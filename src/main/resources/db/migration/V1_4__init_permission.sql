INSERT INTO `crew`.`sy_menu`(`id`, `menu_name`, `menu_code`, `menu_icon`, `menu_path`, `parent_id`, `description`, `redirect`, `component`, `seq`, `create_at`, `hidden`) VALUES (1267613035315785729, '仪表盘', 'dashboard', 'bxAnaalyse', '/dashboard', NULL, '', '/dashboard/workspace', 'RouteView', 9999, '2020-06-02 08:24:33', 0);
INSERT INTO `crew`.`sy_menu`(`id`, `menu_name`, `menu_code`, `menu_icon`, `menu_path`, `parent_id`, `description`, `redirect`, `component`, `seq`, `create_at`, `hidden`) VALUES (1267615579739959298, '工作台', 'WorkSpace', '', '/dashboard/workspace', 1267613035315785729, '', '', 'workSpace', 9999, '2020-06-02 08:34:40', 0);
INSERT INTO `crew`.`sy_menu`(`id`, `menu_name`, `menu_code`, `menu_icon`, `menu_path`, `parent_id`, `description`, `redirect`, `component`, `seq`, `create_at`, `hidden`) VALUES (1267615997123538945, '系统管理', 'System', 'setting', '/system', NULL, '', '', 'PageView', 1, '2020-06-02 08:36:19', 0);
INSERT INTO `crew`.`sy_menu`(`id`, `menu_name`, `menu_code`, `menu_icon`, `menu_path`, `parent_id`, `description`, `redirect`, `component`, `seq`, `create_at`, `hidden`) VALUES (1267616400892407810, '用户管理', 'UserManage', '', '/system/user', 1267615997123538945, '', '', 'systemUser', 9999, '2020-06-02 08:37:55', 0);
INSERT INTO `crew`.`sy_menu`(`id`, `menu_name`, `menu_code`, `menu_icon`, `menu_path`, `parent_id`, `description`, `redirect`, `component`, `seq`, `create_at`, `hidden`) VALUES (1267616680786702337, '角色管理', 'RoleManage', '', '/system/role', 1267615997123538945, '', '', 'systemRole', 7777, '2020-06-02 08:39:02', 0);
INSERT INTO `crew`.`sy_menu`(`id`, `menu_name`, `menu_code`, `menu_icon`, `menu_path`, `parent_id`, `description`, `redirect`, `component`, `seq`, `create_at`, `hidden`) VALUES (1267616921988542465, '部门管理', 'DeptManage', '', '/system/dept', 1267615997123538945, '', '', 'systemDept', 8888, '2020-06-02 08:40:00', 0);
INSERT INTO `crew`.`sy_menu`(`id`, `menu_name`, `menu_code`, `menu_icon`, `menu_path`, `parent_id`, `description`, `redirect`, `component`, `seq`, `create_at`, `hidden`) VALUES (1267617169876103170, '权限管理', 'PermissionManage', '', '/system/permission', 1267615997123538945, '', '', 'systemPermission', 6666, '2020-06-02 08:40:59', 0);
INSERT INTO `crew`.`sy_menu`(`id`, `menu_name`, `menu_code`, `menu_icon`, `menu_path`, `parent_id`, `description`, `redirect`, `component`, `seq`, `create_at`, `hidden`) VALUES (1267617373954158593, '菜单管理', 'MenuManage', '', '/system/menu', 1267615997123538945, '', '', 'systemMenu', 5555, '2020-06-02 08:41:47', 0);
INSERT INTO `crew`.`sy_menu`(`id`, `menu_name`, `menu_code`, `menu_icon`, `menu_path`, `parent_id`, `description`, `redirect`, `component`, `seq`, `create_at`, `hidden`) VALUES (1267751023211372546, '异常页', 'Exception', 'warning', '/exception', NULL, '', '/exception/403', 'RouteView', 0, '2020-06-02 17:32:52', 0);
INSERT INTO `crew`.`sy_menu`(`id`, `menu_name`, `menu_code`, `menu_icon`, `menu_path`, `parent_id`, `description`, `redirect`, `component`, `seq`, `create_at`, `hidden`) VALUES (1267751338962771969, '403', '403', '', '/exception/403', 1267751023211372546, '', '', 'exception403', 3, '2020-06-02 17:34:07', 0);
INSERT INTO `crew`.`sy_menu`(`id`, `menu_name`, `menu_code`, `menu_icon`, `menu_path`, `parent_id`, `description`, `redirect`, `component`, `seq`, `create_at`, `hidden`) VALUES (1267751475692888066, '404', '404', '', '/exception/404', 1267751023211372546, '', '', 'exception404', 2, '2020-06-02 17:34:40', 0);
INSERT INTO `crew`.`sy_menu`(`id`, `menu_name`, `menu_code`, `menu_icon`, `menu_path`, `parent_id`, `description`, `redirect`, `component`, `seq`, `create_at`, `hidden`) VALUES (1267751581037027329, '500', '500', '', '/exception/500', 1267751023211372546, '', '', 'exception500', 1, '2020-06-02 17:35:05', 0);
INSERT INTO `crew`.`sy_menu`(`id`, `menu_name`, `menu_code`, `menu_icon`, `menu_path`, `parent_id`, `description`, `redirect`, `component`, `seq`, `create_at`, `hidden`) VALUES (1267752705852891138, '字典管理', 'Dict', '', '/system/dict', 1267615997123538945, '', '', 'systemDict', 4444, '2020-06-02 17:39:33', 0);
INSERT INTO `crew`.`sy_menu`(`id`, `menu_name`, `menu_code`, `menu_icon`, `menu_path`, `parent_id`, `description`, `redirect`, `component`, `seq`, `create_at`, `hidden`) VALUES (1268718547927207938, '考试管理', 'Exam', 'question-circle', '/exam', NULL, '', '/exam/question/store', 'PageView', 1111, '2020-06-05 09:37:28', 0);
INSERT INTO `crew`.`sy_menu`(`id`, `menu_name`, `menu_code`, `menu_icon`, `menu_path`, `parent_id`, `description`, `redirect`, `component`, `seq`, `create_at`, `hidden`) VALUES (1268718911724359682, '题库管理', 'QuestionStore', '', '/exam/store', 1268718547927207938, '', '', 'questionStore', 9999, '2020-06-05 09:38:54', 0);
INSERT INTO `crew`.`sy_menu`(`id`, `menu_name`, `menu_code`, `menu_icon`, `menu_path`, `parent_id`, `description`, `redirect`, `component`, `seq`, `create_at`, `hidden`) VALUES (1268719318722842626, '问题管理', 'Question', '', '/exam/question', 1268718547927207938, '', '', 'question', 8888, '2020-06-05 09:40:31', 0);
INSERT INTO `crew`.`sy_menu`(`id`, `menu_name`, `menu_code`, `menu_icon`, `menu_path`, `parent_id`, `description`, `redirect`, `component`, `seq`, `create_at`, `hidden`) VALUES (1268796209190313985, '试卷模板', 'PagerTemplate', '', '/exam/template', 1268718547927207938, '', '', 'pagerTemplate', 7777, '2020-06-05 14:46:04', 0);
INSERT INTO `crew`.`sy_menu`(`id`, `menu_name`, `menu_code`, `menu_icon`, `menu_path`, `parent_id`, `description`, `redirect`, `component`, `seq`, `create_at`, `hidden`) VALUES (1268831899617767425, '答题记录', 'PagerAnswer', '', '/exam/answer', 1268718547927207938, '', '', 'pagerAnswer', 5555, '2020-06-05 17:07:53', 0);
INSERT INTO `crew`.`sy_menu`(`id`, `menu_name`, `menu_code`, `menu_icon`, `menu_path`, `parent_id`, `description`, `redirect`, `component`, `seq`, `create_at`, `hidden`) VALUES (1268835985939410946, '考试记录', 'Pager', '', '/exam/pager', 1268718547927207938, '', '', 'pager', 6666, '2020-06-05 17:24:07', 0);
INSERT INTO `crew`.`sy_menu`(`id`, `menu_name`, `menu_code`, `menu_icon`, `menu_path`, `parent_id`, `description`, `redirect`, `component`, `seq`, `create_at`, `hidden`) VALUES (1271252850498273281, '排班管理', 'Arrange', 'build', '/arrange', NULL, '', '/arrange/runtime/table', 'PageView', 6666, '2020-06-12 09:27:52', 0);
INSERT INTO `crew`.`sy_menu`(`id`, `menu_name`, `menu_code`, `menu_icon`, `menu_path`, `parent_id`, `description`, `redirect`, `component`, `seq`, `create_at`, `hidden`) VALUES (1280775502053134338, '时刻表管理', 'Runtime', 'table', '/runtime', NULL, '', '/runtime/table', 'PageView', 8888, '2020-07-08 16:07:30', 0);
INSERT INTO `crew`.`sy_menu`(`id`, `menu_name`, `menu_code`, `menu_icon`, `menu_path`, `parent_id`, `description`, `redirect`, `component`, `seq`, `create_at`, `hidden`) VALUES (1280777845104594945, '交路管理', 'Route', 'retweet', '/route', NULL, '', '/route/table', 'PageView', 7777, '2020-07-08 16:16:48', 0);
INSERT INTO `crew`.`sy_menu`(`id`, `menu_name`, `menu_code`, `menu_icon`, `menu_path`, `parent_id`, `description`, `redirect`, `component`, `seq`, `create_at`, `hidden`) VALUES (1281147833950867457, '排班表', 'ArrangeTable', '', '/arrange/table', 1271252850498273281, '', '/table', 'arrangeTable', 9999, '2020-07-09 16:47:00', 0);

INSERT INTO `crew`.`sy_menu`(`id`, `menu_name`, `menu_code`, `menu_icon`, `menu_path`, `parent_id`, `description`, `redirect`, `component`, `seq`, `create_at`, `hidden`) VALUES (1271253153457045506, '车站管理', 'Station', '', '/station', 1280775502053134338, '', '', 'station', 0, '2020-06-12 09:29:05', 0);
INSERT INTO `crew`.`sy_menu`(`id`, `menu_name`, `menu_code`, `menu_icon`, `menu_path`, `parent_id`, `description`, `redirect`, `component`, `seq`, `create_at`, `hidden`) VALUES (1272452171184902145, '时刻表', 'RuntimeTable', '', '/runtime/table', 1280775502053134338, '', '', 'runtimeTable', 9999, '2020-06-15 16:53:33', 0);
INSERT INTO `crew`.`sy_menu`(`id`, `menu_name`, `menu_code`, `menu_icon`, `menu_path`, `parent_id`, `description`, `redirect`, `component`, `seq`, `create_at`, `hidden`) VALUES (1272452475225804801, '时刻表明细', 'RuntimeItem', '', '/runtime/item', 1280775502053134338, '', '', 'runtimeItem', 8888, '2020-06-15 16:54:45', 0);
INSERT INTO `crew`.`sy_menu`(`id`, `menu_name`, `menu_code`, `menu_icon`, `menu_path`, `parent_id`, `description`, `redirect`, `component`, `seq`, `create_at`, `hidden`) VALUES (1273083455372410881, '时刻表日历', 'RuntimeDate', '', '/runtime/date', 1280775502053134338, '', '', 'runtimeDate', 8887, '2020-06-17 10:42:03', 0);
INSERT INTO `crew`.`sy_menu`(`id`, `menu_name`, `menu_code`, `menu_icon`, `menu_path`, `parent_id`, `description`, `redirect`, `component`, `seq`, `create_at`, `hidden`) VALUES (1275069983549870082, '交路计划', 'RouteTable', '', '/route/table', 1280777845104594945, '', '', 'routeTable', 9999, '2020-06-22 22:15:48', 0);
INSERT INTO `crew`.`sy_menu`(`id`, `menu_name`, `menu_code`, `menu_icon`, `menu_path`, `parent_id`, `description`, `redirect`, `component`, `seq`, `create_at`, `hidden`) VALUES (1275070495024271362, '交路计划明细', 'RouteItem', '', '/route/item', 1280777845104594945, '', '', 'routeItem', 8888, '2020-06-22 22:17:50', 0);
INSERT INTO `crew`.`sy_menu`(`id`, `menu_name`, `menu_code`, `menu_icon`, `menu_path`, `parent_id`, `description`, `redirect`, `component`, `seq`, `create_at`, `hidden`) VALUES (1275076666321850370, '班次组管理', 'ShiftGroup', '', '/shift/group', 1280777845104594945, '', '', 'shiftGroup', 7777, '2020-06-22 22:42:21', 0);
INSERT INTO `crew`.`sy_menu`(`id`, `menu_name`, `menu_code`, `menu_icon`, `menu_path`, `parent_id`, `description`, `redirect`, `component`, `seq`, `create_at`, `hidden`) VALUES (1275076900171075585, '班次管理', 'Shift', '', '/arrange/shift', 1280777845104594945, '', '', 'shift', 6666, '2020-06-22 22:43:17', 1);
INSERT INTO `crew`.`sy_menu`(`id`, `menu_name`, `menu_code`, `menu_icon`, `menu_path`, `parent_id`, `description`, `redirect`, `component`, `seq`, `create_at`, `hidden`) VALUES (1277167497134919682, '司机管理', 'Staff', 'team', '/staff', NULL, '', '/staff/team', 'PageView', 5555, '2020-06-28 17:10:34', 0);
INSERT INTO `crew`.`sy_menu`(`id`, `menu_name`, `menu_code`, `menu_icon`, `menu_path`, `parent_id`, `description`, `redirect`, `component`, `seq`, `create_at`, `hidden`) VALUES (1277515420070731777, '机队管理', 'Team', '', '/staff/team', 1277167497134919682, '', '', 'team', 9999, '2020-06-29 16:13:05', 0);
INSERT INTO `crew`.`sy_menu`(`id`, `menu_name`, `menu_code`, `menu_icon`, `menu_path`, `parent_id`, `description`, `redirect`, `component`, `seq`, `create_at`, `hidden`) VALUES (1277515860313268226, '机组管理', 'Group', '', '/staff/group', 1277167497134919682, '', '', 'group', 8888, '2020-06-29 16:14:50', 0);
INSERT INTO `crew`.`sy_menu`(`id`, `menu_name`, `menu_code`, `menu_icon`, `menu_path`, `parent_id`, `description`, `redirect`, `component`, `seq`, `create_at`, `hidden`) VALUES (1277516106598604802, '司机管理', 'Driver', '', '/staff/driver', 1277167497134919682, '', '', 'driver', 7777, '2020-06-29 16:15:49', 0);
INSERT INTO `crew`.`sy_menu`(`id`, `menu_name`, `menu_code`, `menu_icon`, `menu_path`, `parent_id`, `description`, `redirect`, `component`, `seq`, `create_at`, `hidden`) VALUES (1277828285105328129, '拓展信息', 'Extension', '', '/staff/extension', 1277167497134919682, '', '', 'extension', 6666, '2020-06-30 12:56:18', 0);
INSERT INTO `crew`.`sy_menu`(`id`, `menu_name`, `menu_code`, `menu_icon`, `menu_path`, `parent_id`, `description`, `redirect`, `component`, `seq`, `create_at`, `hidden`) VALUES (1282490577851965442, '排班日计划', 'ArrangeDay', '', '/arrange/day', 1271252850498273281, '', '', 'arrangeDay', 8888, '2020-07-13 09:42:35', 0);
INSERT INTO `crew`.`sy_menu`(`id`, `menu_name`, `menu_code`, `menu_icon`, `menu_path`, `parent_id`, `description`, `redirect`, `component`, `seq`, `create_at`, `hidden`) VALUES (1282628272263716865, '考勤记录', 'Attendance', '', '/staff/attendance', 1277167497134919682, '', '', 'attendance', 5555, '2020-07-13 18:49:44', 0);
INSERT INTO `crew`.`sy_menu`(`id`, `menu_name`, `menu_code`, `menu_icon`, `menu_path`, `parent_id`, `description`, `redirect`, `component`, `seq`, `create_at`, `hidden`) VALUES (1283339533800636418, '信息发布', 'Notice', 'notification', '/notice', NULL, '', '', 'PageView', 4444, '2020-07-15 17:56:02', 0);
INSERT INTO `crew`.`sy_menu`(`id`, `menu_name`, `menu_code`, `menu_icon`, `menu_path`, `parent_id`, `description`, `redirect`, `component`, `seq`, `create_at`, `hidden`) VALUES (1283339759349334018, '通知模板', 'NotificationTemplate', '', '/notice/notification/template', 1283339533800636418, '', '', 'notificationTemplate', 8888, '2020-07-15 17:56:56', 0);
INSERT INTO `crew`.`sy_menu`(`id`, `menu_name`, `menu_code`, `menu_icon`, `menu_path`, `parent_id`, `description`, `redirect`, `component`, `seq`, `create_at`, `hidden`) VALUES (1283340032708902913, '通知管理', 'Notification', '', '/notice/notification', 1283339533800636418, '', '', 'notification', 9999, '2020-07-15 17:58:01', 0);
INSERT INTO `crew`.`sy_menu`(`id`, `menu_name`, `menu_code`, `menu_icon`, `menu_path`, `parent_id`, `description`, `redirect`, `component`, `seq`, `create_at`, `hidden`) VALUES (1283359945926262785, '公告模板', 'AnnouncementTemplate', '', '/notice/announcement/template', 1283339533800636418, '', '', 'announcementTemplate', 6666, '2020-07-15 19:17:09', 0);
INSERT INTO `crew`.`sy_menu`(`id`, `menu_name`, `menu_code`, `menu_icon`, `menu_path`, `parent_id`, `description`, `redirect`, `component`, `seq`, `create_at`, `hidden`) VALUES (1283360250910883841, '公告管理', 'Announcement', '', '/notice/announcement', 1283339533800636418, '', '', 'announcement', 7777, '2020-07-15 19:18:22', 0);



INSERT INTO `crew`.`sy_role_menu_rel`(`id`, `role_id`, `menu_id`) VALUES (1281147922236772353, 1265829314040348888, 1267613035315785729);
INSERT INTO `crew`.`sy_role_menu_rel`(`id`, `role_id`, `menu_id`) VALUES (1281147922240966658, 1265829314040348888, 1267615579739959298);
INSERT INTO `crew`.`sy_role_menu_rel`(`id`, `role_id`, `menu_id`) VALUES (1281147922240966659, 1265829314040348888, 1267615997123538945);
INSERT INTO `crew`.`sy_role_menu_rel`(`id`, `role_id`, `menu_id`) VALUES (1281147922240966660, 1265829314040348888, 1267616400892407810);
INSERT INTO `crew`.`sy_role_menu_rel`(`id`, `role_id`, `menu_id`) VALUES (1281147922245160962, 1265829314040348888, 1267616680786702337);
INSERT INTO `crew`.`sy_role_menu_rel`(`id`, `role_id`, `menu_id`) VALUES (1281147922245160961, 1265829314040348888, 1267616921988542465);
INSERT INTO `crew`.`sy_role_menu_rel`(`id`, `role_id`, `menu_id`) VALUES (1281147922245160963, 1265829314040348888, 1267617169876103170);
INSERT INTO `crew`.`sy_role_menu_rel`(`id`, `role_id`, `menu_id`) VALUES (1281147922245160964, 1265829314040348888, 1267617373954158593);
INSERT INTO `crew`.`sy_role_menu_rel`(`id`, `role_id`, `menu_id`) VALUES (1281147922245160966, 1265829314040348888, 1267751023211372546);
INSERT INTO `crew`.`sy_role_menu_rel`(`id`, `role_id`, `menu_id`) VALUES (1281147922249355265, 1265829314040348888, 1267751338962771969);
INSERT INTO `crew`.`sy_role_menu_rel`(`id`, `role_id`, `menu_id`) VALUES (1281147922249355266, 1265829314040348888, 1267751475692888066);
INSERT INTO `crew`.`sy_role_menu_rel`(`id`, `role_id`, `menu_id`) VALUES (1281147922249355267, 1265829314040348888, 1267751581037027329);
INSERT INTO `crew`.`sy_role_menu_rel`(`id`, `role_id`, `menu_id`) VALUES (1281147922245160965, 1265829314040348888, 1267752705852891138);
INSERT INTO `crew`.`sy_role_menu_rel`(`id`, `role_id`, `menu_id`) VALUES (1281147922249355268, 1265829314040348888, 1268718547927207938);
INSERT INTO `crew`.`sy_role_menu_rel`(`id`, `role_id`, `menu_id`) VALUES (1281147922249355269, 1265829314040348888, 1268718911724359682);
INSERT INTO `crew`.`sy_role_menu_rel`(`id`, `role_id`, `menu_id`) VALUES (1281147922253549570, 1265829314040348888, 1268719318722842626);
INSERT INTO `crew`.`sy_role_menu_rel`(`id`, `role_id`, `menu_id`) VALUES (1281147922253549571, 1265829314040348888, 1268796209190313985);
INSERT INTO `crew`.`sy_role_menu_rel`(`id`, `role_id`, `menu_id`) VALUES (1281147922257743875, 1265829314040348888, 1268831899617767425);
INSERT INTO `crew`.`sy_role_menu_rel`(`id`, `role_id`, `menu_id`) VALUES (1281147922257743874, 1265829314040348888, 1268835985939410946);
INSERT INTO `crew`.`sy_role_menu_rel`(`id`, `role_id`, `menu_id`) VALUES (1281147922270326785, 1265829314040348888, 1271252850498273281);
INSERT INTO `crew`.`sy_role_menu_rel`(`id`, `role_id`, `menu_id`) VALUES (1281147922257743876, 1265829314040348888, 1271253153457045506);
INSERT INTO `crew`.`sy_role_menu_rel`(`id`, `role_id`, `menu_id`) VALUES (1281147922257743878, 1265829314040348888, 1272452171184902145);
INSERT INTO `crew`.`sy_role_menu_rel`(`id`, `role_id`, `menu_id`) VALUES (1281147922261938177, 1265829314040348888, 1272452475225804801);
INSERT INTO `crew`.`sy_role_menu_rel`(`id`, `role_id`, `menu_id`) VALUES (1281147922261938178, 1265829314040348888, 1273083455372410881);
INSERT INTO `crew`.`sy_role_menu_rel`(`id`, `role_id`, `menu_id`) VALUES (1281147922261938179, 1265829314040348888, 1275069983549870082);
INSERT INTO `crew`.`sy_role_menu_rel`(`id`, `role_id`, `menu_id`) VALUES (1281147922261938181, 1265829314040348888, 1275070495024271362);
INSERT INTO `crew`.`sy_role_menu_rel`(`id`, `role_id`, `menu_id`) VALUES (1281147922261938182, 1265829314040348888, 1275076666321850370);
INSERT INTO `crew`.`sy_role_menu_rel`(`id`, `role_id`, `menu_id`) VALUES (1281147922266132482, 1265829314040348888, 1275076900171075585);
INSERT INTO `crew`.`sy_role_menu_rel`(`id`, `role_id`, `menu_id`) VALUES (1281147922266132483, 1265829314040348888, 1277167497134919682);
INSERT INTO `crew`.`sy_role_menu_rel`(`id`, `role_id`, `menu_id`) VALUES (1281147922266132484, 1265829314040348888, 1277515420070731777);
INSERT INTO `crew`.`sy_role_menu_rel`(`id`, `role_id`, `menu_id`) VALUES (1281147922266132485, 1265829314040348888, 1277515860313268226);
INSERT INTO `crew`.`sy_role_menu_rel`(`id`, `role_id`, `menu_id`) VALUES (1281147922266132486, 1265829314040348888, 1277516106598604802);
INSERT INTO `crew`.`sy_role_menu_rel`(`id`, `role_id`, `menu_id`) VALUES (1281147922266132487, 1265829314040348888, 1277828285105328129);
INSERT INTO `crew`.`sy_role_menu_rel`(`id`, `role_id`, `menu_id`) VALUES (1281147922257743877, 1265829314040348888, 1280775502053134338);
INSERT INTO `crew`.`sy_role_menu_rel`(`id`, `role_id`, `menu_id`) VALUES (1281147922261938180, 1265829314040348888, 1280777845104594945);
INSERT INTO `crew`.`sy_role_menu_rel`(`id`, `role_id`, `menu_id`) VALUES (1281147922270326786, 1265829314040348888, 1281147833950867457);
INSERT INTO `crew`.`sy_role_menu_rel`(`id`, `role_id`, `menu_id`) VALUES (1282490969423798277, 1265829314040348888, 1282490577851965442);
INSERT INTO `crew`.`sy_role_menu_rel`(`id`, `role_id`, `menu_id`) VALUES (1282628491810365441, 1265829314040348888, 1282628272263716865);
INSERT INTO `crew`.`sy_role_menu_rel`(`id`, `role_id`, `menu_id`) VALUES (1283340096839811075, 1265829314040348888, 1283339533800636418);
INSERT INTO `crew`.`sy_role_menu_rel`(`id`, `role_id`, `menu_id`) VALUES (1283340096839811077, 1265829314040348888, 1283339759349334018);
INSERT INTO `crew`.`sy_role_menu_rel`(`id`, `role_id`, `menu_id`) VALUES (1283340096839811076, 1265829314040348888, 1283340032708902913);
INSERT INTO `crew`.`sy_role_menu_rel`(`id`, `role_id`, `menu_id`) VALUES (1283360399406022661, 1265829314040348888, 1283359945926262785);
INSERT INTO `crew`.`sy_role_menu_rel`(`id`, `role_id`, `menu_id`) VALUES (1283360399406022660, 1265829314040348888, 1283360250910883841);