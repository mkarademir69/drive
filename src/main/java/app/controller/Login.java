package app.controller;

import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import app.entity.User;
import app.service.UserService;

@Controller
@RequestMapping("/Login")
public class Login
{
	@Autowired
	private UserService userService;
	@GetMapping
	public ModelAndView get()
	{
		return new ModelAndView("login");
	}
	@PostMapping
	public String login(@RequestParam String username,@RequestParam String password,HttpServletRequest request)
	{
		if(userService.login(username,password))
		{
			User user=userService.findByUsername(username);
			request.getSession().setAttribute("user",user);
		}
		return "redirect:/";
	}
}