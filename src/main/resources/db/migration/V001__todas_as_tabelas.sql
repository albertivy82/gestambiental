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
  `nascimento_data` int(11) NOT NULL,
  `escolaridade` varchar(50) NOT NULL,
  `estado_civil` varchar(50) NOT NULL,
  `religiao` varchar(100) NOT NULL,
  `morador` varchar(20) NOT NULL,
  `data_chegada` varchar(255) NOT NULL,
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
  `tipo_solo` varchar(255) NOT NULL,
  `vizinhos_confinantes` varchar(255) NOT NULL,
  `situacao_fundiaria` varchar(255) NOT NULL,
  `documentacao_imovel` varchar(250) NOT NULL,
  `limites` varchar(250) NOT NULL,
  `linhas_de_barco` varchar(250) NOT NULL,
  `pavimentacao` varchar(255) NOT NULL,
  `iluminacao_publica` varchar(100) NOT NULL,
  `equipamentos_urbanos` varchar(255) NOT NULL,
  `espacos_esporte_lazer` varchar(500) NOT NULL,
  `programa_infra_saneamento` varchar(500) NOT NULL,
  `entrevistado` bigint(20) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;


CREATE TABLE benfeitoria (
  `id` BIGINT(20) NOT NULL AUTO_INCREMENT,
  `tipo_benfeitoria` VARCHAR(50) NOT NULL,
  `funcao` VARCHAR(50) NOT NULL,
  `afastamento_da_principal` VARCHAR(500),
  `impermeabilizacao_solo` VARCHAR(50) NOT NULL,
  `limites` VARCHAR(150) NOT NULL,
  `area_benfeitoria` DOUBLE NOT NULL,
  `pavimentos` INT NOT NULL,
  `paredes` VARCHAR(150) NOT NULL,
  `tipo_cobertura` VARCHAR(150) NOT NULL,
  `tipo_esquadrias` VARCHAR(150) NOT NULL,
  `origem_madeira_da_construcao` VARCHAR(150) NOT NULL,
	`origem_pedra_da_construcao` VARCHAR(150) NOT NULL,
	`origem_areia_da_construcao` VARCHAR(150) NOT NULL,
  `alagamentos` VARCHAR(500) NOT NULL,
  `epoca_ocorrencia` VARCHAR(150) NOT NULL,
  `efluentes` VARCHAR(500) NOT NULL,
  `residuos` VARCHAR(500) NOT NULL,
  `fonte_energia` VARCHAR(500) NOT NULL,
  `energia_alimentos`VARCHAR(500) NOT NULL,
  `meios_locomocao` VARCHAR(150) NOT NULL,
  `linhas_onibus` VARCHAR(500) NOT NULL,
  `informativo_predominante` VARCHAR(500) NOT NULL,
  `imovel` bigint(20) NOT NULL,
  PRIMARY KEY (id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

CREATE TABLE `agua` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `tipo_de_fornecimento` VARCHAR(255) NOT NULL,
  `qualidade_da_agua`  VARCHAR(100) NOT NULL,
  `metodo_tratamento` VARCHAR(500) NOT NULL,
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
  `perfil` varchar(255) NOT NULL,
  `data_nascimento` int(11) NOT NULL,
  `sexo` varchar(255) NOT NULL,
  `escolaridade` varchar(255) NOT NULL,
  `estado_civil` varchar(255) NOT NULL,
  `onde_estuda` varchar(500) DEFAULT NULL,
  `trabalho` varchar(500) NOT NULL,
  `religiao` varchar(255) NOT NULL,
  `doencas` varchar(500) NOT NULL,
  `benfeitoria` bigint(30) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;


CREATE TABLE `participacao_instituicao` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `instituicao` varchar(5) NOT NULL,
  `tipoDeRegistro` varchar(255) NOT NULL,
  `Registro` varchar(255) NOT NULL,
  `morador` bigint(30) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;
















