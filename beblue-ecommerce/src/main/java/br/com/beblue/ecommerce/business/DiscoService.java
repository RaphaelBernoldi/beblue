package br.com.beblue.ecommerce.business;

import java.util.List;

import br.com.beblue.ecommerce.domain.entity.Disco;
import br.com.beblue.ecommerce.domain.enumeration.EnumGenero;

public interface DiscoService {

	Disco buscaPorId(Long idDisco);
	List<Disco> buscaDiscos(EnumGenero genero);
}
