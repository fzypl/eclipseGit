package cn.spinrg_aop.helloworld;

public class AtithmeticCalculatorImpl implements AtithmeticCalculator {

	@Override
	public int add(int a, int j) {
		int result=a+j;
		return result;
	}

	@Override
	public int sub(int a, int j) {
		int result=a-j;
		return result;
	}

	@Override
	public int mul(int a, int j) {
		int result=a*j;
		return result;
	}

	@Override
	public int div(int a, int j) {
//		System.out.println("the method add begin with["+a+","+j+"]");
//		System.out.println("the method add end with  "+(a/j));
		int result=a/j;
		return result;
	}

}
