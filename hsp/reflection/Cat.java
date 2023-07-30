package yuan.hsp.reflection;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
@SuppressWarnings({"all"})
//��ʾ�����
//����һ��ʱ��Ա������з�����Ż�
public class Cat {
	public static void main(String[] args) throws ClassNotFoundException, InstantiationException, 
	IllegalAccessException, NoSuchMethodException, SecurityException, IllegalArgumentException, 
	InvocationTargetException {
		Cat cat = new Cat();
		cat.m1();
		cat.m2();
		cat.m3();
		
	}
	
	//����Ϊ�˷������ǹ۲죬��hi()���������ע��
	//m1����ͨ�Ķ�����÷���
	//m2�����÷�����Ƶ��÷�����ȡ�����ʵ���
	//m3û�е���setAccessible(true)��û��ȡ�����ʵ���
	//���Է���Ч�ʲ��ܴ���ô�����Ż��أ�
	public void m1() {
		Cat cat = new Cat();
		long start = System.currentTimeMillis();
		for(int i =0;i<900000000;i++) {
			cat.hi();
		}
		long end = System.currentTimeMillis();
		System.out.println("m1��ʱ"+(end-start));
	}
	public void m2() throws ClassNotFoundException, InstantiationException, IllegalAccessException, 
	NoSuchMethodException, SecurityException, IllegalArgumentException, InvocationTargetException {
		Class cls = Class.forName("yuan.hsp.reflection.Cat");
		Object cat = cls.newInstance();
		Method method = cls.getMethod("hi");
		method.setAccessible(true);//ȡ�����ʼ�飬���Ч��
		
		
		
		long start = System.currentTimeMillis();
		for(int i =0;i<900000000;i++) {
			method.invoke(cat);
		}
		long end = System.currentTimeMillis();
		System.out.println("m2=��ʱ"+(end-start));
		
	}
	public void m3() throws ClassNotFoundException, InstantiationException, IllegalAccessException, 
	NoSuchMethodException, SecurityException, IllegalArgumentException, InvocationTargetException {
		Class cls = Class.forName("yuan.hsp.reflection.Cat");
		Object cat = cls.newInstance();
		Method method = cls.getMethod("hi");
			
		long start = System.currentTimeMillis();
		for(int i =0;i<900000000;i++) {
			method.invoke(cat);
		}
		long end = System.currentTimeMillis();
		System.out.println("m3=��ʱ"+(end-start));
		
	}
	
	private String name="�в�è";
	public int age =10;
	

	public Cat() {
		super();
	}
	public Cat(String name) {
		super();
		this.name = name;
	}
	public void hi() {
//		System.out.println("hi"+name);
	}
	public void cry() {
		System.out.println(name+"������...");
	}
}
