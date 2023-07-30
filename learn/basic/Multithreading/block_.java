package yuan.learn.basic.Multithreading;
//本篇主要讲锁机制（！），主要是和同步机制相关

//先分析同步的原理
//t1，t2和t3三个线程抢锁
//谁抢到谁先进去操作相关代码
//比如t1先进去
//操作完后t1返回
//把锁还回去然后继续和t2t3争抢
//当然可能还是t1又抢夺到了
//因为Synchronized这是个非公平锁，谁抢到就是谁的！
//一.互斥锁
//1.Java语言中，引入了对象互斥锁的概念，来保证共享数据操作的完整性
//2.每个对象都对应于一个可称为“互斥锁”的标记，这个标记用来保证在任一时刻，只要能有一个线程访问该对象
//3.关键字synchronized来与对象的互斥锁联系，当某个对象用synchronized修饰时，表明该对象在任一时刻只能由一个线程访问
//  就是互斥锁启用的意思吧
//4.同步的局限性：导致程序执行效率比一般程序低
//5.同步方法（非静态的）的锁本身可以是this，也可以是其他对象（要求是同一个对象）
//6.同步方法（静态的）的锁为当前类本身


//关于5和6
//5.这里非常非常！！！！！建议去看看我的Demo01讲解了这个this到底是啥，然后介绍关于为什么不是Thread不同却this相同
//必须用同一个对象！！！，创建多个线程对象！！！，互相之间才会收到锁的影响
//同步方法比如上面的售票改版,下面的代码
//就是把锁加到this上了，即调用该方法的对象
//如果想把锁加到别的对象上，可以用同步代码块，下面代码没加注释的是同步方法只能把锁加到this
//同步代码块是加注释的

//两种效果是相同的
//都是把互斥锁加到this对象上
/*当然可以换成别的对象（不过要保证对象是同一个，这样才能起到锁的作用)
比如Object a=new Object();
synchronized(a){
}
也可以
因为，都是同一个线程对象开辟的线程
使用这个对象的a肯定都是同一个(就是保证是同一个锁)，不过我感觉用this方便
也可以static new一个对象
这样的话就算是不同的对象a只要是该类的对象
那么这个对象锁也是同一个*/
//6.是只要是这个类创建的对象都可以受到对应锁的影响
//静态的加载的时候对象还没创建呐，怎么用this?
//对应的static方法里用
//synchronized代码块
//不能这样写
//public static void m2(){
//synchronized(this){
//	
//	}
//}
//正确的写法是
//public static void m2(){
//	synchronized(block_.class) {	没错就是类名.class
//		
//	}
//}

//注意：同步方法有static默认为 当前类为锁，没有static就是this对象是锁

//线程的死锁!!!!!!!!!!!!!!
//多个线程占用对方锁资源，但是不肯相让，导致死锁，在编程中一定要避免死锁的发生
//比如：妈妈：你先完成作业，让你玩手机
//	孩子：先玩手机，再完成作业
//底层就是一个锁，只能在相同时间内锁住一段代码
//具体可以看一下我的博客：比较抽象，还有关于释放锁的操作，就是用完了，把锁开开了
//也可以在博客看看
public class block_ { 
	int times = 10;
	boolean loop =true;
	public synchronized void sell(){//同步方法在同一时刻只能有一个线程执行sell方法，这个锁是	

    if(times<=0){	
        System.out.println("售票结束...");
        loop=false;
        return;
    }


    System.out.println("窗口"+Thread.currentThread().getName()+"售出一张票"
            +"剩余"+(--times)+"票");
}
//	 public  void sell(){//同步方法在同一时刻只能有一个线程执行sell方法
//
//		   synchronized(this) {if(times<=0){	
//		            System.out.println("售票结束...");
//		            loop=false;
//		            return;
//		        }
//
//
//		        System.out.println("窗口"+Thread.currentThread().getName()+"售出一张票"
//		                +"剩余"+(--times)+"票");
//		                }
//		    }


}
