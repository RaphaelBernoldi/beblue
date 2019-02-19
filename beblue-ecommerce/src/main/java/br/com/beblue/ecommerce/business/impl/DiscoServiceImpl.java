package br.com.beblue.ecommerce.business.impl;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import br.com.beblue.ecommerce.business.DiscoService;
import br.com.beblue.ecommerce.domain.dto.spotify.AlbumsDTO;
import br.com.beblue.ecommerce.domain.entity.Disco;
import br.com.beblue.ecommerce.domain.enumeration.EnumGenero;
import br.com.beblue.ecommerce.exception.BeblueErroException;
import br.com.beblue.ecommerce.repository.DiscoRepository;

@Service
public class DiscoServiceImpl extends AbstractService implements DiscoService {

	private static final Logger LOGGER = LoggerFactory.getLogger(DiscoServiceImpl.class);
	
	@Autowired
	private DiscoRepository discoRepository;
	

	
	@Override
	public ResponseEntity<Disco> buscaPorId(Long idDisco) throws BeblueErroException {
		try {
			LOGGER.info("[BUSCA][DISCO][ID_DISCO]["+ idDisco +"]");
			return getResultado(discoRepository.findById(idDisco));
		}catch (Exception e) {
			LOGGER.error("[ERRO][DISCO][ID_DISCO]["+ idDisco +"][message][" + e.getMessage() + "]");
			throw new BeblueErroException("Falha ao buscar disco por id: " + e.getMessage());
		}
	}

	@Override
	public ResponseEntity<List<Disco>> buscaDiscos(EnumGenero genero) throws BeblueErroException {
		try {
			LOGGER.info("[BUSCA][DISCO][GENERO][" + genero + "]");
			return getResultado(discoRepository.findByGenero(genero));
		}catch (Exception e) {
			LOGGER.error("[ERRO][DISCOS][GENERO]["+ genero +"][message][" + e.getMessage() + "]");
			throw new BeblueErroException("Falha ao buscar discos por gênero: " + e.getMessage());
		}
	}
	
	@Override
	public ResponseEntity<List<Disco>>salvaDiscos(AlbumsDTO albumsDTO, EnumGenero genero){
			LOGGER.info("[SALVANDO][DISCOS]");
			List<Disco>discos = new ArrayList<>();
			albumsDTO
				.getItems()
				.forEach(albumSpotify -> {
					Disco disco = new Disco();
					disco.setGenero(genero);
					disco.setNomeAlbum(albumSpotify.getName());
					disco.setNomeArtista(albumSpotify.getArtists().get(0).getName());
					disco.setTotalMusicas(albumSpotify.getTotalTracks());
					disco.setValorDisco(new BigDecimal(Calendar.getInstance().get(Calendar.MINUTE)));
					discos.add(disco);
				
			});
			return new ResponseEntity<List<Disco>>(discoRepository.saveAll(discos), HttpStatus.OK);
	}

}
