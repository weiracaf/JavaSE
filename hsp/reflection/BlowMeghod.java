package yuan.hsp.reflection;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

//���Ʒ���
@SuppressWarnings({"all"})
public class BlowMeghod {
public static void main(String[] args) throws InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException {
	//��ȡClass����
	Class boss = boss.class;
	//��������
	Object newInstance = boss.getDeclaredConstructor().newInstance();
	Method hi = boss.getDeclaredMethod("hi",String.class);//ע�⣬��������в������ڷ�����������ǲ����б��Ӧclass���󣬲�Ȼ��ȡ����
	
	//����
	hi.invoke(newInstance, "6666");
	//���ƣ�����private static����
	Method declaredMethod = boss.getDeclaredMethod("say", int.class, String.class, char.class);
	declaredMethod.setAccessible(true);
	System.out.println(declaredMethod.invoke(null, 2,"��",'c'));//��Ϊ��privateֱ���ûᱨ��Ҫȡ��һ�·��ʵ���
	//null���Ի���0/����ʵ������Ϊ�Ǿ�̬��
	
	//����.invoke�еķ���ֵĬ�϶���Object��var�Ļ�
}
}
@SuppressWarnings({"all"})
class boss{
	public int age;
	private static String name;
	public boss() {
		
	}
	private static String say(int n,String s,char c) {
		return n+" "+s+" "+c;
	}
	public void hi(String s) {
		System.out.println("hi"+s);
	}
	
}