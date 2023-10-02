-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Oct 02, 2023 at 11:14 AM
-- Server version: 10.4.28-MariaDB
-- PHP Version: 8.2.4

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `kafe`
--

-- --------------------------------------------------------

--
-- Table structure for table `category_sorasak_6210451560`
--

CREATE TABLE `category_sorasak_6210451560` (
  `id` binary(16) NOT NULL,
  `name` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `category_sorasak_6210451560`
--

INSERT INTO `category_sorasak_6210451560` (`id`, `name`) VALUES
(0x2e6e624a4c284774b87c9bf7f200f273, 'Dessert'),
(0x87c34a386917465e8aef7a2c984d6696, 'Coffee'),
(0xe52aa37371054f3ea002132db8ccb0db, 'Snacks'),
(0xfe74e55d0ea24b59934da169b713c47a, 'Tea');

-- --------------------------------------------------------

--
-- Table structure for table `member_sorasak_6210451560`
--

CREATE TABLE `member_sorasak_6210451560` (
  `id` binary(16) NOT NULL,
  `name` varchar(255) DEFAULT NULL,
  `password` varchar(255) DEFAULT NULL,
  `role` varchar(255) DEFAULT NULL,
  `username` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `member_sorasak_6210451560`
--

INSERT INTO `member_sorasak_6210451560` (`id`, `name`, `password`, `role`, `username`) VALUES
(0x31376533373861342d343234362d3430, 'manager', '$2a$12$12KZ2LWY4VbdGZnYswxUOuStcv4hrgToFo5sXsQGkqOP.N6xJF5s6', 'ROLE_ADMIN', 'manager'),
(0xf1ca8e297fa14002afcf56c86640a66b, 'mex', '$2a$12$.X7T85CyfBN6Vs/dtja7B.81QiZgQWqhCYWodgQJtbRO9uDhRArTW', 'ROLE_USER', 'mex');

-- --------------------------------------------------------

--
-- Table structure for table `menu_sorasak_6210451560`
--

CREATE TABLE `menu_sorasak_6210451560` (
  `id` binary(16) NOT NULL,
  `name` varchar(255) DEFAULT NULL,
  `price` double NOT NULL,
  `category_id` binary(16) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `menu_sorasak_6210451560`
--

INSERT INTO `menu_sorasak_6210451560` (`id`, `name`, `price`, `category_id`) VALUES
(0x11cc0e6269624a97ae826b075e29ab87, 'Cuppuccino', 55, 0x87c34a386917465e8aef7a2c984d6696),
(0x185abda6b8aa47c3b2ba8739c571ec25, 'Berry Cheesecake', 35, 0x2e6e624a4c284774b87c9bf7f200f273),
(0x35d45a278d2b4b8fa13a27d710c4a4b7, 'Brownie', 55, 0x2e6e624a4c284774b87c9bf7f200f273),
(0x5d4bf33b4b244aa98a176481ec7943a2, 'Veg Burger', 50, 0xe52aa37371054f3ea002132db8ccb0db),
(0x73b791ab54434f16bd476fcbc303f738, 'Thai Tea', 50, 0xfe74e55d0ea24b59934da169b713c47a),
(0x7cbf4e28765e473da3037ee8388d3a0f, 'Expesso', 45, 0x87c34a386917465e8aef7a2c984d6696),
(0xb2021d60dc564bb6babba0a92e1d157f, 'Kiwi Soda', 35, 0xfe74e55d0ea24b59934da169b713c47a),
(0xba85d750d35b428a9c53226e15a0f9dc, 'Mocca', 60, 0x87c34a386917465e8aef7a2c984d6696),
(0xbf8b6ccff6ef4df1af9715ae06b4b376, 'Latte', 60, 0x87c34a386917465e8aef7a2c984d6696),
(0xc2d45fafda5049939da5506ecb464178, 'Matcha Latte', 70, 0xfe74e55d0ea24b59934da169b713c47a),
(0xdf47ee4a0b5747efa828d3b33d4507d2, 'Sandwich', 45, 0xe52aa37371054f3ea002132db8ccb0db);

-- --------------------------------------------------------

--
-- Table structure for table `order_item_sorasak_6210451560`
--

CREATE TABLE `order_item_sorasak_6210451560` (
  `menu_id` binary(16) NOT NULL,
  `order_id` binary(16) NOT NULL,
  `quantity` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `order_item_sorasak_6210451560`
--

INSERT INTO `order_item_sorasak_6210451560` (`menu_id`, `order_id`, `quantity`) VALUES
(0x185abda6b8aa47c3b2ba8739c571ec25, 0xbf7cf0155e2b4407b1016f1686bc776f, 1),
(0x5d4bf33b4b244aa98a176481ec7943a2, 0x76dacbb62e0d4fff8ee36526313642fd, 2),
(0x73b791ab54434f16bd476fcbc303f738, 0xf99fbbf5caa548809ec89ff6f5982381, 2),
(0xbf8b6ccff6ef4df1af9715ae06b4b376, 0x5109651fb1c846799298fc838554579a, 1),
(0xdf47ee4a0b5747efa828d3b33d4507d2, 0xe0eb361ad36549a091c420645f32b523, 1);

-- --------------------------------------------------------

--
-- Table structure for table `purchase_order_sorasak_6210451560`
--

CREATE TABLE `purchase_order_sorasak_6210451560` (
  `id` binary(16) NOT NULL,
  `status` tinyint(4) DEFAULT NULL,
  `timestamp` datetime(6) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `purchase_order_sorasak_6210451560`
--

INSERT INTO `purchase_order_sorasak_6210451560` (`id`, `status`, `timestamp`) VALUES
(0x5109651fb1c846799298fc838554579a, 1, '2023-10-02 15:51:27.000000'),
(0x76dacbb62e0d4fff8ee36526313642fd, 2, '2023-10-02 16:02:21.000000'),
(0xbf7cf0155e2b4407b1016f1686bc776f, 2, '2023-10-02 15:50:06.000000'),
(0xe0eb361ad36549a091c420645f32b523, 1, '2023-10-02 16:09:26.000000'),
(0xf99fbbf5caa548809ec89ff6f5982381, 2, '2023-10-02 16:12:06.000000');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `category_sorasak_6210451560`
--
ALTER TABLE `category_sorasak_6210451560`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `member_sorasak_6210451560`
--
ALTER TABLE `member_sorasak_6210451560`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `menu_sorasak_6210451560`
--
ALTER TABLE `menu_sorasak_6210451560`
  ADD PRIMARY KEY (`id`),
  ADD KEY `FKleh9wwkheth7dcgt88jdlf6v0` (`category_id`);

--
-- Indexes for table `order_item_sorasak_6210451560`
--
ALTER TABLE `order_item_sorasak_6210451560`
  ADD PRIMARY KEY (`menu_id`,`order_id`),
  ADD KEY `FKj5ryvx95s64esdprq1vv12vr4` (`order_id`);

--
-- Indexes for table `purchase_order_sorasak_6210451560`
--
ALTER TABLE `purchase_order_sorasak_6210451560`
  ADD PRIMARY KEY (`id`);

--
-- Constraints for dumped tables
--

--
-- Constraints for table `menu_sorasak_6210451560`
--
ALTER TABLE `menu_sorasak_6210451560`
  ADD CONSTRAINT `FKleh9wwkheth7dcgt88jdlf6v0` FOREIGN KEY (`category_id`) REFERENCES `category_sorasak_6210451560` (`id`);

--
-- Constraints for table `order_item_sorasak_6210451560`
--
ALTER TABLE `order_item_sorasak_6210451560`
  ADD CONSTRAINT `FK42v1i8q2iepb55q8r5loun8vi` FOREIGN KEY (`menu_id`) REFERENCES `menu_sorasak_6210451560` (`id`),
  ADD CONSTRAINT `FKj5ryvx95s64esdprq1vv12vr4` FOREIGN KEY (`order_id`) REFERENCES `purchase_order_sorasak_6210451560` (`id`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
