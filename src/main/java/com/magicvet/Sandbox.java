package main.java.com.magicvet;


import main.java.com.magicvet.model.Cat;
import main.java.com.magicvet.model.Client;
import main.java.com.magicvet.model.Dog;

import java.io.*;
import java.util.Arrays;
import java.util.Comparator;

public class Sandbox {
    public static void main(String[] args) {
        System.out.println(new Client());

        try (BufferedWriter bufferedWriter = new BufferedWriter(
                new OutputStreamWriter(new FileOutputStream("test.txt")))) {
            bufferedWriter.write(String.valueOf(new Client()));
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }   catch (IOException e) {
            throw new RuntimeException(e);
        } {
        }
    }
}
