package yuan.learn.basic;
//本篇主要讲课接口奥
//接口类似于抽象类，不过其内部只有抽象方法，我定义了一个Demo01的接口可以进去看看
//接口设计出来主要是解决java只能单继承问题
//1.接口的多态性！！！！！！
//接口的引用可以指向实现接口的类的对象，这点也类似于继承奥
//当然接口也可以做多态数组
//2.接口实现传递性，类似于继承
//接口A实现接口B，则实现A的类，也可用接口B的引用指向
@SuppressWarnings({"all"})
public class Interface implements Demo01 {

	@Override
	public void myMethod() {
		// TODO Auto-generated method stub
		System.out.println("必须实现方法奥");
	}//我创建了一个Demo01接口，我让Interface实现接口
	public static void main(String[] args) {
		Interface interface1 = new Interface();
		System.out.println(interface1.a);	//可以调用对应插入接口的属性
		interface1.Point2D();	//也可以直接调用接口的默认方法类似继承,但不能通过插入接口的类调用接口的静态方法
		//这点和继承不同，因为继承可以通过子类对象调用父类的静态方法,不过规范还是要用类名.静态方法调用
		Demo01.sa();//可以通过这个接口名调用，这点和正常静态方法一致
	}
	
	//接口使用细节
	/*
	 * 1.接口不能被实例化
	 * 
	 * 2.接口的所有方法都是public(也是默认的不写也是public的)，其中的默认都是抽象方法（默认的）不用加abstract了
	 *   所以实现（重写）接口的方法都是public的，因为重写，子类方法修饰符相对于父类可以扩大（或者相同），不可以缩小
	 * 
	 * 3.一个普通的类插入接口必须实现（重写）其所有的方法
	 * 
	 * 4.抽象类实现接口，就可以不实现接口的方法
	 * 
	 * 5.一个类可以实现多个接口（当然每个接口的方法都要重写）
	 * 
	 * 6.接口中的属性只能是final的，而且是public static final 修饰符（默认的），比如说接口中的int a
	 * 
	 * 实际上是public static final int a=1;（必须初始化）
	 * 
	 * 7.接口属性的访问形式，接口名.属性名
	 * 
	 * 8.一个接口不能继承其他的类，但是可以实现（implements）多个别的接口
	 * 
	 * 举例
	 * 
	 * interface A extends B,C{
	 * 
	 * }
	 * 
	 * 9.接口的修饰符只能是public和默认（和类的修饰符一致）
	 * 
	 * 10.实现类似于继承，子类实现父类可以通过（子类.接口的属性）调用接口的属性
	 */

}

