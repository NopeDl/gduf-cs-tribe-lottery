/*
 Navicat Premium Data Transfer

 Source Server         : mysql02
 Source Server Type    : MySQL
 Source Server Version : 80021
 Source Host           : 47.101.10.168:3307
 Source Schema         : lottery

 Target Server Type    : MySQL
 Target Server Version : 80021
 File Encoding         : 65001

 Date: 19/03/2021 14:21:01
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for log
-- ----------------------------
DROP TABLE IF EXISTS `log`;
CREATE TABLE `log`  (
  `lid` int(0) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `uid` int(0) NULL DEFAULT NULL COMMENT '用户id',
  `pid` int(0) NULL DEFAULT NULL COMMENT '奖品id',
  `operateTime` timestamp(0) NOT NULL DEFAULT CURRENT_TIMESTAMP(0) COMMENT '操作时间',
  `phoneNumber` varchar(11) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '电话号码',
  PRIMARY KEY (`lid`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Table structure for prize
-- ----------------------------
DROP TABLE IF EXISTS `prize`;
CREATE TABLE `prize`  (
  `pid` int(0) NOT NULL AUTO_INCREMENT COMMENT '奖品id',
  `pgrade` int(0) NULL DEFAULT NULL COMMENT '奖品等级',
  `pcount` int(0) NULL DEFAULT NULL COMMENT '奖品数量',
  `pdescription` text CHARACTER SET utf8 COLLATE utf8_general_ci NULL COMMENT '奖品描述',
  `pname` varchar(12) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '奖品名',
  `pweight` double NULL DEFAULT NULL COMMENT '奖品权重',
  PRIMARY KEY (`pid`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 4 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of prize
-- ----------------------------
INSERT INTO `prize` VALUES (1, 1, 1, '一等奖', '一等奖', 0.08);
INSERT INTO `prize` VALUES (2, 2, 2, '二等奖', '二等奖', 0.12);
INSERT INTO `prize` VALUES (3, 3, 20, '三等奖', '三等奖', 0.2);
INSERT INTO `prize` VALUES (4, 4, 3000, '谢谢惠顾', '四等奖', 0.6);

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user`  (
  `uid` int(0) NOT NULL AUTO_INCREMENT COMMENT '用户id',
  `uname` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '用户名',
  `ugender` int(0) NULL DEFAULT NULL COMMENT '用户性别',
  `uip` varchar(18) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '用户的IP地址',
  `status` int(0) NULL DEFAULT NULL COMMENT '用户状态',
  `loginStatus` int(0) NULL DEFAULT NULL COMMENT '登录状态',
  PRIMARY KEY (`uid`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES (1, '111', 1, '111111', 11, 1);

SET FOREIGN_KEY_CHECKS = 1;
