package yuan.learn.basic.IO;

import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.io.PrintWriter;

import org.junit.Test;

//本篇讲打印流
//主要是两个类，PrintStream和PrintWriter-都是输出流奥一个字节流一个字符流
//PrintStream父类是FileOutputStream（FileOutputStream父类是OutputStream）
//下面代码是PrintStream的主要用途
//还有一种用途
//修改sout的默认位置，默认是到显示器上的，可以通过setOut来重新
//更改输出位置，可以到文件中，然后直接输出就行
//没有的话会新建文件进行输出
//下面也进行演示了

//PrintWriter父类是Writer
//可以输出到显示器上（System.out代表显示器）,也可以输入到文件里需要close才能输出成功
//可以更改路径到文件中
//需要close才可以成功输进去


public class 打印流 {
public static void main(String[] args) throws FileNotFoundException {
	PrintStream out =System.out;//可以输出输出到显示器上（System.out）就是一个PrintStream，代表显示器
	out.print(6);
	out.close();
	System.setOut(new PrintStream("D:\\a.txt"));
	System.out.println("666");
}
@Test
	public void m() {
	PrintWriter printWriter = new PrintWriter(System.out);
	printWriter.write("北京你好");
	printWriter.close();
}
}
