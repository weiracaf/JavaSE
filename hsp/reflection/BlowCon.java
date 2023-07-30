package yuan.hsp.reflection;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;



//һЩ���䱬�Ʋ�������ʵԭ��һ��
@SuppressWarnings({"all"})
public class BlowCon {
public static void main(String[] args) throws InstantiationException, IllegalAccessException, NoSuchMethodException, SecurityException, IllegalArgumentException, InvocationTargetException {
	//�Ȼ�ȡUser��Class����
	Class<?> cls = User.class;
	//1.ͨ��public�޲ι���ʵ��
	User a =(User) cls.newInstance();//��������Ѿ������ˣ���ò�Ҫ��
	User newInstance2 = (User)cls.getDeclaredConstructor().newInstance();//����һ�����������
	//�Ȼ�ȡ�޲�publicȻ��newInstance
	System.out.println(newInstance2);
	//2.ͨ��public���вι���������
	Constructor<?> constructor = cls.getConstructor(String.class);
//	���Ǵ���Ĳ�������ɶ�Ӧ�������͵�Class���󣬲��ܻ�ȡ��Ӧ�Ĺ�����
	User bUser=(User) constructor.newInstance("СԬ");
	System.out.println(bUser);
	//3.ͨ����public���вι���������
	//ֻ�д�Declared�ķ����ſ��ܻ�ȡ����public�ģ����Կ����͵�ͼƬ��Java֮�������
	//�Ȼ�ȡprivate��constructor
	Constructor<?> declaredConstructor = cls.getDeclaredConstructor(int.class, String.class);
	
	//ע�⣬����ֱ��newInstance�ᱨ����Ϊ���ǵ���private�ķ���������
	//��������֮ǰѧ��һ��������Ҳ����߷���Ч�ʵĲ���
	declaredConstructor.setAccessible(true);//����ͽ������ƣ�û����仰�ᱨ��
//	���������true��ȡ�����������ʵ��飬�������Ǿ����ڱ������private����/����
	//�ڷ�����ǰ��һ�ж���ֽ�ϻ�
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
	public User(String name){//�޲�public
		this.name=name;
		
	}
	@Override
	public String toString() {
		return "User [age=" + age + ", name=" + name + "]";
	}
	
}
