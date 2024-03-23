-- phpMyAdmin SQL Dump
-- version 5.1.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: May 26, 2022 at 05:39 PM
-- Server version: 10.4.22-MariaDB
-- PHP Version: 8.1.2

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `chtt`
--

-- --------------------------------------------------------

--
-- Table structure for table `hoadon`
--

CREATE TABLE `hoadon` (
  `mahd` varchar(10) NOT NULL,
  `mahang` varchar(10) NOT NULL,
  `manv` varchar(10) NOT NULL,
  `makh` varchar(10) NOT NULL,
  `ngay` date NOT NULL,
  `soluong` int(10) NOT NULL,
  `gia` bigint(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `hoadon`
--

INSERT INTO `hoadon` (`mahd`, `mahang`, `manv`, `makh`, `ngay`, `soluong`, `gia`) VALUES
('HD1', 'MH1', 'NV2', 'KH05', '2022-06-05', 5, 1500000),
('HD10', 'MH1', 'NV2', 'KH05', '2022-06-05', 1, 300000),
('HD2', 'MH3', 'NV2', 'KH05', '2022-05-24', 4, 202000),
('HD3', 'MH5', 'NV2', 'KH05', '2022-06-05', 3, 333333),
('HD4', 'MH4', 'NV3', 'KH01', '2022-05-05', 2, 1400000),
('HD5', 'MH1', 'NV2', 'KH05', '2022-06-05', 5, 1500000),
('HD6', 'MH5', 'NV1', 'KH05', '2022-06-05', 2, 222222),
('HD7', 'MH4', 'NV4', 'KH01', '2022-05-25', 3, 2100000),
('HD8', 'MH1', 'NV2', 'KH01', '2022-05-25', 1, 300000),
('HD9', 'MH1', 'NV1', 'KH05', '2022-05-05', 1, 300000);

-- --------------------------------------------------------

--
-- Table structure for table `khachhang`
--

CREATE TABLE `khachhang` (
  `makh` varchar(10) NOT NULL,
  `tenkh` varchar(50) NOT NULL,
  `diachi` varchar(100) NOT NULL,
  `sodth` int(12) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `khachhang`
--

INSERT INTO `khachhang` (`makh`, `tenkh`, `diachi`, `sodth`) VALUES
('KH01', 'Thành ', 'Gò Vấp', 90411167),
('KH02', 'Linda', 'sgu', 123),
('KH03', 'dung ma ma', 'chuồng gà', 1234578),
('KH04', 'Tài', 'Long An', 90888811),
('KH05', 'Thanh', 'Tây Ninh', 1112223);

-- --------------------------------------------------------

--
-- Table structure for table `login`
--

CREATE TABLE `login` (
  `manv` varchar(30) NOT NULL,
  `password` varchar(30) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `login`
--

INSERT INTO `login` (`manv`, `password`) VALUES
('nv1', '12345'),
('NV2', '12345');

-- --------------------------------------------------------

--
-- Table structure for table `mathang`
--

CREATE TABLE `mathang` (
  `mahang` varchar(10) NOT NULL,
  `tenhang` varchar(50) NOT NULL,
  `loai` varchar(50) NOT NULL,
  `gia` double NOT NULL,
  `soluong` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `mathang`
--

INSERT INTO `mathang` (`mahang`, `tenhang`, `loai`, `gia`, `soluong`) VALUES
('MH1', 'Quần jeans', 'Quần', 300000, 50),
('MH2', 'áo croptop', 'Áo', 15000, 150),
('MH3', 'dây chuyền', 'Phụ kiện', 50500, 100),
('MH4', 'Quần đùi', 'Quần', 700000, 200),
('MH5', 'áo thun', 'Áo', 111111, 15),
('MH7', 'Giày thể thao', 'Giày dép', 2000000, 10);

-- --------------------------------------------------------

--
-- Table structure for table `nhanvien`
--

CREATE TABLE `nhanvien` (
  `manv` varchar(10) NOT NULL,
  `tennv` varchar(80) NOT NULL,
  `chucvu` varchar(30) NOT NULL,
  `diachi` varchar(80) NOT NULL,
  `sodth` int(12) NOT NULL,
  `luong` double NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `nhanvien`
--

INSERT INTO `nhanvien` (`manv`, `tennv`, `chucvu`, `diachi`, `sodth`, `luong`) VALUES
('NV1', 'Lê Hương Thanh', 'Nhân viên bán hàng', 'Tây Ninh', 123, 1),
('NV2', 'Thành', 'Nhân viên bán hàng', 'Gò vấp ', 1234, 12000),
('NV3', 'Trân', 'Nhân viên thu ngân', 'Tân Bình', 1234, 1233),
('NV4', 'Thảo', 'Nhân viên bán hàng', 'Bình định', 1122334, 12000),
('NV5', 'Tài', 'Nhân viên thu ngân', 'Long An ', 97654356, 1);

--
-- Indexes for dumped tables
--

--
-- Indexes for table `hoadon`
--
ALTER TABLE `hoadon`
  ADD PRIMARY KEY (`mahd`),
  ADD KEY `hd` (`mahang`),
  ADD KEY `hd_1` (`manv`),
  ADD KEY `hd_2` (`makh`);

--
-- Indexes for table `khachhang`
--
ALTER TABLE `khachhang`
  ADD PRIMARY KEY (`makh`);

--
-- Indexes for table `login`
--
ALTER TABLE `login`
  ADD PRIMARY KEY (`manv`);

--
-- Indexes for table `mathang`
--
ALTER TABLE `mathang`
  ADD PRIMARY KEY (`mahang`);

--
-- Indexes for table `nhanvien`
--
ALTER TABLE `nhanvien`
  ADD PRIMARY KEY (`manv`);

--
-- Constraints for dumped tables
--

--
-- Constraints for table `hoadon`
--
ALTER TABLE `hoadon`
  ADD CONSTRAINT `hd` FOREIGN KEY (`mahang`) REFERENCES `mathang` (`mahang`),
  ADD CONSTRAINT `hd_1` FOREIGN KEY (`manv`) REFERENCES `nhanvien` (`manv`),
  ADD CONSTRAINT `hd_2` FOREIGN KEY (`makh`) REFERENCES `khachhang` (`makh`);

--
-- Constraints for table `login`
--
ALTER TABLE `login`
  ADD CONSTRAINT `load` FOREIGN KEY (`manv`) REFERENCES `nhanvien` (`manv`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
