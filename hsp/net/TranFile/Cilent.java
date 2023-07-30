package yuan.hsp.net.TranFile;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;
@SuppressWarnings({"all"})
//传输文件客户端
//这里我写一个工具类StreamUtils,具体作用自己去看
public class Cilent {
	public static void main(String[] args) throws UnknownHostException, IOException {
		Socket socket = new Socket(InetAddress.getLocalHost(),8888);
		byte [] b=new byte[1024];//创建字节接收文件
		
		//创建一个把文件输入到我们客户端的流,用处理流包下文件节点流
		BufferedInputStream bufferedInputStream = new BufferedInputStream(new FileInputStream("d:\\ykj.png"));
		//运用工具类，把我们的字节输入流输入的数据转为字节数组
		byte[] streamTOByteArray = StreamUtils.StreamTOByteArray(bufferedInputStream);
		
		//创建向服务端输送数据的流,这里还是用到这个处理流反正以后就用处理流就对了
		BufferedOutputStream bos = new BufferedOutputStream(socket.getOutputStream());
		bos.write(streamTOByteArray);//写入字节数组
		
		bufferedInputStream.close();//可以把那个文件输入流关闭了
		
		socket.shutdownOutput();//注意，字节流输入要这个结束标记
		
		
		InputStream inputStream = socket.getInputStream();//还是我们能把一个输入数据转换为字节数组，就那个工具类，既然写了就多用
		System.out.println(new String(StreamUtils.StreamTOByteArray(inputStream)));
		
		
		//关闭
		bos.close();//注意，这个不要中间关闭，会报错
		socket.close();
		System.out.println("客户端退出");
		
		
		
		
	}

}
