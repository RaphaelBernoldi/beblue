package br.com.beblue.ecommerce.domain.enumeration;

/**
 * 
 * @author raphael
 * Enum de types para serem utilizados no serviço dinamico fornecido pelo spotify </br>
 * Visite o link abaixo para maiores informações</br>
 * @see <a href="https://developer.spotify.com/documentation/web-api/reference-beta/#endpoint-search">Referencia spotify</a>
 * 
 */
public enum EnumTypeSpotify {

	  ALBUM
	, ARTIST
	, PLAYLIST
	, TRACK; 
	
	public String getNomeReal() {
	return this.name().toLowerCase() ;	
	}
	
	
}
