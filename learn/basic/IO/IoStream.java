package yuan.learn.basic.IO;

import java.io.FileInputStream;
import java.io.IOException;

import org.junit.Test;

//本篇讲IO流原理,以及一些流的分类

//注意：二进制文件（word，excel，图片什么的）一定要用字节流处理，纯文本文件（txt什么的）一般用字符流处理

//java.io包下提供了各种“流”类和接口，用以获取不同种类的数据，并通过方法输入/输出数据
//流的分类主要是
//		 输入流 	 	输出流
// 字符流Reader   	Writer
// 字节流InputStream	OutputStream
//JavaIO流涉及四十多个类，不过基本上都是这四个类的衍生，一般子类的名称就是 子类名父类名.class，就是拿父类名做后缀
//比如Reader的子类就有一个FileReader

//接下来我将简单讲一下字节输入流InputStream和字节输出流OutputStream和他们子类

//一.字节输入流InputStream
//常用子类
//FileInputStream文件输入流,BufferedlnputStream缓冲字节输入流，ObjectInputStream对象字节输入流
//1.文件输入流
//常用方法
//构造器FileInputStream(File file)	FileInputStream(String name)
//close()关闭流
//read()从次输入流中读取一个数据字节，read(byte[] b)最多读取b.length个字节，存放到b数组中，返回值是读取到的字节数！！！！！！
//通过这个读取返回的字节数，可以和Write(byte[],int off,int len)做方法的连接！，用来copy，细节可以看Copy_
//read(byte[] b, int off,int len)off代表我们输入在b数组索引off开始
//len代表我们输入了多少字节的数据，如果够的话，还是一次存储b.length，len也就是b.length,如果文件最后生一个，len才会变成1
//skip(long n) 输入流中跳过并丢弃n个字节的数据
//注意：我们是一个一个字节读取的，如果我们文档里面有中文会出现乱码，因为中文是三个字节一般，我们一个个读就相当于只读了一部分数据
//所以一般用字符流比较常用
//这种单个字节的读取(read()无参的方法)效率比较低
//一般用byte[] b那个参数的读取数据，注意，这样并不能解决乱码问题

//二.字节输出流OutputStream
//FileOutPutStream
//常用方法，构造器，FileOnputStream(File file)	FileOnputStream(String name)
//FileOnputStream(File file,boolean append)	FileOnputStream(String name,boolean append)
//append参数是表示你写入的是要追加还是覆盖，true就是追加，false/不写就是覆盖
//close()关闭流
//write(byte[] b)将b.length个字节从指定byte数组写入此文件输出流中
//write(byte[] b, int off,int len)将byte从off索引开始的len个字节写入此输出流
//write(int b)将指定字节写入此文件输出流


//根据这个我们可以写一个copy的小程序放到Copy_

//接下来我将根据不同作用的流来进行划分讲解，一般一个作用的流包含输入流和输出流（可能是字符或者字节）
//分到
//1.字符文件流2.节点流和处理流3.对象处理流4.标准输入输出流5.转换流6.打印流7.Properties在IO流

public class IoStream {
	@Test
    public void readFile01(){
        String filePath="d:\\a.txt";
        int read=0;
        FileInputStream fileInputStream=null;
        try {//创建FileInputStream对象，用于读取文件
            fileInputStream = new FileInputStream(filePath);
            //从该输入流读取一个字节的数据，如果没有输入可用则该方法将阻止
            //如果返回-1则代表输入完毕
            while ((read=fileInputStream.read())!=-1){
                System.out.print((char)read);//转成一个char显示
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        } finally {
            //关闭文件流，释放资源
            try {
                fileInputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
	@Test
    public void readFile02(){
        String filePath="d:\\a.txt";
        
        byte[] buff=new byte[8];//一次读取八个字节
        int readLen=0;
        FileInputStream fileInputStream=null;
        try {//创建FileInputStream对象，用于读取文件
            fileInputStream = new FileInputStream(filePath);
            //从该输入流读取至多b.length字节的数据到字节数组，此方法将阻塞，直到某些输入可用
            //如果返回-1则代表输入完毕
            //如果读取正常，返回实际读取的字节数，如果不够八个就读取小于八个的个数，如果大于8个，就八个八个读，不够的话就读取对应长度
			/*注意
			 * 对应的数据会存放到byte数组里面 并且是动态式存储 hello,world 一共11个字节 第一次读取8个字节 第二次读取3个字节
			 * 就会把前个字节由原来那八个字节的前三个 替换为 第二次读取的三个 并且后面那五个没有变 但是我们是从0到返回对于读取的字节数创建的String
			 * 所以输出肯定是正常的，读取多少输出多少
			 */
           
            while ((readLen=fileInputStream.read(buff))!=-1){
                System.out.print(new String(buff,0,readLen));//转成一个char显示
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        } finally {
            //关闭文件流，释放资源
            try {
                fileInputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

	
}
