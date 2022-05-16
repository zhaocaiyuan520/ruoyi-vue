-- 菜单 SQL
insert into sys_menu (menu_name, parent_id, order_num, path, component, is_frame, is_cache, menu_type, visible, status, perms, icon, create_by, create_time, update_by, update_time, remark)
values('课件', '3', '1', 'course', 'system/course/index', 1, 0, 'C', '0', '0', 'system:course:list', '#', 'admin', sysdate(), '', null, '课件菜单');

-- 按钮父菜单ID
SELECT @parentId := LAST_INSERT_ID();

-- 按钮 SQL
insert into sys_menu (menu_name, parent_id, order_num, path, component, is_frame, is_cache, menu_type, visible, status, perms, icon, create_by, create_time, update_by, update_time, remark)
values('课件查询', @parentId, '1',  '#', '', 1, 0, 'F', '0', '0', 'system:course:query',        '#', 'admin', sysdate(), '', null, '');

insert into sys_menu (menu_name, parent_id, order_num, path, component, is_frame, is_cache, menu_type, visible, status, perms, icon, create_by, create_time, update_by, update_time, remark)
values('课件新增', @parentId, '2',  '#', '', 1, 0, 'F', '0', '0', 'system:course:add',          '#', 'admin', sysdate(), '', null, '');

insert into sys_menu (menu_name, parent_id, order_num, path, component, is_frame, is_cache, menu_type, visible, status, perms, icon, create_by, create_time, update_by, update_time, remark)
values('课件修改', @parentId, '3',  '#', '', 1, 0, 'F', '0', '0', 'system:course:edit',         '#', 'admin', sysdate(), '', null, '');

insert into sys_menu (menu_name, parent_id, order_num, path, component, is_frame, is_cache, menu_type, visible, status, perms, icon, create_by, create_time, update_by, update_time, remark)
values('课件删除', @parentId, '4',  '#', '', 1, 0, 'F', '0', '0', 'system:course:remove',       '#', 'admin', sysdate(), '', null, '');

insert into sys_menu (menu_name, parent_id, order_num, path, component, is_frame, is_cache, menu_type, visible, status, perms, icon, create_by, create_time, update_by, update_time, remark)
values('课件导出', @parentId, '5',  '#', '', 1, 0, 'F', '0', '0', 'system:course:export',       '#', 'admin', sysdate(), '', null, '');