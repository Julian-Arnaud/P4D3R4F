package rmi.interfaces;

import java.rmi.Remote;
import java.rmi.RemoteException;

/**
 * Created by guillaume on 20/05/16.
 */
public interface JoinInterface extends Remote{
    public String join(String name, String email, int id) throws RemoteException;
}
