package serverRelated;

import serialRelated.deserialisation;
import serialRelated.serialisation;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class server {
    public static void main(String arg[]) throws Exception{
        serialisation s = new serialisation();
        deserialisation d = new deserialisation();

        ServerSocket ss = new ServerSocket(4444);
        Socket client ;

        System.out.println("Démarrage du serveur sur 127.0.0.1:4444.\r\nAttente d’une connexion...");

        while (true){
            client = ss.accept();
            System.out.println("UN client a fait erruption !");

            d.setOis(client.getInputStream());
            Object msg = d.getOis().readObject();

            System.out.println("Message Received: " + msg);

            s.setOos(client.getOutputStream());
            s.getOos().writeObject("test " + msg);
            d.getOis().close();
            s.getOos().close();
            client.close();
            if(msg.equals("exit")) break;
        }

        System.out.println("Fin du serveur");
        ss.close();

    }

}
