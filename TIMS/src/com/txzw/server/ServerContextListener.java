package com.txzw.server;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.List;

import com.txzw.entity.Student;
import com.txzw.entity.Teacher;
import com.txzw.util.Datas;
import com.txzw.util.SysConstants;
import com.txzw.util.Tools;

import DAO.user.createDB;

public class ServerContextListener extends Thread {
	public static void main(String[] args) {
		new createDB().create();
		// 启动服务线程
		new ServerContextListener().start();
	}

	@Override
	public void run() {
		// 创建Socket对象
		ServerSocket serverSocket = null;
		Socket socket = null;
		ObjectInputStream ois = null;
		ObjectOutputStream oos = null;
		int i = 0;
		try {
			serverSocket = new ServerSocket(Integer.parseInt(Tools.getValue(SysConstants.SYS_LISTENERPORT)));
			while (true) {
				socket = serverSocket.accept();
				oos = new ObjectOutputStream(socket.getOutputStream());
				ois = new ObjectInputStream(socket.getInputStream());
				// 接收客户端请求的对象
				Datas datas = (Datas) ois.readObject();
				// 创建服务器的业务对象
				ServerService serverService = new ServerService();
				if (datas.getFlag().equals(SysConstants.SYS_LOGIN)) {
					// 登录
					String username = datas.getTeacher().getUsername();
					String password = datas.getTeacher().getPassword();
					// 调用业务方法
					Teacher teacher = serverService.doLogin(username, password);
					datas.setTeacher(teacher);
					if (teacher == null) {
						datas.setFlag(SysConstants.SYS_ERROR);
					} else {
						datas.setFlag(SysConstants.SYS_SUCCESS);
					}
				}
				// 查询请求处理核心代码
				if (datas.getFlag().equals(SysConstants.SYS_FIND)) {
					// 查询
					int teacherID = datas.getTeacher().getID();
					List<Student> studentList = serverService.findStudentByTeacher(teacherID);
					datas.setStudentList(studentList);
					oos.writeObject(datas);
				}
				if (datas.getFlag().equals(SysConstants.SYS_UPDATE)) {
					// 修改
					Student student = datas.getStudent();
					i = serverService.updateStudent(student);
					if (i != 1) {
						datas.setFlag(SysConstants.SYS_ERROR);
					}
				}
				if (datas.getFlag().equals(SysConstants.SYS_DELETE)) {
					// 删除
					Student s = datas.getStudent();
					i = serverService.deleteStudent(s);
					if (i != 1) {
						datas.setFlag(SysConstants.SYS_ERROR);
					}
				}
				oos.writeObject(datas);
				oos.flush();
				socket.shutdownOutput();
			}
		} catch (NumberFormatException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				oos.close();
				ois.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
