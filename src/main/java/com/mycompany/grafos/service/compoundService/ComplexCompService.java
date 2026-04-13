/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.mycompany.grafos.service.compoundService;

import com.mycompany.grafos.service.FontResizable;
import com.mycompany.grafos.service.Offsetable;
import com.mycompany.grafos.service.Positionable;
import com.mycompany.grafos.service.PrinterService;
import com.mycompany.grafos.service.Resizable;

/**
 *
 * @author migue
 */
public interface ComplexCompService 
        extends PrinterService, 
        Positionable, 
        Resizable, 
        FontResizable, 
        Offsetable{
    
}
