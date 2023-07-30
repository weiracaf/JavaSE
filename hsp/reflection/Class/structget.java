package yuan.hsp.reflection.Class;

import java.lang.annotation.Annotation;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.Iterator;

//常用方法进行一个类的信息获取
@SuppressWarnings({"all"})
public class structget {
	public static void main(String[] args) throws ClassNotFoundException {
		//1.得到class对象-forName，前面有好多得到类名的方法
		Class cls = Class.forName("yuan.hsp.reflection.Class.Person");
		//2.getName：获取全类名
		System.out.println(cls.getName());
		//3.getSimpleName:获取简单类名
		System.out.println(cls.getSimpleName());
		//4.getFields:获取所有public修饰的属性，包含父类以及本类的
		Field[] fields = cls.getFields();
		for(Field aField:fields) {
			System.out.println("public本类属性和父类的"+aField.getName());
		}
		//5.getDeclaredFields:获取本类的所有属性
		Field[] declaredFields = cls.getDeclaredFields();
		for(Field bField:declaredFields) {
			System.out.println("本类所有属性"+bField.getName());
		}
		//6.getMethods:获取所有的public修饰的方法，包含本类以及父类的
		Method[] methods = cls.getMethods();
		for(Method cMethod:methods) {
			System.out.println("public本类和父类方法"+cMethod.getName());
		}
		
		//7.getDeclaredMethods:获取本类的所有方法
		Method[] declaredMethods = cls.getDeclaredMethods();
		for(Method dMethod:declaredMethods) {
			System.out.println("本类所有方法"+dMethod.getName());
		}
		
		//8.getConstructors:获取所有public修饰构造器，包含本类
		Constructor[] constructors = cls.getConstructors();
		for(Constructor e:constructors) {
		System.out.println("获取public构造器本类"+e.getName());
		}
		//9.getDeclaredConstructors:获取本类所有构造器
		Constructor[] declaredConstructors = cls.getDeclaredConstructors();
		for(Constructor g:declaredConstructors) {
			System.out.println("本类的所有构造器"+g.getName());
		}
		//10.getPackage:以Package形式返回包信息
		System.out.println(cls.getPackageName());
		//11.getSuperClass:以Class形式返回父类信息
		System.out.println("父类Class对象获取简单类名"+cls.getSuperclass().getSimpleName());
		//12.getInterfaces:以Class[]返回接口信息
		Class[] interfaces = cls.getInterfaces();
		for(Class h:interfaces) {
			System.out.println("接口"+h.getSimpleName());
		}
		//13.getAnnotations:以Annotation[]形式返回注解信息
	  Annotation[] annotations = cls.getAnnotations();
	  for(Annotation i:annotations) {
		  System.out.println("注解"+i);
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
