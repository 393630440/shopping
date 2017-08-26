/*
Navicat MySQL Data Transfer

Source Server         : localhost
Source Server Version : 50538
Source Host           : localhost:8889
Source Database       : tianrui_work

Target Server Type    : MYSQL
Target Server Version : 50538
File Encoding         : 65001

Date: 2017-08-17 08:31:30
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `goods_classify`
-- ----------------------------
DROP TABLE IF EXISTS `goods_classify`;
CREATE TABLE `goods_classify` (
  `classify_id` varchar(50) NOT NULL COMMENT '分类ID',
  `classify_name` varchar(30) DEFAULT NULL COMMENT '分类名称',
  `classify_status` varchar(3) DEFAULT '1' COMMENT '分类状态:1-正常;2-已删除',
  `goods_type` varchar(3) DEFAULT NULL COMMENT '商品类型:1-大众商品;2-宏包商品',
  `parent_id` varchar(50) DEFAULT NULL COMMENT '父ID',
  `descr` varchar(256) DEFAULT NULL COMMENT '备注说明',
  `pubdate` bigint(20) DEFAULT NULL COMMENT '发布时间',
  `icon` varchar(1000) DEFAULT NULL COMMENT '图标',
  PRIMARY KEY (`classify_id`),
  KEY `index_1` (`classify_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='商品分类信息表';

-- ----------------------------
-- Records of goods_classify
-- ----------------------------
INSERT INTO `goods_classify` VALUES ('00f0adcd124f4180913ebe37d16f11d9', '电器类', '1', '1', null, '我就是电器，所有都是电器', '1501373913574', 'goodsClassifyIcon_1502510674672_0.jpg');
INSERT INTO `goods_classify` VALUES ('04666207f8624bddb07b22ec87147baa', '手机类', '1', '2', null, '华为、小米、魅族、vivo、open', '1501952003836', 'goodsClassifyIcon_1502510877876_0.jpg');
INSERT INTO `goods_classify` VALUES ('16e8a18e6daf489ea53e3b78fc6d7bfd', '食品类', '1', '1', null, '都是食品', '1501373913574', 'goodsClassifyIcon_1502511134122_0.jpg');
INSERT INTO `goods_classify` VALUES ('1b775057891c4220a4d51063ae0833be', '日用类', '1', '2', null, '都是日用品', '1501373913574', 'goodsClassifyIcon_1502511346663_0.jpg');
INSERT INTO `goods_classify` VALUES ('4dcee6e86d8d4f3fa7f6c941e0ffa744', '零食类', '1', '1', null, '吃货的时间', '1502511408568', 'goodsClassifyIcon_1502511774938_0.jpg');
INSERT INTO `goods_classify` VALUES ('bb69acfcd3ed43bd9bfa4a699ad2f762', '酒水类', '1', '1', null, '白酒、红酒、啤酒、洋酒、黄酒、鸡尾酒、女儿红', '1501373913574', 'goodsClassifyIcon_1502511359902_0.jpg');
INSERT INTO `goods_classify` VALUES ('d4aeed21c7c7476088fc86ae0ee9779c', '零食类1', '1', '2', null, '123', '1502511883182', 'goodsClassifyIcon_1502511883320_0.jpg');
