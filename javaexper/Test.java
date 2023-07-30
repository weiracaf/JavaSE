package yuan.javaexper;

public class Test {
public static void main(String[] args) {
	Person person01 = new Person("小袁",18);
	Person person02 = new Person("小袁",18);
	Object object = new Object();
	Object object2 = new Object();
	System.out.println("object本身的equal方法，比较是不是同一个对象"+object.equals(object2));
	
	System.out.println(person01.hashCode());
	System.out.println(person01.getClass());
	System.out.println("重写equals方法的person比较属性值"+person01.equals(person02));
	System.out.println(person01);
}
}
class Person{
	public String name;
	public int age;

	

	public Person(String name, int age) {
		super();
		this.name = name;
		this.age = age;
	}



	public boolean equals(Object j){
	    if(this==j)//同一个对象直接反
	    return true;
	    if(j instanceof Person)//是Person我们才比较
	    {    Person a=(Person)j;
	        if(a.name.equals(this.name)&&a.age==this.age)
	            
	    return true;
	                
	    
	    }
	return false;//不是Person返回false
	    
	        }



	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "["+this.name+" "+this.age+"]";
	}




}