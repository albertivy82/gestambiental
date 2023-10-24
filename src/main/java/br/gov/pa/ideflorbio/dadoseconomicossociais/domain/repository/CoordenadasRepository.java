package br.gov.pa.ideflorbio.dadoseconomicossociais.domain.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import br.gov.pa.ideflorbio.dadoseconomicossociais.domain.model.Coordenada;


@Repository
public interface CoordenadasRepository extends JpaRepository<Coordenada, Long> {
	
	@Query(value = "SELECT c.id, c.latitude, c.longitude, c.localidade " +
            "FROM coordenada c " +
            "INNER JOIN localidade l ON l.id = c.localidade " +
            "WHERE l.id = ?1", nativeQuery=true)
    List<Coordenada> findByLocalidadeId(Long localidadeId);


}
