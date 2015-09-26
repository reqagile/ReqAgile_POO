DROP TABLE IF EXISTS `user`;
DROP TABLE IF EXISTS `projeto`;
DROP TABLE IF EXISTS `funcao`;
DROP TABLE IF EXISTS `atuacao`;
DROP TABLE IF EXISTS `tiporeq`;

/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `user` (
  `iduser` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(128) NOT NULL,
  `login` varchar(32) NOT NULL,
  `password` varchar(64) NOT NULL,
  `email` varchar(128) NOT NULL,
  PRIMARY KEY (`iduser`),
  UNIQUE KEY `email_UNIQUE` (`email`),
  UNIQUE KEY `login_UNIQUE` (`login`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;


/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `projeto` (
  `idprojeto` int(11) NOT NULL AUTO_INCREMENT,
  `titulo` varchar(45) NOT NULL,
  `descricao` text,
  PRIMARY KEY (`idprojeto`)
) ENGINE=InnoDB DEFAULT CHARSET=ujis;


/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `funcao` (
  `idfuncao` int(11) NOT NULL AUTO_INCREMENT,
  `funcao` varchar(45) NOT NULL,
  PRIMARY KEY (`idfuncao`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;


/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `atuacao` (
  `CodUser` int(11) NOT NULL,
  `CodProj` int(11) NOT NULL,
  `funcao` int(11) NOT NULL,
  KEY `CodUser_idx` (`CodUser`),
  KEY `CodProj_idx` (`CodProj`),
  KEY `funcao_idx` (`funcao`),
  CONSTRAINT `CodProj` FOREIGN KEY (`CodProj`) REFERENCES `projeto` (`idprojeto`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `CodUser` FOREIGN KEY (`CodUser`) REFERENCES `user` (`iduser`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `funcao` FOREIGN KEY (`funcao`) REFERENCES `funcao` (`idfuncao`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;


/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tiporeq` (
  `idtipoReq` int(11) NOT NULL AUTO_INCREMENT,
  `nome` varchar(32) NOT NULL,
  `descricao` varchar(64) NOT NULL,
  `projeto` int(11) NOT NULL,
  PRIMARY KEY (`idtipoReq`),
  KEY `projeto_idx` (`projeto`),
  CONSTRAINT `projeto` FOREIGN KEY (`projeto`) REFERENCES `projeto` (`idprojeto`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;


INSERT INTO `funcao` VALUES (1,'admin'),(2,'colaborador');