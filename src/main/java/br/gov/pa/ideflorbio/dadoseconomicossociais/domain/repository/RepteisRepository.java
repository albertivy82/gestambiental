package br.gov.pa.ideflorbio.dadoseconomicossociais.domain.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import br.gov.pa.ideflorbio.dadoseconomicossociais.domain.model.Repteis;

@Repository
public interface RepteisRepository extends JpaRepository<Repteis, Long>{
	
	@Query(value="SELECT * FROM REPTEIS WHERE ENTREVISTADO = ?1", nativeQuery = true)
	List<Repteis>findByEntrevistado(Long entrevistado);

}
