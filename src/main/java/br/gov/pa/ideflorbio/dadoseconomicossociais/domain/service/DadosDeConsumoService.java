package br.gov.pa.ideflorbio.dadoseconomicossociais.domain.service;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.gov.pa.ideflorbio.dadoseconomicossociais.api.model.DadosDeConsumoDTO;
import br.gov.pa.ideflorbio.dadoseconomicossociais.domain.exceptions.DadosDeConsumoNaoEncontradoException;
import br.gov.pa.ideflorbio.dadoseconomicossociais.domain.exceptions.EntidadeEmUsoException;
import br.gov.pa.ideflorbio.dadoseconomicossociais.domain.exceptions.ImovelNaoEncontradoException;
import br.gov.pa.ideflorbio.dadoseconomicossociais.domain.exceptions.NegocioException;
import br.gov.pa.ideflorbio.dadoseconomicossociais.domain.model.DadosDeConsumo;
import br.gov.pa.ideflorbio.dadoseconomicossociais.domain.model.Imovel;
import br.gov.pa.ideflorbio.dadoseconomicossociais.domain.repository.DadosDeConsumoRepository;
import br.gov.pa.ideflorbio.dadoseconomicossociais.domain.repository.ImoveisRepository;

@Service
public class DadosDeConsumoService {
	
	
	private static final String ENTIDADE_EM_USO = "Os dados de Consumo registrados com id %d nõ podem ser apagados, pois estão "
			+ "sendo utilizados em um relacionamento";

	
	@Autowired
	DadosDeConsumoRepository consumo;
	
	@Autowired
	ImoveisRepository imoveis;
	
	@Autowired
	ModelMapper mapper;
	
	
		
	@Transactional
	public DadosDeConsumo inserir(DadosDeConsumo dadosDeConsumo) {
		
		Long idImovel = dadosDeConsumo.getImovel().getId();
			Imovel imovel = imoveis.findById(idImovel)
					.orElseThrow(()->new ImovelNaoEncontradoException(idImovel));
			
			if(imovel.getEntrevistado()!=null && dadosDeConsumo.getId()==null) {
				throw new NegocioException("Esta imovel já possui dados sobre consumo cadastrado. Atualize o cadastro ou apague o mesmo"
						+ " para realizar novo cadastro");
			}
			
		dadosDeConsumo.setImovel(imovel);
		
		return mapper.map(consumo.save(dadosDeConsumo), DadosDeConsumo.class);
	}
	
	@Transactional
	public DadosDeConsumo buscarEntidade(Long id) {
		
		return consumo.findById(id)
				.orElseThrow(()-> new DadosDeConsumoNaoEncontradoException(id));
		
	}
	
	public List<DadosDeConsumo> listarTodos(){
		
	   return consumo.findAll(); 
		
	}
	
	public DadosDeConsumoDTO localizarEntidade(Long id) {
		
			DadosDeConsumo dadosDeConsumo = consumo.findById(id)
					.orElseThrow(()-> new DadosDeConsumoNaoEncontradoException(id));
		
		return mapper.map(dadosDeConsumo, DadosDeConsumoDTO.class);
	}
	
		
	@Transactional
	public void excluir(Long id) {
		try {
			consumo.deleteById(id);
			consumo.flush();
		}catch(EmptyResultDataAccessException e) {
			
			throw new DadosDeConsumoNaoEncontradoException(id);
			
		}catch(DataIntegrityViolationException e) {
			
			throw new EntidadeEmUsoException(ENTIDADE_EM_USO.formatted(id));
		}
	}	
	
	


}
