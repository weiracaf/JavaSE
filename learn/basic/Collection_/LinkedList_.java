package yuan.learn.basic.Collection_;

import java.util.LinkedList;
@SuppressWarnings({"all"})
//��LinkedList
//LinkedList�ײ�ʵ����˫�������˫�˶����ص㣨��ArrayList��Vector������ײ㲻ͬ��
//Ϊʲô˵����˫�˶����ص㣿1.first��last2.Ĭ�ϵ�remove��ͷ�ȳ��������ȳ���
//��������κ�Ԫ�أ�Ԫ�ؿ����ظ���������null
//�̲߳���ȫ��û��ʵ��ͬ��

public class LinkedList_ {
public static void main(String[] args) {
	//���Ƚ�һ��LinkedList�ײ�ά����һ��˫������
	//ÿ���ڵ����prevָ��ǰһ���ڵ㣬nextָ���һ���ڵ㣬item�洢���ݣ�Ȼ��firstָ���һ��Ԫ�أ�lastָ�����һ��Ԫ�أ������ݽṹ��
	//��Ϊ�ײ�����������ɾ������ӵ�Ч�ʸ�һЩ�����İɣ����Ԫ��Ч�ʸߣ�������˵�˰ɣ�����Ҫ�¿��ռ䣬������
	LinkedList linkedList = new LinkedList();
	linkedList.add("666");
	linkedList.add(1);
	linkedList.add(8);
	linkedList.add(true);
	linkedList.add(1.6f);
	System.out.println(linkedList);
	//����remove��������Ż�ɾ���ĸ���
	linkedList.remove();//˳��һ�ᣬ����������������һ���޲�remove�����������removeFirst()����
	//����Ĭ��ɾ����һ��Ԫ����
	System.out.println(linkedList);
	//�����ʾɾ�����ǵ�һ��
	linkedList.remove(2);//��Ȼ��Ҳ���԰�����ɾ��
	
	//��������
	//��Ϊ��Ҳ��List�ӿ��µģ����ԣ�����Collection��List�ӿڵķ�������������
	
	
}
}
