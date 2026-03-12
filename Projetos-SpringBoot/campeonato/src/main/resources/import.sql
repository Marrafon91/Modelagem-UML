-- Endereços
INSERT INTO tb_endereco(logradouro, numero, complemento, bairro, cidade, estado) VALUES ('Avenida Maracanã', 1000, 'Setor Norte', 'Maracanã', 'Rio de Janeiro', 'RJ');
INSERT INTO tb_endereco(logradouro, numero, complemento, bairro, cidade, estado) VALUES ('Avenida Machado', 1910, 'Esquina com Rua São Francisco Xavier', 'Santo André', 'São Paulo', 'SP');
INSERT INTO tb_endereco(logradouro, numero, complemento, bairro, cidade, estado) VALUES ('Avenida Paulista', 2000, 'Próximo ao Shopping Center', 'Bela Vista', 'São Paulo', 'SP');
INSERT INTO tb_endereco(logradouro, numero, complemento, bairro, cidade, estado) VALUES ('Rua Padre Miguel', 3500, 'Zona Oeste', 'Jacarepaguá', 'Rio de Janeiro', 'RJ');

-- Estádios
INSERT INTO tb_estadio(nome, endereco_id) VALUES ('Maracanã', 1);
INSERT INTO tb_estadio(nome, endereco_id) VALUES ('Estádio do Pacaembu', 2);
INSERT INTO tb_estadio(nome, endereco_id) VALUES ('Ginásio do Ibirapuera', 3);
INSERT INTO tb_estadio(nome, endereco_id) VALUES ('Ginásio da Juventude', 4);

-- Campeonato
INSERT INTO tb_campeonato(ano, nome_do_campeonato) VALUES (2024, 'Campeonato Brasileiro de Handebol');

-- Times (9 times da enum)
INSERT INTO tb_time_jogadores(nome) VALUES ('CORINTHIANS');
INSERT INTO tb_time_jogadores(nome) VALUES ('PALMEIRAS');
INSERT INTO tb_time_jogadores(nome) VALUES ('SANTOS');
INSERT INTO tb_time_jogadores(nome) VALUES ('SAO_PAULO');
INSERT INTO tb_time_jogadores(nome) VALUES ('FLAMENGO');
INSERT INTO tb_time_jogadores(nome) VALUES ('VASCO');
INSERT INTO tb_time_jogadores(nome) VALUES ('BOTAFOGO');
INSERT INTO tb_time_jogadores(nome) VALUES ('FLUMINENSE');
INSERT INTO tb_time_jogadores(nome) VALUES ('GREMIO');

-- Jogadores Corinthians (6 jogadores - IDs 1-6)
INSERT INTO tb_jogador(nome, posicao, numero_camisa, nascimento, genero, altura, time_id) VALUES ('João Silva', 'Pivô', 1, '1995-03-15', 'M', 1.95, 1);
INSERT INTO tb_jogador(nome, posicao, numero_camisa, nascimento, genero, altura, time_id) VALUES ('Carlos Santos', 'Ala Direita', 7, '1994-06-22', 'M', 1.88, 1);
INSERT INTO tb_jogador(nome, posicao, numero_camisa, nascimento, genero, altura, time_id) VALUES ('Lucas Oliveira', 'Ala Esquerda', 11, '1996-01-10', 'M', 1.85, 1);
INSERT INTO tb_jogador(nome, posicao, numero_camisa, nascimento, genero, altura, time_id) VALUES ('Felipe Costa', 'Goleiro', 25, '1993-08-05', 'M', 1.92, 1);
INSERT INTO tb_jogador(nome, posicao, numero_camisa, nascimento, genero, altura, time_id) VALUES ('Rafael Alves', 'Lateral Direito', 3, '1997-11-20', 'M', 1.80, 1);
INSERT INTO tb_jogador(nome, posicao, numero_camisa, nascimento, genero, altura, time_id) VALUES ('Mateus Pereira', 'Lateral Esquerdo', 5, '1995-05-12', 'M', 1.82, 1);

-- Jogadores Palmeiras (6 jogadores - IDs 7-12)
INSERT INTO tb_jogador(nome, posicao, numero_camisa, nascimento, genero, altura, time_id) VALUES ('Bruno Ferreira', 'Pivô', 9, '1994-09-18', 'M', 1.97, 2);
INSERT INTO tb_jogador(nome, posicao, numero_camisa, nascimento, genero, altura, time_id) VALUES ('Anderson Lima', 'Ala Direita', 8, '1993-04-25', 'M', 1.86, 2);
INSERT INTO tb_jogador(nome, posicao, numero_camisa, nascimento, genero, altura, time_id) VALUES ('Diego Marques', 'Ala Esquerda', 12, '1996-07-30', 'M', 1.84, 2);
INSERT INTO tb_jogador(nome, posicao, numero_camisa, nascimento, genero, altura, time_id) VALUES ('Henrique Rocha', 'Goleiro', 30, '1992-02-14', 'M', 1.91, 2);
INSERT INTO tb_jogador(nome, posicao, numero_camisa, nascimento, genero, altura, time_id) VALUES ('Thiago Gomes', 'Lateral Direito', 4, '1997-10-08', 'M', 1.79, 2);
INSERT INTO tb_jogador(nome, posicao, numero_camisa, nascimento, genero, altura, time_id) VALUES ('Victor Rodrigues', 'Lateral Esquerdo', 6, '1995-12-03', 'M', 1.81, 2);

-- Jogadores Santos (6 jogadores - IDs 13-18)
INSERT INTO tb_jogador(nome, posicao, numero_camisa, nascimento, genero, altura, time_id) VALUES ('Ricardo Barbosa', 'Pivô', 10, '1994-05-11', 'M', 1.96, 3);
INSERT INTO tb_jogador(nome, posicao, numero_camisa, nascimento, genero, altura, time_id) VALUES ('Evandro Silva', 'Ala Direita', 13, '1993-11-27', 'M', 1.87, 3);
INSERT INTO tb_jogador(nome, posicao, numero_camisa, nascimento, genero, altura, time_id) VALUES ('Marcelo Almeida', 'Ala Esquerda', 15, '1996-03-19', 'M', 1.85, 3);
INSERT INTO tb_jogador(nome, posicao, numero_camisa, nascimento, genero, altura, time_id) VALUES ('Antonio Costa', 'Goleiro', 31, '1992-09-06', 'M', 1.93, 3);
INSERT INTO tb_jogador(nome, posicao, numero_camisa, nascimento, genero, altura, time_id) VALUES ('Roberto Souza', 'Lateral Direito', 2, '1997-01-14', 'M', 1.78, 3);
INSERT INTO tb_jogador(nome, posicao, numero_camisa, nascimento, genero, altura, time_id) VALUES ('Patrick Santos', 'Lateral Esquerdo', 14, '1995-08-22', 'M', 1.83, 3);

-- Jogadores São Paulo (6 jogadores - IDs 19-24)
INSERT INTO tb_jogador(nome, posicao, numero_camisa, nascimento, genero, altura, time_id) VALUES ('Fernando Teixeira', 'Pivô', 20, '1994-07-05', 'M', 1.98, 4);
INSERT INTO tb_jogador(nome, posicao, numero_camisa, nascimento, genero, altura, time_id) VALUES ('Gustavo Martins', 'Ala Direita', 16, '1993-12-13', 'M', 1.88, 4);
INSERT INTO tb_jogador(nome, posicao, numero_camisa, nascimento, genero, altura, time_id) VALUES ('Leonardo Mendes', 'Ala Esquerda', 18, '1996-02-28', 'M', 1.86, 4);
INSERT INTO tb_jogador(nome, posicao, numero_camisa, nascimento, genero, altura, time_id) VALUES ('Paulo Gomes', 'Goleiro', 32, '1991-10-19', 'M', 1.94, 4);
INSERT INTO tb_jogador(nome, posicao, numero_camisa, nascimento, genero, altura, time_id) VALUES ('Sergio Oliveira', 'Lateral Direito', 19, '1997-04-11', 'M', 1.80, 4);
INSERT INTO tb_jogador(nome, posicao, numero_camisa, nascimento, genero, altura, time_id) VALUES ('Wagner Santos', 'Lateral Esquerdo', 21, '1995-09-06', 'M', 1.84, 4);

-- Jogadores Flamengo (6 jogadores - IDs 25-30)
INSERT INTO tb_jogador(nome, posicao, numero_camisa, nascimento, genero, altura, time_id) VALUES ('Marco Tulio', 'Pivô', 17, '1989-03-21', 'M', 1.99, 5);
INSERT INTO tb_jogador(nome, posicao, numero_camisa, nascimento, genero, altura, time_id) VALUES ('Felipe Ferreira', 'Ala Direita', 22, '1994-01-09', 'M', 1.87, 5);
INSERT INTO tb_jogador(nome, posicao, numero_camisa, nascimento, genero, altura, time_id) VALUES ('Jorge Souza', 'Ala Esquerda', 24, '1996-05-17', 'M', 1.85, 5);
INSERT INTO tb_jogador(nome, posicao, numero_camisa, nascimento, genero, altura, time_id) VALUES ('Flavio Ribeiro', 'Goleiro', 33, '1992-06-30', 'M', 1.92, 5);
INSERT INTO tb_jogador(nome, posicao, numero_camisa, nascimento, genero, altura, time_id) VALUES ('Cláudio Lima', 'Lateral Direito', 23, '1997-08-15', 'M', 1.79, 5);
INSERT INTO tb_jogador(nome, posicao, numero_camisa, nascimento, genero, altura, time_id) VALUES ('Roney Gomes', 'Lateral Esquerdo', 26, '1995-11-02', 'M', 1.82, 5);

-- Jogadores Vasco (6 jogadores - IDs 31-36)
INSERT INTO tb_jogador(nome, posicao, numero_camisa, nascimento, genero, altura, time_id) VALUES ('Ronaldo Silva', 'Pivô', 27, '1993-08-14', 'M', 1.96, 6);
INSERT INTO tb_jogador(nome, posicao, numero_camisa, nascimento, genero, altura, time_id) VALUES ('Sérgio Neves', 'Ala Direita', 28, '1994-10-23', 'M', 1.86, 6);
INSERT INTO tb_jogador(nome, posicao, numero_camisa, nascimento, genero, altura, time_id) VALUES ('Marcio Barros', 'Ala Esquerda', 29, '1996-04-08', 'M', 1.84, 6);
INSERT INTO tb_jogador(nome, posicao, numero_camisa, nascimento, genero, altura, time_id) VALUES ('Tiago Monteiro', 'Goleiro', 34, '1992-11-25', 'M', 1.90, 6);
INSERT INTO tb_jogador(nome, posicao, numero_camisa, nascimento, genero, altura, time_id) VALUES ('Leandro Costa', 'Lateral Direito', 35, '1997-06-12', 'M', 1.77, 6);
INSERT INTO tb_jogador(nome, posicao, numero_camisa, nascimento, genero, altura, time_id) VALUES ('Fabio Nunes', 'Lateral Esquerdo', 36, '1995-02-19', 'M', 1.81, 6);

-- Jogadores Botafogo (6 jogadores - IDs 37-42)
INSERT INTO tb_jogador(nome, posicao, numero_camisa, nascimento, genero, altura, time_id) VALUES ('Alan Pereira', 'Pivô', 37, '1993-12-07', 'M', 1.97, 7);
INSERT INTO tb_jogador(nome, posicao, numero_camisa, nascimento, genero, altura, time_id) VALUES ('Danilo Sousa', 'Ala Direita', 38, '1994-08-19', 'M', 1.88, 7);
INSERT INTO tb_jogador(nome, posicao, numero_camisa, nascimento, genero, altura, time_id) VALUES ('Ricardo Costa', 'Ala Esquerda', 39, '1996-06-25', 'M', 1.86, 7);
INSERT INTO tb_jogador(nome, posicao, numero_camisa, nascimento, genero, altura, time_id) VALUES ('Julio Oliveira', 'Goleiro', 40, '1991-03-30', 'M', 1.91, 7);
INSERT INTO tb_jogador(nome, posicao, numero_camisa, nascimento, genero, altura, time_id) VALUES ('Emerson Silva', 'Lateral Direito', 41, '1997-09-22', 'M', 1.81, 7);
INSERT INTO tb_jogador(nome, posicao, numero_camisa, nascimento, genero, altura, time_id) VALUES ('Willian Santos', 'Lateral Esquerdo', 42, '1995-04-10', 'M', 1.83, 7);

-- Jogadores Fluminense (6 jogadores - IDs 43-48)
INSERT INTO tb_jogador(nome, posicao, numero_camisa, nascimento, genero, altura, time_id) VALUES ('Gustavo Mendes', 'Pivô', 43, '1991-03-12', 'M', 1.95, 8);
INSERT INTO tb_jogador(nome, posicao, numero_camisa, nascimento, genero, altura, time_id) VALUES ('Milton Gomes', 'Ala Direita', 44, '1994-05-14', 'M', 1.87, 8);
INSERT INTO tb_jogador(nome, posicao, numero_camisa, nascimento, genero, altura, time_id) VALUES ('Nilson Rocha', 'Ala Esquerda', 45, '1996-09-21', 'M', 1.85, 8);
INSERT INTO tb_jogador(nome, posicao, numero_camisa, nascimento, genero, altura, time_id) VALUES ('Oswaldo Mendes', 'Goleiro', 46, '1990-07-11', 'M', 1.93, 8);
INSERT INTO tb_jogador(nome, posicao, numero_camisa, nascimento, genero, altura, time_id) VALUES ('Pedro Vieira', 'Lateral Direito', 47, '1997-02-05', 'M', 1.80, 8);
INSERT INTO tb_jogador(nome, posicao, numero_camisa, nascimento, genero, altura, time_id) VALUES ('Quintin Barbosa', 'Lateral Esquerdo', 48, '1995-10-16', 'M', 1.82, 8);

-- Jogadores Gremio (6 jogadores - IDs 49-54)
INSERT INTO tb_jogador(nome, posicao, numero_camisa, nascimento, genero, altura, time_id) VALUES ('Carlos Teles', 'Pivô', 50, '1987-08-14', 'M', 1.98, 9);
INSERT INTO tb_jogador(nome, posicao, numero_camisa, nascimento, genero, altura, time_id) VALUES ('Renan Pereira', 'Ala Direita', 51, '1994-02-28', 'M', 1.89, 9);
INSERT INTO tb_jogador(nome, posicao, numero_camisa, nascimento, genero, altura, time_id) VALUES ('Saulo Mendes', 'Ala Esquerda', 52, '1996-08-11', 'M', 1.87, 9);
INSERT INTO tb_jogador(nome, posicao, numero_camisa, nascimento, genero, altura, time_id) VALUES ('Tarciso Alves', 'Goleiro', 53, '1991-05-22', 'M', 1.94, 9);
INSERT INTO tb_jogador(nome, posicao, numero_camisa, nascimento, genero, altura, time_id) VALUES ('Ulisses Costa', 'Lateral Direito', 54, '1997-07-30', 'M', 1.81, 9);
INSERT INTO tb_jogador(nome, posicao, numero_camisa, nascimento, genero, altura, time_id) VALUES ('Vinicius Santos', 'Lateral Esquerdo', 55, '1995-01-25', 'M', 1.84, 9);

-- Partidas do Campeonato (6 partidas)
INSERT INTO tb_partida(data, mandante, visitante, pontuacao_mandante, pontuacao_visitante, campeonato_id, estadio_id) VALUES ('2024-03-01', 'CORINTHIANS', 'PALMEIRAS', 28, 25, 1, 1);
INSERT INTO tb_partida(data, mandante, visitante, pontuacao_mandante, pontuacao_visitante, campeonato_id, estadio_id) VALUES ('2024-03-02', 'SANTOS', 'SAO_PAULO', 31, 29, 1, 2);
INSERT INTO tb_partida(data, mandante, visitante, pontuacao_mandante, pontuacao_visitante, campeonato_id, estadio_id) VALUES ('2024-03-03', 'FLAMENGO', 'VASCO', 35, 32, 1, 3);
INSERT INTO tb_partida(data, mandante, visitante, pontuacao_mandante, pontuacao_visitante, campeonato_id, estadio_id) VALUES ('2024-03-04', 'BOTAFOGO', 'FLUMINENSE', 26, 28, 1, 4);
INSERT INTO tb_partida(data, mandante, visitante, pontuacao_mandante, pontuacao_visitante, campeonato_id, estadio_id) VALUES ('2024-03-05', 'GREMIO', 'CORINTHIANS', 30, 27, 1, 1);
INSERT INTO tb_partida(data, mandante, visitante, pontuacao_mandante, pontuacao_visitante, campeonato_id, estadio_id) VALUES ('2024-03-06', 'PALMEIRAS', 'SANTOS', 33, 31, 1, 2);

-- Relação jogador x partida (6 jogadores por partida)
-- Partida 1: Corinthians vs Palmeiras
INSERT INTO jogador_partida(jogador_id, partida_id) VALUES (1, 1);
INSERT INTO jogador_partida(jogador_id, partida_id) VALUES (2, 1);
INSERT INTO jogador_partida(jogador_id, partida_id) VALUES (3, 1);
INSERT INTO jogador_partida(jogador_id, partida_id) VALUES (4, 1);
INSERT INTO jogador_partida(jogador_id, partida_id) VALUES (5, 1);
INSERT INTO jogador_partida(jogador_id, partida_id) VALUES (6, 1);
INSERT INTO jogador_partida(jogador_id, partida_id) VALUES (7, 1);
INSERT INTO jogador_partida(jogador_id, partida_id) VALUES (8, 1);
INSERT INTO jogador_partida(jogador_id, partida_id) VALUES (9, 1);
INSERT INTO jogador_partida(jogador_id, partida_id) VALUES (10, 1);
INSERT INTO jogador_partida(jogador_id, partida_id) VALUES (11, 1);
INSERT INTO jogador_partida(jogador_id, partida_id) VALUES (12, 1);

-- Partida 2: Santos vs São Paulo
INSERT INTO jogador_partida(jogador_id, partida_id) VALUES (13, 2);
INSERT INTO jogador_partida(jogador_id, partida_id) VALUES (14, 2);
INSERT INTO jogador_partida(jogador_id, partida_id) VALUES (15, 2);
INSERT INTO jogador_partida(jogador_id, partida_id) VALUES (16, 2);
INSERT INTO jogador_partida(jogador_id, partida_id) VALUES (17, 2);
INSERT INTO jogador_partida(jogador_id, partida_id) VALUES (18, 2);
INSERT INTO jogador_partida(jogador_id, partida_id) VALUES (19, 2);
INSERT INTO jogador_partida(jogador_id, partida_id) VALUES (20, 2);
INSERT INTO jogador_partida(jogador_id, partida_id) VALUES (21, 2);
INSERT INTO jogador_partida(jogador_id, partida_id) VALUES (22, 2);
INSERT INTO jogador_partida(jogador_id, partida_id) VALUES (23, 2);
INSERT INTO jogador_partida(jogador_id, partida_id) VALUES (24, 2);

-- Partida 3: Flamengo vs Vasco
INSERT INTO jogador_partida(jogador_id, partida_id) VALUES (25, 3);
INSERT INTO jogador_partida(jogador_id, partida_id) VALUES (26, 3);
INSERT INTO jogador_partida(jogador_id, partida_id) VALUES (27, 3);
INSERT INTO jogador_partida(jogador_id, partida_id) VALUES (28, 3);
INSERT INTO jogador_partida(jogador_id, partida_id) VALUES (29, 3);
INSERT INTO jogador_partida(jogador_id, partida_id) VALUES (30, 3);
INSERT INTO jogador_partida(jogador_id, partida_id) VALUES (31, 3);
INSERT INTO jogador_partida(jogador_id, partida_id) VALUES (32, 3);
INSERT INTO jogador_partida(jogador_id, partida_id) VALUES (33, 3);
INSERT INTO jogador_partida(jogador_id, partida_id) VALUES (34, 3);
INSERT INTO jogador_partida(jogador_id, partida_id) VALUES (35, 3);
INSERT INTO jogador_partida(jogador_id, partida_id) VALUES (36, 3);

-- Partida 4: Botafogo vs Fluminense
INSERT INTO jogador_partida(jogador_id, partida_id) VALUES (37, 4);
INSERT INTO jogador_partida(jogador_id, partida_id) VALUES (38, 4);
INSERT INTO jogador_partida(jogador_id, partida_id) VALUES (39, 4);
INSERT INTO jogador_partida(jogador_id, partida_id) VALUES (40, 4);
INSERT INTO jogador_partida(jogador_id, partida_id) VALUES (41, 4);
INSERT INTO jogador_partida(jogador_id, partida_id) VALUES (42, 4);
INSERT INTO jogador_partida(jogador_id, partida_id) VALUES (43, 4);
INSERT INTO jogador_partida(jogador_id, partida_id) VALUES (44, 4);
INSERT INTO jogador_partida(jogador_id, partida_id) VALUES (45, 4);
INSERT INTO jogador_partida(jogador_id, partida_id) VALUES (46, 4);
INSERT INTO jogador_partida(jogador_id, partida_id) VALUES (47, 4);
INSERT INTO jogador_partida(jogador_id, partida_id) VALUES (48, 4);

-- Partida 5: Gremio vs Corinthians
INSERT INTO jogador_partida(jogador_id, partida_id) VALUES (49, 5);
INSERT INTO jogador_partida(jogador_id, partida_id) VALUES (50, 5);
INSERT INTO jogador_partida(jogador_id, partida_id) VALUES (51, 5);
INSERT INTO jogador_partida(jogador_id, partida_id) VALUES (52, 5);
INSERT INTO jogador_partida(jogador_id, partida_id) VALUES (53, 5);
INSERT INTO jogador_partida(jogador_id, partida_id) VALUES (54, 5);
INSERT INTO jogador_partida(jogador_id, partida_id) VALUES (1, 5);
INSERT INTO jogador_partida(jogador_id, partida_id) VALUES (2, 5);
INSERT INTO jogador_partida(jogador_id, partida_id) VALUES (3, 5);
INSERT INTO jogador_partida(jogador_id, partida_id) VALUES (4, 5);
INSERT INTO jogador_partida(jogador_id, partida_id) VALUES (5, 5);
INSERT INTO jogador_partida(jogador_id, partida_id) VALUES (6, 5);

-- Partida 6: Palmeiras vs Santos
INSERT INTO jogador_partida(jogador_id, partida_id) VALUES (7, 6);
INSERT INTO jogador_partida(jogador_id, partida_id) VALUES (8, 6);
INSERT INTO jogador_partida(jogador_id, partida_id) VALUES (9, 6);
INSERT INTO jogador_partida(jogador_id, partida_id) VALUES (10, 6);
INSERT INTO jogador_partida(jogador_id, partida_id) VALUES (11, 6);
INSERT INTO jogador_partida(jogador_id, partida_id) VALUES (12, 6);
INSERT INTO jogador_partida(jogador_id, partida_id) VALUES (13, 6);
INSERT INTO jogador_partida(jogador_id, partida_id) VALUES (14, 6);
INSERT INTO jogador_partida(jogador_id, partida_id) VALUES (15, 6);
INSERT INTO jogador_partida(jogador_id, partida_id) VALUES (16, 6);
INSERT INTO jogador_partida(jogador_id, partida_id) VALUES (17, 6);
INSERT INTO jogador_partida(jogador_id, partida_id) VALUES (18, 6);
