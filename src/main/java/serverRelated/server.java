package serverRelated;

import jakarta.xml.bind.DatatypeConverter;
import serialRelated.deserialisation;
import serialRelated.serialisation;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.security.MessageDigest;
import java.util.Scanner;
import java.util.regex.Pattern;
import java.util.regex.Matcher;

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

            d.setIs(client.getInputStream());
            ObjectInputStream ois = (ObjectInputStream) d.getIs();
            String msg = (String)ois.readObject();

            System.out.println("Message Received: " + msg);

            s.setOs(client.getOutputStream());
            ObjectOutputStream oos = (ObjectOutputStream) s.getOs();
            oos.writeObject("test " + msg);
            ois.close();
            oos.close();
            client.close();
            if(msg.equalsIgnoreCase("exit")) break;
        }

        System.out.println("Fin du serveur");
        ss.close();

    }

}
