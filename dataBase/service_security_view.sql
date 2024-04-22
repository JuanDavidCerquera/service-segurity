-- MySQL dump 10.13  Distrib 8.0.34, for Win64 (x86_64)
--
-- Host: localhost    Database: service_security
-- ------------------------------------------------------
-- Server version	8.0.34

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!50503 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `view`
--

DROP TABLE IF EXISTS `view`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `view` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `created_at` datetime(6) DEFAULT NULL,
  `created_by` bigint DEFAULT NULL,
  `deleted_at` datetime(6) DEFAULT NULL,
  `deleted_by` bigint DEFAULT NULL,
  `state` bit(1) NOT NULL,
  `updated_at` datetime(6) DEFAULT NULL,
  `updated_by` bigint DEFAULT NULL,
  `description` varchar(50) NOT NULL,
  `name` varchar(50) NOT NULL,
  `route` varchar(255) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `UK_d3gdyylhw9vkmxt7l7m4lu912` (`description`)
) ENGINE=InnoDB AUTO_INCREMENT=30 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `view`
--

LOCK TABLES `view` WRITE;
/*!40000 ALTER TABLE `view` DISABLE KEYS */;
INSERT INTO `view` VALUES (1,NULL,NULL,NULL,NULL,_binary '',NULL,NULL,'person','person','../view/Security/person.html'),(2,NULL,NULL,NULL,NULL,_binary '',NULL,NULL,'role','role','../view/Security/role.html'),(3,NULL,NULL,NULL,NULL,_binary '',NULL,NULL,'module','module','../view/Security/module.html'),(4,NULL,NULL,NULL,NULL,_binary '',NULL,NULL,'user','user','../view/Security/user.html'),(5,NULL,NULL,NULL,NULL,_binary '',NULL,NULL,'view','view','../view/Security/view.html'),(6,NULL,NULL,NULL,NULL,_binary '',NULL,NULL,'location','location','../view/Parameter/location.html'),(7,NULL,NULL,NULL,NULL,_binary '',NULL,NULL,'country','country','../view/Parameter/country.html'),(8,NULL,NULL,NULL,NULL,_binary '',NULL,NULL,'continent','continent','../view/Parameter/continent.html'),(9,NULL,NULL,NULL,NULL,_binary '',NULL,NULL,'neighborhood','neighborhood','../view/Parameter/neighborhood.html'),(10,NULL,NULL,NULL,NULL,_binary '',NULL,NULL,'Municipality','Municipality','../view/Parameter/municipality.html'),(11,NULL,NULL,NULL,NULL,_binary '',NULL,NULL,'state','state','../view/Parameter/state.html'),(12,NULL,NULL,NULL,NULL,_binary '',NULL,NULL,'company','company','../view/Operational/company.html'),(13,NULL,NULL,NULL,NULL,_binary '',NULL,NULL,'contract','contract','../view/Operational/contract.html'),(14,NULL,NULL,NULL,NULL,_binary '',NULL,NULL,'employed','employed','../view/Operational/employed.html'),(15,NULL,NULL,NULL,NULL,_binary '',NULL,NULL,'position','position','../view/Operational/position.html'),(16,NULL,NULL,NULL,NULL,_binary '',NULL,NULL,'lending','lending','../view/Operational/lending.html'),(17,NULL,NULL,NULL,NULL,_binary '',NULL,NULL,'libro','libro','../view/Operational/libro.html');
/*!40000 ALTER TABLE `view` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2024-04-22 11:43:28
