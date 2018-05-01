public class Camera
{
  public Vector3D getVPN(){
      return new Vector3D(0,0,1);
    }

  protected Point3D cameraTransform(final Point3D p){
      return p;
    }

  protected Point3D projectionTransform(final Point3D p){
      return p;
    } 

  private final Point3D viewportTransform(final Point3D p){
      double x = ax+bx*p.x;
      double y = ay+by*p.y;
      return new Point3D(x,y,0);
    }

  public final Point3D project(final Point3D p){
    Point3D temp=cameraTransform(p);
    temp=projectionTransform(temp);
    return viewportTransform(temp);
  }

  public Camera(double xmin_, double xmax_, double ymin_, double ymax_){
      xmin = xmin_;
      xmax = xmax_;
      ymin = ymin_;
      ymax = ymax_;
    }

  public void setViewport(int width, int height){
      double dWx = this.xmax-this.xmin;
      double dWy = this.ymax-this.ymin;
      
      bx = ((double)width)/dWx;
      by = ((double)height)/dWy;
      //ax = width - bx*this.xmin;
      ax = 0 - (bx*this.xmin);
      //ay = height - by*this.ymin;
      ay = 0 - (by*this.ymin);
    }

  public String toString(){
      return "Camera set up with xMin = " + xmin + ", xMax = " + xmax 
      + ", yMin = " + ymin + ", yMax = " + ymax;
    }

  private double xmin, xmax, ymin, ymax;
  private double fcp, bcp;  //NOT USED: front & back clippling planes
  private double ax, bx, ay, by;
}