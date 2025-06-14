package br.gov.pa.ideflorbio.dadoseconomicossociais.domain.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import br.gov.pa.ideflorbio.dadoseconomicossociais.domain.model.Credito;

@Repository
public interface CreditosRepository extends JpaRepository<Credito, Long>{
	
	@Query(value= "SELECT * FROM CREDITO WHERE BENFEITORIA = ?1", nativeQuery=true)
	List<Credito> findByBenfeitoriaId(Long benfeiroriaId);

}
