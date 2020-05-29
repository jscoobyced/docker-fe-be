CREATE DATABASE IF NOT EXISTS `jscdb` DEFAULT CHARACTER SET utf8;

USE `jscdb`;

DROP TABLE IF EXISTS `sample`;

CREATE TABLE `sample` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `value` varchar(64) DEFAULT NULL,
  `created` datetime DEFAULT NULL,
  `modified` datetime DEFAULT NULL,
  `status` int(1) DEFAULT 0,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;