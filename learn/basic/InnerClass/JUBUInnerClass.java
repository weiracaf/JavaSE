package yuan.learn.basic.InnerClass;

//本篇介绍匿名内部类和局部内部类啦
public class JUBUInnerClass {
public static void main(String[] args) {
	Outer04 outer04 = new Outer04();
    outer04.method();
	}
}
@SuppressWarnings({"all"})
//先是这个匿名内部类
class Outer04{//外部类
    private int n1=10;//属性
    public void method(){//方法
    //基于接口的匿名内部类
        //1.需求使用接口A，传统写一个类实现接口，然后创建对象
        //2.现在需求的只用一次方法，但是创建一个对象很不划算
        //3.使用匿名内部类搞定，简化开发
        //4.编译类型  A
        //5.运行类型  就是匿名内部类 XXXX就是Outer04$1(外部类名称+$1)，底层分配的名称
        /*
        我们看底层,是有下面这个操作的，会分配一个类名
        class XXXX implements A{
         public void cry(){
                System.out.println("老虎嗷嗷叫...");
            }
        }
         */
        //6.jdk顶层先创建匿名内部类Outer$1，就马上创建了其实例，并且把地址返回给A tiger
        //7.匿名内部类只能，使用一次就不能使用了（只能new一次），但是这个对象还在
        A tiger=new A(){
            public void cry(){
                System.out.println("老虎嗷嗷叫...");
            }
        };
        tiger.cry();
        /*
        1.Father编译类型Father
        2.Father运行类型匿名内部类Outer$2
        3.在底层类似于
        class Outer$2 extends Father{
        @Override
            public void test() {
                System.out.println("匿名内部类重写了test方法");
            }
        }
         */
        Father father=new Father("jack"){
        	@Override
        	public void test() {
        		System.out.println("father匿名内部类");
        	}
        };
        father.test();
        //还有一种基于抽象类的匿名内部类,必须实现抽象类里面的抽象方法
        B b=new B() {
            @Override
            public void say() {
                System.out.println("匿名内部类重写抽象方法");
 
            }
        };
        b.say();
 
    }
 
}
interface A{
    public void cry();
}
class Father{
    public Father(String name){//构造器
 
        }
        public void test(){//方法
 
    }
 
}
abstract class B{
    abstract public void say();
}
//关于匿名内部类的使用
//匿名内部类的使用 
/*
 * 创建类变量或者接口变量用
 B b=new B(){//B是接口或者是类
  
 代码块里面可以重写（实现）B的方法（如果B是抽象类一定要重写里面的抽象方法，接口的话要实现里面的所有方法，普通类可以不写，不写的话就是调用原来的声明）
 }
 * 
 * 最后调用b.方法来进行匿名内部类使用 （当然要在作用域里（对应的方法或者代码块））
 * 
 * 可以看上面的代码有具体使用
 * 
 * 疏忽了，也可以这样使用
 * new Person(){
 * 			@Override
 * 			public void hi(){
 * 					System.out.println("匿名内部类重写hi方法");				
 * 		}
 * }.hi();
 * 太牛了，因为匿名内部类本身也是一个对象，可以直接调用，适用于只想用一次吧
 */
/*
 * 匿名内部类使用细节 匿名内部类既是一个类的定义也是一个对象的创建，因此从语法上看它既有定义类的特征也有创建对象的特征
 * 
 * 匿名内部的使用细节
 * 
 * 1.访问外部类所有成员（包括私有）
 * 
 * 2.不能添加访问修饰符
 * 
 * 3.作用域在定义它的代码块或者方法中
 * 
 * 4.匿名内部类访问外部类直接访问即可
 * 
 * 5.外部其他类不能访问匿名内部类
 * 
 * 6.如果外部类和匿名内部类的成员重名的话，遵循就近原则，想访问外部类成员使用
 * 
 * （外部类名.this.成员名）去访问
 */
/*
 * 说明一下：
 * 
 * 匿名内部类也可以创建一些自己的方法，但是你是调用不了的，因为编译是过不去的，只有运行类型里面有这个方法，而且运行类型你还不知道类名，
 * 所以你肯定在这个对象里调用不到这个方法所以这样做，（这样做是没有意义的）。
 * 
 * 当然你可以在重写方法里调用它自身的方法也是可以的。
 */
//匿名内部类使用场景比如那个比较器Comparator，那个东西一般也就用一次，专门写一个类不好用
/*
 * 传统的建类继承重写创建对象然后调用相比于这个麻烦，但是你如果要多次用就用传统的
 * 
 * 如果你只想用一次，就可以用这种匿名内部类的形式
 * 
 * 更加灵活
 */


/*
 * //4.局部内部类 就正常在方法里，有类名的 
 * public class outer{ 
 * 			public void method() { 
 * class Inner{//这个就是局部内部类啦
 * 		} 
 * 	} 
 * }
 */
/*
 * 使用细节 1.局部内部类定义在外部类的局部位置，通常是方法中
 * 
 * 2.局部内部类可以直接访问外部类的所有属性和方法（包括private）
 * 
 * 3.局部内部类不能添加访问修饰符，但是可以用final修饰 （不可被继承）
 * 
 * 4.局部内部类的作用域仅仅在定义它的方法或者代码块中（所以要调用里面的属性或者方法一定是在外部类的方法里建对象然后调用的！！！）
 * 
 * 5.局部内部类可以直接访问外部类的成员
 * 
 * 6.外部类访问局部内部类的成员，创建对象再访问 （必须在作用域内！！！看4）
 * 7.外部其他类不能访问局部内部类（因为局部内部类相当于一个局部变量）
 *
 * 8.如果外部类和局部内部类的成员重名遵守就近原则
 *想访问外部类成员用
 *外部类名.this.成员名调用（最后这个外部类名.this指向的是一个外部类对象，这个对象调用内部所在方法，比如new Outer02().m1();，指向的是new开辟出来的那块对象）

 */


