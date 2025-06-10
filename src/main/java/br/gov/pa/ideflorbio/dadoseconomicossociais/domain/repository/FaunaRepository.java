package br.gov.pa.ideflorbio.dadoseconomicossociais.domain.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import br.gov.pa.ideflorbio.dadoseconomicossociais.domain.model.Fauna;

@Repository
public interface FaunaRepository extends JpaRepository<Fauna, Long>{
	
	@Query(value="SELECT * FROM FAUNA WHERE ENTREVISTADO = ?1", nativeQuery = true)
	List<Fauna>findByEntrevistado(Long entrevistado);

}
