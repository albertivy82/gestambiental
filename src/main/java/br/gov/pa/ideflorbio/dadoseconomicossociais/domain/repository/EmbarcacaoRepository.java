package br.gov.pa.ideflorbio.dadoseconomicossociais.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.gov.pa.ideflorbio.dadoseconomicossociais.domain.model.Embarcacao;


@Repository
public interface EmbarcacaoRepository extends JpaRepository<Embarcacao, Long> {
	
	
	

}
