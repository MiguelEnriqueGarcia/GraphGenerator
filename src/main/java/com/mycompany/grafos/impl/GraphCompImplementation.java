/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.grafos.impl;

import com.mycompany.logicPrinter.builder.compoundBuilder.ComplexCompBuilder;
import com.mycompany.logicPrinter.part.Position;
import com.mycompany.logicPrinter.model.service.compoundService.ComplexCompService;
import com.mycompany.grafos.service.GraphCompService;
import com.mycompany.grafos.service.NodeService;
import java.util.List;

/**
 *
 * @author migue
 */
public class GraphCompImplementation implements GraphCompService{
    private List<NodeService> nodes;
    private ComplexCompService graphPrinter;
    private Position position = new Position(0, 0);
    private Position mousePosition = new Position(0, 0);
    private double size = 1;
    
    public GraphCompImplementation(List<NodeService> nodes){
        this.nodes = nodes;
        
        ComplexCompBuilder graphPrinterBuilder = new ComplexCompBuilder();
        
        for (NodeService node : this.nodes) {
            graphPrinterBuilder.addPrinter(node);
        }
        
        graphPrinter = graphPrinterBuilder.build();
    }
    
    @Override
    public void printMyself(Position globalOffset) {
        Position totalOffset = globalOffset.move(position).move(mousePosition);
        graphPrinter.printMyself(totalOffset);
    }

    @Override
    public void setPosition(Position position) {
        position.resize(size);
        this.position = position;
//        graphPrinter.setPosition(position);
    }

    @Override
    public Position getPosition() {
        return graphPrinter.getPosition();
    }

    @Override
    public double getSize() {
        return graphPrinter.getSize();
    }

    @Override
    public void resize(double factor) {
        position.resize(factor);
        graphPrinter.resize(factor);
        this.size = factor;
    }

    @Override
    public double getFontSize() {
        return graphPrinter.getFontSize();
    }

    @Override
    public void resizeFont(double fontSize) {
        graphPrinter.resizeFont(fontSize);
    }

    @Override
    public void setOffset(Position offset) {
        graphPrinter.setOffset(offset);
    }

    @Override
    public Position getOffset() {
        return graphPrinter.getOffset();
    }

    @Override
    public Position getMousePosition() {
        return mousePosition;
    }

    @Override
    public void setMousePosition(Position mousePosition) {
        this.mousePosition = mousePosition;
    }
    
}
