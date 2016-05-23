package rmi.implement;

import rmi.interfaces.GlobalInterface;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;

import static rmi.Server.d;
import static rmi.Server.p;

/**
 * Created by guillaume on 23/05/16.
 */
public class GlobaImpl implements GlobalInterface{
    public String add(String description, String technology, String name, String mail, String username) throws RemoteException {
        d.addIdea(description, technology, name, mail, username);
        return p.createResponseAdd(d.getIdea(d.getLastIdeaID()), "OK", new ArrayList<String>());
    }
    public String interest(int id) {
        if (id < 0 || id >d.getLastIdeaID()){
            ArrayList<String> errors = new ArrayList<>();
            errors.add("Wrong idea id");
            return p.createResponseJoin("KO", errors);
        }
        return p.createResponseInterest("OK", new ArrayList<String>(), d.getInterested(id));
    }
    public String join(String name, String email, int id){
        if (id < 0 || id >d.getLastIdeaID()){
            ArrayList<String> errors = new ArrayList<>();
            errors.add("Wrong idea id");
            return p.createResponseJoin("KO", errors);
        }
        d.getIdea(id).join(name, email);
        return p.createResponseJoin("OK", new ArrayList<String>());
    }
    public String list() throws RemoteException{
        return p.createResponseList("OK", d, new ArrayList<String>() );
    }
}
