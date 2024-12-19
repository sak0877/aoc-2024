import java.io.*;
import java.util.*;

public class ReadInput {
    public static ArrayList<String> getInputList(String filename) {
        ArrayList<String> list = new ArrayList<>();
        File file = new File(filename);
        try {
            Scanner scanner = new Scanner(file);
            while (scanner.hasNext()) {
                list.add(scanner.next());
            }
        } catch (FileNotFoundException e) {
            System.err.println(e);
        }
        return list;
    }
}
