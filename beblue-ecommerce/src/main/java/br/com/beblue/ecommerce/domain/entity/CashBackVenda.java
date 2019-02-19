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
	private BigDecimal valor;

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
