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
//文件下载客户端
public class downloadCilent {
	public static void main(String[] args) throws IOException {
		Socket socket = new Socket(InetAddress.getLocalHost(),6666);
		Scanner scanner = new Scanner(System.in);
		System.out.println("输入你想要下载的歌");
		String next = scanner.next();
		
		BufferedOutputStream outputStream = new BufferedOutputStream(socket.getOutputStream());
		outputStream.write(next.getBytes()); 
		outputStream.flush();//注意只要用处理流，最后一定要刷新！！！
		//还要注意一定要结束！！！
		socket.shutdownOutput();
		
		
		byte[] streamTOByteArray = StreamUtils.StreamTOByteArray(socket.getInputStream());
		
		BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(
				new FileOutputStream("d:\\喜欢的音乐.mp3"));
		
		bufferedOutputStream.write(streamTOByteArray);
		
		
		bufferedOutputStream.close();
		socket.close();
		scanner.close();
		
		System.out.println("客户端退出");
		
		
		
		
	}

}