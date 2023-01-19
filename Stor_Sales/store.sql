-- phpMyAdmin SQL Dump
-- version 5.1.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Jan 23, 2022 at 07:19 AM
-- Server version: 10.4.22-MariaDB
-- PHP Version: 8.1.1

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `store`
--

-- --------------------------------------------------------

--
-- Table structure for table `dbtable2`
--

CREATE TABLE `dbtable2` (
  `serial_no` int(20) NOT NULL,
  `item` varchar(50) NOT NULL,
  `price` int(100) NOT NULL,
  `quantity` int(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `dbtable2`
--

INSERT INTO `dbtable2` (`serial_no`, `item`, `price`, `quantity`) VALUES
(1, 'motor', 1200, NULL),
(2, 'belgo', 8500, 0),
(3, 'nisan', 3500, 0),
(4, 'nisan', 3500, 1),
(5, 'nisan', 3500, 3),
(6, 'nisan', 3500, 5),
(7, 'kya', 4500, 5);

-- --------------------------------------------------------

--
-- Table structure for table `table1`
--

CREATE TABLE `table1` (
  `id` int(10) NOT NULL,
  `name` varchar(20) NOT NULL,
  `spare_no` int(10) NOT NULL,
  `price` int(30) DEFAULT NULL,
  `quantity` int(20) DEFAULT NULL,
  `wared` varchar(10) NOT NULL DEFAULT 'japan'
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `table1`
--

INSERT INTO `table1` (`id`, `name`, `spare_no`, `price`, `quantity`, `wared`) VALUES
(3, 'toyota', 2343, 6000, NULL, 'yemen'),
(5, 'soki', 545, 6000, NULL, 'sanaa'),
(8, 'volvo', 555, 3400, NULL, 'mareb'),
(9, 'salses', 1212, 3040, NULL, 'matar'),
(10, 'worker', 3527, 2900, NULL, 'makah'),
(12, 'motor', 565, 1200, NULL, 'japan'),
(13, 'toyota', 1212, 8000, NULL, 'taiz'),
(14, 'nisan', 231, 3500, 10, 'yemen'),
(15, 'belgo', 2365, 8500, 10, 'taize'),
(16, 'kya', 465, 4500, 5, 'aden'),
(17, 'sss', 323, 200, 7, 'taiz');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `dbtable2`
--
ALTER TABLE `dbtable2`
  ADD PRIMARY KEY (`serial_no`);

--
-- Indexes for table `table1`
--
ALTER TABLE `table1`
  ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `dbtable2`
--
ALTER TABLE `dbtable2`
  MODIFY `serial_no` int(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=8;

--
-- AUTO_INCREMENT for table `table1`
--
ALTER TABLE `table1`
  MODIFY `id` int(10) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=18;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
