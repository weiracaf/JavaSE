package yuan.learn.basic.Multithreading;
@SuppressWarnings({"all"})
//这篇也是讲解一下多线程的底层，和上一篇的一些疑问

//进程到线程
//线程全部执行完毕后进程才会完毕
//多线程编程中，不是主线程结束了，进程就结束了，需要所有的线程都运行完成进程才会结束
//底层
//1.进程和线程关系，线程间关系
//Thread.currentThread().getName()
//这行代码可以获取到所在位置的线程的线程名
public class bottom {
public static void main(String[] args) {
	B b = new B();
	B b1 = new B();
	Thread thread = new Thread(b);
	Thread thread01 = new Thread(b1);
	thread01.start();//一个线程可以开辟多个子线程
	thread.start();
	for (int i = 0; i < 5; i++) {
		System.out.println("main run too"+" the Thread name:"+Thread.currentThread().getName());
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
//	可以发现B这个类启动的线程名叫Thread-0
//  B和main是在相同时间运行的,但是此时main线程还是继续执行的
//	不会说卡在start方法
//	等着run的语句执行完，他们两个是一起执行的
//	在执行的效果可以看出
//	主线程和子线程交替执行,相当于在main线程里面开了个Thread-0线程
//	多线程编程中，不是主线程结束了，进程就结束了，需要所有的线程都运行完成进程才会结束
		
//		2.为什么是start不是run???
//		如果把
		/*
		 * cat.start() 改为 cat.run() 相当于是没有开辟线程的 就是普通的创建对象->调用方法 
		 * 要把run方法执行完后才执行主程序的代码
		 * 那就不是多线程了，这叫串行化 而且线程名还是会输出main，没有开辟Thread-0
		 * so，底层就是我们的start开辟的线程！调用的run方法
		 * start源码自己看
		 * start实现多线程的关键方法start0()
		 * start0()是一个本地(native)方法底层是由JVM调用的
		 * 我们不能调用
		 */
	}
}
}
//3.实现Runnable接口的类通过构造器转变为Thread内部细节
//运用的是代理模式（一个设计模式）
//线程代理类，模拟了一个极简的Thread类
//class Proxy implements Runnable{//你可以把Proxy（代理）类当做Thread类对待
//private Runnable target = null;
//
//  @Override
//  public void run() {
//      if (target!=null){
//          target.run();
//      }
//
//  }
//  public Proxy (Runnable target){//构造器
//      this.target=target;
//  }
//  public void start(){
//      start0();
//  }
//  public void start0(){
//      run();
//  }
//}
/*
 * 差不多就是把我们的 Runnable接口实现的对象赋给那个Thread的一个Target（也是Runnable类型）
 * 然后调用Thread的的start的话 会调用Thread的start0() 新建线程 新建完线程以后
 * start0()调用target.run()，然后动态绑定到最开始那个实现Runnable的类型的run 相当于只用了 
 * 我们传进来的那个类型的run方法
 * 其余都是Thread类操作还是调用的Thread的start()和start0()方法 这叫代理模式
 */


class B implements Runnable{

	@Override
	public void run() {
		// TODO Auto-generated method stub
		int count =0;
		while(true) {
		
		System.out.println("???"+(count++)+Thread.currentThread().getName());
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if (count ==10) 
			break;
		
		
		}
		
	}
	
}