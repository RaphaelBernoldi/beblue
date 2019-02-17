package br.com.beblue.ecommerce.business;

import java.time.DayOfWeek;

import br.com.beblue.ecommerce.domain.entity.CashBackConfiguration;
import br.com.beblue.ecommerce.domain.enumeration.EnumGenero;

public interface CashBackConfigurationService {

	CashBackConfiguration buscaPorGeneroEDiaSemana(EnumGenero genero, DayOfWeek diaSemana);
	
}
