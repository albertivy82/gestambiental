package br.gov.pa.ideflorbio.dadoseconomicossociais.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.gov.pa.ideflorbio.dadoseconomicossociais.domain.model.OutrosServicos;
import br.gov.pa.ideflorbio.dadoseconomicossociais.domain.model.ServicosBasicos;

@Repository
public interface OutrosServicosRepository extends JpaRepository<OutrosServicos, Long>{

}
