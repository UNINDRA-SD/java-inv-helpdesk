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

-- Dumping structure for table java.assets
CREATE TABLE IF NOT EXISTS `assets` (
  `id` int NOT NULL AUTO_INCREMENT,
  `brand_id` int DEFAULT NULL,
  `category_id` int DEFAULT NULL,
  `rack_id` int DEFAULT NULL,
  `name` varchar(50) COLLATE utf8mb4_general_ci DEFAULT NULL,
  `model_number` varchar(50) COLLATE utf8mb4_general_ci DEFAULT NULL,
  `part_number` varchar(50) COLLATE utf8mb4_general_ci DEFAULT NULL,
  `serial_number` varchar(50) COLLATE utf8mb4_general_ci DEFAULT NULL,
  `description` text COLLATE utf8mb4_general_ci,
  `qty` int DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- Dumping data for table java.assets: ~4 rows (approximately)
REPLACE INTO `assets` (`id`, `brand_id`, `category_id`, `rack_id`, `name`, `model_number`, `part_number`, `serial_number`, `description`, `qty`) VALUES
	(1, 3, 1, 1, 'Wifi Router 69 Series', 'AP-69', 'AP-69', 'N/A', 'Access Point Wifi Router 69 Series', 3),
	(2, 1, 2, 1, 'Catalyst 1200 Series', '1200', '1200', 'N/A', 'Switch 10 Gbps Speed', 1),
	(3, 2, 3, 2, 'RB951 Series', 'RB951', 'RB951', 'N/A', 'Router wifi', 2),
	(4, 6, 5, 3, 'NAND 1TB', '1TB', '1TB', 'N/A', 'SSD Cache NAND 1TB', 4),
	(5, 11, 4, 4, 'HDD 2TB', '2TB', '2TB', 'N/A', 'HDD 2.5 inch 2TB', 5);

-- Dumping structure for table java.brands
CREATE TABLE IF NOT EXISTS `brands` (
  `id` int NOT NULL AUTO_INCREMENT,
  `name` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- Dumping data for table java.brands: ~11 rows (approximately)
REPLACE INTO `brands` (`id`, `name`) VALUES
	(1, 'Cisco'),
	(2, 'Mikrotik'),
	(3, 'TP-Link'),
	(4, 'D-Link'),
	(5, 'Toto-Link'),
	(6, 'Samsung'),
	(7, 'V-Gen'),
	(8, 'Adata'),
	(9, 'Seagate'),
	(10, 'Toshiba'),
	(11, 'Western Digital');

-- Dumping structure for table java.categories
CREATE TABLE IF NOT EXISTS `categories` (
  `id` int NOT NULL AUTO_INCREMENT,
  `name` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- Dumping data for table java.categories: ~6 rows (approximately)
REPLACE INTO `categories` (`id`, `name`) VALUES
	(1, 'Access Point'),
	(2, 'Switch'),
	(3, 'Router'),
	(4, 'HDD'),
	(5, 'SSD'),
	(6, 'Flashdisk'),
	(7, 'Memory');

-- Dumping structure for table java.customers
CREATE TABLE IF NOT EXISTS `customers` (
  `id` int NOT NULL AUTO_INCREMENT,
  `name` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL,
  `phone` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL,
  `address` text CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- Dumping data for table java.customers: ~4 rows (approximately)
REPLACE INTO `customers` (`id`, `name`, `phone`, `address`) VALUES
	(1, 'Ariq Andrean', '088892891', 'Bekasi dekat cakung'),
	(2, 'Bang Fuji', '08767822', 'Cileungsi jauh'),
	(3, 'Bang Pajar', '0878232', 'Depok kayanya'),
	(4, 'Ocha', '0827232', 'Depok juga kayanya');

-- Dumping structure for table java.delivery_orders
CREATE TABLE IF NOT EXISTS `delivery_orders` (
  `id` int NOT NULL AUTO_INCREMENT,
  `ticket_id` int DEFAULT NULL,
  `user_id` int DEFAULT NULL COMMENT 'Warehouse In Charge',
  `notes` text CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- Dumping data for table java.delivery_orders: ~2 rows (approximately)
REPLACE INTO `delivery_orders` (`id`, `ticket_id`, `user_id`, `notes`) VALUES
	(1, 1, 6, 'Problem Ariq ticket id 1'),
	(2, 2, 2, 'Fuji kejauhan ticket 2');

-- Dumping structure for table java.do_assets
CREATE TABLE IF NOT EXISTS `do_assets` (
  `id` int NOT NULL AUTO_INCREMENT,
  `delivery_order_id` int DEFAULT NULL,
  `asset_id` int DEFAULT NULL,
  `status` varchar(50) COLLATE utf8mb4_general_ci DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- Dumping data for table java.do_assets: ~2 rows (approximately)
REPLACE INTO `do_assets` (`id`, `delivery_order_id`, `asset_id`, `status`) VALUES
	(1, 1, 1, 'Delivered'),
	(2, 1, 2, 'Delivered'),
	(3, 2, 3, 'Delivered');

-- Dumping structure for table java.racks
CREATE TABLE IF NOT EXISTS `racks` (
  `id` int NOT NULL AUTO_INCREMENT,
  `name` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- Dumping data for table java.racks: ~11 rows (approximately)
REPLACE INTO `racks` (`id`, `name`) VALUES
	(1, 'RACK A-1'),
	(2, 'RACK A-2'),
	(3, 'RACK A-3'),
	(4, 'RACK A-4'),
	(5, 'RACK B-1'),
	(6, 'RACK B-2'),
	(7, 'RACK B-3'),
	(8, 'RACK B-4'),
	(9, 'RACK C-1'),
	(10, 'RACK C-2'),
	(11, 'RACK C-3'),
	(12, 'RACK C-4');

-- Dumping structure for table java.tickets
CREATE TABLE IF NOT EXISTS `tickets` (
  `id` int NOT NULL AUTO_INCREMENT,
  `customer_id` int DEFAULT NULL,
  `user_id` int DEFAULT NULL COMMENT 'Engineer In Charge',
  `status` varchar(255) COLLATE utf8mb4_general_ci DEFAULT NULL,
  `problem` varchar(255) COLLATE utf8mb4_general_ci DEFAULT NULL,
  `description` text COLLATE utf8mb4_general_ci,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- Dumping data for table java.tickets: ~4 rows (approximately)
REPLACE INTO `tickets` (`id`, `customer_id`, `user_id`, `status`, `problem`, `description`) VALUES
	(1, 1, 4, 'Close', 'Bang Ariq Komplen Mulu', 'Gk tau kenapa'),
	(2, 2, 4, 'Open', 'Kejauhan', 'jauh bgt boy'),
	(3, 3, 5, 'Open', 'Waduh', 'bocah kenapa dah'),
	(4, 4, 5, 'Open', 'Sok Asik', 'katanya speed kurang kenceng');

-- Dumping structure for table java.users
CREATE TABLE IF NOT EXISTS `users` (
  `id` int NOT NULL AUTO_INCREMENT,
  `email` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL DEFAULT '0',
  `name` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL DEFAULT '0',
  `password` text CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL,
  `role` varchar(225) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL DEFAULT '0',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- Dumping data for table java.users: ~6 rows (approximately)
REPLACE INTO `users` (`id`, `email`, `name`, `password`, `role`) VALUES
	(1, 'dandy@gmail.com', 'Dandy Bagus P', 'b30e4c80db9f696c1094a6f4ee31162cf2a8d207a3f75867064d3f60da436e7a68f92a25be632271ea40a62d5be83a5bf75297bcd58ffdaf6c5ae5fa37dd5e7d', 'Management'),
	(2, 'agus@gmail.com', 'Agus Nugroho', 'b30e4c80db9f696c1094a6f4ee31162cf2a8d207a3f75867064d3f60da436e7a68f92a25be632271ea40a62d5be83a5bf75297bcd58ffdaf6c5ae5fa37dd5e7d', 'Warehouse'),
	(3, 'reza@gmail.com', 'Reza Pra', 'b30e4c80db9f696c1094a6f4ee31162cf2a8d207a3f75867064d3f60da436e7a68f92a25be632271ea40a62d5be83a5bf75297bcd58ffdaf6c5ae5fa37dd5e7d', 'Helpdesk'),
	(4, 'hafidz@gmail.com', 'Hafidz Aris M', 'b30e4c80db9f696c1094a6f4ee31162cf2a8d207a3f75867064d3f60da436e7a68f92a25be632271ea40a62d5be83a5bf75297bcd58ffdaf6c5ae5fa37dd5e7d', 'Engineer'),
	(5, 'sofyan@gmail.com', 'Moh Sofyan', 'b30e4c80db9f696c1094a6f4ee31162cf2a8d207a3f75867064d3f60da436e7a68f92a25be632271ea40a62d5be83a5bf75297bcd58ffdaf6c5ae5fa37dd5e7d', 'Engineer'),
	(6, 'nofal@gmail.com', 'Gopal', 'b30e4c80db9f696c1094a6f4ee31162cf2a8d207a3f75867064d3f60da436e7a68f92a25be632271ea40a62d5be83a5bf75297bcd58ffdaf6c5ae5fa37dd5e7d', 'Warehouse'),
	(7, 'dila@gmail.com', 'Dila', 'b30e4c80db9f696c1094a6f4ee31162cf2a8d207a3f75867064d3f60da436e7a68f92a25be632271ea40a62d5be83a5bf75297bcd58ffdaf6c5ae5fa37dd5e7d', 'Helpdesk');

/*!40103 SET TIME_ZONE=IFNULL(@OLD_TIME_ZONE, 'system') */;
/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IFNULL(@OLD_FOREIGN_KEY_CHECKS, 1) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40111 SET SQL_NOTES=IFNULL(@OLD_SQL_NOTES, 1) */;
