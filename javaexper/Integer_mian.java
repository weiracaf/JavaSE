package yuan.javaexper;
@SuppressWarnings({"all"})
public class Integer_mian {
	public static void main(String[] args) {
		Integer i1 = new Integer(97);
		Integer i2 = new Integer(97);
		System.out.println("==看底层的hashcode-地址");
		System.out.println(i1 == i2);		//false
		System.out.println("包装类重写equals比较里面的值");
		System.out.println(i1.equals(i2));	//true
		System.out.println("--------------");

		/*Integer中的equals()方法：比较此对象与指定对象。
				当且仅当参数不为null，并且是一个与该对象包含相同 int 值的Integer对象时，结果为true。
		*/

		Integer i5 = 97;
		Integer i6 = 97;
		
		System.out.println(i5 == i6);
		System.out.println("这个相同的原因因为都是指向常量池的97，没有大于byte范围不会创建对象");
		System.out.println(i5.equals(i6));	//true
		System.out.println("那equals肯定也相同喽");
		System.out.println("--------------");


		Integer i9 = 127;
		Integer i10 = 127;
		System.out.println(i9 == i10);		//true?
		System.out.println(i9.equals(i10));	//true
		System.out.println("--------------");

		Integer i11 = 128;
		Integer i12 = 128;
		
		System.out.println(i11 == i12);	//false
		System.out.println("如果不在-127-128范围内的话也会报错，超过byte数值范围会创建新的Integer对象");
		System.out.println(i11.equals(i12));	//true

		/*
		-128 ~ 127是byte的取值范围，如果数据在这个范围内，自动装箱就不会新创建对象，而是从常量池中获取；
					   如果超过了byte取值范围，就会在堆内存中再创建对象
		原因：查看API的Integer→valueOf(int i)原码即可。
		*/

		}
	}
