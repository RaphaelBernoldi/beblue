package br.com.beblue.ecommerce.business.impl;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.beblue.ecommerce.business.DiscoService;
import br.com.beblue.ecommerce.domain.entity.Disco;
import br.com.beblue.ecommerce.domain.enumeration.EnumGenero;
import br.com.beblue.ecommerce.repository.DiscoRepository;

@Service
public class DiscoServiceImpl implements DiscoService {

	private static final Logger LOGGER = LoggerFactory.getLogger(DiscoServiceImpl.class);
	
	@Autowired
	private DiscoRepository discoRepository;
	
	@Override
	public Disco buscaPorId(Long idDisco) {
		LOGGER.info("[BUSCA][DISCO][ID_DISCO][{}]", idDisco);
		return null;
	}

	@Override
	public List<Disco> buscaDiscos(EnumGenero genero) {
		LOGGER.info("[BUSCA][DISCO][GENERO][{}]", genero);
		return null;
	}

}
