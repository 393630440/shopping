/*
Navicat MySQL Data Transfer

Source Server         : localhost_8889
Source Server Version : 50538
Source Host           : localhost:8889
Source Database       : tianrui_work

Target Server Type    : MYSQL
Target Server Version : 50538
File Encoding         : 65001

Date: 2017-08-20 22:50:40
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
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8 COMMENT='广告信息';

-- ----------------------------
-- Records of ad_info
-- ----------------------------
INSERT INTO `ad_info` VALUES ('1', 'adImg_1502430774083_0.jpg', 'http://www.baidu.com/123', '我是一个测试的广告哟！！！！', '1', '1', '1502429689995');
INSERT INTO `ad_info` VALUES ('2', 'adImg_1502430505972_2.jpg', 'http://www.baidu.com/', '我是一个测试广告', '1', '2', '1502430165161');
INSERT INTO `ad_info` VALUES ('3', 'adImg_1502430505972_3.jpg', 'http://www.baidu.com/', 'http://www.baidu.com/', '1', '2', '1502430273669');
INSERT INTO `ad_info` VALUES ('4', 'adImg_1502430505972_0.jpg', 'http://www.baidu.com/', 'http://www.baidu.com/', '1', '1', '1502430505765');
INSERT INTO `ad_info` VALUES ('5', null, '12345132', '大后天仍有反弹', '1', '1', '1502973043059');
INSERT INTO `ad_info` VALUES ('6', 'adImg_1503131005088_0.gif', '/wechat/shop/goods/goodsdetails?goodsId=', '12343', '1', '1', '1503131004778');

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
INSERT INTO `admin_user` VALUES ('admin', 'admin', '1', '666666', '超级g', '13839827427', '1503237750713', 'admin', null, '57');
INSERT INTO `admin_user` VALUES ('e74df26737f04dd8a74f41dd0c53204b', 'xiao', '1', '111111', '小娟', '15138912934', '1501333433508', '', '1501333364608', '1');

-- ----------------------------
-- Table structure for `configuration_info`
-- ----------------------------
DROP TABLE IF EXISTS `configuration_info`;
CREATE TABLE `configuration_info` (
  `paramkey` varchar(100) DEFAULT NULL COMMENT '参数键',
  `paramvalue` varchar(100) DEFAULT NULL COMMENT '参数值',
  `depict` varchar(256) DEFAULT NULL COMMENT '描述',
  `flag` varchar(3) DEFAULT '1' COMMENT '维护标志:0-失效;1-有效',
  KEY `index_1` (`paramkey`),
  KEY `index_2` (`flag`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='配置信息表';

-- ----------------------------
-- Records of configuration_info
-- ----------------------------

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
INSERT INTO `goods_classify` VALUES ('e69316bce9f54469858fe1417ea5a3c3', '123', '1', '2', null, '123', '1503133065465', null);

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
INSERT INTO `goods_info` VALUES ('00dd6391385943f69614b4495126482f', '自行车v1', 'goodsImg_1501939867668_0.jpg|goodsImg_1501939867689_1.jpg|goodsImg_1501939867692_2.jpg|goodsImg_1501939867695_3.jpg', '1', '2', '999.99', '100', 'goodsDetails_1501939868543_0.jpg|goodsDetails_1501939868547_1.jpg', '香型:浓香型|规格:500ml/盒|原料与辅料:水、高粱、小麦', '8.00', '97', '3', '3', '123', '0', '1b775057891c4220a4d51063ae0833be', '日用类', '1501937708179');
INSERT INTO `goods_info` VALUES ('011226db1058451a9ee2d8d1783578cc', 'qwe', 'goodsImg_1503133023927_0.png', '1', '2', '123.00', '123', 'goodsDetails_1503133023927_0.gif', '123:456|qwe:12', null, '1000', '0', '0', '0', '0', '04666207f8624bddb07b22ec87147baa', '手机类', '1503132489228');
INSERT INTO `goods_info` VALUES ('0827eb10863d438ebdd0b9c36fc2cc58', '佳佳乐', null, '1', '1', '100.00', null, null, 'weqfsdcb', '10.00', '100', '0', '0', '0', '2', '00f0adcd124f4180913ebe37d16f11d9', '电器类', '1502972943510');
INSERT INTO `goods_info` VALUES ('0add6391385943f69614b4495126482f', '自行车v2', 'goodsImg_1501939867668_0.jpg|goodsImg_1501939867689_1.jpg|goodsImg_1501939867692_2.jpg|goodsImg_1501939867695_3.jpg', '1', '2', '999.99', '100', 'goodsDetails_1501939868543_0.jpg|goodsDetails_1501939868547_1.jpg', '香型:浓香型|规格:500ml/盒|原料与辅料:水、高粱、小麦', '8.00', '100', '0', '0', '0', '0', '1b775057891c4220a4d51063ae0833be', '日用类', '1501937708179');
INSERT INTO `goods_info` VALUES ('0b573f9c6ab5427c85f2e3473ec9f3b3', 'qwe', null, '1', '2', '123.00', '123', null, '123:456|qwe:12', null, '1000', '0', '0', '0', '0', '04666207f8624bddb07b22ec87147baa', '手机类', '1503132438635');
INSERT INTO `goods_info` VALUES ('11dd6391385943f69614b4495126482f', '自行车v3', 'goodsImg_1501939867668_0.jpg|goodsImg_1501939867689_1.jpg|goodsImg_1501939867692_2.jpg|goodsImg_1501939867695_3.jpg', '1', '2', '999.99', '100', 'goodsDetails_1501939868543_0.jpg|goodsDetails_1501939868547_1.jpg', '香型:浓香型|规格:500ml/盒|原料与辅料:水、高粱、小麦', '8.00', '100', '0', '0', '0', '1', '1b775057891c4220a4d51063ae0833be', '日用类', '1501937708179');
INSERT INTO `goods_info` VALUES ('17745c1d95f049e898510397c2b890f7', 'qwe', null, '1', '2', '123.00', '123', null, '123:456|qwe:12', null, '1000', '0', '0', '0', '0', '04666207f8624bddb07b22ec87147baa', '手机类', '1503132455832');
INSERT INTO `goods_info` VALUES ('1add6391385943f69614b4495126482f', '自行车v4', 'goodsImg_1501939867668_0.jpg|goodsImg_1501939867689_1.jpg|goodsImg_1501939867692_2.jpg|goodsImg_1501939867695_3.jpg', '1', '2', '999.99', '100', 'goodsDetails_1501939868543_0.jpg|goodsDetails_1501939868547_1.jpg', '香型:浓香型|规格:500ml/盒|原料与辅料:水、高粱、小麦', '8.00', '97', '3', '3', '2', '1', '1b775057891c4220a4d51063ae0833be', '日用类', '1501937708179');
INSERT INTO `goods_info` VALUES ('22dd6391385943f69614b4495126482f', '自行车v5', 'goodsImg_1501939867668_0.jpg|goodsImg_1501939867689_1.jpg|goodsImg_1501939867692_2.jpg|goodsImg_1501939867695_3.jpg', '1', '2', '999.99', '100', 'goodsDetails_1501939868543_0.jpg|goodsDetails_1501939868547_1.jpg', '香型:浓香型|规格:500ml/盒|原料与辅料:水、高粱、小麦', '8.00', '100', '0', '0', '0', '2', '1b775057891c4220a4d51063ae0833be', '日用类', '1501937708179');
INSERT INTO `goods_info` VALUES ('2add6391385943f69614b4495126482f', '自行车v6', 'goodsImg_1501939867668_0.jpg|goodsImg_1501939867689_1.jpg|goodsImg_1501939867692_2.jpg|goodsImg_1501939867695_3.jpg', '1', '2', '999.99', '100', 'goodsDetails_1501939868543_0.jpg|goodsDetails_1501939868547_1.jpg', '香型:浓香型|规格:500ml/盒|原料与辅料:水、高粱、小麦', '8.00', '100', '0', '0', '0', '2', '1b775057891c4220a4d51063ae0833be', '日用类', '1501937708179');
INSERT INTO `goods_info` VALUES ('33dd6391385943f69614b4495126482f', '自行车v7', 'goodsImg_1501939867668_0.jpg|goodsImg_1501939867689_1.jpg|goodsImg_1501939867692_2.jpg|goodsImg_1501939867695_3.jpg', '1', '2', '999.99', '100', 'goodsDetails_1501939868543_0.jpg|goodsDetails_1501939868547_1.jpg', '香型:浓香型|规格:500ml/盒|原料与辅料:水、高粱、小麦', '8.00', '100', '0', '0', '0', '3', '1b775057891c4220a4d51063ae0833be', '日用类', '1501937708179');
INSERT INTO `goods_info` VALUES ('3add6391385943f69614b4495126482f', '自行车v8', 'goodsImg_1501939867668_0.jpg|goodsImg_1501939867689_1.jpg|goodsImg_1501939867692_2.jpg|goodsImg_1501939867695_3.jpg', '1', '2', '999.99', '100', 'goodsDetails_1501939868543_0.jpg|goodsDetails_1501939868547_1.jpg', '香型:浓香型|规格:500ml/盒|原料与辅料:水、高粱、小麦', '8.00', '100', '0', '0', '0', '3', '1b775057891c4220a4d51063ae0833be', '日用类', '1501937708179');
INSERT INTO `goods_info` VALUES ('3e1d02dc13d24a41a5a22237a706258f', '123', null, '1', '2', '123.00', '123', null, '123', null, '111', '0', '0', '0', '0', '04666207f8624bddb07b22ec87147baa', '手机类', '1503132825124');
INSERT INTO `goods_info` VALUES ('44dd6391385943f69614b4495126482f', '自行车v9', 'goodsImg_1501939867668_0.jpg|goodsImg_1501939867689_1.jpg|goodsImg_1501939867692_2.jpg|goodsImg_1501939867695_3.jpg', '1', '2', '999.99', '100', 'goodsDetails_1501939868543_0.jpg|goodsDetails_1501939868547_1.jpg', '香型:浓香型|规格:500ml/盒|原料与辅料:水、高粱、小麦', '8.00', '100', '0', '0', '0', '4', '1b775057891c4220a4d51063ae0833be', '日用类', '1501937708179');
INSERT INTO `goods_info` VALUES ('4add6391385943f69614b4495126482f', '自行车v10', 'goodsImg_1501939867668_0.jpg|goodsImg_1501939867689_1.jpg|goodsImg_1501939867692_2.jpg|goodsImg_1501939867695_3.jpg', '1', '2', '999.99', '100', 'goodsDetails_1501939868543_0.jpg|goodsDetails_1501939868547_1.jpg', '香型:浓香型|规格:500ml/盒|原料与辅料:水、高粱、小麦', '8.00', '100', '0', '0', '0', '4', '1b775057891c4220a4d51063ae0833be', '日用类', '1501937708179');
INSERT INTO `goods_info` VALUES ('55dd6391385943f69614b4495126482f', '自行车v11', 'goodsImg_1501939867668_0.jpg|goodsImg_1501939867689_1.jpg|goodsImg_1501939867692_2.jpg|goodsImg_1501939867695_3.jpg', '1', '2', '999.99', '100', 'goodsDetails_1501939868543_0.jpg|goodsDetails_1501939868547_1.jpg', '香型:浓香型|规格:500ml/盒|原料与辅料:水、高粱、小麦', '8.00', '100', '0', '0', '0', '5', '1b775057891c4220a4d51063ae0833be', '日用类', '1501937708179');
INSERT INTO `goods_info` VALUES ('582cf4f07c4f4542a42a0011f35d1658', '123', null, '1', '2', '123.00', '123', null, '123', null, '111', '0', '0', '0', '0', '04666207f8624bddb07b22ec87147baa', '手机类', '1503132714045');
INSERT INTO `goods_info` VALUES ('5add6391385943f69614b4495126482f', '自行车v12', 'goodsImg_1501939867668_0.jpg|goodsImg_1501939867689_1.jpg|goodsImg_1501939867692_2.jpg|goodsImg_1501939867695_3.jpg', '1', '2', '999.99', '100', 'goodsDetails_1501939868543_0.jpg|goodsDetails_1501939868547_1.jpg', '香型:浓香型|规格:500ml/盒|原料与辅料:水、高粱、小麦', '8.00', '100', '0', '0', '0', '5', '1b775057891c4220a4d51063ae0833be', '日用类', '1501937708179');
INSERT INTO `goods_info` VALUES ('66dd6391385943f69614b4495126482f', '自行车v13', 'goodsImg_1501939867668_0.jpg|goodsImg_1501939867689_1.jpg|goodsImg_1501939867692_2.jpg|goodsImg_1501939867695_3.jpg', '1', '2', '999.99', '100', 'goodsDetails_1501939868543_0.jpg|goodsDetails_1501939868547_1.jpg', '香型:浓香型|规格:500ml/盒|原料与辅料:水、高粱、小麦', '8.00', '100', '0', '0', '0', '6', '1b775057891c4220a4d51063ae0833be', '日用类', '1501937708179');
INSERT INTO `goods_info` VALUES ('6add6391385943f69614b4495126482f', '自行车v14', 'goodsImg_1501939867668_0.jpg|goodsImg_1501939867689_1.jpg|goodsImg_1501939867692_2.jpg|goodsImg_1501939867695_3.jpg', '1', '2', '999.99', '100', 'goodsDetails_1501939868543_0.jpg|goodsDetails_1501939868547_1.jpg', '香型:浓香型|规格:500ml/盒|原料与辅料:水、高粱、小麦', '8.00', '100', '0', '0', '0', '6', '1b775057891c4220a4d51063ae0833be', '日用类', '1501937708179');
INSERT INTO `goods_info` VALUES ('77dd6391385943f69614b4495126482f', '自行车v15', 'goodsImg_1501939867668_0.jpg|goodsImg_1501939867689_1.jpg|goodsImg_1501939867692_2.jpg|goodsImg_1501939867695_3.jpg', '1', '2', '999.99', '100', 'goodsDetails_1501939868543_0.jpg|goodsDetails_1501939868547_1.jpg', '香型:浓香型|规格:500ml/盒|原料与辅料:水、高粱、小麦', '8.00', '100', '0', '0', '0', '1', '1b775057891c4220a4d51063ae0833be', '日用类', '1501937708179');
INSERT INTO `goods_info` VALUES ('7add6391385943f69614b4495126482f', '自行车v16', 'goodsImg_1501939867668_0.jpg|goodsImg_1501939867689_1.jpg|goodsImg_1501939867692_2.jpg|goodsImg_1501939867695_3.jpg', '1', '2', '999.99', '100', 'goodsDetails_1501939868543_0.jpg|goodsDetails_1501939868547_1.jpg', '香型:浓香型|规格:500ml/盒|原料与辅料:水、高粱、小麦', '8.00', '100', '0', '0', '0', '2', '1b775057891c4220a4d51063ae0833be', '日用类', '1501937708179');
INSERT INTO `goods_info` VALUES ('88dd6391385943f69614b4495126482f', '自行车v17', 'goodsImg_1501939867668_0.jpg|goodsImg_1501939867689_1.jpg|goodsImg_1501939867692_2.jpg|goodsImg_1501939867695_3.jpg', '1', '2', '999.99', '100', 'goodsDetails_1501939868543_0.jpg|goodsDetails_1501939868547_1.jpg', '香型:浓香型|规格:500ml/盒|原料与辅料:水、高粱、小麦', '8.00', '100', '0', '0', '0', '3', '1b775057891c4220a4d51063ae0833be', '日用类', '1501937708179');
INSERT INTO `goods_info` VALUES ('8add6391385943f69614b4495126482f', '自行车v18', 'goodsImg_1501939867668_0.jpg|goodsImg_1501939867689_1.jpg|goodsImg_1501939867692_2.jpg|goodsImg_1501939867695_3.jpg', '1', '2', '999.99', '100', 'goodsDetails_1501939868543_0.jpg|goodsDetails_1501939868547_1.jpg', '香型:浓香型|规格:500ml/盒|原料与辅料:水、高粱、小麦', '8.00', '100', '0', '0', '0', '4', '1b775057891c4220a4d51063ae0833be', '日用类', '1501937708179');
INSERT INTO `goods_info` VALUES ('99dd6391385943f69614b4495126482f', '自行车v19', 'goodsImg_1501939867668_0.jpg|goodsImg_1501939867689_1.jpg|goodsImg_1501939867692_2.jpg|goodsImg_1501939867695_3.jpg', '1', '2', '999.99', '100', 'goodsDetails_1501939868543_0.jpg|goodsDetails_1501939868547_1.jpg', '香型:浓香型|规格:500ml/盒|原料与辅料:水、高粱、小麦', '8.00', '100', '0', '0', '0', '5', '1b775057891c4220a4d51063ae0833be', '日用类', '1501937708179');
INSERT INTO `goods_info` VALUES ('9add6391385943f69614b4495126482f', '自行车v20', 'goodsImg_1501939867668_0.jpg|goodsImg_1501939867689_1.jpg|goodsImg_1501939867692_2.jpg|goodsImg_1501939867695_3.jpg', '1', '2', '999.99', '100', 'goodsDetails_1501939868543_0.jpg|goodsDetails_1501939868547_1.jpg', '香型:浓香型|规格:500ml/盒|原料与辅料:水、高粱、小麦', '8.00', '100', '0', '0', '0', '6', '1b775057891c4220a4d51063ae0833be', '日用类', '1501937708179');
INSERT INTO `goods_info` VALUES ('d2f6b595172948318d5d0b5c92aa9558', '佳佳乐', null, '1', '1', '100.00', null, null, 'weqfsdcb', '10.00', '100', '0', '0', '0', '2', '00f0adcd124f4180913ebe37d16f11d9', '电器类', '1502972955421');
INSERT INTO `goods_info` VALUES ('f876352e19ab461a85b45ae75f1e5e30', 'qwe', null, '1', '2', '123.00', '123', null, '123:456|qwe:12', null, '1000', '0', '0', '0', '0', '04666207f8624bddb07b22ec87147baa', '手机类', '1503132427453');
INSERT INTO `goods_info` VALUES ('fadd6391385943f69614b4495126482f', '自行车v21', 'goodsImg_1501939867668_0.jpg|goodsImg_1501939867689_1.jpg|goodsImg_1501939867692_2.jpg|goodsImg_1501939867695_3.jpg', '1', '2', '999.99', '100', 'goodsDetails_1501939868543_0.jpg|goodsDetails_1501939868547_1.jpg', '香型:浓香型|规格:500ml/盒|原料与辅料:水、高粱、小麦', '8.00', '100', '0', '0', '0', '0', '1b775057891c4220a4d51063ae0833be', '日用类', '1501937708179');

-- ----------------------------
-- Table structure for `member_address`
-- ----------------------------
DROP TABLE IF EXISTS `member_address`;
CREATE TABLE `member_address` (
  `id` varchar(50) NOT NULL COMMENT '地址ID',
  `member_id` varchar(50) NOT NULL COMMENT '会员ID',
  `recipients` varchar(20) DEFAULT NULL COMMENT '收件人',
  `phone` varchar(20) DEFAULT NULL COMMENT '联系电话',
  `city` varchar(30) DEFAULT NULL COMMENT '所在地区',
  `detail_address` varchar(256) DEFAULT NULL COMMENT '详细地址',
  `zip_code` varchar(255) DEFAULT NULL COMMENT '邮编',
  `remark` varchar(255) DEFAULT '' COMMENT '备注',
  `is_default` varchar(3) DEFAULT '0' COMMENT '是否默认:0-非默认;1-默认',
  PRIMARY KEY (`id`),
  KEY `index_1` (`id`),
  KEY `index_2` (`member_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='会员地址信息表';

-- ----------------------------
-- Records of member_address
-- ----------------------------
INSERT INTO `member_address` VALUES ('087437b6f4db4adea67fb36bc04fcf0e', 'o-OJTv_ftDalms42QPVn38jZ30L8', '朱雀', '15246379856', '河南省,郑州市,金水区', '红豆刨冰', '472500', '', '1');
INSERT INTO `member_address` VALUES ('66fcf5d9f66847fdb50757f9d974a718', 'o-OJTv_ftDalms42QPVn38jZ30L8', '快睡吧', '15678453124', '河南省,郑州市,金水区', '红豆刨冰', '475286', '', '0');
INSERT INTO `member_address` VALUES ('c3b08060a609417883347096a7dad4c2', 'o-OJTv_ftDalms42QPVn38jZ30L8', '老司机', '15679864312', '河南省,郑州,辽阳', '画得不端倪', '472586', '', '0');
INSERT INTO `member_address` VALUES ('d3d4ec6822f34a92afd7fe91f03e4618', 'o-OJTv_ftDalms42QPVn38jZ30L8', '黎明看', '15678946325', '河南省,郑州市,金水区', '天明路', '472500', '', '0');

-- ----------------------------
-- Table structure for `member_follow_footprint`
-- ----------------------------
DROP TABLE IF EXISTS `member_follow_footprint`;
CREATE TABLE `member_follow_footprint` (
  `id` varchar(50) NOT NULL DEFAULT '',
  `member_id` varchar(50) DEFAULT NULL COMMENT '会员ID',
  `goods_id` varchar(50) DEFAULT NULL COMMENT '商品ID',
  `ff_type` varchar(3) DEFAULT NULL COMMENT '关注足迹类型:1-关注;2-足迹',
  `seethe_time` bigint(20) DEFAULT NULL COMMENT '查看时间',
  `goods_name` varchar(256) DEFAULT NULL COMMENT '商品名称',
  `goods_img` longtext COMMENT '商品图片',
  `goods_price` double(102,0) DEFAULT NULL COMMENT '商品价格',
  `createtime` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `index_1` (`member_id`,`ff_type`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='会员关注足迹信息表';

-- ----------------------------
-- Records of member_follow_footprint
-- ----------------------------

-- ----------------------------
-- Table structure for `member_info`
-- ----------------------------
DROP TABLE IF EXISTS `member_info`;
CREATE TABLE `member_info` (
  `member_id` varchar(50) NOT NULL COMMENT '会员ID',
  `member_name` varchar(20) DEFAULT '' COMMENT '会员名称',
  `wechat` varchar(50) DEFAULT '' COMMENT '微信号',
  `wechat_img` varchar(256) DEFAULT '' COMMENT '微信头像(图片地址)',
  `wechat_name` varchar(20) DEFAULT '' COMMENT '微信名称',
  `balance` double(10,2) DEFAULT NULL COMMENT '余额',
  `red_packet` double(10,2) DEFAULT NULL COMMENT '宏包',
  `cellphone` varchar(20) DEFAULT '' COMMENT '手机号',
  `birth_time` varchar(20) DEFAULT '' COMMENT '出生日期',
  `city` varchar(30) DEFAULT '' COMMENT '所在城市',
  `rp_exchange_ratio` double(10,2) DEFAULT NULL COMMENT '宏包兑换比例:0.3;0.4;0.5;0.6;0.7;0.8;0.9;1.0',
  `rp_trade_mark` varchar(3) DEFAULT '' COMMENT '宏包交易标志:0-关闭;1-打开',
  `rp_listing_ratio` varchar(10) DEFAULT '0' COMMENT '挂牌宏包比例:*(不限制);500;1000;5000;10000;20000;50000;100000',
  `createtime` bigint(20) DEFAULT NULL COMMENT '创建时间',
  PRIMARY KEY (`member_id`),
  KEY `index_1` (`member_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='会员信息表';

-- ----------------------------
-- Records of member_info
-- ----------------------------
INSERT INTO `member_info` VALUES ('o-OJTv_ftDalms42QPVn38jZ30L8', '科迈罗', 'o-OJTv_ftDalms42QPVn38jZ30L8', 'http://wx.qlogo.cn/mmopen/tBh8sHX3UIHcLNUd2BzOkHjyiciaFgFb0HSjAnvNNdXvZcCC1wbJsa5lWCKnW5GZNR6Z8uGSibylza0DgE9P1nurJllrLOEZ20e/0', '李思佳', '0.00', '0.00', '15689632541', '1992-10-21', '郑州方便', '0.80', '1', '*', '1503187994283');
INSERT INTO `member_info` VALUES ('o-OJTv_wYCQEhioixJyeRMIBnL5o', '老司机', 'o-OJTv_wYCQEhioixJyeRMIBnL5o', 'http://wx.qlogo.cn/mmopen/tBh8sHX3UIFxlkaopJSTrTVCqclNPAfCRUNx9KHPRichOZIrrmx95XUb8IOFwJAibsmmJUeba9xyVprQglo64MqwNEJ52xS1H1/0', '小娟', '0.00', '0.00', '15689657745', '2017-08-07', '就和', '0.60', '0', '*', '1503190719550');

-- ----------------------------
-- Table structure for `member_recharge`
-- ----------------------------
DROP TABLE IF EXISTS `member_recharge`;
CREATE TABLE `member_recharge` (
  `id` varchar(50) NOT NULL COMMENT '充值订单ID',
  `member_id` varchar(50) NOT NULL COMMENT '会员ID',
  `member_name` varchar(125) DEFAULT NULL,
  `recharge_amount` double(10,2) DEFAULT NULL COMMENT '充值金额',
  `recharge_status` varchar(3) DEFAULT NULL COMMENT '充值状态:1-成功;2-失败',
  `createtime` bigint(20) DEFAULT NULL COMMENT '充值时间',
  `remark` varchar(256) DEFAULT NULL COMMENT '备注',
  `desc1` varchar(255) DEFAULT NULL,
  `desc2` varchar(255) DEFAULT NULL,
  `desc3` varchar(255) DEFAULT NULL,
  `desc4` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `index_2` (`member_id`),
  KEY `index_1` (`id`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='会员充值订单表';

-- ----------------------------
-- Records of member_recharge
-- ----------------------------

-- ----------------------------
-- Table structure for `member_rp_gain`
-- ----------------------------
DROP TABLE IF EXISTS `member_rp_gain`;
CREATE TABLE `member_rp_gain` (
  `id` varchar(50) NOT NULL,
  `member_id` varchar(50) NOT NULL COMMENT '会员ID',
  `rp_type` varchar(3) DEFAULT NULL COMMENT '1-金额  2-宏包',
  `rp_num` double(10,2) DEFAULT NULL COMMENT '数量 增加为+  消费为-',
  `source_id` varchar(50) DEFAULT NULL COMMENT '来源ID:1-活动，活动ID;2-消费，订单ID;3-买进，宏包订单ID;4-卖出，宏包订单ID',
  `source_describe` varchar(256) DEFAULT NULL COMMENT '来源描述',
  `createtime` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `index_1` (`member_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='会员宏包获取信息表';

-- ----------------------------
-- Records of member_rp_gain
-- ----------------------------

-- ----------------------------
-- Table structure for `member_settings`
-- ----------------------------
DROP TABLE IF EXISTS `member_settings`;
CREATE TABLE `member_settings` (
  `member_id` varchar(50) NOT NULL COMMENT '会员ID',
  `ddtj` varchar(3) DEFAULT '1' COMMENT '订单提交:0-关闭;1-打开',
  `ddqx` varchar(3) DEFAULT '1' COMMENT '订单取消:0-关闭;1-打开',
  `gmcg` varchar(3) DEFAULT '1' COMMENT '购买成功:0-关闭;1-打开',
  `ddfh` varchar(3) DEFAULT '1' COMMENT '订单发货:0-关闭;1-打开',
  `tksq` varchar(3) DEFAULT '1' COMMENT '退款申请:0-关闭;1-打开',
  `tkjg` varchar(3) DEFAULT '1' COMMENT '退款结果:0-关闭;1-打开',
  `czcg` varchar(3) DEFAULT '1' COMMENT '充值成功:0-关闭;1-打开',
  `txsq` varchar(3) DEFAULT '1' COMMENT '提现申请:0-关闭;1-打开',
  `txcg` varchar(3) DEFAULT '1' COMMENT '提现成功:0-关闭;1-打开',
  `txsb` varchar(3) DEFAULT '1' COMMENT '提现失败:0-关闭;1-打开',
  PRIMARY KEY (`member_id`),
  KEY `index_1` (`member_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='会员消息提醒配置表';

-- ----------------------------
-- Records of member_settings
-- ----------------------------
INSERT INTO `member_settings` VALUES ('o-OJTv_ftDalms42QPVn38jZ30L8', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1');
INSERT INTO `member_settings` VALUES ('o-OJTv_wYCQEhioixJyeRMIBnL5o', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1');

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
INSERT INTO `order_info` VALUES ('123', '20170807075000123', '1', '1', '1000', '1000.00', '1000.00', '1000.00', '0', '3', '123', '1501939867692', '朱艳明4', '18365478965', '河南省，郑州市，金水区', '天明路28号', '1501939867692', '1503199355681');
INSERT INTO `order_info` VALUES ('456', '20170807075000456', '1', '2', '1000', '1000.00', '1000.00', '1000.00', '1000', '1', '123', '1501939867695', '123', '123', '洛阳', '123', null, null);
INSERT INTO `order_info` VALUES ('789', '20170807075000456', '1', '1', '1000', '1000.00', '1000.00', '1000.00', '0', '8', '123', '1501939867695', '123', '123', '洛阳', '123', null, null);

-- ----------------------------
-- Table structure for `red_packet_order`
-- ----------------------------
DROP TABLE IF EXISTS `red_packet_order`;
CREATE TABLE `red_packet_order` (
  `rp_order_id` varchar(50) NOT NULL COMMENT '宏包订单ID',
  `seller_member_id` varchar(50) DEFAULT NULL COMMENT '卖家ID',
  `buyers_member_id` varchar(50) DEFAULT NULL COMMENT '买家ID',
  `rp_exchange_ratio` double(2,2) DEFAULT NULL COMMENT '宏包兑换比例',
  `rp_num` int(10) DEFAULT NULL COMMENT '购买宏包数量',
  PRIMARY KEY (`rp_order_id`),
  KEY `index_1` (`rp_order_id`),
  KEY `index_2` (`seller_member_id`),
  KEY `index_3` (`buyers_member_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='宏包订单信息表';

-- ----------------------------
-- Records of red_packet_order
-- ----------------------------

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
INSERT INTO `shop_creditor` VALUES ('8c59970e1e284558bed2662c9ed40b18', '1', '1', '小娟', '15678963256', '64978946312456', 'xx', '', '', '', '', '', '', '', '', '', '', '100', '1503158400000', '1', 'o-OJTv_wYCQEhioixJyeRMIBnL5o', 'http://wx.qlogo.cn/mmopen/tBh8sHX3UIFxlkaopJSTrTVCqclNPAfCRUNx9KHPRichOZIrrmx95XUb8IOFwJAibsmmJUeba9xyVprQglo64MqwNEJ52xS1H1/0', '1503190769716', '', null);
INSERT INTO `shop_creditor` VALUES ('670d363c59a340b2b90ef9d8c7d18491', '1', '1', '李思佳', '15689632541', '411223199212124569', 'xy', '布丁酒店不像你多看看', '华侨集团', '红豆刨冰', '', '', '', '', '', '', '', '100', '1503158400000', '1', 'o-OJTv_ftDalms42QPVn38jZ30L8', 'http://wx.qlogo.cn/mmopen/tBh8sHX3UIHcLNUd2BzOkHjyiciaFgFb0HSjAnvNNdXvZcCC1wbJsa5lWCKnW5GZNR6Z8uGSibylza0DgE9P1nurJllrLOEZ20e/0', '1503189638525', '', null);

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
  `goods_img` longtext COMMENT '商品图片',
  `goods_price` double(10,2) DEFAULT NULL COMMENT '商品价格',
  `goods_red_packet` int(10) DEFAULT NULL COMMENT '商品宏包',
  `goods_num` int(10) DEFAULT NULL COMMENT '商品数量',
  `goods_type` varchar(3) DEFAULT NULL COMMENT '商品类型:1-大众商品;2-宏包商品',
  `shopping_cart_status` varchar(3) DEFAULT NULL COMMENT '购物车商品状态:1-已添加;2-已购买;3-已删除',
  PRIMARY KEY (`shopping_cart_id`),
  KEY `index_1` (`member_id`),
  KEY `index_2` (`order_id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8 COMMENT='购物车信息表';

-- ----------------------------
-- Records of shopping_cart
-- ----------------------------
INSERT INTO `shopping_cart` VALUES ('1', '00dd6391385943f69614b4495126482f', '123456789', '456', '1503137551201', '自行车v1', 'goodsImg_1501939867668_0.jpg', '999.99', '100', '2', '2', '1');
INSERT INTO `shopping_cart` VALUES ('2', '1add6391385943f69614b4495126482f', '123456789', '456', '1503137603267', '自行车v4', 'goodsImg_1501939867668_0.jpg', '999.99', '100', '3', '2', '1');
INSERT INTO `shopping_cart` VALUES ('3', '00dd6391385943f69614b4495126482f', '123456789', null, '1503200775041', '自行车v1', 'goodsImg_1501939867668_0.jpg', '999.99', '100', '1', '2', '1');

-- ----------------------------
-- Table structure for `weChatPay`
-- ----------------------------
DROP TABLE IF EXISTS `weChatPay`;
CREATE TABLE `weChatPay` (
  `id` varchar(50) NOT NULL DEFAULT '',
  `appId` varchar(50) DEFAULT NULL COMMENT '公众号id',
  `mchId` varchar(50) DEFAULT NULL COMMENT '商铺id',
  `openid` varchar(50) DEFAULT NULL COMMENT '支付人id',
  `transId` varchar(50) DEFAULT NULL COMMENT '微信订单号id',
  `totalFee` double(50,2) DEFAULT NULL COMMENT '支付金额 分',
  `payNum` double(50,2) DEFAULT NULL COMMENT '宏包数量',
  `outTradeNo` varchar(50) DEFAULT NULL COMMENT '订单号',
  `payStatus` varchar(50) DEFAULT '0' COMMENT '支付状态 1-成功 2-失败 0-新建',
  `memberId` varchar(50) DEFAULT NULL COMMENT '接收人id',
  `createtime` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of weChatPay
-- ----------------------------
INSERT INTO `weChatPay` VALUES ('wx20170811194038ad47da8a430993563193', 'wx8c38f7256d081b10', '1487100762', 'o-OJTv_ftDalms42QPVn38jZ30L8', 'wx20170811194038ad47da8a430993563193', '0.00', null, '2017081119471502452050', null, null, '1502452052281');
INSERT INTO `weChatPay` VALUES ('2017081316501502614252', 'wx8c38f7256d081b10', '1487100762', 'o-OJTv_ftDalms42QPVn38jZ30L8', 'wx201708131650546ece520f380505382724', '1.00', null, '2017081316501502614252', null, null, '1502614254475');
INSERT INTO `weChatPay` VALUES ('2017081316511502614284', 'wx8c38f7256d081b10', '1487100762', 'o-OJTv_ftDalms42QPVn38jZ30L8', 'wx201708131651251a1fdc1a750007218923', '0.00', null, '2017081316511502614284', null, null, '1502614285417');
INSERT INTO `weChatPay` VALUES ('2017081316511502614315', 'wx8c38f7256d081b10', '1487100762', 'o-OJTv_ftDalms42QPVn38jZ30L8', 'wx20170813165157802edfe9b80240552775', '407.00', null, '2017081316511502614315', null, null, '1502614317273');
INSERT INTO `weChatPay` VALUES ('2017081316521502614344', 'wx8c38f7256d081b10', '1487100762', 'o-OJTv_ftDalms42QPVn38jZ30L8', 'wx2017081316522614a9f0ea6f0400412047', '0.80', null, '2017081316521502614344', null, null, '1502614346061');
INSERT INTO `weChatPay` VALUES ('2017081317201502616010', 'wx8c38f7256d081b10', '1487100762', 'o-OJTv_ftDalms42QPVn38jZ30L8', 'wx20170813172012d2721080130755949448', '0.50', '0.00', '2017081317201502616010', null, 'oxN_Gwa24d7SC2WsAVAKTNkkwg_o', '1502616012376');
INSERT INTO `weChatPay` VALUES ('2017081317251502616357', 'wx8c38f7256d081b10', '1487100762', 'o-OJTv_ftDalms42QPVn38jZ30L8', 'wx201708131725598b976a2e390363649691', '1.00', '1.00', '2017081317251502616357', null, 'oxN_Gwa24d7SC2WsAVAKTNkkwg_o', '1502616359524');
INSERT INTO `weChatPay` VALUES ('2017081317261502616386', 'wx8c38f7256d081b10', '1487100762', 'o-OJTv_ftDalms42QPVn38jZ30L8', 'wx201708131726278018f1724e0566737237', '0.50', '0.50', '2017081317261502616386', null, 'oxN_Gwa24d7SC2WsAVAKTNkkwg_o', '1502616387684');
INSERT INTO `weChatPay` VALUES ('2017081317441502617494', 'wx8c38f7256d081b10', '1487100762', 'o-OJTv_ftDalms42QPVn38jZ30L8', 'wx2017081317445903590e706d0356942742', '1.00', '1.00', '2017081317441502617494', '1', 'oxN_Gwa24d7SC2WsAVAKTNkkwg_o', '1502617499973');
INSERT INTO `weChatPay` VALUES ('2017081317461502617585', 'wx8c38f7256d081b10', '1487100762', 'o-OJTv_ftDalms42QPVn38jZ30L8', 'wx201708131746263de9f0aabc0553075912', '1.00', '1.00', '2017081317461502617585', '0', 'o-OJTv_ftDalms42QPVn38jZ30L8', '1502617586607');
INSERT INTO `weChatPay` VALUES ('2017081317461502617586', 'wx8c38f7256d081b10', '1487100762', 'o-OJTv_ftDalms42QPVn38jZ30L8', 'wx20170813174628b3ae908cb20630500053', '1.00', '1.00', '2017081317461502617586', '1', 'o-OJTv_ftDalms42QPVn38jZ30L8', '1502617587966');
INSERT INTO `weChatPay` VALUES ('2017081317471502617662', 'wx8c38f7256d081b10', '1487100762', 'o-OJTv_ftDalms42QPVn38jZ30L8', 'wx20170813174743586e5f9d2f0493909060', '1.00', '1.00', '2017081317471502617662', '1', 'oxN_Gwa24d7SC2WsAVAKTNkkwg_o', '1502617663834');
INSERT INTO `weChatPay` VALUES ('2017081321351502631303', 'wx8c38f7256d081b10', '1487100762', 'o-OJTv_ftDalms42QPVn38jZ30L8', 'wx20170813213505174c2a0b640193663938', '405.00', '405.00', '2017081321351502631303', '0', 'oxN_Gwa24d7SC2WsAVAKTNkkwg_o', '1502631305372');
INSERT INTO `weChatPay` VALUES ('2017081619411502883715', 'wx8c38f7256d081b10', '1487100762', 'o-OJTv_ftDalms42QPVn38jZ30L8', 'wx2017081619415256299544bf0458807725', '1.00', null, '2017081619411502883715', '1', null, '1502883717615');
INSERT INTO `weChatPay` VALUES ('2017081621131502889235', 'wx8c38f7256d081b10', '1487100762', 'o-OJTv_ftDalms42QPVn38jZ30L8', 'wx20170816211352c89341c6ff0055907561', '1.00', null, '2017081621131502889235', '1', null, '1502889237348');
INSERT INTO `weChatPay` VALUES ('2017081709481502934538', 'wx8c38f7256d081b10', '1487100762', 'o-OJTv_ftDalms42QPVn38jZ30L8', 'wx20170817094856a9ce6733430160966739', '1.00', null, '2017081709481502934538', '0', null, '1502934541675');
INSERT INTO `weChatPay` VALUES ('2017081822191503065981', 'wx8c38f7256d081b10', '1487100762', 'o-OJTv_ftDalms42QPVn38jZ30L8', 'wx20170818221936cc75ee3d9c0396514377', '8.00', null, '2017081822191503065981', '0', null, '1503065983650');
INSERT INTO `weChatPay` VALUES ('2017082020581503233935', 'wx8c38f7256d081b10', '1487100762', 'o-OJTv_ftDalms42QPVn38jZ30L8', 'wx2017082020585767dde604b10134251583', '1000.00', '0.00', '2017082020581503233935', '0', null, '1503233938024');
INSERT INTO `weChatPay` VALUES ('2017082021001503234008', 'wx8c38f7256d081b10', '1487100762', 'o-OJTv_ftDalms42QPVn38jZ30L8', 'wx20170820210010b14a2c52670551641239', '1000.00', '0.00', '2017082021001503234008', '0', null, '1503234010843');
INSERT INTO `weChatPay` VALUES ('2017082021111503234662', 'wx8c38f7256d081b10', '1487100762', 'o-OJTv_ftDalms42QPVn38jZ30L8', 'wx20170820211104c6c5eabf7e0132131191', '1000.00', '0.00', '2017082021111503234662', '0', null, '1503234664914');
INSERT INTO `weChatPay` VALUES ('2017082021161503235007', 'wx8c38f7256d081b10', '1487100762', 'o-OJTv_ftDalms42QPVn38jZ30L8', '123', '1000.00', '0.00', '2017082021161503235007', '0', null, '1503235009710');
