/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.mycompany.grafos.service.compoundService;

import com.mycompany.grafos.service.Alignable;
import com.mycompany.grafos.service.Boundable;
import com.mycompany.grafos.service.Colorable;
import com.mycompany.grafos.service.Positionable;
import com.mycompany.grafos.service.PrinterService;
import com.mycompany.grafos.service.Resizable;

/**
 *
 * @author migue
 */
public interface RectangleService 
        extends PrinterService,
        Colorable, 
        Positionable, 
        Alignable, 
        Boundable, 
        Resizable{ 
}
