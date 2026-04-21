/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.logicPrinter.part.alignment;

import com.mycompany.logicPrinter.model.marker.Alignment;

/**
 *
 * @author migue
 */
public class SimpleAlignment implements Alignment{
    
    public enum HorizontalAlignment {
        LEFT, CENTER, RIGHT
    };
    
    public enum VerticalAlignment {
        UP, CENTER, BOTTOM
    };
    
    private HorizontalAlignment horizontalAlignment = HorizontalAlignment.CENTER;
    private VerticalAlignment verticalAlignment = VerticalAlignment.CENTER;

    public SimpleAlignment(HorizontalAlignment horizontalAlignment, VerticalAlignment verticalAlignment) {
        this.horizontalAlignment = horizontalAlignment;
        this.verticalAlignment = verticalAlignment;
    }
    
    public HorizontalAlignment getHorizontalAlignment() {
        return horizontalAlignment;
    }

    public VerticalAlignment getVerticalAlignment() {
        return verticalAlignment;
    }
    
}
