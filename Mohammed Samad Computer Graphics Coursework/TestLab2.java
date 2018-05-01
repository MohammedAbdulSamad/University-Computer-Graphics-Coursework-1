public class TestLab2 {

    public static void main (String[]args) {
        System.out.println("CUBE:");
        try {
            GObject cube = new GObject("cube.dat");
        }
        catch (Exception e) {
            System.out.println("File Not Found");
        }
        
        System.out.println("");
        System.out.println("PYRAMID:");
        try {
            GObject cube = new GObject("pyramid.dat");
        }
        catch (Exception e) {
            System.out.println("File Not Found");
        }
    }
}