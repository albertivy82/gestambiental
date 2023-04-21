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
	
	@Query(value = "SELECT * FROM usuario WHERE usuario.email LIKE:email", nativeQuery = true)
	Optional<Usuario>findByEmail(String email);
	
	@Query(value = "SELECT * FROM usuario WHERE usuario.cpf LIKE:cpf", nativeQuery=true)
	Optional<Usuario>findByCpf(String cpf);
	
	@Query(value = "SELECT * FROM usuario WHERE usuario.Matricula LIKE:matricula", nativeQuery=true)
	Optional<Usuario>findByMatricula(String matricula);

}
