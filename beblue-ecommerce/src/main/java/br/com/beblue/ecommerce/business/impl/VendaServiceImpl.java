package br.com.beblue.ecommerce.business.impl;

import java.math.BigDecimal;
import java.time.DayOfWeek;
import java.util.Calendar;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import br.com.beblue.ecommerce.business.CashBackConfigurationService;
import br.com.beblue.ecommerce.business.CashBackDiscoService;
import br.com.beblue.ecommerce.business.CashBackVendaService;
import br.com.beblue.ecommerce.business.ClienteService;
import br.com.beblue.ecommerce.business.VendaService;
import br.com.beblue.ecommerce.domain.entity.CashBackConfiguration;
import br.com.beblue.ecommerce.domain.entity.CashBackDisco;
import br.com.beblue.ecommerce.domain.entity.CashBackVenda;
import br.com.beblue.ecommerce.domain.entity.Cliente;
import br.com.beblue.ecommerce.domain.entity.Disco;
import br.com.beblue.ecommerce.domain.entity.Venda;
import br.com.beblue.ecommerce.exception.BeblueErroException;
import br.com.beblue.ecommerce.repository.VendaRepository;

@Service
public class VendaServiceImpl extends AbstractService implements VendaService {

	@Autowired
	private VendaRepository vendaRepository;
	
	@Autowired
	private CashBackConfigurationService cashBackConfigurationService;
	
	@Autowired
	private ClienteService clienteService;
	
	@Autowired
	private CashBackVendaService cashBackVendaService;
	
	@Autowired
	private CashBackDiscoService cashBackDiscoService;
	
	
	@Override
	public Page<List<Venda>> buscaVendas(Integer diaInicio
									  ,  Integer mesInicio
									  ,  Integer anoInicio
									  ,  Integer diaFinal
									  ,  Integer mesFinal
									  ,  Integer anoFinal) throws BeblueErroException{
		
		Calendar dataInicio = Calendar.getInstance();
		Calendar dataFinal = Calendar.getInstance();
		
		dataInicio.set(anoInicio, mesInicio, diaInicio);
		dataFinal.set(anoFinal, mesFinal, diaFinal);
		
		return getResultado(vendaRepository
								.findByDataVendaBetweenOrderByDataVenda(dataInicio
																	  , dataFinal
																	  , PageRequest.of(1, 10)))
				.getBody();
	}

	@Override
	public ResponseEntity<Venda> geraVenda(Venda venda) throws BeblueErroException {
		
		Cliente clienteSalvo = clienteService.salva(venda.getCliente());
		venda.setCliente(clienteSalvo);
		venda.setDataVenda(Calendar.getInstance());
		CashBackVenda cashBackVenda = new CashBackVenda();
		CashBackDisco cashBackDisco = new CashBackDisco();
		
		for(Disco disco: venda.getDiscos()) {
			
			CashBackConfiguration cashBackConfiguration = cashBackConfigurationService.buscaPorGeneroEDiaSemana(disco.getGenero(), DayOfWeek.of(venda.getDataVenda().get(Calendar.DAY_OF_WEEK)));
			
			venda.setValor(venda.getValor().add(disco.getValorDisco()));
			cashBackVenda.setValor(cashBackVenda.getValor().add(calculaCashBack(disco.getValorDisco(), cashBackConfiguration.getValor())));
			
			cashBackDisco.setValor(cashBackDisco.getValor().add(calculaCashBack(disco.getValorDisco(), cashBackConfiguration.getValor())));
			cashBackDisco.setDisco(disco);
			cashBackDiscoService.salva(cashBackDisco);
			
			
		}
		venda = vendaRepository.save(venda);
		cashBackVenda.setVenda(venda);
		cashBackVendaService.salva(cashBackVenda);
		return new ResponseEntity<Venda>(venda, HttpStatus.CREATED);
	}
	
	@Override
	public ResponseEntity<Venda> buscaPorId(Long idVenda) throws BeblueErroException {
		return getResultado(vendaRepository.findById(idVenda));
	}
	
	private BigDecimal calculaCashBack(BigDecimal valorDisco, BigDecimal percentualCashBack) {
		return valorDisco.multiply(percentualCashBack.divide(new BigDecimal(100l)));
	}

}
