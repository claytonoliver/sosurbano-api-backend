CREATE SEQUENCE seq_usuarios START WITH 1 INCREMENT BY 1;

-- Criar tabela sou_usuario com FK para a tabela genero
CREATE TABLE sou_usuario (
    usuario_id INT PRIMARY KEY,
    nome VARCHAR2(100) NOT NULL,
    email VARCHAR2(100) UNIQUE,
    telefone VARCHAR2(15),
    data_nascimento DATE,
    senha VARCHAR2(100),
    genero_id INT,
    CPF VARCHAR2(20),
    role_id INT,
    CONSTRAINT fk_genero FOREIGN KEY (genero_id) REFERENCES sou_genero (genero_id),
    CONSTRAINT fk_role FOREIGN KEY (role_id) REFERENCES sou_role (role_id)
);