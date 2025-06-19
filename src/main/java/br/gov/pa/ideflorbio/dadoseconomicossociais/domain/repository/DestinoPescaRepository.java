package br.gov.pa.ideflorbio.dadoseconomicossociais.domain.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import br.gov.pa.ideflorbio.dadoseconomicossociais.domain.model.DestinoPesca;

@Repository
public interface DestinoPescaRepository extends JpaRepository<DestinoPesca, Long>{

	@Query(value= "SELECT * FROM DESTINO_PESCA WHERE PESCA_ARTESANAL = ?1", nativeQuery=true)
	List<DestinoPesca> findByPescaArtesanalId(Long pescaArtesanalId);
}
