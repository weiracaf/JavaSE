package yuan.learn.basic.Multithreading;
//��ƪ��Ҫ�������ƣ���������Ҫ�Ǻ�ͬ���������

//�ȷ���ͬ����ԭ��
//t1��t2��t3�����߳�����
//˭����˭�Ƚ�ȥ������ش���
//����t1�Ƚ�ȥ
//�������t1����
//��������ȥȻ�������t2t3����
//��Ȼ���ܻ���t1�����ᵽ��
//��ΪSynchronized���Ǹ��ǹ�ƽ����˭��������˭�ģ�
//һ.������
//1.Java�����У������˶��󻥳����ĸ������֤�������ݲ�����������
//2.ÿ�����󶼶�Ӧ��һ���ɳ�Ϊ�����������ı�ǣ�������������֤����һʱ�̣�ֻҪ����һ���̷߳��ʸö���
//3.�ؼ���synchronized�������Ļ�������ϵ����ĳ��������synchronized����ʱ�������ö�������һʱ��ֻ����һ���̷߳���
//  ���ǻ��������õ���˼��
//4.ͬ���ľ����ԣ����³���ִ��Ч�ʱ�һ������
//5.ͬ���������Ǿ�̬�ģ���������������this��Ҳ��������������Ҫ����ͬһ������
//6.ͬ����������̬�ģ�����Ϊ��ǰ�౾��


//����5��6
//5.����ǳ��ǳ���������������ȥ�����ҵ�Demo01���������this������ɶ��Ȼ����ܹ���Ϊʲô����Thread��ͬȴthis��ͬ
//������ͬһ�����󣡣�������������̶߳��󣡣���������֮��Ż��յ�����Ӱ��
//ͬ�����������������Ʊ�İ�,����Ĵ���
//���ǰ����ӵ�this���ˣ������ø÷����Ķ���
//���������ӵ���Ķ����ϣ�������ͬ������飬�������û��ע�͵���ͬ������ֻ�ܰ����ӵ�this
//ͬ��������Ǽ�ע�͵�

//����Ч������ͬ��
//���ǰѻ������ӵ�this������
/*��Ȼ���Ի��ɱ�Ķ��󣨲���Ҫ��֤������ͬһ����������������������)
����Object a=new Object();
synchronized(a){
}
Ҳ����
��Ϊ������ͬһ���̶߳��󿪱ٵ��߳�
ʹ����������a�϶�����ͬһ��(���Ǳ�֤��ͬһ����)�������Ҹо���this����
Ҳ����static newһ������
�����Ļ������ǲ�ͬ�Ķ���aֻҪ�Ǹ���Ķ���
��ô���������Ҳ��ͬһ��*/
//6.��ֻҪ������ഴ���Ķ��󶼿����ܵ���Ӧ����Ӱ��
//��̬�ļ��ص�ʱ�����û�����ţ���ô��this?
//��Ӧ��static��������
//synchronized�����
//��������д
//public static void m2(){
//synchronized(this){
//	
//	}
//}
//��ȷ��д����
//public static void m2(){
//	synchronized(block_.class) {	û����������.class
//		
//	}
//}

//ע�⣺ͬ��������staticĬ��Ϊ ��ǰ��Ϊ����û��static����this��������

//�̵߳�����!!!!!!!!!!!!!!
//����߳�ռ�öԷ�����Դ�����ǲ������ã������������ڱ����һ��Ҫ���������ķ���
//���磺���裺���������ҵ���������ֻ�
//	���ӣ������ֻ����������ҵ
//�ײ����һ������ֻ������ͬʱ������סһ�δ���
//������Կ�һ���ҵĲ��ͣ��Ƚϳ��󣬻��й����ͷ����Ĳ��������������ˣ�����������
//Ҳ�����ڲ��Ϳ���
public class block_ { 
	int times = 10;
	boolean loop =true;
	public synchronized void sell(){//ͬ��������ͬһʱ��ֻ����һ���߳�ִ��sell�������������	

    if(times<=0){	
        System.out.println("��Ʊ����...");
        loop=false;
        return;
    }


    System.out.println("����"+Thread.currentThread().getName()+"�۳�һ��Ʊ"
            +"ʣ��"+(--times)+"Ʊ");
}
//	 public  void sell(){//ͬ��������ͬһʱ��ֻ����һ���߳�ִ��sell����
//
//		   synchronized(this) {if(times<=0){	
//		            System.out.println("��Ʊ����...");
//		            loop=false;
//		            return;
//		        }
//
//
//		        System.out.println("����"+Thread.currentThread().getName()+"�۳�һ��Ʊ"
//		                +"ʣ��"+(--times)+"Ʊ");
//		                }
//		    }


}