package yuan.learn.basic;

import java.util.ArrayList;
import java.util.List;

//本篇写泛型奥，关于具体语法和使用细节
//泛型的声明
//interface 接口名<T>{}和class 类名<K,V>{}
//说明：1.T,K,V不代表值，代表类型
//2.任何字母都可以用，常用T，写几个都行接口也可以写多个的
//泛型的实例化，要在类名后面指定类型参数的类型
//List<String> strlist = new ArrayList<String>();
//lterator<Customer> iterator = customers.iterator();

//比如说正常ArrayList,和HashMap其实都有泛型，你不写默认Object
//HashMap<1,2>就有两个，一个是key的类型，一个是value的类型

//有关泛型的使用细节
//1.泛型只能是引用类型，不能是基本类型-你要只传int的话只能写Integer,这也是为什么有包装类的原因之一吧
//2.在指定泛型后，可以传入该类型，或者其子类型（多态）
//3.泛型有多种使用类型
//List<Integer> a = new ArrayList<Integer>();
//List<Integer> b = new ArrayList<>();	////没错就是把右边的那个<>里面的东西去掉 
//List c = new ArrayList();//这种什么都不写把<>删除默认的就是泛型类型为Object
//讲解一下奥
//关于第一种和第二种区别：就是没什么区别
//因为第一个指定了，就后面那个就默认指定和前面那个相同的，编译器会进行类型判断，我们简写就行

//有关自定义泛型-就是我们主动应用泛型
//1.自定义泛型类2.自定义泛型接口3.自定义泛型方法
//1.class 类名<T,R...>{成员}
//注意：普通类可以使用泛型，使用泛型数组不能初始化，静态方法不能用类的泛型，泛型类型在创建时要指定，没有指定就默认Object
//下面是针对注意点的具体解释
//class Tiger<T,R,M>{
//	String name; R r; M m; T t;
//	}
/*1.R和M和T都是数据类型
r和m和t都是属性
可以在成员中使用
比如说构造器还有get和set方法里
public Tiger(R r){	this.r = r; };
static void m1(R r){};就会报错了
2.因为类型没有确定，就不知道要开辟多大空间，所以不能初始化
3.静态方法是和类相关的，不是和对象相关，在类加载时，对象还没有创建
静态方法或者属性使用泛型，JVM不能完成初始化（不知道具体类型，不知道怎么开辟空间）
*/
//2.interface 接口名<T,R...>{		}
//接口静态成员不能用泛型，泛型接口的类型，在继承接口或者实现接口时确定
/*解释1.注意接口中的属性都是静态性质的
接口的属性的修饰符只能是public static final。比如int a = 1; 实际上是public static final int a = 1（必须初始化）
2.左边是泛型接口的定义interface IUsb<T t,R r>{};IUsb的定义 
右边是继承泛型接口
如果是第一种Class C implements IUsb{
	}
等同于Class C implements IUsb<Object,Object>{
}
正常的要 class C implements IUsb<String ,Integer>什么的写两个类型，包括接口继承也需要写奥
interface B extends IUsb<String,Integer>

*/

//自定义泛型方法
//语法 修饰符<T,R...> 返回类型 方法名(参数列表){ }
//注意细节：
//1.当泛型方法呗调用的时候，类型会确定
//2.注意使用泛型的方法和泛型方法的区别
//public void eat(E e){}是使用了泛型但不是泛型方法，泛型方法修饰符后面是有<>的
//比如Car有个public <T,R>void fly(T t,R r){泛型方法}
//我们调用的时候 Car a = new Car();  
//直接a.fly("666",100);编译器会自动识别类型，不像之前的要自己写


//泛型的继承和通配!!!!!!!!!!
//泛型没有继承一说：
//List<Object> list=new ArrayList<String>();
//上面的写法是错误的，前后必须对应，或者后面什么也不写

//关于泛型的通配!!!!!!
//1.<?>:支持任意形式泛型
//2.<? extend A>:支持A类以及A类的子类
//3.<? super A>支持A类以及A类的父类
//这个是规定，你传入泛型的范围奥，不是对象类型范围
//就是一般在方法的参数可以哟用到
//比如是你只想接收,泛型是A及其子类的ArrayList对象,参数就是ArrayList<? extend A>
//如果传入对象的泛型不匹配你写的泛型，那么就报错，比如下面这个如果在？ 后面 +extends final_那就报错了
//你就可以用这个下面有例子
@SuppressWarnings({"all"})
public class generic02 {
	public void pr(List<?> a) {//这个就可以接收List子类下不管存储什么类型
		for (Object object : a) {
			System.out.println(object);
		}
	}
public static void main(String[] args) {
	ArrayList<String> arrayList = new ArrayList<>();
	arrayList.add("666");
	arrayList.add("牛");
	arrayList.add("7");
	generic02 generic02 = new generic02();
	generic02.pr(arrayList);
}

}
