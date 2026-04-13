
import com.mycompany.grafos.simplecomponents.Circle;
import com.mycompany.grafos.builder.CircleBuilder;
import com.mycompany.grafos.builder.ComplexCompBuilder;
import com.mycompany.grafos.builder.LineBuilder;
import com.mycompany.grafos.builder.RectangleBuilder;
import com.mycompany.grafos.builder.TextBuilder;
import com.mycompany.grafos.graphcomponents.Node;
import com.mycompany.grafos.gui.GraphCanvas;
import com.mycompany.grafos.impl.PrinterCircleImplementation;
import com.mycompany.grafos.simplecomponents.ComplexComp;
import com.mycompany.grafos.simplecomponents.Line;
import com.mycompany.grafos.simplecomponents.Rectangle;
import com.mycompany.grafos.simplecomponents.Text;
import com.mycompany.grafos.gui.PrincipalFrame;
import com.mycompany.grafos.parts.SimpleAlignment;
import com.mycompany.grafos.parts.CircleBounds;
import com.mycompany.grafos.parts.LineAlignment;
import com.mycompany.grafos.parts.LineBounds;
import com.mycompany.grafos.parts.Position;
import com.mycompany.grafos.parts.RectangleBounds;
import com.mycompany.grafos.parts.TextBounds;
import java.awt.Color;
import com.mycompany.grafos.service.PrinterService;
import java.awt.BasicStroke;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author migue
 */
public class Test009 {
    public static void main(String[] args) {
        PrinterService[] printables = new PrinterService[1];
        
        Node node = new Node(new Position(0, 0));
        Node node2 = new Node(new Position(100, 0));
        
        ComplexComp nodes = new ComplexCompBuilder()
                .addPrinter(node)
                .addPrinter(node2)
                .build();
        
        printables[0] = nodes;
        
        GraphCanvas g = new GraphCanvas(printables);
        
        PrincipalFrame frame = new PrincipalFrame(g);
        frame.setUp(PrincipalFrame.SETUP_TYPES.COMPONENT_TESTER);
        
        g.setBackgroundColor(Color.WHITE);
        while(true){
            g.render();
//            ((ComplexComp)printables[0]).setPosition(new Position((int)(Math.random()*500)+100, (int)(Math.random()*500)+100));
        }
        
    }

}
