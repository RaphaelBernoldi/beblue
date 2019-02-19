package br.com.beblue.ecommerce.domain.entity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Calendar;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonFormat;

import io.swagger.annotations.ApiModelProperty;

@Entity
@Table(name = "VENDA")
@SequenceGenerator(allocationSize = 1, name = "seqVenda" , sequenceName = "SEQ_VENDA")
public class Venda implements Serializable {

	private static final long serialVersionUID = 1L;

	@ApiModelProperty(hidden=true)
	@Id
	@Column(name = "ID_VENDA")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="seqVenda")
	private Long idVenda;
	
	@JsonFormat(pattern = "dd/MM/yyyy HH:mm:ss")
	@ApiModelProperty(hidden=true)
	@Temporal(TemporalType.DATE)
	@Column(name = "DATA_VENDA")
	private Calendar dataVenda;
	
	@ManyToMany
	private List<Disco>discos;
	
	@ManyToOne
	@JoinColumn(name = "ID_CLIENTE")
	private Cliente cliente;
	
	@ApiModelProperty(hidden=true)
	@Column(name = "valor_venda")
	private BigDecimal valor;
	
	public Long getIdVenda() {
		return idVenda;
	}
	public void setIdVenda(Long idVenda) {
		this.idVenda = idVenda;
	}
	public Calendar getDataVenda() {
		return dataVenda;
	}
	public void setDataVenda(Calendar dataVenda) {
		this.dataVenda = dataVenda;
	}
	public List<Disco> getDiscos() {
		return discos;
	}
	public void setDiscos(List<Disco> discos) {
		this.discos = discos;
	}
	public Cliente getCliente() {
		return cliente;
	}
	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
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
