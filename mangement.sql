/*
SQLyog Community v13.1.6 (64 bit)
MySQL - 5.7.19 : Database - management
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`management` /*!40100 DEFAULT CHARACTER SET utf8mb4 */;

USE `management`;

/*Table structure for table `admin` */

DROP TABLE IF EXISTS `admin`;

CREATE TABLE `admin` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(20) NOT NULL,
  `password` varchar(50) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=latin1;

/*Data for the table `admin` */

insert  into `admin`(`id`,`name`,`password`) values 
(1,'admin','123456'),
(2,'admin4','1233333');

/*Table structure for table `department` */

DROP TABLE IF EXISTS `department`;

CREATE TABLE `department` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(10) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;

/*Data for the table `department` */

insert  into `department`(`id`,`name`) values 
(1,'研发部'),
(2,'人力资源'),
(4,'财务部1'),
(5,'政务部');

/*Table structure for table `employee` */

DROP TABLE IF EXISTS `employee`;

CREATE TABLE `employee` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(10) NOT NULL,
  `gander` int(11) NOT NULL,
  `email` varchar(30) NOT NULL,
  `birthday` date NOT NULL,
  `salary` float NOT NULL,
  `create_time` date NOT NULL,
  `department_id` int(11) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=71 DEFAULT CHARSET=utf8;

/*Data for the table `employee` */

insert  into `employee`(`id`,`name`,`gander`,`email`,`birthday`,`salary`,`create_time`,`department_id`) values 
(1,'张三',1,'123@qq.com','2020-12-01',6632,'2021-05-28',1),
(3,'小橙',1,'123@qq.com','2021-06-15',60000,'2021-06-04',1),
(12,'小黑',1,'1991853839@qq.com','2021-05-29',66666,'2021-06-10',1),
(13,'test',1,'123@qq.com','2021-01-01',5000,'2021-01-01',1),
(16,'123',0,'1991853839@qq.com','2021-06-08',22222,'2021-06-11',3),
(17,'小爱',0,'786639838@qq.com','2022-03-09',123,'2022-04-03',4),
(18,'12333344',0,'786639838@qq.com','2022-03-27',12333,'2022-04-03',1),
(26,'test',1,'123@qq.com','2022-04-03',5000,'2022-04-03',1),
(27,'test',1,'123@qq.com','2022-04-03',5000,'2022-04-03',1),
(28,'test',1,'123@qq.com','2022-04-03',5000,'2022-04-03',1),
(29,'test',1,'123@qq.com','2022-04-03',5000,'2022-04-03',1),
(30,'test',1,'123@qq.com','2022-04-03',5000,'2022-04-03',1),
(31,'test',1,'123@qq.com','2022-04-03',5000,'2022-04-03',1),
(32,'test',1,'123@qq.com','2022-04-03',5000,'2022-04-03',1),
(33,'test',1,'123@qq.com','2022-04-03',5000,'2022-04-03',1),
(34,'test',1,'123@qq.com','2022-04-03',5000,'2022-04-03',1),
(35,'test',1,'123@qq.com','2022-04-03',5000,'2022-04-03',1),
(36,'test',1,'123@qq.com','2022-04-03',5000,'2022-04-03',1),
(37,'test',1,'123@qq.com','2022-04-03',5000,'2022-04-03',1),
(38,'test',1,'123@qq.com','2022-04-03',5000,'2022-04-03',1),
(39,'test',1,'123@qq.com','2022-04-03',5000,'2022-04-03',1),
(40,'test',1,'123@qq.com','2022-04-03',5000,'2022-04-03',1),
(41,'test',1,'123@qq.com','2022-04-03',5000,'2022-04-03',1),
(42,'test',1,'123@qq.com','2022-04-03',5000,'2022-04-03',1),
(43,'test',1,'123@qq.com','2022-04-03',5000,'2022-04-03',1),
(44,'test',1,'123@qq.com','2022-04-03',5000,'2022-04-03',1),
(45,'test',1,'123@qq.com','2022-04-03',5000,'2022-04-03',1),
(46,'test',1,'123@qq.com','2022-04-03',5000,'2022-04-03',1),
(47,'test',1,'123@qq.com','2022-04-03',5000,'2022-04-03',1),
(48,'test',1,'123@qq.com','2022-04-03',5000,'2022-04-03',1),
(49,'test',1,'123@qq.com','2022-04-03',5000,'2022-04-03',1),
(50,'test',1,'123@qq.com','2022-04-03',5000,'2022-04-03',1),
(51,'test',1,'123@qq.com','2022-04-03',5000,'2022-04-03',1),
(52,'test',1,'123@qq.com','2022-04-03',5000,'2022-04-03',1),
(53,'test',1,'123@qq.com','2022-04-03',5000,'2022-04-03',1),
(54,'test',1,'123@qq.com','2022-04-03',5000,'2022-04-03',1),
(55,'test',1,'123@qq.com','2022-04-03',5000,'2022-04-03',1),
(56,'test',1,'123@qq.com','2022-04-03',5000,'2022-04-03',1),
(57,'test',1,'123@qq.com','2022-04-03',5000,'2022-04-03',1),
(58,'test',1,'123@qq.com','2022-04-03',5000,'2022-04-03',1),
(59,'test',1,'123@qq.com','2022-04-03',5000,'2022-04-03',1),
(60,'test',1,'123@qq.com','2022-04-03',5000,'2022-04-03',1),
(61,'test',1,'123@qq.com','2022-04-03',5000,'2022-04-03',1),
(62,'test',1,'123@qq.com','2022-04-03',5000,'2022-04-03',1),
(63,'test',1,'123@qq.com','2022-04-03',5000,'2022-04-03',1),
(64,'test',1,'123@qq.com','2022-04-03',5000,'2022-04-03',1),
(65,'test',1,'123@qq.com','2022-04-03',5000,'2022-04-03',1),
(66,'test',1,'123@qq.com','2022-04-03',5000,'2022-04-03',1),
(67,'test',1,'123@qq.com','2022-04-03',5000,'2022-04-03',1),
(68,'test',1,'123@qq.com','2022-04-03',5000,'2022-04-03',1),
(69,'小张',0,'1991853839@qq.com','2022-03-31',3333,'2022-04-05',2),
(70,'小笼包',1,'1991853839@qq.com','2022-04-05',2000,'2022-04-05',5);

/*Table structure for table `news` */

DROP TABLE IF EXISTS `news`;

CREATE TABLE `news` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `title` varchar(128) NOT NULL,
  `context` text NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8mb4;

/*Data for the table `news` */

insert  into `news`(`id`,`title`,`context`) values 
(1,'2022世界移动大会','面向HW，HW与全球运营商、合作伙伴一起，打造极简、绿色、智能的ICT基础设施，坚持科技向善，致力于以创新的技术和产品解决方案让生活更美好、商业更智... '),
(2,'2022运营转型峰会','沿着运营运维数智化转型的旅程，携手将数智技术和创新带入运营运维每一个环节，引领智能新体验、新价值，构建万物互联的智能世界。'),
(3,'其他','HW与达尔文圈发起“维也纳科技向绿倡议”关于公司轮值董事长的当值公告,HW与达尔文圈发起“维也纳科技向绿倡议”关于公司轮值董事长的当值公告.'),
(5,'其他123','HW与达尔文圈发起“维也纳科技向绿倡议”关于公司轮值董事长的当值公告,HW与达尔文圈发起“维也纳科技向绿倡议”关于公司轮值董事长的当值公告.');

/*Table structure for table `partner` */

DROP TABLE IF EXISTS `partner`;

CREATE TABLE `partner` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `name` varchar(128) NOT NULL,
  `description` text,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8mb4;

/*Data for the table `partner` */

insert  into `partner`(`id`,`name`,`description`) values 
(1,'HW云公司','HW云公司是在行业或区域内从事华为云咨询和技术合作，HW云安全可信、能力开放、全球服务，与合作伙伴一起，共同实现客户价值。 '),
(2,'XX解决方案公司','解决方案公司是专门从事软件的开发、生产、销售和服务，具有自主软件产品，能够在HWeSDK或产品基础上进行二次开发或对接HW软硬件平台的行业应用伙伴。 '),
(3,'XX销售公司','销售公司是在行业或区域内从事华为产品和解决方案销售的合作公司。秉承“合作共赢、耕耘收获”的渠道理念，以与合作伙伴实现双赢为宗旨， 积极贯彻合作、共赢的渠道策略。 '),
(4,'XX服务公司','服务公司是在行业或区域内从事HW产品和解决方案的工程交付和售后维护的合作公司。 '),
(5,'人才联盟-ICT学院','人才联盟-ICT学院是经HW公司授权，面向社会、院校等实施HW认证培训项目，培养ICT人才的合作伙伴。 '),
(6,'人才联盟-HALP','人才联盟-HALP是经HW公司授权，为拓展HW认证而发展的培训合作伙伴，其被授权实施HW认证课程。 ');

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
