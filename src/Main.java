import json.ActionClientSide;
import tcp.ClientBis;

/**
 * @author Julian ARNAUD
 * @date 04/05/2016
 **/
public class Main {
    public static void main(String[] args) {
        ActionClientSide actionClientSide = new ActionClientSide();
        actionClientSide.start();

        ClientBis client = new ClientBis(actionClientSide.getMsg(), "10.212.119.110", 8040);

        client.send();
    }
}
