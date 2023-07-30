package yuan.learn.basic.IO;
//把d盘的cc图片拷贝到d盘下并且换个名
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class Copy_ {
	 public static void main(String[] args) {
		    //完成文件拷贝从d到从
		        FileInputStream a=null;
		        FileOutputStream b=null;

		        File file01 = new File("d:\\cc.jpg");
		        File file02 = new File("d:\\cc01.jpg");
		        try {
		             a = new FileInputStream(file01);
		             b = new FileOutputStream(file02);
		            byte [] c=new byte[1024];
		            int readLen=0;
		            while ((readLen=a.read(c))!=-1){
		            //读取到后就写入文件，及边读边写
		                b.write(c,0,readLen);
		            }
		            System.out.println("拷贝完成");

		        } catch (IOException e) {
		           e.printStackTrace();
		        }
		        finally {
		            try {
		                a.close();
		                b.close();
		            } catch (IOException e) {
		                e.printStackTrace();
		            }
		        }


		    }

}
