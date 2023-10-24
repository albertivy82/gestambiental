ALTER TABLE `escola` ADD CONSTRAINT `fk_localidade_escola` FOREIGN KEY ( `localidade` ) REFERENCES `localidade` ( `id` );

ALTER TABLE `usuario` ADD CONSTRAINT `fk_grupo_usuario` FOREIGN KEY ( `grupo` ) REFERENCES `grupo` ( `id` );


ALTER TABLE `grupo_permissao` ADD CONSTRAINT `fk_permissao_grupo_permissao` FOREIGN KEY ( `permissao` ) REFERENCES `permissao` ( `id` );
ALTER TABLE `grupo_permissao` ADD CONSTRAINT `fk_grupo_permissao_grupo` FOREIGN KEY ( `grupo` ) REFERENCES `grupo` ( `id` );


ALTER TABLE `imovel` ADD CONSTRAINT `fk_localidade_imovel` FOREIGN KEY ( `localidade` ) REFERENCES `localidade` ( `id` );


ALTER TABLE `entrevistado` ADD CONSTRAINT `fk_benfeitoria_entrevistado` FOREIGN KEY ( `benfeitoria` ) REFERENCES `benfeitoria` ( `id` );

ALTER TABLE `dados_de_consumo` ADD CONSTRAINT `fk_benfeitoria_dados_de_consuo` FOREIGN KEY ( `benfeitoria` ) REFERENCES `benfeitoria` ( `id` );

ALTER TABLE `servicos_basicos` ADD CONSTRAINT `fk_resdencia_servicos_basicos` FOREIGN KEY ( `benfeitoria` ) REFERENCES `benfeitoria` ( `id` );

ALTER TABLE `violencia` ADD CONSTRAINT `fk_benfeitoria_violencia` FOREIGN KEY ( `benfeitoria` ) REFERENCES `benfeitoria` ( `id` );

ALTER TABLE `instituicao_conhecida` ADD CONSTRAINT `fk_benfeitoria_instituicao_conhecida` FOREIGN KEY ( `benfeitoria` ) REFERENCES `benfeitoria` ( `id` );

ALTER TABLE `atividade_produtiva` ADD CONSTRAINT `fk_benfeitoria_atividade_economica` FOREIGN KEY ( `benfeitoria` ) REFERENCES `benfeitoria` ( `id` );

ALTER TABLE `renda_outras_fontes` ADD CONSTRAINT `fk_benfeitoria_renda_outras_fontes` FOREIGN KEY ( `benfeitoria` ) REFERENCES `benfeitoria` ( `id` );

ALTER TABLE `servicos_basicos` ADD CONSTRAINT `fk_benfeitoria_servicos_basicos` FOREIGN KEY ( `benfeitoria` ) REFERENCES `benfeitoria` ( `id` );

ALTER TABLE `credito` ADD CONSTRAINT `fk_benfeitoria_credito` FOREIGN KEY ( `benfeitoria` ) REFERENCES `benfeitoria` ( `id` );

ALTER TABLE `morador` ADD CONSTRAINT `fk_benfeitoria_morador` FOREIGN KEY ( `benfeitoria`) REFERENCES `benfeitoria` ( `id` );


ALTER TABLE `indicado_consulta_publica` ADD CONSTRAINT `fk_entrevistado_indicado_consulta_publica` FOREIGN KEY ( `entrevistado`) REFERENCES `entrevistado` ( `id` );


ALTER TABLE `posto_de_saude` ADD CONSTRAINT `fk_localidade_posto_de_saude` FOREIGN KEY ( `localidade`) REFERENCES `localidade` ( `id` );

ALTER TABLE `coordenada` ADD CONSTRAINT `fk_localidade_coordenada` FOREIGN KEY ( `localidade`) REFERENCES `localidade` ( `id` );

ALTER TABLE `morador_doenca` ADD CONSTRAINT `fk_morador_morador_doenca` FOREIGN KEY ( `morador` ) REFERENCES `morador` ( `id` );
ALTER TABLE `morador_doenca` ADD CONSTRAINT `fk_doenca_morador_doenca` FOREIGN KEY ( `doenca` ) REFERENCES `doenca` ( `id` );
