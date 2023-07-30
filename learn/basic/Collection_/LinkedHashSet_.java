package yuan.learn.basic.Collection_;
//LinkedHashSet是HashSet的子类
//底层：数组+双向链表
//不允许添加重复元素
/*可以认为是一个有序的HashSet
加入和取出的顺序一样
链表是按照添加元素一个个链表起来的

不是说只有一个索引下的的是一个链表
不同索引的两个元素也可以链接！！！！！！！！！！！！！！！！！！！！（惊叹到了）
所以取出的顺序和加入的顺序一样(不同于HashSet)*/
//所以其实，LinkedHashSet的节点保存的pre和next，不是连接同一条链表的
//是链接到下一个添加入的元素的！
//再根据其属性head（第一个add的）和tail（最后一个add的）可以确定整个的插入顺序
public class LinkedHashSet_ {

}
