package cn.seu.bingluo.controller;

import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import cn.seu.bingluo.command.ContactMeCommand;
import cn.seu.bingluo.util.MailIssue;

@Controller
public class AboutMeController {

	@RequestMapping(value = "/postMsg.html", method = RequestMethod.POST)
	public void contactMe(Model model, ContactMeCommand command,
			HttpServletResponse response) {
		StringBuilder title = new StringBuilder();
		title.append(command.getName()).append(" 给您发来了信息！");

		StringBuilder content = new StringBuilder();
		content.append("<html>");
		content.append("<h3>").append(command.getSubject()).append("</h3>");
		content.append("<p>")
				.append(command.getMessage().replaceAll("\n", "<\br>"))
				.append("</p>");
		content.append("<p>邮箱：").append(command.getEmail()).append("</p>");

		try {
			MailIssue.send(title.toString(), content.toString());
			response.sendRedirect("/");
		} catch (Exception e) {
		}
	}
}
