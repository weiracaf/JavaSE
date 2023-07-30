package yuan.learn.basic.IO;
//本篇转换流
//两个主要类1.InputStreamReader2.OutputStreamWriter

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
@SuppressWarnings({"all"})
//针对纯文本文件的编码格式不同产生的一种流
//注意：转换流本身就是一种字符流，接受字节流！，转换成InputStreamReader这样的字符流
//比如我们这个工作区是GBK编码，那么用字符串读取UTF-8就会出现乱码

//我们可以通过指定我们操作文件的编码格式来进行精确读取

//但是只有字节流！！！才能指定读取（本步骤要通过转换流指定读取编码格式），所以要先指定字节流的读取编码格式
//字符流准确读取就前面那个进过的（保持java文件编码格式和操作的文本文件编码一致）
//然后用转换流将它转换为字符流（InputStreamReader这样的），读取纯文本文件

//先来InputStreamReader
//构造器InputStreamReader(InputStream,Charset)  第二个参数就是编码格式喽
//相当于不但把一个字节流转换为字符流，还能指定用读取什么编码格式
//你不指定就默认java工作区编码格式
//下面有演示代码


//然后OutputStreamWriter
//就是按照指定编码格式写入文件呗
//和上面一样的，什么指定编码，构造方法
//只能接收字节流都一样，不进了
//下一篇-打印流


//转换流一定要和处理流一起用奥！！！

public class 转换流 {
	public static void main(String[] args) throws IOException, FileNotFoundException {
		String aString="d:\\a.txt";
		//字节流转字符流，指定编码格式
		InputStreamReader inputStreamReader = new InputStreamReader(new FileInputStream(aString), "gbk");
		
		BufferedReader bufferedReader = new BufferedReader(inputStreamReader);//处理流呗
		String string = bufferedReader.readLine();
		System.out.println(string);
		bufferedReader.close();
		
	}
}
