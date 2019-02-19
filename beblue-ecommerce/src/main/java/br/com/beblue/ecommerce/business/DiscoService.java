package br.com.beblue.ecommerce.business;

import java.util.List;

import org.springframework.http.ResponseEntity;

import br.com.beblue.ecommerce.domain.dto.spotify.AlbumsDTO;
import br.com.beblue.ecommerce.domain.entity.Disco;
import br.com.beblue.ecommerce.domain.enumeration.EnumGenero;
import br.com.beblue.ecommerce.exception.BeblueErroException;

public interface DiscoService {

	ResponseEntity<Disco> buscaPorId(Long idDisco) throws BeblueErroException;
	ResponseEntity<List<Disco>> buscaDiscos(EnumGenero genero) throws BeblueErroException;
	ResponseEntity<List<Disco>> salvaDiscos(AlbumsDTO albumsDTO, EnumGenero genero);
}
