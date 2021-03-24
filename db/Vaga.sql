DROP TABLE VAGA;

CREATE TABLE `vaga` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `nome` varchar(70) NOT NULL,
  `descricao` varchar(255) NOT NULL,
  `empresa` varchar(100) NOT NULL,
  `salario` double(13,2) NOT NULL,
  `data_publicacao` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `ativo` tinyint(1) NOT NULL DEFAULT '1',
  `data_fim` timestamp NULL DEFAULT NULL,
  `status` char(1) NOT NULL DEFAULT 'A' COMMENT 'A - Aberto, F - Fechado, C - Cancelado, P - Preenchido',
  `versao` int(11) NOT NULL DEFAULT '0',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;