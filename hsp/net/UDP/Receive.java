package yuan.hsp.net.UDP;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;

import yuan.learn.basic.Multithreading.interrupt_;
@SuppressWarnings({"all"})
//UDP�����̽��ն�
public class Receive {
	public static void main(String[] args) throws IOException {
		//1.����һ��datagramSocket����׼����9999�˿ڽ�������
		DatagramSocket datagramSocket = new DatagramSocket(9999);
		//2.����һ��datagramPacket����׼����������
		//UDPÿ�����ݱ����64kb
		byte buf[]=new byte[1024];
		DatagramPacket Packet = new DatagramPacket(buf, buf.length);
		//3.���ý��շ�������ͨ�����紫���DatagramPacket������䵽���ǳ���ı���Packet
		//����9999�˿ڵȴ�����������ݱ����;͸���Packet�����û�з��;�һֱ����
		System.out.println("���ն�A�ȴ����Ͷ˴������ݱ�");
		datagramSocket.receive(Packet);
		
		
		//4.��Packet���в����ȡ��������ʾ
		int length =Packet.getLength();//ʵ�ʽ��յ����ݳ��ȣ���Ҫ������ֻ��һ�仰��1024�϶�����
		byte[] data = Packet.getData();//���յ�������
		System.out.println(new String(data,0,length));
		
		//�ٷ���һ����Ϣ��send
		byte []a="�õģ������".getBytes();
		DatagramPacket Packet02 = new DatagramPacket(a, a.length, InetAddress.getByName("LAPTOP-1MJ9VT92"),
				9998);
		datagramSocket.send(Packet02);
		
		
		//�ر���Դ
		datagramSocket.close();
		System.out.println("���ն��˳�");
		
		
	}

}
