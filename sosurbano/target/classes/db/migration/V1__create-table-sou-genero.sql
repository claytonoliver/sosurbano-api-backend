CREATE SEQUENCE seq_genero START WITH 1 INCREMENT BY 1;

-- Criar tabela genero
CREATE TABLE sou_genero (
genero_id INT PRIMARY KEY,
descricao VARCHAR2(10) NOT NULL
);

INSERT INTO sou_genero (genero_id, descricao) VALUES (seq_genero.NEXTVAL, 'Masculino');
INSERT INTO sou_genero (genero_id, descricao) VALUES (seq_genero.NEXTVAL, 'Feminino');
INSERT INTO sou_genero (genero_id, descricao) VALUES (seq_genero.NEXTVAL, 'Outro');