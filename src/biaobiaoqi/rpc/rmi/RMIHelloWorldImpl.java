package biaobiaoqi.rpc.rmi;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

/**
 * Remote Object Implementation.<br>
 * Clients should know the interface, instead of implementation.<br><br>
 * RMI Server side will bind this remote object to RMI Registry.
 * 
 * @author biaobiaoqi
 *
 */
@SuppressWarnings("serial")
public class RMIHelloWorldImpl extends UnicastRemoteObject implements
		RMIHelloWorld {

	//Default constructor cannot handle exception type RemoteException thrown by implicit super constructor.
	//Must define an explicit constructor
	protected RMIHelloWorldImpl() throws RemoteException {
		super();
	}

	
	@Override
	public String getHelloWorldString(String username) throws RemoteException {
		
		return username + ", Hello world!";
	}
	
}


