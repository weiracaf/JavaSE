package yuan.hsp.net.homework;
//TCPС��ҵ
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.lang.invoke.VarHandle;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;
@SuppressWarnings({"all"})
public class cilent_ {
public static void main(String[] args) throws UnknownHostException, IOException {
		Socket socket = new Socket(InetAddress.getLocalHost(),7777);
		OutputStreamWriter outputStreamWriter = new OutputStreamWriter(socket.getOutputStream());
		BufferedWriter bufferedWriter = new BufferedWriter(outputStreamWriter);
		
		System.out.println("�������������");
		Scanner scanner = new Scanner(System.in);
		String next = scanner.next();
		
		
		
		
		bufferedWriter.write(next);
		bufferedWriter.newLine();
		bufferedWriter.flush();
		
		InputStreamReader inputStreamReader = new InputStreamReader(socket.getInputStream());
		BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
		
		String readLine = bufferedReader.readLine();
		System.out.println(readLine);
		
		bufferedWriter.write("�ܲ��ܽ��յ��磿");
		bufferedWriter.newLine();
		bufferedWriter.flush();
		
		System.out.println(bufferedReader.readLine());
		
		
		bufferedWriter.close();
		bufferedReader.close();
		socket.close();
		
		
		
		
		
		
		
		
}
}
