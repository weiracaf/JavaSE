package yuan.learn.basic.IO;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

//本篇讲IO中的Properties类
//说过一般XXX.properties是配置文件
//怎么读取配置文件数据，就用这个类
//配置文件的格式
//键=值
//注意键值对没有空格，值不需要引号引起来
//Properties常用方法
//load(),加载配置文件键值对到Properties对象，返回的就是一个Properties对象
//list()，将指定数据显示到指定设备
//getProperty(key)根据键获取value
//setProperty(key,value)设置键值对到properties对象
//store()将properties对象的键值对存储到配置文件（属于是追加然后key相同会进行替换），有中文进行unicode编码

//注意写入和读取的时候对象不同写入就是输出流，读取就是输入流

//修改对应的k-v对
//
//如果setProperty(key,value)
//如果key是不存在的它就是创建，如果存在它就是修改
//
//修改pwd为888888
public class Properties类 {
	public static void main(String[] args) throws FileNotFoundException, IOException {
		//先建对象
		Properties properties = new Properties();
		//存几个键值对
		properties.setProperty("user", "小袁");
		properties.setProperty("ip", "666");
		properties.setProperty("pwb", "abc111");
		//把这些键值对存储到文件中
		properties.store(new FileOutputStream("d:\\学习\\666.properties"), null);//自己去看啊
		System.out.println("配置文件成功");
		
		Properties properties2 = new Properties();
		properties2.load(new FileReader("d:\\学习\\666.properties"));
		properties2.list(System.out);
		
		Properties properties3 = new Properties();
		properties3.setProperty("pwb", "888888");
		properties3.store(new FileOutputStream("d:\\学习\\666.properties"), null);
		
		properties2.load(new FileReader("d:\\学习\\666.properties"));//修改完要先读取更新数据，不然还是上次的结果
		properties2.list(System.out);
		
		
	}

}
