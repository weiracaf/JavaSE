package yuan.learn.basic;
@SuppressWarnings({"all"})
//������Ҫ���������û����Լ��������η�
//�������η���Ϊ��public-��ͬ�������Ե��ã���protected-����ͬ������ɵ��ã���ͬ�������Ե��ã�Ĭ��-���಻ͬ�����ܵ��ã������ͬ������
//private-ֻ�б�����Ե���
public class Method {
	public static void main(String[] args) {
		int c = 0;
		float b=2;
		A a = new A();//��ͬһ������java�ļ�����������Լ���ķ�static������ʱ��һ��Ҫ��ʵ�������ܵ���
		a.say();
		Method method = new Method();
		method.he();
		say6();	//���ʱ����staticֱ�ӵ��ü��ɣ�Ҳ������+������
		A.say7();//���ʱ�java�ļ����������staticһ��Ҫ����+������
		
		//��Ҫ���ñ�İ����ļ���java�ļ�����ķ���Ҫ�Ƚ��е��루import��
		//���ﲻ��ʾ�˰�
		
	}
	public void he() {
		System.out.println("he");
	}
	public static void say6() {
		System.out.println("method��"+"6");
	}
	
}

class A{
    public void say(){
        System.out.println("Hello");
    }
    public static void say7() {
		System.out.println("7");
	}
}