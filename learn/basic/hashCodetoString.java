package yuan.learn.basic;
//讲hashCode和toString
public class hashCodetoString {
	public static void main(String[] args) {
		String a= new String("666");
		String b= new String("777");
		String c= new String("666");
		System.out.println(a.hashCode());
		System.out.println(b.hashCode());
		System.out.println(c.hashCode());
		//简单来说hashCode值返回哈希值，这个值和地址有关
		//指向同一个对象的哈希值一定相同，不一个对象，不一定不一样
		//数据结构那个，String的hashCode重写过，字符串内容一样的话返回的哈希值一样
		Cat dog = new Cat("旺财",10);	
		System.out.println(dog.toString());	//toString一般就是返回对应信息构成的字符串
	}
}
class Cat{
	String name;
	int age;
	
	public Cat(String name, int age) {
		super();
		this.name = name;
		this.age = age;
	}

	@Override
	public String toString() {
		return "Cat [name=" + name + ", age=" + age + "]";
	}
	

	
	
}