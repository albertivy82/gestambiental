CREATE TABLE `localidade` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `nome` varchar(255) NOT NULL,
  `municipio` varchar(100) NOT NULL,
  `esfera` varchar(15) NOT NULL,
   PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;

CREATE TABLE `escola` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `nome` varchar(255) NOT NULL,
  `iniciativa` varchar(255) NOT NULL,
  `merenda` varchar(5) NOT NULL,
  `transporte` varchar(5) NOT NULL,
  `educacao_ambiental` varchar(5) NOT NULL,
  `localidade` bigint(30) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;

CREATE TABLE `posto_de_saude` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `nome` varchar(255) NOT NULL,
  `ambulatorial` varchar(5) NOT NULL,
  `urgencia_emergencia` varchar(5) NOT NULL,
  `medicos_por_turno` bigint(5) NOT NULL,
  `localidade` bigint(30) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;


CREATE TABLE `coordenada` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `latitude` varchar(30) NOT NULL,
  `longitude` varchar(30) NOT NULL,
  `localidade` bigint(30) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;

CREATE TABLE `usuario` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `nome` varchar(255) NOT NULL,
  `matricula` varchar(100) NOT NULL,
  `email` varchar(100) NOT NULL,
  `cpf` varchar(100) NOT NULL,
  `senha` varchar(255) NOT NULL,
  `grupo` bigint(30) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;

CREATE TABLE `grupo` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `nome` varchar(255) NOT NULL,
   PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;

CREATE TABLE `permissao` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `nome` varchar(255) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;

CREATE TABLE `grupo_permissao` (
  `grupo` bigint(30) NOT NULL,
  `permissao` bigint(30) NOT NULL,
  primary key (grupo, permissao)
 )ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;


CREATE TABLE `entrevistado` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `nome` varchar(255) NOT NULL,
  `apelido` varchar(100) NOT NULL,
  `naturalidade` varchar(100) DEFAULT NULL,
  `sexo` varchar(20) NOT NULL,
  `nascimento_data` date NOT NULL,
  `escolaridade` varchar(50) NOT NULL,
  `estado_civil` varchar(50) NOT NULL,
  `religiao` varchar(100) NOT NULL,
  `morador` varchar(20) NOT NULL,
  `data_chegada` date NOT NULL,
  `relacao_area_imovel` varchar(255) NOT NULL,
  `relacao_vizinhos` varchar(255) NOT NULL,
  `tipo_alimentacao` varchar(100) NOT NULL,
  `local_compras` varchar(255) NOT NULL,
  `servicos_deficitarios` varchar(255) NOT NULL,
  `sofreu_assaltos` int(11) NOT NULL,
  `presenciou_assalto` int(11) NOT NULL,
  `problemas_de_violencia_local` varchar(255) NOT NULL,
  `pretende_mudar` varchar(20) NOT NULL,
  `motivo_vontade_mudanca` varchar(255) DEFAULT NULL,
  `conhece_ucs` varchar(20) NOT NULL,
  `conhece_uc_proposta` varchar(20) NOT NULL,
  `conhece_area_uc` varchar(20) NOT NULL,
  `utiliza_area_uc` varchar(20) NOT NULL,
  `proposta_melhorar_area` varchar(255) NOT NULL,
  `indicado_consulta_publica` varchar(150) NOT NULL,
  `contato_indicado_consulta_publica` varchar(50) NOT NULL,
  `instituicao_conhecida` varchar(255) DEFAULT NULL,
  `importancia_de_proteger_ambiente` varchar(255) DEFAULT NULL,
  `importancia_de_proteger_fauna` varchar(255) DEFAULT NULL,
  `qual_espaco_precisa_ser_preservado` varchar(255) DEFAULT NULL,
  `problemas_relacionados_ao_ambiente` varchar(255) DEFAULT NULL,
  `como_cuida_saude_familia` varchar(255) DEFAULT NULL,
  `localidade` bigint(20) NOT NULL,
  PRIMARY KEY (`id`),
  FOREIGN KEY (`localidade`) REFERENCES `localidade` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;


CREATE TABLE `imovel` (
   `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `rua` varchar(255) NOT NULL,
  `numero` varchar(10) NOT NULL,
  `bairro` varchar(255) NOT NULL,
  `referencial` varchar(255) NOT NULL,
  `latitude` varchar(255) NOT NULL,
  `longitude` varchar(255) NOT NULL,
  `area_imovel` double NOT NULL,
  `tipo_solo` varchar(60) NOT NULL,
  `vizinhos_confinantes` varchar(255) NOT NULL,
  `situacao_fundiaria` varchar(100) NOT NULL,
  `documentacao_imovel` varchar(100) NOT NULL,
  `limites` varchar(100) NOT NULL,
  `linhas_de_barco` varchar(100) NOT NULL,
  `pavimentacao` varchar(255) NOT NULL,
  `iluminacao_publica` varchar(100) NOT NULL,
  `equipamentos_urbanos` varchar(255) NOT NULL,
  `espacos_esporte_lazer` varchar(100) NOT NULL,
  `programa_infra_saneamento` varchar(100) NOT NULL,
  `entrevistado` bigint(20) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;


CREATE TABLE benfeitoria (
  `id` BIGINT(20) NOT NULL AUTO_INCREMENT,
  `tipo_benfeitoria` VARCHAR(50) NOT NULL,
  `funcao` VARCHAR(50) NOT NULL,
  `tipo_solo` VARCHAR(50) NOT NULL,
  `area_benfeitoria` DOUBLE NOT NULL,
  `pavimentos` INT NOT NULL,
  `tipo_construcao` VARCHAR(150) NOT NULL,
  `tipo_cobertura` VARCHAR(150) NOT NULL,
  `tipo_esquadrias` VARCHAR(150) NOT NULL,
  `alagamentos` VARCHAR(150) NOT NULL,
  `nivel_alagamentos` VARCHAR(150) NOT NULL,
  `efluentes` VARCHAR(150) NOT NULL,
  `residuos` VARCHAR(150) NOT NULL,
  `fonte_energia` VARCHAR(150) NOT NULL,
  `energia_alimentos` VARCHAR(150) NOT NULL,
  `informativo_predominante` VARCHAR(150) NOT NULL,
  `importancia_de_proteger_fauna` VARCHAR(250),
  `importancia_de_proteger_ambiente` VARCHAR(250),
  `qual_espaco_precisa_ser_preservado` VARCHAR(250),
  `problemas_relacionados_ao_ambiente` VARCHAR(250),
  `imovel` bigint(20) NOT NULL,
  PRIMARY KEY (id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

CREATE TABLE `agua` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `tipo_de_fornecimento` VARCHAR(255) NOT NULL,
  `metodo_tratamento` VARCHAR(255) NOT NULL,
  `cor_dagua` VARCHAR(255),
  `cheiro_dagua` VARCHAR(255),
  `sabor_dagua` VARCHAR(255),
  `profundidade_poco` double,
  `benfeitoria` bigint(20),
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;


CREATE TABLE `compras` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `onde_faz_compras` varchar(255) NOT NULL,
  `detalhe_local_de_compras` varchar(255),
  `benfeitoria` bigint(30) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;

CREATE TABLE `dependencias` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `dependencia` varchar(255) NOT NULL,
  `quantidade` INT NOT NULL,
  `benfeitoria` bigint(30) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;

CREATE TABLE `servicos_comunicacao` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `tipo_servico_comunicacao` varchar(150) NOT NULL,
  `operadora_servico_comunicacao` varchar(150) NOT NULL,
  `benfeitoria` bigint(30) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;


CREATE TABLE `vegetacao` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `especie` VARCHAR(150),
  `uso_medicinal` VARCHAR(50) NOT NULL,
  `uso_alimentacao` VARCHAR(50) NOT NULL,
  `uso_ornamental` VARCHAR(50) NOT NULL,
  `uso_comercial` VARCHAR(50) NOT NULL,
  `usa_flor` VARCHAR(50) NOT NULL,
  `usa_folha` VARCHAR(50) NOT NULL,
  `usa_semente` VARCHAR(50) NOT NULL,
  `usa_fruto` VARCHAR(50) NOT NULL,
  `usa_casca` VARCHAR(50) NOT NULL,
  `usa_raiz` VARCHAR(50) NOT NULL,
  `uso_leite_latex` VARCHAR(50) NOT NULL,
  `outros_usos` VARCHAR(50) NOT NULL,
  `coleta_local_publico` VARCHAR(50) NOT NULL,
  `coleta_cultivo` VARCHAR(50) NOT NULL,
  `coleta_compra` VARCHAR(50) NOT NULL,
  `coleta_ambiente_especifica` VARCHAR(50) NOT NULL,
  `quem_ensinou_uso` VARCHAR(255),
  `repassa_conhecimento` VARCHAR(255),
  `observacoes_espontaneas` VARCHAR(255),
  `entrevistado` bigint(20) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;

CREATE TABLE `fauna` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `especie` VARCHAR(150),
  `ocorre_mata` VARCHAR(50) NOT NULL,
  `ocorre_rio` VARCHAR(50) NOT NULL,
  `ocorre_lago` VARCHAR(50) NOT NULL,
  `ocorre_rua` VARCHAR(50) NOT NULL,
  `ocorre_quintal` VARCHAR(50) NOT NULL,
  `outras_ocorrencias` VARCHAR(50) NOT NULL,
  `ferequencia_atual` VARCHAR(50) NOT NULL,
  `ferequencia_passada` VARCHAR(50) NOT NULL,
  `tempo_que_nao_ve` VARCHAR(50) NOT NULL,
  `entrevistado` bigint(20),
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;

CREATE TABLE `peixes` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `especie` VARCHAR(255),
  `locais_especiais` VARCHAR(150) NOT NULL,
  `locais_especificos_alimentacao` VARCHAR(255) NOT NULL,
  `uso_alimnetacao` VARCHAR(50) NOT NULL,
  `uso_comercio` VARCHAR(50) NOT NULL,
  `entrevistado` bigint(20),
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;

CREATE TABLE `repteis` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `especie` VARCHAR(150),
  `local` VARCHAR(150),
  `periodo` VARCHAR(50),
  `uso` VARCHAR(150),
  `ameacado` VARCHAR(50),
  `problemas_relacionados` VARCHAR(255),
  `cacado` VARCHAR(50),
  `descricao_espontanea` VARCHAR(255),
  `entrevistado` bigint(20),
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;

CREATE TABLE `mamiferos` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `especie` VARCHAR(255),
  `uso_consumo` VARCHAR(50) NOT NULL,
  `uso_comercio` VARCHAR(50) NOT NULL,
  `uso_criacao` VARCHAR(50) NOT NULL,
  `uso_remedio` VARCHAR(50) NOT NULL,
  `uso_outros` VARCHAR(150) NOT NULL,
  `priblemas_relacionados` VARCHAR(150),
  `alimentacao` VARCHAR(255),
  `desricao_espontanea` VARCHAR(255),
  `entrevistado` bigint(20),
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;

CREATE TABLE `aves` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `especie` VARCHAR(255),
  `uso_consumo` VARCHAR(50) NOT NULL,
  `usoComercio` VARCHAR(50) NOT NULL,
  `uso-criacao` VARCHAR(50) NOT NULL,
  `uso_remedio` VARCHAR(50) NOT NULL,
  `uso_outros` VARCHAR(50) NOT NULL,
  `priblemas_relacionados` VARCHAR(255),
  `ameaca_sofrida` VARCHAR(255),
  `local_de_aglomeracao` VARCHAR(255),
  `qual_impotancia_da_especie` VARCHAR(255),
  `alimentacao` VARCHAR(255),
  `desricao_espontanea` VARCHAR(255),
  `entrevistado` bigint(20),
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;


CREATE TABLE `atividade_produtiva` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `atividade` varchar(255) NOT NULL,
  `pessoas_envolvidas` bigint(30) NOT NULL,
  `faturamento_atividade_mes_total` decimal(19,2) NOT NULL,
  `benfeitoria` bigint(30) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;

CREATE TABLE `renda_outras_fontes` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `fonte` varchar(100) NOT NULL,
  `beneficiarios` bigint(30) NOT NULL,
  `renda_mes_total` decimal(19,2) NOT NULL,
  `benfeitoria` bigint(30) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;

CREATE TABLE `credito` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `nome` varchar(255) DEFAULT NULL,
  `valor` decimal(19,2) DEFAULT NULL,
  `benfeitoria` bigint(30) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;

CREATE TABLE `morador` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `data_nascimento` date NOT NULL,
  `escolaridade` varchar(255) NOT NULL,
  `estado_civil` varchar(255) NOT NULL,
  `idade` int(3) NOT NULL,
  `onde_estuda` varchar(255) DEFAULT NULL,
  `perfil` varchar(255) NOT NULL,
  `religiao` varchar(255) NOT NULL,
  `sexo` varchar(255) NOT NULL,
  `trabalho` varchar(5) NOT NULL,
  `benfeitoria` bigint(30) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;



CREATE TABLE `pesca_artesanal` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `freq_pesca_semanal` int NOT NULL,
  `horas_por_dia` double NOT NULL,
  `local_da_pesca` VARCHAR(255) NOT NULL,
  `horario_prefencial_pesca` VARCHAR(255) NOT NULL,
  `descarte_por_pescaria` float NOT NULL,
  `gelo_por_pescaria` double NOT NULL,
  `custo_gelo_por_pescaria` double NOT NULL,
  `composicao_rancho` VARCHAR(255) NOT NULL,
  `custo_rancho_por_viagem` double NOT NULL,
  `combustivel_por_viagem` double NOT NULL,
  `custo_combustivel_por_viagem` double NOT NULL,
  `local_desembarque` VARCHAR(255) NOT NULL,
  `pesca_por_safra` double NOT NULL,
  `local_pesca_safra` VARCHAR(255) NOT NULL,
  `local_de_reproducao_peixe` VARCHAR(255) NOT NULL,
  `periodo_defeso` VARCHAR(100) NOT NULL,
  `conhece_defeso` VARCHAR(50) NOT NULL,
  `concorda_defeso` VARCHAR(50) NOT NULL,
  `recebe_defeso` VARCHAR(150) NOT NULL,
  `benfeitoria` bigint(20) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;

CREATE TABLE `pesca_artesanal_conservacao_peixe` (
  `pesca_artesanal` bigint(20) NOT NULL,
  `conservacao_peixe` VARCHAR(255) NOT NULL,
  FOREIGN KEY (`pesca_artesanal`) REFERENCES `pesca_artesanal` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;

CREATE TABLE `pesca_artesanal_custeio` (
  `pesca_artesanal` bigint(20) NOT NULL,
  `custeio` VARCHAR(255) NOT NULL,
  FOREIGN KEY (`pesca_artesanal`) REFERENCES `pesca_artesanal` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;

CREATE TABLE `destino_pesca` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `destinacao` VARCHAR(255),
  `quantidade` double,
  `destino` VARCHAR(255),
  `destino_fixo` VARCHAR(255),
  `para_quantos` int,
  `pesca_artesanal` bigint(20) NOT NULL,
  PRIMARY KEY (`id`),
  FOREIGN KEY (`pesca_artesanal`) REFERENCES `pesca_artesanal` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;

CREATE TABLE `quantidadePescaPorTipo` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `quantidade_pesca` double,
  `tipo_pesca` VARCHAR(255),
  `pesca_artesanal` bigint(20) NOT NULL,
  PRIMARY KEY (`id`),
  FOREIGN KEY (`pesca_artesanal`) REFERENCES `pesca_artesanal` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;

CREATE TABLE `embarcacao` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `numeracao` VARCHAR(255),
  `tipo_barco` VARCHAR(255),
  `tipo_casco` VARCHAR(255),
  `pesca_artesanal` bigint(20) NOT NULL,
  PRIMARY KEY (`id`),
  FOREIGN KEY (`pesca_artesanal`) REFERENCES `pesca_artesanal` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;


CREATE TABLE `especie` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `especie` VARCHAR(255) NOT NULL,
  `quantidade_pescada` double NOT NULL,
  `quantidade_da_pesca` VARCHAR(255),
  `tamanho_da_pesca` VARCHAR(255),
  `exploracao_nivel` VARCHAR(255),
  `preco_venda_medio_kg` double NOT NULL,
  `importancia` VARCHAR(255) NOT NULL,
  `meses_maior_ocorrencia` VARCHAR(255) NOT NULL,
  `pesca_artesanal` bigint(20) NOT NULL,
  PRIMARY KEY (`id`),
  FOREIGN KEY (`pesca_artesanal`) REFERENCES `pesca_artesanal` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;















