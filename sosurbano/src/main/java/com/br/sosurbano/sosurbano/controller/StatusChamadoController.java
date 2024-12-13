package com.br.sosurbano.sosurbano.controller;


import com.br.sosurbano.sosurbano.dto.StatusChamadoDTO;
import com.br.sosurbano.sosurbano.service.StatusChamadoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/status-chamado")
public class StatusChamadoController {

    @Autowired
    private StatusChamadoService statusChamadoService;


    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public StatusChamadoDTO salvarStatusChamado(@RequestBody StatusChamadoDTO statusChamadoDTO) {
        return statusChamadoService.salvarStatusChamado(statusChamadoDTO);
    }


    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<StatusChamadoDTO> listarStatusChamados() {
        return statusChamadoService.listarTodosStatusChamados();
    }


    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public StatusChamadoDTO buscarStatusChamadoPorId(@PathVariable Integer id) {
        return statusChamadoService.buscarStatusChamadoPorId(id);
    }


    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public StatusChamadoDTO atualizarStatusChamado(@PathVariable Integer id, @RequestBody StatusChamadoDTO statusChamadoDTO) {
        return statusChamadoService.atualizarStatusChamado(id, statusChamadoDTO);
    }


    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deletarStatusChamado(@PathVariable Integer id) {
        statusChamadoService.deletarStatusChamado(id);
    }
}
