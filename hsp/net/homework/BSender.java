package yuan.hsp.net.homework;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.util.Scanner;
@SuppressWarnings({"all"})
//UDPС��ҵ
public class BSender {
	public static void main(String[] args) throws IOException {
		DatagramSocket datagramSocket = new DatagramSocket(8886);
		System.out.println("�����������");
		Scanner scanner = new Scanner(System.in);
		String next = scanner.next();
		byte[] bytes = next.getBytes();
		
		DatagramPacket Packet = new DatagramPacket(bytes, bytes.length,InetAddress.getByName("192.168.0.101"), 8885);
		datagramSocket.send(Packet);//�ǵô���ȥ
		
		datagramSocket.close();
		System.out.println("B���˳�");
		
}
}
