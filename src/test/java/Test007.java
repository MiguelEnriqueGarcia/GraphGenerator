
import com.mycompany.logicPrinter.component.simpleComponent.Circle;
import com.mycompany.logicPrinter.builder.simpleBuilder.CircleBuilder;
import com.mycompany.logicPrinter.builder.compoundBuilder.ComplexCompBuilder;
import com.mycompany.logicPrinter.builder.simpleBuilder.LineBuilder;
import com.mycompany.logicPrinter.builder.simpleBuilder.RectangleBuilder;
import com.mycompany.logicPrinter.builder.simpleBuilder.TextBuilder;
import com.mycompany.gui.GraphCanvas;
import com.mycompany.logicPrinter.impl.simpleImpl.PrinterCircleImplementation;
import com.mycompany.logicPrinter.impl.compoundImpl.ComplexCompImplementation;
import com.mycompany.logicPrinter.component.simpleComponent.Line;
import com.mycompany.logicPrinter.component.simpleComponent.Rectangle;
import com.mycompany.logicPrinter.component.simpleComponent.Text;
import com.mycompany.gui.PrincipalFrame;
import com.mycompany.logicPrinter.part.alignment.SimpleAlignment;
import com.mycompany.logicPrinter.part.bound.CircleBounds;
import com.mycompany.logicPrinter.part.alignment.LineAlignment;
import com.mycompany.logicPrinter.part.bound.LineBounds;
import com.mycompany.logicPrinter.part.Position;
import com.mycompany.logicPrinter.part.bound.RectangleBounds;
import com.mycompany.logicPrinter.part.bound.TextBounds;
import java.awt.Color;
import java.awt.BasicStroke;
import com.mycompany.logicPrinter.model.contract.Printable;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author migue
 */
public class Test007 {
    public static void main(String[] args) {
        Printable[] printables = new Printable[1];

        
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
        
        Rectangle r =        new RectangleBuilder()
                        .color(Color.GRAY)
                        .alignment(new SimpleAlignment(SimpleAlignment.HorizontalAlignment.CENTER, SimpleAlignment.VerticalAlignment.CENTER))
                        .position(new Position(60, 60))
                        .bounds(new RectangleBounds(80, 40))
                        .build();
        
        Text t =         new TextBuilder()
                        .text("Hola Hola Hola HxxxxxxxxxxxMMxxxxxxxxxxxxxhjagskvjadvsfgsavdHola HxxxxxxxxxxxMMxxxxxxxxxxxxxhjagskvjadvsfgsavdHola HxxxxxxxxxxxMMxxxxxxxxxxxxxhjagskvjadvsfgsavdHola HxxxxxxxxxxxMMxxxxxxxxxxxxxhjagskvjadvsfgsavdHola HxxxxxxxxxxxMMxxxxxxxxxxxxxhjagskvjadvsfgsavdHola HxxxxxxxxxxxMMxxxxxxxxxxxxxhjagskvjadvsfgsavdHola HxxxxxxxxxxxMMxxxxxxxxxxxxxhjagskvjadvsfgsavdHola HxxxxxxxxxxxMMxxxxxxxxxxxxxhjagskvjadvsfgsavdHola HxxxxxxxxxxxMMxxxxxxxxxxxxxhjagskvjadvsfgsavdHola HxxxxxxxxxxxMMxxxxxxxxxxxxxhjagskvjadvsfgsavdHola HxxxxxxxxxxxMMxxxxxxxxxxxxxhjagskvjadvsfgsavdHola HxxxxxxxxxxxMMxxxxxxxxxxxxxhjagskvjadvsfgsavdHola HxxxxxxxxxxxMMxxxxxxxxxxxxxhjagskvjadvsfgsavdHola HxxxxxxxxxxxMMxxxxxxxxxxxxxhjagskvjadvsfgsavdHola HxxxxxxxxxxxMMxxxxxxxxxxxxxhjagskvjadvsfgsavdHola HxxxxxxxxxxxMMxxxxxxxxxxxxxhjagskvjadvsfgsavdHola HxxxxxxxxxxxMMxxxxxxxxxxxxxhjagskvjadvsfgsavdHola HxxxxxxxxxxxMMxxxxxxxxxxxxxhjagskvjadvsfgsavdfuvasjhdgaysuhgvfduayvsufy")
                        .color(Color.RED)
                        .alignment(new SimpleAlignment(SimpleAlignment.HorizontalAlignment.CENTER, SimpleAlignment.VerticalAlignment.CENTER))
                        .position(new Position(60, 60))
                        .bounds(new TextBounds(70, 30))
                        .build();
        
        printables[0] = new ComplexCompBuilder()
                .addPrinter(c1)
                .addPrinter(c2)
                .addPrinter(l1)
                .addPrinter(r)
                .addPrinter(t)
                .build();
        
        ((ComplexCompImplementation)printables[0]).resize(2);
        ((ComplexCompImplementation)printables[0]).setPosition(new Position(300, 300));
        
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
