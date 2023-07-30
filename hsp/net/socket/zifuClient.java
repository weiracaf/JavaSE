package yuan.hsp.net.socket;

//用字符流就尽量用readLine
//用read的话一个一个字节读的肯定不能输出中文
//也尽量用newLine作为结束

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
		
		
		BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(outputStream));//处理流,里面是转换流
		bufferedWriter.write("Hello,zifuServer");
		bufferedWriter.newLine();//插入一个换行符，表示原先写入内容结束，就不需要那个字节流的结束标记了，不过接收端要用readLine
		bufferedWriter.flush();//字符流需要刷新，才会写入通道
		
		
		
		
		InputStream inputStream = socket.getInputStream();
		BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
		System.out.println(bufferedReader.readLine());
		
		
		
		
		//关闭流和socket
		bufferedReader.close();
		bufferedWriter.close();//关闭这个处理流里面的流也关闭了
		socket.close();
		System.out.println("客户端退出");
	}
}
