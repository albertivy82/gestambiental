package br.gov.pa.ideflorbio.dadoseconomicossociais.domain.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import br.gov.pa.ideflorbio.dadoseconomicossociais.domain.model.Peixes;
import br.gov.pa.ideflorbio.dadoseconomicossociais.domain.model.Vegetacao;


@Repository
public interface PeixesRepository extends JpaRepository<Peixes, Long>{
	
	@Query(value="SELECT * FROM PEIXES WHERE ENTREVISTADO = ?1", nativeQuery = true)
	List<Peixes>findByEntrevistado(Long entrevistado);
	
		

}
