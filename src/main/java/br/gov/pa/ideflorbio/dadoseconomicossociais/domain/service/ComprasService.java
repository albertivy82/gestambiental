package br.gov.pa.ideflorbio.dadoseconomicossociais.domain.service;

import java.util.List;
import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.gov.pa.ideflorbio.dadoseconomicossociais.api.model.ComprasDTO;
import br.gov.pa.ideflorbio.dadoseconomicossociais.domain.exceptions.BenfeitoriaNaoEncontradaException;
import br.gov.pa.ideflorbio.dadoseconomicossociais.domain.exceptions.DadosDeConsumoNaoEncontradoException;
import br.gov.pa.ideflorbio.dadoseconomicossociais.domain.exceptions.EntidadeEmUsoException;
import br.gov.pa.ideflorbio.dadoseconomicossociais.domain.exceptions.NegocioException;
import br.gov.pa.ideflorbio.dadoseconomicossociais.domain.model.Benfeitoria;
import br.gov.pa.ideflorbio.dadoseconomicossociais.domain.model.Compras;
import br.gov.pa.ideflorbio.dadoseconomicossociais.domain.repository.BenfeitoriasRepository;
import br.gov.pa.ideflorbio.dadoseconomicossociais.domain.repository.ComprasRepository;

@Service
public class ComprasService {
	
	
	private static final String ENTIDADE_EM_USO = "Os dados de Compras registrados com id %d nõ podem ser apagados, pois estão "
			+ "sendo utilizados em um relacionamento";

	
	@Autowired
	ComprasRepository compras;
	
	@Autowired
	BenfeitoriasRepository benfeitorias;
	
	@Autowired
	ModelMapper mapper;
	
	
		
	@Transactional
	public Compras inserir(Compras compra) {
		
		Long idBenfeitoria = compra.getBenfeitoria().getId();
			Benfeitoria benfeitoria = benfeitorias.findById(idBenfeitoria)
					.orElseThrow(()->new BenfeitoriaNaoEncontradaException(idBenfeitoria));
			
			Optional<Compras> checkBenfitoria = compras.compasDaBenfeitoria(idBenfeitoria);
			
			if(checkBenfitoria.isPresent()) {
				throw new NegocioException(String.format("A benfeitoria já possui cadastros dessa natureza"));
			}
		
			compra.setBenfeitoria(benfeitoria);
		
		return mapper.map(compras.save(compra), Compras.class);
	}
	
	@Transactional
	public Compras buscarEntidade(Long id) {
		
		return compras.findById(id)
				.orElseThrow(()-> new DadosDeConsumoNaoEncontradoException(id));
		
	}
	
	public List<Compras> listarTodos(){
		
	   return compras.findAll(); 
		
	}
	
	public ComprasDTO localizarEntidade(Long id) {
		
			Compras compra = compras.findById(id)
					.orElseThrow(()-> new DadosDeConsumoNaoEncontradoException(id));
		
		return mapper.map(compra, ComprasDTO.class);
	}
	
	public Compras localDeComprasdaBenfeitoria(Long bftId) {
		Compras compra = compras.compasDaBenfeitoria(bftId)
				.orElseThrow(()->new DadosDeConsumoNaoEncontradoException(bftId));
		
		System.out.print(compra);
		
		return compra;
	}
	
		
	@Transactional
	public void excluir(Long id) {
		try {
			compras.deleteById(id);
			compras.flush();
		}catch(EmptyResultDataAccessException e) {
			
			throw new DadosDeConsumoNaoEncontradoException(id);
			
		}catch(DataIntegrityViolationException e) {
			
			throw new EntidadeEmUsoException(ENTIDADE_EM_USO.formatted(id));
		}
	}	
	
	


}
