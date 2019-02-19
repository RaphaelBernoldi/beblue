package br.com.beblue.ecommerce.business.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.beblue.ecommerce.business.CashBackDiscoService;
import br.com.beblue.ecommerce.domain.entity.CashBackDisco;
import br.com.beblue.ecommerce.exception.BeblueErroException;
import br.com.beblue.ecommerce.repository.CashBackDiscoRepository;

@Service
public class CashBackDiscoServiceImpl extends AbstractService implements CashBackDiscoService {

	
	@Autowired
	private CashBackDiscoRepository cashBackDiscoRepository;

	@Override
	public CashBackDisco salva(CashBackDisco cashBackDisco) throws BeblueErroException {
		try {
			return cashBackDiscoRepository.save(cashBackDisco);
			
		}catch (Exception e) {
			throw new BeblueErroException("Falha ao salvar cashback do disco" + e.getMessage());
		}
	}

}
