-- MariaDB dump 10.19  Distrib 10.4.32-MariaDB, for Win64 (AMD64)
--
-- Host: localhost    Database: oes2
-- ------------------------------------------------------
-- Server version	10.4.32-MariaDB

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `add_addmission`
--

DROP TABLE IF EXISTS `add_addmission`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `add_addmission` (
  `Registration_Number` int(100) NOT NULL AUTO_INCREMENT,
  `First_Name` varchar(500) NOT NULL,
  `Middle_Name` varchar(500) NOT NULL,
  `Last_Name` varchar(500) NOT NULL,
  `Name_On_Certificate` varchar(500) NOT NULL,
  `Course_Name` varchar(500) NOT NULL,
  `Date_Of_Birth` varchar(100) NOT NULL,
  `Gender` varchar(100) NOT NULL,
  `Marital_Status` varchar(100) NOT NULL,
  `Address` varchar(100) NOT NULL,
  `Pincode` varchar(100) NOT NULL,
  `Contact_Number` varchar(100) NOT NULL,
  `Email_ID` varchar(100) NOT NULL,
  `Addhar_Number` varchar(100) NOT NULL,
  `Date_Of_Admission` varchar(100) NOT NULL,
  PRIMARY KEY (`Registration_Number`)
) ENGINE=InnoDB AUTO_INCREMENT=107 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `add_addmission`
--

LOCK TABLES `add_addmission` WRITE;
/*!40000 ALTER TABLE `add_addmission` DISABLE KEYS */;
INSERT INTO `add_addmission` VALUES (100,'Siddhant','Kumar','Gupta',' Siddhant Kumar Gupta','C','2024-04-05','Male','Married','Nashik','422401','9145160843','sidd@gmail.com','123456789012','2024-04-05'),(101,'Anu','Kumari','Gupta',' Anu Kumari Gupta','C','2002-06-21','Female','Unmarried','Nashik','422401','9145160843','anu123@gmail.com','123456789012','2024-04-17'),(103,'Bharat','Lal','Gupta',' Bharat Lal Gupta','C','2000-07-07','Male','Married','Nashik','422401','9145160843','siddhant8796@gmail.com','123456789012','2024-04-17'),(104,'Bindresh','Kumar','Saha',' Bindresh Kumar Saha','C','2001-04-03','Male','Unmarried','Deoria','422401','9145160843','bindresh123@gmail.com','123456789012','2024-04-17'),(105,'Satya ','Praksh','Thakur',' Satya  Praksh Thakur','C','2024-07-04','Male','Unmarried','Nashik','422401','9145160843','satya@gmail.com','123456789012','2024-04-17'),(106,'Mohit','Kumar','Gupta',' Mohit Kumar Gupta','C','1997-04-08','Male','Unmarried','Nashik, Maharashtra','422401','8482975892','mohit1236@gmail.com','123456789012','2025-01-12');
/*!40000 ALTER TABLE `add_addmission` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `add_question`
--

DROP TABLE IF EXISTS `add_question`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `add_question` (
  `Question_Number` int(100) NOT NULL AUTO_INCREMENT,
  `Course_Name` varchar(100) NOT NULL,
  `questions` varchar(100) NOT NULL,
  `option_1` varchar(500) NOT NULL,
  `option_2` varchar(500) NOT NULL,
  `option_3` varchar(500) NOT NULL,
  `option_4` varchar(500) NOT NULL,
  `correct_ans` varchar(500) NOT NULL,
  PRIMARY KEY (`Question_Number`)
) ENGINE=InnoDB AUTO_INCREMENT=51 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `add_question`
--

LOCK TABLES `add_question` WRITE;
/*!40000 ALTER TABLE `add_question` DISABLE KEYS */;
INSERT INTO `add_question` VALUES (1,'C','Who is the father of C language?','Steve Jobs',' James Gosling',' Dennis Ritchie',' Rasmus Lerdorf',' Dennis Ritchie'),(2,'C','Which of the following is not a valid C variable name?','int number;',' float rate;','int variable_count;','int $main;','int $main;'),(3,'C','All keywords in C are in ____________','LowerCase letters','UpperCase letters','CamelCase letters','None of the mentioned','LowerCase letters'),(4,'C',' Which of the following is true for variable names in C?','They can contain alphanumeric characters as well as special characters','It is not an error to declare a variable to be one of the keywords(like goto, static)','Variable names cannot start with a digit','Variable can be of any length','Variable names cannot start with a digit'),(5,'C','Which is valid C expression?','int my_num = 100,000;','int my_num = 100000;','int my num = 1000;','int $my_num = 10000;','int my_num = 100000;'),(6,'C','Which of the following cannot be a variable name in C?','volatile','true','friend','export','volatile'),(7,'C',' What is short int in C programming?','The basic data type of C',' Qualifier','Short is the qualifier and int is the basic data type','All of the mentioned','Short is the qualifier and int is the basic data type'),(8,'C','Which keyword is used to prevent any changes in the variable within a C program?','immutable','mutable','const','volatile','const'),(9,'C','What is the result of logical or relational expression in C?','True or False','0 or 1','0 if an expression is false and any positive number if an expression is true','None of the mentioned','0 or 1'),(10,'C','Which of the following typecasting is accepted by C language?','Widening conversions',' Narrowing conversions','Widening & Narrowing conversions','None of the mentioned','Widening & Narrowing conversions'),(11,'C','A Local variable is stored in__________','Code segment','Stack segment','Heap segment','None of the Above','Stack segment'),(12,'C','Where in C the order of precedence of operators do not exist?','Within conditional statements, if, else','Within while, do-while','Within a macro definition','None of the mentioned','None of the mentioned'),(13,'C','Which of the following is NOT possible with any 2 operators in C?','Different precedence, same associativity','Different precedence, different associativity','Same precedence, different associativity','All of the mentioned','All of the mentioned'),(14,'C','What is an example of iteration in C?','for','while','do-while','all of the mentioned','all of the mentioned'),(15,'C','Functions can return enumeration constants in C?','true','false','depends on the compiler','depends on the standard','true'),(16,'C','Functions in C Language are always _________','Internal','External','Both Internal and External','External and Internal are not valid terms for functions','External'),(17,'C','Which of following is not accepted in C?','static a = 10; //static as','static int func (int); //parameter as static','static static int a; //a static variable prefixed with static','all of the mentioned','static static int a; //a static variable prefixed with static'),(18,'C','Property which allows to produce different executable for different platforms in C is called?','File inclusion','Selective inclusion','Conditional compilation','Recursive macros','Conditional compilation'),(19,'C','What is #include <stdio.h>?','Preprocessor directive','Inclusion directive','File inclusion directive','None of the mentioned','Preprocessor directive'),(20,'C','C preprocessors can have compiler specific features.','True','False','Depends on the standard','Depends on the platform','True'),(21,'C','Which of the following are C preprocessors?','#ifdef','#define','#endif','all of the mentioned','all of the mentioned'),(22,'C','The C-preprocessors are specified with _________ symbol.','#','$','\" \"','&','#'),(23,'C','How is search done in #include and #include “somelibrary.h” according to C standard?','When former is used, current directory is searched and when latter is used, standard directory is searched','When former is used, standard directory is searched and when latter is used, current directory is searched','When former is used, search is done in implementation defined manner and when latter is used, current directory is searched','For both, search for ‘somelibrary’ is done in implementation-defined places','When former is used, standard directory is searched and when latter is used, current directory is searched'),(24,'C','How many number of pointer (*) does C have against a pointer variable declaration?','7','127','255','No limits','No limits'),(25,'C','Which of the following is not possible statically in C language?','Jagged Array','Rectangular Array','Cuboidal Array','Multidimensional Array','Jagged Array'),(26,'C','Which of the following return-type cannot be used for a function in C?','char *','struct','void','none of the mentioned','none of the mentioned'),(27,'C','The standard header _______ is used for variable list arguments (…) in C.','<stdio.h >','<stdlib.h>','<math.h>','<stdarg.h>','<stdarg.h>'),(28,'C','In C language, FILE is of which data type?','int','char *','struct','None of the mentioned','struct'),(29,'C','What is the sizeof(char) in a 32-bit C compiler?','1 bit','2 bits','1 Byte','2 Bytes','1 Byte'),(30,'C','Which of the following is not an operator in C?',',','sizeof()','~','None of the mentioned','None of the mentioned'),(31,'C','scanf() is a predefined function in______header file.','stdlib. h','ctype. h','stdio. h','stdarg. h','stdio. h'),(32,'C','What is meant by ‘a’ in the following C operation?   fp = fopen(\"Random.txt\", \"a\");','Attach','Append','Apprehend','Add','Append'),(33,'C','What are the elements present in the array of the following C code?  int array[5] = {5};','5, 5, 5, 5, 5','5, 0, 0, 0, 0','5, (garbage), (garbage), (garbage), (garbage)','(garbage), (garbage), (garbage), (garbage), 5','5, 0, 0, 0, 0'),(34,'C','Which of the following sequences are unaccepted in C language?','#if    #else    #endif','#if    #elif    #endif','#if    #if    #endif','#if    #undef    #endif','#if    #if    #endif'),(35,'C','The C code ‘for(;;)’ represents an infinite loop. It can be terminated by ___________','break','exit(0)','abort()','terminate','break'),(36,'C','Which for loop has range of similar indexes of ‘i’ used in for (i = 0;i < n; i++)?','for (i = n; i>0; i–)','for (i = n; i >= 0; i–)','for (i = n-1; i>0; i–)','for (i = n-1; i>-1; i–)','for (i = n-1; i>-1; i–)'),(37,'C','Which of the following cannot be used as LHS of the expression in for (exp1;exp2; exp3)?','variable','function','typedef','macros','macros'),(38,'C','C language was developed by ?','Ken Thompson','Peter Norton','Von Newman','Dennis Ritchie','Dennis Ritchie'),(39,'C','In C which character is used to terminate the instruction ?','A. .','B. ;','C. :',' D. ,',' D. ,'),(40,'C','In C which character is used to terminate the instruction ?','.',';',':',',',';'),(41,'C','Programs cab be written in ... ?','Lower case letters','Upper case letters','Mixed letters','None of these','Lower case letters'),(42,'C','Which of these is not a version of C language ?','Microsoft C','Quick C','Turbo C','Fast C','Fast C'),(43,'C','C Programming Follows ....?','Non structured approach','Structured approach','Object oriented approach','None of these','Structured approach'),(44,'C','C Programs are converted into machine language with the helop of ..... ?','Compiler','Interpreter','Operating system','Assembler','Compiler'),(45,'C','C was primarily developed as a ?','Systems Programing Language','General Purpose Language','Data Processing Language','D. None of the above','Systems Programing Language'),(46,'C','A character variable can at a time store ?','1 character','8 characters','254 characters','None of these','1 character'),(47,'C','The real constant in C can be expressed in which of the following forms ?','Fractional form only','Exponential form only','ASCII form only','Both fractional and Exponential form','Both fractional and Exponential form'),(48,'C','Who is the father of C language?','Steve Jobs','James Gosling','Dennis Ritchie','Rasmus Lerdorf','Dennis Ritchie'),(49,'C','Which of the following is not a valid C variable name?','int number;','float rate;','int variable_count;','int $main;','int $main;'),(50,'C','All keywords in C are in ____________','LowerCase letters','UpperCase letters','CamelCase letters','None of the mentioned','LowerCase letters');
/*!40000 ALTER TABLE `add_question` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `admin`
--

DROP TABLE IF EXISTS `admin`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `admin` (
  `Admi_ID` int(100) NOT NULL AUTO_INCREMENT,
  `Admin_Name` varchar(100) NOT NULL,
  `Admin_Secrete_Code` varchar(100) NOT NULL,
  `Username` varchar(100) NOT NULL,
  `Password` varchar(100) NOT NULL,
  PRIMARY KEY (`Admi_ID`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `admin`
--

LOCK TABLES `admin` WRITE;
/*!40000 ALTER TABLE `admin` DISABLE KEYS */;
INSERT INTO `admin` VALUES (1,'Siddhant','Urmila','admin','admin');
/*!40000 ALTER TABLE `admin` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `student_exam_score`
--

DROP TABLE IF EXISTS `student_exam_score`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `student_exam_score` (
  `Registration_Number` int(100) NOT NULL AUTO_INCREMENT,
  `Name_On_Certificate` varchar(200) NOT NULL,
  `Course_Name` varchar(200) NOT NULL,
  `Exam_Date` date NOT NULL,
  `Score` int(100) NOT NULL,
  `Grade` varchar(100) NOT NULL,
  `Result_Status` varchar(100) NOT NULL,
  PRIMARY KEY (`Registration_Number`)
) ENGINE=InnoDB AUTO_INCREMENT=107 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `student_exam_score`
--

LOCK TABLES `student_exam_score` WRITE;
/*!40000 ALTER TABLE `student_exam_score` DISABLE KEYS */;
INSERT INTO `student_exam_score` VALUES (100,' Siddhant Kumar Gupta','C','2024-04-17',28,'F','Fail'),(101,' Anu Kumari Gupta','C','2024-04-17',26,'F','Fail'),(102,' Urmila Devi Gupta','C','2024-04-17',74,'A','Pass'),(103,' Bharat Lal Gupta','C','2024-04-17',60,'B','Pass'),(106,' Mohit Kumar Gupta','C','2025-01-12',32,'F','Fail');
/*!40000 ALTER TABLE `student_exam_score` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `student_user_id_password`
--

DROP TABLE IF EXISTS `student_user_id_password`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `student_user_id_password` (
  `Registration_Number` int(100) NOT NULL AUTO_INCREMENT,
  `Name_On_Certificate` varchar(100) NOT NULL,
  `Course_Name` varchar(200) NOT NULL,
  `Username` varchar(100) NOT NULL,
  `Password` varchar(100) NOT NULL,
  `Date_Of_Admission` date NOT NULL,
  `Exam_Taken` int(100) NOT NULL,
  PRIMARY KEY (`Registration_Number`)
) ENGINE=InnoDB AUTO_INCREMENT=107 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `student_user_id_password`
--

LOCK TABLES `student_user_id_password` WRITE;
/*!40000 ALTER TABLE `student_user_id_password` DISABLE KEYS */;
INSERT INTO `student_user_id_password` VALUES (100,' Siddhant Kumar Gupta','C','Siddhant100','Siddhant100','2024-04-05',1),(101,' Anu Kumari Gupta','C','Anu101','Anu101','2024-04-17',1),(103,' Bharat Lal Gupta','C','Bharat103','Bharat103','2024-04-17',1),(104,' Bindresh Kumar Saha','C','Bindresh104','Bindresh104','2024-04-17',1),(105,' Satya  Praksh Thakur','C','Satya 105','Satya 105','2024-04-17',0),(106,' Mohit Kumar Gupta','C','Mohit106','Mohit106','2025-01-12',1);
/*!40000 ALTER TABLE `student_user_id_password` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2025-02-27 12:43:31
