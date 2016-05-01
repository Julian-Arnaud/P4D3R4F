package data;

import java.lang.reflect.Array;
import java.util.ArrayList;

/**
 * Created by G on 01/05/2016.
 */
public class Database {

    int id = 0;
    ArrayList<Idea> idea = new ArrayList<>();

    public Database (){

    }

    public ArrayList<Idea> getIdea(){
        return idea;
    }

    public Idea getIdea(int id){
        return idea.get(id);
    }

    public ArrayList<Person> getInterested(int id){
        return getIdea(id).getPerson();
    }

    public void interest(int id, String name, String mail){
        getIdea(id).interest(name, mail);
    }

    public void addIdea(String description, String technology, String name, String mail){
        idea.add(new Idea(description, technology, name, mail, id));
        id++;
    }
}
