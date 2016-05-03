package json;

import data.Database;
import data.Person;

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
        Person pers = new Person(p.get("username"), p.get("mail"));
        Database d = new Database();
        d.addIdea(p.get("description"), p.get("technology"), p.get("name"), p.get("mail"), p.get("username"));
        d.addIdea(p.get("description"), p.get("technology"), p.get("name"), p.get("mail"), p.get("username"));
        System.out.println(d.toJSON(p));
    }
}
