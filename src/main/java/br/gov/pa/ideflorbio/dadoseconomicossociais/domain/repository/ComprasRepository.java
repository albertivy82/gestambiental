package br.gov.pa.ideflorbio.dadoseconomicossociais.domain.repository;


import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import br.gov.pa.ideflorbio.dadoseconomicossociais.domain.model.Compras;

@Repository
public interface ComprasRepository extends JpaRepository<Compras, Long>{
	
	@Query(value="SELECT * FROM COMPRAS WHERE BENFEITORIA = ?1", nativeQuery = true)
	Optional<Compras> compasDaBenfeitoria(Long id);

}
