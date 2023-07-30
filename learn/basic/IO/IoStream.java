package yuan.learn.basic.IO;

import java.io.FileInputStream;
import java.io.IOException;

import org.junit.Test;

//��ƪ��IO��ԭ��,�Լ�һЩ���ķ���

//ע�⣺�������ļ���word��excel��ͼƬʲô�ģ�һ��Ҫ���ֽ����������ı��ļ���txtʲô�ģ�һ�����ַ�������

//java.io�����ṩ�˸��֡�������ͽӿڣ����Ի�ȡ��ͬ��������ݣ���ͨ����������/�������
//���ķ�����Ҫ��
//		 ������ 	 	�����
// �ַ���Reader   	Writer
// �ֽ���InputStream	OutputStream
//JavaIO���漰��ʮ����࣬���������϶������ĸ����������һ����������ƾ��� ������������.class�������ø���������׺
//����Reader���������һ��FileReader

//�������ҽ��򵥽�һ���ֽ�������InputStream���ֽ������OutputStream����������

//һ.�ֽ�������InputStream
//��������
//FileInputStream�ļ�������,BufferedlnputStream�����ֽ���������ObjectInputStream�����ֽ�������
//1.�ļ�������
//���÷���
//������FileInputStream(File file)	FileInputStream(String name)
//close()�ر���
//read()�Ӵ��������ж�ȡһ�������ֽڣ�read(byte[] b)����ȡb.length���ֽڣ���ŵ�b�����У�����ֵ�Ƕ�ȡ�����ֽ���������������
//ͨ�������ȡ���ص��ֽ��������Ժ�Write(byte[],int off,int len)�����������ӣ�������copy��ϸ�ڿ��Կ�Copy_
//read(byte[] b, int off,int len)off��������������b��������off��ʼ
//len�������������˶����ֽڵ����ݣ�������Ļ�������һ�δ洢b.length��lenҲ����b.length,����ļ������һ����len�Ż���1
//skip(long n) ������������������n���ֽڵ�����
//ע�⣺������һ��һ���ֽڶ�ȡ�ģ���������ĵ����������Ļ�������룬��Ϊ�����������ֽ�һ�㣬����һ���������൱��ֻ����һ��������
//����һ�����ַ����Ƚϳ���
//���ֵ����ֽڵĶ�ȡ(read()�޲εķ���)Ч�ʱȽϵ�
//һ����byte[] b�Ǹ������Ķ�ȡ���ݣ�ע�⣬���������ܽ����������

//��.�ֽ������OutputStream
//FileOutPutStream
//���÷�������������FileOnputStream(File file)	FileOnputStream(String name)
//FileOnputStream(File file,boolean append)	FileOnputStream(String name,boolean append)
//append�����Ǳ�ʾ��д�����Ҫ׷�ӻ��Ǹ��ǣ�true����׷�ӣ�false/��д���Ǹ���
//close()�ر���
//write(byte[] b)��b.length���ֽڴ�ָ��byte����д����ļ��������
//write(byte[] b, int off,int len)��byte��off������ʼ��len���ֽ�д��������
//write(int b)��ָ���ֽ�д����ļ������


//����������ǿ���дһ��copy��С����ŵ�Copy_

//�������ҽ����ݲ�ͬ���õ��������л��ֽ��⣬һ��һ�����õ�����������������������������ַ������ֽڣ�
//�ֵ�
//1.�ַ��ļ���2.�ڵ����ʹ�����3.��������4.��׼���������5.ת����6.��ӡ��7.Properties��IO��

public class IoStream {
	@Test
    public void readFile01(){
        String filePath="d:\\a.txt";
        int read=0;
        FileInputStream fileInputStream=null;
        try {//����FileInputStream�������ڶ�ȡ�ļ�
            fileInputStream = new FileInputStream(filePath);
            //�Ӹ���������ȡһ���ֽڵ����ݣ����û�����������÷�������ֹ
            //�������-1������������
            while ((read=fileInputStream.read())!=-1){
                System.out.print((char)read);//ת��һ��char��ʾ
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        } finally {
            //�ر��ļ������ͷ���Դ
            try {
                fileInputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
	@Test
    public void readFile02(){
        String filePath="d:\\a.txt";
        
        byte[] buff=new byte[8];//һ�ζ�ȡ�˸��ֽ�
        int readLen=0;
        FileInputStream fileInputStream=null;
        try {//����FileInputStream�������ڶ�ȡ�ļ�
            fileInputStream = new FileInputStream(filePath);
            //�Ӹ���������ȡ����b.length�ֽڵ����ݵ��ֽ����飬�˷�����������ֱ��ĳЩ�������
            //�������-1������������
            //�����ȡ����������ʵ�ʶ�ȡ���ֽ�������������˸��Ͷ�ȡС�ڰ˸��ĸ������������8�����Ͱ˸��˸����������Ļ��Ͷ�ȡ��Ӧ����
			/*ע��
			 * ��Ӧ�����ݻ��ŵ�byte�������� �����Ƕ�̬ʽ�洢 hello,world һ��11���ֽ� ��һ�ζ�ȡ8���ֽ� �ڶ��ζ�ȡ3���ֽ�
			 * �ͻ��ǰ���ֽ���ԭ���ǰ˸��ֽڵ�ǰ���� �滻Ϊ �ڶ��ζ�ȡ������ ���Һ��������û�б� ���������Ǵ�0�����ض��ڶ�ȡ���ֽ���������String
			 * ��������϶��������ģ���ȡ�����������
			 */
           
            while ((readLen=fileInputStream.read(buff))!=-1){
                System.out.print(new String(buff,0,readLen));//ת��һ��char��ʾ
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        } finally {
            //�ر��ļ������ͷ���Դ
            try {
                fileInputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

	
}
