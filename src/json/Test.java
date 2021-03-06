package json;

import data.Database;
import data.Person;

import java.util.ArrayList;

/**
 * Created by G on 01/05/2016.
 */
public class Test {
    public static void main(String[] Args) {
        int id = 0;

        String json =
                "{"+
                        "\"action\": \"ADD\","+
                "\"data\": {"+
            "\"id\": null,"+
                    "\"name\": \"Idea 1\","+
                        "\"description\": \"Text description...\","+
                        "\"technology\": \"Java\","+
                        "\"username\": \"John DOE\","+
                        "\"mail\": \"test@test.com\""+
        "}"+
        "}";

        Parser p= new Parser(json);
        ArrayList<String> error = new ArrayList<>();
        ArrayList<Person> pList = new ArrayList<>();
        pList.add(new Person("test1", "mail1"));
        pList.add(new Person("test2", "mail2"));
        pList.add(new Person("test3", "mail3"));
        Person pers = new Person(p.get("username"), p.get("mail"));
        Database d = new Database();
        d.addIdea(p.get("description"), p.get("technology"), p.get("name"), p.get("mail"), p.get("username"));
        d.addIdea(p.get("description"), p.get("technology"), p.get("name"), p.get("mail"), p.get("username"));
        System.out.println(p.createResponseInterest("OK", error, pList));
        System.out.println(p.createResponseJoin("OK", error));
        System.out.println(p.createResponseAdd(d.getIdea(0),"OK", error));
        System.out.println(p.createResponseList("OK",d, error));
    }
}
