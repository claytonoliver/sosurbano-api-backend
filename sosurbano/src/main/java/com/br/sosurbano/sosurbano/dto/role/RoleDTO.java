package com.br.sosurbano.sosurbano.dto.role;

import com.br.sosurbano.sosurbano.model.RoleModel;
import lombok.Getter;

@Getter
public class RoleDTO {

    private Integer roleId;
    private String descricao;

    public RoleDTO(RoleModel roleModel) {
        this.roleId = roleModel.getRoleId();
        this.descricao = roleModel.getDescricao();
    }
}
