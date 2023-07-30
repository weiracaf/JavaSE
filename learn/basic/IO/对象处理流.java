package yuan.learn.basic.IO;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

//��ƪ����������
//��Ҫ��ObjectOutputStream��ObjectInputStream
//���ǿ�Ӧ���������Ǳ��� int num = 100 ������ݣ�ע�����Ǳ���Ĳ���100���֣�����int 100�����ҿ��Դ��ļ���ֱ�ӻָ�int 100
//�����Ǵ���һ��Dog�������ܹ��ָ�
//Ҳ���ǳ���ֵ����������Ҳ�Ǳ�Ҫ��
//��ʱ��Ҫ���л��ͷ����л�
//���л������ڱ������ݵ�ʱ�򱣴����ݵ�ֵ����������,�����л������෴
//�������л��ͷ����л�����������,��Ҫʵ��Serializable�ӿڣ���Exterbalizable�ӿ�
//�Ƽ����ʵ��Serializable��Ϊ����û���κη�����һ����ǽӿ�
//��ObjectOutputStream��ObjectInputStream�ֱ��ṩ�����л��ͷ����л��Ĺ���
//Ҳ�ǽ��ܶ�Ӧ��OutputStream
//�Ͷ�Ӧ��InputStream 
//��������ʾ����
//���Է��֣���Ӧ��data.txt����ʵ�����룬��Ϊ���ʵĻ��Ͳ��Ǵ��ı��ļ���������Ȼ���Կ�����������+�������ʹ洢��
//������ҪObjectInputStream���з����л����ܿ����洢�Ķ���
//�������fan������������main�������л����ݵĽ����˷����л�
//��Ӧ��˳�����л��Լ��ٶ��ϲ飬��ʵ����Ҳ�����
//��objectInputStream.readUTF()objectInputStream.readChar()objectInputStream.readObject()ʲô��

//һЩϸ�ڲ���
//1.��д˳��һ��
//2.���л��ͷ����л�����Ҫ��ʵ��Serializable�ӿ�
//3.���л����󣬲��Ὣstatic��transient���εĳ�Ա���л���static��transient���Ի��Զ���null
//4.���л�������������ԣ��̳����;Ͱ�װ�࣬������װ�඼ʵ���˲��õ��ģ�ҲҪʵ��Serializable�ӿ�
//5.���л��ɼ̳У��������ĳ��ʵ�������л�����������Ĭ��Ҳʵ�������л�

//�������Ǳ�׼���롢�����
public class �������� {
	public static void main(String[] args) {
        String filePath="d:\\data.txt";//�����׺������ģ����л��󱣴���ļ���ʽ����txt���ǰ������ĸ�ʽ�������
        //������ʵ�����һ����׺��������

        try {
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream(filePath));
            //���л����ݵ�d:\data.txt
            //û�еĻ����ȴ���
            objectOutputStream.writeInt(100); //int�Զ�װ��ΪIntegerʵ����Serializable�ӿ�
            objectOutputStream.writeBoolean(true);//ͬ
            objectOutputStream.writeChar('c');//ͬ
            objectOutputStream.writeUTF("ccle");//ͬ
            //���������Խ�����Dog�������ȥ
            objectOutputStream.writeObject(new Dog("666",18));
            objectOutputStream.close();
            System.out.println("���ݱ������");
        } catch (IOException e) {
            e.printStackTrace();
        }


    }
	public void fan() throws ClassNotFoundException {
		//��ָ�������л��ļ�
        try {
            ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream("d:\\data.dat"));
            //��ȡ�������л�����˳����Ҫ�������л���˳��һ�£�����write��˳���read��˳���Ӧ������Ҫ��ͬ����Ȼ�����
            System.out.println(objectInputStream.readInt());
            System.out.println(objectInputStream.readBoolean());
            System.out.println(objectInputStream.readChar());
            System.out.println(objectInputStream.readUTF());//�ַ����ķ����л�
            //System.out.println(objectInputStream.readObject());//�ײ���ObjectתΪDog����һ���쳣
           Object dog=objectInputStream.readObject();
            System.out.println("dog����������"+dog.getClass());
            System.out.println(dog);
            objectInputStream.close();//�ر�
        } catch (IOException e) {
            e.printStackTrace();
        }

	}

}
@SuppressWarnings({"all"})
class Dog implements Serializable {
    private String name;
    private int age;

    public Dog(String name, int age) {
        this.name = name;
        this.age = age;
    }
}

