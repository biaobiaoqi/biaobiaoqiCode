package biaobiaoqi.rpc.rmi;

import java.rmi.Remote;
import java.rmi.RemoteException;

/**
 * RMIHelloWorld is a interface of remote object in RMI. It extends interface Remote. </br>
 * Remote interface does nothing but marks RMIHelloWorld as a RMI interface.
 *</br><br> 
 * getHelloWorldString() can be invoked by clients in RMI environment.
 * 
 * @author biaobiaoqi
 *
 */
public interface RMIHelloWorld extends Remote {
	String getHelloWorldString (String username) throws RemoteException;
}

