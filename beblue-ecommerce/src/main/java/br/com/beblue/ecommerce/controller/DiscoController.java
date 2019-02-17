package br.com.beblue.ecommerce.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.beblue.ecommerce.domain.entity.Disco;
import io.swagger.annotations.Api;

@RestController
@RequestMapping("/v1/disco")
@Api(value = "Serviço de discos", tags = { "Catalogo de discos" })
public class DiscoController {

	@GetMapping
	public List<Disco>buscaDiscos(){
		return null;	
	}
}
