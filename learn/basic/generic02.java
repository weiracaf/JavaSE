package yuan.learn.basic;

import java.util.ArrayList;
import java.util.List;

//��ƪд���Ͱ£����ھ����﷨��ʹ��ϸ��
//���͵�����
//interface �ӿ���<T>{}��class ����<K,V>{}
//˵����1.T,K,V������ֵ����������
//2.�κ���ĸ�������ã�����T��д�������нӿ�Ҳ����д�����
//���͵�ʵ������Ҫ����������ָ�����Ͳ���������
//List<String> strlist = new ArrayList<String>();
//lterator<Customer> iterator = customers.iterator();

//����˵����ArrayList,��HashMap��ʵ���з��ͣ��㲻дĬ��Object
//HashMap<1,2>����������һ����key�����ͣ�һ����value������

//�йط��͵�ʹ��ϸ��
//1.����ֻ�����������ͣ������ǻ�������-��Ҫֻ��int�Ļ�ֻ��дInteger,��Ҳ��Ϊʲô�а�װ���ԭ��֮һ��
//2.��ָ�����ͺ󣬿��Դ�������ͣ������������ͣ���̬��
//3.�����ж���ʹ������
//List<Integer> a = new ArrayList<Integer>();
//List<Integer> b = new ArrayList<>();	////û����ǰ��ұߵ��Ǹ�<>����Ķ���ȥ�� 
//List c = new ArrayList();//����ʲô����д��<>ɾ��Ĭ�ϵľ��Ƿ�������ΪObject
//����һ�°�
//���ڵ�һ�ֺ͵ڶ������𣺾���ûʲô����
//��Ϊ��һ��ָ���ˣ��ͺ����Ǹ���Ĭ��ָ����ǰ���Ǹ���ͬ�ģ�����������������жϣ����Ǽ�д����

//�й��Զ��巺��-������������Ӧ�÷���
//1.�Զ��巺����2.�Զ��巺�ͽӿ�3.�Զ��巺�ͷ���
//1.class ����<T,R...>{��Ա}
//ע�⣺��ͨ�����ʹ�÷��ͣ�ʹ�÷������鲻�ܳ�ʼ������̬������������ķ��ͣ����������ڴ���ʱҪָ����û��ָ����Ĭ��Object
//���������ע���ľ������
//class Tiger<T,R,M>{
//	String name; R r; M m; T t;
//	}
/*1.R��M��T������������
r��m��t��������
�����ڳ�Ա��ʹ��
����˵����������get��set������
public Tiger(R r){	this.r = r; };
static void m1(R r){};�ͻᱨ����
2.��Ϊ����û��ȷ�����Ͳ�֪��Ҫ���ٶ��ռ䣬���Բ��ܳ�ʼ��
3.��̬�����Ǻ�����صģ����ǺͶ�����أ��������ʱ������û�д���
��̬������������ʹ�÷��ͣ�JVM������ɳ�ʼ������֪���������ͣ���֪����ô���ٿռ䣩
*/
//2.interface �ӿ���<T,R...>{		}
//�ӿھ�̬��Ա�����÷��ͣ����ͽӿڵ����ͣ��ڼ̳нӿڻ���ʵ�ֽӿ�ʱȷ��
/*����1.ע��ӿ��е����Զ��Ǿ�̬���ʵ�
�ӿڵ����Ե����η�ֻ����public static final������int a = 1; ʵ������public static final int a = 1�������ʼ����
2.����Ƿ��ͽӿڵĶ���interface IUsb<T t,R r>{};IUsb�Ķ��� 
�ұ��Ǽ̳з��ͽӿ�
����ǵ�һ��Class C implements IUsb{
	}
��ͬ��Class C implements IUsb<Object,Object>{
}
������Ҫ class C implements IUsb<String ,Integer>ʲô��д�������ͣ������ӿڼ̳�Ҳ��Ҫд��
interface B extends IUsb<String,Integer>

*/

//�Զ��巺�ͷ���
//�﷨ ���η�<T,R...> �������� ������(�����б�){ }
//ע��ϸ�ڣ�
//1.�����ͷ����µ��õ�ʱ�����ͻ�ȷ��
//2.ע��ʹ�÷��͵ķ����ͷ��ͷ���������
//public void eat(E e){}��ʹ���˷��͵����Ƿ��ͷ��������ͷ������η���������<>��
//����Car�и�public <T,R>void fly(T t,R r){���ͷ���}
//���ǵ��õ�ʱ�� Car a = new Car();  
//ֱ��a.fly("666",100);���������Զ�ʶ�����ͣ�����֮ǰ��Ҫ�Լ�д


//���͵ļ̳к�ͨ��!!!!!!!!!!
//����û�м̳�һ˵��
//List<Object> list=new ArrayList<String>();
//�����д���Ǵ���ģ�ǰ������Ӧ�����ߺ���ʲôҲ��д

//���ڷ��͵�ͨ��!!!!!!
//1.<?>:֧��������ʽ����
//2.<? extend A>:֧��A���Լ�A�������
//3.<? super A>֧��A���Լ�A��ĸ���
//����ǹ涨���㴫�뷺�͵ķ�Χ�£����Ƕ������ͷ�Χ
//����һ���ڷ����Ĳ�������Ӵ�õ�
//��������ֻ�����,������A���������ArrayList����,��������ArrayList<? extend A>
//����������ķ��Ͳ�ƥ����д�ķ��ͣ���ô�ͱ������������������ڣ� ���� +extends final_�Ǿͱ�����
//��Ϳ������������������
@SuppressWarnings({"all"})
public class generic02 {
	public void pr(List<?> a) {//����Ϳ��Խ���List�����²��ܴ洢ʲô����
		for (Object object : a) {
			System.out.println(object);
		}
	}
public static void main(String[] args) {
	ArrayList<String> arrayList = new ArrayList<>();
	arrayList.add("666");
	arrayList.add("ţ");
	arrayList.add("7");
	generic02 generic02 = new generic02();
	generic02.pr(arrayList);
}

}
