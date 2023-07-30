package yuan.learn.basic;
//通过enum关键字来创建枚举
public enum Demo02 {
	//final public static Season Spring=new Season("春天","温暖");
    //final public static Season Summer=new Season("夏天","炎热");
    //final public static Season Winter=new Season("冬天","寒冷");
    //final public static Season Autumn=new Season("秋天","凉爽");
    //如果使用enum关键字实现枚举类
    //1.使用enum替代class
    //2.final public static Season Spring=new Season("春天","温暖");和下面的等价
    //  Spring("春天","温暖") 解读 常量名(实参列表)和构造器对应
    //3.如果有多个常量使用逗号,间隔即可（必须用逗号间隔，不能下一行再写一个），最后一个常量写;
    //4.如果使用enum实现枚举，需要将定义的常量对象放在最前面（创建的对象写在最前面）!!!
	//用该方法实现的类有一些常用方法和属性继承了Enum类，可以去我的博客看看
	//
	//你可能有一些疑问：没关系关于枚举的细节都在下面
	
	/*
	 * 1.枚举类里外都不可以new对象，只能通过枚举固定的格式创建对象。new Gender();//会报错
	 * 2.如果枚举类没有任何的构造器时，jvm会自动提供一个private的无参构造器，反之不提供
	 * 3.枚举类中的构造器权限访问级别只能是private，如果不写权限访问级别，jvm会自动补上private
	 * 4.枚举类中对象如果使用无参构造器创建对象，对象名后面的（）可以全部省略不写。 5.枚举类中对象创建的代码必须在枚举类的第一行，否则编译报错
	 * 6.枚举类中对象隐式被 public static final关键字修饰，自己手动显示会编译报错 7.程序中所有的枚举类都 隐式extends
	 * Enum，再无法继承其他类，但是可以实现接口 8.在枚举类的构造器中无法显示使用super() super is not allowed in enum
	 * constructor 9.枚举类不能拥有子类。枚举类不能被其他类继承
	 */

	 
	
    Spring("春天","温暖"),Winter("冬天","寒冷"),Autumn("秋天","凉爽"),Summer("夏天","炎热");

    private String name;
    private String desc;
    private Demo02(String name, String desc) {
        this.name = name;
        this.desc = desc;
    }

    public String getDesc() {
        return desc;
    }

    public String getName() {
        return name;
    }
    @Override
    public String toString() {
        return "Season{" +
                "name='" + name + '\'' +
                ", desc='" + desc + '\'' +
                '}';

}
    }
