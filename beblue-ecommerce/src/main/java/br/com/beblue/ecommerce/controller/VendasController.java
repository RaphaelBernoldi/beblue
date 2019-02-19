package br.com.beblue.ecommerce.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.beblue.ecommerce.business.VendaService;
import br.com.beblue.ecommerce.domain.entity.Venda;
import br.com.beblue.ecommerce.exception.BeblueErroException;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/v1/venda")
@Api(value = "Serviço de vendas", tags = { "Vendas" })
public class VendasController {
	
	@Autowired
	private VendaService vendaService;

	@ApiOperation(httpMethod = "GET"
			, value = "Busca vendas por intervalo de datas")
	@GetMapping("/data-inicio/{diaInicio}/{mesInicio}/{anoInicio}/data-final/{diaFinal}/{mesFinal}/{anoFinal}")
	public Page<List<Venda>>buscaVendas(@PathVariable Integer diaInicio
												, @PathVariable Integer mesInicio
												, @PathVariable Integer anoInicio
												, @PathVariable Integer diaFinal
												, @PathVariable Integer mesFinal
												, @PathVariable Integer anoFinal) throws BeblueErroException{
		return vendaService.buscaVendas(diaInicio, mesInicio, anoInicio, diaFinal, mesFinal, anoFinal);
	}
	
	@ApiOperation(httpMethod = "GET"
			, value = "Busca venda pelo id da venda")
	@GetMapping("/{idVenda}")
	public ResponseEntity<Venda>buscaVenda(@PathVariable Long idVenda) throws BeblueErroException{
		return vendaService.buscaPorId(idVenda);
	}
	
	@ApiOperation(httpMethod = "POST"
			, value = "Gera venda")
	@PostMapping
	private ResponseEntity<Venda>salva(@Valid @RequestBody Venda venda) throws BeblueErroException{
		return vendaService.geraVenda(venda);
		
	}
	
}

