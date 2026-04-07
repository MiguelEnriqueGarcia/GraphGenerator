/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.grafos.impl;

import com.mycompany.grafos.parts.SimpleAlignment;
import com.mycompany.grafos.parts.CircleBounds;
import com.mycompany.grafos.parts.Position;
import com.mycompany.grafos.parts.RectangleBounds;
import com.mycompany.grafos.service.Alignment;
import com.mycompany.grafos.service.Bounds;
import com.mycompany.grafos.service.compoundService.RectangleService;
import java.awt.Color;
import java.awt.Graphics2D;

/**
 *
 * @author migue
 */

public class PrinterRectanglePrinterImplementation implements RectangleService{

    private Color color = Color.RED;
    private Position position = new Position(0, 0);
    private SimpleAlignment alignment = new SimpleAlignment(SimpleAlignment.HorizontalAlignment.CENTER, SimpleAlignment.VerticalAlignment.CENTER);
    private RectangleBounds circleBounds = new RectangleBounds(50, 50);
    private double size = 1;
    
    public PrinterRectanglePrinterImplementation() {
    }

    @Override
    public void printMyself(Graphics2D g) {
        int x = position.getX();
        int y = position.getY();
        
        if (alignment.getHorizontalAlignment() == SimpleAlignment.HorizontalAlignment.CENTER) {
            x -= circleBounds.getXSize()/2;
        }
        if (alignment.getHorizontalAlignment() == SimpleAlignment.HorizontalAlignment.RIGHT) {
            x -= circleBounds.getXSize();
        }
        if (alignment.getVerticalAlignment()== SimpleAlignment.VerticalAlignment.CENTER) {
            y -= circleBounds.getYSize()/2;
        }
        if (alignment.getVerticalAlignment() == SimpleAlignment.VerticalAlignment.BOTTOM) {
            y -= circleBounds.getYSize();
        }
        
        g.setColor(color);
        g.fillRect(x, y, circleBounds.getXSize(), circleBounds.getYSize());
    }
    
    @Override
    public Color getColor() {
        return color;
    }

    @Override
    public void setColor(Color color) {
        this.color = color;
    }

    @Override
    public void setPosition(Position position) {
        this.position = position;
    }

    @Override
    public Position getPosition() {
        return position;
    }

    @Override
    public void setAlignment(Alignment alignment) {
        if (alignment instanceof SimpleAlignment) {
            this.alignment = (SimpleAlignment) alignment;
        }else{
            throw new RuntimeException("Trying to apply incorrect Alignment to a Circle Printer Implementation");
        }
    }
    
    @Override
    public Alignment getAlignment() {
        return alignment;
    }

    @Override
    public Bounds getBounds() {
        return circleBounds;
    }

    @Override
    public void setBounds(Bounds bounds) {
        if (bounds instanceof RectangleBounds) {
            this.circleBounds = (RectangleBounds) bounds;
        }else{
            throw new RuntimeException("Trying to apply incorrect bounds to a Circle Printer Implementation");
        }
    }

    @Override
    public void resize(double factor) {
        circleBounds.resize(factor);
        
        this.size = factor;
    }

    @Override
    public double getSize() {
        return size;
    }
    
}
