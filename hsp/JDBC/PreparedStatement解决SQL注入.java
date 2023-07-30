package yuan.hsp.JDBC;
//演示PreparedStatement的基本操作
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

import com.mysql.jdbc.PreparedStatement;
@SuppressWarnings("all")
public class PreparedStatement解决SQL注入 {
	public static void main(String[] args) throws FileNotFoundException, IOException, ClassNotFoundException, SQLException {
		Scanner scanner = new Scanner(System.in);
		System.out.println("请输入管理员名");
		String admin_name= scanner.nextLine();
		System.out.println("请输入管理员密码");
		String admin_password=scanner.nextLine();// 注意：想要出现SQL注入需要nextLine接收，不然的话接收到空格就停止了！
		//1.正常的配置文件读写
		Properties properties = new Properties();
		properties.load(new FileInputStream("src\\pra.properties"));
		Class.forName(properties.getProperty("driver"));
		String user = properties.getProperty("user");
		String password = properties.getProperty("password");
		String url = properties.getProperty("url");
		//2.得到连接
		Connection connection = DriverManager.getConnection(url, user, password);
		System.out.println(connection);
		//和Statement不同，这个要先组织SQL语句
		//3.组织sql,?就相当于占位符
		String sql ="select name,pwd from admin where name= ? and pwd= ?";
		//4.得到PreparedStatement
		java.sql.PreparedStatement prepareStatement =connection.prepareStatement(sql);
		//5.给?赋值
		prepareStatement.setString(1, admin_name);
		prepareStatement.setString(2, admin_password);
		//6.执行select语句
		//注意：这里执行executeQuery参数就不要写了，上面已经关联了！！！写了
		ResultSet executeQuery = prepareStatement.executeQuery();
		if(executeQuery.next())
		{
			System.out.println("成功登陆");
		}
		else {
			System.out.println("失败登陆");
		}
		
		
		connection.close();
		
		
	}
}
