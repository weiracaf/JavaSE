package yuan.learn.basic;
//��ƪ��Ҫ����ö���������
//ö�ٿ������Ϊһ�鳣���ļ��ϣ�������Ϊ��һ��������࣬����ֻ����һ�����޵��ض�����
//ΪʲôҪ��ö��
//���缾����ʵֻ���ĸ������ﶬ����Ĺ�����д���������������ͨ�Ļ�
//�û���ʵ������������ڵ��ַ�����ֵ�����ܴ���������졯�ȵ���ֵļ���
//���ǿ���ͨ��ö��������
@SuppressWarnings({"all"})
//ö��������ʵ�ַ�ʽ
//1.�Զ���
//2.ͨ��enum�ؼ��֣��������һ��enum��Demo02,���������
public class enum_ {
	final static public enum_ c=new enum_();//�൱�ھ�̬���ԣ����Ծ��ܣ�d���Ǿ�̬�����������c������˻������ھ�̬����main���õ�
	
	int d =100;
public static void main(String[] args) {
	Season a = Season.Autumn;	//������ֻ��ͨ����.�Ѵ�������ֵ��
	System.out.println(a.getDesc());
	System.out.println(a.getName());
	System.out.println(Demo02.Autumn);//�����enum�Ǹ�
	System.out.println(Demo02.Winter);
	System.out.println(c.d);
}
}
class Season{//1.�Զ���ʵ��ö��
	//�ص�
	//1.������˽�л�
	//2.�����ڲ�����һ�����
	//3.���Ⱪ¶����ͨ�����public static final���η�������������Ҳ����ֱ�ӵ��÷�����
	//  final�������ã�ָ��Ķ��󲻿ɸı䣬�������ֵ�ǿ��Ըı��
	//4.�����ṩget���������ṩset����
	private String name;
	private String desc;
	
	private Season(String name, String desc) {
		super();
		this.name = name;
		this.desc = desc;
	}

	final public static Season Spring = new Season("����","��ů");
	final public static Season Summer = new Season("����","����");
	final public static Season Autumn = new Season("����","��ˬ");
	final public static Season Winter = new Season("����","����");
	

	public String getName() {
		return name;
	}
	public String getDesc() {
		return desc;
	}
	
	
}
