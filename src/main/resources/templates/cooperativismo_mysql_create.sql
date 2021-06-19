CREATE TABLE `sessao` (
	`idSessao` INT NOT NULL AUTO_INCREMENT,
	`fimSessao` TIMESTAMP NOT NULL,
	`inicioSessao` TIMESTAMP NOT NULL,
	PRIMARY KEY (`idSessao`)
);

CREATE TABLE `pauta` (
	`idPauta` INT NOT NULL AUTO_INCREMENT,
	`idSessaoFk` INT NOT NULL UNIQUE,
	`descricao_pauta` varchar(255) NOT NULL,
	PRIMARY KEY (`idPauta`)
);

CREATE TABLE `voto` (
	`idVoto` INT NOT NULL AUTO_INCREMENT,
	`voto` BOOLEAN NOT NULL,
	`idPautaFk` INT NOT NULL,
	`idAssociadoFk` INT NOT NULL UNIQUE,
	PRIMARY KEY (`idVoto`)
);

CREATE TABLE `associado` (
	`idAssociado` INT NOT NULL AUTO_INCREMENT,
	`nome` varchar(255) NOT NULL,
	`cpf` varchar(255) NOT NULL UNIQUE,
	PRIMARY KEY (`idAssociado`)
);

ALTER TABLE `pauta` ADD CONSTRAINT `pauta_fk0` FOREIGN KEY (`idSessaoFk`) REFERENCES `sessao`(`idSessao`);

ALTER TABLE `voto` ADD CONSTRAINT `voto_fk0` FOREIGN KEY (`idPautaFk`) REFERENCES `pauta`(`idPauta`);

ALTER TABLE `voto` ADD CONSTRAINT `voto_fk1` FOREIGN KEY (`idAssociadoFk`) REFERENCES `associado`(`idAssociado`);

