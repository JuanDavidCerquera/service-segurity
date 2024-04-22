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
-- Table structure for table `person`
--

DROP TABLE IF EXISTS `person`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `person` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `created_at` datetime(6) DEFAULT NULL,
  `created_by` bigint DEFAULT NULL,
  `deleted_at` datetime(6) DEFAULT NULL,
  `deleted_by` bigint DEFAULT NULL,
  `state` bit(1) NOT NULL,
  `updated_at` datetime(6) DEFAULT NULL,
  `updated_by` bigint DEFAULT NULL,
  `document` varchar(10) NOT NULL,
  `address` varchar(100) NOT NULL,
  `date_of_birth` date NOT NULL,
  `email` varchar(50) NOT NULL,
  `first_name` varchar(50) NOT NULL,
  `gender` varchar(10) NOT NULL,
  `last_name` varchar(50) NOT NULL,
  `phone` varchar(15) NOT NULL,
  `type_document` varchar(50) NOT NULL,
  `municipality_id` bigint NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `UK_2gjs2q1w5r9gftdd1iftupi9a` (`document`),
  UNIQUE KEY `UK_fwmwi44u55bo4rvwsv0cln012` (`email`),
  KEY `FKfrqdnhf0079iiwru9uaxteko7` (`municipality_id`),
  CONSTRAINT `FKfrqdnhf0079iiwru9uaxteko7` FOREIGN KEY (`municipality_id`) REFERENCES `municipality` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `person`
--

LOCK TABLES `person` WRITE;
/*!40000 ALTER TABLE `person` DISABLE KEYS */;
INSERT INTO `person` VALUES (1,NULL,NULL,NULL,NULL,_binary '',NULL,NULL,'123456789','Calle Principal 123','1990-01-01','ejemplo@email.com','Juan','Masculino','Pérez','555-1234','DNI',1),(2,'2024-04-17 19:07:56.835769',1,NULL,NULL,_binary '',NULL,NULL,'1084922499','carerra No 1 - B - 36','2024-04-17','david@example.com','David','M','Salazar','318573684','cc',1),(3,'2024-04-17 19:09:28.846906',1,NULL,NULL,_binary '',NULL,NULL,'897654321','calle No 4 - W - 76','2024-04-03','gama@example.com','Gabriel','M','Marquez','3109876543','cc',1),(4,'2024-04-18 00:15:49.575682',1,NULL,NULL,_binary '',NULL,NULL,'1084922899','calle No 12 - w - 56','2024-04-18','carlitos@example.com','Carlitos','M','Rugars','1234567891','ti',1),(5,'2024-04-21 21:50:00.522995',1,NULL,NULL,_binary '',NULL,NULL,'1235','carerra No 12 - 12 - 12','2024-04-21','1235','david','M','cachaya','321','ti',1),(6,'2024-04-21 21:52:15.152999',1,NULL,NULL,_binary '',NULL,NULL,'987','calle No 12 - 32 - 5','2024-04-21','987','dad','M','ad','987','ti',1),(7,'2024-04-21 21:58:35.986652',1,NULL,NULL,_binary '',NULL,NULL,'024','calle No 12 - 12 - 12','2024-04-21','024','bo','M','bo','024','ti',1);
/*!40000 ALTER TABLE `person` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2024-04-22 11:43:29
