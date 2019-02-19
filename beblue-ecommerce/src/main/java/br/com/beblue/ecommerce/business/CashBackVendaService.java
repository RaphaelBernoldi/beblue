package br.com.beblue.ecommerce.business;

import br.com.beblue.ecommerce.domain.entity.CashBackVenda;
import br.com.beblue.ecommerce.exception.BeblueErroException;

public interface CashBackVendaService {

	CashBackVenda salva(CashBackVenda cashBackVenda) throws BeblueErroException;
}
