package br.gov.pa.ideflorbio.dadoseconomicossociais.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.gov.pa.ideflorbio.dadoseconomicossociais.domain.model.DestinoPesca;

@Repository
public interface DestinoPescaRepository extends JpaRepository<DestinoPesca, Long>{

}
