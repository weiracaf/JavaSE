package yuan.learn.basic.IO;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

//本篇讲对象处理流
//主要是ObjectOutputStream和ObjectInputStream
//我们看应该需求，我们保存 int num = 100 这个数据，注意我们保存的不是100数字，而是int 100，并且可以从文件中直接恢复int 100
//或者是储存一个Dog对象，且能够恢复
//也就是除了值，数据类型也是必要的
//这时需要序列化和反序列化
//序列化就是在保存数据的时候保存数据的值和数据类型,反序列化就是相反
//但是序列化和反序列化是有条件的,需要实现Serializable接口，或Exterbalizable接口
//推荐大家实现Serializable因为里面没有任何方法是一个标记接口
//而ObjectOutputStream和ObjectInputStream分别提供了序列化和反序列化的功能
//也是接受对应的OutputStream
//和对应的InputStream 
//下面有演示代码
//可以发现，对应的data.txt它其实是乱码，因为本质的话就不是纯文本文件，但是依然可以看出是以数据+数据类型存储的
//我们需要ObjectInputStream进行反序列化才能看出存储的对象
//在下面的fan方法，对我们main里面序列化数据的进行了反序列化
//对应的顺序反序列化自己百度上查，其实基本也差不多了
//就objectInputStream.readUTF()objectInputStream.readChar()objectInputStream.readObject()什么的

//一些细节补充
//1.读写顺序一致
//2.序列化和反序列化对象要求实现Serializable接口
//3.序列化对象，不会将static和transient修饰的成员序列化，static和transient属性会自动填null
//4.序列化对象里面的属性（继承类型就包装类，不过包装类都实现了不用担心）也要实现Serializable接口
//5.序列化可继承，就是如果某类实现了序列化，他的子类默认也实现了序列化

//接下来是标准输入、输出流
public class 对象处理流 {
	public static void main(String[] args) {
        String filePath="d:\\data.txt";//这个后缀是随意的，序列化后保存的文件格式不是txt而是按照它的格式来保存的
        //所以其实随便起一个后缀名就行了

        try {
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream(filePath));
            //序列化数据到d:\data.txt
            //没有的话会先创建
            objectOutputStream.writeInt(100); //int自动装箱为Integer实现了Serializable接口
            objectOutputStream.writeBoolean(true);//同
            objectOutputStream.writeChar('c');//同
            objectOutputStream.writeUTF("ccle");//同
            //下面我们自建个类Dog，保存进去
            objectOutputStream.writeObject(new Dog("666",18));
            objectOutputStream.close();
            System.out.println("数据保存完毕");
        } catch (IOException e) {
            e.printStackTrace();
        }


    }
	public void fan() throws ClassNotFoundException {
		//先指定反序列化文件
        try {
            ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream("d:\\data.dat"));
            //读取（反序列化）的顺序需要和你序列化的顺序一致，就是write的顺序和read的顺序对应的数据要相同，不然会出事
            System.out.println(objectInputStream.readInt());
            System.out.println(objectInputStream.readBoolean());
            System.out.println(objectInputStream.readChar());
            System.out.println(objectInputStream.readUTF());//字符串的反序列化
            //System.out.println(objectInputStream.readObject());//底层会把Object转为Dog会抛一个异常
           Object dog=objectInputStream.readObject();
            System.out.println("dog的运行类型"+dog.getClass());
            System.out.println(dog);
            objectInputStream.close();//关闭
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

