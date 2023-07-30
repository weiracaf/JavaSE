package yuan.learn.basic.Collection_;
//本篇写集合要怎么选择
public class 集合的选择 {
	//1.看存储类型，一组对象/一组键值对
	//2.一组对象的话，单列集合
	//允许重复：List
	//	增删多：LinkedList[因为底层是一双向链表，效率高]
	//	改查多：ArrayList [底层是Object类型的可变数组]
	//不允许重复：Set
	//	无序：HashSet[底层HashMap,底层是哈希表(数组+链表),达到某条件会变为红黑树]
	//	排序：TreeSet
	//	插入和取出顺序一致：LinkedHashSet[底层是数组+双向链表]
	//3.一组键值对
	//键无序：HashMap[底层是：哈希表 jdk7:数组+链表 jdk8：数组+链表+红黑树]
	//键排序：TreeMap
	//键插入和读取顺一致：LinkedHashMap
	//读取文件Properties
}
