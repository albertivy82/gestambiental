ALTER TABLE `escola` ADD CONSTRAINT `fk_localidade_escola` FOREIGN KEY ( `localidade` ) REFERENCES `localidade` ( `id` ) ON DELETE CASCADE;
ALTER TABLE `posto_de_saude` ADD CONSTRAINT `fk_localidade_posto_de_saude` FOREIGN KEY ( `localidade`) REFERENCES `localidade` ( `id` ) ON DELETE CASCADE;
ALTER TABLE `coordenada` ADD CONSTRAINT `fk_localidade_coordenada` FOREIGN KEY ( `localidade`) REFERENCES `localidade` ( `id` ) ON DELETE CASCADE;

ALTER TABLE `usuario` ADD CONSTRAINT `fk_grupo_usuario` FOREIGN KEY ( `grupo` ) REFERENCES `grupo` ( `id` );
ALTER TABLE `grupo_permissao` ADD CONSTRAINT `fk_permissao_grupo_permissao` FOREIGN KEY ( `permissao` ) REFERENCES `permissao` ( `id` );
ALTER TABLE `grupo_permissao` ADD CONSTRAINT `fk_grupo_permissao_grupo` FOREIGN KEY ( `grupo` ) REFERENCES `grupo` ( `id` );



ALTER TABLE `entrevistado` ADD CONSTRAINT `fk_localidade_entrevistado` FOREIGN KEY ( `localidade` ) REFERENCES `localidade` ( `id` ) ON DELETE CASCADE;
ALTER TABLE `vegetacao` ADD CONSTRAINT `fk_entrevistado_vegetacao` FOREIGN KEY (`entrevistado`) REFERENCES `entrevistado` (`id`) ON DELETE CASCADE;
ALTER TABLE `fauna` ADD CONSTRAINT `fk_entrevistado_fauna` FOREIGN KEY (`entrevistado`) REFERENCES `entrevistado` (`id`) ON DELETE CASCADE;
ALTER TABLE `peixes` ADD CONSTRAINT `fk_entrevistado_peixes` FOREIGN KEY (`entrevistado`) REFERENCES `entrevistado` (`id`) ON DELETE CASCADE;
ALTER TABLE `repteis` ADD CONSTRAINT `fk_entrevistado_repteis` FOREIGN KEY (`entrevistado`) REFERENCES `entrevistado` (`id`) ON DELETE CASCADE;
ALTER TABLE `mamiferos` ADD CONSTRAINT `fk_entrevistado_mamiferos` FOREIGN KEY (`entrevistado`) REFERENCES `entrevistado` (`id`) ON DELETE CASCADE;
ALTER TABLE `aves` ADD CONSTRAINT `fk_entrevistado_aves` FOREIGN KEY (`entrevistado`) REFERENCES `entrevistado` (`id`) ON DELETE CASCADE;




ALTER TABLE `compras` ADD CONSTRAINT `fk_benfeitoria_compras` FOREIGN KEY ( `benfeitoria` ) REFERENCES `benfeitoria` ( `id` )ON DELETE CASCADE;
ALTER TABLE `dependencias` ADD CONSTRAINT `fk_benfeitoria_dependencias` FOREIGN KEY ( `benfeitoria` ) REFERENCES `benfeitoria` ( `id` ) ON DELETE CASCADE;
ALTER TABLE `servicos_comunicacao` ADD CONSTRAINT `fk_benfeitoria_servicos_comunicacao` FOREIGN KEY ( `benfeitoria` ) REFERENCES `benfeitoria` ( `id` ) ON DELETE CASCADE;
ALTER TABLE `agua` ADD CONSTRAINT `fk_benfeitoria_agua` FOREIGN KEY ( `benfeitoria` ) REFERENCES `benfeitoria` ( `id` ) ON DELETE CASCADE;
ALTER TABLE `atividade_produtiva` ADD CONSTRAINT `fk_benfeitoria_atividade_economica` FOREIGN KEY ( `benfeitoria` ) REFERENCES `benfeitoria` ( `id` ) ON DELETE CASCADE;
ALTER TABLE `renda_outras_fontes` ADD CONSTRAINT `fk_benfeitoria_renda_outras_fontes` FOREIGN KEY ( `benfeitoria` ) REFERENCES `benfeitoria` ( `id` ) ON DELETE CASCADE;
ALTER TABLE `credito` ADD CONSTRAINT `fk_benfeitoria_credito` FOREIGN KEY ( `benfeitoria` ) REFERENCES `benfeitoria` ( `id` ) ON DELETE CASCADE;
ALTER TABLE `morador` ADD CONSTRAINT `fk_benfeitoria_morador` FOREIGN KEY ( `benfeitoria`) REFERENCES `benfeitoria` ( `id` ) ON DELETE CASCADE;
ALTER TABLE `pesca_artesanal` ADD CONSTRAINT `fk_benfeitoria_pesca_artesanal` FOREIGN KEY ( `benfeitoria`) REFERENCES `benfeitoria` ( `id` ) ON DELETE CASCADE;





ALTER TABLE `benfeitoria` ADD CONSTRAINT `fk_imovel_benfeitoria` FOREIGN KEY ( `imovel` ) REFERENCES `imovel` ( `id` ) ON DELETE CASCADE;

ALTER TABLE `imovel` ADD CONSTRAINT `fk_entrevistado_imovel` FOREIGN KEY (`entrevistado`) REFERENCES `entrevistado` (`id`) ON DELETE CASCADE;

ALTER TABLE `participacao_instituicao` ADD CONSTRAINT `fk_articipacao_instituicao_morador` FOREIGN KEY (`morador`) REFERENCES `morador` (`id`) ON DELETE CASCADE;
