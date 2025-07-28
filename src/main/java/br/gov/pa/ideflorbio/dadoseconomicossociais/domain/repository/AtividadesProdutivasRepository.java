package br.gov.pa.ideflorbio.dadoseconomicossociais.domain.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import br.gov.pa.ideflorbio.dadoseconomicossociais.domain.model.AtividadeProdutiva;

@Repository
public interface AtividadesProdutivasRepository extends JpaRepository<AtividadeProdutiva, Long>{
	
	@Query(value= "SELECT * FROM atividade_produtiva WHERE benfeitoria = ?1", nativeQuery=true)
	List<AtividadeProdutiva> findByBenfeitoriaId(Long benfeiroriaId);

}
