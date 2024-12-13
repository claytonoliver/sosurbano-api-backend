CREATE SEQUENCE seq_chamados START WITH 1 INCREMENT BY 1;

CREATE TABLE sou_chamado (
    chamado_id INT PRIMARY KEY,
    usuario_id INT NOT NULL,
    status_id INT NOT NULL,
    data_chamado TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    descricao CLOB,
    latitude NUMBER(9, 6),
    longitude NUMBER(9, 6),
    FOREIGN KEY (status_id) REFERENCES sou_status_chamado(status_id)
);
