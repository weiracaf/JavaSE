package yuan.hsp.reflection;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Properties;

import org.junit.jupiter.api.MethodOrderer.MethodName;
@SuppressWarnings({"all"})
//反射机制的简单介绍
public class introduce {
	public static void main(String[] args) throws IOException, ClassNotFoundException, InstantiationException, 
	IllegalAccessException, NoSuchMethodException, SecurityException, 
	IllegalArgumentException, InvocationTargetException, NoSuchFieldException {//这异常有点多，你忍一下
//	1.正常想调用对应的方法
//	Cat cat = new Cat();
//	cat.hi();
//	2.使用properties类，通过配置文件来进行对应方法的调用，先读取配置文件
		Properties properties = new Properties();
//		properties.load(new FileInputStream("d:\\eclipseworkspace\\Learn\\src\\re.properties"));
		properties.load(new FileInputStream("src\\re.properties"));
		String classfullpath = properties.get("classfullpath").toString();
		String Method = properties.get("method").toString();
		System.out.println(classfullpath);
		System.out.println(Method);
		
//		3.反射机制运用
		//1.加载类，返回Class对象cls
		Class cls = Class.forName(classfullpath);
		//2.通过cls创建对象实例
		Object newInstance = cls.newInstance();
		System.out.println(newInstance.getClass());
		//3.通过对cls来获取到我们对应的对象方法，在反射中万物皆是对象
		Method method1 = cls.getMethod(Method);
		//4.通过method1调用方法，调用格式：方法对象.invoke(实例对象)
		System.out.println("==============================");
		method1.invoke(newInstance);
		//好处就是可以通过该配置文件来改变调用方法，不用修改源代码
		
//		一些常用类的方法
		//java.lang.reflect.Field:代表类的成员变量，Field对象表示某个类的成员变量
		//得到age字段吧，因为private的name是无法用getField获取
		Field field = cls.getField("age");
		System.out.println(field.get(newInstance));//成员变量对象.get(实例对象)
		
		Constructor constructor = cls.getConstructor();
		System.out.println(constructor);
		
		Constructor constructor2 = cls.getConstructor(String.class);
		System.out.println(constructor2);
		
		
		
		
		
		
		
	}
}
