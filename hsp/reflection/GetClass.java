package yuan.hsp.reflection;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

//��ƪ��Ҫ�ǻ�ȡClass��ĸ��ַ���
@SuppressWarnings({"all"})
public class GetClass {
	public static void main(String[] args) throws ClassNotFoundException, FileNotFoundException, IOException {
		//1.Class.forName(��Ӧ���ȫ·��)-�����������ļ���ȡ��ȫ·����������
		Properties properties = new Properties();
		properties.load(new FileInputStream("src\\re.properties"));
		String classfullpath = properties.get("classfullpath").toString();
		Class cls1 = Class.forName(classfullpath);
		System.out.println(cls1);
		//2.����֪������࣬ͨ�����class��ȡ���÷�ʽ�ȫ�ɿ������������-�����ڲ�������
		Class cls2 = Cat.class;
		System.out.println(cls2);
		//3.��֪ĳ�����ʵ�������øö�Ӧ��getClass()��������ȡ�����������Ӧ��Class����-Ӧ�ó�����ͨ�����õĶ��󣬻�ȡClass�����������ͣ�
		Cat cat = new Cat();
		Class cls3 = cat.getClass();
		System.out.println(cls3);
		//4.ͨ�����������ȡ���Class����
		//(1)�ȵõ��������cat
		ClassLoader classLoader = cat.getClass().getClassLoader();
		//(2)ͨ����������õ�Class����
		Class cls4 = classLoader.loadClass(classfullpath);
		System.out.println(cls4);
		//cls1,cls2,cls3,cls4����ͬһ��Class����
		
		//�����������ͻ�ȡclass�����ַ�ʽ
		//1.(������������int,short,long).class�õ�Class����
		Class<Integer> i = int.class;
		Class<Character> c = char.class;
		System.out.println(i);
		System.out.println(c);
		//2.�����������Ͷ�Ӧ�İ�װ��.type,��ö�Ӧ��Class����
		Class<Integer> type = Integer.TYPE;
		System.out.println(type);
		//Ȼ����ʵ���int��Integer��ʵ�Ƕ�Ӧ��һ��Class,int�Զ�װ��ΪInteger��ȡ��Ӧ��Class����
		System.out.println(i.hashCode());
		System.out.println(type.hashCode());
	}

}
