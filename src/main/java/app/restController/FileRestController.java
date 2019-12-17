package app.restController;

import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import app.entity.File;
import app.entity.User;
import app.service.FileService;

@RestController
@RequestMapping("/api/file")
public class FileRestController
{
	@Autowired
	private FileService fileService;
	@PostMapping
	public File save(@RequestBody File file,HttpServletRequest request)
	{
		User user=(User)request.getSession().getAttribute("user");
		file.setUser(user);
		fileService.save(file);
		return file;
	}
	@DeleteMapping("/{id}")
	public void deleteById(@PathVariable int id)
	{
		fileService.deleteById(id);
	}
}