package yuan.learn.basic;
//��ƪ��Ҫ��==��equals֮��Ĳ�ͬ
public class equals {
	public static void main(String[] args) {
		//==�Ļ����ǻ������Ϳ�ֵ�಻��ͬ���������Ϳ��ǲ���ͬһ������ָ���ڴ��Ƿ���ͬ��
		int a=10;
		int b=10;
		System.out.println(a==b);
		String aString = "СԬ";

		String string = new String("СԬ");
		System.out.println(aString==string);//��Ϊnew�ĺ�Stringֱ�ӵ��ڵĴ�����ʽ��һ��
		//���������ַ�����ʹ����һ����==�Ľ��Ҳ������false
		
		//equals�Ļ�ֻ�������������ͣ�Ĭ���жϵ����Ƿ��ַ��ͬ��һ�㶼��������д�÷������ж������Ƿ���ͬ
		//����String����д��equals���������ж��ַ����е������Ƿ���ͬ
		System.out.println(aString.equals(string));//�������Ϊ��
		
		zhen s1 = new zhen("666", 11);
		zhen zhen02 = new zhen("666", 11);
		zhen zhen03 = new zhen("666", 51);
		System.out.println("01��02"+s1.equals(zhen02));
		System.out.println("01��03"+s1.equals(zhen03));
		
		
		
	}
}
class zhen{
	String name;
	int age;
	
	public zhen(String name, int age) {
		super();
		this.name = name;
		this.age = age;
	}
	@Override
	public boolean equals(Object obj) {	//���������д�����������жϣ�Ĭ���жϵ�ַ�Ƿ���ͬ
		if(this==obj)	//1.��ַ��ֱͬ�ӷ�true
			return true;
		if(obj instanceof zhen) {	//2.������ͬ��true
			zhen six=(zhen)obj;
			if(this.name.equals(six.name)&&this.age==six.age)
				return true;
		}
		
			return false;//�����Ծ�false
		
	}
	
}