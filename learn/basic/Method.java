package yuan.learn.basic;
@SuppressWarnings({"all"})
//这期主要讲方法调用机制以及访问修饰符
//访问修饰符分为，public-不同包都可以调用，，protected-本类同包子类可调用，不同包不可以调用，默认-子类不同包不能调用，本类和同包可以
//private-只有本类可以调用
public class Method {
	public static void main(String[] args) {
		int c = 0;
		float b=2;
		A a = new A();//访同一个包的java文件的其他类和自己类的非static方法的时候一定要先实例化才能调用
		a.say();
		Method method = new Method();
		method.he();
		say6();	//访问本类的static直接调用即可，也可类名+方法名
		A.say7();//访问本java文件的其他类的static一定要类名+方法名
		
		//想要调用别的包的文件的java文件的类的方法要先进行导入（import）
		//这里不演示了奥
		
	}
	public void he() {
		System.out.println("he");
	}
	public static void say6() {
		System.out.println("method类"+"6");
	}
	
}

class A{
    public void say(){
        System.out.println("Hello");
    }
    public static void say7() {
		System.out.println("7");
	}
}