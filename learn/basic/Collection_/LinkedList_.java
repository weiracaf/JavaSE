package yuan.learn.basic.Collection_;

import java.util.LinkedList;
@SuppressWarnings({"all"})
//讲LinkedList
//LinkedList底层实现了双向链表和双端队列特点（与ArrayList和Vector的数组底层不同）
//为什么说其有双端队列特点？1.first和last2.默认的remove是头先出（先入先出）
//可以添加任何元素（元素可以重复），包括null
//线程不安全，没有实现同步

public class LinkedList_ {
public static void main(String[] args) {
	//首先讲一下LinkedList底层维护了一个双向链表
	//每个节点包含prev指向前一个节点，next指向后一个节点，item存储数据，然后first指向第一个元素，last指向最后一个元素（就数据结构）
	//因为底层是链表，所以删除和添加的效率高一些（懂的吧，添加元素效率高，不用我说了吧）数组要新开空间，链表不用
	LinkedList linkedList = new LinkedList();
	linkedList.add("666");
	linkedList.add(1);
	linkedList.add(8);
	linkedList.add(true);
	linkedList.add(1.6f);
	System.out.println(linkedList);
	//关于remove操作，你才会删除哪个？
	linkedList.remove();//顺带一提，就是这个类多重载了一个无参remove方法里面调用removeFirst()方法
	//就是默认删除第一个元素呗
	System.out.println(linkedList);
	//结果显示删除的是第一个
	linkedList.remove(2);//当然你也可以按索引删除
	
	//其他方法
	//因为它也是List接口下的，所以，关于Collection和List接口的方法它都可以用
	
	
}
}
