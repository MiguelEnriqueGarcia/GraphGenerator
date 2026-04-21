
import com.mycompany.logicPrinter.component.simpleComponent.Circle;
import com.mycompany.logicPrinter.builder.simpleBuilder.CircleBuilder;
import com.mycompany.gui.GraphCanvas;
import com.mycompany.logicPrinter.impl.simpleImpl.PrinterCircleImplementation;
import com.mycompany.logicPrinter.part.alignment.SimpleAlignment;
import com.mycompany.logicPrinter.part.bound.CircleBounds;
import com.mycompany.logicPrinter.part.Position;
import java.awt.Color;
import com.mycompany.logicPrinter.model.service.simpleService.CircleService;
import com.mycompany.logicPrinter.model.contract.Printable;

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
        Printable[] printables = new Printable[2];

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
