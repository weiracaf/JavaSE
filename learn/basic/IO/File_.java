package yuan.learn.basic.IO;

import java.io.File;
import java.io.IOException;

import org.junit.jupiter.api.Test;

//本篇主要讲文件
//文件就是我们保存数据的地方呗
//大家常用的word，txt，excel文件
//在java编程中，目录（文件夹或硬盘）也可以作为一种特殊的文件
//比如new File("d:\")这样也是可行的
//文件在程序中以流的方式进行操作，流：数据在数据源和程序之间经历的路径
//流又分为-输入流和输出流-输入流自然是从数据源到程序，输出流就是程序到数据源呗
//常用文件操作
//1.new File(String pathname)	根据路径构造File文件
//2.new File(File parent,String child)	根据父目录文件+子路径构建文件
//3.new File(String parent,String child)	根据父目录+子路径构建文件
//createNewFile创建新文件
//下面有代码
//获取文件信息操作
/* //先创建文件对象
   File file = new File("d:\\news1.txt");
   //调用对应方法得到信息
   System.out.println("文件名字="+file.getName());
   System.out.println("文件绝对路径="+file.getAbsolutePath());
   System.out.println("文件父级目录="+file.getParent());
   System.out.println("文件大小(字节)="+file.length());
   System.out.println("文件是否存在="+file.exists());//存在返回true，不存在返回false
   System.out.println("是不是一个文件="+file.isFile());//是返回true，不是返回false
   System.out.println("是不是一个目录="+file.isDirectory());//是返回true，不是返回false
*/
//关于目录的操作
//mkdir()创建一级目录，mkdirs()创建多级目录，delete()删除空目录或文件

public class File_ {
	//mkdir
	@Test
	 public void m3(){
	        File file = new File("d:\\demo");
	        if(file.exists()){
	            System.out.println("目录存在");

	        }else {
	            if (file.mkdirs()) {
	                System.out.println("创建成功...");
	            } else {
	                System.out.println("创建失败...");
	            }
	        }
	 }
	//mkdirs
	@Test
	 public void m2(){
	        File file = new File("d:\\demo\\a\\b\\c");
	        if(file.exists()){
	            System.out.println("目录存在");

	        }else {
	            if (file.mkdirs()) {
	                System.out.println("创建成功...");
	            } else {
	                System.out.println("创建失败...");
	            }
	        }
	    }

	
	//delete
	@Test	//记得加这个奥
	 public void m1(){
	        File file = new File("d:\\news1.txt");
	        if(file.exists()){
	            if (file.delete()) {
	                System.out.println("删除成功");
	            } else {
	                System.out.println("删除失败");
	            }
	        }else System.out.println("该文件不存在");
	    }

	//方式1new File(String Pathname)
	 @Test
	    public void create01(){
	        String filePath="d:\\news1.txt";
	        File file = new File(filePath);
	        try {
	            file.createNewFile();
	            System.out.println("文件创建成功");
	        }
	        catch (IOException e){
	            System.out.println(e);
	        }

	    }
	    //方式2new File(File parent,String child)//根据父目录文件+子路径构建
	    //e:\\news2.txt
	    public void create02(){
	        File file = new File("d:\\");
	        String filename="news2.txt";
	        File file1 = new File(file, filename);//内存创建
	        try {
	            file1.createNewFile();//输出到硬盘
	            System.out.println("创建成功");
	        } catch (IOException e) {
	            e.printStackTrace();
	        }

	    }
	    //方式3new File(String parent,String child) 根据父目录+子路径创建和2的参数不同
	    public void create03(){
	    String parentPath="e:\\";
	    String fileName="news3.txt";
	        File file = new File(parentPath, fileName);
	        try {
	            file.createNewFile();
	        } catch (IOException e) {
	            throw new RuntimeException(e);
	        }
	    }

}
