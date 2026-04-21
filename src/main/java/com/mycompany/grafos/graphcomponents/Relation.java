/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.grafos.graphcomponents;

import com.mycompany.grafos.builder.LineBuilder;
import com.mycompany.grafos.parts.LineAlignment;
import com.mycompany.grafos.parts.LineBounds;
import com.mycompany.grafos.parts.Position;
import com.mycompany.grafos.service.compoundService.LineService;
import com.mycompany.grafos.service.compoundService.NodeService;
import com.mycompany.grafos.service.compoundService.RelationService;
import java.awt.Color;
import java.awt.Graphics2D;
import lombok.experimental.Delegate;

/**
 *
 * @author migue
 */
public class Relation implements RelationService{

    @Delegate
    private LineService linePrintable;
    
    private NodeService lastNode = null;
    private NodeService nextNode = null;
    private int weight = 1;

    @Override
    public void printMyself(Position globalOffset) {
        Position difference = nextNode.getCenter(globalOffset)
                .move(lastNode.getCenter(globalOffset).dot(-1))
                .dot(lastNode.getSize());
        
        linePrintable = new LineBuilder()
                .color(Color.MAGENTA)
                .bounds(new LineBounds(new Position(0, 0), difference))
                .zLayer(1000)
                .alignment(new LineAlignment(LineAlignment.TypeAlignment.FIRST_POSITION))
                .offset(lastNode.getCenter(globalOffset))
                .stroke(2*lastNode.getSize())
                .build();
        linePrintable.printMyself(globalOffset);
    }
    
    @Override
    public NodeService getLastNode() {
        return lastNode;
    }

    @Override
    public NodeService getNextNode() {
        return nextNode;
    }

    @Override
    public int getWeight() {
        return weight;
    }

    @Override
    public void setLastNode(NodeService node) {
        this.lastNode = node;
    }

    @Override
    public void setNextNode(NodeService node) {
        this.nextNode = node;
    }

    @Override
    public void setWeight(int weight) {
        this.weight = weight;
    }
    
}
