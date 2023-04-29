INSERT INTO `dadossocioambienenentais`.`usuario` (`nome`, `matricula`, `email`, `cpf`, `senha`) VALUES ('Mangusto César', '75865498', 'mangusto@gmail.com', '45678912325', '$2a$12$U/kbP6nqpeirrPZ4QFkr6uGfqfFLN4cUjW9m.6vlrnS86.hs1xbXK');
INSERT INTO `dadossocioambienenentais`.`usuario` (`nome`, `matricula`, `email`, `cpf`, `senha`) VALUES ('Albert Pereira', '57213092', 'albert@gmail.com', '75145987234', '$2a$12$U/kbP6nqpeirrPZ4QFkr6uGfqfFLN4cUjW9m.6vlrnS86.hs1xbXK');
INSERT INTO `dadossocioambienenentais`.`usuario` (`nome`, `matricula`, `email`, `cpf`, `senha`) VALUES ('Camarão Empanado', '57356985', 'camarao@gmail.com', '32145698758', '$2a$12$U/kbP6nqpeirrPZ4QFkr6uGfqfFLN4cUjW9m.6vlrnS86.hs1xbXK');
INSERT INTO `dadossocioambienenentais`.`usuario` (`nome`, `matricula`, `email`, `cpf`, `senha`) VALUES ('Boi Ralado', '58965232', 'boi@gmail.com', '74125896332', '$2a$12$U/kbP6nqpeirrPZ4QFkr6uGfqfFLN4cUjW9m.6vlrnS86.hs1xbXK');
INSERT INTO `dadossocioambienenentais`.`usuario` (`nome`, `matricula`, `email`, `cpf`, `senha`) VALUES ('Porco a Purururca', '56989632', 'porco@gmail.com', '96587412336', '$2a$12$U/kbP6nqpeirrPZ4QFkr6uGfqfFLN4cUjW9m.6vlrnS86.hs1xbXK');


INSERT INTO `dadossocioambienenentais`.`permissao` (`nome`) VALUES ('EDITAR_DADOS_SOCIAIS');
INSERT INTO `dadossocioambienenentais`.`permissao` (`nome`) VALUES ('EDITAR_USUARIO');
INSERT INTO `dadossocioambienenentais`.`permissao` (`nome`) VALUES ('EDITAR_LOCALIDADE');


INSERT INTO `dadossocioambienenentais`.`grupo` (`nome`) VALUES ('ADMINISTRADOR');
INSERT INTO `dadossocioambienenentais`.`grupo` (`nome`) VALUES ('GESTOR_AMBIENTAL');
INSERT INTO `dadossocioambienenentais`.`grupo` (`nome`) VALUES ('GERENTE_AMBIENTAL');
INSERT INTO `dadossocioambienenentais`.`grupo` (`nome`) VALUES ('ANALISTA_AMBIENTAL');


INSERT INTO `dadossocioambienenentais`.`localidade` (`nome`, `latitude`, `longitude`, `municipio`) VALUES ('Boa Vsita de Irirteua', '6786768', '768767', 'CURUÇÁ');
INSERT INTO `dadossocioambienenentais`.`localidade` (`nome`, `latitude`, `longitude`, `municipio`) VALUES ('Maracangalha', '5455454', '5454544', 'BELÉM');
INSERT INTO `dadossocioambienenentais`.`localidade` (`nome`, `latitude`, `longitude`, `municipio`) VALUES ('Árvore Gigante', '55255555', '768767', 'SANTARÉM');


INSERT INTO `dadossocioambienenentais`.`grupo_permissao` (`grupo`, `permissao`) VALUES ('1', '1');
INSERT INTO `dadossocioambienenentais`.`grupo_permissao` (`grupo`, `permissao`) VALUES ('1', '2');
INSERT INTO `dadossocioambienenentais`.`grupo_permissao` (`grupo`, `permissao`) VALUES ('1', '3');
INSERT INTO `dadossocioambienenentais`.`grupo_permissao` (`grupo`, `permissao`) VALUES ('2', '1');
INSERT INTO `dadossocioambienenentais`.`grupo_permissao` (`grupo`, `permissao`) VALUES ('3', '1');

INSERT INTO `dadossocioambienenentais`.`usuario_grupo` (`usuario`, `grupo`) VALUES ('1', '1');
INSERT INTO `dadossocioambienenentais`.`usuario_grupo` (`usuario`, `grupo`) VALUES ('2', '2');
INSERT INTO `dadossocioambienenentais`.`usuario_grupo` (`usuario`, `grupo`) VALUES ('3', '3');
INSERT INTO `dadossocioambienenentais`.`usuario_grupo` (`usuario`, `grupo`) VALUES ('4', '4');
INSERT INTO `dadossocioambienenentais`.`usuario_grupo` (`usuario`, `grupo`) VALUES ('5', '4');
