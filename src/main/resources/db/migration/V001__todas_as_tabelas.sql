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
  `educacao_ambiental` varchar(5) NOT NULL,
  `merenda` varchar(5) NOT NULL,
  `transporte` varchar(5) NOT NULL,
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



CREATE TABLE `imovel` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `rua` varchar(255) DEFAULT NULL,
  `numero` varchar(10) DEFAULT NULL,
  `bairro` varchar(255) DEFAULT NULL,
  `referencial` varchar(255) NOT NULL,
  `latitude` varchar(255) NOT NULL,
  `longitude` varchar(255) NOT NULL,
  `area_imovel` double NOT NULL,
  `vizinhos` varchar(255) NOT NULL,
  `situacao_fundiaria` varchar(100) NOT NULL,
  `documentacao_imovel` varchar(100) NOT NULL,
  `data_chegada` date NOT NULL,
  `pretende_mudar` varchar(255) NOT NULL,
  `motivo_vontade_mudanca` varchar(255) DEFAULT NULL,  
  `relacao_area` varchar(255) NOT NULL,
  `relacao_vizinhos` varchar(255) NOT NULL,
  `limites` varchar(100) NOT NULL,
  `iluminacao_publica` varchar(100) NOT NULL,
  `transporte` varchar(100) NOT NULL,
  `programa_infra_saneamento` varchar(100) NOT NULL,
  `linhas_de_barco` varchar(100) NOT NULL,
  `tipo_solo` varchar(100) NOT NULL,
  `esporte_lazer` varchar(100) NOT NULL,
  `localidade` bigint(30) NOT NULL,
   PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;

CREATE TABLE `entrevistado` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `nome` varchar(255) DEFAULT NULL,
  `apelido` varchar(100) DEFAULT NULL,
  `naturalidade` varchar(100) DEFAULT NULL,
  `conhece_uc_proposta` varchar(100) DEFAULT NULL,
  `proposta_melhorar_area` varchar(255) DEFAULT NULL,
  `imovel` bigint(30) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;

CREATE TABLE `atendimento_saude` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `tipo_atendimento` varchar(100) NOT NULL,
  `imovel` bigint(30) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;

CREATE TABLE `outros_servicos` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `outros_servicos` varchar(100) NOT NULL,
  `imovel` bigint(30) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;


CREATE TABLE `imovel_servicos_basicos` (
  `imovel` bigint(30) NOT NULL,
  `servicos_basicos` bigint(30) NOT NULL,
  primary key (imovel, servicos_basicos)
 )ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;


 CREATE TABLE `imovel_atendimento_saude` (
  `imovel` bigint(30) NOT NULL,
  `atendimento_saude` bigint(30) NOT NULL,
  primary key (imovel, atendimento_saude)
 )ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;


CREATE TABLE `imovel_outros_servicos` (
  `imovel` bigint(30) NOT NULL,
  `outros_servicos` bigint(30) NOT NULL,
  primary key (imovel, outros_servicos)
 )ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;

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

CREATE TABLE benfeitoria_material_construcao (
  `benfeitoria_id` BIGINT(20) NOT NULL,
  `origem_material_construcao` VARCHAR(255) NOT NULL,
  FOREIGN KEY (benfeitoria_id) REFERENCES benfeitoria(id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

CREATE TABLE `dados_de_consumo` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `alimentacao_principal` varchar(255) NOT NULL,
  `local_de_compras` varchar(255) NOT NULL,
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
  `benfeitoria` bigint(20) NOT NULL,
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
  `benfeitoria` bigint(20),
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;

CREATE TABLE `peixes` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `especie` VARCHAR(255),
  `locais_especiais` VARCHAR(150) NOT NULL,
  `locais_especificos_alimentacao` VARCHAR(255) NOT NULL,
  `uso_alimnetacao` VARCHAR(50) NOT NULL,
  `uso_comercio` VARCHAR(50) NOT NULL,
  `benfeitoria` bigint(20),
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
  `benfeitoria` bigint(20),
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
  `benfeitoria` bigint(20),
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
  `benfeitoria` bigint(20),
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;

CREATE TABLE `agua` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `possui_forneceimento_publico` VARCHAR(255) NOT NULL,
  `qualidade_fornecimento_publico` VARCHAR(50),
  `cor_agua_forncimento_publico` VARCHAR(255),
  `sabor_agua_fornecimento_publico` VARCHAR(255),
  `cheiro_agua_fornecimento_publico` VARCHAR(255),
  `poco` VARCHAR(255) NOT NULL,
  `profundidade_poco` double,
  `cor_agua_poco` VARCHAR(255),
  `sabor_agua_Poco` VARCHAR(255),
  `cheiro_agua_poco` VARCHAR(255),
  `tratamento_agua` VARCHAR(255) NOT NULL,
  `benfeitoria` bigint(20),
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;

CREATE TABLE `violencia` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `ocorrencias` int NOT NULL,
  `tipo` varchar(255) NOT NULL,
  `condicao` varchar(50) NOT NULL,
  `destaque_de_morador` varchar(50),
  `benfeitoria` bigint(30) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;

CREATE TABLE `instituicao_conhecida` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `nome` varchar(255) NOT NULL,
  `atividades` varchar(255) NOT NULL,
  `benfeitoria` bigint(30) NOT NULL,
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


CREATE TABLE `doenca` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `doenca_nome` varchar(255) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;

CREATE TABLE `morador_doenca` (
  `morador` bigint(30) NOT NULL,
  `doenca` bigint(30) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;


CREATE TABLE `indicado_consulta_publica` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `nome` varchar(255) NOT NULL,
  `perfil` varchar(100) NOT NULL,
  `telefone` varchar(30) DEFAULT NULL,
  `entrevistado` bigint(30) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;


CREATE TABLE `servicos_basicos` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `servicos_deficitarios` varchar(100) NOT NULL,
  `imovel` bigint(30) NOT NULL,
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
  `conservacao_tipo` VARCHAR(255) NOT NULL,
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















