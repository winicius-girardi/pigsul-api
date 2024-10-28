CREATE DATABASE IF NOT EXISTS  aplicacao;
\c aplicacao
CREATE SCHEMA IF NOT EXISTS app_schema;
SET search_path to public,app_schema;

--SET search_path to app_schema;
-- caso psql tiver com formatacao  zoada
--\h
-- \pset format
-- \H
-- \x
-- \pset pager off


--CRIAR INDICES PARAS AS TABELAS EVENTUALMENTE?
CREATE TABLE IF NOT EXISTS app_schema.causa_morte(
    id_causa_morte INT GENERATED ALWAYS AS IDENTITY,
    causa TEXT NOT NULL,
    recomendacoes TEXT NULL,
    CONSTRAINT causa_morte_pk PRIMARY KEY (id_causa_morte)
);

CREATE TABLE IF NOT EXISTS app_schema.tipo_racao(
    id_tipo_racao INT GENERATED ALWAYS AS IDENTITY,
    tipo_racao VARCHAR(4) NOT NULL UNIQUE,
    CONSTRAINT id_tipo_racao_pk PRIMARY KEY (id_tipo_racao)

);

CREATE TABLE IF NOT EXISTS app_schema.usuario(
    id_usuario INT GENERATED ALWAYS AS IDENTITY UNIQUE,
    email VARCHAR(200) NOT NULL,
    nome VARCHAR(200) NOT NULL,
    senha VARCHAR(100) NOT NULL,
    CONSTRAINT email_pk PRIMARY KEY (email),
    CONSTRAINT tamanho_senha CHECK (char_length(senha)>=6)
);



CREATE TABLE IF NOT EXISTS app_schema.uf (
    id_uf INT GENERATED ALWAYS AS IDENTITY,
    sigla VARCHAR(2) NOT NULL,
    nome_uf TEXT NOT NULL,
    CONSTRAINT id_uf_pk PRIMARY KEY (id_uf)
);

CREATE TABLE IF NOT EXISTS app_schema.origem(
    id_origem INT GENERATED ALWAYS AS IDENTITY,
    nome_granja VARCHAR(150) NOT NULL,
    cidade_origem VARCHAR(150) NOT NULL,
    id_uf INT NOT NULL,
    CONSTRAINT id_uf_fk FOREIGN KEY (id_uf) REFERENCES uf(id_uf),
    CONSTRAINT id_origem_pk PRIMARY KEY(id_origem)
);

CREATE TABLE IF NOT EXISTS app_schema.lote(
    id_usuario INT,
    id_lote INT GENERATED ALWAYS AS IDENTITY,
    data_entrada_lote DATE NOT NULL,
    data_saida_lote DATE NULL,
    estado_lote BOOLEAN DEFAULT TRUE,-- talvez permitir ser nulo
    qtd_animais_alojados INTEGER NOT NULL,
    peso_medio_animais_entrada REAL NOT NULL,
    peso_medio_animais_saida REAL NULL,
    id_origem INT,
    observacoes TEXT NULL,
    quantidade_animais_saida INTEGER NULL, -- Pensando em retirar esse campo

    CONSTRAINT peso_saida_positivo CHECK(peso_medio_animais_saida > 0),
    CONSTRAINT peso_entrada_positivo CHECK(peso_medio_animais_entrada > 0),
    CONSTRAINT qtd_animais_positivo CHECK(qtd_animais_alojados > 0),
    CONSTRAINT id_lote_pk PRIMARY KEY (id_lote),
    CONSTRAINT id_origem_fk FOREIGN KEY (id_origem) REFERENCES origem(id_origem),
    CONSTRAINT id_usuario_fk FOREIGN KEY (id_usuario) REFERENCES usuario(id_usuario)

);


--esta com relacionamento nx1 com lote, talvez mudar de lote 1x1 pra controle obituario e nx1 com obituario
CREATE TABLE IF NOT EXISTS app_schema.obituario(
        id_lote INT,
        id_obituario INT GENERATED ALWAYS AS IDENTITY,
        id_causa_morte INT,
        quantidade_animais_mortos INTEGER NOT NULL,
        peso_medio_estimado REAL NOT NULL,

        CONSTRAINT peso_medio_estimado_check CHECK (peso_medio_estimado > 0.0),
        CONSTRAINT quantidade_animais_check CHECK (quantidade_animais_mortos > 0),
        CONSTRAINT id_obituario_pk PRIMARY KEY (id_obituario),
        CONSTRAINT id_lote_fk FOREIGN KEY (id_lote) REFERENCES lote(id_lote),
        CONSTRAINT id_causa_morte_fk FOREIGN KEY (id_causa_morte) REFERENCES causa_morte(id_causa_morte)
        
);

CREATE TABLE IF NOT EXISTS app_schema.carga_racao(
    id_carga_racao INT GENERATED ALWAYS AS IDENTITY,
    peso_carga REAL NOT NULL,
    data_entrada_carga DATE NOT NULL,
    data_emissao_nota DATE NOT NULL,
    num_nota_fiscal VARCHAR(44) NOT NULL,
    id_tipo_racao INT,
    id_lote INT,

    CONSTRAINT num_nota_fiscal_length CHECK (char_length(num_nota_fiscal)=44),
    CONSTRAINT peso_carga_check CHECK (peso_carga > 0.0),
    CONSTRAINT id_lote_fk FOREIGN KEY(id_lote) REFERENCES lote(id_lote),
    CONSTRAINT id_carga_racao_pk PRIMARY KEY (id_carga_racao),
    CONSTRAINT id_tipo_racao_fk FOREIGN KEY(id_tipo_racao) REFERENCES tipo_racao(id_tipo_racao)
);

CREATE TABLE IF NOT EXISTS app_schema.consumo_racao(
    id_consumo_racao INT GENERATED ALWAYS AS IDENTITY,
    id_carga_racao INT,
    data_consumo_inicio DATE NOT NULL,
    inicio_inteiro BOOLEAN NOT NULL,-- TRUE > CARGA FOI CONSUMIDA O DIA INTEIRO; FALSE > MEIO DIA DE CONSUMO APENAS
    data_consumo_termino DATE NULL,
    termino_inteiro BOOLEAN NULL, -- TRUE > CARGA FOI CONSUMIDA ATÉ O FINAL DO DIA ; FALSE > CONSUMO FOI ATÉ METADE DO DIA
    qtd_animais_vivos INTEGER NULL,

    CONSTRAINT qtd_animais_vivos_check CHECK (qtd_animais_vivos >0),
    CONSTRAINT id_carga_racao_fk FOREIGN KEY (id_carga_racao) REFERENCES carga_racao(id_carga_racao),
    CONSTRAINT id_consumo_racao_pk PRIMARY KEY (id_consumo_racao)
);


CREATE USER usuario_app WITH PASSWORD 'usuario_app';
GRANT USAGE ON SCHEMA app_schema TO usuario_app;
GRANT SELECT, INSERT, UPDATE, DELETE ON carga_racao, causa_morte, consumo_racao, lote, obituario, origem, tipo_racao, uf, usuario to usuario_app;
GRANT CONNECT ON DATABASE aplicacao to usuario_app;

GRANT SELECT ON ALL SEQUENCES IN SCHEMA app_schema TO usuario_app;
GRANT USAGE ON ALL SEQUENCES IN SCHEMA  app_schema TO usuario_app;
GRANT SELECT ON ALL TABLES IN SCHEMA app_schema TO usuario_app;
GRANT EXECUTE ON ALL FUNCTIONS IN SCHEMA app_schema TO usuario_app;



ALTER USER usuario_app WITH PASSWORD 'usuario_app';


--GRANT  SELECT, INSERT, UPDATE, DELETE IN ALL TABLES ON DATABASE 'aplicacao' TO usuario_app; --CONNECT,
--GRANT USAGE ON DATABASE aplicacao TO usuario_app;