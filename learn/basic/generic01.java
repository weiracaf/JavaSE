package yuan.learn.basic;

import java.util.ArrayList;

import javax.swing.text.html.HTMLDocument.HTMLReader.SpecialAction;

//��ƪ�������Ͱ£���ƪ�Ƚ�һЩ���������ã�����һƬgeneric02�����������﷨����ô����
//����������
//����һ��ArrayList�������Dog����Dog����name��age�������name��ageҪ����getxxx����
//��ͳ��д�Ļ�����������

//����дû���ⲻ��
/*����д�Ļ�
�������ǵĳ���Ա��С�������һֻè��������ӵĶ������Ͳ�ͬ��
������б�������������ת�ͳ�Do����Do���صķ���
��ʱ�ᷢ������ת���쳣
����
����Ҫ����foreach������ʱ��
for(Object o:arraylist){
//����
//�������Do�෽��
Do a=(Do)o;//��Ҫ����ת�ͣ�ÿ��������ת��Ч�ʻ��
	}�����Ļ��Ǹ�è����תΪ�Ǹ�Do��ʵ�����ǿ�����������������������
	�ص㣺���ǽ���������û�ֻ��������������Do���󣬶���������ת��������
	����ת�������⵱Ȼ��һ�д��룺if(o instanceOf Do),����ֻ�ü��Ͻ���Do������ô������շ��͸øɵ���

*/

//�Ľ�������ֻд�޸ĵĴ��룬��������һ��
//����������<Dog>ʱ���������ֻ�ܴ��Dog����,������������ᱨ���
//
//ArrayList<Dog> arrayList = new ArrayList<Dog>();
//arrayList.add(new Dog("sw",10));
//arrayList.add(new Dog("s",11));
//
//for (Dog a:arrayList//�������ֱ��ȡDogЧ�ʱ�֮ǰ��
//     ) {
//    System.out.println(a);
//}

//���ͻ�������
//���԰ѷ������Ϊ��ʾ�������͵�һ����������
//1.�����ֳƲ��������ͣ���Jdk5.0���ֵ������ԣ�����������͵İ�ȫ������
//2.����������ʵ����ʱֻҪָ������Ҫ�ľ������ͼ���
//3.��֤�����࣬��׳��������������ת��������
//4.���͵����ã�������������ʱͨ��һ����ʶ��ʾ���е�ĳ�����Ե����ͣ�����˵ĳ�������ķ���ֵ���ͣ������ǲ�������(������о���˵��)

/*public class generic01 {
public static void main(String[] args) {
	Person<Object> objectPerson = new Person<>();
    //����㲻д�Ļ���Ĭ��ΪObject
    objectPerson.s=new String("c");
    Person<String> Person = new Person<String>();��һ��˵�����Person��������sֻ��ΪString
    //��Ϊ�൱�ڰ�String������T
	//����Person�����sֻ����String��
	Person.s="СԬ";//�����������͵Ļᱨ��
}
}
class Person<T>{
	String name;//�������ǵ�name��String����
	T s;//s����T���ͣ����T���������ڴ�����ʱ���������
	public T Person(T s){//��������
	return s;//����ֵ����
	}
}
�����൱�ڰ���<>���洫�������(ʵ��)
����Ϊ�Ǹ��������T(�β�)
����˵���԰ѷ������Ϊ���Ա�ʾ�������͵�һ����������
*/

@SuppressWarnings({"all"})
public class generic01 {
	public static void main(String[] args) {

        ArrayList arrayList = new ArrayList();
        arrayList.add(new Do("sw",10));
        arrayList.add(new Do("s",11));
        arrayList.add(new Do("e",12));
        System.out.println(arrayList);
        for (Object object : arrayList) {
			Do a=(Do) object;
			a.Special();
		}
    }

}
class Do{
    public String name;
    public int age;

    public Do(String name, int age) {
        this.name = name;
        this.age = age;
    }
    public void Special() {
    	System.out.println("Do���Լ����еķ���");
    }

    @Override
    public String toString() {
        return "Dog{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
