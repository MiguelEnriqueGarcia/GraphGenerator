/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.mycompany.logicPrinter.model.service.compoundService;

import com.mycompany.logicPrinter.model.contract.FontResizable;
import com.mycompany.logicPrinter.model.contract.Offsetable;
import com.mycompany.logicPrinter.model.contract.Positionable;
import com.mycompany.logicPrinter.model.contract.Resizable;
import com.mycompany.logicPrinter.model.contract.Printable;

/**
 *
 * @author migue
 */
public interface ComplexCompService 
        extends Printable, 
        Positionable, 
        Resizable, 
        FontResizable, 
        Offsetable{
    
}
