package yuan.learn.basic.Collection_;

import java.util.HashSet;
@SuppressWarnings({"all"})
//本篇主要讲HahsSet,以及一些Set篇没有讲到的-无序什么的

//首先说明：HashSet的底层时间上是HashMap(另一个双列集合)
//可以存null、只能有一个null
//HashSet,不保证元素是有序的，取决于Hash后（数据结构，哈希表），再确定索引的结果
//不能有重复元素/对象（前面Set接口说过）
public class HashSet_ {
	public static void main(String[] args) {
		/*
		 * 对于不能有重复元素理解（面试） 
		 * new Dog(“s”) new Dog(“s”) 
		 * 可以存放着两个元素，因为实际指向不同，不是同一个 ，没有重写equals，还有hashCode
		 * 但是newString(“s”)和new String(“s”) 
		 * 这两个不能存储在一个HashSet对象中 因为重写了equals，变为比较内容是否相同,且重写了hashCode
		 * 保证了两元素可以在同一个table[]索引上
		 * 最后调用的equals是调用我们填入对象的奥
		 */
		//HashMap(也就是HashSet)的底层是
		//数组+链表+红黑树
		//这里红黑树就是自平衡B树，B树偷懒没学，所以先看数组链表
		//数组+链表就是一个数组，这个数组存放的元素是一个链表的头指针（头元素？）
		//反正就是根据本类的next可以访问到下一个数据元素，数组有多少个元素就存在多少个链表
		
		
		//其次我们干什么呢？当然是看下我们的扩容底层喽
		 HashSet hashSet =new HashSet();
		 //接下来会很难，跟紧
		 //1.HashSet底层是HashMap
		 //2.添加一个元素时，先得到hash值，转换为索引值
		 //3.找到存储数据表table[]，看对应索引有无以及存放的元素
		 //4.如果有用equals()比较，如果相同，放弃添加，如果不同则添加到最后（和整条链的所有数据比较完，再放到最后）
		 //5.如果没有，直接加入呗
		 //6.！！！在Java8中，如果一条链表的元素个数超过TREEIFY_THRESHOLD(默认为8)
		 //且table的大小>=MIN_TREEIFY_CAPACITY(默认64)，就会树化（红黑树）
		 hashSet.add("java");
		 hashSet.add("php");
		 hashSet.add("java");//添加失败，元素重复（重复不重复底层是看填入类的equals方法（没有就一直找父类直到Object））
		 System.out.println(hashSet);
		 //具体的源码分析，关于第一次add，第二次add，和第一次重复add具体看csdn：小袁拒绝摆烂的博客：单列集合可以看
		 //这里讲的话篇幅太长
		 //主要的话就是add里面有个方法put方法，put方法调用putVal方法和hash方法，hash只是确定对应哈希值（其实不是是一个哈希值运算来的结果，具体原因也在博客）
		 
		 //重点在putVal方法，决定HashSet底层机制里面还有resize()方法上面的判断是否超出容量的扩容方法
		 //讲到扩容
		 //这里我直接写底层的扩容机制了
		 
		 //HashSet底层HashMap:第一次添加table扩容到16
		 //临界值是16*加载因子（0.75）=12
		 //如果table使用到了临界值12，就会扩容到16*2=32（2倍）
		 //新的临界值就是32*0.75=24，以此类推
		 //Java8一条链表元素个数达到(TREEIFY_THRESHOLD)默认为8，且table>=默认64（MIN_TREEIFY_CAPACITY）会树化变红黑树
		 //关于这里的size下面有解释
		/*
		* 注意当我们在一个链表中加入Node元素 其实是算所有的 就是只要你add()元素 就会size++ 尽管他没有占用 所有的比如Table[1]没有元素
		* 但是Table[1]之外的元素，包含链表里的，只要打到了临界值就会扩容 ！！！ 不是说你所有的Table[0]到Table[12]每个都有元素才扩容
		* 只要加进去的元素有12个就扩容，不管是假到链表上，还是第一个位置上 table的size值一旦达到11，马上就树化
		*/
		 
		 
		 
		 //关于怎么才算相同元素！！！
		 //1.hashCode2.equals（关于String重写的hashCode方法不同版本不同，具体看网上）
			/*
			 * 这里看原先的版本奥 比较早期的就是根据String的每个存放的字符（本质也就是字符数组），然后把它们的hash（还是根据hash运算出来的）值
			 * 存放在一个val[]数组最后把val数组所有元素加起来就是String的hash值
			 */
		 //首先你想比较，你肯定要让他们俩在同一个table[]索引上吧
		 //依据的就是hash值，然后比较怎么比较？
		 //调用的就是equals方法呗
		 
		 
		 //现在也可以理解为什么是无序的了吧，根据对应的add机制
		
	}

}
