package DAO;

import java.util.List;

import com.txzw.entity.Student;
import com.txzw.entity.Teacher;

public interface userDAO {
	/**
	 * 验证登录
	 * @param username
	 * @param password
	 * @return
	 */
	Teacher login(String username, String password);

	List<Student> catchStu();

	int update(Student student);

	int delete(Student student);
}
