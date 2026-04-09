/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.grafos.simplecomponents;

import com.mycompany.grafos.service.compoundService.LineService;
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
