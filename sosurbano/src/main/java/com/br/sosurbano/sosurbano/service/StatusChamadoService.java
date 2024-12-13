package com.br.sosurbano.sosurbano.service;

import com.br.sosurbano.sosurbano.dto.StatusChamadoDTO;
import com.br.sosurbano.sosurbano.exception.StatusChamadoNaoEncontradoException;
import com.br.sosurbano.sosurbano.model.StatusChamadoModel;
import com.br.sosurbano.sosurbano.repository.StatusChamadoRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StatusChamadoService {

    @Autowired
    private StatusChamadoRepository statusChamadoRepository;

    public StatusChamadoDTO salvarStatusChamado(@Valid StatusChamadoDTO statusChamadoDTO) {
        StatusChamadoModel statusChamadoModel = new StatusChamadoModel();
        statusChamadoModel.setStatusNome(statusChamadoDTO.getStatusNome());
        statusChamadoModel.setDescricao(statusChamadoDTO.getDescricao());

        StatusChamadoModel statusChamadoSalvo = statusChamadoRepository.save(statusChamadoModel);

        return new StatusChamadoDTO(statusChamadoSalvo.getStatusId(), statusChamadoSalvo.getStatusNome(), statusChamadoSalvo.getDescricao());
    }

    public List<StatusChamadoDTO> listarTodosStatusChamados() {
        List<StatusChamadoModel> statusChamados = statusChamadoRepository.findAll();
        return statusChamados.stream()
                .map(statusChamado -> new StatusChamadoDTO(statusChamado.getStatusId(), statusChamado.getStatusNome(), statusChamado.getDescricao()))
                .toList();
    }

    public StatusChamadoDTO buscarStatusChamadoPorId(Integer id) {
        Optional<StatusChamadoModel> statusChamadoModelOptional = statusChamadoRepository.findById(id);
        if (statusChamadoModelOptional.isPresent()) {
            StatusChamadoModel statusChamado = statusChamadoModelOptional.get();
            return new StatusChamadoDTO(statusChamado.getStatusId(), statusChamado.getStatusNome(), statusChamado.getDescricao());
        } else {
            throw new StatusChamadoNaoEncontradoException("Status Chamado não encontrado com o id: " + id);
        }
    }

    public StatusChamadoDTO atualizarStatusChamado(Integer id, StatusChamadoDTO statusChamadoDTO) {
        Optional<StatusChamadoModel> statusChamadoModelOptional = statusChamadoRepository.findById(id);
        if (statusChamadoModelOptional.isPresent()) {
            StatusChamadoModel statusChamado = statusChamadoModelOptional.get();
            statusChamado.setStatusNome(statusChamadoDTO.getStatusNome());
            statusChamado.setDescricao(statusChamadoDTO.getDescricao());

            StatusChamadoModel statusChamadoAtualizado = statusChamadoRepository.save(statusChamado);
            return new StatusChamadoDTO(statusChamadoAtualizado.getStatusId(), statusChamadoAtualizado.getStatusNome(), statusChamadoAtualizado.getDescricao());
        } else {
            throw new StatusChamadoNaoEncontradoException("Status Chamado não encontrado para atualização com o id: " + id);
        }
    }

    public void deletarStatusChamado(Integer id) {
        Optional<StatusChamadoModel> statusChamadoModelOptional = statusChamadoRepository.findById(id);
        if (statusChamadoModelOptional.isPresent()) {
            statusChamadoRepository.delete(statusChamadoModelOptional.get());
        } else {
            throw new StatusChamadoNaoEncontradoException("Status Chamado não encontrado para deletar com o id: " + id);
        }
    }
}
