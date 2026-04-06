
import com.mycompany.grafos.graphcomponents.Circle;
import com.mycompany.grafos.builder.CircleBuilder;
import com.mycompany.grafos.builder.ComplexCompBuilder;
import com.mycompany.grafos.builder.LineBuilder;
import com.mycompany.grafos.gui.Graph;
import com.mycompany.grafos.impl.PrinterCircleImplementation;
import com.mycompany.grafos.graphcomponents.ComplexComp;
import com.mycompany.grafos.graphcomponents.Line;
import com.mycompany.grafos.gui.PrincipalFrame;
import com.mycompany.grafos.parts.SimpleAlignment;
import com.mycompany.grafos.parts.CircleBounds;
import com.mycompany.grafos.parts.LineAlignment;
import com.mycompany.grafos.parts.LineBounds;
import com.mycompany.grafos.parts.Position;
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
public class Test005 {
    public static void main(String[] args) {
        PrinterService[] printables = new PrinterService[1];

        
        Circle c1 =         new CircleBuilder()
                        .color(Color.GRAY)
                        .alignment(new SimpleAlignment(SimpleAlignment.HorizontalAlignment.CENTER, SimpleAlignment.VerticalAlignment.CENTER))
                        .position(new Position(60, 60))
                        .bounds(new CircleBounds(100, 100))
                        .build();
        
        Circle c2 =        new CircleBuilder()
                        .color(Color.LIGHT_GRAY)
                        .alignment(new SimpleAlignment(SimpleAlignment.HorizontalAlignment.CENTER, SimpleAlignment.VerticalAlignment.CENTER))
                        .position(new Position(60, 60))
                        .bounds(new CircleBounds(90, 90))
                        .build();
        
        Line l1 =          new LineBuilder()
                .color(Color.red)
                .alignment(new LineAlignment(LineAlignment.TypeAlignment.CENTER))
                .position(new Position(60, 60))
                .offset(new Position(0, 20))
                .bounds(new LineBounds(new Position(0, 0), new Position(-75, 0)))
                .stroke(5)
                .build();
        
        System.out.println("FINAL: " + l1.getBounds().toString());
        
        printables[0] = new ComplexCompBuilder()
                .addPrinter(c1)
                .addPrinter(c2)
                .addPrinter(l1)
                .build();
        
        ((ComplexComp)printables[0]).resize(2);
        ((ComplexComp)printables[0]).setPosition(new Position(300, 300));
        
        Graph g = new Graph(printables);
        
        PrincipalFrame frame = new PrincipalFrame(g);
        frame.setUp(PrincipalFrame.SETUP_TYPES.COMPONENT_TESTER);
        
        g.setBackgroundColor(Color.WHITE);
        while(true){
            g.render();
//            ((ComplexComp)printables[0]).setPosition(new Position((int)(Math.random()*500)+100, (int)(Math.random()*500)+100));
        }
        
    }
}
