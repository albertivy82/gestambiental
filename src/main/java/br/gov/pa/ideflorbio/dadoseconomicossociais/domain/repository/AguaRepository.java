package br.gov.pa.ideflorbio.dadoseconomicossociais.domain.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import br.gov.pa.ideflorbio.dadoseconomicossociais.domain.model.Agua;


@Repository
public interface AguaRepository extends JpaRepository<Agua, Long>{
	
	@Query(value= "SELECT * FROM AGUA WHERE BENFEITORIA = ?1", nativeQuery=true)
	List<Agua> findByBenfeitoriaId(Long benfeiroriaId);
	
		

}
