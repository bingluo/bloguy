package cn.seu.bingluo.controller;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Random;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileItemFactory;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import cn.seu.bingluo.command.BaseCommand;
import cn.seu.bingluo.entity.Blog;
import cn.seu.bingluo.entity.User;
import cn.seu.bingluo.service.BlogService;
import cn.seu.bingluo.util.Error;

@Controller
public class UploadController {
	@Autowired
	private BlogService blogService;

	@RequestMapping("/action/blog/post")
	public void uploadImg(HttpServletRequest request,
			HttpServletResponse response, BaseCommand command)
			throws IOException, FileUploadException {
		PrintWriter out = response.getWriter();
		User user = command.getBaseUser();
		if (user == null) {
			out.write(Error.KEError("请先登录！"));
			return;
		}
		response.setContentType("text/html; charset=UTF-8");

		// String title = request.getParameter("title");
		String content = request.getParameter("content");
		if (content != null
				&& /* title != null && */!content.trim().equals("")
		/* && !title.trim().equals("") */) {
			Blog blog = new Blog();
			blog.setAuthorId(user.getUserId());
			blog.setTitle("title");
			blog.setContent(content);
			blog.setTags("JAVA;WEB");
			blogService.postBlog(blog);
			return;
		} else if (!ServletFileUpload.isMultipartContent(request)) {
			// 既不是文本也不是文件
			out.write(Error.KEError("请加入内容"));
			return;
		}
		// 是文件
		String saveUrl = "./webapp/static/images/upload/";
		// 定义允许上传的文件扩展名
		String extensions = "gif,jpg,jpeg,png,bmp";
		// 最大文件大小
		long maxSize = 1000000;

		FileItemFactory factory = new DiskFileItemFactory();
		ServletFileUpload upload = new ServletFileUpload(factory);
		upload.setHeaderEncoding("UTF-8");
		List items = upload.parseRequest(request);
		Iterator itr = items.iterator();
		while (itr.hasNext()) {
			FileItem item = (FileItem) itr.next();
			String fileName = item.getName();
			long fileSize = item.getSize();
			if (!item.isFormField()) {
				// 检查文件大小
				if (item.getSize() > maxSize) {
					out.write(Error.KEError("上传图片大小超过限制。"));
					return;
				}
				// 检查扩展名
				String fileExt = fileName.substring(
						fileName.lastIndexOf(".") + 1).toLowerCase();
				if (!Arrays.<String> asList(extensions.split(",")).contains(
						fileExt)) {
					out.write(Error.KEError("\n只允许上传" + extensions + "格式的图片。"));
					return;
				}

				SimpleDateFormat df = new SimpleDateFormat("yyyyMMddHHmmss");
				String newFileName = df.format(new Date()) + "_"
						+ new Random().nextInt(1000) + "." + fileExt;
				try {
					File uploadedFile = new File(saveUrl, newFileName);
					item.write(uploadedFile);
				} catch (Exception e) {
					out.write(Error.KEError("上传失败。"));
					return;
				}

				JSONObject obj = new JSONObject();
				obj.put("error", 0);
				obj.put("url", "/static/images/upload/" + newFileName);
				out.println(obj.toJSONString());
			}
		}
	}
}
