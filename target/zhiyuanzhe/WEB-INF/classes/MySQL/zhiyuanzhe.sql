/*
Navicat MySQL Data Transfer

Source Server         : localhost_3306
Source Server Version : 50505
Source Host           : localhost:3306
Source Database       : zhiyuanzhe

Target Server Type    : MYSQL
Target Server Version : 50505
File Encoding         : 65001

Date: 2022-08-20 23:24:00
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `activenews`
-- ----------------------------
DROP TABLE IF EXISTS `activenews`;
CREATE TABLE `activenews` (
  `activeNews_id` int(11) NOT NULL AUTO_INCREMENT,
  `activeNews_img` varchar(255) NOT NULL,
  `activeNews_name` varchar(255) NOT NULL,
  `activeNews_context` varchar(255) NOT NULL,
  `activeNews_time` date NOT NULL,
  `activeNews_num` int(11) NOT NULL,
  `admin_id` int(11) NOT NULL,
  `activeNews_state` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`activeNews_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of activenews
-- ----------------------------

-- ----------------------------
-- Table structure for `activetype_info`
-- ----------------------------
DROP TABLE IF EXISTS `activetype_info`;
CREATE TABLE `activetype_info` (
  `activeType_id` int(11) NOT NULL AUTO_INCREMENT,
  `activeType_name` varchar(255) NOT NULL,
  `activeType_state` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`activeType_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of activetype_info
-- ----------------------------

-- ----------------------------
-- Table structure for `active_info`
-- ----------------------------
DROP TABLE IF EXISTS `active_info`;
CREATE TABLE `active_info` (
  `active_id` int(11) NOT NULL AUTO_INCREMENT,
  `active_name` varchar(255) NOT NULL,
  `active_startTime` date NOT NULL,
  `active_endTime` date NOT NULL,
  `active_time` int(11) NOT NULL,
  `active_address` varchar(255) NOT NULL,
  `active_highNum` int(11) NOT NULL,
  `active_lowNum` int(11) NOT NULL,
  `active_num` int(11) NOT NULL,
  `active_context` varchar(255) NOT NULL,
  `admin_id` int(11) NOT NULL,
  `active_state` varchar(255) NOT NULL,
  `teamType_id` int(11) NOT NULL,
  `active_joinNum` int(11) NOT NULL,
  PRIMARY KEY (`active_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of active_info
-- ----------------------------

-- ----------------------------
-- Table structure for `admin_info`
-- ----------------------------
DROP TABLE IF EXISTS `admin_info`;
CREATE TABLE `admin_info` (
  `admin_id` int(11) NOT NULL AUTO_INCREMENT,
  `admin_carID` varchar(255) NOT NULL,
  `admin_tel` varchar(255) NOT NULL,
  `admin_loginName` varchar(255) NOT NULL,
  `admin_pwd` varchar(255) NOT NULL,
  `admin_state` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`admin_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of admin_info
-- ----------------------------

-- ----------------------------
-- Table structure for `teamjob_info`
-- ----------------------------
DROP TABLE IF EXISTS `teamjob_info`;
CREATE TABLE `teamjob_info` (
  `teamJob_id` int(11) NOT NULL AUTO_INCREMENT,
  `teamJob_name` varchar(255) NOT NULL,
  `teamJob_state` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`teamJob_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of teamjob_info
-- ----------------------------

-- ----------------------------
-- Table structure for `teamtype_info`
-- ----------------------------
DROP TABLE IF EXISTS `teamtype_info`;
CREATE TABLE `teamtype_info` (
  `teamType_id` int(11) NOT NULL AUTO_INCREMENT,
  `teamType_name` varchar(255) NOT NULL,
  `teamType_state` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`teamType_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of teamtype_info
-- ----------------------------

-- ----------------------------
-- Table structure for `team_info`
-- ----------------------------
DROP TABLE IF EXISTS `team_info`;
CREATE TABLE `team_info` (
  `team_id` int(11) NOT NULL AUTO_INCREMENT,
  `team_name` varchar(255) NOT NULL,
  `team_startData` date NOT NULL,
  `team_peopleNum` int(11) NOT NULL,
  `team_helpTime` int(11) NOT NULL,
  `teamType_id` int(11) NOT NULL,
  `user_id` int(11) NOT NULL,
  `team_state` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`team_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of team_info
-- ----------------------------

-- ----------------------------
-- Table structure for `user_info`
-- ----------------------------
DROP TABLE IF EXISTS `user_info`;
CREATE TABLE `user_info` (
  `user_id` int(11) NOT NULL AUTO_INCREMENT,
  `user_name` varchar(255) NOT NULL,
  `user_cardId` varchar(255) NOT NULL,
  `user_tel` varchar(255) NOT NULL,
  `user_email` varchar(255) NOT NULL,
  `user_loginName` varchar(255) NOT NULL,
  `user_pwd` varchar(255) NOT NULL,
  `teamJob_id` int(11) NOT NULL,
  `user_helpTime` varchar(255) NOT NULL,
  `active_joNum` int(11) NOT NULL,
  `user_state` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`user_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of user_info
-- ----------------------------
