package com.br.sosurbano.sosurbano.exception;

public class RoleJaExistenteException extends RuntimeException {

    public RoleJaExistenteException(String mensagem) {
        super(mensagem);
    }

}