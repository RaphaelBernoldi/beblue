package br.com.beblue.ecommerce.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@PropertySource(value = { "classpath:endpoint.properties" })
public class EndPoint {

	@Value("${endpoint.api.spotify.token}")
	private String apiSpotifyToken;
	
	@Value("${endpoint.api.spotify.query}")
	private String apiSpotifyQuery;


	public String getApiSpotifyToken() {
		return apiSpotifyToken;
	}


	public void setApiSpotifyToken(String apiSpotifyToken) {
		this.apiSpotifyToken = apiSpotifyToken;
	}


	public String getApiSpotifyQuery() {
		return apiSpotifyQuery;
	}


	public void setApiSpotifyQuery(String apiSpotifyQuery) {
		this.apiSpotifyQuery = apiSpotifyQuery;
	}


	
	
}
