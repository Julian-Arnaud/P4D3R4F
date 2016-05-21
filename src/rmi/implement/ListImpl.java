package rmi.implement;

import rmi.interfaces.ListInterface;

import java.rmi.RemoteException;
import java.util.ArrayList;

import static rmi.Server.d;
import static rmi.Server.p;

/**
 * Created by guillaume on 20/05/16.
 */
public class ListImpl implements ListInterface {
    public String list() throws RemoteException{
        return p.createResponseList("OK", d, new ArrayList<String>() );
    }
}
