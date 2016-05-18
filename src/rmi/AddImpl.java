package rmi;

import java.rmi.RemoteException;

import static rmi.Server.d;

/**
 * @author Alain Defrance
 */
public class AddImpl implements AddInterface {
    public Integer add(String description, String technology, String name, String mail, String username) throws RemoteException {
        d.addIdea(description, technology, name, mail, username);
        return d.getLastIdeaID();
    }
}
