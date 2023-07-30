package yuan.learn.basic.IO;
//本篇讲标准输入输出流
//两个老朋友
//System.in 和System.out
//先讲System.in
//System.in编译类型是InputStream运行类型是BufferedInputStream
/*System.in的标准输入是键盘
new Scanner(System.in)
System.in
当你调用对应Scanner对象的next()
方法就会从System.in（键盘）来读取数据*/
//System.out
//编译类型和运行类型都是PrintStream(是打印流中的输出流，后面会讲)
//默认输出就是显示器咯

//下一篇转换流

@SuppressWarnings({"all"})
public class 标准输入输出流 {
public static void main(String[] args) {
	System.out.println(System.in.getClass());//注意getclass输出的是运行类型
	Object aObject = new String();
	System.out.println(aObject.getClass());
}
}
