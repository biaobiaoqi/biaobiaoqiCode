package biaobiaoqi.rpc.rmi;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
/**
 * Simple example to run RMI client.<br><br>
 * @author biaobiaoqi
 *
 */
public class RMIClient {
	public static void main(String[] args) {
		try{
			//Get object from remote server
			RMIHelloWorld helloWorld = (RMIHelloWorld) Naming.lookup(RMIServer.URL);
			
			//Invoke certain method.
			String result = helloWorld.getHelloWorldString("biaobiaoqi");
			
			System.out.print(result);
			
		} catch (RemoteException e) {
			e.printStackTrace();
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (NotBoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
