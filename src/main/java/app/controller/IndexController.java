package app.controller;

import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import app.entity.User;
import app.service.FileService;

@Controller
@RequestMapping("/")
public class IndexController
{
	@Autowired
	private FileService fileService;
	@GetMapping
	public ModelAndView modelAndView(HttpServletRequest request)
	{
		User user=(User)request.getSession().getAttribute("user");
		ModelAndView modelAndView=new ModelAndView("files");
		modelAndView.addObject("files",fileService.findByUser(user));
		return modelAndView;
	}
}