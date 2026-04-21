/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.mycompany.logicPrinter.model.service.simpleService;

import com.mycompany.logicPrinter.model.contract.Alignable;
import com.mycompany.logicPrinter.model.contract.Boundable;
import com.mycompany.logicPrinter.model.contract.Colorable;
import com.mycompany.logicPrinter.model.contract.Positionable;
import com.mycompany.logicPrinter.model.contract.Resizable;
import com.mycompany.logicPrinter.model.contract.ZLayerable;
import com.mycompany.logicPrinter.model.contract.Printable;

/**
 *
 * @author migue
 */
public interface RectangleService 
        extends Printable,
        Colorable, 
        Positionable, 
        Alignable, 
        ZLayerable,
        Boundable, 
        Resizable{ 
}
