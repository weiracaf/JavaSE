package yuan.hsp.net.socket;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;

import yuan.learn.basic.Multithreading.interrupt_;
@SuppressWarnings({"all"})
//�����ǿͻ��ˣ�����hello,Server�������
public class Cilent {
public static void main(String[] args) throws UnknownHostException, IOException {
//	˼·
	//���ӷ�����
	//���ӳɹ��Ժ󷵻�Socket���󣬸�ֵ��socket
	Socket socket = new Socket(InetAddress.getLocalHost(), 9999);//��Ϊ���������Ǳ����ĳ���
	//����ֱ���ñ�����InetAdress���󼴿ɣ���������ǰٶ�ʲô�ģ�����д��Ӧ��IPV4��9999�Ļ����Ƕ˿ں�
	
	//�������Ժ�ͨ��socket��ú�socket�������������������ǻ����������ˣ�
	OutputStream outputStream = socket.getOutputStream();
	outputStream.write("Hello,Server".getBytes());//�ֽ���д��
	
	//���ý������
	socket.shutdownOutput();
	
	
	InputStream inputStream = socket.getInputStream();
	int readlen=0;
	byte [] b =new byte[1024];
	while ((readlen=inputStream.read(b))!=-1) {
		System.out.println(new String(b,0,readlen));
		
	}
	inputStream.close();
	
	//�ر�����socket
	outputStream.close();
	socket.close();
	System.out.println("�ͻ����˳�");
}
}
