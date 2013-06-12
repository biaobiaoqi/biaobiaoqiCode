package biaobiaoqi.rpc.proxy;

public class HelloWorldImpl implements HelloWorld {
	private int count = 0;
	
	@Override
	public void sayHelloWorld() {
		System.out.println("Hello world!" + count ++ );
	}

}
