package yuan.javaexper;
@SuppressWarnings("all")
public class Packed_class {
		public static void main(String[] args) {
			//int����תΪString
			//��ʽ1
			int i = 100;
			String s1 = i + "";	
			System.out.println(s1);	
			//��ʽ2
			String s2 = String.valueOf(i);
			System.out.println(s2);
			//int��String
			//��ʽ3
			Integer i2 = new Integer(i);
			String s3 = i2.toString();
			System.out.println(s3);
			//��ʽ4
			String s4 = Integer.toString(i);
			System.out.println(s4);
			//Stirng->int
			//�Ȱ�StringתΪInteger-���ֶ�������һ����ֱ���ֶ�װ�������String��Ϊ����
			String s = "200";
			Integer i3 = new Integer(s);//�ֶ�װ��
			//�ֶ�����
			int i4 = i3.intValue();	
			System.out.println(i4);
			//�ֶ�װ��-��������String��Ϊ����
			int i5 = Integer.parseInt(s);
			System.out.println(i5);
			System.out.println("�Զ�װ��Ͳ���");
			
			Integer a1 = 100;	//�Զ�װ�䣺�ѻ�����������ת���ɶ���ֱ�ӿ��Ը������������͸�ֵ
			//�ײ����ֶ�װ��
			int z = a1 + 200;	//�Զ����䣺�Ѷ���ת��Ϊ������������
			//�ײ�Ҳ���ֶ����䣬���ĸ�XXXvalue()����
			System.out.println(z);	//300
			


			
		
		
		
	}

}
