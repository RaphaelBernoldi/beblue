package br.com.beblue.ecommerce.config;

import java.util.Arrays;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

import br.com.beblue.ecommerce.business.DiscoService;
import br.com.beblue.ecommerce.business.SpotifyService;
import br.com.beblue.ecommerce.domain.dto.spotify.ResponseAlbumDTO;
import br.com.beblue.ecommerce.domain.enumeration.EnumGenero;

/**
 * 
 * @author raphael
 * Classe destinada a realizar carga da aplicação assim que a mesma estiver de pé
 */
@Component
public class ApplicationStartUp  implements ApplicationListener<ApplicationReadyEvent> {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(ApplicationStartUp.class);
	
	@Autowired
	private SpotifyService spotifyService;
	
	
	@Autowired
	private DiscoService discoService;
	
	@Override
	public void onApplicationEvent(ApplicationReadyEvent arg0) {
		LOGGER.info("[BEBLUE][UP][INICIALIZANDO][CARGA]");
			Arrays
				.asList(EnumGenero.values())
				.forEach(genero -> {
				
				ResponseAlbumDTO albumsSpotify = spotifyService
													.buscaAlbums(genero
														   , spotifyService.geraToken());
				discoService.salvaDiscos(albumsSpotify.getAlbums(), genero);
				LOGGER.info("[DISCOS][SALVOS]");
				
				
			});
	}

}
