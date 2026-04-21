/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.logicPrinter.component.simpleComponent;

import com.mycompany.logicPrinter.model.service.simpleService.LineService;
import lombok.experimental.Delegate;

/**
 *
 * @author migue
 */
public class Line implements LineService{
    
    @Delegate
    private LineService printer;

    public Line(LineService linePrinter) {
        this.printer = linePrinter;
    }
    
}
