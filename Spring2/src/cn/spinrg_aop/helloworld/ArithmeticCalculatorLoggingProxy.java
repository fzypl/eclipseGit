package cn.spinrg_aop.helloworld;

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
		//代理对象由哪一个累加器进行加载
		ClassLoader loader=target.getClass().getClassLoader();
		//代理对象类型，即其中有哪些方法
		Class[] interfaces = {AtithmeticCalculator.class};
		//当调用代理对象其中方法时 该代码执行
		InvocationHandler h=new InvocationHandler() {
			/**
			 * proxy 正在返回的代理对象 一般情况下 在invoke方法中不使用该对象
			 * method 正在被调用的方法
			 *  调用方法传入的参数
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
