package br.gov.pa.ideflorbio.dadoseconomicossociais.domain.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import br.gov.pa.ideflorbio.dadoseconomicossociais.domain.model.Entrevistado;


@Repository
public interface EntrevistadosRepository extends JpaRepository<Entrevistado, Long>{
	
	
	@Query(value= "SELECT * FROM entrevistado WHERE localidade = ?1", nativeQuery=true)
	List<Entrevistado> findByLocalidadeId (Long localidadeId);
	
	@Query(value = "SELECT * FROM entrevistado WHERE entrevistado.nome LIKE :nome", nativeQuery = true)
	Optional<Entrevistado> findByNome(String nome);
		
	

}
