/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.canvasPrinter.printers;

import com.mycompany.canvasPrinter.bounds.CircleCanvasBounds;
import java.awt.Graphics2D;
import com.mycompany.canvasPrinter.service.CanvasPrinterService;

/**
 *
 * @author migue
 */
public class CircleCanvasPrinter implements CanvasPrinterService<CircleCanvasBounds> {

    @Override
    public void printMyself(Graphics2D g, CircleCanvasBounds bounds) {
        g.fillOval(bounds.getX(), bounds.getY(), bounds.getWidth(), bounds.getHeight());
    }
    
}
