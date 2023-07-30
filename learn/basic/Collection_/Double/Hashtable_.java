package yuan.learn.basic.Collection_.Double;
//本篇介绍Hashtable类
//1.存K-V键值对
//2.Hashtable的value和key都不能为null
//3.方法结束继承Map的，和HashMap基本一样
//4.Hashtable线程安全，HashMap线程不安全
//关于扩容机制的不同
//1.初始数组有11个（一开始介绍11个），临界因子0.75（默认的）
//threshold = (int)Math.min(newCapacity * loadFactor, MAX_ARRAY_SIZE + 1);
//达到临界值（threshold）11*0.75=7的时候扩容，关于MAX_ARRAY_SIZE,你可以认为它是一个最大值，对应Hashtable的数组个数的最大值
//对应的k-v键值对不能超过MAX_ARRAY_SIZE
//正常扩容一下扩容到2n+1（n为OldCapacity就是原本的容量）,11*2+1=23
public class Hashtable_ {

}
