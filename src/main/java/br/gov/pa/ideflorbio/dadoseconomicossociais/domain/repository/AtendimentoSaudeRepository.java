package br.gov.pa.ideflorbio.dadoseconomicossociais.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.gov.pa.ideflorbio.dadoseconomicossociais.domain.model.AtendimentoSaude;

@Repository
public interface AtendimentoSaudeRepository extends JpaRepository<AtendimentoSaude, Long>{

}
