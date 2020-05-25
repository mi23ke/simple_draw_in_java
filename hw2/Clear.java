package hw2;
import java.util.*;
import javax.swing.*;
import java.awt.*;

public class Clear extends Command {
  public void executeCommand (){
    //if a Redo object calls executeCommand, then this function is called
    //and the last removed object is added back to the shapes list
    pRepo.clearList();
  };
}
