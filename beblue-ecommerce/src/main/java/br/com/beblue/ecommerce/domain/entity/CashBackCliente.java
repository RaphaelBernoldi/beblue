package br.com.beblue.ecommerce.domain.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "CASH_BACK_CLIENTE")
@SequenceGenerator(allocationSize = 1, name = "seqCashBackCliente" , sequenceName = "SEQ_CASH_BACK_CLIENTE")
public class CashBackCliente implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "ID_CASHBACK_CLIENTE")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="seqCashBackCliente")
	private Long idCashBackCliente;
	
	@ManyToOne
	@JoinColumn(name = "ID_CLIENTE")
	private Cliente cliente;
	
	@Column(name = "VALOR")
	private Double valor;

	public Long getIdCashBackCliente() {
		return idCashBackCliente;
	}

	public void setIdCashBackCliente(Long idCashBackCliente) {
		this.idCashBackCliente = idCashBackCliente;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public Double getValor() {
		return valor;
	}

	public void setValor(Double valor) {
		this.valor = valor;
	}
	
	
	
}
