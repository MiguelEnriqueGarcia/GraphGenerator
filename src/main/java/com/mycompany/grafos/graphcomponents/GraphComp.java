/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.grafos.graphcomponents;

import com.mycompany.grafos.builder.ComplexCompBuilder;
import com.mycompany.grafos.parts.Position;
import com.mycompany.grafos.service.compoundService.ComplexCompService;
import com.mycompany.grafos.service.compoundService.GraphCompService;
import com.mycompany.grafos.service.compoundService.NodeService;
import java.util.List;

/**
 *
 * @author migue
 */
public class GraphComp implements GraphCompService{
    private List<NodeService> nodes;
    private ComplexCompService graphPrinter;
    private Position position = new Position(0, 0);
    private Position mousePosition = new Position(200, 200);
    private double size = 1;
    
    public GraphComp(List<NodeService> nodes){
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
    
}
