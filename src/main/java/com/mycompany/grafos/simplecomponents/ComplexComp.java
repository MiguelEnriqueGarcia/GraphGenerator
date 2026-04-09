/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.grafos.simplecomponents;

import com.mycompany.grafos.impl.PrinterCircleImplementation;
import com.mycompany.grafos.parts.Position;
import com.mycompany.grafos.service.FontResizable;
import com.mycompany.grafos.service.Offsetable;
import com.mycompany.grafos.service.Positionable;
import java.awt.Graphics2D;
import com.mycompany.grafos.service.PrinterService;
import com.mycompany.grafos.service.Resizable;
import java.util.LinkedList;

/**
 *
 * @author migue
 */

public class ComplexComp implements PrinterService, Positionable, Resizable, FontResizable, Offsetable{
    
    private LinkedList<PrinterService> printers = new LinkedList<>();
    private Position position;
    private Position offset = new Position(0, 0);
    
    private double size = 1;
    private double fontSize = 12;

    public ComplexComp() {
    }
    
    public void addPrinter(PrinterService printer){
        printers.add(printer);
    }

    @Override
    public void printMyself(Graphics2D g, Position globalOffset) {
        Position totalOffset = globalOffset.move(offset);
        
        printers.forEach(p -> p.printMyself(g, totalOffset));
    }

    @Override
    public void setPosition(Position position) {
        this.position = position;
        printers.forEach(p -> {
            if (p instanceof Positionable) {
                ((Positionable)p).setPosition(this.position);
            }
        });
    }

    @Override
    public Position getPosition() {
        return position;
    }

    @Override
    public void resize(double factor) {
        offset.resize(factor);
        
        printers.forEach(p -> {
            if (p instanceof Resizable) {
                ((Resizable)p).resize(factor);
            }
        });
        
        this.size = factor;
        
    }

    @Override
    public double getSize() {
        return size;
    }

    @Override
    public double getFontSize() {
        return fontSize;
    }

    @Override
    public void resizeFont(double fontSize) {
        printers.forEach(p -> {
            if (p instanceof FontResizable) {
                ((FontResizable)p).resizeFont(fontSize);
            }
        });
        
        this.fontSize = fontSize;
    }

    @Override
    public void setOffset(Position offset) {
        this.offset = offset;
    }

    @Override
    public Position getOffset() {
        return offset;
    }
    
}
