/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.canvasPrinter.printers;

import com.mycompany.canvasPrinter.bounds.LineCanvasBounds;
import java.awt.BasicStroke;
import java.awt.Graphics2D;
import java.awt.Stroke;
import com.mycompany.canvasPrinter.service.CanvasPrinterService;

/**
 *
 * @author migue
 */
public class LineCanvasPrinter implements CanvasPrinterService<LineCanvasBounds> {

    @Override
    public void printMyself(Graphics2D g, LineCanvasBounds bounds) {
        
        Stroke lastStroke = g.getStroke();
        
        g.setStroke(new BasicStroke((float) (bounds.getStroke()*bounds.getSize())));
        
        g.drawLine(bounds.getX1(), bounds.getY1(), bounds.getX2(), bounds.getY2());
        
        g.setStroke(lastStroke);
        
    }
    
}
