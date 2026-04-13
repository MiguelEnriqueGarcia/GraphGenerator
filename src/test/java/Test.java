
import com.mycompany.grafos.simplecomponents.Circle;
import com.mycompany.grafos.builder.CircleBuilder;
import com.mycompany.grafos.gui.GraphCanvas;
import com.mycompany.grafos.impl.PrinterCircleImplementation;
import com.mycompany.grafos.parts.SimpleAlignment;
import com.mycompany.grafos.parts.CircleBounds;
import com.mycompany.grafos.parts.Position;
import java.awt.Color;
import com.mycompany.grafos.service.PrinterService;
import com.mycompany.grafos.service.compoundService.CircleService;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author migue
 */
public class Test {
    public static void main(String[] args) {
        PrinterService[] printables = new PrinterService[2];

        printables[0] = 
                new CircleBuilder()
                        .color(Color.GREEN)
                        .alignment(new SimpleAlignment(SimpleAlignment.HorizontalAlignment.CENTER, SimpleAlignment.VerticalAlignment.CENTER))
                        .position(new Position(60, 60))
                        .bounds(new CircleBounds(60, 60))
                        .build();
        
        printables[1] = 
                new CircleBuilder()
                        .alignment(new SimpleAlignment(SimpleAlignment.HorizontalAlignment.CENTER, SimpleAlignment.VerticalAlignment.CENTER))
                        .position(new Position(60, 60))
                        .bounds(new CircleBounds(30, 30))
                        .build();
        
        GraphCanvas g = new GraphCanvas(printables);
        while(true){
            g.render();
        }
    }
}
