package yuan.hsp.net.UDP;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.Socket;
import java.net.SocketException;
@SuppressWarnings({"all"})
//UDP�����̷��Ͷ�
public class Send {
	public static void main(String[] args) throws IOException {
		//1.�ȴ���DatagramSocket����,ָ��һ���˿ڣ�9998�������Ͷˣ���Ϊ���ǵĽ��պͷ��Ͷ���ͬһ̨����,���Զ�Ӧ�Ķ˿ںŲ���һ��
		//����˿ںŵ����ý��գ���������Ͷ˽�����Ϊ���նˣ�����9998����˿ڽ�������
		DatagramSocket datagramSocket = new DatagramSocket(9998);
		//2.����Ҫ���͵����ݷ�װ��DatagramPacket����
		byte []b="Hello,����Ի��".getBytes();
		DatagramPacket datagramPacket = new DatagramPacket(b, b.length, InetAddress.getByName("192.168.0.101"),
				9999);
		//���������������������ip��ַ��InetAddress����Ͷ˿ں�
		datagramSocket.send(datagramPacket);
		
		//3.send����receive���͹�������Ϣ
		byte a[]=new byte[1024];
		DatagramPacket datagramPacket2 = new DatagramPacket(a,a.length);
		datagramSocket.receive(datagramPacket2);
		System.out.println(new String(datagramPacket2.getData(),0,datagramPacket2.getLength()));
		
		//�ر���Դ
		datagramSocket.close();
		System.out.println("���Ͷ��˳�");
		//��Ҫע��ľ��ǣ�ȷ���������������Ƕ�Ӧ�����ݶ��󣬶����Ƿ��Ͷˣ���֮ǰ��TCP��ͬ
		//���ն�ip-�˿ںţ����ݷ�װ��һ�����󣬶�������ȷ�����ն��ٷ�������		
		
	}

}
