package com.txzw.client;

import java.util.List;
import java.util.Scanner;

import com.txzw.entity.Student;
import com.txzw.entity.Teacher;
import com.txzw.util.Datas;
import com.txzw.util.SysConstants;

public class Client {
	public static void main(String[] args) {
		Client.createLoginView();
	}

	// 控制台输入对象
	private static Scanner input = new Scanner(System.in);
	// 客户端业务对象
	private static ClientBIZ clientBIZ = new ClientBIZ();

	// 实现客户端登录视图
	public static void createLoginView() {
		System.out.println("***********操作学员管理系统,请先登录***********");
		System.out.println("1.登录\n2.退出系统");
		System.out.println("****************请选择数字1/2*****************");
		int num = input.nextInt();
		if (num == 1) {
			while (true) {
				System.out.println("用户名称:");
				String username = input.next();
				if ("exit".equals(username)) {
					return;
				}
				System.out.println("用户密码:");
				String passwor = input.next();
				// 调用登录业务,如果登陆成功调用学员管理视图
				Datas datas = clientBIZ.doLogic(username, passwor);
				if (datas.getFlag().equals(SysConstants.SYS_SUCCESS)) {
					System.out.println("登录成功,进入学员管理系统");
					createStudentManageView(datas.getTeacher());
				} else {
					System.out.println("用户名或密码输入错误,登陆失败!");
				}
			}
		}
	}

	// 实现客户端学员信息管理视图的生成
	public static void createStudentManageView(Teacher teacher) {
		while (true) {
			System.out.println("============学员管理系统============");
			System.out.println(" 1.查看学员信息 \n 2.修改学员信息 \n 3.删除学员信息 \n 4.退出管理系统 ");
			System.out.println("****************请选择数字1/2/3/4*****************");
			// 接收用户输入
			String num = input.next();
			// 根据用户调用客户端业务方法
			// 显示查询结果
			if ("1".equals(num)) {
				// 调用客户端业务查询方法,获取服务器返回信息
				Datas datas = clientBIZ.doFind(teacher.getID());
				// 判断服务器返回状态
				if (SysConstants.SYS_FIND.equals(datas.getFlag())) {
					// 获取学员集合
					List<Student> studentList = datas.getStudentList();
					// 输出显示
					System.out.println("================================");
					System.out.println("编号\t学生姓名\t年龄\t性别\t班主任\t评语");
					for (Student student : studentList) {
						System.out.println(student.getStuID() + "\t" + student.getStuName() + "\t" + student.getStuAge()
								+ "\t" + (student.getStuSex() == 1 ? "男" : "女") + "\t" + teacher.getNickname() + "\t"
								+ student.getComments());
					}
					System.out.println("================================");
				} else {
					System.out.println("查询失败!");
				}
			}
			if ("2".equals(num)) {
				// 输入修改学员信息
				System.out.println("要修改的学员编号");
				int stuID = input.nextInt();
				System.out.println("修改后的学员评语");
				String comments = input.next();
				// 调用客户端业务的修改方法,获取服务器返回信息
				Datas datas = clientBIZ.doUpdate(stuID, comments);
				if (datas.getFlag().equals(SysConstants.SYS_UPDATE)) {
					System.out.println("修改成功");
				} else {
					System.out.println("修改失败");
				}
			}
			if ("3".equals(num)) {
				// 输入需要删除的学员编号
				System.out.println("要删除的学员编号\n");
				int stuID = input.nextInt();
				// System.out.println("要删除的学员姓名\n");
				// String stuName = input.next();
				// 调用客户端业务的删除方法,获取服务器返回信息
				Datas datas = clientBIZ.doDelete(stuID);
				// 判断服务器返回状态
				if (datas.getFlag().equals(SysConstants.SYS_DELETE)) {
					System.out.println("删除成功!");
				} else {
					System.out.println("删除失败!");
				}
			}
			if ("4".equals(num)) {
				return;
			}
		}
	}
}
