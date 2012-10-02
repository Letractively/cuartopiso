-- phpMyAdmin SQL Dump
-- version 3.3.9
-- http://www.phpmyadmin.net
--
-- Servidor: localhost
-- Tiempo de generación: 09-11-2011 a las 18:56:44
-- Versión del servidor: 5.5.8
-- Versión de PHP: 5.3.5

SET SQL_MODE="NO_AUTO_VALUE_ON_ZERO";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

--
-- Base de datos: `facturador`
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `articulos`
--

CREATE TABLE IF NOT EXISTS `articulos` (
  `id` int(4) NOT NULL AUTO_INCREMENT,
  `sec` int(2) NOT NULL,
  `art` int(4) NOT NULL,
  `descripcion` varchar(50) CHARACTER SET utf8 COLLATE utf8_spanish_ci NOT NULL,
  `precio` float NOT NULL,
  `stock` int(4) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM  DEFAULT CHARSET=latin1 AUTO_INCREMENT=12 ;

--
-- Volcar la base de datos para la tabla `articulos`
--

INSERT INTO `articulos` (`sec`, `art`, `descripcion`, `precio`, `stock`) VALUES
( 1, 1234, 'Alfajores Jorgito x 10 unidades', 2.35, 23),
( 1, 3221, 'Alfajor Milka', 2.5, 100),
( 2, 5993, 'Chicles Beldent', 1.25, 49),
( 2, 3211, 'Topline x 7', 0.55, 122),
( 3, 9442, 'Coca Cola x 1.25 L', 5.75, 59),
(6, 3, 4563, 'Pepsi 750cm3', 3.9, 93),
( 3, 2311, 'Paso de los Toros 2Lts', 6.25, 110),
( 4, 21, '3D x 500gm', 6.15, 65),
( 4, 2315, 'Galletas Surtidas', 5.2, 45),
( 5, 8392, 'Pañuelos Descatables', 4.25, 54),
( 5, 4221, 'Prime Clasicos', 8.45, 76);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `categoria`
--

CREATE TABLE IF NOT EXISTS `categoria` (
  `id` int(2) NOT NULL AUTO_INCREMENT,
  `nombre` varchar(50) CHARACTER SET utf8 COLLATE utf8_spanish_ci NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM  DEFAULT CHARSET=latin1 AUTO_INCREMENT=6 ;

--
-- Volcar la base de datos para la tabla `categoria`
--

INSERT INTO `categoria` (`id`, `nombre`) VALUES
(1, 'Empleado'),
(2, 'Encargado'),
(3, 'Supervisor'),
(4, 'Cliente'),
(5, 'Jefe');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `empresas`
--

CREATE TABLE IF NOT EXISTS `empresas` (
  `id` int(2) NOT NULL AUTO_INCREMENT,
  `nombre` varchar(50) CHARACTER SET utf8 COLLATE utf8_spanish_ci NOT NULL,
  `cuit` varchar(13) CHARACTER SET utf8 COLLATE utf8_spanish_ci NOT NULL,
  `telefono` int(20) NOT NULL,
  `factura` varchar(10) CHARACTER SET utf8 COLLATE utf8_spanish_ci NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1 AUTO_INCREMENT=1 ;

--
-- Volcar la base de datos para la tabla `empresas`
--


-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `usuario`
--

CREATE TABLE IF NOT EXISTS `usuario` (
  `id` int(2) NOT NULL AUTO_INCREMENT,
  `usr` varchar(50) CHARACTER SET utf8 COLLATE utf8_spanish_ci NOT NULL,
  `psw` varchar(50) CHARACTER SET utf8 COLLATE utf8_spanish_ci NOT NULL,
  `nombre` varchar(100) CHARACTER SET utf8 COLLATE utf8_spanish_ci NOT NULL,
  `apellido` varchar(100) CHARACTER SET utf8 COLLATE utf8_spanish_ci NOT NULL,
  `categoria` bigint(2) NOT NULL,
  `fecha` date NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM  DEFAULT CHARSET=latin1 AUTO_INCREMENT=9 ;

--
-- Volcar la base de datos para la tabla `usuario`
--

INSERT INTO `usuario` (`id`, `usr`, `psw`, `nombre`, `apellido`, `categoria`, `fecha`) VALUES
(1, 'franco', '7110eda4d09e062aa5e4a390b0a572ac0d2c0220', 'Franco A.L.', 'Capra', 5, '2011-11-08'),
(2, 'alksd', 'lakds', 'aksld', 'alksdj', 2, '2001-11-10'),
(3, 'alb', '12', 'Alberto', 'Perez', 2, '2001-11-10'),
(4, '', '', '', '', 2, '2001-11-10'),
(5, 'ale', '123456', 'Alejandro', 'Pepa', 1, '2001-11-10'),
(6, 'luis', '40bd001563085fc35165329ea1ff5c5ecbdbbeef', 'Luis', 'Barocchi', 4, '2001-11-10'),
(7, 'alkdj', '76658a2722cfc360b68a81107f0c193549bc08f4', 'alkjsd', 'asla', 2, '2011-11-08'),
(8, 'pablo', '40bd001563085fc35165329ea1ff5c5ecbdbbeef', 'Pablo', 'Nello', 4, '2011-11-09');
