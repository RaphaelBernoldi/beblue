package br.com.beblue.ecommerce.business.impl;

import java.math.BigDecimal;
import java.time.DayOfWeek;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.beblue.ecommerce.business.CashBackConfigurationService;
import br.com.beblue.ecommerce.domain.entity.CashBackConfiguration;
import br.com.beblue.ecommerce.domain.enumeration.EnumGenero;
import br.com.beblue.ecommerce.exception.BeblueErroException;
import br.com.beblue.ecommerce.repository.CashBackConfigurationRepository;

@Service
public class CashBackConfigurationServiceImpl extends AbstractService implements CashBackConfigurationService {
	
	@Autowired
	private CashBackConfigurationRepository cashBackConfigurationRepository;

	@Override
	public CashBackConfiguration buscaPorGeneroEDiaSemana(EnumGenero genero, DayOfWeek diaSemana) throws BeblueErroException{
		try {
			
			return cashBackConfigurationRepository.findByDiaSemanaAndGenero(diaSemana, genero);
			
		}catch (Exception e) {
			throw new BeblueErroException(e.getMessage());
		}
	}

	
	/**
	 * Realiza carga de configurações de cashback
	 * @return List<CashBackConfiguration>
	 */
	@Override
	public List<CashBackConfiguration> criaConfiguracoes() {
		List<CashBackConfiguration>configurations = new ArrayList<>();
		
		configurations.add(new CashBackConfiguration(new BigDecimal(25l), DayOfWeek.SUNDAY, EnumGenero.POP));
		configurations.add(new CashBackConfiguration(new BigDecimal(7l), DayOfWeek.MONDAY, EnumGenero.POP));
		configurations.add(new CashBackConfiguration(new BigDecimal(6l), DayOfWeek.TUESDAY, EnumGenero.POP));
		configurations.add(new CashBackConfiguration(new BigDecimal(2l), DayOfWeek.WEDNESDAY, EnumGenero.POP));
		configurations.add(new CashBackConfiguration(new BigDecimal(10l), DayOfWeek.THURSDAY, EnumGenero.POP));
		configurations.add(new CashBackConfiguration(new BigDecimal(15l), DayOfWeek.FRIDAY, EnumGenero.POP));
		configurations.add(new CashBackConfiguration(new BigDecimal(20l), DayOfWeek.SATURDAY, EnumGenero.POP));
		
		configurations.add(new CashBackConfiguration(new BigDecimal(30l), DayOfWeek.SUNDAY, EnumGenero.MPB));
		configurations.add(new CashBackConfiguration(new BigDecimal(5l), DayOfWeek.MONDAY, EnumGenero.MPB));
		configurations.add(new CashBackConfiguration(new BigDecimal(10l), DayOfWeek.TUESDAY, EnumGenero.MPB));
		configurations.add(new CashBackConfiguration(new BigDecimal(15l), DayOfWeek.WEDNESDAY, EnumGenero.MPB));
		configurations.add(new CashBackConfiguration(new BigDecimal(20l), DayOfWeek.THURSDAY, EnumGenero.MPB));
		configurations.add(new CashBackConfiguration(new BigDecimal(25l), DayOfWeek.FRIDAY, EnumGenero.MPB));
		configurations.add(new CashBackConfiguration(new BigDecimal(30l), DayOfWeek.SATURDAY, EnumGenero.MPB));
		
		configurations.add(new CashBackConfiguration(new BigDecimal(35l), DayOfWeek.SUNDAY, EnumGenero.CLASSIC));
		configurations.add(new CashBackConfiguration(new BigDecimal(3l), DayOfWeek.MONDAY, EnumGenero.CLASSIC));
		configurations.add(new CashBackConfiguration(new BigDecimal(5l), DayOfWeek.TUESDAY, EnumGenero.CLASSIC));
		configurations.add(new CashBackConfiguration(new BigDecimal(8l), DayOfWeek.WEDNESDAY, EnumGenero.CLASSIC));
		configurations.add(new CashBackConfiguration(new BigDecimal(13l), DayOfWeek.THURSDAY, EnumGenero.CLASSIC));
		configurations.add(new CashBackConfiguration(new BigDecimal(18l), DayOfWeek.FRIDAY, EnumGenero.CLASSIC));
		configurations.add(new CashBackConfiguration(new BigDecimal(25l), DayOfWeek.SATURDAY, EnumGenero.CLASSIC));
		
		configurations.add(new CashBackConfiguration(new BigDecimal(40l), DayOfWeek.SUNDAY, EnumGenero.ROCK));
		configurations.add(new CashBackConfiguration(new BigDecimal(10l), DayOfWeek.MONDAY, EnumGenero.ROCK));
		configurations.add(new CashBackConfiguration(new BigDecimal(15l), DayOfWeek.TUESDAY, EnumGenero.ROCK));
		configurations.add(new CashBackConfiguration(new BigDecimal(15l), DayOfWeek.WEDNESDAY, EnumGenero.ROCK));
		configurations.add(new CashBackConfiguration(new BigDecimal(15l), DayOfWeek.THURSDAY, EnumGenero.ROCK));
		configurations.add(new CashBackConfiguration(new BigDecimal(20l), DayOfWeek.FRIDAY, EnumGenero.ROCK));
		configurations.add(new CashBackConfiguration(new BigDecimal(40l), DayOfWeek.SATURDAY, EnumGenero.ROCK));
		
		return cashBackConfigurationRepository.saveAll(configurations);
	}
	
}
