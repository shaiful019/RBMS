-- phpMyAdmin SQL Dump
-- version 4.4.14
-- http://www.phpmyadmin.net
--
-- Host: 127.0.0.1
-- Generation Time: Dec 11, 2016 at 08:38 PM
-- Server version: 5.6.26
-- PHP Version: 5.6.12

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `restaurant`
--

-- --------------------------------------------------------

--
-- Table structure for table `food_item`
--

CREATE TABLE IF NOT EXISTS `food_item` (
  `food_name` varchar(30) NOT NULL,
  `price` int(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `food_item`
--

INSERT INTO `food_item` (`food_name`, `price`) VALUES
('Burger', 100),
('Grill', 300),
('ilish polao', 250),
('morog polao', 220),
('kacchi birani', 220),
('tehari', 180),
('sandwich', 50),
('pizza', 280),
('somucha', 15),
('roll', 50),
('singara', 10),
('bread', 30),
('mango juice', 80),
('malta juice', 120),
('apple juice', 120),
('pineapple juice', 50),
('soft drinks', 20),
('lassi', 80),
('tea', 20),
('cofee', 20);

-- --------------------------------------------------------

--
-- Table structure for table `order_info`
--

CREATE TABLE IF NOT EXISTS `order_info` (
  `order_no` int(30) NOT NULL,
  `food_name` varchar(30) NOT NULL,
  `quantity` int(30) NOT NULL,
  `date` date NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `order_info`
--

INSERT INTO `order_info` (`order_no`, `food_name`, `quantity`, `date`) VALUES
(123, 'morog polao', 2, '2016-12-09'),
(123, 'tehari', 3, '2016-12-09'),
(123, 'pineapple juice', 2, '2016-12-09'),
(122, 'morog polao', 2, '2016-12-09'),
(122, 'Grill', 1, '2016-12-09'),
(122, 'roll', 2, '2016-12-09'),
(120, 'bread', 2, '2016-12-09'),
(120, 'Grill', 1, '2016-12-09'),
(120, 'lassi', 1, '2016-12-09'),
(119, 'tehari', 3, '2016-12-09'),
(119, 'lassi', 3, '2016-12-09'),
(125, 'bread', 3, '2016-12-09'),
(125, 'somucha', 3, '2016-12-09'),
(125, 'malta juice', 2, '2016-12-09'),
(52, 'tehari', 3, '2016-12-09'),
(52, 'pineapple juice', 3, '2016-12-09'),
(57, 'ilish polao', 10, '2016-12-09'),
(57, 'tehari', 3, '2016-12-09'),
(57, 'kacchi birani', 3, '2016-12-09'),
(57, 'morog polao', 4, '2016-12-09'),
(57, 'bread', 4, '2016-12-09'),
(57, 'singara', 4, '2016-12-09'),
(57, 'roll', 5, '2016-12-09'),
(57, 'somucha', 4, '2016-12-09'),
(57, 'pizza', 4, '2016-12-09'),
(57, 'sandwich', 4, '2016-12-09'),
(57, 'burger', 4, '2016-12-09'),
(57, 'lassi', 1, '2016-12-09'),
(57, 'soft drinks', 4, '2016-12-09'),
(57, 'pineapple juice', 4, '2016-12-09'),
(57, 'mango juice', 7, '2016-12-09'),
(57, 'apple juice', 6, '2016-12-09'),
(57, 'cofee', 7, '2016-12-09'),
(57, 'tea', 18, '2016-12-09'),
(57, 'malta juice', 11, '2016-12-09'),
(14, 'tehari', 2, '2016-12-09'),
(741, 'Grill', 3, '2016-12-09'),
(741, 'lassi', 4, '2016-12-09'),
(741, 'malta juice', 4, '2016-12-09'),
(741, 'somucha', 4, '2016-12-09'),
(741, 'singara', 3, '2016-12-09'),
(741, 'roll', 4, '2016-12-09'),
(741, 'sandwich', 3, '2016-12-09'),
(741, 'burger', 3, '2016-12-09'),
(41, 'ilish polao', 1, '2016-12-09'),
(41, 'kacchi birani', 1, '2016-12-09'),
(41, 'morog polao', 3, '2016-12-09'),
(41, 'Grill', 3, '2016-12-09'),
(41, 'tehari', 13, '2016-12-09'),
(41, 'bread', 4, '2016-12-09'),
(41, 'burger', 5, '2016-12-09'),
(41, 'sandwich', 3, '2016-12-09'),
(41, 'pizza', 4, '2016-12-09'),
(41, 'somucha', 4, '2016-12-09'),
(41, 'roll', 5, '2016-12-09'),
(41, 'singara', 3, '2016-12-09'),
(41, 'apple juice', 4, '2016-12-09'),
(41, 'mango juice', 4, '2016-12-09'),
(41, 'malta juice', 5, '2016-12-09'),
(41, 'pineapple juice', 6, '2016-12-09'),
(41, 'soft drinks', 5, '2016-12-09'),
(41, 'lassi', 4, '2016-12-09'),
(41, 'tea', 5, '2016-12-09'),
(41, 'cofee', 6, '2016-12-09'),
(142, 'ilish polao', 2, '2016-12-09'),
(142, 'kacchi birani', 2, '2016-12-09'),
(142, 'Grill', 1, '2016-12-09'),
(142, 'bread', 4, '2016-12-09'),
(4574, 'ilish polao', 4, '2016-12-09'),
(4574, 'tehari', 1, '2016-12-09'),
(4574, 'bread', 4, '2016-12-09'),
(4574, 'morog polao', 3, '2016-12-09'),
(4574, 'Grill', 4, '2016-12-09'),
(95, 'Grill', 1, '2016-12-12'),
(95, 'bread', 2, '2016-12-12'),
(95, 'tea', 2, '2016-12-12'),
(95, 'cofee', 1, '2016-12-12'),
(151, 'ilish polao', 2, '2016-12-12'),
(151, 'bread', 3, '2016-12-12'),
(151, 'Grill', 1, '2016-12-12'),
(151, 'roll', 4, '2016-12-12'),
(151, 'lassi', 3, '2016-12-12'),
(151, 'pineapple juice', 3, '2016-12-12'),
(151, 'cofee', 4, '2016-12-12'),
(151, 'tea', 3, '2016-12-12'),
(456, 'kacchi birani', 1, '2016-12-12'),
(456, 'tehari', 2, '2016-12-12'),
(456, 'bread', 4, '2016-12-12'),
(456, 'lassi', 4, '2016-12-12'),
(456, 'tea', 3, '2016-12-12'),
(456, 'pineapple juice', 3, '2016-12-12'),
(456, 'mango juice', 3, '2016-12-12'),
(456, 'apple juice', 2, '2016-12-12'),
(5, 'roll', 3, '2016-12-12'),
(756, 'sandwich', 7, '2016-12-12'),
(756, 'burger', 7, '2016-12-12'),
(756, 'pineapple juice', 4, '2016-12-12'),
(756, 'cofee', 2, '2016-12-12'),
(756, 'tea', 6, '2016-12-12'),
(756, 'morog polao', 2, '2016-12-12'),
(45, 'burger', 5, '2016-12-12'),
(45, 'sandwich', 5, '2016-12-12'),
(45, 'mango juice', 4, '2016-12-12'),
(45, 'cofee', 3, '2016-12-12'),
(45, 'tea', 3, '2016-12-12'),
(45, 'morog polao', 2, '2016-12-12'),
(45, 'bread', 3, '2016-12-12');

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
