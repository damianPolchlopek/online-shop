unlock tables;
CREATE DATABASE  IF NOT EXISTS `online_shop` /*!40100 DEFAULT CHARACTER SET latin1 */;
USE `online_shop`;


--
-- Table structure for table `users`
--
DROP TABLE IF EXISTS `users`;
CREATE TABLE `users`(
	`username` varchar(50) NOT NULL,
    `password` varchar(50) NOT NULL,
    `enabled` tinyint(1) NOT NULL,
    PRIMARY KEY (`username`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Inserting data for table `users`
--

INSERT INTO `users` 
VALUES 
('john','{noop}test123',1),
('mary','{noop}test123',1),
('susan','{noop}test123',1);



--
-- Table structure for table `authorities`
--

DROP TABLE IF EXISTS `authorities`;
CREATE TABLE `authorities` (
  `username` varchar(50) NOT NULL,
  `authority` varchar(50) NOT NULL,
  UNIQUE KEY `authorities_idx_1` (`username`,`authority`),
  CONSTRAINT `authorities_ibfk_1` FOREIGN KEY (`username`) REFERENCES `users` (`username`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Inserting data for table `authorities`
--

INSERT INTO `authorities` 
VALUES 
('john','ROLE_EMPLOYEE'),
('mary','ROLE_EMPLOYEE'),
('mary','ROLE_MANAGER'),
('susan','ROLE_EMPLOYEE'),
('susan','ROLE_ADMIN');









--
-- Table structure for table `product`
--

DROP TABLE IF EXISTS `product`;
CREATE TABLE `product` (
  `id` int(11)  NOT NULL AUTO_INCREMENT,
  `name` varchar(50)  NOT NULL,
  `category` varchar(50)  NOT NULL,
  `price` int NOT NULL,
  
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `product`
--

LOCK TABLES `product` WRITE;
INSERT INTO `product` VALUES 
	(1,'Sluchawki', 'Elektronika', 2),
	(2,'Spodenki', 'Ubrania', 3),
	(3,'Pilka', 'Sport', 4),
	(4,'Apap', 'Zdrowie', 5),
	(5,'opony', 'Motoryzacja', 2);
	
UNLOCK TABLES;
	