package yuan.hsp.reflection;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;

//С��ҵ
@SuppressWarnings({"all"})
public class homework {
public static void main(String[] args) throws ClassNotFoundException, InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException, NoSuchFieldException {
	//��ȡClass����
	Class<?> cls = Class.forName("yuan.hsp.reflection.privateTest");
	//��������ʵ��
	privateTest a=(privateTest) cls.getDeclaredConstructor().newInstance();
	//��ȡ��Ӧ�ֶ�
	Field field = cls.getDeclaredField("name");//ע�⣬����Declared�ǻ�ȡ�������ǵ�private�ģ���ͼ�ס��Declared�Ϳ��ԣ�����
	field.setAccessible(true);//����һ��
	System.out.println("�޸�ǰ"+a.getName());
	field.set(a, "666");
	System.out.println("�޸ĺ�"+a.getName());
	
}
}
class privateTest{
	private String name="hellokitty";
	public String getName() {
		return name;
	}
	
}