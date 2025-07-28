package br.gov.pa.ideflorbio.dadoseconomicossociais.domain.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import br.gov.pa.ideflorbio.dadoseconomicossociais.domain.model.ParticipacaoInstituicao;

@Repository
public interface ParticipacaoInstituicaoRepository extends JpaRepository<ParticipacaoInstituicao, Long>{
	
	
	@Query(value="SELECT * FROM participacao_instituicao WHERE morador = ?1", nativeQuery = true)
	List<ParticipacaoInstituicao>findByMorador(Long Morador);

}
