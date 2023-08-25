package br.gov.pa.ideflorbio.dadoseconomicossociais.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.gov.pa.ideflorbio.dadoseconomicossociais.domain.model.Coordenada;


@Repository
public interface CoordenadasRepository extends JpaRepository<Coordenada, Long> {
	
	

}
