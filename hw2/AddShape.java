package hw2;
import java.util.*;
import javax.swing.*;
import java.awt.*;

public class AddShape extends Command {
  public void executeCommand (Shapes s){
    //if a AddShape object calls executeCommand(Shape s), then this function is called
    //and a new Shape s is added to the list
    pRepo.addShape(s);
  };
}
