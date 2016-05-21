package rmi.implement;

import rmi.interfaces.JoinInterface;

import java.util.ArrayList;

import static rmi.Server.d;
import static rmi.Server.p;

/**
 * Created by guillaume on 20/05/16.
 */
public class JoinImpl implements JoinInterface {
    public String join(String name, String email, int id){
        if (id < 0 || id >d.getLastIdeaID()){
            ArrayList<String> errors = new ArrayList<>();
            errors.add("Wrong idea id");
            return p.createResponseJoin("KO", errors);
        }
        d.getIdea(id).join(name, email);
        return p.createResponseJoin("OK", new ArrayList<String>());
    }
}
