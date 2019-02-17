package br.com.beblue.ecommerce.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.beblue.ecommerce.domain.entity.Disco;
import io.swagger.annotations.Api;

@RestController
@RequestMapping("/v1/venda")
@Api(value = "Serviço de vendas", tags = { "Vendas" })
public class VendasController {

	@GetMapping
	public List<Disco>buscaDiscos(){
		return null;	
	}
}

