package com.txzw.client;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

import com.txzw.entity.Student;
import com.txzw.entity.Teacher;
import com.txzw.util.Datas;
import com.txzw.util.SysConstants;
import com.txzw.util.Tools;

public class ClientBIZ {
	Socket socket = null;
	ObjectInputStream ois = null;
	ObjectOutputStream oos = null;

	private void initSocket() {
		// 实例化Socket相关对象
		String hostname = Tools.getValue(SysConstants.SYS_HOSTNAME);
		int port = Integer.parseInt(Tools.getValue(SysConstants.SYS_LISTENERPORT));
		try {
			socket = new Socket(hostname, port);
			oos = new ObjectOutputStream(socket.getOutputStream());
			ois = new ObjectInputStream(socket.getInputStream());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public void closeSocket() {
		// 关闭Socket相关对象
		try {
			oos.close();
			ois.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public Datas doLogic(String username, String password) {
		// 登录方法:通过Socket调用服务器的登录方法
		try {
			initSocket();
			Teacher teacher = new Teacher();
			teacher.setUsername(username);
			teacher.setPassword(password);
			Datas datas = new Datas();
			datas.setTeacher(teacher);
			datas.setFlag(SysConstants.SYS_LOGIN);
			oos.writeObject(datas);
			datas = (Datas) ois.readObject();
			return datas;
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			closeSocket();
		}
		return null;
	}

	public Datas doFind(int teacherID) {
		// 查询学员信息方法:通过Socket调用服务器的查询学员信息服务
		try {
			initSocket();
			Teacher teacher = new Teacher();
			teacher.setID(teacherID);
			Datas datas = new Datas();
			datas.setTeacher(teacher);
			datas.setFlag(SysConstants.SYS_FIND);
			oos.writeObject(datas);
			datas = (Datas) ois.readObject();
			return datas;
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			closeSocket();
		}
		return null;

	}

	public Datas doUpdate(int stuID, String comments) {
		// 修改学员信息方法:通过Socket调用服务器的修改学员信息服务
		try {
			initSocket();
			Datas datas = new Datas();
			datas.setFlag(SysConstants.SYS_UPDATE);
			Student student = new Student();
			student.setComments(comments);
			student.setStuID(stuID);
			datas.setStudent(student);
			oos.writeObject(datas);
			datas = (Datas) ois.readObject();
			return datas;
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			closeSocket();
		}
		return null;
	}

	public Datas doDelete(int stuID) {
		// 删除学员信息方法:通过Socket调用服务器的删除学员信息服务
		try {
			initSocket();
			Datas datas = new Datas();
			datas.setFlag(SysConstants.SYS_DELETE);
			Student student = new Student();
			student.setStuID(stuID);
			datas.setStudent(student);
			oos.writeObject(datas);
			datas = (Datas) ois.readObject();
			return datas;
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			closeSocket();
		}
		return null;
	}
}
