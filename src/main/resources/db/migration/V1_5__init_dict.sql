INSERT INTO `crew`.`sy_dict`(`id`, `dict_name`, `dict_code`, `description`, `create_at`) VALUES (1277776635971960834, '司机职务', 'JOB_TITLE', '', '2020-06-30 09:31:04');

INSERT INTO `crew`.`sy_dict`(`id`, `dict_name`, `dict_code`, `description`, `create_at`) VALUES (1283366594724425729, '公告类型', 'ANNOUNCEMENT_TYPE', '', '2020-07-15 19:43:34');

INSERT INTO `crew`.`sy_dict_entry`(`id`, `dict_code`, `dict_entry_name`, `dict_entry_value`, `description`, `create_at`, `enable`, `seq`) VALUES (1277776767266258945, 'JOB_TITLE', '正司机', '1', '', '2020-06-30 09:31:35', 1, 0);
INSERT INTO `crew`.`sy_dict_entry`(`id`, `dict_code`, `dict_entry_name`, `dict_entry_value`, `description`, `create_at`, `enable`, `seq`) VALUES (1277776796689301506, 'JOB_TITLE', '副司机', '2', '', '2020-06-30 09:31:42', 1, 0);
INSERT INTO `crew`.`sy_dict_entry`(`id`, `dict_code`, `dict_entry_name`, `dict_entry_value`, `description`, `create_at`, `enable`, `seq`) VALUES (1277776820504559618, 'JOB_TITLE', '备班司机', '3', '', '2020-06-30 09:31:48', 1, 0);

INSERT INTO `crew`.`sy_dict_entry`(`id`, `dict_code`, `dict_entry_name`, `dict_entry_value`, `description`, `create_at`, `enable`, `seq`) VALUES (1283366727943909377, 'ANNOUNCEMENT_TYPE', '运行揭示', '1', '', '2020-07-15 19:44:06', 1, 0);
INSERT INTO `crew`.`sy_dict_entry`(`id`, `dict_code`, `dict_entry_name`, `dict_entry_value`, `description`, `create_at`, `enable`, `seq`) VALUES (1283366763700350978, 'ANNOUNCEMENT_TYPE', '部门公告', '2', '', '2020-07-15 19:44:14', 1, 0);
INSERT INTO `crew`.`sy_dict_entry`(`id`, `dict_code`, `dict_entry_name`, `dict_entry_value`, `description`, `create_at`, `enable`, `seq`) VALUES (1283366841936703490, 'ANNOUNCEMENT_TYPE', '行车规则', '3', '', '2020-07-15 19:44:33', 1, 0);