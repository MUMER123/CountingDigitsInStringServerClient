import java.io.InputStreamReader;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    public static void main(String[] args) throws Exception{

        ServerSocket serverSocket = new ServerSocket(1234);
        System.out.println("Waiting for Client to Connect...");
        Socket client = serverSocket.accept();
        System.out.println("Client Connected...");

        ObjectInputStream input = new ObjectInputStream(client.getInputStream());
        Request req = (Request) input.readObject();
        Response res = new Response(CountIntegers(req.getStr()));

        ObjectOutputStream output = new ObjectOutputStream(client.getOutputStream());
        output.writeObject(res);
        output.flush();
        client.close();

    }
    public static int CountIntegers(String str){
        char[] arr = str.toCharArray();
        int digits = 0;
        for(int i=0;i<arr.length;i++){
            if(arr[i]=='0'||arr[i]=='1'||arr[i]=='2'||arr[i]=='3'||arr[i]=='4'||
                    arr[i]=='5'||arr[i]=='6'||arr[i]=='7'||arr[i]=='8'||arr[i]=='9'){
                digits++;
            }
        }
        return digits;
    }
}