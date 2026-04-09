/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.grafos.graphcomponents;

import com.mycompany.grafos.builder.ComplexCompBuilder;
import com.mycompany.grafos.parts.Position;
import com.mycompany.grafos.service.FontResizable;
import com.mycompany.grafos.service.Offsetable;
import com.mycompany.grafos.service.Positionable;
import com.mycompany.grafos.service.PrinterService;
import com.mycompany.grafos.service.Resizable;
import com.mycompany.grafos.simplecomponents.ComplexComp;
import java.awt.Graphics2D;
import java.util.List;
import lombok.experimental.Delegate;

/**
 *
 * @author migue
 */
public class GraphComp implements PrinterService, Positionable, Resizable, FontResizable, Offsetable{
    private List<Node> nodes;
    private Position localPosition = new Position(1000, 0);
    @Delegate
    private ComplexComp graphPrinter;
    
    public GraphComp(List<Node> nodes){
        this.nodes = nodes;
        
        ComplexCompBuilder graphPrinterBuilder = new ComplexCompBuilder();
        
        for (Node node : this.nodes) {
            graphPrinterBuilder.addPrinter(node);
        }
        
        graphPrinter = graphPrinterBuilder.build();
    }

    @Override
    public void printMyself(Graphics2D g, Position globalOffset) {
        Position totalOffset = globalOffset.move(localPosition);
        System.out.println(totalOffset);
        graphPrinter.printMyself(g, totalOffset);
    }
}
