
import com.mycompany.logicPrinter.component.simpleComponent.Circle;
import com.mycompany.logicPrinter.builder.simpleBuilder.CircleBuilder;
import com.mycompany.logicPrinter.builder.compoundBuilder.ComplexCompBuilder;
import com.mycompany.logicPrinter.builder.simpleBuilder.LineBuilder;
import com.mycompany.logicPrinter.builder.simpleBuilder.RectangleBuilder;
import com.mycompany.logicPrinter.builder.simpleBuilder.TextBuilder;
import com.mycompany.grafos.impl.NodeImplementation;
import com.mycompany.gui.GraphCanvas;
import com.mycompany.logicPrinter.impl.simpleImpl.PrinterCircleImplementation;
import com.mycompany.logicPrinter.impl.compoundImpl.ComplexCompImplementation;
import com.mycompany.logicPrinter.component.simpleComponent.Line;
import com.mycompany.logicPrinter.component.simpleComponent.Rectangle;
import com.mycompany.logicPrinter.component.simpleComponent.Text;
import com.mycompany.gui.PrincipalFrame;
import com.mycompany.logicPrinter.component.compundComponent.ComplexComp;
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
public class Test009 {
    public static void main(String[] args) {
        Printable[] printables = new Printable[1];
        
        NodeImplementation node = new NodeImplementation(new Position(0, 0), 0, 0, "", Color.BLACK, null);
        NodeImplementation node2 = new NodeImplementation(new Position(100, 0), 0, 0, "", Color.BLACK, null);
        
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
