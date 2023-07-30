package yuan.hsp.reflection;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
@SuppressWarnings({"all"})
//反射爆破属性
public class BlowField {
	public static void main(String[] args) throws InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException, NoSuchFieldException {
		//1.获取Class类
		Class<Student> student = Student.class;
		//2.创建对象
		Student newInstance = student.getDeclaredConstructor().newInstance();
		//3.使用反射得到age属性对象
		//public的可以直接修改操作
		Field field = student.getField("age");
		field.set(newInstance, 88);
		System.out.println(newInstance);
		//4.反射爆破操作name
		
		Field field2 = student.getDeclaredField("name");
		//还是如果没有取消访问调查，无论对对象进行修改操作，都会出错
		System.out.println(field2);
		
		field2.setAccessible(true);//加上这句就ok了
//		field2.set(newInstance, "小袁");//注意就静态变量的设置方式有多种1.实例对象2.null3.0
		field2.set(null, "我"); 
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
