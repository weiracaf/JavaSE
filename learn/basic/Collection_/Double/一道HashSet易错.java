package yuan.learn.basic.Collection_.Double;

import java.util.HashSet;
@SuppressWarnings({"all"})
public class һ��HashSet�״� {
	public static void main(String[] args) {//Person����age��name��дhashCode��equals
		HashSet hashSet = new HashSet();
		Person p1=new Person(1001, "AA");
		Person p2=new Person(1002, "BB");
		hashSet.add(p1);
		hashSet.add(p2);//һ��Ҫ��д��������toString�����Ĭ���ǵ��ü���������toString����
		p1.name="CC";
		hashSet.remove(p1);
		System.out.println(hashSet);//1002 BB,1001 CC
		hashSet.add(new Person(1001, "CC"));
		System.out.println(hashSet);//1002 BB,1001 CC,1001 CC
		hashSet.add(new Person(1001, "AA"));
		System.out.println(hashSet);//1002 BB,1001 CC,1001 CC,1001 AA
		//���������ģ��ҵĴ������ɱε�
		//����������һ�°�
		//1.��һ���������Ϊp1��Ȼɾ���ˣ�Ϊʲô�������
		//ԭ�����p1ûɾ���ɹ�
		//��Ϊ�м��һ��������p1.name="CC",��ı�p1��hashCode����ֵ
		//ԭ����p1����˵������1��λ�ô洢��remove�ĵײ�Ҳ���ȸ���hashCode��������Ȼ����equals����trueɾ��
		//�����µ�p1���ص�ֵ��������1�ˣ���д�˷�����ֻ��id��name��ͬhashCode������ͬ������ȥ��������1�ĵط���1001��Ȼ�Ҳ���
		//�Ҳ�����ôɾ�������滭һ��ͼ�Ƚϻ����
		//table[0]	p2
		//table[1]	p1
		//table[2]	��remove p1������������
		//table[3]
		//2.�ڶ������
		//Ϊʲô���������1001 CCû�н����滻��
		//�������������룬�����p1��ʱ������������1�������name�޸�ΪCC��������������1���õ���1001 AA��������hashCode����
		//���¼���1001 CC����ô�ܺ�1001 AA������ֵһ�������϶�����һ����������p1���Ը��ģ��������䣩�����ԣ���������������һ��������
		//�����Ͳ��ܱȽϽ����滻��Ҳ�ǵײ��add����
		//table[0]	p2(1002 BB)
		//table[1]	p1��1001 AA->CC��
		//table[2]	1001 CC
		//table[3]
		//3.���������
		//1001 AA,��������,Ϊʲôû��p1�滻��
		//������������ǵ��м��ϣ���Ԫ���Ƿ���ȸ��ݵײ��equals
		//1001 AA��ô��1001 CC��ͬ
		//���Ծ����뵽����1������
		//table[0]	p2(1002 BB)
		//table[1]	p1��1001 AA->CC��
		//table[2]	1001 CC
		//table[3]
	}

}
class Person{
	int age;
	String name;
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + age;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Person other = (Person) obj;
		if (age != other.age)
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}
	public Person(int age, String name) {
		super();
		this.age = age;
		this.name = name;
	}
	@Override
	public String toString() {
		return "Person [age=" + age + ", name=" + name + "]";
	}
	
	
}
