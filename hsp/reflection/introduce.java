package yuan.hsp.reflection;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Properties;

import org.junit.jupiter.api.MethodOrderer.MethodName;
@SuppressWarnings({"all"})
//������Ƶļ򵥽���
public class introduce {
	public static void main(String[] args) throws IOException, ClassNotFoundException, InstantiationException, 
	IllegalAccessException, NoSuchMethodException, SecurityException, 
	IllegalArgumentException, InvocationTargetException, NoSuchFieldException {//���쳣�е�࣬����һ��
//	1.��������ö�Ӧ�ķ���
//	Cat cat = new Cat();
//	cat.hi();
//	2.ʹ��properties�࣬ͨ�������ļ������ж�Ӧ�����ĵ��ã��ȶ�ȡ�����ļ�
		Properties properties = new Properties();
//		properties.load(new FileInputStream("d:\\eclipseworkspace\\Learn\\src\\re.properties"));
		properties.load(new FileInputStream("src\\re.properties"));
		String classfullpath = properties.get("classfullpath").toString();
		String Method = properties.get("method").toString();
		System.out.println(classfullpath);
		System.out.println(Method);
		
//		3.�����������
		//1.�����࣬����Class����cls
		Class cls = Class.forName(classfullpath);
		//2.ͨ��cls��������ʵ��
		Object newInstance = cls.newInstance();
		System.out.println(newInstance.getClass());
		//3.ͨ����cls����ȡ�����Ƕ�Ӧ�Ķ��󷽷����ڷ�����������Ƕ���
		Method method1 = cls.getMethod(Method);
		//4.ͨ��method1���÷��������ø�ʽ����������.invoke(ʵ������)
		System.out.println("==============================");
		method1.invoke(newInstance);
		//�ô����ǿ���ͨ���������ļ����ı���÷����������޸�Դ����
		
//		һЩ������ķ���
		//java.lang.reflect.Field:������ĳ�Ա������Field�����ʾĳ����ĳ�Ա����
		//�õ�age�ֶΰɣ���Ϊprivate��name���޷���getField��ȡ
		Field field = cls.getField("age");
		System.out.println(field.get(newInstance));//��Ա��������.get(ʵ������)
		
		Constructor constructor = cls.getConstructor();
		System.out.println(constructor);
		
		Constructor constructor2 = cls.getConstructor(String.class);
		System.out.println(constructor2);
		
		
		
		
		
		
		
	}
}
