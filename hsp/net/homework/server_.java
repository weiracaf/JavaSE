package yuan.hsp.net.homework;
//С��ҵ
import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.ServerSocket;
import java.net.Socket;
@SuppressWarnings({"all"})
public class server_ {
public static void main(String[] args) throws IOException {
	ServerSocket serverSocket = new ServerSocket(7777);
	System.out.println("�ȴ��ͻ��˽���");
	Socket accept = serverSocket.accept();//����������Ǹ��ȴ�����
	
	InputStreamReader inputStreamReader = new InputStreamReader(accept.getInputStream());
	BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
	String readLine = bufferedReader.readLine();
	String answer="";
	if("name".equals(readLine)) {
		answer="����СԬ";
	}else if("hobby".equals(readLine)){
		answer="��дjava����";
	}else {
		answer="��˵ɶ�أ�";
	}
	
	OutputStreamWriter outputStreamWriter = new OutputStreamWriter(accept.getOutputStream());
	BufferedWriter bufferedWriter = new BufferedWriter(outputStreamWriter);
	
	bufferedWriter.write(answer);
	bufferedWriter.newLine();
	bufferedWriter.flush();
	
	
	System.out.println(bufferedReader.readLine());
	
	
	bufferedWriter.write("���Խ��յ�");
	bufferedWriter.newLine();
	bufferedWriter.flush();
	
	

	System.out.println("������˳�");
	
	bufferedWriter.close();
	bufferedReader.close();
	accept.close();
	serverSocket.close();
	
	

	
	
	
	
}
}
