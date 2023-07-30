package yuan.learn.basic.Collection_.Double;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;


@SuppressWarnings({"all"})
//��ƪ��Ҫ��˫�м���
//	�ȿ���ϵͼ��
//			->HashMap(!)->LinkedHashMap(����)
//			->Hashtable->Properties�����ࣩ
//Map(�ӿ�)	
//			->TreeMap		
public class DoubleColumnSet {
	//�Ƚ���Map�ӿڵ��ص��
	//1.Map��Collection���д��ڣ����ڱ������ӳ���ϵ������key-value(����python���ֵ�)
	//2.Map��key��value,�������κ��������͵����ݣ����װ��HashMap$Node����
	//3.Map��key�������ظ�����ǰ���HashSetһ����������ΪHashSet��һ��ֻ��key��Map��
	//4.Map��value�����ظ�
	//5.Map��key��value������Ϊnull������keyֻ����һ����value�����ж��
	//6.����String����Map��key
	//7.key��value֮���ǵ����һ��һ��key->value��
	
	
	//���漸���Ĳ��������
//	1.��ͬ�ڵ��м���ֻ��һ������˫�м��϶��Ǵ���������
	/*
	 * 2.Node����HashMap���ڲ�����ű�ʾHashMap$Node next�����е�NodeԪ������ Ȼ���Ӧ�����������Ե���
	 * ����Ӧ�����ĵ�һ��NodeԪ�� �õ���һ��NodeԪ���൱�ں��涼����
	 */
	/*
	 * 3��4.key�����ظ���value�����ظ��������ظ��Ļ����滻ԭ��key��value ע�����key��ͬҲ���ܼ���
	 * ����㴫��ıȽ�������ֵΪ0�Ͳ��ܼ����ȥ������������˵��
	 */
//	6.Ҳ������������Ķ�����key����Ϊ�β���Object key
//	7.ͨ��Map�ӿڵ�get(Object key)��������ͨ��key��������valueԪ�أ���Ϊkey�����ظ�������һһ��Ӧ��Ŷ
	
	
	//���ڵײ�Ĵ��淽����Nodeʵ����Entry�ӿ�
	//8.�������key��value����Node��������
	/*
	 * Ϊ�˷���������ᴴ��һ��EntrySet���ϣ��ü��ϴ�ŵ�Ԫ������Entry һ��Entry����key��value
	 * Ȼ���Node�����װ��Entry����(����Ķ�̬��)��Ȼ��ŵ�EntrySet���� ������� 
	 * Ȼ������е�key�����װ��һ��Set�������棬��keySet��������
	 * �����е�value�����װ��Collection�������values��������
	 */

	public static void main(String[] args) {	
		
		//Ȼ��һЩMap�ӿڵĳ���������
		//1.put(Object Key,Object value)���Ԫ��
		HashMap hashMap = new HashMap();
		hashMap.put("1", "һ");
		hashMap.put("2", "��");
		hashMap.put("3", "��");
		hashMap.put("1", "��");//����
		System.out.println(hashMap);
		/*
		 * 2.remove(Object key) ɾ����Ӧkey��value
		 */
		hashMap.remove("1");
		System.out.println(hashMap);
		/*
		 * 3.get(Object key) ����key��Ӧ��value���󣬲�������������Object����
		 */
		System.out.println(hashMap.get("2"));
		/*
		 * 4.Map����.size() ����Ԫ�ظ�����һ��key-value��һ��
		 */
		System.out.println(hashMap.size());
		/*
		 * 5.Map����.isEmpty() �������Ϊ0����true ���������Ϊ0������false
		 */
		System.out.println(hashMap.isEmpty());
		/*
		 * 6.Map����.clear() ɾ�����������Ԫ��
		 */
		/*
		 * 7.Map����.containsKey(Obejct key) �ж�Ӧ��key����true û�еĻ�����false
		 */
		System.out.println(hashMap.containsKey("2"));
		/*
		 * 8.keySet ���ض��ڵ�key 
		 * 9.values ���ض�Ӧ��value 
		 * 10.entrySet �������е�Node
		 */
		
		System.out.println(hashMap.keySet());
		System.out.println(hashMap.values());
		System.out.println(hashMap.entrySet());
		//������Map�ӿڵı�����ʽ
		//1.��ǿfor+keySet+get����
		 Set set = hashMap.keySet();
		for (Object a : set) {
			System.out.println(hashMap.get(a));
		}
		//2.key+������+get
	        Iterator iterator = set.iterator();
	        while (iterator.hasNext()){
	            Object next = iterator.next();
	            System.out.println(next+"="+hashMap.get(next));
	        }
	        //��ʵ���кܶ�
	        //��Ҫ�ǿ�keySet����values��entrySet���صļ��Ͻ��еĲ���
	        
	        
	        //��������������ڲ�ͬ�����н���
	        //��ΪHashMap_(!),Hashtable_,Properties_


	}
	
}
