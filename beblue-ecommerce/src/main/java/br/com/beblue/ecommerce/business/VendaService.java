package br.com.beblue.ecommerce.business;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;

import br.com.beblue.ecommerce.domain.entity.Venda;
import br.com.beblue.ecommerce.exception.BeblueErroException;

public interface VendaService {

	Page<List<Venda>> buscaVendas( Integer diaInicio
								,  Integer mesInicio
								,  Integer anoInicio
								,  Integer diaFinal
								,  Integer mesFinal
								,  Integer anoFinal) throws BeblueErroException;

	ResponseEntity<Venda> geraVenda(Venda venda) throws BeblueErroException;

	ResponseEntity<Venda> buscaPorId(Long idVenda) throws BeblueErroException;;
}
