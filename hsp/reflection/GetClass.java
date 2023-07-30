package yuan.hsp.reflection;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

//本篇主要是获取Class类的各种方法
@SuppressWarnings({"all"})
public class GetClass {
	public static void main(String[] args) throws ClassNotFoundException, FileNotFoundException, IOException {
		//1.Class.forName(对应类的全路径)-常用于配置文件读取类全路径，加载类
		Properties properties = new Properties();
		properties.load(new FileInputStream("src\\re.properties"));
		String classfullpath = properties.get("classfullpath").toString();
		Class cls1 = Class.forName(classfullpath);
		System.out.println(cls1);
		//2.若已知具体的类，通过类的class获取，该方式最安全可靠程序性能最高-多用于参数传递
		Class cls2 = Cat.class;
		System.out.println(cls2);
		//3.已知某个类的实例，调用该对应的getClass()方法，获取对象所属类对应的Class对象-应用场景：通过建好的对象，获取Class对象（运行类型）
		Cat cat = new Cat();
		Class cls3 = cat.getClass();
		System.out.println(cls3);
		//4.通过类加载器获取类的Class对象
		//(1)先得到类加载器cat
		ClassLoader classLoader = cat.getClass().getClassLoader();
		//(2)通过类加载器得到Class对象
		Class cls4 = classLoader.loadClass(classfullpath);
		System.out.println(cls4);
		//cls1,cls2,cls3,cls4都是同一个Class对象
		
		//基本数据类型获取class的两种方式
		//1.(基本数据类型int,short,long).class得到Class对象
		Class<Integer> i = int.class;
		Class<Character> c = char.class;
		System.out.println(i);
		System.out.println(c);
		//2.基本数据类型对应的包装类.type,获得对应的Class对象
		Class<Integer> type = Integer.TYPE;
		System.out.println(type);
		//然后其实这个int和Integer其实是对应的一个Class,int自动装箱为Integer获取对应的Class对象
		System.out.println(i.hashCode());
		System.out.println(type.hashCode());
	}

}
