/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.canvasPrinters.printers;

import com.mycompany.canvasPrinters.CanvasPrinter;
import com.mycompany.canvasPrinters.bounds.RectangleCanvasBounds;
import java.awt.Graphics2D;

/**
 *
 * @author migue
 */
public class RectanglePrinter implements CanvasPrinter<RectangleCanvasBounds> {

    @Override
    public void printMyself(Graphics2D g, RectangleCanvasBounds bounds) {
        g.fillRect(bounds.getX(), bounds.getY(), bounds.getWidth(), bounds.getHeight());
    }
    
}
