package br.com.beblue.ecommerce.business;

import java.util.Calendar;
import java.util.List;

import org.springframework.data.domain.Pageable;

import br.com.beblue.ecommerce.domain.entity.Venda;

public interface VendaService {

	List<Venda>buscaVendas(Calendar dataInicio, Calendar dataFinal, Pageable pageable);
	Venda geraVenda(Venda venda);
	Venda buscaPorId(Long idVenda);
}
