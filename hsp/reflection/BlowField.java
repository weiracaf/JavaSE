package yuan.hsp.reflection;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
@SuppressWarnings({"all"})
//���䱬������
public class BlowField {
	public static void main(String[] args) throws InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException, NoSuchFieldException {
		//1.��ȡClass��
		Class<Student> student = Student.class;
		//2.��������
		Student newInstance = student.getDeclaredConstructor().newInstance();
		//3.ʹ�÷���õ�age���Զ���
		//public�Ŀ���ֱ���޸Ĳ���
		Field field = student.getField("age");
		field.set(newInstance, 88);
		System.out.println(newInstance);
		//4.���䱬�Ʋ���name
		
		Field field2 = student.getDeclaredField("name");
		//�������û��ȡ�����ʵ��飬���۶Զ�������޸Ĳ������������
		System.out.println(field2);
		
		field2.setAccessible(true);//��������ok��
//		field2.set(newInstance, "СԬ");//ע��;�̬���������÷�ʽ�ж���1.ʵ������2.null3.0
		field2.set(null, "��"); 
		System.out.println(newInstance);
		
		
	}
}
@SuppressWarnings({"all"})
class Student{
	public int age;
	private static String name;
	public Student(){
		
	}
	@Override
	public String toString() {
		return name+" "+age;
	}
	
	
	
}
