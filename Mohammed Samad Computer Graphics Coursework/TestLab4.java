import java.io.*;

public class TestLab4 {
   
    public static void main (String[]args) throws IOException, FileNotFoundException {
        String[] fileName = new String[2];
        fileName[0] = "cube.dat";
        fileName[1] = "pyramid.dat";
        Scene scene1 = new Scene(fileName); //}
        System.out.println(scene1.toString());
    }
}