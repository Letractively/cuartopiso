/*
SQLyog Ultimate v8.55 
MySQL - 5.5.13 : Database - abaid4p
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`abaid4p` /*!40100 DEFAULT CHARACTER SET latin1 */;

USE `abaid4p`;

/*Table structure for table `cliente` */

DROP TABLE IF EXISTS `cliente`;

CREATE TABLE `cliente` (
  `idCliente` bigint(10) NOT NULL AUTO_INCREMENT,
  `nombre` varchar(20) NOT NULL,
  `apellido` varchar(20) NOT NULL,
  `fechaNacimiento` date DEFAULT NULL,
  `telefono_1` varchar(10) DEFAULT NULL,
  `telefono_2` varchar(10) DEFAULT NULL,
  `dni` varchar(20) NOT NULL,
  `email` varchar(20) DEFAULT NULL,
  `fecha_alta` date NOT NULL,
  `sueldo` double NOT NULL,
  `estado_civil_id` bigint(10) NOT NULL,
  `empleador_id` bigint(10) NOT NULL,
  `estado_id` bigint(10) NOT NULL,
  `profesion_id` bigint(10) NOT NULL,
  `domicilio_id` bigint(10) NOT NULL,
  PRIMARY KEY (`idCliente`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Data for the table `cliente` */

/*Table structure for table `cobro` */

DROP TABLE IF EXISTS `cobro`;

CREATE TABLE `cobro` (
  `idCobro` bigint(10) NOT NULL AUTO_INCREMENT,
  `importe` double NOT NULL,
  `credito_id` bigint(10) NOT NULL,
  `fecha` date NOT NULL,
  `comprobante` int(10) NOT NULL,
  `estado_id` bigint(10) NOT NULL,
  `usuario_id` bigint(10) NOT NULL,
  PRIMARY KEY (`idCobro`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Data for the table `cobro` */

/*Table structure for table `credito` */

DROP TABLE IF EXISTS `credito`;

CREATE TABLE `credito` (
  `idCredito` bigint(10) NOT NULL AUTO_INCREMENT,
  `fecha` date NOT NULL,
  `cuota` int(10) NOT NULL,
  `importe` double NOT NULL,
  `comprobante` int(10) NOT NULL,
  `solicitud_id` bigint(10) NOT NULL,
  `estado_id` bigint(10) NOT NULL,
  `usuario_id` bigint(10) NOT NULL,
  PRIMARY KEY (`idCredito`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Data for the table `credito` */

/*Table structure for table `distrito` */

DROP TABLE IF EXISTS `distrito`;

CREATE TABLE `distrito` (
  `idDistrito` bigint(10) NOT NULL AUTO_INCREMENT,
  `nombre` varchar(20) NOT NULL,
  `codigo_postal` int(10) DEFAULT NULL,
  `localidad_id` bigint(10) NOT NULL,
  PRIMARY KEY (`idDistrito`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Data for the table `distrito` */

/*Table structure for table `domicilio` */

DROP TABLE IF EXISTS `domicilio`;

CREATE TABLE `domicilio` (
  `idDomicilio` bigint(10) NOT NULL AUTO_INCREMENT,
  `calle` varchar(20) NOT NULL,
  `nro` int(10) DEFAULT NULL,
  `barrio` varchar(20) DEFAULT NULL,
  `piso` varchar(10) DEFAULT NULL,
  `dpto` varchar(10) DEFAULT NULL,
  `manzana` varchar(5) DEFAULT NULL,
  `distrito_id` bigint(10) NOT NULL,
  `observaciones` tinytext,
  PRIMARY KEY (`idDomicilio`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Data for the table `domicilio` */

/*Table structure for table `empleador` */

DROP TABLE IF EXISTS `empleador`;

CREATE TABLE `empleador` (
  `idEmpleador` bigint(10) NOT NULL AUTO_INCREMENT,
  `razon_social` varchar(20) NOT NULL,
  `cuit` varchar(10) NOT NULL,
  PRIMARY KEY (`idEmpleador`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Data for the table `empleador` */

/*Table structure for table `estado` */

DROP TABLE IF EXISTS `estado`;

CREATE TABLE `estado` (
  `idEstado` bigint(10) NOT NULL AUTO_INCREMENT,
  `nombre` varchar(20) NOT NULL,
  PRIMARY KEY (`idEstado`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Data for the table `estado` */

/*Table structure for table `estadocivil` */

DROP TABLE IF EXISTS `estadocivil`;

CREATE TABLE `estadocivil` (
  `idEstado_civil` bigint(10) NOT NULL AUTO_INCREMENT,
  `nombre` varchar(20) NOT NULL,
  PRIMARY KEY (`idEstado_civil`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=latin1;

/*Data for the table `estadocivil` */

insert  into `estadocivil`(`idEstado_civil`,`nombre`) values (1,'Soltero'),(2,'Casado'),(3,'Viudo'),(4,'Divorciado');

/*Table structure for table `interes` */

DROP TABLE IF EXISTS `interes`;

CREATE TABLE `interes` (
  `idInteres` bigint(10) NOT NULL AUTO_INCREMENT,
  `gastos` double DEFAULT NULL,
  `tasa` double NOT NULL,
  `sellado` double DEFAULT NULL,
  `recargo_refin` double DEFAULT NULL,
  `interes_mora` double NOT NULL,
  PRIMARY KEY (`idInteres`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Data for the table `interes` */

/*Table structure for table `localidad` */

DROP TABLE IF EXISTS `localidad`;

CREATE TABLE `localidad` (
  `idLocalidad` bigint(10) NOT NULL AUTO_INCREMENT,
  `nombre` varchar(20) NOT NULL,
  PRIMARY KEY (`idLocalidad`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Data for the table `localidad` */

/*Table structure for table `plan` */

DROP TABLE IF EXISTS `plan`;

CREATE TABLE `plan` (
  `idPlan` bigint(10) NOT NULL AUTO_INCREMENT,
  `codigo` varchar(5) NOT NULL,
  `cant_cuotas` int(10) NOT NULL,
  `dias_vto` int(10) NOT NULL,
  `dias_gracia` int(10) DEFAULT NULL,
  `descripcion` tinytext,
  `limite_capital` int(20) NOT NULL,
  `estado_id` bigint(10) NOT NULL,
  `interes_id` bigint(10) NOT NULL,
  PRIMARY KEY (`idPlan`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Data for the table `plan` */

/*Table structure for table `profesion` */

DROP TABLE IF EXISTS `profesion`;

CREATE TABLE `profesion` (
  `idProfesion` bigint(10) NOT NULL AUTO_INCREMENT,
  `nombre` varchar(20) NOT NULL,
  `plan_id` bigint(10) NOT NULL,
  PRIMARY KEY (`idProfesion`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Data for the table `profesion` */

/*Table structure for table `rol` */

DROP TABLE IF EXISTS `rol`;

CREATE TABLE `rol` (
  `idRol` bigint(10) NOT NULL AUTO_INCREMENT,
  `nombre` varchar(20) NOT NULL,
  PRIMARY KEY (`idRol`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=latin1;

/*Data for the table `rol` */

insert  into `rol`(`idRol`,`nombre`) values (1,'user'),(2,'admin'),(3,'super');

/*Table structure for table `solicitud` */

DROP TABLE IF EXISTS `solicitud`;

CREATE TABLE `solicitud` (
  `idSolicitud` bigint(10) NOT NULL AUTO_INCREMENT,
  `fecha` date NOT NULL,
  `capital` double NOT NULL,
  `estado_id` bigint(10) NOT NULL,
  `plan_id` bigint(10) NOT NULL,
  `cliente_id` bigint(10) NOT NULL,
  `usuario_id` bigint(10) NOT NULL,
  PRIMARY KEY (`idSolicitud`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Data for the table `solicitud` */

/*Table structure for table `usuario` */

DROP TABLE IF EXISTS `usuario`;

CREATE TABLE `usuario` (
  `idUsuario` bigint(10) NOT NULL AUTO_INCREMENT,
  `nombre` varchar(20) NOT NULL,
  `apellido` varchar(20) NOT NULL,
  `telefono_1` varchar(10) DEFAULT NULL,
  `telefono_2` varchar(10) DEFAULT NULL,
  `user` varchar(10) NOT NULL,
  `password` varchar(20) NOT NULL,
  `rol_id` bigint(10) NOT NULL,
  PRIMARY KEY (`idUsuario`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Data for the table `usuario` */

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
