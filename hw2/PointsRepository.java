package hw2;
import java.util.*;
import javax.swing.*;
import java.awt.*;

public class PointsRepository {
  //2 copies of the list of shapes to help keep track
  //of the undo and redo functions; shapes will keep track of all shapes
  //that have been drawn; shapesCopy will be used to draw the shapes to support
  //redo and undo
  public static ArrayList<Shapes> shapes = new ArrayList<>();
  public static ArrayList<Shapes> shapesCopy = new ArrayList<>();
  //methods to return lists where needed
  public ArrayList<Shapes> getList(){
    return shapes;
  }
  public ArrayList<Shapes> getCopy(){
    return shapesCopy;
  }
  //adding a shape to the lists; any shape undone is lost once a new shape
  //is added, so when we add a shape, we make sure both lists match first, if
  //they don't, delete the undone shapes from the main copy, then add to both
  public void addShape(Shapes tempShape) {
    if(shapes.size() > shapesCopy.size()) {
      for(int i=shapes.size(); i>shapesCopy.size(); i--)shapes.remove(i-1);
    }
    shapes.add(tempShape);
    shapesCopy.add(tempShape);
  }
  //method to clear the lists, therefore clearing the canvas
  public void clearList(){
    shapes.clear();
    shapesCopy.clear();
  }
  //method to remove 1 shape from shapescopy to support undo; if shapesCopy has
  //any shapes in it, delete the last one
  public void popOneFromCopy() {
    if(shapesCopy.size() > 0)shapesCopy.remove(shapesCopy.size() - 1);
  }
  //method to support redo, adding undone shape back to shapesCopy list by
  //getting the size of shapesCopy and using that index to get the correct
  //shape from shapes main list
  public void addOneToCopy() {
    if(shapes.size() > shapesCopy.size()){
      int i = shapesCopy.size();
      shapesCopy.add(shapes.get(i));
    }
  }
}
