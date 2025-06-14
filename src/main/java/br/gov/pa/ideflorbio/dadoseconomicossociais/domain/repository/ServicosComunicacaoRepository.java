package br.gov.pa.ideflorbio.dadoseconomicossociais.domain.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import br.gov.pa.ideflorbio.dadoseconomicossociais.domain.model.ServicosComunicacao;

@Repository
public interface ServicosComunicacaoRepository extends JpaRepository<ServicosComunicacao, Long>{
	
	@Query(value= "SELECT * FROM SERVICOS_COMUNICACAO WHERE BENFEITORIA = ?1", nativeQuery=true)
	List<ServicosComunicacao> findByBenfeitoriaId(Long benfeiroriaId);

}
