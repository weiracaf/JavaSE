package yuan.learn.basic.IO;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import org.junit.Test;

//字符流必须手动刷新/关闭才会写入通道！！！！！！！！！！！！！！！！

//本篇讲课文件字符流
//主要是两个类FileReader和FileWriter
//FileReader
//1.new FileReader(File/String)
//2.read:每次读取单个字符，返回该字符串(返回的是对应字符的int形可能根据unicode编码，需要转为字符类型)，如果到文件末位返回-1
//下面有示例，和前面的FileInputStream相同，我们一般用下面这种，效率高
//3.read(char[]):批量读取多个字符到数组，返回读取到的字符数，到文件末尾返回-1
//和前面那个底层原理一样，从头覆盖，返回长度，动态存储

//可以看到，我们运行的汉字还是有乱码
//我把文本改为ANSl（GBK）就没事了
//编码格式决定了 txt文本中的内容 转 IO 流的 编码格式。 这个格式必须跟你 .java 文件设置的编码格式一样，否则就会产生乱码
//默认就是GBK编码，可以在window-preferences-General-workspace里面最下面有编码格式-一个工作区的java文件的编码格式是相同的

//FileWriter
//常用方法
//new FileWriter(File/String) 覆盖式写入	new FileWriter(File/String,true) 追加式写入
//write(int)写入单个字符	write(char[])写入指定数组	write(char[],off,len)写入从数组索引off开始len个字符
//write(string)	 写入整个字符串	write(string,off,len)写入字符串从索引off开始len个字符
//注意：FileWriter后，必须要关闭（close）或刷新（flush）否则写入不到指定的文件
//因为他们两个方法内部有一个方法（implFlush）-是真正的把数据写入文件的
//下面有一个s函数是运用的实例
//当然write还有多种形参
/*巧妙运用
可以传char数组
或者单个字符
还可以(String a,int off,int len)
选取字符串的一部分

数据量大的情况下，使用循环操作*/
public class 文件字符流 {
	 public static void main(String[] args) {

	        String filePath="d:\\a.txt";
	        int b=' ';
	        FileReader a=null;
	        try {
	            a=new FileReader(filePath);
	            while ((b=a.read())!=-1){//循环读取，使用read，单个字符读取
	                System.out.print((char)b);
	            }
	        } catch (IOException e) {
	            e.printStackTrace();
	        }
	        finally {
	            try {
	                a.close();
	            } catch (IOException e) {
	                e.printStackTrace();
	            }
	        }
	    }
	 @Test
	    public void Reader01(){
	        String filePath="d:\\a.txt";
	        char []q=new char[10];
	        int readlen=0;
	        FileReader a=null;
	        try {
	            a=new FileReader(filePath);
	            while ((readlen=a.read(q))!=-1){//循环读取，使用read，返回实际读取到的字符数
	                System.out.print(new String(q,0,readlen));
	            }
	        } catch (IOException e) {
	            e.printStackTrace();
	        }
	        finally {
	            try {
	                a.close();
	            } catch (IOException e) {
	                e.printStackTrace();
	            }
	        }
	    }
	 @Test
	    public void s(){
	        FileWriter d=null;
	        try {
	            d=new FileWriter("d:\\note.txt");
	            d.write("风雨之后，定见彩虹");
	        } catch (IOException e) {
	            e.printStackTrace();
	        } finally {
	            try {
	                d.close();
	            } catch (IOException e) {
	                e.printStackTrace();
	            }
	        }
	    }


}
