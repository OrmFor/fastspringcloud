/*
 Navicat Premium Data Transfer

 Source Server         : localhost_3306
 Source Server Type    : MySQL
 Source Server Version : 50724
 Source Host           : localhost:3306
 Source Schema         : test

 Target Server Type    : MySQL
 Target Server Version : 50724
 File Encoding         : 65001

 Date: 28/08/2020 10:47:12
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for gateway_define
-- ----------------------------
DROP TABLE IF EXISTS `gateway_define`;
CREATE TABLE `gateway_define`  (
  `id` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NOT NULL,
  `uri` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NULL DEFAULT NULL,
  `predicates` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NULL DEFAULT NULL,
  `filters` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NULL DEFAULT NULL,
  `time` datetime(0) NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_bin ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of gateway_define
-- ----------------------------
INSERT INTO `gateway_define` VALUES ('cloudpath', 'lb://cloud-business-service', '[{\"args\":{\"pattern\":\"/admin/wxConfig/**\"},\"name\":\"Path\"}]', '[{\"args\":{\"_genkey_0\":\"1\"},\"name\":\"StripPrefix\"}]', '2020-08-25 09:09:21');
INSERT INTO `gateway_define` VALUES ('cloudpath2', 'lb://nacos-feign-sentinel-consumer', '[{\"args\":{\"pattern\":\"/api/**\"},\"name\":\"Path\"}]', '[{\"args\":{\"_genkey_0\":\"1\"},\"name\":\"StripPrefix\"}]', '2020-08-28 10:21:31');

-- ----------------------------
-- Table structure for rabbitconfig
-- ----------------------------
DROP TABLE IF EXISTS `rabbitconfig`;
CREATE TABLE `rabbitconfig`  (
  `id` int(32) NOT NULL AUTO_INCREMENT,
  `rabbitmq_host` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `rabbitmq_port` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `rabbitmq_user_name` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `rabbitmq_password` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `yqs_host` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `yqs_userId` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `appId` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `yqs_secret` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `rabbitmq_queue_name` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `rabbitmq_virtual_host` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `status` tinyint(1) NULL DEFAULT 1 COMMENT '状态',
  `group` tinyint(1) NULL DEFAULT NULL COMMENT '分组',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 21076 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;


-- ----------------------------
-- Table structure for wx_config
-- ----------------------------
DROP TABLE IF EXISTS `wx_config`;
CREATE TABLE `wx_config`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `mch_id` varchar(255) CHARACTER SET latin1 COLLATE latin1_swedish_ci NOT NULL COMMENT '商户id',
  `key` varchar(255) CHARACTER SET latin1 COLLATE latin1_swedish_ci NOT NULL,
  `cert_string` text CHARACTER SET latin1 COLLATE latin1_swedish_ci NULL COMMENT '流',
  `app_id` varchar(64) CHARACTER SET latin1 COLLATE latin1_swedish_ci NOT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 3 CHARACTER SET = latin1 COLLATE = latin1_swedish_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of wx_config
-- ----------------------------
INSERT INTO `wx_config` VALUES (1, '1496768882', 'sdhfg2342fyygr278y7fh7weghyfgg12', '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', 'wx13693f2be43ce129');
INSERT INTO `wx_config` VALUES (2, '123213131', 'xsfsf', NULL, '123213');

