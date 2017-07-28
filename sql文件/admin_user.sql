/*
Navicat MySQL Data Transfer

Source Server         : localhost_8889
Source Server Version : 50538
Source Host           : localhost:8889
Source Database       : tianrui_work

Target Server Type    : MYSQL
Target Server Version : 50538
File Encoding         : 65001

Date: 2017-07-28 23:07:01
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
  `username` varchar(255) DEFAULT '' COMMENT '用户名称',
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
INSERT INTO `admin_user` VALUES ('admin', 'admin', '1', '666666', '超级管理员', '18337129805', '1501254197691', 'admin', null, '15');
