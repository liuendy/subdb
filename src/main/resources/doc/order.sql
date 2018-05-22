/*
 Navicat Premium Data Transfer

 Source Server         : 本地mysql
 Source Server Type    : MySQL
 Source Server Version : 50721
 Source Host           : localhost
 Source Database       : test2

 Target Server Type    : MySQL
 Target Server Version : 50721
 File Encoding         : utf-8

 Date: 05/21/2018 16:20:20 PM
*/

SET NAMES utf8;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
--  Table structure for `order_1`
-- ----------------------------
DROP TABLE IF EXISTS `order_1`;
CREATE TABLE `order_1` (
  `order_id` bigint(20) NOT NULL AUTO_INCREMENT,
  `order_no` varchar(64) COLLATE utf8mb4_bin DEFAULT NULL,
  `uid` bigint(20) NOT NULL COMMENT '用户ID',
  `amount` decimal(32,16) DEFAULT '0.0000000000000000' COMMENT '[交易金额]',
  `note` varchar(128) COLLATE utf8mb4_bin DEFAULT NULL COMMENT '[备注]',
  `status` int(11) DEFAULT '0' COMMENT '[状态]  0. 无效 1.有效 ',
  `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `edit_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`order_id`),
  UNIQUE KEY `order_no` (`order_no`)
) ENGINE=InnoDB AUTO_INCREMENT=143 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_bin COMMENT='订单表';

SET FOREIGN_KEY_CHECKS = 1;
