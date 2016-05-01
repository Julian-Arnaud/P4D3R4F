package data;

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
}
