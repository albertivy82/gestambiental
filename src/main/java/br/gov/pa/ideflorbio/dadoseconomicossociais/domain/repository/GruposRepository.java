package br.gov.pa.ideflorbio.dadoseconomicossociais.domain.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import br.gov.pa.ideflorbio.dadoseconomicossociais.domain.model.Grupo;

@Repository
public interface GruposRepository extends JpaRepository<Grupo, Long> {
	
	@Query(value = "SELECT nome FROM grupo"
	+ " INNER JOIN usuario_grupo ON usuario_grupo.grupo = grupo.id"
	+ " WHERE usuario_grupo.usuario = :id", nativeQuery=true)
	List<String> findNomeGrupo(@Param("id") Long id);
	
}
