package yuan.learn.basic.Collection_;

import java.util.ArrayList;
@SuppressWarnings({"all"})
//ArrayList_��

//ArrayList���Դ洢���ж��󣬰���null������ͬʱ�洢���null
//ArrayList��������ʵ�����ݴ洢��
//ArrayList������ͬ��Vector
//����ArrayList�̲߳���ȫ��ָ��Ч�ʸߣ������߳���Vector
public class ArrayList_ {
	public static void main(String[] args) {
//		�ײ�ṹ��
//		��˵���ۣ�
//		1.ArrayList��ά����һ��Object���͵�����elementData
//		transient Object[] elementData
//		transient���ε����Բ��ᱻ���л������ܸ㵽������ඣ�
//		2.������ArrayList����ʱ�����ʹ�õ����޲ι��죬���ʼelementData������Ϊ0
//		��һ����ӣ�������elementDataΪ10�������ٴ�����������elemrntDataΪ1.5��
//		3.��ʹ���вι��죬���ʼelementData����Ϊָ����С������Ҫ���ݣ���ֱ������elementDataΪ1.5��
		//�����Ļ���Collection��List�ķ���
		//��Ҫ������ĵײ�ԭ����add()֮�Ƿ���Ҫ���ݺ�����ݲ�������Ҫ���ݻ����ArrayList��grow()��������
		//���Կ��ҵĲ��ͻ���Դ��
		//���ݵı�����Arrays.copyOf()
		//������ֱ�ӵ�
		ArrayList arrayList = new ArrayList();
		arrayList.add("66");
		arrayList.add(8);
		arrayList.add(8);
		arrayList.add(6);
		System.out.println(arrayList);
		//arrayList.remove()û��Ĭ�ϵķ�������û�в�����remove����
	}

}
