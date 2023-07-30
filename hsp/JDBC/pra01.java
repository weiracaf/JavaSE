package yuan.hsp.JDBC;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

import yuan.learn.basic.Multithreading.interrupt_;
@SuppressWarnings({"all"})
public class pra01 {
	public static void main(String[] args) throws FileNotFoundException, IOException, ClassNotFoundException, SQLException {
		//获取资源和注册驱动
		Properties properties = new Properties();
		properties.load(new FileInputStream("src\\pra.properties"));
		Class.forName(properties.getProperty("driver"));
		String user = properties.getProperty("user");
		String password = properties.getProperty("password");
		String url = properties.getProperty("url");
		//得到连接
		Connection connection = DriverManager.getConnection(url, user, password);
		System.out.println(connection);
		//操作语句
		Statement createStatement = connection.createStatement();
		String crString="CREATE TABLE actor(\r\n"
				+ "	id INT PRIMARY KEY AUTO_INCREMENT,\r\n"
				+ "	`name` VARCHAR(32) NOT NULL DEFAULT '',\r\n"
				+ "	sex CHAR(1) NOT NULL DEFAULT '女',\r\n"
				+ "	borndate DATETIME,\r\n"
				+ "	phone VARCHAR(12)); ";
		createStatement.execute(crString);
		for(int i=0;i<5;i++) {
			createStatement.execute("insert into actor values(null,'小明','男','2000-1-1','123')");
		}
		createStatement.execute("update actor set `name`='小袁' WHERE id=1");
		createStatement.execute("delete from actor where id=3");
		//关闭
		createStatement.close();
		connection.close();
		
		
		
		 
	}

}
