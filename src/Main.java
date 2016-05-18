import json.ActionClientSide;
import tcp.ClientBis;
import tcp.ClientTCP;
import tcp.ServerTCP;

/**
 * @author Julian ARNAUD
 * @date 04/05/2016
 **/
public class Main {
    public static void main(String[] args) {
        ActionClientSide actionClientSide = new ActionClientSide();
        actionClientSide.start();

        ClientBis client = new ClientBis(actionClientSide.getMsg(), "10.212.103.98", 9090);

        client.send();
    }
}
