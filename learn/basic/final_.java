package yuan.learn.basic;
//��ƪ��Ҫ��final�ؼ���
public class final_ {
public static void main(String[] args) {
	//final�������κܶණ�������ࡢ���ԡ������;ֲ�����������
	//final�����࣬���಻�ɼ̳�
	//final���η�����ʱ�򣬸÷������ɱ�������д
	//final�������ԡ��ֲ�������ʱ�򣬸����Ե�ֵ�����޸�
	//final�������õ�ʱ��ֻ��ָ��Ķ��󲻿ɸı䣬�������ֵ�ǿ��Ըı��
	//final���ε�ֵ������Ǿ�̬����1.����ʱ2.������3.�����
	//����һ���и�ֵ����
	//������ε��Ǿ�̬��1.����ʱ2.��̬�����
	//ֻ������������ѡһ��
	//��Ϊ��̬���Եļ����Ǳ���ͨ����Ҫ�ȵģ�
	
	//final��static����ʹ��Ч�ʸ���
	//public static int a=8;������.a����ʱ�ᵼ�������
	//�����public final static int a=8;��������Ͳ��ᵼ�������
	//���ǿ����þ�̬�������֤һ��
	System.out.println(add.b);
	System.out.println(add.c);
	//ok��
}
}
class add{
	public static int c=8;
	public final static int b=10;
	static {
		System.out.println("a�౻����");
	}
}
