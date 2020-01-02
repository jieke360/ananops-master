/*
Navicat MySQL Data Transfer

Source Server         : localhost
Source Server Version : 50717
Source Host           : localhost:3306
Source Database       : ananops_uac

Target Server Type    : MYSQL
Target Server Version : 50717
File Encoding         : 65001

Date: 2019-12-11 13:39:55
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for an_mq_message_data
-- ----------------------------
DROP TABLE IF EXISTS `an_mq_message_data`;
CREATE TABLE `an_mq_message_data` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT 'ID',
  `version` int(11) DEFAULT '0' COMMENT '版本号',
  `message_key` varchar(200) CHARACTER SET utf8 DEFAULT NULL COMMENT '消息key',
  `message_topic` varchar(50) CHARACTER SET utf8 DEFAULT '' COMMENT 'topic',
  `message_tag` varchar(50) CHARACTER SET utf8 DEFAULT '' COMMENT 'tag',
  `message_body` longtext CHARACTER SET utf8 COMMENT '消息内容',
  `message_type` int(11) DEFAULT '10' COMMENT '消息类型: 10 - 生产者 ; 20 - 消费者',
  `delay_level` int(11) DEFAULT '0' COMMENT '延时级别 1s 5s 10s 30s 1m 2m 3m 4m 5m 6m 7m 8m 9m 10m 20m 30m 1h 2h',
  `order_type` int(11) DEFAULT '0' COMMENT '顺序类型 0有序 1无序',
  `status` int(11) DEFAULT '10' COMMENT '消息状态',
  `creator` varchar(20) CHARACTER SET utf8 DEFAULT NULL COMMENT '创建人',
  `creator_id` bigint(20) DEFAULT NULL COMMENT '创建人ID',
  `created_time` datetime DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `last_operator` varchar(20) CHARACTER SET utf8 DEFAULT NULL COMMENT '最近操作人',
  `last_operator_id` bigint(20) DEFAULT NULL COMMENT '最后操作人ID',
  `update_time` datetime DEFAULT CURRENT_TIMESTAMP COMMENT '更新时间',
  `yn` int(11) DEFAULT '0' COMMENT '是否删除 -0 未删除 -1 已删除',
  PRIMARY KEY (`id`),
  KEY `idx_message_key` (`message_key`) USING BTREE,
  KEY `idx_created_time` (`created_time`) USING BTREE,
  KEY `idx_update_time` (`update_time`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=317428450421908481 DEFAULT CHARSET=utf8mb4 COMMENT='消息记录表';

-- ----------------------------
-- Records of an_mq_message_data
-- ----------------------------

-- ----------------------------
-- Table structure for an_uac_action
-- ----------------------------
DROP TABLE IF EXISTS `an_uac_action`;
CREATE TABLE `an_uac_action` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT 'ID',
  `version` int(11) DEFAULT '0' COMMENT '版本号',
  `url` varchar(100) CHARACTER SET utf8 DEFAULT '' COMMENT '资源路径',
  `action_name` varchar(90) CHARACTER SET utf8 NOT NULL DEFAULT '' COMMENT '权限名称',
  `action_code` varchar(100) CHARACTER SET utf8 NOT NULL DEFAULT '' COMMENT '权限',
  `status` varchar(20) CHARACTER SET utf8 DEFAULT NULL COMMENT '状态',
  `remark` varchar(300) CHARACTER SET utf8 DEFAULT '' COMMENT '备注',
  `menu_id` bigint(20) NOT NULL COMMENT '菜单ID',
  `creator` varchar(20) CHARACTER SET utf8 DEFAULT '' COMMENT '创建人',
  `creator_id` bigint(20) DEFAULT NULL COMMENT '创建人ID',
  `created_time` datetime DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `last_operator` varchar(20) CHARACTER SET utf8 DEFAULT '' COMMENT '最近操作人',
  `last_operator_id` bigint(20) DEFAULT NULL COMMENT '最后操作人ID',
  `update_time` datetime DEFAULT CURRENT_TIMESTAMP COMMENT '更新时间',
  PRIMARY KEY (`id`),
  UNIQUE KEY `system_id` (`action_code`) USING BTREE,
  UNIQUE KEY `system_id_2` (`action_name`) USING BTREE,
  KEY `tbl_pms_action_ibfk_2` (`menu_id`)
) ENGINE=InnoDB AUTO_INCREMENT=387606786523402241 DEFAULT CHARSET=utf8mb4 ROW_FORMAT=COMPACT COMMENT='权限表';

-- ----------------------------
-- Records of an_uac_action
-- ----------------------------
INSERT INTO `an_uac_action` VALUES ('100001', '0', '/user/save', '编辑用户', 'uac:user:save', 'ENABLE', null, '1112', 'admin', '1', '2017-12-05 22:45:26', '超级管理员', '1', '2018-03-04 22:46:50');
INSERT INTO `an_uac_action` VALUES ('100005', '0', '/role/save', '编辑角色', 'add:role', 'ENABLE', null, '1111', 'admin', '1', '2017-12-05 22:45:26', '超级管理员', '1', '2018-02-26 21:13:48');
INSERT INTO `an_uac_action` VALUES ('305772209559839744', '0', '/uac/role/queryList', '查看角色', 'uca:role:view', 'ENABLE', '', '1111', '超级管理员', '1', '2018-02-26 21:14:48', '超级管理员', '1', '2018-02-26 21:15:01');
INSERT INTO `an_uac_action` VALUES ('308015564217918464', '0', '/order/createOrderDoc/*', '创建订单', 'omc:order:createOrderDoc', 'ENABLE', '', '386619669785743360', '超级管理员', '1', '2018-03-01 23:31:57', '超级管理员', '1', '2018-03-01 23:31:57');
INSERT INTO `an_uac_action` VALUES ('308015817025397760', '0', '/order/cancelOrderDoc/*', '取消订单', 'cancelOrderDoc', 'ENABLE', '', '386619669785743360', '超级管理员', '1', '2018-03-01 23:32:27', '超级管理员', '1', '2018-03-01 23:32:27');
INSERT INTO `an_uac_action` VALUES ('308016353694983168', '0', '/shipping/addShipping', '增加收货人地址', 'omc:shipping:addShipping', 'ENABLE', '', '386619554962477056', '超级管理员', '1', '2018-03-01 23:33:31', '超级管理员', '1', '2018-03-01 23:33:31');
INSERT INTO `an_uac_action` VALUES ('308016771179226112', '0', '/shipping/deleteShipping/*', '删除收货地址', 'omc:shiping:deleteShipping', 'ENABLE', '', '386619554962477056', '超级管理员', '1', '2018-03-01 23:34:20', '超级管理员', '1', '2018-03-01 23:34:20');
INSERT INTO `an_uac_action` VALUES ('308017000884478976', '0', '/shipping/updateShipping/*', '更新收货地址', 'omc:shipping:updateShipping', 'ENABLE', '', '386619554962477056', '超级管理员', '1', '2018-03-01 23:34:48', '超级管理员', '1', '2018-03-01 23:34:48');
INSERT INTO `an_uac_action` VALUES ('308017290090128384', '0', '/shipping/setDefaultAddress/*', '设置默认地址', 'omc:shiping:setDefaultAddress', 'ENABLE', '', '386619554962477056', '超级管理员', '1', '2018-03-01 23:35:22', '超级管理员', '1', '2018-03-01 23:35:22');
INSERT INTO `an_uac_action` VALUES ('308017803162559488', '0', '/pay/createQrCodeImage/*', '生成支付二维码', 'omc:pay:createQrCodeImage', 'ENABLE', '', '386619669785743360', '超级管理员', '1', '2018-03-01 23:36:23', '超级管理员', '1', '2018-03-01 23:36:23');
INSERT INTO `an_uac_action` VALUES ('308018047321383936', '0', '/pay/alipayCallback', '支付宝支付回调', 'omc:pay:callback', 'ENABLE', '', '386619669785743360', '超级管理员', '1', '2018-03-01 23:36:53', '超级管理员', '1', '2018-03-01 23:36:53');
INSERT INTO `an_uac_action` VALUES ('308027485310690304', '0', '/cart/addProduct/**', '向购物车添加商品', 'omc:cart:addProduct', 'ENABLE', '', '386619770943967232', '超级管理员', '1', '2018-03-01 23:55:38', '超级管理员', '1', '2018-03-01 23:55:38');
INSERT INTO `an_uac_action` VALUES ('308027702659523584', '0', '/cart/updateProduct/**', '更新购物车商品', 'omc:cart:updateProduct', 'ENABLE', '', '386619770943967232', '超级管理员', '1', '2018-03-01 23:56:04', '超级管理员', '1', '2018-03-01 23:56:04');
INSERT INTO `an_uac_action` VALUES ('308027958889554944', '0', '/cart/deleteProduct/*', '删除购物车商品', 'omc:cart:deleteProduct', 'ENABLE', '', '386619770943967232', '超级管理员', '1', '2018-03-01 23:56:34', '超级管理员', '1', '2018-03-01 23:56:34');
INSERT INTO `an_uac_action` VALUES ('308028183234487296', '0', '/cart/selectAllProduct', '勾选全部购物车商品', 'omc:cart:selectAllProduct', 'ENABLE', '', '386619770943967232', '超级管理员', '1', '2018-03-01 23:57:01', '超级管理员', '1', '2018-03-01 23:57:01');
INSERT INTO `an_uac_action` VALUES ('308028362683589632', '0', '/cart/unSelectAllProduct', '取消勾选全部购物车商品', 'omc:cart:unSelectAllProduct', 'ENABLE', '', '386619770943967232', '超级管理员', '1', '2018-03-01 23:57:22', '超级管理员', '1', '2018-03-01 23:57:22');
INSERT INTO `an_uac_action` VALUES ('308028500382589952', '0', '/cart/selectProduct/*', '勾选购车商品', 'selectProduct', 'ENABLE', '', '386619770943967232', '超级管理员', '1', '2018-03-01 23:57:39', '超级管理员', '1', '2018-03-01 23:57:39');
INSERT INTO `an_uac_action` VALUES ('308028676685964288', '0', '/cart/unSelectProduct/*', '取消勾选购物车商品', 'omc:cart:unSelectProduct', 'ENABLE', '', '386619770943967232', '超级管理员', '1', '2018-03-01 23:58:00', '超级管理员', '1', '2018-03-01 23:58:00');
INSERT INTO `an_uac_action` VALUES ('308029015392789504', '0', '/cart/updateInformation', '更新用户信息', 'omc:cart:updateInformation', 'ENABLE', '', '386619770943967232', '超级管理员', '1', '2018-03-01 23:58:40', '超级管理员', '1', '2018-03-01 23:58:40');
INSERT INTO `an_uac_action` VALUES ('308699944489853952', '0', '/email/sendRestEmailCode', '发送邮箱验证码', 'omc:emal:sendRestEmailCode', 'ENABLE', '', '386619669785743360', '超级管理员', '1', '2018-03-02 22:11:41', '超级管理员', '1', '2018-03-02 22:11:41');
INSERT INTO `an_uac_action` VALUES ('310162739551020032', '0', '/role/modifyRoleStatusById', '修改角色状态', 'uac:role:modifyRoleStatusById', 'ENABLE', '', '1111', '超级管理员', '1', '2018-03-04 22:38:00', '超级管理员', '1', '2018-03-04 22:38:00');
INSERT INTO `an_uac_action` VALUES ('310163207442408448', '0', '/role/bindUser', '角色绑定用户', 'uac:role:', 'ENABLE', '', '1111', '超级管理员', '1', '2018-03-04 22:38:56', '超级管理员', '1', '2018-03-04 22:38:56');
INSERT INTO `an_uac_action` VALUES ('310164279170966528', '0', '/role/bindMenu', '角色绑定菜单', 'uac:role:bindMenu', 'ENABLE', '', '1111', '超级管理员', '1', '2018-03-04 22:41:03', '超级管理员', '1', '2018-03-04 22:41:03');
INSERT INTO `an_uac_action` VALUES ('310165004122858496', '0', '/role/bindAction', '角色绑定权限', 'uac:role:bindAction', 'ENABLE', '', '1111', '超级管理员', '1', '2018-03-04 22:42:30', '超级管理员', '1', '2018-03-04 22:42:30');
INSERT INTO `an_uac_action` VALUES ('310165760708191232', '0', '/role/deleteRoleById/*', '删除角色', 'uac:role:delete', 'ENABLE', '', '1111', '超级管理员', '1', '2018-03-04 22:44:00', '超级管理员', '1', '2018-03-04 22:45:33');
INSERT INTO `an_uac_action` VALUES ('310166199331726336', '0', '/role/batchDeleteByIdList', '批量删除角色信息', 'uac:role:batchDelete', 'ENABLE', '', '1111', '超级管理员', '1', '2018-03-04 22:44:52', '超级管理员', '1', '2018-03-04 22:44:52');
INSERT INTO `an_uac_action` VALUES ('310169052272141312', '0', '/user/bindRole', '用户绑定角色', 'uac:user:bindRole', 'ENABLE', '', '1112', '超级管理员', '1', '2018-03-04 22:50:32', '超级管理员', '1', '2018-03-04 22:50:32');
INSERT INTO `an_uac_action` VALUES ('310169425665860608', '0', '/user/resetLoginPwd', '重置密码', 'uac:role:resetLoginPwd', 'ENABLE', '', '1112', '超级管理员', '1', '2018-03-04 22:51:17', '超级管理员', '1', '2018-03-04 22:51:17');
INSERT INTO `an_uac_action` VALUES ('310170375616996352', '0', '/user/modifyUserStatusById', '修改用户状态', 'uac:user:modifyUserStatusById', 'ENABLE', '', '1112', '超级管理员', '1', '2018-03-04 22:53:10', '超级管理员', '1', '2018-03-04 22:53:10');
INSERT INTO `an_uac_action` VALUES ('310170756283638784', '0', '/menu/save', '编辑菜单', 'uac:menu:save', 'ENABLE', '', '1113', '超级管理员', '1', '2018-03-04 22:53:55', '超级管理员', '1', '2018-03-04 22:53:55');
INSERT INTO `an_uac_action` VALUES ('310171036865799168', '0', '/menu/deleteById/*', '删除菜单', 'uac:menu:deleteById', 'ENABLE', '', '1113', '超级管理员', '1', '2018-03-04 22:54:29', '超级管理员', '1', '2018-03-04 22:54:29');
INSERT INTO `an_uac_action` VALUES ('310171256882209792', '0', '/menu/modifyStatus', '修改菜单状态', 'uac:menu:modifyStatus', 'ENABLE', '', '1113', '超级管理员', '1', '2018-03-04 22:54:55', '超级管理员', '1', '2018-03-04 22:54:55');
INSERT INTO `an_uac_action` VALUES ('310173131350221824', '0', '/group/save', '编辑组织', 'uac:group:save', 'ENABLE', '', '1115', '超级管理员', '1', '2018-03-04 22:58:39', '超级管理员', '1', '2018-03-04 22:58:39');
INSERT INTO `an_uac_action` VALUES ('310173627720934400', '0', '/group/deleteById/*', '删除组织', 'uac:group:deleteById', 'ENABLE', '', '1115', '超级管理员', '1', '2018-03-04 22:59:38', '超级管理员', '1', '2018-03-04 22:59:38');
INSERT INTO `an_uac_action` VALUES ('310173991090267136', '0', '/group/modifyStatus', '修改组织状态', 'uac:group:modifyStatus', 'ENABLE', '', '1115', '超级管理员', '1', '2018-03-04 23:00:21', '超级管理员', '1', '2018-03-04 23:00:21');
INSERT INTO `an_uac_action` VALUES ('310174242538791936', '0', '/group/bindUser', '组织绑定用户', 'uac:group:bindUser', 'ENABLE', '', '1115', '超级管理员', '1', '2018-03-04 23:00:51', '超级管理员', '1', '2018-03-04 23:00:51');
INSERT INTO `an_uac_action` VALUES ('310175462569550848', '0', '/dict/modifyStatus', '修改数据字典状态', 'mdc:dict:modifyStatus', 'ENABLE', '', '399623736623501312', '超级管理员', '1', '2018-03-04 23:03:17', '超级管理员', '1', '2018-03-04 23:03:17');
INSERT INTO `an_uac_action` VALUES ('310175718698918912', '0', '/dict/save', '编辑数据字典', 'mdc:dict:save', 'ENABLE', '', '399623736623501312', '超级管理员', '1', '2018-03-04 23:03:47', '超级管理员', '1', '2018-03-04 23:03:47');
INSERT INTO `an_uac_action` VALUES ('310176044730557440', '0', '/dict/deleteById/*', '删除数据字典', 'mdc:dict:deleteById', 'ENABLE', '', '399623736623501312', '超级管理员', '1', '2018-03-04 23:04:26', '超级管理员', '1', '2018-03-04 23:04:26');
INSERT INTO `an_uac_action` VALUES ('314332667841618944', '0', '/omc/product/save', '编辑商品', 'omc:product:save', 'ENABLE', '', '386619314180067328', '超级管理员', '1', '2018-03-10 16:42:54', '超级管理员', '1', '2018-03-10 16:42:54');
INSERT INTO `an_uac_action` VALUES ('314333003402716160', '0', '/omc/product/deleteProductById/*', '删除商品', 'omc:product:delete', 'ENABLE', '', '386619314180067328', '超级管理员', '1', '2018-03-10 16:43:34', '超级管理员', '1', '2018-03-10 16:43:34');
INSERT INTO `an_uac_action` VALUES ('314334349447144448', '0', '/omc/category/modifyStatus', '修改商品分类状态', 'omc:category:modifyStatus', 'ENABLE', '', '310861539236127744', '超级管理员', '1', '2018-03-10 16:46:14', '超级管理员', '1', '2018-03-10 16:48:02');
INSERT INTO `an_uac_action` VALUES ('314334713135244288', '0', '/omc/category/deleteById/*', '删除商品分类', 'omc:category:deleteById', 'ENABLE', '', '310861539236127744', '超级管理员', '1', '2018-03-10 16:46:58', '超级管理员', '1', '2018-03-10 16:47:51');
INSERT INTO `an_uac_action` VALUES ('314335013246084096', '0', '/omc/category/save', '编辑商品分类', 'omc:category:save', 'ENABLE', '', '310861539236127744', '超级管理员', '1', '2018-03-10 16:47:34', '超级管理员', '1', '2018-03-10 16:47:34');
INSERT INTO `an_uac_action` VALUES ('387558460746764288', '0', '/action/queryListWithPage', '查询权限列表', 'uac:action:list', 'ENABLE', '查询权限列表', '1114', 'admin', '1', '2017-12-05 22:45:26', 'admin', '1', '2017-12-05 22:45:26');
INSERT INTO `an_uac_action` VALUES ('387560278130298880', '0', '/action/save', '保存权限', 'uac:action:add', 'ENABLE', '新增或者修改权限', '1114', 'admin', '1', '2017-12-05 22:45:26', 'admin', '1', '2017-12-05 22:45:26');
INSERT INTO `an_uac_action` VALUES ('387560564760645632', '0', '/action/deleteActionById/*', '删除权限', 'uac:action:delete', 'ENABLE', '删除权限', '1114', 'admin', '1', '2017-12-05 22:45:26', 'admin', '1', '2017-12-05 22:45:26');
INSERT INTO `an_uac_action` VALUES ('387561185391808512', '0', '/action/modifyStatus', '修改状态', 'uac:action:status', 'ENABLE', '启用/禁用权限', '1114', 'admin', '1', '2017-12-05 22:45:26', 'admin', '1', '2017-12-05 22:45:26');
INSERT INTO `an_uac_action` VALUES ('387561493782204416', '0', '/action/batchDeleteByIdList', '批量删除权限', 'uac:action:batch', 'ENABLE', null, '1114', 'admin', '1', '2017-12-05 22:45:26', 'admin', '1', '2017-12-05 22:45:26');
INSERT INTO `an_uac_action` VALUES ('387606417693085696', '0', '/action/checkActionCode', '检测权限编码是否已存在', 'uac:action:checkActionCode', 'ENABLE', '检测权限编码是否已存在', '1114', 'admin', '1', '2017-12-05 22:45:26', 'admin', '1', '2017-12-05 22:45:26');
INSERT INTO `an_uac_action` VALUES ('387606786523402240', '0', '/action/checkUrl', '检测权限地址唯一性', 'uac:action:checkUrl', 'ENABLE', '检测权限URL唯一性', '1114', 'admin', '1', '2017-12-05 22:45:26', 'admin', '1', '2017-12-05 22:45:26');

-- ----------------------------
-- Table structure for an_uac_application
-- ----------------------------
DROP TABLE IF EXISTS `an_uac_application`;
CREATE TABLE `an_uac_application` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT 'ID',
  `version` int(11) DEFAULT '0' COMMENT '版本号',
  `application_code` varchar(20) CHARACTER SET utf8 DEFAULT '' COMMENT '角色编码',
  `application_name` varchar(90) CHARACTER SET utf8 DEFAULT '' COMMENT '角色名称',
  `status` varchar(20) CHARACTER SET utf8 DEFAULT '' COMMENT '状态',
  `remark` varchar(300) CHARACTER SET utf8 DEFAULT '' COMMENT '备注',
  `creator` varchar(20) CHARACTER SET utf8 DEFAULT '' COMMENT '创建人',
  `creator_id` bigint(20) DEFAULT NULL COMMENT '创建人ID',
  `created_time` datetime DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `last_operator` varchar(20) CHARACTER SET utf8 DEFAULT '' COMMENT '最近操作人',
  `last_operator_id` bigint(20) DEFAULT NULL COMMENT '最后操作人ID',
  `update_time` datetime DEFAULT CURRENT_TIMESTAMP COMMENT '更新时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4 COMMENT='应用表';

-- ----------------------------
-- Records of an_uac_application
-- ----------------------------
INSERT INTO `an_uac_application` VALUES ('1', '1', 'admin', 'admin', 'ENABLE', null, 'admin', '1', '2017-12-05 22:45:26', 'admin', '1', '2017-12-05 22:45:26');

-- ----------------------------
-- Table structure for an_uac_group
-- ----------------------------
DROP TABLE IF EXISTS `an_uac_group`;
CREATE TABLE `an_uac_group` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT 'ID',
  `version` int(11) NOT NULL DEFAULT '0' COMMENT 'VERSION',
  `group_code` varchar(20) CHARACTER SET utf8 NOT NULL DEFAULT '' COMMENT '组织编码',
  `group_name` varchar(20) CHARACTER SET utf8 NOT NULL DEFAULT '' COMMENT '组织名称',
  `status` tinyint(4) DEFAULT NULL COMMENT '状态',
  `type` varchar(32) CHARACTER SET utf8 DEFAULT '' COMMENT '组织类型 1：仓库 2：基地',
  `pid` bigint(20) DEFAULT NULL COMMENT '父ID',
  `level` int(32) DEFAULT '1' COMMENT '层级',
  `leaf` int(32) DEFAULT '0' COMMENT '是否叶子节点,1不是0是',
  `contact` varchar(32) CHARACTER SET utf8 DEFAULT '' COMMENT '联系人',
  `group_address` varchar(255) CHARACTER SET utf8 DEFAULT '' COMMENT '组织地址',
  `province_name` varchar(32) CHARACTER SET utf8 DEFAULT '' COMMENT '省名称',
  `province_id` bigint(20) DEFAULT NULL COMMENT '省编码',
  `city_name` varchar(32) CHARACTER SET utf8 DEFAULT '' COMMENT '城市名称',
  `city_id` bigint(20) DEFAULT NULL COMMENT '城市编码',
  `area_name` varchar(32) CHARACTER SET utf8 DEFAULT NULL COMMENT '区名称',
  `area_id` bigint(32) DEFAULT NULL COMMENT '区编码',
  `street_name` varchar(32) CHARACTER SET utf8 DEFAULT '' COMMENT '街道名称',
  `street_id` bigint(20) DEFAULT NULL COMMENT '街道编码',
  `detail_address` varchar(50) CHARACTER SET utf8 DEFAULT '' COMMENT '详细地址',
  `contact_phone` varchar(11) CHARACTER SET utf8 DEFAULT '' COMMENT '联系人手机号',
  `remark` varchar(300) CHARACTER SET utf8 DEFAULT NULL COMMENT '描述',
  `creator` varchar(20) CHARACTER SET utf8 DEFAULT '' COMMENT '创建人',
  `creator_id` bigint(20) DEFAULT NULL COMMENT '创建人ID',
  `created_time` datetime DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `last_operator` varchar(20) CHARACTER SET utf8 DEFAULT '' COMMENT '最近操作人',
  `last_operator_id` bigint(20) DEFAULT NULL COMMENT '最后操作人ID',
  `update_time` datetime DEFAULT CURRENT_TIMESTAMP COMMENT '更新时间',
  `number` int(11) DEFAULT '0' COMMENT '预留排序字段',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=387731953983557633 DEFAULT CHARSET=utf8mb4 COMMENT='角色表';

-- ----------------------------
-- Records of an_uac_group
-- ----------------------------
INSERT INTO `an_uac_group` VALUES ('1', '1', 'root', 'paascloud', '0', '1', '0', '1', '0', '刘先生', '北京市北京城区西城区', '北京市', '368100109646176256', '北京城区', '368100109679730688', '西城区', '368100109767811072', null, null, null, '155xxxxxxxx', null, 'admin', '1', '2017-12-05 22:45:26', 'admin', '1', '2017-12-05 22:45:26', '0');
INSERT INTO `an_uac_group` VALUES ('2', '2', 'test', '测试组织', '0', '1', '1', '2', '0', '刘先生', '北京市北京城区西城区', '北京市', '368100109646176256', '北京城区', '368100109679730688', '西城区', '368100109767811072', null, null, null, '155xxxxxxxx', null, 'admin', '1', '2017-12-05 22:45:26', 'admin', '1', '2017-12-05 22:45:26', '0');
INSERT INTO `an_uac_group` VALUES ('305783697070629888', '2', '123132', '32132144', '0', '2', '387731953983557632', '3', '0', '321', '山西省长治市长治县', '山西省', '368100116688412672', '长治市', '368100117644713984', '长治县', '368100117745377280', '', null, '32132144', '155xxxxxxxx', '32132144', '超级管理员', '1', '2018-02-26 21:37:37', '超级管理员', '1', '2018-02-26 21:37:57', '0');

-- ----------------------------
-- Table structure for an_uac_group_user
-- ----------------------------
DROP TABLE IF EXISTS `an_uac_group_user`;
CREATE TABLE `an_uac_group_user` (
  `group_id` bigint(20) NOT NULL COMMENT '角色ID',
  `user_id` bigint(20) NOT NULL COMMENT '菜单ID'
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='菜单与角色关联表';

-- ----------------------------
-- Records of an_uac_group_user
-- ----------------------------
INSERT INTO `an_uac_group_user` VALUES ('1', '1');

-- ----------------------------
-- Table structure for an_uac_log
-- ----------------------------
DROP TABLE IF EXISTS `an_uac_log`;
CREATE TABLE `an_uac_log` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT 'ID',
  `group_id` bigint(20) DEFAULT NULL COMMENT '组织流水号',
  `group_name` varchar(50) CHARACTER SET utf8 DEFAULT '' COMMENT '组织名称',
  `log_type` varchar(10) CHARACTER SET utf8 DEFAULT '' COMMENT '日志类型',
  `log_name` varchar(50) CHARACTER SET utf8 DEFAULT '' COMMENT '日志类型名称',
  `action_id` bigint(20) DEFAULT NULL COMMENT '权限ID',
  `action_code` varchar(100) CHARACTER SET utf8 DEFAULT '' COMMENT '权限编码',
  `action_name` varchar(255) CHARACTER SET utf8 DEFAULT '' COMMENT '权限名称',
  `os` varchar(20) CHARACTER SET utf8 DEFAULT '' COMMENT '操作系统',
  `browser` varchar(20) CHARACTER SET utf8 DEFAULT '' COMMENT '浏览器类型',
  `ip` varchar(50) CHARACTER SET utf8 DEFAULT '' COMMENT 'IP地址',
  `location` varchar(50) CHARACTER SET utf8 DEFAULT '' COMMENT '登录位置',
  `mac` varchar(20) CHARACTER SET utf8 DEFAULT '' COMMENT '物理地址',
  `description` varchar(1000) CHARACTER SET utf8 DEFAULT '' COMMENT '详细描述',
  `request_data` varchar(4000) CHARACTER SET utf8 DEFAULT '' COMMENT '请求参数',
  `request_url` varchar(2000) CHARACTER SET utf8 DEFAULT '' COMMENT '请求地址',
  `response_data` varchar(4000) CHARACTER SET utf8 DEFAULT '' COMMENT '响应结果',
  `class_name` varchar(100) CHARACTER SET utf8 DEFAULT '' COMMENT '类名',
  `method_name` varchar(100) CHARACTER SET utf8 DEFAULT '' COMMENT '方法名',
  `start_time` timestamp NULL DEFAULT NULL COMMENT '开始时间',
  `end_time` timestamp NULL DEFAULT NULL COMMENT '结束时间',
  `excute_time` int(11) DEFAULT NULL COMMENT '耗时,秒',
  `creator` varchar(20) CHARACTER SET utf8 DEFAULT '' COMMENT '创建人',
  `creator_id` bigint(20) DEFAULT NULL COMMENT '创建人ID',
  `created_time` datetime DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `last_operator` varchar(20) CHARACTER SET utf8 DEFAULT '' COMMENT '最近操作人',
  `last_operator_id` bigint(20) DEFAULT NULL COMMENT '最后操作人ID',
  `update_time` datetime DEFAULT CURRENT_TIMESTAMP COMMENT '更新时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=778804319972492289 DEFAULT CHARSET=utf8mb4 COMMENT='日志表';

-- ----------------------------
-- Records of an_uac_log
-- ----------------------------
INSERT INTO `an_uac_log` VALUES ('778769229812859904', '1', 'paascloud', '20', '登录日志', null, '', '', 'Windows 10', 'Chrome', '127.0.0.1', '', '', '', '', '/auth/form', '', '', '', null, null, null, '超级管理员', '1', '2019-12-11 11:55:27', '超级管理员', '1', '2019-12-11 11:55:27');
INSERT INTO `an_uac_log` VALUES ('778787553577796608', '1', 'paascloud', '20', '登录日志', null, '', '', 'Windows 10', 'Chrome', '127.0.0.1', '', '', '', '', '/auth/form', '', '', '', null, null, null, '超级管理员', '1', '2019-12-11 12:31:51', '超级管理员', '1', '2019-12-11 12:31:51');
INSERT INTO `an_uac_log` VALUES ('778794650273055744', '1', 'paascloud', '20', '登录日志', null, '', '', 'Windows 10', 'Chrome', '127.0.0.1', '北京市', '', '', '', '/auth/form', '', '', '', null, null, null, '超级管理员', '1', '2019-12-11 12:45:57', '超级管理员', '1', '2019-12-11 12:45:57');
INSERT INTO `an_uac_log` VALUES ('778798455958012928', '1', 'paascloud', '20', '登录日志', null, '', '', 'Windows 10', 'Chrome', '127.0.0.1', '北京市', '', '', '', '/auth/form', '', '', '', null, null, null, '超级管理员', '1', '2019-12-11 12:53:31', '超级管理员', '1', '2019-12-11 12:53:31');
INSERT INTO `an_uac_log` VALUES ('778799430261277696', '1', 'paascloud', '20', '登录日志', null, '', '', 'Windows 10', 'Chrome', '127.0.0.1', '北京市', '', '', '', '/auth/form', '', '', '', null, null, null, '超级管理员', '1', '2019-12-11 12:55:27', '超级管理员', '1', '2019-12-11 12:55:27');
INSERT INTO `an_uac_log` VALUES ('778800410461733888', '1', 'paascloud', '20', '登录日志', null, '', '', 'Windows 10', 'Chrome', '127.0.0.1', '北京市', '', '', '', '/auth/form', '', '', '', null, null, null, '超级管理员', '1', '2019-12-11 12:57:24', '超级管理员', '1', '2019-12-11 12:57:24');
INSERT INTO `an_uac_log` VALUES ('778802697229829120', '1', 'paascloud', '20', '登录日志', null, '', '', 'Windows 10', 'Chrome', '127.0.0.1', '北京市', '', '', '', '/auth/form', '', '', '', null, null, null, '超级管理员', '1', '2019-12-11 13:01:56', '超级管理员', '1', '2019-12-11 13:01:56');
INSERT INTO `an_uac_log` VALUES ('778804319972492288', '1', 'paascloud', '20', '登录日志', null, '', '', 'Windows 10', 'Chrome', '127.0.0.1', '北京市', '', '', '', '/auth/form', '', '', '', null, null, null, '超级管理员', '1', '2019-12-11 13:05:10', '超级管理员', '1', '2019-12-11 13:05:10');

-- ----------------------------
-- Table structure for an_uac_menu
-- ----------------------------
DROP TABLE IF EXISTS `an_uac_menu`;
CREATE TABLE `an_uac_menu` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT 'ID',
  `version` int(11) DEFAULT '0' COMMENT '版本号',
  `menu_code` varchar(50) CHARACTER SET utf8 DEFAULT '' COMMENT '菜单编码',
  `menu_name` varchar(90) CHARACTER SET utf8 DEFAULT '' COMMENT '菜单名称',
  `status` varchar(20) CHARACTER SET utf8 DEFAULT '' COMMENT '状态',
  `url` varchar(150) CHARACTER SET utf8 DEFAULT '' COMMENT '菜单URL',
  `icon` varchar(100) CHARACTER SET utf8 DEFAULT '' COMMENT '图标',
  `pid` bigint(20) DEFAULT NULL COMMENT '父ID',
  `level` int(11) DEFAULT '1' COMMENT '层级(最多三级1,2,3)',
  `leaf` int(11) DEFAULT '0' COMMENT '是否叶子节点,1不是0是',
  `number` int(11) DEFAULT '0' COMMENT '序号',
  `remark` varchar(255) CHARACTER SET utf8 DEFAULT '' COMMENT '备注',
  `application_id` bigint(20) DEFAULT '1' COMMENT '系统编码',
  `creator` varchar(20) CHARACTER SET utf8 DEFAULT '' COMMENT '创建人',
  `creator_id` bigint(20) DEFAULT NULL COMMENT '创建人ID',
  `created_time` datetime DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `last_operator` varchar(20) CHARACTER SET utf8 DEFAULT '' COMMENT '最近操作人',
  `last_operator_id` bigint(20) DEFAULT NULL COMMENT '最后操作人ID',
  `update_time` datetime DEFAULT CURRENT_TIMESTAMP COMMENT '更新时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=399624517099589633 DEFAULT CHARSET=utf8mb4 COMMENT='菜单表';

-- ----------------------------
-- Records of an_uac_menu
-- ----------------------------
INSERT INTO `an_uac_menu` VALUES ('1', '1', 'root', '运营工作台', 'ENABLE', null, 'fa fa-y-combinator', '0', '0', '1', '0', '', '1', '超级管理员', '1', '2017-12-05 22:45:26', '超级管理员', '1', '2017-12-05 22:45:26');
INSERT INTO `an_uac_menu` VALUES ('11', '3', 'uas', '用户中心', 'ENABLE', '/uas', 'fa fa-bicycle', '1', '1', '1', '1', '', '1', '超级管理员', '1', '2017-12-05 22:45:26', 'admin', '1', '2018-02-26 21:11:21');
INSERT INTO `an_uac_menu` VALUES ('111', '3', 'xtsz', '系统管理', 'ENABLE', '/yxgl', 'fa fa-desktop', '11', '2', '0', '1', '', '1', '超级管理员', '1', '2017-12-05 22:45:26', 'admin', '1', '2018-02-26 21:11:21');
INSERT INTO `an_uac_menu` VALUES ('1111', '2', 'uas_role', '角色管理', 'ENABLE', '/uas/role/list', 'fa fa-hand-o-up', '111', '3', '1', '0', '', '1', '超级管理员', '1', '2017-12-05 22:45:26', 'admin', '1', '2018-02-26 21:11:21');
INSERT INTO `an_uac_menu` VALUES ('1112', '2', 'uas_user', '用户管理', 'ENABLE', '/uas/user/list', 'fa fa-user', '111', '3', '1', '0', '', '1', '超级管理员', '1', '2017-12-05 22:45:26', 'admin', '1', '2018-02-26 21:11:21');
INSERT INTO `an_uac_menu` VALUES ('1113', '2', 'uas_menu', '菜单管理', 'ENABLE', '/uas/menu/list', 'fa fa-paperclip', '111', '3', '1', '0', '', '1', '超级管理员', '1', '2017-12-05 22:45:26', 'admin', '1', '2018-02-26 21:11:21');
INSERT INTO `an_uac_menu` VALUES ('1114', '2', 'uas_action', '权限管理', 'ENABLE', '/uas/action/list', 'fa fa-firefox', '111', '3', '1', '0', '', '1', '超级管理员', '1', '2017-12-05 22:45:26', 'admin', '1', '2018-02-26 21:11:21');
INSERT INTO `an_uac_menu` VALUES ('1115', '2', 'uas_group', '组织管理', 'ENABLE', '/uas/group/list', 'fa fa-group', '111', '3', '1', '0', '', '1', '超级管理员', '1', '2017-12-05 22:45:26', 'admin', '1', '2018-02-26 21:11:21');
INSERT INTO `an_uac_menu` VALUES ('305766262338757632', '3', 'add1', '服丰富发', 'DISABLE', '/sajdsalj/asda2', 'aa1', '1', '1', '0', '1231', '', '1', '超级管理员', '1', '2018-02-26 21:02:59', 'admin', '1', '2018-02-26 21:05:10');
INSERT INTO `an_uac_menu` VALUES ('310861539236127744', '0', 'category', '商品分类', 'ENABLE', '/oms/category/list', 'fa fa-print', '386619141710286848', '2', '0', '5', '', '1', '超级管理员', '1', '2018-03-05 21:46:23', '超级管理员', '1', '2018-03-05 21:46:49');
INSERT INTO `an_uac_menu` VALUES ('314345986317100032', '0', 'exception', '异常日志监控', 'ENABLE', '/uas/monitor/exception', 'fa fa-indent', '389537489083305984', '3', '0', '7', '', '1', '超级管理员', '1', '2018-03-10 17:09:22', '超级管理员', '1', '2018-03-11 19:39:01');
INSERT INTO `an_uac_menu` VALUES ('314534993634272256', '0', 'message', '消息管理', 'ENABLE', '/message', 'fa fa-envelope-o', '399621965209538560', '2', '1', '2', '', '1', '超级管理员', '1', '2018-03-10 23:24:53', '超级管理员', '1', '2018-03-11 19:34:41');
INSERT INTO `an_uac_menu` VALUES ('314536915506308096', '0', 'reliable_message', '可靠消息', 'ENABLE', '/mds/message/reliable', 'fa fa-envelope-o', '314534993634272256', '3', '0', '1', '', '1', '超级管理员', '1', '2018-03-10 23:28:42', '超级管理员', '1', '2018-03-11 19:37:26');
INSERT INTO `an_uac_menu` VALUES ('314537372735775744', '0', 'ran_message', '消息记录', 'ENABLE', '/mds/message/record', 'fa fa-envelope-o', '314534993634272256', '3', '0', '1', '', '1', '超级管理员', '1', '2018-03-10 23:29:37', '超级管理员', '1', '2018-03-11 19:37:40');
INSERT INTO `an_uac_menu` VALUES ('386619141710286848', '0', 'oms', '订单中心', 'ENABLE', '/oms', 'fa fa-plug', '1', '1', '1', '2', '订单中心', '1', '超级管理员', '1', '2017-12-05 22:45:26', '超级管理员', '1', '2017-12-05 22:45:26');
INSERT INTO `an_uac_menu` VALUES ('386619314180067328', '0', 'product', '商品管理', 'ENABLE', '/oms/product/list', 'fa fa-print', '386619141710286848', '2', '0', '0', '', '1', '超级管理员', '1', '2017-12-05 22:45:26', '超级管理员', '1', '2017-12-05 22:45:26');
INSERT INTO `an_uac_menu` VALUES ('386619554962477056', '0', 'shipping', '收货地址', 'ENABLE', '/oms/shipping/list', 'fa fa-diamond', '386619141710286848', '2', '0', '0', '', '1', '超级管理员', '1', '2017-12-05 22:45:26', '超级管理员', '1', '2017-12-05 22:45:26');
INSERT INTO `an_uac_menu` VALUES ('386619669785743360', '0', 'order', '订单管理', 'ENABLE', '/oms/order/list', 'fa fa-life-ring', '386619141710286848', '2', '0', '0', '', '1', '超级管理员', '1', '2017-12-05 22:45:26', '超级管理员', '1', '2017-12-05 22:45:26');
INSERT INTO `an_uac_menu` VALUES ('386619770943967232', '0', 'cart', '购物车管理', 'ENABLE', '/oms/cart/list', '', '386619141710286848', '2', '0', '6', '', '1', '超级管理员', '1', '2018-03-12 11:40:32', '超级管理员', '1', '2018-03-12 11:40:32');
INSERT INTO `an_uac_menu` VALUES ('389537489083305984', '2', 'uac_monitor', '运营监控', 'ENABLE', '/uas/monitor', 'fa fa-bar-chart', '11', '2', '1', '2', '', '1', '超级管理员', '1', '2017-12-10 22:02:55', '超级管理员', '1', '2018-03-11 19:43:30');
INSERT INTO `an_uac_menu` VALUES ('389537927648120832', '2', 'monitor_zipkin', '调用链监控', 'ENABLE', '/uas/monitor/zipkin', 'fa fa-gavel', '389537489083305984', '3', '0', '1', '', '1', '超级管理员', '1', '2017-12-10 22:04:39', '超级管理员', '1', '2018-03-11 19:40:00');
INSERT INTO `an_uac_menu` VALUES ('389538226760716288', '2', 'monitor_swagger_uac', '接口文档', 'ENABLE', '/uas/monitor/swagger', 'fa fa-calculator', '389537489083305984', '3', '0', '1', '', '1', '超级管理员', '1', '2017-12-10 22:05:51', '超级管理员', '1', '2018-03-11 19:42:29');
INSERT INTO `an_uac_menu` VALUES ('389538504239091712', '2', 'monitor_druid', '数据库监控', 'ENABLE', '/uas/monitor/druid', 'fa fa-bug', '389537489083305984', '3', '0', '1', '', '1', '超级管理员', '1', '2017-12-10 22:06:57', '超级管理员', '1', '2018-03-11 19:42:55');
INSERT INTO `an_uac_menu` VALUES ('389538784145969152', '2', 'monitor_boot', '监控报警', 'ENABLE', '/uas/monitor/boot', 'fa fa-book', '389537489083305984', '3', '0', '1', '', '1', '超级管理员', '1', '2017-12-10 22:08:03', '超级管理员', '1', '2018-03-11 19:40:44');
INSERT INTO `an_uac_menu` VALUES ('397128438818934784', '2', 'log', '操作日志监控', 'ENABLE', '/uas/monitor/log', 'fa fa-futbol-o', '389537489083305984', '3', '0', '5', '', '1', '超级管理员', '1', '2017-12-31 20:46:38', 'admin', '1', '2018-02-26 21:11:21');
INSERT INTO `an_uac_menu` VALUES ('397129746489675776', '2', 'token', '登录密钥监控', 'ENABLE', '/uas/monitor/token', 'fa fa-sort-amount-asc', '389537489083305984', '3', '0', '6', '', '1', '超级管理员', '1', '2017-12-31 20:51:50', 'admin', '1', '2018-02-26 21:11:21');
INSERT INTO `an_uac_menu` VALUES ('399621965209538560', '0', 'mds', '数据中心', 'ENABLE', '/mds', 'fa fa-tree', '1', '1', '1', '2', '', '1', '超级管理员', '1', '2018-01-07 17:55:01', '超级管理员', '1', '2018-01-07 17:55:01');
INSERT INTO `an_uac_menu` VALUES ('399622376637206528', '0', 'config', '配置管理', 'ENABLE', '/config', 'fa fa-cog', '399621965209538560', '2', '1', '1', '', '1', '超级管理员', '1', '2018-01-07 17:56:39', '超级管理员', '1', '2018-01-22 16:00:40');
INSERT INTO `an_uac_menu` VALUES ('399622908055523328', '0', 'topic', 'Topic管理', 'ENABLE', '/mds/topic/list', 'fa fa-bars', '399622376637206528', '3', '0', '1', '', '1', '超级管理员', '1', '2018-01-07 17:58:46', '超级管理员', '1', '2018-01-07 19:17:50');
INSERT INTO `an_uac_menu` VALUES ('399623029472235520', '0', 'tag', 'Tag管理', 'ENABLE', '/mds/tag/list', 'fa fa-hand-rock-o', '399622376637206528', '3', '0', '2', '', '1', '超级管理员', '1', '2018-01-07 17:59:15', '超级管理员', '1', '2018-01-07 19:18:05');
INSERT INTO `an_uac_menu` VALUES ('399623393500073984', '0', 'producer', '生产者管理', 'ENABLE', '/mds/producer/list', 'fa fa-hand-o-right', '399622376637206528', '3', '0', '3', '', '1', '超级管理员', '1', '2018-01-07 18:00:42', '超级管理员', '1', '2018-01-07 19:18:10');
INSERT INTO `an_uac_menu` VALUES ('399623576635969536', '0', 'consumer', '消费者管理', 'ENABLE', '/mds/consumer/list', 'fa fa-hand-pointer-o', '399622376637206528', '3', '0', '4', '', '1', '超级管理员', '1', '2018-01-07 18:01:25', '超级管理员', '1', '2018-01-07 19:18:14');
INSERT INTO `an_uac_menu` VALUES ('399623736623501312', '0', 'dist', '数据字典', 'ENABLE', '/mds/dict/list', 'fa fa-book', '399622376637206528', '3', '0', '0', '', '1', '超级管理员', '1', '2018-01-07 18:02:03', '超级管理员', '1', '2018-01-22 16:01:33');
INSERT INTO `an_uac_menu` VALUES ('399624320957157376', '0', 'publish', '发布管理', 'ENABLE', '/mds/publish/list', 'fa fa-hourglass-end', '399622376637206528', '3', '0', '5', '', '1', '超级管理员', '1', '2018-01-07 18:04:23', '超级管理员', '1', '2018-01-07 19:18:20');
INSERT INTO `an_uac_menu` VALUES ('399624517099589632', '2', 'subscribe', '订阅管理', 'ENABLE', '/mds/subscribe/list', 'fa fa-pencil', '399622376637206528', '3', '1', '6', '', '1', '超级管理员', '1', '2018-01-07 18:05:10', 'admin', '1', '2018-02-26 21:08:32');

-- ----------------------------
-- Table structure for an_uac_role
-- ----------------------------
DROP TABLE IF EXISTS `an_uac_role`;
CREATE TABLE `an_uac_role` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT 'ID',
  `version` int(11) DEFAULT '0' COMMENT '版本号',
  `role_code` varchar(20) CHARACTER SET utf8 DEFAULT '' COMMENT '角色编码',
  `role_name` varchar(90) CHARACTER SET utf8 DEFAULT '' COMMENT '角色名称',
  `status` varchar(20) CHARACTER SET utf8 DEFAULT '' COMMENT '状态',
  `remark` varchar(300) CHARACTER SET utf8 DEFAULT '' COMMENT '备注',
  `creator` varchar(20) CHARACTER SET utf8 DEFAULT '' COMMENT '创建人',
  `creator_id` bigint(20) DEFAULT NULL COMMENT '创建人ID',
  `created_time` datetime DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `last_operator` varchar(20) CHARACTER SET utf8 DEFAULT '' COMMENT '最近操作人',
  `last_operator_id` bigint(20) DEFAULT NULL COMMENT '最后操作人ID',
  `update_time` datetime DEFAULT CURRENT_TIMESTAMP COMMENT '更新时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=396741611725393921 DEFAULT CHARSET=utf8mb4 COMMENT='角色表';

-- ----------------------------
-- Records of an_uac_role
-- ----------------------------
INSERT INTO `an_uac_role` VALUES ('1', '1', 'admin', '超级管理员', 'ENABLE', null, 'admin', '1', '2017-12-05 22:45:26', 'admin', '1', '2017-12-05 22:45:26');
INSERT INTO `an_uac_role` VALUES ('2', '0', 'developer', '开发人员', 'ENABLE', null, 'admin', '1', '2017-12-05 22:45:26', 'admin', '1', '2017-12-05 22:45:26');
INSERT INTO `an_uac_role` VALUES ('3', '0', 'test', '测试人员', 'DISABLE', null, 'admin', '1', '2017-12-05 22:45:26', 'admin', '1', '2017-12-05 22:45:26');
INSERT INTO `an_uac_role` VALUES ('4', '0', 'master', '管理员', 'ENABLE', null, 'admin', '1', '2017-12-05 22:45:26', 'admin', '1', '2017-12-05 22:45:26');
INSERT INTO `an_uac_role` VALUES ('10000', '1', 'visiter', '普通用户', 'ENABLE', '', 'admin', '1', '2017-12-05 22:45:26', '超级管理员', '1', '2017-12-05 22:45:26');
INSERT INTO `an_uac_role` VALUES ('315998797551379456', '0', '222', '测试', 'ENABLE', '222', '超级管理员', '1', '2017-12-05 22:45:26', '超级管理员', '1', '2017-12-05 22:45:26');

-- ----------------------------
-- Table structure for an_uac_role_action
-- ----------------------------
DROP TABLE IF EXISTS `an_uac_role_action`;
CREATE TABLE `an_uac_role_action` (
  `role_id` bigint(20) NOT NULL,
  `action_id` bigint(20) NOT NULL,
  PRIMARY KEY (`role_id`,`action_id`),
  KEY `FKfe9od4909llybiub42s3ifvcl` (`action_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='角色权限中间表';

-- ----------------------------
-- Records of an_uac_role_action
-- ----------------------------
INSERT INTO `an_uac_role_action` VALUES ('4', '100001');
INSERT INTO `an_uac_role_action` VALUES ('4', '100005');
INSERT INTO `an_uac_role_action` VALUES ('10000', '305772209559839744');
INSERT INTO `an_uac_role_action` VALUES ('10000', '308015564217918464');
INSERT INTO `an_uac_role_action` VALUES ('10000', '308015817025397760');
INSERT INTO `an_uac_role_action` VALUES ('10000', '308016353694983168');
INSERT INTO `an_uac_role_action` VALUES ('10000', '308016771179226112');
INSERT INTO `an_uac_role_action` VALUES ('10000', '308017000884478976');
INSERT INTO `an_uac_role_action` VALUES ('10000', '308017290090128384');
INSERT INTO `an_uac_role_action` VALUES ('10000', '308017803162559488');
INSERT INTO `an_uac_role_action` VALUES ('10000', '308018047321383936');
INSERT INTO `an_uac_role_action` VALUES ('10000', '308699944489853952');
INSERT INTO `an_uac_role_action` VALUES ('10000', '387558460746764288');
INSERT INTO `an_uac_role_action` VALUES ('387665279259381760', '387558460746764288');
INSERT INTO `an_uac_role_action` VALUES ('387665279259381760', '387560278130298880');

-- ----------------------------
-- Table structure for an_uac_role_group
-- ----------------------------
DROP TABLE IF EXISTS `an_uac_role_group`;
CREATE TABLE `an_uac_role_group` (
  `role_id` bigint(20) NOT NULL,
  `group_id` bigint(20) NOT NULL,
  PRIMARY KEY (`role_id`,`group_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of an_uac_role_group
-- ----------------------------

-- ----------------------------
-- Table structure for an_uac_role_menu
-- ----------------------------
DROP TABLE IF EXISTS `an_uac_role_menu`;
CREATE TABLE `an_uac_role_menu` (
  `role_id` bigint(20) NOT NULL COMMENT '角色ID',
  `menu_id` bigint(20) NOT NULL COMMENT '菜单ID',
  PRIMARY KEY (`role_id`,`menu_id`),
  KEY `FK1ckt8kop21ihi6stv1j3ifr8p` (`menu_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='角色菜单中间表';

-- ----------------------------
-- Records of an_uac_role_menu
-- ----------------------------
INSERT INTO `an_uac_role_menu` VALUES ('0', '0');
INSERT INTO `an_uac_role_menu` VALUES ('1', '1');
INSERT INTO `an_uac_role_menu` VALUES ('1', '11');
INSERT INTO `an_uac_role_menu` VALUES ('1', '111');
INSERT INTO `an_uac_role_menu` VALUES ('1', '1111');
INSERT INTO `an_uac_role_menu` VALUES ('4', '1111');
INSERT INTO `an_uac_role_menu` VALUES ('10000', '1111');
INSERT INTO `an_uac_role_menu` VALUES ('387665279259381760', '1111');
INSERT INTO `an_uac_role_menu` VALUES ('1', '1112');
INSERT INTO `an_uac_role_menu` VALUES ('10000', '1112');
INSERT INTO `an_uac_role_menu` VALUES ('387665279259381760', '1112');
INSERT INTO `an_uac_role_menu` VALUES ('1', '1113');
INSERT INTO `an_uac_role_menu` VALUES ('4', '1113');
INSERT INTO `an_uac_role_menu` VALUES ('10000', '1113');
INSERT INTO `an_uac_role_menu` VALUES ('1', '1114');
INSERT INTO `an_uac_role_menu` VALUES ('4', '1114');
INSERT INTO `an_uac_role_menu` VALUES ('10000', '1114');
INSERT INTO `an_uac_role_menu` VALUES ('387665279259381760', '1114');
INSERT INTO `an_uac_role_menu` VALUES ('1', '1115');
INSERT INTO `an_uac_role_menu` VALUES ('10000', '1115');
INSERT INTO `an_uac_role_menu` VALUES ('10000', '310861539236127744');
INSERT INTO `an_uac_role_menu` VALUES ('10000', '314345986317100032');
INSERT INTO `an_uac_role_menu` VALUES ('10000', '314536915506308096');
INSERT INTO `an_uac_role_menu` VALUES ('10000', '314537372735775744');
INSERT INTO `an_uac_role_menu` VALUES ('10000', '386619314180067328');
INSERT INTO `an_uac_role_menu` VALUES ('10000', '386619554962477056');
INSERT INTO `an_uac_role_menu` VALUES ('10000', '386619669785743360');
INSERT INTO `an_uac_role_menu` VALUES ('10000', '389537927648120832');
INSERT INTO `an_uac_role_menu` VALUES ('10000', '389538226760716288');
INSERT INTO `an_uac_role_menu` VALUES ('10000', '389538504239091712');
INSERT INTO `an_uac_role_menu` VALUES ('10000', '389538784145969152');
INSERT INTO `an_uac_role_menu` VALUES ('10000', '397128438818934784');
INSERT INTO `an_uac_role_menu` VALUES ('10000', '397129746489675776');
INSERT INTO `an_uac_role_menu` VALUES ('10000', '399622908055523328');
INSERT INTO `an_uac_role_menu` VALUES ('10000', '399623029472235520');
INSERT INTO `an_uac_role_menu` VALUES ('10000', '399623393500073984');
INSERT INTO `an_uac_role_menu` VALUES ('10000', '399623576635969536');
INSERT INTO `an_uac_role_menu` VALUES ('10000', '399623736623501312');
INSERT INTO `an_uac_role_menu` VALUES ('10000', '399624320957157376');
INSERT INTO `an_uac_role_menu` VALUES ('10000', '399624517099589632');

-- ----------------------------
-- Table structure for an_uac_role_user
-- ----------------------------
DROP TABLE IF EXISTS `an_uac_role_user`;
CREATE TABLE `an_uac_role_user` (
  `role_id` bigint(20) NOT NULL,
  `user_id` bigint(20) NOT NULL,
  PRIMARY KEY (`role_id`,`user_id`),
  KEY `FKdumjqlt1wyblqtana3ag0qhtf` (`user_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='角色用户中间表';

-- ----------------------------
-- Records of an_uac_role_user
-- ----------------------------

-- ----------------------------
-- Table structure for an_uac_user
-- ----------------------------
DROP TABLE IF EXISTS `an_uac_user`;
CREATE TABLE `an_uac_user` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT 'ID',
  `version` int(11) DEFAULT '0' COMMENT '版本号',
  `login_name` varchar(50) DEFAULT '' COMMENT '登录名',
  `login_pwd` varchar(300) DEFAULT '' COMMENT '登录密码',
  `salt` varchar(32) DEFAULT '' COMMENT '盐,用于shiro加密, 字段停用',
  `user_code` varchar(32) DEFAULT '' COMMENT '工号',
  `user_name` varchar(50) DEFAULT '' COMMENT '姓名',
  `mobile_no` varchar(15) DEFAULT '' COMMENT '手机号',
  `email` varchar(50) DEFAULT '' COMMENT '邮件地址',
  `status` varchar(20) DEFAULT '' COMMENT '状态',
  `user_source` varchar(32) DEFAULT '' COMMENT '用户来源',
  `type` varchar(32) DEFAULT '' COMMENT '操作员类型（2000伙伴，3000客户，1000运营）',
  `last_login_ip` varchar(20) DEFAULT '' COMMENT '最后登录IP地址',
  `last_login_location` varchar(50) DEFAULT '' COMMENT '最后登录位置',
  `remark` varchar(300) DEFAULT '' COMMENT '描述',
  `last_login_time` datetime DEFAULT NULL COMMENT '最后登录时间',
  `is_changed_pwd` smallint(6) DEFAULT '0' COMMENT '是否更改过密码',
  `pwd_error_count` smallint(6) DEFAULT '0' COMMENT '连续输错密码次数（连续5次输错就冻结帐号）',
  `pwd_error_time` datetime DEFAULT NULL COMMENT '最后输错密码时间',
  `creator` varchar(20) DEFAULT '' COMMENT '创建人',
  `creator_id` bigint(20) DEFAULT NULL COMMENT '创建人ID',
  `created_time` datetime DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `last_operator` varchar(20) DEFAULT '' COMMENT '最近操作人',
  `last_operator_id` bigint(20) DEFAULT NULL COMMENT '最后操作人ID',
  `update_time` datetime DEFAULT CURRENT_TIMESTAMP COMMENT '更新时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=387614405153656833 DEFAULT CHARSET=utf8 COMMENT='操作员表';

-- ----------------------------
-- Records of an_uac_user
-- ----------------------------
INSERT INTO `an_uac_user` VALUES ('1', '1', 'admin', '$2a$10$LvlRXYpsKRdqahrB/AxQmuQBKyfzD9svcYWd7WLi5aPTNYx3BzvKG', '380048354543013888', 'admin', '超级管理员', '15522222222', '15522222222@163.com', 'ENABLE', '', '', '127.0.0.1', '北京市', '', '2019-12-11 13:05:10', '1', '1', '2017-06-13 18:52:54', 'admin', '1', '2017-12-05 22:45:26', 'admin1', '1', '2017-12-05 22:45:26');

-- ----------------------------
-- Table structure for an_uac_user_menu
-- ----------------------------
DROP TABLE IF EXISTS `an_uac_user_menu`;
CREATE TABLE `an_uac_user_menu` (
  `user_id` bigint(32) DEFAULT NULL COMMENT '用户id',
  `menu_id` bigint(32) DEFAULT NULL COMMENT '菜单id',
  `number` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='用户菜单中间表';

-- ----------------------------
-- Records of an_uac_user_menu
-- ----------------------------

-- ----------------------------
-- Table structure for an_uac_user_token
-- ----------------------------
DROP TABLE IF EXISTS `an_uac_user_token`;
CREATE TABLE `an_uac_user_token` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT 'ID',
  `version` int(11) DEFAULT '0' COMMENT '版本号',
  `pid` bigint(20) DEFAULT NULL COMMENT '父ID',
  `login_name` varchar(50) CHARACTER SET utf8 DEFAULT '' COMMENT '登录名',
  `user_name` varchar(50) CHARACTER SET utf8 DEFAULT '' COMMENT '姓名',
  `user_id` bigint(20) DEFAULT NULL COMMENT '用户ID',
  `os` varchar(20) CHARACTER SET utf8 DEFAULT '' COMMENT '操作系统',
  `browser` varchar(20) CHARACTER SET utf8 DEFAULT '' COMMENT '浏览器',
  `login_ip` varchar(20) CHARACTER SET utf8 DEFAULT '' COMMENT '登陆人Ip地址',
  `login_location` varchar(50) CHARACTER SET utf8 DEFAULT '' COMMENT '登录地址',
  `login_time` datetime DEFAULT CURRENT_TIMESTAMP COMMENT '登录时间',
  `access_token` varchar(2000) CHARACTER SET utf8 DEFAULT '' COMMENT '访问token',
  `refresh_token` varchar(2000) CHARACTER SET utf8 DEFAULT '' COMMENT '刷新token',
  `token_type` varchar(20) CHARACTER SET utf8 DEFAULT '' COMMENT 'token类型',
  `access_token_validity` int(11) DEFAULT NULL COMMENT '访问token的生效时间(秒)',
  `refresh_token_validity` int(11) DEFAULT NULL COMMENT '刷新token的生效时间(秒)',
  `status` int(11) DEFAULT '0' COMMENT '0 在线 10已刷新 20 离线',
  `group_id` bigint(20) DEFAULT NULL COMMENT '组织ID',
  `group_name` varchar(50) CHARACTER SET utf8 DEFAULT '' COMMENT '组织名称',
  `creator` varchar(20) CHARACTER SET utf8 DEFAULT '' COMMENT '创建人',
  `creator_id` bigint(20) DEFAULT NULL COMMENT '创建人ID',
  `created_time` datetime DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `last_operator` varchar(20) CHARACTER SET utf8 DEFAULT '' COMMENT '最近操作人',
  `last_operator_id` bigint(20) DEFAULT NULL COMMENT '最后操作人ID',
  `update_time` datetime DEFAULT CURRENT_TIMESTAMP COMMENT '更新时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=778804319745999873 DEFAULT CHARSET=utf8mb4 COMMENT='用户Token统计表';

-- ----------------------------
-- Records of an_uac_user_token
-- ----------------------------
INSERT INTO `an_uac_user_token` VALUES ('778769220786717696', '0', null, 'admin', '超级管理员', '1', 'Windows 10', 'Chrome', '127.0.0.1', '', '2018-03-15 22:25:26', 'eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJ1c2VyX25hbWUiOiJhZG1pbiIsInNjb3BlIjpbIioiXSwibG9naW5OYW1lIjoiYWRtaW4iLCJleHAiOjE1NzYwNDM3MjMsImF1dGhvcml0aWVzIjpbIi9jYXJ0L2RlbGV0ZVByb2R1Y3QvKiIsIi9tZW51L3NhdmUiLCIvcm9sZS9iaW5kQWN0aW9uIiwiL2FjdGlvbi9kZWxldGVBY3Rpb25CeUlkLyoiLCIvbWVudS9tb2RpZnlTdGF0dXMiLCIvb21jL3Byb2R1Y3QvZGVsZXRlUHJvZHVjdEJ5SWQvKiIsIi9yb2xlL2RlbGV0ZVJvbGVCeUlkLyoiLCIvb21jL2NhdGVnb3J5L2RlbGV0ZUJ5SWQvKiIsIi9kaWN0L21vZGlmeVN0YXR1cyIsIi9vcmRlci9jcmVhdGVPcmRlckRvYy8qIiwiL2VtYWlsL3NlbmRSZXN0RW1haWxDb2RlIiwiL21lbnUvZGVsZXRlQnlJZC8qIiwiL2dyb3VwL2RlbGV0ZUJ5SWQvKiIsIi91c2VyL2JpbmRSb2xlIiwiL3NoaXBwaW5nL3NldERlZmF1bHRBZGRyZXNzLyoiLCIvYWN0aW9uL21vZGlmeVN0YXR1cyIsIi9ncm91cC9zYXZlIiwiL2dyb3VwL2JpbmRVc2VyIiwiL2RpY3Qvc2F2ZSIsIi9hY3Rpb24vY2hlY2tVcmwiLCIvYWN0aW9uL2JhdGNoRGVsZXRlQnlJZExpc3QiLCIvY2FydC9zZWxlY3RBbGxQcm9kdWN0IiwiL2FjdGlvbi9jaGVja0FjdGlvbkNvZGUiLCIvb3JkZXIvY2FuY2VsT3JkZXJEb2MvKiIsIi9yb2xlL21vZGlmeVJvbGVTdGF0dXNCeUlkIiwiL3NoaXBwaW5nL2RlbGV0ZVNoaXBwaW5nLyoiLCIvY2FydC91blNlbGVjdFByb2R1Y3QvKiIsIi9zaGlwcGluZy91cGRhdGVTaGlwcGluZy8qIiwiL2dyb3VwL21vZGlmeVN0YXR1cyIsIi9yb2xlL2JpbmRVc2VyIiwiL3VhYy9yb2xlL3F1ZXJ5TGlzdCIsIi9vbWMvcHJvZHVjdC9zYXZlIiwiL3BheS9hbGlwYXlDYWxsYmFjayIsIi9vbWMvY2F0ZWdvcnkvbW9kaWZ5U3RhdHVzIiwiL2NhcnQvdXBkYXRlSW5mb3JtYXRpb24iLCIvY2FydC91blNlbGVjdEFsbFByb2R1Y3QiLCIvZGljdC9kZWxldGVCeUlkLyoiLCIvdXNlci9zYXZlIiwiL2NhcnQvdXBkYXRlUHJvZHVjdC8qKiIsIi91c2VyL3Jlc2V0TG9naW5Qd2QiLCIvcGF5L2NyZWF0ZVFyQ29kZUltYWdlLyoiLCIvYWN0aW9uL3F1ZXJ5TGlzdFdpdGhQYWdlIiwiL2NhcnQvc2VsZWN0UHJvZHVjdC8qIiwiL2NhcnQvYWRkUHJvZHVjdC8qKiIsIi9yb2xlL3NhdmUiLCIvYWN0aW9uL3NhdmUiLCIvdXNlci9tb2RpZnlVc2VyU3RhdHVzQnlJZCIsIi9zaGlwcGluZy9hZGRTaGlwcGluZyIsIi9vbWMvY2F0ZWdvcnkvc2F2ZSIsIi9yb2xlL2JpbmRNZW51IiwiL3JvbGUvYmF0Y2hEZWxldGVCeUlkTGlzdCJdLCJqdGkiOiJlNDRlNTYzZS1lZGNmLTQ5ZDAtOGUyZS00OTIyNmM1MWVkY2YiLCJjbGllbnRfaWQiOiJhbmFub3BzLWNsaWVudC11YWMiLCJ0aW1lc3RhbXAiOjE1NzYwMzY1MjMyMTB9.bJJaKavhCgQd2VRKnoPCIG1eS2ifZJrmXne35lgqmcE', 'eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJ1c2VyX25hbWUiOiJhZG1pbiIsInNjb3BlIjpbIioiXSwibG9naW5OYW1lIjoiYWRtaW4iLCJhdGkiOiJlNDRlNTYzZS1lZGNmLTQ5ZDAtOGUyZS00OTIyNmM1MWVkY2YiLCJleHAiOjE1Nzg2Mjg1MjMsImF1dGhvcml0aWVzIjpbIi9jYXJ0L2RlbGV0ZVByb2R1Y3QvKiIsIi9tZW51L3NhdmUiLCIvcm9sZS9iaW5kQWN0aW9uIiwiL2FjdGlvbi9kZWxldGVBY3Rpb25CeUlkLyoiLCIvbWVudS9tb2RpZnlTdGF0dXMiLCIvb21jL3Byb2R1Y3QvZGVsZXRlUHJvZHVjdEJ5SWQvKiIsIi9yb2xlL2RlbGV0ZVJvbGVCeUlkLyoiLCIvb21jL2NhdGVnb3J5L2RlbGV0ZUJ5SWQvKiIsIi9kaWN0L21vZGlmeVN0YXR1cyIsIi9vcmRlci9jcmVhdGVPcmRlckRvYy8qIiwiL2VtYWlsL3NlbmRSZXN0RW1haWxDb2RlIiwiL21lbnUvZGVsZXRlQnlJZC8qIiwiL2dyb3VwL2RlbGV0ZUJ5SWQvKiIsIi91c2VyL2JpbmRSb2xlIiwiL3NoaXBwaW5nL3NldERlZmF1bHRBZGRyZXNzLyoiLCIvYWN0aW9uL21vZGlmeVN0YXR1cyIsIi9ncm91cC9zYXZlIiwiL2dyb3VwL2JpbmRVc2VyIiwiL2RpY3Qvc2F2ZSIsIi9hY3Rpb24vY2hlY2tVcmwiLCIvYWN0aW9uL2JhdGNoRGVsZXRlQnlJZExpc3QiLCIvY2FydC9zZWxlY3RBbGxQcm9kdWN0IiwiL2FjdGlvbi9jaGVja0FjdGlvbkNvZGUiLCIvb3JkZXIvY2FuY2VsT3JkZXJEb2MvKiIsIi9yb2xlL21vZGlmeVJvbGVTdGF0dXNCeUlkIiwiL3NoaXBwaW5nL2RlbGV0ZVNoaXBwaW5nLyoiLCIvY2FydC91blNlbGVjdFByb2R1Y3QvKiIsIi9zaGlwcGluZy91cGRhdGVTaGlwcGluZy8qIiwiL2dyb3VwL21vZGlmeVN0YXR1cyIsIi9yb2xlL2JpbmRVc2VyIiwiL3VhYy9yb2xlL3F1ZXJ5TGlzdCIsIi9vbWMvcHJvZHVjdC9zYXZlIiwiL3BheS9hbGlwYXlDYWxsYmFjayIsIi9vbWMvY2F0ZWdvcnkvbW9kaWZ5U3RhdHVzIiwiL2NhcnQvdXBkYXRlSW5mb3JtYXRpb24iLCIvY2FydC91blNlbGVjdEFsbFByb2R1Y3QiLCIvZGljdC9kZWxldGVCeUlkLyoiLCIvdXNlci9zYXZlIiwiL2NhcnQvdXBkYXRlUHJvZHVjdC8qKiIsIi91c2VyL3Jlc2V0TG9naW5Qd2QiLCIvcGF5L2NyZWF0ZVFyQ29kZUltYWdlLyoiLCIvYWN0aW9uL3F1ZXJ5TGlzdFdpdGhQYWdlIiwiL2NhcnQvc2VsZWN0UHJvZHVjdC8qIiwiL2NhcnQvYWRkUHJvZHVjdC8qKiIsIi9yb2xlL3NhdmUiLCIvYWN0aW9uL3NhdmUiLCIvdXNlci9tb2RpZnlVc2VyU3RhdHVzQnlJZCIsIi9zaGlwcGluZy9hZGRTaGlwcGluZyIsIi9vbWMvY2F0ZWdvcnkvc2F2ZSIsIi9yb2xlL2JpbmRNZW51IiwiL3JvbGUvYmF0Y2hEZWxldGVCeUlkTGlzdCJdLCJqdGkiOiJkMGNkNTg1Mi1iZjdmLTRkNmEtOWZkMS1lZGY0ZTM1M2NhYTUiLCJjbGllbnRfaWQiOiJhbmFub3BzLWNsaWVudC11YWMiLCJ0aW1lc3RhbXAiOjE1NzYwMzY1MjMyMTB9.dYqTvmmnAV_9ZJIe1TEpmQ7EmKrYWSm7lpK-4jW3D0c', '', '7200', '2592000', '0', '1', 'paascloud', '超级管理员', '1', '2019-12-11 11:55:26', '超级管理员', '1', '2019-12-11 11:55:26');
INSERT INTO `an_uac_user_token` VALUES ('778787552294339584', '0', null, 'admin', '超级管理员', '1', 'Windows 10', 'Chrome', '127.0.0.1', '', '2019-12-11 11:55:26', 'eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJ1c2VyX25hbWUiOiJhZG1pbiIsInNjb3BlIjpbIioiXSwibG9naW5OYW1lIjoiYWRtaW4iLCJleHAiOjE1NzYwNDU5MTAsImF1dGhvcml0aWVzIjpbIi9jYXJ0L2RlbGV0ZVByb2R1Y3QvKiIsIi9tZW51L3NhdmUiLCIvcm9sZS9iaW5kQWN0aW9uIiwiL2FjdGlvbi9kZWxldGVBY3Rpb25CeUlkLyoiLCIvbWVudS9tb2RpZnlTdGF0dXMiLCIvb21jL3Byb2R1Y3QvZGVsZXRlUHJvZHVjdEJ5SWQvKiIsIi9yb2xlL2RlbGV0ZVJvbGVCeUlkLyoiLCIvb21jL2NhdGVnb3J5L2RlbGV0ZUJ5SWQvKiIsIi9kaWN0L21vZGlmeVN0YXR1cyIsIi9vcmRlci9jcmVhdGVPcmRlckRvYy8qIiwiL2VtYWlsL3NlbmRSZXN0RW1haWxDb2RlIiwiL21lbnUvZGVsZXRlQnlJZC8qIiwiL2dyb3VwL2RlbGV0ZUJ5SWQvKiIsIi91c2VyL2JpbmRSb2xlIiwiL3NoaXBwaW5nL3NldERlZmF1bHRBZGRyZXNzLyoiLCIvYWN0aW9uL21vZGlmeVN0YXR1cyIsIi9ncm91cC9zYXZlIiwiL2dyb3VwL2JpbmRVc2VyIiwiL2RpY3Qvc2F2ZSIsIi9hY3Rpb24vY2hlY2tVcmwiLCIvYWN0aW9uL2JhdGNoRGVsZXRlQnlJZExpc3QiLCIvY2FydC9zZWxlY3RBbGxQcm9kdWN0IiwiL2FjdGlvbi9jaGVja0FjdGlvbkNvZGUiLCIvb3JkZXIvY2FuY2VsT3JkZXJEb2MvKiIsIi9yb2xlL21vZGlmeVJvbGVTdGF0dXNCeUlkIiwiL3NoaXBwaW5nL2RlbGV0ZVNoaXBwaW5nLyoiLCIvY2FydC91blNlbGVjdFByb2R1Y3QvKiIsIi9zaGlwcGluZy91cGRhdGVTaGlwcGluZy8qIiwiL2dyb3VwL21vZGlmeVN0YXR1cyIsIi9yb2xlL2JpbmRVc2VyIiwiL3VhYy9yb2xlL3F1ZXJ5TGlzdCIsIi9vbWMvcHJvZHVjdC9zYXZlIiwiL3BheS9hbGlwYXlDYWxsYmFjayIsIi9vbWMvY2F0ZWdvcnkvbW9kaWZ5U3RhdHVzIiwiL2NhcnQvdXBkYXRlSW5mb3JtYXRpb24iLCIvY2FydC91blNlbGVjdEFsbFByb2R1Y3QiLCIvZGljdC9kZWxldGVCeUlkLyoiLCIvdXNlci9zYXZlIiwiL2NhcnQvdXBkYXRlUHJvZHVjdC8qKiIsIi91c2VyL3Jlc2V0TG9naW5Qd2QiLCIvcGF5L2NyZWF0ZVFyQ29kZUltYWdlLyoiLCIvYWN0aW9uL3F1ZXJ5TGlzdFdpdGhQYWdlIiwiL2NhcnQvc2VsZWN0UHJvZHVjdC8qIiwiL2NhcnQvYWRkUHJvZHVjdC8qKiIsIi9yb2xlL3NhdmUiLCIvYWN0aW9uL3NhdmUiLCIvdXNlci9tb2RpZnlVc2VyU3RhdHVzQnlJZCIsIi9zaGlwcGluZy9hZGRTaGlwcGluZyIsIi9vbWMvY2F0ZWdvcnkvc2F2ZSIsIi9yb2xlL2JpbmRNZW51IiwiL3JvbGUvYmF0Y2hEZWxldGVCeUlkTGlzdCJdLCJqdGkiOiI5NTc4ZmQ4ZS01ODQwLTQ4MDgtYWU0YS1jOGFlZTlkNjJlMGQiLCJjbGllbnRfaWQiOiJhbmFub3BzLWNsaWVudC11YWMiLCJ0aW1lc3RhbXAiOjE1NzYwMzg3MTA2ODh9.sSwMOCxCobGS2-Y0qYHPZ12z0XaIEqIPiAfgkec6KKE', 'eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJ1c2VyX25hbWUiOiJhZG1pbiIsInNjb3BlIjpbIioiXSwibG9naW5OYW1lIjoiYWRtaW4iLCJhdGkiOiI5NTc4ZmQ4ZS01ODQwLTQ4MDgtYWU0YS1jOGFlZTlkNjJlMGQiLCJleHAiOjE1Nzg2MzA3MTAsImF1dGhvcml0aWVzIjpbIi9jYXJ0L2RlbGV0ZVByb2R1Y3QvKiIsIi9tZW51L3NhdmUiLCIvcm9sZS9iaW5kQWN0aW9uIiwiL2FjdGlvbi9kZWxldGVBY3Rpb25CeUlkLyoiLCIvbWVudS9tb2RpZnlTdGF0dXMiLCIvb21jL3Byb2R1Y3QvZGVsZXRlUHJvZHVjdEJ5SWQvKiIsIi9yb2xlL2RlbGV0ZVJvbGVCeUlkLyoiLCIvb21jL2NhdGVnb3J5L2RlbGV0ZUJ5SWQvKiIsIi9kaWN0L21vZGlmeVN0YXR1cyIsIi9vcmRlci9jcmVhdGVPcmRlckRvYy8qIiwiL2VtYWlsL3NlbmRSZXN0RW1haWxDb2RlIiwiL21lbnUvZGVsZXRlQnlJZC8qIiwiL2dyb3VwL2RlbGV0ZUJ5SWQvKiIsIi91c2VyL2JpbmRSb2xlIiwiL3NoaXBwaW5nL3NldERlZmF1bHRBZGRyZXNzLyoiLCIvYWN0aW9uL21vZGlmeVN0YXR1cyIsIi9ncm91cC9zYXZlIiwiL2dyb3VwL2JpbmRVc2VyIiwiL2RpY3Qvc2F2ZSIsIi9hY3Rpb24vY2hlY2tVcmwiLCIvYWN0aW9uL2JhdGNoRGVsZXRlQnlJZExpc3QiLCIvY2FydC9zZWxlY3RBbGxQcm9kdWN0IiwiL2FjdGlvbi9jaGVja0FjdGlvbkNvZGUiLCIvb3JkZXIvY2FuY2VsT3JkZXJEb2MvKiIsIi9yb2xlL21vZGlmeVJvbGVTdGF0dXNCeUlkIiwiL3NoaXBwaW5nL2RlbGV0ZVNoaXBwaW5nLyoiLCIvY2FydC91blNlbGVjdFByb2R1Y3QvKiIsIi9zaGlwcGluZy91cGRhdGVTaGlwcGluZy8qIiwiL2dyb3VwL21vZGlmeVN0YXR1cyIsIi9yb2xlL2JpbmRVc2VyIiwiL3VhYy9yb2xlL3F1ZXJ5TGlzdCIsIi9vbWMvcHJvZHVjdC9zYXZlIiwiL3BheS9hbGlwYXlDYWxsYmFjayIsIi9vbWMvY2F0ZWdvcnkvbW9kaWZ5U3RhdHVzIiwiL2NhcnQvdXBkYXRlSW5mb3JtYXRpb24iLCIvY2FydC91blNlbGVjdEFsbFByb2R1Y3QiLCIvZGljdC9kZWxldGVCeUlkLyoiLCIvdXNlci9zYXZlIiwiL2NhcnQvdXBkYXRlUHJvZHVjdC8qKiIsIi91c2VyL3Jlc2V0TG9naW5Qd2QiLCIvcGF5L2NyZWF0ZVFyQ29kZUltYWdlLyoiLCIvYWN0aW9uL3F1ZXJ5TGlzdFdpdGhQYWdlIiwiL2NhcnQvc2VsZWN0UHJvZHVjdC8qIiwiL2NhcnQvYWRkUHJvZHVjdC8qKiIsIi9yb2xlL3NhdmUiLCIvYWN0aW9uL3NhdmUiLCIvdXNlci9tb2RpZnlVc2VyU3RhdHVzQnlJZCIsIi9zaGlwcGluZy9hZGRTaGlwcGluZyIsIi9vbWMvY2F0ZWdvcnkvc2F2ZSIsIi9yb2xlL2JpbmRNZW51IiwiL3JvbGUvYmF0Y2hEZWxldGVCeUlkTGlzdCJdLCJqdGkiOiIzNWRmNzkzNS0zZjA4LTQ5MWUtOTNlNS0zMTc0YmFiNTAwOTciLCJjbGllbnRfaWQiOiJhbmFub3BzLWNsaWVudC11YWMiLCJ0aW1lc3RhbXAiOjE1NzYwMzg3MTA2ODh9.exYZXDGMXzQNPRChA5XDwqoyVHGPzZK0Dk8yRgbbFyM', '', '7200', '2592000', '0', '1', 'paascloud', '超级管理员', '1', '2019-12-11 12:31:51', '超级管理员', '1', '2019-12-11 12:31:51');
INSERT INTO `an_uac_user_token` VALUES ('778794647731307520', '0', null, 'admin', '超级管理员', '1', 'Windows 10', 'Chrome', '127.0.0.1', '北京市', '2019-12-11 12:31:51', 'eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJ1c2VyX25hbWUiOiJhZG1pbiIsInNjb3BlIjpbIioiXSwibG9naW5OYW1lIjoiYWRtaW4iLCJleHAiOjE1NzYwNDY3NTQsImF1dGhvcml0aWVzIjpbIi9jYXJ0L2RlbGV0ZVByb2R1Y3QvKiIsIi9tZW51L3NhdmUiLCIvcm9sZS9iaW5kQWN0aW9uIiwiL2FjdGlvbi9kZWxldGVBY3Rpb25CeUlkLyoiLCIvbWVudS9tb2RpZnlTdGF0dXMiLCIvb21jL3Byb2R1Y3QvZGVsZXRlUHJvZHVjdEJ5SWQvKiIsIi9yb2xlL2RlbGV0ZVJvbGVCeUlkLyoiLCIvb21jL2NhdGVnb3J5L2RlbGV0ZUJ5SWQvKiIsIi9kaWN0L21vZGlmeVN0YXR1cyIsIi9vcmRlci9jcmVhdGVPcmRlckRvYy8qIiwiL2VtYWlsL3NlbmRSZXN0RW1haWxDb2RlIiwiL21lbnUvZGVsZXRlQnlJZC8qIiwiL2dyb3VwL2RlbGV0ZUJ5SWQvKiIsIi91c2VyL2JpbmRSb2xlIiwiL3NoaXBwaW5nL3NldERlZmF1bHRBZGRyZXNzLyoiLCIvYWN0aW9uL21vZGlmeVN0YXR1cyIsIi9ncm91cC9zYXZlIiwiL2dyb3VwL2JpbmRVc2VyIiwiL2RpY3Qvc2F2ZSIsIi9hY3Rpb24vY2hlY2tVcmwiLCIvYWN0aW9uL2JhdGNoRGVsZXRlQnlJZExpc3QiLCIvY2FydC9zZWxlY3RBbGxQcm9kdWN0IiwiL2FjdGlvbi9jaGVja0FjdGlvbkNvZGUiLCIvb3JkZXIvY2FuY2VsT3JkZXJEb2MvKiIsIi9yb2xlL21vZGlmeVJvbGVTdGF0dXNCeUlkIiwiL3NoaXBwaW5nL2RlbGV0ZVNoaXBwaW5nLyoiLCIvY2FydC91blNlbGVjdFByb2R1Y3QvKiIsIi9zaGlwcGluZy91cGRhdGVTaGlwcGluZy8qIiwiL2dyb3VwL21vZGlmeVN0YXR1cyIsIi9yb2xlL2JpbmRVc2VyIiwiL3VhYy9yb2xlL3F1ZXJ5TGlzdCIsIi9vbWMvcHJvZHVjdC9zYXZlIiwiL3BheS9hbGlwYXlDYWxsYmFjayIsIi9vbWMvY2F0ZWdvcnkvbW9kaWZ5U3RhdHVzIiwiL2NhcnQvdXBkYXRlSW5mb3JtYXRpb24iLCIvY2FydC91blNlbGVjdEFsbFByb2R1Y3QiLCIvZGljdC9kZWxldGVCeUlkLyoiLCIvdXNlci9zYXZlIiwiL2NhcnQvdXBkYXRlUHJvZHVjdC8qKiIsIi91c2VyL3Jlc2V0TG9naW5Qd2QiLCIvcGF5L2NyZWF0ZVFyQ29kZUltYWdlLyoiLCIvYWN0aW9uL3F1ZXJ5TGlzdFdpdGhQYWdlIiwiL2NhcnQvc2VsZWN0UHJvZHVjdC8qIiwiL2NhcnQvYWRkUHJvZHVjdC8qKiIsIi9yb2xlL3NhdmUiLCIvYWN0aW9uL3NhdmUiLCIvdXNlci9tb2RpZnlVc2VyU3RhdHVzQnlJZCIsIi9zaGlwcGluZy9hZGRTaGlwcGluZyIsIi9vbWMvY2F0ZWdvcnkvc2F2ZSIsIi9yb2xlL2JpbmRNZW51IiwiL3JvbGUvYmF0Y2hEZWxldGVCeUlkTGlzdCJdLCJqdGkiOiIyZTlmYzQ2Yy1hOTNkLTRiOWQtYWNmNS03YjA4ZDg2MjdhNWYiLCJjbGllbnRfaWQiOiJhbmFub3BzLWNsaWVudC11YWMiLCJ0aW1lc3RhbXAiOjE1NzYwMzk1NTQzOTl9.GVpAVIqyt0FC_iEpQ06ci5hJ70nSBKWIL45VeFZnEBg', 'eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJ1c2VyX25hbWUiOiJhZG1pbiIsInNjb3BlIjpbIioiXSwibG9naW5OYW1lIjoiYWRtaW4iLCJhdGkiOiIyZTlmYzQ2Yy1hOTNkLTRiOWQtYWNmNS03YjA4ZDg2MjdhNWYiLCJleHAiOjE1Nzg2MzE1NTQsImF1dGhvcml0aWVzIjpbIi9jYXJ0L2RlbGV0ZVByb2R1Y3QvKiIsIi9tZW51L3NhdmUiLCIvcm9sZS9iaW5kQWN0aW9uIiwiL2FjdGlvbi9kZWxldGVBY3Rpb25CeUlkLyoiLCIvbWVudS9tb2RpZnlTdGF0dXMiLCIvb21jL3Byb2R1Y3QvZGVsZXRlUHJvZHVjdEJ5SWQvKiIsIi9yb2xlL2RlbGV0ZVJvbGVCeUlkLyoiLCIvb21jL2NhdGVnb3J5L2RlbGV0ZUJ5SWQvKiIsIi9kaWN0L21vZGlmeVN0YXR1cyIsIi9vcmRlci9jcmVhdGVPcmRlckRvYy8qIiwiL2VtYWlsL3NlbmRSZXN0RW1haWxDb2RlIiwiL21lbnUvZGVsZXRlQnlJZC8qIiwiL2dyb3VwL2RlbGV0ZUJ5SWQvKiIsIi91c2VyL2JpbmRSb2xlIiwiL3NoaXBwaW5nL3NldERlZmF1bHRBZGRyZXNzLyoiLCIvYWN0aW9uL21vZGlmeVN0YXR1cyIsIi9ncm91cC9zYXZlIiwiL2dyb3VwL2JpbmRVc2VyIiwiL2RpY3Qvc2F2ZSIsIi9hY3Rpb24vY2hlY2tVcmwiLCIvYWN0aW9uL2JhdGNoRGVsZXRlQnlJZExpc3QiLCIvY2FydC9zZWxlY3RBbGxQcm9kdWN0IiwiL2FjdGlvbi9jaGVja0FjdGlvbkNvZGUiLCIvb3JkZXIvY2FuY2VsT3JkZXJEb2MvKiIsIi9yb2xlL21vZGlmeVJvbGVTdGF0dXNCeUlkIiwiL3NoaXBwaW5nL2RlbGV0ZVNoaXBwaW5nLyoiLCIvY2FydC91blNlbGVjdFByb2R1Y3QvKiIsIi9zaGlwcGluZy91cGRhdGVTaGlwcGluZy8qIiwiL2dyb3VwL21vZGlmeVN0YXR1cyIsIi9yb2xlL2JpbmRVc2VyIiwiL3VhYy9yb2xlL3F1ZXJ5TGlzdCIsIi9vbWMvcHJvZHVjdC9zYXZlIiwiL3BheS9hbGlwYXlDYWxsYmFjayIsIi9vbWMvY2F0ZWdvcnkvbW9kaWZ5U3RhdHVzIiwiL2NhcnQvdXBkYXRlSW5mb3JtYXRpb24iLCIvY2FydC91blNlbGVjdEFsbFByb2R1Y3QiLCIvZGljdC9kZWxldGVCeUlkLyoiLCIvdXNlci9zYXZlIiwiL2NhcnQvdXBkYXRlUHJvZHVjdC8qKiIsIi91c2VyL3Jlc2V0TG9naW5Qd2QiLCIvcGF5L2NyZWF0ZVFyQ29kZUltYWdlLyoiLCIvYWN0aW9uL3F1ZXJ5TGlzdFdpdGhQYWdlIiwiL2NhcnQvc2VsZWN0UHJvZHVjdC8qIiwiL2NhcnQvYWRkUHJvZHVjdC8qKiIsIi9yb2xlL3NhdmUiLCIvYWN0aW9uL3NhdmUiLCIvdXNlci9tb2RpZnlVc2VyU3RhdHVzQnlJZCIsIi9zaGlwcGluZy9hZGRTaGlwcGluZyIsIi9vbWMvY2F0ZWdvcnkvc2F2ZSIsIi9yb2xlL2JpbmRNZW51IiwiL3JvbGUvYmF0Y2hEZWxldGVCeUlkTGlzdCJdLCJqdGkiOiIxNDY4YzBhOS03ZWEyLTQ1NjQtYmNlMy1jMjRjNTg0OGYzM2YiLCJjbGllbnRfaWQiOiJhbmFub3BzLWNsaWVudC11YWMiLCJ0aW1lc3RhbXAiOjE1NzYwMzk1NTQzOTl9.VmZx_fKc27cfytzBeaUrUL2RtdQcCc0sJAa_Y2RRizI', '', '7200', '2592000', '0', '1', 'paascloud', '超级管理员', '1', '2019-12-11 12:45:57', '超级管理员', '1', '2019-12-11 12:45:57');
INSERT INTO `an_uac_user_token` VALUES ('778798455563748352', '0', null, 'admin', '超级管理员', '1', 'Windows 10', 'Chrome', '127.0.0.1', '北京市', '2019-12-11 12:45:56', 'eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJ1c2VyX25hbWUiOiJhZG1pbiIsInNjb3BlIjpbIioiXSwibG9naW5OYW1lIjoiYWRtaW4iLCJleHAiOjE1NzYwNDcyMTAsImF1dGhvcml0aWVzIjpbIi9jYXJ0L2RlbGV0ZVByb2R1Y3QvKiIsIi9tZW51L3NhdmUiLCIvcm9sZS9iaW5kQWN0aW9uIiwiL2FjdGlvbi9kZWxldGVBY3Rpb25CeUlkLyoiLCIvbWVudS9tb2RpZnlTdGF0dXMiLCIvb21jL3Byb2R1Y3QvZGVsZXRlUHJvZHVjdEJ5SWQvKiIsIi9yb2xlL2RlbGV0ZVJvbGVCeUlkLyoiLCIvb21jL2NhdGVnb3J5L2RlbGV0ZUJ5SWQvKiIsIi9kaWN0L21vZGlmeVN0YXR1cyIsIi9vcmRlci9jcmVhdGVPcmRlckRvYy8qIiwiL2VtYWlsL3NlbmRSZXN0RW1haWxDb2RlIiwiL21lbnUvZGVsZXRlQnlJZC8qIiwiL2dyb3VwL2RlbGV0ZUJ5SWQvKiIsIi91c2VyL2JpbmRSb2xlIiwiL3NoaXBwaW5nL3NldERlZmF1bHRBZGRyZXNzLyoiLCIvYWN0aW9uL21vZGlmeVN0YXR1cyIsIi9ncm91cC9zYXZlIiwiL2dyb3VwL2JpbmRVc2VyIiwiL2RpY3Qvc2F2ZSIsIi9hY3Rpb24vY2hlY2tVcmwiLCIvYWN0aW9uL2JhdGNoRGVsZXRlQnlJZExpc3QiLCIvY2FydC9zZWxlY3RBbGxQcm9kdWN0IiwiL2FjdGlvbi9jaGVja0FjdGlvbkNvZGUiLCIvb3JkZXIvY2FuY2VsT3JkZXJEb2MvKiIsIi9yb2xlL21vZGlmeVJvbGVTdGF0dXNCeUlkIiwiL3NoaXBwaW5nL2RlbGV0ZVNoaXBwaW5nLyoiLCIvY2FydC91blNlbGVjdFByb2R1Y3QvKiIsIi9zaGlwcGluZy91cGRhdGVTaGlwcGluZy8qIiwiL2dyb3VwL21vZGlmeVN0YXR1cyIsIi9yb2xlL2JpbmRVc2VyIiwiL3VhYy9yb2xlL3F1ZXJ5TGlzdCIsIi9vbWMvcHJvZHVjdC9zYXZlIiwiL3BheS9hbGlwYXlDYWxsYmFjayIsIi9vbWMvY2F0ZWdvcnkvbW9kaWZ5U3RhdHVzIiwiL2NhcnQvdXBkYXRlSW5mb3JtYXRpb24iLCIvY2FydC91blNlbGVjdEFsbFByb2R1Y3QiLCIvZGljdC9kZWxldGVCeUlkLyoiLCIvdXNlci9zYXZlIiwiL2NhcnQvdXBkYXRlUHJvZHVjdC8qKiIsIi91c2VyL3Jlc2V0TG9naW5Qd2QiLCIvcGF5L2NyZWF0ZVFyQ29kZUltYWdlLyoiLCIvYWN0aW9uL3F1ZXJ5TGlzdFdpdGhQYWdlIiwiL2NhcnQvc2VsZWN0UHJvZHVjdC8qIiwiL2NhcnQvYWRkUHJvZHVjdC8qKiIsIi9yb2xlL3NhdmUiLCIvYWN0aW9uL3NhdmUiLCIvdXNlci9tb2RpZnlVc2VyU3RhdHVzQnlJZCIsIi9zaGlwcGluZy9hZGRTaGlwcGluZyIsIi9vbWMvY2F0ZWdvcnkvc2F2ZSIsIi9yb2xlL2JpbmRNZW51IiwiL3JvbGUvYmF0Y2hEZWxldGVCeUlkTGlzdCJdLCJqdGkiOiJlYmQwZmE2NS0wMTZjLTRiYzQtYWM1MS1iODFkMDQ3YWQwMzciLCJjbGllbnRfaWQiOiJhbmFub3BzLWNsaWVudC11YWMiLCJ0aW1lc3RhbXAiOjE1NzYwNDAwMTAxMTh9.6p2BXwyYksMHybEw2eGcNu91BqA1u2wgwA5bu_BRn94', 'eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJ1c2VyX25hbWUiOiJhZG1pbiIsInNjb3BlIjpbIioiXSwibG9naW5OYW1lIjoiYWRtaW4iLCJhdGkiOiJlYmQwZmE2NS0wMTZjLTRiYzQtYWM1MS1iODFkMDQ3YWQwMzciLCJleHAiOjE1Nzg2MzIwMTAsImF1dGhvcml0aWVzIjpbIi9jYXJ0L2RlbGV0ZVByb2R1Y3QvKiIsIi9tZW51L3NhdmUiLCIvcm9sZS9iaW5kQWN0aW9uIiwiL2FjdGlvbi9kZWxldGVBY3Rpb25CeUlkLyoiLCIvbWVudS9tb2RpZnlTdGF0dXMiLCIvb21jL3Byb2R1Y3QvZGVsZXRlUHJvZHVjdEJ5SWQvKiIsIi9yb2xlL2RlbGV0ZVJvbGVCeUlkLyoiLCIvb21jL2NhdGVnb3J5L2RlbGV0ZUJ5SWQvKiIsIi9kaWN0L21vZGlmeVN0YXR1cyIsIi9vcmRlci9jcmVhdGVPcmRlckRvYy8qIiwiL2VtYWlsL3NlbmRSZXN0RW1haWxDb2RlIiwiL21lbnUvZGVsZXRlQnlJZC8qIiwiL2dyb3VwL2RlbGV0ZUJ5SWQvKiIsIi91c2VyL2JpbmRSb2xlIiwiL3NoaXBwaW5nL3NldERlZmF1bHRBZGRyZXNzLyoiLCIvYWN0aW9uL21vZGlmeVN0YXR1cyIsIi9ncm91cC9zYXZlIiwiL2dyb3VwL2JpbmRVc2VyIiwiL2RpY3Qvc2F2ZSIsIi9hY3Rpb24vY2hlY2tVcmwiLCIvYWN0aW9uL2JhdGNoRGVsZXRlQnlJZExpc3QiLCIvY2FydC9zZWxlY3RBbGxQcm9kdWN0IiwiL2FjdGlvbi9jaGVja0FjdGlvbkNvZGUiLCIvb3JkZXIvY2FuY2VsT3JkZXJEb2MvKiIsIi9yb2xlL21vZGlmeVJvbGVTdGF0dXNCeUlkIiwiL3NoaXBwaW5nL2RlbGV0ZVNoaXBwaW5nLyoiLCIvY2FydC91blNlbGVjdFByb2R1Y3QvKiIsIi9zaGlwcGluZy91cGRhdGVTaGlwcGluZy8qIiwiL2dyb3VwL21vZGlmeVN0YXR1cyIsIi9yb2xlL2JpbmRVc2VyIiwiL3VhYy9yb2xlL3F1ZXJ5TGlzdCIsIi9vbWMvcHJvZHVjdC9zYXZlIiwiL3BheS9hbGlwYXlDYWxsYmFjayIsIi9vbWMvY2F0ZWdvcnkvbW9kaWZ5U3RhdHVzIiwiL2NhcnQvdXBkYXRlSW5mb3JtYXRpb24iLCIvY2FydC91blNlbGVjdEFsbFByb2R1Y3QiLCIvZGljdC9kZWxldGVCeUlkLyoiLCIvdXNlci9zYXZlIiwiL2NhcnQvdXBkYXRlUHJvZHVjdC8qKiIsIi91c2VyL3Jlc2V0TG9naW5Qd2QiLCIvcGF5L2NyZWF0ZVFyQ29kZUltYWdlLyoiLCIvYWN0aW9uL3F1ZXJ5TGlzdFdpdGhQYWdlIiwiL2NhcnQvc2VsZWN0UHJvZHVjdC8qIiwiL2NhcnQvYWRkUHJvZHVjdC8qKiIsIi9yb2xlL3NhdmUiLCIvYWN0aW9uL3NhdmUiLCIvdXNlci9tb2RpZnlVc2VyU3RhdHVzQnlJZCIsIi9zaGlwcGluZy9hZGRTaGlwcGluZyIsIi9vbWMvY2F0ZWdvcnkvc2F2ZSIsIi9yb2xlL2JpbmRNZW51IiwiL3JvbGUvYmF0Y2hEZWxldGVCeUlkTGlzdCJdLCJqdGkiOiJlNzYyOWU5Ni0zZjVkLTQzNDEtYjg4OC05NzBjNGVlMjAwN2EiLCJjbGllbnRfaWQiOiJhbmFub3BzLWNsaWVudC11YWMiLCJ0aW1lc3RhbXAiOjE1NzYwNDAwMTAxMTh9.HT69HRmg5dVD9FIr-OFDnlnex-AInUqmukFOFduDpTQ', '', '7200', '2592000', '0', '1', 'paascloud', '超级管理员', '1', '2019-12-11 12:53:31', '超级管理员', '1', '2019-12-11 12:53:31');
INSERT INTO `an_uac_user_token` VALUES ('778799429950899200', '0', null, 'admin', '超级管理员', '1', 'Windows 10', 'Chrome', '127.0.0.1', '北京市', '2019-12-11 12:53:30', 'eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJ1c2VyX25hbWUiOiJhZG1pbiIsInNjb3BlIjpbIioiXSwibG9naW5OYW1lIjoiYWRtaW4iLCJleHAiOjE1NzYwNDczMjYsImF1dGhvcml0aWVzIjpbIi9jYXJ0L2RlbGV0ZVByb2R1Y3QvKiIsIi9tZW51L3NhdmUiLCIvcm9sZS9iaW5kQWN0aW9uIiwiL2FjdGlvbi9kZWxldGVBY3Rpb25CeUlkLyoiLCIvbWVudS9tb2RpZnlTdGF0dXMiLCIvb21jL3Byb2R1Y3QvZGVsZXRlUHJvZHVjdEJ5SWQvKiIsIi9yb2xlL2RlbGV0ZVJvbGVCeUlkLyoiLCIvb21jL2NhdGVnb3J5L2RlbGV0ZUJ5SWQvKiIsIi9kaWN0L21vZGlmeVN0YXR1cyIsIi9vcmRlci9jcmVhdGVPcmRlckRvYy8qIiwiL2VtYWlsL3NlbmRSZXN0RW1haWxDb2RlIiwiL21lbnUvZGVsZXRlQnlJZC8qIiwiL2dyb3VwL2RlbGV0ZUJ5SWQvKiIsIi91c2VyL2JpbmRSb2xlIiwiL3NoaXBwaW5nL3NldERlZmF1bHRBZGRyZXNzLyoiLCIvYWN0aW9uL21vZGlmeVN0YXR1cyIsIi9ncm91cC9zYXZlIiwiL2dyb3VwL2JpbmRVc2VyIiwiL2RpY3Qvc2F2ZSIsIi9hY3Rpb24vY2hlY2tVcmwiLCIvYWN0aW9uL2JhdGNoRGVsZXRlQnlJZExpc3QiLCIvY2FydC9zZWxlY3RBbGxQcm9kdWN0IiwiL2FjdGlvbi9jaGVja0FjdGlvbkNvZGUiLCIvb3JkZXIvY2FuY2VsT3JkZXJEb2MvKiIsIi9yb2xlL21vZGlmeVJvbGVTdGF0dXNCeUlkIiwiL3NoaXBwaW5nL2RlbGV0ZVNoaXBwaW5nLyoiLCIvY2FydC91blNlbGVjdFByb2R1Y3QvKiIsIi9zaGlwcGluZy91cGRhdGVTaGlwcGluZy8qIiwiL2dyb3VwL21vZGlmeVN0YXR1cyIsIi9yb2xlL2JpbmRVc2VyIiwiL3VhYy9yb2xlL3F1ZXJ5TGlzdCIsIi9vbWMvcHJvZHVjdC9zYXZlIiwiL3BheS9hbGlwYXlDYWxsYmFjayIsIi9vbWMvY2F0ZWdvcnkvbW9kaWZ5U3RhdHVzIiwiL2NhcnQvdXBkYXRlSW5mb3JtYXRpb24iLCIvY2FydC91blNlbGVjdEFsbFByb2R1Y3QiLCIvZGljdC9kZWxldGVCeUlkLyoiLCIvdXNlci9zYXZlIiwiL2NhcnQvdXBkYXRlUHJvZHVjdC8qKiIsIi91c2VyL3Jlc2V0TG9naW5Qd2QiLCIvcGF5L2NyZWF0ZVFyQ29kZUltYWdlLyoiLCIvYWN0aW9uL3F1ZXJ5TGlzdFdpdGhQYWdlIiwiL2NhcnQvc2VsZWN0UHJvZHVjdC8qIiwiL2NhcnQvYWRkUHJvZHVjdC8qKiIsIi9yb2xlL3NhdmUiLCIvYWN0aW9uL3NhdmUiLCIvdXNlci9tb2RpZnlVc2VyU3RhdHVzQnlJZCIsIi9zaGlwcGluZy9hZGRTaGlwcGluZyIsIi9vbWMvY2F0ZWdvcnkvc2F2ZSIsIi9yb2xlL2JpbmRNZW51IiwiL3JvbGUvYmF0Y2hEZWxldGVCeUlkTGlzdCJdLCJqdGkiOiJiYzFkMWQ3YS1mMTM4LTQ2NTEtOGI3Yi00MTgxNGI1ZDU4N2YiLCJjbGllbnRfaWQiOiJhbmFub3BzLWNsaWVudC11YWMiLCJ0aW1lc3RhbXAiOjE1NzYwNDAxMjYzNTd9.A8PA9hAUcJo0vuRTVL9zu3VngjB_se_PrDSsp_ko04g', 'eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJ1c2VyX25hbWUiOiJhZG1pbiIsInNjb3BlIjpbIioiXSwibG9naW5OYW1lIjoiYWRtaW4iLCJhdGkiOiJiYzFkMWQ3YS1mMTM4LTQ2NTEtOGI3Yi00MTgxNGI1ZDU4N2YiLCJleHAiOjE1Nzg2MzIxMjYsImF1dGhvcml0aWVzIjpbIi9jYXJ0L2RlbGV0ZVByb2R1Y3QvKiIsIi9tZW51L3NhdmUiLCIvcm9sZS9iaW5kQWN0aW9uIiwiL2FjdGlvbi9kZWxldGVBY3Rpb25CeUlkLyoiLCIvbWVudS9tb2RpZnlTdGF0dXMiLCIvb21jL3Byb2R1Y3QvZGVsZXRlUHJvZHVjdEJ5SWQvKiIsIi9yb2xlL2RlbGV0ZVJvbGVCeUlkLyoiLCIvb21jL2NhdGVnb3J5L2RlbGV0ZUJ5SWQvKiIsIi9kaWN0L21vZGlmeVN0YXR1cyIsIi9vcmRlci9jcmVhdGVPcmRlckRvYy8qIiwiL2VtYWlsL3NlbmRSZXN0RW1haWxDb2RlIiwiL21lbnUvZGVsZXRlQnlJZC8qIiwiL2dyb3VwL2RlbGV0ZUJ5SWQvKiIsIi91c2VyL2JpbmRSb2xlIiwiL3NoaXBwaW5nL3NldERlZmF1bHRBZGRyZXNzLyoiLCIvYWN0aW9uL21vZGlmeVN0YXR1cyIsIi9ncm91cC9zYXZlIiwiL2dyb3VwL2JpbmRVc2VyIiwiL2RpY3Qvc2F2ZSIsIi9hY3Rpb24vY2hlY2tVcmwiLCIvYWN0aW9uL2JhdGNoRGVsZXRlQnlJZExpc3QiLCIvY2FydC9zZWxlY3RBbGxQcm9kdWN0IiwiL2FjdGlvbi9jaGVja0FjdGlvbkNvZGUiLCIvb3JkZXIvY2FuY2VsT3JkZXJEb2MvKiIsIi9yb2xlL21vZGlmeVJvbGVTdGF0dXNCeUlkIiwiL3NoaXBwaW5nL2RlbGV0ZVNoaXBwaW5nLyoiLCIvY2FydC91blNlbGVjdFByb2R1Y3QvKiIsIi9zaGlwcGluZy91cGRhdGVTaGlwcGluZy8qIiwiL2dyb3VwL21vZGlmeVN0YXR1cyIsIi9yb2xlL2JpbmRVc2VyIiwiL3VhYy9yb2xlL3F1ZXJ5TGlzdCIsIi9vbWMvcHJvZHVjdC9zYXZlIiwiL3BheS9hbGlwYXlDYWxsYmFjayIsIi9vbWMvY2F0ZWdvcnkvbW9kaWZ5U3RhdHVzIiwiL2NhcnQvdXBkYXRlSW5mb3JtYXRpb24iLCIvY2FydC91blNlbGVjdEFsbFByb2R1Y3QiLCIvZGljdC9kZWxldGVCeUlkLyoiLCIvdXNlci9zYXZlIiwiL2NhcnQvdXBkYXRlUHJvZHVjdC8qKiIsIi91c2VyL3Jlc2V0TG9naW5Qd2QiLCIvcGF5L2NyZWF0ZVFyQ29kZUltYWdlLyoiLCIvYWN0aW9uL3F1ZXJ5TGlzdFdpdGhQYWdlIiwiL2NhcnQvc2VsZWN0UHJvZHVjdC8qIiwiL2NhcnQvYWRkUHJvZHVjdC8qKiIsIi9yb2xlL3NhdmUiLCIvYWN0aW9uL3NhdmUiLCIvdXNlci9tb2RpZnlVc2VyU3RhdHVzQnlJZCIsIi9zaGlwcGluZy9hZGRTaGlwcGluZyIsIi9vbWMvY2F0ZWdvcnkvc2F2ZSIsIi9yb2xlL2JpbmRNZW51IiwiL3JvbGUvYmF0Y2hEZWxldGVCeUlkTGlzdCJdLCJqdGkiOiJlYjIwMDBjNC1mMmQ2LTRmOWMtOGQwMC04Yzg0ZjYyODcyOGMiLCJjbGllbnRfaWQiOiJhbmFub3BzLWNsaWVudC11YWMiLCJ0aW1lc3RhbXAiOjE1NzYwNDAxMjYzNTd9.vBDL8wJHgI8jsqNvzq4Cnmjhn7vCMnDrxLKM5GaD_kk', '', '7200', '2592000', '0', '1', 'paascloud', '超级管理员', '1', '2019-12-11 12:55:27', '超级管理员', '1', '2019-12-11 12:55:27');
INSERT INTO `an_uac_user_token` VALUES ('778800409706759168', '0', null, 'admin', '超级管理员', '1', 'Windows 10', 'Chrome', '127.0.0.1', '北京市', '2019-12-11 12:55:27', 'eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJ1c2VyX25hbWUiOiJhZG1pbiIsInNjb3BlIjpbIioiXSwibG9naW5OYW1lIjoiYWRtaW4iLCJleHAiOjE1NzYwNDc0NDMsImF1dGhvcml0aWVzIjpbIi9jYXJ0L2RlbGV0ZVByb2R1Y3QvKiIsIi9tZW51L3NhdmUiLCIvcm9sZS9iaW5kQWN0aW9uIiwiL2FjdGlvbi9kZWxldGVBY3Rpb25CeUlkLyoiLCIvbWVudS9tb2RpZnlTdGF0dXMiLCIvb21jL3Byb2R1Y3QvZGVsZXRlUHJvZHVjdEJ5SWQvKiIsIi9yb2xlL2RlbGV0ZVJvbGVCeUlkLyoiLCIvb21jL2NhdGVnb3J5L2RlbGV0ZUJ5SWQvKiIsIi9kaWN0L21vZGlmeVN0YXR1cyIsIi9vcmRlci9jcmVhdGVPcmRlckRvYy8qIiwiL2VtYWlsL3NlbmRSZXN0RW1haWxDb2RlIiwiL21lbnUvZGVsZXRlQnlJZC8qIiwiL2dyb3VwL2RlbGV0ZUJ5SWQvKiIsIi91c2VyL2JpbmRSb2xlIiwiL3NoaXBwaW5nL3NldERlZmF1bHRBZGRyZXNzLyoiLCIvYWN0aW9uL21vZGlmeVN0YXR1cyIsIi9ncm91cC9zYXZlIiwiL2dyb3VwL2JpbmRVc2VyIiwiL2RpY3Qvc2F2ZSIsIi9hY3Rpb24vY2hlY2tVcmwiLCIvYWN0aW9uL2JhdGNoRGVsZXRlQnlJZExpc3QiLCIvY2FydC9zZWxlY3RBbGxQcm9kdWN0IiwiL2FjdGlvbi9jaGVja0FjdGlvbkNvZGUiLCIvb3JkZXIvY2FuY2VsT3JkZXJEb2MvKiIsIi9yb2xlL21vZGlmeVJvbGVTdGF0dXNCeUlkIiwiL3NoaXBwaW5nL2RlbGV0ZVNoaXBwaW5nLyoiLCIvY2FydC91blNlbGVjdFByb2R1Y3QvKiIsIi9zaGlwcGluZy91cGRhdGVTaGlwcGluZy8qIiwiL2dyb3VwL21vZGlmeVN0YXR1cyIsIi9yb2xlL2JpbmRVc2VyIiwiL3VhYy9yb2xlL3F1ZXJ5TGlzdCIsIi9vbWMvcHJvZHVjdC9zYXZlIiwiL3BheS9hbGlwYXlDYWxsYmFjayIsIi9vbWMvY2F0ZWdvcnkvbW9kaWZ5U3RhdHVzIiwiL2NhcnQvdXBkYXRlSW5mb3JtYXRpb24iLCIvY2FydC91blNlbGVjdEFsbFByb2R1Y3QiLCIvZGljdC9kZWxldGVCeUlkLyoiLCIvdXNlci9zYXZlIiwiL2NhcnQvdXBkYXRlUHJvZHVjdC8qKiIsIi91c2VyL3Jlc2V0TG9naW5Qd2QiLCIvcGF5L2NyZWF0ZVFyQ29kZUltYWdlLyoiLCIvYWN0aW9uL3F1ZXJ5TGlzdFdpdGhQYWdlIiwiL2NhcnQvc2VsZWN0UHJvZHVjdC8qIiwiL2NhcnQvYWRkUHJvZHVjdC8qKiIsIi9yb2xlL3NhdmUiLCIvYWN0aW9uL3NhdmUiLCIvdXNlci9tb2RpZnlVc2VyU3RhdHVzQnlJZCIsIi9zaGlwcGluZy9hZGRTaGlwcGluZyIsIi9vbWMvY2F0ZWdvcnkvc2F2ZSIsIi9yb2xlL2JpbmRNZW51IiwiL3JvbGUvYmF0Y2hEZWxldGVCeUlkTGlzdCJdLCJqdGkiOiI2MjllYjlkZi0yOTRkLTQ5NzMtOWRmOC1jOTQ2Zjk0NTNhZGYiLCJjbGllbnRfaWQiOiJhbmFub3BzLWNsaWVudC11YWMiLCJ0aW1lc3RhbXAiOjE1NzYwNDAyNDMzMDl9.wJU9O4LuQBQ87esFGb63LToEUUMH8MKJm53Qhv9he2A', 'eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJ1c2VyX25hbWUiOiJhZG1pbiIsInNjb3BlIjpbIioiXSwibG9naW5OYW1lIjoiYWRtaW4iLCJhdGkiOiI2MjllYjlkZi0yOTRkLTQ5NzMtOWRmOC1jOTQ2Zjk0NTNhZGYiLCJleHAiOjE1Nzg2MzIyNDMsImF1dGhvcml0aWVzIjpbIi9jYXJ0L2RlbGV0ZVByb2R1Y3QvKiIsIi9tZW51L3NhdmUiLCIvcm9sZS9iaW5kQWN0aW9uIiwiL2FjdGlvbi9kZWxldGVBY3Rpb25CeUlkLyoiLCIvbWVudS9tb2RpZnlTdGF0dXMiLCIvb21jL3Byb2R1Y3QvZGVsZXRlUHJvZHVjdEJ5SWQvKiIsIi9yb2xlL2RlbGV0ZVJvbGVCeUlkLyoiLCIvb21jL2NhdGVnb3J5L2RlbGV0ZUJ5SWQvKiIsIi9kaWN0L21vZGlmeVN0YXR1cyIsIi9vcmRlci9jcmVhdGVPcmRlckRvYy8qIiwiL2VtYWlsL3NlbmRSZXN0RW1haWxDb2RlIiwiL21lbnUvZGVsZXRlQnlJZC8qIiwiL2dyb3VwL2RlbGV0ZUJ5SWQvKiIsIi91c2VyL2JpbmRSb2xlIiwiL3NoaXBwaW5nL3NldERlZmF1bHRBZGRyZXNzLyoiLCIvYWN0aW9uL21vZGlmeVN0YXR1cyIsIi9ncm91cC9zYXZlIiwiL2dyb3VwL2JpbmRVc2VyIiwiL2RpY3Qvc2F2ZSIsIi9hY3Rpb24vY2hlY2tVcmwiLCIvYWN0aW9uL2JhdGNoRGVsZXRlQnlJZExpc3QiLCIvY2FydC9zZWxlY3RBbGxQcm9kdWN0IiwiL2FjdGlvbi9jaGVja0FjdGlvbkNvZGUiLCIvb3JkZXIvY2FuY2VsT3JkZXJEb2MvKiIsIi9yb2xlL21vZGlmeVJvbGVTdGF0dXNCeUlkIiwiL3NoaXBwaW5nL2RlbGV0ZVNoaXBwaW5nLyoiLCIvY2FydC91blNlbGVjdFByb2R1Y3QvKiIsIi9zaGlwcGluZy91cGRhdGVTaGlwcGluZy8qIiwiL2dyb3VwL21vZGlmeVN0YXR1cyIsIi9yb2xlL2JpbmRVc2VyIiwiL3VhYy9yb2xlL3F1ZXJ5TGlzdCIsIi9vbWMvcHJvZHVjdC9zYXZlIiwiL3BheS9hbGlwYXlDYWxsYmFjayIsIi9vbWMvY2F0ZWdvcnkvbW9kaWZ5U3RhdHVzIiwiL2NhcnQvdXBkYXRlSW5mb3JtYXRpb24iLCIvY2FydC91blNlbGVjdEFsbFByb2R1Y3QiLCIvZGljdC9kZWxldGVCeUlkLyoiLCIvdXNlci9zYXZlIiwiL2NhcnQvdXBkYXRlUHJvZHVjdC8qKiIsIi91c2VyL3Jlc2V0TG9naW5Qd2QiLCIvcGF5L2NyZWF0ZVFyQ29kZUltYWdlLyoiLCIvYWN0aW9uL3F1ZXJ5TGlzdFdpdGhQYWdlIiwiL2NhcnQvc2VsZWN0UHJvZHVjdC8qIiwiL2NhcnQvYWRkUHJvZHVjdC8qKiIsIi9yb2xlL3NhdmUiLCIvYWN0aW9uL3NhdmUiLCIvdXNlci9tb2RpZnlVc2VyU3RhdHVzQnlJZCIsIi9zaGlwcGluZy9hZGRTaGlwcGluZyIsIi9vbWMvY2F0ZWdvcnkvc2F2ZSIsIi9yb2xlL2JpbmRNZW51IiwiL3JvbGUvYmF0Y2hEZWxldGVCeUlkTGlzdCJdLCJqdGkiOiI3ZGE2M2VlMy0zN2RmLTQwMjQtYmY2Zi00NDViZjM3ODIxNTEiLCJjbGllbnRfaWQiOiJhbmFub3BzLWNsaWVudC11YWMiLCJ0aW1lc3RhbXAiOjE1NzYwNDAyNDMzMDl9.yvtrtvMhkbibkl3BKUmtcD-NO5ZAc9J5Ne78PFrNWYg', '', '7200', '2592000', '0', '1', 'paascloud', '超级管理员', '1', '2019-12-11 12:57:24', '超级管理员', '1', '2019-12-11 12:57:24');
INSERT INTO `an_uac_user_token` VALUES ('778802696986559488', '0', null, 'admin', '超级管理员', '1', 'Windows 10', 'Chrome', '127.0.0.1', '北京市', '2019-12-11 12:57:23', 'eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJ1c2VyX25hbWUiOiJhZG1pbiIsInNjb3BlIjpbIioiXSwibG9naW5OYW1lIjoiYWRtaW4iLCJleHAiOjE1NzYwNDc3MTUsImF1dGhvcml0aWVzIjpbIi9jYXJ0L2RlbGV0ZVByb2R1Y3QvKiIsIi9tZW51L3NhdmUiLCIvcm9sZS9iaW5kQWN0aW9uIiwiL2FjdGlvbi9kZWxldGVBY3Rpb25CeUlkLyoiLCIvbWVudS9tb2RpZnlTdGF0dXMiLCIvb21jL3Byb2R1Y3QvZGVsZXRlUHJvZHVjdEJ5SWQvKiIsIi9yb2xlL2RlbGV0ZVJvbGVCeUlkLyoiLCIvb21jL2NhdGVnb3J5L2RlbGV0ZUJ5SWQvKiIsIi9kaWN0L21vZGlmeVN0YXR1cyIsIi9vcmRlci9jcmVhdGVPcmRlckRvYy8qIiwiL2VtYWlsL3NlbmRSZXN0RW1haWxDb2RlIiwiL21lbnUvZGVsZXRlQnlJZC8qIiwiL2dyb3VwL2RlbGV0ZUJ5SWQvKiIsIi91c2VyL2JpbmRSb2xlIiwiL3NoaXBwaW5nL3NldERlZmF1bHRBZGRyZXNzLyoiLCIvYWN0aW9uL21vZGlmeVN0YXR1cyIsIi9ncm91cC9zYXZlIiwiL2dyb3VwL2JpbmRVc2VyIiwiL2RpY3Qvc2F2ZSIsIi9hY3Rpb24vY2hlY2tVcmwiLCIvYWN0aW9uL2JhdGNoRGVsZXRlQnlJZExpc3QiLCIvY2FydC9zZWxlY3RBbGxQcm9kdWN0IiwiL2FjdGlvbi9jaGVja0FjdGlvbkNvZGUiLCIvb3JkZXIvY2FuY2VsT3JkZXJEb2MvKiIsIi9yb2xlL21vZGlmeVJvbGVTdGF0dXNCeUlkIiwiL3NoaXBwaW5nL2RlbGV0ZVNoaXBwaW5nLyoiLCIvY2FydC91blNlbGVjdFByb2R1Y3QvKiIsIi9zaGlwcGluZy91cGRhdGVTaGlwcGluZy8qIiwiL2dyb3VwL21vZGlmeVN0YXR1cyIsIi9yb2xlL2JpbmRVc2VyIiwiL3VhYy9yb2xlL3F1ZXJ5TGlzdCIsIi9vbWMvcHJvZHVjdC9zYXZlIiwiL3BheS9hbGlwYXlDYWxsYmFjayIsIi9vbWMvY2F0ZWdvcnkvbW9kaWZ5U3RhdHVzIiwiL2NhcnQvdXBkYXRlSW5mb3JtYXRpb24iLCIvY2FydC91blNlbGVjdEFsbFByb2R1Y3QiLCIvZGljdC9kZWxldGVCeUlkLyoiLCIvdXNlci9zYXZlIiwiL2NhcnQvdXBkYXRlUHJvZHVjdC8qKiIsIi91c2VyL3Jlc2V0TG9naW5Qd2QiLCIvcGF5L2NyZWF0ZVFyQ29kZUltYWdlLyoiLCIvYWN0aW9uL3F1ZXJ5TGlzdFdpdGhQYWdlIiwiL2NhcnQvc2VsZWN0UHJvZHVjdC8qIiwiL2NhcnQvYWRkUHJvZHVjdC8qKiIsIi9yb2xlL3NhdmUiLCIvYWN0aW9uL3NhdmUiLCIvdXNlci9tb2RpZnlVc2VyU3RhdHVzQnlJZCIsIi9zaGlwcGluZy9hZGRTaGlwcGluZyIsIi9vbWMvY2F0ZWdvcnkvc2F2ZSIsIi9yb2xlL2JpbmRNZW51IiwiL3JvbGUvYmF0Y2hEZWxldGVCeUlkTGlzdCJdLCJqdGkiOiI0ZTFmZmRiZC1jYzBkLTQ5YjUtYTRkNi02ZGZjMzg1ODRjNjkiLCJjbGllbnRfaWQiOiJhbmFub3BzLWNsaWVudC11YWMiLCJ0aW1lc3RhbXAiOjE1NzYwNDA1MTU5NzV9.ntjHoi1nE_8k8M3QJaBBix8D7W9zhHSkr9XxxqBUZgI', 'eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJ1c2VyX25hbWUiOiJhZG1pbiIsInNjb3BlIjpbIioiXSwibG9naW5OYW1lIjoiYWRtaW4iLCJhdGkiOiI0ZTFmZmRiZC1jYzBkLTQ5YjUtYTRkNi02ZGZjMzg1ODRjNjkiLCJleHAiOjE1Nzg2MzI1MTUsImF1dGhvcml0aWVzIjpbIi9jYXJ0L2RlbGV0ZVByb2R1Y3QvKiIsIi9tZW51L3NhdmUiLCIvcm9sZS9iaW5kQWN0aW9uIiwiL2FjdGlvbi9kZWxldGVBY3Rpb25CeUlkLyoiLCIvbWVudS9tb2RpZnlTdGF0dXMiLCIvb21jL3Byb2R1Y3QvZGVsZXRlUHJvZHVjdEJ5SWQvKiIsIi9yb2xlL2RlbGV0ZVJvbGVCeUlkLyoiLCIvb21jL2NhdGVnb3J5L2RlbGV0ZUJ5SWQvKiIsIi9kaWN0L21vZGlmeVN0YXR1cyIsIi9vcmRlci9jcmVhdGVPcmRlckRvYy8qIiwiL2VtYWlsL3NlbmRSZXN0RW1haWxDb2RlIiwiL21lbnUvZGVsZXRlQnlJZC8qIiwiL2dyb3VwL2RlbGV0ZUJ5SWQvKiIsIi91c2VyL2JpbmRSb2xlIiwiL3NoaXBwaW5nL3NldERlZmF1bHRBZGRyZXNzLyoiLCIvYWN0aW9uL21vZGlmeVN0YXR1cyIsIi9ncm91cC9zYXZlIiwiL2dyb3VwL2JpbmRVc2VyIiwiL2RpY3Qvc2F2ZSIsIi9hY3Rpb24vY2hlY2tVcmwiLCIvYWN0aW9uL2JhdGNoRGVsZXRlQnlJZExpc3QiLCIvY2FydC9zZWxlY3RBbGxQcm9kdWN0IiwiL2FjdGlvbi9jaGVja0FjdGlvbkNvZGUiLCIvb3JkZXIvY2FuY2VsT3JkZXJEb2MvKiIsIi9yb2xlL21vZGlmeVJvbGVTdGF0dXNCeUlkIiwiL3NoaXBwaW5nL2RlbGV0ZVNoaXBwaW5nLyoiLCIvY2FydC91blNlbGVjdFByb2R1Y3QvKiIsIi9zaGlwcGluZy91cGRhdGVTaGlwcGluZy8qIiwiL2dyb3VwL21vZGlmeVN0YXR1cyIsIi9yb2xlL2JpbmRVc2VyIiwiL3VhYy9yb2xlL3F1ZXJ5TGlzdCIsIi9vbWMvcHJvZHVjdC9zYXZlIiwiL3BheS9hbGlwYXlDYWxsYmFjayIsIi9vbWMvY2F0ZWdvcnkvbW9kaWZ5U3RhdHVzIiwiL2NhcnQvdXBkYXRlSW5mb3JtYXRpb24iLCIvY2FydC91blNlbGVjdEFsbFByb2R1Y3QiLCIvZGljdC9kZWxldGVCeUlkLyoiLCIvdXNlci9zYXZlIiwiL2NhcnQvdXBkYXRlUHJvZHVjdC8qKiIsIi91c2VyL3Jlc2V0TG9naW5Qd2QiLCIvcGF5L2NyZWF0ZVFyQ29kZUltYWdlLyoiLCIvYWN0aW9uL3F1ZXJ5TGlzdFdpdGhQYWdlIiwiL2NhcnQvc2VsZWN0UHJvZHVjdC8qIiwiL2NhcnQvYWRkUHJvZHVjdC8qKiIsIi9yb2xlL3NhdmUiLCIvYWN0aW9uL3NhdmUiLCIvdXNlci9tb2RpZnlVc2VyU3RhdHVzQnlJZCIsIi9zaGlwcGluZy9hZGRTaGlwcGluZyIsIi9vbWMvY2F0ZWdvcnkvc2F2ZSIsIi9yb2xlL2JpbmRNZW51IiwiL3JvbGUvYmF0Y2hEZWxldGVCeUlkTGlzdCJdLCJqdGkiOiIwNGRlYTE2Mi1hNGFjLTRjOWQtYmJmYi0xOGY3ZGRmNTI5YTAiLCJjbGllbnRfaWQiOiJhbmFub3BzLWNsaWVudC11YWMiLCJ0aW1lc3RhbXAiOjE1NzYwNDA1MTU5NzV9.HUfMJJsz7k_BsiioeJAobm-G24c8HY3Mh_9omlLj5Jo', '', '7200', '2592000', '0', '1', 'paascloud', '超级管理员', '1', '2019-12-11 13:01:56', '超级管理员', '1', '2019-12-11 13:01:56');
INSERT INTO `an_uac_user_token` VALUES ('778804319745999872', '0', null, 'admin', '超级管理员', '1', 'Windows 10', 'Chrome', '127.0.0.1', '北京市', '2019-12-11 13:01:56', 'eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJ1c2VyX25hbWUiOiJhZG1pbiIsInNjb3BlIjpbIioiXSwibG9naW5OYW1lIjoiYWRtaW4iLCJleHAiOjE1NzYwNDc5MDksImF1dGhvcml0aWVzIjpbIi9jYXJ0L2RlbGV0ZVByb2R1Y3QvKiIsIi9tZW51L3NhdmUiLCIvcm9sZS9iaW5kQWN0aW9uIiwiL2FjdGlvbi9kZWxldGVBY3Rpb25CeUlkLyoiLCIvbWVudS9tb2RpZnlTdGF0dXMiLCIvb21jL3Byb2R1Y3QvZGVsZXRlUHJvZHVjdEJ5SWQvKiIsIi9yb2xlL2RlbGV0ZVJvbGVCeUlkLyoiLCIvb21jL2NhdGVnb3J5L2RlbGV0ZUJ5SWQvKiIsIi9kaWN0L21vZGlmeVN0YXR1cyIsIi9vcmRlci9jcmVhdGVPcmRlckRvYy8qIiwiL2VtYWlsL3NlbmRSZXN0RW1haWxDb2RlIiwiL21lbnUvZGVsZXRlQnlJZC8qIiwiL2dyb3VwL2RlbGV0ZUJ5SWQvKiIsIi91c2VyL2JpbmRSb2xlIiwiL3NoaXBwaW5nL3NldERlZmF1bHRBZGRyZXNzLyoiLCIvYWN0aW9uL21vZGlmeVN0YXR1cyIsIi9ncm91cC9zYXZlIiwiL2dyb3VwL2JpbmRVc2VyIiwiL2RpY3Qvc2F2ZSIsIi9hY3Rpb24vY2hlY2tVcmwiLCIvYWN0aW9uL2JhdGNoRGVsZXRlQnlJZExpc3QiLCIvY2FydC9zZWxlY3RBbGxQcm9kdWN0IiwiL2FjdGlvbi9jaGVja0FjdGlvbkNvZGUiLCIvb3JkZXIvY2FuY2VsT3JkZXJEb2MvKiIsIi9yb2xlL21vZGlmeVJvbGVTdGF0dXNCeUlkIiwiL3NoaXBwaW5nL2RlbGV0ZVNoaXBwaW5nLyoiLCIvY2FydC91blNlbGVjdFByb2R1Y3QvKiIsIi9zaGlwcGluZy91cGRhdGVTaGlwcGluZy8qIiwiL2dyb3VwL21vZGlmeVN0YXR1cyIsIi9yb2xlL2JpbmRVc2VyIiwiL3VhYy9yb2xlL3F1ZXJ5TGlzdCIsIi9vbWMvcHJvZHVjdC9zYXZlIiwiL3BheS9hbGlwYXlDYWxsYmFjayIsIi9vbWMvY2F0ZWdvcnkvbW9kaWZ5U3RhdHVzIiwiL2NhcnQvdXBkYXRlSW5mb3JtYXRpb24iLCIvY2FydC91blNlbGVjdEFsbFByb2R1Y3QiLCIvZGljdC9kZWxldGVCeUlkLyoiLCIvdXNlci9zYXZlIiwiL2NhcnQvdXBkYXRlUHJvZHVjdC8qKiIsIi91c2VyL3Jlc2V0TG9naW5Qd2QiLCIvcGF5L2NyZWF0ZVFyQ29kZUltYWdlLyoiLCIvYWN0aW9uL3F1ZXJ5TGlzdFdpdGhQYWdlIiwiL2NhcnQvc2VsZWN0UHJvZHVjdC8qIiwiL2NhcnQvYWRkUHJvZHVjdC8qKiIsIi9yb2xlL3NhdmUiLCIvYWN0aW9uL3NhdmUiLCIvdXNlci9tb2RpZnlVc2VyU3RhdHVzQnlJZCIsIi9zaGlwcGluZy9hZGRTaGlwcGluZyIsIi9vbWMvY2F0ZWdvcnkvc2F2ZSIsIi9yb2xlL2JpbmRNZW51IiwiL3JvbGUvYmF0Y2hEZWxldGVCeUlkTGlzdCJdLCJqdGkiOiI3ODg2Nzk5Mi1lNjE1LTRkN2QtODIzNC00ZDcyYTE2NmI3YjYiLCJjbGllbnRfaWQiOiJhbmFub3BzLWNsaWVudC11YWMiLCJ0aW1lc3RhbXAiOjE1NzYwNDA3MDk0ODV9.5-W9DdYPg699CjhPylxVrrmyozY9a6z4cF6Tfzmn5sM', 'eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJ1c2VyX25hbWUiOiJhZG1pbiIsInNjb3BlIjpbIioiXSwibG9naW5OYW1lIjoiYWRtaW4iLCJhdGkiOiI3ODg2Nzk5Mi1lNjE1LTRkN2QtODIzNC00ZDcyYTE2NmI3YjYiLCJleHAiOjE1Nzg2MzI3MDksImF1dGhvcml0aWVzIjpbIi9jYXJ0L2RlbGV0ZVByb2R1Y3QvKiIsIi9tZW51L3NhdmUiLCIvcm9sZS9iaW5kQWN0aW9uIiwiL2FjdGlvbi9kZWxldGVBY3Rpb25CeUlkLyoiLCIvbWVudS9tb2RpZnlTdGF0dXMiLCIvb21jL3Byb2R1Y3QvZGVsZXRlUHJvZHVjdEJ5SWQvKiIsIi9yb2xlL2RlbGV0ZVJvbGVCeUlkLyoiLCIvb21jL2NhdGVnb3J5L2RlbGV0ZUJ5SWQvKiIsIi9kaWN0L21vZGlmeVN0YXR1cyIsIi9vcmRlci9jcmVhdGVPcmRlckRvYy8qIiwiL2VtYWlsL3NlbmRSZXN0RW1haWxDb2RlIiwiL21lbnUvZGVsZXRlQnlJZC8qIiwiL2dyb3VwL2RlbGV0ZUJ5SWQvKiIsIi91c2VyL2JpbmRSb2xlIiwiL3NoaXBwaW5nL3NldERlZmF1bHRBZGRyZXNzLyoiLCIvYWN0aW9uL21vZGlmeVN0YXR1cyIsIi9ncm91cC9zYXZlIiwiL2dyb3VwL2JpbmRVc2VyIiwiL2RpY3Qvc2F2ZSIsIi9hY3Rpb24vY2hlY2tVcmwiLCIvYWN0aW9uL2JhdGNoRGVsZXRlQnlJZExpc3QiLCIvY2FydC9zZWxlY3RBbGxQcm9kdWN0IiwiL2FjdGlvbi9jaGVja0FjdGlvbkNvZGUiLCIvb3JkZXIvY2FuY2VsT3JkZXJEb2MvKiIsIi9yb2xlL21vZGlmeVJvbGVTdGF0dXNCeUlkIiwiL3NoaXBwaW5nL2RlbGV0ZVNoaXBwaW5nLyoiLCIvY2FydC91blNlbGVjdFByb2R1Y3QvKiIsIi9zaGlwcGluZy91cGRhdGVTaGlwcGluZy8qIiwiL2dyb3VwL21vZGlmeVN0YXR1cyIsIi9yb2xlL2JpbmRVc2VyIiwiL3VhYy9yb2xlL3F1ZXJ5TGlzdCIsIi9vbWMvcHJvZHVjdC9zYXZlIiwiL3BheS9hbGlwYXlDYWxsYmFjayIsIi9vbWMvY2F0ZWdvcnkvbW9kaWZ5U3RhdHVzIiwiL2NhcnQvdXBkYXRlSW5mb3JtYXRpb24iLCIvY2FydC91blNlbGVjdEFsbFByb2R1Y3QiLCIvZGljdC9kZWxldGVCeUlkLyoiLCIvdXNlci9zYXZlIiwiL2NhcnQvdXBkYXRlUHJvZHVjdC8qKiIsIi91c2VyL3Jlc2V0TG9naW5Qd2QiLCIvcGF5L2NyZWF0ZVFyQ29kZUltYWdlLyoiLCIvYWN0aW9uL3F1ZXJ5TGlzdFdpdGhQYWdlIiwiL2NhcnQvc2VsZWN0UHJvZHVjdC8qIiwiL2NhcnQvYWRkUHJvZHVjdC8qKiIsIi9yb2xlL3NhdmUiLCIvYWN0aW9uL3NhdmUiLCIvdXNlci9tb2RpZnlVc2VyU3RhdHVzQnlJZCIsIi9zaGlwcGluZy9hZGRTaGlwcGluZyIsIi9vbWMvY2F0ZWdvcnkvc2F2ZSIsIi9yb2xlL2JpbmRNZW51IiwiL3JvbGUvYmF0Y2hEZWxldGVCeUlkTGlzdCJdLCJqdGkiOiI3MGYxOGJiZS03MmVjLTQ3MzItYTgyZC00NWE0ZmYxMjBiYjYiLCJjbGllbnRfaWQiOiJhbmFub3BzLWNsaWVudC11YWMiLCJ0aW1lc3RhbXAiOjE1NzYwNDA3MDk0ODV9.GGRpS_V9fm_xOg8xJAZkFty8rUGBkV3uepwFSku_vbU', '', '7200', '2592000', '0', '1', 'paascloud', '超级管理员', '1', '2019-12-11 13:05:10', '超级管理员', '1', '2019-12-11 13:05:10');

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
INSERT INTO `databasechangelog` VALUES ('init-schema', 'paascloud.net@gmail.com', 'classpath:liquibase/change_log/2017-06-10-init-schema.xml', '2019-12-10 21:10:58', '1', 'EXECUTED', '7:cebd02a08a9ed3d700e360cd5d26bb72', 'createTable tableName=user', 'init schema', null, '3.5.3', null, null, '5983458108');

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
-- Table structure for persistent_logins
-- ----------------------------
DROP TABLE IF EXISTS `persistent_logins`;
CREATE TABLE `persistent_logins` (
  `username` varchar(64) NOT NULL,
  `series` varchar(64) NOT NULL,
  `token` varchar(64) NOT NULL,
  `last_used` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`series`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- ----------------------------
-- Records of persistent_logins
-- ----------------------------

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
