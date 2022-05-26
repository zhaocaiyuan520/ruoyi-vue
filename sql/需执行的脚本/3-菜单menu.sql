/*
Navicat MySQL Data Transfer

Source Server         : 本地链接982
Source Server Version : 50527
Source Host           : localhost:3306
Source Database       : ry-vue

Target Server Type    : MYSQL
Target Server Version : 50527
File Encoding         : 65001

Date: 2022-05-25 22:16:15
*/
--
-- SET FOREIGN_KEY_CHECKS=0;
--
-- -- ----------------------------
-- -- Table structure for `sys_menu`
-- -- ----------------------------
-- DROP TABLE IF EXISTS `sys_menu`;
-- CREATE TABLE `sys_menu` (
--   `menu_id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '菜单ID',
--   `menu_name` varchar(50) NOT NULL COMMENT '菜单名称',
--   `parent_id` bigint(20) DEFAULT '0' COMMENT '父菜单ID',
--   `order_num` int(4) DEFAULT '0' COMMENT '显示顺序',
--   `path` varchar(200) DEFAULT '' COMMENT '路由地址',
--   `component` varchar(255) DEFAULT NULL COMMENT '组件路径',
--   `query` varchar(255) DEFAULT NULL COMMENT '路由参数',
--   `is_frame` int(1) DEFAULT '1' COMMENT '是否为外链（0是 1否）',
--   `is_cache` int(1) DEFAULT '0' COMMENT '是否缓存（0缓存 1不缓存）',
--   `menu_type` char(1) DEFAULT '' COMMENT '菜单类型（M目录 C菜单 F按钮）',
--   `visible` char(1) DEFAULT '0' COMMENT '菜单状态（0显示 1隐藏）',
--   `status` char(1) DEFAULT '0' COMMENT '菜单状态（0正常 1停用）',
--   `perms` varchar(100) DEFAULT NULL COMMENT '权限标识',
--   `icon` varchar(100) DEFAULT '#' COMMENT '菜单图标',
--   `create_by` varchar(64) DEFAULT '' COMMENT '创建者',
--   `create_time` datetime DEFAULT NULL COMMENT '创建时间',
--   `update_by` varchar(64) DEFAULT '' COMMENT '更新者',
--   `update_time` datetime DEFAULT NULL COMMENT '更新时间',
--   `remark` varchar(500) DEFAULT '' COMMENT '备注',
--   PRIMARY KEY (`menu_id`)
-- ) ENGINE=InnoDB AUTO_INCREMENT=2048 DEFAULT CHARSET=utf8 COMMENT='菜单权限表';

-- ----------------------------
-- Records of sys_menu
-- ----------------------------
INSERT INTO `sys_menu` VALUES ('1', '系统管理', '0', '1', 'system', null, '', '1', '0', 'M', '1', '0', '', 'system', 'admin', '2022-05-08 16:00:26', '', null, '系统管理目录');
INSERT INTO `sys_menu` VALUES ('2', '系统监控', '0', '2', 'monitor', null, '', '1', '0', 'M', '1', '0', '', 'monitor', 'admin', '2022-05-08 16:00:26', '', null, '系统监控目录');
INSERT INTO `sys_menu` VALUES ('3', '功能菜单', '0', '3', 'tool', null, '', '1', '0', 'M', '1', '0', '', 'tool', 'admin', '2022-05-08 16:00:26', '', null, '系统工具目录');
INSERT INTO `sys_menu` VALUES ('4', '若依官网', '0', '4', 'http://ruoyi.vip', null, '', '0', '0', 'M', '1', '0', '', 'guide', 'admin', '2022-05-08 16:00:26', '', null, '若依官网地址');
INSERT INTO `sys_menu` VALUES ('100', '用户管理', '1', '1', 'user', 'system/user/index', '', '1', '0', 'C', '0', '0', 'system:user:list', 'user', 'admin', '2022-05-08 16:00:26', '', null, '用户管理菜单');
INSERT INTO `sys_menu` VALUES ('101', '角色管理', '1', '2', 'role', 'system/role/index', '', '1', '0', 'C', '0', '0', 'system:role:list', 'peoples', 'admin', '2022-05-08 16:00:26', '', null, '角色管理菜单');
INSERT INTO `sys_menu` VALUES ('102', '菜单管理', '1', '3', 'menu', 'system/menu/index', '', '1', '0', 'C', '0', '0', 'system:menu:list', 'tree-table', 'admin', '2022-05-08 16:00:26', '', null, '菜单管理菜单');
INSERT INTO `sys_menu` VALUES ('103', '部门管理', '1', '4', 'dept', 'system/dept/index', '', '1', '0', 'C', '0', '0', 'system:dept:list', 'tree', 'admin', '2022-05-08 16:00:26', '', null, '部门管理菜单');
INSERT INTO `sys_menu` VALUES ('104', '岗位管理', '1', '5', 'post', 'system/post/index', '', '1', '0', 'C', '0', '0', 'system:post:list', 'post', 'admin', '2022-05-08 16:00:26', '', null, '岗位管理菜单');
INSERT INTO `sys_menu` VALUES ('105', '字典管理', '1', '6', 'dict', 'system/dict/index', '', '1', '0', 'C', '0', '0', 'system:dict:list', 'dict', 'admin', '2022-05-08 16:00:26', '', null, '字典管理菜单');
INSERT INTO `sys_menu` VALUES ('106', '参数设置', '1', '7', 'config', 'system/config/index', '', '1', '0', 'C', '0', '0', 'system:config:list', 'edit', 'admin', '2022-05-08 16:00:26', '', null, '参数设置菜单');
INSERT INTO `sys_menu` VALUES ('107', '通知公告', '1', '8', 'notice', 'system/notice/index', '', '1', '0', 'C', '0', '0', 'system:notice:list', 'message', 'admin', '2022-05-08 16:00:27', '', null, '通知公告菜单');
INSERT INTO `sys_menu` VALUES ('108', '日志管理', '1', '9', 'log', '', '', '1', '0', 'M', '0', '0', '', 'log', 'admin', '2022-05-08 16:00:27', '', null, '日志管理菜单');
INSERT INTO `sys_menu` VALUES ('109', '在线用户', '2', '1', 'online', 'monitor/online/index', '', '1', '0', 'C', '0', '0', 'monitor:online:list', 'online', 'admin', '2022-05-08 16:00:27', '', null, '在线用户菜单');
INSERT INTO `sys_menu` VALUES ('110', '定时任务', '2', '2', 'job', 'monitor/job/index', '', '1', '0', 'C', '0', '0', 'monitor:job:list', 'job', 'admin', '2022-05-08 16:00:27', '', null, '定时任务菜单');
INSERT INTO `sys_menu` VALUES ('111', '数据监控', '2', '3', 'druid', 'monitor/druid/index', '', '1', '0', 'C', '0', '0', 'monitor:druid:list', 'druid', 'admin', '2022-05-08 16:00:27', '', null, '数据监控菜单');
INSERT INTO `sys_menu` VALUES ('112', '服务监控', '2', '4', 'server', 'monitor/server/index', '', '1', '0', 'C', '0', '0', 'monitor:server:list', 'server', 'admin', '2022-05-08 16:00:27', '', null, '服务监控菜单');
INSERT INTO `sys_menu` VALUES ('113', '缓存监控', '2', '5', 'cache', 'monitor/cache/index', '', '1', '0', 'C', '0', '0', 'monitor:cache:list', 'redis', 'admin', '2022-05-08 16:00:27', '', null, '缓存监控菜单');
INSERT INTO `sys_menu` VALUES ('114', '表单构建', '3', '1', 'build', 'tool/build/index', '', '1', '0', 'C', '1', '0', 'tool:build:list', 'build', 'admin', '2022-05-08 16:00:27', '', null, '表单构建菜单');
INSERT INTO `sys_menu` VALUES ('115', '代码生成', '3', '2', 'gen', 'tool/gen/index', '', '1', '0', 'C', '1', '0', 'tool:gen:list', 'code', 'admin', '2022-05-08 16:00:27', '', null, '代码生成菜单');
INSERT INTO `sys_menu` VALUES ('116', '系统接口', '3', '3', 'swagger', 'tool/swagger/index', '', '1', '0', 'C', '1', '0', 'tool:swagger:list', 'swagger', 'admin', '2022-05-08 16:00:27', '', null, '系统接口菜单');
INSERT INTO `sys_menu` VALUES ('500', '操作日志', '108', '1', 'operlog', 'monitor/operlog/index', '', '1', '0', 'C', '0', '0', 'monitor:operlog:list', 'form', 'admin', '2022-05-08 16:00:27', '', null, '操作日志菜单');
INSERT INTO `sys_menu` VALUES ('501', '登录日志', '108', '2', 'logininfor', 'monitor/logininfor/index', '', '1', '0', 'C', '0', '0', 'monitor:logininfor:list', 'logininfor', 'admin', '2022-05-08 16:00:27', '', null, '登录日志菜单');
INSERT INTO `sys_menu` VALUES ('1001', '用户查询', '100', '1', '', '', '', '1', '0', 'F', '0', '0', 'system:user:query', '#', 'admin', '2022-05-08 16:00:27', '', null, '');
INSERT INTO `sys_menu` VALUES ('1002', '用户新增', '100', '2', '', '', '', '1', '0', 'F', '0', '0', 'system:user:add', '#', 'admin', '2022-05-08 16:00:27', '', null, '');
INSERT INTO `sys_menu` VALUES ('1003', '用户修改', '100', '3', '', '', '', '1', '0', 'F', '0', '0', 'system:user:edit', '#', 'admin', '2022-05-08 16:00:27', '', null, '');
INSERT INTO `sys_menu` VALUES ('1004', '用户删除', '100', '4', '', '', '', '1', '0', 'F', '0', '0', 'system:user:remove', '#', 'admin', '2022-05-08 16:00:28', '', null, '');
INSERT INTO `sys_menu` VALUES ('1005', '用户导出', '100', '5', '', '', '', '1', '0', 'F', '0', '0', 'system:user:export', '#', 'admin', '2022-05-08 16:00:28', '', null, '');
INSERT INTO `sys_menu` VALUES ('1006', '用户导入', '100', '6', '', '', '', '1', '0', 'F', '0', '0', 'system:user:import', '#', 'admin', '2022-05-08 16:00:28', '', null, '');
INSERT INTO `sys_menu` VALUES ('1007', '重置密码', '100', '7', '', '', '', '1', '0', 'F', '0', '0', 'system:user:resetPwd', '#', 'admin', '2022-05-08 16:00:28', '', null, '');
INSERT INTO `sys_menu` VALUES ('1008', '角色查询', '101', '1', '', '', '', '1', '0', 'F', '0', '0', 'system:role:query', '#', 'admin', '2022-05-08 16:00:28', '', null, '');
INSERT INTO `sys_menu` VALUES ('1009', '角色新增', '101', '2', '', '', '', '1', '0', 'F', '0', '0', 'system:role:add', '#', 'admin', '2022-05-08 16:00:28', '', null, '');
INSERT INTO `sys_menu` VALUES ('1010', '角色修改', '101', '3', '', '', '', '1', '0', 'F', '0', '0', 'system:role:edit', '#', 'admin', '2022-05-08 16:00:28', '', null, '');
INSERT INTO `sys_menu` VALUES ('1011', '角色删除', '101', '4', '', '', '', '1', '0', 'F', '0', '0', 'system:role:remove', '#', 'admin', '2022-05-08 16:00:28', '', null, '');
INSERT INTO `sys_menu` VALUES ('1012', '角色导出', '101', '5', '', '', '', '1', '0', 'F', '0', '0', 'system:role:export', '#', 'admin', '2022-05-08 16:00:28', '', null, '');
INSERT INTO `sys_menu` VALUES ('1013', '菜单查询', '102', '1', '', '', '', '1', '0', 'F', '0', '0', 'system:menu:query', '#', 'admin', '2022-05-08 16:00:28', '', null, '');
INSERT INTO `sys_menu` VALUES ('1014', '菜单新增', '102', '2', '', '', '', '1', '0', 'F', '0', '0', 'system:menu:add', '#', 'admin', '2022-05-08 16:00:28', '', null, '');
INSERT INTO `sys_menu` VALUES ('1015', '菜单修改', '102', '3', '', '', '', '1', '0', 'F', '0', '0', 'system:menu:edit', '#', 'admin', '2022-05-08 16:00:28', '', null, '');
INSERT INTO `sys_menu` VALUES ('1016', '菜单删除', '102', '4', '', '', '', '1', '0', 'F', '0', '0', 'system:menu:remove', '#', 'admin', '2022-05-08 16:00:28', '', null, '');
INSERT INTO `sys_menu` VALUES ('1017', '部门查询', '103', '1', '', '', '', '1', '0', 'F', '0', '0', 'system:dept:query', '#', 'admin', '2022-05-08 16:00:28', '', null, '');
INSERT INTO `sys_menu` VALUES ('1018', '部门新增', '103', '2', '', '', '', '1', '0', 'F', '0', '0', 'system:dept:add', '#', 'admin', '2022-05-08 16:00:28', '', null, '');
INSERT INTO `sys_menu` VALUES ('1019', '部门修改', '103', '3', '', '', '', '1', '0', 'F', '0', '0', 'system:dept:edit', '#', 'admin', '2022-05-08 16:00:28', '', null, '');
INSERT INTO `sys_menu` VALUES ('1020', '部门删除', '103', '4', '', '', '', '1', '0', 'F', '0', '0', 'system:dept:remove', '#', 'admin', '2022-05-08 16:00:29', '', null, '');
INSERT INTO `sys_menu` VALUES ('1021', '岗位查询', '104', '1', '', '', '', '1', '0', 'F', '0', '0', 'system:post:query', '#', 'admin', '2022-05-08 16:00:29', '', null, '');
INSERT INTO `sys_menu` VALUES ('1022', '岗位新增', '104', '2', '', '', '', '1', '0', 'F', '0', '0', 'system:post:add', '#', 'admin', '2022-05-08 16:00:29', '', null, '');
INSERT INTO `sys_menu` VALUES ('1023', '岗位修改', '104', '3', '', '', '', '1', '0', 'F', '0', '0', 'system:post:edit', '#', 'admin', '2022-05-08 16:00:29', '', null, '');
INSERT INTO `sys_menu` VALUES ('1024', '岗位删除', '104', '4', '', '', '', '1', '0', 'F', '0', '0', 'system:post:remove', '#', 'admin', '2022-05-08 16:00:29', '', null, '');
INSERT INTO `sys_menu` VALUES ('1025', '岗位导出', '104', '5', '', '', '', '1', '0', 'F', '0', '0', 'system:post:export', '#', 'admin', '2022-05-08 16:00:29', '', null, '');
INSERT INTO `sys_menu` VALUES ('1026', '字典查询', '105', '1', '#', '', '', '1', '0', 'F', '0', '0', 'system:dict:query', '#', 'admin', '2022-05-08 16:00:29', '', null, '');
INSERT INTO `sys_menu` VALUES ('1027', '字典新增', '105', '2', '#', '', '', '1', '0', 'F', '0', '0', 'system:dict:add', '#', 'admin', '2022-05-08 16:00:29', '', null, '');
INSERT INTO `sys_menu` VALUES ('1028', '字典修改', '105', '3', '#', '', '', '1', '0', 'F', '0', '0', 'system:dict:edit', '#', 'admin', '2022-05-08 16:00:29', '', null, '');
INSERT INTO `sys_menu` VALUES ('1029', '字典删除', '105', '4', '#', '', '', '1', '0', 'F', '0', '0', 'system:dict:remove', '#', 'admin', '2022-05-08 16:00:29', '', null, '');
INSERT INTO `sys_menu` VALUES ('1030', '字典导出', '105', '5', '#', '', '', '1', '0', 'F', '0', '0', 'system:dict:export', '#', 'admin', '2022-05-08 16:00:29', '', null, '');
INSERT INTO `sys_menu` VALUES ('1031', '参数查询', '106', '1', '#', '', '', '1', '0', 'F', '0', '0', 'system:config:query', '#', 'admin', '2022-05-08 16:00:29', '', null, '');
INSERT INTO `sys_menu` VALUES ('1032', '参数新增', '106', '2', '#', '', '', '1', '0', 'F', '0', '0', 'system:config:add', '#', 'admin', '2022-05-08 16:00:29', '', null, '');
INSERT INTO `sys_menu` VALUES ('1033', '参数修改', '106', '3', '#', '', '', '1', '0', 'F', '0', '0', 'system:config:edit', '#', 'admin', '2022-05-08 16:00:29', '', null, '');
INSERT INTO `sys_menu` VALUES ('1034', '参数删除', '106', '4', '#', '', '', '1', '0', 'F', '0', '0', 'system:config:remove', '#', 'admin', '2022-05-08 16:00:30', '', null, '');
INSERT INTO `sys_menu` VALUES ('1035', '参数导出', '106', '5', '#', '', '', '1', '0', 'F', '0', '0', 'system:config:export', '#', 'admin', '2022-05-08 16:00:30', '', null, '');
INSERT INTO `sys_menu` VALUES ('1036', '公告查询', '107', '1', '#', '', '', '1', '0', 'F', '0', '0', 'system:notice:query', '#', 'admin', '2022-05-08 16:00:30', '', null, '');
INSERT INTO `sys_menu` VALUES ('1037', '公告新增', '107', '2', '#', '', '', '1', '0', 'F', '0', '0', 'system:notice:add', '#', 'admin', '2022-05-08 16:00:30', '', null, '');
INSERT INTO `sys_menu` VALUES ('1038', '公告修改', '107', '3', '#', '', '', '1', '0', 'F', '0', '0', 'system:notice:edit', '#', 'admin', '2022-05-08 16:00:30', '', null, '');
INSERT INTO `sys_menu` VALUES ('1039', '公告删除', '107', '4', '#', '', '', '1', '0', 'F', '0', '0', 'system:notice:remove', '#', 'admin', '2022-05-08 16:00:30', '', null, '');
INSERT INTO `sys_menu` VALUES ('1040', '操作查询', '500', '1', '#', '', '', '1', '0', 'F', '0', '0', 'monitor:operlog:query', '#', 'admin', '2022-05-08 16:00:30', '', null, '');
INSERT INTO `sys_menu` VALUES ('1041', '操作删除', '500', '2', '#', '', '', '1', '0', 'F', '0', '0', 'monitor:operlog:remove', '#', 'admin', '2022-05-08 16:00:30', '', null, '');
INSERT INTO `sys_menu` VALUES ('1042', '日志导出', '500', '4', '#', '', '', '1', '0', 'F', '0', '0', 'monitor:operlog:export', '#', 'admin', '2022-05-08 16:00:30', '', null, '');
INSERT INTO `sys_menu` VALUES ('1043', '登录查询', '501', '1', '#', '', '', '1', '0', 'F', '0', '0', 'monitor:logininfor:query', '#', 'admin', '2022-05-08 16:00:30', '', null, '');
INSERT INTO `sys_menu` VALUES ('1044', '登录删除', '501', '2', '#', '', '', '1', '0', 'F', '0', '0', 'monitor:logininfor:remove', '#', 'admin', '2022-05-08 16:00:30', '', null, '');
INSERT INTO `sys_menu` VALUES ('1045', '日志导出', '501', '3', '#', '', '', '1', '0', 'F', '0', '0', 'monitor:logininfor:export', '#', 'admin', '2022-05-08 16:00:30', '', null, '');
INSERT INTO `sys_menu` VALUES ('1046', '在线查询', '109', '1', '#', '', '', '1', '0', 'F', '0', '0', 'monitor:online:query', '#', 'admin', '2022-05-08 16:00:30', '', null, '');
INSERT INTO `sys_menu` VALUES ('1047', '批量强退', '109', '2', '#', '', '', '1', '0', 'F', '0', '0', 'monitor:online:batchLogout', '#', 'admin', '2022-05-08 16:00:30', '', null, '');
INSERT INTO `sys_menu` VALUES ('1048', '单条强退', '109', '3', '#', '', '', '1', '0', 'F', '0', '0', 'monitor:online:forceLogout', '#', 'admin', '2022-05-08 16:00:31', '', null, '');
INSERT INTO `sys_menu` VALUES ('1049', '任务查询', '110', '1', '#', '', '', '1', '0', 'F', '0', '0', 'monitor:job:query', '#', 'admin', '2022-05-08 16:00:31', '', null, '');
INSERT INTO `sys_menu` VALUES ('1050', '任务新增', '110', '2', '#', '', '', '1', '0', 'F', '0', '0', 'monitor:job:add', '#', 'admin', '2022-05-08 16:00:31', '', null, '');
INSERT INTO `sys_menu` VALUES ('1051', '任务修改', '110', '3', '#', '', '', '1', '0', 'F', '0', '0', 'monitor:job:edit', '#', 'admin', '2022-05-08 16:00:31', '', null, '');
INSERT INTO `sys_menu` VALUES ('1052', '任务删除', '110', '4', '#', '', '', '1', '0', 'F', '0', '0', 'monitor:job:remove', '#', 'admin', '2022-05-08 16:00:31', '', null, '');
INSERT INTO `sys_menu` VALUES ('1053', '状态修改', '110', '5', '#', '', '', '1', '0', 'F', '0', '0', 'monitor:job:changeStatus', '#', 'admin', '2022-05-08 16:00:31', '', null, '');
INSERT INTO `sys_menu` VALUES ('1054', '任务导出', '110', '7', '#', '', '', '1', '0', 'F', '0', '0', 'monitor:job:export', '#', 'admin', '2022-05-08 16:00:31', '', null, '');
INSERT INTO `sys_menu` VALUES ('1055', '生成查询', '115', '1', '#', '', '', '1', '0', 'F', '0', '0', 'tool:gen:query', '#', 'admin', '2022-05-08 16:00:31', '', null, '');
INSERT INTO `sys_menu` VALUES ('1056', '生成修改', '115', '2', '#', '', '', '1', '0', 'F', '0', '0', 'tool:gen:edit', '#', 'admin', '2022-05-08 16:00:31', '', null, '');
INSERT INTO `sys_menu` VALUES ('1057', '生成删除', '115', '3', '#', '', '', '1', '0', 'F', '0', '0', 'tool:gen:remove', '#', 'admin', '2022-05-08 16:00:31', '', null, '');
INSERT INTO `sys_menu` VALUES ('1058', '导入代码', '115', '2', '#', '', '', '1', '0', 'F', '0', '0', 'tool:gen:import', '#', 'admin', '2022-05-08 16:00:31', '', null, '');
INSERT INTO `sys_menu` VALUES ('1059', '预览代码', '115', '4', '#', '', '', '1', '0', 'F', '0', '0', 'tool:gen:preview', '#', 'admin', '2022-05-08 16:00:31', '', null, '');
INSERT INTO `sys_menu` VALUES ('1060', '生成代码', '115', '5', '#', '', '', '1', '0', 'F', '0', '0', 'tool:gen:code', '#', 'admin', '2022-05-08 16:00:31', '', null, '');
INSERT INTO `sys_menu` VALUES ('2000', '模块一:主页文章', '0', '1', 'article', 'system/article/index', null, '1', '0', 'C', '0', '0', 'system:article:list', '#', 'admin', '2022-05-08 20:35:31', '', null, '主页详情菜单');
INSERT INTO `sys_menu` VALUES ('2001', '主页文章查询', '2000', '1', '#', '', null, '1', '0', 'F', '0', '0', 'system:article:query', '#', 'admin', '2022-05-08 20:35:31', '', null, '');
INSERT INTO `sys_menu` VALUES ('2002', '主页文章新增', '2000', '2', '#', '', null, '1', '0', 'F', '0', '0', 'system:article:add', '#', 'admin', '2022-05-08 20:35:31', '', null, '');
INSERT INTO `sys_menu` VALUES ('2003', '主页文章修改', '2000', '3', '#', '', null, '1', '0', 'F', '0', '0', 'system:article:edit', '#', 'admin', '2022-05-08 20:35:31', '', null, '');
INSERT INTO `sys_menu` VALUES ('2004', '主页文章删除', '2000', '4', '#', '', null, '1', '0', 'F', '0', '0', 'system:article:remove', '#', 'admin', '2022-05-08 20:35:31', '', null, '');
INSERT INTO `sys_menu` VALUES ('2005', '主页文章导出', '2000', '5', '#', '', null, '1', '0', 'F', '0', '0', 'system:article:export', '#', 'admin', '2022-05-08 20:35:31', '', null, '');
INSERT INTO `sys_menu` VALUES ('2006', '模块一:主页详情', '0', '1', 'info', 'system/info/index', null, '1', '0', 'C', '0', '0', 'system:info:list', '#', 'admin', '2022-05-08 20:35:31', '', null, '主页详情菜单');
INSERT INTO `sys_menu` VALUES ('2007', '主页详情查询', '2006', '1', '#', '', null, '1', '0', 'F', '0', '0', 'system:info:query', '#', 'admin', '2022-05-08 20:35:31', '', null, '');
INSERT INTO `sys_menu` VALUES ('2008', '主页详情新增', '2006', '2', '#', '', null, '1', '0', 'F', '0', '0', 'system:info:add', '#', 'admin', '2022-05-08 20:35:31', '', null, '');
INSERT INTO `sys_menu` VALUES ('2009', '主页详情修改', '2006', '3', '#', '', null, '1', '0', 'F', '0', '0', 'system:info:edit', '#', 'admin', '2022-05-08 20:35:32', '', null, '');
INSERT INTO `sys_menu` VALUES ('2010', '主页详情删除', '2006', '4', '#', '', null, '1', '0', 'F', '0', '0', 'system:info:remove', '#', 'admin', '2022-05-08 20:35:32', '', null, '');
INSERT INTO `sys_menu` VALUES ('2011', '主页详情导出', '2006', '5', '#', '', null, '1', '0', 'F', '0', '0', 'system:info:export', '#', 'admin', '2022-05-08 20:35:32', '', null, '');
INSERT INTO `sys_menu` VALUES ('2012', '模块一:轮播图', '0', '1', 'lbt', 'system/lbt/index', null, '1', '0', 'C', '0', '0', 'system:lbt:list', '#', 'admin', '2022-05-08 20:35:32', '', null, '轮播图菜单');
INSERT INTO `sys_menu` VALUES ('2013', '轮播图查询', '2012', '1', '#', '', null, '1', '0', 'F', '0', '0', 'system:lbt:query', '#', 'admin', '2022-05-08 20:35:32', '', null, '');
INSERT INTO `sys_menu` VALUES ('2014', '轮播图新增', '2012', '2', '#', '', null, '1', '0', 'F', '0', '0', 'system:lbt:add', '#', 'admin', '2022-05-08 20:35:32', '', null, '');
INSERT INTO `sys_menu` VALUES ('2015', '轮播图修改', '2012', '3', '#', '', null, '1', '0', 'F', '0', '0', 'system:lbt:edit', '#', 'admin', '2022-05-08 20:35:32', '', null, '');
INSERT INTO `sys_menu` VALUES ('2016', '轮播图删除', '2012', '4', '#', '', null, '1', '0', 'F', '0', '0', 'system:lbt:remove', '#', 'admin', '2022-05-08 20:35:32', '', null, '');
INSERT INTO `sys_menu` VALUES ('2017', '轮播图导出', '2012', '5', '#', '', null, '1', '0', 'F', '0', '0', 'system:lbt:export', '#', 'admin', '2022-05-08 20:35:32', '', null, '');
INSERT INTO `sys_menu` VALUES ('2018', '模块二:publication', '0', '1', 'publication', 'system/publication/index', null, '1', '0', 'C', '0', '0', 'system:publication:list', '#', 'admin', '2022-05-14 16:33:00', '', null, '出版物模块详情菜单');
INSERT INTO `sys_menu` VALUES ('2019', '出版物模块详情查询', '2018', '1', '#', '', null, '1', '0', 'F', '0', '0', 'system:publication:query', '#', 'admin', '2022-05-14 16:33:00', '', null, '');
INSERT INTO `sys_menu` VALUES ('2020', '出版物模块详情新增', '2018', '2', '#', '', null, '1', '0', 'F', '0', '0', 'system:publication:add', '#', 'admin', '2022-05-14 16:33:00', '', null, '');
INSERT INTO `sys_menu` VALUES ('2021', '出版物模块详情修改', '2018', '3', '#', '', null, '1', '0', 'F', '0', '0', 'system:publication:edit', '#', 'admin', '2022-05-14 16:33:00', '', null, '');
INSERT INTO `sys_menu` VALUES ('2022', '出版物模块详情删除', '2018', '4', '#', '', null, '1', '0', 'F', '0', '0', 'system:publication:remove', '#', 'admin', '2022-05-14 16:33:00', '', null, '');
INSERT INTO `sys_menu` VALUES ('2023', '出版物模块详情导出', '2018', '5', '#', '', null, '1', '0', 'F', '0', '0', 'system:publication:export', '#', 'admin', '2022-05-14 16:33:01', '', null, '');
INSERT INTO `sys_menu` VALUES ('2024', '模块三:课件', '0', '1', 'course', 'system/course/index', null, '1', '0', 'C', '0', '0', 'system:course:list', '#', 'admin', '2022-05-16 21:03:44', '', null, '课件菜单');
INSERT INTO `sys_menu` VALUES ('2025', '课件查询', '2024', '1', '#', '', null, '1', '0', 'F', '0', '0', 'system:course:query', '#', 'admin', '2022-05-16 21:03:44', '', null, '');
INSERT INTO `sys_menu` VALUES ('2026', '课件新增', '2024', '2', '#', '', null, '1', '0', 'F', '0', '0', 'system:course:add', '#', 'admin', '2022-05-16 21:03:44', '', null, '');
INSERT INTO `sys_menu` VALUES ('2027', '课件修改', '2024', '3', '#', '', null, '1', '0', 'F', '0', '0', 'system:course:edit', '#', 'admin', '2022-05-16 21:03:45', '', null, '');
INSERT INTO `sys_menu` VALUES ('2028', '课件删除', '2024', '4', '#', '', null, '1', '0', 'F', '0', '0', 'system:course:remove', '#', 'admin', '2022-05-16 21:03:45', '', null, '');
INSERT INTO `sys_menu` VALUES ('2029', '课件导出', '2024', '5', '#', '', null, '1', '0', 'F', '0', '0', 'system:course:export', '#', 'admin', '2022-05-16 21:03:45', '', null, '');
INSERT INTO `sys_menu` VALUES ('2030', '模块四:人员详情', '0', '1', 'personnel', 'system/personnel/index', null, '1', '0', 'C', '0', '0', 'system:personnel:list', '#', 'admin', '2022-05-25 21:44:13', '', null, '人员详情菜单');
INSERT INTO `sys_menu` VALUES ('2031', '人员详情查询', '2030', '1', '#', '', null, '1', '0', 'F', '0', '0', 'system:personnel:query', '#', 'admin', '2022-05-25 21:44:13', '', null, '');
INSERT INTO `sys_menu` VALUES ('2032', '人员详情新增', '2030', '2', '#', '', null, '1', '0', 'F', '0', '0', 'system:personnel:add', '#', 'admin', '2022-05-25 21:44:13', '', null, '');
INSERT INTO `sys_menu` VALUES ('2033', '人员详情修改', '2030', '3', '#', '', null, '1', '0', 'F', '0', '0', 'system:personnel:edit', '#', 'admin', '2022-05-25 21:44:13', '', null, '');
INSERT INTO `sys_menu` VALUES ('2034', '人员详情删除', '2030', '4', '#', '', null, '1', '0', 'F', '0', '0', 'system:personnel:remove', '#', 'admin', '2022-05-25 21:44:13', '', null, '');
INSERT INTO `sys_menu` VALUES ('2035', '人员详情导出', '2030', '5', '#', '', null, '1', '0', 'F', '0', '0', 'system:personnel:export', '#', 'admin', '2022-05-25 21:44:13', '', null, '');
INSERT INTO `sys_menu` VALUES ('2036', '模块五:链接', '0', '1', 'link', 'system/link/index', null, '1', '0', 'C', '0', '0', 'system:link:list', '#', 'admin', '2022-05-25 21:44:27', '', null, '链接菜单');
INSERT INTO `sys_menu` VALUES ('2037', '链接查询', '2036', '1', '#', '', null, '1', '0', 'F', '0', '0', 'system:link:query', '#', 'admin', '2022-05-25 21:44:27', '', null, '');
INSERT INTO `sys_menu` VALUES ('2038', '链接新增', '2036', '2', '#', '', null, '1', '0', 'F', '0', '0', 'system:link:add', '#', 'admin', '2022-05-25 21:44:27', '', null, '');
INSERT INTO `sys_menu` VALUES ('2039', '链接修改', '2036', '3', '#', '', null, '1', '0', 'F', '0', '0', 'system:link:edit', '#', 'admin', '2022-05-25 21:44:27', '', null, '');
INSERT INTO `sys_menu` VALUES ('2040', '链接删除', '2036', '4', '#', '', null, '1', '0', 'F', '0', '0', 'system:link:remove', '#', 'admin', '2022-05-25 21:44:27', '', null, '');
INSERT INTO `sys_menu` VALUES ('2041', '链接导出', '2036', '5', '#', '', null, '1', '0', 'F', '0', '0', 'system:link:export', '#', 'admin', '2022-05-25 21:44:27', '', null, '');
INSERT INTO `sys_menu` VALUES ('2042', '模块五:招聘', '0', '1', 'recruitment', 'system/recruitment/index', null, '1', '0', 'C', '0', '0', 'system:recruitment:list', '#', 'admin', '2022-05-25 21:44:38', '', null, '招聘菜单');
INSERT INTO `sys_menu` VALUES ('2043', '招聘查询', '2042', '1', '#', '', null, '1', '0', 'F', '0', '0', 'system:recruitment:query', '#', 'admin', '2022-05-25 21:44:38', '', null, '');
INSERT INTO `sys_menu` VALUES ('2044', '招聘新增', '2042', '2', '#', '', null, '1', '0', 'F', '0', '0', 'system:recruitment:add', '#', 'admin', '2022-05-25 21:44:38', '', null, '');
INSERT INTO `sys_menu` VALUES ('2045', '招聘修改', '2042', '3', '#', '', null, '1', '0', 'F', '0', '0', 'system:recruitment:edit', '#', 'admin', '2022-05-25 21:44:39', '', null, '');
INSERT INTO `sys_menu` VALUES ('2046', '招聘删除', '2042', '4', '#', '', null, '1', '0', 'F', '0', '0', 'system:recruitment:remove', '#', 'admin', '2022-05-25 21:44:39', '', null, '');
INSERT INTO `sys_menu` VALUES ('2047', '招聘导出', '2042', '5', '#', '', null, '1', '0', 'F', '0', '0', 'system:recruitment:export', '#', 'admin', '2022-05-25 21:44:39', '', null, '');
