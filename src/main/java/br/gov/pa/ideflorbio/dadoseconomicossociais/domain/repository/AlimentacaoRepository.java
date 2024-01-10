package br.gov.pa.ideflorbio.dadoseconomicossociais.domain.repository;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import br.gov.pa.ideflorbio.dadoseconomicossociais.domain.model.Alimentacao;

@Repository
public interface AlimentacaoRepository extends JpaRepository<Alimentacao, Long>{
	
	@Query(value = "SELECT ID FROM ALIMENTACAO"
			+ " INNER JOIN BENFEITORIA_ALIMENTACAO ON BENFEITORIA_ALIMENTACAO.ALIMENTACAO = ALIMENTACAO.id"
			+ " WHERE BENFEITORIA = ?1", nativeQuery = true)
	List<Long> alimentosBenfeitoria(Long benfeitoria);
	
	

}
