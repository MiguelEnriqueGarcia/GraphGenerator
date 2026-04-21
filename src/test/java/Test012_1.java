
import com.mycompany.logicPrinter.component.simpleComponent.Circle;
import com.mycompany.logicPrinter.builder.simpleBuilder.CircleBuilder;
import com.mycompany.logicPrinter.builder.compoundBuilder.ComplexCompBuilder;
import com.mycompany.logicPrinter.builder.simpleBuilder.LineBuilder;
import com.mycompany.grafos.builder.NodeBuilder;
import com.mycompany.logicPrinter.builder.simpleBuilder.RectangleBuilder;
import com.mycompany.grafos.builder.RelationBuilder;
import com.mycompany.logicPrinter.builder.simpleBuilder.TextBuilder;
import com.mycompany.grafos.impl.GraphCompImplementation;
import com.mycompany.grafos.impl.NodeImplementation;
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
import com.mycompany.grafos.service.NodeService;
import com.mycompany.grafos.service.RelationService;
import java.awt.BasicStroke;
import java.util.LinkedList;
import java.util.List;
import com.mycompany.logicPrinter.model.contract.Printable;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author migue
 */
public class Test012_1 {
    public static void main(String[] args) {
        Printable[] printables = new Printable[1];
        
        List<NodeService> nodes = new LinkedList<>(){{
            
            

            NodeService node1 = new NodeBuilder()
                            .text("A")
                            .grade(1)
                            .color(new Color(180, 255, 180))
                            .position(new Position(100, 500))
                            .build();
            
            NodeService node2 = new NodeBuilder()
                            .text("B")
                            .grade(1)
                            .color(new Color(180, 255, 180))
                            .position(new Position(500, 100))
                            .build();
            
            NodeService node3 = new NodeBuilder()
                            .text("C")
                            .grade(1)
                            .color(new Color(180, 255, 180))
                            .position(new Position(700, 300))
                            .build();
            
            NodeService node4 = new NodeBuilder()
                            .text("D")
                            .grade(1)
                            .color(new Color(180, 255, 180))
                            .position(new Position(300, 700))
                            .build();


            RelationService relation1 = new RelationBuilder()
                    .lastNode(node1)
                    .nextNode(node2)
                    .weight(1)
                    .build();
            RelationService relation2 = new RelationBuilder()
                    .lastNode(node1)
                    .nextNode(node3)
                    .weight(1)
                    .build();
            RelationService relation3 = new RelationBuilder()
                    .lastNode(node1)
                    .nextNode(node4)
                    .weight(1)
                    .build();

            node1.addRelation(relation1);
            node1.addRelation(relation2);
            node1.addRelation(relation3);

            add(node1);
            add(node2);
            add(node3);
            add(node4);
            
        }};
        
        GraphCompImplementation graph = new GraphCompImplementation(nodes);
        
        
        printables[0] = graph;
        
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
