package yuan.hsp.net.homework;
//小作业
import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.ServerSocket;
import java.net.Socket;
@SuppressWarnings({"all"})
public class server_ {
public static void main(String[] args) throws IOException {
	ServerSocket serverSocket = new ServerSocket(7777);
	System.out.println("等待客户端接入");
	Socket accept = serverSocket.accept();//这个不就是那个等待过程
	
	InputStreamReader inputStreamReader = new InputStreamReader(accept.getInputStream());
	BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
	String readLine = bufferedReader.readLine();
	String answer="";
	if("name".equals(readLine)) {
		answer="我是小袁";
	}else if("hobby".equals(readLine)){
		answer="编写java程序";
	}else {
		answer="你说啥呢？";
	}
	
	OutputStreamWriter outputStreamWriter = new OutputStreamWriter(accept.getOutputStream());
	BufferedWriter bufferedWriter = new BufferedWriter(outputStreamWriter);
	
	bufferedWriter.write(answer);
	bufferedWriter.newLine();
	bufferedWriter.flush();
	
	
	System.out.println(bufferedReader.readLine());
	
	
	bufferedWriter.write("可以接收到");
	bufferedWriter.newLine();
	bufferedWriter.flush();
	
	

	System.out.println("服务端退出");
	
	bufferedWriter.close();
	bufferedReader.close();
	accept.close();
	serverSocket.close();
	
	

	
	
	
	
}
}
