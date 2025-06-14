package br.gov.pa.ideflorbio.dadoseconomicossociais.domain.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import br.gov.pa.ideflorbio.dadoseconomicossociais.domain.model.PescaArtesanal;

@Repository
public interface PescaArtesanalRepository extends JpaRepository<PescaArtesanal, Long>{
	
	@Query(value= "SELECT * FROM PESCA_ARTESANAL WHERE BENFEITORIA = ?1", nativeQuery=true)
	List<PescaArtesanal> findByBenfeitoriaId(Long benfeiroriaId);

}
