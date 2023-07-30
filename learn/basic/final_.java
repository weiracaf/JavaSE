package yuan.learn.basic;
//本篇主要讲final关键字
public class final_ {
public static void main(String[] args) {
	//final可以修饰很多东西比如类、属性、方法和局部变量都可以
	//final修饰类，该类不可继承
	//final修饰方法的时候，该方法不可被子类重写
	//final修饰属性、局部变量的时候，该属性的值不可修改
	//final修饰引用的时候，只是指向的对象不可改变，对象里的值是可以改变的
	//final修饰的值如果不是静态，在1.定义时2.构造器3.代码块
	//三者一个中赋值即可
	//如果修饰的是静态的1.定义时2.静态代码块
	//只能在这两个中选一个
	//因为静态属性的加载是比普通属性要先的！
	
	//final和static搭配使用效率更高
	//public static int a=8;用类名.a调用时会导致类加载
	//如果是public final static int a=8;调用这个就不会导致类加载
	//我们可以用静态代码块验证一下
	System.out.println(add.b);
	System.out.println(add.c);
	//ok了
}
}
class add{
	public static int c=8;
	public final static int b=10;
	static {
		System.out.println("a类被加载");
	}
}
