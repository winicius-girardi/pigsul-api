CREATE USER Admin_App WITH PASSWORD 'Admin_App';
CREATE USER Usuario_App WITH PASSWORD 'Usuario_App'; 
CREATE SCHEMA IF NOT EXISTS Aplicacao AUTHORIZATION 'Admin_App';

--CRIAR INDICES PARAS AS TABELAS EVENTUALMENTE?

CREATE TABLE IF NOT EXISTS causa_morte(
    id_causa_morte SERIAL GENERATED ALWAYS AS IDENTITY,
    causa TEXT NOT NULL,
    recomendacoes TEXT NULL,
    CONSTRAINT id_causa_morte_pk PRIMARY KEY(id_causa_morte)
)

CREATE TABLE IF NOT EXISTS uf (
    id_uf SERIAL GENERATED ALWAYS AS IDENTITY,
    sigla VARCHAR(2) NOT NULL,
    nome_uf TEXT NOT NULL,
    CONSTRAINT id_uf_pk PRIMARY KEY (id_uf)
)

CREATE TABLE IF NOT EXISTS origem(
    id_origem SERIAL GENERATED ALWAYS AS IDENTITY,
    nome_granja TEXT NOT NULL,
    cidade TEXT NOT NULL,
    id_uf SERIAL NOT NULL,
    CONSTRAINT id_uf_fk FOREIGN KEY (id_uf) REFERENCES uf(id_uf),
    CONSTRAINT id_origem_pk PRIMARY KEY(id_origem)
)

CREATE TABLE IF NOT EXISTS tipo_racao(
    id_tipo_racao SERIAL GENERATED ALWAYS AS IDENTITY,
    tipo char(4) NOT NULL,
    CONSTRAINT id_tipo_racao_pk PRIMARY KEY (id_tipo_racao)

)
CREATE TABLE IF NOT EXISTS obituario(
        id_lote SERIAL,
        id_obituario SERIAL GENERATED ALWAYS AS IDENTITY,
        id_causa_morte SERIAL,
        quantidade_animais INTEGER NOT NULL,
        peso_medio_estimado REAL NOT NULL,
        CONSTRAINT id_registro_pk PRIMARY KEY(id_obituario)--,
        --CONSTRAINT id_lote_fk FOREIGN KEY (lote),
        CONSTRAINT id_causa_morte_fk FOREIGN KEY (id_causa_morte) REFERENCES causa_morte(id_causa_morte);
        
)

CREATE TABLE IF NOT EXISTS controle_racao(
    id_lote SERIAL,
    id_controle_racao SERIAL GENERATED ALWAYS AS IDENTITY,
    CONSTRAINT id_controle_racao_pk PRIMARY KEY (id_controle_racao),
    --CONSTRAINT id_lote_fk FOREIGN(id_lote) REFERENCES lote(id_lote)
)
CREATE TABLE IF NOT EXISTS carga_racao(
    id_carga_racao SERIAL GENERATED ALWAYS AS IDENTITY,
    peso_carga REAL NOT NULL,
    data_entrada DATE NOT NULL,
    data_saida DATE NULL,
    num_nota_fiscal TEXT NOT NULL,
    id_tipo_racao SERIAL,
    CONSTRAINT id_carga_racao_pk PRIMARY KEY (id_carga_racao),
    CONSTRAINT id_tipo_racao_fk FOREIGN KEY(id_tipo_racao) REFERENCES tipo_racao(id_tipo_racao),
)

CREATE TABLE IF NOT EXISTS consumo_racao(
    id_consumo_racao SERIAL GENERATED ALWAYS AS IDENTITY,
    id_carga_racao SERIAL,
    data_consumo_inicio DATE NOT NULL,
    data_consumo_termino DATE NULL,
    qtd_animais_vivos INTEGER NULL,
    CONSTRAINT id_carga_racao_fk FOREIGN KEY (id_carga_racao) REFERENCES carga_racao(id_carga_racao),
    CONSTRAINT id_consumo_racao_pk PRIMARY KEY (id_consumo_racao)
)

CREATE TABLE IF NOT EXISTS usuario(
    id_usuario SERIAL GENERATED ALWAYS AS IDENTITY,
    email TEXT NOT NULL,
    nome TEXT NOT NULL,
    senha TEXT NOT NULL,
    CONSTRAINT id_usuario_pk PRIMARY KEY (id_usuario),
    CONSTRAINT email_pk PRIMARY KEY (email)
)


CREATE TABLE IF NOT EXISTS lote(
    id_usuario SERIAL,
    id_lote SERIAL GENERATED ALWAYS AS IDENTITY,
    data_entrada_lote DATE NOT NULL,
    data_saida_lote DATE NULL,
    ativo BOOLEAN NOT NULL,-- talvez permitir ser nulo
    qtd_animais_alojados INTEGER NOT NULL,
    peso_medio_animais_entrada REAL NOT NULL,
    peso_medio_animais_saida REAL NULL,
    id_origem SERIAL,
    observacoes TEXT NULL,
    qtd_animais_saida INTEGER NULL, -- Pensando em retirar esse campo
    
    CONSTRAINT id_lote_pk PRIMARY KEY (id_lote),
    CONSTRAINT id_origem_fk FOREIGN KEY (id_origem) REFERENCES origem(id_origem),
    CONSTRAINT id_usuario_fk FOREIGN KEY (id_usuario) REFERENCES usuario(id_usuario)

)
