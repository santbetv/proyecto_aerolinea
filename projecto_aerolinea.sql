-- MySQL  Distrib 5.7.37, for Linux (x86_64)
--
-- Host: localhost    Database: bd_aerolinea
-- ------------------------------------------------------
-- Server version	5.7.25-0ubuntu0.16.04.2

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;


DROP SCHEMA IF EXISTS bd_aerolinea;
CREATE SCHEMA bd_aerolinea;
USE bd_aerolinea;
SET AUTOCOMMIT=0;

--
-- Table structure for table `flight`
--

DROP TABLE IF EXISTS `flight`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `flight` (
  `id_flight` int(11) NOT NULL AUTO_INCREMENT COMMENT 'Clave primaria',	
  `departure_date` date COMMENT 'Fecha salida',
  `departure_station` varchar(30) COMMENT 'Ciudad salida' ,
  `arrival_station` varchar(30) COMMENT 'Ciudad entrada' ,
  `flight_number` varchar(10) COMMENT 'Número de vuelo',
  `price`  DECIMAL(8,2) COMMENT 'Valor de vuelo',
  `currency` varchar(10) COMMENT 'Moneda',
  PRIMARY KEY (`id_flight`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 COMMENT='tabla que permite alamcenar vuelos';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `flight`
--

LOCK TABLES `flight` WRITE;
/*!40000 ALTER TABLE `flight` DISABLE KEYS */;
INSERT INTO `flight` (departure_date,departure_station,arrival_station,flight_number,price,currency) VALUES ('2020-12-25','BOG','CTG','8226',600000.00,'COP'),('2020-12-30','BOG','CTG','8226',850000.00,'COP');
/*!40000 ALTER TABLE `flight` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
