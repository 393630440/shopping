/*
Navicat MySQL Data Transfer

Source Server         : 172.19.4.23_3306
Source Server Version : 50619
Source Host           : 172.19.4.23:3306
Source Database       : tianrui_work

Target Server Type    : MYSQL
Target Server Version : 50619
File Encoding         : 65001

Date: 2017-07-28 18:22:45
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `admin_user`
-- ----------------------------
DROP TABLE IF EXISTS `admin_user`;
CREATE TABLE `admin_user` (
  `id` varchar(32) NOT NULL DEFAULT '',
  `acount` varchar(255) DEFAULT '' COMMENT '账号',
  `acount_status` varchar(255) DEFAULT NULL COMMENT '账号状态1-正常 0-禁用',
  `password` varchar(255) DEFAULT '' COMMENT '密码',
  `telphone` varchar(255) DEFAULT '' COMMENT '联系电话',
  `logintime` bigint(20) DEFAULT NULL COMMENT '登录时间',
  `user_role` varchar(255) DEFAULT '' COMMENT '用户权限',
  `createtime` bigint(20) DEFAULT NULL COMMENT '添加时间',
  `login_num` int(11) DEFAULT NULL COMMENT '登录次数',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of admin_user
-- ----------------------------
