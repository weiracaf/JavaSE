package yuan.hsp.net.TranFile;


import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;



//工具类
public class StreamUtils {
public static byte[] StreamTOByteArray(InputStream i) throws IOException {//接收一个输入流对象，把这个对象传输的数据转换为一个字节数组
	//创建一个字节数组输出流，因为最后可以转换成一个字节数组
	ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
	
	byte b[]=new byte[1024];
	int len;
	while((len=i.read(b))!=-1) {
		byteArrayOutputStream.write(b,0,len);
	}
	byte[] array=byteArrayOutputStream.toByteArray();
	byteArrayOutputStream.close();
	
	return array;
	
}
}
