package yuan.learn.basic;
//本篇主要讲课构造器奥
/*构造器，进行内存的分配和变量的初始化
构造器也称构造方法
来完成对新对象的初始化和内存的分配
不是创建对象，而是对对象中的值的初始化和内存分配

当你new文件时候，先系统进行对象创建，然后调用构造器方法（构造器里面的语句会全部执行）！


这是构造器的命名方法*/
/*[修饰符，比如public] 类名 (参数列表，可以没有参数){
	//不能有return，不会返回值也不要写void
}*/
//java文件编译-》class文件（这个过程，如果你某个类没定义构造器，会生成一个默认构造器）
//public class Demo03 {这里啥都没有
//
//}
public class Constructor_ {
public static void main(String[] args) {
	
}
}
class Demo03{
	//有参构造无参构造，构造器重载
	//默认构造器就属于无参构造器的一种
	//有参构造器可以加一点形参进行属性初始化
	//自定义有参构造器：
	String name;
	public Demo03(String name) {
		this.name=name;
	}
	//如果自定义构造器，默认构造器则不会生成！！！
	/*
	 * 定义多个构造器
	 * 
	 * 进行构造时，系统会根据参数的输入来确定具体调用哪个构造器
	 * 
	 * 从而进行指定对象的初始化赋值
	 */
}
//一些注意点
/*
 * Java语言中，每个类都至少有一个构造器 默认构造器的修饰符与所属类的修饰符一致 一旦显式定义了构造器，则系统不再提供默认构造器
 * 一个类可以创建多个重载的构造器 父类的构造器不可被子类继承
 */
