public class TestLab3 {

    public static void main (String[]args) {
        Point3D p1 = new Point3D(3,1,6);
        Matrix m = new Matrix();
        //m.setTranslation(3,1,6);
        System.out.println(p1.transform(m));
    }
}