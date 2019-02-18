package br.com.beblue.ecommerce.domain.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import br.com.beblue.ecommerce.domain.enumeration.EnumGenero;


@Entity
@Table(name = "DISCO")
@SequenceGenerator(allocationSize = 1, name = "seqDisco" , sequenceName = "SEQ_DISCO")
public class Disco implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "ID_DISCO")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="seqDisco")
	private Long idDisco;
	
	@Column(name = "NOME_ARTISTA")
	private String nomeArtista;
	
	@Column(name = "NOME_ALBUM")
	private String nomeAlbum;
	
	@Column(name = "GENERO")
	@Enumerated(EnumType.STRING)
	private EnumGenero genero;
	
	@Column(name = "TOTAL_MUSICAS")
	private Integer totalMusicas;
	
	public Long getIdDisco() {
		return idDisco;
	}

	public void setIdDisco(Long idDisco) {
		this.idDisco = idDisco;
	}

	public String getNomeArtista() {
		return nomeArtista;
	}

	public void setNomeArtista(String nomeArtista) {
		this.nomeArtista = nomeArtista;
	}

	public String getNomeAlbum() {
		return nomeAlbum;
	}

	public void setNomeAlbum(String nomeAlbum) {
		this.nomeAlbum = nomeAlbum;
	}

	public EnumGenero getGenero() {
		return genero;
	}

	public void setGenero(EnumGenero genero) {
		this.genero = genero;
	}

	public Integer getTotalMusicas() {
		return totalMusicas;
	}

	public void setTotalMusicas(Integer totalMusicas) {
		this.totalMusicas = totalMusicas;
	}
}
