package br.gov.pa.ideflorbio.dadoseconomicossociais.domain.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import br.gov.pa.ideflorbio.dadoseconomicossociais.domain.model.Entrevistado;
import br.gov.pa.ideflorbio.dadoseconomicossociais.domain.model.Imovel;

@Repository
public interface ImoveisRepository extends JpaRepository<Imovel, Long>{
	
	@Query(value= "SELECT * FROM IMOVEL WHERE ENTREVISTADO = ?1", nativeQuery=true)
	Optional<Imovel> findByEntrevistadoId(Long entrevistadoId);
	
	
	

}
