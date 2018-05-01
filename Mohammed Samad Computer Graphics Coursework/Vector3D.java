import static java.lang.Math.*;  /* Now you can use math functions without the Math. prefix */

public class Vector3D implements Cloneable     
{
  public double x,y,z;
  
  public Vector3D(double X, double Y, double Z){
      x=X;
      y=Y;
      z=Z;
    }

  public String toString(){
      return "Vector = [" + x + ", " + y + ", " + z + "]";
    }    

  public Vector3D transform(Matrix m){
      Matrix targetMatrix = new Matrix();
      targetMatrix.setTranslation(x,y,z);
      Matrix result = m.multiply(targetMatrix);
      x=result.m[0][3];
      y=result.m[1][3];
      z=result.m[2][3];
      return this;
    }

  public double L2norm(){
      return Math.sqrt(x*x+y*y+z*z);
    }

  public double dotProduct(Vector3D v){
      double x3 = this.x*v.x;
      double y3 = this.y*v.y;
      double z3 = this.z*v.z;
      return x3+y3+z3;
    }

  public Vector3D crossProduct(Vector3D v){
      double x4 = this.y*v.z-this.z*v.y;
      double y4 = this.z*v.x-this.x*v.z;
      double z4 = this.x*v.y-this.y*v.x;
      Vector3D v1 = new Vector3D(x4,y4,z4);
      return v1;
    }

  public void normalize(){
      this.x = x/this.L2norm();
      this.y = y/this.L2norm();
      this.z = z/this.L2norm();
    } 
}