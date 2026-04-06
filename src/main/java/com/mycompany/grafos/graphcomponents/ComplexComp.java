/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.grafos.graphcomponents;

import com.mycompany.grafos.impl.PrinterCircleImplementation;
import com.mycompany.grafos.parts.Position;
import com.mycompany.grafos.service.Positionable;
import java.awt.Graphics2D;
import com.mycompany.grafos.service.PrinterService;
import com.mycompany.grafos.service.Resizable;
import java.util.LinkedList;

/**
 *
 * @author migue
 */

public class ComplexComp implements PrinterService, Positionable, Resizable{
    
    private LinkedList<PrinterService> printers = new LinkedList<>();
    private Position position;
    private double size = 1;

    public ComplexComp() {
    }
    
    public void addPrinter(PrinterService printer){
        printers.add(printer);
    }

    @Override
    public void printMyself(Graphics2D g) {
        printers.forEach(p -> p.printMyself(g));
    }

    @Override
    public void setPosition(Position position) {
        this.position = position;
        printers.forEach(p -> {
            if (p instanceof Positionable) {
                ((Positionable)p).setPosition(position);
            }
        });
    }

    @Override
    public Position getPosition() {
        return position;
    }

    @Override
    public void resize(double factor) {
        
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
    
}
