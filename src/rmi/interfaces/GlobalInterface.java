package rmi.interfaces;

import java.net.MalformedURLException;
import java.rmi.NotBoundException;
import java.rmi.Remote;
import java.rmi.RemoteException;

/**
 * Created by guillaume on 23/05/16.
 */
public interface GlobalInterface extends Remote {
    public String add(String description, String technology, String name, String mail, String username) throws RemoteException;
    public String interest(int id) throws RemoteException;
    public String join(String name, String email, int id) throws RemoteException;
    public String list() throws RemoteException;


}
