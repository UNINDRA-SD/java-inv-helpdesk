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


-- Dumping database structure for java-inv-helpdesk
DROP DATABASE IF EXISTS `java-inv-helpdesk`;
CREATE DATABASE IF NOT EXISTS `java-inv-helpdesk` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci */ /*!80016 DEFAULT ENCRYPTION='N' */;
USE `java-inv-helpdesk`;

-- Dumping structure for table java-inv-helpdesk.activity_reports
DROP TABLE IF EXISTS `activity_reports`;
CREATE TABLE IF NOT EXISTS `activity_reports` (
  `id` int NOT NULL AUTO_INCREMENT,
  `delivery_order_id` int DEFAULT NULL,
  `action_taken` text COLLATE utf8mb4_general_ci,
  `start_date` date DEFAULT NULL,
  `end_date` date DEFAULT NULL,
  `start_time` time DEFAULT NULL,
  `end_time` time DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=10032 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- Dumping data for table java-inv-helpdesk.activity_reports: ~0 rows (approximately)
REPLACE INTO `activity_reports` (`id`, `delivery_order_id`, `action_taken`, `start_date`, `end_date`, `start_time`, `end_time`) VALUES
	(10008, 100007, 'Ganti Wifi Router baru', '2024-07-02', '2024-07-02', '11:01:00', '13:08:00'),
	(10009, 100008, 'Pasang Wifi Baru\n- kabel\n- router', '2024-07-03', '2024-07-03', '08:00:00', '14:10:00'),
	(10010, 100009, '1. Ganti Router baru\n2. Ganti kabel LAN baru', '2024-07-08', '2024-07-08', '09:00:00', '14:05:00'),
	(10011, 100010, 'Open port config', '2024-07-08', '2024-07-08', '09:55:00', '14:10:00'),
	(10012, 100011, 'Pergantian LAN kabel', '2024-07-08', '2024-07-08', '09:57:00', '14:03:00'),
	(10017, 100014, '1. Restart modem dan akses point - normal\n2. Tes jarak kekuatan sinyal di titik belakang - ada 2 titik sinyal yang lemah', '2024-12-04', '2024-12-04', '10:00:00', '16:10:00'),
	(10018, 100016, '1. cabut colok adaptor\n2. restart perangkat\n3. Kabel dw 100 M putus d tengah', '2024-12-05', '2024-12-05', '11:05:00', '04:00:00'),
	(10019, 100017, 'Pengecekan kabel\nMelakukan Perapihan kabel\nRestart Perangkat ONT\nConfig Manual\nCabut Colok Port DW\nGanti Perangkat ONT', '2024-12-05', '2024-12-05', '12:10:00', '16:15:00'),
	(10020, 100018, 'Restart Perangkat ONT\nConfig Manual\nCabut Colok Port DW\nCek port Di ONT\nConnector Rusak\nGanti Connector di ONT', '2024-12-06', '2024-12-06', '10:10:00', '14:00:00'),
	(10021, 100019, 'Melakukan Pengecekan kabel\nRestart Perangkat ONT\nConfig Manual\nCabut Colok Port DW\nCek port Di ODP\nConnector di ODP Rusak', '2024-12-06', '2024-12-06', '11:00:00', '15:00:00'),
	(10022, 100020, 'Pengecekan ONT\nGanti Adaptor ONT', '2024-12-07', '2024-12-07', '10:53:00', '14:12:00'),
	(10023, 100021, 'Pindah Perangkat ONT \nTarik Ulang Ke rumah yang berbeda', '2024-12-07', '2024-12-07', '13:02:00', '17:28:00'),
	(10024, 100022, 'restart modem-pengecekan sistem-krimping ulang kabel dan sudah normal', '2024-12-06', '2024-12-06', '14:15:00', '05:22:00'),
	(10025, 100023, 'Hex Lite router di ganti', '2024-12-09', '2024-12-09', '10:00:00', '12:04:00'),
	(10026, 100024, 'Sambung kabel FO', '2024-12-11', '2024-12-11', '13:07:00', '15:14:00'),
	(10027, 100025, 'Rapihkan kabel', '2024-12-12', '2024-12-12', '09:00:00', '17:25:00'),
	(10028, 100026, 'Pasang baru', '2024-12-14', '2024-12-14', '10:59:00', '05:29:00'),
	(10029, 100026, 'Pasang baru', '2024-12-14', '2024-12-14', '10:59:00', '17:29:00'),
	(10030, 100027, 'Tambah Access Point', '2024-11-05', '2024-11-05', '11:11:00', '20:30:00'),
	(10031, 100028, 'Tarik Kabel Ulang', '2024-12-13', '2024-12-13', '10:05:00', '20:30:00');

-- Dumping structure for table java-inv-helpdesk.assets
DROP TABLE IF EXISTS `assets`;
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
) ENGINE=InnoDB AUTO_INCREMENT=1000036 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- Dumping data for table java-inv-helpdesk.assets: ~0 rows (approximately)
REPLACE INTO `assets` (`id`, `brand_id`, `category_id`, `rack_id`, `name`, `model_number`, `part_number`, `serial_number`, `description`, `qty`) VALUES
	(1000002, 12, 5, 1, 'Cable LAN STP 30 Meter (Outdoor)', 'STP', NULL, NULL, 'Dari supplier PT. Jaringan Nusa dengan PO ID 32832', 47),
	(1000003, 12, 8, 1, 'Barel Cable Connector', 'BAREL', NULL, NULL, 'Dari supplier PT. Jaringan Nusa dengan PO ID 32832', 31),
	(1000004, 14, 9, 1, 'HTB-3100 A+B Fiber RJ45', 'HTB-3100AB', NULL, NULL, NULL, 96),
	(1000005, 15, 10, 3, 'FIBER OPTIC Single Core 100 Meter', 'FO-SC-100', NULL, NULL, NULL, 47),
	(1000006, 8, 11, 2, 'Mikrobits SFP Transceiver SFP-2.5G-LH-SM 10KM', 'SFP-2.5G-LH-SM', NULL, NULL, NULL, 79),
	(1000007, 1, 12, 1, 'Gigabit 24VDC Passive PoE Adapter', 'TL-POE2412G', NULL, NULL, NULL, 40),
	(1000008, 9, 3, 5, 'Catalyst 3560X 24 Port', 'WS-C3560X-24T-S', NULL, 'FDO1919F48J', 'Dari supplier Procurri Singapore', 1),
	(1000009, 9, 3, 5, 'Catalyst 2960G 24 10/100/1000, 4 T/SFP', 'WS-C2960G-24TC-L', NULL, 'FOC1039X11B', 'Dari supplier Procurri Singapore', 1),
	(1000010, 9, 3, 5, 'Nexus 3172TQ', 'N3K-C3172TQ -10GT', NULL, 'F0C2035R15R', 'Dari supplier Procurri Singapore', 1),
	(1000011, 9, 2, 5, 'ASR 1002', 'ASR 1002', NULL, 'COUCAK5CAA', 'Dari supplier Procurri Singapore', 1),
	(1000012, 8, 2, 7, 'RB750r2 (hEX-Lite)', 'RB750r2', NULL, 'W843U1921DEI1', 'Dari supplier PT. Citraweb Indonesia PO ID 99283', 0),
	(1000013, 8, 2, 7, 'Router RB1100Dx4 1U Rackmount', 'RB1100Dx4', NULL, 'SH2I83832NF92A3F', 'Dari supplier PT. Citraweb Indonesia PO ID 99283', 0),
	(1000014, 16, 2, 3, 'ONT ZTE', 'F660', NULL, 'ZTEGC8024R34', NULL, 3),
	(1000015, 17, 2, 4, 'ONT RTE', 'F670L', NULL, 'RTEGC7023E24', NULL, 1),
	(1000016, 18, 2, 2, 'ONT BDCOM', 'BDCOM', NULL, 'BDCM8EADAED0', NULL, 1),
	(1000017, 19, 13, 7, 'CCTV 4 MP ColorVu Fixed Dome', 'DS-2CD2147G2-L(SU)', NULL, '1270782189', NULL, 1),
	(1000018, 19, 13, 7, 'CCTV 4 MP Smart Hybrid Light with ColorVu Fixed', 'DS-2CD2347G2H-LI(U)', NULL, '1275392012', NULL, 1),
	(1000019, 19, 13, 8, 'CCTV 2 MP AcuSense Varifocal Bullet', 'DS-2CD2626G2-IZS', NULL, '1270319283', NULL, 1),
	(1000020, 1, 14, 9, '300Mbps Wireless N WiFi Router Access Point', 'TL-WR845N', NULL, 'SGH892IEF9HF23', NULL, 0),
	(1000021, 1, 15, 10, 'WR 820n Wifi extender Access Point', 'WR820N', NULL, 'SGT73UHHUR29H', NULL, 1),
	(1000022, 2, 15, 10, 'WR 820n Wifi extender Access Point', 'WR820N', NULL, 'SGT73UHHUR29H', NULL, 1),
	(1000023, 7, 14, 11, 'F9 WALL KILLER ROUTER 600 Wireless Access Point', 'TENDA-F9', NULL, 'TDA8H39JA0DWQ', NULL, 1),
	(1000024, 2, 3, 12, '8 Port Gigabit Metal Unmanaged Switch', 'DGS-108GL', NULL, 'DLA8H3R93JRQW', NULL, 1),
	(1000025, 5, 14, 3, 'Dual-Band AX1800 WIFI 6 Wireless Router', 'E7350-AX1800', NULL, 'LSY7H834I943TS', NULL, 1),
	(1000026, 1, 1, 1, 'mic', 'nc500', 'fc200', '100', 'dari supplier', 20),
	(1000027, 1, 1, 1, 'mic', 'AA500', '200', 'FF500AB', 'dari supplier', 50),
	(1000028, 1, 1, 3, 'Adaptor ONT', 'TP-Link GPON ONU GP110', NULL, NULL, NULL, 4),
	(1000029, 16, 6, 9, 'Kabel Fiber DW ONT 250M', 'DW-ONT-SM 250M', NULL, 'SN1987', NULL, 19),
	(1000030, 11, 7, 10, 'Connector RJ-45', 'RJ-45', 'RJ-45', '-', 'Beli di tokped', 95),
	(1000031, 8, 2, 12, 'Mikrotik hEX lite', 'hEX lite', 'hEX lite', 'HF298HF23R', 'Beli di mikrotik.com', 0),
	(1000032, 14, 10, 1, 'Adapter Fiber Optic', 'FO-ADAPTER', 'FO-ADAPTER', '-', 'beli di shoope', 0),
	(1000033, 20, 16, 11, 'Velcro Starp Cable', 'Nylon cable Tie', 'Nylon cable Tie', '-', 'Nylon cable Tie', 0),
	(1000034, 20, 16, 11, 'Kabel Ties Velcro', 'Ties', 'Ties', '-', '-', 0),
	(1000035, 8, 2, 9, 'hEX S', 'hEX S', 'hEX S', 'H28H3F823F', 'hEX S', 0);

-- Dumping structure for table java-inv-helpdesk.brands
DROP TABLE IF EXISTS `brands`;
CREATE TABLE IF NOT EXISTS `brands` (
  `id` int NOT NULL AUTO_INCREMENT,
  `name` varchar(50) COLLATE utf8mb4_general_ci DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=21 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- Dumping data for table java-inv-helpdesk.brands: ~0 rows (approximately)
REPLACE INTO `brands` (`id`, `name`) VALUES
	(1, 'TP-Link'),
	(2, 'D-Link'),
	(3, 'Toto-Link'),
	(4, 'Pro-Link'),
	(5, 'Linksys'),
	(6, 'Netgear'),
	(7, 'Tenda'),
	(8, 'MikroTik'),
	(9, 'Cisco'),
	(10, 'Fortinet'),
	(11, 'BELDEN'),
	(12, 'COMMSCOPE'),
	(13, 'Ubiquiti'),
	(14, 'NetLink'),
	(15, 'NetLine'),
	(16, 'ZTE'),
	(17, 'RTE'),
	(18, 'BDCOM'),
	(19, 'HIKVISION'),
	(20, 'VELCRO');

-- Dumping structure for table java-inv-helpdesk.categories
DROP TABLE IF EXISTS `categories`;
CREATE TABLE IF NOT EXISTS `categories` (
  `id` int NOT NULL AUTO_INCREMENT,
  `name` varchar(50) COLLATE utf8mb4_general_ci DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=17 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- Dumping data for table java-inv-helpdesk.categories: ~0 rows (approximately)
REPLACE INTO `categories` (`id`, `name`) VALUES
	(1, 'WiFi AP'),
	(2, 'Router'),
	(3, 'Switch'),
	(4, 'Cable UTP'),
	(5, 'Cable STP'),
	(6, 'Cable Fibre Optic'),
	(7, 'RJ-45'),
	(8, 'Barel Connector'),
	(9, 'HTB CONVERTER'),
	(10, 'Cable-FO'),
	(11, 'SFP'),
	(12, 'PoE'),
	(13, 'CCTV IP'),
	(14, 'ACCESS POINT'),
	(15, 'WIFI EXTENDER'),
	(16, 'Others');

-- Dumping structure for table java-inv-helpdesk.customers
DROP TABLE IF EXISTS `customers`;
CREATE TABLE IF NOT EXISTS `customers` (
  `id` int NOT NULL AUTO_INCREMENT,
  `name` varchar(50) COLLATE utf8mb4_general_ci DEFAULT NULL,
  `phone` varchar(50) COLLATE utf8mb4_general_ci DEFAULT NULL,
  `address` text COLLATE utf8mb4_general_ci,
  `description` text COLLATE utf8mb4_general_ci,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=160 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- Dumping data for table java-inv-helpdesk.customers: ~0 rows (approximately)
REPLACE INTO `customers` (`id`, `name`, `phone`, `address`, `description`) VALUES
	(1, 'Angga Wibowo', '6285287163221', 'Jl. Pelita No.7, RT.7/RW.9, Kp. Tengah, Kec. Kramat jati, Kota Jakarta Timur, Daerah Khusus Ibukota Jakarta 13540', 'Paket Dedicated 10 Mbps'),
	(2, 'Surya Pamungkas', '6289621248936', 'Jl. Raya Bogor No.10, RT.1/RW.9, Kec. Kramat jati, Kota Jakarta Timur, Daerah Khusus Ibukota Jakarta 13510', 'Paket UpTo 12 Mbps'),
	(4, 'Sujati', '628113110073', 'Apartment Aerium - Unit 0311 Komplek Meli Melo, Jl. Harapan Indah Boulevard Bulevar No.3 Kav. 26A/05, Pusaka Rakyat, Kecamatan Medan Satria, Kabupaten Bekasi, Jawa Barat 17132', 'Paket UpTo 50Mbps'),
	(5, 'Susanti Djohari', '628128504882', 'Apartment Aerium - Unit 2906 Komplek Meli Melo, Jl. Harapan Indah Boulevard Bulevar No.3 Kav. 26A/05, Pusaka Rakyat, Kecamatan Medan Satria, Kabupaten Bekasi, Jawa Barat 17132', 'Paket Dedicated 50 Mbps'),
	(6, 'Muhamad Yusman .', '87770097505', 'Samara Regency Kav 9, RT 08 RW 09 Nanggewer, Cibinong', '20Mbps'),
	(7, 'Neri Liyawati', '85869009770', 'Gg gelatik 2 RT 2 RW 14 no 1 A', '20Mbps'),
	(8, 'Robi (Cipayung)', '85710059285', 'Jl Jawahir gang h madris RT 02 RW 05 no 21 Kel Bojong pondok terong', '20Mbps'),
	(9, 'BERLIN ADIGUNA EFFENDI,A.Md', '85314812096', 'Perum mustika blok c.30 no. 18 RT 007 RW 007 kelurahan pasir nangka kecamatan Tigaraksa kabupaten Tangerang provinsi Banten', '20Mbps'),
	(11, 'Tri Wahyuni', '85711498502', 'Kp. Jatijajar ii jl persada RT 006/008 No.64 , Jatijajar , Tapos , Depok', '20Mbps'),
	(12, 'Mohamad imran', '816511136', 'Kp. Pengkolan Rt. 005/001 No.29 kel. Pasir gadung kec. Cikupa kab. Tangerang prov. Banten', '20Mbps'),
	(13, 'Sonya Theresa Wangania', '85891526721', 'Jl asrama Divif I Kostrad Cilodong no 6A Cilodong Depok', '20Mbps'),
	(14, 'Tan, Yoseph Sanjaya', '81901200232', 'jl. wotgandul dalam I-A/51 RT 002/002 gabahan', '20Mbps'),
	(15, 'Arsya aulia', '85718948613', 'Jalan pulorida, Rt.09/05 , Bojong pondok terong, Cipayung Kota depok Jawa barat', '20Mbps'),
	(16, 'Saiful Muharom', '81953788980', 'Bulak Barat Rt 04/08 no 170 Cipayung Cipayung', '20Mbps'),
	(17, 'Rahmat winata', '85817028501', 'Kp cukanggalih RT.02 RW.04', '20Mbps'),
	(18, 'Farras Virgana Azis', '85959050975', 'gg samper RT 01/04 cimpaeun tapos depok (kontrakan teh Linda)', '20Mbps'),
	(19, 'Salsabila ( bojongsari )', '85959056012', 'Jl. Ali Andong kp. Bojong sari RT 02/08 Kel Bojong sari kec Bojong sari', '20Mbps'),
	(20, 'Nining (sampora)', '8871732185', 'Lingkungan sampora rt.01 rw.03 kel.cibinong kec.cibinong', '20Mbps'),
	(21, 'JAYA NATA', '83845656836', 'Kp. Sibadak RT.002/005 Kel.Caringin kec.cisoka', '20Mbps'),
	(22, 'Rizki romadhon (cmp)', '895411918822', 'Kp Cimpaeun gg haji sara no 70 RT 02/ 10 Cimpaeun', '20Mbps'),
	(23, 'Devin Budi', '82183380937', 'Paramount petals cluster Aster 7 / 16 kelurahan cukang Galih kecamatan curug', '30Mbps'),
	(24, 'Nani Suryati jeungjing', '83829546984', 'Kp jeungjing RT 004 RW 003 desa jeungjing kec cisoka', '20Mbps'),
	(25, 'Kristianto ( ltg )', '88980097089', 'JL Lamper Tengah RT 003 RW 001 no 71 Lamper Tengah semarang selatan', '20Mbps'),
	(26, 'Irfan yudi darmawan', '82261241262', 'Jl abdul ghani 2 kontrakan pak Gunawan rt 1 rw 9 kel harapan jaya kec cibinong kab Bogor', '20Mbps'),
	(27, 'Fitri Andrianingsih', '89668457837', 'lingkungan 03 citatah rt 03 rw 09', '20Mbps'),
	(28, 'Ahmad zumhur maturidyy', '85693243626', 'Kp sawah GG.afurqon rt 03/08 no.17 kel.cilendek barat kec.bogor barat', '20Mbps'),
	(29, 'Indra Gunawan.,', '81806054963', 'Perum Klapaindah Blok C5/4, Bojong, Klapanunggal, Bogor', '20Mbps'),
	(30, 'Aditya prasetyo ( jo)', '81298829865', 'Kp. Cibeber rt. 003/002 cikahuripan klapanunggal', '50Mbps'),
	(31, 'Wilda Lestari', '895332589342', 'Kp. Walahir RT 009/005 No.55 , Nambo , Klapa Nunggal , Bogor', '20Mbps'),
	(32, 'Rival maulana', '89638515548', 'Kp. Malingping rt 003/006 no 63 kel. Sukahati kec. Citeureup kab. Bogor jabar', '20Mbps'),
	(33, 'Fitria,karanggan', '83845850563', 'Gg cakung rt05 rw06 NO.045 karanggan', '20Mbps'),
	(34, 'Robby Richard Helaha', '81380465051', 'Jl Menteng No 55 RT 002 RW 02 Kel Menteng Kec Bogor Barat', '30Mbps'),
	(35, 'Sarah agustin sihotang', '81546060608', 'Perum andalusia almira no 18 rt03 rw08 kel ciomas kec pagelaran', '20Mbps'),
	(36, 'Dika almira rahmani', '89641484864', 'Jl gg h namin rt 04 rw 06 no 238 kel kalibaru kec cilodong', '20Mbps'),
	(37, 'Agung robiyanto', '89614613004', 'Cibeureum gg jambu rt 02 rw 05 no 109 kel. Mulyaharja Kec. Bogor Selatan', '20Mbps'),
	(38, 'Aris Setiawan ( tarikolot)', '81281852488', 'Kp Tarikolot rt 03/01 ,kel tarikolot ,kec citeureup', '20Mbps'),
	(39, 'RIN RIN ANDRIANI. _', '8118501509', 'KOMPLEK departemen PERTANIAN ATSIRI PERMAI jl gandaria 3 RT 12/RW 13 No 7', '100Mbps'),
	(40, 'Mohamad Haris Fadillah', '89516208183', 'Kp. Pabuaran Kulon Rt 005/005 no 60 warung mak ubih Cibanteng', '20Mbps'),
	(41, 'SONI ULINUHA', '85771213927', 'jl Anggungan luk luk mengwi', '20Mbps'),
	(42, 'Sri Wahyuni,.', '89611723846', 'Kp Cimpaeun RT 002 RW 006 Cimpaeun Tapos', '20Mbps'),
	(43, 'OMAH HERMAWATI', '83847845361', 'KP.KRAMAT RT 01 RW 01 PANARAGAN BOGOR', '20Mbps'),
	(44, 'Fajar setiawan (cibarengkok)', '8888144503', 'Kp cibarengkok rt 006 rw 002 kelurahan peusar kecamatan Panongan (kontrakan pak mahjudin)', '20Mbps'),
	(45, 'IDA..', '895325864509', 'Jl. Kp.Cipayung RT 002 RW 005 Kelurahan pondok Rajeg kecamatan Cibinong kabupaten Bogor Jawa Barat', '20Mbps'),
	(46, 'Sunarni ( tdng )', '895393347076', 'Perumahan Mutiara Kedungmundu Blok D.10 Tandang Tembalang', '20Mbps'),
	(47, 'Neneng Khoerunnisa', '85777726294', 'Kp. Sindangkarsa RT 4 RW 10 no 7 Kel. Sukamaju Baru Kec. Tapos - kontrakan pak jayadi', '50Mbps'),
	(48, 'TATI SETIAWATI (kdm4)', '85891805855', 'Parung kulon RT 04 RW 06 No. 116', '20Mbps'),
	(49, 'Irpan Alpi...', '85163559062', 'Jl.Rawa Indah/Pondok Terong. RT:03. RW:11. Kel:Bojong Pondok Terong. Kec: Cipayung. (kontrakan bpk abdul goni)', '20Mbps'),
	(50, 'Ade Via Irawan', '85780038006', 'perum green delima sentul blok b1 no.17', '20Mbps'),
	(51, 'Bagus tri utomo', '83801183637', 'Kp bolang rt 003 rw 001 kelurahan pasir bolang kecamatan Tigaraksa', '30Mbps'),
	(52, 'Dewi Nurvita Sari.', '81997794841', 'Jl.rawa indah gg Anggrek. kontrakan oren Pondok Terong. RT:01. RW:02. Kel:Bojong Pondok Terong. Kec: Cipayung. - kontrakan ibu yuli', '20Mbps'),
	(53, 'Erna Ratnasari ( krd )', '89647076386', 'JL Trengguli II No.74 RT 006 RW 002 Karangkidul', '20Mbps'),
	(54, 'I KETUT LANUS ARIYANTO', '82144140250', 'JL. GATOT SUBROTO VI NO 37', '20Mbps'),
	(55, 'Slamet Sutriono ( site 2 )', '88233424308', 'Plewan III RT 002 RW 003 Siwalan', '50Mbps'),
	(56, 'DINO BACHTIAR', '881038473813', 'JL PADMA PERUM BETENGSARI GANG PUCUK Kos Paling Ujung', '20Mbps'),
	(57, 'DOMINGGUS RAWA LANDUNAU', '82340180181', 'jln. mahendradata no.99 nix padangsambian', '20Mbps'),
	(58, 'Suryadi (mustika)', '82211278696', 'Mustika Tigaraksa TGR Blok C9 / 42 rt 001 rw 010 kelurahan pasir nangka kecamatan Tigaraksa', '20Mbps'),
	(59, 'Ika supriyatin', '83805818485', 'Perum triraksa village 2 Blok N5 / 10 rt 010 rw 001 kelurahan Munjul kecamatan solear', '20Mbps'),
	(60, 'AYU WULANDARI (kr.kidul)', '82135289522', 'JL TRENGULI II /39a RT 06/02', '20Mbps'),
	(61, 'Novitasari ( tdng 3 )', '87832008665', 'JL Taman Kinibalu III RT 007 RW 002 Tandang', '20Mbps'),
	(62, 'Arif Rohman', '81776591243', 'Perumahan Anniland Blok Q10 No. 11 RT. 001 RW. 011 Ds. Cempaka Kec. Cisoka Tangerang Banten', '20Mbps'),
	(63, 'Syahril Janur', '81311487644', 'Kp janur RT 020 RW 003 desa bojongloa kec cisoka', '20Mbps'),
	(64, 'Ni,Matul Huda', '85811780413', 'Kp bolang RT 002 RW 001 no 2 desa pasir bolang kec Tigaraksa', '20Mbps'),
	(65, 'MAHPUDIN SOLEH (YRS', '82210245683', 'JLN.JEMBATAN PARI NO.6 RT 005/004 KEL.CIJUJUNG KEC.SUKARAJA', '20Mbps'),
	(66, 'Sumintarsih', '88293169538', 'Kp bolang RT 002 RW 001 desa pasir bolang kec tigaraksa', '20Mbps'),
	(67, 'Airil Andika Syahputra', '81219494388', 'Kembangkuning, RT.08/03 Klapanunggal, Bogor', '50Mbps'),
	(68, 'Mega sari - cibeber-', '81398796100', 'Kp Cibeber RT 11/05 Kel Cikahuripan kec klpnunggal', '20Mbps'),
	(69, 'Fadlah Laeli Kamila', '89614554779', 'Gang Gaan Jl H Atim Rt 02 Rw 06 Kel Kalibaru Kec Cilodong (rumah pribadi)', '20Mbps'),
	(70, 'Shinta nurlya', '89614573856', 'Kebon kopi padurenan rt04/011', '30Mbps'),
	(71, 'Asep Saputra (tengah)', '85281690071', 'Kp Cipayung rt.03 rw.01 GG Swadaya Tengah', '20Mbps'),
	(72, 'Dira Aini', '81939999921', 'gg. pulo indah no.84 rt 002 rw 006 tapos tapos', '20Mbps'),
	(73, 'Fauzi@', '8567720810', 'Kp. Sukamulya Rt. 023 / 006 kel. Sukamulya kec. Cikupa', '20Mbps'),
	(74, 'Muhammad arta', '81293441759', 'jl cukanggalih 2 RT.02/004', '20Mbps'),
	(75, 'Badriansyah..', '81319340055', 'Ciherang gede rt.01 rw.01 kel.ciherang kec.dramaga kab.bogor', '20Mbps'),
	(76, 'MARYONO PERSADA', '81281159177', 'Perum Persada elok 3 blok F no.8 Kel.Peusar kec.panongan', '20Mbps'),
	(77, 'Ida Hamidah (MYS)', '85779594827', 'Kp. Gardu Rt04 Rw08 (Gg. Mesjid Al-Barokah)', '20Mbps'),
	(78, 'Aryanda Wibisana', '81315514250', 'Cilendek Barat No 39 RT 3 RW 6, Cilendek Barat, Bogor Barat', '20Mbps'),
	(79, 'Lasma sibarani', '81210091377', 'Jl raya citayam gg batas rt 09 rw 01 kel bojong pondok terong kec cipayung', '20Mbps'),
	(80, 'Muhammad amar ganny..,', '81230009248', 'Jl temp Kalimulya no 72 RT 02/01 Kalimulya Cilodong Depok', '30Mbps'),
	(81, 'Emilia Silfirina', '85180600755', 'Pesona Laguna 1 Blok G5 no 5 Rt. 007 Rw. 020', '20Mbps'),
	(82, '.. Khaerulloh..', '81218460085', 'Jl.karanggan raya, desa puspasari rt.04/04', '20Mbps'),
	(83, 'MUHAMAD RIFAI...', '81213760350', 'MUARA BERES RT01/04 KEL SUKAHATI KEC CIBINONG', '20Mbps'),
	(84, 'Isna Nurinayatullah', '81213102038', 'Jl mayor oking jaya atmaja rt 04 rw 01', '20Mbps'),
	(85, 'FITRIYANI***', '89531306950', 'KP.PABUARAN GG PLANKTON RT 01 RW 09 cibanteng', '20Mbps'),
	(86, 'Hamdani (cpy)', '895404743910', 'Jalan kel. Cipayung bulak barat rt 003 rw 007 no 80 Cipayung, Cipayung, depok', '20Mbps'),
	(87, 'Yati Nurhayati......', '89669867888', 'Muara lebak jl. raya ciapus rt 03/10 no.36 pasir jaya , bogor barat', '30Mbps'),
	(88, 'ASEP SAEPULOH (YRS)', '85711391404', 'KP.KADUMANGGU RT 001/002 KEL.KADUMANGGU KEC.BABAKAN MADANG', '20Mbps'),
	(89, 'Indriati.', '87760842911', 'Lamper Mijen RT 006 RW 006 no.333 Lamper Tengah', '20Mbps'),
	(90, 'Indriati.', '87760842911', 'Lamper Mijen RT 006 RW 006 no.333 Lamper Tengah', '20Mbps'),
	(91, 'Rahadi Gunawan', '89638896480', 'Gg. Kembang RT 004/009 No. 60 Kel. Kedung Halang', '20Mbps'),
	(92, 'Agus Mulyono ( Green Dramaga )', '85893455841', 'Perum Green Dramaga Residence Blok F12', '20Mbps'),
	(93, 'Dewi siti fatimah', '81317778902', 'Jl roda pembangunan no 27 rt 04 rw 06 kel, nanggewer kec, cibinong', '20Mbps'),
	(94, 'Ahmat husein', '81991860830', 'Bulak Timur RT 001 RW 010', '20Mbps'),
	(95, 'Istichomah ( klg )', '89696422613', 'JL Sawah Besar V RT RW 006 RW 003 Kaligawe', '20Mbps'),
	(96, 'Devi Oktoriawanty', '89507837586', 'Pancasan no.13 RT 01 RW 12 Kel pasir jaya kec Bogor barat (kontrakan bapak sugeng)', '20Mbps'),
	(97, 'Muhammad Reza Pahlevi', '89505882276', 'Jl Jerman No 145 rt 03 rw 05 (Kontrakan ibu Rina)', '20Mbps'),
	(98, 'SITI JULAEHA EHA', '85711395104', 'KP.BABAKAN PANDAY RT.03/07 CIBANTENG CIAMPEA', '20Mbps'),
	(99, 'Dyan Firmantiyo Soetrisno', '81329329123', 'Perum Mukti Harjo Indah JL Murtiwangi No.122 RT 003 RW 015 Muktiharjo Kidul', '20Mbps'),
	(100, 'Nyimas Ayu Wandira', '85771354600', 'Kp.Sidakmukti jalan SLTP segar RT/RW 01/02 no.28 sukamaju kel.cilodong Depok jawabarat (kontrakan bapak jamal)', '20Mbps'),
	(101, 'ACHMAD JAYA', '87770335863', 'JL KANCIL RT07/04 KEL TENGAH KEC CIBINONG', '20Mbps'),
	(102, 'Devi Handayani 1', '85775136539', 'Kp kandang panjang RT 02 Rw 05 No.109 kelurahan Tajur halang kecamatan tajur halang', '20Mbps'),
	(103, 'Mamay Mulyani (HE)', '81317061833', 'Kp. Ciluar Batas RT 02 RW 05 no 86 Kel Cimandala Kec Sukaraja Kab Bogor Jawa Barat', '20Mbps'),
	(104, 'MATHEUS RICO HERJUNO ( MRV )', '85158006312', 'Griya bukit jaya blok m17 no 29 rt 03 rw 30 tlajung udik gunung putri bogor', '20Mbps'),
	(105, 'Bpk. Aris', '81382982565', 'Kp. Kebon Kalapa RT. 003 RW. 002 Ds. Jeungjing Kec. Cisoka Tangerang Banten', '20Mbps'),
	(106, 'Siti nuryanti', '82123670988', 'Sindang rasa RT 002 RW 006 no.287', '20Mbps'),
	(107, 'MAULANA REZQY ADITYA ( DYS )', '89519639461', 'Kp cipayung rt 06 rw 07 pondok rajeg bogor', '20Mbps'),
	(108, 'Pinka samiha nursasmiyati', '83867315783', 'jln.bulak barat RT.04/008 No.185', '20Mbps'),
	(109, 'Suharto ...', '81288026280', 'kp pajeleran sukahati cibinong rt 07 rw 08', '20Mbps'),
	(110, 'JUHANI NUR PRIYATIN (mm', '83892803419', 'kp.babakan rt.03/02 tarikolot citeureup - kontrakan pak edo', '20Mbps'),
	(111, 'WAJIM ( DYS )', '895384121518', 'Kp kramat cikaret rt 02 rw 03 harapan jaya cikaret', '20Mbps'),
	(112, 'NUR HALIM', '81805418873', 'pondok pengalasan no.14', '20Mbps'),
	(113, 'Bahrul Nur Hayat', '81283048361', 'PERUM. PURI ARTA SENTOSA BLOK E NO.08, RT.05/ RW.13, KEL. WARINGIN JAYA, KEC. BOJONG GEDE, KODE POS 16920', '20Mbps'),
	(114, 'edi bambang', '85903766992', 'jln, pidada x No.25 X', '20Mbps'),
	(115, 'LALA NOVIA ( MRV )', '895325819932', 'Bantar kemang rt 04 rw 07 bogor', '20Mbps'),
	(116, 'Aminah. ( Pondok Rajeg )', '82124717720', 'gang h diman RT:02. RW:04. Kel:Pondok Rajeg. Kec:Cibinong', '20Mbps'),
	(117, 'Jaenudin****', '85717536463', 'Ciherang gede no.42 RT.02/RW.01 kel.ciherang kec.dramaga', '20Mbps'),
	(118, 'Dian Firman', '89519334293', 'JL Wonodri Sendang Raya RT 001 RW 005', '20Mbps'),
	(119, 'Wakhyudi', '882006532673', 'Jl. Tegal Mulya RT 04 RW 05 No 37 Tegalmulya, Ledug, Kec. Kembaran, Kabupaten Banyumas, Jawa Tengah 53182', '20Mbps'),
	(120, 'Supriyadi ( CPT )', '89519306236', 'Kampung Karangtempel Utara 315 Karangtempel Karangturi', '20Mbps'),
	(121, 'mitasari marasabessy', '82114246642', 'jl setu sela rt04/02', '20Mbps'),
	(122, 'Dewa ayu arioka', '83119690200', 'Gatsu 6 e no. 5', '20Mbps'),
	(123, 'M Rizki 1', '895385653760', 'Kp Liobaru kelurahan Sanja kecamatan Citeureup RT 01 RW 06', '20Mbps'),
	(124, 'Khairul,,,', '82310202233', 'Perumahan griya bukit jaya blok R 6 NO 36 RT 004 RW 019 Desa Bojong nangka kec gunung putri kab bogor', '20Mbps'),
	(125, 'ARIF RAHMAD ROBI_', '81219685274', 'PERUMAHAN GREEN LE MIRAGE BLOK D JALAN NO.29 BLOK D NO. 29 RT 002 RW 004 CIPAYUNG CIPAYUNG DEPOK 16431', '20Mbps'),
	(126, 'Agus Betty Hanova (Antariksa 1)', '85282803715', 'Perumahan Antariksa 1 Blok D no. 4 Rt 005/Rw 020', '20Mbps'),
	(127, 'IDA BAGUS GEDE ARTAYASA,S.E', '87860563573', 'Perumahan lukluk indah blok C no 31', '20Mbps'),
	(128, 'Kholifah.', '85716499904', 'Jl Sukaraja RT 01 RW 01 Kel Nagrak kec Sukaraja kab bogor', '20Mbps'),
	(129, 'Catur Sakti Arrosyid', '85156327863', 'Manggis VIII / 44 RT 007 RW 003 Lamper Lor', '20Mbps'),
	(130, 'ABD. Rahman', '82337906979', 'JL Brigjen Sudiarto Plamongansari Pedurungan', '20Mbps'),
	(131, 'Miftakhul Munir', '82216941010', 'JL Madusari II RT 002 RW 013 Plamongansari', '50Mbps'),
	(132, 'AISYAH(CITARINGGUL)', '85771008557', 'KP CITARINGGUL RT01/01 KEL CITARINGGUL KEC BABAKAN MADANG', '20Mbps'),
	(133, 'drh. Maureen Tyas Lestari', '81916746555', 'jl Wayan Gentuh Dalung Kuta Utara Badung', '20Mbps'),
	(134, 'Dewi Ningsih', '83151404118', 'kp.puspamegara Rt 03/03 kel.puspanegara kec.citereup', '20Mbps'),
	(136, 'Catur Sakti Arrosyid', '81908027021', 'Perum Green Dahlia. blok G no.36 Kel:Jatimulya. Kec:Cilodong.', '20Mbps'),
	(137, 'Tarsih (cimpaeun)', '895366469955', 'Kp baru rt 02 rw 12 kel cimpaeun kec tapos kota depok', '20Mbps'),
	(138, 'Luthfi Widihantoro (Anggana Village)', '85714531583', 'Perumahan The Anggana Village Cluster Basela, Blok C No. 3A', '15Mbps'),
	(139, 'Mimin rochmayati', '8568271711', 'Perum permata Klapanunggal Blok B6 No 6 RT 07 RW 07 Desa Klapanunggal kec Klapanunggal kab bogor', '20Mbps'),
	(140, 'Romi Hidayah', '89637886945', 'Kp. jatijajar RT. 003/RW.008 No.247, Kel. Jatijajar Kec. Tapos', '20Mbps'),
	(141, 'SURYANINGSIH ( NINGSIH)', '895333691657', 'Kp muara kidul rt 04 rw 14 kel pasirjaya kec bogor barat kota bogor', '20Mbps'),
	(142, 'Susilawati (CKP)', '87770734918', 'Jln. Raya Bogor, Kp. Cikempong RT 01 RW 011 Kel. Pakansari', '20Mbps'),
	(143, 'Kartono Wibowo IR', '89516759966', 'Jl. Jeruk Timur 1 No 2 RT07 RW04 (rumah pribadi)', '20Mbps'),
	(144, 'IRDITA PRIANDINI', '81324125153', 'Perum Samasta 2 Citayam Blok C28, RT.03/RW.10, Ragajaya, Kec. Bojonggede, Kab. Bogor, Jawa Barat 16320', '20Mbps'),
	(145, 'Endah Hamidah', '81233573920', 'Perum. Adella Block B12 Kel. Pasir Nangka Kec. Tigaraksa Kab. Tangerang Provinsi. Banten', '20Mbps'),
	(146, 'Agus Leo Sandy', '88211333727', 'Jl. SMP Nusantara RT02/05 Ragajaya, Bojong Gede', '20Mbps'),
	(147, 'Ahmad bayo (tlj)', '82114492844', 'Kp tlajung udik 02/05 tlajung udik gunung putri bogor jabar', '20Mbps'),
	(148, 'Riska ariska', '895622588067', 'Bantar Kemang RT 04 RW 07 Kel bantar Kemang kec Bogor timur', '20Mbps'),
	(149, 'Nanda Tri Novita', '895358391024', 'JL Sidorejo 07 no.9 RT 007 RW 007 Sidorejo Gayamsari', '20Mbps'),
	(150, 'TONI GUNAWAN.,..,.', '87873246377', 'Kp babakan RT01/009 No.7 bubulak', '20Mbps'),
	(151, 'Ari Yansyah_JJR', '81319635348', 'Jl.Jatijajar 2 04/08 Jatijajar Tapos Depok.(Kontrakan Pak Yono)', '20Mbps'),
	(152, 'RINA APRILLIANI (MD)', '895349160812', 'Kp Momonot RT 01 RW 12 Tlajung Udik Gunung Putri', '20Mbps'),
	(153, 'Sukma Rahayu Pratiwi', '82122678127', 'kontrakan hj.sofyan rt.01 rw.05 gang bambu 2 pojok desa Telajung udik Kecamatan Tlajung Udik', '20Mbps'),
	(154, 'Abu_(CBN)', '87870542094', 'Jl.amanah no.32 04/08 Cibinong Bogor', '20Mbps'),
	(155, 'META SUTIANAH', '8977045484', 'Jl.raya muchtar gg.poncol rt 001 rw 007 no.21 kel.sawangan kec.sawangan depok jawa barat 16511', '20Mbps'),
	(156, 'Nur Hazizah', '85893131847', 'Desa Dukuhwaluh Jl Sumardi No 30 RT 003 RW 009 Dukuhwaluh Kembaran', '20Mbps'),
	(157, 'Yandhia', '89685836590', 'Kp sawah rt 02 rw 04 kel jatimuya kec cilodong kota depok', '20Mbps'),
	(158, 'Neneng herawati', '81802109727', 'Kp.cibeureum rt003 rw002 kel.neglasari kec.dramaga', '20Mbps'),
	(159, 'Randi joyo saputro (cmp)', '81329290931', 'Kp.cimpaeun RT 2 rw8 Kel.cimpaeun kec.tapos (kontrakan ibu irma)', '30Mbps');

-- Dumping structure for table java-inv-helpdesk.delivery_orders
DROP TABLE IF EXISTS `delivery_orders`;
CREATE TABLE IF NOT EXISTS `delivery_orders` (
  `id` int NOT NULL AUTO_INCREMENT,
  `ticket_id` int DEFAULT NULL,
  `user_id` int DEFAULT NULL,
  `notes` text COLLATE utf8mb4_general_ci,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=100029 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- Dumping data for table java-inv-helpdesk.delivery_orders: ~0 rows (approximately)
REPLACE INTO `delivery_orders` (`id`, `ticket_id`, `user_id`, `notes`) VALUES
	(100007, 1007, 2, 'teknisi minta router'),
	(100008, 1009, 6, 'pasang baru'),
	(100009, 1011, 6, 'Pergantian router'),
	(100010, 1012, 6, 'Teknisi minta bawa router dan kabel'),
	(100011, 1013, 2, 'Teknisi minta bawa perangkat router dan kabel'),
	(100013, 1016, 2, 'Dibawa oleh teknisi hafidz'),
	(100014, 1017, 2, 'Di bawa sofyan'),
	(100016, 1019, 2, 'dibawa oleh teknisi hafidz'),
	(100017, 1020, 2, 'sedang di bawa oleh teknisi sofyan\r\n'),
	(100018, 1021, 2, 'sedang dibawa oleh teknisi hafidz'),
	(100019, 1022, 7, 'sedang di bawa oleh teknisi sofyan'),
	(100020, 1023, 7, 'sedang di bawa teknisi Hafidz'),
	(100021, 1024, 2, 'sedang di bawa oleh teknisi Sofyan'),
	(100022, 1025, 7, 'Tidak ada barang, perlu di check koneksi saja'),
	(100023, 1007, 7, 'tidak bisa akses, Youtube, Tiktok, Shope dll\r\nInternet Loading lambat'),
	(100024, 1027, 2, 'Internet Tidak ada akses'),
	(100025, 1028, 7, 'Perapihan kabel'),
	(100026, 1029, 2, 'pasang baru'),
	(100027, 1030, 7, 'tambah access point wifi'),
	(100028, 1031, 7, 'Reposisi oleh sofyan');

-- Dumping structure for table java-inv-helpdesk.do_assets
DROP TABLE IF EXISTS `do_assets`;
CREATE TABLE IF NOT EXISTS `do_assets` (
  `id` int NOT NULL AUTO_INCREMENT,
  `delivery_order_id` int DEFAULT NULL,
  `asset_id` int DEFAULT NULL,
  `qty` int DEFAULT NULL,
  `status` varchar(50) COLLATE utf8mb4_general_ci DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=63 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- Dumping data for table java-inv-helpdesk.do_assets: ~0 rows (approximately)
REPLACE INTO `do_assets` (`id`, `delivery_order_id`, `asset_id`, `qty`, `status`) VALUES
	(20, 100007, 1000022, 1, 'Installed'),
	(21, 100008, 1000005, 1, 'Installed'),
	(22, 100008, 1000021, 1, 'Installed'),
	(23, 100009, 1000012, 1, 'Installed'),
	(26, 100010, 1000013, 1, 'Installed'),
	(27, 100010, 1000002, 1, 'Installed'),
	(29, 100011, 1000012, 1, 'Installed'),
	(31, 100011, 1000002, 1, 'Installed'),
	(33, 100012, 1000013, 1, 'Deliver'),
	(34, 100013, 1000006, 1, 'Deliver'),
	(35, 100013, 1000002, 1, 'Deliver'),
	(36, 100013, 1000004, 4, 'Deliver'),
	(37, 100014, 1000020, 1, 'Installed'),
	(39, 100016, 1000005, 1, 'Installed'),
	(40, 100017, 1000014, 1, 'Installed'),
	(41, 100017, 1000014, 1, 'Deliver'),
	(43, 100018, 1000003, 1, 'Installed'),
	(44, 100019, 1000003, 1, 'Installed'),
	(45, 100019, 1000003, 1, 'Deliver'),
	(46, 100020, 1000028, 1, 'Installed'),
	(47, 100020, 1000028, 1, 'Deliver'),
	(49, 100021, 1000029, 1, 'Installed'),
	(50, 100022, 1000030, 5, 'Installed'),
	(51, 100022, 1000002, 1, 'Deliver'),
	(52, 100022, 1000002, 1, 'Deliver'),
	(53, 100018, 1000003, 1, 'Deliver'),
	(54, 100023, 1000031, 1, 'Installed'),
	(55, 100024, 1000032, 2, 'Installed'),
	(56, 100025, 1000033, 3, 'Installed'),
	(57, 100025, 1000034, 5, 'Installed'),
	(58, 100026, 1000002, 1, 'Installed'),
	(59, 100026, 1000035, 1, 'Installed'),
	(60, 100027, 1000020, 1, 'Installed'),
	(61, 100028, 1000002, 1, 'Installed'),
	(62, 100028, 1000029, 1, 'Installed');

-- Dumping structure for table java-inv-helpdesk.do_settlements
DROP TABLE IF EXISTS `do_settlements`;
CREATE TABLE IF NOT EXISTS `do_settlements` (
  `id` int NOT NULL AUTO_INCREMENT,
  `do_asset_id` int NOT NULL DEFAULT '0',
  `activity_report_id` int NOT NULL,
  `fault_model_number` varchar(50) COLLATE utf8mb4_general_ci DEFAULT '0',
  `fault_part_number` varchar(50) COLLATE utf8mb4_general_ci DEFAULT NULL,
  `fault_serial_number` varchar(50) COLLATE utf8mb4_general_ci DEFAULT NULL,
  `fault_name` text COLLATE utf8mb4_general_ci,
  `fault_qty` int DEFAULT NULL,
  `notes` text COLLATE utf8mb4_general_ci NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=36 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- Dumping data for table java-inv-helpdesk.do_settlements: ~0 rows (approximately)
REPLACE INTO `do_settlements` (`id`, `do_asset_id`, `activity_report_id`, `fault_model_number`, `fault_part_number`, `fault_serial_number`, `fault_name`, `fault_qty`, `notes`) VALUES
	(11, 20, 10008, 'WR820N', 'WR820N', 'SGTO9032IOFW', 'WR 820n Wifi extender Access Point', 1, 'SUDAH DIGANTI'),
	(12, 21, 10009, 'FO-SC-100', 'FO-SC-100', '-', 'FIBER OPTIC Single Core 100 Meter', 1, 'pasang baru'),
	(13, 22, 10009, 'WR820N', 'WR820N', '-', 'WR 820n Wifi extender Access Point', 1, 'pasang baru'),
	(14, 23, 10009, 'RB750r2', 'RB750r2', 'JAWDI82H23R', 'RB750r2 (hEX-Lite)', 1, 'DIGANTI DENGAN YANG BARU'),
	(15, 26, 10011, 'RB1100Dx4', 'RB1100Dx4', 'JFEW9023HF2023', 'Router RB1100Dx4 1U Rackmount', 1, 'SUDAH DIGANTI'),
	(16, 27, 10012, 'STP', 'STP', '-', 'Cable LAN STP 30 Meter (Outdoor)', 1, 'SUDAH DIGANTI'),
	(17, 29, 10011, 'RB750r2', 'RB750r2', 'UHW9032HR239', 'RB750r2 (hEX-Lite)', 1, 'SUDAH DIGANTI'),
	(18, 31, 10012, 'STP', 'STP', '-', 'Cable LAN STP 30 Meter (Outdoor)', 1, 'SUDAH DIGANTI'),
	(19, 37, 10017, '', '', '', '', 0, 'tambah akses point baru'),
	(20, 39, 10012, '39 | 1000005', '39 | 1000005', 'FO-SC-100', 'FIBER OPTIC Single Core 100 Meter', 1, 'Tarik ulang Kabel DW'),
	(21, 40, 10019, 'F660', 'F660', 'ZTEGC8024R34', 'ONT ZTE', 1, 'Ganti perangkat ONT'),
	(22, 43, 10020, 'BAREL', 'BAREL', '-', 'Barel Cable Connector', 1, 'Ganti barel Connnector '),
	(23, 44, 10021, 'BAREL', 'BAREL', '-', 'Barel Cable Connector', 1, 'Ganti barel Connnector '),
	(24, 46, 10022, 'TP-Link GPON ONU GP110', 'TP-Link GPON ONU GP110', '-', 'Adaptor ONT', 1, 'Ganti Adaptor ONT'),
	(25, 49, 10023, 'DW-ONT-SM 250M', 'DW-ONT-SM 250M', 'SN1987', 'Kabel Fiber DW ONT 250M', 1, 'Relokasi Rumah'),
	(26, 50, 10024, 'RJ-45', 'RJ-45', '-', 'Connector RJ-45', 5, 'sudah di pakai 4'),
	(27, 54, 10025, 'hEX lite', 'hEX lite', 'HF298HF23R', 'Mikrotik hEX lite', 1, 'Replace Router'),
	(28, 55, 10026, 'FO-ADAPTER', 'FO-ADAPTER', '-', 'Adapter Fiber Optic', 2, 'Sambung Kabel'),
	(29, 56, 10027, 'Nylon cable Tie', 'Nylon cable Tie', '-', 'Velcro Starp Cable', 3, 'Perapihan'),
	(30, 57, 10027, 'Ties', 'Ties', '-', 'Kabel Ties Velcro', 5, 'Perapihan'),
	(31, 58, 10029, 'STP', 'STP', '-', 'Cable LAN STP 30 Meter (Outdoor)', 1, 'install baru'),
	(32, 59, 10008, 'hEX S', 'hEX S', '-', 'hEX S', 1, 'install baru'),
	(33, 60, 10030, 'TL-WR845N', 'TL-WR845N', 'SGH892IEF9HF23', '300Mbps Wireless N WiFi Router Access Point', 1, 'Tambah WIFI'),
	(34, 61, 10031, 'STP', 'STP', '-', 'Cable LAN STP 30 Meter (Outdoor)', 1, 'Tarik Kabel'),
	(35, 62, 10031, 'DW-ONT-SM 250M', 'DW-ONT-SM 250M', '-', 'Kabel Fiber DW ONT 250M', 1, 'Tarik Ulang Kabel');

-- Dumping structure for table java-inv-helpdesk.racks
DROP TABLE IF EXISTS `racks`;
CREATE TABLE IF NOT EXISTS `racks` (
  `id` int NOT NULL AUTO_INCREMENT,
  `name` varchar(50) COLLATE utf8mb4_general_ci DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- Dumping data for table java-inv-helpdesk.racks: ~0 rows (approximately)
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

-- Dumping structure for table java-inv-helpdesk.tickets
DROP TABLE IF EXISTS `tickets`;
CREATE TABLE IF NOT EXISTS `tickets` (
  `id` int NOT NULL AUTO_INCREMENT,
  `customer_id` int DEFAULT NULL,
  `user_id` int DEFAULT NULL,
  `status` varchar(255) COLLATE utf8mb4_general_ci DEFAULT NULL,
  `problem` varchar(255) COLLATE utf8mb4_general_ci DEFAULT NULL,
  `description` text COLLATE utf8mb4_general_ci,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1032 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- Dumping data for table java-inv-helpdesk.tickets: ~0 rows (approximately)
REPLACE INTO `tickets` (`id`, `customer_id`, `user_id`, `status`, `problem`, `description`) VALUES
	(1007, 4, 4, 'Close', 'Internet lemot', 'sudah dari kemarin internet lemota'),
	(1008, 78, 5, 'Open', 'Upgrade paket', 'Up ke Dedicated 20 Mbps'),
	(1009, 157, 4, 'Open', 'Install baru', 'Paket UpTo 30 Mbps'),
	(1011, 31, 4, 'Open', 'Ganti Perangkat', 'perangkat sudah tidak layak'),
	(1012, 41, 5, 'Close', 'Unblock Port', 'Buka blockir port 23 untuk IP Public'),
	(1016, 23, 4, 'Open', 'internet mati', 'sudah mati 2 hari,sudah coba restart modem tapi belum bisa'),
	(1017, 144, 5, 'Open', 'Sinyal WIFI Jelek', 'Di halaman belakang rumah hanya dapat 1 bar sinyal WIFI'),
	(1019, 158, 4, 'Open', 'Kabel FO putus', 'Internet tidak ada akses - Perangkat ada lampu merah'),
	(1020, 157, 5, 'Open', 'Intermitten', 'Internet Intermitten'),
	(1021, 155, 4, 'Open', 'No Internet', 'Tidak ada akses internet'),
	(1022, 15, 4, 'Open', 'No Internet', 'Tidak ada akses internet'),
	(1023, 17, 4, 'Open', 'ONT Matot', 'ONT Matot'),
	(1024, 7, 5, 'Open', 'Relokasi', 'Relokasi Pemasangan'),
	(1025, 131, 4, 'Open', 'Internet lemot', 'Perlu di check koneksi kabel'),
	(1026, 100, 4, 'Open', 'Internet down', 'Internet Loading lambat\r\ntidak bisa akses, Youtube, Tiktok, Shope dll'),
	(1027, 157, 4, 'Open', 'Kabel FO Bending', 'Internet Tidak ada akses'),
	(1028, 40, 4, 'Progress', 'Perapihan Kabel', 'Perapihan Kabel'),
	(1029, 59, 5, 'Open', 'Pasang Internet Baru', 'Pasang Internet Baru'),
	(1030, 67, 5, 'Open', 'Nambah Paket ke 100 Mbps', 'Upgrade paket internet'),
	(1031, 25, 5, 'Open', 'Reposisi', 'Pindah posisi');

-- Dumping structure for table java-inv-helpdesk.users
DROP TABLE IF EXISTS `users`;
CREATE TABLE IF NOT EXISTS `users` (
  `id` int NOT NULL AUTO_INCREMENT,
  `email` varchar(50) COLLATE utf8mb4_general_ci NOT NULL DEFAULT '0',
  `name` varchar(50) COLLATE utf8mb4_general_ci NOT NULL DEFAULT '0',
  `password` text COLLATE utf8mb4_general_ci NOT NULL,
  `role` varchar(225) COLLATE utf8mb4_general_ci NOT NULL DEFAULT '0',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- Dumping data for table java-inv-helpdesk.users: ~0 rows (approximately)
REPLACE INTO `users` (`id`, `email`, `name`, `password`, `role`) VALUES
	(1, 'dandy@gmail.com', 'Dandy Bagus Prasetyo', 'b30e4c80db9f696c1094a6f4ee31162cf2a8d207a3f75867064d3f60da436e7a68f92a25be632271ea40a62d5be83a5bf75297bcd58ffdaf6c5ae5fa37dd5e7d', 'Management'),
	(2, 'agus@gmail.com', 'Agus Nugroho', 'b30e4c80db9f696c1094a6f4ee31162cf2a8d207a3f75867064d3f60da436e7a68f92a25be632271ea40a62d5be83a5bf75297bcd58ffdaf6c5ae5fa37dd5e7d', 'Warehouse'),
	(3, 'reza@gmail.com', 'Reza Pradana', 'b30e4c80db9f696c1094a6f4ee31162cf2a8d207a3f75867064d3f60da436e7a68f92a25be632271ea40a62d5be83a5bf75297bcd58ffdaf6c5ae5fa37dd5e7d', 'Helpdesk'),
	(4, 'hafidz@gmail.com', 'Hafidz Aris M', 'b30e4c80db9f696c1094a6f4ee31162cf2a8d207a3f75867064d3f60da436e7a68f92a25be632271ea40a62d5be83a5bf75297bcd58ffdaf6c5ae5fa37dd5e7d', 'Engineer'),
	(5, 'sofyan@gmail.com', 'Moh Sofyan', 'b30e4c80db9f696c1094a6f4ee31162cf2a8d207a3f75867064d3f60da436e7a68f92a25be632271ea40a62d5be83a5bf75297bcd58ffdaf6c5ae5fa37dd5e7d', 'Engineer'),
	(6, 'nofal@gmail.com', 'Nofal', 'b30e4c80db9f696c1094a6f4ee31162cf2a8d207a3f75867064d3f60da436e7a68f92a25be632271ea40a62d5be83a5bf75297bcd58ffdaf6c5ae5fa37dd5e7d', 'Management'),
	(7, 'dila@gmail.com', 'Dila', 'b30e4c80db9f696c1094a6f4ee31162cf2a8d207a3f75867064d3f60da436e7a68f92a25be632271ea40a62d5be83a5bf75297bcd58ffdaf6c5ae5fa37dd5e7d', 'Warehouse');

/*!40103 SET TIME_ZONE=IFNULL(@OLD_TIME_ZONE, 'system') */;
/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IFNULL(@OLD_FOREIGN_KEY_CHECKS, 1) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40111 SET SQL_NOTES=IFNULL(@OLD_SQL_NOTES, 1) */;
