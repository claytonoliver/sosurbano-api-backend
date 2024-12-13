package com.br.sosurbano.sosurbano.service;

import com.br.sosurbano.sosurbano.dto.chamado.ChamadoExibicaoDTO;
import com.br.sosurbano.sosurbano.exception.ChamadoNaoEncontradoException;
import com.br.sosurbano.sosurbano.model.ChamadoModel;
import com.br.sosurbano.sosurbano.repository.ChamadoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ChamadoService {

    @Autowired
    private ChamadoRepository chamadoRepository;

    public Page<ChamadoExibicaoDTO> listarTodosChamados(Pageable pageable) {
        return chamadoRepository.findAll(pageable)
                .map(ChamadoExibicaoDTO::new);
    }

    public Optional<ChamadoExibicaoDTO> buscarPorId(Integer id) {
        Optional<ChamadoExibicaoDTO> chamado = chamadoRepository.findById(id)
                .map(ChamadoExibicaoDTO::new);

        if (chamado.isEmpty()) {
            throw new ChamadoNaoEncontradoException("Chamado não encontrado com o ID: " + id);
        }

        return chamado;
    }

    public ChamadoModel salvarChamado(ChamadoModel chamado) {
        // Caso queira verificar duplicidade (por exemplo, por algum campo único)
        // if (chamadoRepository.existsByAlgumCampo(chamado.getAlgumCampo())) {
        //     throw new ChamadoJaExistenteException("Chamado já existente");
        // }

        return chamadoRepository.save(chamado);
    }

    public Optional<ChamadoModel> atualizarChamado(Integer id, ChamadoModel chamadoAtualizado) {
        Optional<ChamadoModel> chamado = chamadoRepository.findById(id);

        if (chamado.isEmpty()) {
            throw new ChamadoNaoEncontradoException("Chamado não encontrado para atualização com o ID: " + id);
        }

        chamado.get().setUsuarioId(chamadoAtualizado.getUsuarioId());
        chamado.get().setStatusId(chamadoAtualizado.getStatusId());
        chamado.get().setDataChamado(chamadoAtualizado.getDataChamado());
        chamado.get().setDescricao(chamadoAtualizado.getDescricao());
        chamado.get().setLatitude(chamadoAtualizado.getLatitude());
        chamado.get().setLongitude(chamadoAtualizado.getLongitude());

        return Optional.of(chamadoRepository.save(chamado.get()));
    }

    public void deletarChamado(Integer id) {
        Optional<ChamadoModel> chamado = chamadoRepository.findById(id);

        if (chamado.isEmpty()) {
            throw new ChamadoNaoEncontradoException("Chamado não encontrado para exclusão com o ID: " + id);
        }

        chamadoRepository.deleteById(id);
    }
}
