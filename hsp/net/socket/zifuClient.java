package yuan.hsp.net.socket;

//���ַ����;�����readLine
//��read�Ļ�һ��һ���ֽڶ��Ŀ϶������������
//Ҳ������newLine��Ϊ����

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;

import org.hamcrest.core.StringEndsWith;
@SuppressWarnings({"all"})
public class zifuClient {
	public static void main(String[] args) throws UnknownHostException, IOException {
		Socket socket = new Socket(InetAddress.getLocalHost(), 9999);

		
		OutputStream outputStream = socket.getOutputStream();
		
		
		BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(outputStream));//������,������ת����
		bufferedWriter.write("Hello,zifuServer");
		bufferedWriter.newLine();//����һ�����з�����ʾԭ��д�����ݽ������Ͳ���Ҫ�Ǹ��ֽ����Ľ�������ˣ��������ն�Ҫ��readLine
		bufferedWriter.flush();//�ַ�����Ҫˢ�£��Ż�д��ͨ��
		
		
		
		
		InputStream inputStream = socket.getInputStream();
		BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
		System.out.println(bufferedReader.readLine());
		
		
		
		
		//�ر�����socket
		bufferedReader.close();
		bufferedWriter.close();//�ر�����������������Ҳ�ر���
		socket.close();
		System.out.println("�ͻ����˳�");
	}
}
