package algorithm;

public class Test {
	public static void main(String[] args) {
//			int a = 9/0;
//		Integer a = new Integer(2);
//		Integer b= new Integer(2);
//		System.out.println(a==b);
//		String number = null;
//		if(number==null) {
//			throw new IllegalArgumentException();
//		}
//		A a
		A aa = new A(); 
		
	}
	
}interface I1{
	void m1();
}
interface I2 extends I1{
	void m2();
}
interface I3{
	void m3();
}
class A implements I3{
	public void m3() {};
}
class B extends A implements I2{
	public void m1(){};
	public void m2() {}
}
