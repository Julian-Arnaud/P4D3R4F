package rmi.implement;

import rmi.interfaces.AddInterface;

import java.rmi.RemoteException;
import java.util.ArrayList;

import static rmi.Server.d;
import static rmi.Server.p;

public class AddImpl implements AddInterface {
    public String add(String description, String technology, String name, String mail, String username) throws RemoteException {
        d.addIdea(description, technology, name, mail, username);
        return p.createResponseAdd(d.getIdea(d.getLastIdeaID()), "OK", new ArrayList<String>());
    }
}
