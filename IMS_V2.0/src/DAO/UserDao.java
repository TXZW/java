package DAO;

import java.util.List;

import com.txzw.entity.Student;
import com.txzw.entity.Teacher;

public interface UserDao {
	// 教师登陆验证
	public Teacher login(String username, String password);

	// 获取学生集合
	public List<Student> catchStu(int teacherID);

	// 评语更新
	public int update(Student student);

	// 删除
	public int delete(Student student);
}
