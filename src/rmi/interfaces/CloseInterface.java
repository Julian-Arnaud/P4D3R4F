package rmi.interfaces;

import java.net.MalformedURLException;
import java.rmi.NotBoundException;
import java.rmi.Remote;
import java.rmi.RemoteException;

/**
 * Created by guillaume on 20/05/16.
 */
public interface CloseInterface extends Remote {
    public String close() throws RemoteException, MalformedURLException, NotBoundException;
}
