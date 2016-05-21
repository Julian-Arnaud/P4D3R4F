package rmi.interfaces;

import java.rmi.Remote;
import java.rmi.RemoteException;

/**
 * Created by guillaume on 20/05/16.
 */

public interface ListInterface extends Remote {
    public String list() throws RemoteException;
}
