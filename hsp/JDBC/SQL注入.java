package yuan.hsp.JDBC;

import static org.junit.jupiter.api.Assertions.assertTimeoutPreemptively;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;
import java.util.Scanner;
@SuppressWarnings("all")
public class SQL注入 {
public static void main(String[] args) throws FileNotFoundException, IOException, ClassNotFoundException, SQLException {
	Scanner scanner = new Scanner(System.in);
	System.out.println("请输入管理员名");
	String admin_name= scanner.nextLine();
	System.out.println("请输入管理员密码");
	String admin_password=scanner.nextLine();// 注意：想要出现SQL注入需要nextLine接收，不然的话接收到空格就停止了！
	Properties properties = new Properties();
	properties.load(new FileInputStream("src\\pra.properties"));
	Class.forName(properties.getProperty("driver"));
	String user = properties.getProperty("user");
	String password = properties.getProperty("password");
	String url = properties.getProperty("url");
	//得到连接
	Connection connection = DriverManager.getConnection(url, user, password);
	System.out.println(connection);
	//statement
	Statement createStatement = connection.createStatement();
	//组织sql
	String sql ="select name,pwd from admin where name='"+admin_name+"' and pwd='"+admin_password+"'";
	ResultSet executeQuery = createStatement.executeQuery(sql);
	if (executeQuery.next()) {//查询到一条记录登陆就成功
		System.out.println("登陆成功");
	}
	else {
		System.out.println("登陆失败");
	}
	createStatement.close();
	connection.close();
	
	
}
}
