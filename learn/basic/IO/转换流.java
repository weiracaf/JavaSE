package yuan.learn.basic.IO;
//��ƪת����
//������Ҫ��1.InputStreamReader2.OutputStreamWriter

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
@SuppressWarnings({"all"})
//��Դ��ı��ļ��ı����ʽ��ͬ������һ����
//ע�⣺ת�����������һ���ַ����������ֽ�������ת����InputStreamReader�������ַ���
//�������������������GBK���룬��ô���ַ�����ȡUTF-8�ͻ��������

//���ǿ���ͨ��ָ�����ǲ����ļ��ı����ʽ�����о�ȷ��ȡ

//����ֻ���ֽ�������������ָ����ȡ��������Ҫͨ��ת����ָ����ȡ�����ʽ��������Ҫ��ָ���ֽ����Ķ�ȡ�����ʽ
//�ַ���׼ȷ��ȡ��ǰ���Ǹ������ģ�����java�ļ������ʽ�Ͳ������ı��ļ�����һ�£�
//Ȼ����ת��������ת��Ϊ�ַ�����InputStreamReader�����ģ�����ȡ���ı��ļ�

//����InputStreamReader
//������InputStreamReader(InputStream,Charset)  �ڶ����������Ǳ����ʽ�
//�൱�ڲ�����һ���ֽ���ת��Ϊ�ַ���������ָ���ö�ȡʲô�����ʽ
//�㲻ָ����Ĭ��java�����������ʽ
//��������ʾ����


//Ȼ��OutputStreamWriter
//���ǰ���ָ�������ʽд���ļ���
//������һ���ģ�ʲôָ�����룬���췽��
//ֻ�ܽ����ֽ�����һ����������
//��һƪ-��ӡ��


//ת����һ��Ҫ�ʹ�����һ���ð£�����

public class ת���� {
	public static void main(String[] args) throws IOException, FileNotFoundException {
		String aString="d:\\a.txt";
		//�ֽ���ת�ַ�����ָ�������ʽ
		InputStreamReader inputStreamReader = new InputStreamReader(new FileInputStream(aString), "gbk");
		
		BufferedReader bufferedReader = new BufferedReader(inputStreamReader);//��������
		String string = bufferedReader.readLine();
		System.out.println(string);
		bufferedReader.close();
		
	}
}
