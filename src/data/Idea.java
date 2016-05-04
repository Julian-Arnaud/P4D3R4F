package data;

import json.Parser;

import java.util.ArrayList;

/**
 * Created by G on 01/05/2016.
 */
public class Idea {

    private int id;
    private String name;
    private Person author;
    private String description;
    private String technology;
    private ArrayList<Person> person = new ArrayList<>();

    public Idea (String description, String technology, String name, String mail, int id, String username){
        this.description = description;
        this.technology = technology;
        this.name = name;
        author = new Person (username, mail);
        this.id = id;
    }

    public void join(String username, String email){
        person.add(new Person(username, email));
    }

    public String getDescription() {
        return description;
    }

    public String getTechnology() {
        return technology;
    }

    public ArrayList<Person> getPerson() {
        return person;
    }

    public void interest(String name, String mail){
        person.add(new Person(name, mail));
    }

    public String toJSON(Parser p, String attribute){
        ArrayList<ArrayList<String>> tmp = new ArrayList<>();
        ArrayList<String> tmp2 = new ArrayList<>();
        tmp2.add(p.createId(id));
        tmp2.add(p.create("name",name));
        tmp2.add(p.create("description",description));
        tmp2.add(p.create("technology", technology));
        tmp2.add(author.toJSON(p, "owner"));
        tmp.add(tmp2);
        return p.createSubList(attribute, tmp);

    }
}
