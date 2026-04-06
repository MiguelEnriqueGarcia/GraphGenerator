/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.grafos.builder;

import com.mycompany.grafos.graphcomponents.Line;
import com.mycompany.grafos.impl.PrinterLineImplementation;
import com.mycompany.grafos.parts.LineAlignment;
import com.mycompany.grafos.parts.LineBounds;
import com.mycompany.grafos.parts.Position;
import com.mycompany.grafos.service.Alignable;
import com.mycompany.grafos.service.Boundable;
import com.mycompany.grafos.service.Colorable;
import com.mycompany.grafos.service.Positionable;
import java.awt.Color;
import com.mycompany.grafos.service.compoundService.LineService;
import java.awt.Stroke;

/**
 *
 * @author migue
 */
public class LineBuilder {
    
    private Line c;
    private LineService printerService;

    public LineBuilder() {
        printerService = new PrinterLineImplementation();
    }
    
    public LineBuilder color(Color color){
        if (printerService instanceof Colorable) {
            ((Colorable)printerService).setColor(color);
        }else{
            throw new RuntimeException("Trying to apply color to non-colorable printer");
        }
        
        return this;
    }
    
    public LineBuilder position(Position position){
        if (printerService instanceof Positionable) {
            ((Positionable)printerService).setPosition(position);
        }else{
            throw new RuntimeException("Trying to apply position to non-positionable printer");
        }
        
        return this;
    }
    
    public LineBuilder alignment(LineAlignment alignment){
        if (printerService instanceof Alignable) {
            ((Alignable)printerService).setAlignment(alignment);
        }else{
            throw new RuntimeException("Trying to apply alignment to non-alignable printer");
        }
        
        return this;
    }
    
    public LineBuilder bounds(LineBounds bounds){
        if (printerService instanceof Boundable) {
            ((Boundable)printerService).setBounds(bounds);
        }else{
            throw new RuntimeException("Trying to apply bounds to non-boundable printer");
        }
        
        return this;
    }
    
    public LineBuilder offset(Position position){
        printerService.setOffset(position);
        return this;
    }
    
    public LineBuilder stroke(double stroke){
        printerService.setStroke(stroke);
        return this;
    }

    public Line build(){
        return new Line(printerService);
    }
    
}
