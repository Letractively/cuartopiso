/*
SQLyog Community v9.02 
MySQL - 6.0.10-alpha-community : Database - tienda
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`tienda` /*!40100 DEFAULT CHARACTER SET latin1 */;

USE `tienda`;

/*Table structure for table `articulo` */

DROP TABLE IF EXISTS `articulo`;

CREATE TABLE `articulo` (
  `idArticulo` int(11) NOT NULL AUTO_INCREMENT,
  `nombre` varchar(50) DEFAULT NULL,
  `precio` double NOT NULL,
  `idcliente` int(11) NOT NULL,
  PRIMARY KEY (`idArticulo`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=latin1;

/*Data for the table `articulo` */

insert  into `articulo`(`idArticulo`,`nombre`,`precio`,`idcliente`) values (1,'arroz',5,1),(2,'leche',15,2),(3,'fideos',10,3);

/*Table structure for table `cliente` */

DROP TABLE IF EXISTS `cliente`;

CREATE TABLE `cliente` (
  `idcliente` int(11) NOT NULL AUTO_INCREMENT,
  `nombre` varchar(50) DEFAULT NULL,
  `apellido` varchar(50) DEFAULT NULL,
  `direccion` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`idcliente`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=latin1;

/*Data for the table `cliente` */

insert  into `cliente`(`idcliente`,`nombre`,`apellido`,`direccion`) values (1,'pablo','nello','salta'),(2,'sergio','carrion','dorrego'),(3,'jorge','berrondo','ciudad'),(4,'pablo','nello','salta'),(5,'pablo','nello','salta');

/*Table structure for table `cliente_articulo` */

DROP TABLE IF EXISTS `cliente_articulo`;

CREATE TABLE `cliente_articulo` (
  `Cliente_IDCLIENTE` bigint(20) NOT NULL,
  `cesta_IDARTICULO` bigint(20) NOT NULL,
  PRIMARY KEY (`Cliente_IDCLIENTE`,`cesta_IDARTICULO`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Data for the table `cliente_articulo` */

/*Table structure for table `sequence` */

DROP TABLE IF EXISTS `sequence`;

CREATE TABLE `sequence` (
  `SEQ_NAME` varchar(50) NOT NULL,
  `SEQ_COUNT` decimal(38,0) DEFAULT NULL,
  PRIMARY KEY (`SEQ_NAME`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Data for the table `sequence` */

insert  into `sequence`(`SEQ_NAME`,`SEQ_COUNT`) values ('SEQ_GEN','0');

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
