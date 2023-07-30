package yuan.hsp.net.homework;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.util.Scanner;
@SuppressWarnings({"all"})
//UDP小作业
public class BSender {
	public static void main(String[] args) throws IOException {
		DatagramSocket datagramSocket = new DatagramSocket(8886);
		System.out.println("输入你的问题");
		Scanner scanner = new Scanner(System.in);
		String next = scanner.next();
		byte[] bytes = next.getBytes();
		
		DatagramPacket Packet = new DatagramPacket(bytes, bytes.length,InetAddress.getByName("192.168.0.101"), 8885);
		datagramSocket.send(Packet);//记得传过去
		
		datagramSocket.close();
		System.out.println("B端退出");
		
}
}
