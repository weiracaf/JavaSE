package yuan.hsp.JDBC.conchi;

import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Properties;
import org.junit.jupiter.api.Test;
import com.mchange.v2.c3p0.ComboPooledDataSource;

//���ݿ�C3P0���ݿ����ӳ�
public class C3P0 {
	@Test
public void testc3p0_01() throws Exception {
	//1.����һ������Դ����(ʵ��DataSource�ӿ�)
	ComboPooledDataSource comboPooledDataSource = new ComboPooledDataSource();
	//2.ͨ�������ļ���ȡ�����Ϣ
	Properties properties = new Properties();
	properties.load(new FileInputStream("src\\pra.properties"));
	String user=properties.getProperty("user");
	String password=properties.getProperty("password");
	String url=properties.getProperty("url");
	String driver=properties.getProperty("driver");
	//3.������Դ������ز���
	//ע���������ӹ�����comboPooledDataSource������
	comboPooledDataSource.setDriverClass(driver);
	comboPooledDataSource.setJdbcUrl(url);
	comboPooledDataSource.setUser(user);
	comboPooledDataSource.setPassword(password);
	//4.���ó�ʼ������
	comboPooledDataSource.setInitialPoolSize(10);//���ó�ʼΪ10�����������ӳش��������ж��ٸ����ӣ�
	//���������
	comboPooledDataSource.setMaxPoolSize(50);//���������Ϊ50(���ǵ���10�����꣬������Ҫ�õģ���������-��ൽ50������51��ȥ���еȴ�)
	//����һ��Ч��
	long start = System.currentTimeMillis();
	//5.��ȡ���ӣ�����
	for(int i=0;i<5000;i++) {
	Connection connection = comboPooledDataSource.getConnection();//��������Ǵ�DataSource�ӿ�ʵ�ֵ�
	connection.close();
	}
	long end = System.currentTimeMillis();
	System.out.println("�ķ�ʱ��Ϊ"+(end-start));
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
		System.out.println("�ķ�ʱ��Ϊ"+(end-start));
	}
}
