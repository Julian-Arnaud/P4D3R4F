package json;

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
        String ret="";
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
        return ret;
    }
}
