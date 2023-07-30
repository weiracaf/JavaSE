package yuan.hsp.JDBC.conchi;
//��һ���õ�³�����ӳ�����mysql���ݿ�Ĺ�����
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
	//����Ĺرղ������������ϵĹرգ����Ƕϵ����ӷŻض����
	public static void close (ResultSet resultSet, Statement statement,java.sql.Connection connection) throws SQLException {
		if (resultSet!=null) 
			resultSet.close();
		
		if (statement!=null) 
			statement.close();
		
		if(connection!=null)
			connection.close();
		
	}
}
