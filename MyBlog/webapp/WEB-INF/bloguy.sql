/*
Navicat MySQL Data Transfer

Source Server         : local
Source Server Version : 50520
Source Host           : localhost:3306
Source Database       : bloguy

Target Server Type    : MYSQL
Target Server Version : 50520
File Encoding         : 65001

Date: 2013-11-07 13:43:34
*/

SET FOREIGN_KEY_CHECKS=0;
-- ----------------------------
-- Table structure for `blogs`
-- ----------------------------
DROP TABLE IF EXISTS `blogs`;
CREATE TABLE `blogs` (
  `BLOG_ID` int(11) NOT NULL AUTO_INCREMENT,
  `TITLE` varchar(100) NOT NULL,
  `CONTENT` longtext NOT NULL,
  `POST_TIME` datetime NOT NULL,
  `AUTHOR_ID` int(11) NOT NULL,
  `TAGS` varchar(100) DEFAULT '',
  `FOLDER_ID` int(11) NOT NULL DEFAULT '0',
  `COMMENT_COUNT` int(11) NOT NULL DEFAULT '0' COMMENT '评论数',
  `CLICK_TIMES` int(11) NOT NULL DEFAULT '0',
  `UPDATE_TIME` datetime NOT NULL,
  PRIMARY KEY (`BLOG_ID`)
) ENGINE=InnoDB AUTO_INCREMENT=19 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of blogs
-- ----------------------------
INSERT INTO blogs VALUES ('1', 'First Blog', '<strong>CoolBlue</strong> is a free, W3C-compliant, CSS-based website template\r\n					by <a href=\"http://www.cssmoban.com/\">styleshout.com</a>. This work is\r\n					distributed under the <a rel=\"license\" href=\"http://creativecommons.org/licenses/by/2.5/\">\r\n					Creative Commons Attribution 2.5  License</a>, which means that you are free to\r\n					use and modify it for any purpose. All I ask is that you give me credit by including a <strong>link back</strong> to\r\n					<a href=\"http://www.cssmoban.com/\">my website</a>.\r\n               </p>\r\n\r\n               <p>\r\n               You can find more of my free template designs at <a href=\"http://www.cssmoban.com/\">my website</a>.\r\n					For premium commercial designs, you can check out\r\n               <a href=\"#\" title=\"Website Templates\">DreamTemplate.com</a>.\r\n					</p>\r', '2012-11-20 16:35:40', '1', 'IT;JAVA;WEB;中国', '1', '10', '251', '2012-11-24 14:04:04');
INSERT INTO blogs VALUES ('2', '第二篇文章', '我操，我写不出来啊', '2012-11-23 11:45:25', '1', 'IT;JAVA', '2', '0', '7', '2012-11-24 14:04:07');
INSERT INTO blogs VALUES ('3', 'third', '哎哟不错哦，要不要看看', '2012-11-23 13:33:30', '1', 'IT', '2', '0', '2', '2012-11-24 14:04:09');
INSERT INTO blogs VALUES ('4', '这是什么', '啊哈哈', '2012-11-23 13:34:03', '1', 'JAVA', '1', '0', '27', '2012-11-24 14:04:11');
INSERT INTO blogs VALUES ('5', '不了歌是把', '阿士大夫', '2012-11-23 13:34:31', '1', 'IT', '1', '0', '57', '2012-11-24 14:04:13');
INSERT INTO blogs VALUES ('6', '呵呵', '呵呵', '2012-11-23 13:34:55', '1', 'JAVA', '1', '1', '45', '2012-11-24 14:04:17');
INSERT INTO blogs VALUES ('7', 'adsf', '<p>asdf   <div style=\"padding-bottom: 0px; margin: 0px; padding-left: 0px; padding-right: 0px; display: inline; float: none; padding-top: 0px\" id=\"scid:0767317B-992E-4b12-91E0-4F059A8CECA8:ff290b7c-f7b1-452c-a944-86a29e0103f5\" class=\"wlWriterEditableSmartContent\">Technorati 标签: <a href=\"http://technorati.com/tags/haha\" rel=\"tag\">haha</a>,<a href=\"http://technorati.com/tags/ad\" rel=\"tag\">ad</a></div></p>', '2012-11-25 23:22:20', '1', '', '1', '0', '4', '2012-11-25 23:22:20');
INSERT INTO blogs VALUES ('8', '阿斯蒂芬', '<p><u><em><strong><strike><a href=\"http://www.baidu.com\">ASDF啊啊</a></strike></strong></em></u></p>  <blockquote>   <p><sub><font style=\"background-color: #ffff00\">舅舅家空间看<a href=\"http://localhost//static/images/upload/a.jpg\"><img style=\"background-image: none; border-bottom: 0px; border-left: 0px; padding-left: 0px; padding-right: 0px; display: inline; border-top: 0px; border-right: 0px; padding-top: 0px\" title=\"5a083703-9055-4405-b044-2555239299be_thumb_thumb_thumb_thumb\" border=\"0\" alt=\"5a083703-9055-4405-b044-2555239299be_thumb_thumb_thumb_thumb\" src=\"http://localhost//static/images/upload/a.jpg\" width=\"244\" height=\"164\" /></a></font></sub></p> </blockquote>  <p><sup><font color=\"#ff0000\">sADS</font></sup></p>  <ul>   <li><sup></sup><sup>1</sup></li>    <li><sup>2</sup></li>    <li><sup>3</sup></li> </ul>', '2012-11-26 19:05:13', '1', '', '1', '0', '1', '2012-11-26 19:05:43');
INSERT INTO blogs VALUES ('9', '标签', '<div style=\"padding-bottom: 0px; margin: 0px; padding-left: 0px; padding-right: 0px; display: inline; float: none; padding-top: 0px\" id=\"scid:9D7513F9-C04C-4721-824A-2B34F0212519:b79dcd3e-06e7-43f4-b6a6-34ded4649361\" class=\"wlWriterEditableSmartContent\"><pre class=\"brush: java; gutter: true; first-line: 1; tab-size: 4;  toolbar: true;  width: 547px; height: 360px;\" style=\" width: 547px; height: 360px;overflow: auto;\">@RequestMapping(&quot;/&quot;)\npublic String index(Model model, BaseCommand command) {\n	try {\n		commonIssues(model, command);\n		model.addAttribute(&quot;pageType&quot;, &quot;index&quot;);\n	} catch (Exception e) {\n		return &quot;error404&quot;;\n	}\n	return &quot;index&quot;;\n}</pre><!-- Code inserted with Steve Dunn\'s Windows Live Writer Code Formatter Plugin.  http://dunnhq.com --></div>', '2012-11-26 19:07:00', '1', '', '1', '0', '19', '2012-11-26 19:31:59');
INSERT INTO blogs VALUES ('10', 'title', '<p>\r\n	<p>\r\n		KindEditor\r\n	</p>\r\n	<p>\r\n		<img src=\"http://localhost/static/js/kindeditor/plugins/emoticons/images/1.gif\" border=\"0\" alt=\"\" />\r\n	</p>\r\n	<p>\r\n		<img src=\"http://localhost/static/images/upload/20121127193255_746.jpg\" alt=\"\" />\r\n	</p>\r\n	<p>\r\n		<table cellpadding=\"2\" cellspacing=\"0\" border=\"1\" bordercolor=\"#000000\" style=\"width:772px;background-color:#E53333;\">\r\n			<tbody>\r\n				<tr>\r\n					<td>\r\n						<br />\r\n					</td>\r\n					<td>\r\n						<br />\r\n					</td>\r\n				</tr>\r\n				<tr>\r\n					<td>\r\n						<br />\r\n					</td>\r\n					<td>\r\n						<br />\r\n					</td>\r\n				</tr>\r\n				<tr>\r\n					<td>\r\n						<br />\r\n					</td>\r\n					<td>\r\n						<br />\r\n					</td>\r\n				</tr>\r\n			</tbody>\r\n		</table>\r\n	</p>\r\n<pre class=\"brush:java;toolbar: false; auto-links: false;\">public void Hello(String str){\r\n    System.out.println(str);\r\n    return\r\n}</pre>\r\n<br class=\"Apple-interchange-newline\" />\r\n</p>', '2012-11-27 20:00:46', '1', 'JAVA;WEB', '0', '0', '3', '2012-11-27 20:00:46');
INSERT INTO blogs VALUES ('11', 'title', '<pre class=\"brush:java;toolbar: false; auto-links: false;\">	@SuppressWarnings(\"unchecked\")\r\n	@Override\r\n	public ListselectCommentsByBlogIdAndBaseAndRank(long id,\r\n			int base, int range) {\r\n		Map<string, long=\"\"> map = new HashMap<string, long=\"\">();\r\n		map.put(\"id\", Long.valueOf(id));\r\n		map.put(\"base\", Long.valueOf(base));\r\n		map.put(\"range\", Long.valueOf(range));\r\n		return (List) getSqlMapClientTemplate().queryForList(\r\n				\"COMMENTS.selectCommentsByBlogIdAndBaseAndRank\", map);\r\n	}</string,></string,></pre>', '2012-11-27 20:03:58', '1', 'JAVA;WEB', '0', '0', '1', '2012-11-27 20:03:58');
INSERT INTO blogs VALUES ('12', 'title', 'KindEditor\r\n<pre class=\"brush:java;toolbar: true; auto-links: false;\">	@SuppressWarnings(\"unchecked\")\r\n	@Override\r\n	public ListselectBlogsByBaseAndRange(int base, int range) {\r\n		Map<string, object=\"\"> map = new HashMap<string, object=\"\">();\r\n		map.put(\"base\", base);\r\n		map.put(\"range\", range);\r\n		return getSqlMapClientTemplate().queryForList(\r\n				\"BLOGS.selectBlogsByBaseAndRange\", map);\r\n	}</string,></string,></pre>', '2012-11-27 20:09:04', '1', 'JAVA;WEB', '0', '0', '0', '2012-11-27 20:09:04');
INSERT INTO blogs VALUES ('13', 'title', '<pre class=\"brush:java;toolbar: true; auto-links: false;\">	@SuppressWarnings(\"unchecked\")\r\n	@Override\r\n	public List<commentpojo> selectCommentsByBlogIdAndBaseAndRank(long id,\r\n			int base, int range) {\r\n		Map<string, long=\"\"> map = new HashMap<string, long=\"\">();\r\n		map.put(\"id\", Long.valueOf(id));\r\n		map.put(\"base\", Long.valueOf(base));\r\n		map.put(\"range\", Long.valueOf(range));\r\n		return (List<commentpojo>) getSqlMapClientTemplate().queryForList(\r\n				\"COMMENTS.selectCommentsByBlogIdAndBaseAndRank\", map);\r\n	}\r\n</commentpojo></string,></string,></commentpojo></pre>', '2012-11-27 20:28:10', '1', 'JAVA;WEB', '0', '0', '0', '2012-11-27 20:28:10');
INSERT INTO blogs VALUES ('14', 'title', '<pre class=\"brush:java;toolbar: true; auto-links: false;\">	@SuppressWarnings(\"unchecked\")\r\n	@Override\r\n	public List<commentpojo> selectCommentsByBlogIdAndBaseAndRank(long id,\r\n			int base, int range) {\r\n		Map<string, long=\"\"> map = new HashMap<string, long=\"\">();\r\n		map.put(\"id\", Long.valueOf(id));\r\n		map.put(\"base\", Long.valueOf(base));\r\n		map.put(\"range\", Long.valueOf(range));\r\n		return (List<commentpojo>) getSqlMapClientTemplate().queryForList(\r\n				\"COMMENTS.selectCommentsByBlogIdAndBaseAndRank\", map);\r\n	}\r\n</commentpojo></string,></string,></commentpojo></pre>', '2012-11-27 20:29:25', '1', 'JAVA;WEB', '0', '0', '0', '2012-11-27 20:29:25');
INSERT INTO blogs VALUES ('15', 'title', '<pre class=\"brush:java;toolbar: true; auto-links: false;\">	@SuppressWarnings(\"unchecked\")\r\n	@Override\r\n	public List&lt;CommentPojo&gt; selectCommentsByBlogIdAndBaseAndRank(long id,\r\n			int base, int range) {\r\n		Map&lt;String, Long&gt; map = new HashMap&lt;String, Long&gt;();\r\n		map.put(\"id\", Long.valueOf(id));\r\n		map.put(\"base\", Long.valueOf(base));\r\n		map.put(\"range\", Long.valueOf(range));\r\n		return (List&lt;CommentPojo&gt;) getSqlMapClientTemplate().queryForList(\r\n				\"COMMENTS.selectCommentsByBlogIdAndBaseAndRank\", map);\r\n	}</pre>\r\nKindEditor', '2012-11-27 20:45:56', '1', 'JAVA;WEB', '0', '0', '0', '2012-11-27 20:45:56');
INSERT INTO blogs VALUES ('16', 'title', '<p>\r\n	<img src=\"http://localhost/static/js/kindeditor/plugins/emoticons/images/0.gif\" border=\"0\" alt=\"\" />\r\n</p>\r\n<p>\r\n<pre class=\"brush:java;toolbar: true; auto-links: false;\">	private void commonIssues(Model model, BaseCommand command) {\r\n		List&lt;FolderPojo&gt; folderList = folderService.getAllFolders();\r\n		List&lt;BlogPojo&gt; popularBlogs = blogService.getPopularBlogs();\r\n		List&lt;CommentPojo&gt; latestComments = commentServce.getLatestComments();\r\n		User user = command.getBaseUser();\r\n		User currenUser = command.getBaseUser();\r\n\r\n		model.addAttribute(\"folderList\", folderList);\r\n		model.addAttribute(\"popularBlogs\", popularBlogs);\r\n		model.addAttribute(\"latestComments\", latestComments);\r\n		model.addAttribute(\"user\", user);\r\n		model.addAttribute(\"currentUser\", currenUser);\r\n	}//这是注释</pre>\r\n<img src=\"http://www.baidu.com/img/baidu_sylogo1.gif\" alt=\"\" />\r\n</p>', '2012-11-30 21:18:59', '1', 'JAVA;WEB', '0', '0', '0', '2012-11-30 21:18:59');
INSERT INTO blogs VALUES ('17', '张俊雪是傻逼', '<p>大的<strong>萨芬</strong></p>', '2013-10-19 15:24:34', '1', null, '1', '0', '0', '2013-10-19 15:24:34');
INSERT INTO blogs VALUES ('18', 'hello', '<p><em>阿<font color=\"#000000\">斯顿法师打发</font></em></p>  <p><a href=\"http://localhost//static/images/upload/a.jpg\"><img style=\"background-image: none; border-bottom: 0px; border-left: 0px; padding-left: 0px; padding-right: 0px; display: inline; border-top: 0px; border-right: 0px; padding-top: 0px\" title=\"001\" border=\"0\" alt=\"001\" src=\"http://localhost//static/images/upload/a.jpg\" width=\"244\" height=\"154\" /></a></p>', '2013-11-03 00:40:45', '1', null, '1', '0', '1', '2013-11-03 00:40:45');

-- ----------------------------
-- Table structure for `comments`
-- ----------------------------
DROP TABLE IF EXISTS `comments`;
CREATE TABLE `comments` (
  `COMMENT_ID` int(11) NOT NULL AUTO_INCREMENT,
  `COMMENT_USER_ID` int(11) NOT NULL,
  `CONTENT` longtext NOT NULL,
  `TO_TYPE` varchar(1) NOT NULL DEFAULT '0' COMMENT '0:文章;1:评论',
  `TO_ID` int(11) NOT NULL COMMENT '评论的文章（评论）的ID',
  `POST_TIME` datetime NOT NULL,
  `BLOG_ID` int(11) NOT NULL,
  PRIMARY KEY (`COMMENT_ID`)
) ENGINE=InnoDB AUTO_INCREMENT=22 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of comments
-- ----------------------------
INSERT INTO comments VALUES ('1', '1', '欢迎大家来访', '0', '1', '2012-11-21 10:44:19', '1');
INSERT INTO comments VALUES ('2', '1', '子级评论', '1', '1', '2012-11-22 09:17:25', '1');
INSERT INTO comments VALUES ('3', '1', '平行子级评论1', '1', '1', '2012-11-22 10:44:36', '1');
INSERT INTO comments VALUES ('4', '1', '孙子评论', '1', '2', '2012-11-22 10:45:06', '1');
INSERT INTO comments VALUES ('15', '1', '呵呵', '0', '1', '2012-11-23 10:36:55', '1');
INSERT INTO comments VALUES ('16', '1', '尼玛', '1', '3', '2012-11-23 10:37:03', '1');
INSERT INTO comments VALUES ('17', '1', '傻逼', '1', '3', '2012-11-23 10:37:11', '1');
INSERT INTO comments VALUES ('18', '1', '循环', '1', '17', '2012-11-23 10:37:27', '1');
INSERT INTO comments VALUES ('19', '1', '循环', '1', '18', '2012-11-23 10:37:35', '1');
INSERT INTO comments VALUES ('20', '1', '循环', '1', '18', '2012-11-23 10:40:38', '1');
INSERT INTO comments VALUES ('21', '1', '我操。。', '0', '6', '2012-11-23 14:20:40', '6');

-- ----------------------------
-- Table structure for `folders`
-- ----------------------------
DROP TABLE IF EXISTS `folders`;
CREATE TABLE `folders` (
  `FOLDER_ID` int(11) NOT NULL AUTO_INCREMENT,
  `FOLDER_NAME` varchar(100) NOT NULL,
  `FOLDER_USER_ID` int(11) NOT NULL,
  `ADD_TIME` datetime NOT NULL,
  `BLOG_COUNT` int(11) NOT NULL DEFAULT '0',
  PRIMARY KEY (`FOLDER_ID`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of folders
-- ----------------------------
INSERT INTO folders VALUES ('1', '未归档', '0', '2012-11-01 11:42:38', '9');
INSERT INTO folders VALUES ('2', '2012年归档', '0', '2012-11-21 00:00:00', '2');

-- ----------------------------
-- Table structure for `tags`
-- ----------------------------
DROP TABLE IF EXISTS `tags`;
CREATE TABLE `tags` (
  `tag_id` int(11) NOT NULL AUTO_INCREMENT,
  `tag_name` varchar(10) NOT NULL,
  `blog_count` int(11) NOT NULL DEFAULT '1',
  `add_time` datetime NOT NULL,
  `update_time` datetime NOT NULL,
  PRIMARY KEY (`tag_id`),
  UNIQUE KEY `tag_index` (`tag_name`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of tags
-- ----------------------------
INSERT INTO tags VALUES ('1', 'JAVA', '11', '2012-11-20 13:43:22', '2012-11-30 21:18:59');
INSERT INTO tags VALUES ('2', 'WEB', '8', '2012-11-24 13:43:29', '2012-11-30 21:18:59');
INSERT INTO tags VALUES ('3', '中国', '1', '2012-11-23 13:43:32', '2012-11-24 13:43:49');
INSERT INTO tags VALUES ('5', 'IT', '4', '2012-11-21 13:43:35', '2012-11-24 13:43:51');

-- ----------------------------
-- Table structure for `users`
-- ----------------------------
DROP TABLE IF EXISTS `users`;
CREATE TABLE `users` (
  `USER_ID` int(11) NOT NULL AUTO_INCREMENT,
  `USER_NAME` varchar(50) NOT NULL DEFAULT '',
  `PASSWORD` varchar(200) NOT NULL,
  `AVATARURL` varchar(500) DEFAULT 'avatar.jpg',
  `INTRO` varchar(500) DEFAULT '这个人很懒，什么都没留下',
  `EMAIL` varchar(100) DEFAULT NULL,
  `ADD_TIME` datetime NOT NULL,
  `UPDATE_TIME` datetime NOT NULL,
  PRIMARY KEY (`USER_ID`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of users
-- ----------------------------
INSERT INTO users VALUES ('1', 'BingLuo', '2308720', 'avatar.jpg', '我只想说狡辩一下我并不懒。。。“这个人很懒...”这句话貌似已经沿用了十几年了吧？。。。', null, '2012-11-16 13:43:07', '2012-11-24 13:43:15');
INSERT INTO users VALUES ('2', 'HEHE', 'HEHE', 'avatar.jpg', '这个人很懒，什么都没留下', null, '2012-11-30 20:10:50', '2012-11-30 20:10:50');
DELIMITER ;;
CREATE TRIGGER `trg_insert_blog` AFTER INSERT ON `blogs` FOR EACH ROW BEGIN
	set @x=NEW.FOLDERID;
    update FOLDERS set BLOG_COUNT = BLOG_COUNT +1 where FOLDERID= @x;
END
;;
DELIMITER ;
DELIMITER ;;
CREATE TRIGGER `trg_insert_comment` AFTER INSERT ON `comments` FOR EACH ROW BEGIN
	set @x=NEW.BLOG_ID;
    update blogs set comment_count = comment_count+1 where blogId = @x;
END
;;
DELIMITER ;
