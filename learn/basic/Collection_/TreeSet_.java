package yuan.learn.basic.Collection_;
//这里简单介绍一下这个TreeSet
//类似于HashSet它的底层是双列集合的TreeMap

/*重点和其他的区别是，可以排序（按照你想要的方式）
当我们使用无参构造器创建TreeSet时
仍然是无序的
如果你希望按照添加的元素按照字符串大小排序
需要使用TreeSet一个构造器可以传入一个比较器Compartor（接口）（比较器呗，前面有介绍哦）
使用匿名内部类*/
//写的方式在new的时候写就可以
/*TreeSet treeSet = new TreeSet(new Comparator(){
		@Override
		public int compare(Object o1,Object o2){
		return ...;
		}


})*/
//TreeSet的底层是TreeMap
//把我们传入的比较器传给了TreeMap的一个属性comparator
//TreeSet的add方法底层是TreeMap的put方法
//然后依据这个属性的返回值，来做到添加的结果
//其他的再TreeMap讲吧
public class TreeSet_ {
	

}
