package cn.seu.bingluo.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import cn.seu.bingluo.command.BaseCommand;
import cn.seu.bingluo.command.ReplyCommand;
import cn.seu.bingluo.entity.BlogPojo;
import cn.seu.bingluo.entity.Comment;
import cn.seu.bingluo.entity.CommentPojo;
import cn.seu.bingluo.entity.FolderPojo;
import cn.seu.bingluo.entity.Tag;
import cn.seu.bingluo.entity.User;
import cn.seu.bingluo.service.BlogService;
import cn.seu.bingluo.service.CommentServce;
import cn.seu.bingluo.service.FolderService;
import cn.seu.bingluo.service.TagService;
import cn.seu.bingluo.service.UserService;

@Controller
public class BlogController {
	@Autowired
	private BlogService blogService;
	@Autowired
	private CommentServce commentServce;
	@Autowired
	private FolderService folderService;
	@Autowired
	private UserService userService;
	@Autowired
	private TagService tagService;

	@RequestMapping("/admin/newblog")
	public String newBlog() {
		return "newblog";
	}

	@RequestMapping("/action/xmlrpc")
	public void livewriter(HttpServletRequest request,
			HttpServletResponse response) {
		XmlrpcAction xmlrpcAction = new XmlrpcAction();
		try {
			xmlrpcAction.index(request, response);
		} catch (ServletException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@RequestMapping("/action/xmlrpc/rsd-{userId}")
	public void rsd(@PathVariable("userId") long userId,
			HttpServletResponse response) {
		XmlrpcAction xmlrpcAction = new XmlrpcAction();
		try {
			xmlrpcAction.rsd(userId, response);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@RequestMapping("/action/xmlrpc/wlwmanifest-{userId}")
	public void wlwmanifest(@PathVariable("userId") long userId,
			HttpServletResponse response) {
		XmlrpcAction xmlrpcAction = new XmlrpcAction();
		try {
			xmlrpcAction.wlwmanifest(userId, response);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@RequestMapping("/")
	public String index(Model model, BaseCommand command) {
		try {
			commonIssues(model, command);
			model.addAttribute("pageType", "index");
		} catch (Exception e) {
			e.printStackTrace();
			return "error404";
		}
		return "index";
	}

	@RequestMapping("/{user}/blogs.html")
	public String blogList(BaseCommand command, Model model,
			HttpServletRequest request) {
		try {
			String p = request.getParameter("p");
			int pageNum = 0;
			if (p != null) {
				pageNum = Integer.parseInt(p) - 1;
				if (pageNum < 0) {
					pageNum = 0;
				}
			}

			List<BlogPojo> blogList = blogService.getBlogsByPageNumAndRange(
					pageNum, 5);
			int blogCount = blogService.getUserBlogCount(command.getBaseUser()
					.getUserId());
			model.addAttribute("pageNum", pageNum + 1);
			model.addAttribute("blogList", blogList);
			model.addAttribute("pageCount",
					(int) Math.ceil((double) blogCount / 5));
			model.addAttribute("pageType", "blogs");
			commonIssues(model, command);
		} catch (Exception e) {
			e.printStackTrace();
			return "error404";
		}
		return "blogList";
	}

	@RequestMapping("/blog/{blogId}.html")
	public String blog(@PathVariable("blogId") String blogId, Model model,
			BaseCommand command, HttpServletRequest request) {
		try {
			long id = Integer.valueOf(blogId);
			BlogPojo blogPojo = blogService.getBlogById(id);
			// 博客点击量+1
			blogService.clickBlog(id);
			int pageNum = 0;
			String p = request.getParameter("p");
			if (p != null && !p.equals("")) {
				pageNum = Integer.valueOf(p);
			}

			List<CommentPojo> commentList = commentServce
					.getCommentsByBlogIdAndPageAndRange(blogPojo.getBlogId(),
							pageNum, 10);
			commentServce.setChildrenCommentForList(commentList);
			model.addAttribute("blog", blogPojo);
			model.addAttribute("comments", commentServce.toHtml(commentList));
			model.addAttribute("pageType", "blogs");
			commonIssues(model, command);
		} catch (Exception e) {
			e.printStackTrace();
			return "error404";
		}
		return "blog";
	}

	@RequestMapping("/archives.html")
	public String archives(Model model, BaseCommand command) {
		try {
			commonIssues(model, command);
			model.addAttribute("pageType", "archives");
		} catch (Exception e) {
			e.printStackTrace();
			return "error404";
		}
		return "folderList";
	}

	@RequestMapping("/blog-folder/{folderId}.html")
	public String archives(@PathVariable("folderId") String folderId,
			Model model, BaseCommand command) {
		try {
			long id = Integer.valueOf(folderId);
			FolderPojo folder = folderService.getFolderById(id);
			folder.setBlogList(blogService.getBlogsByFolderId(id));
			model.addAttribute("archive", folder);
			model.addAttribute("pageType", "archives");
			commonIssues(model, command);
		} catch (Exception e) {
			e.printStackTrace();
			return "error404";
		}
		return "archives";
	}

	@RequestMapping("/tags.html")
	public String tagList(Model model, BaseCommand command) {
		try {
			commonIssues(model, command);
			model.addAttribute("pageType", "tags");
		} catch (Exception e) {
			e.printStackTrace();
			return "error404";
		}
		return "tagList";
	}

	@RequestMapping("/tag-blog/{tagId}.html")
	public String tagBlog(@PathVariable("tagId") String tagId, Model model,
			BaseCommand command) {
		try {
			long id = Long.valueOf(tagId);
			Tag tag = tagService.getTagById(id);
			List<BlogPojo> blogList = blogService
					.getBlogsByTagAndPageNumAndRange(tag.getTagName(), 0, 10);
			model.addAttribute("blogList", blogList);
			model.addAttribute("pageType", "tags");
			commonIssues(model, command);
		} catch (Exception e) {
			e.printStackTrace();
			return "error404";
		}
		return "blogList";
	}

	@RequestMapping("/contact.html")
	public String contactMe(Model model, BaseCommand command) {
		model.addAttribute("pageType", "contact");
		commonIssues(model, command);
		return "contactMe";
	}

	@RequestMapping("/postReply")
	public String postReply(ReplyCommand command, Model model,
			HttpServletRequest request) {
		try {
			Comment comment = new CommentPojo();
			comment.setCommentUserId(command.getBaseUser().getUserId());
			comment.setContent(command.getContent());
			comment.setToId(command.getToId());
			comment.setBlogId(command.getBlogId());
			comment.setToType(command.getToType());
			commentServce.addComment(comment);
		} catch (Exception e) {
			e.printStackTrace();
			return "error404";
		}
		return blog(String.valueOf(command.getBlogId()), model, command,
				request);
	}

	private void commonIssues(Model model, BaseCommand command) {
		List<FolderPojo> folderList = folderService.getAllFolders();
		List<BlogPojo> popularBlogs = blogService.getPopularBlogs();
		List<CommentPojo> latestComments = commentServce.getLatestComments();
		User user = command.getBaseUser();
		User currenUser = command.getBaseUser();

		model.addAttribute("folderList", folderList);
		model.addAttribute("popularBlogs", popularBlogs);
		model.addAttribute("latestComments", latestComments);
		model.addAttribute("user", user);
		model.addAttribute("currentUser", currenUser);
	}

	@RequestMapping("/favicon.ico")
	public void favicon(HttpServletResponse response) throws IOException {
		response.sendRedirect("/static/images/favicon.ico");
	}
}