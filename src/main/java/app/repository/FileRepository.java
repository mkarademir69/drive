package app.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import app.entity.File;
import app.entity.User;

public interface FileRepository extends JpaRepository<File,Integer>
{
	List<File> findByUser(User user);
}