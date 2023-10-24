INSERT INTO `dadossocioambienenentais`.`permissao` (`nome`) VALUES ('EDITAR_USUARIO');
INSERT INTO `dadossocioambienenentais`.`permissao` (`nome`) VALUES ('EDITAR_LOCALIDADE');
INSERT INTO `dadossocioambienenentais`.`permissao` (`nome`) VALUES ('EDITAR_DADOS_SOCIAIS');
INSERT INTO `dadossocioambienenentais`.`permissao` (`nome`) VALUES ('EDITAR_DADOS_AMBIENTAIS');
INSERT INTO `dadossocioambienenentais`.`permissao` (`nome`) VALUES ('EDITAR_PERMISSOES');


INSERT INTO `dadossocioambienenentais`.`grupo` (`nome`) VALUES ('ADMINISTRADOR');
INSERT INTO `dadossocioambienenentais`.`grupo` (`nome`) VALUES ('GESTOR_AMBIENTAL');
INSERT INTO `dadossocioambienenentais`.`grupo` (`nome`) VALUES ('ANALISTA_AMBIENTAL');
INSERT INTO `dadossocioambienenentais`.`grupo` (`nome`) VALUES ('ANALISTA_SOCIAL');

INSERT INTO `dadossocioambienenentais`.`usuario` (`nome`, `matricula`, `email`, `cpf`, `senha`, `grupo`) VALUES ('Giovanna Fernandes Sousa', '57213091', 'jfs@gmail.com', '501.197.440-58', '$2a$12$U/kbP6nqpeirrPZ4QFkr6uGfqfFLN4cUjW9m.6vlrnS86.hs1xbXK','2');
INSERT INTO `dadossocioambienenentais`.`usuario` (`nome`, `matricula`, `email`, `cpf`, `senha`, `grupo`) VALUES ('Albert Pereira', '57213092', 'albert@gmail.com', '75145987234', '$2a$12$U/kbP6nqpeirrPZ4QFkr6uGfqfFLN4cUjW9m.6vlrnS86.hs1xbXK','1');
INSERT INTO `dadossocioambienenentais`.`usuario` (`nome`, `matricula`, `email`, `cpf`, `senha`, `grupo`) VALUES ('Sophia Araujo Almeida', '57213093', 'camarao@gmail.com', '904.759.350-20', '$2a$12$U/kbP6nqpeirrPZ4QFkr6uGfqfFLN4cUjW9m.6vlrnS86.hs1xbXK','3');
INSERT INTO `dadossocioambienenentais`.`usuario` (`nome`, `matricula`, `email`, `cpf`, `senha`, `grupo`) VALUES ('Ryan Azevedo Alves', '57213094', 'boi@gmail.com', '741.953.850-67', '$2a$12$U/kbP6nqpeirrPZ4QFkr6uGfqfFLN4cUjW9m.6vlrnS86.hs1xbXK','4');
INSERT INTO `dadossocioambienenentais`.`usuario` (`nome`, `matricula`, `email`, `cpf`, `senha`, `grupo`) VALUES ('Vinicius Oliveira Goncalves', '57213095', 'porco@gmail.com', '872.689.560-96', '$2a$12$U/kbP6nqpeirrPZ4QFkr6uGfqfFLN4cUjW9m.6vlrnS86.hs1xbXK','1');



INSERT INTO `dadossocioambienenentais`.`localidade` (`nome`, `municipio`, `esfera`) VALUES ('Boa Vsita de Irirteua', 'CURUÇÁ', 'ESTADUAL');
INSERT INTO `dadossocioambienenentais`.`localidade` (`nome`, `municipio`, `esfera`) VALUES ('Floresta da Marinha', 'BELÉM', 'ESTADUAL');
INSERT INTO `dadossocioambienenentais`.`localidade` (`nome`, `municipio`, `esfera`) VALUES ('Árvore Gigante', 'SANTARÉM', 'MUNICIPAL');


INSERT INTO `dadossocioambienenentais`.`grupo_permissao` (`grupo`, `permissao`) VALUES ('1', '1');
INSERT INTO `dadossocioambienenentais`.`grupo_permissao` (`grupo`, `permissao`) VALUES ('1', '2');
INSERT INTO `dadossocioambienenentais`.`grupo_permissao` (`grupo`, `permissao`) VALUES ('1', '3');
INSERT INTO `dadossocioambienenentais`.`grupo_permissao` (`grupo`, `permissao`) VALUES ('1', '4');
INSERT INTO `dadossocioambienenentais`.`grupo_permissao` (`grupo`, `permissao`) VALUES ('1', '5');
INSERT INTO `dadossocioambienenentais`.`grupo_permissao` (`grupo`, `permissao`) VALUES ('2', '2');
INSERT INTO `dadossocioambienenentais`.`grupo_permissao` (`grupo`, `permissao`) VALUES ('2', '3');
INSERT INTO `dadossocioambienenentais`.`grupo_permissao` (`grupo`, `permissao`) VALUES ('2', '4');
INSERT INTO `dadossocioambienenentais`.`grupo_permissao` (`grupo`, `permissao`) VALUES ('3', '4');
INSERT INTO `dadossocioambienenentais`.`grupo_permissao` (`grupo`, `permissao`) VALUES ('4', '3');

INSERT INTO `dadossocioambienenentais`.`coordenada` (`latitude`, `longitude`, `localidade`) VALUES ('-6,3655988', '-6555555', '1');
INSERT INTO `dadossocioambienenentais`.`coordenada` (`latitude`, `longitude`, `localidade`) VALUES ('9,365988', '-6985547', '1');
INSERT INTO `dadossocioambienenentais`.`coordenada` (`latitude`, `longitude`, `localidade`) VALUES ('-6,9854625', '-6,985417', '1');
INSERT INTO `dadossocioambienenentais`.`coordenada` (`latitude`, `longitude`, `localidade`) VALUES ('1º 23\19\"S', '48º 23\19\"W', '2');
INSERT INTO `dadossocioambienenentais`.`coordenada` (`latitude`, `longitude`, `localidade`) VALUES ('1º 53\29\"S', '48º 33\19\"W', '2');
INSERT INTO `dadossocioambienenentais`.`coordenada` (`latitude`, `longitude`, `localidade`) VALUES ('1º 43\15\"S', '58º 93\19\"W', '2');
INSERT INTO `dadossocioambienenentais`.`coordenada` (`latitude`, `longitude`, `localidade`) VALUES ('-9,3652', '-9,3625', '3');
INSERT INTO `dadossocioambienenentais`.`coordenada` (`latitude`, `longitude`, `localidade`) VALUES ('-9,3652', '-3,3255', '3');


INSERT INTO `dadossocioambienenentais`.`imovel` (`rua`, `numero`, `bairro`, `referencial`, `latitude`, `longitude`, `situacao_fundiaria`, `documentacao_imovel`, `data_chegada`, `pretende_mudar`, `motivo_vontade_mudanca`, `relacao_area`, `relacao_vizinhos`, `limites`, `transporte`, `linhas_de_barco`, `tipo_solo`, `esporte_lazer`, `localidade`) VALUES ('RUA 2', 'S/N', 'PEDREIRINHA', 'PERTO DA FEIRA', '456454', '76576', 'PROPRIETARIO', 'NÃO_POSSUI', '1982-09-20', 'SIM', 'CONFLITOS FUNDIÁRIOS', 'SEMPRE MOROU NO LOCAL', 'BOA', 'MURO_ALVENARIA', 'MOTO', 'NÃO', 'TERRA_FIRME', 'SEDE_ESPORTIVA', '1');
INSERT INTO `dadossocioambienenentais`.`imovel` (`rua`, `numero`, `bairro`, `referencial`, `latitude`, `longitude`, `situacao_fundiaria`, `documentacao_imovel`, `data_chegada`,`pretende_mudar`, `motivo_vontade_mudanca`, `relacao_area`, `relacao_vizinhos`, `limites`, `transporte`, `linhas_de_barco`, `tipo_solo`, `esporte_lazer`, `localidade`) VALUES ('RUA 3', 'S/N', 'PEDREIRINHA', 'EM FRENTE AO CAMPINHO', '456454', '76576', 'PROPRIETARIO', 'NÃO_POSSUI', '1982-09-20', 'NÃO', 'NÃO INFORMADO', 'SEMPRE MOROU NO LOCAL', 'BOA', 'MURO_ALVENARIA', 'MOTO', 'NÃO', 'TERRA_FIRME', 'SEDE_ESPORTIVA', '1');
INSERT INTO `dadossocioambienenentais`.`imovel` (`rua`, `numero`, `bairro`, `referencial`, `latitude`, `longitude`, `situacao_fundiaria`, `documentacao_imovel`, `data_chegada`, `pretende_mudar`, `motivo_vontade_mudanca`, `relacao_area`, `relacao_vizinhos`, `limites`, `transporte`, `linhas_de_barco`, `tipo_solo`, `esporte_lazer`, `localidade`) VALUES ('RUA 2', 'S/N', 'PEDREIRINHA', 'PERTO DA FEIRA', '456454', '76576', 'PROPRIETARIO', 'NÃO_POSSUI', '1982-09-20', 'NÃO', 'NÃO INFORMADO','SEMPRE MOROU NO LOCAL', 'BOA', 'MURO_ALVENARIA', 'MOTO', 'NÃO', 'TERRA_FIRME', 'SEDE_ESPORTIVA', '1');
INSERT INTO `dadossocioambienenentais`.`imovel` (`rua`, `numero`, `bairro`, `referencial`, `latitude`, `longitude`, `situacao_fundiaria`, `documentacao_imovel`, `data_chegada`,`pretende_mudar`, `motivo_vontade_mudanca`, `relacao_area`, `relacao_vizinhos`, `limites`, `transporte`, `linhas_de_barco`, `tipo_solo`, `esporte_lazer`, `localidade`) VALUES ('RUA SMAÚMA', '45 A', 'DAS PEDRAS', 'PRÓXIMO AO IGARAPÉ', '456454', '76576', 'PROPRIETARIO', 'NÃO_POSSUI', '1982-09-20', 'NÃO', 'NÃO INFORMADO', 'SEMPRE MOROU NO LOCAL', 'BOA', 'MURO_ALVENARIA', 'MOTO', 'NÃO', 'TERRA_FIRME', 'SEDE_ESPORTIVA', '2');
INSERT INTO `dadossocioambienenentais`.`imovel` (`rua`, `numero`, `bairro`, `referencial`, `latitude`, `longitude`, `situacao_fundiaria`, `documentacao_imovel`, `data_chegada`, `pretende_mudar`, `motivo_vontade_mudanca`,`relacao_area`, `relacao_vizinhos`, `limites`, `transporte`, `linhas_de_barco`, `tipo_solo`, `esporte_lazer`, `localidade`) VALUES ('RUA BURIT', '654', 'RIACHINHO', 'PERTO DA FEIRA', '456454', '76576', 'PROPRIETARIO', 'NÃO_POSSUI', '1982-09-20', 'SIM', 'GARIMPO','SEMPRE MOROU NO LOCAL', 'BOA', 'MURO_ALVENARIA', 'MOTO', 'NÃO', 'TERRA_FIRME', 'SEDE_ESPORTIVA', '2');
INSERT INTO `dadossocioambienenentais`.`imovel` (`rua`, `numero`, `bairro`, `referencial`, `latitude`, `longitude`, `situacao_fundiaria`, `documentacao_imovel`, `data_chegada`, `pretende_mudar`, `motivo_vontade_mudanca`, `relacao_area`, `relacao_vizinhos`, `limites`, `transporte`, `linhas_de_barco`, `tipo_solo`, `esporte_lazer`, `localidade`) VALUES ('RUA WE6', '562B', 'MANAGABEIRA', 'NA VILA AGROPECUÁRIA', '456454', '76576', 'PROPRIETARIO', 'NÃO_POSSUI', '1982-09-20', 'NÃO', 'SEMPRE MOROU NO LOCAL', 'SEMPRE MOROU NO LOCAL', 'BOA', 'MURO_ALVENARIA', 'MOTO', 'NÃO', 'TERRA_FIRME', 'SEDE_ESPORTIVA', '3');
INSERT INTO `dadossocioambienenentais`.`imovel` (`rua`, `numero`, `bairro`, `referencial`, `latitude`, `longitude`, `situacao_fundiaria`, `documentacao_imovel`, `data_chegada`, `pretende_mudar`, `motivo_vontade_mudanca`, `relacao_area`, `relacao_vizinhos`, `limites`, `transporte`, `linhas_de_barco`, `tipo_solo`, `esporte_lazer`, `localidade`) VALUES ('SN 15', 'S/N', 'MIRITI', 'NA ENTRADA DA CIDADE', '456454', '76576', 'PROPRIETARIO', 'NÃO_POSSUI', '1982-09-20', 'NÃO', 'NÃO INFORMOU', 'SEMPRE MOROU NO LOCAL', 'BOA', 'MURO_ALVENARIA', 'MOTO', 'NÃO', 'TERRA_FIRME', 'SEDE_ESPORTIVA', '3');
INSERT INTO `dadossocioambienenentais`.`imovel` (`rua`, `numero`, `bairro`, `referencial`, `latitude`, `longitude`, `situacao_fundiaria`, `documentacao_imovel`, `data_chegada`, `pretende_mudar`, `motivo_vontade_mudanca`, `relacao_area`, `relacao_vizinhos`, `limites`, `transporte`, `linhas_de_barco`, `tipo_solo`, `esporte_lazer`, `localidade`) VALUES ('ARSENAL', '56', 'CREMAÇÃO', 'PRÓXIMA A ÁREA PARA UC', '456454', '76576', 'PROPRIETARIO', 'NÃO_POSSUI', '1982-09-20', 'SIM', 'ALAGAMENTOS CONSTANTES', 'SEMPRE MOROU NO LOCAL', 'BOA', 'MURO_ALVENARIA', 'MOTO', 'NÃO', 'TERRA_FIRME', 'SEDE_ESPORTIVA', '3');

