package yuan.hsp.JDBC;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import org.junit.jupiter.api.Test;



public class ������ {
	@Test
	public void m1() throws ClassNotFoundException, SQLException {
		Class.forName("com.mysql.jdbc.Driver");
		
		Connection connection = DriverManager
				.getConnection("jdbc:mysql://localhost:3306/db02?rewriteBatchedStatements=true","root","123456");
		String sql="insert into admin values (?,?)";
		PreparedStatement prepareStatement = connection.prepareStatement(sql);
		for(int i=0;i<5000;i++) {
			prepareStatement.setString(1, "jack"+i);
			prepareStatement.setString(2, "666");
			//�������㵽�����������-����Դ��
			prepareStatement.addBatch();
			//����1000����¼ʱ������ִ�У������������ʱ��д����Ȼ�Ǹ�����Ҳ�������޵ģ�
			if ((i+1)%1000==0) {
				prepareStatement.executeBatch();//����ִ��
				prepareStatement.clearBatch();//���һ��
			}
			
		}
		prepareStatement.close();
		connection.close();
		
		
	}

}
