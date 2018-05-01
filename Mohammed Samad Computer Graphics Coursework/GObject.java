import java.util.Scanner;
import java.io.*;
import java.awt.Color;

public class GObject
{
  public Point3D[] vertex;
  public Face[] face;
  
  public GObject(Point3D[] v, Face[] f){  
      vertex = v;
      face = f;
    }
    
  public void transform(Matrix m) {
      for (int p = 0; p < vertex.length; p++) {
          Matrix targetMatrix = new Matrix();
          double Vx = vertex[p].getX();
          double Vy = vertex[p].getY();
          double Vz = vertex[p].getZ();
          targetMatrix.setTranslation(Vx,Vy,Vz);
          Matrix result = m.multiply(targetMatrix);
          vertex[p].setX(result.m[0][3]);
          vertex[p].setY(result.m[1][3]);
          vertex[p].setZ(result.m[2][3]);
        }
    }

  public GObject(String fileName) throws IOException, FileNotFoundException {
      Scanner in = new Scanner(System.in);
      Scanner inFile = new Scanner(new FileReader(fileName));
      
      int verticesNum = inFile.nextInt(); 
      Point3D[] v1 = new Point3D[verticesNum]; 
      System.out.println("Number of Vertices: " + verticesNum);
      for (int i = 0; i < verticesNum; i++) {
          double x = inFile.nextDouble();
          double y = inFile.nextDouble();
          double z = inFile.nextDouble();
          Point3D p = new Point3D(x,y,z);
          v1[i] = p;
          System.out.println(v1[i].toString() + ": Vertex " + i);
        } 
      vertex = v1;
        
      System.out.println("");  
        
      int facesNum = inFile.nextInt();
      Face[] f1 = new Face[facesNum];
      System.out.println("Number of Faces: " + facesNum);
      for (int k = 0; k < facesNum; k++) {
          int faceVerticesNum = inFile.nextInt();
          int[] index = new int[faceVerticesNum];
          System.out.println("Number of Vertices in Face " + k + ": " + faceVerticesNum);
          for (int l = 0; l < faceVerticesNum; l++) {
              int faceVertices = inFile.nextInt();
              index[l] = faceVertices; 
            }
          float red = inFile.nextFloat();
          float green = inFile.nextFloat();
          float blue = inFile.nextFloat();
          Color c = new Color(red,green,blue);
          Face f = new Face(index, c);
          f1[k] = f;
          System.out.println(f1[k].toString());
          System.out.println(""); 
        }
      face = f1;  
      inFile.close();
    }

  public String toString(){
      for (int p = 0; p < vertex.length; p++) {
          System.out.println(vertex[p].toString());
        }
      for (int k = 0; k < face.length; k++) {
          System.out.println(face[k].toString());
        }
      return "";
    }
}