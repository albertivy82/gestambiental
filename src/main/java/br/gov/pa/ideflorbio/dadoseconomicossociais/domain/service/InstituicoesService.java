package br.gov.pa.ideflorbio.dadoseconomicossociais.domain.service;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.gov.pa.ideflorbio.dadoseconomicossociais.api.model.InstituicoesConhecidasDTO;
import br.gov.pa.ideflorbio.dadoseconomicossociais.domain.exceptions.EntidadeEmUsoException;
import br.gov.pa.ideflorbio.dadoseconomicossociais.domain.exceptions.ImovelNaoEncontradoException;
import br.gov.pa.ideflorbio.dadoseconomicossociais.domain.exceptions.InstituicaoNaoEncontradaException;
import br.gov.pa.ideflorbio.dadoseconomicossociais.domain.model.Imovel;
import br.gov.pa.ideflorbio.dadoseconomicossociais.domain.model.InstituicaoConhecida;
import br.gov.pa.ideflorbio.dadoseconomicossociais.domain.repository.ImoveisRepository;
import br.gov.pa.ideflorbio.dadoseconomicossociais.domain.repository.InstituicoesConhecidasRepository;

@Service
public class InstituicoesService {
	
	private static final String ENTIDADE_EM_USO 
	= "A insituição de código %d não pode ser removida, pois está em uso";
	
	@Autowired
	InstituicoesConhecidasRepository instituicoes;
	
	@Autowired
	ImoveisRepository imoveis;
	
	
	@Autowired
	ModelMapper mapper;
	
	@Transactional
	public InstituicaoConhecida inserir(InstituicaoConhecida instituicaoConhecida) {
		
		Long idImovel = instituicaoConhecida.getImovel().getId();
		Imovel imovel = imoveis.findById(idImovel)
		.orElseThrow(()->new ImovelNaoEncontradoException(idImovel));
		
		instituicaoConhecida.setImovel(imovel);
		
		return instituicoes.save(instituicaoConhecida);
	}
	
	
	@Transactional
	public InstituicaoConhecida buscarEntidade(Long id) {
		
		InstituicaoConhecida InstituicaoConhecidaAtual = instituicoes.findById(id)
				.orElseThrow(()->new InstituicaoNaoEncontradaException(id));
				
		return InstituicaoConhecidaAtual;
		
	}

	
	public List<InstituicaoConhecida> listarTodos(){
		
	   return instituicoes.findAll(); 
		
	}
	
	public InstituicoesConhecidasDTO localizarEntidade(Long id) {
		
		InstituicaoConhecida instituicaoAtual = instituicoes.findById(id)
				.orElseThrow(()-> new InstituicaoNaoEncontradaException(id));
		
		return mapper.map(instituicaoAtual, InstituicoesConhecidasDTO.class);
	}
	
		
	@Transactional
	public void excluir(Long id) {
		try {
			instituicoes.deleteById(id);
			instituicoes.flush();
		}catch(EmptyResultDataAccessException e) {
			
			throw new InstituicaoNaoEncontradaException(id);
			
		}catch(DataIntegrityViolationException e) {
			
			throw new EntidadeEmUsoException(ENTIDADE_EM_USO.formatted(id));
		}
	}	
	
	
	

}
