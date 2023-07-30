package yuan.hsp.JDBC;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import yuan.hsp.JDBC.jdbcutils.JDBCUtils;

public class 事务处理 {
public static void main(String[] args) throws SQLException {
	Connection connection = JDBCUtils.getConnection();
	connection.setAutoCommit(false);
	String sql="update account set money = money-100 where id=1";
	String sql2="update account set money = money+100 where id=100";
	PreparedStatement prepareStatement = connection.prepareStatement(sql);
	prepareStatement.execute();
	prepareStatement.execute(sql2);
	connection.commit();
	JDBCUtils.close(null, prepareStatement, connection);
	

	
	
}
}
