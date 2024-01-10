package br.gov.pa.ideflorbio.dadoseconomicossociais.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import br.gov.pa.ideflorbio.dadoseconomicossociais.domain.model.Alimentacao;

@Repository
public interface DadosDeConsumoRepository2 extends JpaRepository<Alimentacao, Long>{

}
