package yuan.hsp.net;

import java.net.InetAddress;
import java.net.UnknownHostException;
@SuppressWarnings({"all"})
//本篇主讲InetAddress类
//一个在网络编程常用的类
//后面的Socket对象创建需要这个InetAdress对象和端口号
public class InetAddress_ {
	public static void main(String[] args) throws UnknownHostException {
//		获取本机的InetAddress对象
		InetAddress localHost = InetAddress.getLocalHost();
		System.out.println(localHost);//会输出主机名/IPV4地址
//		根据指定的主机名获取InetAddress对象
		InetAddress byName = InetAddress.getByName("LAPTOP-1MJ9VT92");//getByname可以传ip地址，不过那样是查不到主机名的
		System.out.println(byName);
//		根据域名返回InetAddress对象
		InetAddress host2 = InetAddress.getByName("www.baidu.com");
		//域名
		System.out.println(host2);//返回的是 域名/百度对应的ip
//		通过InetAdress对象，获取对应的地址
		String hostAddress = host2.getHostAddress();
		System.out.println(hostAddress);
//		通过InetAdress对象，获取对应的主机名、没有主机名就获取到域名
		String hostName = host2.getHostName();
		System.out.println(hostName);
		
	}

}
