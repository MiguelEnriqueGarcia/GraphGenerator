/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.logicPrinter.builder.simpleBuilder;

import com.mycompany.logicPrinter.component.simpleComponent.Rectangle;
import com.mycompany.logicPrinter.impl.simpleImpl.PrinterRectanglePrinterImplementation;
import com.mycompany.logicPrinter.part.alignment.SimpleAlignment;
import com.mycompany.logicPrinter.part.Position;
import com.mycompany.logicPrinter.part.bound.RectangleBounds;
import com.mycompany.logicPrinter.model.contract.Alignable;
import com.mycompany.logicPrinter.model.contract.Boundable;
import com.mycompany.logicPrinter.model.contract.Colorable;
import com.mycompany.logicPrinter.model.contract.Positionable;
import com.mycompany.logicPrinter.model.contract.ZLayerable;
import java.awt.Color;
import com.mycompany.logicPrinter.model.service.simpleService.RectangleService;

/**
 *
 * @author migue
 */
public class RectangleBuilder {
    
    private Rectangle c;
    private RectangleService printerService;

    public RectangleBuilder() {
        printerService = new PrinterRectanglePrinterImplementation();
    }
    
    public RectangleBuilder color(Color color){
        if (printerService instanceof Colorable) {
            ((Colorable)printerService).setColor(color);
        }else{
            throw new RuntimeException("Trying to apply color to non-colorable printer");
        }
        
        return this;
    }
    
    public RectangleBuilder position(Position position){
        if (printerService instanceof Positionable) {
            ((Positionable)printerService).setPosition(position);
        }else{
            throw new RuntimeException("Trying to apply position to non-positionable printer");
        }
        
        return this;
    }
    
    public RectangleBuilder alignment(SimpleAlignment alignment){
        if (printerService instanceof Alignable) {
            ((Alignable)printerService).setAlignment(alignment);
        }else{
            throw new RuntimeException("Trying to apply alignment to non-alignable printer");
        }
        
        return this;
    }
    
    public RectangleBuilder bounds(RectangleBounds bounds){
        if (printerService instanceof Boundable) {
            ((Boundable)printerService).setBounds(bounds);
        }else{
            throw new RuntimeException("Trying to apply bounds to non-boundable printer");
        }
        
        return this;
    }
    
    
    public RectangleBuilder zLayer(int zLayer){
        if (printerService instanceof ZLayerable) {
            ((ZLayerable)printerService).setZLayer(zLayer);
        }else{
            throw new RuntimeException("Trying to apply zLayer to non-zLayerable printer");
        }
        
        return this;
    }

    public Rectangle build(){
        return new Rectangle(printerService);
    }
    
}
