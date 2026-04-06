/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.grafos.graphcomponents;

import com.mycompany.grafos.service.compoundService.CircleService;
import lombok.experimental.Delegate;

/**
 *
 * @author migue
 */

public class Circle  implements CircleService{
    
    @Delegate
    private CircleService printer;

    public Circle(CircleService circlePrinter) {
        this.printer = circlePrinter;
    }
    
}
