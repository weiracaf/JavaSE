package yuan.learn.basic.Collection_;
//讲Vector类
//Vector的大多数的方法和arrayList相同
//底层也是protected Object[] elementData一个数组
//Vector是线程同步的，线程安全
//Vector类的操作方法都有synchronized
//开发中需要线程同步安全时使用Vector
public class Vector_ {
public static void main(String[] args) {
	//主要是比较和ArrayList的不同咯
	//				线程安全（同步）效率	扩容倍数
	//ArrayList		线程不安全，效率高	有参1.5倍，无参第一次10之后需要扩容1.5倍
	//Vector		线程安全，效率低		无参默认10，需要扩容时2倍扩容，有参指定大小就需要扩容就2倍扩容，还有一个方法在下面
	//底层的话，其实就grow方法有所区别所以扩容不同
	//其实无参构造用的其实是有参构造无参的源码里面是this(10);就是指定十个大小空间呗
	//然后还有一个重载
	//Vector(10,5)	10是初始容量 initialCapacity,然后5是capacityIncrement
	//默认的话，其实就是0
	//grow()其实里面有个三元运算符
	//newCapacity = oldCapacity+((capacityIncrement>0)?capacityIncrement:oldCapacity)
	//看见没，正常为0的话，就是+oldCapacity就是二倍呗，如果是5的话，+capacityIncrement不就是变为扩容固定长度
	//刚开始赋10个空间
	//每次需要扩容，扩容五个空间，就不是默认的二倍了
}
}
