
package br.gov.pa.ideflorbio.dadoseconomicossociais.domain.service;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.gov.pa.ideflorbio.dadoseconomicossociais.api.model.AvesDTO;
import br.gov.pa.ideflorbio.dadoseconomicossociais.domain.exceptions.AveNaoEncontradaException;
import br.gov.pa.ideflorbio.dadoseconomicossociais.domain.exceptions.EntidadeEmUsoException;
import br.gov.pa.ideflorbio.dadoseconomicossociais.domain.exceptions.EntrevistadoNaoEncontradoException;
import br.gov.pa.ideflorbio.dadoseconomicossociais.domain.model.Aves;
import br.gov.pa.ideflorbio.dadoseconomicossociais.domain.model.Entrevistado;
import br.gov.pa.ideflorbio.dadoseconomicossociais.domain.repository.AvesRepository;
import br.gov.pa.ideflorbio.dadoseconomicossociais.domain.repository.EntrevistadosRepository;

@Service
public class AveService {

    private static final String ENTIDADE_EM_USO = "A ave de código %d não pode ser removida, pois está em uso";

    @Autowired
    AvesRepository aves;

    @Autowired
    EntrevistadosRepository entrevistados;

    @Autowired
    ModelMapper mapper;

    @Transactional
    public Aves inserir(Aves ave) {
        Long idEntrevistado = ave.getEntrevistado().getId();
        Entrevistado entrevistado = entrevistados.findById(idEntrevistado)
            .orElseThrow(() -> new EntrevistadoNaoEncontradoException(idEntrevistado));
        ave.setEntrevistado(entrevistado);
        return aves.save(ave);
    }

    public Aves buscarEntidade(Long id) {
        Aves atual = aves.findById(id)
            .orElseThrow(() -> new AveNaoEncontradaException(id));
        return inserir(atual);
    }

    public List<Aves> listarTodos() {
        return aves.findAll();
    }

    public AvesDTO localizarEntidade(Long id) {
        Aves ave = aves.findById(id)
            .orElseThrow(() -> new AveNaoEncontradaException(id));
        return mapper.map(ave, AvesDTO.class);
    }

    public List<AvesDTO> buscarPorEntrevistado(Long entrevistadoId) {
        return aves.findByEntrevistado(entrevistadoId)
            .stream().map(e -> mapper.map(e, AvesDTO.class)).toList();
    }

    @Transactional
    public void excluir(Long id) {
        try {
            aves.deleteById(id);
            aves.flush();
        } catch (EmptyResultDataAccessException e) {
            throw new AveNaoEncontradaException(id);
        } catch (DataIntegrityViolationException e) {
            throw new EntidadeEmUsoException(ENTIDADE_EM_USO.formatted(id));
        }
    }
}

