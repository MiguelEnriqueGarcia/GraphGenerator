/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.grafos.impl;

import com.mycompany.logicPrinter.builder.simpleBuilder.LineBuilder;
import com.mycompany.logicPrinter.part.alignment.LineAlignment;
import com.mycompany.logicPrinter.part.bound.LineBounds;
import com.mycompany.logicPrinter.part.Position;
import com.mycompany.logicPrinter.model.service.simpleService.LineService;
import com.mycompany.grafos.service.NodeService;
import com.mycompany.grafos.service.RelationService;
import java.awt.Color;
import lombok.experimental.Delegate;

/**
 *
 * @author migue
 */
public class RelationImplementation implements RelationService{

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
