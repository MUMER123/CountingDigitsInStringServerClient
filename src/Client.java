import java.io.BufferedOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

public class Client {
    public static void main(String[] args)throws Exception{

        Socket client = new Socket("localhost",1234);

        String str = "Hi! I am 20 Years OLD.";
        Request req = new Request(str);

        ObjectOutputStream output = new ObjectOutputStream(client.getOutputStream());
        output.writeObject(req);
        output.flush();

        ObjectInputStream input = new ObjectInputStream(client.getInputStream());
        Response res = (Response) input.readObject();

        System.out.println("Number of Digits in the String: "+res.getCount());
        client.close();
    }
}
