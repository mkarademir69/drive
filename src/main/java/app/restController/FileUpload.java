package app.restController;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import javax.servlet.http.HttpSession;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@RestController
@RequestMapping("/Upload")
public class FileUpload
{
	@PostMapping
	public A upload(@RequestParam MultipartFile file,HttpSession session)
	{
		String originalFilename=file.getOriginalFilename();
		String name=session.getServletContext().getRealPath("/")+"/file/"+originalFilename;
		try
		{
			byte[] bs=file.getBytes();
			File file2=new File(name);
			int a=0;
			while(file2.exists())
			{
				a++;
				name=session.getServletContext().getRealPath("/")+"/file/"+originalFilename.substring(0,originalFilename.lastIndexOf("."))+a+originalFilename.substring(originalFilename.lastIndexOf('.'));
				file2=new File(name);
			}
			FileOutputStream fileOutputStream=new FileOutputStream(name);
			BufferedOutputStream bufferedOutputStream=new BufferedOutputStream(fileOutputStream);
			bufferedOutputStream.write(bs);
			bufferedOutputStream.flush();
			bufferedOutputStream.close();
		}
		catch(Exception e)
		{
			System.out.println(e.getMessage());
		}
		return new A(name.substring(name.lastIndexOf('/')+1));
	}
}
@Getter
@Setter
@AllArgsConstructor
class A
{
	private String filename;
}