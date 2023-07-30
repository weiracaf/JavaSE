package yuan.javaexper;
@SuppressWarnings("all")
public class Packed_class {
		public static void main(String[] args) {
			//int类型转为String
			//方式1
			int i = 100;
			String s1 = i + "";	
			System.out.println(s1);	
			//方式2
			String s2 = String.valueOf(i);
			System.out.println(s2);
			//int到String
			//方式3
			Integer i2 = new Integer(i);
			String s3 = i2.toString();
			System.out.println(s3);
			//方式4
			String s4 = Integer.toString(i);
			System.out.println(s4);
			//Stirng->int
			//先把String转为Integer-》手动拆箱那一步、直接手动装箱可以用String作为参数
			String s = "200";
			Integer i3 = new Integer(s);//手动装箱
			//手动拆箱
			int i4 = i3.intValue();	
			System.out.println(i4);
			//手动装箱-》可以用String作为参数
			int i5 = Integer.parseInt(s);
			System.out.println(i5);
			System.out.println("自动装箱和拆箱");
			
			Integer a1 = 100;	//自动装箱：把基本数据类型转换成对象。直接可以给引用数据类型赋值
			//底层是手动装箱
			int z = a1 + 200;	//自动拆箱：把对象转换为基本数据类型
			//底层也是手动拆箱，用哪个XXXvalue()方法
			System.out.println(z);	//300
			


			
		
		
		
	}

}
