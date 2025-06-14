package br.gov.pa.ideflorbio.dadoseconomicossociais.domain.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import br.gov.pa.ideflorbio.dadoseconomicossociais.domain.model.RendaOutrasFontes;

@Repository
public interface RendasOutrasFontesRepository extends JpaRepository<RendaOutrasFontes, Long>{
	
	@Query(value= "SELECT * FROM RENDA_OUTRAS_FONTES WHERE BENFEITORIA = ?1", nativeQuery=true)
	List<RendaOutrasFontes> findByBenfeitoriaId(Long benfeiroriaId);

}
