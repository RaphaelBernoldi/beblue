package br.com.beblue.ecommerce.business;

import br.com.beblue.ecommerce.domain.entity.CashBack;
import br.com.beblue.ecommerce.domain.entity.Cliente;

public interface CashBackService {

	CashBack buscaCashBackPorCliente(Cliente cliente);
	CashBack salva(Cliente cliente);
}
