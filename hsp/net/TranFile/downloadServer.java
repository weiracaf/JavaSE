package yuan.hsp.net.TranFile;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.channels.NonWritableChannelException;
import java.util.Scanner;

import yuan.learn.basic.Multithreading.interrupt_;
@SuppressWarnings({"all"})
//文件下载服务端
public class downloadServer {
public static void main(String[] args) throws IOException {
	ServerSocket serverSocket = new ServerSocket(6666);
	System.out.println("服务端在6666端口等待");
	Socket accept = serverSocket.accept();
	
	BufferedInputStream InputStream = new BufferedInputStream(accept.getInputStream());
	byte[] array = StreamUtils.StreamTOByteArray(InputStream);
	String Array = new String(array, 0, array.length);
	
	
	
	System.out.println("需要查找的文件是"+Array);
	//传输文件肯定是字节流
	BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(accept.getOutputStream());
	
	String name = "";
	if(Array.equals("Ferrari")) {
	name="d:\\CloudMusic\\Bebe Rexha - Ferrari.mp3";
	}
	else {
		name="d:\\CloudMusic\\周星星 - 足够.mp3";
	}
	BufferedInputStream bufferedInputStream = new BufferedInputStream(
			new FileInputStream(name));
	
	byte[] Array02 = StreamUtils.StreamTOByteArray(bufferedInputStream);
	
	bufferedOutputStream.write(Array02);
	accept.shutdownOutput();
	
	//关闭,后开的资源先关闭
	bufferedInputStream.close();
	bufferedOutputStream.close();
	accept.close();
	serverSocket.close();
	System.out.println("服务端退出");
	
	
	
}
}