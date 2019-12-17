package app.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import app.entity.User;
import app.repository.UserRepository;

@Service
public class UserService
{
	@Autowired
	private UserRepository userRepository;
	@Autowired
	private PasswordEncoder passwordEncoder;
	public void save(User user)
	{
		userRepository.save(user);
	}
	public void update(User user)
	{
		userRepository.save(user);
	}
	public void deleteById(int id)
	{
		userRepository.deleteById(id);
	}
	public User findById(int id)
	{
		return userRepository.findById(id).get();
	}
	public List<User> findAll()
	{
		return userRepository.findAll();
	}
	public User findByUsername(String username)
	{
		return userRepository.findByUsername(username);
	}
	public boolean login(String username,String password)
	{
		User user=findByUsername(username);
		if(user==null)
			return false;
		return passwordEncoder.matches(password,user.getPassword());
	}
}