package br.com.beblue.ecommerce.business;

import br.com.beblue.ecommerce.domain.entity.CashBackCliente;
import br.com.beblue.ecommerce.domain.entity.Cliente;

public interface CashBackClienteService {

	CashBackCliente buscaCashBackPorCliente(Cliente cliente);
	CashBackCliente salva(Cliente cliente);
}
