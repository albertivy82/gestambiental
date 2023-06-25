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
import br.gov.pa.ideflorbio.dadoseconomicossociais.domain.exceptions.ImovelNaoEncontradoException;
import br.gov.pa.ideflorbio.dadoseconomicossociais.domain.exceptions.LocalidadeNaoEncontradaException;
import br.gov.pa.ideflorbio.dadoseconomicossociais.domain.model.Imovel;
import br.gov.pa.ideflorbio.dadoseconomicossociais.domain.model.Localidade;
import br.gov.pa.ideflorbio.dadoseconomicossociais.domain.repository.ImoveisRepository;
import br.gov.pa.ideflorbio.dadoseconomicossociais.domain.repository.LocalidadesRepository;

@Service
public class ImovelService {
	
	private static final String ENTIDADE_EM_USO 
	= "O imóvel de código %d não pode ser removido, pois está em uso";
	
	@Autowired
	LocalidadesRepository localidades;
	
	@Autowired
	ImoveisRepository imoveis;
	
	
	@Autowired
	ModelMapper mapper;
	
	public Imovel buscarEntidade(Long id) {
		return imoveis.findById(id)
				.orElseThrow(()-> new ImovelNaoEncontradoException(id));
	}
	
	@Transactional
	public Imovel inserir(Imovel imovel) {
		
		Long idLocalidade = imovel.getLocalidade().getId();
			Localidade localidade = localidades.findById(idLocalidade)
					.orElseThrow(()->new LocalidadeNaoEncontradaException(idLocalidade));
		
		imovel.setLocalidade(localidade);
		
		return imoveis.save(imovel);
	}
	
	
		
	public List<Imovel> listarTodos(){
		
	   return imoveis.findAll(); 
		
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
