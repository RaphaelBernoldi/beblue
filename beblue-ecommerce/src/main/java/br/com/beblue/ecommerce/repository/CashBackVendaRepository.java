package br.com.beblue.ecommerce.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.beblue.ecommerce.domain.entity.CashBackVenda;

@Repository
public interface CashBackVendaRepository extends JpaRepository<CashBackVenda, Long> {

}
