-- --------------------------------------------------------
-- Host:                         127.0.0.1
-- Server version:               8.0.30 - MySQL Community Server - GPL
-- Server OS:                    Win64
-- HeidiSQL Version:             12.1.0.6537
-- --------------------------------------------------------

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET NAMES utf8 */;
/*!50503 SET NAMES utf8mb4 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

-- Dumping structure for table java.brands
CREATE TABLE IF NOT EXISTS `brands` (
  `id` int NOT NULL AUTO_INCREMENT,
  `name` varchar(50) COLLATE utf8mb4_general_ci DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- Dumping data for table java.brands: ~4 rows (approximately)
REPLACE INTO `brands` (`id`, `name`) VALUES
	(1, 'CISCO'),
	(2, 'MIKROTIK'),
	(3, 'TP-LINK'),
	(4, 'D-LINK');

-- Dumping structure for table java.categories
CREATE TABLE IF NOT EXISTS `categories` (
  `id` int NOT NULL AUTO_INCREMENT,
  `name` varchar(50) COLLATE utf8mb4_general_ci DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- Dumping data for table java.categories: ~0 rows (approximately)
REPLACE INTO `categories` (`id`, `name`) VALUES
	(1, 'Memory');

-- Dumping structure for table java.customers
CREATE TABLE IF NOT EXISTS `customers` (
  `id` int NOT NULL AUTO_INCREMENT,
  `name` varchar(50) COLLATE utf8mb4_general_ci DEFAULT NULL,
  `phone` varchar(50) COLLATE utf8mb4_general_ci DEFAULT NULL,
  `address` text COLLATE utf8mb4_general_ci,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- Dumping data for table java.customers: ~1 rows (approximately)
REPLACE INTO `customers` (`id`, `name`, `phone`, `address`) VALUES
	(1, 'paijo', '908908', 'jl maju mundur 12/09');

-- Dumping structure for table java.racks
CREATE TABLE IF NOT EXISTS `racks` (
  `id` int NOT NULL AUTO_INCREMENT,
  `name` varchar(50) COLLATE utf8mb4_general_ci DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- Dumping data for table java.racks: ~2 rows (approximately)
REPLACE INTO `racks` (`id`, `name`) VALUES
	(1, 'RACK A-1'),
	(2, 'RACK A-2'),
	(3, 'RACK B-1');

-- Dumping structure for table java.users
CREATE TABLE IF NOT EXISTS `users` (
  `id` int NOT NULL AUTO_INCREMENT,
  `email` varchar(50) COLLATE utf8mb4_general_ci NOT NULL DEFAULT '0',
  `name` varchar(50) COLLATE utf8mb4_general_ci NOT NULL DEFAULT '0',
  `password` text COLLATE utf8mb4_general_ci NOT NULL,
  `role` varchar(225) COLLATE utf8mb4_general_ci NOT NULL DEFAULT '0',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- Dumping data for table java.users: ~6 rows (approximately)
REPLACE INTO `users` (`id`, `email`, `name`, `password`, `role`) VALUES
	(1, 'dandy@gmail.com', 'Dandy Bagus P', 'b30e4c80db9f696c1094a6f4ee31162cf2a8d207a3f75867064d3f60da436e7a68f92a25be632271ea40a62d5be83a5bf75297bcd58ffdaf6c5ae5fa37dd5e7d', 'Management'),
	(2, 'agus@gmail.com', 'Agus Nugroho', 'b30e4c80db9f696c1094a6f4ee31162cf2a8d207a3f75867064d3f60da436e7a68f92a25be632271ea40a62d5be83a5bf75297bcd58ffdaf6c5ae5fa37dd5e7d', 'Warehouse'),
	(3, 'reza@gmail.com', 'Reza Pra', 'b30e4c80db9f696c1094a6f4ee31162cf2a8d207a3f75867064d3f60da436e7a68f92a25be632271ea40a62d5be83a5bf75297bcd58ffdaf6c5ae5fa37dd5e7d', 'Helpdesk'),
	(4, 'hafidz@gmail.com', 'Hafidz Aris M', 'b30e4c80db9f696c1094a6f4ee31162cf2a8d207a3f75867064d3f60da436e7a68f92a25be632271ea40a62d5be83a5bf75297bcd58ffdaf6c5ae5fa37dd5e7d', 'Engineer');

/*!40103 SET TIME_ZONE=IFNULL(@OLD_TIME_ZONE, 'system') */;
/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IFNULL(@OLD_FOREIGN_KEY_CHECKS, 1) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40111 SET SQL_NOTES=IFNULL(@OLD_SQL_NOTES, 1) */;
