package yuan.learn.basic.IO;

import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.io.PrintWriter;

import org.junit.Test;

//��ƪ����ӡ��
//��Ҫ�������࣬PrintStream��PrintWriter-�����������һ���ֽ���һ���ַ���
//PrintStream������FileOutputStream��FileOutputStream������OutputStream��
//���������PrintStream����Ҫ��;
//����һ����;
//�޸�sout��Ĭ��λ�ã�Ĭ���ǵ���ʾ���ϵģ�����ͨ��setOut������
//�������λ�ã����Ե��ļ��У�Ȼ��ֱ���������
//û�еĻ����½��ļ��������
//����Ҳ������ʾ��

//PrintWriter������Writer
//�����������ʾ���ϣ�System.out������ʾ����,Ҳ�������뵽�ļ�����Ҫclose��������ɹ�
//���Ը���·�����ļ���
//��Ҫclose�ſ��Գɹ����ȥ


public class ��ӡ�� {
public static void main(String[] args) throws FileNotFoundException {
	PrintStream out =System.out;//��������������ʾ���ϣ�System.out������һ��PrintStream��������ʾ��
	out.print(6);
	out.close();
	System.setOut(new PrintStream("D:\\a.txt"));
	System.out.println("666");
}
@Test
	public void m() {
	PrintWriter printWriter = new PrintWriter(System.out);
	printWriter.write("�������");
	printWriter.close();
}
}
