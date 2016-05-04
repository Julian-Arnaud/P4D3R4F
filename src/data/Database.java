package data;

import json.Parser;

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

    public void addIdea(String description, String technology, String username, String mail, String name){
        idea.add(new Idea(description, technology, username, mail, id, name));
        id++;
    }

    public String toJSON(Parser p){
        ArrayList<ArrayList<String>> tmp = new ArrayList<>();
        ArrayList<String> tmp2 = new ArrayList<>();
        for (Idea i : idea){
            tmp2.add(i.toJSON(p, ""));
            tmp.add(tmp2);
            tmp2 = new ArrayList<>();
        }
        return p.createList("projects", tmp);
    }

    public int getLastIdeaID(){return (id-1);}
}
