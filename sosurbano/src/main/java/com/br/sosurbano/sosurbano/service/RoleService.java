package com.br.sosurbano.sosurbano.service;

import com.br.sosurbano.sosurbano.dto.role.RoleDTO;
import com.br.sosurbano.sosurbano.exception.RoleNaoEncontradaException;
import com.br.sosurbano.sosurbano.exception.RoleJaExistenteException;
import com.br.sosurbano.sosurbano.model.RoleModel;
import com.br.sosurbano.sosurbano.repository.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class RoleService {

    @Autowired
    private RoleRepository roleRepository;

    public List<RoleDTO> listarTodosRoles() {
        return roleRepository.findAll()
                .stream()
                .map(RoleDTO::new)
                .collect(Collectors.toList());
    }

    public Optional<RoleDTO> buscarPorId(Integer id) {
        Optional<RoleDTO> role = roleRepository.findById(id)
                .map(RoleDTO::new);

        if (role.isEmpty()) {
            throw new RoleNaoEncontradaException("Role não encontrada com o ID: " + id);
        }

        return role;
    }

    public RoleModel salvarRole(RoleModel role) {
        if (roleRepository.existsByDescricao(role.getDescricao())) {
            throw new RoleJaExistenteException("Role com a descrição já existe: " + role.getDescricao());
        }

        return roleRepository.save(role);
    }

    public Optional<RoleModel> atualizarRole(Integer id, RoleModel roleAtualizado) {
        Optional<RoleModel> role = roleRepository.findById(id);

        if (role.isEmpty()) {
            throw new RoleNaoEncontradaException("Role não encontrada para atualização com o ID: " + id);
        }

        role.get().setDescricao(roleAtualizado.getDescricao());
        return Optional.of(roleRepository.save(role.get()));
    }

    public void deletarRole(Integer id) {
        Optional<RoleModel> role = roleRepository.findById(id);

        if (role.isEmpty()) {
            throw new RoleNaoEncontradaException("Role não encontrada para exclusão com o ID: " + id);
        }

        roleRepository.deleteById(id);
    }
}
