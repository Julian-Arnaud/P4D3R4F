package data;

import json.Parser;

import java.util.ArrayList;

/**
 * Created by G on 01/05/2016.
 */
public class Person {

    private String name;
    private String mail;

    public Person (String name, String mail){
        this.name = name;
        this.mail = mail;
    }

    public String getName() {
        return name;
    }

    public String getMail() {
        return mail;
    }

    public String toJSON(Parser p, String attribut){
        ArrayList<ArrayList<String>> tmp = new ArrayList<>();
        ArrayList<String> tmp2 = new ArrayList<>();
        tmp2.add(p.create("name", name));
        tmp2.add(p.create("mail", mail));
        tmp.add(tmp2);
        return p.createList(attribut, tmp );
    }
}
