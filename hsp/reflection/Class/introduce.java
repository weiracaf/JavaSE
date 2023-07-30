package yuan.hsp.reflection.Class;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;

import yuan.hsp.reflection.Cat;
@SuppressWarnings({"all"})
//class类的基本介绍
public class introduce {
public static void main(String[] args) throws ClassNotFoundException, InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException, NoSuchFieldException {
	String classPath="yuan.hsp.reflection.Class.Car";
	//1.获取到Car类对应的Class对象
	Class cls = Class.forName(classPath);
	//2.输出cls
	System.out.println(cls);//会显示是哪个类的Class对像（应该是toString重写的）
	System.out.println(cls.getClass());//输出cls的运行类型 java.lang.Class
	//3.得到包名
	System.out.println("================================");
	System.out.println(cls.getPackage().getName());
	System.out.println(cls.getPackageName());//两种都可以
	//4.得到全类名
	System.out.println("================================");
	System.out.println(cls.getName());//返回类名
	//5.通过cls创建对象实例
	Object newInstance = cls.newInstance();//当然这个现在弃用了
	
	Car newInstance2 = (Car)cls.getDeclaredConstructor().newInstance();//现在一般用这个方法
	//先获构造器再创建对象实例
	System.out.println(newInstance2);
	//6.通过反射获取属性brand,注意：私有属性不能通过该方式获取，后面有单独讲
	Field brand = cls.getField("brand");
	System.out.println(brand.get(newInstance2));
	//7.通过反射给属性赋值
	brand.set(newInstance2, "奔驰");
	System.out.println(brand.get(newInstance2));
	//8.希望可以得到Car里所有的属性
	System.out.println("======================================");
	Field[] fields = cls.getFields();
	for (Field field : fields) {
		System.out.println(field.getName());//依次输出属性的名称
	}
	
	
}
}

class Car{
	public String brand="宝马";
	public int price=1000000;
	public String color="白";
	@Override
	public String toString() {
		return "Car [brand=" + brand + ", price=" + price + ", color=" + color + "]";
	}
	
}
