package rmi.implement;

import rmi.interfaces.CloseInterface;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

/**
 * Created by guillaume on 20/05/16.
 */
public class CloseImpl implements CloseInterface {
    public String close() throws RemoteException, MalformedURLException, NotBoundException {
        Naming.unbind("s");
        UnicastRemoteObject.unexportObject(this, true);
        System.out.println("Closing Server");
        return "{\"status\": \"OK\", \"errors\": [], \"data;\": {}";
    }
}
