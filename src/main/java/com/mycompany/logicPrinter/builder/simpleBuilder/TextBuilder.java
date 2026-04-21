/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.logicPrinter.builder.simpleBuilder;

import com.mycompany.logicPrinter.component.simpleComponent.Text;
import com.mycompany.logicPrinter.impl.simpleImpl.PrinterTextImplementation;
import com.mycompany.logicPrinter.part.alignment.SimpleAlignment;
import com.mycompany.logicPrinter.part.Position;
import com.mycompany.logicPrinter.part.bound.TextBounds;
import com.mycompany.logicPrinter.model.contract.Alignable;
import com.mycompany.logicPrinter.model.contract.Boundable;
import com.mycompany.logicPrinter.model.contract.Colorable;
import com.mycompany.logicPrinter.model.contract.Positionable;
import com.mycompany.logicPrinter.model.contract.ZLayerable;
import java.awt.Color;
import com.mycompany.logicPrinter.model.service.simpleService.TextService;

/**
 *
 * @author migue
 */
public class TextBuilder {
    
    private Text c;
    private TextService printerService;

    public TextBuilder() {
        printerService = new PrinterTextImplementation();
    }
    
    public TextBuilder text(String text){
        printerService.setText(text);
        
        return this;
    }
    
    public TextBuilder color(Color color){
        if (printerService instanceof Colorable) {
            ((Colorable)printerService).setColor(color);
        }else{
            throw new RuntimeException("Trying to apply color to non-colorable printer");
        }
        
        return this;
    }
    
    public TextBuilder position(Position position){
        if (printerService instanceof Positionable) {
            ((Positionable)printerService).setPosition(position);
        }else{
            throw new RuntimeException("Trying to apply position to non-positionable printer");
        }
        
        return this;
    }
    
    public TextBuilder alignment(SimpleAlignment alignment){
        if (printerService instanceof Alignable) {
            ((Alignable)printerService).setAlignment(alignment);
        }else{
            throw new RuntimeException("Trying to apply alignment to non-alignable printer");
        }
        
        return this;
    }
    
    public TextBuilder bounds(TextBounds bounds){
        if (printerService instanceof Boundable) {
            ((Boundable)printerService).setBounds(bounds);
        }else{
            throw new RuntimeException("Trying to apply bounds to non-boundable printer");
        }
        
        return this;
    }
    
    public TextBuilder zLayer(int zLayer){
        if (printerService instanceof ZLayerable) {
            ((ZLayerable)printerService).setZLayer(zLayer);
        }else{
            throw new RuntimeException("Trying to apply zLayer to non-zLayerable printer");
        }
        
        return this;
    }

    public Text build(){
        return new Text(printerService);
    }
    
}
