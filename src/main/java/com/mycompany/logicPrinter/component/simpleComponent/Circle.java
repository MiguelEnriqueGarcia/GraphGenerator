/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.logicPrinter.component.simpleComponent;

import com.mycompany.logicPrinter.model.service.simpleService.CircleService;
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
