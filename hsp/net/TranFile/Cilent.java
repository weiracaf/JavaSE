package yuan.hsp.net.TranFile;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;
@SuppressWarnings({"all"})
//�����ļ��ͻ���
//������дһ��������StreamUtils,���������Լ�ȥ��
public class Cilent {
	public static void main(String[] args) throws UnknownHostException, IOException {
		Socket socket = new Socket(InetAddress.getLocalHost(),8888);
		byte [] b=new byte[1024];//�����ֽڽ����ļ�
		
		//����һ�����ļ����뵽���ǿͻ��˵���,�ô����������ļ��ڵ���
		BufferedInputStream bufferedInputStream = new BufferedInputStream(new FileInputStream("d:\\ykj.png"));
		//���ù����࣬�����ǵ��ֽ����������������תΪ�ֽ�����
		byte[] streamTOByteArray = StreamUtils.StreamTOByteArray(bufferedInputStream);
		
		//�����������������ݵ���,���ﻹ���õ���������������Ժ���ô������Ͷ���
		BufferedOutputStream bos = new BufferedOutputStream(socket.getOutputStream());
		bos.write(streamTOByteArray);//д���ֽ�����
		
		bufferedInputStream.close();//���԰��Ǹ��ļ��������ر���
		
		socket.shutdownOutput();//ע�⣬�ֽ�������Ҫ����������
		
		
		InputStream inputStream = socket.getInputStream();//���������ܰ�һ����������ת��Ϊ�ֽ����飬���Ǹ������࣬��Ȼд�˾Ͷ���
		System.out.println(new String(StreamUtils.StreamTOByteArray(inputStream)));
		
		
		//�ر�
		bos.close();//ע�⣬�����Ҫ�м�رգ��ᱨ��
		socket.close();
		System.out.println("�ͻ����˳�");
		
		
		
		
	}

}
