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
public class SQLע�� {
public static void main(String[] args) throws FileNotFoundException, IOException, ClassNotFoundException, SQLException {
	Scanner scanner = new Scanner(System.in);
	System.out.println("���������Ա��");
	String admin_name= scanner.nextLine();
	System.out.println("���������Ա����");
	String admin_password=scanner.nextLine();// ע�⣺��Ҫ����SQLע����ҪnextLine���գ���Ȼ�Ļ����յ��ո��ֹͣ�ˣ�
	Properties properties = new Properties();
	properties.load(new FileInputStream("src\\pra.properties"));
	Class.forName(properties.getProperty("driver"));
	String user = properties.getProperty("user");
	String password = properties.getProperty("password");
	String url = properties.getProperty("url");
	//�õ�����
	Connection connection = DriverManager.getConnection(url, user, password);
	System.out.println(connection);
	//statement
	Statement createStatement = connection.createStatement();
	//��֯sql
	String sql ="select name,pwd from admin where name='"+admin_name+"' and pwd='"+admin_password+"'";
	ResultSet executeQuery = createStatement.executeQuery(sql);
	if (executeQuery.next()) {//��ѯ��һ����¼��½�ͳɹ�
		System.out.println("��½�ɹ�");
	}
	else {
		System.out.println("��½ʧ��");
	}
	createStatement.close();
	connection.close();
	
	
}
}
