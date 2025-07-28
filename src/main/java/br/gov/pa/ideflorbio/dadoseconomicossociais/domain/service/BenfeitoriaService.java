package br.gov.pa.ideflorbio.dadoseconomicossociais.domain.service;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.gov.pa.ideflorbio.dadoseconomicossociais.domain.exceptions.BenfeitoriaNaoEncontradaException;
import br.gov.pa.ideflorbio.dadoseconomicossociais.domain.exceptions.EntidadeEmUsoException;
import br.gov.pa.ideflorbio.dadoseconomicossociais.domain.exceptions.ImovelNaoEncontradoException;
import br.gov.pa.ideflorbio.dadoseconomicossociais.domain.model.Benfeitoria;
import br.gov.pa.ideflorbio.dadoseconomicossociais.domain.model.Imovel;
import br.gov.pa.ideflorbio.dadoseconomicossociais.domain.repository.BenfeitoriasRepository;
import br.gov.pa.ideflorbio.dadoseconomicossociais.domain.repository.ImoveisRepository;



@Service
public class BenfeitoriaService {
	
	private static final String ENTIDADE_EM_USO 
	= "A benfeitoria de código %d não pode ser removida, pois está em uso";
	
	@Autowired
	BenfeitoriasRepository benfeitorias;
	
	
	@Autowired
	ImoveisRepository imoveis;
	
	@Autowired
	ModelMapper mapper;
	
	
	@Transactional
	public Benfeitoria inserir (Benfeitoria benfeitoria) {
		Long imovelId = benfeitoria.getImovel().getId();
		Imovel imovel = imoveis.findById(imovelId).orElseThrow(()->new ImovelNaoEncontradoException(imovelId));
		
		benfeitoria.setImovel(imovel);
		
		return benfeitorias.save(benfeitoria);
	}
	
	
     public Benfeitoria buscarEntidade(Long id) {
		
		return benfeitorias.findById(id)
				.orElseThrow(()->new BenfeitoriaNaoEncontradaException(id));
		
	 }
	
	public List<Benfeitoria> listarTodos(){
		
		   return benfeitorias.findAll(); 
			
	}
		
	 
	     
	
	public List<Benfeitoria> buscarPorImovel(Long imovelId) {
		
			List<Benfeitoria> benfeitoriasDB = benfeitorias.findByImovelId(imovelId);
			
		return benfeitoriasDB;
		
	}
	
	
	
	
	@Transactional
	public void excluir(Long id) {
		try {
			benfeitorias.deleteById(id);
			benfeitorias.flush();
		}catch(EmptyResultDataAccessException e) {
			
			throw new BenfeitoriaNaoEncontradaException(id);
			
		}catch(DataIntegrityViolationException e) {
			
			throw new EntidadeEmUsoException(ENTIDADE_EM_USO.formatted(id));
		}
	}	
	
	
	
	
}
