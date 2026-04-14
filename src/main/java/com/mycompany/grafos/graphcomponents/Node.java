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
import com.mycompany.grafos.service.compoundService.RelationService;
import com.mycompany.grafos.simplecomponents.Circle;
import com.mycompany.grafos.simplecomponents.ComplexComp;
import com.mycompany.grafos.simplecomponents.Line;
import com.mycompany.grafos.simplecomponents.Rectangle;
import com.mycompany.grafos.simplecomponents.Text;
import java.awt.Color;
import java.awt.Graphics2D;
import java.util.LinkedList;
import java.util.List;
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
    private List<RelationService> relations;

    public Node() {
        this(new Position(0, 0), 100, 1, "Autogenerado", Color.RED, null);
    }
    
    public Node(Position localPosition, int radius, int grade, String text, Color color, List<RelationService> relations){
        this.localPosition = localPosition;
        this.radius = radius;
        this.grade = grade;
        this.text = text;
        this.color = color;
        if (relations != null) {
            this.relations = relations;
        }else{
            this.relations = new LinkedList<>();
        }
        
        updatePrintable();
    }

    @Override
    public void printMyself(Graphics2D g, Position globalOffset) {
        for (RelationService relation : relations) {
            relation.printMyself(g, globalOffset);
        }
        printable.printMyself(g, globalOffset);
    }
    
    @Override
    public Position getCenter(Position globalOffset) {
        return this.localPosition;
    }
    
    private void updatePrintable(){
        printable = getNodePrintable(this.localPosition, text, radius, color);
    }
    
    @Override
    public void setRelations(List<RelationService> relations) {
        this.relations = relations;
        updatePrintable();
    }
    
    @Override
    public void addRelations(List<RelationService> relations){
        relations.forEach(relation -> {
            this.relations.add(relation);
        });
        updatePrintable();
    }
    
    @Override
    public void addRelation(RelationService relation){
        relations.add(relation);
        updatePrintable();
    }
    
    @Override
    public List<RelationService> getRelations() {
        return relations;
    }

    private static ComplexComp getNodePrintable(Position offset, String text, int radius, Color color) {
        Circle c1 =         new CircleBuilder()
                        .color(Color.GRAY)
                        .alignment(new SimpleAlignment(SimpleAlignment.HorizontalAlignment.CENTER, SimpleAlignment.VerticalAlignment.CENTER))
                        .bounds(new CircleBounds(radius, radius))
                        .build();
        
        Circle c2 =        new CircleBuilder()
                        .color(color)
                        .alignment(new SimpleAlignment(SimpleAlignment.HorizontalAlignment.CENTER, SimpleAlignment.VerticalAlignment.CENTER))
                        .bounds(new CircleBounds(radius - (int)(radius*0.1), radius - (int)(radius*0.1)))
                        .build();

        
//        Rectangle r =        new RectangleBuilder()
//                        .color(color)
//                        .alignment(new SimpleAlignment(SimpleAlignment.HorizontalAlignment.CENTER, SimpleAlignment.VerticalAlignment.CENTER))
//                        .bounds(new RectangleBounds((int) (radius*0.80), (int) (radius*0.4)))
//                        .build();
        
        Text t =         new TextBuilder()
                        .text(text)
                        .color(Color.RED)
                        .alignment(new SimpleAlignment(SimpleAlignment.HorizontalAlignment.CENTER, SimpleAlignment.VerticalAlignment.CENTER))
                        .bounds(new TextBounds((int) (radius*0.70), (int) (radius*0.30)))
                        .build();
        
        ComplexComp complex = new ComplexCompBuilder()
                .addPrinter(c1)
                .addPrinter(c2)
//                .addPrinter(r)
                .addPrinter(t)
                .offset(offset)
                .build();
        
        complex.resize(2);
        complex.setPosition(new Position(0, 0));
        
        return complex;
    }
    
    @Override
    public Color getColor() {
        return color;
    }

    @Override
    public void setColor(Color color) {
        this.color = color;
        updatePrintable();
    }

    @Override
    public void setText(String text) {
        this.text = text;
        
        updatePrintable();
    }

    @Override
    public void setGrade(int grade) {
        this.grade = grade;
        
        updatePrintable();
    }

    @Override
    public void setRadius(int radius) {
        this.radius = radius;
        
        updatePrintable();
    }

    @Override
    public void setPosition(Position position) {
        this.localPosition = position;
    }
    
}
