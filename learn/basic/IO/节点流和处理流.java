package yuan.learn.basic.IO;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import org.junit.Test;

//��ƪ�ǽڵ����ʹ������Ľ���

//�ַ������ڴ��ı��ļ���Ҳ��ASCLL�ļ���
//�ֽ������ڶ������ļ�

//�ڵ������Դ�һ���ض�������Դ��д���ݣ���FileWriter,FileReader
//��������Ҳ�ư�װ�����ǡ����ӡ����Ѵ��ڵ������ڵ�����������֮�ϣ�Ϊ�����ṩ��Ϊǿ��Ķ�д���ܣ���BufferedReader,BufferedWriter
//���ߵ�����
//�ڵ����ǵײ���ֱ�Ӻ�����Դ����
//��������װ�ڵ������ȿ���������ͬ�ڵ���֮���ʵ�ֲ��죬Ҳ�����ṩ������ķ�������������
//�������ô�1.������ߣ������ӻ��巽ʽ��������������Ч��2.�����ı�ݣ��������ṩһϵ�б�ݵķ�����һ������������������ݣ�������������

/*�ڵ�����ֱ�Ӳ�������Դ��ֻ�ܶԶ�Ӧ������Դ���в�������һ�������ƣ�����Բ�������������Ч�ʿ��ܲ��Ǻܸߣ����ܿ��ܲ��Ǻ�ǿ��
���������Խڵ�������һ����װ���Ƚڵ������ܸ�ǿ��
ע��һ�㴦�������治���ٰ�һ��������������һ���ڵ�����ǰ��������û������
�����Ҫ�ص��ڵ�����*/

//ֻ˵�϶����У��ٸ����Ӱ�
//����������BufferedReader������һ������ Reader,���Դ洢�ڵ�����ֻҪ��Reader���࣬BufferedWriterͬ������Writer
//���Reader����Writer���Կ��԰�����ı���FileReader��CharArrayReader��CharArrayWriterʲô�ĶԶ�Ӧ���������ͻ����ļ����в�����
//����ֱ�Ӱ������Ľڵ�������ȥ������ģʽ��������ģʽ

//��������Ҫ�Ǵ������Ľ���
//BufferdReader��BufferedWriter������Ҫ����readLine����
//�����ַ���(��Ϊ����Reader�������)
//���ҹرյ�ʱ��ֻ�ر���������ɣ��ײ���Զ��رհ�װ�Ľڵ���
//1.BufferdReader
//�����������Լ���
//����read��һ���ַ�һ���ַ���ȡ��
/*readLine��һ��һ�ж�ȡȻ�󷵻�
��line����Ч�ʱȽϸ�*/
//2.BufferedWriter
//����
//ʹ��BufferWriter��
//�������޾У�������
//����d�̵�a.txt�ļ��У�����ʽ��
//jie()����ʵ��

//������ƣ��ֽ���Ҳ���ж�Ӧ�Ĵ�������
//�ֱ���BufferInputStream��BufferOutputStream�����ڲ����������ļ�
//��������ԭ�����ַ�������һ������˵�ˣ��о�һ�³��÷���
//3.BufferInputStream
//���췽��BufferedInputStream(InputStream in) ����BufferedInputStream(InputStream in,int size)
//�ڶ��ַ�������ָ����������С��������������õ�һ����ð��Ҹо�
//������1.read()2.read(byte []b,int off,int len),3.skip()4.close()5.read(byte[]b)ע��5����ֵ�Ƕ�ȡ�����ֽ���
//����InputStream�ķ���
//�ײ���ʵ���ǵ������ǽڵ����ķ���
//4.BufferedOutputStream
//����BufferedWriter
//ʵ����������壬���ֽ�д��ײ��������������д��һ�ε��õײ�ϵͳһ��
//���÷�����������BufferedOutputStream(OutputStream out),BufferedOutputStream(OutputStream out,int size)
//�Ǹ��ڶ���Ҳ��ָ����������С��������Ľ���һ��
//write(int b)  write(byte []b,int off,int len)  flush()  write(byte[] b) 
//�Լ���OutputStream���ܹ��ķ���

//�����Ƕ�������

@SuppressWarnings({"all"})
public class �ڵ����ʹ����� {
	public static void main(String[] args) throws IOException {
		String filepath="d:\\ѧϰ\\6.txt";	//ע���d�̵�Ӳ������d:�������ļ���ֱ��д�ļ������ֲ��ü�:
		BufferedReader bufferedReader = new BufferedReader(new FileReader(filepath));
		String line;
		while((line = bufferedReader.readLine())!=null) {
			System.out.println(line);
		}
		bufferedReader.close();//��װ�Ľڵ��������Ŵ������Ĺرն��ر�
	}
	 @Test
	    public void jie(){
	        BufferedWriter bufferedWriter=null;
	        try {
	             bufferedWriter = new BufferedWriter(new FileWriter("d:\\a.txt"));
	            bufferedWriter.write("�����޾У��������");
	            System.out.println("�޸����");
	        } catch (IOException e) {
	           e.printStackTrace();
	        } finally {
	            try {
	                bufferedWriter.close();
	            } catch (IOException e) {
	                e.printStackTrace();
	            }
	        }
	    }

	

}
