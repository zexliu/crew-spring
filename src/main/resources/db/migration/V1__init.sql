CREATE TABLE `sy_permission` (
`id` bigint(11) NOT NULL,
`permission_name` varchar(32) NULL COMMENT '权限名称',
`permission_code` varchar(32) NULL COMMENT '权限编码',
`permission_path` varchar(200) NULL COMMENT '权限路径',
`seq` int(11) NULL DEFAULT 0 COMMENT '排序',
`description` varchar(200) NULL COMMENT '描述',
`parent_id` bigint(11) NULL COMMENT '所属权限',
`method_type` tinyint(4) NULL COMMENT '方法类型',
`create_at` datetime NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
PRIMARY KEY (`id`) ,
UNIQUE INDEX `uk_permission_code` (`permission_code` ASC) USING BTREE
)
COMMENT = '权限表';
CREATE TABLE `sy_role_permission_rel` (
`id` bigint(11) NOT NULL,
`role_id` bigint(11) NOT NULL COMMENT '角色ID',
`permission_id` bigint(11) NOT NULL COMMENT '权限ID',
PRIMARY KEY (`id`) ,
UNIQUE INDEX `uk_role_id_permission_id` (`role_id` ASC, `permission_id` ASC) USING HASH
)
COMMENT = '角色权限关联关系';
CREATE TABLE `sy_role` (
`id` bigint(11) NOT NULL,
`role_name` varchar(32) NULL COMMENT '角色名称',
`role_code` varchar(32) NULL COMMENT '角色编码',
`description` varchar(200) NULL COMMENT '描述',
`seq` int(11) NULL DEFAULT 0 COMMENT '排序',
`create_at` datetime NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
PRIMARY KEY (`id`) ,
UNIQUE INDEX `uk_role_name` (`role_name` ASC) USING BTREE,
UNIQUE INDEX `uk_role_code` (`role_code` ASC) USING BTREE
)
COMMENT = '角色表';
CREATE TABLE `sy_role_menu_rel` (
`id` bigint(11) NOT NULL,
`role_id` bigint(11) NOT NULL COMMENT '角色ID',
`menu_id` bigint(11) NOT NULL COMMENT '菜单ID',
PRIMARY KEY (`id`) ,
UNIQUE INDEX `uk_role_id_menu_id` (`role_id` ASC, `menu_id` ASC) USING HASH
)
COMMENT = '角色菜单关联关系';
CREATE TABLE `sy_menu` (
`id` bigint(11) NOT NULL,
`menu_name` varchar(32) NULL COMMENT '菜单名称',
`menu_code` varchar(32) NULL COMMENT '菜单编码',
`menu_icon` varchar(128) NULL COMMENT '菜单图标',
`menu_path` varchar(200) NULL COMMENT '页面路径',
`parent_id` bigint(11) NULL COMMENT '所属菜单',
`description` varchar(200) NULL COMMENT '描述',
`redirect` varchar(200) NULL COMMENT '重定向',
`component` varchar(200) NULL COMMENT '组件',
`seq` int(11) NULL DEFAULT 0 COMMENT '排序',
`create_at` datetime NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
`hidden` tinyint(1) NULL DEFAULT 0 COMMENT '是否隐藏',
PRIMARY KEY (`id`) 
)
COMMENT = '菜单表';
CREATE TABLE `sy_user_role_rel` (
`id` bigint(11) NOT NULL,
`user_id` bigint(11) NOT NULL COMMENT '用户ID',
`role_id` bigint(11) NOT NULL COMMENT '角色ID',
PRIMARY KEY (`id`) ,
UNIQUE INDEX `uk_user_id_role_id` (`user_id` ASC, `role_id` ASC) USING HASH
)
COMMENT = '用户角色关系表';
CREATE TABLE `sy_user` (
`id` bigint(11) NOT NULL,
`username` varchar(32) NULL COMMENT '用户名',
`password` varchar(128) NULL COMMENT '密码',
`mobile` varchar(32) NULL COMMENT '手机号',
`email` varchar(128) NULL COMMENT '邮箱',
`nickname` varchar(32) NULL COMMENT '昵称',
`real_name` varchar(16) NULL COMMENT '真实姓名',
`avatar` varchar(255) NULL COMMENT '头像',
`work_no` varchar(32) NULL COMMENT '工号',
`gender` tinyint(4) NULL DEFAULT 0 COMMENT '性别',
`birth_day` date NULL COMMENT '生日',
`enable` tinyint(1) NULL DEFAULT 1 COMMENT '可用状态',
`locked` tinyint(1) NULL DEFAULT 0 COMMENT '删除状态',
`login_at` datetime NULL DEFAULT CURRENT_TIMESTAMP COMMENT '最后登录时间',
`login_ip` varchar(32) NULL COMMENT '最后登录IP',
`expire_at` datetime NULL COMMENT '过期时间',
`create_at` datetime NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
PRIMARY KEY (`id`) ,
UNIQUE INDEX `uk_username` (`username` ASC) USING BTREE,
UNIQUE INDEX `uk_mobile` (`mobile` ASC) USING BTREE,
UNIQUE INDEX `uk_email` (`email` ASC) USING BTREE
)
COMMENT = '用户表';
CREATE TABLE `sy_dept` (
`id` bigint(11) NOT NULL,
`dept_name` varchar(32) NULL COMMENT '部门名称',
`dept_code` varchar(32) NULL COMMENT '部门编码',
`parent_id` bigint(11) NULL COMMENT '所属部门',
`address` varchar(200) NULL COMMENT '部门地址',
`fax` varchar(32) NULL COMMENT '传真',
`phone` varchar(32) NULL COMMENT '电话',
`description` varchar(200) NULL COMMENT '描述',
`seq` int(11) NULL COMMENT '排序',
`create_at` datetime NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
PRIMARY KEY (`id`) 
)
COMMENT = '部门表';
CREATE TABLE `sy_user_dept_rel` (
`id` bigint(11) NOT NULL,
`user_id` bigint(11) NOT NULL COMMENT '用户ID',
`dept_id` bigint(11) NOT NULL COMMENT '部门ID',
PRIMARY KEY (`id`) ,
UNIQUE INDEX `uk_user_id_dept_id` (`user_id` ASC, `dept_id` ASC) USING HASH
)
COMMENT = '用户部门关系表';
CREATE TABLE `sy_dept_role_rel` (
`id` bigint(11) NOT NULL,
`dept_id` bigint(11) NOT NULL COMMENT '部门ID',
`role_id` bigint(11) NOT NULL COMMENT '角色ID',
PRIMARY KEY (`id`) ,
UNIQUE INDEX `uk_dept_id_role_id` (`dept_id` ASC, `role_id` ASC) USING HASH
)
COMMENT = '部门角色关系表';
CREATE TABLE `sy_dict` (
`id` bigint(11) NOT NULL,
`dict_name` varchar(32) NULL COMMENT '字典名称',
`dict_code` varchar(32) NULL COMMENT '字典编码',
`description` varchar(200) NULL COMMENT '描述',
`create_at` datetime NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
PRIMARY KEY (`id`) ,
UNIQUE INDEX `uk_dict_name` (`dict_name` ASC) USING BTREE,
UNIQUE INDEX `uk_dict_code` (`dict_code` ASC) USING BTREE
)
COMMENT = '数据字典';
CREATE TABLE `sy_dict_entry` (
`id` bigint(11) NOT NULL,
`dict_code` varchar(32) NULL COMMENT '字典编码',
`dict_entry_name` varchar(32) NULL COMMENT '字典项名称',
`dict_entry_value` varchar(32) NULL COMMENT '字典项值',
`description` varchar(200) NULL COMMENT '描述',
`create_at` datetime NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
`enable` tinyint(1) NULL DEFAULT 1 COMMENT '可用状态',
`seq` int(11) NULL DEFAULT 0 COMMENT '排序',
PRIMARY KEY (`id`) 
)
COMMENT = '字典项';
CREATE TABLE `qa_question_store` (
`id` bigint(11) NOT NULL,
`question_store_name` varchar(32) NULL COMMENT '题库名称',
`description` varchar(200) NULL COMMENT '描述',
`create_at` datetime NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
`del_flag` tinyint(1) NULL DEFAULT 0 COMMENT '删除标记',
PRIMARY KEY (`id`) ,
UNIQUE INDEX `uk_question_store_name` (`question_store_name` ASC) USING BTREE
)
COMMENT = '试题题库';
CREATE TABLE `qa_question` (
`id` bigint(11) NOT NULL,
`question_store_id` bigint(11) NULL COMMENT '题库编号',
`question_type` tinyint(4) NULL COMMENT '问题类型',
`question_content` text NULL COMMENT '问题内容',
`question_answer_items` varchar(255) NULL COMMENT '答案选项',
`question_answer` varchar(32) NULL COMMENT '正确答案',
`question_score` int(11) NULL COMMENT '分值',
`create_at` datetime NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
`del_flag` tinyint(1) NULL DEFAULT 0 COMMENT '删除标记',
PRIMARY KEY (`id`) 
)
COMMENT = '试题';
CREATE TABLE `qa_question_pager_template` (
`id` bigint(11) NOT NULL,
`pager_template_name` varchar(32) NULL COMMENT '模板名称',
`question_store_id` bigint(11) NULL COMMENT '题库编号',
`question_count` int(11) NULL COMMENT '题目数量',
`create_at` datetime NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
`enable` tinyint(1) NULL DEFAULT 1 COMMENT '启用状态',
`del_flag` tinyint(1) NULL DEFAULT 0 COMMENT '删除状态',
`description` varchar(200) NULL COMMENT '描述',
PRIMARY KEY (`id`) 
)
COMMENT = '试卷模板';
CREATE TABLE `qa_driver_question_pager` (
`id` bigint(11) NOT NULL,
`template_id` bigint(11) NULL COMMENT '模板ID',
`driver_id` bigint(11) NULL COMMENT '司机ID',
`question_store_id` bigint(11) NULL COMMENT '题库ID',
`total_score` int(11) NULL COMMENT '总分数',
`question_count` int(11) NULL COMMENT '答题数量',
`time_duration` int(11) NULL COMMENT '总用时',
`create_at` datetime NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
`submit_at` datetime NULL COMMENT '提交时间',
`driver_score` int(11) NULL DEFAULT 0 COMMENT '司机得分',
`status` tinyint(4) NULL DEFAULT 1 COMMENT '状态',
`effect` tinyint(1) NULL DEFAULT 0 COMMENT '是否有效',
PRIMARY KEY (`id`) 
)
COMMENT = '用户答题试卷';
CREATE TABLE `qa_driver_pager_answer` (
`id` bigint(11) NOT NULL,
`question_id` bigint(11) NULL COMMENT '问题ID',
`question_pager_id` bigint(11) NULL COMMENT '试卷ID',
`driver_id` bigint(11) NULL COMMENT '司机ID',
`answer` varchar(200) NULL COMMENT '答案',
`question_score` int(11) NULL COMMENT '问题分数',
`right` tinyint(1) NULL COMMENT '是否正确',
`create_at` datetime NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
PRIMARY KEY (`id`) 
)
COMMENT = '司机答题表';
CREATE TABLE `sb_station` (
`id` bigint(11) NOT NULL,
`station_name` varchar(32) NULL COMMENT '车站名称',
`station_code` varchar(32) NULL COMMENT '车站编码',
`next_station_distance` float(10,2) NULL COMMENT '下站距离',
`seq` int(11) NULL DEFAULT 0 COMMENT '排序',
`description` varchar(200) NULL COMMENT '描述',
`is_park` tinyint(1) NULL DEFAULT 0 COMMENT '是否停车场',
`is_return` tinyint(1) NULL DEFAULT 0 COMMENT '是否折返点',
PRIMARY KEY (`id`) ,
UNIQUE INDEX `uk_station_name` (`station_name` ASC) USING BTREE,
UNIQUE INDEX `uk_station_code` (`station_code` ASC) USING BTREE
)
COMMENT = '车站表';
CREATE TABLE `sb_runtime_table` (
`id` bigint(11) NOT NULL,
`table_name` varchar(32) NULL COMMENT '时刻表名称',
`description` varchar(200) NULL COMMENT '描述',
`create_at` datetime NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
PRIMARY KEY (`id`) ,
UNIQUE INDEX `uk_table_name` (`table_name` ASC) USING BTREE
)
COMMENT = '时刻表';
CREATE TABLE `sb_runtime_item` (
`id` bigint(11) NOT NULL,
`table_id` bigint(11) NULL COMMENT '所属时刻表',
`start_station_id` bigint(11) NULL COMMENT '始发站ID',
`end_station_id` bigint(11) NULL COMMENT '终点站ID',
`train_no` varchar(32) NULL COMMENT '车次',
`service_no` varchar(32) NULL COMMENT '服务号',
`description` varchar(200) NULL COMMENT '备注',
`start_at` time NULL COMMENT '开点',
`end_at` time NULL COMMENT '到点',
`distance` float(10,2) NULL COMMENT '总里程',
`create_at` datetime NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
`up` tinyint(1) NULL COMMENT '是否上行',
PRIMARY KEY (`id`) 
)
COMMENT = '时刻表数据项';
CREATE TABLE `sb_runtime_table_date` (
`id` bigint(11) NOT NULL,
`table_id` bigint(11) NULL COMMENT '时刻表ID',
`date` date NULL COMMENT '日期',
`create_at` datetime NULL DEFAULT CURRENT_TIMESTAMP,
PRIMARY KEY (`id`) 
)
COMMENT = '时刻表对应日期';
CREATE TABLE `sb_route_item` (
`id` bigint(11) NOT NULL,
`table_id` bigint(11) NULL COMMENT '交路表ID',
`shift_group_id` bigint(11) NULL COMMENT '班次组ID',
`shift_id` bigint(11) NULL COMMENT '班次ID',
`route_item_no` varchar(30) NULL COMMENT '交路号',
`attendance_station_id` bigint(11) NULL COMMENT '出勤站点点',
`attendance_at` time NULL COMMENT '出勤时间',
`meet_at` time NULL COMMENT '接车时间',
`meet_runtime_item_id` bigint(11) NULL COMMENT '接车车次',
`meet_station_id` bigint(11) NULL COMMENT '接车第点',
`back_runtime_item_id` bigint(11) NULL COMMENT '退勤车次',
`back_station_id` bigint(11) NULL COMMENT '退勤地点',
`back_at` time NULL COMMENT '退勤时间',
`distance` double(10,2) NULL COMMENT '总公里数',
`remark` varchar(200) NULL COMMENT '备注',
`description` varchar(200) NULL COMMENT '描述',
`create_at` datetime NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
PRIMARY KEY (`id`) 
)
COMMENT = '交路计划明细表';
CREATE TABLE `sb_route_table` (
`id` bigint(11) NOT NULL,
`table_name` varchar(30) NULL COMMENT '交路计划名称',
`runtime_table_id` bigint(11) NULL COMMENT '运行时刻表ID',
`create_at` datetime NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
`description` varchar(200) NULL COMMENT '描述',
`enable` tinyint(1) NULL COMMENT '启用状态',
PRIMARY KEY (`id`) ,
UNIQUE INDEX `uk_table_name` (`table_name` ASC) USING BTREE
)
COMMENT = '交路计划表';
CREATE TABLE `sb_route_runtime_rel` (
`id` bigint(11) NOT NULL,
`route_item_id` bigint(11) NULL,
`runtime_item_id` bigint(11) NULL,
PRIMARY KEY (`id`) ,
UNIQUE INDEX `uk_route_item_id_runtime_item_id` (`route_item_id` ASC, `runtime_item_id` ASC) USING HASH
)
COMMENT = '交路明细时刻明细关联关系';
CREATE TABLE `sb_shift_group` (
`id` bigint(11) NOT NULL,
`group_name` varchar(30) NULL COMMENT '班次组名称',
`seq` int(11) NULL DEFAULT 0 COMMENT '排序',
`create_at` datetime NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
`description` varchar(200) NULL COMMENT '描述',
PRIMARY KEY (`id`) 
)
COMMENT = '班次所属';
CREATE TABLE `sb_shift` (
`id` bigint(11) NOT NULL,
`shift_group_id` bigint(11) NULL COMMENT '班次组ID',
`shift_name` varchar(30) NULL COMMENT '班次名称',
`seq` int(11) NULL DEFAULT 0 COMMENT '排序',
`create_at` datetime NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
PRIMARY KEY (`id`) 
)
COMMENT = '班次';
CREATE TABLE `sb_staff_group` (
`id` bigint(11) NOT NULL,
`team_id` bigint(11) NULL COMMENT '机队ID',
`group_name` varchar(30) NULL COMMENT '机组名称',
`description` varchar(200) NULL COMMENT '描述',
`create_at` datetime NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
`rotate_count` int(11) NULL DEFAULT 0 COMMENT '轮换次数',
`rotate_status` tinyint(4) NULL COMMENT '轮换状态',
`group_phone` varchar(32) NULL COMMENT '机组电话',
PRIMARY KEY (`id`) ,
UNIQUE INDEX `uk_group_name` (`group_name` ASC) USING BTREE
)
COMMENT = '机队组';
CREATE TABLE `sb_staff_team` (
`id` bigint(11) NOT NULL,
`team_name` varchar(30) NULL COMMENT '机队名称',
`team_phone` varchar(30) NULL COMMENT '机队电话',
`rotate_count` int(11) NULL DEFAULT 0 COMMENT '轮换次数',
`rotate_status` tinyint(4) NULL COMMENT '轮换状态',
`group_type` tinyint(4) NULL COMMENT '机队类型',
`create_at` datetime NULL DEFAULT CURRENT_TIMESTAMP,
`description` varchar(200) NULL COMMENT '描述',
PRIMARY KEY (`id`) ,
UNIQUE INDEX `uk_team_name` (`team_name` ASC) USING BTREE
)
COMMENT = '机队';
CREATE TABLE `sb_staff` (
`id` bigint(11) NOT NULL,
`user_id` bigint(11) NULL,
`fingerprint` text NULL COMMENT '指纹',
`skills` varchar(30) NULL COMMENT '技能',
`safe_at` datetime NULL DEFAULT CURRENT_TIMESTAMP COMMENT '安全时间',
`create_at` datetime NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
`team_id` bigint(11) NULL COMMENT '队伍ID',
`group_id` bigint(11) NULL COMMENT '组ID',
`job_title` tinyint(4) NULL COMMENT '职务',
`is_team_leader` tinyint(1) NULL COMMENT '是否机队负责人',
`is_group_leader` tinyint(1) NULL COMMENT '是否机组负责人',
PRIMARY KEY (`id`) 
);
CREATE TABLE `sys_extension_field` (
`id` bigint(11) NOT NULL,
`table_name` varchar(128) NULL COMMENT '表名',
`field_name` varchar(32) NULL COMMENT '字段名称',
`field_code` varchar(32) NULL COMMENT '字段编码',
`field_type` tinyint(4) NULL COMMENT '字段类型',
`create_at` datetime NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
PRIMARY KEY (`id`) ,
UNIQUE INDEX `uk_field_code` (`field_code` ASC) USING BTREE
)
COMMENT = '拓展信息字段';
CREATE TABLE `sys_extension_info` (
`id` bigint(11) NOT NULL,
`field_code` varchar(32) NULL COMMENT '字段编码',
`instance_id` bigint(11) NULL COMMENT '实例ID',
`long_value` bigint(255) NULL COMMENT '整型',
`double_value` double(16,8) NULL COMMENT '浮点型',
`text_value` longtext NULL COMMENT '字符串',
PRIMARY KEY (`id`) 
)
COMMENT = '拓展信息值';
CREATE TABLE `sb_staff_team_scheduling` (
`id` bigint(11) NOT NULL,
`date` date NULL COMMENT '日期',
`shift_group_id` bigint(11) NULL COMMENT '班次组ID',
`staff_team_id` bigint(11) NULL COMMENT '机队ID',
PRIMARY KEY (`id`) 
)
COMMENT = '机队轮换信息';
CREATE TABLE `sb_staff_group_scheduling` (
`id` bigint(11) NOT NULL,
`date` date NULL COMMENT '日期',
`route_item_id` bigint(11) NULL COMMENT '交路项ID',
`staff_group_id` bigint(11) NULL COMMENT '机组ID',
PRIMARY KEY (`id`) 
)
COMMENT = '机组轮换信息';
CREATE TABLE `sb_staff_attendance` (
`id` bigint(11) NOT NULL,
`staff_id` bigint(11) NULL COMMENT '司机ID',
`route_item_id` bigint(11) NULL COMMENT '交路ID',
`route_item_no` varchar(30) NULL COMMENT '交路号',
`date` date NULL COMMENT '日期',
`attendance_at` time NULL COMMENT '出勤时间',
`back_at` time NULL COMMENT '退勤时间',
`real_attendance_at` time NULL COMMENT '实际出勤时间',
`real_back_at` time NULL COMMENT '实际退勤时间',
`answer_accuracy` decimal(10,2) NULL COMMENT '考试分数',
`alcohol_value` decimal(10,2) NULL COMMENT '测酒值',
`alcohol_result` tinyint(4) NULL COMMENT '测酒结果 0正常；1饮酒；2酗酒',
`attendance_device_id` varchar(30) NULL COMMENT '设备ID',
`back_device_id` varchar(30) NULL,
`attendance_status` tinyint(4) NULL DEFAULT 0,
`back_status` tinyint(4) NULL DEFAULT 0,
`staff_team_id` bigint(11) NULL COMMENT '机队',
`staff_group_id` bigint(11) NULL COMMENT '机组',
`distance` double(10,2) NULL COMMENT '行驶里程',
`duration` int(11) NULL COMMENT '有效工时',
PRIMARY KEY (`id`) 
)
COMMENT = '出勤记录';
CREATE TABLE `sn_notification_template` (
`id` bigint(11) NOT NULL,
`template_code` varchar(32) NULL COMMENT '模板编码',
`template_title` varchar(32) NULL COMMENT '模板标题',
`template_content` text NULL COMMENT '模板内容',
`channel_type` tinyint(4) NULL COMMENT '发布渠道',
`create_at` datetime NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
PRIMARY KEY (`id`) 
)
COMMENT = '公告模板';
CREATE TABLE `sn_notification` (
`id` bigint(11) NOT NULL,
`title` varchar(32) NULL COMMENT '标题',
`content` text NULL COMMENT '内容',
`params` varchar(200) NULL COMMENT '参数',
`channel_type` tinyint(4) NULL COMMENT '发布渠道',
`create_at` datetime NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
`publish_type` tinyint(1) NULL COMMENT '发布类型',
`read_status` tinyint(1) NULL DEFAULT 0 COMMENT '阅读状态',
PRIMARY KEY (`id`) 
);
CREATE TABLE `sn_notification_user_rel` (
`id` bigint(11) NOT NULL,
`user_id` bigint(11) NULL,
`notification_id` bigint(11) NULL,
PRIMARY KEY (`id`) 
);
CREATE TABLE `sn_announcement_template` (
`id` bigint(11) NOT NULL,
`template_code` varchar(32) NULL COMMENT '模板编码',
`template_title` varchar(32) NULL COMMENT '模板标题',
`template_content` varchar(255) NULL COMMENT '模板内容',
`create_at` datetime NULL DEFAULT CURRENT_TIMESTAMP,
`announcement_type` tinyint(4) NULL COMMENT '模板类型',
PRIMARY KEY (`id`) 
);
CREATE TABLE `sn_announcement` (
`id` bigint(11) NOT NULL,
`title` varchar(30) NULL COMMENT '标题',
`content` text NULL COMMENT '内容',
`valid_start_at` datetime NULL COMMENT '有效开始时间',
`valid_end_at` datetime NULL COMMENT '有效结束时间',
`create_at` datetime NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
`params` varchar(200) NULL COMMENT '参数',
`announcement_type` tinyint(4) NULL,
`valid_status` tinyint(1) NULL DEFAULT 1 COMMENT '有效状态',
PRIMARY KEY (`id`) 
);
CREATE TABLE `sb_safe_config` (
`id` bigint(11) NOT NULL,
`create_at` datetime NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
`safe1_at` date NULL COMMENT '重大安全事故',
`safe2_at` date NULL COMMENT '大安全事故',
`safe3_at` date NULL COMMENT '较大安全事故',
`safe4_at` date NULL COMMENT '一般安全事故',
`safe5_at` date NULL COMMENT '老动人身安全事故',
`type` tinyint(4) NULL COMMENT '操作类型',
`description` varchar(200) NULL COMMENT '备注',
`operator_id` bigint(11) NULL COMMENT '操作人ID',
PRIMARY KEY (`id`) 
);
CREATE TABLE `sb_staff_leave` (
`id` bigint(11) NOT NULL,
`type` tinyint(4) NULL COMMENT '请假类型',
`user_id` bigint(11) NULL COMMENT '人员ID',
`create_at` datetime NULL COMMENT '创建时间',
`status` tinyint(4) NULL COMMENT '审批状态',
`description` varchar(200) NULL COMMENT '备注',
`leave_at` date NULL COMMENT '离队日期',
`back_at` date NULL COMMENT '归队日期',
`days` int(11) NULL COMMENT '天数',
PRIMARY KEY (`id`) 
)
COMMENT = '请假表';
CREATE TABLE `sb_staff_leave_log` (
`id` bigint(11) NOT NULL,
`leave_id` bigint(11) NULL COMMENT '请假ID',
`operator_id` bigint(11) NULL COMMENT '操作人ID',
`create_at` datetime NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
`description` varchar(200) NULL COMMENT '备注',
`type` tinyint(4) NULL COMMENT '记录类型',
PRIMARY KEY (`id`) 
)
COMMENT = '请假审核记录';

ALTER TABLE `sy_permission` ADD CONSTRAINT `fk_sy_permission_sy_permission_1` FOREIGN KEY (`parent_id`) REFERENCES `sy_permission` (`id`);
ALTER TABLE `sy_role_permission_rel` ADD CONSTRAINT `fk_sy_role_permission_rel_sy_permission_1` FOREIGN KEY (`permission_id`) REFERENCES `sy_permission` (`id`);
ALTER TABLE `sy_role_permission_rel` ADD CONSTRAINT `fk_sy_role_permission_rel_sy_role_1` FOREIGN KEY (`role_id`) REFERENCES `sy_role` (`id`);
ALTER TABLE `sy_user_role_rel` ADD CONSTRAINT `fk_sy_user_role_rel_sy_user_1` FOREIGN KEY (`user_id`) REFERENCES `sy_user` (`id`);
ALTER TABLE `sy_user_role_rel` ADD CONSTRAINT `fk_sy_user_role_rel_sy_role_1` FOREIGN KEY (`role_id`) REFERENCES `sy_role` (`id`);
ALTER TABLE `sy_role_menu_rel` ADD CONSTRAINT `fk_sy_role_menu_rel_sy_role_1` FOREIGN KEY (`role_id`) REFERENCES `sy_role` (`id`);
ALTER TABLE `sy_role_menu_rel` ADD CONSTRAINT `fk_sy_role_menu_rel_sy_menu_1` FOREIGN KEY (`menu_id`) REFERENCES `sy_menu` (`id`);
ALTER TABLE `sy_menu` ADD CONSTRAINT `fk_sy_menu_sy_menu_1` FOREIGN KEY (`parent_id`) REFERENCES `sy_menu` (`id`);
ALTER TABLE `sy_user_dept_rel` ADD CONSTRAINT `fk_sy_user_dept_rel_sy_user_1` FOREIGN KEY (`user_id`) REFERENCES `sy_user` (`id`);
ALTER TABLE `sy_user_dept_rel` ADD CONSTRAINT `fk_sy_user_dept_rel_sy_dept_1` FOREIGN KEY (`dept_id`) REFERENCES `sy_dept` (`id`);
ALTER TABLE `sy_dept_role_rel` ADD CONSTRAINT `fk_sy_dept_role_rel_sy_dept_1` FOREIGN KEY (`dept_id`) REFERENCES `sy_dept` (`id`);
ALTER TABLE `sy_dept_role_rel` ADD CONSTRAINT `fk_sy_dept_role_rel_sy_role_1` FOREIGN KEY (`role_id`) REFERENCES `sy_role` (`id`);
ALTER TABLE `sy_dept` ADD CONSTRAINT `fk_sy_dept_sy_dept_1` FOREIGN KEY (`parent_id`) REFERENCES `sy_dept` (`id`);
ALTER TABLE `sy_dict_entry` ADD CONSTRAINT `fk_sy_dict_entry_sy_dict_1` FOREIGN KEY (`dict_code`) REFERENCES `sy_dict` (`dict_code`);
ALTER TABLE `qa_question` ADD CONSTRAINT `fk_qa_question_qa_question_store_1` FOREIGN KEY (`question_store_id`) REFERENCES `qa_question_store` (`id`);
ALTER TABLE `qa_question_pager_template` ADD CONSTRAINT `fk_qa_question_pager_template_qa_question_store_1` FOREIGN KEY (`question_store_id`) REFERENCES `qa_question_store` (`id`);
ALTER TABLE `qa_driver_question_pager` ADD CONSTRAINT `fk_qa_driver_question_pager_qa_question_store_1` FOREIGN KEY (`question_store_id`) REFERENCES `qa_question_store` (`id`);
ALTER TABLE `qa_driver_pager_answer` ADD CONSTRAINT `fk_qa_driver_pager_answer_qa_question_1` FOREIGN KEY (`question_id`) REFERENCES `qa_question` (`id`);
ALTER TABLE `qa_driver_pager_answer` ADD CONSTRAINT `fk_qa_driver_pager_answer_qa_driver_question_pager_1` FOREIGN KEY (`question_pager_id`) REFERENCES `qa_driver_question_pager` (`id`);
ALTER TABLE `qa_driver_question_pager` ADD CONSTRAINT `fk_qa_driver_question_pager_qa_question_pager_template_1` FOREIGN KEY (`template_id`) REFERENCES `qa_question_pager_template` (`id`);
ALTER TABLE `sb_runtime_item` ADD CONSTRAINT `fk_sb_runtime_item_sb_runtime_table_1` FOREIGN KEY (`table_id`) REFERENCES `sb_runtime_table` (`id`);
ALTER TABLE `sb_runtime_item` ADD CONSTRAINT `fk_sb_runtime_item_sb_station_1` FOREIGN KEY (`start_station_id`) REFERENCES `sb_station` (`id`);
ALTER TABLE `sb_runtime_item` ADD CONSTRAINT `fk_sb_runtime_item_sb_station_2` FOREIGN KEY (`end_station_id`) REFERENCES `sb_station` (`id`);
ALTER TABLE `sb_runtime_table_date` ADD CONSTRAINT `fk_sb_runtime_table_date_sb_runtime_table_1` FOREIGN KEY (`table_id`) REFERENCES `sb_runtime_table` (`id`);
ALTER TABLE `sb_route_runtime_rel` ADD CONSTRAINT `fk_sb_route_runtime_relation_sb_route_item_1` FOREIGN KEY (`route_item_id`) REFERENCES `sb_route_item` (`id`);
ALTER TABLE `sb_route_table` ADD CONSTRAINT `fk_sb_route_table_sb_runtime_table_1` FOREIGN KEY (`runtime_table_id`) REFERENCES `sb_runtime_table` (`id`);
ALTER TABLE `sb_shift` ADD CONSTRAINT `fk_sb_shift_sb_shift_group_1` FOREIGN KEY (`shift_group_id`) REFERENCES `sb_shift_group` (`id`);
ALTER TABLE `sb_route_item` ADD CONSTRAINT `fk_sb_route_item_sb_shift_1` FOREIGN KEY (`shift_id`) REFERENCES `sb_shift` (`id`);
ALTER TABLE `sb_route_item` ADD CONSTRAINT `fk_sb_route_item_sb_route_table_1` FOREIGN KEY (`table_id`) REFERENCES `sb_route_table` (`id`);
ALTER TABLE `sb_route_item` ADD CONSTRAINT `fk_sb_route_item_sb_station_1` FOREIGN KEY (`meet_station_id`) REFERENCES `sb_station` (`id`);
ALTER TABLE `sb_route_item` ADD CONSTRAINT `fk_sb_route_item_sb_station_2` FOREIGN KEY (`back_station_id`) REFERENCES `sb_station` (`id`);
ALTER TABLE `sb_staff_group` ADD CONSTRAINT `fk_sb_staff_group_sb_staff_team_1` FOREIGN KEY (`team_id`) REFERENCES `sb_staff_team` (`id`);
ALTER TABLE `sb_staff` ADD CONSTRAINT `fk_sb_staff_sb_staff_group_1` FOREIGN KEY (`group_id`) REFERENCES `sb_staff_group` (`id`);
ALTER TABLE `sb_route_item` ADD CONSTRAINT `fk_sb_route_item_sb_shift_group_1` FOREIGN KEY (`shift_group_id`) REFERENCES `sb_shift_group` (`id`);
ALTER TABLE `sb_route_runtime_rel` ADD CONSTRAINT `fk_sb_route_runtime_relation_sb_runtime_item_1` FOREIGN KEY (`runtime_item_id`) REFERENCES `sb_runtime_item` (`id`);
ALTER TABLE `sn_notification_user_rel` ADD CONSTRAINT `fk_sn_notificatoin_user_rel_sn_notification_1` FOREIGN KEY (`notification_id`) REFERENCES `sn_notification` (`id`);
ALTER TABLE `sb_staff_leave_log` ADD CONSTRAINT `fk_sb_staff_leave_log_sb_staff_leave_1` FOREIGN KEY (`leave_id`) REFERENCES `sb_staff_leave` (`id`);

