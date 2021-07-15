/*
 Navicat Premium Data Transfer

 Source Server         : 192.168.150.1-MYSQL
 Source Server Type    : MySQL
 Source Server Version : 80019
 Source Host           : localhost:3306
 Source Schema         : recruitment_web

 Target Server Type    : MySQL
 Target Server Version : 80019
 File Encoding         : 65001

 Date: 15/07/2021 10:09:55
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for collection
-- ----------------------------
DROP TABLE IF EXISTS `collection`;
CREATE TABLE `collection`  (
  `id` int(0) NOT NULL AUTO_INCREMENT,
  `user_id` int(0) NULL DEFAULT NULL,
  `job_id` int(0) NULL DEFAULT NULL,
  `company_id` int(0) NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 5 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of collection
-- ----------------------------
INSERT INTO `collection` VALUES (5, 15, 19, NULL);

-- ----------------------------
-- Table structure for company
-- ----------------------------
DROP TABLE IF EXISTS `company`;
CREATE TABLE `company`  (
  `company_id` int(0) NOT NULL AUTO_INCREMENT,
  `user_id` int(0) NULL DEFAULT NULL,
  `name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `kind` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '公司领域',
  `place` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '公司所在城市',
  `stage` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '融资',
  `scale` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '规模',
  `url` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '公司网址',
  `comintroduce` varchar(3400) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '公司描述',
  `address` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '公司具体地址',
  `avatar` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`company_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 15 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of company
-- ----------------------------
INSERT INTO `company` VALUES (6, 10009, '广州市汇聚支付电子科技有限公司', '支付电子', '广州市', 'A轮', '100-499人', 'www.ikeca.com', '广州市汇聚支付电子科技有限公司（以下简称汇聚支付）是广州市正佳集团旗下的全资子公司，成立于2008年7月1日，注册资本一亿元人民币，总部位于中国广州。', '广州天河区广晟大厦(正佳广场)1101-1104室', 'e807a5e182ee40fa8424dceeb2e91de2.png');
INSERT INTO `company` VALUES (7, 10010, '阿里巴巴集团', '互联网', '杭州市', '天使轮', '10000人以上', 'www.alibaba.com', '阿里巴巴集团的使命是让天下没有难做的生意。\n我们旨在赋能企业改变营销、销售和经营的方式。我们为商家、品牌及其他企业提供基本的互联网基础设施以及营销平台，让其可借助互联网的力量与用户和客户互动。我们的业务包括核心电商、云计算、数字媒体和娱乐以及创新项目和其他业务。我们并通过子公司菜鸟网络及所投资的关联公司口碑，参与物流和本地服务行业，同时与蚂蚁金融服务集团有战略合作，该金融服务集团主要通过中国领先的第三方网上支付平台支付宝运营。', '杭州余杭区阿里巴巴西溪园区', '4f87f397a6bf4c1b9b57c10bc7c8f0f3.png');
INSERT INTO `company` VALUES (8, 10011, '腾讯', '互联网', '深圳市', '已上市', '10000人以上', 'www.qq.com', '腾讯以技术丰富互联网用户的生活。\n通过通信及社交平台微信和 QQ 促进用户联系，并助其连接数字内容和生活服务，尽在弹指间。\n通过高效广告平台，协助品牌和市场营销者触达数以亿计的中国消费者。\n通过金融科技及企业服务，促进合作伙伴业务发展，助力实现数字化升级。\n我们大力投资于人才队伍和推动科技创新，积极参与互联网行业协同发展。', '深圳市 南山区 腾讯大厦', '580b70aaede94c60ada4ec6c19dcaa00.png');
INSERT INTO `company` VALUES (9, 10012, '百度时代网络技术（北京）有限公司', '互联网', '北京市', 'A轮', '10000人以上', 'www.baidu.com', '“百度”二字，来自于八百年前南宋词人辛弃疾的一句词：众里寻他千百度。这句话描述了词人对理想的执着追求。\n百度拥有数万名研发工程师，这是中国乃至全球最为优秀的技术团队。这支队伍掌握着世界上最为先进的搜索引擎技术，使百度成为中国掌握世界尖端科学核心技术的中国高科技企业，也使中国成为美国、俄罗斯、和韩国之外，全球仅有的4个拥有搜索引擎核心技术的国家之一。', '北京海淀区百度大厦百度大厦', 'fde1a1422a0c490797ced48a70890eb6.png');
INSERT INTO `company` VALUES (10, 10013, '华为技术有限公司', 'j计算机软件', '深圳市', '不需要融资', '10000人以上', 'www.huawei.com', '华为创立于1987年，是全球领先的ICT（信息与通信）基础设施和智能终端提供商，我们致力于把数字世界带入每个人、每个家庭、每个组织，构建万物互联的智能世界：让无处不在的联接，成为人人平等的权利；为世界提供最强算力，让云无处不在，让智能无所不及；所有的行业和组织，因强大的数字平台而变得敏捷、高效、生机勃勃；通过AI重新定义体验，让消费者在家居、办公、出行等全场景获得极致的个性化体验。目前华为约有19.4万员工，业务遍及170多个国家和地区，服务30多亿人口。', '上海市 浦东新区 上海华为技术有限公司(新金桥路) 2222', 'd1e95f10aa1f4fd7b549314baee4acbb.png');
INSERT INTO `company` VALUES (11, 10014, '国际商业机器（中国）有限公司', '互联网', '天津市', '天使轮', '10000人以上', 'www.IBM.com', 'SmartCamp创业家全球训练营当今世界发展迅速，带来全新的机遇和挑战，唯有持续创新，才能适应不断的变化。从蒸汽机时代开始，创新就一直引领起了世界前进的脚步。IBM公司成立百年，创新百年，愿助力创业家放飞梦想，共建智慧地球。从2010年开始，IBM在全球范围内，启动创业企业全球扶持计划(IBMGEP)，为创立5年之内、从事软件产品开发或服务的创业企业，提供产品研发、专家指导、市场拓展等丰富资源，帮助提升其业务方案、寻找目标客户，有效缩短创新周期。作为创业企业全球扶持计划的重要一环', '深圳南山区蛇口科技大厦B座5楼', '2dfca73454aa4d2696b2286327238b2f.png');
INSERT INTO `company` VALUES (12, 10015, '北京小米移动软件有限公司', '互联网', '北京市', '天使轮', '10000人以上', 'www.xiaomi.com', '小米公司正式成立于2010年4月，是一家以手机、智能硬件和 IoT 平台为核心的互联网公司。创业仅7年时间，小米的年收入就突破了千亿元人民币。截止2018年，小米的业务遍及全球80多个国家和地区。\n\n小米的使命是，始终坚持做“感动人心、价格厚道”的好产品，让全球每个人都能享受科技带来的美好生活。', '北京海淀区小米移动互联网产业园小米科技园', 'cc270894fa3e4f7e8a7d1fd78550ecb6.png');
INSERT INTO `company` VALUES (13, 10016, '北京京东世纪贸易有限公司', '电子商务', '北京市', '天使轮', '10000人以上', 'www.jingdong.com', '京东于2004年正式涉足电商领域，2018年，京东集团市场交易额接近1.7万亿元*。2019年7月，京东第四次入榜《财富》全球500强，位列第139位，在全球仅次于亚马逊和Alphabet，位列互联网企业第三。', '北京朝阳区北辰世纪中心A座10层', 'bc1db4c0574a44f99e9551b66dfb933c.png');
INSERT INTO `company` VALUES (14, 10017, '北京三快在线科技有限公司', '互联网', '北京市', '天使轮', '10000人以上', 'www.meituan.com', '美团的使命是“帮大家吃得更好，生活更好”。作为一家生活服务电子商务平台，公司聚焦“Food +Platform”战略，以“吃”为核心，通过科技创新，和广大商户与各类合作伙伴一起，努力为消费者提供品质生活，推动生活服务业需求侧和供给侧数字化升级。\n2018年9月20日，美团正式在港交所挂牌上市。美团将始终坚持以客户为中心，不断加大在科技研发方面的投入，更好承担社会责任，更多创造社会价值，与广大合作伙伴一起发展共赢。', '北京朝阳区望京SOHO1', '338004f0caee4a15a004f9f7dc8707ce.png');
INSERT INTO `company` VALUES (15, 10018, '联想教育科技（北京）有限公司', '培训机构', '北京市', 'A轮', '100-499人', 'www.lianxiang.com', '用心教育，好好赚钱', '北京海淀区联想西区总部w1', '7a3083b21cf040798d84250cd9b62f22.png');

-- ----------------------------
-- Table structure for company_user
-- ----------------------------
DROP TABLE IF EXISTS `company_user`;
CREATE TABLE `company_user`  (
  `id` int(0) NOT NULL AUTO_INCREMENT COMMENT 'id',
  `username` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT 'hr账号',
  `password` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '密码',
  `create_time` timestamp(0) NULL DEFAULT NULL COMMENT '创建时间',
  `update_time` timestamp(0) NULL DEFAULT NULL COMMENT '更新时间',
  `deleted` int(0) NULL DEFAULT 0 COMMENT '是否删除了，默认0',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 10018 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of company_user
-- ----------------------------
INSERT INTO `company_user` VALUES (10009, 'test1', '123', '2021-06-29 21:53:58', '2021-06-29 21:53:58', 0);
INSERT INTO `company_user` VALUES (10010, 'test2', '123', '2021-06-29 21:55:55', '2021-06-29 21:55:55', 0);
INSERT INTO `company_user` VALUES (10011, 'test4', '123', '2021-06-29 21:58:50', '2021-06-29 21:58:50', 0);
INSERT INTO `company_user` VALUES (10012, 'test5', '123', '2021-06-29 22:01:26', '2021-06-29 22:01:26', 0);
INSERT INTO `company_user` VALUES (10013, 'test7', '123', '2021-06-29 22:03:11', '2021-06-29 22:03:11', 0);
INSERT INTO `company_user` VALUES (10014, 'test6', '123', '2021-06-29 22:05:07', '2021-06-29 22:05:07', 0);
INSERT INTO `company_user` VALUES (10015, 'test8', '123', '2021-06-29 22:06:05', '2021-06-29 22:06:05', 0);
INSERT INTO `company_user` VALUES (10016, 'test10', '123', '2021-06-29 22:07:34', '2021-06-29 22:07:34', 0);
INSERT INTO `company_user` VALUES (10017, 'test11', '123', '2021-06-29 22:09:00', '2021-06-29 22:09:00', 0);
INSERT INTO `company_user` VALUES (10018, 'test12', '123', '2021-06-29 22:09:45', '2021-06-29 22:09:45', 0);

-- ----------------------------
-- Table structure for deliver
-- ----------------------------
DROP TABLE IF EXISTS `deliver`;
CREATE TABLE `deliver`  (
  `id` int(0) NOT NULL AUTO_INCREMENT,
  `apply_id` int(0) NULL DEFAULT NULL,
  `company_id` int(0) NULL DEFAULT NULL,
  `job_id` int(0) NULL DEFAULT NULL,
  `resume_id` int(0) NULL DEFAULT NULL,
  `status` int(0) NULL DEFAULT 0,
  `create_time` timestamp(0) NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 10 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of deliver
-- ----------------------------
INSERT INTO `deliver` VALUES (9, 15, 6, 19, 11, 2, NULL);
INSERT INTO `deliver` VALUES (10, 15, 6, 19, 11, 1, NULL);

-- ----------------------------
-- Table structure for face
-- ----------------------------
DROP TABLE IF EXISTS `face`;
CREATE TABLE `face`  (
  `id` int(0) NOT NULL AUTO_INCREMENT,
  `apply_id` int(0) NULL DEFAULT NULL,
  `company_id` int(0) NULL DEFAULT NULL,
  `job_id` int(0) NULL DEFAULT NULL,
  `status` int(0) NULL DEFAULT 0,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 7 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of face
-- ----------------------------
INSERT INTO `face` VALUES (7, 15, 6, 19, 0);

-- ----------------------------
-- Table structure for first_type
-- ----------------------------
DROP TABLE IF EXISTS `first_type`;
CREATE TABLE `first_type`  (
  `first_id` int(0) NOT NULL AUTO_INCREMENT COMMENT '第一类id',
  `first_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '第一类名称',
  PRIMARY KEY (`first_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 10004 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of first_type
-- ----------------------------
INSERT INTO `first_type` VALUES (10000, '后端开发');
INSERT INTO `first_type` VALUES (10001, '移动开发');
INSERT INTO `first_type` VALUES (10002, '前端开发');
INSERT INTO `first_type` VALUES (10003, '测试');
INSERT INTO `first_type` VALUES (10004, '运维/技术支持');

-- ----------------------------
-- Table structure for job
-- ----------------------------
DROP TABLE IF EXISTS `job`;
CREATE TABLE `job`  (
  `job_id` int(0) NOT NULL AUTO_INCREMENT,
  `user_id` int(0) NULL DEFAULT NULL,
  `companyid` int(0) NULL DEFAULT NULL COMMENT '公司的id',
  `job_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '工作名称',
  `kind` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '职位类别',
  `department` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '所属部门',
  `salary` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '薪资',
  `place` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '工作城市',
  `experience` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `academic` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `address` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `jobdescription` varchar(3400) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `jobneed` varchar(3000) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `remail` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '接收的邮箱',
  `hr` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `status` int(0) NULL DEFAULT 0 COMMENT '是否有效,0有效',
  `create_time` datetime(0) NULL DEFAULT NULL,
  `update_time` datetime(0) NULL DEFAULT NULL,
  PRIMARY KEY (`job_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 23 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of job
-- ----------------------------
INSERT INTO `job` VALUES (19, 10009, 6, 'go语言开发工程师', '后端开发', '后端开发部', '14500', '北京市', '应届毕业生', '本 科', '广州天河区广晟大厦(正佳广场)1101-1104室', '开发后端', '岗位职责：\n1、参与技术讨论，产品需求分析；\n2、参与系统的开发，单元测试。\n任职要求：\n全日制本科及以上学历；\n熟悉Golang，有一定的代码量积累，了解Python语言者优先考虑；\n熟悉HTTP协议，对计算机网络有一定了解；\n熟悉Linux，能用linux进行日常开发，在服务器上部署过项目的优先考虑；', '1666053505@qq.com', '李大钊', 0, '2021-06-29 22:54:32', '2021-06-29 22:54:32');
INSERT INTO `job` VALUES (20, 10009, 6, '高级测试工程', '测试', '测试开发部', '16300', '广州', '应届毕业生', '本科', '广州天河区广晟大厦(正佳广场)1101-1104室', '1、负责后端架构设计与实现\n2、参与设计系统技术方案，核心代码开发和系统调优\n3、解决研发过程中遇到高并发、数据隔离、系统解耦等方面的问题，提高开发效率，\n2、持续优化系统架构，支持业务快速发展和演进\n4、参与制定代码规范、测试规范，建立起开发质量控制方法\n5、指导并培养相关技术方向的团队成员，带领团队不断攻克技术难题', '1、有扎实的计算机基础，对数据结构、算法基础有扎实掌握，对计算机体系结构、操作系统、计算机网络有深刻理解；\n2、扎实的编程功底，至少精通C/C++/Java/Golang其中一种语言，具有良好的编程习惯和编码风格；精通 Golang 者优先\n3、具有出色的抽象设计能力，思路清晰，善于思考，能独立分析和解决问题\n4、熟悉常用的SQL/NoSql数据库、消息队列和分布式存储组件，对数据库、缓存、消息队列、索引等技术有深入的了解；\n5、掌握分布式系统基础理论、熟练微服务架构，具有高并发、大流量、高性能、高可用系统经验者优先；\n6、充分了解业内实践和趋势，有较好的前瞻性，为项目决策提供有力支持；\n7、良好的沟通能力和团队协作精神，较强的主动性和责任心，能够自我驱动，不断学习，热爱技术；\n8、5年以上后端工作经验，2年以上架构师经验；', '1666053505@qq.com', '李大钊', 0, '2021-06-29 22:58:22', '2021-06-29 22:58:22');
INSERT INTO `job` VALUES (21, 10009, 6, 'Linux运维', '运维/技术支持', '技术部', '17800', '南京市', '实习生', '硕 士', '广州天河区广晟大厦(正佳广场)1101-1104室', '1、在帮带人指导下，学习所需的技术，熟悉公司系统，通过考核。\n2、及时解答并处理用户在系统过程中遇到的问题。\n3、负责公司ERP、OA等系统的日常管理维护及技术支持。\n4、协助系统的部署实施、操作培训。\n5、负责收集、整理用户对ERP、OA系统的使用意见及建议，为系统优化提供参考意见。\n6、领导安排的的其它工作。', '1、本科及以上学历，2022年毕业，计算机相关专业，可全职实习；\n2、掌握数据库基本操作，对运维工作有基本认识，有相关实习经验优先；\n3、开朗积极，乐于沟通合作，对业务有好奇心；\n4、责任心强，服从工作安排，有抗压能力。', 'dasfasd5@qq.com', '李大钊', 0, '2021-06-29 23:01:50', '2021-06-29 23:01:50');
INSERT INTO `job` VALUES (22, 10010, 7, 'Java高端开发工程师', '后端开发', '后端开发部', '20700', '北京市', '实习生', '本科', '杭州余杭区阿里巴巴西溪园区', '工作职责:（学JAVA语言的优先）其实经常大佬也包吃\n1、执行上级主管安排的工作任务，对负责模块进行设计和开发测试\n2、负责项目的日常开发维护工作等\n3、配合项目工作进度和编程工作规范编写程序；', '1、计算机及相关专业毕业，大学本科及其以上学历，欢迎在校实习生；\n2、了解HTML/XML、JavaScript、CSS、JSP、Java语言及SQL；\n3、具有良好的沟通能力和团队合作精神；\n4、做事认真、严谨，能够承受一定压力；\n5、男女不限，18-30岁', 'rttyrsfzx@qq.com', '张勇', 0, '2021-06-29 23:08:34', '2021-06-29 23:08:34');
INSERT INTO `job` VALUES (23, 10010, 7, '高级测试工程师', '测试', '测试开发部', '8000', '杭州市', '5-10年', '本科', '杭州余杭区阿里巴巴西溪园区', '1、工作内容包括功能、性能、自动化测试，以及发布交付及线上监控等；\n2、通过编写脚本及工具不断提升测试效率，包括持续集成、测试工具等的建设', '1、2022届本科及以上毕业生，至少实习2个月及以上，计算机或相关专业本科及以上；\n2、掌握java、php、shell、python等语言中的1-2种，熟悉算法、数据结构、计算机网络，熟悉Linux,mysql（或其他数据库）对技术有热情；', 'sdfafdfqe@qq.com', '张勇', 0, '2021-06-29 23:12:52', '2021-06-29 23:12:52');

-- ----------------------------
-- Table structure for position
-- ----------------------------
DROP TABLE IF EXISTS `position`;
CREATE TABLE `position`  (
  `position_id` int(0) NOT NULL AUTO_INCREMENT COMMENT '职位id',
  `position_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '职位名称',
  `position_describe` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '描述',
  `second_type_id` int(0) NULL DEFAULT NULL,
  PRIMARY KEY (`position_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 10006 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of position
-- ----------------------------
INSERT INTO `position` VALUES (10000, 'Java后端开发', '帮助架构师完成任务', 10000);
INSERT INTO `position` VALUES (10001, 'Java大数据开发', NULL, 10000);
INSERT INTO `position` VALUES (10002, 'C#高级工程师', NULL, 10001);
INSERT INTO `position` VALUES (10003, 'Android应用开发', NULL, 10002);
INSERT INTO `position` VALUES (10004, 'Android系统开发', NULL, 10002);
INSERT INTO `position` VALUES (10005, '后端测试工程师', NULL, 10003);
INSERT INTO `position` VALUES (10006, '大数据测试工程师', NULL, 10003);

-- ----------------------------
-- Table structure for resume
-- ----------------------------
DROP TABLE IF EXISTS `resume`;
CREATE TABLE `resume`  (
  `resume_id` int(0) NOT NULL AUTO_INCREMENT,
  `user_id` int(0) NULL DEFAULT NULL COMMENT '用户id',
  `name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '名字',
  `sex` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '性别',
  `birth` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '生日',
  `nationality` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '国籍',
  `email` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '邮箱',
  `telephone` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '电话',
  `experience` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '工作经历',
  `desiredjob` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '期望工作',
  `desiredsalary` decimal(10, 2) NULL DEFAULT NULL COMMENT '期望薪资',
  `desiredcity` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '期望城市',
  `school` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `subject` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `academic` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `begindate` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `enddate` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `projectname` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `duty` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `starttime` datetime(0) NULL DEFAULT NULL,
  `endtime` datetime(0) NULL DEFAULT NULL,
  `description` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '项目描述',
  `assessment` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '自我评价',
  `avatar` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '头像',
  PRIMARY KEY (`resume_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 23 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of resume
-- ----------------------------
INSERT INTO `resume` VALUES (11, 15, '林佳', '男', '1999-10-18T16:00:00.000Z', '中 国', '1666053505@qq.com', '14714131611', '应届毕业生', '后端开发', 10000.00, '广州', '广东药科大学', '计算机科学与技术', '本科', '2021-06-27T16:00:00.000Z', '2023-02-04T16:00:00.000Z', '二手商城', '项目开发后端', '2021-02-03 00:00:00', '2021-06-02 00:00:00', '模仿闲鱼二手商城的一个项目', '1.大三计科在读，已过四级，熟练掌握C，Java。精通JavaWeb开发。计算机本科，具有良好的编程习惯，熟练掌握Spring、SpringMVC、Mybatis、Redis等。掌握git的使用，学习能力强，适应能力强。\n\n2.熟练使用linux系统的命令，Xshell和Xftp', 'a0ec623199eb489bba617107d9187ec0.png');
INSERT INTO `resume` VALUES (12, 16, '李明', '男', '2000-01-31T16:00:00.000Z', '中 国', '1666053505@gmail.com', '14714131611', '应届毕业生', '后端开发', 10000.00, '广州', '哈佛大学', '计算机科学与技术', '本科', '2018-01-31T16:00:00.000Z', '2022-03-02T16:00:00.000Z', '论文管理系统', '项目经理', '2021-06-15 00:00:00', '2021-06-29 00:00:00', '一个论文管理系统', '能抗压。喜欢996的生活快请我！', 'a0ec623199eb489bba617107d9187ec0.png');
INSERT INTO `resume` VALUES (13, 17, '马云', '男', '1991-02-04T16:00:00.000Z', '中 国', '8715151@qq.com', '15920118767', '5-10年', '项目', 10000.00, '广州', '杭州师范大学', '计算机科学与技术', '博 士', '2021-06-29T16:00:00.000Z', '2021-06-29T16:00:00.000Z', '淘宝电商平台', '总裁', '2001-06-19 00:00:00', '2021-06-09 00:00:00', '成为首富的小项目', '对金钱不感兴趣，996是福报', 'a0ec623199eb489bba617107d9187ec0.png');
INSERT INTO `resume` VALUES (14, 18, '陈健', '男', '1991-07-10T15:00:00.000Z', '美 国', 'postxvc@qq.com', '13714156781', '10年以上', '人工智能', 10000.00, '深圳市', '麻省理工大学', '计算机科学与技术', '本科', '2021-05-31T16:00:00.000Z', '2021-06-22T16:00:00.000Z', '人工智能实验室', '设计师', '2021-06-07 00:00:00', '2021-06-08 00:00:00', '专注人工智能的人脸识别等应用!', '热爱生活，热爱加班!', 'a0ec623199eb489bba617107d9187ec0.png');
INSERT INTO `resume` VALUES (15, 19, '丘富', '男', '1990-07-04T15:00:00.000Z', '中 国', 'sdfdggerd@qq.com', '18911011023', '三年及以下', '通 信', 10000.00, '广州', '中山大学', '计算机科学与技术', '本科', '2000-06-05T16:00:00.000Z', '2021-06-29T16:00:00.000Z', '仓库进出系统', '项目经理', '2020-06-08 00:00:00', '2021-06-22 00:00:00', '一个仓库的管理系统', '热爱加班，喜欢996福报', 'a0ec623199eb489bba617107d9187ec0.png');
INSERT INTO `resume` VALUES (16, 20, '王兴', '男', '2002-02-27T16:00:00.000Z', '中 国', 'dfdfs@qq.com', '15820976785', '应届毕业生', '高端技术职位', 10000.00, '深圳市', '华南理工大学', '计算机科学与技术', '硕 士', '2021-06-15T16:00:00.000Z', '2021-06-06T16:00:00.000Z', '', '', NULL, NULL, '', '', 'a0ec623199eb489bba617107d9187ec0.png');
INSERT INTO `resume` VALUES (17, 21, '苏文峰', '男', '2021-06-08T16:00:00.000Z', '中 国', 'sdfssadfsad@qq.com', '14672342324', '3-5年', '测 试', 10000.00, '上海市', '上海大学', '计算机科学与技术', '硕 士', '2021-06-21T16:00:00.000Z', '2021-06-13T16:00:00.000Z', '', '', NULL, NULL, '', '', 'a0ec623199eb489bba617107d9187ec0.png');
INSERT INTO `resume` VALUES (18, 22, '李东旭', '男', '2000-02-01T16:00:00.000Z', '美 国', 'asdfasd@qq.com', '13131242343', '3-5年', '运维/技术支持', 10000.00, '深圳市', '东华大学', '应用数学', '硕 士', '2021-06-16T16:00:00.000Z', '2021-06-21T16:00:00.000Z', '', '', NULL, NULL, '', '', 'a0ec623199eb489bba617107d9187ec0.png');
INSERT INTO `resume` VALUES (19, 23, '李大霄', '女', '2021-05-31T16:00:00.000Z', '英 国', 'asdfasd@qq.com', '13712323436', '5-10年', '硬件开发', 10000.00, '天津市', '天津大学', '应用数学', '硕 士', '2021-06-07T16:00:00.000Z', '2021-05-05T16:00:00.000Z', '', '', NULL, NULL, '', '', 'a0ec623199eb489bba617107d9187ec0.png');
INSERT INTO `resume` VALUES (20, 24, '李丽丽', '女', '2021-05-31T16:00:00.000Z', '中 国', 'dongxueqq@qq.com', '15630478691', '三年及以下', '前端开发', 10000.00, '成都市', '南京大学', '计算机科学与技术', '硕士', '2021-05-30T16:00:00.000Z', '2021-07-09T16:00:00.000Z', '', '', NULL, NULL, '', '', 'a0ec623199eb489bba617107d9187ec0.png');
INSERT INTO `resume` VALUES (21, 25, '吴晓霞', '女', '2008-02-03T16:00:00.000Z', '中 国', '231231231qq@qq.com', '15630478692', '三年及以下', '后端开发', 10000.00, '成都市', '南京大学', '计算机科学与技术', '硕士', '2018-07-02T16:00:00.000Z', '2021-06-28T16:00:00.000Z', '', '', NULL, NULL, '', '', 'a0ec623199eb489bba617107d9187ec0.png');
INSERT INTO `resume` VALUES (22, 26, '林丹丹', '女', '1999-05-31T16:00:00.000Z', '中 国', 'sdffsaf@qq.com', '15630478667', '5-10年', '通 信', 10000.00, '成都市', '清华大学', '计算机科学与技术', '博 士', '2000-06-14T16:00:00.000Z', '2021-06-13T16:00:00.000Z', '', '', NULL, NULL, '', '', 'a0ec623199eb489bba617107d9187ec0.png');
INSERT INTO `resume` VALUES (23, 27, '苏丽丽', '女', '2001-02-05T16:00:00.000Z', '中 国', 'dongxueqq@qq.com', '15630478691', '三年及以下', '后端开发', 10000.00, '深圳', '南京大学', '计算机科学与技术', '硕士', '2021-06-29T16:00:00.000Z', '2021-06-12T16:00:00.000Z', '', '', NULL, NULL, '', '', 'a0ec623199eb489bba617107d9187ec0.png');

-- ----------------------------
-- Table structure for second_type
-- ----------------------------
DROP TABLE IF EXISTS `second_type`;
CREATE TABLE `second_type`  (
  `second_id` int(0) NOT NULL AUTO_INCREMENT COMMENT '第二类的id',
  `second_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '第二类名字',
  `first_id` int(0) NULL DEFAULT NULL COMMENT '第一类id',
  `deleted` int(0) NULL DEFAULT 0 COMMENT '是否删除，0,1',
  PRIMARY KEY (`second_id`) USING BTREE,
  INDEX `first_id`(`first_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 10003 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of second_type
-- ----------------------------
INSERT INTO `second_type` VALUES (10000, 'Java', 10000, 0);
INSERT INTO `second_type` VALUES (10001, 'C#', 10000, 0);
INSERT INTO `second_type` VALUES (10002, 'Android', 10001, 0);
INSERT INTO `second_type` VALUES (10003, '测试工程师', 10003, 0);

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user`  (
  `id` int(0) NOT NULL AUTO_INCREMENT COMMENT 'id',
  `username` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '账号',
  `password` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '密码',
  `create_time` datetime(0) NULL DEFAULT NULL COMMENT '创建时间',
  `update_time` timestamp(0) NULL DEFAULT NULL COMMENT '修改时间',
  `deleted` int(0) NULL DEFAULT 0 COMMENT '是否注销，1是注销',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 30 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES (15, 'linjia', '123', '2021-06-29 19:01:25', '2021-06-29 19:01:25', 0);
INSERT INTO `user` VALUES (16, 'liming', '123', '2021-06-29 19:42:53', '2021-06-29 19:42:53', 0);
INSERT INTO `user` VALUES (17, 'mayun', '123', '2021-06-29 21:09:20', '2021-06-29 21:09:20', 0);
INSERT INTO `user` VALUES (18, 'chenjian', '123', '2021-06-29 21:15:16', '2021-06-29 21:15:16', 0);
INSERT INTO `user` VALUES (19, 'qiufu', '123', '2021-06-29 21:22:42', '2021-06-29 21:22:42', 0);
INSERT INTO `user` VALUES (20, 'wangxing', '123', '2021-06-29 21:32:07', '2021-06-29 21:32:07', 0);
INSERT INTO `user` VALUES (21, 'test1', '123', '2021-06-29 21:34:35', '2021-06-29 21:34:35', 0);
INSERT INTO `user` VALUES (22, 'test2', '123', '2021-06-29 21:36:30', '2021-06-29 21:36:30', 0);
INSERT INTO `user` VALUES (23, 'test3', '123', '2021-06-29 21:40:02', '2021-06-29 21:40:02', 0);
INSERT INTO `user` VALUES (24, 'test5', '123', '2021-06-29 21:41:40', '2021-06-29 21:41:40', 0);
INSERT INTO `user` VALUES (25, 'test9', '123', '2021-06-29 21:46:10', '2021-06-29 21:46:10', 0);
INSERT INTO `user` VALUES (26, 'test10', '123', '2021-06-29 21:47:39', '2021-06-29 21:47:39', 0);
INSERT INTO `user` VALUES (27, 'test11', '123', '2021-06-29 21:49:17', '2021-06-29 21:49:17', 0);
INSERT INTO `user` VALUES (28, 'test4', '123', '2021-06-29 22:01:06', '2021-06-29 22:01:06', 0);
INSERT INTO `user` VALUES (29, 'test6', '123', '2021-06-29 22:04:36', '2021-06-29 22:04:36', 0);
INSERT INTO `user` VALUES (30, 'opoo', '123', '2021-06-30 10:32:16', '2021-06-30 10:32:16', 0);

SET FOREIGN_KEY_CHECKS = 1;
