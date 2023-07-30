package yuan.hsp.JDBC.jdbcutils;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.Statement;
@SuppressWarnings("all")
//实现连接和关闭的JDBC工具类
public class JDBCUtils {
	//定义相关属性,因为只需要一份用static修饰
	private static String user;
	private static String password;
	private static String url;
	private static String driver;
	//用static初始化
	static {
		Properties properties = new Properties();
		try {
			properties.load(new FileInputStream("src\\pra.properties"));
			user=properties.getProperty("user");
			password=properties.getProperty("password");
			url=properties.getProperty("url");
			driver=properties.getProperty("driver");
		} catch (IOException e) {//捕获异常
			throw new RuntimeException(e);//实际开发中一般转为一个运行异常抛出去
			//将编译异常转为运行异常，可以捕获或者默认处理
		}	
	}
	//获取连接
	public static java.sql.Connection getConnection() {
		try {
			return DriverManager.getConnection(url, user, password);
		} catch (SQLException e) {
			throw new RuntimeException(e);//还是转运行异常
		}
	}
	//关闭资源
	//参数为可能需要关闭的资源
	public static void close(ResultSet set,PreparedStatement prepareStatement,java.sql.Connection connection) throws SQLException {
		//参数用Statement既可以接收Statement也可以接收PreparedStatement
		
		//判断是否为null，比如可能不是查询就没有ResultSet这个传入null即可,然后不等于null就关闭
		if (set!=null) 
			set.close();
		
		if (prepareStatement!=null) 
			prepareStatement.close();
		
		if(connection!=null)
			connection.close();
		
	}
	
}
