package yuan.hsp.JDBC;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.jdbc.Driver;
@SuppressWarnings("all")
public class ����� {
public static void main(String[] args) throws SQLException, ClassNotFoundException {
	Class.forName("com.mysql.jdbc.Driver");
	
	Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/db02", "root", "123456");
	
	Statement createStatement = connection.createStatement();
	
	String sql="select id,name,sex,borndate from actor";
	ResultSet executeQuery = createStatement.executeQuery(sql);//��֮ǰ��execute��ͬ��executeQuery����һ��ResultSet
	//��whileȡ������
	while (executeQuery.next()) {
		int id=executeQuery.getInt(1);//��ȡ���е�һ������
		String name=executeQuery.getString(2);//�ڶ���
		String sex=executeQuery.getString(3);//������
		Date date = executeQuery.getDate(4);//������
		System.out.println(id+name+sex+date);
	}
	//�ر�
	createStatement.close();
	connection.close();
	
}
}
