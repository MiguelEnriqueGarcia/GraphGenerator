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
public class LineAlignment implements Alignment{
    
    public enum TypeAlignment {
        FIRST_POSITION, CENTER, SECOND_POSITION
    };
    
    private TypeAlignment typeAlignment = TypeAlignment.FIRST_POSITION;

    public LineAlignment(TypeAlignment typeAlignment) {
        this.typeAlignment = typeAlignment;
    }

    public TypeAlignment getTypeAlignment() {
        return typeAlignment;
    }
    
}
