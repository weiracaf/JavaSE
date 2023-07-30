package yuan.learn.basic;

import java.util.ArrayList;

import javax.swing.text.html.HTMLDocument.HTMLReader.SpecialAction;

//这篇来讲泛型奥，这篇先讲一些引出和作用，在来一片generic02来具体描述语法和怎么引用
//先引出泛型
//需求一个ArrayList添加三个Dog对象，Dog含有name和age，并输出name和age要求用getxxx方法
//传统的写的话，看主方法

//这样写没问题不过
/*这样写的话
假如我们的程序员不小心添加了一只猫（与想添加的对象类型不同）
如果你有遍历，并且向下转型成Do想用Do独特的方法
此时会发生类型转换异常
就是
你需要进行foreach遍历的时候
for(Object o:arraylist){
//操作
//如果调用Do类方法
Do a=(Do)o;//需要向下转型，每个都向下转型效率会低
	}这样的话那个猫不能转为那个Do其实，我们可以依靠泛型来解决这个问题
	重点：我们解决的是让用户只能往这个里面添加Do对象，而不是类型转换的问题
	类型转换的问题当然简单一行代码：if(o instanceOf Do),但是只让集合接收Do对象怎么解决接收泛型该干的了

*/

//改进后，这里只写修改的代码，其他代码一样
//当这样带上<Dog>时，这个集合只能存放Dog类型,加入其他对象会报错奥
//
//ArrayList<Dog> arrayList = new ArrayList<Dog>();
//arrayList.add(new Dog("sw",10));
//arrayList.add(new Dog("s",11));
//
//for (Dog a:arrayList//这里可以直接取Dog效率比之前高
//     ) {
//    System.out.println(a);
//}

//泛型基本介绍
//可以把泛型理解为表示数据类型的一种数据类型
//1.泛型又称参数化类型，是Jdk5.0出现的新特性，解决数据类型的安全性问题
//2.在类声明或实例化时只要指定好需要的具体类型即可
//3.保证代码简洁，健壮，比如上面类型转换的例子
//4.泛型的作用：可以在类声明时通过一个标识表示类中的某个属性的类型，或者说某个方法的返回值类型，或者是参数类型(下面进行举例说明)

/*public class generic01 {
public static void main(String[] args) {
	Person<Object> objectPerson = new Person<>();
    //如果你不写的话，默认为Object
    objectPerson.s=new String("c");
    Person<String> Person = new Person<String>();这一步说明这个Person对象里面s只能为String
    //因为相当于把String赋给了T
	//现在Person里面的s只能是String了
	Person.s="小袁";//传入其他类型的会报错
}
}
class Person<T>{
	String name;//代表我们的name是String类型
	T s;//s则是T类型，这个T类型是你在创建的时候定义的类型
	public T Person(T s){//参数类型
	return s;//返回值类型
	}
}
就是相当于把你<>里面传入的类型(实参)
代替为那个类里面的T(形参)
所以说可以把泛型理解为可以表示数据类型的一种数据类型
*/

@SuppressWarnings({"all"})
public class generic01 {
	public static void main(String[] args) {

        ArrayList arrayList = new ArrayList();
        arrayList.add(new Do("sw",10));
        arrayList.add(new Do("s",11));
        arrayList.add(new Do("e",12));
        System.out.println(arrayList);
        for (Object object : arrayList) {
			Do a=(Do) object;
			a.Special();
		}
    }

}
class Do{
    public String name;
    public int age;

    public Do(String name, int age) {
        this.name = name;
        this.age = age;
    }
    public void Special() {
    	System.out.println("Do类自己特有的方法");
    }

    @Override
    public String toString() {
        return "Dog{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
