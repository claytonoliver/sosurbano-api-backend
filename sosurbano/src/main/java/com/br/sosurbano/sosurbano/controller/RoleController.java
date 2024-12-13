package com.br.sosurbano.sosurbano.controller;

import com.br.sosurbano.sosurbano.dto.role.RoleDTO;
import com.br.sosurbano.sosurbano.model.RoleModel;
import com.br.sosurbano.sosurbano.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/roles")
public class RoleController {

    @Autowired
    private RoleService roleService;

    @GetMapping
    public List<RoleDTO> listarRoles() {
        return roleService.listarTodosRoles();
    }

    @GetMapping("/{id}")
    public ResponseEntity<RoleDTO> buscarRolePorId(@PathVariable Integer id) {
        Optional<RoleDTO> role = roleService.buscarPorId(id);
        return role.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<RoleModel> criarRole(@RequestBody RoleModel role) {
        RoleModel roleSalvo = roleService.salvarRole(role);
        return ResponseEntity.status(HttpStatus.CREATED).body(roleSalvo);
    }

    @PutMapping("/{id}")
    public ResponseEntity<RoleModel> atualizarRole(@PathVariable Integer id, @RequestBody RoleModel roleAtualizado) {
        Optional<RoleModel> role = roleService.atualizarRole(id, roleAtualizado);
        return role.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deletarRole(@PathVariable Integer id) {
        roleService.deletarRole(id);
    }
}
