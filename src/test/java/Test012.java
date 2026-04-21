
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
public class Test012 {
    public static void main(String[] args) {
        Printable[] printables = new Printable[1];
        
        List<NodeService> nodes = new LinkedList<>(){{
            
            NodeService lastNode = null;
            
            for (int i = 0; i < 50; i++) {
                
                NodeBuilder nodeBuilder = new NodeBuilder()
                                .text("Hola")
                                .grade(1)
                                .color(new Color(180, 255, 180))
                                .position(new Position((int) (Math.random()*2000-500), (int) (Math.random()*2000-500)))
                                .radius((int) (60+Math.random()*160));
                
                if (lastNode != null) {
                    
                    RelationService relation = new RelationBuilder()
                            .lastNode(lastNode)
                            .nextNode(nodeBuilder.build())
                            .weight(1)
                            .build();
                    
                    nodeBuilder.addRelation(relation);
                }
                
                NodeService node = nodeBuilder.build();
                
                add(node);
                
                lastNode = node;
            }
            
            
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
