package rmi.interfaces;

import java.rmi.Remote;
import java.rmi.RemoteException;

/**
 * Created by guillaume on 20/05/16.
 */
public interface InterestInterface extends Remote {
    public String interest(int id) throws RemoteException;
}
