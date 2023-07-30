package yuan.hsp.net.UDP;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.Socket;
import java.net.SocketException;
@SuppressWarnings({"all"})
//UDP网络编程发送端
public class Send {
	public static void main(String[] args) throws IOException {
		//1.先创建DatagramSocket对象,指定一个端口（9998）给发送端，因为我们的接收和发送端在同一台主机,所以对应的端口号不能一样
		//这个端口号的作用接收，当这个发送端将来成为接收端，会在9998这个端口接收数据
		DatagramSocket datagramSocket = new DatagramSocket(9998);
		//2.将需要发送的数据封装到DatagramPacket对象
		byte []b="Hello,明天吃火锅".getBytes();
		DatagramPacket datagramPacket = new DatagramPacket(b, b.length, InetAddress.getByName("192.168.0.101"),
				9999);
		//后面的连个参数是主机（ip地址）InetAddress对象和端口号
		datagramSocket.send(datagramPacket);
		
		//3.send接收receive发送过来的消息
		byte a[]=new byte[1024];
		DatagramPacket datagramPacket2 = new DatagramPacket(a,a.length);
		datagramSocket.receive(datagramPacket2);
		System.out.println(new String(datagramPacket2.getData(),0,datagramPacket2.getLength()));
		
		//关闭资源
		datagramSocket.close();
		System.out.println("发送端退出");
		//需要注意的就是，确定我们输出方向的是对应的数据对象，而不是发送端，和之前的TCP不同
		//接收端ip-端口号，数据封装到一个对象，而不是先确定接收端再发送数据		
		
	}

}
