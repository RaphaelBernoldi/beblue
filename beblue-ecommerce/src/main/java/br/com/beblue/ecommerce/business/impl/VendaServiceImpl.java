package br.com.beblue.ecommerce.business.impl;

import java.util.Calendar;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import br.com.beblue.ecommerce.business.VendaService;
import br.com.beblue.ecommerce.domain.entity.Venda;
import br.com.beblue.ecommerce.repository.VendaRepository;

@Service
public class VendaServiceImpl implements VendaService {

	@Autowired
	private VendaRepository vendaRepository;
	
	@Override
	public List<Venda> buscaVendas(Calendar dataInicio, Calendar dataFinal, Pageable pageable) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Venda geraVenda(Venda venda) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Venda buscaPorId(Long idVenda) {
		// TODO Auto-generated method stub
		return null;
	}

}
