package biaobiaoqi.rpc.rmi;

import java.net.MalformedURLException;
import java.rmi.AlreadyBoundException;
import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;

import javax.sound.sampled.Port;
/**
 * Simple Example to run RMI server.<br><br>
 * 
 * @author biaobiaoqi
 *
 */
public class RMIServer {
	public static final int PORT = 12090; 
	//The RMI URL should be 'host:port/name'
	public static final String URL = "//localhost:" + PORT + "/helloworld";

	
	public static void main(String[] args) throws RemoteException, MalformedURLException, AlreadyBoundException {
		
		RMIHelloWorldImpl helloService = new RMIHelloWorldImpl();
		//Start RIMRegistry service in certain port.
		LocateRegistry.createRegistry(PORT);
		
		//Bind remote object.
		Naming.bind(URL, helloService);
		
		
		System.out.println("Server is ready to hello world!");
		
	}
}
