package br.com.beblue.ecommerce.domain.entity;

import java.io.Serializable;
import java.math.BigDecimal;

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
@Table(name = "CASH_BACK_DISCO")
@SequenceGenerator(allocationSize = 1, name = "seqCashBackDisco" , sequenceName = "SEQ_CASH_BACK_DISCO")
public class CashBackDisco implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "ID_CASHBACK_CLIENTE")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="seqCashBackDisco")
	private Long idCashBackCliente;
	
	@ManyToOne
	@JoinColumn(name = "ID_DISCO")
	private Disco disco;
	
	@Column(name = "VALOR")
	private BigDecimal valor;

	public Long getIdCashBackCliente() {
		return idCashBackCliente;
	}

	public void setIdCashBackCliente(Long idCashBackCliente) {
		this.idCashBackCliente = idCashBackCliente;
	}

	public Disco getDisco() {
		return disco;
	}

	public void setDisco(Disco disco) {
		this.disco = disco;
	}

	public BigDecimal getValor() {
		if(valor == null) {
			valor = BigDecimal.ZERO;
		}
		return valor;
	}

	public void setValor(BigDecimal valor) {
		this.valor = valor;
	}
	
	
	
}
