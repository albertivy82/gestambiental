package br.gov.pa.ideflorbio.dadoseconomicossociais.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.gov.pa.ideflorbio.dadoseconomicossociais.domain.model.Credito;
import br.gov.pa.ideflorbio.dadoseconomicossociais.domain.model.Dependencias;

@Repository
public interface DependenciasRepository extends JpaRepository<Dependencias, Long>{

}
