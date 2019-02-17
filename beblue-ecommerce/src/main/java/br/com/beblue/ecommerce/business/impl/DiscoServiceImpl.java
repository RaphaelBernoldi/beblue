package br.com.beblue.ecommerce.business.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import br.com.beblue.ecommerce.business.DiscoService;
import br.com.beblue.ecommerce.domain.entity.Disco;
import br.com.beblue.ecommerce.domain.enumeration.EnumGenero;
import br.com.beblue.ecommerce.repository.DiscoRepository;

@Service
public class DiscoServiceImpl implements DiscoService {

	@Autowired
	private DiscoRepository discoRepository;
	
	@Override
	public Disco buscaPorId(Long idDisco) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Disco> buscaDiscos(EnumGenero genero, Pageable pageble) {
		// TODO Auto-generated method stub
		return null;
	}

}
