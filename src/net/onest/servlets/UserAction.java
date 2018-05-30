package net.onest.servlets;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;


import net.onest.bean.User;
import net.onest.service.UserService;

@Controller
public class UserAction {
	@Autowired
	private UserService userService;
	@RequestMapping("/userlogin")
	private String userLogin(Model model,String username,String password,HttpSession session) {
		User user=userService.findUser(username, password);
		session.setAttribute("username", user);
		if(user!=null) {
			return "user/indexqq";
		}
		return "user/loginfail";
	}
	
	@RequestMapping("/register")
	public String register(User user) {
		boolean result = userService.register(user);
		if(result) {
			return "user/registerSuccess";
		}else {
			return "register";
		}
	}
	
	@RequestMapping("/finduser")
	public String selectuser(Model model) {
		List<User> list=userService.find();
		model.addAttribute("userlist",list);
		return "admin/userlist";
	}
	
	
	
}
