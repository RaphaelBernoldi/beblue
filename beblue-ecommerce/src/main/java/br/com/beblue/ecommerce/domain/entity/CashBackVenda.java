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
@Table(name = "CASH_BACK_VENDA")
@SequenceGenerator(allocationSize = 1, name = "seqCashBackVenda" , sequenceName = "SEQ_CASH_BACK_VENDA")
public class CashBackVenda implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "ID_CASHBACK_VENDA")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="seqCashBackVenda")
	private Long idCashBackVenda;
	
	@ManyToOne
	@JoinColumn(name = "ID_VENDA")
	private Venda venda;
	
	@Column(name = "VALOR")
	private Double valor;

	public Long getIdCashBackVenda() {
		return idCashBackVenda;
	}

	public void setIdCashBackVenda(Long idCashBackVenda) {
		this.idCashBackVenda = idCashBackVenda;
	}

	public Venda getVenda() {
		return venda;
	}

	public void setVenda(Venda venda) {
		this.venda = venda;
	}

	public Double getValor() {
		return valor;
	}

	public void setValor(Double valor) {
		this.valor = valor;
	}

}
