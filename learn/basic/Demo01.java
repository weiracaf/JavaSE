package yuan.learn.basic;
import java.awt.geom.Point2D;
@SuppressWarnings({"all"})
//ע�⣺��jdk7.0ǰ�ӿ������еķ�����û�з�����
//jdk8.0�Ժ�ӿ�������о�̬������Ĭ�Ϸ�����Ҳ����˵�ӿ��п����з�����ʵ��
public interface Demo01 {
	int a = 10;//Ĭ�Ͼ���public static final int a=10;
	void myMethod();//������û��abstract�ĳ��󷽷����ͳ��󷽷�������ͬ����Ҫʵ�֣�Ĭ��public
	default public void Point2D() {//��������з������Ĭ�Ϸ���ඣ�����Ҫ��default���βſ��Լӷ�����
		System.out.println("666");
	}
	static public void sa() {	//��̬�������з����壬���������������ӿ���.��̬����
		//����
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
