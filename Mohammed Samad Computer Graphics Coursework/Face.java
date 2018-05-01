import java.awt.Color;
import java.util.*;

public class Face
{
  public int[] index;
  public Color color;

  public Face(int[] i, Color c){
      index = i;
      color = c;
    }

  public String toString(){ 
      return "Indexes: " + Arrays.toString(index) + ", Color: " + color.toString();
    }
}