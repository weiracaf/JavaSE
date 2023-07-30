package yuan.hsp.JDBC;
//��ʾPreparedStatement�Ļ�������
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
public class PreparedStatement���SQLע�� {
	public static void main(String[] args) throws FileNotFoundException, IOException, ClassNotFoundException, SQLException {
		Scanner scanner = new Scanner(System.in);
		System.out.println("���������Ա��");
		String admin_name= scanner.nextLine();
		System.out.println("���������Ա����");
		String admin_password=scanner.nextLine();// ע�⣺��Ҫ����SQLע����ҪnextLine���գ���Ȼ�Ļ����յ��ո��ֹͣ�ˣ�
		//1.�����������ļ���д
		Properties properties = new Properties();
		properties.load(new FileInputStream("src\\pra.properties"));
		Class.forName(properties.getProperty("driver"));
		String user = properties.getProperty("user");
		String password = properties.getProperty("password");
		String url = properties.getProperty("url");
		//2.�õ�����
		Connection connection = DriverManager.getConnection(url, user, password);
		System.out.println(connection);
		//��Statement��ͬ�����Ҫ����֯SQL���
		//3.��֯sql,?���൱��ռλ��
		String sql ="select name,pwd from admin where name= ? and pwd= ?";
		//4.�õ�PreparedStatement
		java.sql.PreparedStatement prepareStatement =connection.prepareStatement(sql);
		//5.��?��ֵ
		prepareStatement.setString(1, admin_name);
		prepareStatement.setString(2, admin_password);
		//6.ִ��select���
		//ע�⣺����ִ��executeQuery�����Ͳ�Ҫд�ˣ������Ѿ������ˣ�����д��
		ResultSet executeQuery = prepareStatement.executeQuery();
		if(executeQuery.next())
		{
			System.out.println("�ɹ���½");
		}
		else {
			System.out.println("ʧ�ܵ�½");
		}
		
		
		connection.close();
		
		
	}
}
