package yuan.hsp.net.TranFile;

import java.io.BufferedOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;
@SuppressWarnings({"all"})
//�ļ����ؿͻ���
public class downloadCilent {
	public static void main(String[] args) throws IOException {
		Socket socket = new Socket(InetAddress.getLocalHost(),6666);
		Scanner scanner = new Scanner(System.in);
		System.out.println("��������Ҫ���صĸ�");
		String next = scanner.next();
		
		BufferedOutputStream outputStream = new BufferedOutputStream(socket.getOutputStream());
		outputStream.write(next.getBytes()); 
		outputStream.flush();//ע��ֻҪ�ô����������һ��Ҫˢ�£�����
		//��Ҫע��һ��Ҫ����������
		socket.shutdownOutput();
		
		
		byte[] streamTOByteArray = StreamUtils.StreamTOByteArray(socket.getInputStream());
		
		BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(
				new FileOutputStream("d:\\ϲ��������.mp3"));
		
		bufferedOutputStream.write(streamTOByteArray);
		
		
		bufferedOutputStream.close();
		socket.close();
		scanner.close();
		
		System.out.println("�ͻ����˳�");
		
		
		
		
	}

}