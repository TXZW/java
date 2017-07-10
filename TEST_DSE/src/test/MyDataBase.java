package test;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import com.haylion.Base.BaseMapper;
import com.haylion.Base.Message;
import com.haylion.Tool.DataBase;
import com.haylion.po.test;

public class MyDataBase implements DataBase {
	private static String resource = "mybatis-config.xml";
	private static SqlSessionFactory sqlSessionFactory;
	private static SqlSession session = null;
	private static BaseMapper testDao;
	static {
		try {
			InputStream is = Resources.getResourceAsStream(resource);
			sqlSessionFactory = new SqlSessionFactoryBuilder().build(is);
			session = sqlSessionFactory.openSession();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}

	@Override
	public List<Message> queryAllById(String setName) {
		// TODO Auto-generated method stub
		String[] ss = setName.split("_");
		try {
			testDao = (BaseMapper) session.getMapper(Class.forName(ss[0] + "Mapper"));
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		List<Message> list = new ArrayList<Message>(testDao.queryAllById(ss[1]));
		return list;
	}

	@Override
	public boolean insert(List<Message> list) {
		// TODO Auto-generated method stub

		try {
			for (Message message : list) {
				if (message instanceof test) {
					testDao.insert((test) message);
				}
			}
			session.commit();
			return true;
		} catch (Exception e) {
			// TODO: handle exception
			session.rollback();
			return false;
		}
	}

	@Override
	public boolean insert(Message message) {
		// TODO Auto-generated method stub

		try {
			if (message instanceof test) {
				testDao.insert((test) message);
			}
			session.commit();
			return true;
		} catch (Exception e) {
			// TODO: handle exception
			session.rollback();
			return false;
		}
	}

	@Override
	public boolean update(List<Message> list) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean delete(List<Message> list) {
		// TODO Auto-generated method stub
		return false;
	}

}
