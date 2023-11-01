package br.gov.pa.ideflorbio.dadoseconomicossociais.domain.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import br.gov.pa.ideflorbio.dadoseconomicossociais.domain.model.Escola;


@Repository
public interface EscolasRepository extends JpaRepository<Escola, Long> {
	
	@Query(value = "SELECT * FROM escola WHERE escola.nome LIKE :nome", nativeQuery = true)
	Optional<Escola> findByNome(String nome);
	
	@Query(value="SELECT * FROM escola WHERE localidade = ?1", nativeQuery = true)
	List<Escola>findByLocalidade(Long localidade);
	

}
