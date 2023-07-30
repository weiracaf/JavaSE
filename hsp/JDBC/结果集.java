package yuan.hsp.JDBC;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.jdbc.Driver;
@SuppressWarnings("all")
public class 结果集 {
public static void main(String[] args) throws SQLException, ClassNotFoundException {
	Class.forName("com.mysql.jdbc.Driver");
	
	Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/db02", "root", "123456");
	
	Statement createStatement = connection.createStatement();
	
	String sql="select id,name,sex,borndate from actor";
	ResultSet executeQuery = createStatement.executeQuery(sql);//和之前的execute不同，executeQuery返回一个ResultSet
	//用while取出数据
	while (executeQuery.next()) {
		int id=executeQuery.getInt(1);//获取该行第一列数据
		String name=executeQuery.getString(2);//第二列
		String sex=executeQuery.getString(3);//第三列
		Date date = executeQuery.getDate(4);//第四列
		System.out.println(id+name+sex+date);
	}
	//关闭
	createStatement.close();
	connection.close();
	
}
}
