package hw2;
import java.util.*;
import javax.swing.*;
import java.awt.*;

public class Clear extends Command {
  public void executeCommand (){
    //if a Clear object calls executeCommand, then this function is called
    //and the board is cleared and all shapes are removed
    pRepo.clearList();
  };
}
