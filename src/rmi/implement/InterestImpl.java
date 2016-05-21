package rmi.implement;

import rmi.interfaces.InterestInterface;

import java.util.ArrayList;

import static rmi.Server.d;
import static rmi.Server.p;

/**
 * Created by guillaume on 20/05/16.
 */
public class InterestImpl implements InterestInterface{
    @Override
    public String interest(int id) {
        if (id < 0 || id >d.getLastIdeaID()){
            ArrayList<String> errors = new ArrayList<>();
            errors.add("Wrong idea id");
            return p.createResponseJoin("KO", errors);
        }
        return p.createResponseInterest("OK", new ArrayList<String>(), d.getInterested(id));
    }
}
