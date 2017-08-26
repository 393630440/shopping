/*
Navicat MySQL Data Transfer

Source Server         : localhost
Source Server Version : 50538
Source Host           : localhost:8889
Source Database       : tianrui_work

Target Server Type    : MYSQL
Target Server Version : 50538
File Encoding         : 65001

Date: 2017-08-17 08:31:59
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `shopping_cart`
-- ----------------------------
DROP TABLE IF EXISTS `shopping_cart`;
CREATE TABLE `shopping_cart` (
  `shopping_cart_id` int(20) NOT NULL AUTO_INCREMENT COMMENT '购物车ID',
  `goods_id` varchar(50) DEFAULT NULL COMMENT '商品ID',
  `member_id` varchar(50) DEFAULT NULL COMMENT '会员ID',
  `order_id` varchar(50) DEFAULT NULL COMMENT '订单ID',
  `creation_time` bigint(20) DEFAULT NULL COMMENT '添加时间',
  `goods_name` varchar(256) DEFAULT NULL COMMENT '商品名称',
  `goods_img` varchar(1000) DEFAULT NULL COMMENT '商品图片',
  `goods_price` double(10,2) DEFAULT NULL COMMENT '商品价格',
  `goods_red_packet` int(10) DEFAULT NULL COMMENT '商品宏包',
  `goods_num` int(10) DEFAULT NULL COMMENT '商品数量',
  `goods_type` varchar(3) DEFAULT NULL COMMENT '商品类型:1-大众商品;2-宏包商品',
  `shopping_cart_status` varchar(3) DEFAULT NULL COMMENT '购物车商品状态:1-已添加;2-已购买;3-已删除',
  PRIMARY KEY (`shopping_cart_id`),
  KEY `index_1` (`member_id`),
  KEY `index_2` (`order_id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8 COMMENT='购物车信息表';

-- ----------------------------
-- Records of shopping_cart
-- ----------------------------
INSERT INTO `shopping_cart` VALUES ('1', '00dd6391385943f69614b4495126482f', '123456789', null, '1502894472167', '自行车v1', 'goodsImg_1501939867668_0.jpg', '999.99', '100', '1', '2', '1');
INSERT INTO `shopping_cart` VALUES ('2', '00dd6391385943f69614b4495126482f', '123456789', null, '1502894657296', '自行车v1', 'goodsImg_1501939867668_0.jpg', '999.99', '100', '5', '2', '1');
INSERT INTO `shopping_cart` VALUES ('3', '00dd6391385943f69614b4495126482f', '123456789', null, '1502894775887', '自行车v1', 'goodsImg_1501939867668_0.jpg', '999.99', '100', '15', '2', '1');
INSERT INTO `shopping_cart` VALUES ('4', '00dd6391385943f69614b4495126482f', '123456789', null, '1502894824366', '自行车v1', 'goodsImg_1501939867668_0.jpg', '999.99', '100', '1', '2', '1');
INSERT INTO `shopping_cart` VALUES ('5', '00dd6391385943f69614b4495126482f', '123456789', null, '1502894830307', '自行车v1', 'goodsImg_1501939867668_0.jpg', '999.99', '100', '3', '2', '1');
