package yuan.javaexper;
@SuppressWarnings("all")
public class String_Buffer {
	public static void main(String[] args) {
		String string = new String("java");
		StringBuffer stringBuffer01 = new StringBuffer(string);
		System.out.println("操作之前"+stringBuffer01);
		
		stringBuffer01.append(" is diffcult?");
		stringBuffer01.insert(0, "yuan think ");
		System.out.println("经过插入和添加之后"+stringBuffer01);
		
		stringBuffer01.delete(stringBuffer01.length()-1, stringBuffer01.length());//删除最后一个字符
		stringBuffer01.delete(0, 11);//删除yuan think
		System.out.println("经过删除的"+stringBuffer01);
		
		stringBuffer01.replace(0, 4, "python");
		System.out.println("java替换为python"+stringBuffer01);
		
		System.out.println("反转后的stringbuffer,会直接修改原对象"
				+ "！！！"+stringBuffer01.reverse());
		stringBuffer01.reverse();//为了方便观察再反转一次
		System.out.println("截取含is的后面"+stringBuffer01.substring(7));
		System.out.println("截取不含is的前面"+stringBuffer01.substring(0,7));
		System.out.println("任务二");
		String s = "hebei";
		System.out.println("String传参没有修改前"+s);
		change(s);		
		System.out.println("String传参修改后"+s);	
					//因为：String类虽然是引用数据类型，但是它当做参数传递时和基本数据类型是一样的
		System.out.println("------------------");
		StringBuffer sb = new StringBuffer();
		sb.append("hebei");
		change(sb);		
		System.out.println(sb);	
		
		System.out.println("总结String类型传递"
				+ "String类型比较特殊，因为String类型是不可变的，如果形参经过操作修改的话，常量池中会开辟一个新的内存空间来存储修改后的数据（直接使用双引号声明出来的String对象会直接存储在常量池中）。形参的改变对实参也没有影响。结果和值传递一样，但是值传递不会开辟新的内存空间。\r\n"
				);
		
	}
	public static void change(String s) {
	s+="yuan";
	}
	public static void change(StringBuffer a) {
		a.append("yuan_buffer");
	}
}
