package yuan.javaexper;
@SuppressWarnings({"all"})
public class Integer_mian {
	public static void main(String[] args) {
		Integer i1 = new Integer(97);
		Integer i2 = new Integer(97);
		System.out.println("==���ײ��hashcode-��ַ");
		System.out.println(i1 == i2);		//false
		System.out.println("��װ����дequals�Ƚ������ֵ");
		System.out.println(i1.equals(i2));	//true
		System.out.println("--------------");

		/*Integer�е�equals()�������Ƚϴ˶�����ָ������
				���ҽ���������Ϊnull��������һ����ö��������ͬ int ֵ��Integer����ʱ�����Ϊtrue��
		*/

		Integer i5 = 97;
		Integer i6 = 97;
		
		System.out.println(i5 == i6);
		System.out.println("�����ͬ��ԭ����Ϊ����ָ�����ص�97��û�д���byte��Χ���ᴴ������");
		System.out.println(i5.equals(i6));	//true
		System.out.println("��equals�϶�Ҳ��ͬ�");
		System.out.println("--------------");


		Integer i9 = 127;
		Integer i10 = 127;
		System.out.println(i9 == i10);		//true?
		System.out.println(i9.equals(i10));	//true
		System.out.println("--------------");

		Integer i11 = 128;
		Integer i12 = 128;
		
		System.out.println(i11 == i12);	//false
		System.out.println("�������-127-128��Χ�ڵĻ�Ҳ�ᱨ������byte��ֵ��Χ�ᴴ���µ�Integer����");
		System.out.println(i11.equals(i12));	//true

		/*
		-128 ~ 127��byte��ȡֵ��Χ����������������Χ�ڣ��Զ�װ��Ͳ����´������󣬶��Ǵӳ������л�ȡ��
					   ���������byteȡֵ��Χ���ͻ��ڶ��ڴ����ٴ�������
		ԭ�򣺲鿴API��Integer��valueOf(int i)ԭ�뼴�ɡ�
		*/

		}
	}
