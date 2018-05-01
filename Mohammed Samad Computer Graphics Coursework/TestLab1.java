public class TestLab1 {

    public static void main (String[]args) {
        Point3D p1 = new Point3D(2,3,4);
        Point3D p2 = new Point3D(4,6,8);
        
        double distance = p1.distance(p2);
        
        System.out.println("p1 -> " + p1.toString());
        System.out.println("p2 -> " + p2.toString());
        System.out.println("Distance = " + distance);
        
        Vector3D v1 = new Vector3D(2,3,4);
        Vector3D v2 = new Vector3D(4,6,8);
        Vector3D v3 = new Vector3D(8,12,16);
        
        double L2norm = v1.L2norm();
        double DotProduct = v1.dotProduct(v2);
        Vector3D v4 = v2.crossProduct(v3);
        
        System.out.println("v1 -> " + v1.toString());
        System.out.println("v2 -> " + v2.toString());
        System.out.println("v3 -> " + v3.toString());
        
        System.out.println("L2 Norm of v1 = " + L2norm);
        System.out.println("Dot Product of v1 and v2 = " + DotProduct);
        System.out.println("Cross Product of v2 and v3 gives = " + v4.toString());
        
        v1.normalize();
        System.out.println("Vector v1 is now normalized = " + v1.toString());
    }
}