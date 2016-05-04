package tcp;

/**
 * Created by guillaume on 04/05/16.
 */
import java.io.*;
import java.net.Socket;
import java.net.UnknownHostException;

public class Client
{
    private static int    _port;
    private static Socket _socket;

    public static void main(String[] args)
    {
        String message      = "ping";
        InputStream input   = null;

        try
        {
            _port   = (args.length == 1) ? Integer.parseInt(args[0]) : 8080;
            _socket = new Socket((String) null, _port);

            ObjectOutputStream out = new ObjectOutputStream(_socket.getOutputStream());
            out.write("hello".getBytes());

            // Open stream
            input = _socket.getInputStream();

            // Show the server response
            String response = new BufferedReader(new InputStreamReader(input)).readLine();
            System.out.println("Server message: " + response);
        }
        catch (UnknownHostException e)
        {
            e.printStackTrace();
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
        finally
        {
            try
            {
                input.close();
                _socket.close();
            }
            catch (IOException e)
            {
                e.printStackTrace();
            }
        }
    }
}