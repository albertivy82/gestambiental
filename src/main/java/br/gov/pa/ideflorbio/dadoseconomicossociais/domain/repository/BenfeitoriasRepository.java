package br.gov.pa.ideflorbio.dadoseconomicossociais.domain.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import br.gov.pa.ideflorbio.dadoseconomicossociais.domain.model.Benfeitoria;

@Repository
public interface BenfeitoriasRepository extends JpaRepository<Benfeitoria, Long>{
	
	@Query(value= "SELECT * FROM benfeitoria WHERE imovel = ?1", nativeQuery=true)
	List<Benfeitoria> findByImovelId(Long imovelId);
	
	

}
