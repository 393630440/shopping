/*
Navicat MySQL Data Transfer

Source Server         : localhost
Source Server Version : 50538
Source Host           : localhost:8889
Source Database       : tianrui_work

Target Server Type    : MYSQL
Target Server Version : 50538
File Encoding         : 65001

Date: 2017-08-07 23:03:56
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `goods_info`
-- ----------------------------
DROP TABLE IF EXISTS `goods_info`;
CREATE TABLE `goods_info` (
  `goods_id` varchar(50) NOT NULL COMMENT '商品ID',
  `goods_name` varchar(256) DEFAULT NULL COMMENT '商品名称',
  `goods_img` varchar(1000) DEFAULT NULL COMMENT '商品图片(图片地址)',
  `goods_status` varchar(3) DEFAULT NULL COMMENT '商品状态:1-已上架;2-已下架',
  `goods_type` varchar(3) DEFAULT NULL COMMENT '商品类型:1-大众商品;2-宏包商品',
  `goods_price` double(10,2) DEFAULT NULL COMMENT '商品价格',
  `red_packet` int(10) DEFAULT NULL COMMENT '宏包',
  `goods_details` varchar(256) DEFAULT NULL COMMENT '详情',
  `goods_param` varchar(1000) DEFAULT NULL COMMENT '参数',
  `express_fee` double(10,2) DEFAULT NULL COMMENT '快递费',
  `inventory` int(10) DEFAULT NULL COMMENT '库存',
  `salesvolume` int(10) DEFAULT '0' COMMENT '销量',
  `buy_num` int(10) DEFAULT '0' COMMENT '购买数量',
  `browse_num` int(10) DEFAULT '0' COMMENT '浏览记录',
  `sifting` varchar(3) DEFAULT '0' COMMENT '筛选条件:0-普通商品;1-推荐商品;2-新品上市;3-热卖商品;4-促销商品;5-卖家包邮;6-限时抢购',
  `classify_id` varchar(50) DEFAULT NULL COMMENT '分类ID',
  `classify_name` varchar(30) DEFAULT NULL COMMENT '分类名称',
  `pubdate` bigint(20) DEFAULT NULL COMMENT '发布时间',
  PRIMARY KEY (`goods_id`),
  KEY `index_1` (`goods_id`),
  KEY `index_2` (`classify_id`),
  KEY `index_3` (`goods_status`),
  KEY `index_4` (`goods_type`),
  KEY `index_5` (`sifting`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='商品信息表';

-- ----------------------------
-- Records of goods_info
-- ----------------------------
INSERT INTO `goods_info` VALUES ('fadd6391385943f69614b4495126482f', '自行车v', 'goodsImg_1501939867668_0.jpg|goodsImg_1501939867689_1.jpg|goodsImg_1501939867692_2.jpg|goodsImg_1501939867695_3.jpg', '1', '1', '999.99', '0', 'goodsDetails_1501939868543_0.jpg|goodsDetails_1501939868547_1.jpg', '123456789', '8.00', '100', '0', '0', '0', '0', '1b775057891c4220a4d51063ae0833be', '日用类', '1501937708179');
