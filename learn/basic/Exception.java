package yuan.learn.basic;
@SuppressWarnings({"all"})
//本章讲解异常处理机制奥，可能会有点长耐心观看
//异常分为1.error（错误）严重错误-程序会崩溃且无法处理2.Exception又分为运行时异常和编译时异常，是可以处理的异常
//异常有一个体系图
//所有异常的父类为Throwable里面有Error和Exception,主要还是Exception
//运行时异常，一般是一些逻辑错误，比如分母为0了，是我们应该避免的，对于其可以不做处理，因为不能全try catch太浪费资源，在容易出错的地方处理即可，默认抛出
//编译时异常就是编译时下划线是红色的需要立即修改处理-抛出或处理

//主要是运行时异常
//主要有，空指针，数组下标越界，数字运算异常，类型转换异常等
//处理异常的方式
/*
 * try{可能出错的代码
 * }catch(Exception e){
 * 	//捕获到异常时，系统将异常封装给Exception e,传递给catch
 * 	//得到异常对象进行处理-catch里面书写，如果没有异常catch里面不执行
 * 	}
 *	finally{
 *	不过有没有异常都要执行的代码
 *	}
 * 
 * 细节：1.异常发生，异常后的代码不执行直接到catch
 * 细节：2如果try中有多个异常(异常类型相同)，会先捕获前面的异常，然后处理，后面那个异常是不执行的，都在try里
 *	    如果想对不同异常分开捕获进行对应的处理，要对异常的类型具体区分，进行多个catch，来捕获你想捕获的异常
 *		父类异常要放在子类的异常后面，要不然父类就把子类的异常处理了，你写子类的异常有什么用呢？
 */
/*抛出异常
 *throws关键字，将发生的异常交给调用者处理，最顶级处理者为JVM，程序员没有处理默认就是抛出（运行时异常）
 *public static void main(String args[]) thorows Exception
 *(抛出异常是默认的，所以我们有异常时，会给到JVM，JVM就输出异常信息，然后停止程序运行) 
 *当然编译时异常也可以抛出，在对应方法上加上 throws 抛出的异常类型即可
 *将会交给对应调用处理，顺带一提，main的调用者就是JVM
 *throws可以接你想抛出的异常，如果你想有异常就抛出（不用判断异常的类型）可以自己写
 *throws Exception
 *也可以抛出多种异常throws 异常种类1,异常种类2，异常种类3;
 *如 public void f2() throws FileNotFoundException,NullPointerException{
 *		代码
 *		}
 */
//自定义异常这里不进了，一般用不到，用到自己搜
public class Exception {
	public static void main(String[] args) {
        int num1=10;
        int num2=0;
        //1.分母为0
        //2.当程序检测到分母为0时，程序就会抛出异常ArithmeticException
        //3.当抛出异常后，如果不处理，最后抛到jvm，jvm也不处理奥，程序会崩溃，下面的代码就不会再运行
        //4.这样的代码，一个小错误，就会导致整个程序不能运行，以后设计软件的时候不太使用，健壮性太差
        //5.java提供了一个异常处理机制来解决该问题
        //可以用try-catch来处理
        //6.可以选中你认为可能出错的代码区域，用shift+alt+z跳出界面，然后选择第一个的就可以
        //如果进行异常处理，那么即使出现了异常，程序也可以继续执行

        try {
            int res=num1/num2;
        } catch (ArithmeticException e) {
            e.printStackTrace();
            System.out.println(e.getMessage());//可以输出异常信息
        }
        System.out.println("程序继续运行....");
    }
}
