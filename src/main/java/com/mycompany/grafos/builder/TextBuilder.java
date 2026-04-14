/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.grafos.builder;

import com.mycompany.grafos.impl.PrinterCircleImplementation;
import com.mycompany.grafos.simplecomponents.Circle;
import com.mycompany.grafos.simplecomponents.Text;
import com.mycompany.grafos.impl.PrinterTextImplementation;
import com.mycompany.grafos.parts.SimpleAlignment;
import com.mycompany.grafos.parts.CircleBounds;
import com.mycompany.grafos.parts.Position;
import com.mycompany.grafos.parts.TextBounds;
import com.mycompany.grafos.service.Alignable;
import com.mycompany.grafos.service.Boundable;
import com.mycompany.grafos.service.Colorable;
import com.mycompany.grafos.service.Positionable;
import java.awt.Color;
import com.mycompany.grafos.service.compoundService.CircleService;
import com.mycompany.grafos.service.compoundService.TextService;

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

    public Text build(){
        return new Text(printerService);
    }
    
}
