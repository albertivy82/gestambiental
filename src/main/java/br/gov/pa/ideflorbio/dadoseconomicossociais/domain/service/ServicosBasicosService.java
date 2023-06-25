package br.gov.pa.ideflorbio.dadoseconomicossociais.domain.service;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import br.gov.pa.ideflorbio.dadoseconomicossociais.api.model.ServicosBasicosDTO;
import br.gov.pa.ideflorbio.dadoseconomicossociais.domain.exceptions.EntidadeEmUsoException;
import br.gov.pa.ideflorbio.dadoseconomicossociais.domain.exceptions.ImovelNaoEncontradoException;
import br.gov.pa.ideflorbio.dadoseconomicossociais.domain.exceptions.NegocioException;
import br.gov.pa.ideflorbio.dadoseconomicossociais.domain.exceptions.ServicoNaoEncontradoException;
import br.gov.pa.ideflorbio.dadoseconomicossociais.domain.model.Imovel;
import br.gov.pa.ideflorbio.dadoseconomicossociais.domain.model.ServicosBasicos;
import br.gov.pa.ideflorbio.dadoseconomicossociais.domain.repository.ImoveisRepository;
import br.gov.pa.ideflorbio.dadoseconomicossociais.domain.repository.ServicosBasicosRepository;
@Service
public class ServicosBasicosService {
	
	
	private static final String ENTIDADE_EM_USO = "Os dados sobre serviços públis básicos com id %d nõ podem ser apagados, pois estão "
			+ "sendo utilizados em um relacionamento";

	
	@Autowired
	ServicosBasicosRepository servicos;
	
	@Autowired
	ImoveisRepository imoveis;
	
	@Autowired
	ModelMapper mapper;
	
	@Transactional
	public ServicosBasicos inserir(ServicosBasicos servicosBasicos) {
		
		Long idImovel = servicosBasicos.getImovel().getId();
		
		Imovel imovel = imoveis.findById(idImovel)
		.orElseThrow(()->new ImovelNaoEncontradoException(idImovel));
		
		if(imovel.getEntrevistado()!=null && servicosBasicos.getId()==null) {
			throw new NegocioException("Esta imovel já possui dados sobre "
					+ "atendimentos bássicos cadastrados. Atualize o cadastro ou apague o mesmo"
					+ " para realizar novo cadastro");
		}
		
		servicosBasicos.setImovel(imovel);
		
		return servicos.save(servicosBasicos);
	}
	
	@Transactional
	public ServicosBasicos buscarEntidade(Long id) {
		
		ServicosBasicos servicosBasicos = servicos.findById(id)
				.orElseThrow(()-> new ServicoNaoEncontradoException(id));
		
		return servicosBasicos;
	}
	
	public List<ServicosBasicos> listarTodos(){
		
	   return servicos.findAll(); 
		
	}
	
	public ServicosBasicosDTO localizarEntidade(Long id) {
		
			ServicosBasicos ServicosBasicos = servicos.findById(id)
					.orElseThrow(()-> new ServicoNaoEncontradoException(id));
		
		return mapper.map(ServicosBasicos, ServicosBasicosDTO.class);
	}
	
		
	@Transactional
	public void excluir(Long id) {
		try {
			servicos.deleteById(id);
			servicos.flush();
		}catch(EmptyResultDataAccessException e) {
			
			throw new ServicoNaoEncontradoException(id);
			
		}catch(DataIntegrityViolationException e) {
			
			throw new EntidadeEmUsoException(ENTIDADE_EM_USO.formatted(id));
		}
	}	
	
	


}
