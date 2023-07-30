package yuan.learn.basic.Collection_.Double;

import java.util.HashSet;
@SuppressWarnings({"all"})
public class 一道HashSet易错 {
	public static void main(String[] args) {//Person根据age和name重写hashCode和equals
		HashSet hashSet = new HashSet();
		Person p1=new Person(1001, "AA");
		Person p2=new Person(1002, "BB");
		hashSet.add(p1);
		hashSet.add(p2);//一定要重写加入的类的toString，输出默认是调用加入类对象的toString方法
		p1.name="CC";
		hashSet.remove(p1);
		System.out.println(hashSet);//1002 BB,1001 CC
		hashSet.add(new Person(1001, "CC"));
		System.out.println(hashSet);//1002 BB,1001 CC,1001 CC
		hashSet.add(new Person(1001, "AA"));
		System.out.println(hashSet);//1002 BB,1001 CC,1001 CC,1001 AA
		//结果是逆天的，我的大脑是蒙蔽的
		//接下来解析一下吧
		//1.第一次输出：因为p1既然删除了，为什么还能输出
		//原因就是p1没删除成功
		//因为中间的一个操作，p1.name="CC",会改变p1的hashCode返回值
		//原来的p1比如说在索引1的位置存储，remove的底层也是先根据hashCode找索引，然后用equals返回true删除
		//但是新的p1返回的值不是索引1了（重写了方法，只有id和name相同hashCode返回相同），他去不是索引1的地方找1001当然找不到
		//找不到怎么删除？下面画一个图比较或理解
		//table[0]	p2
		//table[1]	p1
		//table[2]	（remove p1搜索的索引）
		//table[3]
		//2.第二次输出
		//为什么能输出两个1001 CC没有进行替换吗？
		//笨啊！，你想想，你加入p1的时候，他是在索引1，你把他name修改为CC，他不还在索引1（用的是1001 AA的索引（hashCode））
		//你新加入1001 CC它怎么能和1001 AA的索引值一样，它肯定是另一个索引啊（p1属性更改，索引不变），所以，他们两个都不在一个索引上
		//他两就不能比较进行替换，也是底层的add机制
		//table[0]	p2(1002 BB)
		//table[1]	p1（1001 AA->CC）
		//table[2]	1001 CC
		//table[3]
		//3.第三次输出
		//1001 AA,你又蒙了,为什么没把p1替换掉
		//笨啊！，这个是单列集合，看元素是否相等根据底层的equals
		//1001 AA怎么和1001 CC相同
		//所以就填入到索引1后面呗
		//table[0]	p2(1002 BB)
		//table[1]	p1（1001 AA->CC）
		//table[2]	1001 CC
		//table[3]
	}

}
class Person{
	int age;
	String name;
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + age;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Person other = (Person) obj;
		if (age != other.age)
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}
	public Person(int age, String name) {
		super();
		this.age = age;
		this.name = name;
	}
	@Override
	public String toString() {
		return "Person [age=" + age + ", name=" + name + "]";
	}
	
	
}
