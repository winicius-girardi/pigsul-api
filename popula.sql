\c aplicacao

INSERT INTO app_schema.causa_morte (causa, recomendacoes)
VALUES
    ('Doença Respiratória', 'Isolar os animais infectados e aplicar medicação'),
    ('Encefalite','Isolar animal e medicar com x,y,z'),
    ('Fatores ambientais','Ajustar tempetura e ventilação do ambiente'),
    ('Briga','Separar animais, colocar objetos para distração');

INSERT INTO app_schema.tipo_racao (tipo_racao)
VALUES
    ('RSCA'),
    ('RSC1'),
    ('RSC2'),
    ('RSC3'),
    ('RST1'),
    ('RST2'),
    ('RST3');

INSERT INTO app_schema.usuario (email,nome,senha)
VALUES
    ('teste@teste','cleber','kdoaskdoadko'),
    ('carlinhos@teste','jao','cavalo'),
    ('cavalo@teste','charopinho','elegosta'),
    ('aaaaaa@teste','ronnie coleman','aaaaaaaa'),
    ('buthenol@teste','el nasser sonbaty','pareee');

INSERT INTO app_schema.uf (nome_uf,sigla)
VALUES
        ('Amazonas', 'AM'),
        ('Alagoas', 'AL'),
        ('Acre', 'AC'),
        ('Amapá', 'AP'),
        ('Bahia', 'BA'),
        ('Pará', 'PA'),
        ('Mato Grosso', 'MT'),
        ('Minas Gerais', 'MG'),
        ('Mato Grosso do Sul', 'MS'),
        ('Goiás', 'GO'),
        ('Maranhão', 'MA'),
        ('Rio Grande do Sul', 'RS'),
        ('Tocantins', 'TO'),
        ('Piauí', 'PI'),
        ('São Paulo', 'SP'),
        ('Rondônia', 'RO'),
        ('Roraima', 'RR'),
        ('Paraná', 'PR'),
        ('Ceará', 'CE'),
        ('Pernambuco', 'PE'),
        ('Santa Catarina', 'SC'),
        ('Paraíba', 'PB'),
        ('Rio Grande do Norte', 'RN'),
        ('Espírito Santo', 'ES'),
        ('Rio de Janeiro', 'RJ'),
        ('Sergipe', 'SE'),
        ('Distrito Federal','DF');

INSERT INTO app_schema.origem (nome_granja,cidade_origem,id_uf)
VALUES
    ('cavalo','Paial',1),
    ('cavalo1','Xaxim',2),
    ('cavalo2','Pinhalzinho',20),
    ('cavalo4','Arvoredo',4),
    ('cavalo10','Concordia',8);

INSERT INTO app_schema.lote(id_usuario,data_entrada_lote,qtd_animais_alojados,
    peso_medio_animais_entrada,id_origem)
VALUES
    (1,'2020-02-28',1000,28.6,2),
    (3,'2019-06-03',5000,30.84,1),
    (3,'2012-01-13',500,20.84,4),
    (2,'2017-12-25',2500,26.42,3);

INSERT INTO app_schema.obituario (id_lote,id_causa_morte,quantidade_animais_mortos,
    peso_medio_estimado)
VALUES
    (1,2,3,60.51),
    (1,3,1,40.52),
    (2,1,2,20),
    (1,3,4,100),
    (3,4,2,80),
    (3,1,5,120);

INSERT INTO app_schema.carga_racao (peso_carga,data_entrada_carga,data_emissao_nota,num_nota_fiscal,
    id_tipo_racao,id_lote)
VALUES
    (17000.80,'2022-01-20','2022-01-19','20502050250011239120391031123912039103112391',1,1),
    (11054.12,'2022-02-08','2022-02-07','12391203910311239120391031123912039103112391',2,1),
    (16040.20,'2021-10-10','2022-01-10','50205020502015020502050201502050205020150205',5,2),
    (12012.91,'2012-06-16','2012-06-16','12313123312311231312331231123131233123112313',3,3);

INSERT INTO app_schema.consumo_racao (id_carga_racao,data_consumo_inicio,inicio_inteiro)
VALUES
    (1,'2022-10-02',TRUE),
    (2,'2020-10-01',FALSE),
    (3,'2023-11-30',TRUE),
    (4,'2024-12-02',FALSE);


