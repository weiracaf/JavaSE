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
//ʵ�����Ӻ͹رյ�JDBC������
public class JDBCUtils {
	//�����������,��Ϊֻ��Ҫһ����static����
	private static String user;
	private static String password;
	private static String url;
	private static String driver;
	//��static��ʼ��
	static {
		Properties properties = new Properties();
		try {
			properties.load(new FileInputStream("src\\pra.properties"));
			user=properties.getProperty("user");
			password=properties.getProperty("password");
			url=properties.getProperty("url");
			driver=properties.getProperty("driver");
		} catch (IOException e) {//�����쳣
			throw new RuntimeException(e);//ʵ�ʿ�����һ��תΪһ�������쳣�׳�ȥ
			//�������쳣תΪ�����쳣�����Բ������Ĭ�ϴ���
		}	
	}
	//��ȡ����
	public static java.sql.Connection getConnection() {
		try {
			return DriverManager.getConnection(url, user, password);
		} catch (SQLException e) {
			throw new RuntimeException(e);//����ת�����쳣
		}
	}
	//�ر���Դ
	//����Ϊ������Ҫ�رյ���Դ
	public static void close(ResultSet set,PreparedStatement prepareStatement,java.sql.Connection connection) throws SQLException {
		//������Statement�ȿ��Խ���StatementҲ���Խ���PreparedStatement
		
		//�ж��Ƿ�Ϊnull��������ܲ��ǲ�ѯ��û��ResultSet�������null����,Ȼ�󲻵���null�͹ر�
		if (set!=null) 
			set.close();
		
		if (prepareStatement!=null) 
			prepareStatement.close();
		
		if(connection!=null)
			connection.close();
		
	}
	
}
