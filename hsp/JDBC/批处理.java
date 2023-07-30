package yuan.hsp.JDBC;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import org.junit.jupiter.api.Test;



public class 批处理 {
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
			//！将语句搞到批量处理包中-》看源码
			prepareStatement.addBatch();
			//当有1000条记录时候批量执行（这个数据量多时候写，不然那个容器也不是无限的）
			if ((i+1)%1000==0) {
				prepareStatement.executeBatch();//批量执行
				prepareStatement.clearBatch();//清空一下
			}
			
		}
		prepareStatement.close();
		connection.close();
		
		
	}

}
