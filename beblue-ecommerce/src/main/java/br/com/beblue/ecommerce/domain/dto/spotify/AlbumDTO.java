package br.com.beblue.ecommerce.domain.dto.spotify;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

public class AlbumDTO {

	private List<ArtistDTO>artists;
	
	private String href;
	
	private String id;
	
	private String name;
	
	@JsonProperty("release_date")
	private String releaseDate;
	
	@JsonProperty("total_tracks")
	private Integer totalTracks;
	
	private String uri;
	
	public List<ArtistDTO> getArtists() {
		return artists;
	}
	public void setArtists(List<ArtistDTO> artists) {
		this.artists = artists;
	}
	public String getHref() {
		return href;
	}
	public void setHref(String href) {
		this.href = href;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getReleaseDate() {
		return releaseDate;
	}
	public void setReleaseDate(String releaseDate) {
		this.releaseDate = releaseDate;
	}
	public Integer getTotalTracks() {
		return totalTracks;
	}
	public void setTotalTracks(Integer totalTracks) {
		this.totalTracks = totalTracks;
	}
	public String getUri() {
		return uri;
	}
	public void setUri(String uri) {
		this.uri = uri;
	}
	
}
