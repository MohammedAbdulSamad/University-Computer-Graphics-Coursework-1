import java.awt.*;
import java.io.IOException;

import java.io.*;

public class Scene
{
  private GObject[] obj;

  public Scene(String[] fileName)throws IOException, FileNotFoundException{
      obj = new GObject[fileName.length];
      for (int i = 0; i < obj.length; i++) {
          obj[i] = new GObject(fileName[i]);
        }
    }

  public void transform(Matrix m){
       for (int p = 0; p < obj.length; p++) {
           obj[p].transform(m);
        }
    }

  //wait until next lab for Camera
  public void draw(Camera c, Graphics g){
      for (int i = 0; i < obj.length; i++) {
          //Point3D test = c.project(obj[i]);
          Point3D[] vertices = obj[i].vertex;
          for (int k = 0; k < obj[i].face.length; k++) {
              Face theFace = obj[i].face[k];
              int faceVerticesNum = theFace.index.length; //Number of vertices in face
              int[] faceVertices = theFace.index;         //Array of vertex numbers

              int[] ArrayX = new int[faceVerticesNum];    //Array of vertex X coordinates
              int[] ArrayY = new int[faceVerticesNum];    //Array of vertex Y coordinates
              for (int j = 0; j < faceVerticesNum; j++) {
                  //Get the vertex ussing the number from the array of face vertetx numbers
                  Point3D theVertex = vertices[faceVertices[j]];
                  theVertex = c.project(theVertex); //Project the vertex
                  ArrayX[j] = (int)theVertex.x;     //Store vertex x value
                  ArrayY[j] = (int)theVertex.y;     //Store vertex y value
                }
              g.setColor(theFace.color);                   //Set the colour to face colour 
               
              //Project transform 3 vertices in each face
              Point3D p1 = c.projectionTransform(vertices[faceVertices[0]]);
              Point3D p2 = c.projectionTransform(vertices[faceVertices[1]]);
              Point3D p3 = c.projectionTransform(vertices[faceVertices[2]]);
              
              //Check if its front facing
              boolean isFrontFace = Point3D.isFrontFace(p1,p2,p3,c.getVPN());
              if (isFrontFace) {
                  g.fillPolygon(ArrayX,ArrayY,faceVerticesNum);
                }
            }
        }
    }

  public String toString(){
      return "This Scene has " + obj.length + " GObjects";
    }
}