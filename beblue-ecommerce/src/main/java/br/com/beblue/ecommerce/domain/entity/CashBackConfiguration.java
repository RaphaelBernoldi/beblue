package br.com.beblue.ecommerce.domain.entity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.DayOfWeek;

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
@Table(name = "CASH_BACK_CONFIGURATION")
@SequenceGenerator(allocationSize = 1, name = "seqCashBackConfiguration" , sequenceName = "SEQ_CASH_BACK_CONFIGURATION")
public class CashBackConfiguration implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "ID_CASHBACK")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="seqCashBackConfiguration")
	private Long idCashBack;
	
	@Column(name = "VALOR")
	private BigDecimal valor;
	
	@Column(name = "DIA_SEMANA")
	@Enumerated(EnumType.STRING)
	private DayOfWeek diaSemana;
	
	@Column(name = "GENERO")
	@Enumerated(EnumType.STRING)
	private EnumGenero genero;
	
	
	
	public CashBackConfiguration() {}
	
	public CashBackConfiguration(BigDecimal valor, DayOfWeek diaSemana, EnumGenero genero) {
		this.valor = valor;
		this.diaSemana = diaSemana;
		this.genero = genero;
	}
	
	public Long getIdCashBack() {
		return idCashBack;
	}
	public void setIdCashBack(Long idCashBack) {
		this.idCashBack = idCashBack;
	}
	public BigDecimal getValor() {
		return valor;
	}
	public void setValor(BigDecimal valor) {
		this.valor = valor;
	}
	public DayOfWeek getDiaSemana() {
		return diaSemana;
	}
	public void setDiaSemana(DayOfWeek diaSemana) {
		this.diaSemana = diaSemana;
	}
	public EnumGenero getGenero() {
		return genero;
	}
	public void setGenero(EnumGenero genero) {
		this.genero = genero;
	}
	
	
}
