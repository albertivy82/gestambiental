package br.gov.pa.ideflorbio.dadoseconomicossociais.domain.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import br.gov.pa.ideflorbio.dadoseconomicossociais.domain.model.Usuario;


@Repository
public interface UsuariosRepository extends JpaRepository<Usuario, Long>{
	
	@Query(value = "SELECT * FROM usuario WHERE usuario.nome LIKE:nome", nativeQuery = true)
	Optional<Usuario> findByNome(String nome);

}
