package yuan.learn.basic.IO;
//��d�̵�ccͼƬ������d���²��һ�����
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class Copy_ {
	 public static void main(String[] args) {
		    //����ļ�������d����
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
		            //��ȡ�����д���ļ������߶���д
		                b.write(c,0,readLen);
		            }
		            System.out.println("�������");

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
