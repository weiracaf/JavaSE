package yuan.learn.basic;
//ͨ��enum�ؼ���������ö��
public enum Demo02 {
	//final public static Season Spring=new Season("����","��ů");
    //final public static Season Summer=new Season("����","����");
    //final public static Season Winter=new Season("����","����");
    //final public static Season Autumn=new Season("����","��ˬ");
    //���ʹ��enum�ؼ���ʵ��ö����
    //1.ʹ��enum���class
    //2.final public static Season Spring=new Season("����","��ů");������ĵȼ�
    //  Spring("����","��ů") ��� ������(ʵ���б�)�͹�������Ӧ
    //3.����ж������ʹ�ö���,������ɣ������ö��ż����������һ����дһ���������һ������д;
    //4.���ʹ��enumʵ��ö�٣���Ҫ������ĳ������������ǰ�棨�����Ķ���д����ǰ�棩!!!
	//�ø÷���ʵ�ֵ�����һЩ���÷��������Լ̳���Enum�࣬����ȥ�ҵĲ��Ϳ���
	//
	//�������һЩ���ʣ�û��ϵ����ö�ٵ�ϸ�ڶ�������
	
	/*
	 * 1.ö�������ⶼ������new����ֻ��ͨ��ö�ٹ̶��ĸ�ʽ��������new Gender();//�ᱨ��
	 * 2.���ö����û���κεĹ�����ʱ��jvm���Զ��ṩһ��private���޲ι���������֮���ṩ
	 * 3.ö�����еĹ�����Ȩ�޷��ʼ���ֻ����private�������дȨ�޷��ʼ���jvm���Զ�����private
	 * 4.ö�����ж������ʹ���޲ι������������󣬶���������ģ�������ȫ��ʡ�Բ�д�� 5.ö�����ж��󴴽��Ĵ��������ö����ĵ�һ�У�������뱨��
	 * 6.ö�����ж�����ʽ�� public static final�ؼ������Σ��Լ��ֶ���ʾ����뱨�� 7.���������е�ö���඼ ��ʽextends
	 * Enum�����޷��̳������࣬���ǿ���ʵ�ֽӿ� 8.��ö����Ĺ��������޷���ʾʹ��super() super is not allowed in enum
	 * constructor 9.ö���಻��ӵ�����ࡣö���಻�ܱ�������̳�
	 */

	 
	
    Spring("����","��ů"),Winter("����","����"),Autumn("����","��ˬ"),Summer("����","����");

    private String name;
    private String desc;
    private Demo02(String name, String desc) {
        this.name = name;
        this.desc = desc;
    }

    public String getDesc() {
        return desc;
    }

    public String getName() {
        return name;
    }
    @Override
    public String toString() {
        return "Season{" +
                "name='" + name + '\'' +
                ", desc='" + desc + '\'' +
                '}';

}
    }
