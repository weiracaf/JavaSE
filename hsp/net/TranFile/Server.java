package yuan.hsp.net.TranFile;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.BufferedWriter;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStreamWriter;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.UnknownHostException;
@SuppressWarnings({"all"})
public class Server {
	public static void main(String[] args) throws UnknownHostException, IOException {
		//服务端叫ServerSocket，在8888端口监听
		ServerSocket serverSocket = new ServerSocket(8888);
		System.out.println("在8888端口等待链接");
		//等待链接
		Socket accept = serverSocket.accept();
		//先创建这个输入流，读取数据，处理流包
		BufferedInputStream In = new BufferedInputStream(accept.getInputStream());
		//由于我们之前已经写了输入流变成字符数组的方法直接用
		byte[] STA = StreamUtils.StreamTOByteArray(In);
		//(相对路径)创建输出流输出文件，还是处理流包
		BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream("src\\66.png"));
		bos.write(STA);//写入
		System.out.println("服务端传输文件完成");
		
		
		//然后介绍输出客户端：收到图片
		BufferedWriter b = new BufferedWriter(new OutputStreamWriter(accept.getOutputStream()));
		b.write("收到图片");
		b.flush();//这个底层才是发送数据
		accept.shutdownInput();//如果用这个作为停止标志，那么接收方是可以用字节流接收字符流传输的数据的
		
		
		//这两个流也要最后关闭，不然你写入的数据Cilent读不到，不知道为啥，感觉写网络就最后把流都关闭一下吧
		In.close();
		bos.close();
		
		b.close();
		accept.close();
		serverSocket.close();
		System.out.println("服务端退出");
		
		
	}

}
