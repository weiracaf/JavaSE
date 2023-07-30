package yuan.hsp.reflection;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;



//一些反射爆破操作，其实原理都一样
@SuppressWarnings({"all"})
public class BlowCon {
public static void main(String[] args) throws InstantiationException, IllegalAccessException, NoSuchMethodException, SecurityException, IllegalArgumentException, InvocationTargetException {
	//先获取User的Class对象
	Class<?> cls = User.class;
	//1.通过public无参构造实例
	User a =(User) cls.newInstance();//不过这个已经弃用了，最好不要用
	User newInstance2 = (User)cls.getDeclaredConstructor().newInstance();//现在一般用这个方法
	//先获取无参public然后newInstance
	System.out.println(newInstance2);
	//2.通过public的有参构造器创建
	Constructor<?> constructor = cls.getConstructor(String.class);
//	我们传入的参数，变成对应参数类型的Class对象，才能获取对应的构造器
	User bUser=(User) constructor.newInstance("小袁");
	System.out.println(bUser);
	//3.通过非public的有参构造器创建
	//只有带Declared的方法才可能获取到非public的，可以看博客的图片在Java之类加载中
	//先获取private的constructor
	Constructor<?> declaredConstructor = cls.getDeclaredConstructor(int.class, String.class);
	
	//注意，这里直接newInstance会报错，因为我们调用private的方法它会检测
	//所以我们之前学过一个操作，也是提高反射效率的操作
	declaredConstructor.setAccessible(true);//这个就叫做爆破，没有这句话会报错
//	这个参数是true会取消反射对象访问调查，所以我们就能在别的类用private属性/方法
	//在反射面前，一切都是纸老虎
	User cUser=(User)declaredConstructor.newInstance(1,"666");
	System.out.println(cUser);
	
	
	
}
}
@SuppressWarnings({"all"})
class User{
	private int age;
	private String name;
	public User() {
		
	}
	private User(int age,String name){
		this.age=age;
		this.name=name;
	}
	public User(String name){//无参public
		this.name=name;
		
	}
	@Override
	public String toString() {
		return "User [age=" + age + ", name=" + name + "]";
	}
	
}
