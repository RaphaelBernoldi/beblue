package br.com.beblue.ecommerce.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.beblue.ecommerce.business.DiscoService;
import br.com.beblue.ecommerce.domain.entity.Disco;
import br.com.beblue.ecommerce.domain.enumeration.EnumGenero;
import br.com.beblue.ecommerce.exception.BeblueErroException;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/v1/disco")
@Api(value = "Serviço de discos", tags = { "Catalogo de discos" })
public class DiscoController {

	@Autowired
	private DiscoService discoService;
	
	@ApiOperation(httpMethod = "GET"
				, value = "Busca disco pelo id")
	@GetMapping("/{idDisco}")
	public ResponseEntity<Disco> buscaDisco(@PathVariable Long idDisco) throws BeblueErroException {
		return discoService.buscaPorId(idDisco);
	}
	
	@ApiOperation(httpMethod = "GET"
				, value = "Busca discos por genero musical")
	@GetMapping("/genero/{genero}")
	public ResponseEntity<List<Disco>>buscaPorGenero(@PathVariable EnumGenero genero) throws BeblueErroException{
		return discoService.buscaDiscos(genero);
	}
}
