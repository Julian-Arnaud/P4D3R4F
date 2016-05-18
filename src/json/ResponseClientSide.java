package json;

import data.Person;
import data.Project;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

/**
 * @author Julian ARNAUD
 * @date 04/05/2016
 **/
public class ResponseClientSide {
    JSONObject jsonObject;
    String action;
    ArrayList<Project> projects;
    ArrayList<Person> persons;


    public ResponseClientSide(String json, String action){
        this.action = action;
        try {
            this.jsonObject = new JSONObject(json);
        } catch (JSONException e) {
            e.printStackTrace();
        }

        start(action);
    }

    public void start(String action){
        if(action.equals("add")){
            decodeAdd();
        }else if(action.equals("list")){
            decodeList();
        }else if(action.equals("join")){
            decodeJoin();
        }
        else {
            decodeInterest();
        }
    }

    public void decodeAdd(){
        try {
            if(jsonObject.getString("status").equals("OK")){
                Project project = new Project();
                project.setId(jsonObject.getInt("id"));
                project.setTechnology(jsonObject.getString("technology"));
                project.setDescription(jsonObject.getString("description"));
                project.setName(jsonObject.getString("name"));
                project.setMail(jsonObject.getString("mail"));
                project.setUsername(jsonObject.getString("mail"));
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    public void decodeList(){
        try {
            if(jsonObject.getString("status").equals("OK")){
                JSONArray arrayProjects = new JSONArray(jsonObject.getJSONArray("projects"));
                for(int i = 0; i < arrayProjects.length(); ++i){
                    JSONObject tmp = arrayProjects.getJSONObject(i);
                    Project proj = new Project();
                    proj.setId(tmp.getInt("id"));
                    proj.setDescription(tmp.getString("description"));
                    proj.setTechnology(tmp.getString("technology"));
                    proj.setName(tmp.getString("name"));

                    JSONObject owner = tmp.getJSONObject("owner");
                    proj.setUsername(owner.getString("username"));
                    proj.setMail(owner.getString("mail"));

                    projects.add(proj);
                }
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    public void decodeJoin(){
        try {
            if(!jsonObject.getString("status").equals("OK")){
                System.out.println("Erreur");
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    public void decodeInterest(){
        try {
            if(jsonObject.getString("status").equals("OK")){
                JSONArray arrayPersons = new JSONArray(jsonObject.getJSONArray("owner"));
                for(int i = 0; i < arrayPersons.length(); ++i){
                    JSONObject tmp = arrayPersons.getJSONObject(i);
                    Person pers = new Person(tmp.getString("username"), tmp.getString("mail"));
                    persons.add(pers);
                }
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }
}
