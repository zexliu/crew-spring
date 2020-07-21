INSERT INTO `sy_user` VALUES (1265829314040346666,
                              'admin',
                              '$2a$10$kNUhHY7c.IBnYxGvEaBqeuMDAdhUvzX5OZZliqPTtpJX3RYpt/tYy',
                              '18713888898',
                              'zexliu@icloud.com',
                              'zex',
                              '刘泽',
                              'https://ss2.bdstatic.com/70cFvnSh_Q1YnxGkpoWK1HF6hhy/it/u=101753226,3098745374&fm=26&gp=0.jpg',
                              '1',
                              1,
                              '2020-05-28', 1, 0,  NULL, NULL, NULL, '2020-05-28 10:02:52');

INSERT INTO `sy_role` VALUES (1265829314040348888,'管理员','ADMIN','系统管理员',0,'2020-05-28 10:02:52');
INSERT INTO `sy_user_role_rel` VALUES (1265829314040349999,1265829314040346666,1265829314040348888);
INSERT INTO `crew`.`sb_safe_config`(`id`, `create_at`, `safe1_at`, `safe2_at`, `safe3_at`, `safe4_at`, `safe5_at`, `type`, `description`, `operator_id`) VALUES (1, '2020-07-21 16:29:02', '2020-07-21', '2020-07-21', '2020-07-21', '2020-07-21', '2020-07-21', 0, '初始化信息', 1265829314040346666);




