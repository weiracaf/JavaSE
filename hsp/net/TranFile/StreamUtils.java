package yuan.hsp.net.TranFile;


import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;



//������
public class StreamUtils {
public static byte[] StreamTOByteArray(InputStream i) throws IOException {//����һ�����������󣬰���������������ת��Ϊһ���ֽ�����
	//����һ���ֽ��������������Ϊ������ת����һ���ֽ�����
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
