CREATE DATABASE  IF NOT EXISTS `bd_neptuno` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci */;
USE `bd_neptuno`;
-- MySQL dump 10.13  Distrib 8.0.13, for Win64 (x86_64)
--
-- Host: localhost    Database: bd_neptuno2
-- ------------------------------------------------------
-- Server version	8.0.13

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
 SET NAMES utf8 ;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `categorias`
--

DROP TABLE IF EXISTS `categorias`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `categorias` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `categoria` varchar(15) NOT NULL,
  `descripcion` text,
  PRIMARY KEY (`id`),
  UNIQUE KEY `uq_categoria` (`categoria`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `categorias`
--

LOCK TABLES `categorias` WRITE;
/*!40000 ALTER TABLE `categorias` DISABLE KEYS */;
INSERT INTO `categorias` VALUES (1,'Bebidas','Gaseosas, café, té, cervezas y maltas'),(2,'Condimentos','Salsas dulces y picantes, delicias, comida para untar y aderezos'),(3,'Repostería','Postres, dulces y pan dulce'),(4,'Lácteos','Quesos'),(5,'Granos/Cereales','Pan, galletas, pasta y cereales'),(6,'Carnes','Carnes preparadas'),(7,'Frutas/Verduras','Frutas secas y queso de soja'),(8,'Pescado/Marisco','Pescados, mariscos y algas');
/*!40000 ALTER TABLE `categorias` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `categorias_new`
--

DROP TABLE IF EXISTS `categorias_new`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `categorias_new` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `categoria` varchar(15) NOT NULL,
  `descripcion` text,
  PRIMARY KEY (`id`),
  UNIQUE KEY `uq_categoria_new` (`categoria`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `categorias_new`
--

LOCK TABLES `categorias_new` WRITE;
/*!40000 ALTER TABLE `categorias_new` DISABLE KEYS */;
/*!40000 ALTER TABLE `categorias_new` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `clavesanteriores`
--

DROP TABLE IF EXISTS `clavesanteriores`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `clavesanteriores` (
  `numero` int(11) NOT NULL AUTO_INCREMENT,
  `nombre` varchar(30) DEFAULT NULL,
  `clave` varchar(30) DEFAULT NULL,
  PRIMARY KEY (`numero`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `clavesanteriores`
--

LOCK TABLES `clavesanteriores` WRITE;
/*!40000 ALTER TABLE `clavesanteriores` DISABLE KEYS */;
INSERT INTO `clavesanteriores` VALUES (1,'marcos','123abc');
/*!40000 ALTER TABLE `clavesanteriores` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `clientes`
--

DROP TABLE IF EXISTS `clientes`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `clientes` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `codigo` varchar(5) NOT NULL,
  `empresa` varchar(40) NOT NULL,
  `contacto` varchar(30) DEFAULT NULL,
  `cargo_contacto` varchar(30) DEFAULT NULL,
  `direccion` varchar(60) DEFAULT NULL,
  `ciudad` varchar(15) DEFAULT NULL,
  `region` varchar(15) DEFAULT NULL,
  `cp` varchar(10) DEFAULT NULL,
  `pais` varchar(15) DEFAULT NULL,
  `telefono` varchar(24) DEFAULT NULL,
  `fax` varchar(24) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `uq_cliente1` (`codigo`),
  UNIQUE KEY `uq_cliente2` (`empresa`)
) ENGINE=InnoDB AUTO_INCREMENT=92 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `clientes`
--

LOCK TABLES `clientes` WRITE;
/*!40000 ALTER TABLE `clientes` DISABLE KEYS */;
INSERT INTO `clientes` VALUES (1,'ALFKI','Alfreds Futterkiste','Maria Anders','Representante de ventas','Obere Str. 57','Berlín',NULL,'12209','Alemania','030-0074321','030-0076545'),(2,'ANATR','Ana Trujillo Emparedados y helados','Ana Trujillo','Propietario','Avda. de la Constitución 2222','México D.F.',NULL,'05021','México','(5) 555-4729','(5) 555-3745'),(3,'ANTON','Antonio Moreno Taquería','Antonio Moreno','Propietario','Mataderos  2312','México D.F.',NULL,'05023','México','(5) 555-3932',NULL),(4,'AROUT','Around the Horn','Thomas Hardy','Representante de ventas','120 Hanover Sq.','Londres',NULL,'WA1 1DP','Reino Unido','(71) 555-7788','(71) 555-6750'),(5,'BERGS','Berglunds snabbköp','Christina Berglund','Administrador de pedidos','Berguvsvägen  8','Luleå',NULL,'S-958 22','Suecia','0921-12 34 65','0921-12 34 67'),(6,'BLAUS','Blauer See Delikatessen','Hanna Moos','Representante de ventas','Forsterstr. 57','Mannheim',NULL,'68306','Alemania','0621-08460','0621-08924'),(7,'BLONP','Blondel père et fils','Frédérique Citeaux','Gerente de marketing','24, place Kléber','Estrasburgo',NULL,'67000','Francia','88.60.15.31','88.60.15.32'),(8,'BOLID','Bólido Comidas preparadas','Martín Sommer','Propietario','C/ Araquil, 67','Madrid',NULL,'28023','España','(91) 555 22 82','(91) 555 91 99'),(9,'BONAP','Bon app\'','Laurence Lebihan','Propietario','12, rue des Bouchers','Marsella',NULL,'13008','Francia','91.24.45.40','91.24.45.41'),(10,'BOTTM','Bottom-Dollar Markets','Elizabeth Lincoln','Gerente de contabilidad','23 Tsawassen Blvd.','Tsawassen','BC','T2F 8M4','Canadá','(604) 555-4729','(604) 555-3745'),(11,'BSBEV','B\'s Beverages','Victoria Ashworth','Representante de ventas','Fauntleroy Circus','Londres',NULL,'EC2 5NT','Reino Unido','(71) 555-1212',NULL),(12,'CACTU','Cactus Comidas para llevar','Patricio Simpson','Agente de ventas','Cerrito 333','Buenos Aires',NULL,'1010','Argentina','(1) 135-5555','(1) 135-4892'),(13,'CENTC','Centro comercial Moctezuma','Francisco Chang','Gerente de marketing','Sierras de Granada 9993','México D.F.',NULL,'05022','México','(5) 555-3392','(5) 555-7293'),(14,'COMMI','Comércio Mineiro','Pedro Afonso','Asistente de ventas','Av. dos Lusíadas, 23','São Paulo','SP','05432-043','Brasil','(11) 555-7647',NULL),(15,'CONSH','Consolidated Holdings','Elizabeth Brown','Representante de ventas','Berkeley Gardens\r\n12  Brewery ','Londres',NULL,'WX1 6LT','Reino Unido','(71) 555-2282','(71) 555-9199'),(16,'CHOPS','Chop-suey Chinese','Yang Wang','Propietario','Hauptstr. 29','Berna',NULL,'3012','Suiza','0452-076545',NULL),(17,'DRACD','Drachenblut Delikatessen','Sven Ottlieb','Administrador de pedidos','Walserweg 21','Aachen',NULL,'52066','Alemania','0241-039123','0241-059428'),(18,'DUMON','Du monde entier','Janine Labrune','Propietario','67, rue des Cinquante Otages','Nantes',NULL,'44000','Francia','40.67.88.88','40.67.89.89'),(19,'EASTC','Eastern Connection','Ann Devon','Agente de ventas','35 King George','Londres',NULL,'WX3 6FW','Reino Unido','(71) 555-0297','(71) 555-3373'),(20,'ERNSH','Ernst Handel','Roland Mendel','Gerente de ventas','Kirchgasse 6','Graz',NULL,'8010','Austria','7675-3425','7675-3426'),(21,'FAMIA','Familia Arquibaldo','Aria Cruz','Asistente de marketing','Rua Orós, 92','Sao Paulo','SP','05442-030','Brasil','(11) 555-9857',NULL),(22,'FISSA','FISSA Fabrica Inter. Salchichas S.A.','Diego Roel','Gerente de contabilidad','C/ Moralzarzal, 86','Madrid',NULL,'28034','España','(91) 555 94 44','(91) 555 55 93'),(23,'FOLIG','Folies gourmandes','Martine Rancé','Asistente de agente de ventas','184, chaussée de Tournai','Lille',NULL,'59000','Francia','20.16.10.16','20.16.10.17'),(24,'FOLKO','Folk och fä HB','Maria Larsson','Propietario','Åkergatan 24','Bräcke',NULL,'S-844 67','Suecia','0695-34 67 21',NULL),(25,'FRANK','Frankenversand','Peter Franken','Gerente de marketing','Berliner Platz 43','München',NULL,'80805','Alemania','089-0877310','089-0877451'),(26,'FRANR','France restauration','Carine Schmitt','Gerente de marketing','54, rue Royale','Nantes',NULL,'44000','Francia','40.32.21.21','40.32.21.20'),(27,'FRANS','Franchi S.p.A.','Paolo Accorti','Representante de ventas','Via Monte Bianco 34','Torino',NULL,'10100','Italia','011-4988260','011-4988261'),(28,'FURIB','Furia Bacalhau e Frutos do Mar','Lino Rodriguez ','Gerente de ventas','Jardim das rosas n. 32','Lisboa',NULL,'1675','Portugal','(1) 354-2534','(1) 354-2535'),(29,'GALED','Galería del gastrónomo','Eduardo Saavedra','Gerente de marketing','Rambla de Cataluña, 23','Barcelona',NULL,'08022','España','(93) 203 4560','(93) 203 4561'),(30,'GODOS','Godos Cocina Típica','José Pedro Freyre','Gerente de ventas','C/ Romero, 33','Sevilla',NULL,'41101','España','(95) 555 82 82',NULL),(31,'GOURL','Gourmet Lanchonetes','André Fonseca','Asistente de ventas','Av. Brasil, 442','Campinas','SP','04876-786','Brasil','(11) 555-9482',NULL),(32,'GREAL','Great Lakes Food Market','Howard Snyder','Gerente de marketing','2732 Baker Blvd.','Eugenia','OR','97403','Estados Unidos','(503) 555-7555',NULL),(33,'GROSR','GROSELLA-Restaurante','Manuel Pereira','Propietario','5ª Ave. Los Palos Grandes','Caracas','DF','1081','Venezuela','(2) 283-2951','(2) 283-3397'),(34,'HANAR','Hanari Carnes','Mario Pontes','Gerente de contabilidad','Rua do Paço, 67','Rio de Janeiro','RJ','05454-876','Brasil','(21) 555-0091','(21) 555-8765'),(35,'HILAA','HILARIÓN-Abastos','Carlos Hernández','Representante de ventas','Carrera 22 con Ave. Carlos Soublette #8-35','San Cristóbal','Táchira','5022','Venezuela','(5) 555-1340','(5) 555-1948'),(36,'HUNGC','Hungry Coyote Import Store','Yoshi Latimer','Representante de ventas','City Center Plaza\r\n516 Main St.','Elgin','OR','97827','Estados Unidos','(503) 555-6874','(503) 555-2376'),(37,'HUNGO','Hungry Owl All-Night Grocers','Patricia McKenna','Asistente de ventas','8 Johnstown Road','Cork','Co. Cork',NULL,'Irlanda','2967 542','2967 3333'),(38,'ISLAT','Island Trading','Helen Bennett','Gerente de marketing','Garden House\r\nCrowther Way','Cowes','Isla de Wight','PO31 7PJ','Reino Unido','(198) 555-8888',NULL),(39,'KOENE','Königlich Essen','Philip Cramer','Asistente de ventas','Maubelstr. 90','Brandenburgo',NULL,'14776','Alemania','0555-09876',NULL),(40,'LACOR','La corne d\'abondance','Daniel Tonini','Representante de ventas','67, avenue de l\'Europe','Versalles',NULL,'78000','Francia','30.59.84.10','30.59.85.11'),(41,'LAMAI','La maison d\'Asie','Annette Roulet','Gerente de ventas','1 rue Alsace-Lorraine','Toulouse',NULL,'31000','Francia','61.77.61.10','61.77.61.11'),(42,'LAUGB','Laughing Bacchus Wine Cellars','Yoshi Tannamuri','Asistente de marketing','1900 Oak St.','Vancouver','BC','V3F 2K1','Canadá','(604) 555-3392','(604) 555-7293'),(43,'LAZYK','Lazy K Kountry Store','John Steel','Gerente de marketing','12 Orchestra Terrace','Walla Walla','WA','99362','Estados Unidos','(509) 555-7969','(509) 555-6221'),(44,'LEHMS','Lehmanns Marktstand','Renate Messner','Representante de ventas','Magazinweg 7','Francfurt',NULL,'60528','Alemania','069-0245984','069-0245874'),(45,'LETSS','Let\'s Stop N Shop','Jaime Yorres','Propietario','87 Polk St.\r\nSuite 5','San Francisco','CA','94117','Estados Unidos','(415) 555-5938',NULL),(46,'LILAS','LILA-Supermercado','Carlos González','Gerente de contabilidad','Carrera 52 con Ave. Bolívar #65-98 Llano Largo','Barquisimeto','Lara','3508','Venezuela','(9) 331-6954','(9) 331-7256'),(47,'LINOD','LINO-Delicateses','Felipe Izquierdo','Propietario','Ave. 5 de Mayo Porlamar','I. de Margarita','Nueva Esparta','4980','Venezuela','(8) 34-56-12','(8) 34-93-93'),(48,'LONEP','Lonesome Pine Restaurant','Fran Wilson','Gerente de ventas','89 Chiaroscuro Rd.','Portland','OR','97219','Estados Unidos','(503) 555-9573','(503) 555-9646'),(49,'MAGAA','Magazzini Alimentari Riuniti','Giovanni Rovelli','Gerente de marketing','Via Ludovico il Moro 22','Bérgamo',NULL,'24100','Italia','035-640230','035-640231'),(50,'MAISD','Maison Dewey','Catherine Dewey','Agente de ventas','Rue Joseph-Bens 532','Bruselas',NULL,'B-1180','Bélgica','(02) 201 24 67','(02) 201 24 68'),(51,'MEREP','Mère Paillarde','Jean Fresnière','Asistente de marketing','43 rue St. Laurent','Montreal','Québec','H1J 1C3','Canadá','(514) 555-8054','(514) 555-8055'),(52,'MORGK','Morgenstern Gesundkost','Alexander Feuer','Asistente de marketing','Heerstr. 22','Leipzig',NULL,'04179','Alemania','0342-023176',NULL),(53,'NORTS','North/South','Simon Crowther','Asistente de ventas','South House\r\n300 Queensbridge','Londres',NULL,'SW7 1RZ','Reino Unido','(71) 555-7733','(71) 555-2530'),(54,'OCEAN','Océano Atlántico Ltda.','Yvonne Moncada','Agente de ventas','Ing. Gustavo Moncada 8585\r\nPiso 20-A','Buenos Aires',NULL,'1010','Argentina','(1) 135-5333','(1) 135-5535'),(55,'OLDWO','Old World Delicatessen','Rene Phillips','Representante de ventas','2743 Bering St.','Anchorage','AK','99508','Estados Unidos','(907) 555-7584','(907) 555-2880'),(56,'OTTIK','Ottilies Käseladen','Henriette Pfalzheim','Propietario','Mehrheimerstr. 369','Köln',NULL,'50739','Alemania','0221-0644327','0221-0765721'),(57,'PARIS','Paris spécialités','Marie Bertrand','Propietario','265, boulevard Charonne','París',NULL,'75012','Francia','(1) 42.34.22.66','(1) 42.34.22.77'),(58,'PERIC','Pericles Comidas clásicas','Guillermo Fernández','Representante de ventas','Calle Dr. Jorge Cash 321','México D.F.',NULL,'05033','México','(5) 552-3745','(5) 545-3745'),(59,'PICCO','Piccolo und mehr','Georg Pipps','Gerente de ventas','Geislweg 14','Salzburgo',NULL,'5020','Austria','6562-9722','6562-9723'),(60,'PRINI','Princesa Isabel Vinhos','Isabel de Castro','Representante de ventas','Estrada da saúde n. 58','Lisboa',NULL,'1756','Portugal','(1) 356-5634',NULL),(61,'QUEDE','Que Delícia','Bernardo Batista','Gerente de contabilidad','Rua da Panificadora, 12','Rio de Janeiro','RJ','02389-673','Brasil','(21) 555-4252','(21) 555-4545'),(62,'QUEEN','Queen Cozinha','Lúcia Carvalho','Asistente de marketing','Alameda dos Canàrios, 891','Sao Paulo','SP','05487-020','Brasil','(11) 555-1189',NULL),(63,'QUICK','QUICK-Stop','Horst Kloss','Gerente de contabilidad','Taucherstraße 10','Cunewalde',NULL,'01307','Alemania','0372-035188',NULL),(64,'RANCH','Rancho grande','Sergio Gutiérrez','Representante de ventas','Av. del Libertador 900','Buenos Aires',NULL,'1010','Argentina','(1) 123-5555','(1) 123-5556'),(65,'RATTC','Rattlesnake Canyon Grocery','Paula Wilson','Representante agente ventas','2817 Milton Dr.','Albuquerque','NM','87110','Estados Unidos','(505) 555-5939','(505) 555-3620'),(66,'REGGC','Reggiani Caseifici','Maurizio Moroni','Asistente de ventas','Strada Provinciale 124','Reggio Emilia',NULL,'42100','Italia','0522-556721','0522-556722'),(67,'RICAR','Ricardo Adocicados','Janete Limeira','Asistente de agente de ventas','Av. Copacabana, 267','Rio de Janeiro','RJ','02389-890','Brasil','(21) 555-3412',NULL),(68,'RICSU','Richter Supermarkt','Michael Holz','Gerente de ventas','Grenzacherweg 237','Génova',NULL,'1203','Suiza','0897-034214',NULL),(69,'ROMEY','Romero y tomillo','Alejandra Camino','Gerente de contabilidad','Gran Vía, 1','Madrid',NULL,'28001','España','(91) 745 6200','(91) 745 6210'),(70,'SANTG','Santé Gourmet','Jonas Bergulfsen','Propietario','Erling Skakkes gate 78','Stavern',NULL,'4110','Noruega','07-98 92 35','07-98 92 47'),(71,'SAVEA','Save-a-lot Markets','Jose Pavarotti','Representante de ventas','187 Suffolk Ln.','Boise','ID','83720','Estados Unidos','(208) 555-8097',NULL),(72,'SEVES','Seven Seas Imports','Hari Kumar','Gerente de ventas','90 Wadhurst Rd.','Londres',NULL,'OX15 4NB','Reino Unido','(71) 555-1717','(71) 555-5646'),(73,'SIMOB','Simons bistro','Jytte Petersen','Propietario','Vinbæltet 34','København',NULL,'1734','Dinamarca','31 12 34 56','31 13 35 57'),(74,'SPECD','Spécialités du monde','Dominique Perrier','Gerente de marketing','25, rue Lauriston','París',NULL,'75016','Francia','(1) 47.55.60.10','(1) 47.55.60.20'),(75,'SPLIR','Split Rail Beer & Ale','Art Braunschweiger','Gerente de ventas','P.O. Box 555','Lander','WY','82520','Estados Unidos','(307) 555-4680','(307) 555-6525'),(76,'SUPRD','Suprêmes délices','Pascale Cartrain','Gerente de contabilidad','Boulevard Tirou, 255','Charleroi',NULL,'B-6000','Bélgica','(071) 23 67 22 20','(071) 23 67 22 21'),(77,'THEBI','The Big Cheese','Liz Nixon','Gerente de marketing','89 Jefferson Way\r\nSuite 2','Portland','OR','97201','Estados Unidos','(503) 555-3612',NULL),(78,'THECR','The Cracker Box','Liu Wong','Asistente de marketing','55 Grizzly Peak Rd.','Butte','MT','59801','Estados Unidos','(406) 555-5834','(406) 555-8083'),(79,'TOMSP','Toms Spezialitäten','Karin Josephs','Gerente de marketing','Luisenstr. 48','Münster',NULL,'44087','Alemania','0251-031259','0251-035695'),(80,'TORTU','Tortuga Restaurante','Miguel Angel Paolino','Propietario','Avda. Azteca 123','México D.F.',NULL,'05033','México','(5) 555-2933',NULL),(81,'TRADH','Tradição Hipermercados','Anabela Domingues','Representante de ventas','Av. Inês de Castro, 414','Sao Paulo','SP','05634-030','Brasil','(11) 555-2167','(11) 555-2168'),(82,'TRAIH','Trail\'s Head Gourmet Provisioners','Helvetius Nagy','Asistente de ventas','722 DaVinci Blvd.','Kirkland','WA','98034','Estados Unidos','(206) 555-8257','(206) 555-2174'),(83,'VAFFE','Vaffeljernet','Palle Ibsen','Gerente de ventas','Smagsløget 45','Århus',NULL,'8200','Dinamarca','86 21 32 43','86 22 33 44'),(84,'VICTE','Victuailles en stock','Mary Saveley','Agente de ventas','2, rue du Commerce','Lion',NULL,'69004','Francia','78.32.54.86','78.32.54.87'),(85,'VINET','Vins et alcools Chevalier','Paul Henriot','Gerente de contabilidad','59 rue de l\'Abbaye','Reims',NULL,'51100','Francia','26.47.15.10','26.47.15.11'),(86,'WANDK','Die Wandernde Kuh','Rita Müller','Representante de ventas','Adenauerallee 900','Stuttgart',NULL,'70563','Alemania','0711-020361','0711-035428'),(87,'WARTH','Wartian Herkku','Pirkko Koskitalo','Gerente de contabilidad','Torikatu 38','Oulu',NULL,'90110','Finlandia','981-443655','981-443655'),(88,'WELLI','Wellington Importadora','Paula Parente','Gerente de ventas','Rua do Mercado, 12','Resende','SP','08737-363','Brasil','(14) 555-8122',NULL),(89,'WHITC','White Clover Markets','Karl Jablonski','Propietario','305 - 14th Ave. S.\r\nSuite 3B','Seattle','WA','98128','Estados Unidos','(206) 555-4112','(206) 555-4115'),(91,'WOLZA','Wolski  Zajazd','Zbyszek Piestrzeniewicz','Propietario','ul. Filtrowa 68','Warszawa',NULL,'01-012','Polonia','(26) 642-7012','(26) 642-7012');
/*!40000 ALTER TABLE `clientes` ENABLE KEYS */;
UNLOCK TABLES;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
/*!50003 CREATE*/ /*!50017 DEFINER=`root`@`localhost`*/ /*!50003 TRIGGER `clientes_del` BEFORE DELETE ON `clientes` FOR EACH ROW begin
 
 -- Elimino los pedidos de ese cliente
 -- Pero antes necesito eliminar los detalles de cada uno de esos pedidos por tener foreign key
	DELETE FROM detalles 
    WHERE detalles.pedido_id IN (SELECT id 
								from pedidos 
								WHERE pedidos.cliente_id = old.id);
 
 	DELETE 
    FROM pedidos 
	WHERE pedidos.cliente_id = old.id;
 
 
 -- Elimino los registros historicos de ese cliente
--   DELETE FROM clientes_historico 
--   WHERE codigo = old.codigo;
 end */;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;

--
-- Table structure for table `detalles`
--

DROP TABLE IF EXISTS `detalles`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `detalles` (
  `pedido_id` int(11) NOT NULL,
  `producto_id` int(11) NOT NULL,
  `precio_unidad` decimal(19,4) DEFAULT NULL,
  `cantidad` smallint(6) DEFAULT NULL,
  `descuento` double(7,2) DEFAULT NULL,
  PRIMARY KEY (`pedido_id`,`producto_id`),
  KEY `fk_producto` (`producto_id`),
  CONSTRAINT `fk_pedido` FOREIGN KEY (`pedido_id`) REFERENCES `pedidos` (`id`) ON DELETE CASCADE,
  CONSTRAINT `fk_producto` FOREIGN KEY (`producto_id`) REFERENCES `productos` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `detalles`
--

LOCK TABLES `detalles` WRITE;
/*!40000 ALTER TABLE `detalles` DISABLE KEYS */;
INSERT INTO `detalles` VALUES (10249,14,18.6000,9,0.00),(10249,51,42.4000,40,0.00),(10250,41,7.7000,10,0.00),(10250,51,42.4000,35,0.15),(10250,65,16.8000,15,0.15),(10251,22,16.8000,6,0.05),(10251,57,15.6000,15,0.05),(10251,65,16.8000,20,0.00),(10252,20,64.8000,40,0.05),(10252,33,2.0000,25,0.05),(10252,60,27.2000,40,0.00),(10253,31,10.0000,20,0.00),(10253,39,14.4000,42,0.00),(10253,49,16.0000,40,0.00),(10254,24,3.6000,15,0.15),(10254,55,19.2000,21,0.15),(10254,74,8.0000,21,0.00),(10255,2,15.2000,20,0.00),(10255,16,13.9000,35,0.00),(10255,36,15.2000,25,0.00),(10255,59,44.0000,30,0.00),(10256,53,26.2000,15,0.00),(10256,77,10.4000,12,0.00),(10257,27,35.1000,25,0.00),(10257,39,14.4000,6,0.00),(10257,77,10.4000,15,0.00),(10258,2,15.2000,50,0.20),(10258,5,17.0000,65,0.20),(10258,32,25.6000,6,0.20),(10259,21,8.0000,10,0.00),(10259,37,20.8000,1,0.00),(10260,41,7.7000,16,0.25),(10260,57,15.6000,50,0.00),(10260,62,39.4000,15,0.25),(10260,70,12.0000,21,0.25),(10261,21,8.0000,20,0.00),(10261,35,14.4000,20,0.00),(10262,5,17.0000,12,0.20),(10262,7,24.0000,15,0.00),(10262,56,30.4000,2,0.00),(10263,16,13.9000,60,0.25),(10263,24,3.6000,28,0.00),(10263,30,20.7000,60,0.25),(10263,74,8.0000,36,0.25),(10264,2,15.2000,35,0.00),(10264,41,7.7000,25,0.15),(10265,17,31.2000,30,0.00),(10265,70,12.0000,20,0.00),(10266,12,30.4000,12,0.05),(10267,40,14.7000,50,0.00),(10267,59,44.0000,70,0.15),(10267,76,14.4000,15,0.15),(10268,29,99.0000,10,0.00),(10268,72,27.8000,4,0.00),(10269,33,2.0000,60,0.05),(10269,72,27.8000,20,0.05),(10270,36,15.2000,30,0.00),(10270,43,36.8000,25,0.00),(10271,33,2.0000,24,0.00),(10272,20,64.8000,6,0.00),(10272,31,10.0000,40,0.00),(10272,72,27.8000,24,0.00),(10273,10,24.8000,24,0.05),(10273,31,10.0000,15,0.05),(10273,33,2.0000,20,0.00),(10273,40,14.7000,60,0.05),(10273,76,14.4000,33,0.05),(10274,71,17.2000,20,0.00),(10274,72,27.8000,7,0.00),(10275,24,3.6000,12,0.05),(10275,59,44.0000,6,0.05),(10276,10,24.8000,15,0.00),(10276,13,4.8000,10,0.00),(10277,28,36.4000,20,0.00),(10277,62,39.4000,12,0.00),(10278,44,15.5000,16,0.00),(10278,59,44.0000,15,0.00),(10278,63,35.1000,8,0.00),(10278,73,12.0000,25,0.00),(10279,17,31.2000,15,0.25),(10280,24,3.6000,12,0.00),(10280,55,19.2000,20,0.00),(10280,75,6.2000,30,0.00),(10281,19,7.3000,1,0.00),(10281,24,3.6000,6,0.00),(10281,35,14.4000,4,0.00),(10282,30,20.7000,6,0.00),(10282,57,15.6000,2,0.00),(10283,15,12.4000,20,0.00),(10283,19,7.3000,18,0.00),(10283,60,27.2000,35,0.00),(10283,72,27.8000,3,0.00),(10284,27,35.1000,15,0.25),(10284,44,15.5000,21,0.00),(10284,60,27.2000,20,0.25),(10284,67,11.2000,5,0.25),(10285,1,14.4000,45,0.20),(10285,40,14.7000,40,0.20),(10285,53,26.2000,36,0.20),(10286,35,14.4000,100,0.00),(10286,62,39.4000,40,0.00),(10287,16,13.9000,40,0.15),(10287,34,11.2000,20,0.00),(10287,46,9.6000,15,0.15),(10288,54,5.9000,10,0.10),(10288,68,10.0000,3,0.10),(10289,3,8.0000,30,0.00),(10289,64,26.6000,9,0.00),(10290,5,17.0000,20,0.00),(10290,29,99.0000,15,0.00),(10290,49,16.0000,15,0.00),(10290,77,10.4000,10,0.00),(10291,13,4.8000,20,0.10),(10291,44,15.5000,24,0.10),(10291,51,42.4000,2,0.10),(10292,20,64.8000,20,0.00),(10293,18,50.0000,12,0.00),(10293,24,3.6000,10,0.00),(10293,63,35.1000,5,0.00),(10293,75,6.2000,6,0.00),(10294,1,14.4000,18,0.00),(10294,17,31.2000,15,0.00),(10294,43,36.8000,15,0.00),(10294,60,27.2000,21,0.00),(10294,75,6.2000,6,0.00),(10295,56,30.4000,4,0.00),(10296,11,16.8000,12,0.00),(10296,16,13.9000,30,0.00),(10296,69,28.8000,15,0.00),(10297,39,14.4000,60,0.00),(10297,72,27.8000,20,0.00),(10298,2,15.2000,40,0.00),(10298,36,15.2000,40,0.25),(10298,59,44.0000,30,0.25),(10298,62,39.4000,15,0.00),(10299,19,7.3000,15,0.00),(10299,70,12.0000,20,0.00);
/*!40000 ALTER TABLE `detalles` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `empleados`
--

DROP TABLE IF EXISTS `empleados`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `empleados` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `apellidos` varchar(20) NOT NULL,
  `nombre` varchar(10) NOT NULL,
  `cargo` varchar(30) DEFAULT NULL,
  `tratamiento` varchar(25) DEFAULT NULL,
  `fecha_nacimiento` date DEFAULT NULL,
  `fecha_contratacion` date DEFAULT NULL,
  `direccion` varchar(60) DEFAULT NULL,
  `ciudad` varchar(15) DEFAULT NULL,
  `region` varchar(15) DEFAULT NULL,
  `cp` varchar(10) DEFAULT NULL,
  `pais` varchar(15) DEFAULT NULL,
  `telefono_domicilio` varchar(24) DEFAULT NULL,
  `extension` varchar(4) DEFAULT NULL,
  `notas` text,
  `jefe_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_jefe` (`jefe_id`),
  CONSTRAINT `fk_jefe` FOREIGN KEY (`jefe_id`) REFERENCES `empleados` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `empleados`
--

LOCK TABLES `empleados` WRITE;
/*!40000 ALTER TABLE `empleados` DISABLE KEYS */;
INSERT INTO `empleados` VALUES (1,'Davolio','Nancy','Representante de ventas','Srta.','1968-12-08','1992-05-01','507 - 20th Ave. E.\r\nApt. 2A','Seattle','WA','98122','EE.UU.','(206) 555-9857','5467','Su formación incluye una licenciatura en Psicología por la Universidad del Estado de Colorado. También escribió \"El arte de la llamada en frío\". Nancy es miembro de Toastmasters International.',2),(2,'Fuller','Andrew','Vicepresidente comercial','Dr.','1952-02-19','1992-08-14','908 W. Capital Way','Tacoma','WA','98401','EE.UU.','(206) 555-9482','3457','Andrew completó su licenciatura en Comercio y un doctorado en Marketing Internacional de la Universidad de Dallas. Habla con fluidez en francés e italiano y lee el alemán. Ingresó en la empresa como representante de ventas, fue ascendido a gerente de cuentas y después fue nombrado vicepresidente comercial.\r\nAndrew es miembro de la Mesa redonda de administración de Ventas, la Cámara de comercio de Seattle y de la Asociación de importadores de la Cuenca del Pacífico.',NULL),(3,'Leverling','Janet','Representante de ventas','Srta.','1963-08-30','1992-04-01','722 Moss Bay Blvd.','Kirkland','WA','98033','EE.UU.','(206) 555-3412','3355','Janet es licenciada en Química por la Universidad de Boston. También ha completado un programa de formación en Gestión de minoristas de alimentación. Janet fue contratada como vendedora asociada y fue ascendida a representante de ventas.',2),(4,'Peacock','Margaret','Representante de ventas','Sra.','1958-09-19','1993-05-03','4110 Old Redmond Rd.','Redmond','WA','98052','EE.UU.','(206) 555-8122','5176','Margaret es licenciada en Literatura inglesa por el Colegio Universitario Concordia, y tiene un máster del Instituto Americano de Artes Culinarias. Estuvo asignada temporalmente a la oficina de Londres antes de regresar a su puesto permanente en Seattle.',2),(5,'Buchanan','Steven','Gerente de ventas','Sr.','1955-03-04','1993-10-17','14 Garrett Hill','Londres',NULL,'SW1 8JR','Reino Unido','(71) 555-4848','3453','Steven Buchanan se graduó en la Universidad de St. Andrews, Escocia. Tras su ingreso en la empresa dedicó 6 meses a un programa de orientación en la oficina de Seattle y luego volvió a su puesto permanente en Londres, donde fue ascendido a gerente de ventas. Completó con éxito los cursos de Telemarketing y Gestión de ventas internacional. Habla francés.',2),(6,'Suyama','Michael','Representante de ventas','Sr.','1963-07-02','1993-10-17','Coventry House\r\nMiner Rd.','Londres',NULL,'EC2 7JR','Reino Unido','(71) 555-7773','428','Michael se graduó en la Universidad de Sussex (MA, economía) y la Universidad de California en Los Angeles (MBA, marketing). También ha asistido a cursos de Ventas multiculturales y Administración del tiempo para profesionales de ventas. Habla\r\njaponés y lee y escribe en francés, portugués y español.',5),(7,'King','Robert','Representante de ventas','Sr.','1960-05-29','1994-01-02','Edgeham Hollow\r\nWinchester Way','Londres',NULL,'RG1 9SP','Reino Unido','(71) 555-5598','465','Robert King colaboró en la organización Peace Corps y viajó extensamente antes de completar su licenciatura en inglés en la Universidad de Michigan, el año en que ingresó en la empresa. Después de completar un curso denominado \"Ventas en Europa\", fue\r\ntransferido a la oficina de Londres.',5),(8,'Callahan','Laura','Coordinador ventas interno','Srta.','1958-01-09','1994-03-05','4726 - 11th Ave. N.E.','Seattle','WA','98105','EE.UU.','(206) 555-1189','2344','Laura se graduó en Psicología por la Universidad de Washington. También completó un curso de francés de negocios. Lee y escribe en francés.',2),(9,'Dodsworth','Anne','Representante de ventas','Srta.','1969-07-02','1994-11-15','7 Houndstooth Rd.','Londres',NULL,'WG2 7LT','Reino Unido','(71) 555-4444','452','Anne tiene una licenciatura en inglés por el  St. Lawrence College.  Habla con fluidez el francés y el alemán.',5);
/*!40000 ALTER TABLE `empleados` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `envios`
--

DROP TABLE IF EXISTS `envios`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `envios` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `empresa` varchar(40) NOT NULL,
  `telefono` varchar(24) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `uq_envio` (`empresa`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `envios`
--

LOCK TABLES `envios` WRITE;
/*!40000 ALTER TABLE `envios` DISABLE KEYS */;
INSERT INTO `envios` VALUES (1,'Speedy Express','(503) 555-9831'),(2,'United Package','(503) 555-3199'),(3,'Federal Shipping','(503) 555-9931');
/*!40000 ALTER TABLE `envios` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Temporary view structure for view `importes`
--

DROP TABLE IF EXISTS `importes`;
/*!50001 DROP VIEW IF EXISTS `importes`*/;
SET @saved_cs_client     = @@character_set_client;
SET character_set_client = utf8mb4;
/*!50001 CREATE VIEW `importes` AS SELECT 
 1 AS `pedido_id`,
 1 AS `producto_id`,
 1 AS `precio_unidad`,
 1 AS `cantidad`,
 1 AS `descuento`,
 1 AS `importe`*/;
SET character_set_client = @saved_cs_client;

--
-- Table structure for table `pedidos`
--

DROP TABLE IF EXISTS `pedidos`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `pedidos` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `cliente_id` int(11) NOT NULL,
  `empleado_id` int(11) DEFAULT NULL,
  `fecha_pedido` date DEFAULT NULL,
  `fecha_entrega` date DEFAULT NULL,
  `fecha_envio` date DEFAULT NULL,
  `envio_id` int(11) DEFAULT NULL,
  `cargo` decimal(19,4) DEFAULT NULL,
  `destinatario` varchar(40) DEFAULT NULL,
  `direccion_destinatario` varchar(60) DEFAULT NULL,
  `ciudad_destinatario` varchar(15) DEFAULT NULL,
  `region_destinatario` varchar(15) DEFAULT NULL,
  `cp_destinatario` varchar(10) DEFAULT NULL,
  `pais_destinatario` varchar(15) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_cliente` (`cliente_id`),
  KEY `fk_envio` (`envio_id`),
  KEY `fk_empleado` (`empleado_id`),
  CONSTRAINT `fk_cliente` FOREIGN KEY (`cliente_id`) REFERENCES `clientes` (`id`),
  CONSTRAINT `fk_empleado` FOREIGN KEY (`empleado_id`) REFERENCES `empleados` (`id`),
  CONSTRAINT `fk_envio` FOREIGN KEY (`envio_id`) REFERENCES `envios` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=11078 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `pedidos`
--

LOCK TABLES `pedidos` WRITE;
/*!40000 ALTER TABLE `pedidos` DISABLE KEYS */;
INSERT INTO `pedidos` VALUES (10249,79,6,'1996-07-05','1996-08-16','1996-07-10',1,11.6100,'Toms Spezialitäten','Luisenstr. 48','Münster',NULL,'44087','Alemania'),(10250,34,4,'1996-07-08','1996-08-05','1996-07-12',2,65.8300,'Hanari Carnes','Rua do Paço, 67','Río de Janeiro','RJ','05454-876','Brasil'),(10251,84,3,'1996-07-08','1996-08-05','1996-07-15',1,41.3400,'Victuailles en stock','2, rue du Commerce','Lyon',NULL,'69004','Francia'),(10252,76,4,'1996-07-09','1996-08-06','1996-07-11',2,51.3000,'Suprêmes délices','Boulevard Tirou, 255','Charleroi',NULL,'B-6000','Bélgica'),(10253,34,3,'1996-07-10','1996-07-24','1996-07-16',2,58.1700,'Hanari Carnes','Rua do Paço, 67','Río de Janeiro','RJ','05454-876','Brasil'),(10254,16,5,'1996-07-11','1996-08-08','1996-07-23',2,22.9800,'Chop-suey Chinese','Hauptstr. 31','Bern',NULL,'3012','Suiza'),(10255,68,9,'1996-07-12','1996-08-09','1996-07-15',3,148.3300,'Richter Supermarkt','Starenweg 5','Genève',NULL,'1204','Suiza'),(10256,88,3,'1996-07-15','1996-08-12','1996-07-17',2,13.9700,'Wellington Importadora','Rua do Mercado, 12','Resende','SP','08737-363','Brasil'),(10257,35,4,'1996-07-16','1996-08-13','1996-07-22',3,81.9100,'HILARIÓN-Abastos','Carrera 22 con Ave. Carlos Soublette #8-35','San Cristóbal','Táchira','5022','Venezuela'),(10258,20,1,'1996-07-17','1996-08-14','1996-07-23',1,140.5100,'Ernst Handel','Kirchgasse 6','Graz',NULL,'8010','Austria'),(10259,13,4,'1996-07-18','1996-08-15','1996-07-25',3,3.2500,'Centro comercial Moctezuma','Sierras de Granada 9993','México D.F.',NULL,'05022','México'),(10260,56,4,'1996-07-19','1996-08-16','1996-07-29',1,55.0900,'Ottilies Käseladen','Mehrheimerstr. 369','Köln',NULL,'50739','Alemania'),(10261,61,4,'1996-07-19','1996-08-16','1996-07-30',2,3.0500,'Que Delícia','Rua da Panificadora, 12','Río de Janeiro','RJ','02389-673','Brasil'),(10262,65,8,'1996-07-22','1996-08-19','1996-07-25',3,48.2900,'Rattlesnake Canyon Grocery','2817 Milton Dr.','Albuquerque','NM','87110','Estados Unidos'),(10263,20,9,'1996-07-23','1996-08-20','1996-07-31',3,146.0600,'Ernst Handel','Kirchgasse 6','Graz',NULL,'8010','Austria'),(10264,24,6,'1996-07-24','1996-08-21','1996-08-23',3,3.6700,'Folk och fä HB','Åkergatan 24','Bräcke',NULL,'S-844 67','Suecia'),(10265,7,2,'1996-07-25','1996-08-22','1996-08-12',1,55.2800,'Blondel père et fils','24, place Kléber','Strasbourg',NULL,'67000','Francia'),(10266,87,3,'1996-07-26','1996-09-06','1996-07-31',3,25.7300,'Wartian Herkku','Torikatu 38','Oulu',NULL,'90110','Finlandia'),(10267,25,4,'1996-07-29','1996-08-26','1996-08-06',1,208.5800,'Frankenversand','Berliner Platz 43','München',NULL,'80805','Alemania'),(10268,33,8,'1996-07-30','1996-08-27','1996-08-02',3,66.2900,'GROSELLA-Restaurante','5ª Ave. Los Palos Grandes','Caracas','DF','1081','Venezuela'),(10269,89,5,'1996-07-31','1996-08-14','1996-08-09',1,4.5600,'White Clover Markets','1029 - 12th Ave. S.','Seattle','WA','98124','Estados Unidos'),(10270,87,1,'1996-08-01','1996-08-29','1996-08-02',1,136.5400,'Wartian Herkku','Torikatu 38','Oulu',NULL,'90110','Finlandia'),(10271,75,6,'1996-08-01','1996-08-29','1996-08-30',2,4.5400,'Split Rail Beer & Ale','P.O. Box 555','Lander','WY','82520','Estados Unidos'),(10272,65,6,'1996-08-02','1996-08-30','1996-08-06',2,98.0300,'Rattlesnake Canyon Grocery','2817 Milton Dr.','Albuquerque','NM','87110','Estados Unidos'),(10273,63,3,'1996-08-05','1996-09-02','1996-08-12',3,76.0700,'QUICK-Stop','Taucherstraße 10','Cunewalde',NULL,'01307','Alemania'),(10274,85,6,'1996-08-06','1996-09-03','1996-08-16',1,6.0100,'Vins et alcools Chevalier','59 rue de l\'Abbaye','Reims',NULL,'51100','Francia'),(10275,49,1,'1996-08-07','1996-09-04','1996-08-09',1,26.9300,'Magazzini Alimentari Riuniti','Via Ludovico il Moro 22','Bérgamo',NULL,'24100','Italia'),(10276,80,8,'1996-08-08','1996-08-22','1996-08-14',3,13.8400,'Tortuga Restaurante','Avda. Azteca 123','México D.F.',NULL,'05033','México'),(10277,52,2,'1996-08-09','1996-09-06','1996-08-13',3,125.7700,'Morgenstern Gesundkost','Heerstr. 22','Leipzig',NULL,'04179','Alemania'),(10278,5,8,'1996-08-12','1996-09-09','1996-08-16',2,92.6900,'Berglunds snabbköp','Berguvsvägen  8','Luleå',NULL,'S-958 22','Suecia'),(10279,44,8,'1996-08-13','1996-09-10','1996-08-16',2,25.8300,'Lehmanns Marktstand','Magazinweg 7','Frankfurt a.M. ',NULL,'60528','Alemania'),(10280,5,2,'1996-08-14','1996-09-11','1996-09-12',1,8.9800,'Berglunds snabbköp','Berguvsvägen  8','Luleå',NULL,'S-958 22','Suecia'),(10281,69,4,'1996-08-14','1996-08-28','1996-08-21',1,2.9400,'Romero y tomillo','Gran Vía, 1','Madrid',NULL,'28001','España'),(10282,69,4,'1996-08-15','1996-09-12','1996-08-21',1,12.6900,'Romero y tomillo','Gran Vía, 1','Madrid',NULL,'28001','España'),(10283,46,3,'1996-08-16','1996-09-13','1996-08-23',3,84.8100,'LILA-Supermercado','Carrera 52 con Ave. Bolívar #65-98 Llano Largo','Barquisimeto','Lara','3508','Venezuela'),(10284,44,4,'1996-08-19','1996-09-16','1996-08-27',1,76.5600,'Lehmanns Marktstand','Magazinweg 7','Frankfurt a.M. ',NULL,'60528','Alemania'),(10285,63,1,'1996-08-20','1996-09-17','1996-08-26',2,76.8300,'QUICK-Stop','Taucherstraße 10','Cunewalde',NULL,'01307','Alemania'),(10286,63,8,'1996-08-21','1996-09-18','1996-08-30',3,229.2400,'QUICK-Stop','Taucherstraße 10','Cunewalde',NULL,'01307','Alemania'),(10287,67,8,'1996-08-22','1996-09-19','1996-08-28',3,12.7600,'Ricardo Adocicados','Av. Copacabana, 267','Río de Janeiro','RJ','02389-890','Brasil'),(10288,66,4,'1996-08-23','1996-09-20','1996-09-03',1,7.4500,'Reggiani Caseifici','Strada Provinciale 124','Reggio Emilia',NULL,'42100','Italia'),(10289,11,7,'1996-08-26','1996-09-23','1996-08-28',3,22.7700,'B\'s Beverages','Fauntleroy Circus','London',NULL,'EC2 5NT','Reino Unido'),(10290,14,8,'1996-08-27','1996-09-24','1996-09-03',1,79.7000,'Comércio Mineiro','Av. dos Lusíadas, 23','São Paulo','SP','05432-043','Brasil'),(10291,61,6,'1996-08-27','1996-09-24','1996-09-04',2,6.4000,'Que Delícia','Rua da Panificadora, 12','Río de Janeiro','RJ','02389-673','Brasil'),(10292,81,1,'1996-08-28','1996-09-25','1996-09-02',2,1.3500,'Tradição Hipermercados','Av. Inês de Castro, 414','São Paulo','SP','05634-030','Brasil'),(10293,80,1,'1996-08-29','1996-09-26','1996-09-11',3,21.1800,'Tortuga Restaurante','Avda. Azteca 123','México D.F.',NULL,'05033','México'),(10294,65,4,'1996-08-30','1996-09-27','1996-09-05',2,147.2600,'Rattlesnake Canyon Grocery','2817 Milton Dr.','Albuquerque','NM','87110','Estados Unidos'),(10295,85,2,'1996-09-02','1996-09-30','1996-09-10',2,1.1500,'Vins et alcools Chevalier','59 rue de l\'Abbaye','Reims',NULL,'51100','Francia'),(10296,46,6,'1996-09-03','1996-10-01','1996-09-11',1,0.1200,'LILA-Supermercado','Carrera 52 con Ave. Bolívar #65-98 Llano Largo','Barquisimeto','Lara','3508','Venezuela'),(10297,7,5,'1996-09-04','1996-10-16','1996-09-10',2,5.7400,'Blondel père et fils','24, place Kléber','Strasbourg',NULL,'67000','Francia'),(10298,37,6,'1996-09-05','1996-10-03','1996-09-11',2,168.2200,'Hungry Owl All-Night Grocers','8 Johnstown Road','Cork','Co. Cork',NULL,'Irlanda'),(10299,67,4,'1996-09-06','1996-10-04','1996-09-13',2,29.7600,'Ricardo Adocicados','Av. Copacabana, 267','Río de Janeiro','RJ','02389-890','Brasil'),(10300,49,2,'1996-09-09','1996-10-07','1996-09-18',2,17.6800,'Magazzini Alimentari Riuniti','Via Ludovico il Moro 22','Bérgamo',NULL,'24100','Italia'),(10301,86,8,'1996-09-09','1996-10-07','1996-09-17',2,45.0800,'Die Wandernde Kuh','Adenauerallee 900','Stuttgart',NULL,'70563','Alemania'),(10302,76,4,'1996-09-10','1996-10-08','1996-10-09',2,6.2700,'Suprêmes délices','Boulevard Tirou, 255','Charleroi',NULL,'B-6000','Bélgica'),(10303,30,7,'1996-09-11','1996-10-09','1996-09-18',2,107.8300,'Godos Cocina Típica','C/ Romero, 33','Sevilla',NULL,'41101','España'),(10304,80,1,'1996-09-12','1996-10-10','1996-09-17',2,63.7900,'Tortuga Restaurante','Avda. Azteca 123','México D.F.',NULL,'05033','México'),(10305,55,8,'1996-09-13','1996-10-11','1996-10-09',3,257.6200,'Old World Delicatessen','2743 Bering St.','Anchorage','AK','99508','Estados Unidos'),(10306,69,1,'1996-09-16','1996-10-14','1996-09-23',3,7.5600,'Romero y tomillo','Gran Vía, 1','Madrid',NULL,'28001','España'),(10307,48,2,'1996-09-17','1996-10-15','1996-09-25',2,0.5600,'Lonesome Pine Restaurant','89 Chiaroscuro Rd.','Portland','OR','97219','Estados Unidos'),(10308,2,7,'1996-09-18','1996-10-16','1996-09-24',3,1.6100,'Ana Trujillo Emparedados y helados','Avda. de la Constitución 2222','México D.F.',NULL,'05021','México'),(10309,37,3,'1996-09-19','1996-10-17','1996-10-23',1,47.3000,'Hungry Owl All-Night Grocers','8 Johnstown Road','Cork','Co. Cork',NULL,'Irlanda'),(10310,77,8,'1996-09-20','1996-10-18','1996-09-27',2,17.5200,'The Big Cheese','89 Jefferson Way\r\nSuite 2','Portland','OR','97201','Estados Unidos'),(10311,18,1,'1996-09-20','1996-10-04','1996-09-26',3,24.6900,'Du monde entier','67, rue des Cinquante Otages','Nantes',NULL,'44000','Francia'),(10312,86,2,'1996-09-23','1996-10-21','1996-10-03',2,40.2600,'Die Wandernde Kuh','Adenauerallee 900','Stuttgart',NULL,'70563','Alemania'),(10313,63,2,'1996-09-24','1996-10-22','1996-10-04',2,1.9600,'QUICK-Stop','Taucherstraße 10','Cunewalde',NULL,'01307','Alemania'),(10314,65,1,'1996-09-25','1996-10-23','1996-10-04',2,74.1600,'Rattlesnake Canyon Grocery','2817 Milton Dr.','Albuquerque','NM','87110','Estados Unidos'),(10315,38,4,'1996-09-26','1996-10-24','1996-10-03',2,41.7600,'Island Trading','Garden House\r\nCrowther Way','Cowes','Isle of Wight','PO31 7PJ','Reino Unido'),(10316,65,1,'1996-09-27','1996-10-25','1996-10-08',3,150.1500,'Rattlesnake Canyon Grocery','2817 Milton Dr.','Albuquerque','NM','87110','Estados Unidos'),(10317,48,6,'1996-09-30','1996-10-28','1996-10-10',1,12.6900,'Lonesome Pine Restaurant','89 Chiaroscuro Rd.','Portland','OR','97219','Estados Unidos'),(10318,38,8,'1996-10-01','1996-10-29','1996-10-04',2,4.7300,'Island Trading','Garden House\r\nCrowther Way','Cowes','Isle of Wight','PO31 7PJ','Reino Unido'),(10319,80,7,'1996-10-02','1996-10-30','1996-10-11',3,64.5000,'Tortuga Restaurante','Avda. Azteca 123','México D.F.',NULL,'05033','México'),(10320,87,5,'1996-10-03','1996-10-17','1996-10-18',3,34.5700,'Wartian Herkku','Torikatu 38','Oulu',NULL,'90110','Finlandia'),(10321,38,3,'1996-10-03','1996-10-31','1996-10-11',2,3.4300,'Island Trading','Garden House\r\nCrowther Way','Cowes','Isle of Wight','PO31 7PJ','Reino Unido'),(10322,58,7,'1996-10-04','1996-11-01','1996-10-23',3,0.4000,'Pericles Comidas clásicas','Calle Dr. Jorge Cash 321','México D.F.',NULL,'05033','México'),(10323,39,4,'1996-10-07','1996-11-04','1996-10-14',1,4.8800,'Königlich Essen','Maubelstr. 90','Brandenburg',NULL,'14776','Alemania'),(10324,71,9,'1996-10-08','1996-11-05','1996-10-10',1,214.2700,'Save-a-lot Markets','187 Suffolk Ln.','Boise','ID','83720','Estados Unidos'),(10325,39,1,'1996-10-09','1996-10-23','1996-10-14',3,64.8600,'Königlich Essen','Maubelstr. 90','Brandenburg',NULL,'14776','Alemania'),(10326,8,4,'1996-10-10','1996-11-07','1996-10-14',2,77.9200,'Bólido Comidas preparadas','C/ Araquil, 67','Madrid',NULL,'28023','España'),(10327,24,2,'1996-10-11','1996-11-08','1996-10-14',1,63.3600,'Folk och fä HB','Åkergatan 24','Bräcke',NULL,'S-844 67','Suecia'),(10328,28,4,'1996-10-14','1996-11-11','1996-10-17',3,87.0300,'Furia Bacalhau e Frutos do Mar','Jardim das rosas n. 32','Lisboa',NULL,'1675','Portugal'),(10329,75,4,'1996-10-15','1996-11-26','1996-10-23',2,191.6700,'Split Rail Beer & Ale','P.O. Box 555','Lander','WY','82520','Estados Unidos'),(10330,46,3,'1996-10-16','1996-11-13','1996-10-28',1,12.7500,'LILA-Supermercado','Carrera 52 con Ave. Bolívar #65-98 Llano Largo','Barquisimeto','Lara','3508','Venezuela'),(10331,9,9,'1996-10-16','1996-11-27','1996-10-21',1,10.1900,'Bon app\'','12, rue des Bouchers','Marseille',NULL,'13008','Francia'),(10332,51,3,'1996-10-17','1996-11-28','1996-10-21',2,52.8400,'Mère Paillarde','43 rue St. Laurent','Montréal','Québec','H1J 1C3','Canadá'),(10333,87,5,'1996-10-18','1996-11-15','1996-10-25',3,0.5900,'Wartian Herkku','Torikatu 38','Oulu',NULL,'90110','Finlandia'),(10334,84,8,'1996-10-21','1996-11-18','1996-10-28',2,8.5600,'Victuailles en stock','2, rue du Commerce','Lyon',NULL,'69004','Francia'),(10335,37,7,'1996-10-22','1996-11-19','1996-10-24',2,42.1100,'Hungry Owl All-Night Grocers','8 Johnstown Road','Cork','Co. Cork',NULL,'Irlanda'),(10336,60,7,'1996-10-23','1996-11-20','1996-10-25',2,15.5100,'Princesa Isabel Vinhos','Estrada da saúde n. 58','Lisboa',NULL,'1756','Portugal'),(10337,25,4,'1996-10-24','1996-11-21','1996-10-29',3,108.2600,'Frankenversand','Berliner Platz 43','München',NULL,'80805','Alemania'),(10338,55,4,'1996-10-25','1996-11-22','1996-10-29',3,84.2100,'Old World Delicatessen','2743 Bering St.','Anchorage','AK','99508','Estados Unidos'),(10339,51,2,'1996-10-28','1996-11-25','1996-11-04',2,15.6600,'Mère Paillarde','43 rue St. Laurent','Montréal','Québec','H1J 1C3','Canadá'),(10340,9,1,'1996-10-29','1996-11-26','1996-11-08',3,166.3100,'Bon app\'','12, rue des Bouchers','Marseille',NULL,'13008','Francia'),(10341,73,7,'1996-10-29','1996-11-26','1996-11-05',3,26.7800,'Simons bistro','Vinbæltet 34','København',NULL,'1734','Dinamarca'),(10342,25,4,'1996-10-30','1996-11-13','1996-11-04',2,54.8300,'Frankenversand','Berliner Platz 43','München',NULL,'80805','Alemania'),(10343,44,4,'1996-10-31','1996-11-28','1996-11-06',1,110.3700,'Lehmanns Marktstand','Magazinweg 7','Frankfurt a.M. ',NULL,'60528','Alemania'),(10344,89,4,'1996-11-01','1996-11-29','1996-11-05',2,23.2900,'White Clover Markets','1029 - 12th Ave. S.','Seattle','WA','98124','Estados Unidos'),(10345,63,2,'1996-11-04','1996-12-02','1996-11-11',2,249.0600,'QUICK-Stop','Taucherstraße 10','Cunewalde',NULL,'01307','Alemania'),(10346,65,3,'1996-11-05','1996-12-17','1996-11-08',3,142.0800,'Rattlesnake Canyon Grocery','2817 Milton Dr.','Albuquerque','NM','87110','Estados Unidos'),(10347,21,4,'1996-11-06','1996-12-04','1996-11-08',3,3.1000,'Familia Arquibaldo','Rua Orós, 92','São Paulo','SP','05442-030','Brasil'),(10348,86,4,'1996-11-07','1996-12-05','1996-11-15',2,0.7800,'Die Wandernde Kuh','Adenauerallee 900','Stuttgart',NULL,'70563','Alemania'),(10349,75,7,'1996-11-08','1996-12-06','1996-11-15',1,8.6300,'Split Rail Beer & Ale','P.O. Box 555','Lander','WY','82520','Estados Unidos'),(10350,41,6,'1996-11-11','1996-12-09','1996-12-03',2,64.1900,'La maison d\'Asie','1 rue Alsace-Lorraine','Toulouse',NULL,'31000','Francia'),(10351,20,1,'1996-11-11','1996-12-09','1996-11-20',1,162.3300,'Ernst Handel','Kirchgasse 6','Graz',NULL,'8010','Austria'),(10352,28,3,'1996-11-12','1996-11-26','1996-11-18',3,1.3000,'Furia Bacalhau e Frutos do Mar','Jardim das rosas n. 32','Lisboa',NULL,'1675','Portugal'),(10353,59,7,'1996-11-13','1996-12-11','1996-11-25',3,360.6300,'Piccolo und mehr','Geislweg 14','Salzburg',NULL,'5020','Austria'),(10354,58,8,'1996-11-14','1996-12-12','1996-11-20',3,53.8000,'Pericles Comidas clásicas','Calle Dr. Jorge Cash 321','México D.F.',NULL,'05033','México'),(10355,4,6,'1996-11-15','1996-12-13','1996-11-20',1,41.9500,'Around the Horn','Brook Farm\r\nStratford St. Mary','Colchester','Essex','CO7 6JX','Reino Unido'),(10356,86,6,'1996-11-18','1996-12-16','1996-11-27',2,36.7100,'Die Wandernde Kuh','Adenauerallee 900','Stuttgart',NULL,'70563','Alemania'),(10357,46,1,'1996-11-19','1996-12-17','1996-12-02',3,34.8800,'LILA-Supermercado','Carrera 52 con Ave. Bolívar #65-98 Llano Largo','Barquisimeto','Lara','3508','Venezuela'),(10358,41,5,'1996-11-20','1996-12-18','1996-11-27',1,19.6400,'La maison d\'Asie','1 rue Alsace-Lorraine','Toulouse',NULL,'31000','Francia'),(10359,72,5,'1996-11-21','1996-12-19','1996-11-26',3,288.4300,'Seven Seas Imports','90 Wadhurst Rd.','London',NULL,'OX15 4NB','Reino Unido'),(10360,7,4,'1996-11-22','1996-12-20','1996-12-02',3,131.7000,'Blondel père et fils','24, place Kléber','Strasbourg',NULL,'67000','Francia'),(10361,63,1,'1996-11-22','1996-12-20','1996-12-03',2,183.1700,'QUICK-Stop','Taucherstraße 10','Cunewalde',NULL,'01307','Alemania'),(10362,9,3,'1996-11-25','1996-12-23','1996-11-28',1,96.0400,'Bon app\'','12, rue des Bouchers','Marseille',NULL,'13008','Francia'),(10363,17,4,'1996-11-26','1996-12-24','1996-12-04',3,30.5400,'Drachenblut Delikatessen','Walserweg 21','Aachen',NULL,'52066','Alemania'),(10364,19,1,'1996-11-26','1997-01-07','1996-12-04',1,71.9700,'Eastern Connection','35 King George','London',NULL,'WX3 6FW','Reino Unido'),(10365,3,3,'1996-11-27','1996-12-25','1996-12-02',2,22.0000,'Antonio Moreno Taquería','Mataderos  2312','México D.F.',NULL,'05023','México'),(10366,29,8,'1996-11-28','1997-01-09','1996-12-30',2,10.1400,'Galería del gastronómo','Rambla de Cataluña, 23','Barcelona',NULL,'8022','España'),(10367,83,7,'1996-11-28','1996-12-26','1996-12-02',3,13.5500,'Vaffeljernet','Smagsløget 45','Århus',NULL,'8200','Dinamarca'),(10368,20,2,'1996-11-29','1996-12-27','1996-12-02',2,101.9500,'Ernst Handel','Kirchgasse 6','Graz',NULL,'8010','Austria'),(10369,75,8,'1996-12-02','1996-12-30','1996-12-09',2,195.6800,'Split Rail Beer & Ale','P.O. Box 555','Lander','WY','82520','Estados Unidos'),(10370,16,6,'1996-12-03','1996-12-31','1996-12-27',2,1.1700,'Chop-suey Chinese','Hauptstr. 31','Bern',NULL,'3012','Suiza'),(10371,41,1,'1996-12-03','1996-12-31','1996-12-24',1,0.4500,'La maison d\'Asie','1 rue Alsace-Lorraine','Toulouse',NULL,'31000','Francia'),(10372,62,5,'1996-12-04','1997-01-01','1996-12-09',2,890.7800,'Queen Cozinha','Alameda dos Canàrios, 891','São Paulo','SP','05487-020','Brasil'),(10373,37,4,'1996-12-05','1997-01-02','1996-12-11',3,124.1200,'Hungry Owl All-Night Grocers','8 Johnstown Road','Cork','Co. Cork',NULL,'Irlanda'),(10374,91,1,'1996-12-05','1997-01-02','1996-12-09',3,3.9400,'Wolski Zajazd','ul. Filtrowa 68','Warszawa',NULL,'01-012','Polonia'),(10375,36,3,'1996-12-06','1997-01-03','1996-12-09',2,20.1200,'Hungry Coyote Import Store','City Center Plaza\r\n516 Main St.','Elgin','OR','97827','Estados Unidos'),(10376,51,1,'1996-12-09','1997-01-06','1996-12-13',2,20.3900,'Mère Paillarde','43 rue St. Laurent','Montréal','Québec','H1J 1C3','Canadá'),(10377,72,1,'1996-12-09','1997-01-06','1996-12-13',3,22.2100,'Seven Seas Imports','90 Wadhurst Rd.','London',NULL,'OX15 4NB','Reino Unido'),(10378,24,5,'1996-12-10','1997-01-07','1996-12-19',3,5.4400,'Folk och fä HB','Åkergatan 24','Bräcke',NULL,'S-844 67','Suecia'),(10379,61,2,'1996-12-11','1997-01-08','1996-12-13',1,45.0300,'Que Delícia','Rua da Panificadora, 12','Río de Janeiro','RJ','02389-673','Brasil'),(10380,37,8,'1996-12-12','1997-01-09','1997-01-16',3,35.0300,'Hungry Owl All-Night Grocers','8 Johnstown Road','Cork','Co. Cork',NULL,'Irlanda'),(10381,46,3,'1996-12-12','1997-01-09','1996-12-13',3,7.9900,'LILA-Supermercado','Carrera 52 con Ave. Bolívar #65-98 Llano Largo','Barquisimeto','Lara','3508','Venezuela'),(10382,20,4,'1996-12-13','1997-01-10','1996-12-16',1,94.7700,'Ernst Handel','Kirchgasse 6','Graz',NULL,'8010','Austria'),(10383,4,8,'1996-12-16','1997-01-13','1996-12-18',3,34.2400,'Around the Horn','Brook Farm\r\nStratford St. Mary','Colchester','Essex','CO7 6JX','Reino Unido'),(10384,5,3,'1996-12-16','1997-01-13','1996-12-20',3,168.6400,'Berglunds snabbköp','Berguvsvägen  8','Luleå',NULL,'S-958 22','Suecia'),(10385,75,1,'1996-12-17','1997-01-14','1996-12-23',2,30.9600,'Split Rail Beer & Ale','P.O. Box 555','Lander','WY','82520','Estados Unidos'),(10386,21,9,'1996-12-18','1997-01-01','1996-12-25',3,13.9900,'Familia Arquibaldo','Rua Orós, 92','São Paulo','SP','05442-030','Brasil'),(10387,70,1,'1996-12-18','1997-01-15','1996-12-20',2,93.6300,'Santé Gourmet','Erling Skakkes gate 78','Stavern',NULL,'4110','Noruega'),(10388,72,2,'1996-12-19','1997-01-16','1996-12-20',1,34.8600,'Seven Seas Imports','90 Wadhurst Rd.','London',NULL,'OX15 4NB','Reino Unido'),(10389,10,4,'1996-12-20','1997-01-17','1996-12-24',2,47.4200,'Bottom-Dollar Markets','23 Tsawassen Blvd.','Tsawassen','BC','T2F 8M4','Canadá'),(10390,20,6,'1996-12-23','1997-01-20','1996-12-26',1,126.3800,'Ernst Handel','Kirchgasse 6','Graz',NULL,'8010','Austria'),(10391,17,3,'1996-12-23','1997-01-20','1996-12-31',3,5.4500,'Drachenblut Delikatessen','Walserweg 21','Aachen',NULL,'52066','Alemania'),(10392,59,2,'1996-12-24','1997-01-21','1997-01-01',3,122.4600,'Piccolo und mehr','Geislweg 14','Salzburg',NULL,'5020','Austria'),(10393,71,1,'1996-12-25','1997-01-22','1997-01-03',3,126.5600,'Save-a-lot Markets','187 Suffolk Ln.','Boise','ID','83720','Estados Unidos'),(10394,36,1,'1996-12-25','1997-01-22','1997-01-03',3,30.3400,'Hungry Coyote Import Store','City Center Plaza\r\n516 Main St.','Elgin','OR','97827','Estados Unidos'),(10395,35,6,'1996-12-26','1997-01-23','1997-01-03',1,184.4100,'HILARIÓN-Abastos','Carrera 22 con Ave. Carlos Soublette #8-35','San Cristóbal','Táchira','5022','Venezuela'),(10396,25,1,'1996-12-27','1997-01-10','1997-01-06',3,135.3500,'Frankenversand','Berliner Platz 43','München',NULL,'80805','Alemania'),(10397,60,5,'1996-12-27','1997-01-24','1997-01-02',1,60.2600,'Princesa Isabel Vinhos','Estrada da saúde n. 58','Lisboa',NULL,'1756','Portugal'),(10398,71,2,'1996-12-30','1997-01-27','1997-01-09',3,89.1600,'Save-a-lot Markets','187 Suffolk Ln.','Boise','ID','83720','Estados Unidos'),(10399,83,8,'1996-12-31','1997-01-14','1997-01-08',3,27.3600,'Vaffeljernet','Smagsløget 45','Århus',NULL,'8200','Dinamarca'),(10400,19,1,'1997-01-01','1997-01-29','1997-01-16',3,83.9300,'Eastern Connection','35 King George','London',NULL,'WX3 6FW','Reino Unido'),(10401,65,1,'1997-01-01','1997-01-29','1997-01-10',1,12.5100,'Rattlesnake Canyon Grocery','2817 Milton Dr.','Albuquerque','NM','87110','Estados Unidos'),(10402,20,8,'1997-01-02','1997-02-13','1997-01-10',2,67.8800,'Ernst Handel','Kirchgasse 6','Graz',NULL,'8010','Austria'),(10403,20,4,'1997-01-03','1997-01-31','1997-01-09',3,73.7900,'Ernst Handel','Kirchgasse 6','Graz',NULL,'8010','Austria'),(10404,49,2,'1997-01-03','1997-01-31','1997-01-08',1,155.9700,'Magazzini Alimentari Riuniti','Via Ludovico il Moro 22','Bérgamo',NULL,'24100','Italia'),(10405,47,1,'1997-01-06','1997-02-03','1997-01-22',1,34.8200,'LINO-Delicateses','Ave. 5 de Mayo Porlamar','I. de Margarita','Nueva Esparta','4980','Venezuela'),(10406,62,7,'1997-01-07','1997-02-18','1997-01-13',1,108.0400,'Queen Cozinha','Alameda dos Canàrios, 891','São Paulo','SP','05487-020','Brasil'),(10407,56,2,'1997-01-07','1997-02-04','1997-01-30',2,91.4800,'Ottilies Käseladen','Mehrheimerstr. 369','Köln',NULL,'50739','Alemania'),(10408,23,8,'1997-01-08','1997-02-05','1997-01-14',1,11.2600,'Folies gourmandes','184, chaussée de Tournai','Lille',NULL,'59000','Francia'),(10409,54,3,'1997-01-09','1997-02-06','1997-01-14',1,29.8300,'Océano Atlántico Ltda.','Ing. Gustavo Moncada 8585\r\nPiso 20-A','Buenos Aires',NULL,'1010','Argentina'),(10410,10,3,'1997-01-10','1997-02-07','1997-01-15',3,2.4000,'Bottom-Dollar Markets','23 Tsawassen Blvd.','Tsawassen','BC','T2F 8M4','Canadá'),(10411,10,9,'1997-01-10','1997-02-07','1997-01-21',3,23.6500,'Bottom-Dollar Markets','23 Tsawassen Blvd.','Tsawassen','BC','T2F 8M4','Canadá'),(10412,87,8,'1997-01-13','1997-02-10','1997-01-15',2,3.7700,'Wartian Herkku','Torikatu 38','Oulu',NULL,'90110','Finlandia'),(10413,41,3,'1997-01-14','1997-02-11','1997-01-16',2,95.6600,'La maison d\'Asie','1 rue Alsace-Lorraine','Toulouse',NULL,'31000','Francia'),(10414,21,2,'1997-01-14','1997-02-11','1997-01-17',3,21.4800,'Familia Arquibaldo','Rua Orós, 92','São Paulo','SP','05442-030','Brasil'),(10415,36,3,'1997-01-15','1997-02-12','1997-01-24',1,0.2000,'Hungry Coyote Import Store','City Center Plaza\r\n516 Main St.','Elgin','OR','97827','Estados Unidos'),(10416,87,8,'1997-01-16','1997-02-13','1997-01-27',3,22.7200,'Wartian Herkku','Torikatu 38','Oulu',NULL,'90110','Finlandia'),(10417,73,4,'1997-01-16','1997-02-13','1997-01-28',3,70.2900,'Simons bistro','Vinbæltet 34','København',NULL,'1734','Dinamarca'),(10418,63,4,'1997-01-17','1997-02-14','1997-01-24',1,17.5500,'QUICK-Stop','Taucherstraße 10','Cunewalde',NULL,'01307','Alemania'),(10419,68,4,'1997-01-20','1997-02-17','1997-01-30',2,137.3500,'Richter Supermarkt','Starenweg 5','Genève',NULL,'1204','Suiza'),(10420,88,3,'1997-01-21','1997-02-18','1997-01-27',1,44.1200,'Wellington Importadora','Rua do Mercado, 12','Resende','SP','08737-363','Brasil'),(10421,61,8,'1997-01-21','1997-03-04','1997-01-27',1,99.2300,'Que Delícia','Rua da Panificadora, 12','Río de Janeiro','RJ','02389-673','Brasil'),(10422,27,2,'1997-01-22','1997-02-19','1997-01-31',1,3.0200,'Franchi S.p.A.','Via Monte Bianco 34','Torino',NULL,'10100','Italia'),(10423,31,6,'1997-01-23','1997-02-06','1997-02-24',3,24.5000,'Gourmet Lanchonetes','Av. Brasil, 442','Campinas','SP','04876-786','Brasil'),(10424,51,7,'1997-01-23','1997-02-20','1997-01-27',2,370.6100,'Mère Paillarde','43 rue St. Laurent','Montréal','Québec','H1J 1C3','Canadá'),(10425,41,6,'1997-01-24','1997-02-21','1997-02-14',2,7.9300,'La maison d\'Asie','1 rue Alsace-Lorraine','Toulouse',NULL,'31000','Francia'),(10426,29,4,'1997-01-27','1997-02-24','1997-02-06',1,18.6900,'Galería del gastronómo','Rambla de Cataluña, 23','Barcelona',NULL,'8022','España'),(10427,59,4,'1997-01-27','1997-02-24','1997-03-03',2,31.2900,'Piccolo und mehr','Geislweg 14','Salzburg',NULL,'5020','Austria'),(10428,66,7,'1997-01-28','1997-02-25','1997-02-04',1,11.0900,'Reggiani Caseifici','Strada Provinciale 124','Reggio Emilia',NULL,'42100','Italia'),(10429,37,3,'1997-01-29','1997-03-12','1997-02-07',2,56.6300,'Hungry Owl All-Night Grocers','8 Johnstown Road','Cork','Co. Cork',NULL,'Irlanda'),(10430,20,4,'1997-01-30','1997-02-13','1997-02-03',1,458.7800,'Ernst Handel','Kirchgasse 6','Graz',NULL,'8010','Austria'),(10431,10,4,'1997-01-30','1997-02-13','1997-02-07',2,44.1700,'Bottom-Dollar Markets','23 Tsawassen Blvd.','Tsawassen','BC','T2F 8M4','Canadá'),(10432,75,3,'1997-01-31','1997-02-14','1997-02-07',2,4.3400,'Split Rail Beer & Ale','P.O. Box 555','Lander','WY','82520','Estados Unidos'),(10433,60,3,'1997-02-03','1997-03-03','1997-03-04',3,73.8300,'Princesa Isabel Vinhos','Estrada da saúde n. 58','Lisboa',NULL,'1756','Portugal'),(10434,24,3,'1997-02-03','1997-03-03','1997-02-13',2,17.9200,'Folk och fä HB','Åkergatan 24','Bräcke',NULL,'S-844 67','Suecia'),(10435,15,8,'1997-02-04','1997-03-18','1997-02-07',2,9.2100,'Consolidated Holdings','Berkeley Gardens\r\n12  Brewery ','London',NULL,'WX1 6LT','Reino Unido'),(10436,7,3,'1997-02-05','1997-03-05','1997-02-11',2,156.6600,'Blondel père et fils','24, place Kléber','Strasbourg',NULL,'67000','Francia'),(10437,87,8,'1997-02-05','1997-03-05','1997-02-12',1,19.9700,'Wartian Herkku','Torikatu 38','Oulu',NULL,'90110','Finlandia'),(10438,79,3,'1997-02-06','1997-03-06','1997-02-14',2,8.2400,'Toms Spezialitäten','Luisenstr. 48','Münster',NULL,'44087','Alemania'),(10439,51,6,'1997-02-07','1997-03-07','1997-02-10',3,4.0700,'Mère Paillarde','43 rue St. Laurent','Montréal','Québec','H1J 1C3','Canadá'),(10440,71,4,'1997-02-10','1997-03-10','1997-02-28',2,86.5300,'Save-a-lot Markets','187 Suffolk Ln.','Boise','ID','83720','Estados Unidos'),(10441,55,3,'1997-02-10','1997-03-24','1997-03-14',2,73.0200,'Old World Delicatessen','2743 Bering St.','Anchorage','AK','99508','Estados Unidos'),(10442,20,3,'1997-02-11','1997-03-11','1997-02-18',2,47.9400,'Ernst Handel','Kirchgasse 6','Graz',NULL,'8010','Austria'),(10443,66,8,'1997-02-12','1997-03-12','1997-02-14',1,13.9500,'Reggiani Caseifici','Strada Provinciale 124','Reggio Emilia',NULL,'42100','Italia'),(10444,5,3,'1997-02-12','1997-03-12','1997-02-21',3,3.5000,'Berglunds snabbköp','Berguvsvägen  8','Luleå',NULL,'S-958 22','Suecia'),(10445,5,3,'1997-02-13','1997-03-13','1997-02-20',1,9.3000,'Berglunds snabbköp','Berguvsvägen  8','Luleå',NULL,'S-958 22','Suecia'),(10446,79,6,'1997-02-14','1997-03-14','1997-02-19',1,14.6800,'Toms Spezialitäten','Luisenstr. 48','Münster',NULL,'44087','Alemania'),(10447,67,4,'1997-02-14','1997-03-14','1997-03-07',2,68.6600,'Ricardo Adocicados','Av. Copacabana, 267','Río de Janeiro','RJ','02389-890','Brasil'),(10448,64,4,'1997-02-17','1997-03-17','1997-02-24',2,38.8200,'Rancho grande','Av. del Libertador 900','Buenos Aires',NULL,'1010','Argentina'),(10449,7,3,'1997-02-18','1997-03-18','1997-02-27',2,53.3000,'Blondel père et fils','24, place Kléber','Strasbourg',NULL,'67000','Francia'),(10450,84,8,'1997-02-19','1997-03-19','1997-03-11',2,7.2300,'Victuailles en stock','2, rue du Commerce','Lyon',NULL,'69004','Francia'),(10451,63,4,'1997-02-19','1997-03-05','1997-03-12',3,189.0900,'QUICK-Stop','Taucherstraße 10','Cunewalde',NULL,'01307','Alemania'),(10452,71,8,'1997-02-20','1997-03-20','1997-02-26',1,140.2600,'Save-a-lot Markets','187 Suffolk Ln.','Boise','ID','83720','Estados Unidos'),(10453,4,1,'1997-02-21','1997-03-21','1997-02-26',2,25.3600,'Around the Horn','Brook Farm\r\nStratford St. Mary','Colchester','Essex','CO7 6JX','Reino Unido'),(10454,41,4,'1997-02-21','1997-03-21','1997-02-25',3,2.7400,'La maison d\'Asie','1 rue Alsace-Lorraine','Toulouse',NULL,'31000','Francia'),(10455,87,8,'1997-02-24','1997-04-07','1997-03-03',2,180.4500,'Wartian Herkku','Torikatu 38','Oulu',NULL,'90110','Finlandia'),(10456,39,8,'1997-02-25','1997-04-08','1997-02-28',2,8.1200,'Königlich Essen','Maubelstr. 90','Brandenburg',NULL,'14776','Alemania'),(10457,39,2,'1997-02-25','1997-03-25','1997-03-03',1,11.5700,'Königlich Essen','Maubelstr. 90','Brandenburg',NULL,'14776','Alemania'),(10458,76,7,'1997-02-26','1997-03-26','1997-03-04',3,147.0600,'Suprêmes délices','Boulevard Tirou, 255','Charleroi',NULL,'B-6000','Bélgica'),(10459,84,4,'1997-02-27','1997-03-27','1997-02-28',2,25.0900,'Victuailles en stock','2, rue du Commerce','Lyon',NULL,'69004','Francia'),(10460,24,8,'1997-02-28','1997-03-28','1997-03-03',1,16.2700,'Folk och fä HB','Åkergatan 24','Bräcke',NULL,'S-844 67','Suecia'),(10461,46,1,'1997-02-28','1997-03-28','1997-03-05',3,148.6100,'LILA-Supermercado','Carrera 52 con Ave. Bolívar #65-98 Llano Largo','Barquisimeto','Lara','3508','Venezuela'),(10462,15,2,'1997-03-03','1997-03-31','1997-03-18',1,6.1700,'Consolidated Holdings','Berkeley Gardens\r\n12  Brewery ','London',NULL,'WX1 6LT','Reino Unido'),(10463,76,5,'1997-03-04','1997-04-01','1997-03-06',3,14.7800,'Suprêmes délices','Boulevard Tirou, 255','Charleroi',NULL,'B-6000','Bélgica'),(10464,28,4,'1997-03-04','1997-04-01','1997-03-14',2,89.0000,'Furia Bacalhau e Frutos do Mar','Jardim das rosas n. 32','Lisboa',NULL,'1675','Portugal'),(10465,83,1,'1997-03-05','1997-04-02','1997-03-14',3,145.0400,'Vaffeljernet','Smagsløget 45','Århus',NULL,'8200','Dinamarca'),(10466,14,4,'1997-03-06','1997-04-03','1997-03-13',1,11.9300,'Comércio Mineiro','Av. dos Lusíadas, 23','São Paulo','SP','05432-043','Brasil'),(10467,49,8,'1997-03-06','1997-04-03','1997-03-11',2,4.9300,'Magazzini Alimentari Riuniti','Via Ludovico il Moro 22','Bérgamo',NULL,'24100','Italia'),(10468,39,3,'1997-03-07','1997-04-04','1997-03-12',3,44.1200,'Königlich Essen','Maubelstr. 90','Brandenburg',NULL,'14776','Alemania'),(10469,89,1,'1997-03-10','1997-04-07','1997-03-14',1,60.1800,'White Clover Markets','1029 - 12th Ave. S.','Seattle','WA','98124','Estados Unidos'),(10470,9,4,'1997-03-11','1997-04-08','1997-03-14',2,64.5600,'Bon app\'','12, rue des Bouchers','Marseille',NULL,'13008','Francia'),(10471,11,2,'1997-03-11','1997-04-08','1997-03-18',3,45.5900,'B\'s Beverages','Fauntleroy Circus','London',NULL,'EC2 5NT','Reino Unido'),(10472,72,8,'1997-03-12','1997-04-09','1997-03-19',1,4.2000,'Seven Seas Imports','90 Wadhurst Rd.','London',NULL,'OX15 4NB','Reino Unido'),(10473,38,1,'1997-03-13','1997-03-27','1997-03-21',3,16.3700,'Island Trading','Garden House\r\nCrowther Way','Cowes','Isle of Wight','PO31 7PJ','Reino Unido'),(10474,58,5,'1997-03-13','1997-04-10','1997-03-21',2,83.4900,'Pericles Comidas clásicas','Calle Dr. Jorge Cash 321','México D.F.',NULL,'05033','México'),(10475,76,9,'1997-03-14','1997-04-11','1997-04-04',1,68.5200,'Suprêmes délices','Boulevard Tirou, 255','Charleroi',NULL,'B-6000','Bélgica'),(10476,35,8,'1997-03-17','1997-04-14','1997-03-24',3,4.4100,'HILARIÓN-Abastos','Carrera 22 con Ave. Carlos Soublette #8-35','San Cristóbal','Táchira','5022','Venezuela'),(10477,60,5,'1997-03-17','1997-04-14','1997-03-25',2,13.0200,'Princesa Isabel Vinhos','Estrada da saúde n. 58','Lisboa',NULL,'1756','Portugal'),(10478,84,2,'1997-03-18','1997-04-01','1997-03-26',3,4.8100,'Victuailles en stock','2, rue du Commerce','Lyon',NULL,'69004','Francia'),(10479,65,3,'1997-03-19','1997-04-16','1997-03-21',3,708.9500,'Rattlesnake Canyon Grocery','2817 Milton Dr.','Albuquerque','NM','87110','Estados Unidos'),(10480,23,6,'1997-03-20','1997-04-17','1997-03-24',2,1.3500,'Folies gourmandes','184, chaussée de Tournai','Lille',NULL,'59000','Francia'),(10481,67,8,'1997-03-20','1997-04-17','1997-03-25',2,64.3300,'Ricardo Adocicados','Av. Copacabana, 267','Río de Janeiro','RJ','02389-890','Brasil'),(10482,43,1,'1997-03-21','1997-04-18','1997-04-10',3,7.4800,'Lazy K Kountry Store','12 Orchestra Terrace','Walla Walla','WA','99362','Estados Unidos'),(10483,89,7,'1997-03-24','1997-04-21','1997-04-25',2,15.2800,'White Clover Markets','1029 - 12th Ave. S.','Seattle','WA','98124','Estados Unidos'),(10484,11,3,'1997-03-24','1997-04-21','1997-04-01',3,6.8800,'B\'s Beverages','Fauntleroy Circus','London',NULL,'EC2 5NT','Reino Unido'),(10485,47,4,'1997-03-25','1997-04-08','1997-03-31',2,64.4500,'LINO-Delicateses','Ave. 5 de Mayo Porlamar','I. de Margarita','Nueva Esparta','4980','Venezuela'),(10486,35,1,'1997-03-26','1997-04-23','1997-04-02',2,30.5300,'HILARIÓN-Abastos','Carrera 22 con Ave. Carlos Soublette #8-35','San Cristóbal','Táchira','5022','Venezuela'),(10487,62,2,'1997-03-26','1997-04-23','1997-03-28',2,71.0700,'Queen Cozinha','Alameda dos Canàrios, 891','São Paulo','SP','05487-020','Brasil'),(10488,25,8,'1997-03-27','1997-04-24','1997-04-02',2,4.9300,'Frankenversand','Berliner Platz 43','München',NULL,'80805','Alemania'),(10489,59,6,'1997-03-28','1997-04-25','1997-04-09',2,5.2900,'Piccolo und mehr','Geislweg 14','Salzburg',NULL,'5020','Austria'),(10490,35,7,'1997-03-31','1997-04-28','1997-04-03',2,210.1900,'HILARIÓN-Abastos','Carrera 22 con Ave. Carlos Soublette #8-35','San Cristóbal','Táchira','5022','Venezuela'),(10491,28,8,'1997-03-31','1997-04-28','1997-04-08',3,16.9600,'Furia Bacalhau e Frutos do Mar','Jardim das rosas n. 32','Lisboa',NULL,'1675','Portugal'),(10492,10,3,'1997-04-01','1997-04-29','1997-04-11',1,62.8900,'Bottom-Dollar Markets','23 Tsawassen Blvd.','Tsawassen','BC','T2F 8M4','Canadá'),(10493,41,4,'1997-04-02','1997-04-30','1997-04-10',3,10.6400,'La maison d\'Asie','1 rue Alsace-Lorraine','Toulouse',NULL,'31000','Francia'),(10494,14,4,'1997-04-02','1997-04-30','1997-04-09',2,65.9900,'Comércio Mineiro','Av. dos Lusíadas, 23','São Paulo','SP','05432-043','Brasil'),(10495,42,3,'1997-04-03','1997-05-01','1997-04-11',3,4.6500,'Laughing Bacchus Wine Cellars','2319 Elm St.','Vancouver','BC','V3F 2K1','Canadá'),(10496,81,7,'1997-04-04','1997-05-02','1997-04-07',2,46.7700,'Tradição Hipermercados','Av. Inês de Castro, 414','São Paulo','SP','05634-030','Brasil'),(10497,44,7,'1997-04-04','1997-05-02','1997-04-07',1,36.2100,'Lehmanns Marktstand','Magazinweg 7','Frankfurt a.M. ',NULL,'60528','Alemania'),(10498,35,8,'1997-04-07','1997-05-05','1997-04-11',2,29.7500,'HILARIÓN-Abastos','Carrera 22 con Ave. Carlos Soublette #8-35','San Cristóbal','Táchira','5022','Venezuela'),(10499,46,4,'1997-04-08','1997-05-06','1997-04-16',2,102.0200,'LILA-Supermercado','Carrera 52 con Ave. Bolívar #65-98 Llano Largo','Barquisimeto','Lara','3508','Venezuela'),(10500,41,6,'1997-04-09','1997-05-07','1997-04-17',1,42.6800,'La maison d\'Asie','1 rue Alsace-Lorraine','Toulouse',NULL,'31000','Francia'),(10501,6,9,'1997-04-09','1997-05-07','1997-04-16',3,8.8500,'Blauer See Delikatessen','Forsterstr. 57','Mannheim',NULL,'68306','Alemania'),(10502,58,2,'1997-04-10','1997-05-08','1997-04-29',1,69.3200,'Pericles Comidas clásicas','Calle Dr. Jorge Cash 321','México D.F.',NULL,'05033','México'),(10503,37,6,'1997-04-11','1997-05-09','1997-04-16',2,16.7400,'Hungry Owl All-Night Grocers','8 Johnstown Road','Cork','Co. Cork',NULL,'Irlanda'),(10504,89,4,'1997-04-11','1997-05-09','1997-04-18',3,59.1300,'White Clover Markets','1029 - 12th Ave. S.','Seattle','WA','98124','Estados Unidos'),(10505,51,3,'1997-04-14','1997-05-12','1997-04-21',3,7.1300,'Mère Paillarde','43 rue St. Laurent','Montréal','Québec','H1J 1C3','Canadá'),(10506,39,9,'1997-04-15','1997-05-13','1997-05-02',2,21.1900,'Königlich Essen','Maubelstr. 90','Brandenburg',NULL,'14776','Alemania'),(10507,3,7,'1997-04-15','1997-05-13','1997-04-22',1,47.4500,'Antonio Moreno Taquería','Mataderos  2312','México D.F.',NULL,'05023','México'),(10508,56,1,'1997-04-16','1997-05-14','1997-05-13',2,4.9900,'Ottilies Käseladen','Mehrheimerstr. 369','Köln',NULL,'50739','Alemania'),(10509,6,4,'1997-04-17','1997-05-15','1997-04-29',1,0.1500,'Blauer See Delikatessen','Forsterstr. 57','Mannheim',NULL,'68306','Alemania'),(10510,71,6,'1997-04-18','1997-05-16','1997-04-28',3,367.6300,'Save-a-lot Markets','187 Suffolk Ln.','Boise','ID','83720','Estados Unidos'),(10511,9,4,'1997-04-18','1997-05-16','1997-04-21',3,350.6400,'Bon app\'','12, rue des Bouchers','Marseille',NULL,'13008','Francia'),(10512,21,7,'1997-04-21','1997-05-19','1997-04-24',2,3.5300,'Familia Arquibaldo','Rua Orós, 92','São Paulo','SP','05442-030','Brasil'),(10513,86,7,'1997-04-22','1997-06-03','1997-04-28',1,105.6500,'Die Wandernde Kuh','Adenauerallee 900','Stuttgart',NULL,'70563','Alemania'),(10514,20,3,'1997-04-22','1997-05-20','1997-05-16',2,789.9500,'Ernst Handel','Kirchgasse 6','Graz',NULL,'8010','Austria'),(10515,63,2,'1997-04-23','1997-05-07','1997-05-23',1,204.4700,'QUICK-Stop','Taucherstraße 10','Cunewalde',NULL,'01307','Alemania'),(10516,37,2,'1997-04-24','1997-05-22','1997-05-01',3,62.7800,'Hungry Owl All-Night Grocers','8 Johnstown Road','Cork','Co. Cork',NULL,'Irlanda'),(10517,53,3,'1997-04-24','1997-05-22','1997-04-29',3,32.0700,'North/South','South House\r\n300 Queensbridge','London',NULL,'SW7 1RZ','Reino Unido'),(10518,80,4,'1997-04-25','1997-05-09','1997-05-05',2,218.1500,'Tortuga Restaurante','Avda. Azteca 123','México D.F.',NULL,'05033','México'),(10519,16,6,'1997-04-28','1997-05-26','1997-05-01',3,91.7600,'Chop-suey Chinese','Hauptstr. 31','Bern',NULL,'3012','Suiza'),(10520,70,7,'1997-04-29','1997-05-27','1997-05-01',1,13.3700,'Santé Gourmet','Erling Skakkes gate 78','Stavern',NULL,'4110','Noruega'),(10521,12,8,'1997-04-29','1997-05-27','1997-05-02',2,17.2200,'Cactus Comidas para llevar','Cerrito 333','Buenos Aires',NULL,'1010','Argentina'),(10522,44,4,'1997-04-30','1997-05-28','1997-05-06',1,45.3300,'Lehmanns Marktstand','Magazinweg 7','Frankfurt a.M. ',NULL,'60528','Alemania'),(10523,72,7,'1997-05-01','1997-05-29','1997-05-30',2,77.6300,'Seven Seas Imports','90 Wadhurst Rd.','London',NULL,'OX15 4NB','Reino Unido'),(10524,5,1,'1997-05-01','1997-05-29','1997-05-07',2,244.7900,'Berglunds snabbköp','Berguvsvägen  8','Luleå',NULL,'S-958 22','Suecia'),(10525,9,1,'1997-05-02','1997-05-30','1997-05-23',2,11.0600,'Bon app\'','12, rue des Bouchers','Marseille',NULL,'13008','Francia'),(10526,87,4,'1997-05-05','1997-06-02','1997-05-15',2,58.5900,'Wartian Herkku','Torikatu 38','Oulu',NULL,'90110','Finlandia'),(10527,63,7,'1997-05-05','1997-06-02','1997-05-07',1,41.9000,'QUICK-Stop','Taucherstraße 10','Cunewalde',NULL,'01307','Alemania'),(10528,32,6,'1997-05-06','1997-05-20','1997-05-09',2,3.3500,'Great Lakes Food Market','2732 Baker Blvd.','Eugene','OR','97403','Estados Unidos'),(10529,50,5,'1997-05-07','1997-06-04','1997-05-09',2,66.6900,'Maison Dewey','Rue Joseph-Bens 532','Bruxelles',NULL,'B-1180','Bélgica'),(10530,59,3,'1997-05-08','1997-06-05','1997-05-12',2,339.2200,'Piccolo und mehr','Geislweg 14','Salzburg',NULL,'5020','Austria'),(10531,54,7,'1997-05-08','1997-06-05','1997-05-19',1,8.1200,'Océano Atlántico Ltda.','Ing. Gustavo Moncada 8585\r\nPiso 20-A','Buenos Aires',NULL,'1010','Argentina'),(10532,19,7,'1997-05-09','1997-06-06','1997-05-12',3,74.4600,'Eastern Connection','35 King George','London',NULL,'WX3 6FW','Reino Unido'),(10533,24,8,'1997-05-12','1997-06-09','1997-05-22',1,188.0400,'Folk och fä HB','Åkergatan 24','Bräcke',NULL,'S-844 67','Suecia'),(10534,44,8,'1997-05-12','1997-06-09','1997-05-14',2,27.9400,'Lehmanns Marktstand','Magazinweg 7','Frankfurt a.M. ',NULL,'60528','Alemania'),(10535,3,4,'1997-05-13','1997-06-10','1997-05-21',1,15.6400,'Antonio Moreno Taquería','Mataderos  2312','México D.F.',NULL,'05023','México'),(10536,44,3,'1997-05-14','1997-06-11','1997-06-06',2,58.8800,'Lehmanns Marktstand','Magazinweg 7','Frankfurt a.M. ',NULL,'60528','Alemania'),(10537,68,1,'1997-05-14','1997-05-28','1997-05-19',1,78.8500,'Richter Supermarkt','Starenweg 5','Genève',NULL,'1204','Suiza'),(10538,11,9,'1997-05-15','1997-06-12','1997-05-16',3,4.8700,'B\'s Beverages','Fauntleroy Circus','London',NULL,'EC2 5NT','Reino Unido'),(10539,11,6,'1997-05-16','1997-06-13','1997-05-23',3,12.3600,'B\'s Beverages','Fauntleroy Circus','London',NULL,'EC2 5NT','Reino Unido'),(10540,63,3,'1997-05-19','1997-06-16','1997-06-13',3,1007.6400,'QUICK-Stop','Taucherstraße 10','Cunewalde',NULL,'01307','Alemania'),(10541,34,2,'1997-05-19','1997-06-16','1997-05-29',1,68.6500,'Hanari Carnes','Rua do Paço, 67','Río de Janeiro','RJ','05454-876','Brasil'),(10542,39,1,'1997-05-20','1997-06-17','1997-05-26',3,10.9500,'Königlich Essen','Maubelstr. 90','Brandenburg',NULL,'14776','Alemania'),(10543,46,8,'1997-05-21','1997-06-18','1997-05-23',2,48.1700,'LILA-Supermercado','Carrera 52 con Ave. Bolívar #65-98 Llano Largo','Barquisimeto','Lara','3508','Venezuela'),(10544,48,4,'1997-05-21','1997-06-18','1997-05-30',1,24.9100,'Lonesome Pine Restaurant','89 Chiaroscuro Rd.','Portland','OR','97219','Estados Unidos'),(10545,43,8,'1997-05-22','1997-06-19','1997-06-26',2,11.9200,'Lazy K Kountry Store','12 Orchestra Terrace','Walla Walla','WA','99362','Estados Unidos'),(10546,84,1,'1997-05-23','1997-06-20','1997-05-27',3,194.7200,'Victuailles en stock','2, rue du Commerce','Lyon',NULL,'69004','Francia'),(10547,72,3,'1997-05-23','1997-06-20','1997-06-02',2,178.4300,'Seven Seas Imports','90 Wadhurst Rd.','London',NULL,'OX15 4NB','Reino Unido'),(10548,79,3,'1997-05-26','1997-06-23','1997-06-02',2,1.4300,'Toms Spezialitäten','Luisenstr. 48','Münster',NULL,'44087','Alemania'),(10549,63,5,'1997-05-27','1997-06-10','1997-05-30',1,171.2400,'QUICK-Stop','Taucherstraße 10','Cunewalde',NULL,'01307','Alemania'),(10550,30,7,'1997-05-28','1997-06-25','1997-06-06',3,4.3200,'Godos Cocina Típica','C/ Romero, 33','Sevilla',NULL,'41101','España'),(10551,28,4,'1997-05-28','1997-07-09','1997-06-06',3,72.9500,'Furia Bacalhau e Frutos do Mar','Jardim das rosas n. 32','Lisboa',NULL,'1675','Portugal'),(10552,35,2,'1997-05-29','1997-06-26','1997-06-05',1,83.2200,'HILARIÓN-Abastos','Carrera 22 con Ave. Carlos Soublette #8-35','San Cristóbal','Táchira','5022','Venezuela'),(10553,87,2,'1997-05-30','1997-06-27','1997-06-03',2,149.4900,'Wartian Herkku','Torikatu 38','Oulu',NULL,'90110','Finlandia'),(10554,56,4,'1997-05-30','1997-06-27','1997-06-05',3,120.9700,'Ottilies Käseladen','Mehrheimerstr. 369','Köln',NULL,'50739','Alemania'),(10555,71,6,'1997-06-02','1997-06-30','1997-06-04',3,252.4900,'Save-a-lot Markets','187 Suffolk Ln.','Boise','ID','83720','Estados Unidos'),(10556,73,2,'1997-06-03','1997-07-15','1997-06-13',1,9.8000,'Simons bistro','Vinbæltet 34','København',NULL,'1734','Dinamarca'),(10557,44,9,'1997-06-03','1997-06-17','1997-06-06',2,96.7200,'Lehmanns Marktstand','Magazinweg 7','Frankfurt a.M. ',NULL,'60528','Alemania'),(10558,4,1,'1997-06-04','1997-07-02','1997-06-10',2,72.9700,'Around the Horn','Brook Farm\r\nStratford St. Mary','Colchester','Essex','CO7 6JX','Reino Unido'),(10559,7,6,'1997-06-05','1997-07-03','1997-06-13',1,8.0500,'Blondel père et fils','24, place Kléber','Strasbourg',NULL,'67000','Francia'),(10560,25,8,'1997-06-06','1997-07-04','1997-06-09',1,36.6500,'Frankenversand','Berliner Platz 43','München',NULL,'80805','Alemania'),(10561,24,2,'1997-06-06','1997-07-04','1997-06-09',2,242.2100,'Folk och fä HB','Åkergatan 24','Bräcke',NULL,'S-844 67','Suecia'),(10562,66,1,'1997-06-09','1997-07-07','1997-06-12',1,22.9500,'Reggiani Caseifici','Strada Provinciale 124','Reggio Emilia',NULL,'42100','Italia'),(10563,67,2,'1997-06-10','1997-07-22','1997-06-24',2,60.4300,'Ricardo Adocicados','Av. Copacabana, 267','Río de Janeiro','RJ','02389-890','Brasil'),(10564,65,4,'1997-06-10','1997-07-08','1997-06-16',3,13.7500,'Rattlesnake Canyon Grocery','2817 Milton Dr.','Albuquerque','NM','87110','Estados Unidos'),(10565,51,8,'1997-06-11','1997-07-09','1997-06-18',2,7.1500,'Mère Paillarde','43 rue St. Laurent','Montréal','Québec','H1J 1C3','Canadá'),(10566,7,9,'1997-06-12','1997-07-10','1997-06-18',1,88.4000,'Blondel père et fils','24, place Kléber','Strasbourg',NULL,'67000','Francia'),(10567,37,1,'1997-06-12','1997-07-10','1997-06-17',1,33.9700,'Hungry Owl All-Night Grocers','8 Johnstown Road','Cork','Co. Cork',NULL,'Irlanda'),(10568,29,3,'1997-06-13','1997-07-11','1997-07-09',3,6.5400,'Galería del gastronómo','Rambla de Cataluña, 23','Barcelona',NULL,'8022','España'),(10569,65,5,'1997-06-16','1997-07-14','1997-07-11',1,58.9800,'Rattlesnake Canyon Grocery','2817 Milton Dr.','Albuquerque','NM','87110','Estados Unidos'),(10570,51,3,'1997-06-17','1997-07-15','1997-06-19',3,188.9900,'Mère Paillarde','43 rue St. Laurent','Montréal','Québec','H1J 1C3','Canadá'),(10571,20,8,'1997-06-17','1997-07-29','1997-07-04',3,26.0600,'Ernst Handel','Kirchgasse 6','Graz',NULL,'8010','Austria'),(10572,5,3,'1997-06-18','1997-07-16','1997-06-25',2,116.4300,'Berglunds snabbköp','Berguvsvägen  8','Luleå',NULL,'S-958 22','Suecia'),(10573,3,7,'1997-06-19','1997-07-17','1997-06-20',3,84.8400,'Antonio Moreno Taquería','Mataderos  2312','México D.F.',NULL,'05023','México'),(10574,82,4,'1997-06-19','1997-07-17','1997-06-30',2,37.6000,'Trail\'s Head Gourmet Provisioners','722 DaVinci Blvd.','Kirkland','WA','98034','Estados Unidos'),(10575,52,5,'1997-06-20','1997-07-04','1997-06-30',1,127.3400,'Morgenstern Gesundkost','Heerstr. 22','Leipzig',NULL,'04179','Alemania'),(10576,80,3,'1997-06-23','1997-07-07','1997-06-30',3,18.5600,'Tortuga Restaurante','Avda. Azteca 123','México D.F.',NULL,'05033','México'),(10577,82,9,'1997-06-23','1997-08-04','1997-06-30',2,25.4100,'Trail\'s Head Gourmet Provisioners','722 DaVinci Blvd.','Kirkland','WA','98034','Estados Unidos'),(10578,11,4,'1997-06-24','1997-07-22','1997-07-25',3,29.6000,'B\'s Beverages','Fauntleroy Circus','London',NULL,'EC2 5NT','Reino Unido'),(10579,45,1,'1997-06-25','1997-07-23','1997-07-04',2,13.7300,'Let\'s Stop N Shop','87 Polk St.\r\nSuite 5','San Francisco','CA','94117','Estados Unidos'),(10580,56,4,'1997-06-26','1997-07-24','1997-07-01',3,75.8900,'Ottilies Käseladen','Mehrheimerstr. 369','Köln',NULL,'50739','Alemania'),(10581,21,3,'1997-06-26','1997-07-24','1997-07-02',1,3.0100,'Familia Arquibaldo','Rua Orós, 92','São Paulo','SP','05442-030','Brasil'),(10582,6,3,'1997-06-27','1997-07-25','1997-07-14',2,27.7100,'Blauer See Delikatessen','Forsterstr. 57','Mannheim',NULL,'68306','Alemania'),(10583,87,2,'1997-06-30','1997-07-28','1997-07-04',2,7.2800,'Wartian Herkku','Torikatu 38','Oulu',NULL,'90110','Finlandia'),(10584,7,4,'1997-06-30','1997-07-28','1997-07-04',1,59.1400,'Blondel père et fils','24, place Kléber','Strasbourg',NULL,'67000','Francia'),(10585,88,7,'1997-07-01','1997-07-29','1997-07-10',1,13.4100,'Wellington Importadora','Rua do Mercado, 12','Resende','SP','08737-363','Brasil'),(10586,66,9,'1997-07-02','1997-07-30','1997-07-09',1,0.4800,'Reggiani Caseifici','Strada Provinciale 124','Reggio Emilia',NULL,'42100','Italia'),(10587,61,1,'1997-07-02','1997-07-30','1997-07-09',1,62.5200,'Que Delícia','Rua da Panificadora, 12','Río de Janeiro','RJ','02389-673','Brasil'),(10588,63,2,'1997-07-03','1997-07-31','1997-07-10',3,194.6700,'QUICK-Stop','Taucherstraße 10','Cunewalde',NULL,'01307','Alemania'),(10589,32,8,'1997-07-04','1997-08-01','1997-07-14',2,4.4200,'Great Lakes Food Market','2732 Baker Blvd.','Eugene','OR','97403','Estados Unidos'),(10590,51,4,'1997-07-07','1997-08-04','1997-07-14',3,44.7700,'Mère Paillarde','43 rue St. Laurent','Montréal','Québec','H1J 1C3','Canadá'),(10591,83,1,'1997-07-07','1997-07-21','1997-07-16',1,55.9200,'Vaffeljernet','Smagsløget 45','Århus',NULL,'8200','Dinamarca'),(10592,44,3,'1997-07-08','1997-08-05','1997-07-16',1,32.1000,'Lehmanns Marktstand','Magazinweg 7','Frankfurt a.M. ',NULL,'60528','Alemania'),(10593,44,7,'1997-07-09','1997-08-06','1997-08-13',2,174.2000,'Lehmanns Marktstand','Magazinweg 7','Frankfurt a.M. ',NULL,'60528','Alemania'),(10594,55,3,'1997-07-09','1997-08-06','1997-07-16',2,5.2400,'Old World Delicatessen','2743 Bering St.','Anchorage','AK','99508','Estados Unidos'),(10595,20,2,'1997-07-10','1997-08-07','1997-07-14',1,96.7800,'Ernst Handel','Kirchgasse 6','Graz',NULL,'8010','Austria'),(10596,89,8,'1997-07-11','1997-08-08','1997-08-12',1,16.3400,'White Clover Markets','1029 - 12th Ave. S.','Seattle','WA','98124','Estados Unidos'),(10597,59,7,'1997-07-11','1997-08-08','1997-07-18',3,35.1200,'Piccolo und mehr','Geislweg 14','Salzburg',NULL,'5020','Austria'),(10598,65,1,'1997-07-14','1997-08-11','1997-07-18',3,44.4200,'Rattlesnake Canyon Grocery','2817 Milton Dr.','Albuquerque','NM','87110','Estados Unidos'),(10599,11,6,'1997-07-15','1997-08-26','1997-07-21',3,29.9800,'B\'s Beverages','Fauntleroy Circus','London',NULL,'EC2 5NT','Reino Unido'),(10600,36,4,'1997-07-16','1997-08-13','1997-07-21',1,45.1300,'Hungry Coyote Import Store','City Center Plaza\r\n516 Main St.','Elgin','OR','97827','Estados Unidos'),(10601,35,7,'1997-07-16','1997-08-27','1997-07-22',1,58.3000,'HILARIÓN-Abastos','Carrera 22 con Ave. Carlos Soublette #8-35','San Cristóbal','Táchira','5022','Venezuela'),(10602,83,8,'1997-07-17','1997-08-14','1997-07-22',2,2.9200,'Vaffeljernet','Smagsløget 45','Århus',NULL,'8200','Dinamarca'),(10603,71,8,'1997-07-18','1997-08-15','1997-08-08',2,48.7700,'Save-a-lot Markets','187 Suffolk Ln.','Boise','ID','83720','Estados Unidos'),(10604,28,1,'1997-07-18','1997-08-15','1997-07-29',1,7.4600,'Furia Bacalhau e Frutos do Mar','Jardim das rosas n. 32','Lisboa',NULL,'1675','Portugal'),(10605,51,1,'1997-07-21','1997-08-18','1997-07-29',2,379.1300,'Mère Paillarde','43 rue St. Laurent','Montréal','Québec','H1J 1C3','Canadá'),(10606,81,4,'1997-07-22','1997-08-19','1997-07-31',3,79.4000,'Tradição Hipermercados','Av. Inês de Castro, 414','São Paulo','SP','05634-030','Brasil'),(10607,71,5,'1997-07-22','1997-08-19','1997-07-25',1,200.2400,'Save-a-lot Markets','187 Suffolk Ln.','Boise','ID','83720','Estados Unidos'),(10608,79,4,'1997-07-23','1997-08-20','1997-08-01',2,27.7900,'Toms Spezialitäten','Luisenstr. 48','Münster',NULL,'44087','Alemania'),(10609,18,7,'1997-07-24','1997-08-21','1997-07-30',2,1.8500,'Du monde entier','67, rue des Cinquante Otages','Nantes',NULL,'44000','Francia'),(10610,41,8,'1997-07-25','1997-08-22','1997-08-06',1,26.7800,'La maison d\'Asie','1 rue Alsace-Lorraine','Toulouse',NULL,'31000','Francia'),(10611,91,6,'1997-07-25','1997-08-22','1997-08-01',2,80.6500,'Wolski Zajazd','ul. Filtrowa 68','Warszawa',NULL,'01-012','Polonia'),(10612,71,1,'1997-07-28','1997-08-25','1997-08-01',2,544.0800,'Save-a-lot Markets','187 Suffolk Ln.','Boise','ID','83720','Estados Unidos'),(10613,35,4,'1997-07-29','1997-08-26','1997-08-01',2,8.1100,'HILARIÓN-Abastos','Carrera 22 con Ave. Carlos Soublette #8-35','San Cristóbal','Táchira','5022','Venezuela'),(10614,6,8,'1997-07-29','1997-08-26','1997-08-01',3,1.9300,'Blauer See Delikatessen','Forsterstr. 57','Mannheim',NULL,'68306','Alemania'),(10616,32,1,'1997-07-31','1997-08-28','1997-08-05',2,116.5300,'Great Lakes Food Market','2732 Baker Blvd.','Eugene','OR','97403','Estados Unidos'),(10617,32,4,'1997-07-31','1997-08-28','1997-08-04',2,18.5300,'Great Lakes Food Market','2732 Baker Blvd.','Eugene','OR','97403','Estados Unidos'),(10618,51,1,'1997-08-01','1997-09-12','1997-08-08',1,154.6800,'Mère Paillarde','43 rue St. Laurent','Montréal','Québec','H1J 1C3','Canadá'),(10619,51,3,'1997-08-04','1997-09-01','1997-08-07',3,91.0500,'Mère Paillarde','43 rue St. Laurent','Montréal','Québec','H1J 1C3','Canadá'),(10620,42,2,'1997-08-05','1997-09-02','1997-08-14',3,0.9400,'Laughing Bacchus Wine Cellars','2319 Elm St.','Vancouver','BC','V3F 2K1','Canadá'),(10621,38,4,'1997-08-05','1997-09-02','1997-08-11',2,23.7300,'Island Trading','Garden House\r\nCrowther Way','Cowes','Isle of Wight','PO31 7PJ','Reino Unido'),(10622,67,4,'1997-08-06','1997-09-03','1997-08-11',3,50.9700,'Ricardo Adocicados','Av. Copacabana, 267','Río de Janeiro','RJ','02389-890','Brasil'),(10623,25,8,'1997-08-07','1997-09-04','1997-08-12',2,97.1800,'Frankenversand','Berliner Platz 43','München',NULL,'80805','Alemania'),(10624,78,4,'1997-08-07','1997-09-04','1997-08-19',2,94.8000,'The Cracker Box','55 Grizzly Peak Rd.','Butte','MT','59801','Estados Unidos'),(10625,2,3,'1997-08-08','1997-09-05','1997-08-14',1,43.9000,'Ana Trujillo Emparedados y helados','Avda. de la Constitución 2222','México D.F.',NULL,'05021','México'),(10626,5,1,'1997-08-11','1997-09-08','1997-08-20',2,138.6900,'Berglunds snabbköp','Berguvsvägen  8','Luleå',NULL,'S-958 22','Suecia'),(10627,71,8,'1997-08-11','1997-09-22','1997-08-21',3,107.4600,'Save-a-lot Markets','187 Suffolk Ln.','Boise','ID','83720','Estados Unidos'),(10628,7,4,'1997-08-12','1997-09-09','1997-08-20',3,30.3600,'Blondel père et fils','24, place Kléber','Strasbourg',NULL,'67000','Francia'),(10629,30,4,'1997-08-12','1997-09-09','1997-08-20',3,85.4600,'Godos Cocina Típica','C/ Romero, 33','Sevilla',NULL,'41101','España'),(10630,39,1,'1997-08-13','1997-09-10','1997-08-19',2,32.3500,'Königlich Essen','Maubelstr. 90','Brandenburg',NULL,'14776','Alemania'),(10631,41,8,'1997-08-14','1997-09-11','1997-08-15',1,0.8700,'La maison d\'Asie','1 rue Alsace-Lorraine','Toulouse',NULL,'31000','Francia'),(10632,86,8,'1997-08-14','1997-09-11','1997-08-19',1,41.3800,'Die Wandernde Kuh','Adenauerallee 900','Stuttgart',NULL,'70563','Alemania'),(10633,20,7,'1997-08-15','1997-09-12','1997-08-18',3,477.9000,'Ernst Handel','Kirchgasse 6','Graz',NULL,'8010','Austria'),(10634,23,4,'1997-08-15','1997-09-12','1997-08-21',3,487.3800,'Folies gourmandes','184, chaussée de Tournai','Lille',NULL,'59000','Francia'),(10635,49,8,'1997-08-18','1997-09-15','1997-08-21',3,47.4600,'Magazzini Alimentari Riuniti','Via Ludovico il Moro 22','Bérgamo',NULL,'24100','Italia'),(10636,87,4,'1997-08-19','1997-09-16','1997-08-26',1,1.1500,'Wartian Herkku','Torikatu 38','Oulu',NULL,'90110','Finlandia'),(10637,62,6,'1997-08-19','1997-09-16','1997-08-26',1,201.2900,'Queen Cozinha','Alameda dos Canàrios, 891','São Paulo','SP','05487-020','Brasil'),(10638,47,3,'1997-08-20','1997-09-17','1997-09-01',1,158.4400,'LINO-Delicateses','Ave. 5 de Mayo Porlamar','I. de Margarita','Nueva Esparta','4980','Venezuela'),(10639,70,7,'1997-08-20','1997-09-17','1997-08-27',3,38.6400,'Santé Gourmet','Erling Skakkes gate 78','Stavern',NULL,'4110','Noruega'),(10640,86,4,'1997-08-21','1997-09-18','1997-08-28',1,23.5500,'Die Wandernde Kuh','Adenauerallee 900','Stuttgart',NULL,'70563','Alemania'),(10641,35,4,'1997-08-22','1997-09-19','1997-08-26',2,179.6100,'HILARIÓN-Abastos','Carrera 22 con Ave. Carlos Soublette #8-35','San Cristóbal','Táchira','5022','Venezuela'),(10642,73,7,'1997-08-22','1997-09-19','1997-09-05',3,41.8900,'Simons bistro','Vinbæltet 34','København',NULL,'1734','Dinamarca'),(10643,1,6,'1997-08-25','1997-09-22','1997-09-02',2,29.4600,'Alfreds Futterkiste','Obere Str. 57','Berlín',NULL,'12209','Alemania'),(10644,88,3,'1997-08-25','1997-09-22','1997-09-01',2,0.1400,'Wellington Importadora','Rua do Mercado, 12','Resende','SP','08737-363','Brasil'),(10645,34,4,'1997-08-26','1997-09-23','1997-09-02',1,12.4100,'Hanari Carnes','Rua do Paço, 67','Río de Janeiro','RJ','05454-876','Brasil'),(10646,37,9,'1997-08-27','1997-10-08','1997-09-03',3,142.3300,'Hungry Owl All-Night Grocers','8 Johnstown Road','Cork','Co. Cork',NULL,'Irlanda'),(10647,61,4,'1997-08-27','1997-09-10','1997-09-03',2,45.5400,'Que Delícia','Rua da Panificadora, 12','Río de Janeiro','RJ','02389-673','Brasil'),(10648,67,5,'1997-08-28','1997-10-09','1997-09-09',2,14.2500,'Ricardo Adocicados','Av. Copacabana, 267','Río de Janeiro','RJ','02389-890','Brasil'),(10649,50,5,'1997-08-28','1997-09-25','1997-08-29',3,6.2000,'Maison Dewey','Rue Joseph-Bens 532','Bruxelles',NULL,'B-1180','Bélgica'),(10650,21,5,'1997-08-29','1997-09-26','1997-09-03',3,176.8100,'Familia Arquibaldo','Rua Orós, 92','São Paulo','SP','05442-030','Brasil'),(10651,86,8,'1997-09-01','1997-09-29','1997-09-11',2,20.6000,'Die Wandernde Kuh','Adenauerallee 900','Stuttgart',NULL,'70563','Alemania'),(10652,31,4,'1997-09-01','1997-09-29','1997-09-08',2,7.1400,'Gourmet Lanchonetes','Av. Brasil, 442','Campinas','SP','04876-786','Brasil'),(10653,25,1,'1997-09-02','1997-09-30','1997-09-19',1,93.2500,'Frankenversand','Berliner Platz 43','München',NULL,'80805','Alemania'),(10654,5,5,'1997-09-02','1997-09-30','1997-09-11',1,55.2600,'Berglunds snabbköp','Berguvsvägen  8','Luleå',NULL,'S-958 22','Suecia'),(10655,66,1,'1997-09-03','1997-10-01','1997-09-11',2,4.4100,'Reggiani Caseifici','Strada Provinciale 124','Reggio Emilia',NULL,'42100','Italia'),(10656,32,6,'1997-09-04','1997-10-02','1997-09-10',1,57.1500,'Great Lakes Food Market','2732 Baker Blvd.','Eugene','OR','97403','Estados Unidos'),(10657,71,2,'1997-09-04','1997-10-02','1997-09-15',2,352.6900,'Save-a-lot Markets','187 Suffolk Ln.','Boise','ID','83720','Estados Unidos'),(10658,63,4,'1997-09-05','1997-10-03','1997-09-08',1,364.1500,'QUICK-Stop','Taucherstraße 10','Cunewalde',NULL,'01307','Alemania'),(10659,62,7,'1997-09-05','1997-10-03','1997-09-10',2,105.8100,'Queen Cozinha','Alameda dos Canàrios, 891','São Paulo','SP','05487-020','Brasil'),(10660,36,8,'1997-09-08','1997-10-06','1997-10-15',1,111.2900,'Hungry Coyote Import Store','City Center Plaza\r\n516 Main St.','Elgin','OR','97827','Estados Unidos'),(10661,37,7,'1997-09-09','1997-10-07','1997-09-15',3,17.5500,'Hungry Owl All-Night Grocers','8 Johnstown Road','Cork','Co. Cork',NULL,'Irlanda'),(10662,48,3,'1997-09-09','1997-10-07','1997-09-18',2,1.2800,'Lonesome Pine Restaurant','89 Chiaroscuro Rd.','Portland','OR','97219','Estados Unidos'),(10663,9,2,'1997-09-10','1997-09-24','1997-10-03',2,113.1500,'Bon app\'','12, rue des Bouchers','Marseille',NULL,'13008','Francia'),(10664,28,1,'1997-09-10','1997-10-08','1997-09-19',3,1.2700,'Furia Bacalhau e Frutos do Mar','Jardim das rosas n. 32','Lisboa',NULL,'1675','Portugal'),(10665,48,1,'1997-09-11','1997-10-09','1997-09-17',2,26.3100,'Lonesome Pine Restaurant','89 Chiaroscuro Rd.','Portland','OR','97219','Estados Unidos'),(10666,68,7,'1997-09-12','1997-10-10','1997-09-22',2,232.4200,'Richter Supermarkt','Starenweg 5','Genève',NULL,'1204','Suiza'),(10667,20,7,'1997-09-12','1997-10-10','1997-09-19',1,78.0900,'Ernst Handel','Kirchgasse 6','Graz',NULL,'8010','Austria'),(10668,86,1,'1997-09-15','1997-10-13','1997-09-23',2,47.2200,'Die Wandernde Kuh','Adenauerallee 900','Stuttgart',NULL,'70563','Alemania'),(10669,73,2,'1997-09-15','1997-10-13','1997-09-22',1,24.3900,'Simons bistro','Vinbæltet 34','København',NULL,'1734','Dinamarca'),(10670,25,4,'1997-09-16','1997-10-14','1997-09-18',1,203.4800,'Frankenversand','Berliner Platz 43','München',NULL,'80805','Alemania'),(10671,26,1,'1997-09-17','1997-10-15','1997-09-24',1,30.3400,'France restauration','54, rue Royale','Nantes',NULL,'44000','Francia'),(10672,5,9,'1997-09-17','1997-10-01','1997-09-26',2,95.7500,'Berglunds snabbköp','Berguvsvägen  8','Luleå',NULL,'S-958 22','Suecia'),(10674,38,4,'1997-09-18','1997-10-16','1997-09-30',2,0.9000,'Island Trading','Garden House\r\nCrowther Way','Cowes','Isle of Wight','PO31 7PJ','Reino Unido'),(10675,25,5,'1997-09-19','1997-10-17','1997-09-23',2,31.8500,'Frankenversand','Berliner Platz 43','München',NULL,'80805','Alemania'),(10676,80,2,'1997-09-22','1997-10-20','1997-09-29',2,2.0100,'Tortuga Restaurante','Avda. Azteca 123','México D.F.',NULL,'05033','México'),(10677,3,1,'1997-09-22','1997-10-20','1997-09-26',3,4.0300,'Antonio Moreno Taquería','Mataderos  2312','México D.F.',NULL,'05023','México'),(10678,71,7,'1997-09-23','1997-10-21','1997-10-16',3,388.9800,'Save-a-lot Markets','187 Suffolk Ln.','Boise','ID','83720','Estados Unidos'),(10679,7,8,'1997-09-23','1997-10-21','1997-09-30',3,27.9400,'Blondel père et fils','24, place Kléber','Strasbourg',NULL,'67000','Francia'),(10680,55,1,'1997-09-24','1997-10-22','1997-09-26',1,26.6100,'Old World Delicatessen','2743 Bering St.','Anchorage','AK','99508','Estados Unidos'),(10681,32,3,'1997-09-25','1997-10-23','1997-09-30',3,76.1300,'Great Lakes Food Market','2732 Baker Blvd.','Eugene','OR','97403','Estados Unidos'),(10682,3,3,'1997-09-25','1997-10-23','1997-10-01',2,36.1300,'Antonio Moreno Taquería','Mataderos  2312','México D.F.',NULL,'05023','México'),(10683,18,2,'1997-09-26','1997-10-24','1997-10-01',1,4.4000,'Du monde entier','67, rue des Cinquante Otages','Nantes',NULL,'44000','Francia'),(10684,56,3,'1997-09-26','1997-10-24','1997-09-30',1,145.6300,'Ottilies Käseladen','Mehrheimerstr. 369','Köln',NULL,'50739','Alemania'),(10685,31,4,'1997-09-29','1997-10-13','1997-10-03',2,33.7500,'Gourmet Lanchonetes','Av. Brasil, 442','Campinas','SP','04876-786','Brasil'),(10686,59,2,'1997-09-30','1997-10-28','1997-10-08',1,96.5000,'Piccolo und mehr','Geislweg 14','Salzburg',NULL,'5020','Austria'),(10687,37,9,'1997-09-30','1997-10-28','1997-10-30',2,296.4300,'Hungry Owl All-Night Grocers','8 Johnstown Road','Cork','Co. Cork',NULL,'Irlanda'),(10688,83,4,'1997-10-01','1997-10-15','1997-10-07',2,299.0900,'Vaffeljernet','Smagsløget 45','Århus',NULL,'8200','Dinamarca'),(10689,5,1,'1997-10-01','1997-10-29','1997-10-07',2,13.4200,'Berglunds snabbköp','Berguvsvägen  8','Luleå',NULL,'S-958 22','Suecia'),(10690,34,1,'1997-10-02','1997-10-30','1997-10-03',1,15.8000,'Hanari Carnes','Rua do Paço, 67','Río de Janeiro','RJ','05454-876','Brasil'),(10691,63,2,'1997-10-03','1997-11-14','1997-10-22',2,810.0500,'QUICK-Stop','Taucherstraße 10','Cunewalde',NULL,'01307','Alemania'),(10692,1,4,'1997-10-03','1997-10-31','1997-10-13',2,61.0200,'Alfreds Futterkiste','Obere Str. 57','Berlín',NULL,'12209','Alemania'),(10693,89,3,'1997-10-06','1997-10-20','1997-10-10',3,139.3400,'White Clover Markets','1029 - 12th Ave. S.','Seattle','WA','98124','Estados Unidos'),(10694,63,8,'1997-10-06','1997-11-03','1997-10-09',3,398.3600,'QUICK-Stop','Taucherstraße 10','Cunewalde',NULL,'01307','Alemania'),(10696,89,8,'1997-10-08','1997-11-19','1997-10-14',3,102.5500,'White Clover Markets','1029 - 12th Ave. S.','Seattle','WA','98124','Estados Unidos'),(10697,47,3,'1997-10-08','1997-11-05','1997-10-14',1,45.5200,'LINO-Delicateses','Ave. 5 de Mayo Porlamar','I. de Margarita','Nueva Esparta','4980','Venezuela'),(10698,20,4,'1997-10-09','1997-11-06','1997-10-17',1,272.4700,'Ernst Handel','Kirchgasse 6','Graz',NULL,'8010','Austria'),(10699,52,3,'1997-10-09','1997-11-06','1997-10-13',3,0.5800,'Morgenstern Gesundkost','Heerstr. 22','Leipzig',NULL,'04179','Alemania'),(10700,71,3,'1997-10-10','1997-11-07','1997-10-16',1,65.1000,'Save-a-lot Markets','187 Suffolk Ln.','Boise','ID','83720','Estados Unidos'),(10701,37,6,'1997-10-13','1997-10-27','1997-10-15',3,220.3100,'Hungry Owl All-Night Grocers','8 Johnstown Road','Cork','Co. Cork',NULL,'Irlanda'),(10702,1,4,'1997-10-13','1997-11-24','1997-10-21',1,23.9400,'Alfreds Futterkiste','Obere Str. 57','Berlín',NULL,'12209','Alemania'),(10703,24,6,'1997-10-14','1997-11-11','1997-10-20',2,152.3000,'Folk och fä HB','Åkergatan 24','Bräcke',NULL,'S-844 67','Suecia'),(10704,62,6,'1997-10-14','1997-11-11','1997-11-07',1,4.7800,'Queen Cozinha','Alameda dos Canàrios, 891','São Paulo','SP','05487-020','Brasil'),(10705,35,9,'1997-10-15','1997-11-12','1997-11-18',2,3.5200,'HILARIÓN-Abastos','Carrera 22 con Ave. Carlos Soublette #8-35','San Cristóbal','Táchira','5022','Venezuela'),(10706,55,8,'1997-10-16','1997-11-13','1997-10-21',3,135.6300,'Old World Delicatessen','2743 Bering St.','Anchorage','AK','99508','Estados Unidos'),(10707,4,4,'1997-10-16','1997-10-30','1997-10-23',3,21.7400,'Around the Horn','Brook Farm\r\nStratford St. Mary','Colchester','Essex','CO7 6JX','Reino Unido'),(10708,77,6,'1997-10-17','1997-11-28','1997-11-05',2,2.9600,'The Big Cheese','89 Jefferson Way\r\nSuite 2','Portland','OR','97201','Estados Unidos'),(10709,31,1,'1997-10-17','1997-11-14','1997-11-20',3,210.8000,'Gourmet Lanchonetes','Av. Brasil, 442','Campinas','SP','04876-786','Brasil'),(10710,27,1,'1997-10-20','1997-11-17','1997-10-23',1,4.9800,'Franchi S.p.A.','Via Monte Bianco 34','Torino',NULL,'10100','Italia'),(10711,71,5,'1997-10-21','1997-12-02','1997-10-29',2,52.4100,'Save-a-lot Markets','187 Suffolk Ln.','Boise','ID','83720','Estados Unidos'),(10712,37,3,'1997-10-21','1997-11-18','1997-10-31',1,89.9300,'Hungry Owl All-Night Grocers','8 Johnstown Road','Cork','Co. Cork',NULL,'Irlanda'),(10713,71,1,'1997-10-22','1997-11-19','1997-10-24',1,167.0500,'Save-a-lot Markets','187 Suffolk Ln.','Boise','ID','83720','Estados Unidos'),(10714,71,5,'1997-10-22','1997-11-19','1997-10-27',3,24.4900,'Save-a-lot Markets','187 Suffolk Ln.','Boise','ID','83720','Estados Unidos'),(10715,9,3,'1997-10-23','1997-11-06','1997-10-29',1,63.2000,'Bon app\'','12, rue des Bouchers','Marseille',NULL,'13008','Francia'),(10716,64,4,'1997-10-24','1997-11-21','1997-10-27',2,22.5700,'Rancho grande','Av. del Libertador 900','Buenos Aires',NULL,'1010','Argentina'),(10717,25,1,'1997-10-24','1997-11-21','1997-10-29',2,59.2500,'Frankenversand','Berliner Platz 43','München',NULL,'80805','Alemania'),(10718,39,1,'1997-10-27','1997-11-24','1997-10-29',3,170.8800,'Königlich Essen','Maubelstr. 90','Brandenburg',NULL,'14776','Alemania'),(10719,45,8,'1997-10-27','1997-11-24','1997-11-05',2,51.4400,'Let\'s Stop N Shop','87 Polk St.\r\nSuite 5','San Francisco','CA','94117','Estados Unidos'),(10720,61,8,'1997-10-28','1997-11-11','1997-11-05',2,9.5300,'Que Delícia','Rua da Panificadora, 12','Río de Janeiro','RJ','02389-673','Brasil'),(10721,63,5,'1997-10-29','1997-11-26','1997-10-31',3,48.9200,'QUICK-Stop','Taucherstraße 10','Cunewalde',NULL,'01307','Alemania'),(10722,71,8,'1997-10-29','1997-12-10','1997-11-04',1,74.5800,'Save-a-lot Markets','187 Suffolk Ln.','Boise','ID','83720','Estados Unidos'),(10723,89,3,'1997-10-30','1997-11-27','1997-11-25',1,21.7200,'White Clover Markets','1029 - 12th Ave. S.','Seattle','WA','98124','Estados Unidos'),(10724,51,8,'1997-10-30','1997-12-11','1997-11-05',2,57.7500,'Mère Paillarde','43 rue St. Laurent','Montréal','Québec','H1J 1C3','Canadá'),(10725,21,4,'1997-10-31','1997-11-28','1997-11-05',3,10.8300,'Familia Arquibaldo','Rua Orós, 92','São Paulo','SP','05442-030','Brasil'),(10726,19,4,'1997-11-03','1997-11-17','1997-12-05',1,16.5600,'Eastern Connection','35 King George','London',NULL,'WX3 6FW','Reino Unido'),(10727,66,2,'1997-11-03','1997-12-01','1997-12-05',1,89.9000,'Reggiani Caseifici','Strada Provinciale 124','Reggio Emilia',NULL,'42100','Italia'),(10728,62,4,'1997-11-04','1997-12-02','1997-11-11',2,58.3300,'Queen Cozinha','Alameda dos Canàrios, 891','São Paulo','SP','05487-020','Brasil'),(10729,47,8,'1997-11-04','1997-12-16','1997-11-14',3,141.0600,'LINO-Delicateses','Ave. 5 de Mayo Porlamar','I. de Margarita','Nueva Esparta','4980','Venezuela'),(10730,9,5,'1997-11-05','1997-12-03','1997-11-14',1,20.1200,'Bon app\'','12, rue des Bouchers','Marseille',NULL,'13008','Francia'),(10731,16,7,'1997-11-06','1997-12-04','1997-11-14',1,96.6500,'Chop-suey Chinese','Hauptstr. 31','Bern',NULL,'3012','Suiza'),(10732,9,3,'1997-11-06','1997-12-04','1997-11-07',1,16.9700,'Bon app\'','12, rue des Bouchers','Marseille',NULL,'13008','Francia'),(10733,5,1,'1997-11-07','1997-12-05','1997-11-10',3,110.1100,'Berglunds snabbköp','Berguvsvägen  8','Luleå',NULL,'S-958 22','Suecia'),(10734,31,2,'1997-11-07','1997-12-05','1997-11-12',3,1.6300,'Gourmet Lanchonetes','Av. Brasil, 442','Campinas','SP','04876-786','Brasil'),(10735,45,6,'1997-11-10','1997-12-08','1997-11-21',2,45.9700,'Let\'s Stop N Shop','87 Polk St.\r\nSuite 5','San Francisco','CA','94117','Estados Unidos'),(10736,37,9,'1997-11-11','1997-12-09','1997-11-21',2,44.1000,'Hungry Owl All-Night Grocers','8 Johnstown Road','Cork','Co. Cork',NULL,'Irlanda'),(10737,85,2,'1997-11-11','1997-12-09','1997-11-18',2,7.7900,'Vins et alcools Chevalier','59 rue de l\'Abbaye','Reims',NULL,'51100','Francia'),(10738,74,2,'1997-11-12','1997-12-10','1997-11-18',1,2.9100,'Spécialités du monde','25, rue Lauriston','Paris',NULL,'75016','Francia'),(10739,85,3,'1997-11-12','1997-12-10','1997-11-17',3,11.0800,'Vins et alcools Chevalier','59 rue de l\'Abbaye','Reims',NULL,'51100','Francia'),(10740,89,4,'1997-11-13','1997-12-11','1997-11-25',2,81.8800,'White Clover Markets','1029 - 12th Ave. S.','Seattle','WA','98124','Estados Unidos'),(10741,5,4,'1997-11-14','1997-11-28','1997-11-18',3,10.9600,'Berglunds snabbköp','Berguvsvägen  8','Luleå',NULL,'S-958 22','Suecia'),(10742,10,3,'1997-11-14','1997-12-12','1997-11-18',3,243.7300,'Bottom-Dollar Markets','23 Tsawassen Blvd.','Tsawassen','BC','T2F 8M4','Canadá'),(10743,4,1,'1997-11-17','1997-12-15','1997-11-21',2,23.7200,'Around the Horn','Brook Farm\r\nStratford St. Mary','Colchester','Essex','CO7 6JX','Reino Unido'),(10744,83,6,'1997-11-17','1997-12-15','1997-11-24',1,69.1900,'Vaffeljernet','Smagsløget 45','Århus',NULL,'8200','Dinamarca'),(10745,63,9,'1997-11-18','1997-12-16','1997-11-27',1,3.5200,'QUICK-Stop','Taucherstraße 10','Cunewalde',NULL,'01307','Alemania'),(10746,16,1,'1997-11-19','1997-12-17','1997-11-21',3,31.4300,'Chop-suey Chinese','Hauptstr. 31','Bern',NULL,'3012','Suiza'),(10747,59,6,'1997-11-19','1997-12-17','1997-11-26',1,117.3300,'Piccolo und mehr','Geislweg 14','Salzburg',NULL,'5020','Austria'),(10748,71,3,'1997-11-20','1997-12-18','1997-11-28',1,232.5500,'Save-a-lot Markets','187 Suffolk Ln.','Boise','ID','83720','Estados Unidos'),(10749,38,4,'1997-11-20','1997-12-18','1997-12-19',2,61.5300,'Island Trading','Garden House\r\nCrowther Way','Cowes','Isle of Wight','PO31 7PJ','Reino Unido'),(10750,87,9,'1997-11-21','1997-12-19','1997-11-24',1,79.3000,'Wartian Herkku','Torikatu 38','Oulu',NULL,'90110','Finlandia'),(10751,68,3,'1997-11-24','1997-12-22','1997-12-03',3,130.7900,'Richter Supermarkt','Starenweg 5','Genève',NULL,'1204','Suiza'),(10752,53,2,'1997-11-24','1997-12-22','1997-11-28',3,1.3900,'North/South','South House\r\n300 Queensbridge','London',NULL,'SW7 1RZ','Reino Unido'),(10753,27,3,'1997-11-25','1997-12-23','1997-11-27',1,7.7000,'Franchi S.p.A.','Via Monte Bianco 34','Torino',NULL,'10100','Italia'),(10754,49,6,'1997-11-25','1997-12-23','1997-11-27',3,2.3800,'Magazzini Alimentari Riuniti','Via Ludovico il Moro 22','Bérgamo',NULL,'24100','Italia'),(10755,9,4,'1997-11-26','1997-12-24','1997-11-28',2,16.7100,'Bon app\'','12, rue des Bouchers','Marseille',NULL,'13008','Francia'),(10756,75,8,'1997-11-27','1997-12-25','1997-12-02',2,73.2100,'Split Rail Beer & Ale','P.O. Box 555','Lander','WY','82520','Estados Unidos'),(10757,71,6,'1997-11-27','1997-12-25','1997-12-15',1,8.1900,'Save-a-lot Markets','187 Suffolk Ln.','Boise','ID','83720','Estados Unidos'),(10758,68,3,'1997-11-28','1997-12-26','1997-12-04',3,138.1700,'Richter Supermarkt','Starenweg 5','Genève',NULL,'1204','Suiza'),(10759,2,3,'1997-11-28','1997-12-26','1997-12-12',3,11.9900,'Ana Trujillo Emparedados y helados','Avda. de la Constitución 2222','México D.F.',NULL,'05021','México'),(10760,50,4,'1997-12-01','1997-12-29','1997-12-10',1,155.6400,'Maison Dewey','Rue Joseph-Bens 532','Bruxelles',NULL,'B-1180','Bélgica'),(10761,65,5,'1997-12-02','1997-12-30','1997-12-08',2,18.6600,'Rattlesnake Canyon Grocery','2817 Milton Dr.','Albuquerque','NM','87110','Estados Unidos'),(10762,24,3,'1997-12-02','1997-12-30','1997-12-09',1,328.7400,'Folk och fä HB','Åkergatan 24','Bräcke',NULL,'S-844 67','Suecia'),(10763,23,3,'1997-12-03','1997-12-31','1997-12-08',3,37.3500,'Folies gourmandes','184, chaussée de Tournai','Lille',NULL,'59000','Francia'),(10764,20,6,'1997-12-03','1997-12-31','1997-12-08',3,145.4500,'Ernst Handel','Kirchgasse 6','Graz',NULL,'8010','Austria'),(10765,63,3,'1997-12-04','1998-01-01','1997-12-09',3,42.7400,'QUICK-Stop','Taucherstraße 10','Cunewalde',NULL,'01307','Alemania'),(10766,56,4,'1997-12-05','1998-01-02','1997-12-09',1,157.5500,'Ottilies Käseladen','Mehrheimerstr. 369','Köln',NULL,'50739','Alemania'),(10767,76,4,'1997-12-05','1998-01-02','1997-12-15',3,1.5900,'Suprêmes délices','Boulevard Tirou, 255','Charleroi',NULL,'B-6000','Bélgica'),(10768,4,3,'1997-12-08','1998-01-05','1997-12-15',2,146.3200,'Around the Horn','Brook Farm\r\nStratford St. Mary','Colchester','Essex','CO7 6JX','Reino Unido'),(10769,83,3,'1997-12-08','1998-01-05','1997-12-12',1,65.0600,'Vaffeljernet','Smagsløget 45','Århus',NULL,'8200','Dinamarca'),(10770,34,8,'1997-12-09','1998-01-06','1997-12-17',3,5.3200,'Hanari Carnes','Rua do Paço, 67','Río de Janeiro','RJ','05454-876','Brasil'),(10771,20,9,'1997-12-10','1998-01-07','1998-01-02',2,11.1900,'Ernst Handel','Kirchgasse 6','Graz',NULL,'8010','Austria'),(10772,44,3,'1997-12-10','1998-01-07','1997-12-19',2,91.2800,'Lehmanns Marktstand','Magazinweg 7','Frankfurt a.M. ',NULL,'60528','Alemania'),(10773,20,1,'1997-12-11','1998-01-08','1997-12-16',3,96.4300,'Ernst Handel','Kirchgasse 6','Graz',NULL,'8010','Austria'),(10774,24,4,'1997-12-11','1997-12-25','1997-12-12',1,48.2000,'Folk och fä HB','Åkergatan 24','Bräcke',NULL,'S-844 67','Suecia'),(10775,78,7,'1997-12-12','1998-01-09','1997-12-26',1,20.2500,'The Cracker Box','55 Grizzly Peak Rd.','Butte','MT','59801','Estados Unidos'),(10776,20,1,'1997-12-15','1998-01-12','1997-12-18',3,351.5300,'Ernst Handel','Kirchgasse 6','Graz',NULL,'8010','Austria'),(10777,31,7,'1997-12-15','1997-12-29','1998-01-21',2,3.0100,'Gourmet Lanchonetes','Av. Brasil, 442','Campinas','SP','04876-786','Brasil'),(10778,5,3,'1997-12-16','1998-01-13','1997-12-24',1,6.7900,'Berglunds snabbköp','Berguvsvägen  8','Luleå',NULL,'S-958 22','Suecia'),(10779,52,3,'1997-12-16','1998-01-13','1998-01-14',2,58.1300,'Morgenstern Gesundkost','Heerstr. 22','Leipzig',NULL,'04179','Alemania'),(10780,46,2,'1997-12-16','1997-12-30','1997-12-25',1,42.1300,'LILA-Supermercado','Carrera 52 con Ave. Bolívar #65-98 Llano Largo','Barquisimeto','Lara','3508','Venezuela'),(10781,87,2,'1997-12-17','1998-01-14','1997-12-19',3,73.1600,'Wartian Herkku','Torikatu 38','Oulu',NULL,'90110','Finlandia'),(10782,12,9,'1997-12-17','1998-01-14','1997-12-22',3,1.1000,'Cactus Comidas para llevar','Cerrito 333','Buenos Aires',NULL,'1010','Argentina'),(10783,34,4,'1997-12-18','1998-01-15','1997-12-19',2,124.9800,'Hanari Carnes','Rua do Paço, 67','Río de Janeiro','RJ','05454-876','Brasil'),(10784,49,4,'1997-12-18','1998-01-15','1997-12-22',3,70.0900,'Magazzini Alimentari Riuniti','Via Ludovico il Moro 22','Bérgamo',NULL,'24100','Italia'),(10785,33,1,'1997-12-18','1998-01-15','1997-12-24',3,1.5100,'GROSELLA-Restaurante','5ª Ave. Los Palos Grandes','Caracas','DF','1081','Venezuela'),(10786,62,8,'1997-12-19','1998-01-16','1997-12-23',1,110.8700,'Queen Cozinha','Alameda dos Canàrios, 891','São Paulo','SP','05487-020','Brasil'),(10787,41,2,'1997-12-19','1998-01-02','1997-12-26',1,249.9300,'La maison d\'Asie','1 rue Alsace-Lorraine','Toulouse',NULL,'31000','Francia'),(10788,63,1,'1997-12-22','1998-01-19','1998-01-19',2,42.7000,'QUICK-Stop','Taucherstraße 10','Cunewalde',NULL,'01307','Alemania'),(10789,23,1,'1997-12-22','1998-01-19','1997-12-31',2,100.6000,'Folies gourmandes','184, chaussée de Tournai','Lille',NULL,'59000','Francia'),(10790,31,6,'1997-12-22','1998-01-19','1997-12-26',1,28.2300,'Gourmet Lanchonetes','Av. Brasil, 442','Campinas','SP','04876-786','Brasil'),(10791,25,6,'1997-12-23','1998-01-20','1998-01-01',2,16.8500,'Frankenversand','Berliner Platz 43','München',NULL,'80805','Alemania'),(10792,91,1,'1997-12-23','1998-01-20','1997-12-31',3,23.7900,'Wolski Zajazd','ul. Filtrowa 68','Warszawa',NULL,'01-012','Polonia'),(10793,4,3,'1997-12-24','1998-01-21','1998-01-08',3,4.5200,'Around the Horn','Brook Farm\r\nStratford St. Mary','Colchester','Essex','CO7 6JX','Reino Unido'),(10794,61,6,'1997-12-24','1998-01-21','1998-01-02',1,21.4900,'Que Delícia','Rua da Panificadora, 12','Río de Janeiro','RJ','02389-673','Brasil'),(10795,20,8,'1997-12-24','1998-01-21','1998-01-20',2,126.6600,'Ernst Handel','Kirchgasse 6','Graz',NULL,'8010','Austria'),(10796,35,3,'1997-12-25','1998-01-22','1998-01-14',1,26.5200,'HILARIÓN-Abastos','Carrera 22 con Ave. Carlos Soublette #8-35','San Cristóbal','Táchira','5022','Venezuela'),(10797,17,7,'1997-12-25','1998-01-22','1998-01-05',2,33.3500,'Drachenblut Delikatessen','Walserweg 21','Aachen',NULL,'52066','Alemania'),(10798,38,2,'1997-12-26','1998-01-23','1998-01-05',1,2.3300,'Island Trading','Garden House\r\nCrowther Way','Cowes','Isle of Wight','PO31 7PJ','Reino Unido'),(10799,39,9,'1997-12-26','1998-02-06','1998-01-05',3,30.7600,'Königlich Essen','Maubelstr. 90','Brandenburg',NULL,'14776','Alemania'),(10800,72,1,'1997-12-26','1998-01-23','1998-01-05',3,137.4400,'Seven Seas Imports','90 Wadhurst Rd.','London',NULL,'OX15 4NB','Reino Unido'),(10801,8,4,'1997-12-29','1998-01-26','1997-12-31',2,97.0900,'Bólido Comidas preparadas','C/ Araquil, 67','Madrid',NULL,'28023','España'),(10802,73,4,'1997-12-29','1998-01-26','1998-01-02',2,257.2600,'Simons bistro','Vinbæltet 34','København',NULL,'1734','Dinamarca'),(10803,88,4,'1997-12-30','1998-01-27','1998-01-06',1,55.2300,'Wellington Importadora','Rua do Mercado, 12','Resende','SP','08737-363','Brasil'),(10804,72,6,'1997-12-30','1998-01-27','1998-01-07',2,27.3300,'Seven Seas Imports','90 Wadhurst Rd.','London',NULL,'OX15 4NB','Reino Unido'),(10805,77,2,'1997-12-30','1998-01-27','1998-01-09',3,237.3400,'The Big Cheese','89 Jefferson Way\r\nSuite 2','Portland','OR','97201','Estados Unidos'),(10806,84,3,'1997-12-31','1998-01-28','1998-01-05',2,22.1100,'Victuailles en stock','2, rue du Commerce','Lyon',NULL,'69004','Francia'),(10807,27,4,'1997-12-31','1998-01-28','1998-01-30',1,1.3600,'Franchi S.p.A.','Via Monte Bianco 34','Torino',NULL,'10100','Italia'),(10808,55,2,'1998-01-01','1998-01-29','1998-01-09',3,45.5300,'Old World Delicatessen','2743 Bering St.','Anchorage','AK','99508','Estados Unidos'),(10809,88,7,'1998-01-01','1998-01-29','1998-01-07',1,4.8700,'Wellington Importadora','Rua do Mercado, 12','Resende','SP','08737-363','Brasil'),(10810,42,2,'1998-01-01','1998-01-29','1998-01-07',3,4.3300,'Laughing Bacchus Wine Cellars','2319 Elm St.','Vancouver','BC','V3F 2K1','Canadá'),(10811,47,8,'1998-01-02','1998-01-30','1998-01-08',1,31.2200,'LINO-Delicateses','Ave. 5 de Mayo Porlamar','I. de Margarita','Nueva Esparta','4980','Venezuela'),(10812,66,5,'1998-01-02','1998-01-30','1998-01-12',1,59.7800,'Reggiani Caseifici','Strada Provinciale 124','Reggio Emilia',NULL,'42100','Italia'),(10813,67,1,'1998-01-05','1998-02-02','1998-01-09',1,47.3800,'Ricardo Adocicados','Av. Copacabana, 267','Río de Janeiro','RJ','02389-890','Brasil'),(10814,84,3,'1998-01-05','1998-02-02','1998-01-14',3,130.9400,'Victuailles en stock','2, rue du Commerce','Lyon',NULL,'69004','Francia'),(10815,71,2,'1998-01-05','1998-02-02','1998-01-14',3,14.6200,'Save-a-lot Markets','187 Suffolk Ln.','Boise','ID','83720','Estados Unidos'),(10816,32,4,'1998-01-06','1998-02-03','1998-02-04',2,719.7800,'Great Lakes Food Market','2732 Baker Blvd.','Eugene','OR','97403','Estados Unidos'),(10817,39,3,'1998-01-06','1998-01-20','1998-01-13',2,306.0700,'Königlich Essen','Maubelstr. 90','Brandenburg',NULL,'14776','Alemania'),(10818,49,7,'1998-01-07','1998-02-04','1998-01-12',3,65.4800,'Magazzini Alimentari Riuniti','Via Ludovico il Moro 22','Bérgamo',NULL,'24100','Italia'),(10819,12,2,'1998-01-07','1998-02-04','1998-01-16',3,19.7600,'Cactus Comidas para llevar','Cerrito 333','Buenos Aires',NULL,'1010','Argentina'),(10820,65,3,'1998-01-07','1998-02-04','1998-01-13',2,37.5200,'Rattlesnake Canyon Grocery','2817 Milton Dr.','Albuquerque','NM','87110','Estados Unidos'),(10821,75,1,'1998-01-08','1998-02-05','1998-01-15',1,36.6800,'Split Rail Beer & Ale','P.O. Box 555','Lander','WY','82520','Estados Unidos'),(10822,82,6,'1998-01-08','1998-02-05','1998-01-16',3,7.0000,'Trail\'s Head Gourmet Provisioners','722 DaVinci Blvd.','Kirkland','WA','98034','Estados Unidos'),(10823,46,5,'1998-01-09','1998-02-06','1998-01-13',2,163.9700,'LILA-Supermercado','Carrera 52 con Ave. Bolívar #65-98 Llano Largo','Barquisimeto','Lara','3508','Venezuela'),(10824,24,8,'1998-01-09','1998-02-06','1998-01-30',1,1.2300,'Folk och fä HB','Åkergatan 24','Bräcke',NULL,'S-844 67','Suecia'),(10825,17,1,'1998-01-09','1998-02-06','1998-01-14',1,79.2500,'Drachenblut Delikatessen','Walserweg 21','Aachen',NULL,'52066','Alemania'),(10826,7,6,'1998-01-12','1998-02-09','1998-02-06',1,7.0900,'Blondel père et fils','24, place Kléber','Strasbourg',NULL,'67000','Francia'),(10827,9,1,'1998-01-12','1998-01-26','1998-02-06',2,63.5400,'Bon app\'','12, rue des Bouchers','Marseille',NULL,'13008','Francia'),(10828,64,9,'1998-01-13','1998-01-27','1998-02-04',1,90.8500,'Rancho grande','Av. del Libertador 900','Buenos Aires',NULL,'1010','Argentina'),(10829,38,9,'1998-01-13','1998-02-10','1998-01-23',1,154.7200,'Island Trading','Garden House\r\nCrowther Way','Cowes','Isle of Wight','PO31 7PJ','Reino Unido'),(10830,81,4,'1998-01-13','1998-02-24','1998-01-21',2,81.8300,'Tradição Hipermercados','Av. Inês de Castro, 414','São Paulo','SP','05634-030','Brasil'),(10831,70,3,'1998-01-14','1998-02-11','1998-01-23',2,72.1900,'Santé Gourmet','Erling Skakkes gate 78','Stavern',NULL,'4110','Noruega'),(10832,41,2,'1998-01-14','1998-02-11','1998-01-19',2,43.2600,'La maison d\'Asie','1 rue Alsace-Lorraine','Toulouse',NULL,'31000','Francia'),(10833,56,6,'1998-01-15','1998-02-12','1998-01-23',2,71.4900,'Ottilies Käseladen','Mehrheimerstr. 369','Köln',NULL,'50739','Alemania'),(10834,81,1,'1998-01-15','1998-02-12','1998-01-19',3,29.7800,'Tradição Hipermercados','Av. Inês de Castro, 414','São Paulo','SP','05634-030','Brasil'),(10835,1,1,'1998-01-15','1998-02-12','1998-01-21',3,69.5300,'Alfreds Futterkiste','Obere Str. 57','Berlín',NULL,'12209','Alemania'),(10836,20,7,'1998-01-16','1998-02-13','1998-01-21',1,411.8800,'Ernst Handel','Kirchgasse 6','Graz',NULL,'8010','Austria'),(10837,5,9,'1998-01-16','1998-02-13','1998-01-23',3,13.3200,'Berglunds snabbköp','Berguvsvägen  8','Luleå',NULL,'S-958 22','Suecia'),(10838,47,3,'1998-01-19','1998-02-16','1998-01-23',3,59.2800,'LINO-Delicateses','Ave. 5 de Mayo Porlamar','I. de Margarita','Nueva Esparta','4980','Venezuela'),(10839,81,3,'1998-01-19','1998-02-16','1998-01-22',3,35.4300,'Tradição Hipermercados','Av. Inês de Castro, 414','São Paulo','SP','05634-030','Brasil'),(10840,47,4,'1998-01-19','1998-03-02','1998-02-16',2,2.7100,'LINO-Delicateses','Ave. 5 de Mayo Porlamar','I. de Margarita','Nueva Esparta','4980','Venezuela'),(10841,76,5,'1998-01-20','1998-02-17','1998-01-29',2,424.3000,'Suprêmes délices','Boulevard Tirou, 255','Charleroi',NULL,'B-6000','Bélgica'),(10842,80,1,'1998-01-20','1998-02-17','1998-01-29',3,54.4200,'Tortuga Restaurante','Avda. Azteca 123','México D.F.',NULL,'05033','México'),(10843,84,4,'1998-01-21','1998-02-18','1998-01-26',2,9.2600,'Victuailles en stock','2, rue du Commerce','Lyon',NULL,'69004','Francia'),(10844,59,8,'1998-01-21','1998-02-18','1998-01-26',2,25.2200,'Piccolo und mehr','Geislweg 14','Salzburg',NULL,'5020','Austria'),(10845,63,8,'1998-01-21','1998-02-04','1998-01-30',1,212.9800,'QUICK-Stop','Taucherstraße 10','Cunewalde',NULL,'01307','Alemania'),(10846,76,2,'1998-01-22','1998-03-05','1998-01-23',3,56.4600,'Suprêmes délices','Boulevard Tirou, 255','Charleroi',NULL,'B-6000','Bélgica'),(10847,71,4,'1998-01-22','1998-02-05','1998-02-10',3,487.5700,'Save-a-lot Markets','187 Suffolk Ln.','Boise','ID','83720','Estados Unidos'),(10848,15,7,'1998-01-23','1998-02-20','1998-01-29',2,38.2400,'Consolidated Holdings','Berkeley Gardens\r\n12  Brewery ','London',NULL,'WX1 6LT','Reino Unido'),(10849,39,9,'1998-01-23','1998-02-20','1998-01-30',2,0.5600,'Königlich Essen','Maubelstr. 90','Brandenburg',NULL,'14776','Alemania'),(10850,84,1,'1998-01-23','1998-03-06','1998-01-30',1,49.1900,'Victuailles en stock','2, rue du Commerce','Lyon',NULL,'69004','Francia'),(10851,67,5,'1998-01-26','1998-02-23','1998-02-02',1,160.5500,'Ricardo Adocicados','Av. Copacabana, 267','Río de Janeiro','RJ','02389-890','Brasil'),(10852,65,8,'1998-01-26','1998-02-09','1998-01-30',1,174.0500,'Rattlesnake Canyon Grocery','2817 Milton Dr.','Albuquerque','NM','87110','Estados Unidos'),(10853,6,9,'1998-01-27','1998-02-24','1998-02-03',2,53.8300,'Blauer See Delikatessen','Forsterstr. 57','Mannheim',NULL,'68306','Alemania'),(10854,20,3,'1998-01-27','1998-02-24','1998-02-05',2,100.2200,'Ernst Handel','Kirchgasse 6','Graz',NULL,'8010','Austria'),(10855,55,3,'1998-01-27','1998-02-24','1998-02-04',1,170.9700,'Old World Delicatessen','2743 Bering St.','Anchorage','AK','99508','Estados Unidos'),(10856,3,3,'1998-01-28','1998-02-25','1998-02-10',2,58.4300,'Antonio Moreno Taquería','Mataderos  2312','México D.F.',NULL,'05023','México'),(10857,5,8,'1998-01-28','1998-02-25','1998-02-06',2,188.8500,'Berglunds snabbköp','Berguvsvägen  8','Luleå',NULL,'S-958 22','Suecia'),(10858,40,2,'1998-01-29','1998-02-26','1998-02-03',1,52.5100,'La corne d\'abondance','67, avenue de l\'Europe','Versailles',NULL,'78000','Francia'),(10859,25,1,'1998-01-29','1998-02-26','1998-02-02',2,76.1000,'Frankenversand','Berliner Platz 43','München',NULL,'80805','Alemania'),(10860,26,3,'1998-01-29','1998-02-26','1998-02-04',3,19.2600,'France restauration','54, rue Royale','Nantes',NULL,'44000','Francia'),(10861,89,4,'1998-01-30','1998-02-27','1998-02-17',2,14.9300,'White Clover Markets','1029 - 12th Ave. S.','Seattle','WA','98124','Estados Unidos'),(10862,44,8,'1998-01-30','1998-03-13','1998-02-02',2,53.2300,'Lehmanns Marktstand','Magazinweg 7','Frankfurt a.M. ',NULL,'60528','Alemania'),(10863,35,4,'1998-02-02','1998-03-02','1998-02-17',2,30.2600,'HILARIÓN-Abastos','Carrera 22 con Ave. Carlos Soublette #8-35','San Cristóbal','Táchira','5022','Venezuela'),(10864,4,4,'1998-02-02','1998-03-02','1998-02-09',2,3.0400,'Around the Horn','Brook Farm\r\nStratford St. Mary','Colchester','Essex','CO7 6JX','Reino Unido'),(10865,63,2,'1998-02-02','1998-02-16','1998-02-12',1,348.1400,'QUICK-Stop','Taucherstraße 10','Cunewalde',NULL,'01307','Alemania'),(10866,5,5,'1998-02-03','1998-03-03','1998-02-12',1,109.1100,'Berglunds snabbköp','Berguvsvägen  8','Luleå',NULL,'S-958 22','Suecia'),(10867,48,6,'1998-02-03','1998-03-17','1998-02-11',1,1.9300,'Lonesome Pine Restaurant','89 Chiaroscuro Rd.','Portland','OR','97219','Estados Unidos'),(10868,62,7,'1998-02-04','1998-03-04','1998-02-23',2,191.2700,'Queen Cozinha','Alameda dos Canàrios, 891','São Paulo','SP','05487-020','Brasil'),(10869,72,5,'1998-02-04','1998-03-04','1998-02-09',1,143.2800,'Seven Seas Imports','90 Wadhurst Rd.','London',NULL,'OX15 4NB','Reino Unido'),(10870,89,5,'1998-02-04','1998-03-04','1998-02-13',3,12.0400,'White Clover Markets','305 - 14th Ave. S.\r\nSuite 3B','Seattle','WA','98128','Estados Unidos'),(10871,9,9,'1998-02-05','1998-03-05','1998-02-10',2,112.2700,'Bon app\'','12, rue des Bouchers','Marseille',NULL,'13008','Francia'),(10872,30,5,'1998-02-05','1998-03-05','1998-02-09',2,175.3200,'Godos Cocina Típica','C/ Romero, 33','Sevilla',NULL,'41101','España'),(10874,30,5,'1998-02-06','1998-03-06','1998-02-11',2,19.5800,'Godos Cocina Típica','C/ Romero, 33','Sevilla',NULL,'41101','España'),(10875,5,4,'1998-02-06','1998-03-06','1998-03-03',2,32.3700,'Berglunds snabbköp','Berguvsvägen  8','Luleå',NULL,'S-958 22','Suecia'),(10876,9,7,'1998-02-09','1998-03-09','1998-02-12',3,60.4200,'Bon app\'','12, rue des Bouchers','Marseille',NULL,'13008','Francia'),(10877,67,1,'1998-02-09','1998-03-09','1998-02-19',1,38.0600,'Ricardo Adocicados','Av. Copacabana, 267','Río de Janeiro','RJ','02389-890','Brasil'),(10878,63,4,'1998-02-10','1998-03-10','1998-02-12',1,46.6900,'QUICK-Stop','Taucherstraße 10','Cunewalde',NULL,'01307','Alemania'),(10880,24,7,'1998-02-10','1998-03-24','1998-02-18',1,88.0100,'Folk och fä HB','Åkergatan 24','Bräcke',NULL,'S-844 67','Suecia'),(10881,12,4,'1998-02-11','1998-03-11','1998-02-18',1,2.8400,'Cactus Comidas para llevar','Cerrito 333','Buenos Aires',NULL,'1010','Argentina'),(10882,71,4,'1998-02-11','1998-03-11','1998-02-20',3,23.1000,'Save-a-lot Markets','187 Suffolk Ln.','Boise','ID','83720','Estados Unidos'),(10883,48,8,'1998-02-12','1998-03-12','1998-02-20',3,0.5300,'Lonesome Pine Restaurant','89 Chiaroscuro Rd.','Portland','OR','97219','Estados Unidos'),(10884,45,4,'1998-02-12','1998-03-12','1998-02-13',2,90.9700,'Let\'s Stop N Shop','87 Polk St.\r\nSuite 5','San Francisco','CA','94117','Estados Unidos'),(10885,76,6,'1998-02-12','1998-03-12','1998-02-18',3,5.6400,'Suprêmes délices','Boulevard Tirou, 255','Charleroi',NULL,'B-6000','Bélgica'),(10886,34,1,'1998-02-13','1998-03-13','1998-03-02',1,4.9900,'Hanari Carnes','Rua do Paço, 67','Río de Janeiro','RJ','05454-876','Brasil'),(10887,29,8,'1998-02-13','1998-03-13','1998-02-16',3,1.2500,'Galería del gastronómo','Rambla de Cataluña, 23','Barcelona',NULL,'8022','España'),(10888,30,1,'1998-02-16','1998-03-16','1998-02-23',2,51.8700,'Godos Cocina Típica','C/ Romero, 33','Sevilla',NULL,'41101','España'),(10889,65,9,'1998-02-16','1998-03-16','1998-02-23',3,280.6100,'Rattlesnake Canyon Grocery','2817 Milton Dr.','Albuquerque','NM','87110','Estados Unidos'),(10890,18,7,'1998-02-16','1998-03-16','1998-02-18',1,32.7600,'Du monde entier','67, rue des Cinquante Otages','Nantes',NULL,'44000','Francia'),(10891,44,7,'1998-02-17','1998-03-17','1998-02-19',2,20.3700,'Lehmanns Marktstand','Magazinweg 7','Frankfurt a.M. ',NULL,'60528','Alemania'),(10892,50,4,'1998-02-17','1998-03-17','1998-02-19',2,120.2700,'Maison Dewey','Rue Joseph-Bens 532','Bruxelles',NULL,'B-1180','Bélgica'),(10893,39,9,'1998-02-18','1998-03-18','1998-02-20',2,77.7800,'Königlich Essen','Maubelstr. 90','Brandenburg',NULL,'14776','Alemania'),(10894,71,1,'1998-02-18','1998-03-18','1998-02-20',1,116.1300,'Save-a-lot Markets','187 Suffolk Ln.','Boise','ID','83720','Estados Unidos'),(10895,20,3,'1998-02-18','1998-03-18','1998-02-23',1,162.7500,'Ernst Handel','Kirchgasse 6','Graz',NULL,'8010','Austria'),(10896,50,7,'1998-02-19','1998-03-19','1998-02-27',3,32.4500,'Maison Dewey','Rue Joseph-Bens 532','Bruxelles',NULL,'B-1180','Bélgica'),(10897,37,3,'1998-02-19','1998-03-19','1998-02-25',2,603.5400,'Hungry Owl All-Night Grocers','8 Johnstown Road','Cork','Co. Cork',NULL,'Irlanda'),(10898,54,4,'1998-02-20','1998-03-20','1998-03-06',2,1.2700,'Océano Atlántico Ltda.','Ing. Gustavo Moncada 8585\r\nPiso 20-A','Buenos Aires',NULL,'1010','Argentina'),(10899,46,5,'1998-02-20','1998-03-20','1998-02-26',3,1.2100,'LILA-Supermercado','Carrera 52 con Ave. Bolívar #65-98 Llano Largo','Barquisimeto','Lara','3508','Venezuela'),(10900,88,1,'1998-02-20','1998-03-20','1998-03-04',2,1.6600,'Wellington Importadora','Rua do Mercado, 12','Resende','SP','08737-363','Brasil'),(10901,35,4,'1998-02-23','1998-03-23','1998-02-26',1,62.0900,'HILARIÓN-Abastos','Carrera 22 con Ave. Carlos Soublette #8-35','San Cristóbal','Táchira','5022','Venezuela'),(10902,24,1,'1998-02-23','1998-03-23','1998-03-03',1,44.1500,'Folk och fä HB','Åkergatan 24','Bräcke',NULL,'S-844 67','Suecia'),(10903,34,3,'1998-02-24','1998-03-24','1998-03-04',3,36.7100,'Hanari Carnes','Rua do Paço, 67','Río de Janeiro','RJ','05454-876','Brasil'),(10904,89,3,'1998-02-24','1998-03-24','1998-02-27',3,162.9500,'White Clover Markets','1029 - 12th Ave. S.','Seattle','WA','98124','Estados Unidos'),(10905,88,9,'1998-02-24','1998-03-24','1998-03-06',2,13.7200,'Wellington Importadora','Rua do Mercado, 12','Resende','SP','08737-363','Brasil'),(10906,91,4,'1998-02-25','1998-03-11','1998-03-03',3,26.2900,'Wolski Zajazd','ul. Filtrowa 68','Warszawa',NULL,'01-012','Polonia'),(10907,74,6,'1998-02-25','1998-03-25','1998-02-27',3,9.1900,'Spécialités du monde','25, rue Lauriston','Paris',NULL,'75016','Francia'),(10908,66,4,'1998-02-26','1998-03-26','1998-03-06',2,32.9600,'Reggiani Caseifici','Strada Provinciale 124','Reggio Emilia',NULL,'42100','Italia'),(10909,70,1,'1998-02-26','1998-03-26','1998-03-10',2,53.0500,'Santé Gourmet','Erling Skakkes gate 78','Stavern',NULL,'4110','Noruega'),(10911,30,3,'1998-02-26','1998-03-26','1998-03-05',1,38.1900,'Godos Cocina Típica','C/ Romero, 33','Sevilla',NULL,'41101','España'),(10912,37,2,'1998-02-26','1998-03-26','1998-03-18',2,580.9100,'Hungry Owl All-Night Grocers','8 Johnstown Road','Cork','Co. Cork',NULL,'Irlanda'),(10913,62,4,'1998-02-26','1998-03-26','1998-03-04',1,33.0500,'Queen Cozinha','Alameda dos Canàrios, 891','São Paulo','SP','05487-020','Brasil'),(10914,62,6,'1998-02-27','1998-03-27','1998-03-02',1,21.1900,'Queen Cozinha','Alameda dos Canàrios, 891','São Paulo','SP','05487-020','Brasil'),(10915,80,2,'1998-02-27','1998-03-27','1998-03-02',2,3.5100,'Tortuga Restaurante','Avda. Azteca 123','México D.F.',NULL,'05033','México'),(10916,64,1,'1998-02-27','1998-03-27','1998-03-09',2,63.7700,'Rancho grande','Av. del Libertador 900','Buenos Aires',NULL,'1010','Argentina'),(10917,69,4,'1998-03-02','1998-03-30','1998-03-11',2,8.2900,'Romero y tomillo','Gran Vía, 1','Madrid',NULL,'28001','España'),(10918,10,3,'1998-03-02','1998-03-30','1998-03-11',3,48.8300,'Bottom-Dollar Markets','23 Tsawassen Blvd.','Tsawassen','BC','T2F 8M4','Canadá'),(10919,47,2,'1998-03-02','1998-03-30','1998-03-04',2,19.8000,'LINO-Delicateses','Ave. 5 de Mayo Porlamar','I. de Margarita','Nueva Esparta','4980','Venezuela'),(10920,4,4,'1998-03-03','1998-03-31','1998-03-09',2,29.6100,'Around the Horn','Brook Farm\r\nStratford St. Mary','Colchester','Essex','CO7 6JX','Reino Unido'),(10921,83,1,'1998-03-03','1998-04-14','1998-03-09',1,176.4800,'Vaffeljernet','Smagsløget 45','Århus',NULL,'8200','Dinamarca'),(10922,34,5,'1998-03-03','1998-03-31','1998-03-05',3,62.7400,'Hanari Carnes','Rua do Paço, 67','Río de Janeiro','RJ','05454-876','Brasil'),(10923,41,7,'1998-03-03','1998-04-14','1998-03-13',3,68.2600,'La maison d\'Asie','1 rue Alsace-Lorraine','Toulouse',NULL,'31000','Francia'),(10924,5,3,'1998-03-04','1998-04-01','1998-04-08',2,151.5200,'Berglunds snabbköp','Berguvsvägen  8','Luleå',NULL,'S-958 22','Suecia'),(10925,34,3,'1998-03-04','1998-04-01','1998-03-13',1,2.2700,'Hanari Carnes','Rua do Paço, 67','Río de Janeiro','RJ','05454-876','Brasil'),(10926,2,4,'1998-03-04','1998-04-01','1998-03-11',3,39.9200,'Ana Trujillo Emparedados y helados','Avda. de la Constitución 2222','México D.F.',NULL,'05021','México'),(10927,40,4,'1998-03-05','1998-04-02','1998-04-08',1,19.7900,'La corne d\'abondance','67, avenue de l\'Europe','Versailles',NULL,'78000','Francia'),(10928,29,1,'1998-03-05','1998-04-02','1998-03-18',1,1.3600,'Galería del gastronómo','Rambla de Cataluña, 23','Barcelona',NULL,'8022','España'),(10929,25,6,'1998-03-05','1998-04-02','1998-03-12',1,33.9300,'Frankenversand','Berliner Platz 43','München',NULL,'80805','Alemania'),(10930,76,4,'1998-03-06','1998-04-17','1998-03-18',3,15.5500,'Suprêmes délices','Boulevard Tirou, 255','Charleroi',NULL,'B-6000','Bélgica'),(10931,68,4,'1998-03-06','1998-03-20','1998-03-19',2,13.6000,'Richter Supermarkt','Starenweg 5','Genève',NULL,'1204','Suiza'),(10932,9,8,'1998-03-06','1998-04-03','1998-03-24',1,134.6400,'Bon app\'','12, rue des Bouchers','Marseille',NULL,'13008','Francia'),(10933,38,6,'1998-03-06','1998-04-03','1998-03-16',3,54.1500,'Island Trading','Garden House\r\nCrowther Way','Cowes','Isle of Wight','PO31 7PJ','Reino Unido'),(10934,44,3,'1998-03-09','1998-04-06','1998-03-12',3,32.0100,'Lehmanns Marktstand','Magazinweg 7','Frankfurt a.M. ',NULL,'60528','Alemania'),(10935,88,4,'1998-03-09','1998-04-06','1998-03-18',3,47.5900,'Wellington Importadora','Rua do Mercado, 12','Resende','SP','08737-363','Brasil'),(10936,32,3,'1998-03-09','1998-04-06','1998-03-18',2,33.6800,'Great Lakes Food Market','2732 Baker Blvd.','Eugene','OR','97403','Estados Unidos'),(10937,12,7,'1998-03-10','1998-03-24','1998-03-13',3,31.5100,'Cactus Comidas para llevar','Cerrito 333','Buenos Aires',NULL,'1010','Argentina'),(10938,63,3,'1998-03-10','1998-04-07','1998-03-16',2,31.8900,'QUICK-Stop','Taucherstraße 10','Cunewalde',NULL,'01307','Alemania'),(10939,49,2,'1998-03-10','1998-04-07','1998-03-13',2,76.3300,'Magazzini Alimentari Riuniti','Via Ludovico il Moro 22','Bérgamo',NULL,'24100','Italia'),(10940,9,8,'1998-03-11','1998-04-08','1998-03-23',3,19.7700,'Bon app\'','12, rue des Bouchers','Marseille',NULL,'13008','Francia'),(10941,71,7,'1998-03-11','1998-04-08','1998-03-20',2,400.8100,'Save-a-lot Markets','187 Suffolk Ln.','Boise','ID','83720','Estados Unidos'),(10942,66,9,'1998-03-11','1998-04-08','1998-03-18',3,17.9500,'Reggiani Caseifici','Strada Provinciale 124','Reggio Emilia',NULL,'42100','Italia'),(10943,11,4,'1998-03-11','1998-04-08','1998-03-19',2,2.1700,'B\'s Beverages','Fauntleroy Circus','London',NULL,'EC2 5NT','Reino Unido'),(10944,10,6,'1998-03-12','1998-03-26','1998-03-13',3,52.9200,'Bottom-Dollar Markets','23 Tsawassen Blvd.','Tsawassen','BC','T2F 8M4','Canadá'),(10945,52,4,'1998-03-12','1998-04-09','1998-03-18',1,10.2200,'Morgenstern Gesundkost','Heerstr. 22','Leipzig',NULL,'04179','Alemania'),(10946,83,1,'1998-03-12','1998-04-09','1998-03-19',2,27.2000,'Vaffeljernet','Smagsløget 45','Århus',NULL,'8200','Dinamarca'),(10947,11,3,'1998-03-13','1998-04-10','1998-03-16',2,3.2600,'B\'s Beverages','Fauntleroy Circus','London',NULL,'EC2 5NT','Reino Unido'),(10948,30,3,'1998-03-13','1998-04-10','1998-03-19',3,23.3900,'Godos Cocina Típica','C/ Romero, 33','Sevilla',NULL,'41101','España'),(10949,10,2,'1998-03-13','1998-04-10','1998-03-17',3,74.4400,'Bottom-Dollar Markets','23 Tsawassen Blvd.','Tsawassen','BC','T2F 8M4','Canadá'),(10950,49,1,'1998-03-16','1998-04-13','1998-03-23',2,2.5000,'Magazzini Alimentari Riuniti','Via Ludovico il Moro 22','Bérgamo',NULL,'24100','Italia'),(10951,68,9,'1998-03-16','1998-04-27','1998-04-07',2,30.8500,'Richter Supermarkt','Starenweg 5','Genève',NULL,'1204','Suiza'),(10952,1,1,'1998-03-16','1998-04-27','1998-03-24',1,40.4200,'Alfreds Futterkiste','Obere Str. 57','Berlín',NULL,'12209','Alemania'),(10953,4,9,'1998-03-16','1998-03-30','1998-03-25',2,23.7200,'Around the Horn','Brook Farm\r\nStratford St. Mary','Colchester','Essex','CO7 6JX','Reino Unido'),(10954,47,5,'1998-03-17','1998-04-28','1998-03-20',1,27.9100,'LINO-Delicateses','Ave. 5 de Mayo Porlamar','I. de Margarita','Nueva Esparta','4980','Venezuela'),(10955,24,8,'1998-03-17','1998-04-14','1998-03-20',2,3.2600,'Folk och fä HB','Åkergatan 24','Bräcke',NULL,'S-844 67','Suecia'),(10956,6,6,'1998-03-17','1998-04-28','1998-03-20',2,44.6500,'Blauer See Delikatessen','Forsterstr. 57','Mannheim',NULL,'68306','Alemania'),(10957,35,8,'1998-03-18','1998-04-15','1998-03-27',3,105.3600,'HILARIÓN-Abastos','Carrera 22 con Ave. Carlos Soublette #8-35','San Cristóbal','Táchira','5022','Venezuela'),(10958,54,7,'1998-03-18','1998-04-15','1998-03-27',2,49.5600,'Océano Atlántico Ltda.','Ing. Gustavo Moncada 8585\r\nPiso 20-A','Buenos Aires',NULL,'1010','Argentina'),(10959,31,6,'1998-03-18','1998-04-29','1998-03-23',2,4.9800,'Gourmet Lanchonetes','Av. Brasil, 442','Campinas','SP','04876-786','Brasil'),(10960,35,3,'1998-03-19','1998-04-02','1998-04-08',1,2.0800,'HILARIÓN-Abastos','Carrera 22 con Ave. Carlos Soublette #8-35','San Cristóbal','Táchira','5022','Venezuela'),(10961,62,8,'1998-03-19','1998-04-16','1998-03-30',1,104.4700,'Queen Cozinha','Alameda dos Canàrios, 891','São Paulo','SP','05487-020','Brasil'),(10962,63,8,'1998-03-19','1998-04-16','1998-03-23',2,275.7900,'QUICK-Stop','Taucherstraße 10','Cunewalde',NULL,'01307','Alemania'),(10963,28,9,'1998-03-19','1998-04-16','1998-03-26',3,2.7000,'Furia Bacalhau e Frutos do Mar','Jardim das rosas n. 32','Lisboa',NULL,'1675','Portugal'),(10964,74,3,'1998-03-20','1998-04-17','1998-03-24',2,87.3800,'Spécialités du monde','25, rue Lauriston','Paris',NULL,'75016','Francia'),(10965,55,6,'1998-03-20','1998-04-17','1998-03-30',3,144.3800,'Old World Delicatessen','2743 Bering St.','Anchorage','AK','99508','Estados Unidos'),(10966,16,4,'1998-03-20','1998-04-17','1998-04-08',1,27.1900,'Chop-suey Chinese','Hauptstr. 31','Bern',NULL,'3012','Suiza'),(10967,79,2,'1998-03-23','1998-04-20','1998-04-02',2,62.2200,'Toms Spezialitäten','Luisenstr. 48','Münster',NULL,'44087','Alemania'),(10968,20,1,'1998-03-23','1998-04-20','1998-04-01',3,74.6000,'Ernst Handel','Kirchgasse 6','Graz',NULL,'8010','Austria'),(10969,14,1,'1998-03-23','1998-04-20','1998-03-30',2,0.2100,'Comércio Mineiro','Av. dos Lusíadas, 23','São Paulo','SP','05432-043','Brasil'),(10970,8,9,'1998-03-24','1998-04-07','1998-04-24',1,16.1600,'Bólido Comidas preparadas','C/ Araquil, 67','Madrid',NULL,'28023','España'),(10971,26,2,'1998-03-24','1998-04-21','1998-04-02',2,121.8200,'France restauration','54, rue Royale','Nantes',NULL,'44000','Francia'),(10972,40,4,'1998-03-24','1998-04-21','1998-03-26',2,0.0200,'La corne d\'abondance','67, avenue de l\'Europe','Versailles',NULL,'78000','Francia'),(10973,40,6,'1998-03-24','1998-04-21','1998-03-27',2,15.1700,'La corne d\'abondance','67, avenue de l\'Europe','Versailles',NULL,'78000','Francia'),(10974,75,3,'1998-03-25','1998-04-08','1998-04-03',3,12.9600,'Split Rail Beer & Ale','P.O. Box 555','Lander','WY','82520','Estados Unidos'),(10975,10,1,'1998-03-25','1998-04-22','1998-03-27',3,32.2700,'Bottom-Dollar Markets','23 Tsawassen Blvd.','Tsawassen','BC','T2F 8M4','Canadá'),(10976,35,1,'1998-03-25','1998-05-06','1998-04-03',1,37.9700,'HILARIÓN-Abastos','Carrera 22 con Ave. Carlos Soublette #8-35','San Cristóbal','Táchira','5022','Venezuela'),(10977,24,8,'1998-03-26','1998-04-23','1998-04-10',3,208.5000,'Folk och fä HB','Åkergatan 24','Bräcke',NULL,'S-844 67','Suecia'),(10978,50,9,'1998-03-26','1998-04-23','1998-04-23',2,32.8200,'Maison Dewey','Rue Joseph-Bens 532','Bruxelles',NULL,'B-1180','Bélgica'),(10979,20,8,'1998-03-26','1998-04-23','1998-03-31',2,353.0700,'Ernst Handel','Kirchgasse 6','Graz',NULL,'8010','Austria'),(10980,24,4,'1998-03-27','1998-05-08','1998-04-17',1,1.2600,'Folk och fä HB','Åkergatan 24','Bräcke',NULL,'S-844 67','Suecia'),(10981,34,1,'1998-03-27','1998-04-24','1998-04-02',2,193.3700,'Hanari Carnes','Rua do Paço, 67','Río de Janeiro','RJ','05454-876','Brasil'),(10982,10,2,'1998-03-27','1998-04-24','1998-04-08',1,14.0100,'Bottom-Dollar Markets','23 Tsawassen Blvd.','Tsawassen','BC','T2F 8M4','Canadá'),(10983,71,2,'1998-03-27','1998-04-24','1998-04-06',2,657.5400,'Save-a-lot Markets','187 Suffolk Ln.','Boise','ID','83720','Estados Unidos'),(10984,71,1,'1998-03-30','1998-04-27','1998-04-03',3,211.2200,'Save-a-lot Markets','187 Suffolk Ln.','Boise','ID','83720','Estados Unidos'),(10985,37,2,'1998-03-30','1998-04-27','1998-04-02',1,91.5100,'Hungry Owl All-Night Grocers','8 Johnstown Road','Cork','Co. Cork',NULL,'Irlanda'),(10986,54,8,'1998-03-30','1998-04-27','1998-04-21',2,217.8600,'Océano Atlántico Ltda.','Ing. Gustavo Moncada 8585\r\nPiso 20-A','Buenos Aires',NULL,'1010','Argentina'),(10987,19,8,'1998-03-31','1998-04-28','1998-04-06',1,185.4800,'Eastern Connection','35 King George','London',NULL,'WX3 6FW','Reino Unido'),(10988,65,3,'1998-03-31','1998-04-28','1998-04-10',2,61.1400,'Rattlesnake Canyon Grocery','2817 Milton Dr.','Albuquerque','NM','87110','Estados Unidos'),(10989,61,2,'1998-03-31','1998-04-28','1998-04-02',1,34.7600,'Que Delícia','Rua da Panificadora, 12','Río de Janeiro','RJ','02389-673','Brasil'),(10990,20,2,'1998-04-01','1998-05-13','1998-04-07',3,117.6100,'Ernst Handel','Kirchgasse 6','Graz',NULL,'8010','Austria'),(10991,63,1,'1998-04-01','1998-04-29','1998-04-07',1,38.5100,'QUICK-Stop','Taucherstraße 10','Cunewalde',NULL,'01307','Alemania'),(10992,77,1,'1998-04-01','1998-04-29','1998-04-03',3,4.2700,'The Big Cheese','89 Jefferson Way\r\nSuite 2','Portland','OR','97201','Estados Unidos'),(10993,24,7,'1998-04-01','1998-04-29','1998-04-10',3,8.8100,'Folk och fä HB','Åkergatan 24','Bräcke',NULL,'S-844 67','Suecia'),(10994,83,2,'1998-04-02','1998-04-16','1998-04-09',3,65.5300,'Vaffeljernet','Smagsløget 45','Århus',NULL,'8200','Dinamarca'),(10995,58,1,'1998-04-02','1998-04-30','1998-04-06',3,46.0000,'Pericles Comidas clásicas','Calle Dr. Jorge Cash 321','México D.F.',NULL,'05033','México'),(10996,63,4,'1998-04-02','1998-04-30','1998-04-10',2,1.1200,'QUICK-Stop','Taucherstraße 10','Cunewalde',NULL,'01307','Alemania'),(10997,46,8,'1998-04-03','1998-05-15','1998-04-13',2,73.9100,'LILA-Supermercado','Carrera 52 con Ave. Bolívar #65-98 Llano Largo','Barquisimeto','Lara','3508','Venezuela'),(10998,91,8,'1998-04-03','1998-04-17','1998-04-17',2,20.3100,'Wolski Zajazd','ul. Filtrowa 68','Warszawa',NULL,'01-012','Polonia'),(10999,56,6,'1998-04-03','1998-05-01','1998-04-10',2,96.3500,'Ottilies Käseladen','Mehrheimerstr. 369','Köln',NULL,'50739','Alemania'),(11000,65,2,'1998-04-06','1998-05-04','1998-04-14',3,55.1200,'Rattlesnake Canyon Grocery','2817 Milton Dr.','Albuquerque','NM','87110','Estados Unidos'),(11001,24,2,'1998-04-06','1998-05-04','1998-04-14',2,197.3000,'Folk och fä HB','Åkergatan 24','Bräcke',NULL,'S-844 67','Suecia'),(11002,71,4,'1998-04-06','1998-05-04','1998-04-16',1,141.1600,'Save-a-lot Markets','187 Suffolk Ln.','Boise','ID','83720','Estados Unidos'),(11003,78,3,'1998-04-06','1998-05-04','1998-04-08',3,14.9100,'The Cracker Box','55 Grizzly Peak Rd.','Butte','MT','59801','Estados Unidos'),(11004,50,3,'1998-04-07','1998-05-05','1998-04-20',1,44.8400,'Maison Dewey','Rue Joseph-Bens 532','Bruxelles',NULL,'B-1180','Bélgica'),(11006,32,3,'1998-04-07','1998-05-05','1998-04-15',2,25.1900,'Great Lakes Food Market','2732 Baker Blvd.','Eugene','OR','97403','Estados Unidos'),(11007,60,8,'1998-04-08','1998-05-06','1998-04-13',2,202.2400,'Princesa Isabel Vinhos','Estrada da saúde n. 58','Lisboa',NULL,'1756','Portugal'),(11008,20,7,'1998-04-08','1998-05-06',NULL,3,79.4600,'Ernst Handel','Kirchgasse 6','Graz',NULL,'8010','Austria'),(11009,30,2,'1998-04-08','1998-05-06','1998-04-10',1,59.1100,'Godos Cocina Típica','C/ Romero, 33','Sevilla',NULL,'41101','España'),(11010,66,2,'1998-04-09','1998-05-07','1998-04-21',2,28.7100,'Reggiani Caseifici','Strada Provinciale 124','Reggio Emilia',NULL,'42100','Italia'),(11011,1,3,'1998-04-09','1998-05-07','1998-04-13',1,1.2100,'Alfreds Futterkiste','Obere Str. 57','Berlín',NULL,'12209','Alemania'),(11012,25,1,'1998-04-09','1998-04-23','1998-04-17',3,242.9500,'Frankenversand','Berliner Platz 43','München',NULL,'80805','Alemania'),(11013,69,2,'1998-04-09','1998-05-07','1998-04-10',1,32.9900,'Romero y tomillo','Gran Vía, 1','Madrid',NULL,'28001','España'),(11014,47,2,'1998-04-10','1998-05-08','1998-04-15',3,23.6000,'LINO-Delicateses','Ave. 5 de Mayo Porlamar','I. de Margarita','Nueva Esparta','4980','Venezuela'),(11015,70,2,'1998-04-10','1998-04-24','1998-04-20',2,4.6200,'Santé Gourmet','Erling Skakkes gate 78','Stavern',NULL,'4110','Noruega'),(11016,4,9,'1998-04-10','1998-05-08','1998-04-13',2,33.8000,'Around the Horn','Brook Farm\r\nStratford St. Mary','Colchester','Essex','CO7 6JX','Reino Unido'),(11017,20,9,'1998-04-13','1998-05-11','1998-04-20',2,754.2600,'Ernst Handel','Kirchgasse 6','Graz',NULL,'8010','Austria'),(11018,48,4,'1998-04-13','1998-05-11','1998-04-16',2,11.6500,'Lonesome Pine Restaurant','89 Chiaroscuro Rd.','Portland','OR','97219','Estados Unidos'),(11019,64,6,'1998-04-13','1998-05-11',NULL,3,3.1700,'Rancho grande','Av. del Libertador 900','Buenos Aires',NULL,'1010','Argentina'),(11020,56,2,'1998-04-14','1998-05-12','1998-04-16',2,43.3000,'Ottilies Käseladen','Mehrheimerstr. 369','Köln',NULL,'50739','Alemania'),(11021,63,3,'1998-04-14','1998-05-12','1998-04-21',1,297.1800,'QUICK-Stop','Taucherstraße 10','Cunewalde',NULL,'01307','Alemania'),(11022,34,9,'1998-04-14','1998-05-12','1998-05-04',2,6.2700,'Hanari Carnes','Rua do Paço, 67','Río de Janeiro','RJ','05454-876','Brasil'),(11023,11,1,'1998-04-14','1998-04-28','1998-04-24',2,123.8300,'B\'s Beverages','Fauntleroy Circus','London',NULL,'EC2 5NT','Reino Unido'),(11024,19,4,'1998-04-15','1998-05-13','1998-04-20',1,74.3600,'Eastern Connection','35 King George','London',NULL,'WX3 6FW','Reino Unido'),(11025,87,6,'1998-04-15','1998-05-13','1998-04-24',3,29.1700,'Wartian Herkku','Torikatu 38','Oulu',NULL,'90110','Finlandia'),(11026,27,4,'1998-04-15','1998-05-13','1998-04-28',1,47.0900,'Franchi S.p.A.','Via Monte Bianco 34','Torino',NULL,'10100','Italia'),(11027,10,1,'1998-04-16','1998-05-14','1998-04-20',1,52.5200,'Bottom-Dollar Markets','23 Tsawassen Blvd.','Tsawassen','BC','T2F 8M4','Canadá'),(11028,39,2,'1998-04-16','1998-05-14','1998-04-22',1,29.5900,'Königlich Essen','Maubelstr. 90','Brandenburg',NULL,'14776','Alemania'),(11029,16,4,'1998-04-16','1998-05-14','1998-04-27',1,47.8400,'Chop-suey Chinese','Hauptstr. 31','Bern',NULL,'3012','Suiza'),(11030,71,7,'1998-04-17','1998-05-15','1998-04-27',2,830.7500,'Save-a-lot Markets','187 Suffolk Ln.','Boise','ID','83720','Estados Unidos'),(11031,71,6,'1998-04-17','1998-05-15','1998-04-24',2,227.2200,'Save-a-lot Markets','187 Suffolk Ln.','Boise','ID','83720','Estados Unidos'),(11032,89,2,'1998-04-17','1998-05-15','1998-04-23',3,606.1900,'White Clover Markets','1029 - 12th Ave. S.','Seattle','WA','98124','Estados Unidos'),(11033,68,7,'1998-04-17','1998-05-15','1998-04-23',3,84.7400,'Richter Supermarkt','Starenweg 5','Genève',NULL,'1204','Suiza'),(11034,55,8,'1998-04-20','1998-06-01','1998-04-27',1,40.3200,'Old World Delicatessen','2743 Bering St.','Anchorage','AK','99508','Estados Unidos'),(11035,76,2,'1998-04-20','1998-05-18','1998-04-24',2,0.1700,'Suprêmes délices','Boulevard Tirou, 255','Charleroi',NULL,'B-6000','Bélgica'),(11036,17,8,'1998-04-20','1998-05-18','1998-04-22',3,149.4700,'Drachenblut Delikatessen','Walserweg 21','Aachen',NULL,'52066','Alemania'),(11037,30,7,'1998-04-21','1998-05-19','1998-04-27',1,3.2000,'Godos Cocina Típica','C/ Romero, 33','Sevilla',NULL,'41101','España'),(11038,76,1,'1998-04-21','1998-05-19','1998-04-30',2,29.5900,'Suprêmes délices','Boulevard Tirou, 255','Charleroi',NULL,'B-6000','Bélgica'),(11039,47,1,'1998-04-21','1998-05-19',NULL,2,65.0000,'LINO-Delicateses','Ave. 5 de Mayo Porlamar','I. de Margarita','Nueva Esparta','4980','Venezuela'),(11040,32,4,'1998-04-22','1998-05-20',NULL,3,18.8400,'Great Lakes Food Market','2732 Baker Blvd.','Eugene','OR','97403','Estados Unidos'),(11041,16,3,'1998-04-22','1998-05-20','1998-04-28',2,48.2200,'Chop-suey Chinese','Hauptstr. 31','Bern',NULL,'3012','Suiza'),(11042,14,2,'1998-04-22','1998-05-06','1998-05-01',1,29.9900,'Comércio Mineiro','Av. dos Lusíadas, 23','São Paulo','SP','05432-043','Brasil'),(11043,74,5,'1998-04-22','1998-05-20','1998-04-29',2,8.8000,'Spécialités du monde','25, rue Lauriston','Paris',NULL,'75016','Francia'),(11044,91,4,'1998-04-23','1998-05-21','1998-05-01',1,8.7200,'Wolski Zajazd','ul. Filtrowa 68','Warszawa',NULL,'01-012','Polonia'),(11045,10,6,'1998-04-23','1998-05-21',NULL,2,70.5800,'Bottom-Dollar Markets','23 Tsawassen Blvd.','Tsawassen','BC','T2F 8M4','Canadá'),(11046,86,8,'1998-04-23','1998-05-21','1998-04-24',2,71.6400,'Die Wandernde Kuh','Adenauerallee 900','Stuttgart',NULL,'70563','Alemania'),(11047,19,7,'1998-04-24','1998-05-22','1998-05-01',3,46.6200,'Eastern Connection','35 King George','London',NULL,'WX3 6FW','Reino Unido'),(11048,10,7,'1998-04-24','1998-05-22','1998-04-30',3,24.1200,'Bottom-Dollar Markets','23 Tsawassen Blvd.','Tsawassen','BC','T2F 8M4','Canadá'),(11049,31,3,'1998-04-24','1998-05-22','1998-05-04',1,8.3400,'Gourmet Lanchonetes','Av. Brasil, 442','Campinas','SP','04876-786','Brasil'),(11050,24,8,'1998-04-27','1998-05-25','1998-05-05',2,59.4100,'Folk och fä HB','Åkergatan 24','Bräcke',NULL,'S-844 67','Suecia'),(11051,41,7,'1998-04-27','1998-05-25',NULL,3,2.7900,'La maison d\'Asie','1 rue Alsace-Lorraine','Toulouse',NULL,'31000','Francia'),(11052,34,3,'1998-04-27','1998-05-25','1998-05-01',1,67.2600,'Hanari Carnes','Rua do Paço, 67','Río de Janeiro','RJ','05454-876','Brasil'),(11053,59,2,'1998-04-27','1998-05-25','1998-04-29',2,53.0500,'Piccolo und mehr','Geislweg 14','Salzburg',NULL,'5020','Austria'),(11054,12,8,'1998-04-28','1998-05-26',NULL,1,0.3300,'Cactus Comidas para llevar','Cerrito 333','Buenos Aires',NULL,'1010','Argentina'),(11055,35,7,'1998-04-28','1998-05-26','1998-05-05',2,120.9200,'HILARIÓN-Abastos','Carrera 22 con Ave. Carlos Soublette #8-35','San Cristóbal','Táchira','5022','Venezuela'),(11056,19,8,'1998-04-28','1998-05-12','1998-05-01',2,278.9600,'Eastern Connection','35 King George','London',NULL,'WX3 6FW','Reino Unido'),(11057,53,3,'1998-04-29','1998-05-27','1998-05-01',3,4.1300,'North/South','South House\r\n300 Queensbridge','London',NULL,'SW7 1RZ','Reino Unido'),(11058,6,9,'1998-04-29','1998-05-27',NULL,3,31.1400,'Blauer See Delikatessen','Forsterstr. 57','Mannheim',NULL,'68306','Alemania'),(11059,67,2,'1998-04-29','1998-06-10',NULL,2,85.8000,'Ricardo Adocicados','Av. Copacabana, 267','Río de Janeiro','RJ','02389-890','Brasil'),(11060,27,2,'1998-04-30','1998-05-28','1998-05-04',2,10.9800,'Franchi S.p.A.','Via Monte Bianco 34','Torino',NULL,'10100','Italia'),(11061,32,4,'1998-04-30','1998-06-11',NULL,3,14.0100,'Great Lakes Food Market','2732 Baker Blvd.','Eugene','OR','97403','Estados Unidos'),(11062,66,4,'1998-04-30','1998-05-28',NULL,2,29.9300,'Reggiani Caseifici','Strada Provinciale 124','Reggio Emilia',NULL,'42100','Italia'),(11063,37,3,'1998-04-30','1998-05-28','1998-05-06',2,81.7300,'Hungry Owl All-Night Grocers','8 Johnstown Road','Cork','Co. Cork',NULL,'Irlanda'),(11064,71,1,'1998-05-01','1998-05-29','1998-05-04',1,30.0900,'Save-a-lot Markets','187 Suffolk Ln.','Boise','ID','83720','Estados Unidos'),(11065,46,8,'1998-05-01','1998-05-29',NULL,1,12.9100,'LILA-Supermercado','Carrera 52 con Ave. Bolívar #65-98 Llano Largo','Barquisimeto','Lara','3508','Venezuela'),(11066,89,7,'1998-05-01','1998-05-29','1998-05-04',2,44.7200,'White Clover Markets','1029 - 12th Ave. S.','Seattle','WA','98124','Estados Unidos'),(11067,17,1,'1998-05-04','1998-05-18','1998-05-06',2,7.9800,'Drachenblut Delikatessen','Walserweg 21','Aachen',NULL,'52066','Alemania'),(11068,62,8,'1998-05-04','1998-06-01',NULL,2,81.7500,'Queen Cozinha','Alameda dos Canàrios, 891','São Paulo','SP','05487-020','Brasil'),(11069,80,1,'1998-05-04','1998-06-01','1998-05-06',2,15.6700,'Tortuga Restaurante','Avda. Azteca 123','México D.F.',NULL,'05033','México'),(11070,44,2,'1998-05-05','1998-06-02',NULL,1,136.0000,'Lehmanns Marktstand','Magazinweg 7','Frankfurt a.M. ',NULL,'60528','Alemania'),(11071,46,1,'1998-05-05','1998-06-02',NULL,1,0.9300,'LILA-Supermercado','Carrera 52 con Ave. Bolívar #65-98 Llano Largo','Barquisimeto','Lara','3508','Venezuela'),(11072,20,4,'1998-05-05','1998-06-02',NULL,2,258.6400,'Ernst Handel','Kirchgasse 6','Graz',NULL,'8010','Austria'),(11073,58,2,'1998-05-05','1998-06-02',NULL,2,24.9500,'Pericles Comidas clásicas','Calle Dr. Jorge Cash 321','México D.F.',NULL,'05033','México'),(11074,73,7,'1998-05-06','1998-06-03',NULL,2,18.4400,'Simons bistro','Vinbæltet 34','København',NULL,'1734','Dinamarca'),(11075,68,8,'1998-05-06','1998-06-03',NULL,2,6.1900,'Richter Supermarkt','Starenweg 5','Genève',NULL,'1204','Suiza'),(11076,9,4,'1998-05-06','1998-06-03',NULL,2,38.2800,'Bon app\'','12, rue des Bouchers','Marseille',NULL,'13008','Francia'),(11077,65,1,'1998-05-06','1998-06-03',NULL,2,8.5300,'Rattlesnake Canyon Grocery','2817 Milton Dr.','Albuquerque','NM','87110','Estados Unidos');
/*!40000 ALTER TABLE `pedidos` ENABLE KEYS */;
UNLOCK TABLES;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
/*!50003 CREATE*/ /*!50017 DEFINER=`root`@`localhost`*/ /*!50003 TRIGGER `beforeInsertPedidos` BEFORE INSERT ON `pedidos` FOR EACH ROW BEGIN
	DECLARE v_Destinatario,
			v_DireccionDestinatario,
			v_CiudadDestinatario,
			v_RegionDestinatario,
			v_CodPostalDestinatario,
			v_PaisDestinatario
				VARCHAR(100);

	SELECT Contacto, Direccion, Ciudad, Region, cp, Pais
			INTO v_Destinatario, v_DireccionDestinatario, v_CiudadDestinatario, v_RegionDestinatario, v_CodPostalDestinatario, v_PaisDestinatario
	FROM Clientes
	WHERE Id = new.Id;

	IF ISNULL(new.Destinatario) THEN SET new.Destinatario = v_Destinatario; END IF;
	IF ISNULL(new.Direccion_Destinatario) THEN SET new.Direccion_Destinatario = v_DireccionDestinatario; END IF;
	IF ISNULL(new.Ciudad_Destinatario) THEN SET new.Ciudad_Destinatario = v_CiudadDestinatario; END IF;
	IF ISNULL(new.Region_Destinatario) THEN SET new.Region_Destinatario = v_RegionDestinatario; END IF;
	IF ISNULL(new.cp_Destinatario) THEN SET new.cp_Destinatario = v_CodPostalDestinatario; END IF;
	IF ISNULL(new.Pais_Destinatario) THEN SET new.Pais_Destinatario = v_PaisDestinatario; END IF;
END */;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;

--
-- Table structure for table `productos`
--

DROP TABLE IF EXISTS `productos`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `productos` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `producto` varchar(40) NOT NULL,
  `proveedor_id` int(11) DEFAULT NULL,
  `categoria_id` int(11) DEFAULT NULL,
  `cantidad_por_unidad` varchar(20) DEFAULT NULL,
  `precio_unidad` decimal(19,4) DEFAULT NULL,
  `unidades_existencia` smallint(6) DEFAULT NULL,
  `unidades_pedido` smallint(6) DEFAULT NULL,
  `nivel_nuevo_pedido` int(11) DEFAULT NULL,
  `suspendido` tinyint(1) NOT NULL DEFAULT '0',
  `notas` text,
  `iva` decimal(14,2) NOT NULL DEFAULT '0.00',
  PRIMARY KEY (`id`),
  UNIQUE KEY `uq_producto` (`producto`),
  KEY `fk_categoria` (`categoria_id`),
  KEY `fk_proveedor` (`proveedor_id`),
  CONSTRAINT `fk_categoria` FOREIGN KEY (`categoria_id`) REFERENCES `categorias` (`id`),
  CONSTRAINT `fk_proveedor` FOREIGN KEY (`proveedor_id`) REFERENCES `proveedores` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=78 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `productos`
--

LOCK TABLES `productos` WRITE;
/*!40000 ALTER TABLE `productos` DISABLE KEYS */;
INSERT INTO `productos` VALUES (1,'Té Dharamsala',1,1,'10 cajas x 20 bolsas',18.0000,39,0,10,0,'Producto: Té Dharamsala. Precio unidad: 18.0000. IVA: 10.00. Precio unidad con IVA: 18.0000000000',10.00),(2,'Cerveza tibetana Barley',1,1,'24 - bot. 12 l',19.0000,17,40,25,0,'Producto: Cerveza tibetana Barley. Precio unidad: 19.0000. IVA: 10.00. Precio unidad con IVA: 19.0000000000',10.00),(3,'Sirope de regaliz',1,2,'12 - bot. 550 ml',10.0000,13,70,25,0,'Producto: Sirope de regaliz. Precio unidad: 10.0000. IVA: 10.00. Precio unidad con IVA: 10.0000000000',10.00),(4,'Especias Cajun del chef Anton',2,2,'48 - frascos 6 l',22.0000,53,0,0,0,'Producto: Especias Cajun del chef Anton. Precio unidad: 22.0000. IVA: 10.00. Precio unidad con IVA: 22.0000000000',10.00),(5,'Mezcla Gumbo del chef Anton',2,2,'36 cajas',21.3500,0,0,0,-1,'Producto: Mezcla Gumbo del chef Anton. Precio unidad: 21.3500. IVA: 10.00. Precio unidad con IVA: 21.3500000000',10.00),(6,'Mermelada de grosellas de la abuela',3,2,'12 - frascos 8 l',25.0000,120,0,25,0,'Producto: Mermelada de grosellas de la abuela. Precio unidad: 25.0000. IVA: 10.00. Precio unidad con IVA: 25.0000000000',10.00),(7,'Peras secas orgánicas del tío Bob',3,7,'12 - paq. 1 kg',30.0000,15,0,10,0,'Producto: Peras secas orgánicas del tío Bob. Precio unidad: 30.0000. IVA: 10.00. Precio unidad con IVA: 30.0000000000',10.00),(8,'Salsa de arándanos Northwoods',3,2,'12 - frascos 12 l',40.0000,6,0,0,0,'Producto: Salsa de arándanos Northwoods. Precio unidad: 40.0000. IVA: 10.00. Precio unidad con IVA: 40.0000000000',10.00),(9,'Buey Mishi Kobe',4,6,'18 - paq. 500 g',97.0000,29,0,0,-1,'Producto: Buey Mishi Kobe. Precio unidad: 97.0000. IVA: 10.00. Precio unidad con IVA: 97.0000000000',10.00),(10,'Pez espada',4,8,'12 - frascos 200 ml',31.0000,31,0,0,0,'Producto: Pez espada. Precio unidad: 31.0000. IVA: 10.00. Precio unidad con IVA: 31.0000000000',10.00),(11,'Queso Cabrales',5,4,'paq. 1 kg',21.0000,22,30,30,0,'Producto: Queso Cabrales. Precio unidad: 21.0000. IVA: 10.00. Precio unidad con IVA: 21.0000000000',10.00),(12,'Queso Manchego La Pastora',5,4,'10 - paq. 500 g',38.0000,86,0,0,0,'Producto: Queso Manchego La Pastora. Precio unidad: 38.0000. IVA: 10.00. Precio unidad con IVA: 38.0000000000',10.00),(13,'Algas Konbu',6,8,'caja 2 kg',6.0000,24,0,5,0,'Producto: Algas Konbu. Precio unidad: 6.0000. IVA: 10.00. Precio unidad con IVA: 6.0000000000',10.00),(14,'Cuajada de judías',6,7,'40 - paq. 100 g',23.2500,35,0,0,0,'Producto: Cuajada de judías. Precio unidad: 23.2500. IVA: 10.00. Precio unidad con IVA: 23.2500000000',10.00),(15,'Salsa de soja baja en sodio',6,2,'24 - bot. 250 ml',15.5000,39,0,5,0,'Producto: Salsa de soja baja en sodio. Precio unidad: 15.5000. IVA: 10.00. Precio unidad con IVA: 15.5000000000',10.00),(16,'Postre de merengue Pavlova',7,3,'32 - cajas 500 g',17.4500,29,0,10,0,'Producto: Postre de merengue Pavlova. Precio unidad: 17.4500. IVA: 10.00. Precio unidad con IVA: 17.4500000000',10.00),(17,'Cordero Alice Springs',7,6,'20 - latas 1 kg',39.0000,0,0,0,-1,'Producto: Cordero Alice Springs. Precio unidad: 39.0000. IVA: 10.00. Precio unidad con IVA: 39.0000000000',10.00),(18,'Langostinos tigre Carnarvon',7,8,'paq. 16 kg',62.5000,42,0,0,0,'Producto: Langostinos tigre Carnarvon. Precio unidad: 62.5000. IVA: 10.00. Precio unidad con IVA: 62.5000000000',10.00),(19,'Pastas de té de chocolate',8,3,'10 cajas x 12 piezas',9.2000,25,0,5,0,'Producto: Pastas de té de chocolate. Precio unidad: 9.2000. IVA: 10.00. Precio unidad con IVA: 9.2000000000',10.00),(20,'Mermelada de Sir Rodney\'s',8,3,'30 cajas regalo',81.0000,40,0,0,0,'Producto: Mermelada de Sir Rodney\'s. Precio unidad: 81.0000. IVA: 10.00. Precio unidad con IVA: 81.0000000000',10.00),(21,'Bollos de Sir Rodney\'s',8,3,'24 paq. x 4 piezas',10.0000,3,40,5,0,'Producto: Bollos de Sir Rodney\'s. Precio unidad: 10.0000. IVA: 10.00. Precio unidad con IVA: 10.0000000000',10.00),(22,'Pan de centeno crujiente estilo Gustaf\'s',9,5,'24 - paq. 500 g',21.0000,104,0,25,0,'Producto: Pan de centeno crujiente estilo Gustaf\'s. Precio unidad: 21.0000. IVA: 10.00. Precio unidad con IVA: 21.0000000000',10.00),(23,'Pan fino',9,5,'12 - paq. 250 g',9.0000,61,0,25,0,'Producto: Pan fino. Precio unidad: 9.0000. IVA: 10.00. Precio unidad con IVA: 9.0000000000',10.00),(24,'Refresco Guaraná Fantástica',10,1,'12 - latas 355 ml',4.5000,20,0,0,-1,'Producto: Refresco Guaraná Fantástica. Precio unidad: 4.5000. IVA: 10.00. Precio unidad con IVA: 4.5000000000',10.00),(25,'Crema de chocolate y nueces NuNuCa',11,3,'20 - vasos  450 g',14.0000,76,0,30,0,'Producto: Crema de chocolate y nueces NuNuCa. Precio unidad: 14.0000. IVA: 10.00. Precio unidad con IVA: 14.0000000000',10.00),(26,'Ositos de goma Gumbär',11,3,'100 - bolsas 250 g',31.2300,15,0,0,0,'Producto: Ositos de goma Gumbär. Precio unidad: 31.2300. IVA: 10.00. Precio unidad con IVA: 31.2300000000',10.00),(27,'Chocolate Schoggi',11,3,'100 - piezas 100 g',43.9000,49,0,30,0,'Producto: Chocolate Schoggi. Precio unidad: 43.9000. IVA: 10.00. Precio unidad con IVA: 43.9000000000',10.00),(28,'Col fermentada Rössle',12,7,'25 - latas 825 g',45.6000,26,0,0,-1,'Producto: Col fermentada Rössle. Precio unidad: 45.6000. IVA: 10.00. Precio unidad con IVA: 45.6000000000',10.00),(29,'Salchicha Thüringer',12,6,'50 bolsas x 30 salch',123.7900,0,0,0,-1,'Producto: Salchicha Thüringer. Precio unidad: 123.7900. IVA: 10.00. Precio unidad con IVA: 123.7900000000',10.00),(30,'Arenque blanco del noroeste',13,8,'10 - vasos 200 g',25.8900,10,0,15,0,'Producto: Arenque blanco del noroeste. Precio unidad: 25.8900. IVA: 10.00. Precio unidad con IVA: 25.8900000000',10.00),(31,'Queso gorgonzola Telino',14,4,'12 - paq. 100 g',12.5000,0,70,20,0,'Producto: Queso gorgonzola Telino. Precio unidad: 12.5000. IVA: 10.00. Precio unidad con IVA: 12.5000000000',10.00),(32,'Queso Mascarpone Fabioli',14,4,'24 - paq. 200 g',32.0000,9,40,25,0,'Producto: Queso Mascarpone Fabioli. Precio unidad: 32.0000. IVA: 10.00. Precio unidad con IVA: 32.0000000000',10.00),(33,'Queso de cabra',15,4,'500 g',2.5000,112,0,20,0,'Producto: Queso de cabra. Precio unidad: 2.5000. IVA: 10.00. Precio unidad con IVA: 2.5000000000',10.00),(34,'Cerveza Sasquatch',16,1,'24 - bot. 12 l',14.0000,111,0,15,0,'Producto: Cerveza Sasquatch. Precio unidad: 14.0000. IVA: 10.00. Precio unidad con IVA: 14.0000000000',10.00),(35,'Cerveza negra Steeleye',16,1,'24 - bot. 12 l',18.0000,20,0,15,0,'Producto: Cerveza negra Steeleye. Precio unidad: 18.0000. IVA: 10.00. Precio unidad con IVA: 18.0000000000',10.00),(36,'Escabeche de arenque',17,8,'24 - frascos 250 g',19.0000,112,0,20,0,'Producto: Escabeche de arenque. Precio unidad: 19.0000. IVA: 10.00. Precio unidad con IVA: 19.0000000000',10.00),(37,'Salmón ahumado Gravad',17,8,'12 - paq. 500 g',26.0000,11,50,25,0,'Producto: Salmón ahumado Gravad. Precio unidad: 26.0000. IVA: 10.00. Precio unidad con IVA: 26.0000000000',10.00),(38,'Vino Côte de Blaye',18,1,'12 - bot. 75 cl',263.5000,17,0,15,0,'Producto: Vino Côte de Blaye. Precio unidad: 263.5000. IVA: 10.00. Precio unidad con IVA: 263.5000000000',10.00),(39,'Licor verde Chartreuse',18,1,'750 cc por bot.',18.0000,69,0,5,0,'Producto: Licor verde Chartreuse. Precio unidad: 18.0000. IVA: 10.00. Precio unidad con IVA: 18.0000000000',10.00),(40,'Carne de cangrejo de Boston',19,8,'24 - latas 4 l',18.4000,123,0,30,0,'Producto: Carne de cangrejo de Boston. Precio unidad: 18.4000. IVA: 10.00. Precio unidad con IVA: 18.4000000000',10.00),(41,'Crema de almejas estilo Nueva Inglaterra',19,8,'12 - latas 12 l',9.6500,85,0,10,0,'Producto: Crema de almejas estilo Nueva Inglaterra. Precio unidad: 9.6500. IVA: 10.00. Precio unidad con IVA: 9.6500000000',10.00),(42,'Tallarines de Singapur',20,5,'32 - 1 kg paq.',14.0000,26,0,0,-1,'Producto: Tallarines de Singapur. Precio unidad: 14.0000. IVA: 10.00. Precio unidad con IVA: 14.0000000000',10.00),(43,'Café de Malasia',20,1,'16 - latas 500 g',46.0000,17,10,25,0,'Producto: Café de Malasia. Precio unidad: 46.0000. IVA: 10.00. Precio unidad con IVA: 46.0000000000',10.00),(44,'Azúcar negra Malacca',20,2,'20 - bolsas 2 kg',19.4500,27,0,15,0,'Producto: Azúcar negra Malacca. Precio unidad: 19.4500. IVA: 10.00. Precio unidad con IVA: 19.4500000000',10.00),(45,'Arenque ahumado',21,8,'paq. 1k',9.5000,5,70,15,0,'Producto: Arenque ahumado. Precio unidad: 9.5000. IVA: 10.00. Precio unidad con IVA: 9.5000000000',10.00),(46,'Arenque salado',21,8,'4 - vasos 450 g',12.0000,95,0,0,0,'Producto: Arenque salado. Precio unidad: 12.0000. IVA: 10.00. Precio unidad con IVA: 12.0000000000',10.00),(47,'Galletas Zaanse',22,3,'10 - cajas 4 l',9.5000,36,0,0,0,'Producto: Galletas Zaanse. Precio unidad: 9.5000. IVA: 10.00. Precio unidad con IVA: 9.5000000000',10.00),(48,'Chocolate holandés',22,3,'10 paq.',12.7500,15,70,25,0,'Producto: Chocolate holandés. Precio unidad: 12.7500. IVA: 10.00. Precio unidad con IVA: 12.7500000000',10.00),(49,'Regaliz',23,3,'24 - paq. 50 g',20.0000,10,60,15,0,'Producto: Regaliz. Precio unidad: 20.0000. IVA: 10.00. Precio unidad con IVA: 20.0000000000',10.00),(50,'Chocolate blanco',23,3,'12 - barras 100 g',16.2500,65,0,30,0,'Producto: Chocolate blanco. Precio unidad: 16.2500. IVA: 10.00. Precio unidad con IVA: 16.2500000000',10.00),(51,'Manzanas secas Manjimup',24,7,'50 - paq. 300 g',53.0000,20,0,10,0,'Producto: Manzanas secas Manjimup. Precio unidad: 53.0000. IVA: 10.00. Precio unidad con IVA: 53.0000000000',10.00),(52,'Cereales para Filo',24,5,'16 - cajas 2 kg',7.0000,38,0,25,0,'Producto: Cereales para Filo. Precio unidad: 7.0000. IVA: 10.00. Precio unidad con IVA: 7.0000000000',10.00),(53,'Empanada de carne',24,6,'48 porc.',32.8000,0,0,0,-1,'Producto: Empanada de carne. Precio unidad: 32.8000. IVA: 10.00. Precio unidad con IVA: 32.8000000000',10.00),(54,'Empanada de cerdo',25,6,'16 tartas',7.4500,21,0,10,0,'Producto: Empanada de cerdo. Precio unidad: 7.4500. IVA: 10.00. Precio unidad con IVA: 7.4500000000',10.00),(55,'Paté chino',25,6,'24 cajas x 2 tartas',24.0000,115,0,20,0,'Producto: Paté chino. Precio unidad: 24.0000. IVA: 10.00. Precio unidad con IVA: 24.0000000000',10.00),(56,'Gnocchi de la abuela Alicia',26,5,'24 - paq. 250 g',38.0000,21,10,30,0,'Producto: Gnocchi de la abuela Alicia. Precio unidad: 38.0000. IVA: 10.00. Precio unidad con IVA: 38.0000000000',10.00),(57,'Raviolis Angelo',26,5,'24 - paq. 250 g',19.5000,36,0,20,0,'Producto: Raviolis Angelo. Precio unidad: 19.5000. IVA: 10.00. Precio unidad con IVA: 19.5000000000',10.00),(58,'Caracoles de Borgoña',27,8,'24 porc.',13.2500,62,0,20,0,'Producto: Caracoles de Borgoña. Precio unidad: 13.2500. IVA: 10.00. Precio unidad con IVA: 13.2500000000',10.00),(59,'Raclet de queso Courdavault',28,4,'paq. 5 kg',55.0000,79,0,0,0,'Producto: Raclet de queso Courdavault. Precio unidad: 55.0000. IVA: 10.00. Precio unidad con IVA: 55.0000000000',10.00),(60,'Camembert Pierrot',28,4,'15 - paq. 300 g',34.0000,19,0,0,0,'Producto: Camembert Pierrot. Precio unidad: 34.0000. IVA: 10.00. Precio unidad con IVA: 34.0000000000',10.00),(61,'Sirope de arce',29,2,'24 - bot. 500 ml',28.5000,113,0,25,0,'Producto: Sirope de arce. Precio unidad: 28.5000. IVA: 10.00. Precio unidad con IVA: 28.5000000000',10.00),(62,'Tarta de azúcar',29,3,'48 tartas',49.3000,17,0,0,0,'Producto: Tarta de azúcar. Precio unidad: 49.3000. IVA: 10.00. Precio unidad con IVA: 49.3000000000',10.00),(63,'Sandwich de vegetales',7,2,'15 - frascos 625 g',43.9000,24,0,5,0,'Producto: Sandwich de vegetales. Precio unidad: 43.9000. IVA: 10.00. Precio unidad con IVA: 43.9000000000',10.00),(64,'Bollos de pan de Wimmer',12,5,'20 bolsas x 4 porc.',33.2500,22,80,30,0,'Producto: Bollos de pan de Wimmer. Precio unidad: 33.2500. IVA: 10.00. Precio unidad con IVA: 33.2500000000',10.00),(65,'Salsa de pimiento picante de Luisiana',2,2,'32 - bot. 8 l',21.0500,76,0,0,0,'Producto: Salsa de pimiento picante de Luisiana. Precio unidad: 21.0500. IVA: 10.00. Precio unidad con IVA: 21.0500000000',10.00),(66,'Especias picantes de Luisiana',2,2,'24 - frascos 8 l',17.0000,4,100,20,0,'Producto: Especias picantes de Luisiana. Precio unidad: 17.0000. IVA: 10.00. Precio unidad con IVA: 17.0000000000',10.00),(67,'Cerveza Laughing Lumberjack',16,1,'24 - bot. 12 l',14.0000,52,0,10,0,'Producto: Cerveza Laughing Lumberjack. Precio unidad: 14.0000. IVA: 10.00. Precio unidad con IVA: 14.0000000000',10.00),(68,'Barras de pan de Escocia',8,3,'10 cajas x 8 porc.',12.5000,6,10,15,0,'Producto: Barras de pan de Escocia. Precio unidad: 12.5000. IVA: 10.00. Precio unidad con IVA: 12.5000000000',10.00),(69,'Queso Gudbrandsdals',15,4,'paq. 10 kg',36.0000,26,0,15,0,'Producto: Queso Gudbrandsdals. Precio unidad: 36.0000. IVA: 10.00. Precio unidad con IVA: 36.0000000000',10.00),(70,'Cerveza Outback',7,1,'24 - bot. 355 ml',15.0000,15,10,30,0,'Producto: Cerveza Outback. Precio unidad: 15.0000. IVA: 10.00. Precio unidad con IVA: 15.0000000000',10.00),(71,'Crema de queso Fløtemys',15,4,'10 - paq. 500 g',21.5000,26,0,0,0,'Producto: Crema de queso Fløtemys. Precio unidad: 21.5000. IVA: 10.00. Precio unidad con IVA: 21.5000000000',10.00),(72,'Queso Mozzarella Giovanni',14,4,'24 - paq. 200 g',34.8000,14,0,0,0,'Producto: Queso Mozzarella Giovanni. Precio unidad: 34.8000. IVA: 10.00. Precio unidad con IVA: 34.8000000000',10.00),(73,'Caviar rojo',17,8,'24 - frascos150 g',15.0000,101,0,5,0,'Producto: Caviar rojo. Precio unidad: 15.0000. IVA: 10.00. Precio unidad con IVA: 15.0000000000',10.00),(74,'Queso de soja Longlife',4,7,'paq. 5 kg',10.0000,4,20,5,0,'Producto: Queso de soja Longlife. Precio unidad: 10.0000. IVA: 10.00. Precio unidad con IVA: 10.0000000000',10.00),(75,'Cerveza Klosterbier Rhönbräu',12,1,'24 - bot. 0,5 l',7.7500,125,0,25,0,'Producto: Cerveza Klosterbier Rhönbräu. Precio unidad: 7.7500. IVA: 10.00. Precio unidad con IVA: 7.7500000000',10.00),(76,'Licor Cloudberry',23,1,'500 ml',18.0000,57,0,20,0,'Producto: Licor Cloudberry. Precio unidad: 18.0000. IVA: 10.00. Precio unidad con IVA: 18.0000000000',10.00),(77,'Salsa verde original Frankfurter',12,2,'12 cajas',13.0000,32,0,15,0,'Producto: Salsa verde original Frankfurter. Precio unidad: 13.0000. IVA: 10.00. Precio unidad con IVA: 13.0000000000',10.00);
/*!40000 ALTER TABLE `productos` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `productos_new`
--

DROP TABLE IF EXISTS `productos_new`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `productos_new` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `producto` varchar(40) NOT NULL,
  `proveedor_id` int(11) DEFAULT NULL,
  `categoria_id` int(11) DEFAULT NULL,
  `cantidad_por_unidad` varchar(20) DEFAULT NULL,
  `precio_unidad` decimal(19,4) DEFAULT NULL,
  `unidades_existencia` smallint(6) DEFAULT NULL,
  `unidades_pedido` smallint(6) DEFAULT NULL,
  `nivel_nuevo_pedido` int(11) DEFAULT NULL,
  `suspendido` tinyint(1) NOT NULL DEFAULT '0',
  PRIMARY KEY (`id`),
  UNIQUE KEY `uq_producto_new` (`producto`),
  KEY `fk_categoria_new` (`categoria_id`),
  KEY `fk_proveedor_new` (`proveedor_id`),
  CONSTRAINT `fk_categoria_new` FOREIGN KEY (`categoria_id`) REFERENCES `categorias_new` (`id`),
  CONSTRAINT `fk_proveedor_new` FOREIGN KEY (`proveedor_id`) REFERENCES `proveedores_new` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=78 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `productos_new`
--

LOCK TABLES `productos_new` WRITE;
/*!40000 ALTER TABLE `productos_new` DISABLE KEYS */;
/*!40000 ALTER TABLE `productos_new` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `proveedores`
--

DROP TABLE IF EXISTS `proveedores`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `proveedores` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `empresa` varchar(40) NOT NULL,
  `contacto` varchar(30) DEFAULT NULL,
  `cargo_contacto` varchar(30) DEFAULT NULL,
  `direccion` varchar(60) DEFAULT NULL,
  `ciudad` varchar(15) DEFAULT NULL,
  `region` varchar(15) DEFAULT NULL,
  `cp` varchar(10) DEFAULT NULL,
  `pais` varchar(15) DEFAULT NULL,
  `telefono` varchar(24) DEFAULT NULL,
  `fax` varchar(24) DEFAULT NULL,
  `web` text,
  PRIMARY KEY (`id`),
  UNIQUE KEY `uq_proveedor` (`empresa`)
) ENGINE=InnoDB AUTO_INCREMENT=30 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `proveedores`
--

LOCK TABLES `proveedores` WRITE;
/*!40000 ALTER TABLE `proveedores` DISABLE KEYS */;
INSERT INTO `proveedores` VALUES (1,'Exotic Liquids','Charlotte Cooper','Gerente de compras','49 Gilbert St.','Londres',NULL,'EC1 4SD','Reino Unido','(171) 555-2222',NULL,NULL),(2,'New Orleans Cajun Delights','Shelley Burke','Administrador de pedidos','P.O. Box 78934','New Orleans','LA','70117','Estados Unidos','(100) 555-4822',NULL,NULL),(3,'Grandma Kelly\'s Homestead','Regina Murphy','Representante de ventas','707 Oxford Rd.','Ann Arbor','MI','48104','Estados Unidos','(313) 555-5735','(313) 555-3349',NULL),(4,'Tokyo Traders','Yoshi Nagase','Gerente de marketing','9-8 Sekimai\r\nMusashino-shi','Tokyo',NULL,'100','Japón','(03) 3555-5011',NULL,NULL),(5,'Cooperativa de Quesos \'Las Cabras\'','Antonio del Valle Saavedra ','Administrador de exportaciones','Calle del Rosal 4','Oviedo','Asturias','33007','España','(98) 598 76 54',NULL,NULL),(6,'Mayumi\'s','Mayumi Ohno','Representante de marketing','92 Setsuko\r\nChuo-ku','Osaka',NULL,'545','Japón','(06) 431-7877',NULL,NULL),(7,'Pavlova, Ltd.','Ian Devling','Gerente de marketing','74 Rose St.\r\nMoonie Ponds','Melbourne','Victoria','3058','Australia','(03) 444-2343','(03) 444-6588',NULL),(8,'Specialty Biscuits, Ltd.','Peter Wilson','Representante de ventas','29 King\'s Way','Manchester',NULL,'M14 GSD','Reino Unido','(161) 555-4448',NULL,NULL),(9,'PB Knäckebröd AB','Lars Peterson','Agente de ventas','Kaloadagatan 13','Göteborg',NULL,'S-345 67','Suecia','031-987 65 43','031-987 65 91',NULL),(10,'Refrescos Americanas LTDA','Carlos Diaz','Gerente de marketing','Av. das Americanas 12.890','São Paulo',NULL,'5442','Brasil','(11) 555 4640',NULL,NULL),(11,'Heli Süßwaren GmbH & Co. KG','Petra Winkler','Gerente de ventas','Tiergartenstraße 5','Berlín',NULL,'10785','Alemania','(010) 9984510',NULL,NULL),(12,'Plutzer Lebensmittelgroßmärkte AG','Martin Bein','Ger. marketing internacional','Bogenallee 51','Frankfurt',NULL,'60439','Alemania','(069) 992755',NULL,NULL),(13,'Nord-Ost-Fisch Handelsgesellschaft mbH','Sven Petersen','Coordinador de mercados','Frahmredder 112a','Cuxhaven',NULL,'27478','Alemania','(04721) 8713','(04721) 8714',NULL),(14,'Formaggi Fortini s.r.l.','Elio Rossi','Representante de ventas','Viale Dante, 75','Ravenna',NULL,'48100','Italia','(0544) 60323','(0544) 60603',NULL),(15,'Norske Meierier','Beate Vileid','Gerente de marketing','Hatlevegen 5','Sandvika',NULL,'1320','Noruega','(0)2-953010',NULL,NULL),(16,'Bigfoot Breweries','Cheryl Saylor','Repr. de cuentas regional','3400 - 8th Avenue\r\nSuite 210','Bend','OR','97101','Estados Unidos','(503) 555-9931',NULL,NULL),(17,'Svensk Sjöföda AB','Michael Björn','Representante de ventas','Brovallavägen 231','Stockholm',NULL,'S-123 45','Suecia','08-123 45 67',NULL,NULL),(18,'Aux joyeux ecclésiastiques','Guylène Nodier','Gerente de ventas','203, Rue des Francs-Bourgeois','París',NULL,'75004','Francia','(1) 03.83.00.68','(1) 03.83.00.62',NULL),(19,'New England Seafood Cannery','Robb Merchant','Agente de cuentas al por mayor','Order Processing Dept.\r\n2100 Paul Revere Blvd.','Boston','MA','02134','Estados Unidos','(617) 555-3267','(617) 555-3389',NULL),(20,'Leka Trading','Chandra Leka','Propietario','471 Serangoon Loop, Suite #402','Singapore',NULL,'0512','Singapur','555-8787',NULL,NULL),(21,'Lyngbysild','Niels Petersen','Gerente de ventas','Lyngbysild\r\nFiskebakken 10','Lyngby',NULL,'2800','Dinamarca','43844108','43844115',NULL),(22,'Zaanse Snoepfabriek','Dirk Luchte','Gerente de contabilidad','Verkoop\r\nRijnweg 22','Zaandam',NULL,'9999 ZZ','Holanda','(12345) 1212','(12345) 1210',NULL),(23,'Karkki Oy','Anne Heikkonen','Gerente de producción','Valtakatu 12','Lappeenranta',NULL,'53120','Finlandia','(953) 10956',NULL,NULL),(24,'G\'day, Mate','Wendy Mackenzie','Representante de ventas','170 Prince Edward Parade\r\nHunter\'s Hill','Sydney','NSW','2042','Australia','(02) 555-5914','(02) 555-4873',NULL),(25,'Ma Maison','Jean-Guy Lauzon','Gerente de marketing','2960 Rue St. Laurent','Montréal','Québec','H1J 1C3','Canadá','(514) 555-9022',NULL,NULL),(26,'Pasta Buttini s.r.l.','Giovanni Giudici','Administrador de pedidos','Via dei Gelsomini, 153','Salerno',NULL,'84100','Italia','(089) 6547665','(089) 6547667',NULL),(27,'Escargots Nouveaux','Marie Delamare','Gerente de ventas','22, rue H. Voiron','Montceau',NULL,'71300','Francia','85.57.00.07',NULL,NULL),(28,'Gai pâturage','Eliane Noz','Representante de ventas','Bat. B\r\n3, rue des Alpes','Annecy',NULL,'74000','Francia','38.76.98.06','38.76.98.58',NULL),(29,'Forêts d\'érables','Chantal Goulet','Gerente de contabilidad','148 rue Chasseur','Ste-Hyacinthe','Québec','J2S 7S8','Canadá','(514) 555-2955','(514) 555-2921',NULL);
/*!40000 ALTER TABLE `proveedores` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `proveedores_new`
--

DROP TABLE IF EXISTS `proveedores_new`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `proveedores_new` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `empresa` varchar(40) NOT NULL,
  `contacto` varchar(30) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `uq_proveedor` (`empresa`)
) ENGINE=InnoDB AUTO_INCREMENT=30 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `proveedores_new`
--

LOCK TABLES `proveedores_new` WRITE;
/*!40000 ALTER TABLE `proveedores_new` DISABLE KEYS */;
/*!40000 ALTER TABLE `proveedores_new` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Temporary view structure for view `totales`
--

DROP TABLE IF EXISTS `totales`;
/*!50001 DROP VIEW IF EXISTS `totales`*/;
SET @saved_cs_client     = @@character_set_client;
SET character_set_client = utf8mb4;
/*!50001 CREATE VIEW `totales` AS SELECT 
 1 AS `id`,
 1 AS `fecha_pedido`,
 1 AS `cliente_id`,
 1 AS `empleado_id`,
 1 AS `envio_id`,
 1 AS `cargo`,
 1 AS `importe`,
 1 AS `total`*/;
SET character_set_client = @saved_cs_client;

--
-- Temporary view structure for view `totales_mensuales`
--

DROP TABLE IF EXISTS `totales_mensuales`;
/*!50001 DROP VIEW IF EXISTS `totales_mensuales`*/;
SET @saved_cs_client     = @@character_set_client;
SET character_set_client = utf8mb4;
/*!50001 CREATE VIEW `totales_mensuales` AS SELECT 
 1 AS `año`,
 1 AS `mes`,
 1 AS `fecha`,
 1 AS `cargo`,
 1 AS `importe`,
 1 AS `total`,
 1 AS `num_pedidos`*/;
SET character_set_client = @saved_cs_client;

--
-- Table structure for table `usuarios`
--

DROP TABLE IF EXISTS `usuarios`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `usuarios` (
  `nombre` varchar(30) NOT NULL,
  `clave` varchar(30) DEFAULT NULL,
  PRIMARY KEY (`nombre`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `usuarios`
--

LOCK TABLES `usuarios` WRITE;
/*!40000 ALTER TABLE `usuarios` DISABLE KEYS */;
INSERT INTO `usuarios` VALUES ('marcos','999zzz');
/*!40000 ALTER TABLE `usuarios` ENABLE KEYS */;
UNLOCK TABLES;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
/*!50003 CREATE*/ /*!50017 DEFINER=`root`@`localhost`*/ /*!50003 TRIGGER `before_usuarios_update` BEFORE UPDATE ON `usuarios` FOR EACH ROW begin
  insert into clavesanteriores(nombre, clave) values (old.nombre, old.clave); 
end */;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;

--
-- Temporary view structure for view `v_empleados1`
--

DROP TABLE IF EXISTS `v_empleados1`;
/*!50001 DROP VIEW IF EXISTS `v_empleados1`*/;
SET @saved_cs_client     = @@character_set_client;
SET character_set_client = utf8mb4;
/*!50001 CREATE VIEW `v_empleados1` AS SELECT 
 1 AS `id`,
 1 AS `apellidos`,
 1 AS `nombre`,
 1 AS `cargo`,
 1 AS `tratamiento`,
 1 AS `fecha_nacimiento`,
 1 AS `fecha_contratacion`,
 1 AS `direccion`,
 1 AS `ciudad`,
 1 AS `region`,
 1 AS `cp`,
 1 AS `pais`,
 1 AS `telefono_domicilio`,
 1 AS `extension`,
 1 AS `notas`,
 1 AS `jefe_id`*/;
SET character_set_client = @saved_cs_client;

--
-- Temporary view structure for view `v_nueva`
--

DROP TABLE IF EXISTS `v_nueva`;
/*!50001 DROP VIEW IF EXISTS `v_nueva`*/;
SET @saved_cs_client     = @@character_set_client;
SET character_set_client = utf8mb4;
/*!50001 CREATE VIEW `v_nueva` AS SELECT 
 1 AS `id`,
 1 AS `producto`,
 1 AS `proveedor_id`,
 1 AS `categoria_id`,
 1 AS `cantidad_por_unidad`*/;
SET character_set_client = @saved_cs_client;

--
-- Dumping routines for database 'bd_neptuno2'
--
/*!50003 DROP FUNCTION IF EXISTS `Edad_Empleado` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` FUNCTION `Edad_Empleado`(var_id INT) RETURNS int(11)
    DETERMINISTIC
BEGIN
	declare fecha_edad int;
    
	SELECT TIMESTAMPDIFF(YEAR, empleados.fecha_nacimiento, curdate()) into fecha_edad
    FROM empleados
    WHERE empleados.id=var_id;
    
	RETURN fecha_edad;
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP FUNCTION IF EXISTS `fn_factorial` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` FUNCTION `fn_factorial`(n INT) RETURNS int(11)
    DETERMINISTIC
BEGIN

DECLARE factorial_final INT;
SET factorial_final = n ;
IF n <= 0 THEN
	RETURN 1;
END IF;

buclaso: LOOP
SET n = n - 1 ;
	IF n<1 THEN
	LEAVE buclaso;
	END IF;
SET factorial_final = factorial_final * n ;
END LOOP buclaso;

return factorial_final;

END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP FUNCTION IF EXISTS `Iniciales_Empleado` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` FUNCTION `Iniciales_Empleado`(var_id int(11)) RETURNS varchar(40) CHARSET utf8mb4
    DETERMINISTIC
BEGIN
	declare iniciales varchar(40);
	declare ape varchar(30);
	declare nom varchar(10);

	select nombre, apellidos into nom, ape
    from empleados 
    where id=var_id ;

	set iniciales=upper(concat(left(ape,1),left(nom,1)));

	RETURN iniciales;
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP FUNCTION IF EXISTS `Prefijo` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` FUNCTION `Prefijo`(cadena varchar(15), num_char int) RETURNS varchar(15) CHARSET utf8mb4
    DETERMINISTIC
BEGIN
declare pre varchar(15);
set pre=concat(upper(left(cadena,num_char)),"-");

RETURN pre;
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP FUNCTION IF EXISTS `proc_factorial` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` FUNCTION `proc_factorial`(
  numero int) RETURNS int(11)
    DETERMINISTIC
begin
	declare fact int;
	
	set fact = 1;
	
	while numero>1 do
		set fact = fact * numero;
		set numero  = numero - 1;
	end while;
  
	return fact;
end ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP FUNCTION IF EXISTS `tipo_de_via` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` FUNCTION `tipo_de_via`(direccion varchar(50)) RETURNS varchar(10) CHARSET utf8mb4
    DETERMINISTIC
begin
	declare tipoDireccion varchar(10);
	if direccion like '%Avda%' then
		set tipoDireccion="Avda";
    elseif direccion like '%Avenida%' then
		set tipoDireccion="Avenida";
	elseif direccion like '%Calle%' then
		set tipoDireccion="Calle";
	elseif direccion like '%Camino%' then
		set tipoDireccion="Camino";
	elseif direccion like '%Plaza%' then
		set tipoDireccion="Plaza";
	else 
		set tipoDireccion="NA";
    end if;

	return tipoDireccion;
end ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP FUNCTION IF EXISTS `total_pedido` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` FUNCTION `total_pedido`(var_id int) RETURNS int(11)
    DETERMINISTIC
BEGIN
	declare hola int;
    set hola = (select pedido_id, (precio_unidad * cantidad) as 'Total pedido' from detalles 
    inner join productos on detalles.peido_id = productos.id
    where productos.id = var_id);
RETURN hola;
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `Actualizar_Stock` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `Actualizar_Stock`(
	var_descripcion varchar(40),
	var_id_categoria int(11),
	var_cantidad smallint(6)
	)
BEGIN
	IF (SELECT COUNT(*) 
	   FROM Productos 
        WHERE descripcion = var_descripcion 
        AND categoria = id_categoria) = 0 THEN
		UPDATE Productos
		SET unidades_existencia = unidades_existencia + var_cantidad
		WHERE unidades_existencia > 0;
    ELSE 
		INSERT INTO productos (producto, categoria_id, unidades_existencia)
		VALUES (var_descripcion, var_id_categoria, var_cantidad);
    END IF;
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `Empleados_por_sexo` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `Empleados_por_sexo`(var_sexo varchar(6))
BEGIN
	IF var_sexo = "HOMBRE" THEN
		SELECT *, edad_empleado(id) edad
		FROM empleados
		where tratamiento IN ('Sr.', 'Dr.');  
    ELSE 
		IF var_sexo = "MUJER" THEN
			SELECT *, edad_empleado(id) edad
			FROM empleados
			where tratamiento IN ('Sra.', 'Dra.', 'Srta.');     
		END IF;
	END IF;
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `iva_nota` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `iva_nota`(var_iva decimal(4,2))
BEGIN

	update productos
	set iva = var_iva;

	update productos
	set notas = concat("Producto: ", producto, ". Precio unidad: ", precio_unidad, ". IVA: ", iva, ". Precio unidad con IVA: ", precio_unidad*iva/10);

END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `modifica_horas_mensuales` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `modifica_horas_mensuales`(var_incremento_precio_hora decimal(8,2), var_incremento_horas_trabajadas decimal(8,2), var_year year, var_mes int, var_id int(11))
BEGIN

	if var_incremento_precio_hora = null || var_incremento_horas_trabajadas = null || var_year = null || var_mes = null then
		
        select "Parámetros básicos no introducidos";
        
	end if;
    
    if var_id = null then
    
		update horas_mensuales set horas_trabajadas = var_incremento_horas_trabajadas;
UPDATE horas_mensuales 
SET 
    precio_hora = var_precio_hora;
        
    end if;
    
UPDATE horas_mensuales 
SET 
    horas_trabajadas = var_incremento_horas_trabajadas
WHERE
    año = var_year AND mes = var_mes
        AND id_empleado = var_id;
    
UPDATE horas_mensuales 
SET 
    precio_hora = var_precio_hora
WHERE
    año = var_year AND mes = var_mes
        AND id_empleado = var_id;


END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;

--
-- Final view structure for view `importes`
--

/*!50001 DROP VIEW IF EXISTS `importes`*/;
/*!50001 SET @saved_cs_client          = @@character_set_client */;
/*!50001 SET @saved_cs_results         = @@character_set_results */;
/*!50001 SET @saved_col_connection     = @@collation_connection */;
/*!50001 SET character_set_client      = utf8mb4 */;
/*!50001 SET character_set_results     = utf8mb4 */;
/*!50001 SET collation_connection      = utf8mb4_0900_ai_ci */;
/*!50001 CREATE ALGORITHM=UNDEFINED */
/*!50013 DEFINER=`root`@`localhost` SQL SECURITY DEFINER */
/*!50001 VIEW `importes` AS select `detalles`.`pedido_id` AS `pedido_id`,`detalles`.`producto_id` AS `producto_id`,`detalles`.`precio_unidad` AS `precio_unidad`,`detalles`.`cantidad` AS `cantidad`,`detalles`.`descuento` AS `descuento`,((`detalles`.`precio_unidad` * `detalles`.`cantidad`) * (1 - `detalles`.`descuento`)) AS `importe` from `detalles` */;
/*!50001 SET character_set_client      = @saved_cs_client */;
/*!50001 SET character_set_results     = @saved_cs_results */;
/*!50001 SET collation_connection      = @saved_col_connection */;

--
-- Final view structure for view `totales`
--

/*!50001 DROP VIEW IF EXISTS `totales`*/;
/*!50001 SET @saved_cs_client          = @@character_set_client */;
/*!50001 SET @saved_cs_results         = @@character_set_results */;
/*!50001 SET @saved_col_connection     = @@collation_connection */;
/*!50001 SET character_set_client      = utf8mb4 */;
/*!50001 SET character_set_results     = utf8mb4 */;
/*!50001 SET collation_connection      = utf8mb4_0900_ai_ci */;
/*!50001 CREATE ALGORITHM=UNDEFINED */
/*!50013 DEFINER=`root`@`localhost` SQL SECURITY DEFINER */
/*!50001 VIEW `totales` AS select `p`.`id` AS `id`,`p`.`fecha_pedido` AS `fecha_pedido`,`p`.`cliente_id` AS `cliente_id`,`p`.`empleado_id` AS `empleado_id`,`p`.`envio_id` AS `envio_id`,`p`.`cargo` AS `cargo`,sum(`i`.`importe`) AS `importe`,(`p`.`cargo` + sum(`i`.`importe`)) AS `total` from (`pedidos` `p` join `importes` `i` on((`p`.`id` = `i`.`pedido_id`))) group by `p`.`id` */;
/*!50001 SET character_set_client      = @saved_cs_client */;
/*!50001 SET character_set_results     = @saved_cs_results */;
/*!50001 SET collation_connection      = @saved_col_connection */;

--
-- Final view structure for view `totales_mensuales`
--

/*!50001 DROP VIEW IF EXISTS `totales_mensuales`*/;
/*!50001 SET @saved_cs_client          = @@character_set_client */;
/*!50001 SET @saved_cs_results         = @@character_set_results */;
/*!50001 SET @saved_col_connection     = @@collation_connection */;
/*!50001 SET character_set_client      = utf8mb4 */;
/*!50001 SET character_set_results     = utf8mb4 */;
/*!50001 SET collation_connection      = utf8mb4_0900_ai_ci */;
/*!50001 CREATE ALGORITHM=UNDEFINED */
/*!50013 DEFINER=`root`@`localhost` SQL SECURITY DEFINER */
/*!50001 VIEW `totales_mensuales` AS select year(`totales`.`fecha_pedido`) AS `año`,month(`totales`.`fecha_pedido`) AS `mes`,(`totales`.`fecha_pedido` + interval (1 - dayofmonth(`totales`.`fecha_pedido`)) day) AS `fecha`,round(sum(`totales`.`cargo`),0) AS `cargo`,round(sum(`totales`.`importe`),0) AS `importe`,round(sum(`totales`.`total`),0) AS `total`,count(`totales`.`id`) AS `num_pedidos` from `totales` group by year(`totales`.`fecha_pedido`),month(`totales`.`fecha_pedido`) */;
/*!50001 SET character_set_client      = @saved_cs_client */;
/*!50001 SET character_set_results     = @saved_cs_results */;
/*!50001 SET collation_connection      = @saved_col_connection */;

--
-- Final view structure for view `v_empleados1`
--

/*!50001 DROP VIEW IF EXISTS `v_empleados1`*/;
/*!50001 SET @saved_cs_client          = @@character_set_client */;
/*!50001 SET @saved_cs_results         = @@character_set_results */;
/*!50001 SET @saved_col_connection     = @@collation_connection */;
/*!50001 SET character_set_client      = utf8mb4 */;
/*!50001 SET character_set_results     = utf8mb4 */;
/*!50001 SET collation_connection      = utf8mb4_0900_ai_ci */;
/*!50001 CREATE ALGORITHM=UNDEFINED */
/*!50013 DEFINER=`root`@`localhost` SQL SECURITY DEFINER */
/*!50001 VIEW `v_empleados1` AS select `empleados`.`id` AS `id`,`empleados`.`apellidos` AS `apellidos`,`empleados`.`nombre` AS `nombre`,`empleados`.`cargo` AS `cargo`,`empleados`.`tratamiento` AS `tratamiento`,`empleados`.`fecha_nacimiento` AS `fecha_nacimiento`,`empleados`.`fecha_contratacion` AS `fecha_contratacion`,`empleados`.`direccion` AS `direccion`,`empleados`.`ciudad` AS `ciudad`,`empleados`.`region` AS `region`,`empleados`.`cp` AS `cp`,`empleados`.`pais` AS `pais`,`empleados`.`telefono_domicilio` AS `telefono_domicilio`,`empleados`.`extension` AS `extension`,`empleados`.`notas` AS `notas`,`empleados`.`jefe_id` AS `jefe_id` from `empleados` */;
/*!50001 SET character_set_client      = @saved_cs_client */;
/*!50001 SET character_set_results     = @saved_cs_results */;
/*!50001 SET collation_connection      = @saved_col_connection */;

--
-- Final view structure for view `v_nueva`
--

/*!50001 DROP VIEW IF EXISTS `v_nueva`*/;
/*!50001 SET @saved_cs_client          = @@character_set_client */;
/*!50001 SET @saved_cs_results         = @@character_set_results */;
/*!50001 SET @saved_col_connection     = @@collation_connection */;
/*!50001 SET character_set_client      = utf8mb4 */;
/*!50001 SET character_set_results     = utf8mb4 */;
/*!50001 SET collation_connection      = utf8mb4_0900_ai_ci */;
/*!50001 CREATE ALGORITHM=UNDEFINED */
/*!50013 DEFINER=`root`@`localhost` SQL SECURITY DEFINER */
/*!50001 VIEW `v_nueva` AS select `productos`.`id` AS `id`,`productos`.`producto` AS `producto`,`productos`.`proveedor_id` AS `proveedor_id`,`productos`.`categoria_id` AS `categoria_id`,`productos`.`cantidad_por_unidad` AS `cantidad_por_unidad` from (`productos` join `categorias` on((`productos`.`categoria_id` = `categorias`.`id`))) */;
/*!50001 SET character_set_client      = @saved_cs_client */;
/*!50001 SET character_set_results     = @saved_cs_results */;
/*!50001 SET collation_connection      = @saved_col_connection */;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2020-11-13  4:18:45
