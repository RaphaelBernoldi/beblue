package br.com.beblue.ecommerce.business.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.beblue.ecommerce.business.CashBackVendaService;
import br.com.beblue.ecommerce.domain.entity.CashBackVenda;
import br.com.beblue.ecommerce.exception.BeblueErroException;
import br.com.beblue.ecommerce.repository.CashBackVendaRepository;

@Service
public class CashBackVendaServiceImpl extends AbstractService implements CashBackVendaService {

	@Autowired
	private CashBackVendaRepository cashBackVendaRepository;
	
	@Override
	public CashBackVenda salva(CashBackVenda cashBackVenda) throws BeblueErroException {
		try {
			return cashBackVendaRepository.save(cashBackVenda);
		}catch (Exception e) {
			throw new BeblueErroException("Falha ao salvar cashback da venda" + e.getMessage());
		}
	}

}
