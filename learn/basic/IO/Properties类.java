package yuan.learn.basic.IO;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

//��ƪ��IO�е�Properties��
//˵��һ��XXX.properties�������ļ�
//��ô��ȡ�����ļ����ݣ����������
//�����ļ��ĸ�ʽ
//��=ֵ
//ע���ֵ��û�пո�ֵ����Ҫ����������
//Properties���÷���
//load(),���������ļ���ֵ�Ե�Properties���󣬷��صľ���һ��Properties����
//list()����ָ��������ʾ��ָ���豸
//getProperty(key)���ݼ���ȡvalue
//setProperty(key,value)���ü�ֵ�Ե�properties����
//store()��properties����ļ�ֵ�Դ洢�������ļ���������׷��Ȼ��key��ͬ������滻���������Ľ���unicode����

//ע��д��Ͷ�ȡ��ʱ�����ͬд��������������ȡ����������

//�޸Ķ�Ӧ��k-v��
//
//���setProperty(key,value)
//���key�ǲ����ڵ������Ǵ�������������������޸�
//
//�޸�pwdΪ888888
public class Properties�� {
	public static void main(String[] args) throws FileNotFoundException, IOException {
		//�Ƚ�����
		Properties properties = new Properties();
		//�漸����ֵ��
		properties.setProperty("user", "СԬ");
		properties.setProperty("ip", "666");
		properties.setProperty("pwb", "abc111");
		//����Щ��ֵ�Դ洢���ļ���
		properties.store(new FileOutputStream("d:\\ѧϰ\\666.properties"), null);//�Լ�ȥ����
		System.out.println("�����ļ��ɹ�");
		
		Properties properties2 = new Properties();
		properties2.load(new FileReader("d:\\ѧϰ\\666.properties"));
		properties2.list(System.out);
		
		Properties properties3 = new Properties();
		properties3.setProperty("pwb", "888888");
		properties3.store(new FileOutputStream("d:\\ѧϰ\\666.properties"), null);
		
		properties2.load(new FileReader("d:\\ѧϰ\\666.properties"));//�޸���Ҫ�ȶ�ȡ�������ݣ���Ȼ�����ϴεĽ��
		properties2.list(System.out);
		
		
	}

}
