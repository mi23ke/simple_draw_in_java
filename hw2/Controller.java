package hw2;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Controller {
  //point holds location of mouse click
  Point point;
  //shape holds shape to be painted
  Shapes shape;
  //create instance of command to implement the command pattern, it will be
  //used to implement Undo, Redo, AddShape and Clear commands
  Command command = new Command();
  //create instance of PaneView that is used to update the canvas when needed
  PanelView pView = new PanelView();
  //creating custom button classes to help identify specific buttons
  //to apply correct listener adapter
  class SButton extends JButton{ public void setLabel(){setText("Square");}}
  class CButton extends JButton{ public void setLabel(){setText("Circle");}}
  class TButton extends JButton{ public void setLabel(){setText("Hello!");}}
  class RButton extends JButton{ public void setLabel(){setText("Redo");}}
  class UButton extends JButton{ public void setLabel(){setText("Undo");}}
  class ClearButton extends JButton{ public void setLabel(){setText("Clear");}}
  //created SETLISTENER methods to create the listener required
  //the type of button provided to method will determine which method to use
  //square button listener
  public void setListener(SButton sb){
    sb.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {shape = new Square();} });  }
  //circle button listener
  public void setListener(CButton cb){
    cb.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {shape = new Circle();} });  }
  //hello world button listener
  public void setListener(TButton tb){
    tb.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {shape = new Text();}  });  }
  //undo button listener
  public void setListener(UButton ub){
    ub.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
        //make command variable an undo command
        command = new Undo();
        //call executeCommand for the Undo object which will remove
        //the last painted object from the list copy
        command.executeCommand();
        //repaint the new list with last object removed
        pView.repaint();      }    });  }
  //set redo button listener
  public void setListener(RButton rb){
    rb.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
        //make command variable a redo command
        command = new Redo();
        //call executeCommand for the redo object
        command.executeCommand();
        //repaint the updated list copy
        pView.repaint();      }    });  }
  //set clear button listener
  public void setListener(ClearButton cb){
    cb.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
        //using command interface to clear the canvas
        command = new Clear();
        command.executeCommand();
        //paint updated list
        pView.repaint();      }    });  }
  //set listener for mouse event to capture point locations
  public void setListener(PanelView pv){
    pv.addMouseListener(new MouseAdapter() {
       @Override
       public void mousePressed(MouseEvent e){
         if(shape != null) {
           point = new Point(e.getX(),e.getY());
           shape.point = point;
           //using command interface to add a shape to the list
           command = new AddShape();
           command.executeCommand(shape);
           pView.repaint();
         }
         shape = null;       }    });  }

  //CreateWindow method creates all the elements of the JFRame and JPanel which
  //is used as the canvas to draw the Shapes objects; the lister adapter methods
  //are called on the respective buttons in order to implement the adapter
  //pattern;
  public void createWindow() {
    //Create frame
    JFrame.setDefaultLookAndFeelDecorated(true);
    JFrame f = new JFrame("Three Pattern Demo");
    f.setResizable(true);
    f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    pView.setBounds(200,0,500,400);
    setListener(pView);
    //creating all buttons
    JPanel buttonsPanel = new JPanel();
    buttonsPanel.setBounds(0,0,200,400);
    buttonsPanel.setLayout(null);
    buttonsPanel.setBackground(Color.gray);
    //square button
    SButton sButton = new SButton();
    sButton.setLabel();
    sButton.setBounds(50,50,100,30);
    //setting the listener for the square button
    setListener(sButton);
    //circle button
    CButton cButton = new CButton();
    cButton.setLabel();
    cButton.setBounds(50,100,100,30);
    //setting the listener for the circle button
    setListener(cButton);
    //hellow world buttton
    TButton tButton = new TButton();
    tButton.setLabel();
    tButton.setBounds(50,150,100,30);
    //setting the listener for the hello world button
    setListener(tButton);
    //undo button
    UButton uButton = new UButton();
    uButton.setLabel();
    uButton.setBounds(50,200,100,30);
    //setting the listener for the undo button
    setListener(uButton);
    //redo button
    RButton rButton = new RButton();
    rButton.setLabel();
    rButton.setBounds(50,250,100,30);
    //setting the listener for redo button
    setListener(rButton);
    //clear button
    ClearButton clearButton = new ClearButton();
    clearButton.setLabel();
    clearButton.setBounds(50,300,100,30);
    //setting the listener for the clear button
    setListener(clearButton);
    //Add buttons to panel and add panels to frame and make visible
    buttonsPanel.add(sButton); buttonsPanel.add(cButton);
    buttonsPanel.add(clearButton); buttonsPanel.add(tButton);
    buttonsPanel.add(rButton); buttonsPanel.add(uButton);
    f.add(buttonsPanel, BorderLayout.WEST);
    f.add(pView);
    f.setSize(700,400);
    f.setLayout(null);
    f.setVisible(true);
  }
}
