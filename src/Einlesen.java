import jdk.swing.interop.SwingInterOpUtils;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class Einlesen {
    public Einlesen(String fileName) {
        fileName = "numbers.csv";
        try (BufferedReader br = new BufferedReader(new FileReader("numbers.csv"))) {
            String line;
            line = br.readLine();

            String[] parts = line.split(":");

            //List<String[]> list = new ArrayList();
            List<String> fixedLengthList = Arrays.asList(parts);

            ArrayList<String> listOfString = new ArrayList<String>(fixedLengthList);

            System.out.println("list of comma seperated String: " + listOfString);
            System.out.println("size: " + listOfString.size());
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }


        try (Stream<String> stream = Files.lines(Paths.get(fileName))) {
            //stream.forEach(System.out::println);
            String[] string = {stream.toString()};
            for (int i = 0; i < string.length; i++) {
                System.out.println(string);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
