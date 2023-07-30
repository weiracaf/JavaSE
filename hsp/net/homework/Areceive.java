package yuan.hsp.net.homework;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;

//UDP小作业
@SuppressWarnings({"all"})
public class Areceive {
public static void main(String[] args) throws IOException {
	DatagramSocket datagramSocket = new DatagramSocket(8885);
	byte b[]=new byte[1024];
	DatagramPacket datagramPacket = new DatagramPacket(b,b.length);
	System.out.println("开始等待");
	datagramSocket.receive(datagramPacket);
	
	String string = new String(datagramPacket.getData(), 0, datagramPacket.getLength());
	
	if(string.equals("四大名著是哪些")) {
		System.out.println("四大名著是红楼梦-西游记-水浒传-三国演义");
	}
	else {
		System.out.println("what");
	}
	System.out.println("A端退出");
	
}
}
