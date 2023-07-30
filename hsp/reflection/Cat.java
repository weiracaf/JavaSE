package yuan.hsp.reflection;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
@SuppressWarnings({"all"})
//演示类罢了
//还有一个时间对比来进行反射的优化
public class Cat {
	public static void main(String[] args) throws ClassNotFoundException, InstantiationException, 
	IllegalAccessException, NoSuchMethodException, SecurityException, IllegalArgumentException, 
	InvocationTargetException {
		Cat cat = new Cat();
		cat.m1();
		cat.m2();
		cat.m3();
		
	}
	
	//这里为了方便我们观察，把hi()输出的内容注释
	//m1是普通的对象调用方法
	//m2就是用反射机制调用方法，取消访问调查
	//m3没有调用setAccessible(true)，没有取消访问调查
	//可以发现效率差距很大，怎么进行优化呢？
	public void m1() {
		Cat cat = new Cat();
		long start = System.currentTimeMillis();
		for(int i =0;i<900000000;i++) {
			cat.hi();
		}
		long end = System.currentTimeMillis();
		System.out.println("m1耗时"+(end-start));
	}
	public void m2() throws ClassNotFoundException, InstantiationException, IllegalAccessException, 
	NoSuchMethodException, SecurityException, IllegalArgumentException, InvocationTargetException {
		Class cls = Class.forName("yuan.hsp.reflection.Cat");
		Object cat = cls.newInstance();
		Method method = cls.getMethod("hi");
		method.setAccessible(true);//取消访问检查，提高效率
		
		
		
		long start = System.currentTimeMillis();
		for(int i =0;i<900000000;i++) {
			method.invoke(cat);
		}
		long end = System.currentTimeMillis();
		System.out.println("m2=耗时"+(end-start));
		
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
		System.out.println("m3=耗时"+(end-start));
		
	}
	
	private String name="招财猫";
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
		System.out.println(name+"喵喵叫...");
	}
}
