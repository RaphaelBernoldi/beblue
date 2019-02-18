package br.com.beblue.ecommerce.business.impl;

import java.nio.charset.Charset;

import org.apache.commons.codec.binary.Base64;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

import br.com.beblue.ecommerce.business.SpotifyService;
import br.com.beblue.ecommerce.config.CredenciaisSpotify;
import br.com.beblue.ecommerce.config.EndPoint;
import br.com.beblue.ecommerce.domain.dto.spotify.ResponseAlbumDTO;
import br.com.beblue.ecommerce.domain.dto.spotify.TokenDTO;
import br.com.beblue.ecommerce.domain.enumeration.EnumGenero;
import br.com.beblue.ecommerce.domain.enumeration.EnumTypeSpotify;

@Service
public class SpotifyServiceImpl implements SpotifyService {

	@Autowired
	private EndPoint endPoint;
	
	@Autowired
	private CredenciaisSpotify credenciais;
	
	@Autowired
	private RestTemplate restTemplate;
	
	
	@Override
	public TokenDTO geraToken() {
		try {
		    HttpEntity<MultiValueMap<String, String>> request = new HttpEntity<>(getBodyToken(), getHeaderAuthentication());
		    
		    return restTemplate
		    			.exchange(endPoint.getApiSpotifyToken(), HttpMethod.POST, request, TokenDTO.class)
		    			.getBody();
			}catch (HttpClientErrorException e) {
				e.printStackTrace();
				System.out.println(e.getMessage());
				return null;
			}
	}

	@Override
	public ResponseAlbumDTO buscaAlbums(EnumGenero genero, TokenDTO token) {
		
		HttpEntity<?> request = new HttpEntity<>(null, getHeader(token));
		return restTemplate
    			.exchange(endPoint.getApiSpotifyQuery() + montaQuerySpotfy(1, 50, EnumTypeSpotify.ALBUM, genero.name())
    				    , HttpMethod.GET
    				    , request
    				    , ResponseAlbumDTO.class)
    			.getBody();
	}
	
	/**
	 * Método destinado a montar os parametros de um serviço genérico disponibilizado pelo spotify, onde, </br>
	 * passamos offser/limit o tipo de consulta que quer fazer (EnumType) e o valor que quer pesquisar.
	 * @param offset
	 * @param limit
	 * @param type
	 * @param value
	 * @return
	 */
	private String montaQuerySpotfy(Integer offset, Integer limit, EnumTypeSpotify type, String value) {
		StringBuilder q = new StringBuilder("?");
		return q
				.append("offset=").append(offset.toString())
				.append("&limit=").append(limit.toString())
				.append("&q=").append(value)
				.append("&type=").append(type.getNomeReal())
				.toString();
	}
	
	/**
	 * Método destinado a geração do header que será enviado aos endPoints que serão utilizados
	 * @return HttpHeaders
	 */
	private HttpHeaders getHeader(TokenDTO token) {
		   String bearer = "Bearer " + token.getAccessToken();
		   HttpHeaders headers = new HttpHeaders();
		   headers.add("Authorization", bearer);
		   return headers;
	}
	
	
	
	/**
	 * Método destinado a geração do corpo que será enviado para gerar o token
	 * @return MultiValueMap<String, String>
	 */
	private MultiValueMap<String, String>  getBodyToken() {
		MultiValueMap<String, String> body = new LinkedMultiValueMap<String, String>();
		body.add("grant_type", credenciais.getGrantType());
		body.add("client_id", credenciais.getClientId());
		body.add("client_secret", credenciais.getClientSecret());
		return body;
	}
	
	
	/**
	 * Método destinado a geração do header que será enviado à api, com o padrão Basic
	 * @return HttpHeaders
	 */
	private HttpHeaders getHeaderAuthentication() {
		  String auth = credenciais.getClientId() + ":" + credenciais.getClientSecret();
		   byte[] encodedAuth = Base64.encodeBase64(auth.getBytes());
		   String basicAuth = "Basic " + new String(encodedAuth, Charset.forName("UTF-8"));
		   HttpHeaders headers = new HttpHeaders();
		   headers.add("Authorization", basicAuth);
		   headers.setContentType(MediaType.APPLICATION_FORM_URLENCODED);
		   return headers;
	}

}
