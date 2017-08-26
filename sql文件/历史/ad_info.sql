/*
Navicat MySQL Data Transfer

Source Server         : localhost
Source Server Version : 50538
Source Host           : localhost:8889
Source Database       : tianrui_work

Target Server Type    : MYSQL
Target Server Version : 50538
File Encoding         : 65001

Date: 2017-08-17 08:31:25
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `ad_info`
-- ----------------------------
DROP TABLE IF EXISTS `ad_info`;
CREATE TABLE `ad_info` (
  `id` int(10) NOT NULL AUTO_INCREMENT COMMENT '广告ID',
  `img` varchar(256) DEFAULT NULL COMMENT '图片路径',
  `url` varchar(256) DEFAULT NULL COMMENT '广告地址',
  `depict` varchar(256) DEFAULT NULL COMMENT '描述',
  `status` varchar(3) DEFAULT NULL COMMENT '广告状态:0-失效;1-有效',
  `type` varchar(3) DEFAULT NULL COMMENT '广告类型:1-大众商品;2-宏包商品',
  `pubdate` bigint(20) DEFAULT NULL COMMENT '发布时间',
  PRIMARY KEY (`id`),
  KEY `index_1` (`id`),
  KEY `index_2` (`status`),
  KEY `index_3` (`type`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8 COMMENT='广告信息';

-- ----------------------------
-- Records of ad_info
-- ----------------------------
INSERT INTO `ad_info` VALUES ('1', 'adImg_1502430774083_0.jpg', 'http://www.baidu.com/123', '我是一个测试的广告哟！！！！', '1', '1', '1502429689995');
INSERT INTO `ad_info` VALUES ('2', 'adImg_1502430505972_2.jpg', 'http://www.baidu.com/', '我是一个测试广告', '1', '2', '1502430165161');
INSERT INTO `ad_info` VALUES ('3', 'adImg_1502430505972_3.jpg', 'http://www.baidu.com/', 'http://www.baidu.com/', '1', '2', '1502430273669');
INSERT INTO `ad_info` VALUES ('4', 'adImg_1502430505972_0.jpg', 'http://www.baidu.com/', 'http://www.baidu.com/', '1', '1', '1502430505765');
