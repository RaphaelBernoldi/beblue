package br.com.beblue.ecommerce.business;

import br.com.beblue.ecommerce.domain.entity.CashBackDisco;
import br.com.beblue.ecommerce.exception.BeblueErroException;

public interface CashBackDiscoService {

	CashBackDisco salva(CashBackDisco cashBackDisco) throws BeblueErroException;
}
