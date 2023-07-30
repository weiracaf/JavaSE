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
		//��ȡ��Դ��ע������
		Properties properties = new Properties();
		properties.load(new FileInputStream("src\\pra.properties"));
		Class.forName(properties.getProperty("driver"));
		String user = properties.getProperty("user");
		String password = properties.getProperty("password");
		String url = properties.getProperty("url");
		//�õ�����
		Connection connection = DriverManager.getConnection(url, user, password);
		System.out.println(connection);
		//�������
		Statement createStatement = connection.createStatement();
		String crString="CREATE TABLE actor(\r\n"
				+ "	id INT PRIMARY KEY AUTO_INCREMENT,\r\n"
				+ "	`name` VARCHAR(32) NOT NULL DEFAULT '',\r\n"
				+ "	sex CHAR(1) NOT NULL DEFAULT 'Ů',\r\n"
				+ "	borndate DATETIME,\r\n"
				+ "	phone VARCHAR(12)); ";
		createStatement.execute(crString);
		for(int i=0;i<5;i++) {
			createStatement.execute("insert into actor values(null,'С��','��','2000-1-1','123')");
		}
		createStatement.execute("update actor set `name`='СԬ' WHERE id=1");
		createStatement.execute("delete from actor where id=3");
		//�ر�
		createStatement.close();
		connection.close();
		
		
		
		 
	}

}
