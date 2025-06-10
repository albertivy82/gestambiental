package br.gov.pa.ideflorbio.dadoseconomicossociais.domain.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import br.gov.pa.ideflorbio.dadoseconomicossociais.domain.model.Mamiferos;

@Repository
public interface MamiferosRepository extends JpaRepository<Mamiferos, Long>{
	
	@Query(value="SELECT * FROM MAMIFEROS WHERE ENTREVISTADO = ?1", nativeQuery = true)
	List<Mamiferos>findByEntrevistado(Long entrevistado);

}
