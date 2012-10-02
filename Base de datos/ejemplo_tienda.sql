/*
SQLyog Ultimate v8.55 
MySQL - 5.5.13 : Database - ejemplo_tienda
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`ejemplo_tienda` /*!40100 DEFAULT CHARACTER SET latin1 */;

USE `ejemplo_tienda`;

/*Table structure for table `cliente` */

DROP TABLE IF EXISTS `cliente`;

CREATE TABLE `cliente` (
  `ID` bigint(20) NOT NULL AUTO_INCREMENT,
  `CODPOSTAL` varchar(255) DEFAULT NULL,
  `NOMBRE` varchar(255) DEFAULT NULL,
  `LOCALIDAD` varchar(255) DEFAULT NULL,
  `NIF` varchar(255) DEFAULT NULL,
  `EMAIL` varchar(255) DEFAULT NULL,
  `DOMICILIO` varchar(255) DEFAULT NULL,
  `APELLIDOS` varchar(255) DEFAULT NULL,
  `TELEFONO` varchar(255) DEFAULT NULL,
  `PROVINCIA` varchar(255) DEFAULT NULL,
  `VERSION` int(11) DEFAULT NULL,
  `USUARIO_ID` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`ID`),
  KEY `FK_CLIENTE_USUARIO_ID` (`USUARIO_ID`)
) ENGINE=MyISAM AUTO_INCREMENT=4 DEFAULT CHARSET=latin1;

/*Data for the table `cliente` */

insert  into `cliente`(`ID`,`CODPOSTAL`,`NOMBRE`,`LOCALIDAD`,`NIF`,`EMAIL`,`DOMICILIO`,`APELLIDOS`,`TELEFONO`,`PROVINCIA`,`VERSION`,`USUARIO_ID`) values (1,'32004','Pedro','Ourense','12345678A','pedro @pedro.com','Edifico Politécnico, Campus As Lagoas','Pérez Pérez','988123456','Ourense',1,5),(2,'15002','Ana','A Coruña','87654321B','ana@ana.com','Plaza de María Pita','Álvarez Álvarez','981112233','A Coruña',1,2),(3,'36012','Luis','Vigo','11223344G','luis@luis.com','C/. García Barbón, 49 5ºC','López López','986332211','Pontevedra',1,1);

/*Table structure for table `familia` */

DROP TABLE IF EXISTS `familia`;

CREATE TABLE `familia` (
  `ID` bigint(20) NOT NULL AUTO_INCREMENT,
  `NOMBRE` varchar(255) DEFAULT NULL,
  `ABREVIATURA` varchar(255) DEFAULT NULL,
  `VERSION` int(11) DEFAULT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=MyISAM AUTO_INCREMENT=13 DEFAULT CHARSET=latin1;

/*Data for the table `familia` */

insert  into `familia`(`ID`,`NOMBRE`,`ABREVIATURA`,`VERSION`) values (1,'Procesadores AMD','CPU-AMD',2),(2,'Procesadores Intel','CPU-INTEL',2),(3,'Discos duros internos','HD-int',2),(4,'Discos duros externos','HD-ext',1),(5,'Monitores LCD','LCD',2),(6,'Memoria RAM','RAM',1),(8,'Lectores CD/DVD','CD/DVD',1),(9,'Cajas y torres','Cajas',1),(10,'Periféricos','Perif.',1),(11,'Placas base AMD','PB-AMD',1),(12,'Placas base Intel','PB-intel',1);

/*Table structure for table `lineapedido` */

DROP TABLE IF EXISTS `lineapedido`;

CREATE TABLE `lineapedido` (
  `ID` bigint(20) NOT NULL AUTO_INCREMENT,
  `DESCUENTO` double DEFAULT NULL,
  `PRECIO` double DEFAULT NULL,
  `CANTIDAD` bigint(20) DEFAULT NULL,
  `VERSION` int(11) DEFAULT NULL,
  `PEDIDO_ID` bigint(20) DEFAULT NULL,
  `PRODUCTO_ID` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`ID`),
  KEY `FK_LINEAPEDIDO_PRODUCTO_ID` (`PRODUCTO_ID`),
  KEY `FK_LINEAPEDIDO_PEDIDO_ID` (`PEDIDO_ID`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

/*Data for the table `lineapedido` */

/*Table structure for table `pedido` */

DROP TABLE IF EXISTS `pedido`;

CREATE TABLE `pedido` (
  `ID` bigint(20) NOT NULL AUTO_INCREMENT,
  `ESTADO` int(11) DEFAULT NULL,
  `FECHA` date DEFAULT NULL,
  `VERSION` int(11) DEFAULT NULL,
  `CLIENTE_ID` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`ID`),
  KEY `FK_PEDIDO_CLIENTE_ID` (`CLIENTE_ID`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

/*Data for the table `pedido` */

/*Table structure for table `pedido_lineapedido` */

DROP TABLE IF EXISTS `pedido_lineapedido`;

CREATE TABLE `pedido_lineapedido` (
  `Pedido_ID` bigint(20) NOT NULL,
  `lineasPedido_ID` bigint(20) NOT NULL,
  PRIMARY KEY (`Pedido_ID`,`lineasPedido_ID`),
  KEY `FK_PEDIDO_LINEAPEDIDO_lineasPedido_ID` (`lineasPedido_ID`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

/*Data for the table `pedido_lineapedido` */

/*Table structure for table `producto` */

DROP TABLE IF EXISTS `producto`;

CREATE TABLE `producto` (
  `ID` bigint(20) NOT NULL AUTO_INCREMENT,
  `PRECIO` double DEFAULT NULL,
  `DESCRIPCION` varchar(255) DEFAULT NULL,
  `EXISTENCIAS` int(11) DEFAULT NULL,
  `MARCA` varchar(255) DEFAULT NULL,
  `DETALLE` varchar(255) DEFAULT NULL,
  `MODELO` varchar(255) DEFAULT NULL,
  `VERSION` int(11) DEFAULT NULL,
  `FAMILIA_ID` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`ID`),
  KEY `FK_PRODUCTO_FAMILIA_ID` (`FAMILIA_ID`)
) ENGINE=MyISAM AUTO_INCREMENT=8 DEFAULT CHARSET=latin1;

/*Data for the table `producto` */

insert  into `producto`(`ID`,`PRECIO`,`DESCRIPCION`,`EXISTENCIAS`,`MARCA`,`DETALLE`,`MODELO`,`VERSION`,`FAMILIA_ID`) values (1,175,'CPU AMD Phenon II X4 955',5,'AMD','CARACTERISTICAS \r\n\r\nVelocidad de Reloj 3,2Ghz\r\nMemoria Caché 6MB L3\r\nTecnología del Procesador65nmSOI\r\nFormato Socket AM3+\r\nDescripción de la Alimentación\r\nVoltaje de Entrada 125W\r\nCondiciones Ambientales\r\nRefrigeración','Phenon II X4 955',1,1),(3,143,'INTEL CORE 2 QUAD Q8300 \r\n2.50GHZ',9,'INTEL','Tecnología: Quad-Core \r\nComputación de 64 bits: Sí\r\nCantidad de procesadores: 1\r\nVelocidad reloj: 2.50 GHz\r\nVelocidad del bus: 1333 MHz\r\nZócalo de procesador: LGA775 Socket\r\nFabricación: 45 nm\r\nPotencia:95 W\r\nCaché:  L2 - 4 MB','Quad Core Q8300',1,2),(4,65,'Seagate Barracuda 1TB',7,'Seagate','Disco duro Seagate Barracuda interno SATA2.\r\n5900 rpm, cache 32MB','ST31000520AS',2,3),(5,55,'Western Digital 500 GB',8,'Western Digital','Disco Duro Western Digital Interno 3.5´´ 500GB SATA 32MB Cache','WD5000AADS',1,3),(6,107,'LCD LG 18.5\"',7,'LG','Pantalla TFT\r\nTamaño 18.5&#8221; Panorámico\r\nDimensiones (mm) 448 x 198 x 383m\r\nPeso (Kg) 4,10 Kg\r\ncontraste 8000:1, resolución WSXGA+, tiempo de respuesta de 5ms','W1943S',1,5),(7,275,'SAMSUNG TFT 23\"',3,'Samsung','TFT 23 pulgadas panorámico con sintonizador de (TDT). Contrate 50000:1, tiempo respuesta: 5ms. Full HD\r\nConector HDMI.\r\nSintonizador TDT integrado. \r\nFormato 16:9','P2370HD',3,5);

/*Table structure for table `usuario` */

DROP TABLE IF EXISTS `usuario`;

CREATE TABLE `usuario` (
  `ID` bigint(20) NOT NULL AUTO_INCREMENT,
  `TIPO` varchar(255) DEFAULT NULL,
  `ULTIMOACCESO` date DEFAULT NULL,
  `LOGIN` varchar(255) DEFAULT NULL,
  `FECHAALTA` date DEFAULT NULL,
  `PASSWORD` varchar(255) DEFAULT NULL,
  `VERSION` int(11) DEFAULT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=MyISAM AUTO_INCREMENT=6 DEFAULT CHARSET=latin1;

/*Data for the table `usuario` */

insert  into `usuario`(`ID`,`TIPO`,`ULTIMOACCESO`,`LOGIN`,`FECHAALTA`,`PASSWORD`,`VERSION`) values (1,'CLIENTE',NULL,'luis',NULL,'luis',1),(2,'CLIENTE','2009-12-09','ana',NULL,'ana',3),(5,'CLIENTE',NULL,'pedro',NULL,'pedro',1);

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
