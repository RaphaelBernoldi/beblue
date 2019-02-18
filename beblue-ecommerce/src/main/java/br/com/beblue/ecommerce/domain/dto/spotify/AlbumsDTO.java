package br.com.beblue.ecommerce.domain.dto.spotify;

import java.util.List;

public class AlbumsDTO {

	private String href;
	private List<AlbumDTO>items;
	
	public String getHref() {
		return href;
	}
	public void setHref(String href) {
		this.href = href;
	}
	public List<AlbumDTO> getItems() {
		return items;
	}
	public void setItems(List<AlbumDTO> items) {
		this.items = items;
	}
	
	
}
