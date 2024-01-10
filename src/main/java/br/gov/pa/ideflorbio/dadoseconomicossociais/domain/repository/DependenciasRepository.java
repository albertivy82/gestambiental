package br.gov.pa.ideflorbio.dadoseconomicossociais.domain.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import br.gov.pa.ideflorbio.dadoseconomicossociais.domain.model.Dependencias;

@Repository
public interface DependenciasRepository extends JpaRepository<Dependencias, Long>{
	
	@Query
	(value = "SELECT * FROM DEPENDENCIAS WHERE BENFEITORIA = ?1", nativeQuery = true)
	List<Dependencias> dependenciasDaDaBenfeitoria(Long id);

}
