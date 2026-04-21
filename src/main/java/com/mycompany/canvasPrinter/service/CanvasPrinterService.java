/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.mycompany.canvasPrinter.service;

import com.mycompany.logicPrinter.model.contract.Colorable;
import java.awt.Graphics2D;

/**
 *
 * @author migue
 */
public interface CanvasPrinterService <T extends CanvasBoundsService & Colorable> {
    public void printMyself(Graphics2D g, T bounds);
}
