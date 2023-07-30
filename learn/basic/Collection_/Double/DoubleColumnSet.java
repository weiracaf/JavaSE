package yuan.learn.basic.Collection_.Double;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;


@SuppressWarnings({"all"})
//本篇主要讲双列集合
//	先看体系图吧
//			->HashMap(!)->LinkedHashMap(子类)
//			->Hashtable->Properties（子类）
//Map(接口)	
//			->TreeMap		
public class DoubleColumnSet {
	//先讲课Map接口的特点吧
	//1.Map和Collection并列存在，用于保存具有映射关系的数据key-value(类似python的字典)
	//2.Map的key和value,可以是任何引用类型的数据，会封装到HashMap$Node里面
	//3.Map的key不允许重复，和前面的HashSet一样（可以认为HashSet是一个只有key的Map）
	//4.Map的value可以重复
	//5.Map的key和value都可以为null，不过key只能有一个，value可以有多个
	//6.常用String类做Map的key
	//7.key和value之间是单向的一对一（key->value）
	
	
	//上面几条的补充吧算是
//	1.不同于单列集合只传一个对象，双列集合都是传两个对象
	/*
	 * 2.Node类是HashMap的内部类符号表示HashMap$Node next把所有的Node元素连接 然后对应数组索引可以调用
	 * 到对应索引的第一个Node元素 拿到第一个Node元素相当于后面都有了
	 */
	/*
	 * 3和4.key不能重复，value可以重复，可以重复的话会替换原来key的value 注意可能key不同也不能加入
	 * 如果你传入的比较器返回值为0就不能加入进去（这个后面具体说）
	 */
//	6.也可以用其他类的对象做key，因为形参是Object key
//	7.通过Map接口的get(Object key)方法可以通过key对象来找value元素，以为key不能重复所以是一一对应的哦
	
	
	//关于底层的储存方法，Node实现了Entry接口
	//8.这里理解key和value存在Node对象里面
	/*
	 * 为了方便遍历，会创建一个EntrySet集合，该集合存放的元素类型Entry 一个Entry包含key和value
	 * 然后把Node对象封装成Entry对象(对象的多态呗)，然后放到EntrySet集合 方便遍历 
	 * 然后把所有的key对象封装到一个Set集合里面，用keySet方法调用
	 * 把所有的value对象封装到Collection集合里，用values方法调用
	 */

	public static void main(String[] args) {	
		
		//然后讲一些Map接口的常见方法吧
		//1.put(Object Key,Object value)添加元素
		HashMap hashMap = new HashMap();
		hashMap.put("1", "一");
		hashMap.put("2", "二");
		hashMap.put("3", "三");
		hashMap.put("1", "四");//覆盖
		System.out.println(hashMap);
		/*
		 * 2.remove(Object key) 删除对应key的value
		 */
		hashMap.remove("1");
		System.out.println(hashMap);
		/*
		 * 3.get(Object key) 返回key对应的value对象，不过编译类型是Object对象
		 */
		System.out.println(hashMap.get("2"));
		/*
		 * 4.Map对象.size() 返回元素个数，一对key-value算一个
		 */
		System.out.println(hashMap.size());
		/*
		 * 5.Map对象.isEmpty() 如果个数为0返回true 如果个数不为0发布会false
		 */
		System.out.println(hashMap.isEmpty());
		/*
		 * 6.Map对象.clear() 删除对象的所有元素
		 */
		/*
		 * 7.Map对象.containsKey(Obejct key) 有对应的key返回true 没有的话返回false
		 */
		System.out.println(hashMap.containsKey("2"));
		/*
		 * 8.keySet 返回对于的key 
		 * 9.values 返回对应的value 
		 * 10.entrySet 返回所有的Node
		 */
		
		System.out.println(hashMap.keySet());
		System.out.println(hashMap.values());
		System.out.println(hashMap.entrySet());
		//接下来Map接口的遍历方式
		//1.增强for+keySet+get方法
		 Set set = hashMap.keySet();
		for (Object a : set) {
			System.out.println(hashMap.get(a));
		}
		//2.key+迭代器+get
	        Iterator iterator = set.iterator();
	        while (iterator.hasNext()){
	            Object next = iterator.next();
	            System.out.println(next+"="+hashMap.get(next));
	        }
	        //其实还有很多
	        //主要是靠keySet或者values或entrySet返回的集合进行的操作
	        
	        
	        //接下来的子类放在不同的类中讲了
	        //分为HashMap_(!),Hashtable_,Properties_


	}
	
}
