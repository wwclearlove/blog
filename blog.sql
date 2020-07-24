/*
 Navicat Premium Data Transfer

 Source Server         : ww
 Source Server Type    : MySQL
 Source Server Version : 50730
 Source Host           : 39.106.123.27:3306
 Source Schema         : blog

 Target Server Type    : MySQL
 Target Server Version : 50730
 File Encoding         : 65001

 Date: 24/07/2020 14:18:51
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for t_blog
-- ----------------------------
DROP TABLE IF EXISTS `t_blog`;
CREATE TABLE `t_blog`  (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `appreciation` bit(1) NOT NULL,
  `commentabled` bit(1) NOT NULL,
  `content` longtext CHARACTER SET utf8 COLLATE utf8_general_ci NULL,
  `create_time` datetime(0) NULL DEFAULT NULL,
  `description` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `first_picture` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `flag` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `published` bit(1) NOT NULL,
  `recommend` bit(1) NOT NULL,
  `share_statement` bit(1) NOT NULL,
  `title` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `update_time` datetime(0) NULL DEFAULT NULL,
  `views` int(11) NULL DEFAULT NULL,
  `type_id` bigint(20) NULL DEFAULT NULL,
  `user_id` bigint(20) NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `FK292449gwg5yf7ocdlmswv9w4j`(`type_id`) USING BTREE,
  INDEX `FK8ky5rrsxh01nkhctmo7d48p82`(`user_id`) USING BTREE,
  CONSTRAINT `FK292449gwg5yf7ocdlmswv9w4j` FOREIGN KEY (`type_id`) REFERENCES `t_type` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `FK8ky5rrsxh01nkhctmo7d48p82` FOREIGN KEY (`user_id`) REFERENCES `t_user` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB AUTO_INCREMENT = 3 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of t_blog
-- ----------------------------
INSERT INTO `t_blog` VALUES (1, b'1', b'1', '# 个人博客\r\n\r\n麻烦点star，不要fork\r\n\r\n> 或许现在很多企业和团队尚未重视前端工程，或许前端工程在很多人眼里还只是“构建工具”的代名词，又或许未来前端领域的变革使得一切工程问题从根本上得到解决。不管怎样，我只是希望当下能认真的记录自己在前端工程领域的所见所想，与正在经历前端工程化改进，并被此过程困扰的同学交流心得。\r\n\r\n[欢迎一起探讨各自在前端开发中遇到的工程问题](https://github.com/fouber/blog/issues/8)\r\n\r\n目录\r\n\r\n* 系列专题\r\n    * [前端工程——基础篇](https://github.com/fouber/blog/issues/10)\r\n* 工程杂谈\r\n    * [浅谈前端集成解决方案](https://github.com/fouber/blog/issues/1)\r\n    * [前端工程与性能优化](https://github.com/fouber/blog/issues/3)\r\n    * [前端开发体系建设日记](https://github.com/fouber/blog/issues/2)\r\n    * [前端开发体与模块化框架](https://github.com/fouber/blog/issues/4)\r\n    * [大公司里怎样开发和部署前端代码？](https://github.com/fouber/blog/issues/6)\r\n    * [如何进行前端自动化测试？](https://github.com/fouber/blog/issues/7)\r\n    * [md5戳计算过程](https://github.com/fouber/blog/issues/5)\r\n* 职业发展\r\n    * [一个程序员的成长之路](https://github.com/fouber/blog/issues/41)\r\n* 示例项目\r\n    * [php版静态资源管理系统示例](https://github.com/fouber/static-resource-management-system-demo)\r\n    * [模块化开发组合php版静态资源管理示例](https://github.com/fouber/fis-php-md.js)\r\n    * [java版静态资源管理系统示例](https://github.com/fouber/fis-java-jsp)\r\n    * [静态资源缓存控制演示项目](https://github.com/fouber/static-resource-digest-project)\r\n* 业界实践\r\n    * [前端组件化开发实践](http://tech.meituan.com/frontend-component-practice.html) by 美团 \r\n    * [2015前端组件化框架之路](https://github.com/xufei/blog/issues/19) by [@民工精髓](http://weibo.com/sharpmaster)\r\n    * [前端工程之模块化](http://fex.baidu.com/blog/2014/03/fis-module/) by [@沈洪顺](http://weibo.com/u/1916384703)\r\n    * 前端xss防火墙系列文章 by [@ＥtherＤream](https://github.com/zjcqoo)\r\n        * [内联事件拦截](http://fex.baidu.com/blog/2014/06/xss-frontend-firewall-1/)\r\n        * [可疑模块拦截](http://fex.baidu.com/blog/2014/06/xss-frontend-firewall-2/)\r\n        * [无懈可击的钩子](http://fex.baidu.com/blog/2014/06/xss-frontend-firewall-3/)\r\n        * [天衣无缝的防护](http://fex.baidu.com/blog/2014/06/xss-frontend-firewall-4/)\r\n        * [整装待发](http://fex.baidu.com/blog/2014/06/xss-frontend-firewall-5)\r\n* 经典图书\r\n    * 《[High Performance Web Sites](http://book.douban.com/subject/2084131/)》（[高性能网站建设指南](http://book.douban.com/subject/3132277/)）\r\n    * 《[Even Faster Web Sites](http://book.douban.com/subject/3686503/)》（[高性能网站建设进阶指南](http://book.douban.com/subject/4719162/)）\r\n    * 《[High Performance Browser Networking](http://book.douban.com/subject/21866396/)》（[Web性能权威指南](http://book.douban.com/subject/25856314/)）\r\n* 经典文章\r\n    * [Best Practices for Speeding Up Your Web Site（雅虎35条）](https://developer.yahoo.com/performance/rules.html)\r\n    * [Facebook静态网页资源的管理和优化](http://v.youku.com/v_show/id_XMjI5OTUxMjE2.html) [[PDF](http://velocity.oreilly.com.cn/2010/ppts/VelocityChina2010Dec7StaticResource.pdf)] by [@David Wei](http://weibo.com/weixiaoliang9)\r\n    * [Facebook移动互联网应用的性能优化](http://v.youku.com/v_show/id_XMzUwOTQzMzA4.html) [[PDF](http://velocity.oreilly.com.cn/2011/ppts/MobilePerformanceVelocity2011_DavidWei.pdf)] by [@David Wei](http://weibo.com/weixiaoliang9)\r\n    * [PageSpeed Insights规则](https://developers.google.com/speed/docs/insights/rules?csw=1)\r\n    * [Mobile Analysis in PageSpeed Insights](https://developers.google.com/speed/docs/insights/mobile)\r\n    * Optimizing the Critical Rendering Path for Instant Mobile Websites [[slides](https://docs.google.com/presentation/d/1IRHyU7_crIiCjl0Gvue0WY3eY_eYvFQvSfwQouW9368/present?slide=id.p19),[video](https://www.youtube.com/watch?v=YV1nKLWoARQ)]\r\n    * Instant Mobile Websites: Techniques and Best Practices [[slides](http://storage.googleapis.com/io-2013/presentations/239-%20Instant%20Mobile%20Websites-%20Techniques%20and%20Best%20Practices.pdf), [video](https://www.youtube.com/watch?v=Bzw8-ZLpwtw)]\r\n    * [Critical Rendering Path（关键呈现路径）](https://developers.google.com/web/fundamentals/performance/critical-rendering-path/)\r\n    * [Optimizing Content Efficienc（优化内容效率）](https://developers.google.com/web/fundamentals/performance/optimizing-content-efficiency/?hl=zh-cn)\r\n    * [Rendering（渲染性能）](https://developers.google.com/web/fundamentals/performance/rendering/?hl=zh-cn)\r\n    * [How browsers work](http://taligarsiel.com/Projects/howbrowserswork1.htm)\r\n\r\n微博 [@前端农民工](http://www.weibo.com/fouber)\r\n', '2020-05-24 14:12:01', '转载别', 'https://cdn.colorhub.me/HZXLk-aflbxJQ0RuHQ0qFdurNIKW39MvvDm2yzXTh24/fill/0/500/ce/0/bG9jYWw6Ly8vM2Ev/MmQvZDhiZDU4ZjNl/OWY3YTNmZGQxMzQ0/ZGQwMzEwNjc2ZmRi/MWUxM2EyZC5qcGVn.jpg', '转载', b'1', b'1', b'1', '前端学习', '2020-05-24 14:12:01', 12, 1, 1);
INSERT INTO `t_blog` VALUES (2, b'0', b'0', '\r\n <h1 class=\"curproject-name\"> pd </h1> \r\n \r\n\r\n\r\n# 公共分类\r\n\r\n## 分页查询视频\r\n<a id=分页查询视频> </a>\r\n### 基本信息\r\n\r\n**Path：** /video/id\r\n\r\n**Method：** GET\r\n\r\n**接口描述：**\r\n<p>根据runnerid分页查询单个跑步者的视频</p>\r\n\r\n\r\n### 请求参数\r\n**Query**\r\n\r\n| 参数名称  |  是否必须 | 示例  | 备注  |\r\n| ------------ | ------------ | ------------ | ------------ |\r\n| page | 是  |  1 |  当前页数 |\r\n| order | 是  |  id |  以字段排序 |\r\n| runnerId | 是  |  跑步者id |  跑步人物的id |\r\n\r\n### 返回数据\r\n\r\n<table>\r\n  <thead class=\"ant-table-thead\">\r\n    <tr>\r\n      <th key=name>名称</th><th key=type>类型</th><th key=required>是否必须</th><th key=default>默认值</th><th key=desc>备注</th><th key=sub>其他信息</th>\r\n    </tr>\r\n  </thead><tbody className=\"ant-table-tbody\"><tr key=0-0><td key=0><span style=\"padding-left: 0px\"><span style=\"color: #8c8a8a\"></span> code</span></td><td key=1><span>integer</span></td><td key=2>非必须</td><td key=3></td><td key=4><span style=\"white-space: pre-wrap\">200-400-500</span></td><td key=5><p key=2><span style=\"font-weight: \'700\'\">format: </span><span>int32</span></p></td></tr><tr key=0-1><td key=0><span style=\"padding-left: 0px\"><span style=\"color: #8c8a8a\"></span> data</span></td><td key=1><span>object</span></td><td key=2>非必须</td><td key=3></td><td key=4><span style=\"white-space: pre-wrap\">响应数据</span></td><td key=5></td></tr><tr key=0-2><td key=0><span style=\"padding-left: 0px\"><span style=\"color: #8c8a8a\"></span> message</span></td><td key=1><span>string</span></td><td key=2>非必须</td><td key=3></td><td key=4><span style=\"white-space: pre-wrap\">success等</span></td><td key=5></td></tr>\r\n               </tbody>\r\n              </table>\r\n            \r\n## 注册跑步者\r\n<a id=注册跑步者> </a>\r\n### 基本信息\r\n\r\n**Path：** /runners/sign\r\n\r\n**Method：** POST\r\n\r\n**接口描述：**\r\n<p>人脸注册跑步者</p>\r\n\r\n\r\n### 请求参数\r\n**Headers**\r\n\r\n| 参数名称  | 参数值  |  是否必须 | 示例  | 备注  |\r\n| ------------ | ------------ | ------------ | ------------ | ------------ |\r\n| Content-Type  |  multipart/form-data | 是  |   |   |\r\n**Body**\r\n\r\n| 参数名称  | 参数类型  |  是否必须 | 示例  | 备注  |\r\n| ------------ | ------------ | ------------ | ------------ | ------------ |\r\n| id | text  |  是 |  人物id  |  跑步人物id |\r\n| account | text  |  是 |  test  |  账户名 |\r\n| password | text  |  是 |  123456  |  密码 |\r\n| sex | text  |  否 |  0  |  性别:(0男，1女) |\r\n| name | text  |  是 |  测试  |  姓名 |\r\n| roleType | text  |  是 |  角色id  |  角色id:对应动漫角色 |\r\n| runType | text  |  是 |  1  |  跑步模式:0自己跑-1明星陪跑 |\r\n| starId | text  |  否 |  明星id  |  陪跑人物id(跑步模式为明星陪跑) |\r\n| files | file  |  是 |  人脸照片  |  人脸照片集合 |\r\n\r\n\r\n\r\n### 返回数据\r\n\r\n<table>\r\n  <thead class=\"ant-table-thead\">\r\n    <tr>\r\n      <th key=name>名称</th><th key=type>类型</th><th key=required>是否必须</th><th key=default>默认值</th><th key=desc>备注</th><th key=sub>其他信息</th>\r\n    </tr>\r\n  </thead><tbody className=\"ant-table-tbody\"><tr key=0-0><td key=0><span style=\"padding-left: 0px\"><span style=\"color: #8c8a8a\"></span> code</span></td><td key=1><span>integer</span></td><td key=2>非必须</td><td key=3></td><td key=4><span style=\"white-space: pre-wrap\">200-400-500</span></td><td key=5><p key=2><span style=\"font-weight: \'700\'\">format: </span><span>int32</span></p></td></tr><tr key=0-1><td key=0><span style=\"padding-left: 0px\"><span style=\"color: #8c8a8a\"></span> data</span></td><td key=1><span>object</span></td><td key=2>非必须</td><td key=3></td><td key=4><span style=\"white-space: pre-wrap\">响应数据</span></td><td key=5></td></tr><tr key=0-2><td key=0><span style=\"padding-left: 0px\"><span style=\"color: #8c8a8a\"></span> message</span></td><td key=1><span>string</span></td><td key=2>非必须</td><td key=3></td><td key=4><span style=\"white-space: pre-wrap\">success等</span></td><td key=5></td></tr>\r\n               </tbody>\r\n              </table>\r\n            ', '2020-07-07 10:47:49', '222', 'https://cdn.colorhub.me/HZXLk-aflbxJQ0RuHQ0qFdurNIKW39MvvDm2yzXTh24/fill/0/500/ce/0/bG9jYWw6Ly8vM2Ev/MmQvZDhiZDU4ZjNl/OWY3YTNmZGQxMzQ0/ZGQwMzEwNjc2ZmRi/MWUxM2EyZC5qcGVn.jpg', '', b'1', b'0', b'0', '22', '2020-07-07 10:47:49', 4, 1, 1);

-- ----------------------------
-- Table structure for t_blog_tags
-- ----------------------------
DROP TABLE IF EXISTS `t_blog_tags`;
CREATE TABLE `t_blog_tags`  (
  `blogs_id` bigint(20) NOT NULL,
  `tags_id` bigint(20) NOT NULL,
  INDEX `FK5feau0gb4lq47fdb03uboswm8`(`tags_id`) USING BTREE,
  INDEX `FKh4pacwjwofrugxa9hpwaxg6mr`(`blogs_id`) USING BTREE,
  CONSTRAINT `FK5feau0gb4lq47fdb03uboswm8` FOREIGN KEY (`tags_id`) REFERENCES `t_tag` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `FKh4pacwjwofrugxa9hpwaxg6mr` FOREIGN KEY (`blogs_id`) REFERENCES `t_blog` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of t_blog_tags
-- ----------------------------
INSERT INTO `t_blog_tags` VALUES (1, 1);
INSERT INTO `t_blog_tags` VALUES (2, 1);

-- ----------------------------
-- Table structure for t_comment
-- ----------------------------
DROP TABLE IF EXISTS `t_comment`;
CREATE TABLE `t_comment`  (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `admin_comment` bit(1) NOT NULL,
  `avatar` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `content` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `create_time` datetime(0) NULL DEFAULT NULL,
  `email` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `nickname` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `blog_id` bigint(20) NULL DEFAULT NULL,
  `parent_comment_id` bigint(20) NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `FKke3uogd04j4jx316m1p51e05u`(`blog_id`) USING BTREE,
  INDEX `FK4jj284r3pb7japogvo6h72q95`(`parent_comment_id`) USING BTREE,
  CONSTRAINT `FK4jj284r3pb7japogvo6h72q95` FOREIGN KEY (`parent_comment_id`) REFERENCES `t_comment` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `FKke3uogd04j4jx316m1p51e05u` FOREIGN KEY (`blog_id`) REFERENCES `t_blog` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of t_comment
-- ----------------------------

-- ----------------------------
-- Table structure for t_photo
-- ----------------------------
DROP TABLE IF EXISTS `t_photo`;
CREATE TABLE `t_photo`  (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `create_time` datetime(0) NULL DEFAULT NULL,
  `dz` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `message` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 2 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of t_photo
-- ----------------------------
INSERT INTO `t_photo` VALUES (1, '2020-05-24 14:15:08', 'http://p7.qhimg.com//bdm//1600_900_85//t01a605f895246d4469.jpg', '学习呢正在');

-- ----------------------------
-- Table structure for t_tag
-- ----------------------------
DROP TABLE IF EXISTS `t_tag`;
CREATE TABLE `t_tag`  (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 2 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of t_tag
-- ----------------------------
INSERT INTO `t_tag` VALUES (1, '学习吧');

-- ----------------------------
-- Table structure for t_type
-- ----------------------------
DROP TABLE IF EXISTS `t_type`;
CREATE TABLE `t_type`  (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 2 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of t_type
-- ----------------------------
INSERT INTO `t_type` VALUES (1, '前端学习');

-- ----------------------------
-- Table structure for t_user
-- ----------------------------
DROP TABLE IF EXISTS `t_user`;
CREATE TABLE `t_user`  (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `avatar` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `create_time` datetime(0) NULL DEFAULT NULL,
  `email` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `nickname` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `password` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `phone` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `type` int(11) NULL DEFAULT NULL,
  `update_time` datetime(0) NULL DEFAULT NULL,
  `username` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 2 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of t_user
-- ----------------------------
INSERT INTO `t_user` VALUES (1, 'http://p8.qhimg.com//bdm//1280_1024_85//t01b458779c4f05fb9e.jpg', '2020-05-24 12:57:01', '1280488753', '王一维', 'e10adc3949ba59abbe56e057f20f883e', '15328561260', 1, '2020-05-24 12:57:28', 'admin');

-- ----------------------------
-- Table structure for t_yl
-- ----------------------------
DROP TABLE IF EXISTS `t_yl`;
CREATE TABLE `t_yl`  (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `title` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `url` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 2 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of t_yl
-- ----------------------------
INSERT INTO `t_yl` VALUES (1, '乐山中德促进中心', 'http://www.sczdkc.cn/');

SET FOREIGN_KEY_CHECKS = 1;
