package yuan.hsp.net;

import java.net.InetAddress;
import java.net.UnknownHostException;
@SuppressWarnings({"all"})
//��ƪ����InetAddress��
//һ���������̳��õ���
//�����Socket���󴴽���Ҫ���InetAdress����Ͷ˿ں�
public class InetAddress_ {
	public static void main(String[] args) throws UnknownHostException {
//		��ȡ������InetAddress����
		InetAddress localHost = InetAddress.getLocalHost();
		System.out.println(localHost);//�����������/IPV4��ַ
//		����ָ������������ȡInetAddress����
		InetAddress byName = InetAddress.getByName("LAPTOP-1MJ9VT92");//getByname���Դ�ip��ַ�����������ǲ鲻����������
		System.out.println(byName);
//		������������InetAddress����
		InetAddress host2 = InetAddress.getByName("www.baidu.com");
		//����
		System.out.println(host2);//���ص��� ����/�ٶȶ�Ӧ��ip
//		ͨ��InetAdress���󣬻�ȡ��Ӧ�ĵ�ַ
		String hostAddress = host2.getHostAddress();
		System.out.println(hostAddress);
//		ͨ��InetAdress���󣬻�ȡ��Ӧ����������û���������ͻ�ȡ������
		String hostName = host2.getHostName();
		System.out.println(hostName);
		
	}

}
