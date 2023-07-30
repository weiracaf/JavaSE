package yuan.learn.basic.Collection_;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
@SuppressWarnings({"all"})
//���ڽ����м��ϣ��������д�㣬����ԭ������
//���м�����ϵͼ
//							->ArrayList,LinkedList,Vector(��)
//				->List(�ӿ�)
//Collection(�ӿ�)
//				->Set(�ӿ�)
//							->TreeSet,HashSet(��)
//��Ϊ����������Ҫ��ֵ��չ�������¿ռ�̫�鷳
//�ͳ����˼���������������Ϸֵ��м��Ϻ�˫�м��ϣ����ڽ����м���
/*���ϵĺô�
1.��̬����������������ʹ�÷���
2.�ṩһϵ�з����������ķ���
3.ʹ�ü�����ӣ�ɾ����Ԫ�أ��������*/
public class SingleSetMethod {
	public static void main(String[]  args) {
		//�Ƚ�Collection�ӿ��еķ���������ʵ��������
		//1.add(����)������������͵Ļ����Զ�װ�䣬�򼯺������Ԫ��
		Collection arrayList = new ArrayList();	//�ӿڲ���ʵ������������ʵ��������������ʾ
		arrayList.add("666");
		arrayList.add(10);
		arrayList.add(1.6f);
		arrayList.add(false);
		System.out.println(arrayList);
		//2.remove()���������ж�����ʽ
		//һ.��������arrayList.remove(Integer.valueOf(10));��Ҫɾ������10�Ļ�,Ҫ����ת��Integer
		//��.arrayList.remove(true);//����ֵ������Բ���!!
		//����һ�ֲ���������һ���ӿ�д���൱�����أ�����ȷʵCollectionֻд���������ķ���
		//���ز���ֵ�ж�ɾ���Ƿ�ɹ�
		arrayList.remove(10);
		//ע�⣺��Ϊ����������������Collectionֻ�ж���ķ��������10�Զ�װ��Ϊ����
		//�����List��֮�µ�ʵ�ֵ����࣬Ĭ�Ͼ������������Ƕ�����Ҫ�Զ�װ��
		//3.contains(����)
		//���Ҹö����ڼ��������ޣ��з���true���޷���false
		if(arrayList.contains(Float.valueOf(1.6f))){
			System.out.println("��1.6");
		}
		//4.clear()��ղ�������ռ����е����ж����޷���ֵ
		System.out.println("���ǰ"+arrayList);
		arrayList.clear();
		System.out.println("��պ�"+arrayList);
		//5.addAll():��Ӷ��Ԫ��
		//������дaddAll(Collection c)��������������Ԫ��
		//addAll(int idex,Collection c)���������϶�Ӧ������Ԫ��
		//���ز������жϳɹ����
		ArrayList list = new ArrayList();
		list.add("��¥��");
		list.add("��������");
		list.add("ˮ䰴�");
		arrayList.addAll(list);
		System.out.println("addAll��"+arrayList);
		//6.containsAll�����Ҷ��Ԫ���Ƿ����
		//containsAll(Collection c)
		//���ز���ֵ���ж�����
		System.out.println(arrayList.containsAll(list));
		//7.size()���ؼ���Ԫ�ظ���
		System.out.println("�����е�Ԫ��"+arrayList.size());
		
		//�ӿڱ�����������������������������������������������������������������������
		//Inerator()
		//����ʵ����Collection�ӿڵļ����࣬����һ��iterator()����
		//���Է���һ��ʵ����Iterator�Ķ��󣬼�������
		//Iterator���ڱ������ϣ�������Ŷ���
		Collection c=new ArrayList();
		c.add("����");
		c.add("��¥��");
		c.add("���μ�");
		Iterator a= c.iterator();
        while (a.hasNext()){
        System.out.println(a.next());
        }
        //��Ȼ����Ҫ���ǻ�������ǿforѭ���ģ�������������������������������������������������������������
        //�ײ㻹�ǵ�����
        for (Object object : c) {
			System.out.println(object);//ͬ������ö�Ӧ�������ͷ�����Ҫǿת���Լ�instanceOfת
		}
        
        //Ȼ����List�ӿڵķ���
        //����ķ���ֻҪ������ķ����������ľ������أ�
        //1.add(int index,Obiect ele)
        //������index���룬eleԪ��
        List list1 = new ArrayList();
        list1.add("СԬ");
        list1.add("����");
        list1.add(2,"��");
        list1.add(1,"С");
        System.out.println(list1);
        //2.addAll(int index,Collection ele)
        //������indexλ�ÿ�ʼ,��ele����Ԫ�ؼӽ���
        //3.remove(int index):�Ƴ�ָ��indexλ�õ�Ԫ�أ������ش�Ԫ��
        System.out.println(list.remove(1));
        System.out.println(list);


        ArrayList arrayList1 = new ArrayList();
        arrayList1.add("Ŭ��");
        arrayList1.add("����");
        list.addAll(1,arrayList1);
        System.out.println(list);
        //֮����������Լ��ķ���
        //4.get(int index)
        //��ȡ����indexλ�õ�Ԫ��
        System.out.println(list.get(1));
        //5.indexOf(Object obj):����obj�ڼ������״γ��ֵ�λ��
        System.out.println(list.indexOf("����"));//δ���ַ���-1
        //6.lastIndexOf(Object obj):����obj�ڼ��������һ�γ��ֵ�λ��
        System.out.println(list.lastIndexOf("����"));
        //7.set(int index,Object ele):��index����Ԫ���滻Ϊele
        list.set(0,"AI");
        System.out.println(list);
        //8.List subList(int formIndex,int toIndex)
        //���ش�formIndex��toIndexλ�õ��Ӽ���[formIndex,toIndex)
        System.out.println(list.subList(0,2));
        //List�ӿڳ���ǰ������ֱ������Լ�һ��
        //����һ����ͨfor��������
        for(int i=0;i<list.size();i++)
        {
        Object object=list.get(i);
        System.out.println(object);
        }
        
        
        //������ھ���ĳ�����Ҵ�������ļ����⣬�ֱ�ΪArrayList_,Vector_,LinkList_,Set,HashSet_,LinkedHashSet_
        //����Collection_����




        




		
		
		
	}

}
