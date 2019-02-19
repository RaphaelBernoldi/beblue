package br.com.beblue.ecommerce.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.beblue.ecommerce.domain.entity.Disco;
import br.com.beblue.ecommerce.domain.enumeration.EnumGenero;

@Repository
public interface DiscoRepository extends JpaRepository<Disco, Long>{

	Optional<List<Disco>>findByGenero(EnumGenero genero);
}
