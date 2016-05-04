package json;

import org.json.JSONObject;

import java.util.Scanner;

/**
 * @author Julian ARNAUD
 * @date 04/05/2016
 **/
public class ActionClientSide {

    private String action;
    private String username;
    private String mail;
    private int id;
    private String technology;
    private String description;
    private String name;

    private String msg;

    public ActionClientSide(){
        start();
    }

    public void start(){
        System.out.println("Choisissez une action:\nadd\nlist\njoin\ninterest");
        Scanner scanner = new Scanner(System.in);
        String choice = scanner.next();
        //System.out.println(choice);
        //scanner.close();
        if(choice.equals("add")){
            add();
        }else if(choice.equals("list")){
            list();
        }else if(choice.equals("join")){
            join();
        }else if(choice.equals("interest")){
            interest();
        }else{
            start();
        }
    }

    public void add(){
        this.action = "add";
        Scanner in = new Scanner(System.in);
        System.out.println("Saisir nom du projet");
        this.name = in.next();
        System.out.println("Saisir la description du projet");
        this.description = in.next();
        System.out.println("Saisir technologie");
        this.technology = in.next();
        System.out.println("Saisir nom utilisateur");
        this.username = in.next();
        System.out.println("Saisir email");
        this.mail = in.next();

        this.msg = "{\"action\":\"ADD\", \"data\":{\"id\":\"null\", \"name\":\""+name
                +"\",\"description\":\""+description
                +"\",\"technology\":\""+technology
                +"\",\"username\":\""+username+
                "\",\"mail\":\""+mail
                +"\"}}";
        System.out.println(msg);
    }

    public void list(){
        this.action = "list";
        this.msg = "{\"action\":\"LIST\", \"data\":{}}";
    }

    public void join(){
        this.action = "join";
        Scanner in = new Scanner(System.in);
        System.out.println("Saisir nom utilisateur");
        this.username = in.next();
        System.out.println("Saisir email");
        this.mail = in.next();
        System.out.println("Saisir id projet");
        this.id = in.nextInt();

        this.msg = "{\"action\":\"JOIN\", \"data\":{\"id\":\""+id
                +"\", \"username\":\""+username
                +"\",\"mail\":\""+mail
                +"\"}}";
    }

    public void interest(){
        this.action = "interest";
        Scanner in = new Scanner(System.in);
        System.out.println("Saisir id projet");
        this.id = in.nextInt();

        this.msg = "{\"action\":\"INTEREST\",\"data\":{\"id\":\""+id+"\"}}";
    }

    public String getMsg(){
        return msg;
    }
}
