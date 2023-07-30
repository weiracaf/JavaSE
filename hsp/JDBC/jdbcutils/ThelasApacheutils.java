package yuan.hsp.JDBC.jdbcutils;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.junit.jupiter.api.Test;

import yuan.hsp.JDBC.conchi.druidutils;

//��commons-dbutilsҲ��Ŀǰ���Ч�Ĺ������-��Ҫ����jar��
public class ThelasApacheutils {
	public static void main(String[] args) throws Exception {
		//1.�õ�����(druid)
		Connection connection = druidutils.getConnection();
		//2.������Ӧjar��
		//3.����QueryRunner
		QueryRunner queryRunner = new QueryRunner();
		//4.ִ����صķ�������ArrayList�����
		String sql="select * from actor where id >= ?";
		//���ͣ�
		//query��������1.ִ��sql��䣬�õ�result---��װ��--��ArrayList�����У�Ȼ�󷵻ؼ���
		//2.sql������������Ҫִ�е����
		//3.��Ҫ�ȵõ�connection����
		//4.new BeanListHandler<>(Actor.class)���ڽ�resultSet->Actor����-����װ��ArrayList������
		//��class���󿴾�������ݽṹ-����sql�ĸ���������java���ĸ��������ײ��÷������
		//5.���Ĳ���1���Ǵ�������sql����?�ģ��ж���ʺž�д���������˳��д�����
		//6.�ײ�õ���resultset����query�رգ����еײ㴴����prepareStatementҲ��رգ�����ֻ��Ҫ�ͷ����Ӽ���
		List<Actor> query = queryRunner.query(connection, sql, new BeanListHandler<>(Actor.class), 1);
		System.out.println("���������Ϣ");
		for (Actor q : query) {
			System.out.println(q);
		}
		//5.�ͷ���Դ
		druidutils.close(null, null, connection);
		
	}
	@Test
	public void tset_cha2() throws SQLException {
		//1.��ȡ����
		Connection connection = druidutils.getConnection();
		//2.����QueryRunner������֯sql���
		QueryRunner queryRunner = new QueryRunner();
		String sql="select * from actor where id = ?";
		//3.��SQL���Ҫ���ص��������������Ǵ����Ķ�����յĻ�����Ӧ��ResultSetHandler��ʵ����ΪBeanHandler
		Actor query = queryRunner.query(connection, sql, new BeanHandler<>(Actor.class), 1);
		System.out.println(query.getName()+query.getPhone()+query.getSex());
		//4.�ͷ���Դ
		druidutils.close(null, null, connection);
	}
	@Test
	public void tset_cha3() throws SQLException {
		//1.��ȡ����
		Connection connection = druidutils.getConnection();
		//2.����QueryRunner������֯sql���
		QueryRunner queryRunner = new QueryRunner();
		String sql="select * from actor where id = ?";
		//3.��SQL���Ҫ���ص��������������Ǵ����Ķ�����յĻ�����Ӧ��ResultSetHandler��ʵ����ΪBeanHandler
		Actor query = queryRunner.query(connection, sql, new BeanHandler<>(Actor.class), 1);
		System.out.println(query.getName()+query.getPhone()+query.getSex());
		//4.�ͷ���Դ
		druidutils.close(null, null, connection);
	}
	@Test
	public void tset_DML() throws SQLException {
		//1.��ȡ���� 
		Connection connection = druidutils.getConnection();
		//2.����QueryRunner������֯sql���
		QueryRunner queryRunner = new QueryRunner();
		String sql="update actor set name = ? where id = ?";
		//3.updateִ��dml���
		int update = queryRunner.update(connection, sql, "����", 4);
		//���ص�����Ӱ�������
		System.out.println("��Ӱ�������λ"+update);
		//4.�ͷ���Դ
		druidutils.close(null, null, connection);
	}

}
