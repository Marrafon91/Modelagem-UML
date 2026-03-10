-- Endereços
INSERT INTO tb_endereco(logradouro, numero, complemento, bairro, cidade, estado) VALUES ('Avenida Maracanã', 1000, 'Setor Norte', 'Maracanã', 'Rio de Janeiro', 'RJ');
INSERT INTO tb_endereco(logradouro, numero, complemento, bairro, cidade, estado) VALUES ('Avenida Machado', 1910, 'Esquina com Rua São Francisco Xavier', 'Santo André', 'São Paulo', 'SP');

-- Estádios
INSERT INTO tb_estadio(nome, endereco_id) VALUES ('Maracanã', 1);
INSERT INTO tb_estadio(nome, endereco_id) VALUES ('Estádio do Pacaembu', 2);

-- Campeonato
INSERT INTO tb_campeonato(ano, nome_do_campeonato) VALUES (2017, 'Copa de Handebol');

--Times
INSERT INTO tb_time_jogadores(nome) VALUES ('CORINTHIANS');
INSERT INTO tb_time_jogadores(nome) VALUES ('PALMEIRAS');
INSERT INTO tb_time_jogadores(nome) VALUES ('FLUMINENSE');
INSERT INTO tb_time_jogadores(nome) VALUES ('FLAMENGO');

 -- Jogadores
INSERT INTO tb_jogador(nome, posicao, numero_camisa, nascimento, genero, altura, time_id) VALUES ('João da Silva', 'Atacante', 9, '1990-07-11', 'M', 1.81, 1);
INSERT INTO tb_jogador(nome, posicao, numero_camisa, nascimento, genero, altura, time_id) VALUES ('Marco Tulio', 'Zagueiro', 4, '1989-03-21', 'M', 1.74, 1);
INSERT INTO tb_jogador(nome, posicao, numero_camisa, nascimento, genero, altura, time_id) VALUES ('Gustavo Mendes', 'Atacante', 10, '1991-03-12', 'M', 1.73, 2);
INSERT INTO tb_jogador(nome, posicao, numero_camisa, nascimento, genero, altura, time_id) VALUES ('Carlos Teles', 'Zagueiro', 2, '1987-08-14', 'M', 1.86, 2);

-- Partidas
INSERT INTO tb_partida(data, mandante, visitante, pontuacao_mandante, pontuacao_visitante, campeonato_id, estadio_id) VALUES ('2017-08-20', 'CORINTHIANS', 'PALMEIRAS', 10, 7, 1, 1);
INSERT INTO tb_partida(data, mandante, visitante, pontuacao_mandante, pontuacao_visitante, campeonato_id, estadio_id) VALUES ('2017-08-21', 'FLUMINENSE', 'FLAMENGO', 9, 13, 1, 2);

-- Relação jogador x partida
INSERT INTO jogador_partida(jogador_id, partida_id) VALUES (1, 1);
INSERT INTO jogador_partida(jogador_id, partida_id) VALUES (2, 1);
INSERT INTO jogador_partida(jogador_id, partida_id) VALUES (3, 1);
INSERT INTO jogador_partida(jogador_id, partida_id) VALUES (4, 1);
INSERT INTO jogador_partida(jogador_id, partida_id) VALUES (1, 2);
INSERT INTO jogador_partida(jogador_id, partida_id) VALUES (2, 2);