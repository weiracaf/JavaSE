package yuan.learn.basic;
//本篇主要讲解枚举类的作用
//枚举可以理解为一组常量的集合，可以认为是一种特殊的类，里面只包含一组有限的特定对象
//为什么要用枚举
//比如季节其实只有四个春夏秋冬，你的构造器写的如果是那种最普通的话
//用户其实可以随意给季节的字符串赋值，可能创造出‘红天’等等奇怪的季节
//我们可以通过枚举来限制
@SuppressWarnings({"all"})
//枚举有两种实现方式
//1.自定义
//2.通过enum关键字，这个看另一个enum类Demo02,里面有详解
public class enum_ {
	final static public enum_ c=new enum_();//相当于静态属性，所以尽管，d不是静态，不过在这个c里加载了还是能在静态方法main调用的
	
	int d =100;
public static void main(String[] args) {
	Season a = Season.Autumn;	//像这样只能通过类.已创建对象赋值奥
	System.out.println(a.getDesc());
	System.out.println(a.getName());
	System.out.println(Demo02.Autumn);//这个是enum那个
	System.out.println(Demo02.Winter);
	System.out.println(c.d);
}
}
class Season{//1.自定义实现枚举
	//特点
	//1.构造器私有化
	//2.本类内部创造一组对象
	//3.对外暴露对象（通过添加public static final修饰符，不创建对象也可以直接调用方法）
	//  final修饰引用，指向的对象不可改变，对象里的值是可以改变的
	//4.可以提供get方法，不提供set方法
	private String name;
	private String desc;
	
	private Season(String name, String desc) {
		super();
		this.name = name;
		this.desc = desc;
	}

	final public static Season Spring = new Season("春天","温暖");
	final public static Season Summer = new Season("夏天","炎热");
	final public static Season Autumn = new Season("秋天","凉爽");
	final public static Season Winter = new Season("冬天","寒冷");
	

	public String getName() {
		return name;
	}
	public String getDesc() {
		return desc;
	}
	
	
}
