/*
Navicat MySQL Data Transfer

Source Server         : Զ��
Source Server Version : 50622
Source Host           : 119.23.74.128:3306
Source Database       : pets

Target Server Type    : MYSQL
Target Server Version : 50622
File Encoding         : 65001

Date: 2019-06-14 14:45:58
*/

SET FOREIGN_KEY_CHECKS=0;
-- ----------------------------
-- Table structure for `address`
-- ----------------------------
DROP TABLE IF EXISTS `address`;
CREATE TABLE `address` (
  `adderid` int(11) NOT NULL AUTO_INCREMENT,
  `province` varchar(50) DEFAULT NULL,
  `market` varchar(50) DEFAULT NULL,
  `district` varchar(50) DEFAULT NULL,
  `detaadder` varchar(50) DEFAULT NULL,
  `temphone` varchar(50) DEFAULT NULL,
  `shname` varchar(50) DEFAULT NULL,
  `mr` varchar(50) DEFAULT NULL,
  `uid` int(11) DEFAULT NULL,
  PRIMARY KEY (`adderid`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of address
-- ----------------------------
INSERT INTO `address` VALUES ('1', '广东省', '广州市', '天河区', '660号', '12345678911', '周楷涛', '0', '22');

-- ----------------------------
-- Table structure for `adopter`
-- ----------------------------
DROP TABLE IF EXISTS `adopter`;
CREATE TABLE `adopter` (
  `terId` int(11) NOT NULL AUTO_INCREMENT COMMENT '领养人信息表id',
  `sex` varchar(50) DEFAULT NULL COMMENT '领养人性别 1 麻麻 0 爸爸',
  `age` varchar(50) DEFAULT NULL COMMENT '领养人年代 6 60后  7 70后 8 80后 9 90后 0 00后',
  `status` varchar(50) DEFAULT NULL COMMENT '领养人工作状态  1 无业 2 学生 3 工作  0退休',
  `experience` varchar(50) DEFAULT NULL COMMENT '养宠经验  1 有经验 0 无经验',
  `marriage` varchar(50) DEFAULT NULL COMMENT '婚姻状况  1 单身 2 恋爱中 0 已婚',
  `lodging` varchar(50) DEFAULT NULL COMMENT '住房状况  1 自住房 2 整租房 0 合租',
  `income` varchar(50) DEFAULT NULL COMMENT '我的月收入 1 小于三千 2 三千到六千 3 六千到一万 4 大于一万',
  `de` varchar(500) DEFAULT NULL,
  `userId` int(11) DEFAULT NULL COMMENT '用户id',
  PRIMARY KEY (`terId`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=14 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of adopter
-- ----------------------------
INSERT INTO `adopter` VALUES ('13', '爸爸', '90后', '学生', '无经验', '单身', '自住房', '小于3千', '很想要一只', '14');

-- ----------------------------
-- Table structure for `adoption`
-- ----------------------------
DROP TABLE IF EXISTS `adoption`;
CREATE TABLE `adoption` (
  `adid` int(11) NOT NULL AUTO_INCREMENT COMMENT '送养表id',
  `name` varchar(32) DEFAULT NULL COMMENT '宠物昵称',
  `sex` int(2) DEFAULT NULL COMMENT '宠物性别 1 - 男孩 0 - 女孩 ',
  `isVaccine` varchar(10) DEFAULT NULL COMMENT '是否注射疫苗 1 -是 0-否',
  `isNeuter` varchar(10) DEFAULT NULL COMMENT '是否绝育 1 -是 0-否',
  `isEP` varchar(10) DEFAULT NULL COMMENT '是否驱虫 1 -是 0-否',
  `describe` varchar(255) DEFAULT NULL COMMENT '宠物描述或送养原因',
  `city` varchar(32) DEFAULT NULL COMMENT '城市',
  `detailed` varchar(120) DEFAULT NULL COMMENT '详细地址',
  `kindId` int(11) DEFAULT NULL COMMENT '种类表id',
  `petAgeId` int(11) DEFAULT NULL COMMENT '宠物年龄表id',
  `userId` int(11) DEFAULT NULL COMMENT '用户id',
  PRIMARY KEY (`adid`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=67 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of adoption
-- ----------------------------
INSERT INTO `adoption` VALUES ('31', '阿斯达', '0', '已注射', '已绝育', '已驱虫', '阿斯达四大', '广州市', '珠吉路660号', '2', '1', '14');
INSERT INTO `adoption` VALUES ('32', '小强', '0', '已注射', '未绝育', '已驱虫', '没有故事', '广州市', '朱吉路660', '2', '2', '14');
INSERT INTO `adoption` VALUES ('38', '罗根', '1', '已注射', '已绝育', '已驱虫', '罗根是妈妈的独生子，很惊奇竟然流浪猫咪有一胎的宝宝，后来才发现罗根妈之前是有家的以前做过刨', '广州市', '珠吉路660号', '1', '2', '16');
INSERT INTO `adoption` VALUES ('39', '小橘子', '0', '已注射', '已绝育', '已驱虫', '7个月左右的弟弟，性格温柔亲人，身体健康，流浪在小区，每次喂食都会伸出小爪卖萌，求撸欲望强烈。', '广州市', '珠吉路660号', '1', '1', '16');
INSERT INTO `adoption` VALUES ('40', '小嗨', '0', '已注射', '未绝育', '已驱虫', '小家伙很没心没肺，一点都不难过。亲人，陌生人很容易接近，肚子随便摸。', '广州市', '珠吉路660号', '2', '1', '16');
INSERT INTO `adoption` VALUES ('41', '小明', '0', '已注射', '已绝育', '已驱虫', '小明是最爱清洁的小弟弟，每次第一个上厕所。一窝里唯一的弟弟，察言观色在两位姐姐中间左右逢源 最贵奶粉奶大 求富养', '广州市', '珠吉路660号', '1', '2', '16');
INSERT INTO `adoption` VALUES ('42', '旺', '0', '已注射', '已绝育', '未驱虫', '这个狗妈妈2/3个月前流浪到工地。当时已经怀孕了。工地有几个年轻人很好。给她饭吃，供养她直到生产', '广州市', '珠吉路660号', '2', '2', '16');
INSERT INTO `adoption` VALUES ('43', '小旺', '0', '已注射', '已绝育', '未驱虫', '这个狗妈妈2/3个月前流浪到工地。当时已经怀孕了。工地有几个年轻人很好。给她饭吃，供养她直到生产', '广州市', '珠吉路660号', '2', '2', '16');
INSERT INTO `adoption` VALUES ('61', '皮皮', '0', '已注射', '已绝育', '已驱虫', '性格活泼好动，粘人的男孩子，白天困了就挨着你睡觉，晚上喜欢爬床上睡在主人枕头边或者脚边。 ', '广州市', '珠吉路660号', '1', '2', '16');
INSERT INTO `adoption` VALUES ('66', '小小', '0', '已注射', '已绝育', '已驱虫', '很小，很好看', '广州市', '珠吉路660号', '1', '3', '16');

-- ----------------------------
-- Table structure for `adoptionConditions`
-- ----------------------------
DROP TABLE IF EXISTS `adoptionConditions`;
CREATE TABLE `adoptionConditions` (
  `acId` int(11) NOT NULL AUTO_INCREMENT COMMENT '领养条件表id',
  `conditions` varchar(32) DEFAULT NULL COMMENT '领养条件内容',
  PRIMARY KEY (`acId`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of adoptionConditions
-- ----------------------------
INSERT INTO `adoptionConditions` VALUES ('1', '仅限同城');
INSERT INTO `adoptionConditions` VALUES ('2', '按时打疫苗');
INSERT INTO `adoptionConditions` VALUES ('3', '同意适龄绝育');
INSERT INTO `adoptionConditions` VALUES ('4', '不得遗弃，转让，贩卖，繁殖，虐待');
INSERT INTO `adoptionConditions` VALUES ('5', '有防盗门，必须封网');
INSERT INTO `adoptionConditions` VALUES ('6', '接受领养前家访，领养后回访');
INSERT INTO `adoptionConditions` VALUES ('7', '家庭成员全员同意');
INSERT INTO `adoptionConditions` VALUES ('8', '工作稳定，有一定经济基础');
INSERT INTO `adoptionConditions` VALUES ('9', '文明养宠，出门拴绳，科学喂养');
INSERT INTO `adoptionConditions` VALUES ('10', '签订领养协议');

-- ----------------------------
-- Table structure for `cart`
-- ----------------------------
DROP TABLE IF EXISTS `cart`;
CREATE TABLE `cart` (
  `cartId` int(11) NOT NULL AUTO_INCREMENT COMMENT '购物车id',
  `pronum` int(11) DEFAULT NULL COMMENT '商品数量',
  `userId` int(11) DEFAULT NULL COMMENT '用户id',
  `wareId` int(11) DEFAULT NULL COMMENT '商品id',
  PRIMARY KEY (`cartId`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=22 DEFAULT CHARSET=utf8 ROW_FORMAT=COMPACT;

-- ----------------------------
-- Records of cart
-- ----------------------------

-- ----------------------------
-- Table structure for `finds`
-- ----------------------------
DROP TABLE IF EXISTS `finds`;
CREATE TABLE `finds` (
  `fid` int(11) NOT NULL AUTO_INCREMENT COMMENT '寻宠id',
  `fimg` varchar(255) DEFAULT NULL COMMENT '宠物照片',
  `ftype` varchar(255) DEFAULT NULL COMMENT '发布类型 0-丢失； 1-捡到',
  `fname` varchar(255) DEFAULT NULL COMMENT '宠物昵称',
  `fcity` varchar(255) DEFAULT NULL COMMENT '所在城市',
  `ftime` date DEFAULT NULL COMMENT '丢失时间',
  `faddress` varchar(255) DEFAULT NULL COMMENT '丢失地址',
  `fontime` int(11) DEFAULT NULL COMMENT '有效时间',
  `fkind` int(11) DEFAULT NULL COMMENT '种类 ：1-猫猫，2.狗狗，3.其它',
  `fdesc` varchar(255) DEFAULT NULL COMMENT '宠物描述',
  `userId` int(11) DEFAULT NULL COMMENT '用户id',
  PRIMARY KEY (`fid`)
) ENGINE=InnoDB AUTO_INCREMENT=18 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of finds
-- ----------------------------
INSERT INTO `finds` VALUES ('9', 'http://119.23.74.128/group1/M00/00/01/rBEDD1zw9s6AHZ-3AAUyrrrnBSo526.jpg', '1', '大雕', '广州市', '2019-05-31', '天河区朱吉路660号', '10', '1', '长得很大，牛逼', '25');
INSERT INTO `finds` VALUES ('10', 'http://119.23.74.128/group1/M00/00/03/rBEDD1z91rqAJTFoAADpz39HwEg733.jpg', '1', '贵宾猫', '广州市', '2016-06-10', '天河区珠吉路660号', '10', '1', '长得可爱，有点萌萌的！！', '15');
INSERT INTO `finds` VALUES ('11', 'http://119.23.74.128/group1/M00/00/03/rBEDD1z912mAe-EtAAGAqS2Wp0g18.jpeg', '2', '咖菲猫', '广州市', '2019-06-10', '番禺区', '20', '1', '白白的，胖胖的噢！！', '15');
INSERT INTO `finds` VALUES ('12', 'http://119.23.74.128/group1/M00/00/03/rBEDD1z92B-AbHe8AAC3HdoBrbQ314.jpg', '1', '贵宾犬', '深圳市', '2018-06-10', '宝安', '30', '2', '黄黄的猫，很乖很听话的噢！！！', '15');
INSERT INTO `finds` VALUES ('13', 'http://119.23.74.128/group1/M00/00/03/rBEDD1z9252ADvKvAABubEAM9DI218.jpg', '1', '寻2岁博美狗狗', '广州市', '2019-06-10', '黄埔区', '10', '2', '最美丽的博美犬，今年才2岁，白白的毛', '15');
INSERT INTO `finds` VALUES ('14', 'http://119.23.74.128/group1/M00/00/03/rBEDD1z92_GAQk8cAABFbiqrA3A973.jpg', '1', '傻傻的哈士奇', '广州市', '2019-06-10', '天河区', '10', '2', '傻傻的，最乖的最听话的', '15');
INSERT INTO `finds` VALUES ('15', 'http://119.23.74.128/group1/M00/00/03/rBEDD1z93KqAKfLkAABv-yth7SA167.jpg', '1', '萨摩耶犬', '深圳市', '2019-06-10', '沙井', '10', '2', '聪明、乖巧可爱、不掉毛、友善、会看家、易训这些优点都是它身上所持有的！', '15');
INSERT INTO `finds` VALUES ('16', 'http://119.23.74.128/group1/M00/00/03/rBEDD1z9_NeAJN68AAD51vxwDUU590.jpg', '1', '会流口水的萨摩耶犬', '广州市', '2019-06-10', '珠江新城', '10', '2', '这么萌的狗狗真的很讨人喜欢了，而且很乖巧，撒娇起来更是无敌了。不管是流口水的它还是卖萌不自知的它，都能带给人们无限的快乐哟~', '15');
INSERT INTO `finds` VALUES ('17', 'http://119.23.74.128/group1/M00/00/04/rBEDD1z_dPOAAAa7AAIEcnTngjo649.jpg', '1', '小气NG11', '广州市', '2019-06-11', '朱继璐', '10', '1', '123', '22');

-- ----------------------------
-- Table structure for `itemcat`
-- ----------------------------
DROP TABLE IF EXISTS `itemcat`;
CREATE TABLE `itemcat` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(50) DEFAULT NULL,
  `img` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=27 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of itemcat
-- ----------------------------
INSERT INTO `itemcat` VALUES ('17', '公益义卖', 'http://119.23.74.128/group1/M00/00/00/rBEDD1zku06Abp9kAAAkvX1vYJs279.png');
INSERT INTO `itemcat` VALUES ('18', '狗粮', 'http://119.23.74.128/group1/M00/00/00/rBEDD1zku2aAG8DJAAAnM7wjnHw515.png');
INSERT INTO `itemcat` VALUES ('19', '猫粮', 'http://119.23.74.128/group1/M00/00/00/rBEDD1zku3eAAACbAAAmB0bXY1A554.png');
INSERT INTO `itemcat` VALUES ('20', '零食罐头', 'http://119.23.74.128/group1/M00/00/00/rBEDD1zku5KABDW2AAAsXh1co00156.png');
INSERT INTO `itemcat` VALUES ('21', '驱虫保健', 'http://119.23.74.128/group1/M00/00/00/rBEDD1zku7OAHS8mAAAjo5ICZbk336.png');
INSERT INTO `itemcat` VALUES ('22', '清洁洗护', 'http://119.23.74.128/group1/M00/00/00/rBEDD1zku8eAZzGqAAAb4ywXAQQ118.png');
INSERT INTO `itemcat` VALUES ('23', '日常用品', 'http://119.23.74.128/group1/M00/00/00/rBEDD1zku-WATJJyAAAv8dy7qjE044.png');
INSERT INTO `itemcat` VALUES ('24', '玩具周边', 'http://119.23.74.128/group1/M00/00/00/rBEDD1zku_WAWZMkAAAnEzpRz5U468.png');

-- ----------------------------
-- Table structure for `items`
-- ----------------------------
DROP TABLE IF EXISTS `items`;
CREATE TABLE `items` (
  `wareid` int(11) NOT NULL AUTO_INCREMENT,
  `warename` varchar(50) DEFAULT NULL,
  `proprice` bigint(20) DEFAULT NULL,
  `waretime` datetime DEFAULT NULL,
  `waredetailed` varchar(10000) DEFAULT NULL,
  `warefreight` int(11) DEFAULT NULL,
  `warestatus` char(2) DEFAULT NULL,
  `cid` int(11) DEFAULT NULL,
  PRIMARY KEY (`wareid`)
) ENGINE=InnoDB AUTO_INCREMENT=110 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of items
-- ----------------------------
INSERT INTO `items` VALUES ('86', '麦富迪 宠物狗粮 藻趣儿通用成犬粮', '289', '2019-06-10 22:47:30', '', '999', '1', '18');
INSERT INTO `items` VALUES ('87', '皇家狗粮 CC优选成犬狗粮 全价粮 8kg', '180', '2019-06-10 22:50:04', '', '999', '1', '18');
INSERT INTO `items` VALUES ('88', '麦富迪 宠物狗粮 藻趣儿通用成犬粮7.5kg', '126', '2019-06-10 22:52:32', '', '999', '1', '18');
INSERT INTO `items` VALUES ('89', '皇家猫粮 Indoor27室内成猫猫粮 全价粮 2kg', '122', '2019-06-10 22:54:45', '', '999', '1', '19');
INSERT INTO `items` VALUES ('90', ' 皇家猫粮 K36幼猫猫粮 全价粮 4-12月龄 2kg ', '104', '2019-06-10 22:56:27', '', '999', '1', '19');
INSERT INTO `items` VALUES ('91', '皇家猫粮 BK34猫奶糕全价粮 1-4月龄 2kg ', '152', '2019-06-10 22:57:47', '', '999', '1', '19');
INSERT INTO `items` VALUES ('92', '宠物零食狗零食 成犬大型犬洁齿棒磨牙棒狗咬胶', '99', '2019-06-11 08:38:53', '', '999', '1', '17');
INSERT INTO `items` VALUES ('93', '麦富迪 狗罐头狗湿粮宠物狗粮', '24', '2019-06-11 08:40:06', '', '999', '1', '17');
INSERT INTO `items` VALUES ('94', '麦富迪 狗零食狗磨牙棒洁齿棒 通用钙奶味', '26', '2019-06-11 08:41:35', '', '999', '1', '17');
INSERT INTO `items` VALUES ('95', '麦富迪 狗罐头狗湿粮宠物狗粮 泰国原装进口鸡肉+牛油果', '29', '2019-06-11 08:43:36', '', '999', '1', '20');
INSERT INTO `items` VALUES ('96', '顽皮（Wanpy）宠物狗粮 狗湿粮 狗罐头 ', '19', '2019-06-11 08:44:57', '', '456', '1', '20');
INSERT INTO `items` VALUES ('97', ' 爱丽思IRIS 狗罐头狗湿粮狗粮宠物狗粮牛肉味狗罐头', '22', '2019-06-11 08:46:06', '', '786', '1', '20');
INSERT INTO `items` VALUES ('98', '美国进口 大宠爱 狗狗驱虫药 体外驱虫滴剂 宠物药品 驱除耳螨疥螨虱子跳蚤蛔虫等', '223', '2019-06-11 08:47:51', '', '456', '1', '21');
INSERT INTO `items` VALUES ('99', '狗体外驱虫药滴剂除跳蚤虱蜱虫预防叮咬宠物药品', '360', '2019-06-11 08:49:29', '', '999', '1', '21');
INSERT INTO `items` VALUES ('100', '驱虫药滴剂除跳蚤虱蜱虫预防叮咬宠物药品', '90', '2019-06-11 08:51:11', '', '999', '1', '21');
INSERT INTO `items` VALUES ('101', '咖卡猫沐浴露宠物沐浴露猫咪香波杀菌除蚤浴液猫洗澡宠物用品', '27', '2019-06-11 08:53:08', '', '999', '1', '22');
INSERT INTO `items` VALUES ('102', 'SOS猫咪沐浴露 温和增香 宠物香波', '45', '2019-06-11 08:54:33', '', '666', '1', '22');
INSERT INTO `items` VALUES ('103', '艾宠宠物 护肤二合一香波花卉草本香型', '72', '2019-06-11 08:56:15', '', '999', '1', '22');
INSERT INTO `items` VALUES ('104', '小佩PETKIT猫抓板猫玩具磨爪器猫窝瓦楞纸磨爪猫咪用品', '93', '2019-06-11 08:58:06', '', '999', '1', '24');
INSERT INTO `items` VALUES ('105', '宠物玩具猫玩具逗猫棒逗猫玩具不倒翁小老鼠小猫咪幼猫玩具', '49', '2019-06-11 08:59:59', '', '999', '1', '24');
INSERT INTO `items` VALUES ('106', '田田猫加长杆羽毛逗猫杆钓鱼逗猫棒猫玩具宠物猫用品', '18', '2019-06-11 09:01:19', '', '789', '1', '24');
INSERT INTO `items` VALUES ('107', '狗狗凉席夏季可拆洗冰垫睡垫四季宠物冰窝猫垫子泰迪凉垫', '39', '2019-06-11 09:03:00', '', '999', '1', '23');
INSERT INTO `items` VALUES ('108', '夏季狗床中型犬小型犬宠物窝 ', '39', '2019-06-11 09:04:20', '', '999', '1', '23');
INSERT INTO `items` VALUES ('109', '狗窝猫窝狗狗垫子秋冬宠物窝垫耐咬狗狗棉垫', '39', '2019-06-11 09:06:13', '', '999', '1', '23');

-- ----------------------------
-- Table structure for `kind`
-- ----------------------------
DROP TABLE IF EXISTS `kind`;
CREATE TABLE `kind` (
  `kindId` int(11) NOT NULL AUTO_INCREMENT COMMENT '种类表id',
  `kindName` varchar(16) DEFAULT NULL COMMENT '种类名称',
  PRIMARY KEY (`kindId`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of kind
-- ----------------------------
INSERT INTO `kind` VALUES ('1', '猫猫');
INSERT INTO `kind` VALUES ('2', '狗狗');
INSERT INTO `kind` VALUES ('3', '其他');

-- ----------------------------
-- Table structure for `lookingPet`
-- ----------------------------
DROP TABLE IF EXISTS `lookingPet`;
CREATE TABLE `lookingPet` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '寻宠表id',
  `type` int(2) DEFAULT NULL COMMENT '发布寻宠表类型 0 - 丢失 1 -捡到',
  `petName` varchar(32) DEFAULT NULL COMMENT '宠物昵称',
  `city` varchar(60) DEFAULT NULL COMMENT '所在城市',
  `stealTime` datetime DEFAULT NULL COMMENT '宠物丢失时间',
  `site` varchar(60) DEFAULT NULL COMMENT '宠物丢失详细地址',
  `validTime` varchar(30) DEFAULT NULL COMMENT '有效时间 10    20    30 ',
  `describe` varchar(120) DEFAULT NULL COMMENT '宠物描述',
  `name` varchar(12) DEFAULT NULL COMMENT '发布寻宠人的名称',
  `phone` varchar(16) DEFAULT NULL COMMENT '寻宠人手机号码',
  `weChat` varchar(32) DEFAULT NULL COMMENT '微信号码',
  `isShowPhone` int(2) DEFAULT NULL COMMENT '是否显示电话号码 1 - 显示  0 - 隐藏',
  `kindId` int(11) DEFAULT NULL COMMENT '种类表id',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of lookingPet
-- ----------------------------

-- ----------------------------
-- Table structure for `manager`
-- ----------------------------
DROP TABLE IF EXISTS `manager`;
CREATE TABLE `manager` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `uname` varchar(255) DEFAULT NULL,
  `pwd` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of manager
-- ----------------------------
INSERT INTO `manager` VALUES ('1', 'LMH', '123456');
INSERT INTO `manager` VALUES ('2', 'ZKT', '123456');
INSERT INTO `manager` VALUES ('3', 'ZHL', '123456');
INSERT INTO `manager` VALUES ('4', 'ZCL', '123456');

-- ----------------------------
-- Table structure for `mb_user`
-- ----------------------------
DROP TABLE IF EXISTS `mb_user`;
CREATE TABLE `mb_user` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `username` varchar(50) DEFAULT NULL,
  `password` varchar(50) DEFAULT NULL,
  `phone` varchar(50) DEFAULT NULL,
  `email` varchar(50) DEFAULT NULL,
  `img` varchar(1000) DEFAULT NULL,
  `created` datetime DEFAULT NULL,
  `updated` datetime DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=23 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of mb_user
-- ----------------------------
INSERT INTO `mb_user` VALUES ('10', '123', '4F0578B87975ECD16D15E8A21CB904EE', '12345678911', '123@qq.com', 'http://119.23.74.128/group1/M00/00/00/rBEDD1zhHq-A', '2019-05-19 17:15:55', '2019-05-19 17:15:55');
INSERT INTO `mb_user` VALUES ('12', 'zqq', 'D49F76D7DD5074F946923CACC9833799', '13049610329', '2137372344@qq.com', 'http://119.23.74.128/group1/M00/00/03/rBEDD1z8xPiAFPIhAAAo7Q5_Zsg683.png', '2019-06-09 16:36:54', '2019-06-09 16:36:54');
INSERT INTO `mb_user` VALUES ('14', 'lmh', 'AD4CFB033E57C9CF6163421CDFD3B9B4', '12345678912', '123@qq.com', 'http://119.23.74.128/group1/M00/00/03/rBEDD1z9xDSAE9otAAC0hHhWy1E62.jpeg', '2019-06-10 10:45:27', '2019-06-10 10:45:27');
INSERT INTO `mb_user` VALUES ('15', '轻浅离笑', 'F532DF0B43632F489ECCF603A56F5F2D', '13045678910', '12345678@qq.com', 'http://119.23.74.128/group1/M00/00/03/rBEDD1z91V6AQcF5AABCdQZO06M704.jpg', '2019-06-10 11:59:52', '2019-06-10 11:59:52');
INSERT INTO `mb_user` VALUES ('16', 'zqq123', 'A4BFD403DA8B1F09195F7FF28A4FA6D3', '13049610320', '123456@qq.com', 'http://119.23.74.128/group1/M00/00/03/rBEDD1z91rOAIpztAACYm0e25l8710.jpg', '2019-06-10 12:08:55', '2019-06-10 12:08:55');
INSERT INTO `mb_user` VALUES ('17', 'zkt', 'A89728E0BBE39263BBBBC49C2090A6E8', '13556340999', '123456789@qq.com', 'http://119.23.74.128/group1/M00/00/04/rBEDD1z_EGGAMorRAAAxLhxqfEU661.jpg', '2019-06-11 10:23:04', '2019-06-11 10:23:04');
INSERT INTO `mb_user` VALUES ('21', 'qqq', '28AEAE55B913CAC253D1F5E19759BD8C', '12345678913', '2443435929@qq.com', 'http://119.23.74.128/group1/M00/00/04/rBEDD1z_WemAZ-g6AAIEcnTngjo011.jpg', '2019-06-11 15:37:06', '2019-06-11 15:37:06');
INSERT INTO `mb_user` VALUES ('22', 'zqq1234', 'F214A49B968FABCE372C001D5397D9FD', '13049610340', '543246270@qq.com', 'http://119.23.74.128/group1/M00/00/04/rBEDD1z_dGuATmUTAAIEcnTngjo129.jpg', '2019-06-11 17:29:57', '2019-06-11 17:29:57');

-- ----------------------------
-- Table structure for `orderdetail`
-- ----------------------------
DROP TABLE IF EXISTS `orderdetail`;
CREATE TABLE `orderdetail` (
  `id` int(20) NOT NULL AUTO_INCREMENT COMMENT '订单子表id',
  `itemId` int(50) NOT NULL COMMENT '商品id',
  `orderId` int(50) NOT NULL COMMENT '订单id',
  `num` int(10) DEFAULT NULL COMMENT '商品购买数量',
  `itemName` varchar(60) COLLATE utf8_bin DEFAULT NULL COMMENT '商品名字',
  `price` int(50) DEFAULT NULL COMMENT '商品单价',
  PRIMARY KEY (`id`) USING BTREE,
  KEY `item_id` (`itemId`) USING BTREE,
  KEY `order_id` (`orderId`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=20 DEFAULT CHARSET=utf8 COLLATE=utf8_bin ROW_FORMAT=COMPACT;

-- ----------------------------
-- Records of orderdetail
-- ----------------------------
INSERT INTO `orderdetail` VALUES ('15', '86', '14', '2', '麦富迪 宠物狗粮 藻趣儿通用成犬粮', '289');
INSERT INTO `orderdetail` VALUES ('16', '87', '14', '2', '皇家狗粮 CC优选成犬狗粮 全价粮 8kg', '180');
INSERT INTO `orderdetail` VALUES ('17', '86', '15', '2', '麦富迪 宠物狗粮 藻趣儿通用成犬粮', '289');
INSERT INTO `orderdetail` VALUES ('18', '88', '16', '2', '麦富迪 宠物狗粮 藻趣儿通用成犬粮7.5kg', '126');
INSERT INTO `orderdetail` VALUES ('19', '86', '17', '2', '麦富迪 宠物狗粮 藻趣儿通用成犬粮', '289');

-- ----------------------------
-- Table structure for `orders`
-- ----------------------------
DROP TABLE IF EXISTS `orders`;
CREATE TABLE `orders` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '订单id',
  `orderNo` varchar(32) DEFAULT NULL COMMENT '订单号',
  `userId` int(11) DEFAULT NULL COMMENT '用户编号',
  `payment` varchar(10) DEFAULT NULL COMMENT '实付金额。精确到2位小数;单位:元。如:200.07，表示:200元7分',
  `status` int(10) DEFAULT NULL COMMENT '状态：1、未付款，2、已付款，3、未发货，4、已发货，5、交易成功，6、交易关闭',
  `createtime` datetime DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=18 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of orders
-- ----------------------------
INSERT INTO `orders` VALUES ('12', '7Xn2P4Y38735', '14', '938.00', '2', '2019-06-11 09:30:14');
INSERT INTO `orders` VALUES ('13', 'w5OD7eAOmG67', '14', '938.00', '2', '2019-06-11 10:13:04');
INSERT INTO `orders` VALUES ('14', '1ktSA0c1c679', '14', '938.00', '2', '2019-06-11 10:16:29');
INSERT INTO `orders` VALUES ('15', 'X3oQYy9fhT24', '14', '578.00', '2', '2019-06-11 14:12:12');
INSERT INTO `orders` VALUES ('16', 'yD427J243f57', '21', '252.00', '2', '2019-06-11 16:36:02');
INSERT INTO `orders` VALUES ('17', '4xdIfYFfg8Ij', '22', '578.00', '2', '2019-06-11 17:36:05');

-- ----------------------------
-- Table structure for `petAge`
-- ----------------------------
DROP TABLE IF EXISTS `petAge`;
CREATE TABLE `petAge` (
  `ageId` int(11) NOT NULL AUTO_INCREMENT COMMENT '宠物年龄表id',
  `age` varchar(32) DEFAULT NULL COMMENT '宠物年龄',
  PRIMARY KEY (`ageId`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=21 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of petAge
-- ----------------------------
INSERT INTO `petAge` VALUES ('1', '1岁');
INSERT INTO `petAge` VALUES ('2', '2岁');
INSERT INTO `petAge` VALUES ('3', '3岁');
INSERT INTO `petAge` VALUES ('4', '4岁');
INSERT INTO `petAge` VALUES ('5', '5岁');
INSERT INTO `petAge` VALUES ('6', '6岁');
INSERT INTO `petAge` VALUES ('7', '7岁');
INSERT INTO `petAge` VALUES ('8', '8岁');
INSERT INTO `petAge` VALUES ('9', '9岁');
INSERT INTO `petAge` VALUES ('10', '10岁');
INSERT INTO `petAge` VALUES ('11', '11岁');
INSERT INTO `petAge` VALUES ('12', '12岁');
INSERT INTO `petAge` VALUES ('13', '13岁');
INSERT INTO `petAge` VALUES ('14', '14岁');
INSERT INTO `petAge` VALUES ('15', '15岁');
INSERT INTO `petAge` VALUES ('16', '16岁');
INSERT INTO `petAge` VALUES ('17', '17岁');
INSERT INTO `petAge` VALUES ('18', '18岁');
INSERT INTO `petAge` VALUES ('19', '19岁');
INSERT INTO `petAge` VALUES ('20', '20岁');

-- ----------------------------
-- Table structure for `petImages`
-- ----------------------------
DROP TABLE IF EXISTS `petImages`;
CREATE TABLE `petImages` (
  `imgId` int(11) NOT NULL AUTO_INCREMENT COMMENT '宠物图片表id',
  `img` varchar(100) DEFAULT NULL COMMENT '宠物图片地址',
  `adid` int(11) DEFAULT NULL COMMENT '送养表id',
  PRIMARY KEY (`imgId`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=60 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of petImages
-- ----------------------------
INSERT INTO `petImages` VALUES ('8', 'http://119.23.74.128/group1/M00/00/03/rBEDD1z7_qOABGBCAAAoTCIjyQA546.png', '28');
INSERT INTO `petImages` VALUES ('9', 'http://119.23.74.128/group1/M00/00/03/rBEDD1z7_qOAeP9ZAAAo7Q5_Zsg199.png', '28');
INSERT INTO `petImages` VALUES ('10', 'http://119.23.74.128/group1/M00/00/03/rBEDD1z7_qOAd4ekAAAl37LiWeQ597.png', '28');
INSERT INTO `petImages` VALUES ('11', 'http://119.23.74.128/group1/M00/00/03/rBEDD1z8yXCANTYvAAAl37LiWeQ826.png', '30');
INSERT INTO `petImages` VALUES ('12', 'http://119.23.74.128/group1/M00/00/03/rBEDD1z8yXCAXcmMAAAo7Q5_Zsg030.png', '30');
INSERT INTO `petImages` VALUES ('13', 'http://119.23.74.128/group1/M00/00/03/rBEDD1z8yXCAMtkpAAAoTCIjyQA657.png', '30');
INSERT INTO `petImages` VALUES ('14', 'http://119.23.74.128/group1/M00/00/03/rBEDD1z8zzWAC_V2AAAl37LiWeQ160.png', '31');
INSERT INTO `petImages` VALUES ('15', 'http://119.23.74.128/group1/M00/00/03/rBEDD1z8zzWAPGDXAAAoTCIjyQA298.png', '31');
INSERT INTO `petImages` VALUES ('16', 'http://119.23.74.128/group1/M00/00/03/rBEDD1z8zzWAQXkNAAAo7Q5_Zsg315.png', '31');
INSERT INTO `petImages` VALUES ('17', 'http://119.23.74.128/group1/M00/00/03/rBEDD1z92aqAVC_0AAEir5pcaJs241.jpg', '38');
INSERT INTO `petImages` VALUES ('18', 'http://119.23.74.128/group1/M00/00/03/rBEDD1z92aqALyn4AADzVd5nvnw828.jpg', '38');
INSERT INTO `petImages` VALUES ('19', 'http://119.23.74.128/group1/M00/00/03/rBEDD1z92aqAUrd4AAETNUn_p28036.jpg', '38');
INSERT INTO `petImages` VALUES ('20', 'http://119.23.74.128/group1/M00/00/03/rBEDD1z92l2ABuyzAAEab_hpeCQ059.jpg', '39');
INSERT INTO `petImages` VALUES ('21', 'http://119.23.74.128/group1/M00/00/03/rBEDD1z92l2AKXdSAAGTfRqIIKg082.jpg', '39');
INSERT INTO `petImages` VALUES ('22', 'http://119.23.74.128/group1/M00/00/03/rBEDD1z92l6ACHR4AAFrZ-G0TDM711.jpg', '39');
INSERT INTO `petImages` VALUES ('23', 'http://119.23.74.128/group1/M00/00/03/rBEDD1z92vWAf17WAAF2xp7bLxM922.jpg', '40');
INSERT INTO `petImages` VALUES ('24', 'http://119.23.74.128/group1/M00/00/03/rBEDD1z92vaAaDfEAAE2WFhe7xw620.jpg', '40');
INSERT INTO `petImages` VALUES ('25', 'http://119.23.74.128/group1/M00/00/03/rBEDD1z92vaAYRu9AAOTGMOegtg172.jpg', '40');
INSERT INTO `petImages` VALUES ('26', 'http://119.23.74.128/group1/M00/00/03/rBEDD1z924uAH525AANyysaLE5Q267.jpg', '41');
INSERT INTO `petImages` VALUES ('27', 'http://119.23.74.128/group1/M00/00/03/rBEDD1z925CAUkFeAAdeow4_BBc037.jpg', '41');
INSERT INTO `petImages` VALUES ('28', 'http://119.23.74.128/group1/M00/00/03/rBEDD1z925OAK8VnAA8n--TRvq8287.jpg', '41');
INSERT INTO `petImages` VALUES ('29', 'http://119.23.74.128/group1/M00/00/03/rBEDD1z93HyAGJkOAAJJXG9Gm-s025.jpg', '42');
INSERT INTO `petImages` VALUES ('30', 'http://119.23.74.128/group1/M00/00/03/rBEDD1z93HyAGJkOAAJJXG9Gm-s025.jpg', '43');
INSERT INTO `petImages` VALUES ('31', 'http://119.23.74.128/group1/M00/00/03/rBEDD1z93HyAGJkOAAJJXG9Gm-s025.jpg', '44');
INSERT INTO `petImages` VALUES ('32', 'http://119.23.74.128/group1/M00/00/03/rBEDD1z93HyAGJkOAAJJXG9Gm-s025.jpg', '45');
INSERT INTO `petImages` VALUES ('33', 'http://119.23.74.128/group1/M00/00/03/rBEDD1z93HyAGJkOAAJJXG9Gm-s025.jpg', '46');
INSERT INTO `petImages` VALUES ('34', 'http://119.23.74.128/group1/M00/00/03/rBEDD1z93HyAGJkOAAJJXG9Gm-s025.jpg', '47');
INSERT INTO `petImages` VALUES ('35', 'http://119.23.74.128/group1/M00/00/03/rBEDD1z93HyAGJkOAAJJXG9Gm-s025.jpg', '48');
INSERT INTO `petImages` VALUES ('36', 'http://119.23.74.128/group1/M00/00/03/rBEDD1z93HyAGJkOAAJJXG9Gm-s025.jpg', '49');
INSERT INTO `petImages` VALUES ('37', 'http://119.23.74.128/group1/M00/00/03/rBEDD1z93HyAGJkOAAJJXG9Gm-s025.jpg', '50');
INSERT INTO `petImages` VALUES ('38', 'http://119.23.74.128/group1/M00/00/03/rBEDD1z93HyAGJkOAAJJXG9Gm-s025.jpg', '51');
INSERT INTO `petImages` VALUES ('39', 'http://119.23.74.128/group1/M00/00/03/rBEDD1z93HyAGJkOAAJJXG9Gm-s025.jpg', '52');
INSERT INTO `petImages` VALUES ('40', 'http://119.23.74.128/group1/M00/00/03/rBEDD1z93HyAGJkOAAJJXG9Gm-s025.jpg', '53');
INSERT INTO `petImages` VALUES ('41', 'http://119.23.74.128/group1/M00/00/03/rBEDD1z93HyAGJkOAAJJXG9Gm-s025.jpg', '54');
INSERT INTO `petImages` VALUES ('42', 'http://119.23.74.128/group1/M00/00/03/rBEDD1z93HyAGJkOAAJJXG9Gm-s025.jpg', '55');
INSERT INTO `petImages` VALUES ('43', 'http://119.23.74.128/group1/M00/00/03/rBEDD1z93HyAGJkOAAJJXG9Gm-s025.jpg', '56');
INSERT INTO `petImages` VALUES ('44', 'http://119.23.74.128/group1/M00/00/03/rBEDD1z93HyAGJkOAAJJXG9Gm-s025.jpg', '57');
INSERT INTO `petImages` VALUES ('45', 'http://119.23.74.128/group1/M00/00/03/rBEDD1z93HyAGJkOAAJJXG9Gm-s025.jpg', '58');
INSERT INTO `petImages` VALUES ('46', 'http://119.23.74.128/group1/M00/00/03/rBEDD1z93HyAGJkOAAJJXG9Gm-s025.jpg', '59');
INSERT INTO `petImages` VALUES ('47', 'http://119.23.74.128/group1/M00/00/03/rBEDD1z93HyAGJkOAAJJXG9Gm-s025.jpg', '60');
INSERT INTO `petImages` VALUES ('48', 'http://119.23.74.128/group1/M00/00/03/rBEDD1z9_smAH3SfAAFEh-7gUpo821.jpg', '61');
INSERT INTO `petImages` VALUES ('49', 'http://119.23.74.128/group1/M00/00/03/rBEDD1z-HrWAab7_AACWVknA-ng50.jpeg', '62');
INSERT INTO `petImages` VALUES ('50', 'http://119.23.74.128/group1/M00/00/03/rBEDD1z-HrWALKJBAAA-qPsHqew755.jpg', '62');
INSERT INTO `petImages` VALUES ('51', 'http://119.23.74.128/group1/M00/00/03/rBEDD1z-HrWAM6ZIAAC0hHhWy1E98.jpeg', '62');
INSERT INTO `petImages` VALUES ('52', 'http://119.23.74.128/group1/M00/00/03/rBEDD1z-IH2ASLLpAAA15d5ihBU216.jpg', '64');
INSERT INTO `petImages` VALUES ('53', 'http://119.23.74.128/group1/M00/00/03/rBEDD1z-IH2ASGH_AAC0hHhWy1E35.jpeg', '64');
INSERT INTO `petImages` VALUES ('54', 'http://119.23.74.128/group1/M00/00/03/rBEDD1z-IWSAG-YiAAAKan2OEqA334.jpg', '65');
INSERT INTO `petImages` VALUES ('55', 'http://119.23.74.128/group1/M00/00/03/rBEDD1z-IWSANJXQAAAKnZIYMxg397.jpg', '65');
INSERT INTO `petImages` VALUES ('56', 'http://119.23.74.128/group1/M00/00/03/rBEDD1z-IWSAWQBaAAAJTbrIp3g195.jpg', '65');
INSERT INTO `petImages` VALUES ('57', 'http://119.23.74.128/group1/M00/00/04/rBEDD1z_OUuAFOZZAAIEcnTngjo758.jpg', '66');
INSERT INTO `petImages` VALUES ('58', 'http://119.23.74.128/group1/M00/00/04/rBEDD1z_OUuAV37BAAEnzotGanE986.jpg', '66');
INSERT INTO `petImages` VALUES ('59', 'http://119.23.74.128/group1/M00/00/04/rBEDD1z_OUuATHv7AAEy0GFLsoo519.jpg', '66');

-- ----------------------------
-- Table structure for `relationship`
-- ----------------------------
DROP TABLE IF EXISTS `relationship`;
CREATE TABLE `relationship` (
  `reId` int(11) NOT NULL AUTO_INCREMENT COMMENT '关系表id',
  `acId` int(11) DEFAULT NULL COMMENT '领养条件表id',
  `adid` int(11) DEFAULT NULL COMMENT '送养表id',
  PRIMARY KEY (`reId`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=92 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of relationship
-- ----------------------------
INSERT INTO `relationship` VALUES ('42', '1', '28');
INSERT INTO `relationship` VALUES ('43', '2', '28');
INSERT INTO `relationship` VALUES ('44', '3', '28');
INSERT INTO `relationship` VALUES ('45', '4', '28');
INSERT INTO `relationship` VALUES ('46', '5', '28');
INSERT INTO `relationship` VALUES ('47', '1', '30');
INSERT INTO `relationship` VALUES ('48', '2', '30');
INSERT INTO `relationship` VALUES ('49', '3', '30');
INSERT INTO `relationship` VALUES ('50', '4', '30');
INSERT INTO `relationship` VALUES ('51', '5', '30');
INSERT INTO `relationship` VALUES ('52', '1', '31');
INSERT INTO `relationship` VALUES ('53', '2', '31');
INSERT INTO `relationship` VALUES ('54', '4', '31');
INSERT INTO `relationship` VALUES ('55', '5', '31');
INSERT INTO `relationship` VALUES ('56', '3', '31');
INSERT INTO `relationship` VALUES ('57', '1', '38');
INSERT INTO `relationship` VALUES ('58', '2', '38');
INSERT INTO `relationship` VALUES ('59', '3', '38');
INSERT INTO `relationship` VALUES ('60', '5', '38');
INSERT INTO `relationship` VALUES ('61', '4', '38');
INSERT INTO `relationship` VALUES ('62', '1', '39');
INSERT INTO `relationship` VALUES ('63', '3', '39');
INSERT INTO `relationship` VALUES ('64', '2', '39');
INSERT INTO `relationship` VALUES ('65', '4', '39');
INSERT INTO `relationship` VALUES ('66', '5', '39');
INSERT INTO `relationship` VALUES ('67', '1', '40');
INSERT INTO `relationship` VALUES ('68', '4', '40');
INSERT INTO `relationship` VALUES ('69', '3', '40');
INSERT INTO `relationship` VALUES ('70', '2', '40');
INSERT INTO `relationship` VALUES ('71', '5', '40');
INSERT INTO `relationship` VALUES ('72', '1', '41');
INSERT INTO `relationship` VALUES ('73', '2', '41');
INSERT INTO `relationship` VALUES ('74', '4', '41');
INSERT INTO `relationship` VALUES ('75', '3', '41');
INSERT INTO `relationship` VALUES ('76', '5', '41');
INSERT INTO `relationship` VALUES ('77', '1', '62');
INSERT INTO `relationship` VALUES ('78', '2', '62');
INSERT INTO `relationship` VALUES ('79', '3', '62');
INSERT INTO `relationship` VALUES ('80', '4', '62');
INSERT INTO `relationship` VALUES ('81', '5', '62');
INSERT INTO `relationship` VALUES ('82', '1', '65');
INSERT INTO `relationship` VALUES ('83', '2', '65');
INSERT INTO `relationship` VALUES ('84', '3', '65');
INSERT INTO `relationship` VALUES ('85', '4', '65');
INSERT INTO `relationship` VALUES ('86', '5', '65');
INSERT INTO `relationship` VALUES ('87', '1', '66');
INSERT INTO `relationship` VALUES ('88', '2', '66');
INSERT INTO `relationship` VALUES ('89', '3', '66');
INSERT INTO `relationship` VALUES ('90', '5', '66');
INSERT INTO `relationship` VALUES ('91', '4', '66');

-- ----------------------------
-- Table structure for `wareimg`
-- ----------------------------
DROP TABLE IF EXISTS `wareimg`;
CREATE TABLE `wareimg` (
  `lid` int(11) NOT NULL AUTO_INCREMENT,
  `limg` varchar(100) DEFAULT NULL,
  `wareid` int(11) DEFAULT NULL,
  PRIMARY KEY (`lid`)
) ENGINE=InnoDB AUTO_INCREMENT=181 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of wareimg
-- ----------------------------
INSERT INTO `wareimg` VALUES ('106', 'http://119.23.74.128/group1/M00/00/03/rBEDD1z-YQ6ANrFWAAAKnZIYMxg120.jpg', '85');
INSERT INTO `wareimg` VALUES ('107', 'http://119.23.74.128/group1/M00/00/03/rBEDD1z-YQ6AeNiyAAAJTbrIp3g104.jpg', '85');
INSERT INTO `wareimg` VALUES ('108', 'http://119.23.74.128/group1/M00/00/03/rBEDD1z-YQ-AHiMnAAAKan2OEqA100.jpg', '85');
INSERT INTO `wareimg` VALUES ('109', 'http://119.23.74.128/group1/M00/00/03/rBEDD1z-bYKASjPFAAAKny4ylLo958.jpg', '86');
INSERT INTO `wareimg` VALUES ('110', 'http://119.23.74.128/group1/M00/00/03/rBEDD1z-bYOAIi1KAAAQSx5lhP0798.jpg', '86');
INSERT INTO `wareimg` VALUES ('111', 'http://119.23.74.128/group1/M00/00/03/rBEDD1z-bYOAcKj1AAARzMDj64c182.jpg', '86');
INSERT INTO `wareimg` VALUES ('112', 'http://119.23.74.128/group1/M00/00/03/rBEDD1z-bhyAVkMBAAAKoZgVL58761.jpg', '87');
INSERT INTO `wareimg` VALUES ('113', 'http://119.23.74.128/group1/M00/00/03/rBEDD1z-bhyACBvYAAAKNPQYAIg768.jpg', '87');
INSERT INTO `wareimg` VALUES ('114', 'http://119.23.74.128/group1/M00/00/03/rBEDD1z-bhyAJcaWAAAMf0eCOxI902.jpg', '87');
INSERT INTO `wareimg` VALUES ('115', 'http://119.23.74.128/group1/M00/00/03/rBEDD1z-brCAdy6hAAAKny4ylLo239.jpg', '88');
INSERT INTO `wareimg` VALUES ('116', 'http://119.23.74.128/group1/M00/00/03/rBEDD1z-brCAb8E_AAAR7EomtNI144.jpg', '88');
INSERT INTO `wareimg` VALUES ('117', 'http://119.23.74.128/group1/M00/00/03/rBEDD1z-brGAd1AgAAARo6YwOjs436.jpg', '88');
INSERT INTO `wareimg` VALUES ('118', 'http://119.23.74.128/group1/M00/00/03/rBEDD1z-bzWAcJqOAAAKzH5DOZw337.jpg', '89');
INSERT INTO `wareimg` VALUES ('119', 'http://119.23.74.128/group1/M00/00/03/rBEDD1z-bzWAKhs1AAAMMAV63hY098.jpg', '89');
INSERT INTO `wareimg` VALUES ('120', 'http://119.23.74.128/group1/M00/00/04/rBEDD1z-bzWAE51QAAANWZ4X29E297.jpg', '89');
INSERT INTO `wareimg` VALUES ('121', 'http://119.23.74.128/group1/M00/00/04/rBEDD1z-b5uAYRszAAAEN1oU3Ew916.jpg', '90');
INSERT INTO `wareimg` VALUES ('122', 'http://119.23.74.128/group1/M00/00/04/rBEDD1z-b5yAMALEAAAF_eSSobs396.jpg', '90');
INSERT INTO `wareimg` VALUES ('123', 'http://119.23.74.128/group1/M00/00/04/rBEDD1z-b5yAYAdDAAAJ00Dvaec094.jpg', '90');
INSERT INTO `wareimg` VALUES ('124', 'http://119.23.74.128/group1/M00/00/04/rBEDD1z-b-uAHC3SAAAGD3kvG1g515.jpg', '91');
INSERT INTO `wareimg` VALUES ('125', 'http://119.23.74.128/group1/M00/00/04/rBEDD1z-b-uARYmZAAAJdPHsX2g772.jpg', '91');
INSERT INTO `wareimg` VALUES ('126', 'http://119.23.74.128/group1/M00/00/04/rBEDD1z-b-uARoW4AAAM6yO6zuc794.jpg', '91');
INSERT INTO `wareimg` VALUES ('127', 'http://119.23.74.128/group1/M00/00/04/rBEDD1z--B2AMjzGAAASHqsBcBc669.jpg', '92');
INSERT INTO `wareimg` VALUES ('128', 'http://119.23.74.128/group1/M00/00/04/rBEDD1z--B2AD8oyAAAQCj5vMcs474.jpg', '92');
INSERT INTO `wareimg` VALUES ('129', 'http://119.23.74.128/group1/M00/00/04/rBEDD1z--B2AMTUxAAAQkEvohMc508.jpg', '92');
INSERT INTO `wareimg` VALUES ('130', 'http://119.23.74.128/group1/M00/00/04/rBEDD1z--GaAJPlWAAAIgC78rAA310.jpg', '93');
INSERT INTO `wareimg` VALUES ('131', 'http://119.23.74.128/group1/M00/00/04/rBEDD1z--GaAebs1AAAWPgvScNU939.jpg', '93');
INSERT INTO `wareimg` VALUES ('132', 'http://119.23.74.128/group1/M00/00/04/rBEDD1z--GaAFV_mAAARTcp8CGU339.jpg', '93');
INSERT INTO `wareimg` VALUES ('133', 'http://119.23.74.128/group1/M00/00/04/rBEDD1z--L-ASiY7AAAN1xufJsQ812.jpg', '94');
INSERT INTO `wareimg` VALUES ('134', 'http://119.23.74.128/group1/M00/00/04/rBEDD1z--L-ARjPtAAATAwKxmQY857.jpg', '94');
INSERT INTO `wareimg` VALUES ('135', 'http://119.23.74.128/group1/M00/00/04/rBEDD1z--L-AIIFYAAARCyHT1XQ902.jpg', '94');
INSERT INTO `wareimg` VALUES ('136', 'http://119.23.74.128/group1/M00/00/04/rBEDD1z--TiACYvmAAAVwUHGT6I062.jpg', '95');
INSERT INTO `wareimg` VALUES ('137', 'http://119.23.74.128/group1/M00/00/04/rBEDD1z--TiAJeLFAAATfQe_v58233.jpg', '95');
INSERT INTO `wareimg` VALUES ('138', 'http://119.23.74.128/group1/M00/00/04/rBEDD1z--TiAUKWkAAAPeobbcGY750.jpg', '95');
INSERT INTO `wareimg` VALUES ('139', 'http://119.23.74.128/group1/M00/00/04/rBEDD1z--YmASCjGAAAKv1q8fPw877.jpg', '96');
INSERT INTO `wareimg` VALUES ('140', 'http://119.23.74.128/group1/M00/00/04/rBEDD1z--YqAP8FhAAAHNV6QS7o734.jpg', '96');
INSERT INTO `wareimg` VALUES ('141', 'http://119.23.74.128/group1/M00/00/04/rBEDD1z--YqAMzH5AAAHI4TOpAc848.jpg', '96');
INSERT INTO `wareimg` VALUES ('142', 'http://119.23.74.128/group1/M00/00/04/rBEDD1z--c6ARVkHAAALFsALBjI062.jpg', '97');
INSERT INTO `wareimg` VALUES ('143', 'http://119.23.74.128/group1/M00/00/04/rBEDD1z--c6ABvGfAAAIKKzPGlo464.jpg', '97');
INSERT INTO `wareimg` VALUES ('144', 'http://119.23.74.128/group1/M00/00/04/rBEDD1z--c-AQ05UAAAJdT_Ck7M669.jpg', '97');
INSERT INTO `wareimg` VALUES ('145', 'http://119.23.74.128/group1/M00/00/04/rBEDD1z--jeAZwlMAAAMmLFLIf0897.jpg', '98');
INSERT INTO `wareimg` VALUES ('146', 'http://119.23.74.128/group1/M00/00/04/rBEDD1z--jeAKZOQAAANlXSdPO4584.jpg', '98');
INSERT INTO `wareimg` VALUES ('147', 'http://119.23.74.128/group1/M00/00/04/rBEDD1z--jeAHwRMAAAG2MYT5eU205.jpg', '98');
INSERT INTO `wareimg` VALUES ('148', 'http://119.23.74.128/group1/M00/00/04/rBEDD1z--pmAMmFxAAALpboYAlQ391.jpg', '99');
INSERT INTO `wareimg` VALUES ('149', 'http://119.23.74.128/group1/M00/00/04/rBEDD1z--pmAO-q9AAALAWkXlhQ015.jpg', '99');
INSERT INTO `wareimg` VALUES ('150', 'http://119.23.74.128/group1/M00/00/04/rBEDD1z--pmAHz9oAAAJQVHDeog337.jpg', '99');
INSERT INTO `wareimg` VALUES ('151', 'http://119.23.74.128/group1/M00/00/04/rBEDD1z--v-AP2ytAAAHpj9UtiU125.jpg', '100');
INSERT INTO `wareimg` VALUES ('152', 'http://119.23.74.128/group1/M00/00/04/rBEDD1z--v-Ad9fWAAAOkx7UUHU486.jpg', '100');
INSERT INTO `wareimg` VALUES ('153', 'http://119.23.74.128/group1/M00/00/04/rBEDD1z--wCAbuwTAAAHkHAjF0A451.jpg', '100');
INSERT INTO `wareimg` VALUES ('154', 'http://119.23.74.128/group1/M00/00/04/rBEDD1z--3SANFgMAAAH8v6s2ZY546.jpg', '101');
INSERT INTO `wareimg` VALUES ('155', 'http://119.23.74.128/group1/M00/00/04/rBEDD1z--3SANol_AAAKrFZz6Vs775.jpg', '101');
INSERT INTO `wareimg` VALUES ('156', 'http://119.23.74.128/group1/M00/00/04/rBEDD1z--3SASePXAAAIBqvBhOw294.jpg', '101');
INSERT INTO `wareimg` VALUES ('157', 'http://119.23.74.128/group1/M00/00/04/rBEDD1z--8mAZ5toAAAJqez7hjU408.jpg', '102');
INSERT INTO `wareimg` VALUES ('158', 'http://119.23.74.128/group1/M00/00/04/rBEDD1z--8mASGcVAAADtM0KXHo256.jpg', '102');
INSERT INTO `wareimg` VALUES ('159', 'http://119.23.74.128/group1/M00/00/04/rBEDD1z--8mAMGzXAAANI14UYME964.jpg', '102');
INSERT INTO `wareimg` VALUES ('160', 'http://119.23.74.128/group1/M00/00/04/rBEDD1z-_C-AcpsaAAAJCGxN1q8846.jpg', '103');
INSERT INTO `wareimg` VALUES ('161', 'http://119.23.74.128/group1/M00/00/04/rBEDD1z-_DCAJL-lAAAJJWJ2Ubw624.jpg', '103');
INSERT INTO `wareimg` VALUES ('162', 'http://119.23.74.128/group1/M00/00/04/rBEDD1z-_DCACB2oAAAKAG42sdk250.jpg', '103');
INSERT INTO `wareimg` VALUES ('163', 'http://119.23.74.128/group1/M00/00/04/rBEDD1z-_J6AP1X2AAAJHUo3QSg296.jpg', '104');
INSERT INTO `wareimg` VALUES ('164', 'http://119.23.74.128/group1/M00/00/04/rBEDD1z-_J6AAOALAAAK7Py7EKU924.jpg', '104');
INSERT INTO `wareimg` VALUES ('165', 'http://119.23.74.128/group1/M00/00/04/rBEDD1z-_J6AXzMlAAAKrJ7wMQk366.jpg', '104');
INSERT INTO `wareimg` VALUES ('166', 'http://119.23.74.128/group1/M00/00/04/rBEDD1z-_RCALiKHAAATTlfMDhM578.jpg', '105');
INSERT INTO `wareimg` VALUES ('167', 'http://119.23.74.128/group1/M00/00/04/rBEDD1z-_RCAMkT1AAAPBshlsms026.jpg', '105');
INSERT INTO `wareimg` VALUES ('168', 'http://119.23.74.128/group1/M00/00/04/rBEDD1z-_RCAX2WVAAAWHST95ZA252.jpg', '105');
INSERT INTO `wareimg` VALUES ('169', 'http://119.23.74.128/group1/M00/00/04/rBEDD1z-_V-AD2IuAAAGa8iLesU737.jpg', '106');
INSERT INTO `wareimg` VALUES ('170', 'http://119.23.74.128/group1/M00/00/04/rBEDD1z-_V-AIkv0AAAF6S49mRY312.jpg', '106');
INSERT INTO `wareimg` VALUES ('171', 'http://119.23.74.128/group1/M00/00/04/rBEDD1z-_V-AB81aAAAFBnDLelA672.jpg', '106');
INSERT INTO `wareimg` VALUES ('172', 'http://119.23.74.128/group1/M00/00/04/rBEDD1z-_cSAG4JmAAASOPn4F8k573.jpg', '107');
INSERT INTO `wareimg` VALUES ('173', 'http://119.23.74.128/group1/M00/00/04/rBEDD1z-_cSAJDA_AAAJOytSih0422.jpg', '107');
INSERT INTO `wareimg` VALUES ('174', 'http://119.23.74.128/group1/M00/00/04/rBEDD1z-_cSAKmnVAAALlRFrFkA290.jpg', '107');
INSERT INTO `wareimg` VALUES ('175', 'http://119.23.74.128/group1/M00/00/04/rBEDD1z-_hSAJNiyAAAFdHC9xpQ659.jpg', '108');
INSERT INTO `wareimg` VALUES ('176', 'http://119.23.74.128/group1/M00/00/04/rBEDD1z-_hSACwJwAAAHXK0l-S8328.jpg', '108');
INSERT INTO `wareimg` VALUES ('177', 'http://119.23.74.128/group1/M00/00/04/rBEDD1z-_hSASC63AAAGmsDxtIw724.jpg', '108');
INSERT INTO `wareimg` VALUES ('178', 'http://119.23.74.128/group1/M00/00/04/rBEDD1z-_oWAdZMQAAAKPk_qJ7A795.jpg', '109');
INSERT INTO `wareimg` VALUES ('179', 'http://119.23.74.128/group1/M00/00/04/rBEDD1z-_oWAUdACAAAQKNw9CN0686.jpg', '109');
INSERT INTO `wareimg` VALUES ('180', 'http://119.23.74.128/group1/M00/00/04/rBEDD1z-_oWAHLx4AAAL-hQHyyk444.jpg', '109');

-- ----------------------------
-- View structure for `v2`
-- ----------------------------
DROP VIEW IF EXISTS `v2`;
CREATE ALGORITHM=UNDEFINED DEFINER=`root`@`%` SQL SECURITY DEFINER VIEW `v2` AS select `o`.`orderNo` AS `orderNo`,`o`.`userId` AS `userId`,`od`.`id` AS `id`,`od`.`itemId` AS `itemId`,`od`.`orderId` AS `orderId`,`od`.`num` AS `num`,`od`.`itemName` AS `itemName`,`od`.`price` AS `price`,`i`.`limg` AS `limg` from (((`orders` `o` join `orderdetail` `od`) join `items` `t`) join `wareimg` `i`) where ((`o`.`id` = `od`.`orderId`) and (`od`.`itemId` = `t`.`wareid`) and (`t`.`wareid` = `i`.`wareid`));
