/*
Navicat MySQL Data Transfer

Source Server         : localhost
Source Server Version : 50538
Source Host           : localhost:8889
Source Database       : tianrui_work

Target Server Type    : MYSQL
Target Server Version : 50538
File Encoding         : 65001

Date: 2017-08-17 08:31:49
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `order_info`
-- ----------------------------
DROP TABLE IF EXISTS `order_info`;
CREATE TABLE `order_info` (
  `order_id` varchar(50) NOT NULL COMMENT '订单ID',
  `order_code` varchar(50) NOT NULL COMMENT '订单编号',
  `member_id` varchar(50) DEFAULT NULL COMMENT '会员ID',
  `goods_type` varchar(3) DEFAULT NULL COMMENT '商品类型:1-大众商品;2-宏包商品',
  `goods_num` int(10) DEFAULT NULL COMMENT '商品数量',
  `goods_subtotal` double(10,2) DEFAULT NULL COMMENT '商品小计',
  `express_fee` double(10,2) DEFAULT NULL COMMENT '运费',
  `order_amount` double(10,2) DEFAULT NULL COMMENT '订单总金额',
  `order_red_packet` int(10) DEFAULT NULL COMMENT '订单总宏包',
  `order_status` varchar(3) DEFAULT NULL COMMENT '订单状态:1-待付款;2-待发货;3-待收货;4-已完成;5-退款申请;6-退款失败;7-退款成功;8-已取消;9-已删除;0-彻底删除',
  `buyer_word` varchar(256) DEFAULT NULL COMMENT '买家留言',
  `creation_time` bigint(20) DEFAULT NULL COMMENT '创建时间',
  `recipients` varchar(20) DEFAULT NULL COMMENT '收件人',
  `phone` varchar(20) DEFAULT NULL COMMENT '联系电话',
  `city` varchar(30) DEFAULT NULL COMMENT '所在地区',
  `detail_address` varchar(50) DEFAULT NULL COMMENT '详细地址',
  `refund_apply_time` bigint(20) DEFAULT NULL COMMENT '退货申请时间',
  `refund_audit_time` bigint(20) DEFAULT NULL COMMENT '退货审核时间',
  PRIMARY KEY (`order_id`),
  KEY `index_1` (`order_id`),
  KEY `index_2` (`member_id`),
  KEY `index_3` (`goods_type`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='订单信息表';

-- ----------------------------
-- Records of order_info
-- ----------------------------
INSERT INTO `order_info` VALUES ('123', '20170807075000123', '1', '1', '1000', '1000.00', '1000.00', '1000.00', '0', '5', '123', '1501939867692', '123', '123', '郑州', '123', '1501939867692', '1502118169221');
INSERT INTO `order_info` VALUES ('456', '20170807075000456', '1', '2', '1000', '1000.00', '1000.00', '1000.00', '1000', '1', '123', '1501939867695', '123', '123', '洛阳', '123', null, null);
INSERT INTO `order_info` VALUES ('789', '20170807075000456', '1', '1', '1000', '1000.00', '1000.00', '1000.00', '0', '8', '123', '1501939867695', '123', '123', '洛阳', '123', null, null);
