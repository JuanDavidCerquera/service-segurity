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
-- Table structure for table `lending`
--

DROP TABLE IF EXISTS `lending`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `lending` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `created_at` datetime(6) DEFAULT NULL,
  `created_by` bigint DEFAULT NULL,
  `deleted_at` datetime(6) DEFAULT NULL,
  `deleted_by` bigint DEFAULT NULL,
  `state` bit(1) NOT NULL,
  `updated_at` datetime(6) DEFAULT NULL,
  `updated_by` bigint DEFAULT NULL,
  `action` bit(1) DEFAULT NULL,
  `amount` int DEFAULT NULL,
  `date` datetime(6) DEFAULT NULL,
  `book_id` bigint NOT NULL,
  `client_id` bigint NOT NULL,
  `employed_id` bigint NOT NULL,
  PRIMARY KEY (`id`),
  KEY `FK5dfmeoql9w2y3hjdvlgp2fp8s` (`book_id`),
  KEY `FKi58b9hfx0d4ihb5vajc6mxyqb` (`client_id`),
  KEY `FKd8n415wlt1q3nvi2lblcnyjsi` (`employed_id`),
  CONSTRAINT `FK5dfmeoql9w2y3hjdvlgp2fp8s` FOREIGN KEY (`book_id`) REFERENCES `book` (`id`),
  CONSTRAINT `FKd8n415wlt1q3nvi2lblcnyjsi` FOREIGN KEY (`employed_id`) REFERENCES `employed` (`id`),
  CONSTRAINT `FKi58b9hfx0d4ihb5vajc6mxyqb` FOREIGN KEY (`client_id`) REFERENCES `client` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `lending`
--

LOCK TABLES `lending` WRITE;
/*!40000 ALTER TABLE `lending` DISABLE KEYS */;
INSERT INTO `lending` VALUES (1,'2024-04-17 20:11:05.629912',1,NULL,NULL,_binary '','2024-04-18 01:49:42.137292',1,_binary '\0',10,'2024-04-18 16:09:00.000000',1,1,1),(2,'2024-04-17 20:20:16.420203',1,NULL,NULL,_binary '','2024-04-18 01:29:14.225685',1,_binary '\0',10,'2024-04-18 16:20:00.000000',1,1,1),(3,'2024-04-18 00:16:54.875521',1,NULL,NULL,_binary '','2024-04-18 01:43:04.000450',1,_binary '\0',20,'2024-04-19 11:16:00.000000',1,2,1),(4,'2024-04-18 01:33:00.945740',1,NULL,NULL,_binary '','2024-04-18 01:47:17.861548',1,_binary '\0',200,'2024-04-19 12:33:00.000000',1,1,1),(5,'2024-04-18 01:43:38.717684',1,NULL,NULL,_binary '','2024-04-18 01:48:34.103474',1,_binary '\0',200,'2024-04-19 12:43:00.000000',1,1,1),(6,'2024-04-21 22:00:02.747491',1,NULL,NULL,_binary '',NULL,NULL,_binary '',5,'2024-04-21 22:00:02.747491',4,3,1);
/*!40000 ALTER TABLE `lending` ENABLE KEYS */;
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
