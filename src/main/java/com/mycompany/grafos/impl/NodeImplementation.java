/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.grafos.impl;

import com.mycompany.logicPrinter.builder.simpleBuilder.CircleBuilder;
import com.mycompany.logicPrinter.builder.compoundBuilder.ComplexCompBuilder;
import com.mycompany.logicPrinter.builder.simpleBuilder.TextBuilder;
import com.mycompany.logicPrinter.part.bound.CircleBounds;
import com.mycompany.logicPrinter.part.Position;
import com.mycompany.logicPrinter.part.alignment.SimpleAlignment;
import com.mycompany.logicPrinter.part.bound.TextBounds;
import com.mycompany.grafos.service.NodeService;
import com.mycompany.grafos.service.RelationService;
import com.mycompany.logicPrinter.component.compundComponent.ComplexComp;
import com.mycompany.logicPrinter.component.simpleComponent.Circle;
import com.mycompany.logicPrinter.component.simpleComponent.Text;
import com.mycompany.logicPrinter.model.service.compoundService.ComplexCompService;
import java.awt.Color;
import java.util.LinkedList;
import java.util.List;
import lombok.experimental.Delegate;

/**
 *
 * @author migue
 */
public class NodeImplementation implements NodeService {
    
    @Delegate
    private ComplexCompService printable;
    private Position localPosition;
    private String text;
    private int grade;
    private int radius;
    private Color color;
    private List<RelationService> relations;

    public NodeImplementation() {
        this(new Position(0, 0), 100, 1, "Autogenerado", Color.RED, null);
    }
    
    public NodeImplementation(Position localPosition, int radius, int grade, String text, Color color, List<RelationService> relations){
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
    public void printMyself(Position globalOffset) {
        for (RelationService relation : relations) {
            relation.printMyself(globalOffset);
        }
        printable.printMyself(globalOffset);
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

    private static ComplexCompService getNodePrintable(Position offset, String text, int radius, Color color) {
        Circle c1 =         new CircleBuilder()
                        .color(Color.GRAY)
                        .alignment(new SimpleAlignment(SimpleAlignment.HorizontalAlignment.CENTER, SimpleAlignment.VerticalAlignment.CENTER))
                        .bounds(new CircleBounds(radius, radius))
                        .zLayer(3)
                        .build();
        
        Circle c2 =        new CircleBuilder()
                        .color(color)
                        .alignment(new SimpleAlignment(SimpleAlignment.HorizontalAlignment.CENTER, SimpleAlignment.VerticalAlignment.CENTER))
                        .bounds(new CircleBounds(radius - (int)(radius*0.1), radius - (int)(radius*0.1)))
                        .zLayer(2)
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
                        .zLayer(1)
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

    @Override
    public int getGrade() {
        return grade;
    }

    @Override
    public int getRadius() {
        return radius;
    }

    @Override
    public String getText() {
        return text;
    }
    
    
    
}
