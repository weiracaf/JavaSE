package yuan.learn.basic.IO;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import org.junit.Test;

//本篇是节点流和处理流的讲解

//字符流用于纯文本文件（也称ASCLL文件）
//字节流用于二进制文件

//节点流可以从一个特定的数据源读写数据，如FileWriter,FileReader
//处理流（也称包装流）是“连接”在已存在的流（节点流或处理流）之上，为程序提供更为强大的读写功能，如BufferedReader,BufferedWriter
//两者的区别
//节点流是底层流直接和数据源相连
//处理流包装节点流，既可以消除不同节点流之间的实现差异，也可以提供更方便的方法完成输入输出
//处理流好处1.性能提高：用增加缓冲方式来提高输入输出的效率2.操作的便捷：处理流提供一系列便捷的方法来一次输入输出大批量数据，操作更加灵活方便

/*节点流，直接操作数据源，只能对对应的数据源进行操作，有一定的限制，灵活性不够，这样的流效率可能不是很高，功能可能不是很强大
处理流，对节点流进行一个包装，比节点流功能更强大
注意一般处理流里面不会再包一个处理流，而是一个节点流，前面那样做没有意义
最后都是要回到节点流的*/

//只说肯定不行，举个例子吧
//处理流，像BufferedReader类里有一个属性 Reader,可以存储节点流，只要是Reader子类，BufferedWriter同理不过是Writer
//这个Reader或者Writer属性可以包含别的比如FileReader，CharArrayReader，CharArrayWriter什么的对对应的数据类型或者文件进行操作。
//可以直接把其他的节点流丢进去，这种模式叫修饰器模式

//接下来主要是处理流的讲解
//BufferdReader和BufferedWriter、、主要是有readLine方便
//都是字符流(因为都是Reader的子类喽)
//并且关闭的时候只关闭外层流即可，底层会自动关闭包装的节点流
//1.BufferdReader
//下面有例子自己看
//正常read是一个字符一个字符读取的
/*readLine会一行一行读取然后返回
用line接收效率比较高*/
//2.BufferedWriter
//任务
//使用BufferWriter将
//“我身无拘，武道无穷”
//传入d盘的a.txt文件中（覆盖式）
//jie()函数实现

//与此相似，字节流也是有对应的处理流的
//分别是BufferInputStream和BufferOutputStream，用于操作二进制文件
//这两个类原来和字符处理流一样，不说了，列举一下常用方法
//3.BufferInputStream
//构造方法BufferedInputStream(InputStream in) 还有BufferedInputStream(InputStream in,int size)
//第二种方法可以指定缓冲区大小，不清楚，不过用第一种最好吧我感觉
//方法：1.read()2.read(byte []b,int off,int len),3.skip()4.close()5.read(byte[]b)注意5返回值是读取到的字节数
//都是InputStream的方法
//底层其实就是调用我们节点流的方法
//4.BufferedOutputStream
//类似BufferedWriter
//实现输出流缓冲，将字节写入底层输出流，而不是写入一次调用底层系统一次
//常用方法：构造器BufferedOutputStream(OutputStream out),BufferedOutputStream(OutputStream out,int size)
//那个第二个也是指定缓冲区大小，和上面的建议一样
//write(int b)  write(byte []b,int off,int len)  flush()  write(byte[] b) 
//自己看OutputStream介绍过的方法

//下面是对象处理流

@SuppressWarnings({"all"})
public class 节点流和处理流 {
	public static void main(String[] args) throws IOException {
		String filepath="d:\\学习\\6.txt";	//注意奥d盘的硬盘名是d:，正常文件夹直接写文件夹名字不用加:
		BufferedReader bufferedReader = new BufferedReader(new FileReader(filepath));
		String line;
		while((line = bufferedReader.readLine())!=null) {
			System.out.println(line);
		}
		bufferedReader.close();//包装的节点流会随着处理流的关闭而关闭
	}
	 @Test
	    public void jie(){
	        BufferedWriter bufferedWriter=null;
	        try {
	             bufferedWriter = new BufferedWriter(new FileWriter("d:\\a.txt"));
	            bufferedWriter.write("我身无拘，武道无穷");
	            System.out.println("修改完成");
	        } catch (IOException e) {
	           e.printStackTrace();
	        } finally {
	            try {
	                bufferedWriter.close();
	            } catch (IOException e) {
	                e.printStackTrace();
	            }
	        }
	    }

	

}
