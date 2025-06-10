package br.gov.pa.ideflorbio.dadoseconomicossociais.domain.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import br.gov.pa.ideflorbio.dadoseconomicossociais.domain.model.Aves;


@Repository
public interface AvesRepository extends JpaRepository<Aves, Long>{
	
	@Query(value="SELECT * FROM AVES WHERE ENTREVISTADO = ?1", nativeQuery = true)
	List<Aves>findByEntrevistado(Long entrevistado);

}
