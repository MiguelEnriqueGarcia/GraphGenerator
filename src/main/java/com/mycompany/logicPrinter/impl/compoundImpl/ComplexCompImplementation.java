/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.logicPrinter.impl.compoundImpl;

import com.mycompany.logicPrinter.part.Position;
import com.mycompany.logicPrinter.model.contract.FontResizable;
import com.mycompany.logicPrinter.model.contract.Positionable;
import com.mycompany.logicPrinter.model.contract.Resizable;
import com.mycompany.logicPrinter.model.service.compoundService.ComplexCompService;
import java.util.LinkedList;
import com.mycompany.logicPrinter.model.contract.Printable;

/**
 *
 * @author migue
 */

public class ComplexCompImplementation implements ComplexCompService{
    
    private LinkedList<Printable> printers = new LinkedList<>();
    private Position position;
    private Position offset = new Position(0, 0);
    
    private double size = 1;
    private double fontSize = 12;

    public ComplexCompImplementation() {
    }
    
    public void addPrinter(Printable printer){
        printers.add(printer);
    }

    @Override
    public void printMyself(Position globalOffset) {
        Position totalOffset = globalOffset.move(offset);
        printers.forEach(p -> p.printMyself(totalOffset));
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
