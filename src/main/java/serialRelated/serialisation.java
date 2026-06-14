package serialRelated;

import target.classes.Personne;

import java.io.*;

public class serialisation {
    private FileOutputStream fos;
    private ObjectOutputStream oos;
    private OutputStream os;

    public void setOos(FileOutputStream fos) {
        try {
            this.oos = new ObjectOutputStream(fos);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    public void setOos(OutputStream fos) {
        try {
            this.oos = new ObjectOutputStream(fos);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void setFos(String file)  {
        try {
            this.fos = new FileOutputStream(file);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    public void setOs(OutputStream os)  {
        try {
            this.os = new ObjectOutputStream(os);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public OutputStream getOs() {
        return os;
    }

    public FileOutputStream getFos() {
        return fos;
    }

    public ObjectOutputStream getOos() {
        return oos;
    }

}
