package com.br.sosurbano.sosurbano.service;

import com.br.sosurbano.sosurbano.dto.usuario.UsuarioCadastroDTO;
import com.br.sosurbano.sosurbano.dto.usuario.UsuarioExibicaoDTO;
import com.br.sosurbano.sosurbano.model.UsuarioModel;
import com.br.sosurbano.sosurbano.repository.UsuarioRepository;
import jakarta.validation.Valid;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository;
    private Optional<UsuarioModel> usuarioModelOptional;

    public UsuarioExibicaoDTO salvarUsuario(@Valid UsuarioCadastroDTO usuarioCadastroDTO) {

        String senhaCriptografada = new BCryptPasswordEncoder().encode(usuarioCadastroDTO.senha());

        UsuarioModel usuarioModel = new UsuarioModel();
        BeanUtils.copyProperties(usuarioCadastroDTO, usuarioModel);
        usuarioModel.setSenha(senhaCriptografada);

        UsuarioModel usuarioSalvo = usuarioRepository.save(usuarioModel);
        return new UsuarioExibicaoDTO(usuarioSalvo);
    }


    public Page<UsuarioExibicaoDTO> listarTodosUsuarios(Pageable pagina) {
        return usuarioRepository
                .findAll(pagina)
                .map(UsuarioExibicaoDTO::new); // converte cada Usuario para UsuarioExibicaoDTO
    }

    public UsuarioExibicaoDTO buscarUsuarioPorId(long id) {
        usuarioModelOptional = usuarioRepository.findById(id);

        if(usuarioModelOptional.isPresent()){
            return new UsuarioExibicaoDTO(usuarioModelOptional.get());
        }else{
            throw new RuntimeException("Usuário não existe");
        }
    }

    public UsuarioExibicaoDTO updateUsuario(long id, UsuarioCadastroDTO usuarioAtualizadoDTO) {
        usuarioModelOptional = usuarioRepository.findById(id);

        if (usuarioModelOptional.isPresent()) {
            UsuarioModel usuarioModel = new UsuarioModel();
            BeanUtils.copyProperties(usuarioAtualizadoDTO, usuarioModel);

            UsuarioModel usuarioAtualizado = usuarioRepository.save(usuarioModel);

            return new UsuarioExibicaoDTO(usuarioAtualizado);
        } else {
            throw new RuntimeException("Usuário não existe");
        }
    }

    public void deleteUsuario(Long id) {
        Optional<UsuarioModel> usuarioModelOptional = usuarioRepository.findById(id);

        if (usuarioModelOptional.isPresent()) {
            usuarioRepository.deleteById(id);
        } else {
            throw new RuntimeException("Usuário não existe");
        }
    }

}
