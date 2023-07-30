package yuan.learn.basic;
import java.awt.geom.Point2D;
@SuppressWarnings({"all"})
//注意：在jdk7.0前接口里所有的方法都没有方法体
//jdk8.0以后接口里可以有静态方法，默认方法，也就是说接口中可以有方法的实现
public interface Demo01 {
	int a = 10;//默认就是public static final int a=10;
	void myMethod();//类似于没有abstract的抽象方法，和抽象方法特征相同，需要实现，默认public
	default public void Point2D() {//这个就是有方法体的默认方法喽，不过要有default修饰才可以加方法体
		System.out.println("666");
	}
	static public void sa() {	//静态方法，有方法体，可以像类那样，接口名.静态方法
		//调用
		System.out.println("sa");
	}
	

}
 class B implements Demo01{
	
	public static void main(String[] args) {
	Demo01.sa();
	B a = new B();
	a.Point2D();
	}

	@Override
	public void myMethod() {
		// TODO Auto-generated method stub
		
	}
}
