CREATE TABLE `localidade` (
  `id` bigint(30) NOT NULL AUTO_INCREMENT,
  `nome` varchar(255) NOT NULL,
  `municipio` varchar(100) NOT NULL,
  `esfera` varchar(15) NOT NULL,
   PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=UTF8;

CREATE TABLE `escola` (
  `id` bigint(30) NOT NULL AUTO_INCREMENT,
  `nome` varchar(255) NOT NULL,
  `educacao_ambiental` varchar(5) NOT NULL,
  `merenda` varchar(5) NOT NULL,
  `transporte` varchar(5) NOT NULL,
  `localidade` bigint(30) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=UTF8;

CREATE TABLE `posto_de_saude` (
  `id` bigint(30) NOT NULL AUTO_INCREMENT,
  `nome` varchar(255) NOT NULL,
  `ambulatorial` varchar(5) NOT NULL,
  `urgencia_emergencia` varchar(5) NOT NULL,
  `medicos_por_turno` bigint(5) NOT NULL,
  `localidade` bigint(30) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=UTF8;


CREATE TABLE `coordenada` (
  `id` bigint(30) NOT NULL AUTO_INCREMENT,
  `latitude` varchar(30) NOT NULL,
  `longitude` varchar(30) NOT NULL,
  `localidade` bigint(30) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=UTF8;

CREATE TABLE `usuario` (
  `id` bigint(30) NOT NULL AUTO_INCREMENT,
  `nome` varchar(255) NOT NULL,
  `matricula` varchar(100) NOT NULL,
  `email` varchar(100) NOT NULL,
  `cpf` varchar(100) NOT NULL,
  `senha` varchar(255) NOT NULL,
  `grupo` bigint(30) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=UTF8;

CREATE TABLE `grupo` (
  `id` bigint(30) NOT NULL AUTO_INCREMENT,
  `nome` varchar(255) NOT NULL,
   PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=UTF8;

CREATE TABLE `permissao` (
  `id` bigint(30) NOT NULL AUTO_INCREMENT,
  `nome` varchar(255) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=UTF8;

CREATE TABLE `grupo_permissao` (
  `grupo` bigint(30) NOT NULL,
  `permissao` bigint(30) NOT NULL,
  primary key (grupo, permissao)
 )ENGINE=InnoDB DEFAULT CHARSET=UTF8;

CREATE TABLE `localidade_usuario` (
  `localidade` bigint(30) NOT NULL,
  `usuario` bigint(30) NOT NULL
 ) ENGINE=InnoDB DEFAULT CHARSET=UTF8;


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
) ENGINE=InnoDB DEFAULT CHARSET=UTF8;

CREATE TABLE `benfeitoria`(
  `id` bigint(30) NOT NULL AUTO_INCREMENT,
   PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=UTF8;


CREATE TABLE `entrevistado` (
  `id` bigint(30) NOT NULL AUTO_INCREMENT,
  `nome` varchar(255) DEFAULT NULL,
  `apelido` varchar(100) DEFAULT NULL,
  `naturalidade` varchar(100) DEFAULT NULL,
  `conhece_uc_proposta` varchar(100) DEFAULT NULL,
  `proposta_melhorar_area` varchar(255) DEFAULT NULL,
  `imovel` bigint(30) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=UTF8;




CREATE TABLE `violencia` (
  `id` bigint(30) NOT NULL AUTO_INCREMENT,
  `ocorrencias` int NOT NULL,
  `tipo` varchar(255) NOT NULL,
  `condicao` varchar(50) NOT NULL,
  `destaque_de_morador` varchar(50),
  `benfeitoria` bigint(30) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=UTF8;



CREATE TABLE `instituicao_conhecida` (
  `id` bigint(3) NOT NULL AUTO_INCREMENT,
  `nome` varchar(255) NOT NULL,
  `atividades` varchar(255) NOT NULL,
  `benfeitoria` bigint(30) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=UTF8;


CREATE TABLE `atividade_produtiva` (
  `id` bigint(30) NOT NULL AUTO_INCREMENT,
  `atividade` varchar(255) NOT NULL,
  `pessoas_envolvidas` bigint(30) NOT NULL,
  `faturamento_atividade_mes_total` decimal(19,2) NOT NULL,
  `benfeitoria` bigint(30) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=UTF8;

CREATE TABLE `renda_outras_fontes` (
  `id` bigint(30) NOT NULL AUTO_INCREMENT,
  `fonte` varchar(100) NOT NULL,
  `beneficiarios` bigint(30) NOT NULL,
  `renda_mes_total` decimal(19,2) NOT NULL,
  `benfeitoria` bigint(30) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=UTF8;

CREATE TABLE `credito` (
  `id` bigint(30) NOT NULL AUTO_INCREMENT,
  `nome` varchar(255) DEFAULT NULL,
  `valor` decimal(19,2) DEFAULT NULL,
  `benfeitoria` bigint(30) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=UTF8;

CREATE TABLE `morador` (
  `id` bigint(30) NOT NULL AUTO_INCREMENT,
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
) ENGINE=InnoDB DEFAULT CHARSET=UTF8;


CREATE TABLE `doenca` (
  `id` bigint(30) NOT NULL AUTO_INCREMENT,
  `doenca_nome` varchar(255) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=UTF8;

CREATE TABLE `morador_doenca` (
  `morador` bigint(30) NOT NULL,
  `doenca` bigint(30) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=UTF8;


CREATE TABLE `dados_de_consumo` (
  `id` bigint(30) NOT NULL AUTO_INCREMENT,
  `alimentacao_principal` varchar(255) NOT NULL,
  `local_de_compras` varchar(255) NOT NULL,
  `benfeitoria` bigint(30) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=UTF8;

CREATE TABLE `indicado_consulta_publica` (
  `id` bigint(30) NOT NULL AUTO_INCREMENT,
  `nome` varchar(255) NOT NULL,
  `perfil` varchar(100) NOT NULL,
  `telefone` varchar(30) DEFAULT NULL,
  `entrevistado` bigint(30) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=UTF8;



CREATE TABLE `servicos_basicos` (
  `id` bigint(30) NOT NULL AUTO_INCREMENT,
  `servicos_deficitarios` varchar(100) NOT NULL,
  `imovel` bigint(30) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=UTF8;

CREATE TABLE `atendimento_saude` (
  `id` bigint(30) NOT NULL AUTO_INCREMENT,
  `tipo_atendimento` varchar(100) NOT NULL,
  `imovel` bigint(30) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=UTF8;


CREATE TABLE `outros_servicos` (
  `id` bigint(30) NOT NULL AUTO_INCREMENT,
  `outros_servicos` varchar(100) NOT NULL,
  `imovel` bigint(30) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=UTF8;


CREATE TABLE `imovel_servicos_basicos` (
  `imovel` bigint(30) NOT NULL,
  `servicos_basicos` bigint(30) NOT NULL,
  primary key (imovel, servicos_basicos)
 )ENGINE=InnoDB DEFAULT CHARSET=UTF8;


 CREATE TABLE `imovel_atendimento_saude` (
  `imovel` bigint(30) NOT NULL,
  `atendimento_saude` bigint(30) NOT NULL,
  primary key (imovel, atendimento_saude)
 )ENGINE=InnoDB DEFAULT CHARSET=UTF8;


CREATE TABLE `imovel_outros_servicos` (
  `imovel` bigint(30) NOT NULL,
  `outros_servicos` bigint(30) NOT NULL,
  primary key (imovel, outros_servicos)
 )ENGINE=InnoDB DEFAULT CHARSET=UTF8;












