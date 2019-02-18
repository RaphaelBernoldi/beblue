package br.com.beblue.ecommerce.business;

import br.com.beblue.ecommerce.domain.dto.spotify.ResponseAlbumDTO;
import br.com.beblue.ecommerce.domain.dto.spotify.TokenDTO;
import br.com.beblue.ecommerce.domain.enumeration.EnumGenero;

public interface SpotifyService {

	TokenDTO geraToken();
	ResponseAlbumDTO buscaAlbums(EnumGenero genero, TokenDTO token);
	
	
}