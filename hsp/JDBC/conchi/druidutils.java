package yuan.hsp.JDBC.conchi;
//搞一个用德鲁伊连接池连接mysql数据库的工具类
import java.io.FileInputStream;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;
import javax.sql.DataSource;
import com.alibaba.druid.pool.DruidDataSourceFactory;
import com.mysql.jdbc.Connection;
import com.mysql.jdbc.Statement;
@SuppressWarnings("all")
public class druidutils {
	private static DataSource ds;
	static {
		Properties properties = new Properties();
		try {
			properties.load(new FileInputStream("src\\druid.properties"));
			ds=DruidDataSourceFactory.createDataSource(properties);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public static java.sql.Connection getConnection() throws SQLException {
		return ds.getConnection();
	}
	//这里的关闭不是真正意义上的关闭！而是断掉连接放回对象池
	public static void close (ResultSet resultSet, Statement statement,java.sql.Connection connection) throws SQLException {
		if (resultSet!=null) 
			resultSet.close();
		
		if (statement!=null) 
			statement.close();
		
		if(connection!=null)
			connection.close();
		
	}
}
