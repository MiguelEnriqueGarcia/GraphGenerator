/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.mycompany.canvasPrinters;

import com.mycompany.grafos.service.Colorable;
import java.awt.Graphics2D;

/**
 *
 * @author migue
 */
public interface CanvasPrinter <T extends CanvasBounds & Colorable> {
    public void printMyself(Graphics2D g, T bounds);
}
