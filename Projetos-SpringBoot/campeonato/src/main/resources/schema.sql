-- Campeonato Spring Boot - H2 Database Schema
-- Este arquivo define o esquema completo do banco de dados

-- Tabela de Endereços
CREATE TABLE tb_endereco (
    id BIGINT PRIMARY KEY AUTO_INCREMENT,
    logradouro VARCHAR(50) NOT NULL,
    numero INT NOT NULL,
    complemento VARCHAR(100) NOT NULL,
    bairro VARCHAR(50) NOT NULL,
    cidade VARCHAR(50) NOT NULL,
    estado VARCHAR(2) NOT NULL
);

-- Tabela de Estádios
CREATE TABLE tb_estadio (
    id BIGINT PRIMARY KEY AUTO_INCREMENT,
    nome VARCHAR(100) NOT NULL,
    endereco_id BIGINT NOT NULL UNIQUE,
    FOREIGN KEY (endereco_id) REFERENCES tb_endereco(id) ON DELETE CASCADE
);

-- Tabela de Campeonatos
CREATE TABLE tb_campeonato (
    id BIGINT PRIMARY KEY AUTO_INCREMENT,
    ano INT NOT NULL,
    nome_do_campeonato VARCHAR(100) NOT NULL
);

-- Tabela de Times/Jogadores
CREATE TABLE tb_time_jogadores (
    id BIGINT PRIMARY KEY AUTO_INCREMENT,
    nome VARCHAR(100) NOT NULL
);

-- Tabela de Jogadores
CREATE TABLE tb_jogador (
    id BIGINT PRIMARY KEY AUTO_INCREMENT,
    nome VARCHAR(100) NOT NULL,
    posicao VARCHAR(50),
    numero_camisa INT CHECK (numero_camisa >= 1 AND numero_camisa <= 99),
    nascimento DATE NOT NULL,
    genero CHAR(1),
    altura DOUBLE,
    time_id BIGINT NOT NULL,
    FOREIGN KEY (time_id) REFERENCES tb_time_jogadores(id) ON DELETE CASCADE
);

-- Tabela de Partidas
CREATE TABLE tb_partida (
    id BIGINT PRIMARY KEY AUTO_INCREMENT,
    data DATE NOT NULL,
    mandante VARCHAR(50) NOT NULL,
    visitante VARCHAR(50) NOT NULL,
    pontuacao_mandante INT,
    pontuacao_visitante INT,
    campeonato_id BIGINT,
    estadio_id BIGINT NOT NULL,
    FOREIGN KEY (campeonato_id) REFERENCES tb_campeonato(id) ON DELETE SET NULL,
    FOREIGN KEY (estadio_id) REFERENCES tb_estadio(id) ON DELETE CASCADE
);

-- Tabela de Associação Jogador-Partida (Many-to-Many)
CREATE TABLE jogador_partida (
    jogador_id BIGINT NOT NULL,
    partida_id BIGINT NOT NULL,
    PRIMARY KEY (jogador_id, partida_id),
    FOREIGN KEY (jogador_id) REFERENCES tb_jogador(id) ON DELETE CASCADE,
    FOREIGN KEY (partida_id) REFERENCES tb_partida(id) ON DELETE CASCADE
);

-- Índices para melhorar performance
CREATE INDEX idx_jogador_time ON tb_jogador(time_id);
CREATE INDEX idx_partida_campeonato ON tb_partida(campeonato_id);
CREATE INDEX idx_partida_estadio ON tb_partida(estadio_id);
CREATE INDEX idx_endereco_cidade ON tb_endereco(cidade);
CREATE INDEX idx_endereco_bairro ON tb_endereco(bairro);
CREATE INDEX idx_endereco_logradouro ON tb_endereco(logradouro);

