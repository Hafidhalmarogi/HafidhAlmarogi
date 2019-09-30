/*
SQLyog Professional v12.4.3 (64 bit)
MySQL - 10.1.31-MariaDB : Database - bank_db
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`bank_db` /*!40100 DEFAULT CHARACTER SET latin1 */;

USE `bank_db`;

/*Table structure for table `tabungan_tbl` */

DROP TABLE IF EXISTS `tabungan_tbl`;

CREATE TABLE `tabungan_tbl` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `nik` varchar(30) DEFAULT NULL,
  `nama` varchar(100) DEFAULT NULL,
  `kredit` int(11) DEFAULT NULL,
  `debet` int(11) DEFAULT NULL,
  `saldo` int(11) DEFAULT NULL,
  `craete_time` datetime DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=40 DEFAULT CHARSET=latin1;

/*Data for the table `tabungan_tbl` */

insert  into `tabungan_tbl`(`id`,`nik`,`nama`,`kredit`,`debet`,`saldo`,`craete_time`) values 
(31,'111','Hidayat',5000,0,5000,'2019-09-30 18:47:33'),
(32,'111','Hidayat',5000,1200,8800,'2019-09-30 18:48:22'),
(34,'123','Herdi',2000,2200,-200,'2019-09-30 18:49:24'),
(35,'123','Herdi',20000,0,19800,'2019-09-30 18:49:42'),
(36,'0712','Hafidh',20000,0,20000,'2019-09-30 21:47:50'),
(38,'1234','almarogi',50000,0,50000,'2019-09-30 21:16:50'),
(39,'1234','almarogi',0,20000,30000,'2019-09-30 21:18:49');

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
