package json;

import data.Person;
import data.Project;
import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;

/**
 * @author Julian ARNAUD
 * @date 04/05/2016
 **/
public class ResponseClientSide {
    JSONObject jsonObject;
    ArrayList<Project> projects;
    ArrayList<Person> persons;


    public ResponseClientSide(String json){
        this.jsonObject = new JSONObject(json);
    }

    public void decodeAdd(){
        if(jsonObject.getString("status").equals("OK")){
            Project project = new Project();
            project.setId(jsonObject.getInt("id"));
            project.setTechnology(jsonObject.getString("technology"));
            project.setDescription(jsonObject.getString("description"));
            project.setName(jsonObject.getString("name"));
            project.setMail(jsonObject.getString("mail"));
            project.setUsername(jsonObject.getString("mail"));
        }
    }

    public void decodeList(){
        if(jsonObject.getString("status").equals("OK")){
            JSONArray arrayProjects = new JSONArray(jsonObject.getJSONArray("projects"));
            for(int i = 0; i < arrayProjects.length(); ++i){
                JSONObject tmp = arrayProjects.getJSONObject(i);
                Project proj = new Project();
                proj.setId(tmp.getInt("id"));
                proj.setDescription(tmp.getString("description"));
                proj.setTechnology(tmp.getString("technology"));
                proj.setUsername(tmp.getString("username"));
                proj.setMail(tmp.getString("mail"));
                proj.setName(tmp.getString("name"));

                projects.add(proj);
            }
        }
    }

    public void decodeJoin(){
        if(!jsonObject.getString("status").equals("OK")){
            System.out.println("Erreur");
        }
    }

    public void decodeInterest(){
        if(jsonObject.getString("status").equals("OK")){
            JSONArray arrayPersons = new JSONArray(jsonObject.getJSONArray("people"));
            for(int i = 0; i < arrayPersons.length(); ++i){
                JSONObject tmp = arrayPersons.getJSONObject(i);
                Person pers = new Person(tmp.getString("username"), tmp.getString("mail"));
                persons.add(pers);
            }
        }
    }
}
