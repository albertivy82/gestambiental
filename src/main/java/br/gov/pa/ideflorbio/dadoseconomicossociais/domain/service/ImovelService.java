package br.gov.pa.ideflorbio.dadoseconomicossociais.domain.service;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.gov.pa.ideflorbio.dadoseconomicossociais.api.model.ImovelDTO;
import br.gov.pa.ideflorbio.dadoseconomicossociais.domain.exceptions.EntidadeEmUsoException;
import br.gov.pa.ideflorbio.dadoseconomicossociais.domain.exceptions.EntrevistadoNaoEncontradoException;
import br.gov.pa.ideflorbio.dadoseconomicossociais.domain.exceptions.ImovelNaoEncontradoException;
import br.gov.pa.ideflorbio.dadoseconomicossociais.domain.exceptions.NegocioException;
import br.gov.pa.ideflorbio.dadoseconomicossociais.domain.model.Entrevistado;
import br.gov.pa.ideflorbio.dadoseconomicossociais.domain.model.Imovel;
import br.gov.pa.ideflorbio.dadoseconomicossociais.domain.repository.AtendimentoSaudeRepository;
import br.gov.pa.ideflorbio.dadoseconomicossociais.domain.repository.EntrevistadosRepository;
import br.gov.pa.ideflorbio.dadoseconomicossociais.domain.repository.ImoveisRepository;
import br.gov.pa.ideflorbio.dadoseconomicossociais.domain.repository.ServicosBasicosRepository;

@Service
public class ImovelService {
	
	private static final String ENTIDADE_EM_USO 
	= "O imóvel de código %d não pode ser removido, pois está em uso";
	
	
	
	@Autowired
	ImoveisRepository imoveis;
	
	@Autowired
	EntrevistadosRepository entrevistados;
	
	@Autowired
	ServicosBasicosRepository servicoBasico;
	
	@Autowired
	AtendimentoSaudeRepository atendimentos;
	
		
	
	@Autowired
	ModelMapper mapper;
	
	public Imovel buscarEntidade(Long id) {
		return imoveis.findById(id)
				.orElseThrow(()-> new ImovelNaoEncontradoException(id));
	}
	
	@Transactional
	public Imovel inserir(Imovel imovel) {
		
		Long idEntrevistado = imovel.getEntrevistado().getId();
		Entrevistado entrevistado = entrevistados.findById(idEntrevistado)
		.orElseThrow(()->new EntrevistadoNaoEncontradoException(idEntrevistado));
		
		if(entrevistado.getId()!=null && imovel.getEntrevistado()!=null) {
			throw new NegocioException("Esta Entrevistado já possui um imóvel cadastrado. Atualize o cadastro ou apague o mesmo"
					+ " para realizar novo cadastro");
		}
		
		entrevistado.setImovel(imovel);
		
		return imoveis.save(imovel);
	}
	
	
		
	public List<Imovel> listarTodos(){
		
	   return imoveis.findAll(); 
		
	}
	
    
  public Imovel buscarPorEntrevistado(Long entrevistadoId) {
		
		Imovel imovelDB = imoveis.findByEntrevistadoId(entrevistadoId).orElseThrow(()->new ImovelNaoEncontradoException(entrevistadoId));
			
	return imovelDB;
	
   }
	
	
	public ImovelDTO localizarEntidade(Long id) {
		
			Imovel imovel = buscarEntidade(id);
		
		return mapper.map(imovel, ImovelDTO.class);
	}
	
	
    	
			
	@Transactional
	public void excluir(Long id) {
		try {
			imoveis.deleteById(id);
			imoveis.flush();
		}catch(EmptyResultDataAccessException e) {
			
			throw new ImovelNaoEncontradoException(id);
			
		}catch(DataIntegrityViolationException e) {
			
			throw new EntidadeEmUsoException(ENTIDADE_EM_USO.formatted(id));
		}
	}	
	
	
	

}
