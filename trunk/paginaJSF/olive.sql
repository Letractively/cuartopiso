/*
SQLyog Community Edition- MySQL GUI v6.05
Host - 5.0.45-community-nt : Database - olive
*********************************************************************
Server version : 5.0.45-community-nt
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

create database if not exists `olive`;

USE `olive`;

/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;

/*Table structure for table `productos` */

DROP TABLE IF EXISTS `productos`;

CREATE TABLE `productos` (
  `ID` bigint(20) NOT NULL,
  `NOMBRE` varchar(255) default NULL,
  `PRECIO` varchar(255) default NULL,
  `DESCRPCION` varchar(255) default NULL,
  `CAPACIDAD` varchar(255) default NULL,
  PRIMARY KEY  (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Data for the table `productos` */

insert  into `productos`(`ID`,`NOMBRE`,`PRECIO`,`DESCRPCION`,`CAPACIDAD`) values (1,'Garlic Flavored Olive Oil - Souri','35','Garlic flavored olive oil spiced to perfection, packing its own punch, meant for upgrading any serving, salad or dish','200 ml'),(2,'Extra Virgin Olive Oil - Picual','33','A sweet fruity fragrance and a delightful green aroma','200 ml'),(3,'Extra Virgin Olive Oil - Manzanillo','65','A famous and vigorous fragrance with a strong and enduring fruity flavor','1 liter'),(4,'Truffle Flavored Olive Oil - Barnea','39','Truffle flavored olive oil spiced to perfection, packing its own punch, meant for upgrading any serving, salad or dish.','200 ml'),(5,'Extra Virgin Olive Oil - Frantoio','65','A delicately refreshing aroma and a sweet almond-like taste','1 liter'),(6,'Extra Virgin Olive Oil – Negev Premium Blend','79','Negev is our premium blend extra virgin olive oil. A fusion of two of the finest olives – Picual and Barnea, integrating the balance of bitterness with fruitiness','500 ml');

/*Table structure for table `sequence` */

DROP TABLE IF EXISTS `sequence`;

CREATE TABLE `sequence` (
  `SEQ_NAME` varchar(50) NOT NULL,
  `SEQ_COUNT` decimal(38,0) default NULL,
  PRIMARY KEY  (`SEQ_NAME`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Data for the table `sequence` */

insert  into `sequence`(`SEQ_NAME`,`SEQ_COUNT`) values ('SEQ_GEN','0');

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
