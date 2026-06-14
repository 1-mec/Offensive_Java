package serialRelated;

import java.io.*;

public class serialisation {
    private FileOutputStream fos;
    private ObjectOutputStream oos;

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

    public FileOutputStream getFos() {
        return fos;
    }

    public ObjectOutputStream getOos() {
        return oos;
    }

}
