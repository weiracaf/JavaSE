package yuan.hsp.net.homework;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;

//UDPС��ҵ
@SuppressWarnings({"all"})
public class Areceive {
public static void main(String[] args) throws IOException {
	DatagramSocket datagramSocket = new DatagramSocket(8885);
	byte b[]=new byte[1024];
	DatagramPacket datagramPacket = new DatagramPacket(b,b.length);
	System.out.println("��ʼ�ȴ�");
	datagramSocket.receive(datagramPacket);
	
	String string = new String(datagramPacket.getData(), 0, datagramPacket.getLength());
	
	if(string.equals("�Ĵ���������Щ")) {
		System.out.println("�Ĵ������Ǻ�¥��-���μ�-ˮ䰴�-��������");
	}
	else {
		System.out.println("what");
	}
	System.out.println("A���˳�");
	
}
}
