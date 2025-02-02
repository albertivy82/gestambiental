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

INSERT INTO `dadossocioambientais`.`escola` (`nome`, `educacao_ambiental`, `merenda`, `transporte`, `localidade`) VALUES ('ESCOLA ESTADUAL DE ENSINO FUNDAMENTAL E MÉDIO NOSSA SENHORA DAS GRAÇAS', 'SIM', 'NÃO', 'SIM', '1');
INSERT INTO `dadossocioambientais`.`escola` (`nome`, `educacao_ambiental`, `merenda`, `transporte`, `localidade`) VALUES ('ESCOLA ESTADUAL DE ENSINO FUNDAMENTAL E MÉDIO PROFESSOR AMBRÓSIO', 'SIM', 'SIM', 'SIM', '1');
INSERT INTO `dadossocioambientais`.`escola` (`nome`, `educacao_ambiental`, `merenda`, `transporte`, `localidade`) VALUES ('ESCOLA MUNICIPAL DE ENSINO FUNDAMENTAL E MÉDIO GENERAL LIMA', 'SIM', 'SIM', 'NÃO', '2');
INSERT INTO `dadossocioambientais`.`escola` (`nome`, `educacao_ambiental`, `merenda`, `transporte`, `localidade`) VALUES ('ESCOLA ESTADUAL DE ENSINO FUNDAMENTAL E MÉDIO PROFESSORA JÚLIA', 'NÃO', 'SIM', 'SIM', '3');
INSERT INTO `dadossocioambientais`.`escola` (`nome`, `educacao_ambiental`, `merenda`, `transporte`, `localidade`) VALUES ('ESCOLA ESTADUAL DE ENSINO FUNDAMENTAL E MÉDIO NOSSA SENHORA DE NAZARÉ', 'SIM', 'NÃO', 'SIM', '3');


INSERT INTO `dadossocioambientais`.`posto_de_saude` (`nome`, `ambulatorial`, `urgencia_emergencia`, `medicos_por_turno`, `localidade`) VALUES ('POSTO MUNICIPAL', 'SIM', 'NÃO', '4', '1');
INSERT INTO `dadossocioambientais`.`posto_de_saude` (`nome`, `ambulatorial`, `urgencia_emergencia`, `medicos_por_turno`, `localidade`) VALUES ('POSTO MUNICIPAL', 'SIM', 'SIM', '6', '2');
INSERT INTO `dadossocioambientais`.`posto_de_saude` (`nome`, `ambulatorial`, `urgencia_emergencia`, `medicos_por_turno`, `localidade`) VALUES ('POSTO MUNICIPAL', 'NÃO', 'SIM', '2', '3');



