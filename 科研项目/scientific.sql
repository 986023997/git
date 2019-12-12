/*
Navicat MySQL Data Transfer

Source Server         : mysql
Source Server Version : 50637
Source Host           : localhost:3306
Source Database       : scientific

Target Server Type    : MYSQL
Target Server Version : 50637
File Encoding         : 65001

Date: 2019-12-01 16:58:51
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `department`
-- ----------------------------
DROP TABLE IF EXISTS `department`;
CREATE TABLE `department` (
  `Depart_id` int(11) NOT NULL AUTO_INCREMENT,
  `Depart_name` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`Depart_id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of department
-- ----------------------------
INSERT INTO `department` VALUES ('1', '生产部');
INSERT INTO `department` VALUES ('2', '市场部');
INSERT INTO `department` VALUES ('3', '科研管理部');
INSERT INTO `department` VALUES ('5', '管理员');

-- ----------------------------
-- Table structure for `item`
-- ----------------------------
DROP TABLE IF EXISTS `item`;
CREATE TABLE `item` (
  `Item_id` int(11) NOT NULL AUTO_INCREMENT,
  `Item_name` varchar(255) DEFAULT NULL,
  `Item_app_id` int(11) DEFAULT NULL,
  `Item_date` date DEFAULT NULL,
  `Item_topic` varchar(255) DEFAULT NULL,
  `Item_content` varchar(255) DEFAULT NULL,
  `Item_fund` varchar(255) DEFAULT NULL,
  `Item_status1` int(11) DEFAULT '0',
  `Item_Check_id1` varchar(11) DEFAULT NULL,
  `Item_status2` int(11) DEFAULT '0',
  `Item_Check_id2` varchar(11) DEFAULT NULL,
  PRIMARY KEY (`Item_id`)
) ENGINE=InnoDB AUTO_INCREMENT=16 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of item
-- ----------------------------
INSERT INTO `item` VALUES ('2', '办公无纸化的研究', '1', '2019-11-24', '现代化', '现代化办公方式的多样化', '2000', '2', '朱林', '2', '朱林');
INSERT INTO `item` VALUES ('5', '南昌航空大学科技学院网上报名系统', '1', '2019-12-25', '网上，报名', '收到的疯狂送到家附近收到了副驾驶的垃圾分类是解放路口设计分类考试的福利看手机登录福建省砥砺奋进路上看到就凉快圣诞节分类考试的经费时间分类考试等级分类考试等级分类考试等级分类考试杜绝浪费会计师代理费酸辣粉收到了开房记录SDK冯老师独立开发技术带来菲利克斯法律会计师独立开发就算了分离式的f', '10000000', '2', '朱林', '0', '');
INSERT INTO `item` VALUES ('11', '江西省科学院', '2', '2019-11-24', '科研', '南昌航空大学科技学院', '10000', '1', 'lisi', '1', 'wang5');
INSERT INTO `item` VALUES ('12', '南昌航空大学科技学院网上报名系统', '2', '2019-11-24', '报名', '江西省科学院', '10000000', '1', 'lisi', '0', null);
INSERT INTO `item` VALUES ('13', '办公无纸化的研究', '1', '2019-11-24', '现代化办公', '现代化办公方式的多样化', '2000', '0', null, '0', null);
INSERT INTO `item` VALUES ('14', '南昌航空大学科技学院网上报名系统', '1', '2019-12-25', '网上报名', '收到的疯狂送到家附近收到了副驾驶的垃圾分类是解放路口设计分类考试的福利看手机登录福建省砥砺奋进路上看到就凉快圣诞节分类考试的经费时间分类考试等级分类考试等级分类考试等级分类考试杜绝浪费会计师代理费酸辣粉收到了开房记录SDK冯老师独立开发技术带来菲利克斯法律会计师独立开发就算了分离式的f', '10000000', '0', null, '0', null);
INSERT INTO `item` VALUES ('15', '公司垃圾分类', '10', '2019-12-25', '垃圾分类', '江西省科学院', '2000', '1', 'lisi', '1', 'wang5');

-- ----------------------------
-- Table structure for `limit1`
-- ----------------------------
DROP TABLE IF EXISTS `limit1`;
CREATE TABLE `limit1` (
  `Limit_id` int(11) NOT NULL AUTO_INCREMENT,
  `Limit_url` text,
  PRIMARY KEY (`Limit_id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8 ROW_FORMAT=COMPACT;

-- ----------------------------
-- Records of limit1
-- ----------------------------
INSERT INTO `limit1` VALUES ('1', '/LoginServlet/UserInfoServlet/UpdatePasswordServlet/UpdateUserServlet/ItemApplicationServlet/ItemShowServlet/ShowContentServlet/DeleteItemServlet/UpdateItemUIServlet/UpdateItemServlet/DepartItemShowServlet/DepartItemCheckServlet/ItemNoCheckServlet/ChargeDepartItemListServlet/ChargeItemCheckServlet/AdminServlet/pages/user_item/itemapplication2.jsp/UserManagerServlet');
INSERT INTO `limit1` VALUES ('2', '/LoginServlet/UserInfoServlet/UpdatePasswordServlet/UpdateUserServlet/ItemApplicationServlet/ItemShowServlet/ShowContentServlet/DeleteItemServlet/UpdateItemUIServlet/UpdateItemServlet/pages/user_item/itemapplication2.jsp/UserInfoServlet/ItemShowServlet/ShowContentServlet');
INSERT INTO `limit1` VALUES ('3', '/DepartItemShowServlet/DepartItemCheckServlet/ItemNoCheckServlet/UserInfoServlet/ShowContentServlet');
INSERT INTO `limit1` VALUES ('4', '/ChargeDepartItemListServlet/ChargeItemCheckServlet/UserInfoServlet/ShowContentServlet');

-- ----------------------------
-- Table structure for `role`
-- ----------------------------
DROP TABLE IF EXISTS `role`;
CREATE TABLE `role` (
  `Role_id` int(11) NOT NULL AUTO_INCREMENT,
  `Role_name` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`Role_id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of role
-- ----------------------------
INSERT INTO `role` VALUES ('1', '管理员');
INSERT INTO `role` VALUES ('2', '部门员工');
INSERT INTO `role` VALUES ('3', '部门管理');
INSERT INTO `role` VALUES ('4', '科研部门管理');

-- ----------------------------
-- Table structure for `role_limit`
-- ----------------------------
DROP TABLE IF EXISTS `role_limit`;
CREATE TABLE `role_limit` (
  `Role_Limit_id` int(11) NOT NULL AUTO_INCREMENT,
  `Role_id` int(11) DEFAULT NULL,
  `Limit_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`Role_Limit_id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of role_limit
-- ----------------------------
INSERT INTO `role_limit` VALUES ('1', '1', '1');
INSERT INTO `role_limit` VALUES ('2', '2', '2');
INSERT INTO `role_limit` VALUES ('3', '3', '3');
INSERT INTO `role_limit` VALUES ('4', '4', '4');

-- ----------------------------
-- Table structure for `user`
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `User_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '员工id',
  `User_name` varchar(255) DEFAULT NULL COMMENT '员工名字',
  `User_password` varchar(255) DEFAULT NULL,
  `User_realname` varchar(255) DEFAULT NULL,
  `User_age` int(11) DEFAULT NULL,
  `User_sex` varchar(255) DEFAULT NULL,
  `User_depart_id` int(11) DEFAULT NULL,
  `User_mail` varchar(255) DEFAULT NULL,
  `User_phone` varchar(255) DEFAULT NULL,
  `User_address` varchar(255) DEFAULT NULL,
  `User_date` date DEFAULT NULL,
  PRIMARY KEY (`User_id`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES ('1', 'admin', 'admin', 'admin', '22', '男', '0', '2405943665@qq.com', '13672263043', '江西省赣州市南康区天马山大道', '2019-11-22');
INSERT INTO `user` VALUES ('2', 'zhang3', '123456', 'zhang3', '26', '男', '1', '986023997@qq.com', '13065125513', '江西省gzs', '2019-11-24');
INSERT INTO `user` VALUES ('3', 'lisi', '123456', 'lisi', '22', '男', '1', '986023997@qq.com', '13065125513', '江西省', '2019-11-24');
INSERT INTO `user` VALUES ('4', 'wang5', '123456', 'wang5', '22', '男', '3', '986023997@qq.com', '13065125513', '江西省', '2019-11-24');
INSERT INTO `user` VALUES ('5', 'zl', '123456', 'zzz', '22', '男', '0', '2405943665@qq.com', '13672263043', '江西省赣州市', '2019-11-30');
INSERT INTO `user` VALUES ('10', 'zhao6', '123', '赵六', '12', '女', '1', '986023997@qq.com', '13065125513', '江西省赣州市南康区', '2019-12-25');

-- ----------------------------
-- Table structure for `user_role`
-- ----------------------------
DROP TABLE IF EXISTS `user_role`;
CREATE TABLE `user_role` (
  `User_Role_id` int(11) NOT NULL AUTO_INCREMENT,
  `User_id` int(11) DEFAULT NULL,
  `Role_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`User_Role_id`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of user_role
-- ----------------------------
INSERT INTO `user_role` VALUES ('1', '1', '1');
INSERT INTO `user_role` VALUES ('2', '2', '2');
INSERT INTO `user_role` VALUES ('3', '3', '3');
INSERT INTO `user_role` VALUES ('4', '4', '4');
INSERT INTO `user_role` VALUES ('6', '5', '1');
INSERT INTO `user_role` VALUES ('8', '9', '1');
INSERT INTO `user_role` VALUES ('9', '10', '2');
