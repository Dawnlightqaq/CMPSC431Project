-- MySQL dump 10.13  Distrib 8.2.0, for macos13 (arm64)
--
-- Host: 127.0.0.1    Database: CMPSC431W
-- ------------------------------------------------------
-- Server version	8.2.0

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!50503 SET NAMES utf8mb4 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `Announcement`
--

DROP TABLE IF EXISTS `Announcement`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `Announcement` (
  `Title` varchar(30) NOT NULL,
  `Date` date NOT NULL,
  `Content` varchar(300) DEFAULT NULL,
  `EID` int NOT NULL,
  PRIMARY KEY (`Title`,`Date`),
  KEY `announcement_ibfk_1` (`EID`),
  CONSTRAINT `announcement_ibfk_1` FOREIGN KEY (`EID`) REFERENCES `Employee` (`EID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Announcement`
--

LOCK TABLES `Announcement` WRITE;
/*!40000 ALTER TABLE `Announcement` DISABLE KEYS */;
/*!40000 ALTER TABLE `Announcement` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `Coach`
--

DROP TABLE IF EXISTS `Coach`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `Coach` (
  `Coach_EID` int NOT NULL,
  `Field` varchar(50) DEFAULT NULL,
  `Gender` char(1) DEFAULT NULL,
  PRIMARY KEY (`Coach_EID`),
  CONSTRAINT `coach_ibfk_1` FOREIGN KEY (`Coach_EID`) REFERENCES `Employee` (`EID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Coach`
--

LOCK TABLES `Coach` WRITE;
/*!40000 ALTER TABLE `Coach` DISABLE KEYS */;
INSERT INTO `Coach` VALUES (1,'newfield','M'),(2,'tes','M');
/*!40000 ALTER TABLE `Coach` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `Coach_teach_course`
--

DROP TABLE IF EXISTS `Coach_teach_course`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `Coach_teach_course` (
  `Coach_EID` int NOT NULL,
  `Course_name` varchar(30) NOT NULL,
  `Season` char(2) NOT NULL,
  `Year` int NOT NULL,
  PRIMARY KEY (`Coach_EID`,`Course_name`,`Season`,`Year`),
  KEY `Course_name` (`Course_name`,`Season`,`Year`),
  CONSTRAINT `coach_teach_course_ibfk_1` FOREIGN KEY (`Coach_EID`) REFERENCES `Coach` (`Coach_EID`),
  CONSTRAINT `coach_teach_course_ibfk_2` FOREIGN KEY (`Course_name`, `Season`, `Year`) REFERENCES `Course` (`Course_name`, `Season`, `Year`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Coach_teach_course`
--

LOCK TABLES `Coach_teach_course` WRITE;
/*!40000 ALTER TABLE `Coach_teach_course` DISABLE KEYS */;
INSERT INTO `Coach_teach_course` VALUES (2,'test1','FA',2022);
/*!40000 ALTER TABLE `Coach_teach_course` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `Comments`
--

DROP TABLE IF EXISTS `Comments`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `Comments` (
  `CID` int NOT NULL AUTO_INCREMENT,
  `Comment_Content` varchar(100) DEFAULT NULL,
  `UID` int NOT NULL,
  PRIMARY KEY (`CID`),
  KEY `UID` (`UID`),
  CONSTRAINT `comments_ibfk_1` FOREIGN KEY (`UID`) REFERENCES `User` (`UID`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Comments`
--

LOCK TABLES `Comments` WRITE;
/*!40000 ALTER TABLE `Comments` DISABLE KEYS */;
INSERT INTO `Comments` VALUES (1,'test',7),(2,'test2',6);
/*!40000 ALTER TABLE `Comments` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `Course`
--

DROP TABLE IF EXISTS `Course`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `Course` (
  `Course_name` varchar(30) NOT NULL,
  `Season` char(2) NOT NULL,
  `Year` int NOT NULL,
  PRIMARY KEY (`Course_name`,`Season`,`Year`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Course`
--

LOCK TABLES `Course` WRITE;
/*!40000 ALTER TABLE `Course` DISABLE KEYS */;
INSERT INTO `Course` VALUES ('test1','FA',2022),('test1','FA',2023),('test2','SU',2023),('test3','FA',2023),('test4','SP',2023);
/*!40000 ALTER TABLE `Course` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `Employee`
--

DROP TABLE IF EXISTS `Employee`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `Employee` (
  `EID` int NOT NULL AUTO_INCREMENT,
  `Name` varchar(30) DEFAULT NULL,
  `Email` varchar(60) DEFAULT NULL,
  `Phone_number` bigint DEFAULT NULL,
  `Salary` int DEFAULT NULL,
  `Birthday` date DEFAULT NULL,
  `Login_time` datetime DEFAULT NULL,
  PRIMARY KEY (`EID`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Employee`
--

LOCK TABLES `Employee` WRITE;
/*!40000 ALTER TABLE `Employee` DISABLE KEYS */;
INSERT INTO `Employee` VALUES (1,'e1','e1@1',123,0,'2023-12-02','2023-12-03 00:00:00'),(2,'NewE','newE@1',12314,NULL,'2023-12-01','2023-12-02 00:00:00'),(3,'ly','tes@new',1234,NULL,'2023-12-01','2023-12-02 00:00:00');
/*!40000 ALTER TABLE `Employee` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `Facility`
--

DROP TABLE IF EXISTS `Facility`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `Facility` (
  `FID` int NOT NULL AUTO_INCREMENT,
  `Status` varchar(30) DEFAULT NULL,
  `Purchase_time` date DEFAULT NULL,
  `Facility_name` varchar(30) DEFAULT NULL,
  `In_use_status` bit(1) DEFAULT NULL,
  PRIMARY KEY (`FID`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Facility`
--

LOCK TABLES `Facility` WRITE;
/*!40000 ALTER TABLE `Facility` DISABLE KEYS */;
INSERT INTO `Facility` VALUES (1,'new','2023-12-02','F1',_binary '\0'),(2,'new','2023-12-02','F2',_binary '\0'),(4,'new','2023-12-02','newfa',_binary '\0');
/*!40000 ALTER TABLE `Facility` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `Facility_usage`
--

DROP TABLE IF EXISTS `Facility_usage`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `Facility_usage` (
  `UID` int NOT NULL,
  `FID` int NOT NULL,
  `Time` date NOT NULL,
  PRIMARY KEY (`UID`,`FID`,`Time`),
  KEY `FID` (`FID`),
  CONSTRAINT `facility_usage_ibfk_1` FOREIGN KEY (`FID`) REFERENCES `Facility` (`FID`),
  CONSTRAINT `facility_usage_ibfk_2` FOREIGN KEY (`UID`) REFERENCES `User` (`UID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Facility_usage`
--

LOCK TABLES `Facility_usage` WRITE;
/*!40000 ALTER TABLE `Facility_usage` DISABLE KEYS */;
/*!40000 ALTER TABLE `Facility_usage` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `Payment`
--

DROP TABLE IF EXISTS `Payment`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `Payment` (
  `PID` int NOT NULL AUTO_INCREMENT,
  `Purpose` varchar(50) DEFAULT NULL,
  `Amount` int DEFAULT NULL,
  `Payment_date` date DEFAULT NULL,
  `Pay_UID` int NOT NULL,
  PRIMARY KEY (`PID`),
  KEY `Pay_UID` (`Pay_UID`),
  CONSTRAINT `payment_ibfk_1` FOREIGN KEY (`Pay_UID`) REFERENCES `User` (`UID`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Payment`
--

LOCK TABLES `Payment` WRITE;
/*!40000 ALTER TABLE `Payment` DISABLE KEYS */;
INSERT INTO `Payment` VALUES (1,'Membership',123,'2023-12-02',7);
/*!40000 ALTER TABLE `Payment` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `User`
--

DROP TABLE IF EXISTS `User`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `User` (
  `UID` int NOT NULL AUTO_INCREMENT,
  `Name` varchar(30) DEFAULT NULL,
  `Email` varchar(60) DEFAULT NULL,
  `Phone_number` bigint DEFAULT NULL,
  `Gender` char(1) DEFAULT NULL,
  `Birthday` date DEFAULT NULL,
  `Login_time` datetime DEFAULT NULL,
  `registration_date` date DEFAULT NULL,
  PRIMARY KEY (`UID`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `User`
--

LOCK TABLES `User` WRITE;
/*!40000 ALTER TABLE `User` DISABLE KEYS */;
INSERT INTO `User` VALUES (1,NULL,'test@qw',123,'M','2023-12-09','2023-12-02 19:31:36','2023-12-01'),(2,NULL,'test@new',123,'M','2023-12-08','2023-12-02 00:00:00','2023-12-01'),(3,'test','test@12',123,'F','1212-12-20','2023-12-01 00:00:00','2023-12-01'),(4,'new','test@new',123,'F','0323-12-20','2023-12-02 00:00:00','2023-12-02'),(5,'Leyan','test1@1',12324,'F','2321-12-30','2023-12-02 00:00:00','2023-12-02'),(6,'e','tes@1',13124,'F','0213-02-12','2023-12-02 00:00:00','2023-12-02'),(7,'Leyang Zhang','new@1',12,'F','2000-12-03','2023-12-03 00:00:00','2023-12-02'),(8,'aer','tes@1',1234,'F','0312-12-30','2023-12-02 00:00:00','2023-12-02'),(9,'12','tes@1',1232,'F','0024-12-03','2023-12-02 00:00:00','2023-12-02'),(10,'123','tr@12',1312,'F','0024-12-30','2023-12-02 00:00:00','2023-12-02');
/*!40000 ALTER TABLE `User` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `User_take_Course`
--

DROP TABLE IF EXISTS `User_take_Course`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `User_take_Course` (
  `UID` int NOT NULL,
  `Course_name` varchar(30) NOT NULL,
  `Season` char(2) NOT NULL,
  `Year` int NOT NULL,
  PRIMARY KEY (`UID`,`Course_name`,`Season`,`Year`),
  KEY `Course_name` (`Course_name`,`Season`,`Year`),
  CONSTRAINT `user_take_course_ibfk_1` FOREIGN KEY (`UID`) REFERENCES `User` (`UID`),
  CONSTRAINT `user_take_course_ibfk_2` FOREIGN KEY (`Course_name`, `Season`, `Year`) REFERENCES `Course` (`Course_name`, `Season`, `Year`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `User_take_Course`
--

LOCK TABLES `User_take_Course` WRITE;
/*!40000 ALTER TABLE `User_take_Course` DISABLE KEYS */;
INSERT INTO `User_take_Course` VALUES (7,'test1','FA',2022);
/*!40000 ALTER TABLE `User_take_Course` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2023-12-03  0:40:06
