public class PerspectiveCamera extends Camera
{
  public Point3D cop=new Point3D(0,0,-4);      //centre of projection  
    
  public Point3D vrp = new Point3D(0,0,0);     //View Reference Point
  public Vector3D vpn = new Vector3D(0,0,1);   //View Plane Normal
  public Vector3D vuv = new Vector3D(0,1,0);   //View up Vector
  
  private Matrix m = new Matrix();              //Camera Transformation Matrix
  {m.setIdentity(); }
  
  public Vector3D getVPN(){/*return the view plan normal vector*/
      return vpn;
    }
  
  protected Point3D cameraTransform(final Point3D p) {
      /*double dX = this.cop.x-p.x;
      double dY = this.cop.y-p.y;
      double dZ = this.cop.z-p.z;
      Vector3D lineOfSight = new Vector3D(dX,dY,dZ);*/
      
      ////////////////////////////UVN////////////////////////////////////////////////////
      Vector3D lineOfSight = new Vector3D(this.vpn.x, this.vpn.y, this.vpn.z);
      double N = lineOfSight.L2norm();
      Vector3D n = new Vector3D(lineOfSight.x/N, lineOfSight.y/N, lineOfSight.z/N);
      Vector3D preU = this.vuv.crossProduct(this.vpn);
      double U = preU.L2norm();
      Vector3D u = new Vector3D(preU.x/U, preU.y/U, preU.z/U);
      Vector3D v = n.crossProduct(u);
      ///////////////////////////////////////////////////////////////////////////////////
      
      //System.out.println(u.toString());
      //System.out.println(v.toString());
      //System.out.println(n.toString());
      
      //////////////////M*R*T///////////////////////////////////////////////////////////
      Matrix T = new Matrix();
      //Matrix Pxyz = new Matrix();
      
      T.setTranslation(-vrp.x,-vrp.y,-vrp.z);   //T Matrix
      //Pxyz.setTranslation(p.x,p.y,p.z);
      
      Matrix R = new Matrix();
      
      ////R Matrix////
      R.m[0][0] = u.x;
      R.m[0][1] = u.y;
      R.m[0][2] = u.z;
      
      R.m[1][0] = v.x;
      R.m[1][1] = v.y;
      R.m[1][2] = v.z;
      
      R.m[2][0] = n.x;
      R.m[2][1] = n.y;
      R.m[2][2] = n.z;
      
      Matrix m = R.multiply(T);
      //m = m1.multiply(Pw);
      ///////////////////////////////////////////////////////////////////////////////
      
      //System.out.println(m.m[0][3]+ " " + m.m[1][3] + " " + m.m[2][3]);
     
      Point3D tPoint = p.transform(m);
      return tPoint;
    }
    
  protected Point3D projectionTransform(final Point3D p){
      double vectorDifference = this.cop.distance(vrp); //Calcualte distance between COP and VRP
      double distanceZ = this.cop.z-p.z;                //Calculate distance between vertex and COP on Z axis 
      double X = (p.x*vectorDifference)/distanceZ;
      double Y = (p.y*vectorDifference)/distanceZ;
      double Z = this.vrp.z;
      //System.out.println(X+ " " + Y + " " + Z);
      
      return new Point3D(X,Y,Z);
    }

  public PerspectiveCamera(double xmin_, double xmax_, double ymin_, double ymax_){
      super(xmin_,xmax_,ymin_,ymax_);
    }

  public void setupCOP(Point3D cop_){
      cop = cop_;
    }     

  public void setupUVN(Point3D vrp_, Vector3D vpn_, Vector3D vuv_) {
      vrp = vrp_;
      vpn = vpn_;
      vuv = vuv_;
    }
}
