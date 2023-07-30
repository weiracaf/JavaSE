package yuan.learn.basic.Collection_;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
@SuppressWarnings({"all"})
//这期讲单列集合，这里就少写点，具体原理看博客
//单列集合体系图
//							->ArrayList,LinkedList,Vector(类)
//				->List(接口)
//Collection(接口)
//				->Set(接口)
//							->TreeSet,HashSet(类)
//因为数组扩容需要赋值扩展，创建新空间太麻烦
//就出现了集合这个东西，集合分单列集合和双列集合，本期讲单列集合
/*集合的好处
1.动态保存任意多个个对象，使用方便
2.提供一系列方便操作对象的方法
3.使用集合添加，删除新元素，简洁明了*/
public class SingleSetMethod {
	public static void main(String[]  args) {
		//先讲Collection接口中的方法，都是实例方法奥
		//1.add(对象)，传入基本类型的话会自动装箱，向集合中添加元素
		Collection arrayList = new ArrayList();	//接口不能实例化，我们用实现他的类来做演示
		arrayList.add("666");
		arrayList.add(10);
		arrayList.add(1.6f);
		arrayList.add(false);
		System.out.println(arrayList);
		//2.remove()参数可以有多种形式
		//一.对象类型arrayList.remove(Integer.valueOf(10));想要删除对象10的话,要把它转成Integer
		//二.arrayList.remove(true);//布尔值特殊可以不改!!
		//还有一种参数是在另一个接口写着相当于重载，但是确实Collection只写了这个对象的方法
		//返回布尔值判断删除是否成功
		arrayList.remove(10);
		//注意：因为我这里引用类型是Collection只有对象的方法，会把10自动装箱为对象
		//如果是List或之下的实现的子类，默认就是索引，不是对象，需要自动装箱
		//3.contains(对象)
		//查找该对象在集合中有无，有返回true，无返回false
		if(arrayList.contains(Float.valueOf(1.6f))){
			System.out.println("有1.6");
		}
		//4.clear()清空操作，清空集合中的所有对象，无返回值
		System.out.println("清空前"+arrayList);
		arrayList.clear();
		System.out.println("清空后"+arrayList);
		//5.addAll():添加多个元素
		//两种重写addAll(Collection c)添加这个集合所有元素
		//addAll(int idex,Collection c)添加这个集合对应索引的元素
		//返回布尔，判断成功与否
		ArrayList list = new ArrayList();
		list.add("红楼梦");
		list.add("三国演义");
		list.add("水浒传");
		arrayList.addAll(list);
		System.out.println("addAll后"+arrayList);
		//6.containsAll：查找多个元素是否存在
		//containsAll(Collection c)
		//返回布尔值，判断有无
		System.out.println(arrayList.containsAll(list));
		//7.size()返回集合元素个数
		System.out.println("集合有的元素"+arrayList.size());
		
		//接口遍历，迭代器！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！
		//Inerator()
		//所有实现了Collection接口的集合类，都有一个iterator()方法
		//可以返回一个实现了Iterator的对象，即迭代器
		//Iterator用于遍历集合，本身不存放对象
		Collection c=new ArrayList();
		c.add("三国");
		c.add("红楼梦");
		c.add("西游记");
		Iterator a= c.iterator();
        while (a.hasNext()){
        System.out.println(a.next());
        }
        //当然，重要我们还是用增强for循环的！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！
        //底层还是迭代器
        for (Object object : c) {
			System.out.println(object);//同理想调用对应运行类型方法需要强转，自己instanceOf转
		}
        
        //然后是List接口的方法
        //下面的方法只要和上面的方法有重名的就是重载！
        //1.add(int index,Obiect ele)
        //在索引index插入，ele元素
        List list1 = new ArrayList();
        list1.add("小袁");
        list1.add("无语");
        list1.add(2,"大");
        list1.add(1,"小");
        System.out.println(list1);
        //2.addAll(int index,Collection ele)
        //从索引index位置开始,将ele所有元素加进来
        //3.remove(int index):移除指定index位置的元素，并返回此元素
        System.out.println(list.remove(1));
        System.out.println(list);


        ArrayList arrayList1 = new ArrayList();
        arrayList1.add("努力");
        arrayList1.add("加油");
        list.addAll(1,arrayList1);
        System.out.println(list);
        //之后基本介绍自己的方法
        //4.get(int index)
        //获取索引index位置的元素
        System.out.println(list.get(1));
        //5.indexOf(Object obj):返回obj在集合中首次出现的位置
        System.out.println(list.indexOf("无语"));//未出现返回-1
        //6.lastIndexOf(Object obj):返回obj在集合中最后一次出现的位置
        System.out.println(list.lastIndexOf("无语"));
        //7.set(int index,Object ele):将index处的元素替换为ele
        list.set(0,"AI");
        System.out.println(list);
        //8.List subList(int formIndex,int toIndex)
        //返回从formIndex到toIndex位置的子集合[formIndex,toIndex)
        System.out.println(list.subList(0,2));
        //List接口除了前面的两种遍历可以加一种
        //增加一种普通for遍历方法
        for(int i=0;i<list.size();i++)
        {
        Object object=list.get(i);
        System.out.println(object);
        }
        
        
        //下面关于具体某个类我创建别的文件讲解，分别为ArrayList_,Vector_,LinkList_,Set,HashSet_,LinkedHashSet_
        //放在Collection_包下




        




		
		
		
	}

}
