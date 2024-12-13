CREATE SEQUENCE role_seq
START WITH 1
INCREMENT BY 1
NOCACHE
NOCYCLE;

-- Criação da tabela sou_role
CREATE TABLE sou_role (
 role_id INT PRIMARY KEY,
 descricao VARCHAR2(100) NOT NULL
);

INSERT INTO sou_role (role_id, descricao) VALUES (role_seq.NEXTVAL, 'Admin');
INSERT INTO sou_role (role_id, descricao) VALUES (role_seq.NEXTVAL, 'User');