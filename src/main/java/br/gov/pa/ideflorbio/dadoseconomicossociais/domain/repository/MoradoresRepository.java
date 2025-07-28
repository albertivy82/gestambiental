package br.gov.pa.ideflorbio.dadoseconomicossociais.domain.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import br.gov.pa.ideflorbio.dadoseconomicossociais.domain.model.Morador;

@Repository
public interface MoradoresRepository extends JpaRepository<Morador, Long>{
	
	@Query(value= "SELECT * FROM morador WHERE benfeitoria = ?1", nativeQuery=true)
	List<Morador> findByBenfeitoriaId(Long benfeiroriaId);

}
