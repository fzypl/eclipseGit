package cn.spinrg_aop.helloworld;

public class Main {
	public static void main(String[] args) {
//		AtithmeticCalculator atithmeticCalculator=null;
//		atithmeticCalculator =new AtithmeticCalculatorImpl();
		
		
//		int reuslt=atithmeticCalculator.add(1, 2);
//		System.out.println(reuslt);
//		reuslt=atithmeticCalculator.div(4, 2);
//		System.out.println(reuslt);
		
		
		AtithmeticCalculator target=new AtithmeticCalculatorImpl();
		AtithmeticCalculator proxy=new ArithmeticCalculatorLoggingProxy(target).getLoggingProxy();
		
		int reuslt=proxy.add(1, 2);
		System.out.println(reuslt);
		reuslt=proxy.div(4, 2);
		System.out.println(reuslt);
	}
}
