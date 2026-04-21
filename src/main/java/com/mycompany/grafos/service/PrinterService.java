/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.grafos.service;

import com.mycompany.grafos.parts.Position;
import java.awt.Graphics2D;

/**
 *
 * @author migue
 */
public interface PrinterService {

    public default void printMyself()
    {
        printMyself(new Position(0,0));
    }
    
    public void printMyself(Position globalOffset);
    
}
