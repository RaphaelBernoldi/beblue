package br.com.beblue.ecommerce.domain.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "CLIENTE")
@SequenceGenerator(allocationSize = 1, name = "seqCliente" , sequenceName = "SEQ_CLIENTE")
public class Cliente implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "ID_CLIENTE")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="seqCliente")
	private Long idCliente;
	
	@Column(name = "NOME")
	private String nome;
	
	@Column(name = "CPF")
	private String cpf;
	
	public Long getIdCliente() {
		return idCliente;
	}
	public void setIdCliente(Long idCliente) {
		this.idCliente = idCliente;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getCpf() {
		return cpf;
	}
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	
	
	
	
}
