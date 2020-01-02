/*
Navicat MySQL Data Transfer

Source Server         : beianxie
Source Server Version : 50728
Source Host           : localhost:3306
Source Database       : mdmc

Target Server Type    : MYSQL
Target Server Version : 50728
File Encoding         : 65001

Date: 2019-12-19 13:24:37
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for databasechangelog
-- ----------------------------
DROP TABLE IF EXISTS `databasechangelog`;
CREATE TABLE `databasechangelog` (
  `ID` varchar(255) NOT NULL,
  `AUTHOR` varchar(255) NOT NULL,
  `FILENAME` varchar(255) NOT NULL,
  `DATEEXECUTED` datetime NOT NULL,
  `ORDEREXECUTED` int(11) NOT NULL,
  `EXECTYPE` varchar(10) NOT NULL,
  `MD5SUM` varchar(35) DEFAULT NULL,
  `DESCRIPTION` varchar(255) DEFAULT NULL,
  `COMMENTS` varchar(255) DEFAULT NULL,
  `TAG` varchar(255) DEFAULT NULL,
  `LIQUIBASE` varchar(20) DEFAULT NULL,
  `CONTEXTS` varchar(255) DEFAULT NULL,
  `LABELS` varchar(255) DEFAULT NULL,
  `DEPLOYMENT_ID` varchar(10) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of databasechangelog
-- ----------------------------
INSERT INTO `databasechangelog` VALUES ('init-schema', 'paascloud.net@gmail.com', 'classpath:liquibase/change_log/2017-06-10-init-schema.xml', '2019-12-18 15:46:26', '1', 'EXECUTED', '7:cebd02a08a9ed3d700e360cd5d26bb72', 'createTable tableName=user', 'init schema', null, '3.5.3', null, null, '6655186830');

-- ----------------------------
-- Table structure for databasechangeloglock
-- ----------------------------
DROP TABLE IF EXISTS `databasechangeloglock`;
CREATE TABLE `databasechangeloglock` (
  `ID` int(11) NOT NULL,
  `LOCKED` bit(1) NOT NULL,
  `LOCKGRANTED` datetime DEFAULT NULL,
  `LOCKEDBY` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of databasechangeloglock
-- ----------------------------
INSERT INTO `databasechangeloglock` VALUES ('1', '\0', null, null);

-- ----------------------------
-- Table structure for device
-- ----------------------------
DROP TABLE IF EXISTS `device`;
CREATE TABLE `device` (
  `id` bigint(20) NOT NULL COMMENT 'ID',
  `version` int(11) DEFAULT NULL COMMENT '版本号',
  `creator` varchar(20) DEFAULT NULL COMMENT '创建人',
  `creator_id` bigint(20) DEFAULT NULL COMMENT '创建人ID',
  `created_time` datetime DEFAULT NULL COMMENT '创建时间',
  `last_operator` varchar(20) DEFAULT NULL COMMENT '最近操作人',
  `last_operator_id` bigint(20) DEFAULT NULL COMMENT '最后操作人ID',
  `update_time` datetime DEFAULT NULL COMMENT '更新时间',
  `device_model` varchar(20) DEFAULT NULL COMMENT '设别型号',
  `device_type` varchar(20) DEFAULT NULL COMMENT '设备类型',
  `count` int(20) DEFAULT NULL COMMENT '剩余设备数',
  `cost` decimal(10,3) DEFAULT NULL COMMENT '设备单价',
  `manufacture` varchar(50) DEFAULT NULL COMMENT '设备生产厂商',
  `production_date` datetime DEFAULT NULL COMMENT '设备生产日期',
  `installation_date` datetime DEFAULT NULL COMMENT '设备安装日期',
  `device_name` varchar(20) DEFAULT NULL,
  `task_id` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC;

-- ----------------------------
-- Records of device
-- ----------------------------
INSERT INTO `device` VALUES ('8604444743573834036', null, null, null, null, null, null, null, 'sh', 'ss', null, null, null, null, null, null, null);

-- ----------------------------
-- Table structure for device_order
-- ----------------------------
DROP TABLE IF EXISTS `device_order`;
CREATE TABLE `device_order` (
  `id` bigint(20) NOT NULL COMMENT 'ID',
  `version` int(11) DEFAULT NULL COMMENT '版本号',
  `creator` varchar(20) DEFAULT NULL COMMENT '创建人',
  `creator_id` bigint(20) DEFAULT NULL COMMENT '创建人ID',
  `created_time` datetime DEFAULT NULL COMMENT '创建时间',
  `last_operator` varchar(20) DEFAULT NULL COMMENT '最近操作人',
  `last_operator_id` bigint(20) DEFAULT NULL COMMENT '最后操作人ID',
  `update_time` datetime DEFAULT NULL COMMENT '更新时间',
  `task_id` bigint(20) DEFAULT NULL COMMENT '对应的任务ID',
  `task_item_id` bigint(20) DEFAULT NULL COMMENT '对应的任务子项ID',
  `maintainer_id` bigint(20) DEFAULT NULL COMMENT '对应的维修工ID',
  `device_id` bigint(20) DEFAULT NULL COMMENT '设备ID',
  `cost` decimal(10,3) DEFAULT NULL COMMENT '当前订单的花费',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC;

-- ----------------------------
-- Records of device_order
-- ----------------------------

-- ----------------------------
-- Table structure for review
-- ----------------------------
DROP TABLE IF EXISTS `review`;
CREATE TABLE `review` (
  `id` bigint(20) NOT NULL COMMENT 'ID',
  `version` int(11) DEFAULT NULL COMMENT '版本号',
  `creator` varchar(20) DEFAULT NULL COMMENT '创建人',
  `creator_id` bigint(20) DEFAULT NULL COMMENT '创建人ID',
  `created_time` datetime DEFAULT NULL COMMENT '创建时间',
  `last_operator` varchar(20) DEFAULT NULL COMMENT '最近操作人',
  `last_operator_id` bigint(20) DEFAULT NULL COMMENT '最后操作人ID',
  `update_time` datetime DEFAULT NULL COMMENT '更新时间',
  `task_id` bigint(20) DEFAULT NULL COMMENT '任务ID',
  `facilitator_id` bigint(20) DEFAULT NULL COMMENT '服务商ID',
  `maintainer_id` bigint(20) DEFAULT NULL COMMENT '维修工程师ID',
  `user_id` bigint(20) DEFAULT NULL COMMENT '申请维修维护的用户的ID',
  `score` int(5) DEFAULT NULL COMMENT '服务评级',
  `contents` varchar(100) DEFAULT NULL COMMENT '服务评论',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC;

-- ----------------------------
-- Records of review
-- ----------------------------
INSERT INTO `review` VALUES ('124312', null, null, null, null, null, null, null, '14234', null, null, null, '3', 'gasg');

-- ----------------------------
-- Table structure for task
-- ----------------------------
DROP TABLE IF EXISTS `task`;
CREATE TABLE `task` (
  `id` bigint(20) NOT NULL COMMENT 'ID',
  `version` int(11) DEFAULT NULL COMMENT '版本号',
  `creator` varchar(20) DEFAULT NULL COMMENT '创建人',
  `creator_id` bigint(20) DEFAULT NULL COMMENT '创建人ID',
  `created_time` datetime DEFAULT NULL COMMENT '创建时间',
  `last_operator` varchar(20) DEFAULT NULL COMMENT '最近操作人',
  `last_operator_id` bigint(20) DEFAULT NULL COMMENT '最后操作人ID',
  `update_time` datetime DEFAULT NULL COMMENT '更新时间',
  `user_id` bigint(20) DEFAULT NULL COMMENT '发起此次维修请求的用户ID',
  `principal_id` bigint(20) DEFAULT NULL COMMENT '用户负责人（领导）ID',
  `project_id` bigint(20) DEFAULT NULL COMMENT '任务对应的项目ID',
  `facilitator_id` bigint(20) DEFAULT NULL COMMENT '服务商ID',
  `maintainer_id` bigint(20) DEFAULT NULL COMMENT '维修工ID',
  `scheduled_finish_time` datetime DEFAULT NULL COMMENT '预计完成时间',
  `actual_finish_time` datetime DEFAULT NULL COMMENT '实际完成时间',
  `scheduled_start_time` datetime DEFAULT NULL COMMENT '预计开始时间',
  `actual_start_time` datetime DEFAULT NULL COMMENT '实际开始时间',
  `deadline` datetime DEFAULT NULL COMMENT '最迟完成时间',
  `request_latitude` decimal(10,6) DEFAULT NULL COMMENT '请求维修的地点，纬度',
  `request_longitude` decimal(10,6) DEFAULT NULL COMMENT '请求维修的地点，经度',
  `status` int(10) DEFAULT NULL COMMENT '当前任务的进度状态',
  `total_cost` decimal(10,3) DEFAULT NULL COMMENT '维修总花费',
  `clearing_form` int(5) DEFAULT NULL COMMENT '结算方式',
  `title` varchar(20) DEFAULT NULL,
  `contract_id` bigint(20) DEFAULT NULL,
  `address_name` varchar(20) DEFAULT NULL,
  `creator_call` varchar(20) DEFAULT NULL,
  `level` int(11) DEFAULT NULL,
  `appoint_time` datetime DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC;

-- ----------------------------
-- Records of task
-- ----------------------------
INSERT INTO `task` VALUES ('-7950681695466206864', null, 'string', null, null, null, null, null, '0', '0', '0', '410', null, null, null, null, null, null, null, null, '3', '0.000', '0', 'string', '0', 'string', 'string', '0', '2019-12-19 09:57:07');
INSERT INTO `task` VALUES ('-2385539199958337489', null, 'string', null, null, null, null, null, '0', '0', '0', '0', null, null, null, null, null, null, null, null, null, '0.000', '0', 'string', '0', 'string', 'string', '0', '2019-12-17 09:26:05');
INSERT INTO `task` VALUES ('-1688915737305287805', null, 'string', null, null, null, null, null, '777', '0', '0', '0', null, null, null, null, null, null, null, null, null, '67.000', '0', 'string', '0', 'string', 'string', '0', '2019-12-17 11:29:50');
INSERT INTO `task` VALUES ('312', null, null, null, null, null, null, null, '222', '11', '4', '444', '41421342', null, '2019-07-18 05:27:05', null, '2019-12-18 05:27:16', null, null, null, '4', '324.000', '1', 'faasg', '2314', 'faasgfas', '231244', '4', '2019-12-18 05:28:48');
INSERT INTO `task` VALUES ('13213', null, 'string', null, null, null, null, null, '222', '3131', '31', '1324', '1413421', null, '2019-12-18 05:27:10', null, '2019-12-18 05:27:19', null, null, null, '3', '1421.000', '3', 'ffas', '4310', 'afasgsa', '12343124', '5', '2019-12-16 19:09:32');
INSERT INTO `task` VALUES ('14234', null, null, null, null, null, null, null, '222', '424', '5', '521', '14223', null, '2019-12-18 05:32:45', null, '2019-12-18 05:32:49', null, null, null, '7', '4141.000', null, null, '141', 'ghfd', '1231241', null, null);
INSERT INTO `task` VALUES ('23131', null, 'string', null, null, null, null, null, '0', '5214', '14', '451', '1423', null, '2019-12-18 05:31:16', null, '2019-12-18 05:31:39', null, null, null, '5', '14.000', '0', 'string', '14', 'hdf', '142142', '0', '2019-12-16 19:05:22');
INSERT INTO `task` VALUES ('295007014525519194', null, null, null, null, null, null, null, '222', '3', '3', '12421', '1425', null, '2019-12-18 05:31:20', null, '2019-12-18 05:31:41', null, null, null, '6', '412.000', '0', 'string', '1412', 'hfd', '55431', null, null);
INSERT INTO `task` VALUES ('1204630146083280590', null, 'string', null, null, null, null, null, '777', '3131', '0', '1324', '44', null, '2019-12-18 05:31:18', null, '2019-12-18 05:31:44', null, null, null, '7', '412.000', '0', 'string', '1412', 'dh', '142141', '0', '2019-12-17 11:29:50');
INSERT INTO `task` VALUES ('4831437787179364367', null, 'string', null, null, null, null, null, '1435', '521', '0', '1324', '44', null, '2019-12-18 05:31:22', null, '2019-12-18 05:31:45', null, null, null, '11', '41.000', '0', 'string', '1412', 'dfh', '1421', '0', '2019-12-17 09:55:51');
INSERT INTO `task` VALUES ('7230326287577540007', null, null, null, null, null, null, null, '777', '214', '0', '26553', '44', null, '2019-12-18 05:31:25', null, '2019-12-18 05:31:47', null, null, null, '12', '1.000', '0', 'string', '14235', null, 'string', null, null);

-- ----------------------------
-- Table structure for task_item
-- ----------------------------
DROP TABLE IF EXISTS `task_item`;
CREATE TABLE `task_item` (
  `id` bigint(20) NOT NULL COMMENT 'ID',
  `version` int(11) DEFAULT NULL COMMENT '版本号',
  `creator` varchar(20) DEFAULT NULL COMMENT '创建人',
  `creator_id` bigint(20) DEFAULT NULL COMMENT '创建人ID',
  `created_time` datetime DEFAULT NULL COMMENT '创建时间',
  `last_operator` varchar(20) DEFAULT NULL COMMENT '最近操作人',
  `last_operator_id` bigint(20) DEFAULT NULL COMMENT '最后操作人ID',
  `update_time` datetime DEFAULT NULL COMMENT '更新时间',
  `task_id` bigint(20) DEFAULT NULL COMMENT '任务ID',
  `device_id` bigint(20) DEFAULT NULL COMMENT '设备ID',
  `device_name` varchar(100) DEFAULT NULL,
  `actual_finish_time` datetime DEFAULT NULL COMMENT '完成维修的时间戳',
  `actual_start_time` datetime DEFAULT NULL COMMENT '开始维修的时间戳',
  `description` varchar(100) DEFAULT NULL COMMENT '故障描述',
  `level` int(5) DEFAULT NULL COMMENT '故障等级',
  `device_latitude` decimal(10,6) DEFAULT NULL COMMENT '故障设备位置，纬度',
  `device_longitude` decimal(10,6) DEFAULT NULL COMMENT '故障设备位置，经度',
  `maintainer_id` bigint(20) DEFAULT NULL COMMENT '维修工ID',
  `status` int(5) DEFAULT NULL COMMENT '当前维修状态',
  `suggestion` varchar(100) DEFAULT NULL COMMENT '维修建议（维修工填写）',
  `result` varchar(100) DEFAULT NULL COMMENT '维修结果（维修工填写）',
  `photo_url` varchar(100) DEFAULT NULL,
  `trouble_type` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC;

-- ----------------------------
-- Records of task_item
-- ----------------------------
INSERT INTO `task_item` VALUES ('-8491581439925870400', null, null, null, null, null, null, null, null, '0', 'string', null, null, 'string', null, '0.000000', '0.000000', null, null, null, null, 'string', '0');
INSERT INTO `task_item` VALUES ('-6906843202057565408', null, null, null, null, null, null, null, null, '0', 'string', null, null, 'string', null, '0.000000', '0.000000', null, null, null, null, 'string', '0');
INSERT INTO `task_item` VALUES ('-6871971428002626218', null, null, null, null, null, null, null, '14234', '3214', 'fsf', '2019-12-18 05:36:17', '2019-12-18 05:36:20', 'fsfa', '2', '0.000000', '0.000000', null, null, null, null, 'string', '2');
INSERT INTO `task_item` VALUES ('-6157605761730018776', null, null, null, null, null, null, null, '14234', '4124', 'fgsdg', '2019-12-18 05:37:15', '2019-12-18 05:37:18', 'gsgg', '3', '0.000000', '0.000000', null, null, null, null, 'string', '4');
INSERT INTO `task_item` VALUES ('-4114773880007600578', null, null, null, null, null, null, null, null, '0', 'string', null, null, 'string', null, '0.000000', '0.000000', null, null, null, null, 'string', '0');
INSERT INTO `task_item` VALUES ('178339286271545530', null, null, null, null, null, null, null, '-7950681695466206864', '0', 'string', null, null, 'string', null, '0.000000', '0.000000', null, null, null, null, 'string', '0');
INSERT INTO `task_item` VALUES ('3846496076806917476', null, null, null, null, null, null, null, null, '0', 'string', null, null, 'string', null, '0.000000', '0.000000', null, null, null, null, 'string', '0');
INSERT INTO `task_item` VALUES ('5652716821451624696', null, null, null, null, null, null, null, null, '0', 'string', null, null, 'string', null, '0.000000', '0.000000', null, null, null, null, 'string', '0');
INSERT INTO `task_item` VALUES ('6509884822980181514', null, null, null, null, null, null, null, null, '0', 'string', null, null, 'string', null, '0.000000', '0.000000', null, null, null, null, null, null);
INSERT INTO `task_item` VALUES ('8604444543573834036', null, 'dsddf', null, '2019-12-10 05:47:30', null, null, null, '23412423424234', '8604444743573834036', 'ssd', null, null, 'ddd', '2', null, null, '123', '4', null, '', null, null);

-- ----------------------------
-- Table structure for task_item_log
-- ----------------------------
DROP TABLE IF EXISTS `task_item_log`;
CREATE TABLE `task_item_log` (
  `id` bigint(20) NOT NULL COMMENT 'ID',
  `version` int(11) DEFAULT NULL COMMENT '版本号',
  `creator` varchar(20) DEFAULT NULL COMMENT '创建人',
  `creator_id` bigint(20) DEFAULT NULL COMMENT '创建人ID',
  `created_time` datetime DEFAULT NULL COMMENT '创建时间',
  `last_operator` varchar(20) DEFAULT NULL COMMENT '最近操作人',
  `last_operator_id` bigint(20) DEFAULT NULL COMMENT '最后操作人ID',
  `update_time` datetime DEFAULT NULL COMMENT '更新时间',
  `task_id` bigint(20) DEFAULT NULL COMMENT '对应的任务ID',
  `status` int(10) DEFAULT NULL COMMENT '当前操作对应的状态',
  `movement` varchar(100) DEFAULT NULL COMMENT '当前发生动作的描述（维修工或甲方用户填写）',
  `task_item_id` bigint(20) DEFAULT NULL COMMENT '对应的任务子项ID',
  `status_timestamp` datetime DEFAULT NULL COMMENT '当前发生操作对应的时间戳',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC;

-- ----------------------------
-- Records of task_item_log
-- ----------------------------
INSERT INTO `task_item_log` VALUES ('-7588485422864916452', null, null, null, null, null, null, null, '0', null, 'string', null, null);

-- ----------------------------
-- Table structure for task_log
-- ----------------------------
DROP TABLE IF EXISTS `task_log`;
CREATE TABLE `task_log` (
  `id` bigint(20) NOT NULL COMMENT 'ID',
  `version` int(11) DEFAULT NULL COMMENT '版本号',
  `creator` varchar(20) DEFAULT NULL COMMENT '创建人',
  `creator_id` bigint(20) DEFAULT NULL COMMENT '创建人ID',
  `created_time` datetime DEFAULT NULL COMMENT '创建时间',
  `last_operator` varchar(20) DEFAULT NULL COMMENT '最近操作人',
  `last_operator_id` bigint(20) DEFAULT NULL COMMENT '最后操作人ID',
  `update_time` datetime DEFAULT NULL COMMENT '更新时间',
  `task_id` bigint(20) DEFAULT NULL COMMENT '任务ID',
  `status` int(10) DEFAULT NULL COMMENT '当前操作对应的状态',
  `movement` varchar(100) DEFAULT NULL COMMENT '当前操作的描述',
  `status_timestamp` datetime DEFAULT NULL COMMENT '当前操作对应的时间戳',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC;

-- ----------------------------
-- Records of task_log
-- ----------------------------
INSERT INTO `task_log` VALUES ('-4148831232226474293', null, null, null, null, null, null, null, '-7950681695466206864', '3', '待审核人审核', null);
INSERT INTO `task_log` VALUES ('-1164289435962556165', null, null, null, null, 'string', null, null, '14234', '3', 'string', '2019-12-13 12:10:09');
INSERT INTO `task_log` VALUES ('2222', null, null, null, null, 'dd', null, null, '14234', '4', 'ddd', '2019-06-10 04:40:50');

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- ----------------------------
-- Records of user
-- ----------------------------
