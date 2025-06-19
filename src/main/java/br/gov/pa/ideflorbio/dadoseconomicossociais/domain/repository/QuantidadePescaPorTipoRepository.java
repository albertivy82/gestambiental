package br.gov.pa.ideflorbio.dadoseconomicossociais.domain.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import br.gov.pa.ideflorbio.dadoseconomicossociais.domain.model.QuantidadePescaPorTipo;


@Repository
public interface QuantidadePescaPorTipoRepository extends JpaRepository<QuantidadePescaPorTipo, Long>{
	
	@Query(value= "SELECT * FROM QUANTIDADE_PESCA_POR_TIPO WHERE PESCA_ARTESANAL = ?1", nativeQuery=true)
	List<QuantidadePescaPorTipo> findByPescaArtesanalId(Long pescaArtesanalId);

}
