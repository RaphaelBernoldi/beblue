package br.com.beblue.ecommerce.repository;

import java.util.Calendar;
import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.beblue.ecommerce.domain.entity.Venda;

@Repository
public interface VendaRepository extends JpaRepository<Venda, Long> {
	
	Optional<Page<List<Venda>>>findByDataVendaBetweenOrderByDataVenda(Calendar dataInicio, Calendar dataFinal, Pageable pageable);

}
