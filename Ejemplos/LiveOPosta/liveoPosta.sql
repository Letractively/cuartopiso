/*
SQLyog Enterprise - MySQL GUI v8.05 
MySQL - 5.0.45-community-nt : Database - liveoposta
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;

CREATE DATABASE /*!32312 IF NOT EXISTS*/`liveoposta` /*!40100 DEFAULT CHARACTER SET utf8 */;

USE `liveoposta`;

/*Table structure for table `producto` */

DROP TABLE IF EXISTS `producto`;

CREATE TABLE `producto` (
  `ID` bigint(20) NOT NULL auto_increment,
  `CAPACIDAD` varchar(255) default NULL,
  `DESCRIPCION` varchar(255) default NULL,
  `FOTOS` varchar(255) default NULL,
  `NOMBRE` varchar(255) default NULL,
  `PRECIO` double default NULL,
  `RANKING` int(11) default NULL,
  `PROVEEDOR_ID` bigint(20) default NULL,
  `RUBRO_ID` bigint(20) default NULL,
  PRIMARY KEY  (`ID`),
  KEY `FK_PRODUCTO_PROVEEDORES_ID` (`PROVEEDOR_ID`),
  KEY `FK_PRODUCTO_RUBRO_ID` (`RUBRO_ID`)
) ENGINE=MyISAM AUTO_INCREMENT=7 DEFAULT CHARSET=utf8;

/*Data for the table `producto` */

insert  into `producto`(`ID`,`CAPACIDAD`,`DESCRIPCION`,`FOTOS`,`NOMBRE`,`PRECIO`,`RANKING`,`PROVEEDOR_ID`,`RUBRO_ID`) values (1,'200 ml','Garlic flavored olive oil spiced to perfection, packing its own punch, meant for upgrading any serving, salad or dish',NULL,'Garlic Flavored Olive Oil - Souri',35,1,1,1),(2,'200 ml','A sweet fruity fragrance and a delightful green aroma',NULL,'Extra Virgin Olive Oil - Picual',33,0,1,2),(3,'1 liter','A famous and vigorous fragrance with a strong and enduring fruity flavor',NULL,'Extra Virgin Olive Oil - Manzanillo',65,1,1,3),(4,'200 ml','Truffle flavored olive oil spiced to perfection, packing its own punch, meant for upgrading any serving, salad or dish.',NULL,'Truffle Flavored Olive Oil - Barnea',39,1,2,1),(5,'1 liter','A delicately refreshing aroma and a sweet almond-like taste',NULL,'Extra Virgin Olive Oil - Frantoio',65,0,2,2),(6,'500 ml','Negev is our premium blend extra virgin olive oil. A fusion of two of the finest olives – Picual and Barnea, integrating the balance of bitterness with fruitiness',NULL,'Extra Virgin Olive Oil – Negev Premium Blend',79,1,2,3);

/*Table structure for table `proveedores` */

DROP TABLE IF EXISTS `proveedores`;

CREATE TABLE `proveedores` (
  `ID` bigint(20) NOT NULL auto_increment,
  `DESCRIPCION` varchar(255) default NULL,
  PRIMARY KEY  (`ID`)
) ENGINE=MyISAM AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

/*Data for the table `proveedores` */

insert  into `proveedores`(`ID`,`DESCRIPCION`) values (1,'zucardi'),(2,'molinos');

/*Table structure for table `rubro` */

DROP TABLE IF EXISTS `rubro`;

CREATE TABLE `rubro` (
  `ID` bigint(20) NOT NULL auto_increment,
  `DESCRIPCION` varchar(255) default NULL,
  PRIMARY KEY  (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

/*Data for the table `rubro` */

insert  into `rubro`(`ID`,`DESCRIPCION`) values (1,'Aceite'),(2,'Mermelada'),(3,'Perfume');

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
