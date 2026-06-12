package serverRelated;

import serialRelated.deserialisation;
import serialRelated.serialisation;

import java.io.*;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;

public class client {
    public static void main(String args[]) throws IOException, ClassNotFoundException, InterruptedException {
        serialisation s = new serialisation();
        deserialisation d = new deserialisation();
        InetAddress addr = InetAddress.getLocalHost();
        Socket socket;
        int i = 0;
        for(;i <= 11; i++){
            socket = new Socket(addr.getHostName(),4444);
            s.setOs(socket.getOutputStream());
            ObjectOutputStream oos = (ObjectOutputStream) s.getOs();
            System.out.println("Requête envoyée");
            if (i == 10){
                oos.writeObject("exit");
            } else {
                oos.writeObject("test "+i);
            }
            d.setIs(socket.getInputStream());
            ObjectInputStream ois = (ObjectInputStream) d.getIs();
            String msg = (String)ois.readObject();
            System.out.println("Message = "+msg);
            ois.close();
            oos.close();
            Thread.sleep(100);
        }


    }
}
