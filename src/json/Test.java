package json;
import org.json.JSONException;
import org.json.JSONObject;

/**
 * Created by G on 01/05/2016.
 */
public class Test {
    public static void main(String[] Args) {
        String json =
                "{"
                        + "'title': 'Computing and Information systems',"
                        + "'id' : 1,"
                        + "'children' : 'true',"
                        + "'groups' : [{"
                        + "'title' : 'Level one CIS',"
                        + "'id' : 2,"
                        + "'children' : 'true',"
                        + "'groups' : [{"
                        + "'title' : 'Intro To Computing and Internet',"
                        + "'id' : 3,"
                        + "'children': 'false',"
                        + "'groups':[]"
                        + "}]"
                        + "}]"
                        + "}";

        try{
            JSONObject obj = new JSONObject(json);
            String id = obj.getString("id");
            System.out.println(id);
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }
}
