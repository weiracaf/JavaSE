package yuan.hsp.JDBC;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

import com.mysql.jdbc.Driver;
@SuppressWarnings({"all"})
// 第一个JDBC程序演示一些简单操作
public class JDBC01 {
	public static void main(String[] args) throws SQLException {
		//前置工作：项目下建一个文件夹
		//把mysql.jar拷贝到该目录下然后Add to project加入到项目中才能使用mysql连接jdbc的jar文件（一些接口个包）
		//1.注册驱动
		Driver driver = new Driver();//Driver就是对应的一个类 
		
		//2.得到连接
		//jdbc:mysql://表示jdbc连接mysql，localhost是主机ip（本机主机localhost就可以），3306对应mysql端口
		//db02对应想要连接的数据库，mysql连接本质还是socket连接
		String url="jdbc:mysql://localhost:3306/db02";
		//将用户名和密码放到properties对象中（注册操作）
		//!user和password是规定好的，就是对应用户名和密码，不要写成其他的
		Properties properties = new Properties();
		properties.setProperty("user", "root");//用户
		properties.setProperty("password", "123456");//密码
		
		Connection connect = driver.connect(url, properties);//得到连接
		//3.执行sql语句 
		String sql = "insert into actor values(null,'刘德华','男','1970-11-11','110')";
		//创建一个statement对象（执行静态sql语句，返回生成结果的对象）
		Statement Statement = connect.createStatement();
		int executeUpdate = Statement.executeUpdate(sql);//dml语句返回受影响的行数
		
		System.out.println(executeUpdate);
		//4.关闭连接(先开后闭)
		Statement.close();
		connect.close();
		
	}

}

