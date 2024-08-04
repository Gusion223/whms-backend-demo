-- MySQL dump 10.13  Distrib 8.0.36, for Win64 (x86_64)
--
-- Host: localhost    Database: whms
-- ------------------------------------------------------
-- Server version	8.0.36

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
-- Table structure for table `backup`
--

DROP TABLE IF EXISTS `backup`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `backup` (
  `bid` int NOT NULL AUTO_INCREMENT COMMENT '数据库备份id',
  `id` int DEFAULT NULL COMMENT '创建的用户id',
  `auto_create` enum('Y','N') NOT NULL COMMENT '是否由系统自动创建',
  `btime` datetime NOT NULL COMMENT '备份时间',
  `bdesc` varchar(150) NOT NULL COMMENT '备份描述',
  `bfilepath` varchar(255) NOT NULL COMMENT '备份文件的路径',
  `btype` smallint NOT NULL DEFAULT '0' COMMENT '备份类型, 0为完全备份',
  PRIMARY KEY (`bid`),
  KEY `id` (`id`),
  KEY `btime` (`btime`) USING BTREE,
  CONSTRAINT `backup_ibfk_1` FOREIGN KEY (`id`) REFERENCES `user` (`id`) ON DELETE SET NULL ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=33 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Temporary view structure for view `backupuser`
--

DROP TABLE IF EXISTS `backupuser`;
/*!50001 DROP VIEW IF EXISTS `backupuser`*/;
SET @saved_cs_client     = @@character_set_client;
/*!50503 SET character_set_client = utf8mb4 */;
/*!50001 CREATE VIEW `backupuser` AS SELECT 
 1 AS `bid`,
 1 AS `id`,
 1 AS `auto_create`,
 1 AS `btime`,
 1 AS `bdesc`,
 1 AS `bfilepath`,
 1 AS `btype`,
 1 AS `user_name`*/;
SET character_set_client = @saved_cs_client;

--
-- Table structure for table `customer`
--

DROP TABLE IF EXISTS `customer`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `customer` (
  `cid` int NOT NULL AUTO_INCREMENT COMMENT '顾客id',
  `csex` int DEFAULT NULL COMMENT '顾客性别',
  `cage` int DEFAULT NULL COMMENT '顾客年龄',
  `cname` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '顾客名称',
  `caddr` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '顾客居住地点',
  `cphone` char(11) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '顾客手机号码',
  PRIMARY KEY (`cid`),
  UNIQUE KEY `caddr` (`caddr`),
  UNIQUE KEY `cphone` (`cphone`),
  UNIQUE KEY `cid` (`cid`),
  CONSTRAINT `customer_chk_2` CHECK ((`cage` > 0))
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `good`
--

DROP TABLE IF EXISTS `good`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `good` (
  `gid` int NOT NULL AUTO_INCREMENT COMMENT '商品id',
  `gname` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '商品名称',
  `gtype` varchar(12) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '商品类型',
  `gunit_price` decimal(6,2) NOT NULL COMMENT '商品零售价格',
  `gunit` char(6) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '商品单位',
  PRIMARY KEY (`gid`),
  UNIQUE KEY `gname` (`gname`),
  CONSTRAINT `good_chk_1` CHECK ((`gunit_price` > 0.00))
) ENGINE=InnoDB AUTO_INCREMENT=32 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Temporary view structure for view `powarehousesupplieruser`
--

DROP TABLE IF EXISTS `powarehousesupplieruser`;
/*!50001 DROP VIEW IF EXISTS `powarehousesupplieruser`*/;
SET @saved_cs_client     = @@character_set_client;
/*!50503 SET character_set_client = utf8mb4 */;
/*!50001 CREATE VIEW `powarehousesupplieruser` AS SELECT 
 1 AS `sid`,
 1 AS `sname`,
 1 AS `saddr`,
 1 AS `sphone`,
 1 AS `sdesc`,
 1 AS `wid`,
 1 AS `wname`,
 1 AS `waddr`,
 1 AS `poid`,
 1 AS `potime`,
 1 AS `pototal_cost`,
 1 AS `nick_name`,
 1 AS `id`*/;
SET character_set_client = @saved_cs_client;

--
-- Table structure for table `purchase_detail`
--

DROP TABLE IF EXISTS `purchase_detail`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `purchase_detail` (
  `poid` int NOT NULL COMMENT '订货订单id',
  `gid` int NOT NULL COMMENT '商品id',
  `pdamount` int DEFAULT NULL COMMENT '商品数量',
  `pdtotal_cost` decimal(10,2) DEFAULT NULL COMMENT '进货开销',
  PRIMARY KEY (`poid`,`gid`) USING BTREE,
  KEY `gid` (`gid`),
  CONSTRAINT `purchase_detail_ibfk_1` FOREIGN KEY (`gid`) REFERENCES `good` (`gid`) ON DELETE RESTRICT ON UPDATE CASCADE,
  CONSTRAINT `purchase_detail_ibfk_2` FOREIGN KEY (`poid`) REFERENCES `purchase_order` (`poid`) ON DELETE RESTRICT ON UPDATE CASCADE,
  CONSTRAINT `purchase_detail_chk_1` CHECK ((`pdamount` > 0)),
  CONSTRAINT `purchase_detail_chk_2` CHECK ((`pdtotal_cost` > 0))
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
/*!50003 CREATE*/ /*!50017 DEFINER=`root`@`%`*/ /*!50003 TRIGGER `pd_insert` AFTER INSERT ON `purchase_detail` FOR EACH ROW BEGIN
	DECLARE target_wid INT;
	DECLARE exist_record INT;

	UPDATE purchase_order SET pototal_cost=pototal_cost+new.pdtotal_cost WHERE poid=new.poid;	
	
	SELECT wid into target_wid FROM purchase_order WHERE poid = new.poid;
	if(target_wid is not NULL) THEN
		SELECT COUNT(wid) INTO exist_record FROM store_record WHERE wid=target_wid and gid=new.gid;
		IF(exist_record=0) THEN
			INSERT INTO store_record VALUES (target_wid, new.gid, 0);
		END IF;
		UPDATE store_record SET sramount=sramount+new.pdamount WHERE wid=target_wid and gid=new.gid;
	END IF;

END */;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
/*!50003 CREATE*/ /*!50017 DEFINER=`root`@`%`*/ /*!50003 TRIGGER `pd_update` AFTER UPDATE ON `purchase_detail` FOR EACH ROW BEGIN
	DECLARE target_wid INT;
	DECLARE exist_record INT;

	UPDATE purchase_order SET pototal_cost=pototal_cost+new.pdtotal_cost WHERE poid=new.poid;

	SELECT wid into target_wid FROM purchase_order WHERE poid = new.poid;
	if(target_wid is not NULL) THEN
		SELECT COUNT(wid) INTO exist_record FROM store_record WHERE wid=target_wid and gid=new.gid;
		IF(exist_record=0) THEN
			INSERT INTO store_record VALUES (target_wid, new.gid, 0);
		END IF;
		UPDATE store_record SET sramount=sramount+new.pdamount WHERE wid=target_wid and gid=new.gid;
	END IF;
	
	UPDATE purchase_order SET pototal_cost=pototal_cost-old.pdtotal_cost WHERE poid=old.poid;
	SELECT wid into target_wid FROM purchase_order WHERE poid = old.poid;
	if(target_wid is not NULL) THEN
		SELECT COUNT(wid) INTO exist_record FROM store_record WHERE wid=target_wid and gid=old.gid;
		IF(exist_record=1) THEN
			UPDATE store_record SET sramount=sramount-old.pdamount WHERE wid=target_wid and gid=old.gid;
		END IF;
	END IF;	
END */;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
/*!50003 CREATE*/ /*!50017 DEFINER=`root`@`%`*/ /*!50003 TRIGGER `pd_delete` AFTER DELETE ON `purchase_detail` FOR EACH ROW BEGIN
	DECLARE target_wid INT;
	DECLARE exist_record INT;

	UPDATE purchase_order SET pototal_cost=pototal_cost-old.pdtotal_cost WHERE poid=old.poid;
	SELECT wid into target_wid FROM purchase_order WHERE poid = old.poid;
	if(target_wid is not NULL) THEN
		SELECT COUNT(wid) INTO exist_record FROM store_record WHERE wid=target_wid and gid=old.gid;
		IF(exist_record=1) THEN
			UPDATE store_record SET sramount=sramount-old.pdamount WHERE wid=target_wid and gid=old.gid;
		END IF;
	END IF;	
END */;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;

--
-- Table structure for table `purchase_order`
--

DROP TABLE IF EXISTS `purchase_order`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `purchase_order` (
  `poid` int NOT NULL AUTO_INCREMENT COMMENT '入库记录id',
  `id` int DEFAULT NULL COMMENT '操作员id',
  `sid` int DEFAULT NULL COMMENT '供应商id',
  `wid` int DEFAULT NULL COMMENT '入库仓库id',
  `potime` datetime NOT NULL COMMENT '入库操作的时间',
  `pototal_cost` decimal(10,2) NOT NULL DEFAULT '0.00' COMMENT '入库订货的总成本',
  PRIMARY KEY (`poid`),
  KEY `id` (`id`),
  KEY `sid` (`sid`),
  KEY `wid` (`wid`),
  KEY `potime` (`potime`) USING BTREE,
  CONSTRAINT `purchase_order_ibfk_1` FOREIGN KEY (`id`) REFERENCES `user` (`id`) ON DELETE SET NULL ON UPDATE CASCADE,
  CONSTRAINT `purchase_order_ibfk_2` FOREIGN KEY (`sid`) REFERENCES `supplier` (`sid`) ON DELETE SET NULL ON UPDATE CASCADE,
  CONSTRAINT `purchase_order_ibfk_3` FOREIGN KEY (`wid`) REFERENCES `warehouse` (`wid`) ON DELETE SET NULL ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=30 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `s_g`
--

DROP TABLE IF EXISTS `s_g`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `s_g` (
  `sid` int NOT NULL COMMENT '供应商id',
  `gid` int NOT NULL COMMENT '供应商品的id',
  `gunit_cost` decimal(6,2) NOT NULL COMMENT '商品购入单价',
  PRIMARY KEY (`sid`,`gid`) USING BTREE,
  KEY `gid` (`gid`),
  CONSTRAINT `s_g_ibfk_1` FOREIGN KEY (`sid`) REFERENCES `supplier` (`sid`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `s_g_ibfk_2` FOREIGN KEY (`gid`) REFERENCES `good` (`gid`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `s_g_chk_1` CHECK ((`gunit_cost` > 0))
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `sale_detail`
--

DROP TABLE IF EXISTS `sale_detail`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `sale_detail` (
  `soid` int NOT NULL COMMENT '销售记录id',
  `gid` int NOT NULL COMMENT '销售商品id',
  `sdamount` int NOT NULL DEFAULT '0' COMMENT '销售商品数量',
  `sdtotal` decimal(8,2) NOT NULL DEFAULT '0.00' COMMENT '销售总数',
  PRIMARY KEY (`soid`,`gid`) USING BTREE,
  KEY `gid` (`gid`),
  CONSTRAINT `sale_detail_ibfk_1` FOREIGN KEY (`soid`) REFERENCES `sale_order` (`soid`) ON DELETE RESTRICT ON UPDATE CASCADE,
  CONSTRAINT `sale_detail_ibfk_2` FOREIGN KEY (`gid`) REFERENCES `good` (`gid`) ON DELETE RESTRICT ON UPDATE CASCADE,
  CONSTRAINT `sale_detail_chk_1` CHECK ((`sdamount` > 0))
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
/*!50003 CREATE*/ /*!50017 DEFINER=`root`@`%`*/ /*!50003 TRIGGER `sd_insert` AFTER INSERT ON `sale_detail` FOR EACH ROW BEGIN
	DECLARE new_from_wid, record_exist INT;
	UPDATE sale_order SET sototal = sototal + new.sdtotal WHERE soid=new.soid;
	SELECT wid INTO new_from_wid FROM sale_order WHERE soid=new.soid;
	IF(new_from_wid is not NULL)THEN
		SELECT COUNT(*) INTO record_exist FROM store_record WHERE wid=new_from_wid and gid=new.gid;
		IF(record_exist=1)THEN
			UPDATE store_record SET sramount=sramount-new.sdamount WHERE wid=new_from_wid and gid=new.gid;
		END IF;
	END IF;
END */;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
/*!50003 CREATE*/ /*!50017 DEFINER=`root`@`%`*/ /*!50003 TRIGGER `sd_update` AFTER UPDATE ON `sale_detail` FOR EACH ROW BEGIN
	DECLARE new_from_wid, record_exist INT;
	DECLARE old_from_wid INT;
	
	UPDATE sale_order SET sototal = sototal + new.sdtotal WHERE soid=new.soid;
	SELECT wid INTO new_from_wid FROM sale_order WHERE soid=new.soid;
	IF(new_from_wid is not NULL)THEN
		SELECT COUNT(*) INTO record_exist FROM store_record WHERE wid=new_from_wid and gid=new.gid;
		IF(record_exist=1)THEN
			UPDATE store_record SET sramount=sramount-new.sdamount WHERE wid=new_from_wid and gid=new.gid;
		END IF;
	END IF;
	

	UPDATE sale_order SET sototal = sototal - old.sdtotal WHERE soid=new.soid;
	SELECT wid INTO old_from_wid FROM sale_order WHERE soid= old.soid;
	IF(old_from_wid is not NULL)THEN
		SELECT COUNT(*) INTO record_exist FROM store_record WHERE wid=old_from_wid and gid=old.gid;
		IF(record_exist=0)THEN
			INSERT INTO store_record VALUES(old_from_wid, old.gid, old.sdamount);
		ELSE 
			UPDATE store_record SET sramount=sramount+old.sdamount WHERE wid=old_from_wid and gid=old.gid;
		END IF;
	END IF;
END */;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
/*!50003 CREATE*/ /*!50017 DEFINER=`root`@`%`*/ /*!50003 TRIGGER `sd_delete` AFTER DELETE ON `sale_detail` FOR EACH ROW BEGIN
	DECLARE old_from_wid, record_exist INT;
	UPDATE sale_order SET sototal = sototal - old.sdtotal;
	SELECT wid INTO old_from_wid FROM sale_order WHERE soid= old.soid;
	IF(old_from_wid is not NULL)THEN
		SELECT COUNT(*) INTO record_exist FROM store_record WHERE wid=old_from_wid and gid=old.gid;
		IF(record_exist=0)THEN
			INSERT INTO store_record VALUES(old_from_wid, old.gid, old.sdamount);
		ELSE 
			UPDATE store_record SET sramount=sramount+old.sdamount WHERE wid=old_from_wid and gid=old.gid;
		END IF;
	END IF;
END */;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;

--
-- Table structure for table `sale_order`
--

DROP TABLE IF EXISTS `sale_order`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `sale_order` (
  `soid` int NOT NULL AUTO_INCREMENT COMMENT '销售记录id',
  `cid` int DEFAULT NULL COMMENT '顾客id',
  `wid` int DEFAULT NULL COMMENT '仓库id',
  `id` int DEFAULT NULL COMMENT '业务员id',
  `sotime` datetime NOT NULL COMMENT '销售时间',
  `sototal` decimal(10,2) NOT NULL DEFAULT '0.00' COMMENT '销售总金额',
  PRIMARY KEY (`soid`),
  KEY `cid` (`cid`),
  KEY `id` (`id`),
  KEY `wid` (`wid`),
  KEY `sotime` (`sotime`) USING BTREE,
  CONSTRAINT `sale_order_ibfk_1` FOREIGN KEY (`cid`) REFERENCES `customer` (`cid`) ON DELETE SET NULL ON UPDATE CASCADE,
  CONSTRAINT `sale_order_ibfk_2` FOREIGN KEY (`id`) REFERENCES `user` (`id`) ON DELETE SET NULL ON UPDATE CASCADE,
  CONSTRAINT `sale_order_ibfk_3` FOREIGN KEY (`wid`) REFERENCES `warehouse` (`wid`) ON DELETE SET NULL ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=41 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Temporary view structure for view `sowarehousecustomeruser`
--

DROP TABLE IF EXISTS `sowarehousecustomeruser`;
/*!50001 DROP VIEW IF EXISTS `sowarehousecustomeruser`*/;
SET @saved_cs_client     = @@character_set_client;
/*!50503 SET character_set_client = utf8mb4 */;
/*!50001 CREATE VIEW `sowarehousecustomeruser` AS SELECT 
 1 AS `soid`,
 1 AS `cid`,
 1 AS `wid`,
 1 AS `id`,
 1 AS `sotime`,
 1 AS `sototal`,
 1 AS `cname`,
 1 AS `wname`,
 1 AS `nick_name`*/;
SET character_set_client = @saved_cs_client;

--
-- Temporary view structure for view `srwarehousegood`
--

DROP TABLE IF EXISTS `srwarehousegood`;
/*!50001 DROP VIEW IF EXISTS `srwarehousegood`*/;
SET @saved_cs_client     = @@character_set_client;
/*!50503 SET character_set_client = utf8mb4 */;
/*!50001 CREATE VIEW `srwarehousegood` AS SELECT 
 1 AS `wid`,
 1 AS `gid`,
 1 AS `sramount`,
 1 AS `wname`,
 1 AS `gname`,
 1 AS `gunit`,
 1 AS `gunit_price`,
 1 AS `gtype`*/;
SET character_set_client = @saved_cs_client;

--
-- Table structure for table `store_record`
--

DROP TABLE IF EXISTS `store_record`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `store_record` (
  `wid` int NOT NULL COMMENT '仓库id',
  `gid` int NOT NULL COMMENT '商品id',
  `sramount` int NOT NULL COMMENT '存储数量',
  PRIMARY KEY (`wid`,`gid`),
  KEY `gid` (`gid`),
  CONSTRAINT `store_record_ibfk_1` FOREIGN KEY (`wid`) REFERENCES `warehouse` (`wid`) ON DELETE RESTRICT ON UPDATE CASCADE,
  CONSTRAINT `store_record_ibfk_2` FOREIGN KEY (`gid`) REFERENCES `good` (`gid`) ON DELETE RESTRICT ON UPDATE CASCADE,
  CONSTRAINT `store_record_chk_1` CHECK ((`sramount` >= 0))
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `supplier`
--

DROP TABLE IF EXISTS `supplier`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `supplier` (
  `sid` int NOT NULL AUTO_INCREMENT COMMENT '供货商id',
  `sname` varchar(12) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '供货商名称',
  `saddr` varchar(15) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '供货商地址',
  `sphone` char(11) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '供货商联系电话',
  `sdesc` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '供货商描述',
  PRIMARY KEY (`sid`),
  UNIQUE KEY `sname` (`sname`) USING BTREE,
  KEY `sphone` (`sphone`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=20 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `test_time`
--

DROP TABLE IF EXISTS `test_time`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `test_time` (
  `tid` int NOT NULL AUTO_INCREMENT,
  PRIMARY KEY (`tid`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Temporary view structure for view `towarehouseuser`
--

DROP TABLE IF EXISTS `towarehouseuser`;
/*!50001 DROP VIEW IF EXISTS `towarehouseuser`*/;
SET @saved_cs_client     = @@character_set_client;
/*!50503 SET character_set_client = utf8mb4 */;
/*!50001 CREATE VIEW `towarehouseuser` AS SELECT 
 1 AS `toid`,
 1 AS `id`,
 1 AS `wid_prev`,
 1 AS `wid_cur`,
 1 AS `totime`,
 1 AS `wname_prev`,
 1 AS `wname_cur`,
 1 AS `nick_name`*/;
SET character_set_client = @saved_cs_client;

--
-- Table structure for table `transfer_detail`
--

DROP TABLE IF EXISTS `transfer_detail`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `transfer_detail` (
  `toid` int NOT NULL COMMENT '转储指令id',
  `gid` int NOT NULL COMMENT '商品id',
  `tdamount` int NOT NULL COMMENT '转储商品数量',
  PRIMARY KEY (`toid`,`gid`),
  KEY `gid` (`gid`),
  CONSTRAINT `transfer_detail_ibfk_1` FOREIGN KEY (`toid`) REFERENCES `transfer_order` (`toid`) ON DELETE RESTRICT ON UPDATE CASCADE,
  CONSTRAINT `transfer_detail_ibfk_2` FOREIGN KEY (`gid`) REFERENCES `good` (`gid`) ON DELETE RESTRICT ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
/*!50003 CREATE*/ /*!50017 DEFINER=`root`@`%`*/ /*!50003 TRIGGER `td_insert` AFTER INSERT ON `transfer_detail` FOR EACH ROW BEGIN
	DECLARE new_target_wid, new_from_wid, exist_record INT;
	SELECT wid_prev, wid_cur INTO new_from_wid, new_target_wid FROM transfer_order WHERE toid=new.toid;
	IF(new_from_wid is not NULL)THEN
		SELECT COUNT(*) INTO exist_record FROM store_record WHERE wid=new_from_wid and gid=new.gid;
		IF(exist_record=1)THEN
			UPDATE store_record SET sramount = sramount-new.tdamount WHERE wid=new_from_wid and gid=new.gid;
		END IF;
	END IF;
	
	IF(new_target_wid is not NULL)THEN
		SELECT COUNT(*) INTO exist_record FROM store_record WHERE wid=new_target_wid and gid=new.gid;
		IF(exist_record=0)THEN
			INSERT INTO store_record VALUES(new_target_wid,new.gid, new.tdamount);
		ELSE
			UPDATE store_record SET sramount = sramount+new.tdamount WHERE wid=new_target_wid and gid=new.gid;
		END IF;
	END IF;
END */;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
/*!50003 CREATE*/ /*!50017 DEFINER=`root`@`%`*/ /*!50003 TRIGGER `td_update` AFTER UPDATE ON `transfer_detail` FOR EACH ROW BEGIN
	DECLARE new_target_wid, new_from_wid, exist_record INT;
	DECLARE old_target_wid, old_from_wid INT;
	SELECT wid_prev, wid_cur INTO new_from_wid, new_target_wid FROM transfer_order WHERE toid=new.toid;
	IF(new_from_wid is not NULL)THEN
		SELECT COUNT(*) INTO exist_record FROM store_record WHERE wid=new_from_wid and gid=new.gid;
		IF(exist_record=1)THEN
			UPDATE store_record SET sramount = sramount-new.tdamount WHERE wid=new_from_wid and gid=new.gid;
		END IF;
	END IF;
	
	IF(new_target_wid is not NULL)THEN
		SELECT COUNT(*) INTO exist_record FROM store_record WHERE wid=new_target_wid and gid=new.gid;
		IF(exist_record=0)THEN
			INSERT INTO store_record VALUES(new_target_wid,new.gid, new.tdamount);
		ELSE
			UPDATE store_record SET sramount = sramount+new.tdamount WHERE wid=new_target_wid and gid=new.gid;
		END IF;
	END IF;
	

	SELECT wid_prev, wid_cur INTO old_from_wid, old_target_wid FROM transfer_order WHERE toid=old.toid;
	IF(old_from_wid is not NULL)THEN
		SELECT COUNT(*) INTO exist_record FROM store_record WHERE wid=old_from_wid and gid=old.gid;
		IF(exist_record=0)THEN
			INSERT INTO store_record VALUES (old_from_wid, old.gid, old.tdamount);
		ELSE 
			UPDATE store_record SET sramount = sramount+old.tdamount WHERE wid=old_from_wid and gid=old.gid;
		END IF;
	END IF;
	
	IF(old_target_wid is not NULL)THEN
		SELECT COUNT(*) INTO exist_record FROM store_record WHERE wid=old_target_wid and gid=old.gid;
		IF(exist_record=1)THEN
			UPDATE store_record SET sramount=sramount-old.tdamount WHERE wid=old_target_wid and gid=old.gid;
		END IF;
	END IF;
	
END */;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
/*!50003 CREATE*/ /*!50017 DEFINER=`root`@`%`*/ /*!50003 TRIGGER `td_delete` AFTER DELETE ON `transfer_detail` FOR EACH ROW BEGIN
	DECLARE old_target_wid, old_from_wid, exist_record INT;
	SELECT wid_prev, wid_cur INTO old_from_wid, old_target_wid FROM transfer_order WHERE toid=old.toid;
	IF(old_from_wid is not NULL)THEN
		SELECT COUNT(*) INTO exist_record FROM store_record WHERE wid=old_from_wid and gid=old.gid;
		IF(exist_record=0)THEN
			INSERT INTO store_record VALUES (old_from_wid, old.gid, old.tdamount);
		ELSE 
			UPDATE store_record SET sramount = sramount+old.tdamount WHERE wid=old_from_wid and gid=old.gid;
		END IF;
	END IF;
	
	IF(old_target_wid is not NULL)THEN
		SELECT COUNT(*) INTO exist_record FROM store_record WHERE wid=old_target_wid and gid=old.gid;
		IF(exist_record=1)THEN
			UPDATE store_record SET sramount=sramount-old.tdamount WHERE wid=old_target_wid and gid=old.gid;
		END IF;
	END IF;
	
END */;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;

--
-- Table structure for table `transfer_order`
--

DROP TABLE IF EXISTS `transfer_order`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `transfer_order` (
  `toid` int NOT NULL AUTO_INCREMENT COMMENT '转储记录id',
  `id` int DEFAULT NULL COMMENT '操作人员',
  `wid_prev` int DEFAULT NULL COMMENT '先前存储仓库的id',
  `wid_cur` int DEFAULT NULL COMMENT '后续存储的仓库id',
  `totime` datetime NOT NULL COMMENT '转储操作的时间',
  PRIMARY KEY (`toid`),
  KEY `wid_prev` (`wid_prev`),
  KEY `wid_cur` (`wid_cur`),
  KEY `id` (`id`),
  KEY `totime` (`totime`) USING BTREE,
  CONSTRAINT `transfer_order_ibfk_1` FOREIGN KEY (`wid_prev`) REFERENCES `warehouse` (`wid`) ON DELETE SET NULL ON UPDATE CASCADE,
  CONSTRAINT `transfer_order_ibfk_2` FOREIGN KEY (`wid_cur`) REFERENCES `warehouse` (`wid`) ON DELETE SET NULL ON UPDATE CASCADE,
  CONSTRAINT `transfer_order_ibfk_3` FOREIGN KEY (`id`) REFERENCES `user` (`id`) ON DELETE SET NULL ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `user`
--

DROP TABLE IF EXISTS `user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `user` (
  `id` int NOT NULL AUTO_INCREMENT COMMENT '主键',
  `user_name` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '账号',
  `nick_name` varchar(90) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '姓名',
  `password` varchar(20) NOT NULL COMMENT '密码',
  `age` int NOT NULL COMMENT '年龄',
  `sex` int NOT NULL COMMENT '性别',
  `phone` varchar(11) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '电话',
  `user_type` int NOT NULL COMMENT '角色 0为管理员, 1为销售员，2为仓管员',
  `isValid` varchar(4) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL DEFAULT 'Y' COMMENT 'Y为有效，其他均无效',
  PRIMARY KEY (`id`),
  UNIQUE KEY `unique_user_name` (`user_name`) USING BTREE COMMENT '用户名/登录账号是唯一的',
  KEY `normal_nick_name` (`nick_name`) USING BTREE,
  KEY `normal_user_type` (`user_type`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=60 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `warehouse`
--

DROP TABLE IF EXISTS `warehouse`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `warehouse` (
  `wid` int NOT NULL AUTO_INCREMENT COMMENT '仓库id\r\n',
  `wname` varchar(24) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '仓库名称',
  `waddr` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '仓库地址',
  PRIMARY KEY (`wid`),
  UNIQUE KEY `wname` (`wname`),
  UNIQUE KEY `wid` (`wid`)
) ENGINE=InnoDB AUTO_INCREMENT=14 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Final view structure for view `backupuser`
--

/*!50001 DROP VIEW IF EXISTS `backupuser`*/;
/*!50001 SET @saved_cs_client          = @@character_set_client */;
/*!50001 SET @saved_cs_results         = @@character_set_results */;
/*!50001 SET @saved_col_connection     = @@collation_connection */;
/*!50001 SET character_set_client      = utf8mb4 */;
/*!50001 SET character_set_results     = utf8mb4 */;
/*!50001 SET collation_connection      = utf8mb4_0900_ai_ci */;
/*!50001 CREATE ALGORITHM=UNDEFINED */
/*!50013 DEFINER=`root`@`localhost` SQL SECURITY DEFINER */
/*!50001 VIEW `backupuser` AS select `b`.`bid` AS `bid`,`b`.`id` AS `id`,`b`.`auto_create` AS `auto_create`,`b`.`btime` AS `btime`,`b`.`bdesc` AS `bdesc`,`b`.`bfilepath` AS `bfilepath`,`b`.`btype` AS `btype`,`u`.`user_name` AS `user_name` from (`backup` `b` left join `user` `u` on((`b`.`id` = `u`.`id`))) */;
/*!50001 SET character_set_client      = @saved_cs_client */;
/*!50001 SET character_set_results     = @saved_cs_results */;
/*!50001 SET collation_connection      = @saved_col_connection */;

--
-- Final view structure for view `powarehousesupplieruser`
--

/*!50001 DROP VIEW IF EXISTS `powarehousesupplieruser`*/;
/*!50001 SET @saved_cs_client          = @@character_set_client */;
/*!50001 SET @saved_cs_results         = @@character_set_results */;
/*!50001 SET @saved_col_connection     = @@collation_connection */;
/*!50001 SET character_set_client      = utf8mb4 */;
/*!50001 SET character_set_results     = utf8mb4 */;
/*!50001 SET collation_connection      = utf8mb4_0900_ai_ci */;
/*!50001 CREATE ALGORITHM=UNDEFINED */
/*!50013 DEFINER=`root`@`%` SQL SECURITY DEFINER */
/*!50001 VIEW `powarehousesupplieruser` AS select `s`.`sid` AS `sid`,`s`.`sname` AS `sname`,`s`.`saddr` AS `saddr`,`s`.`sphone` AS `sphone`,`s`.`sdesc` AS `sdesc`,`w`.`wid` AS `wid`,`w`.`wname` AS `wname`,`w`.`waddr` AS `waddr`,`po`.`poid` AS `poid`,`po`.`potime` AS `potime`,`po`.`pototal_cost` AS `pototal_cost`,`u`.`nick_name` AS `nick_name`,`u`.`id` AS `id` from (((`purchase_order` `po` left join `supplier` `s` on((`s`.`sid` = `po`.`sid`))) left join `warehouse` `w` on((`w`.`wid` = `po`.`wid`))) left join `user` `u` on((`u`.`id` = `po`.`id`))) */;
/*!50001 SET character_set_client      = @saved_cs_client */;
/*!50001 SET character_set_results     = @saved_cs_results */;
/*!50001 SET collation_connection      = @saved_col_connection */;

--
-- Final view structure for view `sowarehousecustomeruser`
--

/*!50001 DROP VIEW IF EXISTS `sowarehousecustomeruser`*/;
/*!50001 SET @saved_cs_client          = @@character_set_client */;
/*!50001 SET @saved_cs_results         = @@character_set_results */;
/*!50001 SET @saved_col_connection     = @@collation_connection */;
/*!50001 SET character_set_client      = utf8mb4 */;
/*!50001 SET character_set_results     = utf8mb4 */;
/*!50001 SET collation_connection      = utf8mb4_0900_ai_ci */;
/*!50001 CREATE ALGORITHM=UNDEFINED */
/*!50013 DEFINER=`root`@`%` SQL SECURITY DEFINER */
/*!50001 VIEW `sowarehousecustomeruser` AS select `so`.`soid` AS `soid`,`so`.`cid` AS `cid`,`so`.`wid` AS `wid`,`so`.`id` AS `id`,`so`.`sotime` AS `sotime`,`so`.`sototal` AS `sototal`,`c`.`cname` AS `cname`,`w`.`wname` AS `wname`,`u`.`nick_name` AS `nick_name` from (((`sale_order` `so` left join `customer` `c` on((`so`.`cid` = `c`.`cid`))) left join `warehouse` `w` on((`so`.`wid` = `w`.`wid`))) left join `user` `u` on((`so`.`id` = `u`.`id`))) */;
/*!50001 SET character_set_client      = @saved_cs_client */;
/*!50001 SET character_set_results     = @saved_cs_results */;
/*!50001 SET collation_connection      = @saved_col_connection */;

--
-- Final view structure for view `srwarehousegood`
--

/*!50001 DROP VIEW IF EXISTS `srwarehousegood`*/;
/*!50001 SET @saved_cs_client          = @@character_set_client */;
/*!50001 SET @saved_cs_results         = @@character_set_results */;
/*!50001 SET @saved_col_connection     = @@collation_connection */;
/*!50001 SET character_set_client      = utf8mb4 */;
/*!50001 SET character_set_results     = utf8mb4 */;
/*!50001 SET collation_connection      = utf8mb4_0900_ai_ci */;
/*!50001 CREATE ALGORITHM=UNDEFINED */
/*!50013 DEFINER=`root`@`%` SQL SECURITY DEFINER */
/*!50001 VIEW `srwarehousegood` AS select `sr`.`wid` AS `wid`,`sr`.`gid` AS `gid`,`sr`.`sramount` AS `sramount`,`w`.`wname` AS `wname`,`g`.`gname` AS `gname`,`g`.`gunit` AS `gunit`,`g`.`gunit_price` AS `gunit_price`,`g`.`gtype` AS `gtype` from ((`store_record` `sr` left join `good` `g` on((`g`.`gid` = `sr`.`gid`))) left join `warehouse` `w` on((`w`.`wid` = `sr`.`wid`))) */;
/*!50001 SET character_set_client      = @saved_cs_client */;
/*!50001 SET character_set_results     = @saved_cs_results */;
/*!50001 SET collation_connection      = @saved_col_connection */;

--
-- Final view structure for view `towarehouseuser`
--

/*!50001 DROP VIEW IF EXISTS `towarehouseuser`*/;
/*!50001 SET @saved_cs_client          = @@character_set_client */;
/*!50001 SET @saved_cs_results         = @@character_set_results */;
/*!50001 SET @saved_col_connection     = @@collation_connection */;
/*!50001 SET character_set_client      = utf8mb4 */;
/*!50001 SET character_set_results     = utf8mb4 */;
/*!50001 SET collation_connection      = utf8mb4_0900_ai_ci */;
/*!50001 CREATE ALGORITHM=UNDEFINED */
/*!50013 DEFINER=`root`@`%` SQL SECURITY DEFINER */
/*!50001 VIEW `towarehouseuser` AS select `tro`.`toid` AS `toid`,`tro`.`id` AS `id`,`tro`.`wid_prev` AS `wid_prev`,`tro`.`wid_cur` AS `wid_cur`,`tro`.`totime` AS `totime`,`wp`.`wname` AS `wname_prev`,`wc`.`wname` AS `wname_cur`,`u`.`nick_name` AS `nick_name` from (((`transfer_order` `tro` left join `warehouse` `wp` on((`wp`.`wid` = `tro`.`wid_prev`))) left join `warehouse` `wc` on((`wc`.`wid` = `tro`.`wid_cur`))) left join `user` `u` on((`u`.`id` = `tro`.`id`))) */;
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

-- Dump completed on 2024-08-04 11:08:48
