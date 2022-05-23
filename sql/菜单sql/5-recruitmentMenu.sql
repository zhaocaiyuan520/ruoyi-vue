-- 菜单 SQL
insert into sys_menu (menu_name, parent_id, order_num, path, component, is_frame, is_cache, menu_type, visible, status, perms, icon, create_by, create_time, update_by, update_time, remark)
values('招聘', '3', '1', 'recruitment', 'system/recruitment/index', 1, 0, 'C', '0', '0', 'system:recruitment:list', '#', 'admin', sysdate(), '', null, '招聘菜单');

-- 按钮父菜单ID
SELECT @parentId := LAST_INSERT_ID();

-- 按钮 SQL
insert into sys_menu (menu_name, parent_id, order_num, path, component, is_frame, is_cache, menu_type, visible, status, perms, icon, create_by, create_time, update_by, update_time, remark)
values('招聘查询', @parentId, '1',  '#', '', 1, 0, 'F', '0', '0', 'system:recruitment:query',        '#', 'admin', sysdate(), '', null, '');

insert into sys_menu (menu_name, parent_id, order_num, path, component, is_frame, is_cache, menu_type, visible, status, perms, icon, create_by, create_time, update_by, update_time, remark)
values('招聘新增', @parentId, '2',  '#', '', 1, 0, 'F', '0', '0', 'system:recruitment:add',          '#', 'admin', sysdate(), '', null, '');

insert into sys_menu (menu_name, parent_id, order_num, path, component, is_frame, is_cache, menu_type, visible, status, perms, icon, create_by, create_time, update_by, update_time, remark)
values('招聘修改', @parentId, '3',  '#', '', 1, 0, 'F', '0', '0', 'system:recruitment:edit',         '#', 'admin', sysdate(), '', null, '');

insert into sys_menu (menu_name, parent_id, order_num, path, component, is_frame, is_cache, menu_type, visible, status, perms, icon, create_by, create_time, update_by, update_time, remark)
values('招聘删除', @parentId, '4',  '#', '', 1, 0, 'F', '0', '0', 'system:recruitment:remove',       '#', 'admin', sysdate(), '', null, '');

insert into sys_menu (menu_name, parent_id, order_num, path, component, is_frame, is_cache, menu_type, visible, status, perms, icon, create_by, create_time, update_by, update_time, remark)
values('招聘导出', @parentId, '5',  '#', '', 1, 0, 'F', '0', '0', 'system:recruitment:export',       '#', 'admin', sysdate(), '', null, '');