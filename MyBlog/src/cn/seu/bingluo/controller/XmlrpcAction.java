package cn.seu.bingluo.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang.StringUtils;
import org.apache.xmlrpc.XmlRpcException;
import org.apache.xmlrpc.server.PropertyHandlerMapping;
import org.apache.xmlrpc.server.XmlRpcServerConfigImpl;
import org.apache.xmlrpc.webserver.XmlRpcServletServer;

import cn.seu.bingluo.core.SystemContainer;
import cn.seu.bingluo.entity.Blog;
import cn.seu.bingluo.entity.BlogPojo;
import cn.seu.bingluo.entity.Folder;
import cn.seu.bingluo.entity.FolderPojo;
import cn.seu.bingluo.entity.User;
import cn.seu.bingluo.service.BlogService;
import cn.seu.bingluo.service.FolderService;
import cn.seu.bingluo.service.StorageService;
import cn.seu.bingluo.service.UserService;
import cn.seu.bingluo.util.LinkTool;

/**
 * 用于支持使用 XMLRPC 接口发布博客
 * 
 * @author Winter Lau
 * @date 2012-1-14 下午5:35:20
 */
public class XmlrpcAction {
	private UserService userService = (UserService) SystemContainer
			.lookup("userService");
	private BlogService blogService = (BlogService) SystemContainer
			.lookup("blogService");
	private FolderService folderService = (FolderService) SystemContainer
			.lookup("folderService");

	/**
	 * 返回某篇文章内容
	 * 
	 * @param postid
	 * @param username
	 * @param pwd
	 * @return
	 * @throws XmlRpcException
	 */
	public Object getPost(String postid, String username, String pwd)
			throws XmlRpcException {
		final User user = login(username, pwd);
		if (user == null) {
			return loginError();
		}

		final Blog blog = blogService.getBlogById(Long.valueOf(postid));
		final String url = LinkTool.blog(blog.getBlogId());
		final Folder folder = folderService.getFolderById(blog.getFolderId());

		return new HashMap<String, Object>() {
			{
				put("userid", blog.getAuthorId());
				put("dateCreated", blog.getPostTime());
				put("postid", blog.getBlogId());
				put("description", blog.getContent());
				put("title", blog.getTitle());
				put("link", LinkTool.blog(blog.getBlogId()));
				put("permaLink", LinkTool.blog(blog.getBlogId()));
				put("mt_excerpt", "");
				put("mt_text_more", "");
				put("mt_allow_comments", "1");
				put("mt_allow_pings", "0");
				put("mt_convert_breaks", "");
				put("mt_keywords ", blog.getTags());
			}
		};
	}

	/**
	 * 上传媒体，返回 UrlData
	 * 
	 * @param blogid
	 * @param username
	 * @param pwd
	 * @param file
	 * @return
	 * @throws IOException
	 * @throws XmlRpcException
	 */
	@SuppressWarnings("rawtypes")
	public Object newMediaObject(String blogid, String username, String pwd,
			HashMap file) throws IOException, XmlRpcException {
		final User user = login(username, pwd);
		if (user == null) {
			return loginError();
		}

		byte[] bits = (byte[]) file.get("bits");
		String name = file.get("name").toString();// Windows-Live-Writer/123123_A453/file_1_8.jpg
		String type = file.get("type").toString();// image/jpeg

		if (!StringUtils.startsWith(type, "image/")) {
			return new HashMap<String, Object>() {
				{
					put("faultCode", HttpServletResponse.SC_FORBIDDEN);
					put("faultString", "error:img_file_not_accept");
				}
			};
		}
		String uri = StorageService.storeImage(bits, "");

		final String url = LinkTool.image(uri);
		return new HashMap<String, String>() {
			{
				put("url", url);
			}
		};
		// RequestContext ctx = RequestContext.get();
		// final User user = login(username, pwd, ctx.ip());
		// if (user == null)
		// return loginError();
		//
		// byte[] bits = (byte[]) file.get("bits");
		// String name = file.get("name").toString();//
		// Windows-Live-Writer/123123_A453/file_1_8.jpg
		// String type = file.get("type").toString();// image/jpeg
		//
		// if (!StringUtils.startsWith(type, "image/")) {
		// return new HashMap<String, Object>() {
		// {
		// put("faultCode", HttpServletResponse.SC_FORBIDDEN);
		// put("faultString", ResourceUtils.getString("error",
		// "img_file_not_accept"));
		// }
		// };
		// }
		//
		// String uri = StorageService.IMAGES.save(bits,
		// FilenameUtils.getExtension(name));
		//
		// final String url = LinkTool.upload("img/" + uri);
		// return new HashMap<String, String>() {
		// {
		// put("url", url);
		// }
		// };
	}

	/**
	 * 发表文章，返回字符串为文章ID
	 * 
	 * @param blogid
	 * @param username
	 * @param pwd
	 * @param post
	 * @param publish
	 * @return
	 * @throws XmlRpcException
	 */
	@SuppressWarnings("rawtypes")
	public Object newPost(String blogid, String username, String pwd,
			HashMap post, boolean publish) throws XmlRpcException {
		final User user = userService.logon(username, pwd);
		if (user == null) {
			return loginError();
		}
		Blog blog = new Blog();
		blog.setAuthorId(user.getUserId());
		blog.setTitle((String) post.get("title"));
		blog.setContent((String) post.get("description"));
		blog.setTags((String) post.get("tags"));
		HashMap source = (HashMap) post.get("source");
		Object[] categories = (Object[]) post.get("categories");
		List<FolderPojo> folders = folderService
				.getAllFolders(user.getUserId());
		if (categories != null && categories.length > 0) {
			boolean catalog_find = false;
			for (FolderPojo folder : folders) {
				for (Object c : categories) {
					if (StringUtils.equalsIgnoreCase(folder.getFolderName(),
							(String) c)) {
						blog.setFolderId(folder.getFolderId());
						catalog_find = true;
						break;
					}
				}
				if (catalog_find) {
					break;
				}
			}
		} else {
			blog.setFolderId(folders.get(0).getFolderId());
		}

		return blogService.postBlog(blog);
	}

	/**
	 * 删除文章
	 * 
	 * @param appKey
	 * @param postid
	 * @param username
	 * @param pwd
	 * @param publish
	 * @return
	 * @throws XmlRpcException
	 */
	public Object deletePost(String appKey, String postid, String username,
			String pwd, boolean publish) throws XmlRpcException {
		final User user = userService.logon(username, pwd);
		if (user == null) {
			return loginError();
		}
		Blog blog = blogService.getBlogById(Long.valueOf(postid));
		if (blog.getAuthorId() != user.getUserId()) {
			return false;
		}
		blogService.deleteBlog(blog.getBlogId());
		return true;
	}

	/**
	 * 编辑文章
	 * 
	 * @param postid
	 * @param username
	 * @param pwd
	 * @param post
	 * @param publish
	 * @return
	 * @throws XmlRpcException
	 */
	@SuppressWarnings("rawtypes")
	public Object editPost(String postid, String username, String pwd,
			HashMap post, boolean publish) throws XmlRpcException {
		final User user = login(username, pwd);
		if (user == null) {
			return loginError();
		}

		Blog blog = blogService.getBlogById(Long.valueOf(postid));
		if (blog == null || blog.getAuthorId() != user.getUserId()) {
			return false;
		}
		blog.setTitle((String) post.get("title"));
		blog.setContent((String) post.get("description"));

		return blogService.updateBlog(blog);
	}

	/**
	 * 获取博客信息
	 * 
	 * @param key
	 * @param username
	 * @param pwd
	 * @return
	 * @throws XmlRpcException
	 */
	public Object getUsersBlogs(String key, String username, String pwd)
			throws XmlRpcException {
		final User user = login(username, pwd);
		if (user == null) {
			return loginError();
		}
		return new HashMap[] { new HashMap<String, Object>() {
			{
				put("blogid", user.getUserId());
				put("blogName", user.getUserName() + "的博客");
				put("url", LinkTool.user(user.getUserId()));
			}
		} };
	}

	public Object getTags(String blogid, String username, String pwd) {
		System.out.println("getTags");
		return null;
	}

	/**
	 * 获取分类信息
	 * 
	 * @param username
	 * @param pwd
	 * @return
	 * @throws XmlRpcException
	 */
	public Object getCategories(String blogid, String username, String pwd)
			throws XmlRpcException {
		final User user = login(username, pwd);
		if (user == null) {
			return loginError();
		}

		List<FolderPojo> folders = folderService
				.getAllFolders(user.getUserId());
		HashMap[] results = new HashMap[folders.size()];
		for (int i = 0; i < folders.size(); i++) {
			final FolderPojo folder = folders.get(i);
			results[i] = new HashMap<String, Object>() {
				{
					put("categoryid", folder.getFolderId());
					put("title", folder.getFolderName());
					put("description", "");
					put("htmlUrl", LinkTool.folder(folder.getFolderId()));
					put("rssUrl", LinkTool.folder(folder.getFolderId()));
				}
			};
		}
		return results;
	}

	/**
	 * 获取文章列表
	 * 
	 * @param blogid
	 * @param username
	 * @param pwd
	 * @param numberOfPosts
	 * @return
	 * @throws XmlRpcException
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public Object getRecentPosts(String blogid, String username, String pwd,
			int numberOfPosts) throws XmlRpcException {
		final User user = login(username, pwd);
		if (user == null) {
			return loginError();
		}

		List<BlogPojo> blogs = blogService.getBlogsByPageNumAndRange(0, 100);
		HashMap[] results = new HashMap[blogs.size()];
		for (int i = 0; i < blogs.size(); i++) {
			final Blog blog = blogs.get(i);
			final String url = LinkTool.blog(Long.valueOf(blogid));
			final FolderPojo folder = folderService.getFolderById(blog
					.getFolderId());
			results[i] = new HashMap<String, Object>() {
				{
					put("dateCreated", blog.getPostTime());
					put("userid", blog.getAuthorId());
					put("postid", blog.getBlogId());
					put("description", blog.getContent());
					put("title", blog.getTitle());
					put("link", LinkTool.blog(blog.getBlogId()));
					put("permaLink", LinkTool.blog(blog.getBlogId()));
					put("categories", new ArrayList<String>() {
						{
							add(folder.getFolderName());
						}
					});
					put("mt_excerpt", "");
					put("mt_text_more", "");
					put("mt_allow_comments", 1);
					put("mt_allow_pings", 0);
					put("mt_keywords", blog.getTags());
				}
			};
		}
		return results;
	}

	/**
	 * 新建分类
	 * 
	 * @param blogid
	 * @param username
	 * @param pwd
	 * @param category
	 * @return
	 * @throws XmlRpcException
	 */
	@SuppressWarnings("rawtypes")
	public Object newCategory(String blogid, String username, String pwd,
			HashMap category) throws XmlRpcException {
		final User user = login(username, pwd);
		if (user == null) {
			return loginError();
		}
		final String name = (String) category.get("name");
		if (folderService.isExistFolderName(name, user.getUserId())) {
			return new HashMap<String, Object>() {
				{
					put("faultCode", HttpServletResponse.SC_FORBIDDEN);
					put("faultString", "error:blog_catalog_name_exists " + name);
				}
			};
		}

		Folder folder = new Folder();
		folder.setFolderName(name);
		folder.setFolderUserId(user.getUserId());
		return folderService.createFolder(folder);
	}

	/**
	 * 判断访问者的身份
	 * 
	 * @param username
	 * @param pwd
	 * @param ip
	 * @return
	 */
	private User login(String username, String pwd) {
		return userService.logon(username, pwd);
	}

	/**
	 * 返回登录错误提示信息
	 * 
	 * @return
	 * @throws XmlRpcException
	 */
	private HashMap<String, Object> loginError() throws XmlRpcException {
		return new HashMap<String, Object>() {
			{
				put("faultCode", HttpServletResponse.SC_FORBIDDEN);
				put("faultString", "error:user_login_failed");
			}
		};
		/**
		 * return new HashMap<String, Object>(){{ put("faultCode",
		 * HttpServletResponse.SC_FORBIDDEN); put("faultString",
		 * ResourceUtils.getString("error", "user_login_failed")); }};
		 */
	}

	/**
	 * 入口方法
	 * 
	 * @param ctx
	 * @throws IOException
	 * @throws ServletException
	 */
	public void index(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("index");
		server.execute(request, response);
	}

	/**
	 * 输出XMLRPC描述信息
	 * 
	 * @param ctx
	 * @throws IOException
	 */
	public void rsd(long userId, HttpServletResponse response)
			throws IOException {
		final User user = userService.getUserById((int) userId);
		if (user == null) {
			return;
		}
		StringBuilder xml = new StringBuilder();
		xml.append("<?xml version=\"1.0\" encoding=\"utf-8\" ?>\n");
		xml.append("<rsd version=\"1.0\" xmlns=\"http://archipelago.phrasewise.com/rsd\">\n");
		xml.append("<service>\n");
		xml.append("<engineName>个人博客</engineName>\n");
		xml.append("<engineLink>" + LinkTool.domain() + "</engineLink>\n");
		xml.append("<homePageLink>" + LinkTool.user(user.getUserId())
				+ "</homePageLink>\n");
		xml.append("<apis><api name=\"MetaWeblog\" preferred=\"true\" apiLink=\"");
		xml.append(LinkTool.action("xmlrpc"));
		xml.append("\"  blogID=\"");
		xml.append(user.getUserId());
		xml.append("\"/></apis>\n");
		xml.append("</service>\n");
		xml.append("</rsd>");
		response.getWriter().write(xml.toString());
	}

	/**
	 * Just for Live Writer
	 * 
	 * @param ctx
	 * @throws IOException
	 */
	public void wlwmanifest(long userId, HttpServletResponse response)
			throws IOException {
		final User user = userService.getUserById((int) userId);
		if (user == null) {
			return;
		}
		StringBuilder xml = new StringBuilder();
		xml.append("<?xml version=\"1.0\" encoding=\"utf-8\" ?>\n");
		xml.append("<manifest xmlns=\"http://schemas.microsoft.com/wlw/manifest/weblog\">\n");
		xml.append("<options><clientType>Metaweblog</clientType><supportsKeywords>Yes</supportsKeywords><supportsNewCategories>Yes</supportsNewCategories><supportsSlug>Yes</supportsSlug><supportsAuthor>Yes</supportsAuthor><supportsGetTags>Yes</supportsGetTags></options>");
		xml.append("<weblog>\n");
		xml.append("<serviceName>个人博客</serviceName>\n");
		xml.append("<homepageLinkText>" + user.getUserName()
				+ "</homepageLinkText>\n");
		xml.append("<adminLinkText>博客管理</adminLinkText>\n");
		xml.append("<adminUrl>" + LinkTool.user(user.getUserId())
				+ "</adminUrl>\n");
		xml.append("<postEditingUrl>" + LinkTool.blogEdit("{post-id}")
				+ "</postEditingUrl>\n");
		xml.append("</weblog>\n");
		xml.append("</manifest>");
		response.getWriter().print(xml.toString());
	}

	private static XmlRpcServletServer server;

	static {
		try {
			// create a new XmlRpcServletServer object
			server = new XmlRpcServletServer();
			// set up handler mapping of XmlRpcServletServer object
			PropertyHandlerMapping phm = new PropertyHandlerMapping();
			phm.addHandler("wp", XmlrpcAction.class);
			phm.addHandler("blogger", XmlrpcAction.class);
			phm.addHandler("metaWeblog", XmlrpcAction.class);
			server.setHandlerMapping(phm);
			// more config of XmlRpcServletServer object
			XmlRpcServerConfigImpl serverConfig = (XmlRpcServerConfigImpl) server
					.getConfig();
			serverConfig.setEnabledForExtensions(true);
			serverConfig.setContentLengthOptional(false);
		} catch (XmlRpcException e) {
			throw new RuntimeException(e);
		}
	}

}
