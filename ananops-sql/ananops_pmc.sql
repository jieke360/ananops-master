/*
Navicat MySQL Data Transfer

Source Server         : localhost
Source Server Version : 50717
Source Host           : localhost:3306
Source Database       : ananops_pmc

Target Server Type    : MYSQL
Target Server Version : 50717
File Encoding         : 65001

Date: 2019-12-11 19:01:33
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for an_pmc_contract
-- ----------------------------
DROP TABLE IF EXISTS `an_pmc_contract`;
CREATE TABLE `an_pmc_contract` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `version` varchar(20) DEFAULT NULL COMMENT '版本号',
  `contract_code` varchar(50) DEFAULT NULL COMMENT '合同编号',
  `contract_name` varchar(50) DEFAULT NULL COMMENT '合同名称',
  `contract_type` varchar(50) DEFAULT NULL COMMENT '合同类型',
  `party_a_id` bigint(20) DEFAULT NULL COMMENT '甲方id',
  `party_a_name` varchar(20) DEFAULT NULL COMMENT '甲方组织名称',
  `a_legal_name` varchar(20) DEFAULT NULL COMMENT '甲方合同签字法人',
  `party_b_id` bigint(20) DEFAULT NULL COMMENT '乙方id',
  `party_b_name` varchar(20) DEFAULT NULL COMMENT '乙方组织名称',
  `b_legal_name` varchar(20) DEFAULT NULL COMMENT '乙方合同签字法人',
  `bank_name` varchar(50) DEFAULT NULL COMMENT '乙方开户银行',
  `bank_account` varchar(50) DEFAULT NULL COMMENT '乙方银行账号',
  `sign_time` datetime DEFAULT NULL COMMENT '合同签订时间',
  `start_time` datetime DEFAULT NULL COMMENT '合同开始时间',
  `end_time` datetime DEFAULT NULL COMMENT '合同结束时间',
  `is_postpone` int(4) DEFAULT NULL COMMENT '是否自动顺延（0-未顺延，1-顺延）',
  `payment_type` int(2) DEFAULT NULL COMMENT '支付方式（1-现结、2-账期、3-年结）',
  `project_money` decimal(10,0) DEFAULT NULL COMMENT '项目金额',
  `payment_time` datetime DEFAULT NULL COMMENT '付款时间',
  `device_count` int(11) DEFAULT NULL COMMENT '维修设备数量',
  `agent_content` varchar(500) DEFAULT NULL COMMENT '乙方代理内容',
  `is_spare_part` int(4) DEFAULT NULL COMMENT '乙方是否包备品备件（0-不包，1-包）',
  `is_spare_service` int(11) DEFAULT NULL COMMENT '乙方是否提供备品备件替换服务（0-不提供，1-提供)',
  `assit_money` decimal(10,0) DEFAULT NULL COMMENT '乙供辅料金额（乙方会提供一些免费辅件，超过该金额的才会另收费）',
  `last_response_time` int(3) DEFAULT NULL COMMENT '维修维护最迟响应时间,单位小时（配合转单功能以及平台的提醒功能，在一定时限内短信、电话或邮件提醒）',
  `verification` varchar(300) DEFAULT NULL COMMENT '维修工身份验证流程（对于有保密属性的设备需要验证维修工的身份）',
  `record_time` int(3) DEFAULT NULL COMMENT '月度记录表提交周期，单位天（也可以为每月第一天）',
  `is_change` int(4) DEFAULT '0' COMMENT '合同是否变更（0-未变更，1-变更）',
  `is_destory` int(4) DEFAULT '0' COMMENT '合同是否作废（0-有效，1-作废）',
  `file_path` varchar(300) DEFAULT NULL COMMENT '附件路径',
  `description` varchar(300) DEFAULT NULL COMMENT '描述',
  `creator_id` bigint(20) DEFAULT NULL COMMENT '创建者id',
  `creator` varchar(20) DEFAULT NULL COMMENT '创建者',
  `created_time` datetime DEFAULT NULL COMMENT '创建时间',
  `last_operator` varchar(20) DEFAULT NULL COMMENT '最近操作人',
  `last_operator_id` bigint(20) DEFAULT NULL COMMENT '最近操作人id',
  `update_time` datetime DEFAULT NULL COMMENT '更新时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=utf8;


-- ----------------------------
-- Table structure for an_pmc_inspect_device
-- ----------------------------
DROP TABLE IF EXISTS `an_pmc_inspect_device`;
CREATE TABLE `an_pmc_inspect_device` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT 'ID',
  `version` varchar(20) DEFAULT NULL,
  `project_id` bigint(20) DEFAULT NULL COMMENT '项目id',
  `project_name` varchar(50) DEFAULT NULL COMMENT '项目名称',
  `device_name` varchar(50) DEFAULT NULL COMMENT '设备名字',
  `device_type` varchar(50) DEFAULT NULL COMMENT '设备类型',
  `inspection_content` varchar(300) DEFAULT NULL COMMENT '巡检内容',
  `inspection_condition` int(4) DEFAULT NULL COMMENT '巡检情况(0-正常，1-不正常)',
  `deal_result` varchar(300) DEFAULT NULL COMMENT '处理结果',
  `cycle_time` int(3) DEFAULT NULL COMMENT '巡检周期',
  `scheduled_start_time` datetime DEFAULT NULL COMMENT '预计开始时间',
  `deadline_time` datetime DEFAULT NULL COMMENT '最晚开始时间',
  `description` varchar(300) DEFAULT NULL COMMENT '描述',
  `creator` varchar(20) DEFAULT NULL COMMENT '创建者',
  `creator_id` bigint(20) DEFAULT NULL COMMENT '创建者id',
  `created_time` datetime DEFAULT NULL COMMENT '创建时间',
  `last_operator` varchar(20) DEFAULT NULL COMMENT '最近操作人',
  `last_operator_id` bigint(20) DEFAULT NULL COMMENT '最近操作人id',
  `update_time` datetime DEFAULT NULL COMMENT '更新时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;


-- ----------------------------
-- Table structure for an_pmc_project
-- ----------------------------
DROP TABLE IF EXISTS `an_pmc_project`;
CREATE TABLE `an_pmc_project` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT 'ID',
  `version` int(11) DEFAULT NULL,
  `contract_id` bigint(20) DEFAULT NULL COMMENT '合同id',
  `contract_name` varchar(50) DEFAULT NULL COMMENT '合同名称',
  `project_name` varchar(50) DEFAULT NULL COMMENT '项目名称',
  `project_type` varchar(50) DEFAULT NULL COMMENT '项目类型',
  `is_contract` int(4) DEFAULT NULL COMMENT '是否签署合同（0-没有，1-有，没有签署合同的未虚拟项目）',
  `party_a_id` bigint(20) DEFAULT NULL COMMENT '甲方id',
  `party_a_name` varchar(20) DEFAULT NULL COMMENT '甲方名称',
  `party_b_id` bigint(20) DEFAULT NULL COMMENT '乙方id',
  `party_b_name` varchar(20) DEFAULT NULL COMMENT '乙方名称',
  `a_one_name` varchar(20) DEFAULT NULL COMMENT '联系人1姓名',
  `party_a_one` varchar(15) DEFAULT NULL COMMENT '甲方项目负责人联系方式1',
  `a_two_name` varchar(20) DEFAULT NULL COMMENT '联系人2姓名',
  `party_a_two` varchar(15) DEFAULT NULL COMMENT '甲方项目负责人联系方式2',
  `a_three_name` varchar(20) DEFAULT NULL COMMENT '联系人1姓名',
  `party_a_three` varchar(15) DEFAULT NULL COMMENT '甲方项目负责人联系方式2',
  `b_name` varchar(20) DEFAULT NULL COMMENT '乙方项目负责人',
  `party_b_one` varchar(15) DEFAULT NULL COMMENT '乙方负责人电话',
  `party_b_tel` varchar(15) DEFAULT NULL COMMENT '乙方24小时值班电话',
  `party_b_phone` varchar(15) DEFAULT NULL COMMENT '乙方24小时开通的移动电话',
  `party_b_email` varchar(50) DEFAULT NULL COMMENT '乙方24小时开通邮箱',
  `start_time` datetime DEFAULT NULL COMMENT '开始时间（虚拟项目必填）',
  `end_time` datetime DEFAULT NULL COMMENT '结束时间（虚拟项目必填',
  `is_destory` int(4) DEFAULT '0' COMMENT '项目是否作废（0-有效，1-作废）',
  `description` varchar(255) DEFAULT NULL COMMENT '描述',
  `creator` varchar(20) DEFAULT NULL COMMENT '创建者',
  `creator_id` bigint(20) DEFAULT NULL COMMENT '创建者id',
  `created_time` datetime DEFAULT NULL COMMENT '创建时间',
  `last_operator` varchar(20) DEFAULT NULL COMMENT '最近操作人',
