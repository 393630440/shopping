/*
Navicat MySQL Data Transfer

Source Server         : localhost_8889
Source Server Version : 50538
Source Host           : localhost:8889
Source Database       : tianrui_work

Target Server Type    : MYSQL
Target Server Version : 50538
File Encoding         : 65001

Date: 2017-08-14 22:32:14
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `member_withdrawal`
-- ----------------------------
DROP TABLE IF EXISTS `member_withdrawal`;
CREATE TABLE `member_withdrawal` (
  `id` varchar(50) NOT NULL COMMENT '提现订单ID',
  `member_id` varchar(50) NOT NULL COMMENT '会员ID',
  `member_name` varchar(50) DEFAULT NULL,
  `withdrawal_amount` double(10,2) DEFAULT NULL COMMENT '提现金额',
  `withdrawal_status` varchar(3) DEFAULT NULL COMMENT '提现状态:0-申请;1-成功;2-失败',
  `createtime` bigint(20) DEFAULT NULL COMMENT '提现时间',
  `audit_time` bigint(20) DEFAULT NULL COMMENT '审核时间',
  `remark` varchar(256) DEFAULT NULL COMMENT '备注',
  PRIMARY KEY (`id`),
  KEY `index_1` (`id`),
  KEY `index_2` (`member_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='会员提现订单表';

-- ----------------------------
-- Records of member_withdrawal
-- ----------------------------
INSERT INTO `member_withdrawal` VALUES ('0dbc9764853b481995362bb983489e86', 'o-OJTv_ftDalms42QPVn38jZ30L8', '李思佳', '1.00', '0', '1502720865130', null, null);
INSERT INTO `member_withdrawal` VALUES ('143fe6855f424e2ea99004910cf4750b', 'o-OJTv_ftDalms42QPVn38jZ30L8', '李思佳', '1.00', '0', '1502720863083', null, null);
INSERT INTO `member_withdrawal` VALUES ('2d48450e58f342c496cad3ee4c9c8e94', 'o-OJTv_ftDalms42QPVn38jZ30L8', '李思佳', '1.00', '0', '1502720854547', null, null);
INSERT INTO `member_withdrawal` VALUES ('48579c0771784007975c6b598e04b45b', 'o-OJTv_ftDalms42QPVn38jZ30L8', '李思佳', '1.00', '0', '1502720860139', null, null);
INSERT INTO `member_withdrawal` VALUES ('599e8c4131704faf8891996106b7ce70', 'o-OJTv_ftDalms42QPVn38jZ30L8', '李思佳', '1.00', '0', '1502720848353', null, null);
INSERT INTO `member_withdrawal` VALUES ('6aaa092d927541c3982c2f2b0ff0fefe', 'o-OJTv_ftDalms42QPVn38jZ30L8', '李思佳', '1.00', '0', '1502720858381', null, null);
INSERT INTO `member_withdrawal` VALUES ('7054a7563b25436c8f96c65f4dd695a2', 'o-OJTv_ftDalms42QPVn38jZ30L8', '李思佳', '1.00', '0', '1502720275246', null, null);
INSERT INTO `member_withdrawal` VALUES ('7dd612941ed54818aca6550a5d09d2fb', 'o-OJTv_ftDalms42QPVn38jZ30L8', '李思佳', '1.00', '0', '1502720851644', null, null);
INSERT INTO `member_withdrawal` VALUES ('b347555dbec34545b847a85268ac92c6', 'o-OJTv_ftDalms42QPVn38jZ30L8', '李思佳', '1.00', '0', '1502720873314', null, null);
INSERT INTO `member_withdrawal` VALUES ('b731d83f46c7459789fc63b3ff287d5a', 'o-OJTv_ftDalms42QPVn38jZ30L8', '李思佳', '1.00', '0', '1502720869515', null, null);
INSERT INTO `member_withdrawal` VALUES ('b7896b518373476a992ee5609ae3d2f2', 'o-OJTv_ftDalms42QPVn38jZ30L8', '李思佳', '1.00', '0', '1502720856578', null, null);
INSERT INTO `member_withdrawal` VALUES ('bfdc29fa66354de297be4abf78c9dbcd', 'o-OJTv_ftDalms42QPVn38jZ30L8', '李思佳', '1.00', '0', '1502720867686', null, null);
INSERT INTO `member_withdrawal` VALUES ('c532ca170a7545908775ac09aa8fdd3c', 'o-OJTv_ftDalms42QPVn38jZ30L8', '李思佳', '1.00', '0', '1502720994757', null, null);
INSERT INTO `member_withdrawal` VALUES ('e4e70f328bda40809e9853999a18aeef', 'o-OJTv_ftDalms42QPVn38jZ30L8', '李思佳', '1.00', '0', '1502720871464', null, null);
INSERT INTO `member_withdrawal` VALUES ('eb0394e699654efba1375bcad4b634f4', 'o-OJTv_ftDalms42QPVn38jZ30L8', '李思佳', '1.00', '0', '1502720845287', null, null);
