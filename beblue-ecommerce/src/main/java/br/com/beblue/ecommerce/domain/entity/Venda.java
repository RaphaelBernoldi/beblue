package br.com.beblue.ecommerce.domain.entity;

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


@Entity
@Table(name = "VENDA")
@SequenceGenerator(allocationSize = 1, name = "seqVenda" , sequenceName = "SEQ_VENDA")
public class Venda {

	@Id
	@Column(name = "ID_VENDA")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="seqVenda")
	private Long idVenda;
	
	@Temporal(TemporalType.DATE)
	@Column(name = "DATA_VENDA")
	private Calendar dataVenda;
	
	@ManyToMany
	private List<Disco>discos;
	
	@ManyToOne
	@JoinColumn(name = "ID_CLIENTE")
	private Cliente cliente;
	
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
	
	
}
