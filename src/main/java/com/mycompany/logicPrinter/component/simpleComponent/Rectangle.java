/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.logicPrinter.component.simpleComponent;

import com.mycompany.logicPrinter.model.service.simpleService.CircleService;
import com.mycompany.logicPrinter.model.service.simpleService.RectangleService;
import lombok.experimental.Delegate;

/**
 *
 * @author migue
 */

public class Rectangle  implements CircleService{
    
    @Delegate
    private RectangleService printer;

    public Rectangle(RectangleService rectanglePrinter) {
        this.printer = rectanglePrinter;
    }
    
}
