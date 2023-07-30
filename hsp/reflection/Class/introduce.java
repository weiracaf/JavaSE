package yuan.hsp.reflection.Class;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;

import yuan.hsp.reflection.Cat;
@SuppressWarnings({"all"})
//class��Ļ�������
public class introduce {
public static void main(String[] args) throws ClassNotFoundException, InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException, NoSuchFieldException {
	String classPath="yuan.hsp.reflection.Class.Car";
	//1.��ȡ��Car���Ӧ��Class����
	Class cls = Class.forName(classPath);
	//2.���cls
	System.out.println(cls);//����ʾ���ĸ����Class����Ӧ����toString��д�ģ�
	System.out.println(cls.getClass());//���cls���������� java.lang.Class
	//3.�õ�����
	System.out.println("================================");
	System.out.println(cls.getPackage().getName());
	System.out.println(cls.getPackageName());//���ֶ�����
	//4.�õ�ȫ����
	System.out.println("================================");
	System.out.println(cls.getName());//��������
	//5.ͨ��cls��������ʵ��
	Object newInstance = cls.newInstance();//��Ȼ�������������
	
	Car newInstance2 = (Car)cls.getDeclaredConstructor().newInstance();//����һ�����������
	//�Ȼ������ٴ�������ʵ��
	System.out.println(newInstance2);
	//6.ͨ�������ȡ����brand,ע�⣺˽�����Բ���ͨ���÷�ʽ��ȡ�������е�����
	Field brand = cls.getField("brand");
	System.out.println(brand.get(newInstance2));
	//7.ͨ����������Ը�ֵ
	brand.set(newInstance2, "����");
	System.out.println(brand.get(newInstance2));
	//8.ϣ�����Եõ�Car�����е�����
	System.out.println("======================================");
	Field[] fields = cls.getFields();
	for (Field field : fields) {
		System.out.println(field.getName());//����������Ե�����
	}
	
	
}
}

class Car{
	public String brand="����";
	public int price=1000000;
	public String color="��";
	@Override
	public String toString() {
		return "Car [brand=" + brand + ", price=" + price + ", color=" + color + "]";
	}
	
}
