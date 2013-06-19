package biaobiaoqi.rpc.proxy;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Proxy;

public class Test {

	public static void main(String[] args) throws SecurityException, NoSuchMethodException, IllegalArgumentException, InstantiationException, IllegalAccessException, InvocationTargetException {
		HelloWorld hw = new HelloWorldImpl();
		
		System.out.println("--------------Simple way to get proxy object-------------");
		
		InvocationHandler hwHandler = new HelloWorldHandler(hw);
		
		Class<?>[] interfaces = hw.getClass().getInterfaces();
		System.out.println(""+ interfaces.length);
		
		
		
		HelloWorld proxy = (HelloWorld) Proxy.newProxyInstance(hw.getClass().getClassLoader(), hw.getClass().getInterfaces(), hwHandler);
		
		proxy.sayHelloWorld();
		
		
//		System.out.println("---------------Complex way-------------------");
//		
//		Class<?> clazz = Proxy.getProxyClass(hw.getClass().getClassLoader(), hw.getClass().getInterfaces()); 
//
//		Constructor<?> constructor = clazz.getConstructor(new Class[] { InvocationHandler.class }); 
//
//		HelloWorld proxy2 = (HelloWorld)constructor.newInstance(hwHandler); 
//		proxy2.sayHelloWorld();
		
	}
}
