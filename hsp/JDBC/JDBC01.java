package yuan.hsp.JDBC;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

import com.mysql.jdbc.Driver;
@SuppressWarnings({"all"})
// ��һ��JDBC������ʾһЩ�򵥲���
public class JDBC01 {
	public static void main(String[] args) throws SQLException {
		//ǰ�ù�������Ŀ�½�һ���ļ���
		//��mysql.jar��������Ŀ¼��Ȼ��Add to project���뵽��Ŀ�в���ʹ��mysql����jdbc��jar�ļ���һЩ�ӿڸ�����
		//1.ע������
		Driver driver = new Driver();//Driver���Ƕ�Ӧ��һ���� 
		
		//2.�õ�����
		//jdbc:mysql://��ʾjdbc����mysql��localhost������ip����������localhost�Ϳ��ԣ���3306��Ӧmysql�˿�
		//db02��Ӧ��Ҫ���ӵ����ݿ⣬mysql���ӱ��ʻ���socket����
		String url="jdbc:mysql://localhost:3306/db02";
		//���û���������ŵ�properties�����У�ע�������
		//!user��password�ǹ涨�õģ����Ƕ�Ӧ�û��������룬��Ҫд��������
		Properties properties = new Properties();
		properties.setProperty("user", "root");//�û�
		properties.setProperty("password", "123456");//����
		
		Connection connect = driver.connect(url, properties);//�õ�����
		//3.ִ��sql��� 
		String sql = "insert into actor values(null,'���»�','��','1970-11-11','110')";
		//����һ��statement����ִ�о�̬sql��䣬�������ɽ���Ķ���
		Statement Statement = connect.createStatement();
		int executeUpdate = Statement.executeUpdate(sql);//dml��䷵����Ӱ�������
		
		System.out.println(executeUpdate);
		//4.�ر�����(�ȿ����)
		Statement.close();
		connect.close();
		
	}

}

