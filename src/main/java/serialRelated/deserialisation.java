package serialRelated;

import java.io.*;

public class deserialisation {

    private FileInputStream fis;
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

    public void setFis(String file)  {
        try {
            this.fis = new FileInputStream(file);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    public FileInputStream getFis() {
        return fis;
    }

    public ObjectInputStream getOis() {
        return ois;
    }


}
