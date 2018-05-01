public class Point3D
{
  public double x,y,z;

  public Point3D(double X,double Y,double Z){
      x=X;
      y=Y;
      z=Z;
    }
    
  public Vector3D vector(Point3D p) {
      return new Vector3D(this.x-p.x, this.y-p.y, this.z-p.z);
    }
    
  public static Vector3D faceNormal(Point3D p1, Point3D p2, Point3D p3) {
      double v1X = p2.getX() - p1.getX();
      double v1Y = p2.getY() - p1.getY();
      double v1Z = p2.getZ() - p1.getZ();
      Vector3D v1 = new Vector3D(v1X, v1Y, v1Z);
      
      double v2X = p3.getX() - p1.getX();
      double v2Y = p3.getY() - p1.getY();
      double v2Z = p3.getZ() - p1.getZ();
      Vector3D v2 = new Vector3D(v2X, v2Y, v2Z);
      
      Vector3D n = v1.crossProduct(v2);
      
      return n;
    }
    
  public static boolean isFrontFace(Point3D p1, Point3D p2, Point3D p3, Vector3D vpn) {
      Vector3D n = faceNormal(p1, p2, p3);
      double result = n.dotProduct(vpn);
      if (result > 0) {
          return true;
        }
      return false;  
    }    

  public double distance(Point3D p){
      double dx = this.x - p.x;
      double dy = this.y - p.y;
      double dz = this.z - p.z;
      return Math.sqrt(dx*dx+dy*dy+dz*dz);
    }
    
  public Point3D transform(Matrix m) {
      Matrix targetMatrix = new Matrix();
      targetMatrix.setTranslation(x,y,z);
      Matrix result = m.multiply(targetMatrix);
      return new Point3D(result.m[0][3],result.m[1][3],result.m[2][3]);
    }
    
  public double getX () {
      return x;
    }
    
  public double getY () {
      return y;
    }
    
  public double getZ () {
      return z;
    }
    
  public void setX (double newX) {
      x = newX;
    }
    
  public void setY (double newY) {
      y = newY;
    }
    
  public void setZ (double newZ) {
      z = newZ;
    }

  public String toString(){
      return "[" + x + ", " + y + ", " + z + "]";
    }
}