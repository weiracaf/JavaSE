package yuan.learn.basic;

import org.junit.jupiter.api.Test;

//本篇Junit
//传统测试方法需要先创建后调用方法
//Junit帮助我们可以直接运行方法
//方法结束在想要单独运行的方法上加上@Test
//运行方法，右键鼠标->Run as->Junit Test
//这样会把有@Test全运行
//如果想单独调用
//选中方法名，右击鼠标还是->Run as->Junit Test
public class Junit {
	@Test
	public void m2() {
		System.out.println("m2方法调用");
	}
	@Test
	public void n1() {
		int n =10;
		System.out.println(n+"n1方法奥");
	}
}
