package yuan.hsp.net.socket;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

import yuan.learn.basic.Multithreading.interrupt_;
@SuppressWarnings({"all"})
//我们网络数据的服务端-本包是TCP字节流编程内容
public class Server {
	public static void main(String[] args) throws IOException {
		//具体的编程任务可以去看博客-网络编程-TCP字节流编程
		//在本机的9999端口监听，要求本机没有其他服务占用9999端口
		ServerSocket serverSocket = new ServerSocket(9999);
		System.out.println("服务端在9999端口监听，等待链接...");
		//当没有客户端连接9999端口，程序阻塞等待链接
		//如果有客户端链接，会返回一个Socket对象，下面可以直接去看客户端的代码，向服务端请求，然后下面的代码才会运行
		Socket accept = serverSocket.accept();
		System.out.println("服务端"+accept.getClass());//这句话其实你只运行这个程序，他不会输出，就是因为没客户端连接
		//然后我们通过客户端连接本机9999端口，成功的输出了上面那一句话
		
		//现在是接收输入流输入的数据然后输出，可能是通过输入流来读取数据
		InputStream inputStream = accept.getInputStream();
		//IO读取
		byte [] buf = new byte[1024];
		int readLen = 0;
		while((readLen=inputStream.read(buf))!=-1) {
			System.out.println(new String(buf,0,readLen));//String还有这种构造器长见识了，根据读取到内容显示
		}
		
		
		OutputStream outputStream = accept.getOutputStream();
		outputStream.write("Hello,client".getBytes());
		
		accept.shutdownOutput();
		
		
		outputStream.close();
		
		inputStream.close();
		accept.close();
		serverSocket.close();//比用户端退出多一个步骤
		//关于serverSocket和accept（socket对象）区别
		//就是第一个可以产生很多个Socket建立，比如说你这个服务端要和多个用户端连接，你不可以只用一个Socket对象
		//可以通过serverSocket创建Socket和指定用户连接，就是serverSocket相当于经理，可以派具体的员工
		//就建立通讯业务，自己计算负责派人的，而且没有客户的话，员工和这个经理一起关闭，没人要你干什么？
		
		
	}

}
