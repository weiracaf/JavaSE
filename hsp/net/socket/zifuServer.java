package yuan.hsp.net.socket;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.ServerSocket;
import java.net.Socket;
@SuppressWarnings({"all"})
//����Ļ�����ǰ���ֽ�����Ϊ�ַ����ĸİ棬Ҫ��һ��
//����˼�����ת�����
//�ַ�������һЩ
public class zifuServer {
	public static void main(String[] args) throws IOException {
		//����˽���
		ServerSocket serverSocket = new ServerSocket(9999);
		System.out.println("�������9999�˿ڼ������ȴ�����...");
		
		Socket accept = serverSocket.accept();
		System.out.println("�����"+accept.getClass());
		//���ֽ�����Ȼ��ת����+������
		InputStream inputStream = accept.getInputStream();
		BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
		String readLine = bufferedReader.readLine();
		System.out.println(readLine);
	
		
		//�������Ƿ�������
		OutputStream outputStream = accept.getOutputStream();
		BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(outputStream));
		bufferedWriter.write("hello,zifuClient");
		bufferedWriter.newLine();//���д��������������readLine,�Ͳ���accept.shutdownOutput();��
		bufferedWriter.flush();//һ��Ҫˢ�»����
		
		//�ر���������ɣ�����һ���Ǻ�򿪵����ȹر�
		bufferedWriter.close();
		bufferedReader.close();
		accept.close();
		serverSocket.close();
		
		
		
	}

}
