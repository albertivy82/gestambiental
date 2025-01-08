package br.gov.pa.ideflorbio.dadoseconomicossociais.domain.service;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.gov.pa.ideflorbio.dadoseconomicossociais.domain.exceptions.BenfeitoriaNaoEncontradaException;
import br.gov.pa.ideflorbio.dadoseconomicossociais.domain.exceptions.ImovelNaoEncontradoException;
import br.gov.pa.ideflorbio.dadoseconomicossociais.domain.model.Benfeitoria;
import br.gov.pa.ideflorbio.dadoseconomicossociais.domain.model.Imovel;
import br.gov.pa.ideflorbio.dadoseconomicossociais.domain.model.enums.OrigemMaterialConstrucao;
import br.gov.pa.ideflorbio.dadoseconomicossociais.domain.repository.BenfeitoriasRepository;
import br.gov.pa.ideflorbio.dadoseconomicossociais.domain.repository.ImoveisRepository;



@Service
public class BenfeitoriaService {
	
	@Autowired
	BenfeitoriasRepository benfeitorias;
	
	
	@Autowired
	ImoveisRepository imoveis;
	
	@Autowired
	ModelMapper mapper;
	
	
	
	public Benfeitoria buscarEntidade(Long id) {
		
		return benfeitorias.findById(id)
				.orElseThrow(()->new BenfeitoriaNaoEncontradaException(id));
		
	}
	
	
	public Benfeitoria inserir (Benfeitoria benfeitoria) {
		System.out.println(benfeitoria.getImovel().getId());
		Long imovelId = benfeitoria.getImovel().getId();
		Imovel imovel = imoveis.findById(imovelId).orElseThrow(()->new ImovelNaoEncontradoException(imovelId));
		
		benfeitoria.setImovel(imovel);
		
		return benfeitorias.save(benfeitoria);
	}
	
	public List<Benfeitoria> buscarPorImovel(Long imovelId) {
		
			List<Benfeitoria> benfeitoriasDB = benfeitorias.findByImovelId(imovelId);
			
			benfeitoriasDB.forEach(benfeitoria -> {
			    List<String> origemMaterialStrings = benfeitorias.findOrigemMaterialConstrucaoByBenfeitoriaId(benfeitoria.getId());
			    Set<OrigemMaterialConstrucao> origemMaterial = origemMaterialStrings.stream()
			        .map(OrigemMaterialConstrucao::valueOf)
			        .collect(Collectors.toSet());
			    benfeitoria.setOrigemMaterialConstrucao(origemMaterial);
			});

		return benfeitoriasDB;
		
	}
	
	
	
	
}
