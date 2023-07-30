package yuan.hsp.reflection;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

//爆破方法
@SuppressWarnings({"all"})
public class BlowMeghod {
public static void main(String[] args) throws InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException {
	//获取Class对象
	Class boss = boss.class;
	//创建对象
	Object newInstance = boss.getDeclaredConstructor().newInstance();
	Method hi = boss.getDeclaredMethod("hi",String.class);//注意，如果方法有参数，在方法名后面就是参数列表对应class对象，不然获取不到
	
	//调用
	hi.invoke(newInstance, "6666");
	//爆破，调用private static方法
	Method declaredMethod = boss.getDeclaredMethod("say", int.class, String.class, char.class);
	declaredMethod.setAccessible(true);
	System.out.println(declaredMethod.invoke(null, 2,"个",'c'));//因为是private直接用会报错，要取消一下访问调查
	//null可以换成0/对象实例，因为是静态的
	
	//方法.invoke中的返回值默认都是Object打var的话
}
}
@SuppressWarnings({"all"})
class boss{
	public int age;
	private static String name;
	public boss() {
		
	}
	private static String say(int n,String s,char c) {
		return n+" "+s+" "+c;
	}
	public void hi(String s) {
		System.out.println("hi"+s);
	}
	
}