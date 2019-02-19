package br.com.beblue.ecommerce.business;

import java.time.DayOfWeek;
import java.util.List;

import br.com.beblue.ecommerce.domain.entity.CashBackConfiguration;
import br.com.beblue.ecommerce.domain.enumeration.EnumGenero;
import br.com.beblue.ecommerce.exception.BeblueErroException;

public interface CashBackConfigurationService {

	CashBackConfiguration buscaPorGeneroEDiaSemana(EnumGenero genero, DayOfWeek diaSemana)throws BeblueErroException;
	List<CashBackConfiguration> criaConfiguracoes();
	
}
