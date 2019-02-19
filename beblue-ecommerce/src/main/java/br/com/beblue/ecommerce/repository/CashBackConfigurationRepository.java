package br.com.beblue.ecommerce.repository;

import java.time.DayOfWeek;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.beblue.ecommerce.domain.entity.CashBackConfiguration;
import br.com.beblue.ecommerce.domain.enumeration.EnumGenero;

@Repository
public interface CashBackConfigurationRepository extends JpaRepository<CashBackConfiguration, Long> {
	
	CashBackConfiguration findByDiaSemanaAndGenero(DayOfWeek diaSemana, EnumGenero genero);

}
