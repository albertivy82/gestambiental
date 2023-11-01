package br.gov.pa.ideflorbio.dadoseconomicossociais.domain.service;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.gov.pa.ideflorbio.dadoseconomicossociais.api.model.AtendimentoSaudeDTO;
import br.gov.pa.ideflorbio.dadoseconomicossociais.domain.exceptions.EntidadeEmUsoException;
import br.gov.pa.ideflorbio.dadoseconomicossociais.domain.exceptions.ServicoNaoEncontradoException;
import br.gov.pa.ideflorbio.dadoseconomicossociais.domain.model.AtendimentoSaude;
import br.gov.pa.ideflorbio.dadoseconomicossociais.domain.repository.AtendimentoSaudeRepository;
@Service
public class AtendimentoSaudeService {
	
	
	private static final String ENTIDADE_EM_USO = "Os dados sobre serviços públicos básicos com id %d nõ podem ser apagados, pois estão "
			+ "sendo utilizados em um relacionamento";

	
	@Autowired
	AtendimentoSaudeRepository atendimentos;
	
	@Autowired
	ModelMapper mapper;
	
	@Transactional
	public AtendimentoSaude inserir(AtendimentoSaude atendimentosBasicos) {
		
		return atendimentos.save(atendimentosBasicos);
	}
	
	@Transactional
	public AtendimentoSaude buscarEntidade(Long id) {
		
		AtendimentoSaude atendimentosBasicos = atendimentos.findById(id)
				.orElseThrow(()-> new ServicoNaoEncontradoException(id));
		
		return atendimentosBasicos;
	}
	
	public List<AtendimentoSaude> listarTodos(){
		
	   return atendimentos.findAll(); 
		
	}
	
	public AtendimentoSaudeDTO localizarEntidade(Long id) {
		
			AtendimentoSaude AtendimentoSaude = atendimentos.findById(id)
					.orElseThrow(()-> new ServicoNaoEncontradoException(id));
		
		return mapper.map(AtendimentoSaude, AtendimentoSaudeDTO.class);
	}
	
		
	@Transactional
	public void excluir(Long id) {
		try {
			atendimentos.deleteById(id);
			atendimentos.flush();
		}catch(EmptyResultDataAccessException e) {
			
			throw new ServicoNaoEncontradoException(id);
			
		}catch(DataIntegrityViolationException e) {
			
			throw new EntidadeEmUsoException(ENTIDADE_EM_USO.formatted(id));
		}
	}	
	
	


}
