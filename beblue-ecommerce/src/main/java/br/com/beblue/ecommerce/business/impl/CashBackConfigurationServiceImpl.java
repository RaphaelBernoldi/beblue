package br.com.beblue.ecommerce.business.impl;

import java.time.DayOfWeek;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.beblue.ecommerce.business.CashBackConfigurationService;
import br.com.beblue.ecommerce.domain.entity.CashBackConfiguration;
import br.com.beblue.ecommerce.domain.enumeration.EnumGenero;
import br.com.beblue.ecommerce.repository.CashBackConfigurationRepository;

@Service
public class CashBackConfigurationServiceImpl implements CashBackConfigurationService {
	
	@Autowired
	private CashBackConfigurationRepository cashBackConfigurationRepository;
	
	@Override
	public CashBackConfiguration buscaPorGeneroEDiaSemana(EnumGenero genero, DayOfWeek diaSemana) {
		// TODO Auto-generated method stub
		return null;
	}

}
