SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

DROP DATABASE IF EXISTS routes;
CREATE DATABASE IF NOT EXISTS routes DEFAULT CHARACTER SET utf8 COLLATE utf8_general_ci;
USE routes;

DROP TABLE IF EXISTS ROUTE;
CREATE TABLE IF NOT EXISTS ROUTE (
  ROUTEID int(11) NOT NULL AUTO_INCREMENT,
  ROUTETITLE varchar(30) NOT NULL,
  DEPARTUREPOINT varchar(30) NOT NULL,
  PRIMARY KEY (ROUTEID)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;

INSERT INTO ROUTE (ROUTEID, ROUTETITLE, DEPARTUREPOINT) VALUES
(1, 'Oor Wullie Route', 'GCU'),
(2, 'Religious Route', 'Glasgow Cathedral'),
(3, 'Art Route', 'Kelvingrove Art Gallery and Museum'),
(4, 'Education Route', 'GCU');

DROP TABLE IF EXISTS STAGE;
CREATE TABLE IF NOT EXISTS STAGE (
  STAGEID int(11) NOT NULL AUTO_INCREMENT,
  STAGENUMBER int(11) NOT NULL,
  ENDPOINT varchar(30) NOT NULL,
  STAGELENGTH DECIMAL(5,2) NOT NULL,
  ROUTEID int(11) NOT NULL,
  PRIMARY KEY (STAGEID),
  KEY ALBUMID (ROUTEID)
) ENGINE=InnoDB AUTO_INCREMENT=33 DEFAULT CHARSET=utf8;

INSERT INTO STAGE (STAGEID, STAGENUMBER, ENDPOINT, STAGELENGTH, ROUTEID) VALUES
(1, 1, 'City Chambers', 0.75, 1),
(2, 2, 'Sir Chris Hoy Velodrome', 3.8, 1),
(3, 3, 'People''s Palace', 2.7, 1),
(4, 4, 'Riverside Museum', 5.4, 1),
(5, 5, 'Botanic Gardens', 2.4, 1),
(6, 6, 'GCU', 3.4, 1),
(7, 1, 'St Andrew''s Cathedral', 1.8, 2),
(8, 2, 'Central Mosque', 0.75, 2),
(9, 3, 'University Chapel', 5.4, 2),
(10, 4, 'Om Hindu Mandir', 1.3, 2),
(11, 5, 'Gurdwara Singh Sabha', 0.6, 2),
(12, 6, 'Quaker Meeting House', 1.2, 2),
(13, 7, 'Glasgow Buddhist Centre', 0.35, 2),
(14, 8, 'Garnethill Synagogue', 0.45, 2),
(15, 9, 'Glasgow Cathderal', 3.3, 2),
(16, 1, 'Hunterian Art Gallery', 1.2, 3),
(17, 2, 'MacKintosh Building', 2.2, 3),
(18, 3, 'Gallery Of Modern Art', 1.4, 3),
(19, 4, 'St. Mungo Museum Of Religious Life & Art', 1.3, 3),
(20, 5, 'People''s Palace', 2.0, 3),
(21, 6, 'The Burrell Collection', 7.1, 3),
(22, 7, 'House For An Art Lover', 2.8, 3),
(23, 8, 'Kelvingrove Art Gallery and Museum', 5.0, 3),
(24, 1, 'University Of Strathclyde', 0.65, 4),
(25, 2, 'City Of Glasgow College - Riverside Campus', 1.4, 4),
(26, 3, 'School of Simulation and Visualisation', 3.9, 4),
(27, 4, 'Glasgow Science Centre', 0.7, 4),
(28, 5, 'University of Glasgow', 2.4, 4),
(29, 6, 'The Mitchell Library', 1.9, 4),
(30, 7, 'Glasgow School Of Art', 0.9, 4),
(31, 8, 'Royal Conservatoire Of Scotland', 0.75, 4),
(32, 9, 'GCU', 0.6, 4);


ALTER TABLE STAGE
  ADD CONSTRAINT STAGE_ibfk_1 FOREIGN KEY (ROUTEID) REFERENCES ROUTE (ROUTEID);
  
DELIMITER $$
--
-- Procedures
--
DROP PROCEDURE IF EXISTS `AddRoute`$$
CREATE DEFINER=`root`@`localhost` PROCEDURE `AddRoute` (IN `inRouteTitle` TEXT, IN `inDeparturePoint` TEXT)  BEGIN
 INSERT INTO ROUTE (ROUTETITLE, DEPARTUREPOINT)
        VALUES (inRouteTitle, inDeparturePoint);
END$$

DROP PROCEDURE IF EXISTS `AddStage`$$
CREATE DEFINER=`root`@`localhost` PROCEDURE `AddStage` (IN `inStageNumber` INT, IN `inEndPoint` TEXT, IN `inStageLength` FLOAT, IN `inRouteId` INT)  BEGIN
 INSERT INTO STAGE (STAGENUMBER, ENDPOINT, STAGELENGTH, ROUTEID)
        VALUES (inStageNumber, inEndPoint, inStageLength, inRouteId);
END$$

DROP PROCEDURE IF EXISTS `GetRoute`$$
CREATE DEFINER=`root`@`localhost` PROCEDURE `GetRoute` (IN `inRouteId` INT)  BEGIN
 SELECT *
 FROM     ROUTE
 WHERE  ROUTEID = inRouteId ;
END$$

DROP PROCEDURE IF EXISTS `GetRoutes`$$
CREATE DEFINER=`root`@`localhost` PROCEDURE `GetRoutes` ()  READS SQL DATA
BEGIN
  Select ROUTEID, ROUTETITLE, DEPARTUREPOINT From ROUTE Order By ROUTEID;    
END$$

DROP PROCEDURE IF EXISTS `GetRouteStages`$$
CREATE DEFINER=`root`@`localhost` PROCEDURE `GetRouteStages` (IN `inRouteId` INT)  NO SQL
BEGIN
  SELECT STAGEID, STAGENUMBER, ENDPOINT, STAGELENGTH FROM STAGE
  WHERE ROUTEID = inRouteId 
  Order By STAGENUMBER;
End$$

DELIMITER ;  

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
