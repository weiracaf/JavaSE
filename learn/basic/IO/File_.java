package yuan.learn.basic.IO;

import java.io.File;
import java.io.IOException;

import org.junit.jupiter.api.Test;

//��ƪ��Ҫ���ļ�
//�ļ��������Ǳ������ݵĵط���
//��ҳ��õ�word��txt��excel�ļ�
//��java����У�Ŀ¼���ļ��л�Ӳ�̣�Ҳ������Ϊһ��������ļ�
//����new File("d:\")����Ҳ�ǿ��е�
//�ļ��ڳ����������ķ�ʽ���в�������������������Դ�ͳ���֮�侭����·��
//���ַ�Ϊ-�������������-��������Ȼ�Ǵ�����Դ��������������ǳ�������Դ��
//�����ļ�����
//1.new File(String pathname)	����·������File�ļ�
//2.new File(File parent,String child)	���ݸ�Ŀ¼�ļ�+��·�������ļ�
//3.new File(String parent,String child)	���ݸ�Ŀ¼+��·�������ļ�
//createNewFile�������ļ�
//�����д���
//��ȡ�ļ���Ϣ����
/* //�ȴ����ļ�����
   File file = new File("d:\\news1.txt");
   //���ö�Ӧ�����õ���Ϣ
   System.out.println("�ļ�����="+file.getName());
   System.out.println("�ļ�����·��="+file.getAbsolutePath());
   System.out.println("�ļ�����Ŀ¼="+file.getParent());
   System.out.println("�ļ���С(�ֽ�)="+file.length());
   System.out.println("�ļ��Ƿ����="+file.exists());//���ڷ���true�������ڷ���false
   System.out.println("�ǲ���һ���ļ�="+file.isFile());//�Ƿ���true�����Ƿ���false
   System.out.println("�ǲ���һ��Ŀ¼="+file.isDirectory());//�Ƿ���true�����Ƿ���false
*/
//����Ŀ¼�Ĳ���
//mkdir()����һ��Ŀ¼��mkdirs()�����༶Ŀ¼��delete()ɾ����Ŀ¼���ļ�

public class File_ {
	//mkdir
	@Test
	 public void m3(){
	        File file = new File("d:\\demo");
	        if(file.exists()){
	            System.out.println("Ŀ¼����");

	        }else {
	            if (file.mkdirs()) {
	                System.out.println("�����ɹ�...");
	            } else {
	                System.out.println("����ʧ��...");
	            }
	        }
	 }
	//mkdirs
	@Test
	 public void m2(){
	        File file = new File("d:\\demo\\a\\b\\c");
	        if(file.exists()){
	            System.out.println("Ŀ¼����");

	        }else {
	            if (file.mkdirs()) {
	                System.out.println("�����ɹ�...");
	            } else {
	                System.out.println("����ʧ��...");
	            }
	        }
	    }

	
	//delete
	@Test	//�ǵü������
	 public void m1(){
	        File file = new File("d:\\news1.txt");
	        if(file.exists()){
	            if (file.delete()) {
	                System.out.println("ɾ���ɹ�");
	            } else {
	                System.out.println("ɾ��ʧ��");
	            }
	        }else System.out.println("���ļ�������");
	    }

	//��ʽ1new File(String Pathname)
	 @Test
	    public void create01(){
	        String filePath="d:\\news1.txt";
	        File file = new File(filePath);
	        try {
	            file.createNewFile();
	            System.out.println("�ļ������ɹ�");
	        }
	        catch (IOException e){
	            System.out.println(e);
	        }

	    }
	    //��ʽ2new File(File parent,String child)//���ݸ�Ŀ¼�ļ�+��·������
	    //e:\\news2.txt
	    public void create02(){
	        File file = new File("d:\\");
	        String filename="news2.txt";
	        File file1 = new File(file, filename);//�ڴ洴��
	        try {
	            file1.createNewFile();//�����Ӳ��
	            System.out.println("�����ɹ�");
	        } catch (IOException e) {
	            e.printStackTrace();
	        }

	    }
	    //��ʽ3new File(String parent,String child) ���ݸ�Ŀ¼+��·��������2�Ĳ�����ͬ
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
