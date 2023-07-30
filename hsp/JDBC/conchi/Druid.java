package yuan.hsp.JDBC.conchi;

import java.io.FileInputStream;

import java.sql.Connection;
import java.util.Properties;
import javax.sql.DataSource;

import org.junit.jupiter.api.Test;

import com.alibaba.druid.pool.DruidDataSourceFactory;


//���Ե�³��ʹ��
public class Druid {
	
	@Test
public void testdruid() throws Exception {
	//1.jar������������ļ����뵽srcĿ¼����
	//��������ļ���properties�������и������ݿ����ӳص���Ϣ
	//-#max wait time (5000 mil seconds)�ر����һ���������ȴ�ʱ�䣬�ȴ��������ʱ�䣬�����ȴ���һ����������
	//2.����properties��ȡ
	Properties properties = new Properties();
	properties.load(new FileInputStream("src\\druid.properties"));
	//3.����һ��ָ�������ݿ����ӳ�
	DataSource createDataSource = DruidDataSourceFactory.createDataSource(properties);
	long start = System.currentTimeMillis();
	for(int i=0;i<5000;i++) {
	Connection connection = createDataSource.getConnection();
	connection.close();//������ǹرղ���ʱ�����Ƿ�������
	}
	long end = System.currentTimeMillis();
	System.out.println("����ʱ��"+(end-start));
}
}
