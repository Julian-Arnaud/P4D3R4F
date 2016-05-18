package rmi;

import java.rmi.Remote;
import java.rmi.RemoteException;

/**
 * @author Alain Defrance
 */
public interface AddInterface extends Remote {
    public Integer add(String description, String technology, String name, String mail, String username) throws RemoteException;
}
