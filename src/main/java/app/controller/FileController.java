package app.controller;

import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import app.entity.File;
import app.entity.User;
import app.service.FileService;

@Controller
@RequestMapping("/File")
public class FileController
{
	@Autowired
	private FileService fileService;
	@GetMapping("/{id}")
	public ModelAndView findById(@PathVariable int id,HttpServletRequest request)
	{
		User user=(User)request.getSession().getAttribute("user");
		ModelAndView modelAndView=new ModelAndView("file");
		File file=fileService.findById(id);
		if(file.getUser().getId()==user.getId())
			modelAndView.addObject("file",file);
		return modelAndView;
	}
}