package yuan.learn.basic.Collection_.Double;
//这章主要是HashMap类的讲解
/*HashSet有具体的HashMap的特点

1.不能有重复元素（指的key对象），value可以一样
2.是一种链表数组形式
3.根据key对象的hash值来确定对象所在的数组索引，添加到链表中-无序
4.线程不安全*/
public class HashMap_ {
	/*
	 * 在Hash中没有讲到的特点 1.Collection接口是单列集合，只传入一个对象，另一个对象的话，系统生成了PRESENT来补充，本质上也是双列集合，
	 * 但是另一个对象由系统进行补充并且所有单列集合的那个Value对象（PRESENT）都一样
	 * 
	 * 2.在双列集合中是put(Object key,Object value)
	 * 3.传入两个对象,而且但集合中的key对象是同一个的话,后来的value会替换掉之前的value对象
	 * 之所以单列集合（HashSet）没有变化，是因为PRESENT是同一个对象并且不会输出，其实它内部也是有替换的。
	 */
	
	//关于HashMap的底层，因为其实在HashSet讲的很清楚了
	//这里只补充几点
	//1.HashMap底层维护了Node类型的数组table，默认为null
	//2.创建对象时候，将加载因子（loadfactor）初始化为0.75
	//3.第一次添加先扩容到16。到16*loadfactor(0.75)=12下一次扩容
	//扩容的话会扩容到原来的二倍就是32然后还是到32*0.75=24下一次扩容，以此类推
	//4.树化的问题，1.一条链表超过8 2.table[]大小>=64
	//关于判断元素是否相同
	/*
	 * hashCode和equals
	 * 1、hashCode的存在主要是用于查找的快捷性，如Hashtable，HashMap等，hashCode是用来在散列存储结构中确定对象的存储地址的；
	 * 
	 * 2、如果两个对象相同，就是适用于equals(java.lang.Object) 方法，那么这两个对象的hashCode一定要相同；
	 * 
	 * 3、如果对象的equals方法被重写，那么对象的hashCode也尽量重写，并且产生hashCode使用的对象，一定要和equals方法中使用的一致，
	 * 否则就会违反上面提到的第2点；
	 * 
	 * 4、两个对象的hashCode相同，并不一定表示两个对象就相同，也就是不一定适用于equals(java.lang.Object)
	 * 方法，只能够说明这两个对象在散列存储结构中，如Hashtable，他们“存放在同一个篮子里”
	 */
	//具体其实都在HashSet说过了，可以看看奥

}
