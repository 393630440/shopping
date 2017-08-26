/*
Navicat MySQL Data Transfer

Source Server         : localhost_8889
Source Server Version : 50538
Source Host           : localhost:8889
Source Database       : work

Target Server Type    : MYSQL
Target Server Version : 50538
File Encoding         : 65001

Date: 2017-07-25 22:44:00
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `shop_creditor`
-- ----------------------------
DROP TABLE IF EXISTS `shop_creditor`;
CREATE TABLE `shop_creditor` (
  `id` varchar(32) NOT NULL DEFAULT '' COMMENT '债权发布主键id',
  `creditor_status` varchar(6) DEFAULT '' COMMENT '信息状态 1-正常  0-作废',
  `creditor_type` varchar(6) DEFAULT NULL COMMENT '1-债权人 2-债务人',
  `creditor_name` varchar(255) DEFAULT '' COMMENT '债权人名称',
  `creditor_phone` varchar(255) DEFAULT '' COMMENT '债权人电话',
  `creditor_idcard` varchar(255) DEFAULT '' COMMENT '债权人身份证号',
  `creditor_sex` varchar(6) DEFAULT '' COMMENT '债权人性别 xx-女 xy-男',
  `creditor_address` varchar(255) DEFAULT '' COMMENT '债权人地址',
  `creditor_company` varchar(255) DEFAULT '' COMMENT '债权人公司',
  `creditor_company_address` varchar(255) DEFAULT '' COMMENT '债权人公司地址',
  `debtor_name` varchar(255) DEFAULT '' COMMENT '债务人名称',
  `debtor_phone` varchar(255) DEFAULT '' COMMENT '债务人电话',
  `debtor_idcrd` varchar(255) DEFAULT '' COMMENT '债务人身份证',
  `debtor_sex` varchar(6) DEFAULT '' COMMENT '债务人性别 xx-女 xy-男',
  `debtor_address` varchar(255) DEFAULT '' COMMENT '债务人身份证地址',
  `debtor_company` varchar(255) DEFAULT '' COMMENT '债务人公司名称',
  `debtor_company_address` varchar(255) DEFAULT '' COMMENT '债务人公司地址',
  `debt_amount` double(20,0) DEFAULT NULL COMMENT '债务金额',
  `debt_time` bigint(20) DEFAULT NULL COMMENT '债务产生时间',
  `debt_type` varchar(6) DEFAULT '' COMMENT '1-公司债务，2-借条债务，3-欠条债务，4-判决债务，5-其他债务',
  `creator` varchar(255) DEFAULT '' COMMENT '创建人',
  `creatorImg` varchar(255) DEFAULT '' COMMENT '添加人头像',
  `creator_time` bigint(20) DEFAULT NULL COMMENT '创建时间',
  `updatetor` varchar(255) DEFAULT '' COMMENT '修改人',
  `update_time` bigint(20) DEFAULT NULL COMMENT '修改时间',
  PRIMARY KEY (`id`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of shop_creditor
-- ----------------------------
INSERT INTO `shop_creditor` VALUES ('6611690576694fa7a1a7170260d24526', '', null, '', '', '', '', '', '', '', '', '', '', '', '', '', '', null, null, '', '', null, '1500988050902', '', null);
INSERT INTO `shop_creditor` VALUES ('debb28e5016f4ff391eb5f07717040a4', '1', '1', '流浪哥', '18337129856', '4125698741254231', 'xy', '斯蒂芬森分', '首发机会公司', '啊二个对手犯规', '', '', '', '', '', '', '', '200', '1500912000000', '1', '', null, '1500989991574', '', null);
INSERT INTO `shop_creditor` VALUES ('f5f0ccc56a28455eb4c9e79638c2901d', '1', '1', '', '', '', '', '', '', '', '', '', '', '', '', '', '', null, null, '1', '', null, '1500990318759', '', null);
