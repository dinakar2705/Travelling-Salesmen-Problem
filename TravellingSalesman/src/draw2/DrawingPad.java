 package draw2;
import java.awt.Dimension;

import javax.swing.JFrame;

import scribble3.EraserTool;
import scribble3.ScribbleTool;
import draw1.CircleShape;
import draw1.DiamondShape;
import draw1.LineShape;
import draw1.OvalShape;
import draw1.RectangleShape;
import draw1.RoundRectangleShape;
import draw1.ToolKit;

public class DrawingPad extends draw1.DrawingPad {
  public DrawingPad(String title) {
    super(title);
  }
  protected void initTools() {
    
    toolkit = new ToolKit();
    toolkit.addTool(new ScribbleTool(canvas, "Scribble"));
    toolkit.addTool(new TwoEndsShapeTool(canvas, "Line", new LineShape()));
    toolkit.addTool(new TwoEndsShapeTool(canvas, "Oval", new OvalShape()));
    toolkit.addTool(new TwoEndsShapeTool(canvas, "Filled Oval", new FilledOvalShape()));
    toolkit.addTool(new TwoEndsShapeTool(canvas, "Rectangle", new RectangleShape()));
    toolkit.addTool(new TwoEndsShapeTool(canvas, "Filled Rectangle", new FilledRectangleShape()));
    toolkit.addTool(new TwoEndsShapeTool(canvas, "Circle", new CircleShape()));
    toolkit.addTool(new TwoEndsShapeTool(canvas, "Filled Circle", new FilledCircleShape())); 
    toolkit.addTool(new TwoEndsShapeTool(canvas, "Round Rectangle", new RoundRectangleShape()));
    toolkit.addTool(new TwoEndsShapeTool(canvas, "Filled Round Rect", new FilledRoundRectangleShape()));
    toolkit.addTool(new TwoEndsShapeTool(canvas, "Undo", new FilledDiamondShape()));
    toolkit.addTool(new TwoEndsShapeTool(canvas, "Eraser", new FilledDiamondShape()));
    toolkit.addTool(new TwoEndsShapeTool(canvas, "Area Eraser", new FilledDiamondShape()));
    
    drawingCanvas.setTool(toolkit.getTool(0));
  }
  
  public static void main(String[] args) {
    
    int width = 500;
    int height = 600;
    JFrame frame = new draw2.DrawingPad("Drawing Pad");
    frame.setSize(width, height);
    Dimension screenSize = java.awt.Toolkit.
        getDefaultToolkit().getScreenSize();
  
    frame.setLocation(screenSize.width/2 - width/2, 
          screenSize.height/2 - height/2);
    frame.setVisible(true);
  }
}