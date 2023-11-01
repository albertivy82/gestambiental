package br.gov.pa.ideflorbio.dadoseconomicossociais.domain.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import br.gov.pa.ideflorbio.dadoseconomicossociais.domain.model.PostoDeSaude;

@Repository
public interface PostosDeSaudeRepository extends JpaRepository<PostoDeSaude, Long>{
	
	
	@Query(value="SELECT * FROM POSTO_DE_SAUDE WHERE localidade = ?1", nativeQuery = true)
	List<PostoDeSaude>findByLocalidade(Long localidade);

}
