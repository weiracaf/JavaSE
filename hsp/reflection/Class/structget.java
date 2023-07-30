package yuan.hsp.reflection.Class;

import java.lang.annotation.Annotation;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.Iterator;

//���÷�������һ�������Ϣ��ȡ
@SuppressWarnings({"all"})
public class structget {
	public static void main(String[] args) throws ClassNotFoundException {
		//1.�õ�class����-forName��ǰ���кö�õ������ķ���
		Class cls = Class.forName("yuan.hsp.reflection.Class.Person");
		//2.getName����ȡȫ����
		System.out.println(cls.getName());
		//3.getSimpleName:��ȡ������
		System.out.println(cls.getSimpleName());
		//4.getFields:��ȡ����public���ε����ԣ����������Լ������
		Field[] fields = cls.getFields();
		for(Field aField:fields) {
			System.out.println("public�������Ժ͸����"+aField.getName());
		}
		//5.getDeclaredFields:��ȡ�������������
		Field[] declaredFields = cls.getDeclaredFields();
		for(Field bField:declaredFields) {
			System.out.println("������������"+bField.getName());
		}
		//6.getMethods:��ȡ���е�public���εķ��������������Լ������
		Method[] methods = cls.getMethods();
		for(Method cMethod:methods) {
			System.out.println("public����͸��෽��"+cMethod.getName());
		}
		
		//7.getDeclaredMethods:��ȡ��������з���
		Method[] declaredMethods = cls.getDeclaredMethods();
		for(Method dMethod:declaredMethods) {
			System.out.println("�������з���"+dMethod.getName());
		}
		
		//8.getConstructors:��ȡ����public���ι���������������
		Constructor[] constructors = cls.getConstructors();
		for(Constructor e:constructors) {
		System.out.println("��ȡpublic����������"+e.getName());
		}
		//9.getDeclaredConstructors:��ȡ�������й�����
		Constructor[] declaredConstructors = cls.getDeclaredConstructors();
		for(Constructor g:declaredConstructors) {
			System.out.println("��������й�����"+g.getName());
		}
		//10.getPackage:��Package��ʽ���ذ���Ϣ
		System.out.println(cls.getPackageName());
		//11.getSuperClass:��Class��ʽ���ظ�����Ϣ
		System.out.println("����Class�����ȡ������"+cls.getSuperclass().getSimpleName());
		//12.getInterfaces:��Class[]���ؽӿ���Ϣ
		Class[] interfaces = cls.getInterfaces();
		for(Class h:interfaces) {
			System.out.println("�ӿ�"+h.getSimpleName());
		}
		//13.getAnnotations:��Annotation[]��ʽ����ע����Ϣ
	  Annotation[] annotations = cls.getAnnotations();
	  for(Annotation i:annotations) {
		  System.out.println("ע��"+i);
	  }
	}

}

class A{
	public String hobby;
	public void hi() {
		
	}
	
}
interface B{}
interface C{}
@SuppressWarnings({"all"})
@Deprecated
class Person extends A implements B,C{
	public String name;
	protected int age;
	String job;
	private double salary;
	public Person(){
		
	}
	public Person(String name) {
		
	}
	public void m1() {
		
	}
	protected void m2() {
		
	}
	void m3(){
		
	}
	private void m4() {
		
	}
	
	
}
