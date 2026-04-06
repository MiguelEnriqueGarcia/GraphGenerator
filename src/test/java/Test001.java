
import com.mycompany.grafos.graphcomponents.Circle;
import com.mycompany.grafos.builder.CircleBuilder;
import com.mycompany.grafos.builder.ComplexCompBuilder;
import com.mycompany.grafos.gui.Graph;
import com.mycompany.grafos.impl.PrinterCircleImplementation;
import com.mycompany.grafos.graphcomponents.ComplexComp;
import com.mycompany.grafos.parts.SimpleAlignment;
import com.mycompany.grafos.parts.CircleBounds;
import com.mycompany.grafos.parts.Position;
import java.awt.Color;
import com.mycompany.grafos.service.PrinterService;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author migue
 */
public class Test001 {
    public static void main(String[] args) {
        PrinterService[] printables = new PrinterService[1];

        
        Circle c1 =         new CircleBuilder()
                        .color(Color.GREEN)
                        .alignment(new SimpleAlignment(SimpleAlignment.HorizontalAlignment.CENTER, SimpleAlignment.VerticalAlignment.CENTER))
                        .position(new Position(60, 60))
                        .bounds(new CircleBounds(100, 100))
                        .build();
        
        Circle c2 =        new CircleBuilder()
                        .alignment(new SimpleAlignment(SimpleAlignment.HorizontalAlignment.CENTER, SimpleAlignment.VerticalAlignment.CENTER))
                        .position(new Position(60, 60))
                        .bounds(new CircleBounds(80, 80))
                        .build();
        
        printables[0] = new ComplexCompBuilder().addPrinter(c1).addPrinter(c2).build();
        
        Graph g = new Graph(printables);
        while(true){
            g.render();
            ((ComplexComp)printables[0]).setPosition(new Position((int)(Math.random()*500)+100, (int)(Math.random()*500)+100));
        }
        
    }
}
