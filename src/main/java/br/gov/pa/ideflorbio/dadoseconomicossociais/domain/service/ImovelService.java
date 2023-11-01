package br.gov.pa.ideflorbio.dadoseconomicossociais.domain.service;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.gov.pa.ideflorbio.dadoseconomicossociais.api.model.AtendimentoSaudeDTO;
import br.gov.pa.ideflorbio.dadoseconomicossociais.api.model.ImovelDTO;
import br.gov.pa.ideflorbio.dadoseconomicossociais.api.model.OutrosServicosDTO;
import br.gov.pa.ideflorbio.dadoseconomicossociais.api.model.ServicosBasicosDTO;
import br.gov.pa.ideflorbio.dadoseconomicossociais.domain.exceptions.EntidadeEmUsoException;
import br.gov.pa.ideflorbio.dadoseconomicossociais.domain.exceptions.ImovelNaoEncontradoException;
import br.gov.pa.ideflorbio.dadoseconomicossociais.domain.exceptions.LocalidadeNaoEncontradaException;
import br.gov.pa.ideflorbio.dadoseconomicossociais.domain.exceptions.ServicoNaoEncontradoException;
import br.gov.pa.ideflorbio.dadoseconomicossociais.domain.model.AtendimentoSaude;
import br.gov.pa.ideflorbio.dadoseconomicossociais.domain.model.Imovel;
import br.gov.pa.ideflorbio.dadoseconomicossociais.domain.model.Localidade;
import br.gov.pa.ideflorbio.dadoseconomicossociais.domain.model.OutrosServicos;
import br.gov.pa.ideflorbio.dadoseconomicossociais.domain.model.ServicosBasicos;
import br.gov.pa.ideflorbio.dadoseconomicossociais.domain.repository.AtendimentoSaudeRepository;
import br.gov.pa.ideflorbio.dadoseconomicossociais.domain.repository.ImoveisRepository;
import br.gov.pa.ideflorbio.dadoseconomicossociais.domain.repository.LocalidadesRepository;
import br.gov.pa.ideflorbio.dadoseconomicossociais.domain.repository.OutrosServicosRepository;
import br.gov.pa.ideflorbio.dadoseconomicossociais.domain.repository.ServicosBasicosRepository;

@Service
public class ImovelService {
	
	private static final String ENTIDADE_EM_USO 
	= "O imóvel de código %d não pode ser removido, pois está em uso";
	
	@Autowired
	LocalidadesRepository localidades;
	
	@Autowired
	ImoveisRepository imoveis;
	
	@Autowired
	ServicosBasicosRepository servicoBasico;
	
	@Autowired
	AtendimentoSaudeRepository atendimentos;
	
	@Autowired
	OutrosServicosRepository outrosServicos;
	
	
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
	public List<ImovelDTO> findByLocalidade(Long localidadeId){
		
		return imoveis.findByLocalidadeId(localidadeId).stream().map(i->mapper.map(i, ImovelDTO.class)).toList();
		
	}
	
	
	public ImovelDTO localizarEntidade(Long id) {
		
			Imovel imovel = buscarEntidade(id);
		
		return mapper.map(imovel, ImovelDTO.class);
	}
	
	
    public List<ServicosBasicosDTO> listaServicosBasicos(Long id){
		
		Imovel imovel = imoveis.findById(id)
				.orElseThrow(()-> new ImovelNaoEncontradoException(id));
		
		List<ServicosBasicosDTO> listaServicosBasicos = imovel.getServicosBasicos()
				.stream().map(e->mapper.map(e, ServicosBasicosDTO.class)).toList();
		
		return listaServicosBasicos;
	}
	
	@Transactional
	public void vincularServicoBasico(Long imovelId, Long servicoId) {
		
		Imovel imovel = imoveis.findById(imovelId)
				.orElseThrow(()-> new ImovelNaoEncontradoException(imovelId));
		ServicosBasicos servico = servicoBasico.findById(servicoId)
				.orElseThrow(()->new ServicoNaoEncontradoException(servicoId));
		
		imovel.getServicosBasicos().add(servico);
		
	}
	
	@Transactional
	public void desvincularServicoBasico(Long imovelId, Long servicoId) {
		
		Imovel imovel = imoveis.findById(imovelId)
				.orElseThrow(()-> new ImovelNaoEncontradoException(imovelId));
		ServicosBasicos servico = servicoBasico.findById(servicoId)
				.orElseThrow(()->new ServicoNaoEncontradoException(servicoId));
		
		imovel.getServicosBasicos().remove(servico);
		
	}
	
	
	 public List<AtendimentoSaudeDTO> listaAtendimentoSaude(Long id){
			
			Imovel imovel = imoveis.findById(id)
					.orElseThrow(()-> new ImovelNaoEncontradoException(id));
			
			List<AtendimentoSaudeDTO> listaAtendimentoSaude = imovel.getAtendimentoSaude()
					.stream().map(e->mapper.map(e, AtendimentoSaudeDTO.class)).toList();
			
			return listaAtendimentoSaude;
		}
	
	
	@Transactional
	public void vincularAtendimentoSaude(Long imovelId, Long atendimentoId) {
		
		Imovel imovel = imoveis.findById(imovelId)
				.orElseThrow(()-> new ImovelNaoEncontradoException(imovelId));
		AtendimentoSaude atendimentoSaude = atendimentos.findById(atendimentoId)
				.orElseThrow(()->new ServicoNaoEncontradoException(atendimentoId));
		
		imovel.getAtendimentoSaude().add(atendimentoSaude);
		
	}
	
	@Transactional
	public void desvincularAtendimentoSaude(Long imovelId, Long atendimentoId) {
		
		Imovel imovel = imoveis.findById(imovelId)
				.orElseThrow(()-> new ImovelNaoEncontradoException(imovelId));
		AtendimentoSaude atendimentoSaude = atendimentos.findById(atendimentoId)
				.orElseThrow(()->new ServicoNaoEncontradoException(atendimentoId));
		
		imovel.getAtendimentoSaude().remove(atendimentoSaude);
		
	}
	
	
	public List<OutrosServicosDTO> listaOutrosServicos(Long id){
		
		Imovel imovel = imoveis.findById(id)
				.orElseThrow(()-> new ImovelNaoEncontradoException(id));
		
		List<OutrosServicosDTO> listaOutrosServicos = imovel.getAtendimentoSaude()
				.stream().map(e->mapper.map(e, OutrosServicosDTO.class)).toList();
		
		return listaOutrosServicos;
	}
	
	@Transactional
	public void vincularOutrosServicos(Long imovelId, Long outrosServicosId) {
		
		Imovel imovel = imoveis.findById(imovelId)
				.orElseThrow(()-> new ImovelNaoEncontradoException(imovelId));
		OutrosServicos outroServico = outrosServicos.findById(outrosServicosId)
				.orElseThrow(()->new ServicoNaoEncontradoException(outrosServicosId));
		
		imovel.getOutrosServicos().add(outroServico);
		
	}
		
	@Transactional
	public void desvincularOutrosServicos(Long imovelId, Long outrosServicosId) {
		
		Imovel imovel = imoveis.findById(imovelId)
				.orElseThrow(()-> new ImovelNaoEncontradoException(imovelId));
		OutrosServicos outroServico = outrosServicos.findById(outrosServicosId)
				.orElseThrow(()->new ServicoNaoEncontradoException(outrosServicosId));
		
		imovel.getOutrosServicos().remove(outroServico);
		
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
