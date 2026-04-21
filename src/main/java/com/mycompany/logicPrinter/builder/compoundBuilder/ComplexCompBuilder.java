/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.logicPrinter.builder.compoundBuilder;

import com.mycompany.logicPrinter.component.compundComponent.ComplexComp;
import com.mycompany.logicPrinter.impl.compoundImpl.ComplexCompImplementation;
import com.mycompany.logicPrinter.part.Position;
import com.mycompany.logicPrinter.model.contract.Printable;

/**
 *
 * @author migue
 */
public class ComplexCompBuilder {
    
    private ComplexCompImplementation c;

    public ComplexCompBuilder() {
        c = new ComplexCompImplementation();
    }
    
    public ComplexCompBuilder addPrinter(Printable printer){
        c.addPrinter(printer);
        
        return this;
    }
    
    public ComplexCompBuilder offset(Position position){
        c.setOffset(position);
        
        return this;
    }
    
    public ComplexComp build(){
        return new ComplexComp(c);
    }
    
}
