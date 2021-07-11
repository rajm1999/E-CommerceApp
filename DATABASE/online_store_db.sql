-- phpMyAdmin SQL Dump
-- version 5.0.2
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Jul 11, 2021 at 04:28 PM
-- Server version: 10.4.13-MariaDB
-- PHP Version: 7.4.7

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `online_store_db`
--

-- --------------------------------------------------------

--
-- Table structure for table `electronic_products`
--

CREATE TABLE `electronic_products` (
  `id` int(11) NOT NULL,
  `name` varchar(255) NOT NULL,
  `price` int(11) NOT NULL,
  `brand` varchar(255) NOT NULL,
  `picture` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `electronic_products`
--

INSERT INTO `electronic_products` (`id`, `name`, `price`, `brand`, `picture`) VALUES
(1, 'Ethinic T-shirt', 1999, 'Nike', 'https://images.unsplash.com/photo-1585032767761-878270336a0b?ixid=MnwxMjA3fDB8MHxzZWFyY2h8NHx8bmlrZSUyMHQlMjBzaGlydHN8ZW58MHx8MHx8&ixlib=rb-1.2.1&auto=format&fit=crop&w=500&q=60'),
(2, 'Grey Solid Polo T-Shirt', 1499, 'Nike', 'https://images.unsplash.com/photo-1563833717765-00462801314e?ixid=MnwxMjA3fDB8MHxzZWFyY2h8MTR8fG5pa2UlMjB0JTIwc2hpcnRzfGVufDB8fDB8fA%3D%3D&ixlib=rb-1.2.1&auto=format&fit=crop&w=500&q=60'),
(3, 'Brown Nike T-shirt', 899, 'Nike', 'https://images.unsplash.com/photo-1611885716429-670e1349b7c0?ixid=MnwxMjA3fDB8MHxzZWFyY2h8MjZ8fG5pa2UlMjB0JTIwc2hpcnRzfGVufDB8fDB8fA%3D%3D&ixlib=rb-1.2.1&auto=format&fit=crop&w=500&q=60'),
(4, 'White Sneakers', 3499, 'Reebok', 'https://images.unsplash.com/photo-1582231640349-6ea6881fabeb?ixid=MnwxMjA3fDB8MHxzZWFyY2h8Mzd8fHJlZWJva3xlbnwwfHwwfHw%3D&ixlib=rb-1.2.1&auto=format&fit=crop&w=500&q=60'),
(5, 'White Plain T-shirt', 599, 'Reebok', 'https://images.unsplash.com/photo-1521572163474-6864f9cf17ab?ixid=MnwxMjA3fDB8MHxzZWFyY2h8MTR8fGZsaXBrYXJ0JTIwY2xvdGhpbmd8ZW58MHx8MHx8&ixlib=rb-1.2.1&auto=format&fit=crop&w=500&q=60'),
(6, 'Bag ', 2599, 'Reebok', 'https://images.unsplash.com/photo-1605018459394-e67bede065d1?ixid=MnwxMjA3fDB8MHxzZWFyY2h8Mzl8fHJlZWJva3xlbnwwfHwwfHw%3D&ixlib=rb-1.2.1&auto=format&fit=crop&w=500&q=60'),
(7, 'Sports Shoes', 6999, 'Nike', 'https://images.unsplash.com/photo-1559252676-c735ac416188?ixid=MnwxMjA3fDB8MHxzZWFyY2h8NDJ8fHJlZWJva3xlbnwwfHwwfHw%3D&ixlib=rb-1.2.1&auto=format&fit=crop&w=500&q=60'),
(8, 'Adidas Men\'s soccer shoes', 4599, 'Adidas', 'https://images.unsplash.com/photo-1580974869414-5e7b7e796a24?ixid=MnwxMjA3fDB8MHxzZWFyY2h8Mjl8fHJlZWJva3xlbnwwfHwwfHw%3D&ixlib=rb-1.2.1&auto=format&fit=crop&w=500&q=60'),
(9, 'Men\'s Red Sports T-shirt', 799, 'Adidas', 'https://images.unsplash.com/photo-1511746315387-c4a76990fdce?ixid=MnwxMjA3fDB8MHxzZWFyY2h8MXx8YWRpZGFzfGVufDB8fDB8fA%3D%3D&ixlib=rb-1.2.1&auto=format&fit=crop&w=500&q=60');

-- --------------------------------------------------------

--
-- Table structure for table `invoice`
--

CREATE TABLE `invoice` (
  `invoice_num` int(11) NOT NULL,
  `invoice_appointment_time` timestamp NOT NULL DEFAULT current_timestamp(),
  `email` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `invoice`
--

INSERT INTO `invoice` (`invoice_num`, `invoice_appointment_time`, `email`) VALUES
(1, '2021-07-11 13:48:22', 'admin@gmail.com');

-- --------------------------------------------------------

--
-- Table structure for table `invoice_details`
--

CREATE TABLE `invoice_details` (
  `invoice_num` int(11) NOT NULL,
  `amount` int(11) NOT NULL,
  `product_id` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `invoice_details`
--

INSERT INTO `invoice_details` (`invoice_num`, `amount`, `product_id`) VALUES
(1, 2, 4),
(1, 2, 3),
(1, 4, 2),
(1, 1, 2);

-- --------------------------------------------------------

--
-- Table structure for table `signup_users`
--

CREATE TABLE `signup_users` (
  `sno` int(11) NOT NULL,
  `email` varchar(30) NOT NULL,
  `username` varchar(20) NOT NULL,
  `password` varchar(255) NOT NULL,
  `dt` datetime NOT NULL DEFAULT current_timestamp()
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `signup_users`
--

INSERT INTO `signup_users` (`sno`, `email`, `username`, `password`, `dt`) VALUES
(1, 'raj@gmail.com', 'raj1911', '$2y$10$w0U8tUtvawIgfeEIH4IiH./3iMitMl48rh2YYHEhuRG9f8vulp4NK', '2021-06-23 18:45:58'),
(2, 'ramesh@gmail.com', 'ramesh123', '$2y$10$bPrN1xuXNGBvNZmUcl7zGOTXYUCkHL.c.AvDOaT3Uj0sGZ9RWhTSO', '2021-06-23 21:17:01'),
(3, 'admin@gmail.com', 'admin', '$2y$10$GVYD9fDTnrqJlI8EXc2wlesbVfi8cF8Bc6Wm9jpE3LMb0QZUF8jMm', '2021-07-11 14:00:11');

-- --------------------------------------------------------

--
-- Table structure for table `temporary_place_order`
--

CREATE TABLE `temporary_place_order` (
  `email` varchar(255) NOT NULL,
  `product_id` int(11) NOT NULL,
  `amount` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `temporary_place_order`
--

INSERT INTO `temporary_place_order` (`email`, `product_id`, `amount`) VALUES
('admin@gmail.com', 2, 4),
('admin@gmail.com', 2, 3),
('admin@gmail.com', 4, 2),
('admin@gmail.com', 1, 2);

--
-- Indexes for dumped tables
--

--
-- Indexes for table `electronic_products`
--
ALTER TABLE `electronic_products`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `invoice`
--
ALTER TABLE `invoice`
  ADD PRIMARY KEY (`invoice_num`);

--
-- Indexes for table `signup_users`
--
ALTER TABLE `signup_users`
  ADD PRIMARY KEY (`sno`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `invoice`
--
ALTER TABLE `invoice`
  MODIFY `invoice_num` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- AUTO_INCREMENT for table `signup_users`
--
ALTER TABLE `signup_users`
  MODIFY `sno` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
