/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.grafos.builder;

import com.mycompany.grafos.graphcomponents.Circle;
import com.mycompany.grafos.graphcomponents.ComplexComp;
import com.mycompany.grafos.service.PrinterService;
import java.awt.Color;

/**
 *
 * @author migue
 */
public class ComplexCompBuilder {
    
    private ComplexComp c;

    public ComplexCompBuilder() {
        c = new ComplexComp();
    }
    
    public ComplexCompBuilder addPrinter(PrinterService printer){
        c.addPrinter(printer);
        
        return this;
    }
    public ComplexComp build(){
        return c;
    }
    
}
