package scribble3;

import java.awt.*; 

import scribble3.*;
import scribble3.Shape;
import draw1.*;

/**
 * EraseTool class adds a tool to be used on the DrawingPad to allow the indication of strokes being removed 
 * from the canvas. It extends the ScribbleTool class from package scribble3 from the textbook
 * "Object Oriented Software Development Using Java" by Xiaoping Jia, from Chapter 9
 */
public class EraserTool extends ScribbleTool {

  public EraserTool(ScribbleCanvas canvas, String name) {
      super(canvas, name);
    }

    public void startShape(Point p) {

     canvas.setCurColor(Color.WHITE);
      super.startShape(p);
    }
     
    public void addPointToShape(Point p) {
      super.addPointToShape(p);
    } 
    
    public void endShape(Point p) {
      super.endShape(p);
    }
    
}
