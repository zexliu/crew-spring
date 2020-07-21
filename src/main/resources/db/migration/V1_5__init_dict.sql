INSERT INTO `crew`.`sy_dict`(`id`, `dict_name`, `dict_code`, `description`, `create_at`) VALUES (1277776635971960834, '司机职务', 'JOB_TITLE', '', '2020-06-30 09:31:04');
INSERT INTO `crew`.`sy_dict`(`id`, `dict_name`, `dict_code`, `description`, `create_at`) VALUES (1283366594724425729, '公告类型', 'ANNOUNCEMENT_TYPE', '', '2020-07-15 19:43:34');
INSERT INTO `crew`.`sy_dict`(`id`, `dict_name`, `dict_code`, `description`, `create_at`) VALUES (1285518281966772226, '事务类型', 'TRANSACTION_TYPE', '', '2020-07-21 18:13:36');



INSERT INTO `crew`.`sy_dict_entry`(`id`, `dict_code`, `dict_entry_name`, `dict_entry_value`, `description`, `create_at`, `enable`, `seq`) VALUES (1277776767266258945, 'JOB_TITLE', '正司机', '1', '', '2020-06-30 09:31:35', 1, 0);
INSERT INTO `crew`.`sy_dict_entry`(`id`, `dict_code`, `dict_entry_name`, `dict_entry_value`, `description`, `create_at`, `enable`, `seq`) VALUES (1277776796689301506, 'JOB_TITLE', '副司机', '2', '', '2020-06-30 09:31:42', 1, 0);
INSERT INTO `crew`.`sy_dict_entry`(`id`, `dict_code`, `dict_entry_name`, `dict_entry_value`, `description`, `create_at`, `enable`, `seq`) VALUES (1277776820504559618, 'JOB_TITLE', '备班司机', '3', '', '2020-06-30 09:31:48', 1, 0);
INSERT INTO `crew`.`sy_dict_entry`(`id`, `dict_code`, `dict_entry_name`, `dict_entry_value`, `description`, `create_at`, `enable`, `seq`) VALUES (1283366727943909377, 'ANNOUNCEMENT_TYPE', '运行揭示', '1', '', '2020-07-15 19:44:06', 1, 0);
INSERT INTO `crew`.`sy_dict_entry`(`id`, `dict_code`, `dict_entry_name`, `dict_entry_value`, `description`, `create_at`, `enable`, `seq`) VALUES (1283366763700350978, 'ANNOUNCEMENT_TYPE', '部门公告', '2', '', '2020-07-15 19:44:14', 1, 0);
INSERT INTO `crew`.`sy_dict_entry`(`id`, `dict_code`, `dict_entry_name`, `dict_entry_value`, `description`, `create_at`, `enable`, `seq`) VALUES (1283366841936703490, 'ANNOUNCEMENT_TYPE', '行车规则', '3', '', '2020-07-15 19:44:33', 1, 0);
INSERT INTO `crew`.`sy_dict_entry`(`id`, `dict_code`, `dict_entry_name`, `dict_entry_value`, `description`, `create_at`, `enable`, `seq`) VALUES (1285518862429085697, 'TRANSACTION_TYPE', '事假', '1', '', '2020-07-21 18:15:55', 1, 9999);
INSERT INTO `crew`.`sy_dict_entry`(`id`, `dict_code`, `dict_entry_name`, `dict_entry_value`, `description`, `create_at`, `enable`, `seq`) VALUES (1285518907958255617, 'TRANSACTION_TYPE', '病假', '2', '', '2020-07-21 18:16:06', 1, 8888);
INSERT INTO `crew`.`sy_dict_entry`(`id`, `dict_code`, `dict_entry_name`, `dict_entry_value`, `description`, `create_at`, `enable`, `seq`) VALUES (1285519347714252801, 'TRANSACTION_TYPE', '婚假', '3', '', '2020-07-21 18:17:50', 1, 0);
INSERT INTO `crew`.`sy_dict_entry`(`id`, `dict_code`, `dict_entry_name`, `dict_entry_value`, `description`, `create_at`, `enable`, `seq`) VALUES (1285519404278636545, 'TRANSACTION_TYPE', '产假', '4', '', '2020-07-21 18:18:04', 1, 0);
INSERT INTO `crew`.`sy_dict_entry`(`id`, `dict_code`, `dict_entry_name`, `dict_entry_value`, `description`, `create_at`, `enable`, `seq`) VALUES (1285519552505339906, 'TRANSACTION_TYPE', '会议', '5', '', '2020-07-21 18:18:39', 1, 0);
INSERT INTO `crew`.`sy_dict_entry`(`id`, `dict_code`, `dict_entry_name`, `dict_entry_value`, `description`, `create_at`, `enable`, `seq`) VALUES (1285519823335743489, 'TRANSACTION_TYPE', '培训', '6', '', '2020-07-21 18:19:44', 1, 0);
INSERT INTO `crew`.`sy_dict_entry`(`id`, `dict_code`, `dict_entry_name`, `dict_entry_value`, `description`, `create_at`, `enable`, `seq`) VALUES (1285519874262982657, 'TRANSACTION_TYPE', '其他', '0', '', '2020-07-21 18:19:56', 1, 0);