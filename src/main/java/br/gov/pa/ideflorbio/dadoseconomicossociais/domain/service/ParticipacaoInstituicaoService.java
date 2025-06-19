package br.gov.pa.ideflorbio.dadoseconomicossociais.domain.service;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.gov.pa.ideflorbio.dadoseconomicossociais.api.model.ParticipacaoInstituicaoDTO;
import br.gov.pa.ideflorbio.dadoseconomicossociais.domain.exceptions.EntidadeEmUsoException;
import br.gov.pa.ideflorbio.dadoseconomicossociais.domain.exceptions.MoradorNaoEncontradoException;
import br.gov.pa.ideflorbio.dadoseconomicossociais.domain.exceptions.ParticipacaoInstituicaoNaoEncontradaException;
import br.gov.pa.ideflorbio.dadoseconomicossociais.domain.exceptions.PeixeNaoEncontradoException;
import br.gov.pa.ideflorbio.dadoseconomicossociais.domain.model.Morador;
import br.gov.pa.ideflorbio.dadoseconomicossociais.domain.model.ParticipacaoInstituicao;
import br.gov.pa.ideflorbio.dadoseconomicossociais.domain.repository.MoradoresRepository;
import br.gov.pa.ideflorbio.dadoseconomicossociais.domain.repository.ParticipacaoInstituicaoRepository;

@Service
public class ParticipacaoInstituicaoService {
	
	private static final String ENTIDADE_EM_USO 
	= "A participação institucional de código %d não pode ser removida, pois está em uso";
	
	@Autowired
	ParticipacaoInstituicaoRepository participacoes;
	
	@Autowired
	MoradoresRepository moradores;
	
	@Autowired
	ModelMapper mapper;
	
	@Transactional
	public ParticipacaoInstituicao inserir(ParticipacaoInstituicao participacaoInstituicao) {
		
		
		Long idMorador = participacaoInstituicao.getMorador().getId();
		Morador entrevistado = moradores.findById(idMorador)
		.orElseThrow(()->new MoradorNaoEncontradoException(idMorador));
		participacaoInstituicao.setMorador(entrevistado);
		
		return participacoes.save(participacaoInstituicao);
	}
	
	
	public ParticipacaoInstituicao buscarEntidade(Long id) {
		
		ParticipacaoInstituicao participacaoInstituicaoAtual = participacoes.findById(id)
				.orElseThrow(()-> new ParticipacaoInstituicaoNaoEncontradaException(id));
		return inserir(participacaoInstituicaoAtual);
	}
	
	
	
	public List<ParticipacaoInstituicao> listarTodos(){
		
	   return participacoes.findAll(); 
		
	}
	
	
	public ParticipacaoInstituicaoDTO localizarEntidade(Long id) {
		
			ParticipacaoInstituicao participacaoInstituicao = participacoes.findById(id)
					.orElseThrow(()-> new PeixeNaoEncontradoException(id));
		
		return mapper.map(participacaoInstituicao, ParticipacaoInstituicaoDTO.class);
	}
	
	public List<ParticipacaoInstituicaoDTO> buscarPorMorador(Long entrevistadoId){
		List<ParticipacaoInstituicaoDTO> participacaoInstituicaoPorMorador = participacoes.findByMorador(entrevistadoId)
				.stream().map(participacaoInstituicao->mapper.map(participacaoInstituicao, ParticipacaoInstituicaoDTO.class)).toList();
		
		return participacaoInstituicaoPorMorador;
	}
		
	@Transactional
	public void excluir(Long id) {
		try {
			participacoes.deleteById(id);
			participacoes.flush();
		}catch(EmptyResultDataAccessException e) {
			
			throw new PeixeNaoEncontradoException(id);
			
		}catch(DataIntegrityViolationException e) {
			
			throw new EntidadeEmUsoException(ENTIDADE_EM_USO.formatted(id));
		}
	}	
	
	
	

}
