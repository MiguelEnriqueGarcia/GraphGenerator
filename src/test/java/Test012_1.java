
import com.mycompany.grafos.simplecomponents.Circle;
import com.mycompany.grafos.builder.CircleBuilder;
import com.mycompany.grafos.builder.ComplexCompBuilder;
import com.mycompany.grafos.builder.LineBuilder;
import com.mycompany.grafos.builder.NodeBuilder;
import com.mycompany.grafos.builder.RectangleBuilder;
import com.mycompany.grafos.builder.RelationBuilder;
import com.mycompany.grafos.builder.TextBuilder;
import com.mycompany.grafos.graphcomponents.GraphComp;
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
import com.mycompany.grafos.service.compoundService.NodeService;
import com.mycompany.grafos.service.compoundService.RelationService;
import java.awt.BasicStroke;
import java.util.LinkedList;
import java.util.List;

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
        PrinterService[] printables = new PrinterService[1];
        
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
        
        GraphComp graph = new GraphComp(nodes);
        
        
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
