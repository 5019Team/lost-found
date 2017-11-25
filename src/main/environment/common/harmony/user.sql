/*
Navicat MySQL Data Transfer

Source Server         : localhost_3306
Source Server Version : 50717
Source Host           : localhost:3306
Source Database       : harmony

Target Server Type    : MYSQL
Target Server Version : 50717
File Encoding         : 65001

Date: 2017-11-25 14:32:49
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `usercode` char(20) NOT NULL COMMENT '用户编码',
  `nickname` char(10) NOT NULL COMMENT '昵称',
  `email` char(30) NOT NULL COMMENT '邮箱',
  `password` char(20) NOT NULL COMMENT '密码',
  `type` tinyint(2) NOT NULL COMMENT '账号类型: 0-注册账号，1-QQ登录，2-WeChat登录',
  `state` tinyint(2) NOT NULL COMMENT '状态 0-禁用，1-启用',
  `modify_time` datetime NOT NULL ON UPDATE CURRENT_TIMESTAMP COMMENT '修改时间',
  `create_time` datetime NOT NULL COMMENT '创建时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='账号表';
