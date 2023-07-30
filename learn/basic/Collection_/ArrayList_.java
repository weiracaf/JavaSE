package yuan.learn.basic.Collection_;

import java.util.ArrayList;
@SuppressWarnings({"all"})
//ArrayList_类

//ArrayList可以存储所有对象，包括null，可以同时存储多个null
//ArrayList是由数组实现数据存储的
//ArrayList基本等同于Vector
//不过ArrayList线程不安全（指向效率高），多线程用Vector
public class ArrayList_ {
	public static void main(String[] args) {
//		底层结构！
//		先说结论：
//		1.ArrayList中维护了一个Object类型的数组elementData
//		transient Object[] elementData
//		transient修饰的属性不会被序列化，不能搞到对象流喽！
//		2.当创建ArrayList对象时，如果使用的是无参构造，则初始elementData的容量为0
//		第一次添加，则扩容elementData为10，如需再次扩容则扩容elemrntData为1.5倍
//		3.若使用有参构造，则初始elementData容量为指定大小，如需要扩容，则直接扩容elementData为1.5倍
		//方法的话就Collection和List的方法
		//主要是上面的底层原理，看add()之是否需要扩容后的扩容操作，需要扩容会调用ArrayList的grow()方法扩容
		//可以看我的博客或者源码
		//扩容的本质是Arrays.copyOf()
		//接下来直接到
		ArrayList arrayList = new ArrayList();
		arrayList.add("66");
		arrayList.add(8);
		arrayList.add(8);
		arrayList.add(6);
		System.out.println(arrayList);
		//arrayList.remove()没有默认的方法就是没有参数的remove方法
	}

}
