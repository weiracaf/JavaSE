package yuan.hsp.net.TranFile;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.BufferedWriter;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStreamWriter;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.UnknownHostException;
@SuppressWarnings({"all"})
public class Server {
	public static void main(String[] args) throws UnknownHostException, IOException {
		//����˽�ServerSocket����8888�˿ڼ���
		ServerSocket serverSocket = new ServerSocket(8888);
		System.out.println("��8888�˿ڵȴ�����");
		//�ȴ�����
		Socket accept = serverSocket.accept();
		//�ȴ����������������ȡ���ݣ���������
		BufferedInputStream In = new BufferedInputStream(accept.getInputStream());
		//��������֮ǰ�Ѿ�д������������ַ�����ķ���ֱ����
		byte[] STA = StreamUtils.StreamTOByteArray(In);
		//(���·��)�������������ļ������Ǵ�������
		BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream("src\\66.png"));
		bos.write(STA);//д��
		System.out.println("����˴����ļ����");
		
		
		//Ȼ���������ͻ��ˣ��յ�ͼƬ
		BufferedWriter b = new BufferedWriter(new OutputStreamWriter(accept.getOutputStream()));
		b.write("�յ�ͼƬ");
		b.flush();//����ײ���Ƿ�������
		accept.shutdownInput();//����������Ϊֹͣ��־����ô���շ��ǿ������ֽ��������ַ�����������ݵ�
		
		
		//��������ҲҪ���رգ���Ȼ��д�������Cilent����������֪��Ϊɶ���о�д��������������ر�һ�°�
		In.close();
		bos.close();
		
		b.close();
		accept.close();
		serverSocket.close();
		System.out.println("������˳�");
		
		
	}

}
