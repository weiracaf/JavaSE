package yuan.learn.basic.IO;
//��ƪ����׼���������
//����������
//System.in ��System.out
//�Ƚ�System.in
//System.in����������InputStream����������BufferedInputStream
/*System.in�ı�׼�����Ǽ���
new Scanner(System.in)
System.in
������ö�ӦScanner�����next()
�����ͻ��System.in�����̣�����ȡ����*/
//System.out
//�������ͺ��������Ͷ���PrintStream(�Ǵ�ӡ���е������������ὲ)
//Ĭ�����������ʾ����

//��һƪת����

@SuppressWarnings({"all"})
public class ��׼��������� {
public static void main(String[] args) {
	System.out.println(System.in.getClass());//ע��getclass���������������
	Object aObject = new String();
	System.out.println(aObject.getClass());
}
}
