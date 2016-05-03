package json;

import data.Database;
import data.Idea;
import data.Person;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

/**
 * Created by FILIOL DE RAIMOND-MICHEL Guillaume on 02/05/2016.
 *
 * @author FILIOL DE RAIMOND-MICHEL Guillaume
 */
public class Parser {

    JSONObject JSON;

    public Parser(String JSON){
        try {
            this.JSON = new JSONObject(JSON);
        }catch (JSONException ignored){}
    }

    public String getAction(){
        try {
            return JSON.getString("action");
        }catch (JSONException ignored){}
        return "";
    }
    public String getData(){
        try {
            return JSON.getString("data");
        }catch (JSONException ignored){}
        return "";
    }

    public String getId(){
        try {
            return JSON.getJSONObject("data").getString("id");
        }catch (JSONException ignored){}
        return "";
    }
    public String get(String toGet){
        try{
            return JSON.getJSONObject("data").getString(toGet);
        }catch (JSONException ignored){}
        return "";
    }

    public String createId(int id){
        return "\"id\": "+String.valueOf(id);
    }

    public String create(String toCreate, String content){
        return "\""+toCreate+"\": "+"\""+content+"\"";
    }

    public String createList(String toCreate, ArrayList<ArrayList<String>> content){
        String ret;
        if (toCreate.length() ==0){
            ret = "[";
        }else {

            ret = "\"" + toCreate + "\": [";
        }
        for (int i= 0;i<content.size(); i++){
            if (i!=0){
                ret += ",{";
            }else {
                ret += "{";
            }
            for (int j = 0; j<content.get(i).size(); j++){
                if (j!=0){
                    ret+=","+content.get(i).get(j);
                }else{
                    ret+=content.get(i).get(j);
                }
            }
            ret+="}";
        }
        ret+="]";
        return ret;
    }
    public String createSubList(String toCreate, ArrayList<ArrayList<String>> content){
        String ret = "";
        if (toCreate.length() !=0){
            ret = "\"" + toCreate + "\": {";
        }
        for (int i= 0;i<content.size(); i++){
            if (i!=0) {
                ret += ",";
            }
            for (int j = 0; j<content.get(i).size(); j++){
                if (j!=0){
                    ret+=","+content.get(i).get(j);
                }else{
                    ret+=content.get(i).get(j);
                }
            }
        }
        if (toCreate.length() != 0) ret+="}";
        return ret;
    }

    public String createData(Database d){
        return "\"data\": {"+d.toJSON(this)+"}";
    }

    public String createStatus(String status){
        return "\"status: \""+status+"\",";
    }

    public String createError(ArrayList<String> error){
        ArrayList<ArrayList <String>> tmp = new ArrayList<>();
        ArrayList<String> tmp2 = new ArrayList<>();
        for (String s : error){
            tmp2.add(create("message", s));
            tmp.add(tmp2);
            tmp2 = new ArrayList<>();
        }
        return createList("errors", tmp)+",";
    }

    public String createPeople(ArrayList<Person> persons){
        ArrayList<ArrayList <String>> tmp = new ArrayList<>();
        ArrayList<String> tmp2 = new ArrayList<>();
        for (Person p : persons){
            tmp2.add(p.toJSON(this, ""));
            tmp.add(tmp2);
            tmp2 = new ArrayList<>();
        }
        return createList("people", tmp);
    }

    public String createResponseInterest(String status, ArrayList<String> errors, ArrayList<Person> persons){
        String ret = "{";
        ret+=createStatus(status);
        ret+=createError(errors);
        ret+="\"data\": {"+createPeople(persons)+"}";
        ret+="}";
        return ret;
    }
    public String createResponseJoin(String status, ArrayList<String> errors){
        String ret = "{";
        ret+=createStatus(status);
        ret+=createError(errors);
        ret+="\"data\": {}";
        ret+="}";
        return ret;
    }

    public String createResponseAdd(Idea i, String status, ArrayList<String> errors){
        String ret = "{";
        ret+=createStatus(status);
        ret+=createError(errors);
        ret+="\"data\": {"+i.toJSON(this, "project")+"}";
        ret+="}";
        return ret;
    }

    String createResponseList(String status, Database d, ArrayList<String> errors){
        String ret = "{";
        ret+=createStatus(status);
        ret+=createError(errors);
        ret+="\"data\": {"+d.toJSON(this)+"}";
        ret+="}";
        return ret;
    }
}
