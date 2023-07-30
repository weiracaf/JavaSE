package yuan.hsp.net.UDP;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;

import yuan.learn.basic.Multithreading.interrupt_;
@SuppressWarnings({"all"})
//UDP网络编程接收端
public class Receive {
	public static void main(String[] args) throws IOException {
		//1.创建一个datagramSocket对象，准备在9999端口接收数据
		DatagramSocket datagramSocket = new DatagramSocket(9999);
		//2.构建一个datagramPacket对象，准备接收数据
		//UDP每个数据报最大64kb
		byte buf[]=new byte[1024];
		DatagramPacket Packet = new DatagramPacket(buf, buf.length);
		//3.调用接收方法，将通过网络传输的DatagramPacket对象，填充到我们程序的变量Packet
		//会在9999端口等待，如果有数据报发送就赋给Packet，如果没有发送就一直阻塞
		System.out.println("接收端A等待发送端传送数据报");
		datagramSocket.receive(Packet);
		
		
		//4.对Packet进行拆包，取出数据显示
		int length =Packet.getLength();//实际接收的数据长度，主要是我们只发一句话，1024肯定够了
		byte[] data = Packet.getData();//接收到的数据
		System.out.println(new String(data,0,length));
		
		//再发送一条消息到send
		byte []a="好的，明天见".getBytes();
		DatagramPacket Packet02 = new DatagramPacket(a, a.length, InetAddress.getByName("LAPTOP-1MJ9VT92"),
				9998);
		datagramSocket.send(Packet02);
		
		
		//关闭资源
		datagramSocket.close();
		System.out.println("接收端退出");
		
		
	}

}
