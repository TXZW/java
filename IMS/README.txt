基于jdk 1.8,DBC 5.1.41,MYSQL 5.7,tomcat 8.5
需导入Eclipse运行
功能比较简陋
内置管理员账户admin1,密码123
内置管理员账户admin2,密码456
1.先运行com.txzw.server包下的ServerContextListener
2.开启tomcat服务区
3.访问http://(tomcatURI)/IMS
可在src/sys.properties可修改数据库相关信息(地址 端口号 用户名 密码等)
修改完需重启服务器

新增学生信息分页显示