package rmi.interfaces;

import java.rmi.Remote;
import java.rmi.RemoteException;
public interface AddInterface extends Remote {
    public String add(String description, String technology, String name, String mail, String username) throws RemoteException;
}
