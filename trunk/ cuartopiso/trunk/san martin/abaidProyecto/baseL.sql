/*
SQLyog Ultimate v8.55 
MySQL - 6.0.4-alpha-community : Database - abaidposta
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`abaidposta` /*!40100 DEFAULT CHARACTER SET latin1 */;

USE `abaidposta`;

/*Table structure for table `cliente` */

DROP TABLE IF EXISTS `cliente`;

CREATE TABLE `cliente` (
  `idCliente` int(10) NOT NULL AUTO_INCREMENT,
  `nombre` varchar(20) DEFAULT NULL,
  `apellido` varchar(20) DEFAULT NULL,
  `dni` int(20) DEFAULT NULL,
  `mail` varchar(50) DEFAULT NULL,
  `telefono1` int(20) DEFAULT NULL,
  `telefono2` int(30) DEFAULT NULL,
  `estadoCivil` varchar(10) DEFAULT NULL,
  `fechaNacimiento` varchar(15) DEFAULT NULL,
  `cuil` int(20) DEFAULT NULL,
  `sueldo` float DEFAULT NULL,
  `idProfesion` int(10) DEFAULT NULL,
  PRIMARY KEY (`idCliente`),
  KEY `FK_cliente_profesion` (`idProfesion`),
  CONSTRAINT `FK_cliente_profesion` FOREIGN KEY (`idProfesion`) REFERENCES `profesion` (`idProfesion`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=latin1;

/*Data for the table `cliente` */

insert  into `cliente`(`idCliente`,`nombre`,`apellido`,`dni`,`mail`,`telefono1`,`telefono2`,`estadoCivil`,`fechaNacimiento`,`cuil`,`sueldo`,`idProfesion`) values (1,'pablo','nello',30741354,'pablonello@hotmail.com',436264,2147483647,'soltero','10/03/1984',2147483647,3400,1),(2,'sergio','carrion',30741354,'sec.carrion@hotmail.com',4306264,26137363,'soltero','10/3/1984',307413540,10000,1),(3,'jorge','berrondo',10723040,'bejdfsf@hotmail.com',4305265,261589460,'soltero','10-03-2021',30713540,4500,1),(4,'Luis','Tomas',43565432,'fesdf@cidm.com',34234234,262337363,'casado','21/09/1980',307413540,23456,1);

/*Table structure for table `credito` */

DROP TABLE IF EXISTS `credito`;

CREATE TABLE `credito` (
  `idCredito` int(10) NOT NULL AUTO_INCREMENT,
  `comprobante` int(20) DEFAULT NULL,
  `cuota` int(10) DEFAULT NULL,
  `montoTotal` float DEFAULT NULL,
  `montoXcuota` float DEFAULT NULL,
  `intXcuota` float DEFAULT NULL,
  `fecha1` date DEFAULT NULL,
  `fecha2` date DEFAULT NULL,
  `fechaCobro` date DEFAULT NULL,
  `montoPagado` float DEFAULT NULL,
  `cancelado` varchar(10) DEFAULT NULL,
  `debe` float DEFAULT NULL,
  `intXmora` float DEFAULT NULL,
  `idCliente` int(10) NOT NULL,
  PRIMARY KEY (`idCredito`),
  KEY `FK_credito_cliente` (`idCliente`),
  CONSTRAINT `FK_credito_cliente` FOREIGN KEY (`idCliente`) REFERENCES `cliente` (`idCliente`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=latin1;

/*Data for the table `credito` */

insert  into `credito`(`idCredito`,`comprobante`,`cuota`,`montoTotal`,`montoXcuota`,`intXcuota`,`fecha1`,`fecha2`,`fechaCobro`,`montoPagado`,`cancelado`,`debe`,`intXmora`,`idCliente`) values (1,100,1,8000,200,200,'2000-12-05','2012-05-12','1988-08-05',8000,'pt',0,0,1),(2,100,2,8000,200,2000,'2000-12-05','2012-05-11','1989-10-05',8000,'pt',0,0,1);

/*Table structure for table `domicilio` */

DROP TABLE IF EXISTS `domicilio`;

CREATE TABLE `domicilio` (
  `idDomicilio` int(10) NOT NULL AUTO_INCREMENT,
  `calle` varchar(10) DEFAULT NULL,
  `numero` int(10) DEFAULT NULL,
  `barrio` varchar(10) DEFAULT NULL,
  `piso` int(10) DEFAULT NULL,
  `localidad` varchar(10) DEFAULT NULL,
  `codigoPostal` int(10) DEFAULT NULL,
  `dpto` int(10) DEFAULT NULL,
  `manzana` varchar(10) DEFAULT NULL,
  `casa` int(10) DEFAULT NULL,
  `provincia` varchar(10) DEFAULT NULL,
  `observacion` varchar(10) DEFAULT NULL,
  `idCliente` int(10) NOT NULL,
  `idUsuario` int(10) NOT NULL,
  PRIMARY KEY (`idDomicilio`),
  KEY `FK_domicilio_usuario` (`idUsuario`),
  KEY `FK_domicilio_cliente` (`idCliente`),
  CONSTRAINT `FK_domicilio_cliente` FOREIGN KEY (`idCliente`) REFERENCES `cliente` (`idCliente`),
  CONSTRAINT `FK_domicilio_usuario` FOREIGN KEY (`idUsuario`) REFERENCES `usuario` (`idUsuario`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Data for the table `domicilio` */

/*Table structure for table `interes` */

DROP TABLE IF EXISTS `interes`;

CREATE TABLE `interes` (
  `idInteres` int(10) NOT NULL AUTO_INCREMENT,
  `gastosAdmin` float DEFAULT NULL,
  `tasa` float DEFAULT NULL,
  `sellado` float DEFAULT NULL,
  `recargoXRefinanciacion` float DEFAULT NULL,
  `intXMora` float DEFAULT NULL,
  `estado` varchar(10) DEFAULT NULL,
  `fecha` varchar(10) DEFAULT NULL,
  `observacion` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`idInteres`)
) ENGINE=InnoDB AUTO_INCREMENT=15 DEFAULT CHARSET=latin1;

/*Data for the table `interes` */

insert  into `interes`(`idInteres`,`gastosAdmin`,`tasa`,`sellado`,`recargoXRefinanciacion`,`intXMora`,`estado`,`fecha`,`observacion`) values (5,45,45,45,45,45,'toto','',''),(6,56,56,56,5656,56,NULL,NULL,NULL),(8,15,9,9,15,9,NULL,NULL,NULL),(9,8,8,8,8,8,NULL,NULL,NULL),(10,5,5657,7,7,7,NULL,NULL,NULL),(11,0,0,0,0,0,NULL,NULL,NULL),(12,677,78,78,78,78,NULL,NULL,NULL),(13,45,89,0,12,121,NULL,NULL,NULL),(14,100,100,100,100,100,NULL,NULL,NULL);

/*Table structure for table `plan` */

DROP TABLE IF EXISTS `plan`;

CREATE TABLE `plan` (
  `idPlan` int(10) NOT NULL AUTO_INCREMENT,
  `canCuotas` int(10) DEFAULT NULL,
  `codigo` varchar(10) DEFAULT NULL,
  `diasDeGacias` int(10) DEFAULT NULL,
  `vencimiento` int(10) DEFAULT NULL,
  `descripcion` varchar(50) DEFAULT NULL,
  `estado` varchar(10) DEFAULT NULL,
  `limiteCapital` int(10) DEFAULT NULL,
  `idInteres` int(10) NOT NULL,
  `idCredito` int(10) DEFAULT NULL,
  PRIMARY KEY (`idPlan`),
  KEY `FK_plan_interes` (`idInteres`),
  KEY `FK_plan_credito` (`idCredito`),
  CONSTRAINT `FK_plan_credito` FOREIGN KEY (`idCredito`) REFERENCES `credito` (`idCredito`),
  CONSTRAINT `FK_plan_idInteres` FOREIGN KEY (`idInteres`) REFERENCES `interes` (`idInteres`),
  CONSTRAINT `FK_plan_interes` FOREIGN KEY (`idInteres`) REFERENCES `interes` (`idInteres`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=latin1;

/*Data for the table `plan` */

insert  into `plan`(`idPlan`,`canCuotas`,`codigo`,`diasDeGacias`,`vencimiento`,`descripcion`,`estado`,`limiteCapital`,`idInteres`,`idCredito`) values (1,5,'54',45,345,'este plan se le ortorga a jubilados','grge',435,5,NULL),(2,3,'4r',45,35,'este plan se le orotga a las amas de casa','',435,9,NULL);

/*Table structure for table `planprofesion` */

DROP TABLE IF EXISTS `planprofesion`;

CREATE TABLE `planprofesion` (
  `idPlanProfesion` int(10) NOT NULL AUTO_INCREMENT,
  `idProfesion` int(10) NOT NULL,
  `idPlan` int(10) NOT NULL,
  PRIMARY KEY (`idPlanProfesion`),
  KEY `FK_planprofesion_profesion` (`idProfesion`),
  KEY `FK_planprofesion_plan` (`idPlan`),
  CONSTRAINT `FK_planprofesion_plan` FOREIGN KEY (`idPlan`) REFERENCES `plan` (`idPlan`),
  CONSTRAINT `FK_planprofesion_profesion` FOREIGN KEY (`idProfesion`) REFERENCES `profesion` (`idProfesion`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Data for the table `planprofesion` */

/*Table structure for table `profesion` */

DROP TABLE IF EXISTS `profesion`;

CREATE TABLE `profesion` (
  `idProfesion` int(10) NOT NULL AUTO_INCREMENT,
  `nombre` varchar(10) DEFAULT NULL,
  PRIMARY KEY (`idProfesion`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=latin1;

/*Data for the table `profesion` */

insert  into `profesion`(`idProfesion`,`nombre`) values (1,'profesor');

/*Table structure for table `usuario` */

DROP TABLE IF EXISTS `usuario`;

CREATE TABLE `usuario` (
  `idUsuario` int(10) NOT NULL AUTO_INCREMENT,
  `usr` varchar(15) DEFAULT NULL,
  `nombre` varchar(10) DEFAULT NULL,
  `apellido` varchar(10) DEFAULT NULL,
  `dni` int(20) DEFAULT NULL,
  `mail` varchar(30) DEFAULT NULL,
  `telefono1` bigint(15) DEFAULT NULL,
  `telefono2` bigint(15) DEFAULT NULL,
  `psw` varchar(20) DEFAULT NULL,
  `pswConf` varchar(20) DEFAULT NULL,
  `fechaNac` varchar(10) DEFAULT NULL,
  `tipo` varchar(10) DEFAULT NULL,
  PRIMARY KEY (`idUsuario`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=latin1;

/*Data for the table `usuario` */

insert  into `usuario`(`idUsuario`,`usr`,`nombre`,`apellido`,`dni`,`mail`,`telefono1`,`telefono2`,`psw`,`pswConf`,`fechaNac`,`tipo`) values (2,'popo','pepe','pepe',3074154,'pablonello@hotmail.com',30741354,30741354,'pepere',NULL,'10/03/1984','super'),(3,'fideo','pablo','nello',30741354,'pablonello@hotmail.com',4306264,2613736308,'1234','1234','10/03/1984','super'),(4,'pepe','pablo','nello',30741354,'pablonello@hotmail.com',4306264,2613736308,'12','12','10/03/1984','user'),(5,'tito','pablo','nello',30741354,'pablonello@hotmail.com',4306264,2613736308,'5','5','10/03/1984','super'),(6,'chichi','lidia','caminos',10723040,'',4306264,NULL,'lidia','lidia','1/10/1952','user'),(7,'falo','asa','hjkhjk',32678876,'adasd@dkc.com',34343433,14455667,'123456','123456','3/9/1987','Super'),(8,'seba','','',NULL,'',NULL,NULL,'coso','coso','','Super'),(9,'babi','','',NULL,'',NULL,NULL,'1','1','','user');

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
