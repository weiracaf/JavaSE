package yuan.learn.basic.IO;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import org.junit.Test;

//�ַ��������ֶ�ˢ��/�رղŻ�д��ͨ����������������������������������

//��ƪ�����ļ��ַ���
//��Ҫ��������FileReader��FileWriter
//FileReader
//1.new FileReader(File/String)
//2.read:ÿ�ζ�ȡ�����ַ������ظ��ַ���(���ص��Ƕ�Ӧ�ַ���int�ο��ܸ���unicode���룬��ҪתΪ�ַ�����)��������ļ�ĩλ����-1
//������ʾ������ǰ���FileInputStream��ͬ������һ�����������֣�Ч�ʸ�
//3.read(char[]):������ȡ����ַ������飬���ض�ȡ�����ַ��������ļ�ĩβ����-1
//��ǰ���Ǹ��ײ�ԭ��һ������ͷ���ǣ����س��ȣ���̬�洢

//���Կ������������еĺ��ֻ���������
//�Ұ��ı���ΪANSl��GBK����û����
//�����ʽ������ txt�ı��е����� ת IO ���� �����ʽ�� �����ʽ������� .java �ļ����õı����ʽһ��������ͻ��������
//Ĭ�Ͼ���GBK���룬������window-preferences-General-workspace�����������б����ʽ-һ����������java�ļ��ı����ʽ����ͬ��

//FileWriter
//���÷���
//new FileWriter(File/String) ����ʽд��	new FileWriter(File/String,true) ׷��ʽд��
//write(int)д�뵥���ַ�	write(char[])д��ָ������	write(char[],off,len)д�����������off��ʼlen���ַ�
//write(string)	 д�������ַ���	write(string,off,len)д���ַ���������off��ʼlen���ַ�
//ע�⣺FileWriter�󣬱���Ҫ�رգ�close����ˢ�£�flush������д�벻��ָ�����ļ�
//��Ϊ�������������ڲ���һ��������implFlush��-�������İ�����д���ļ���
//������һ��s���������õ�ʵ��
//��Ȼwrite���ж����β�
/*��������
���Դ�char����
���ߵ����ַ�
������(String a,int off,int len)
ѡȡ�ַ�����һ����

�������������£�ʹ��ѭ������*/
public class �ļ��ַ��� {
	 public static void main(String[] args) {

	        String filePath="d:\\a.txt";
	        int b=' ';
	        FileReader a=null;
	        try {
	            a=new FileReader(filePath);
	            while ((b=a.read())!=-1){//ѭ����ȡ��ʹ��read�������ַ���ȡ
	                System.out.print((char)b);
	            }
	        } catch (IOException e) {
	            e.printStackTrace();
	        }
	        finally {
	            try {
	                a.close();
	            } catch (IOException e) {
	                e.printStackTrace();
	            }
	        }
	    }
	 @Test
	    public void Reader01(){
	        String filePath="d:\\a.txt";
	        char []q=new char[10];
	        int readlen=0;
	        FileReader a=null;
	        try {
	            a=new FileReader(filePath);
	            while ((readlen=a.read(q))!=-1){//ѭ����ȡ��ʹ��read������ʵ�ʶ�ȡ�����ַ���
	                System.out.print(new String(q,0,readlen));
	            }
	        } catch (IOException e) {
	            e.printStackTrace();
	        }
	        finally {
	            try {
	                a.close();
	            } catch (IOException e) {
	                e.printStackTrace();
	            }
	        }
	    }
	 @Test
	    public void s(){
	        FileWriter d=null;
	        try {
	            d=new FileWriter("d:\\note.txt");
	            d.write("����֮�󣬶����ʺ�");
	        } catch (IOException e) {
	            e.printStackTrace();
	        } finally {
	            try {
	                d.close();
	            } catch (IOException e) {
	                e.printStackTrace();
	            }
	        }
	    }


}
