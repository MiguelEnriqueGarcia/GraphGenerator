/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.grafos.graphcomponents;

import com.mycompany.grafos.builder.CircleBuilder;
import com.mycompany.grafos.builder.ComplexCompBuilder;
import com.mycompany.grafos.builder.LineBuilder;
import com.mycompany.grafos.builder.RectangleBuilder;
import com.mycompany.grafos.builder.TextBuilder;
import com.mycompany.grafos.parts.CircleBounds;
import com.mycompany.grafos.parts.LineAlignment;
import com.mycompany.grafos.parts.LineBounds;
import com.mycompany.grafos.parts.Position;
import com.mycompany.grafos.parts.RectangleBounds;
import com.mycompany.grafos.parts.SimpleAlignment;
import com.mycompany.grafos.parts.TextBounds;
import com.mycompany.grafos.service.Colorable;
import com.mycompany.grafos.service.FontResizable;
import com.mycompany.grafos.service.Offsetable;
import com.mycompany.grafos.service.Positionable;
import com.mycompany.grafos.service.PrinterService;
import com.mycompany.grafos.service.Resizable;
import com.mycompany.grafos.service.compoundService.NodeService;
import com.mycompany.grafos.simplecomponents.Circle;
import com.mycompany.grafos.simplecomponents.ComplexComp;
import com.mycompany.grafos.simplecomponents.Line;
import com.mycompany.grafos.simplecomponents.Rectangle;
import com.mycompany.grafos.simplecomponents.Text;
import java.awt.Color;
import java.awt.Graphics2D;
import lombok.experimental.Delegate;

/**
 *
 * @author migue
 */
public class Node implements NodeService {
    
    @Delegate
    private ComplexComp printable;
    private Position localPosition;
    private String text;
    private int grade;
    private int radius;
    private Color color;
    
    public Node(Position localPosition){
        this.localPosition = localPosition;
        
        printable = getNodePrintable(this.localPosition);
        
        
    }

    private static ComplexComp getNodePrintable(Position offset) {
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
        
        ComplexComp complex = new ComplexCompBuilder()
                .addPrinter(c1)
                .addPrinter(c2)
                .addPrinter(l1)
                .addPrinter(r)
                .addPrinter(t)
                .offset(offset)
                .build();
        
        complex.resize(2);
        complex.setPosition(new Position(300, 300));
        
        return complex;
    }
    
    @Override
    public Color getColor() {
        return color;
    }

    @Override
    public void setColor(Color color) {
        this.color = color;
    }
    
}
