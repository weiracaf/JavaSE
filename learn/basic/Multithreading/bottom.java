package yuan.learn.basic.Multithreading;
@SuppressWarnings({"all"})
//��ƪҲ�ǽ���һ�¶��̵߳ĵײ㣬����һƪ��һЩ����

//���̵��߳�
//�߳�ȫ��ִ����Ϻ���̲Ż����
//���̱߳���У��������߳̽����ˣ����̾ͽ����ˣ���Ҫ���е��̶߳�������ɽ��̲Ż����
//�ײ�
//1.���̺��̹߳�ϵ���̼߳��ϵ
//Thread.currentThread().getName()
//���д�����Ի�ȡ������λ�õ��̵߳��߳���
public class bottom {
public static void main(String[] args) {
	B b = new B();
	B b1 = new B();
	Thread thread = new Thread(b);
	Thread thread01 = new Thread(b1);
	thread01.start();//һ���߳̿��Կ��ٶ�����߳�
	thread.start();
	for (int i = 0; i < 5; i++) {
		System.out.println("main run too"+" the Thread name:"+Thread.currentThread().getName());
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
//	���Է���B������������߳�����Thread-0
//  B��main������ͬʱ�����е�,���Ǵ�ʱmain�̻߳��Ǽ���ִ�е�
//	����˵����start����
//	����run�����ִ���꣬����������һ��ִ�е�
//	��ִ�е�Ч�����Կ���
//	���̺߳����߳̽���ִ��,�൱����main�߳����濪�˸�Thread-0�߳�
//	���̱߳���У��������߳̽����ˣ����̾ͽ����ˣ���Ҫ���е��̶߳�������ɽ��̲Ż����
		
//		2.Ϊʲô��start����run???
//		�����
		/*
		 * cat.start() ��Ϊ cat.run() �൱����û�п����̵߳� ������ͨ�Ĵ�������->���÷��� 
		 * Ҫ��run����ִ������ִ��������Ĵ���
		 * �ǾͲ��Ƕ��߳��ˣ���д��л� �����߳������ǻ����main��û�п���Thread-0
		 * so���ײ�������ǵ�start���ٵ��̣߳����õ�run����
		 * startԴ���Լ���
		 * startʵ�ֶ��̵߳Ĺؼ�����start0()
		 * start0()��һ������(native)�����ײ�����JVM���õ�
		 * ���ǲ��ܵ���
		 */
	}
}
}
//3.ʵ��Runnable�ӿڵ���ͨ��������ת��ΪThread�ڲ�ϸ��
//���õ��Ǵ���ģʽ��һ�����ģʽ��
//�̴߳����࣬ģ����һ�������Thread��
//class Proxy implements Runnable{//����԰�Proxy�������൱��Thread��Դ�
//private Runnable target = null;
//
//  @Override
//  public void run() {
//      if (target!=null){
//          target.run();
//      }
//
//  }
//  public Proxy (Runnable target){//������
//      this.target=target;
//  }
//  public void start(){
//      start0();
//  }
//  public void start0(){
//      run();
//  }
//}
/*
 * �����ǰ����ǵ� Runnable�ӿ�ʵ�ֵĶ��󸳸��Ǹ�Thread��һ��Target��Ҳ��Runnable���ͣ�
 * Ȼ�����Thread�ĵ�start�Ļ� �����Thread��start0() �½��߳� �½����߳��Ժ�
 * start0()����target.run()��Ȼ��̬�󶨵��ʼ�Ǹ�ʵ��Runnable�����͵�run �൱��ֻ���� 
 * ���Ǵ��������Ǹ����͵�run����
 * ���඼��Thread��������ǵ��õ�Thread��start()��start0()���� ��д���ģʽ
 */


class B implements Runnable{

	@Override
	public void run() {
		// TODO Auto-generated method stub
		int count =0;
		while(true) {
		
		System.out.println("???"+(count++)+Thread.currentThread().getName());
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if (count ==10) 
			break;
		
		
		}
		
	}
	
}