-- phpMyAdmin SQL Dump
-- version 4.5.1
-- http://www.phpmyadmin.net
--
-- Host: 127.0.0.1
-- Generation Time: Jan 01, 2017 at 08:08 PM
-- Server version: 10.1.19-MariaDB
-- PHP Version: 5.6.28

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `tkafol`
--

-- --------------------------------------------------------

--
-- Table structure for table `area`
--

CREATE TABLE `area` (
  `ID` int(11) NOT NULL,
  `NAME` varchar(200) NOT NULL,
  `STORE_DATE` timestamp NULL DEFAULT CURRENT_TIMESTAMP
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `branch`
--

CREATE TABLE `branch` (
  `ID` int(11) NOT NULL,
  `NAME` varchar(100) DEFAULT NULL,
  `AREA_ID` int(11) DEFAULT NULL,
  `ADDRESS` varchar(222) DEFAULT NULL,
  `AREA_MANAGER_ID` int(11) DEFAULT NULL,
  `STORE_DATE` timestamp NULL DEFAULT CURRENT_TIMESTAMP
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `case`
--

CREATE TABLE `case` (
  `ID` int(11) NOT NULL,
  `CASE_NAME` varchar(200) NOT NULL,
  `FILE_NUMBER` int(11) NOT NULL,
  `RESEARCH_TYPE` int(11) DEFAULT NULL,
  `RESEARCH_DATE` timestamp NULL DEFAULT NULL,
  `ADDRESS` varchar(512) DEFAULT NULL,
  `AREA_ID` int(11) DEFAULT NULL,
  `TELEPHONE` varchar(20) DEFAULT NULL,
  `ID_NUMBER` varchar(45) DEFAULT NULL,
  `ID_ISSUED_PLACE_ID` int(11) DEFAULT NULL,
  `ID_ISSUED_DATE` timestamp NULL DEFAULT NULL,
  `MARITAL_STATUS_ID` int(11) DEFAULT NULL,
  `STORE_DATE` timestamp NULL DEFAULT CURRENT_TIMESTAMP
) ENGINE=InnoDB DEFAULT CHARSET=latin1 COMMENT='main case table ';

-- --------------------------------------------------------

--
-- Table structure for table `diseases`
--

CREATE TABLE `diseases` (
  `ID` int(11) NOT NULL,
  `NAME` varchar(100) DEFAULT NULL,
  `STORE_DATE` timestamp NULL DEFAULT CURRENT_TIMESTAMP
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `diseases`
--

INSERT INTO `diseases` (`ID`, `NAME`, `STORE_DATE`) VALUES
(3, 'virus M-', '2016-12-26 15:20:35'),
(4, 'virus Mkl', '2016-12-26 15:20:41'),
(8, 'Dodckdkd', '2017-01-01 12:04:38'),
(11, 'vvv', '2017-01-01 19:01:14');

-- --------------------------------------------------------

--
-- Table structure for table `gender`
--

CREATE TABLE `gender` (
  `ID` int(11) NOT NULL,
  `NAME` varchar(45) DEFAULT NULL,
  `STORE_DATE` timestamp NULL DEFAULT CURRENT_TIMESTAMP
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `gender`
--

INSERT INTO `gender` (`ID`, `NAME`, `STORE_DATE`) VALUES
(1, 'Male', '2016-12-07 20:19:23'),
(2, 'Female', '2016-12-07 20:19:54');

-- --------------------------------------------------------

--
-- Table structure for table `government`
--

CREATE TABLE `government` (
  `ID` int(11) NOT NULL,
  `NAME` varchar(100) DEFAULT NULL,
  `STORE_DATE` timestamp NULL DEFAULT CURRENT_TIMESTAMP
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `jobs`
--

CREATE TABLE `jobs` (
  `ID` int(11) NOT NULL,
  `NAME` varchar(100) DEFAULT NULL,
  `STORE_DATE` timestamp NULL DEFAULT CURRENT_TIMESTAMP
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `matrial_state`
--

CREATE TABLE `matrial_state` (
  `ID` int(11) NOT NULL,
  `NAME` varchar(45) DEFAULT NULL,
  `STOR_DATE` timestamp NULL DEFAULT CURRENT_TIMESTAMP
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `research_type`
--

CREATE TABLE `research_type` (
  `ID` int(11) NOT NULL,
  `NAME` varchar(100) DEFAULT NULL,
  `STORE_DATE` timestamp NULL DEFAULT CURRENT_TIMESTAMP
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `users`
--

CREATE TABLE `users` (
  `ID` int(11) NOT NULL,
  `USER_NAME` varchar(255) NOT NULL,
  `PASSWORD` varchar(255) NOT NULL,
  `EMAIL` varchar(255) NOT NULL,
  `PHONE` varchar(20) DEFAULT NULL,
  `ADDRESS` varchar(255) DEFAULT NULL,
  `ROLE_ID` int(11) DEFAULT NULL,
  `MANAGER_ID` int(11) DEFAULT NULL,
  `BRANCH_ID` int(11) DEFAULT NULL,
  `AREA_ID` int(11) DEFAULT NULL,
  `GENDER_ID` int(11) DEFAULT NULL,
  `STORE_DATE` timestamp NULL DEFAULT CURRENT_TIMESTAMP
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `users`
--

INSERT INTO `users` (`ID`, `USER_NAME`, `PASSWORD`, `EMAIL`, `PHONE`, `ADDRESS`, `ROLE_ID`, `MANAGER_ID`, `BRANCH_ID`, `AREA_ID`, `GENDER_ID`, `STORE_DATE`) VALUES
(1, 'Admin', 'Admin', 'me.elkady@gmail.com', '01009065701', 'Beha', NULL, NULL, NULL, NULL, NULL, '2016-12-10 16:44:19');

-- --------------------------------------------------------

--
-- Table structure for table `user_role`
--

CREATE TABLE `user_role` (
  `ID` int(11) NOT NULL,
  `NAME` varchar(100) NOT NULL,
  `STORE_DATE` timestamp NULL DEFAULT CURRENT_TIMESTAMP
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Indexes for dumped tables
--

--
-- Indexes for table `area`
--
ALTER TABLE `area`
  ADD PRIMARY KEY (`ID`),
  ADD UNIQUE KEY `NAME_UNIQUE` (`NAME`);

--
-- Indexes for table `branch`
--
ALTER TABLE `branch`
  ADD PRIMARY KEY (`ID`),
  ADD KEY `BRANCH_AREA_FK_idx` (`AREA_ID`),
  ADD KEY `BRANCH_MANAGER_ID_idx` (`AREA_MANAGER_ID`);

--
-- Indexes for table `case`
--
ALTER TABLE `case`
  ADD PRIMARY KEY (`ID`),
  ADD KEY `CASE_RESEARCH_TYP_FK_idx` (`RESEARCH_TYPE`),
  ADD KEY `CASE_AREA_FK_idx` (`AREA_ID`),
  ADD KEY `CASE_ID_ISSUED_GOV_idx` (`ID_ISSUED_PLACE_ID`),
  ADD KEY `CASE_MAT_FK_idx` (`MARITAL_STATUS_ID`);

--
-- Indexes for table `diseases`
--
ALTER TABLE `diseases`
  ADD PRIMARY KEY (`ID`);

--
-- Indexes for table `gender`
--
ALTER TABLE `gender`
  ADD PRIMARY KEY (`ID`);

--
-- Indexes for table `government`
--
ALTER TABLE `government`
  ADD PRIMARY KEY (`ID`);

--
-- Indexes for table `jobs`
--
ALTER TABLE `jobs`
  ADD PRIMARY KEY (`ID`);

--
-- Indexes for table `matrial_state`
--
ALTER TABLE `matrial_state`
  ADD PRIMARY KEY (`ID`);

--
-- Indexes for table `research_type`
--
ALTER TABLE `research_type`
  ADD PRIMARY KEY (`ID`);

--
-- Indexes for table `users`
--
ALTER TABLE `users`
  ADD PRIMARY KEY (`ID`),
  ADD UNIQUE KEY `USER_NAME_UNIQUE` (`USER_NAME`),
  ADD UNIQUE KEY `EMAIL_UNIQUE` (`EMAIL`),
  ADD UNIQUE KEY `PHONE_UNIQUE` (`PHONE`),
  ADD KEY `USER_ROLE_FK_idx` (`ROLE_ID`),
  ADD KEY `USER_MANAGER_FK_idx` (`MANAGER_ID`),
  ADD KEY `USER_BRANCH_FK_idx` (`BRANCH_ID`),
  ADD KEY `USER_GENDER_FK_idx` (`GENDER_ID`),
  ADD KEY `USER_AREA_FK_idx` (`AREA_ID`);

--
-- Indexes for table `user_role`
--
ALTER TABLE `user_role`
  ADD PRIMARY KEY (`ID`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `diseases`
--
ALTER TABLE `diseases`
  MODIFY `ID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=12;
--
-- Constraints for dumped tables
--

--
-- Constraints for table `branch`
--
ALTER TABLE `branch`
  ADD CONSTRAINT `BRANCH_AREA_FK` FOREIGN KEY (`AREA_ID`) REFERENCES `area` (`ID`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  ADD CONSTRAINT `BRANCH_MANAGER_ID` FOREIGN KEY (`AREA_MANAGER_ID`) REFERENCES `users` (`ID`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Constraints for table `case`
--
ALTER TABLE `case`
  ADD CONSTRAINT `CASE_AREA_FK` FOREIGN KEY (`AREA_ID`) REFERENCES `area` (`ID`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  ADD CONSTRAINT `CASE_ID_ISSUED_GOV_FK` FOREIGN KEY (`ID_ISSUED_PLACE_ID`) REFERENCES `government` (`ID`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  ADD CONSTRAINT `CASE_MAT_FK` FOREIGN KEY (`MARITAL_STATUS_ID`) REFERENCES `matrial_state` (`ID`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  ADD CONSTRAINT `CASE_RESEARCH_TYP_FK` FOREIGN KEY (`RESEARCH_TYPE`) REFERENCES `research_type` (`ID`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Constraints for table `users`
--
ALTER TABLE `users`
  ADD CONSTRAINT `USER_AREA_FK` FOREIGN KEY (`AREA_ID`) REFERENCES `area` (`ID`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  ADD CONSTRAINT `USER_BRANCH_FK` FOREIGN KEY (`BRANCH_ID`) REFERENCES `branch` (`ID`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  ADD CONSTRAINT `USER_GENDER_FK` FOREIGN KEY (`GENDER_ID`) REFERENCES `gender` (`ID`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  ADD CONSTRAINT `USER_MANAGER_FK` FOREIGN KEY (`MANAGER_ID`) REFERENCES `users` (`ID`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  ADD CONSTRAINT `USER_ROLE_FK` FOREIGN KEY (`ROLE_ID`) REFERENCES `user_role` (`ID`) ON DELETE NO ACTION ON UPDATE NO ACTION;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
