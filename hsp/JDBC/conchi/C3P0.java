package yuan.hsp.JDBC.conchi;

import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Properties;
import org.junit.jupiter.api.Test;
import com.mchange.v2.c3p0.ComboPooledDataSource;

//数据库C3P0数据库连接池
public class C3P0 {
	@Test
public void testc3p0_01() throws Exception {
	//1.创建一个数据源对象(实现DataSource接口)
	ComboPooledDataSource comboPooledDataSource = new ComboPooledDataSource();
	//2.通过配置文件获取相关信息
	Properties properties = new Properties();
	properties.load(new FileInputStream("src\\pra.properties"));
	String user=properties.getProperty("user");
	String password=properties.getProperty("password");
	String url=properties.getProperty("url");
	String driver=properties.getProperty("driver");
	//3.给数据源设置相关参数
	//注意我们连接管理由comboPooledDataSource来管理
	comboPooledDataSource.setDriverClass(driver);
	comboPooledDataSource.setJdbcUrl(url);
	comboPooledDataSource.setUser(user);
	comboPooledDataSource.setPassword(password);
	//4.设置初始连接数
	comboPooledDataSource.setInitialPoolSize(10);//设置初始为10个（就是连接池创建里面有多少个连接）
	//最大连接数
	comboPooledDataSource.setMaxPoolSize(50);//最大连接数为50(就是当你10个用完，还有想要用的，增加连接-最多到50个，第51个去队列等待)
	//测试一下效率
	long start = System.currentTimeMillis();
	//5.获取连接！核心
	for(int i=0;i<5000;i++) {
	Connection connection = comboPooledDataSource.getConnection();//这个方法是从DataSource接口实现的
	connection.close();
	}
	long end = System.currentTimeMillis();
	System.out.println("耗费时间为"+(end-start));
}
	@Test
	public void CP30test02() throws SQLException {
		ComboPooledDataSource comboPooledDataSource = new ComboPooledDataSource("hello");
		long start = System.currentTimeMillis();
		for(int i=0;i<5000;i++) {
			Connection connection = comboPooledDataSource.getConnection();
			connection.close();
		}
		long end = System.currentTimeMillis();
		System.out.println("耗费时间为"+(end-start));
	}
}
