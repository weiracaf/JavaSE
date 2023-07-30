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
//这个的话就是前面字节流变为字符流的改版，要求都一样
//核心思想就是转换流喽
//字符流方便一些
public class zifuServer {
	public static void main(String[] args) throws IOException {
		//服务端接收
		ServerSocket serverSocket = new ServerSocket(9999);
		System.out.println("服务端在9999端口监听，等待链接...");
		
		Socket accept = serverSocket.accept();
		System.out.println("服务端"+accept.getClass());
		//先字节流，然后转换流+处理流
		InputStream inputStream = accept.getInputStream();
		BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
		String readLine = bufferedReader.readLine();
		System.out.println(readLine);
	
		
		//接下来是服务端输出
		OutputStream outputStream = accept.getOutputStream();
		BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(outputStream));
		bufferedWriter.write("hello,zifuClient");
		bufferedWriter.newLine();//换行代表结束，接收用readLine,就不用accept.shutdownOutput();了
		bufferedWriter.flush();//一定要刷新或结束
		
		//关闭外层流即可，而且一般是后打开的流先关闭
		bufferedWriter.close();
		bufferedReader.close();
		accept.close();
		serverSocket.close();
		
		
		
	}

}
