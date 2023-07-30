package yuan.hsp.reflection;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;

//小作业
@SuppressWarnings({"all"})
public class homework {
public static void main(String[] args) throws ClassNotFoundException, InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException, NoSuchFieldException {
	//获取Class对象
	Class<?> cls = Class.forName("yuan.hsp.reflection.privateTest");
	//创建对象实例
	privateTest a=(privateTest) cls.getDeclaredConstructor().newInstance();
	//获取对应字段
	Field field = cls.getDeclaredField("name");//注意，不加Declared是获取不到我们的private的，你就记住加Declared就可以！！！
	field.setAccessible(true);//爆破一下
	System.out.println("修改前"+a.getName());
	field.set(a, "666");
	System.out.println("修改后"+a.getName());
	
}
}
class privateTest{
	private String name="hellokitty";
	public String getName() {
		return name;
	}
	
}