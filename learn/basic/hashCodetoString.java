package yuan.learn.basic;
//��hashCode��toString
public class hashCodetoString {
	public static void main(String[] args) {
		String a= new String("666");
		String b= new String("777");
		String c= new String("666");
		System.out.println(a.hashCode());
		System.out.println(b.hashCode());
		System.out.println(c.hashCode());
		//����˵hashCodeֵ���ع�ϣֵ�����ֵ�͵�ַ�й�
		//ָ��ͬһ������Ĺ�ϣֵһ����ͬ����һ�����󣬲�һ����һ��
		//���ݽṹ�Ǹ���String��hashCode��д�����ַ�������һ���Ļ����صĹ�ϣֵһ��
		Cat dog = new Cat("����",10);	
		System.out.println(dog.toString());	//toStringһ����Ƿ��ض�Ӧ��Ϣ���ɵ��ַ���
	}
}
class Cat{
	String name;
	int age;
	
	public Cat(String name, int age) {
		super();
		this.name = name;
		this.age = age;
	}

	@Override
	public String toString() {
		return "Cat [name=" + name + ", age=" + age + "]";
	}
	

	
	
}