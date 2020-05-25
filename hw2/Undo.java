package hw2;
import java.util.*;
import javax.swing.*;
import java.awt.*;

public class Undo extends Command {
  public void executeCommand (){
    //if a Undo object calls executeCommand, then this function is called
    //and the last added shape is removed from the list
    pRepo.popOneFromCopy();
  };
}
