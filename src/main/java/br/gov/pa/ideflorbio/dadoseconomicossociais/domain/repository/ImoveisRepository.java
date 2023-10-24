package br.gov.pa.ideflorbio.dadoseconomicossociais.domain.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import br.gov.pa.ideflorbio.dadoseconomicossociais.domain.model.Imovel;

@Repository
public interface ImoveisRepository extends JpaRepository<Imovel, Long>{
	
	@Query(value= "SELECT * FROM IMOVEL WHERE localidade = ?1", nativeQuery=true)
	List<Imovel> findByLocalidadeId (Long localidadeId);

}
