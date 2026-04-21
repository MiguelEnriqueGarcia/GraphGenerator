/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.grafos.gui;

import com.mycompany.canvasPrinters.Pencil;
import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.image.BufferStrategy;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import com.mycompany.grafos.service.PrinterService;

/**
 *
 * @author migue
 */
public class GraphCanvas extends Canvas{
    
    private BufferStrategy bs;
    private Graphics2D g;
    private List<PrinterService> printables;
    private Color backgroundColor;
    
    public GraphCanvas(PrinterService ... printables) {
        this.printables = new LinkedList<>();
        Arrays.stream(printables).forEach(u -> this.printables.add(u));
        

        this.setIgnoreRepaint(true);


        this.setFocusable(true);
        this.requestFocus();
    }
    private void initBufferStrategy() {
        if (bs == null) {
            createBufferStrategy(2);
            bs = getBufferStrategy();
        }
    }

    public void render() {
        if (bs == null) {
            initBufferStrategy();
            return;
        }
        
        startRender();
        
        updateItems();
        
        EndRender();
        
    }
    
    private void startRender() {
        Pencil.clear();
        
        g = (Graphics2D) bs.getDrawGraphics();
        g.setColor(backgroundColor);
        g.fillRect(0, 0, getWidth(), getHeight());    
    }
    private void updateItems() {
        printables.forEach(u -> {
            printItem(u);
        });
    }
    private void printItem(PrinterService printable){
        Color lastColor = g.getColor();
        printable.printMyself();
        g.setColor(lastColor);
    }
    
    private void EndRender(){
        Pencil.printAll(g);
        
        g.dispose();
        bs.show();
    }

    public Color getBackgroundColor() {
        return backgroundColor;
    }

    public void setBackgroundColor(Color backgroundColor) {
        this.backgroundColor = backgroundColor;
    }

    public List<PrinterService> getPrintables() {
        return printables;
    }
    
}
