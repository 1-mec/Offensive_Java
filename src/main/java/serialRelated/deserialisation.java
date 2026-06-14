package serialRelated;

import target.classes.Personne;
import java.io.*;

public class deserialisation {

    private FileInputStream fis;
    private InputStream is;
    private ObjectInputStream ois;

    public void setOis(FileInputStream fis) {
        try {
            this.ois = new ObjectInputStream(fis);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    public void setOis(InputStream is) {
        try {
            this.ois = new ObjectInputStream(is);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void setIs(InputStream is) {
        try {
            this.is = new ObjectInputStream(is);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void setFis(String file)  {
        try {
            this.fis = new FileInputStream(file);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    public InputStream getIs() {
        return is;
    }

    public FileInputStream getFis() {
        return fis;
    }

    public ObjectInputStream getOis() {
        return ois;
    }


}
