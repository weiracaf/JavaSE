package yuan.javaexper;
@SuppressWarnings("all")
public class String_Buffer {
	public static void main(String[] args) {
		String string = new String("java");
		StringBuffer stringBuffer01 = new StringBuffer(string);
		System.out.println("����֮ǰ"+stringBuffer01);
		
		stringBuffer01.append(" is diffcult?");
		stringBuffer01.insert(0, "yuan think ");
		System.out.println("������������֮��"+stringBuffer01);
		
		stringBuffer01.delete(stringBuffer01.length()-1, stringBuffer01.length());//ɾ�����һ���ַ�
		stringBuffer01.delete(0, 11);//ɾ��yuan think
		System.out.println("����ɾ����"+stringBuffer01);
		
		stringBuffer01.replace(0, 4, "python");
		System.out.println("java�滻Ϊpython"+stringBuffer01);
		
		System.out.println("��ת���stringbuffer,��ֱ���޸�ԭ����"
				+ "������"+stringBuffer01.reverse());
		stringBuffer01.reverse();//Ϊ�˷���۲��ٷ�תһ��
		System.out.println("��ȡ��is�ĺ���"+stringBuffer01.substring(7));
		System.out.println("��ȡ����is��ǰ��"+stringBuffer01.substring(0,7));
		System.out.println("�����");
		String s = "hebei";
		System.out.println("String����û���޸�ǰ"+s);
		change(s);		
		System.out.println("String�����޸ĺ�"+s);	
					//��Ϊ��String����Ȼ�������������ͣ�������������������ʱ�ͻ�������������һ����
		System.out.println("------------------");
		StringBuffer sb = new StringBuffer();
		sb.append("hebei");
		change(sb);		
		System.out.println(sb);	
		
		System.out.println("�ܽ�String���ʹ���"
				+ "String���ͱȽ����⣬��ΪString�����ǲ��ɱ�ģ�����βξ��������޸ĵĻ����������лῪ��һ���µ��ڴ�ռ����洢�޸ĺ�����ݣ�ֱ��ʹ��˫��������������String�����ֱ�Ӵ洢�ڳ������У����βεĸı��ʵ��Ҳû��Ӱ�졣�����ֵ����һ��������ֵ���ݲ��Ὺ���µ��ڴ�ռ䡣\r\n"
				);
		
	}
	public static void change(String s) {
	s+="yuan";
	}
	public static void change(StringBuffer a) {
		a.append("yuan_buffer");
	}
}
