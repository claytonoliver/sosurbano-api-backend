package com.br.sosurbano.sosurbano.controller;

import com.br.sosurbano.sosurbano.dto.chamado.ChamadoExibicaoDTO;
import com.br.sosurbano.sosurbano.model.ChamadoModel;
import com.br.sosurbano.sosurbano.service.ChamadoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/api/chamados")
public class ChamadoController {

    @Autowired
    private ChamadoService chamadoService;

    @GetMapping
    public Page<ChamadoExibicaoDTO> listarChamados(Pageable pageable) {
        return chamadoService.listarTodosChamados(pageable);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ChamadoExibicaoDTO> buscarChamadoPorId(@PathVariable Integer id) {
        Optional<ChamadoExibicaoDTO> chamado = chamadoService.buscarPorId(id);
        return chamado.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<ChamadoModel> criarChamado(@RequestBody ChamadoModel chamado) {
        ChamadoModel chamadoSalvo = chamadoService.salvarChamado(chamado);
        return ResponseEntity.status(HttpStatus.CREATED).body(chamadoSalvo);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ChamadoModel> atualizarChamado(@PathVariable Integer id, @RequestBody ChamadoModel chamadoAtualizado) {
        Optional<ChamadoModel> chamado = chamadoService.atualizarChamado(id, chamadoAtualizado);
        return chamado.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deletarChamado(@PathVariable Integer id) {
        chamadoService.deletarChamado(id);
    }
}