/*
Navicat MySQL Data Transfer

Source Server         : mysql
Source Server Version : 80011
Source Host           : localhost:3306
Source Database       : demo

Target Server Type    : MYSQL
Target Server Version : 80011
File Encoding         : 65001

Date: 2020-09-23 18:43:42
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(40) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `email` varchar(40) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `username` varchar(40) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `password` varchar(40) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `createDate` timestamp NULL DEFAULT NULL,
  `address` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES ('1', '王者归来', '287664409@qq.com', 'admin', '123456', '2020-09-21 00:00:00', '北京市通州区商通大道1号');
INSERT INTO `user` VALUES ('2', '小罗', '', 'tiger', '123456', '2020-09-22 00:00:00', '上海市普陀区金沙江路 1518');
INSERT INTO `user` VALUES ('3', '福山润', '', 'tiger', '123456', '2020-09-23 00:00:00', '上海市普陀区金沙江路 1518');
INSERT INTO `user` VALUES ('4', '莲花池', null, 'tiger', null, '2020-09-23 00:00:00', '上海市普陀区金沙江路 1518');
INSERT INTO `user` VALUES ('5', '乔峰', null, 'tiger', null, '2020-09-23 00:00:00', '上海市普陀区金沙江路 1518');
INSERT INTO `user` VALUES ('6', '王小虎', null, 'tiger', null, '2020-09-23 00:00:00', '上海市普陀区金沙江路 1518');
INSERT INTO `user` VALUES ('7', '王小虎', null, 'tiger', null, '2020-09-23 00:00:00', '上海市普陀区金沙江路 1518');
INSERT INTO `user` VALUES ('8', '王小虎', null, 'tiger', null, '2020-09-23 00:00:00', '上海市普陀区金沙江路 1518');
INSERT INTO `user` VALUES ('9', '王小虎', null, 'tiger', null, '2020-09-23 00:00:00', '上海市普陀区金沙江路 1518');
INSERT INTO `user` VALUES ('10', '王小虎', null, 'tiger', null, '2020-09-23 00:00:00', '上海市普陀区金沙江路 1518');
INSERT INTO `user` VALUES ('11', '王小虎', null, 'tiger', null, '2020-09-23 00:00:00', '上海市普陀区金沙江路 1518');
INSERT INTO `user` VALUES ('12', '王小虎', null, 'tiger', null, '2020-09-23 00:00:00', '上海市普陀区金沙江路 1518');
