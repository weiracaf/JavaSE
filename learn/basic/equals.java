package yuan.learn.basic;
//本篇主要讲==和equals之间的不同
public class equals {
	public static void main(String[] args) {
		//==的话就是基本类型看值相不相同，引用类型看是不是同一个对象（指向内存是否相同）
		int a=10;
		int b=10;
		System.out.println(a==b);
		String aString = "小袁";

		String string = new String("小袁");
		System.out.println(aString==string);//因为new的和String直接等于的创建方式不一样
		//所以两个字符串即使内容一样，==的结果也可能是false
		
		//equals的话只能用于引用类型，默认判断的是是否地址相同，一般都是类中重写该方法来判断内容是否相同
		//比如String就重写了equals方法，来判断字符串中的内容是否相同
		System.out.println(aString.equals(string));//所以这个为真
		
		zhen s1 = new zhen("666", 11);
		zhen zhen02 = new zhen("666", 11);
		zhen zhen03 = new zhen("666", 51);
		System.out.println("01和02"+s1.equals(zhen02));
		System.out.println("01和03"+s1.equals(zhen03));
		
		
		
	}
}
class zhen{
	String name;
	int age;
	
	public zhen(String name, int age) {
		super();
		this.name = name;
		this.age = age;
	}
	@Override
	public boolean equals(Object obj) {	//这里就是重写来进行内容判断，默认判断地址是否相同
		if(this==obj)	//1.地址相同直接返true
			return true;
		if(obj instanceof zhen) {	//2.内容相同返true
			zhen six=(zhen)obj;
			if(this.name.equals(six.name)&&this.age==six.age)
				return true;
		}
		
			return false;//都不对就false
		
	}
	
}