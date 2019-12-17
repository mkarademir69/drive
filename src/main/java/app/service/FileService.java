package app.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import app.entity.File;
import app.entity.User;
import app.repository.FileRepository;

@Service
public class FileService
{
	@Autowired
	private FileRepository fileRepository;
	public void save(File file)
	{
		fileRepository.save(file);
	}
	public void update(File file)
	{
		fileRepository.save(file);
	}
	public void deleteById(int id)
	{
		fileRepository.deleteById(id);
	}
	public List<File> findAll()
	{
		return fileRepository.findAll();
	}
	public File findById(int id)
	{
		return fileRepository.findById(id).get();
	}
	public List<File> findByUser(User user)
	{
		return fileRepository.findByUser(user);
	}
}