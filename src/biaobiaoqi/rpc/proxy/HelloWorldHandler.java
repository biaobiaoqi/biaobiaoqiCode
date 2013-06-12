package biaobiaoqi.rpc.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class HelloWorldHandler implements InvocationHandler {

    private Object objOriginal;
    /**
     * @param obj 
     */
    public HelloWorldHandler(Object obj) {
           this.objOriginal = obj ;
    }
    
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
           Object result ;
          
           doBefore();
          
           result = method.invoke(this.objOriginal ,args);
          
           doAfter();
          
           return result ;
    }
   
    private void doBefore() {
           System.out.println("In InvocationHandler: before method invoke!");
    }
   
    private void doAfter() {
           System.out.println("In InvocationHadler:¡¡after method invoke!");
    }
}