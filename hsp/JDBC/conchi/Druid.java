package yuan.hsp.JDBC.conchi;

import java.io.FileInputStream;

import java.sql.Connection;
import java.util.Properties;
import javax.sql.DataSource;

import org.junit.jupiter.api.Test;

import com.alibaba.druid.pool.DruidDataSourceFactory;


//测试德鲁伊使用
public class Druid {
	
	@Test
public void testdruid() throws Exception {
	//1.jar包导入和配置文件加入到src目录下面
	//这个配置文件（properties）里面有各种数据库连接池的信息
	//-#max wait time (5000 mil seconds)特别解释一下这个是最长等待时间，等待超过这个时间，放弃等待下一次申请连接
	//2.创建properties读取
	Properties properties = new Properties();
	properties.load(new FileInputStream("src\\druid.properties"));
	//3.创建一个指定的数据库连接池
	DataSource createDataSource = DruidDataSourceFactory.createDataSource(properties);
	long start = System.currentTimeMillis();
	for(int i=0;i<5000;i++) {
	Connection connection = createDataSource.getConnection();
	connection.close();//这个不是关闭操作时间上是返还操作
	}
	long end = System.currentTimeMillis();
	System.out.println("消耗时间"+(end-start));
}
}
