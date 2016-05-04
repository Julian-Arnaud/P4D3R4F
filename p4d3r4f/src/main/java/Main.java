import json.ActionClientSide;
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

        ClientTCP client = new ClientTCP(actionClientSide.getMsg(), "127.0.0.1", 7777);

        client.send();
        client.receive();
    }
}
