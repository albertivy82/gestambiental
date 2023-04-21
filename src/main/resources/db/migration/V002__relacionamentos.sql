ALTER TABLE `escola` ADD CONSTRAINT `fk_localidade_escola` FOREIGN KEY ( `localidade` ) REFERENCES `localidade` ( `id` );



ALTER TABLE `localidade_usuario` ADD CONSTRAINT `fk_usuario_localidade_usuario` FOREIGN KEY ( `usuario` ) REFERENCES `usuario` ( `id` );
ALTER TABLE `localidade_usuario` ADD CONSTRAINT `fk_localidade__usuario_localidade` FOREIGN KEY ( `localidade` ) REFERENCES `localidade` ( `id` );

ALTER TABLE `usuario_grupo` ADD CONSTRAINT `fk_grupo_usuario_grupo` FOREIGN KEY ( `grupo` ) REFERENCES `grupo` ( `id` );
ALTER TABLE `usuario_grupo` ADD CONSTRAINT `fk_usuario_grupo_usuario` FOREIGN KEY ( `usuario` ) REFERENCES `usuario` ( `id` );

ALTER TABLE `grupo_permissao` ADD CONSTRAINT `fk_permissao_grupo_permissao` FOREIGN KEY ( `permissao` ) REFERENCES `permissao` ( `id` );
ALTER TABLE `grupo_permissao` ADD CONSTRAINT `fk_grupo_permissao_grupo` FOREIGN KEY ( `grupo` ) REFERENCES `grupo` ( `id` );


ALTER TABLE `residencia` ADD CONSTRAINT `fk_localidade_residencia` FOREIGN KEY ( `localidade` ) REFERENCES `localidade` ( `id` );


ALTER TABLE `entrevistado` ADD CONSTRAINT `fk_residencia_entrevistado` FOREIGN KEY ( `residencia` ) REFERENCES `residencia` ( `id` );

ALTER TABLE `dados_de_consumo` ADD CONSTRAINT `fk_resdencia_dados_de_consuo` FOREIGN KEY ( `residencia` ) REFERENCES `residencia` ( `id` );

ALTER TABLE `servicos_basicos` ADD CONSTRAINT `fk_resdencia_servicos_basicos` FOREIGN KEY ( `residencia` ) REFERENCES `residencia` ( `id` );

ALTER TABLE `violencia` ADD CONSTRAINT `fk_residencia_violencia` FOREIGN KEY ( `residencia` ) REFERENCES `residencia` ( `id` );

ALTER TABLE `instituicao_conhecida` ADD CONSTRAINT `fk_residencia_instituicao_conhecida` FOREIGN KEY ( `residencia` ) REFERENCES `residencia` ( `id` );


ALTER TABLE `atividade_produtiva` ADD CONSTRAINT `fk_residencia_atividade_economica` FOREIGN KEY ( `residencia` ) REFERENCES `residencia` ( `id` );
ALTER TABLE `renda_outras_fontes` ADD CONSTRAINT `fk_residencia_renda_outras_fontes` FOREIGN KEY ( `residencia` ) REFERENCES `residencia` ( `id` );

ALTER TABLE `servicos_basicos` ADD CONSTRAINT `fk_residencia_servicos_basicos` FOREIGN KEY ( `residencia` ) REFERENCES `residencia` ( `id` );

ALTER TABLE `credito` ADD CONSTRAINT `fk_residencia_credito` FOREIGN KEY ( `residencia` ) REFERENCES `residencia` ( `id` );
ALTER TABLE `morador` ADD CONSTRAINT `fk_residencia_morador` FOREIGN KEY ( `residencia`) REFERENCES `residencia` ( `id` );

ALTER TABLE `indicado_consulta_publica` ADD CONSTRAINT `fk_entrevistado_indicado_consulta_publica` FOREIGN KEY ( `entrevistado`) REFERENCES `entrevistado` ( `id` );


ALTER TABLE `posto_de_saude` ADD CONSTRAINT `fk_localidade_posto_de_saude` FOREIGN KEY ( `localidade`) REFERENCES `localidade` ( `id` );


ALTER TABLE `morador_doenca` ADD CONSTRAINT `fk_morador_morador_doenca` FOREIGN KEY ( `morador` ) REFERENCES `morador` ( `id` );
ALTER TABLE `morador_doenca` ADD CONSTRAINT `fk_doenca_morador_doenca` FOREIGN KEY ( `doenca` ) REFERENCES `doenca` ( `id` );
