package target.classes;

import serialRelated.deserialisation;
import serialRelated.serialisation;

import java.io.IOException;

public class TestSerialisations {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        deserialisation d = new deserialisation();
        serialisation s = new serialisation();
        Personne p1 = new Personne("Jean-Paul","Sartre",82);
        Personne p2 = new Personne("Alphonse","Lamartine",78);

        System.out.println("-> " + p1);
        System.out.println("-> " + p2);

        s.setFos("payload.ser");
        s.setOos(s.getFos());
        s.getOos().writeObject(p1);
        s.getOos().writeObject(p2);
        s.getOos().close();

        d.setFis("payload.ser");
        d.setOis(d.getFis());
        Personne p = (Personne)d.getOis().readObject();
        System.out.println("-> " + p);
        Personne pbis= (Personne)d.getOis().readObject();
        System.out.println("-> " + pbis);
        d.getOis().close();
    }
}
