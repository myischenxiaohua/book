/*
 Navicat Premium Data Transfer

 Source Server         : 本地
 Source Server Type    : MySQL
 Source Server Version : 50724
 Source Host           : localhost:3306
 Source Schema         : book

 Target Server Type    : MySQL
 Target Server Version : 50724
 File Encoding         : 65001

 Date: 24/01/2019 16:20:47
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for T_ADMIN
-- ----------------------------
DROP TABLE IF EXISTS `T_ADMIN`;
CREATE TABLE `T_ADMIN`  (
  `id` int(10) UNSIGNED NOT NULL AUTO_INCREMENT COMMENT '编号',
  `name` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '名称',
  `password` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '密码',
  `lastdate` datetime(0) DEFAULT NULL,
  `flag` tinyint(1) DEFAULT NULL COMMENT '管理员标识,0非超级管理员，1 超级管理员',
  `phone` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '电话',
  `status` tinyint(1) DEFAULT 1 COMMENT '状态，1启用，0禁用',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 7 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of T_ADMIN
-- ----------------------------
INSERT INTO `T_ADMIN` VALUES (3, 'cxh', '1193529BAB705B6E6C76DF175D7CCCD3', '2019-01-24 15:38:51', 1, '', 1);
INSERT INTO `T_ADMIN` VALUES (6, 'zs', 'CDC6D1963928D5C349A4EEBF11C8B4A5', '2019-01-22 08:56:13', 0, '15923472069', 1);

-- ----------------------------
-- Table structure for T_BOOKCASE
-- ----------------------------
DROP TABLE IF EXISTS `T_BOOKCASE`;
CREATE TABLE `T_BOOKCASE`  (
  `id` int(11) UNSIGNED NOT NULL AUTO_INCREMENT COMMENT '书架编号',
  `name` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '书架名称',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 3 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of T_BOOKCASE
-- ----------------------------
INSERT INTO `T_BOOKCASE` VALUES (1, '1-1-1');
INSERT INTO `T_BOOKCASE` VALUES (2, '1-1-2');

-- ----------------------------
-- Table structure for T_BOOKS
-- ----------------------------
DROP TABLE IF EXISTS `T_BOOKS`;
CREATE TABLE `T_BOOKS`  (
  `isbn` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '图书编号',
  `category_id` int(11) DEFAULT NULL COMMENT '分类，外键。引用T_BOOK_CATEGORY的id',
  `admin_id` int(11) DEFAULT NULL COMMENT '管理员，外键。引用T_ADMIN的id',
  `name` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '书名',
  `author` varchar(30) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '作者',
  `publish` varchar(30) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '出版社',
  `edition` int(11) DEFAULT NULL COMMENT '版次',
  `publishdate` datetime(0) DEFAULT NULL COMMENT '出版日期',
  `unitprice` decimal(10, 0) DEFAULT NULL COMMENT '单价',
  `credate` datetime(0) DEFAULT NULL COMMENT '创建时间',
  `extant` int(6) DEFAULT NULL COMMENT '现存量',
  `inventory` int(6) DEFAULT NULL COMMENT '总库存量',
  `bookcase_id` int(11) DEFAULT NULL COMMENT '书架编号，引用T_BOOKCASE的id',
  `remark` text CHARACTER SET utf8 COLLATE utf8_general_ci COMMENT '备注',
  PRIMARY KEY (`isbn`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of T_BOOKS
-- ----------------------------
INSERT INTO `T_BOOKS` VALUES ('96e5a6f0-2d06-4bbd-ba5c-e7ed23f54f66', 1, 3, 'java基础', '张三丰', '北大青鸟出版社', 1, NULL, 10, NULL, 0, 200, 1, NULL);
INSERT INTO `T_BOOKS` VALUES ('b91a5f20-5cff-4a20-8f11-1428a4eca17e', 1, 3, 'jsp', '张四丰', '重庆出版社', 2, NULL, 10, NULL, 0, 200, 1, NULL);

-- ----------------------------
-- Table structure for T_BOOK_CATEGORY
-- ----------------------------
DROP TABLE IF EXISTS `T_BOOK_CATEGORY`;
CREATE TABLE `T_BOOK_CATEGORY`  (
  `id` int(10) UNSIGNED NOT NULL AUTO_INCREMENT COMMENT '书籍分类编号、主键',
  `pid` int(11) DEFAULT NULL COMMENT '父节点',
  `name` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '书籍分类名称',
  `fine` decimal(10, 0) DEFAULT NULL COMMENT '罚金',
  `remark` text CHARACTER SET utf8 COLLATE utf8_general_ci COMMENT '备注',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 4 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of T_BOOK_CATEGORY
-- ----------------------------
INSERT INTO `T_BOOK_CATEGORY` VALUES (1, NULL, '计算机', 10, NULL);
INSERT INTO `T_BOOK_CATEGORY` VALUES (2, NULL, '文学', NULL, NULL);
INSERT INTO `T_BOOK_CATEGORY` VALUES (3, NULL, '农业', NULL, NULL);

-- ----------------------------
-- Table structure for T_CANCEL
-- ----------------------------
DROP TABLE IF EXISTS `T_CANCEL`;
CREATE TABLE `T_CANCEL`  (
  `id` int(10) UNSIGNED NOT NULL AUTO_INCREMENT COMMENT '编号',
  `books_isbn` char(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '图书编号',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for T_FINE
-- ----------------------------
DROP TABLE IF EXISTS `T_FINE`;
CREATE TABLE `T_FINE`  (
  `id` int(11) NOT NULL COMMENT '罚款编号',
  `reader_id` int(11) DEFAULT NULL COMMENT '用户编号',
  `books_isbn` char(15) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '图书编号',
  `money` float(255, 0) DEFAULT NULL COMMENT '罚款金额',
  `credate` datetime(0) DEFAULT NULL COMMENT '罚款时间',
  `status` smallint(255) DEFAULT NULL COMMENT '状态',
  `remark` text CHARACTER SET utf8 COLLATE utf8_general_ci COMMENT '备注',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for T_GIVEBACK
-- ----------------------------
DROP TABLE IF EXISTS `T_GIVEBACK`;
CREATE TABLE `T_GIVEBACK`  (
  `id` int(11) NOT NULL COMMENT '还书编号',
  `reader_id` int(11) DEFAULT NULL COMMENT '用户编号',
  `books_isbn` char(15) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '图书编号',
  `backtime` datetime(0) DEFAULT NULL COMMENT '归还时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for T_LEND_BOOK
-- ----------------------------
DROP TABLE IF EXISTS `T_LEND_BOOK`;
CREATE TABLE `T_LEND_BOOK`  (
  `id` int(11) NOT NULL COMMENT '借书编号',
  `reader_id` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '读者id，外键，引用T_READER表的id',
  `books_isbn` char(15) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '图书id，外键，引用T_BOOKS表的isbn',
  `credate` datetime(0) DEFAULT NULL COMMENT '借出时间',
  `retdate` datetime(0) DEFAULT NULL COMMENT '应还时间',
  `renew_number` int(11) DEFAULT NULL COMMENT '续借次数',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for T_LOST
-- ----------------------------
DROP TABLE IF EXISTS `T_LOST`;
CREATE TABLE `T_LOST`  (
  `id` int(10) UNSIGNED NOT NULL AUTO_INCREMENT COMMENT '编号',
  `isbn` char(15) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '图书id',
  `indemnify` decimal(10, 0) DEFAULT NULL COMMENT '偿还金额',
  `createTime` datetime(0) DEFAULT NULL COMMENT '创建时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for T_READER
-- ----------------------------
DROP TABLE IF EXISTS `T_READER`;
CREATE TABLE `T_READER`  (
  `id` int(10) UNSIGNED NOT NULL AUTO_INCREMENT COMMENT '读者编号',
  `name` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '读者名称',
  `age` int(11) NOT NULL COMMENT '年龄',
  `card` char(20) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '身份证',
  `sex` smallint(2) DEFAULT NULL COMMENT '性别0男，1女',
  `phone` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '电话',
  `violation_no` int(11) UNSIGNED ZEROFILL DEFAULT 00000000000 COMMENT '违规次数',
  `borrow_book_number` int(11) UNSIGNED ZEROFILL DEFAULT 00000000000 COMMENT '借书数量',
  `createDate` datetime(0) DEFAULT NULL COMMENT '注册时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 3 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '读者' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of T_READER
-- ----------------------------
INSERT INTO `T_READER` VALUES (1, '陈晓华', 28, '500234199008153736', 0, '15923472069', 00000000000, 00000000000, NULL);
INSERT INTO `T_READER` VALUES (2, '刘明', 30, '500234199008153739', 0, '1578456788', 00000000000, 00000000000, NULL);

-- ----------------------------
-- Table structure for T_READER_TYPE
-- ----------------------------
DROP TABLE IF EXISTS `T_READER_TYPE`;
CREATE TABLE `T_READER_TYPE`  (
  `id` int(11) UNSIGNED NOT NULL AUTO_INCREMENT COMMENT '编号',
  `name` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '名称',
  `pid` int(11) DEFAULT NULL COMMENT '父节点',
  `reader_id` char(15) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '读者编号',
  `number` int(11) DEFAULT NULL COMMENT '可借数量',
  `available` int(11) DEFAULT NULL COMMENT '可借天数',
  `renew_number` int(11) DEFAULT NULL COMMENT '续借次数',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

SET FOREIGN_KEY_CHECKS = 1;
