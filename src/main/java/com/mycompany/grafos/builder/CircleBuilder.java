/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.grafos.builder;

import com.mycompany.grafos.impl.PrinterCircleImplementation;
import com.mycompany.grafos.simplecomponents.Circle;
import com.mycompany.grafos.parts.SimpleAlignment;
import com.mycompany.grafos.parts.CircleBounds;
import com.mycompany.grafos.parts.Position;
import com.mycompany.grafos.service.Alignable;
import com.mycompany.grafos.service.Boundable;
import com.mycompany.grafos.service.Colorable;
import com.mycompany.grafos.service.Positionable;
import com.mycompany.grafos.service.ZLayerable;
import java.awt.Color;
import com.mycompany.grafos.service.compoundService.CircleService;

/**
 *
 * @author migue
 */
public class CircleBuilder {
    
    private Circle c;
    private CircleService printerService;

    public CircleBuilder() {
        printerService = new PrinterCircleImplementation();
    }
    
    public CircleBuilder color(Color color){
        if (printerService instanceof Colorable) {
            ((Colorable)printerService).setColor(color);
        }else{
            throw new RuntimeException("Trying to apply color to non-colorable printer");
        }
        
        return this;
    }
    
    public CircleBuilder position(Position position){
        if (printerService instanceof Positionable) {
            ((Positionable)printerService).setPosition(position);
        }else{
            throw new RuntimeException("Trying to apply position to non-positionable printer");
        }
        
        return this;
    }
    
    public CircleBuilder alignment(SimpleAlignment alignment){
        if (printerService instanceof Alignable) {
            ((Alignable)printerService).setAlignment(alignment);
        }else{
            throw new RuntimeException("Trying to apply alignment to non-alignable printer");
        }
        
        return this;
    }
    
    public CircleBuilder bounds(CircleBounds bounds){
        if (printerService instanceof Boundable) {
            ((Boundable)printerService).setBounds(bounds);
        }else{
            throw new RuntimeException("Trying to apply bounds to non-boundable printer");
        }
        
        return this;
    }
    
    public CircleBuilder zLayer(int zLayer){
        if (printerService instanceof ZLayerable) {
            ((ZLayerable)printerService).setZLayer(zLayer);
        }else{
            throw new RuntimeException("Trying to apply zLayer to non-zLayerable printer");
        }
        
        return this;
    }

    public Circle build(){
        return new Circle(printerService);
    }
    
}
