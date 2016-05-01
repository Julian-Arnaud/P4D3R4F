package data;

import java.util.ArrayList;

/**
 * Created by G on 01/05/2016.
 */
public class Idea {

    private int id;
    private String description;
    private String technology;
    private ArrayList<Person> person = new ArrayList<>();

    public Idea (String description, String technology, String name, String mail, int id){
        this.description = description;
        this.technology = technology;
        person.add(new Person (name, mail));
        this.id = id;
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
}
