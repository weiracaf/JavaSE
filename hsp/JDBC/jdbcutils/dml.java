package yuan.hsp.JDBC.jdbcutils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

import org.junit.jupiter.api.Test;
@SuppressWarnings("all")
//��ʾJDBC������ʹ��
public class dml {
@Test
	public void testDML() throws SQLException {
	Connection connection = null;
	//����֯sql���
	String sql="update actor set name= ? where id = ? ";
	PreparedStatement prepareStatement=null;
	try {
		connection=JDBCUtils.getConnection(); 
		prepareStatement = connection.prepareStatement(sql);
		prepareStatement.setString(1, "���ǳ�");
		prepareStatement.setInt(2, 4);
		
		prepareStatement.executeUpdate();
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	finally {
		JDBCUtils.close(null, prepareStatement, connection);
	}

}

}
