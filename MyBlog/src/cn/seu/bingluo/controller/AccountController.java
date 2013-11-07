package cn.seu.bingluo.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import cn.seu.bingluo.command.BaseCommand;
import cn.seu.bingluo.entity.User;
import cn.seu.bingluo.filter.SecurityContextHolder;
import cn.seu.bingluo.service.UserService;

@Controller
public class AccountController {
	@Autowired
	private UserService userService;

	@RequestMapping("/logon.html")
	public String LogonPage() {
		return "logon";
	}

	@RequestMapping("/register.html")
	public String RegisterPage() {
		return "register";
	}

	@RequestMapping(value = "/logon", method = RequestMethod.POST)
	public void login(@RequestParam("username") String username,
			@RequestParam("password") String password, Model model,
			HttpServletResponse response) {
		String goTo = null;
		User user = userService.logon(username, password);
		if (user != null) {
			SecurityContextHolder.getSecurityContext().setUser(user);
			goTo = "/" + user.getUserId();
		} else {
			goTo = "/logon.html";
		}

		try {
			response.sendRedirect(goTo);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@RequestMapping(value = "/register", method = RequestMethod.POST)
	public void register(@RequestParam("username") String username,
			@RequestParam("password") String password,
			@RequestParam("password2") String password2,
			@RequestParam("email") String email,
			@RequestParam("verifyCode") String verifyCode,
			HttpServletResponse response, BaseCommand command)
			throws IOException {
		response.setContentType("text/plain; charset=utf-8");
		PrintWriter out = response.getWriter();
		if (username.trim() == "") {
			out.write("请输入用户名");
			return;
		} else if (password.trim() == "") {
			out.write("请输入密码");
			return;
		} else if (!password.equals(password2)) {
			out.write("请输入相同的密码");
		} else if (email.trim() == "") {
			out.write("请输入邮箱");
		} else if (verifyCode.trim() == "") {
			out.write("请输入验证码");
		} else if (false) {
			out.write("请输入正确的验证码");
		} else {
			User user = new User();
			user.setUserName(username);
			user.setPassword(password);
			user.setUserId(userService.register(user));
			SecurityContextHolder.getSecurityContext().setUser(user);
			out.write("success");
		}
	}
}
