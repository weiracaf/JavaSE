package yuan.hsp.net.socket;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

import yuan.learn.basic.Multithreading.interrupt_;
@SuppressWarnings({"all"})
//�����������ݵķ����-������TCP�ֽ����������
public class Server {
	public static void main(String[] args) throws IOException {
		//����ı���������ȥ������-������-TCP�ֽ������
		//�ڱ�����9999�˿ڼ�����Ҫ�󱾻�û����������ռ��9999�˿�
		ServerSocket serverSocket = new ServerSocket(9999);
		System.out.println("�������9999�˿ڼ������ȴ�����...");
		//��û�пͻ�������9999�˿ڣ����������ȴ�����
		//����пͻ������ӣ��᷵��һ��Socket�����������ֱ��ȥ���ͻ��˵Ĵ��룬����������Ȼ������Ĵ���Ż�����
		Socket accept = serverSocket.accept();
		System.out.println("�����"+accept.getClass());//��仰��ʵ��ֻ����������������������������Ϊû�ͻ�������
		//Ȼ������ͨ���ͻ������ӱ���9999�˿ڣ��ɹ��������������һ�仰
		
		//�����ǽ������������������Ȼ�������������ͨ������������ȡ����
		InputStream inputStream = accept.getInputStream();
		//IO��ȡ
		byte [] buf = new byte[1024];
		int readLen = 0;
		while((readLen=inputStream.read(buf))!=-1) {
			System.out.println(new String(buf,0,readLen));//String�������ֹ���������ʶ�ˣ����ݶ�ȡ��������ʾ
		}
		
		
		OutputStream outputStream = accept.getOutputStream();
		outputStream.write("Hello,client".getBytes());
		
		accept.shutdownOutput();
		
		
		outputStream.close();
		
		inputStream.close();
		accept.close();
		serverSocket.close();//���û����˳���һ������
		//����serverSocket��accept��socket��������
		//���ǵ�һ�����Բ����ܶ��Socket����������˵����������Ҫ�Ͷ���û������ӣ��㲻����ֻ��һ��Socket����
		//����ͨ��serverSocket����Socket��ָ���û����ӣ�����serverSocket�൱�ھ��������ɾ����Ա��
		//�ͽ���ͨѶҵ���Լ����㸺�����˵ģ�����û�пͻ��Ļ���Ա�����������һ��رգ�û��Ҫ���ʲô��
		
		
	}

}
