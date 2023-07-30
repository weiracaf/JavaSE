package yuan.hsp.JDBC.jdbcutils;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.junit.jupiter.api.Test;

import yuan.hsp.JDBC.conchi.druidutils;

//用commons-dbutils也是目前最高效的工具类库-需要导入jar包
public class ThelasApacheutils {
	public static void main(String[] args) throws Exception {
		//1.得到连接(druid)
		Connection connection = druidutils.getConnection();
		//2.引入相应jar包
		//3.创建QueryRunner
		QueryRunner queryRunner = new QueryRunner();
		//4.执行相关的方法返回ArrayList结果集
		String sql="select * from actor where id >= ?";
		//解释：
		//query方法就是1.执行sql语句，得到result---封装到--》ArrayList集合中，然后返回集合
		//2.sql语句就是我们需要执行的语句
		//3.需要先得到connection连接
		//4.new BeanListHandler<>(Actor.class)：在将resultSet->Actor对象-》封装到ArrayList对象中
		//传class对象看具体的数据结构-决定sql哪个参数传给java类哪个参数，底层用反射机制
		//5.最后的参数1，是传给我们sql语句的?的，有多个问号就写多个，按照顺序，写到最后
		//6.底层得到的resultset会在query关闭，还有底层创建的prepareStatement也会关闭，我们只需要释放连接即可
		List<Actor> query = queryRunner.query(connection, sql, new BeanListHandler<>(Actor.class), 1);
		System.out.println("输出集合信息");
		for (Actor q : query) {
			System.out.println(q);
		}
		//5.释放资源
		druidutils.close(null, null, connection);
		
	}
	@Test
	public void tset_cha2() throws SQLException {
		//1.获取连接
		Connection connection = druidutils.getConnection();
		//2.创建QueryRunner对象，组织sql语句
		QueryRunner queryRunner = new QueryRunner();
		String sql="select * from actor where id = ?";
		//3.看SQL语句要返回单个，这里用我们创建的对象接收的话，对应的ResultSetHandler的实现类为BeanHandler
		Actor query = queryRunner.query(connection, sql, new BeanHandler<>(Actor.class), 1);
		System.out.println(query.getName()+query.getPhone()+query.getSex());
		//4.释放资源
		druidutils.close(null, null, connection);
	}
	@Test
	public void tset_cha3() throws SQLException {
		//1.获取连接
		Connection connection = druidutils.getConnection();
		//2.创建QueryRunner对象，组织sql语句
		QueryRunner queryRunner = new QueryRunner();
		String sql="select * from actor where id = ?";
		//3.看SQL语句要返回单个，这里用我们创建的对象接收的话，对应的ResultSetHandler的实现类为BeanHandler
		Actor query = queryRunner.query(connection, sql, new BeanHandler<>(Actor.class), 1);
		System.out.println(query.getName()+query.getPhone()+query.getSex());
		//4.释放资源
		druidutils.close(null, null, connection);
	}
	@Test
	public void tset_DML() throws SQLException {
		//1.获取连接 
		Connection connection = druidutils.getConnection();
		//2.创建QueryRunner对象，组织sql语句
		QueryRunner queryRunner = new QueryRunner();
		String sql="update actor set name = ? where id = ?";
		//3.update执行dml语句
		int update = queryRunner.update(connection, sql, "郭靖", 4);
		//返回的是受影响的行数
		System.out.println("受影响的行数位"+update);
		//4.释放资源
		druidutils.close(null, null, connection);
	}

}
