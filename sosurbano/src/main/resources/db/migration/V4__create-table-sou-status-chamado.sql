CREATE SEQUENCE seq_status_chamado START WITH 1 INCREMENT BY 1;

CREATE TABLE sou_status_chamado (
    status_id INT PRIMARY KEY,
    status_nome VARCHAR2(50) NOT NULL, -- Ex: "aberto", "em andamento", "finalizado"
    descricao CLOB
);
