package br.gov.pa.ideflorbio.dadoseconomicossociais.domain.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import br.gov.pa.ideflorbio.dadoseconomicossociais.domain.model.Embarcacao;


@Repository
public interface EmbarcacaoRepository extends JpaRepository<Embarcacao, Long> {
	
	@Query(value= "SELECT * FROM EMBARCACAO WHERE PESCA_ARTESANAL = ?1", nativeQuery=true)
	List<Embarcacao> findByPescaArtesanalId(Long pescaArtesanalId);

	

}
