INSERT INTO `dadossocioambientais`.`grupo` (`nome`) VALUES ('ADMINISTRADOR');
INSERT INTO `dadossocioambientais`.`grupo` (`nome`) VALUES ('USUARIO');

INSERT INTO `dadossocioambientais`.`permissao` (`nome`) VALUES ('EDITAR_USUARIO');
INSERT INTO `dadossocioambientais`.`permissao` (`nome`) VALUES ('EDITAR_LOCALIDADE');
INSERT INTO `dadossocioambientais`.`permissao` (`nome`) VALUES ('EDITAR_DADOS_SOCIAIS');
INSERT INTO `dadossocioambientais`.`permissao` (`nome`) VALUES ('EDITAR_PERMISSOES');


INSERT INTO `dadossocioambientais`.`grupo_permissao` (`grupo`, `permissao`) VALUES ('1', '1');
INSERT INTO `dadossocioambientais`.`grupo_permissao` (`grupo`, `permissao`) VALUES ('1', '2');
INSERT INTO `dadossocioambientais`.`grupo_permissao` (`grupo`, `permissao`) VALUES ('1', '3');
INSERT INTO `dadossocioambientais`.`grupo_permissao` (`grupo`, `permissao`) VALUES ('1', '4');
INSERT INTO `dadossocioambientais`.`grupo_permissao` (`grupo`, `permissao`) VALUES ('2', '3');


INSERT INTO `dadossocioambientais`.`usuario` (`nome`, `matricula`, `email`, `cpf`, `senha`, `grupo`) VALUES ('Giovanna Fernandes Sousa', '57213091', 'jfs@gmail.com', '501.197.440-58', '$2a$12$U/kbP6nqpeirrPZ4QFkr6uGfqfFLN4cUjW9m.6vlrnS86.hs1xbXK','1');
INSERT INTO `dadossocioambientais`.`usuario` (`nome`, `matricula`, `email`, `cpf`, `senha`, `grupo`) VALUES ('Albert Pereira', '57213092', 'albert@gmail.com', '75145987234', '$2a$12$U/kbP6nqpeirrPZ4QFkr6uGfqfFLN4cUjW9m.6vlrnS86.hs1xbXK','1');
INSERT INTO `dadossocioambientais`.`usuario` (`nome`, `matricula`, `email`, `cpf`, `senha`, `grupo`) VALUES ('Sophia Araujo Almeida', '57213093', 'camarao@gmail.com', '904.759.350-20', '$2a$12$U/kbP6nqpeirrPZ4QFkr6uGfqfFLN4cUjW9m.6vlrnS86.hs1xbXK','1');
INSERT INTO `dadossocioambientais`.`usuario` (`nome`, `matricula`, `email`, `cpf`, `senha`, `grupo`) VALUES ('Ryan Azevedo Alves', '57213094', 'boi@gmail.com', '741.953.850-67', '$2a$12$U/kbP6nqpeirrPZ4QFkr6uGfqfFLN4cUjW9m.6vlrnS86.hs1xbXK','2');
INSERT INTO `dadossocioambientais`.`usuario` (`nome`, `matricula`, `email`, `cpf`, `senha`, `grupo`) VALUES ('Vinicius Oliveira Goncalves', '57213095', 'porco@gmail.com', '872.689.560-96', '$2a$12$U/kbP6nqpeirrPZ4QFkr6uGfqfFLN4cUjW9m.6vlrnS86.hs1xbXK','2');



INSERT INTO `dadossocioambientais`.`localidade` (`nome`, `municipio`, `esfera`) VALUES ('Boa Vista de Irirteua', 'CURUÇÁ', 'ESTADUAL');
INSERT INTO `dadossocioambientais`.`localidade` (`nome`, `municipio`, `esfera`) VALUES ('Floresta da Marinha', 'BELÉM', 'ESTADUAL');
INSERT INTO `dadossocioambientais`.`localidade` (`nome`, `municipio`, `esfera`) VALUES ('Árvore Gigante', 'SANTARÉM', 'MUNICIPAL');




INSERT INTO `dadossocioambientais`.`escola` (`nome`, `iniciativa`,`merenda`, `transporte`, `educacao_ambiental`, `localidade`) VALUES ('ESCOLA ESTADUAL DE ENSINO FUNDAMENTAL E MÉDIO NOSSA SENHORA DAS GRAÇAS', 'ESTADUAL','SIM', 'NÃO', 'SIM', '1');
INSERT INTO `dadossocioambientais`.`escola` (`nome`, `iniciativa`,`merenda`, `transporte`, `educacao_ambiental`, `localidade`) VALUES ('ESCOLA ESTADUAL DE ENSINO FUNDAMENTAL E MÉDIO PROFESSOR AMBRÓSIO', 'MUNICIPAL','SIM', 'SIM', 'SIM', '1');
INSERT INTO `dadossocioambientais`.`escola` (`nome`, `iniciativa`,`merenda`, `transporte`, `educacao_ambiental`, `localidade`) VALUES ('ESCOLA MUNICIPAL DE ENSINO FUNDAMENTAL E MÉDIO GENERAL LIMA', 'MUNICIPAL','SIM', 'SIM', 'NÃO', '2');
INSERT INTO `dadossocioambientais`.`escola` (`nome`, `iniciativa`,`merenda`, `transporte`, `educacao_ambiental`, `localidade`) VALUES ('ESCOLA ESTADUAL DE ENSINO FUNDAMENTAL E MÉDIO PROFESSORA JÚLIA', 'MUNICIPAL', 'NÃO', 'SIM', 'SIM', '3');
INSERT INTO `dadossocioambientais`.`escola` (`nome`, `iniciativa`,`merenda`, `transporte`, `educacao_ambiental`, `localidade`) VALUES ('ESCOLA ESTADUAL DE ENSINO FUNDAMENTAL E MÉDIO NOSSA SENHORA DE NAZARÉ', 'ESTADUAL','SIM', 'NÃO', 'SIM', '3');


INSERT INTO `dadossocioambientais`.`posto_de_saude` (`nome`, `ambulatorial`, `urgencia_emergencia`, `medicos_por_turno`, `localidade`) VALUES ('POSTO MUNICIPAL', 'SIM', 'NÃO', '4', '1');
INSERT INTO `dadossocioambientais`.`posto_de_saude` (`nome`, `ambulatorial`, `urgencia_emergencia`, `medicos_por_turno`, `localidade`) VALUES ('POSTO MUNICIPAL', 'SIM', 'SIM', '6', '2');
INSERT INTO `dadossocioambientais`.`posto_de_saude` (`nome`, `ambulatorial`, `urgencia_emergencia`, `medicos_por_turno`, `localidade`) VALUES ('POSTO MUNICIPAL', 'NÃO', 'SIM', '2', '3');



INSERT INTO `dadossocioambientais`.`entrevistado` (`nome`, `apelido`, `naturalidade`, `sexo`, `nascimento_data`, `escolaridade`, `estado_civil`, `religiao`, `morador`, `data_chegada`, `relacao_area_imovel`, `relacao_vizinhos`, `tipo_alimentacao`, `local_compras`, `servicos_deficitarios`, `sofreu_assaltos`, `presenciou_assalto`, `problemas_de_violencia_local`, `pretende_mudar`, `motivo_vontade_mudanca`, `conhece_ucs`, `conhece_uc_proposta`, `conhece_area_uc`, `utiliza_area_uc`, `proposta_melhorar_area`, `indicado_consulta_publica`, `contato_indicado_consulta_publica`, `instituicao_conhecida`, `importancia_de_proteger_ambiente`, `importancia_de_proteger_fauna`, `qual_espaco_precisa_ser_preservado`, `problemas_relacionados_ao_ambiente`, `como_cuida_saude_familia`, `localidade`) VALUES 
('Paulo José da Silva', 'Graviola', 'Finlândia', 'MASCULINO', '2025-06-11', 'ENSINO_SUPERIOR_COMPLETO', 'SOLTEIRO', 'Católico', 'SIM', '2025-06-11', 'Tetse', 'Teste', 'VEGETAIS', 'OUTRA_LOCALIDADE, Outras: Teste', 'Limpeza pública', '0', '0', 'Teste', 'NÃO', '', 'SIM', 'SIM', 'NÃO', 'NÃO', 'Teste', 'Tezt', 'Tez', 'Instituições Conhecidas: Tese', 'Tese', 'Testetets', 'Teze', 'Tezte', 'CONSULTA_COM_O_ENFERMEIRO_NO_POSTO_DE_SAUDE', '1');

INSERT INTO `dadossocioambientais`.`imovel` (`rua`, `numero`, `bairro`, `referencial`, `latitude`, `longitude`, `area_imovel`, `tipo_solo`, `vizinhos_confinantes`, `situacao_fundiaria`, `documentacao_imovel`, `limites`, `linhas_de_barco`, `pavimentacao`, `iluminacao_publica`, `equipamentos_urbanos`, `espacos_esporte_lazer`, `programa_infra_saneamento`, `entrevistado`) VALUES ('Rua', 'Numero', 'Baitro', 'Ref', 'Lat', 'L9g', '9.64', 'TERRA_FIRME', 'LADO_DIREITO, NAO_DECLARADO', 'POSSE', 'TÍTULO_DE_POSSE', 'CERCA_VIVA', 'Barcos', 'BLOKET', 'SIM', 'NÃO', 'BALNEÁRIOS', 'Nani', '1');
