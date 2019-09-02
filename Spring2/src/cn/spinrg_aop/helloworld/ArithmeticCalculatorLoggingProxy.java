package cn.spinrg_aop.helloworld;
//123
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.Arrays;

public class ArithmeticCalculatorLoggingProxy {
	private AtithmeticCalculator target;
	
	public ArithmeticCalculatorLoggingProxy(AtithmeticCalculator target) {
		super();
		this.target = target;
	}

	public AtithmeticCalculator getLoggingProxy() {
		
		AtithmeticCalculator proxy=null;
		//�����������һ���ۼ������м���
		ClassLoader loader=target.getClass().getClassLoader();
		//����������ͣ�����������Щ����
		Class[] interfaces = {AtithmeticCalculator.class};
		//�����ô���������з���ʱ �ô���ִ��
		InvocationHandler h=new InvocationHandler() {
			/**
			 * proxy ���ڷ��صĴ������ һ������� ��invoke�����в�ʹ�øö���
			 * method ���ڱ����õķ���
			 *  ���÷�������Ĳ���
			 */
			@Override
			public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
				String methodName =method.getName();
				System.out.println("methodName  "+methodName+"  begin with "+Arrays.asList(args));
				Object result=method.invoke(target, args);
				System.out.println("the method   " +methodName+"  end with"+result);
				return result;
			}
		};
		proxy=(AtithmeticCalculator) Proxy.newProxyInstance(loader, interfaces, h);
		return proxy;
	}
}
