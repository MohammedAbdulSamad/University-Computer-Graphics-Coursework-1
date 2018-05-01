import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class PerspectiveAnimator extends ParallelAnimator
{
  protected void setupCamera()
  {
    camera= new PerspectiveCamera(-5,5,-5,5);
    //Lab 7:
    ((PerspectiveCamera)camera).setupUVN(new Point3D(0,0,0), new Vector3D(0,0,1), new Vector3D(0,1,0));
    ((PerspectiveCamera)camera).setupCOP(new Point3D(0,0,3));
  }
  
  public PerspectiveAnimator()
  {
      super();
      //PerspectiveCamera newCam = (PerspectiveCamera) PerspectiveAnimator.this.camera;
      addKeyListener(new KeyListener() {
          
          public void keyPressed(KeyEvent e) {
              PerspectiveCamera newCam = (PerspectiveCamera) PerspectiveAnimator.this.camera;
              int keyCode = e.getKeyCode();
              switch (keyCode) {
                  case KeyEvent.VK_UP:
                    //newCam.cop.y = newCam.cop.y+1;
                    newCam.vrp.y = newCam.vrp.y+0.2;
                    break;
                  case KeyEvent.VK_DOWN:
                    //newCam.cop.y = newCam.cop.y-1;
                    newCam.vrp.y = newCam.vrp.y-0.2;
                    break;
                  case KeyEvent.VK_LEFT:
                    //newCam.vpn.z += 0.2;
                    //newCam.cop.x = newCam.cop.x-1;
                    newCam.vrp.x = newCam.vrp.x+0.2;
                    break;
                  case KeyEvent.VK_RIGHT:
                    newCam.vrp.x = newCam.vrp.x-0.2;
                    break;
                  case KeyEvent.VK_SPACE:
                    if (newCam.vpn.z > 0) {
                        newCam.vpn.z = -(newCam.vpn.z);
                    } else { 
                        newCam.vpn.z = newCam.vpn.z*(-1); }
                    break;
                }
              
              
              
              if (e.getKeyChar() == 'w')
              {
                  //newCam.cop.z = newCam.cop.z-1;
                  newCam.vrp.z = newCam.vrp.z-0.2;
              }
              else if (e.getKeyChar() == 's')
              {
                  //newCam.cop.z = newCam.cop.z+1;
                  newCam.vrp.z = newCam.vrp.z+0.2;
              }
              if (e.getKeyChar() == 'r')
              {
                  setupCamera();
              }
              
              System.out.println("COP: " + newCam.cop.toString()); 
              System.out.println("VPN: " + newCam.vpn.toString()); 
              System.out.println("VRP: " + newCam.vrp.toString()); 
              
            }
          public void keyReleased(KeyEvent e) { 
              /*System.out.println("COP: " + newCam.cop.toString()); 
              System.out.println("VPN: " + newCam.vpn.toString()); 
              System.out.println("VRP: " + newCam.vrp.toString()); */
            }  
          public void keyTyped(KeyEvent e) {
              System.out.println(""); 
            }  
        } );
  }

  public static void main(String[] args)
  { 
    new PerspectiveAnimator().loop();
  }
}