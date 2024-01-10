INSERT INTO `dadossocioambientais`.`permissao` (`nome`) VALUES ('EDITAR_USUARIO');
INSERT INTO `dadossocioambientais`.`permissao` (`nome`) VALUES ('EDITAR_LOCALIDADE');
INSERT INTO `dadossocioambientais`.`permissao` (`nome`) VALUES ('EDITAR_DADOS_SOCIAIS');
INSERT INTO `dadossocioambientais`.`permissao` (`nome`) VALUES ('EDITAR_DADOS_AMBIENTAIS');
INSERT INTO `dadossocioambientais`.`permissao` (`nome`) VALUES ('EDITAR_PERMISSOES');


INSERT INTO `dadossocioambientais`.`grupo` (`nome`) VALUES ('ADMINISTRADOR');
INSERT INTO `dadossocioambientais`.`grupo` (`nome`) VALUES ('GESTOR_AMBIENTAL');
INSERT INTO `dadossocioambientais`.`grupo` (`nome`) VALUES ('ANALISTA_AMBIENTAL');
INSERT INTO `dadossocioambientais`.`grupo` (`nome`) VALUES ('ANALISTA_SOCIAL');

INSERT INTO `dadossocioambientais`.`usuario` (`nome`, `matricula`, `email`, `cpf`, `senha`, `grupo`) VALUES ('Giovanna Fernandes Sousa', '57213091', 'jfs@gmail.com', '501.197.440-58', '$2a$12$U/kbP6nqpeirrPZ4QFkr6uGfqfFLN4cUjW9m.6vlrnS86.hs1xbXK','2');
INSERT INTO `dadossocioambientais`.`usuario` (`nome`, `matricula`, `email`, `cpf`, `senha`, `grupo`) VALUES ('Albert Pereira', '57213092', 'albert@gmail.com', '75145987234', '$2a$12$U/kbP6nqpeirrPZ4QFkr6uGfqfFLN4cUjW9m.6vlrnS86.hs1xbXK','1');
INSERT INTO `dadossocioambientais`.`usuario` (`nome`, `matricula`, `email`, `cpf`, `senha`, `grupo`) VALUES ('Sophia Araujo Almeida', '57213093', 'camarao@gmail.com', '904.759.350-20', '$2a$12$U/kbP6nqpeirrPZ4QFkr6uGfqfFLN4cUjW9m.6vlrnS86.hs1xbXK','3');
INSERT INTO `dadossocioambientais`.`usuario` (`nome`, `matricula`, `email`, `cpf`, `senha`, `grupo`) VALUES ('Ryan Azevedo Alves', '57213094', 'boi@gmail.com', '741.953.850-67', '$2a$12$U/kbP6nqpeirrPZ4QFkr6uGfqfFLN4cUjW9m.6vlrnS86.hs1xbXK','4');
INSERT INTO `dadossocioambientais`.`usuario` (`nome`, `matricula`, `email`, `cpf`, `senha`, `grupo`) VALUES ('Vinicius Oliveira Goncalves', '57213095', 'porco@gmail.com', '872.689.560-96', '$2a$12$U/kbP6nqpeirrPZ4QFkr6uGfqfFLN4cUjW9m.6vlrnS86.hs1xbXK','1');



INSERT INTO `dadossocioambientais`.`localidade` (`nome`, `municipio`, `esfera`) VALUES ('Boa Vista de Irirteua', 'CURUÇÁ', 'ESTADUAL');
INSERT INTO `dadossocioambientais`.`localidade` (`nome`, `municipio`, `esfera`) VALUES ('Floresta da Marinha', 'BELÉM', 'ESTADUAL');
INSERT INTO `dadossocioambientais`.`localidade` (`nome`, `municipio`, `esfera`) VALUES ('Árvore Gigante', 'SANTARÉM', 'MUNICIPAL');


INSERT INTO `dadossocioambientais`.`grupo_permissao` (`grupo`, `permissao`) VALUES ('1', '1');
INSERT INTO `dadossocioambientais`.`grupo_permissao` (`grupo`, `permissao`) VALUES ('1', '2');
INSERT INTO `dadossocioambientais`.`grupo_permissao` (`grupo`, `permissao`) VALUES ('1', '3');
INSERT INTO `dadossocioambientais`.`grupo_permissao` (`grupo`, `permissao`) VALUES ('1', '4');
INSERT INTO `dadossocioambientais`.`grupo_permissao` (`grupo`, `permissao`) VALUES ('1', '5');
INSERT INTO `dadossocioambientais`.`grupo_permissao` (`grupo`, `permissao`) VALUES ('2', '2');
INSERT INTO `dadossocioambientais`.`grupo_permissao` (`grupo`, `permissao`) VALUES ('2', '3');
INSERT INTO `dadossocioambientais`.`grupo_permissao` (`grupo`, `permissao`) VALUES ('2', '4');
INSERT INTO `dadossocioambientais`.`grupo_permissao` (`grupo`, `permissao`) VALUES ('3', '4');
INSERT INTO `dadossocioambientais`.`grupo_permissao` (`grupo`, `permissao`) VALUES ('4', '3');

INSERT INTO `dadossocioambientais`.`coordenada` (`latitude`, `longitude`, `localidade`) VALUES ('-6,3655988', '-6555555', '1');
INSERT INTO `dadossocioambientais`.`coordenada` (`latitude`, `longitude`, `localidade`) VALUES ('9,365988', '-6985547', '1');
INSERT INTO `dadossocioambientais`.`coordenada` (`latitude`, `longitude`, `localidade`) VALUES ('-6,9854625', '-6,985417', '1');
INSERT INTO `dadossocioambientais`.`coordenada` (`latitude`, `longitude`, `localidade`) VALUES ('1º 23\19\"S', '48º 23\19\"W', '2');
INSERT INTO `dadossocioambientais`.`coordenada` (`latitude`, `longitude`, `localidade`) VALUES ('1º 53\29\"S', '48º 33\19\"W', '2');
INSERT INTO `dadossocioambientais`.`coordenada` (`latitude`, `longitude`, `localidade`) VALUES ('1º 43\15\"S', '58º 93\19\"W', '2');
INSERT INTO `dadossocioambientais`.`coordenada` (`latitude`, `longitude`, `localidade`) VALUES ('-9,3652', '-9,3625', '3');
INSERT INTO `dadossocioambientais`.`coordenada` (`latitude`, `longitude`, `localidade`) VALUES ('-9,3652', '-3,3255', '3');



INSERT INTO `dadossocioambientais`.`imovel` (`rua`, `numero`, `bairro`, `referencial`, `latitude`, `longitude`, `area_imovel`, `vizinhos`, `situacao_fundiaria`, `documentacao_imovel`, `data_chegada`, `pretende_mudar`, `motivo_vontade_mudanca`, `relacao_area`, `relacao_vizinhos`, `limites`, `iluminacao_publica`, `transporte`, `programa_infra_saneamento`, `linhas_de_barco`, `tipo_solo`, `esporte_lazer`, `localidade`) VALUES ('13º DE ABRIL', '54F', 'DAS PEDRAS', 'PRÓXIMO AO MANGUEZAL', '888888', '8888888', '25', 'LADO_ESQUERDO_ATRAS', 'OCUPAÇÃO_COM_BENFEITORIA', 'NÃO_POSSUI', '1981-02-13', 'SIM', 'DISPUTA POR TERRAS', 'NASCEU NO LOCAL', 'PÉSSIMA', 'MURO_ALVENARIA', 'SIM', 'RABETA', 'DESCONHECE', 'NÃO', 'TERRA_FIRME', 'SEDE_ESPORTIVA', '1');
INSERT INTO `dadossocioambientais`.`imovel` (`rua`, `numero`, `bairro`, `referencial`, `latitude`, `longitude`, `area_imovel`, `vizinhos`,`situacao_fundiaria`, `documentacao_imovel`, `data_chegada`, `pretende_mudar`, `motivo_vontade_mudanca`, `relacao_area`, `relacao_vizinhos`, `limites`, `iluminacao_publica`, `transporte`, `programa_infra_saneamento`, `linhas_de_barco`, `tipo_solo`, `esporte_lazer`, `localidade`) VALUES ('RUA 2', 'S/N', 'PEDREIRINHA', 'PERTO DA FEIRA', '456454', '76576', '25', 'LADO_ESQUERDO_ATRAS', 'PROPRIETARIO', 'NÃO_POSSUI', '1982-09-20', 'SIM', 'CONFLITOS FUNDIÁRIOS', 'SEMPRE MOROU NO LOCAL', 'BOA', 'MURO_ALVENARIA','NÃO', 'MOTO', 'DESCONHECE','NÃO', 'TERRA_FIRME', 'SEDE_ESPORTIVA', '1');
INSERT INTO `dadossocioambientais`.`imovel` (`rua`, `numero`, `bairro`, `referencial`, `latitude`, `longitude`, `area_imovel`, `vizinhos`, `situacao_fundiaria`, `documentacao_imovel`, `data_chegada`,`pretende_mudar`, `motivo_vontade_mudanca`, `relacao_area`, `relacao_vizinhos`, `limites`, `iluminacao_publica`,`transporte`, `programa_infra_saneamento`, `linhas_de_barco`, `tipo_solo`, `esporte_lazer`, `localidade`) VALUES ('RUA 3', 'S/N', 'PEDREIRINHA', 'EM FRENTE AO CAMPINHO', '456454', '76576', '25', 'LADO_ESQUERDO_ATRAS', 'PROPRIETARIO', 'NÃO_POSSUI', '1982-09-20', 'NÃO', 'NÃO INFORMADO', 'SEMPRE MOROU NO LOCAL', 'BOA', 'MURO_ALVENARIA', 'SIM','MOTO','DESCONHECE', 'NÃO', 'TERRA_FIRME', 'SEDE_ESPORTIVA', '1');
INSERT INTO `dadossocioambientais`.`imovel` (`rua`, `numero`, `bairro`, `referencial`, `latitude`, `longitude`, `area_imovel`, `vizinhos`, `situacao_fundiaria`, `documentacao_imovel`, `data_chegada`, `pretende_mudar`, `motivo_vontade_mudanca`, `relacao_area`, `relacao_vizinhos`, `limites`, `iluminacao_publica`,`transporte`, `programa_infra_saneamento`,`linhas_de_barco`, `tipo_solo`, `esporte_lazer`, `localidade`) VALUES ('RUA 2', 'S/N', 'PEDREIRINHA', 'PERTO DA FEIRA', '456454', '76576', '25', 'LADO_ESQUERDO_ATRAS','PROPRIETARIO', 'NÃO_POSSUI', '1982-09-20', 'NÃO', 'NÃO INFORMADO','SEMPRE MOROU NO LOCAL', 'BOA', 'MURO_ALVENARIA', 'SIM','MOTO', 'NÃO','DESCONHECE', 'TERRA_FIRME', 'SEDE_ESPORTIVA', '1');
INSERT INTO `dadossocioambientais`.`imovel` (`rua`, `numero`, `bairro`, `referencial`, `latitude`, `longitude`, `area_imovel`, `vizinhos`,`situacao_fundiaria`, `documentacao_imovel`, `data_chegada`,`pretende_mudar`, `motivo_vontade_mudanca`, `relacao_area`, `relacao_vizinhos`, `limites`, `iluminacao_publica`,`transporte`,`programa_infra_saneamento`,`linhas_de_barco`, `tipo_solo`, `esporte_lazer`, `localidade`) VALUES ('RUA SMAÚMA', '45 A', 'DAS PEDRAS', 'PRÓXIMO AO IGARAPÉ', '456454', '76576', '25', 'LADO_ESQUERDO_ATRAS', 'PROPRIETARIO', 'NÃO_POSSUI', '1982-09-20', 'NÃO', 'NÃO INFORMADO', 'SEMPRE MOROU NO LOCAL', 'BOA', 'MURO_ALVENARIA', 'NÃO','MOTO','DESCONHECE', 'NÃO', 'TERRA_FIRME', 'SEDE_ESPORTIVA', '2');
INSERT INTO `dadossocioambientais`.`imovel` (`rua`, `numero`, `bairro`, `referencial`, `latitude`, `longitude`, `area_imovel`, `vizinhos`, `situacao_fundiaria`, `documentacao_imovel`, `data_chegada`, `pretende_mudar`, `motivo_vontade_mudanca`,`relacao_area`, `relacao_vizinhos`, `limites`, `iluminacao_publica`,`transporte`, `programa_infra_saneamento`,`linhas_de_barco`, `tipo_solo`, `esporte_lazer`, `localidade`) VALUES ('RUA BURIT', '654', 'RIACHINHO', 'PERTO DA FEIRA', '456454', '76576', '25', 'LADO_ESQUERDO_ATRAS','PROPRIETARIO', 'NÃO_POSSUI', '1982-09-20', 'SIM', 'GARIMPO','SEMPRE MOROU NO LOCAL', 'BOA', 'MURO_ALVENARIA', 'SIM','MOTO', 'NÃO', 'TERRA_FIRME','DESCONHECE', 'SEDE_ESPORTIVA', '2');
INSERT INTO `dadossocioambientais`.`imovel` (`rua`, `numero`, `bairro`, `referencial`, `latitude`, `longitude`, `area_imovel`, `vizinhos`,`situacao_fundiaria`, `documentacao_imovel`, `data_chegada`, `pretende_mudar`, `motivo_vontade_mudanca`, `relacao_area`, `relacao_vizinhos`, `limites`, `iluminacao_publica`,`transporte`, `programa_infra_saneamento`,`linhas_de_barco`, `tipo_solo`, `esporte_lazer`, `localidade`) VALUES ('RUA WE6', '562B', 'MANAGABEIRA', 'NA VILA AGROPECUÁRIA', '456454', '76576', '25', 'LADO_ESQUERDO_ATRAS','PROPRIETARIO', 'NÃO_POSSUI', '1982-09-20', 'NÃO', 'SEMPRE MOROU NO LOCAL', 'SEMPRE MOROU NO LOCAL', 'BOA', 'MURO_ALVENARIA','NÃO', 'MOTO', 'DESCONHECE','NÃO', 'TERRA_FIRME', 'SEDE_ESPORTIVA', '3');
INSERT INTO `dadossocioambientais`.`imovel` (`rua`, `numero`, `bairro`, `referencial`, `latitude`, `longitude`, `area_imovel`, `vizinhos`,`situacao_fundiaria`, `documentacao_imovel`, `data_chegada`, `pretende_mudar`, `motivo_vontade_mudanca`, `relacao_area`, `relacao_vizinhos`, `limites`, `iluminacao_publica`,`transporte`, `programa_infra_saneamento`,`linhas_de_barco`, `tipo_solo`, `esporte_lazer`, `localidade`) VALUES ('SN 15', 'S/N', 'MIRITI', 'NA ENTRADA DA CIDADE', '456454', '76576','25', 'LADO_ESQUERDO_ATRAS', 'PROPRIETARIO', 'NÃO_POSSUI', '1982-09-20', 'NÃO', 'NÃO INFORMOU', 'SEMPRE MOROU NO LOCAL', 'BOA', 'MURO_ALVENARIA', 'NÃO','MOTO', 'DESCONHECE','NÃO', 'TERRA_FIRME', 'SEDE_ESPORTIVA', '3');
INSERT INTO `dadossocioambientais`.`imovel` (`rua`, `numero`, `bairro`, `referencial`, `latitude`, `longitude`, `area_imovel`, `vizinhos`,`situacao_fundiaria`, `documentacao_imovel`, `data_chegada`, `pretende_mudar`, `motivo_vontade_mudanca`, `relacao_area`, `relacao_vizinhos`, `limites`, `iluminacao_publica`,`transporte`, `programa_infra_saneamento`,`linhas_de_barco`, `tipo_solo`, `esporte_lazer`, `localidade`) VALUES ('ARSENAL', '56', 'CREMAÇÃO', 'PRÓXIMA A ÁREA PARA UC', '456454', '76576','25', 'LADO_ESQUERDO_ATRAS','PROPRIETARIO', 'NÃO_POSSUI', '1982-09-20', 'SIM', 'ALAGAMENTOS CONSTANTES', 'SEMPRE MOROU NO LOCAL', 'BOA', 'MURO_ALVENARIA','NÃO', 'MOTO', 'DESCONHECE','NÃO', 'TERRA_FIRME', 'SEDE_ESPORTIVA', '3');

INSERT INTO `dadossocioambientais`.`escola` (`nome`, `educacao_ambiental`, `merenda`, `transporte`, `localidade`) VALUES ('ESCOLA ESTADUAL DE ENSINO FUNDAMENTAL E MÉDIO NOSSA SENHORA DAS GRAÇAS', 'SIM', 'NÃO', 'SIM', '1');
INSERT INTO `dadossocioambientais`.`escola` (`nome`, `educacao_ambiental`, `merenda`, `transporte`, `localidade`) VALUES ('ESCOLA ESTADUAL DE ENSINO FUNDAMENTAL E MÉDIO PROFESSOR AMBRÓSIO', 'SIM', 'SIM', 'SIM', '1');
INSERT INTO `dadossocioambientais`.`escola` (`nome`, `educacao_ambiental`, `merenda`, `transporte`, `localidade`) VALUES ('ESCOLA MUNICIPAL DE ENSINO FUNDAMENTAL E MÉDIO GENERAL LIMA', 'SIM', 'SIM', 'NÃO', '2');
INSERT INTO `dadossocioambientais`.`escola` (`nome`, `educacao_ambiental`, `merenda`, `transporte`, `localidade`) VALUES ('ESCOLA ESTADUAL DE ENSINO FUNDAMENTAL E MÉDIO PROFESSORA JÚLIA', 'NÃO', 'SIM', 'SIM', '3');
INSERT INTO `dadossocioambientais`.`escola` (`nome`, `educacao_ambiental`, `merenda`, `transporte`, `localidade`) VALUES ('ESCOLA ESTADUAL DE ENSINO FUNDAMENTAL E MÉDIO NOSSA SENHORA DE NAZARÉ', 'SIM', 'NÃO', 'SIM', '3');




INSERT INTO `dadossocioambientais`.`posto_de_saude` (`nome`, `ambulatorial`, `urgencia_emergencia`, `medicos_por_turno`, `localidade`) VALUES ('POSTO MUNICIPAL', 'SIM', 'NÃO', '4', '1');
INSERT INTO `dadossocioambientais`.`posto_de_saude` (`nome`, `ambulatorial`, `urgencia_emergencia`, `medicos_por_turno`, `localidade`) VALUES ('POSTO MUNICIPAL', 'SIM', 'SIM', '6', '2');
INSERT INTO `dadossocioambientais`.`posto_de_saude` (`nome`, `ambulatorial`, `urgencia_emergencia`, `medicos_por_turno`, `localidade`) VALUES ('POSTO MUNICIPAL', 'NÃO', 'SIM', '2', '3');


INSERT INTO `dadossocioambientais`.`benfeitoria` (
  `tipo_benfeitoria`, `funcao`, `tipo_solo`, `area_benfeitoria`, `pavimentos`, 
  `tipo_construcao`, `tipo_cobertura`, `tipo_esquadrias`, `alagamentos`, `nivel_alagamentos`, 
  `efluentes`, `residuos`, `fonte_energia`, `energia_alimentos`, `informativo_predominante`, 
  `importancia_de_proteger_fauna`, `importancia_de_proteger_ambiente`, `qual_espaco_precisa_ser_preservado`, 
  `problemas_relacionados_ao_ambiente`, `imovel`) VALUES ('Residencia', 'Principal', 'Vejetacao', 120.5, 2, 
 'Madeira', 'Telha_de_Barro', 'madeira', 'FREQUENTEMENTE', 'ENCHENTE', 
 'Fossa_Septica', 'Coleta_Seletiva', 'Placa_Solar', 'Gas', 'Internet', 
 'Alta', 'Alta', 'Área Verde Local', 
 'Poluição Sonora', 1);

INSERT INTO `dadossocioambientais`.`benfeitoria` (
  `tipo_benfeitoria`, `funcao`, `tipo_solo`, `area_benfeitoria`, `pavimentos`, 
  `tipo_construcao`, `tipo_cobertura`, `tipo_esquadrias`, `alagamentos`, `nivel_alagamentos`, 
  `efluentes`, `residuos`, `fonte_energia`, `energia_alimentos`, `informativo_predominante`, 
  `importancia_de_proteger_fauna`, `importancia_de_proteger_ambiente`, `qual_espaco_precisa_ser_preservado`, 
  `problemas_relacionados_ao_ambiente`, `imovel`) VALUES ('Comercio', 'Principal', 'Vejetacao', 300.0, 1, 
 'Palha', 'Brasilit', 'aluminio', 'RARAMENTE', 'NÃO_SE_APLICA', 
 'Fossa_Septica', 'Coleta_Publica', 'Equatorial', 'Gas', 'Radio', 
 'Média', 'Média', 'Parques Urbanos', 
 'Desmatamento', 2);
INSERT INTO `dadossocioambientais`.`benfeitoria` (
  `tipo_benfeitoria`, `funcao`, `tipo_solo`, `area_benfeitoria`, `pavimentos`, 
  `tipo_construcao`, `tipo_cobertura`, `tipo_esquadrias`, `alagamentos`, `nivel_alagamentos`, 
  `efluentes`, `residuos`, `fonte_energia`, `energia_alimentos`, `informativo_predominante`, 
  `importancia_de_proteger_fauna`, `importancia_de_proteger_ambiente`, `qual_espaco_precisa_ser_preservado`, 
  `problemas_relacionados_ao_ambiente`, `imovel`) VALUES ('SemUso', 'Secundaria', 'Vejetacao', 200.0, 1, 
 'Alvenaria', 'Laje', 'PVC', 'RARAMENTE', 'NÃO_SE_APLICA', 
 'Fossa_Negra', 'Queimado', 'Equatorial', 'Carvao', 'Radio', 
 'Baixa', 'Baixa', 'Reservas Naturais', 
 'Emissão de Gases', 3);

INSERT INTO `dadossocioambientais`.`alimentacao` (`alimentacao_principal`) VALUES ('PEIXE');
INSERT INTO `dadossocioambientais`.`alimentacao` (`alimentacao_principal`) VALUES ('AVES');
INSERT INTO `dadossocioambientais`.`alimentacao` (`alimentacao_principal`) VALUES ('CARNES');
INSERT INTO `dadossocioambientais`.`alimentacao` (`alimentacao_principal`) VALUES ('VEGETAIS');
INSERT INTO `dadossocioambientais`.`alimentacao` (`alimentacao_principal`) VALUES ('MARISCOS');
INSERT INTO `dadossocioambientais`.`alimentacao` (`alimentacao_principal`) VALUES ('VARIADO');
INSERT INTO `dadossocioambientais`.`alimentacao` (`alimentacao_principal`) VALUES ('NAO_DECLARADO');

