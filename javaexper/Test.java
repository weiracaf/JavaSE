package yuan.javaexper;

public class Test {
public static void main(String[] args) {
	Person person01 = new Person("СԬ",18);
	Person person02 = new Person("СԬ",18);
	Object object = new Object();
	Object object2 = new Object();
	System.out.println("object�����equal�������Ƚ��ǲ���ͬһ������"+object.equals(object2));
	
	System.out.println(person01.hashCode());
	System.out.println(person01.getClass());
	System.out.println("��дequals������person�Ƚ�����ֵ"+person01.equals(person02));
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
	    if(this==j)//ͬһ������ֱ�ӷ�
	    return true;
	    if(j instanceof Person)//��Person���ǲűȽ�
	    {    Person a=(Person)j;
	        if(a.name.equals(this.name)&&a.age==this.age)
	            
	    return true;
	                
	    
	    }
	return false;//����Person����false
	    
	        }



	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "["+this.name+" "+this.age+"]";
	}




}