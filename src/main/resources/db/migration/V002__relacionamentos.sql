ALTER TABLE `escola` ADD CONSTRAINT `fk_localidade_escola` FOREIGN KEY ( `localidade` ) REFERENCES `localidade` ( `id` );

ALTER TABLE `usuario` ADD CONSTRAINT `fk_grupo_usuario` FOREIGN KEY ( `grupo` ) REFERENCES `grupo` ( `id` );


ALTER TABLE `grupo_permissao` ADD CONSTRAINT `fk_permissao_grupo_permissao` FOREIGN KEY ( `permissao` ) REFERENCES `permissao` ( `id` );
ALTER TABLE `grupo_permissao` ADD CONSTRAINT `fk_grupo_permissao_grupo` FOREIGN KEY ( `grupo` ) REFERENCES `grupo` ( `id` );






ALTER TABLE `imovel` ADD CONSTRAINT `fk_localidade_imovel` FOREIGN KEY ( `localidade` ) REFERENCES `localidade` ( `id` );



ALTER TABLE `compras` ADD CONSTRAINT `fk_benfeitoria_compras` FOREIGN KEY ( `benfeitoria` ) REFERENCES `benfeitoria` ( `id` );
ALTER TABLE `dependencias` ADD CONSTRAINT `fk_benfeitoria_dependencias` FOREIGN KEY ( `benfeitoria` ) REFERENCES `benfeitoria` ( `id` );
ALTER TABLE `servicos_comunicacao` ADD CONSTRAINT `fk_benfeitoria_servicos_comunicacao` FOREIGN KEY ( `benfeitoria` ) REFERENCES `benfeitoria` ( `id` );
ALTER TABLE `vegetacao` ADD CONSTRAINT `fk_benfeitoria_vegetacao` FOREIGN KEY ( `benfeitoria` ) REFERENCES `benfeitoria` ( `id` );
ALTER TABLE `fauna` ADD CONSTRAINT `fk_benfeitoria_fauna` FOREIGN KEY ( `benfeitoria` ) REFERENCES `benfeitoria` ( `id` );
ALTER TABLE `peixes` ADD CONSTRAINT `fk_benfeitoria_peixes` FOREIGN KEY ( `benfeitoria` ) REFERENCES `benfeitoria` ( `id` );
ALTER TABLE `repteis` ADD CONSTRAINT `fk_benfeitoria_repteis` FOREIGN KEY ( `benfeitoria` ) REFERENCES `benfeitoria` ( `id` );
ALTER TABLE `mamiferos` ADD CONSTRAINT `fk_benfeitoria_mamiferos` FOREIGN KEY ( `benfeitoria` ) REFERENCES `benfeitoria` ( `id` );
ALTER TABLE `aves` ADD CONSTRAINT `fk_benfeitoria_aves` FOREIGN KEY ( `benfeitoria` ) REFERENCES `benfeitoria` ( `id` );
ALTER TABLE `agua` ADD CONSTRAINT `fk_benfeitoria_agua` FOREIGN KEY ( `benfeitoria` ) REFERENCES `benfeitoria` ( `id` );
ALTER TABLE `violencia` ADD CONSTRAINT `fk_benfeitoria_violencia` FOREIGN KEY ( `benfeitoria` ) REFERENCES `benfeitoria` ( `id` );
ALTER TABLE `instituicao_conhecida` ADD CONSTRAINT `fk_benfeitoria_instituicao_conhecida` FOREIGN KEY ( `benfeitoria` ) REFERENCES `benfeitoria` ( `id` );
ALTER TABLE `atividade_produtiva` ADD CONSTRAINT `fk_benfeitoria_atividade_economica` FOREIGN KEY ( `benfeitoria` ) REFERENCES `benfeitoria` ( `id` );
ALTER TABLE `renda_outras_fontes` ADD CONSTRAINT `fk_benfeitoria_renda_outras_fontes` FOREIGN KEY ( `benfeitoria` ) REFERENCES `benfeitoria` ( `id` );
ALTER TABLE `credito` ADD CONSTRAINT `fk_benfeitoria_credito` FOREIGN KEY ( `benfeitoria` ) REFERENCES `benfeitoria` ( `id` );
ALTER TABLE `morador` ADD CONSTRAINT `fk_benfeitoria_morador` FOREIGN KEY ( `benfeitoria`) REFERENCES `benfeitoria` ( `id` );
ALTER TABLE `pesca_artesanal` ADD CONSTRAINT `fk_benfeitoria_pesca_artesanal` FOREIGN KEY ( `benfeitoria`) REFERENCES `benfeitoria` ( `id` );


ALTER TABLE `benfeitoria_alimentacao` ADD CONSTRAINT `fk_benfeitoria_alimentacao_benfeitoria` FOREIGN KEY ( `alimentacao` ) REFERENCES `alimentacao` ( `id` );
ALTER TABLE `benfeitoria_alimentacao` ADD CONSTRAINT `fk_alimentacao_benfeitoria_alimentacao` FOREIGN KEY ( `benfeitoria` ) REFERENCES `benfeitoria` ( `id` );

ALTER TABLE `entrevistado` ADD CONSTRAINT `fk_imovel_entrevistado` FOREIGN KEY ( `imovel` ) REFERENCES `imovel` ( `id` );
ALTER TABLE `indicado_consulta_publica` ADD CONSTRAINT `fk_entrevistado_indicado_consulta_publica` FOREIGN KEY ( `entrevistado`) REFERENCES `entrevistado` ( `id` );


ALTER TABLE `posto_de_saude` ADD CONSTRAINT `fk_localidade_posto_de_saude` FOREIGN KEY ( `localidade`) REFERENCES `localidade` ( `id` );

ALTER TABLE `coordenada` ADD CONSTRAINT `fk_localidade_coordenada` FOREIGN KEY ( `localidade`) REFERENCES `localidade` ( `id` );

ALTER TABLE `morador_doenca` ADD CONSTRAINT `fk_morador_morador_doenca` FOREIGN KEY ( `morador` ) REFERENCES `morador` ( `id` );
ALTER TABLE `morador_doenca` ADD CONSTRAINT `fk_doenca_morador_doenca` FOREIGN KEY ( `doenca` ) REFERENCES `doenca` ( `id` );


ALTER TABLE `imovel_servicos_basicos` ADD CONSTRAINT `fk_imovel_servicos_basicos` FOREIGN KEY ( `imovel` ) REFERENCES `imovel` ( `id` );
ALTER TABLE `imovel_servicos_basicos` ADD CONSTRAINT `fk_servicos_basicos_imovel` FOREIGN KEY ( `servicos_basicos` ) REFERENCES `servicos_basicos` ( `id` );


ALTER TABLE `imovel_atendimento_saude` ADD CONSTRAINT `fk_imovel_atendimento_saude` FOREIGN KEY ( `imovel` ) REFERENCES `imovel` ( `id` );
ALTER TABLE `imovel_atendimento_saude` ADD CONSTRAINT `fk_atendimento_saude_imovel` FOREIGN KEY ( `atendimento_saude` ) REFERENCES `atendimento_saude` ( `id` );

ALTER TABLE `imovel_outros_servicos` ADD CONSTRAINT `fk_imovel_outros_servicos` FOREIGN KEY ( `imovel` ) REFERENCES `imovel` ( `id` );
ALTER TABLE `imovel_outros_servicos` ADD CONSTRAINT `fk_outros_servicos_imovel` FOREIGN KEY ( `outros_servicos` ) REFERENCES `outros_servicos` ( `id` );


ALTER TABLE `benfeitoria` ADD CONSTRAINT `fk_imovel_benfeitoria` FOREIGN KEY ( `imovel` ) REFERENCES `imovel` ( `id` );
