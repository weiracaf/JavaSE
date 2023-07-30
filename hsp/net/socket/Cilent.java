package yuan.hsp.net.socket;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;

import yuan.learn.basic.Multithreading.interrupt_;
@SuppressWarnings({"all"})
//这里是客户端，发送hello,Server给服务端
public class Cilent {
public static void main(String[] args) throws UnknownHostException, IOException {
//	思路
	//连接服务器
	//连接成功以后返回Socket对象，赋值给socket
	Socket socket = new Socket(InetAddress.getLocalHost(), 9999);//因为我们链接是本机的程序
	//所以直接用本机的InetAdress对象即可，如果连接是百度什么的，可以写对应的IPV4，9999的话就是端口号
	
	//连接上以后，通过socket获得和socket对象关联的输出流（就是会输出到服务端）
	OutputStream outputStream = socket.getOutputStream();
	outputStream.write("Hello,Server".getBytes());//字节流写入
	
	//设置结束标记
	socket.shutdownOutput();
	
	
	InputStream inputStream = socket.getInputStream();
	int readlen=0;
	byte [] b =new byte[1024];
	while ((readlen=inputStream.read(b))!=-1) {
		System.out.println(new String(b,0,readlen));
		
	}
	inputStream.close();
	
	//关闭流和socket
	outputStream.close();
	socket.close();
	System.out.println("客户端退出");
}
}
