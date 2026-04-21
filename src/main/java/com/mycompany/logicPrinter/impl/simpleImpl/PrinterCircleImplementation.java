/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.logicPrinter.impl.simpleImpl;

import com.mycompany.canvasPrinter.Pencil;
import com.mycompany.canvasPrinter.bounds.CircleCanvasBounds;
import com.mycompany.logicPrinter.part.alignment.SimpleAlignment;
import com.mycompany.logicPrinter.part.bound.CircleBounds;
import com.mycompany.logicPrinter.part.Position;
import com.mycompany.logicPrinter.model.marker.Alignment;
import com.mycompany.logicPrinter.model.marker.Bounds;
import com.mycompany.logicPrinter.model.service.simpleService.CircleService;
import java.awt.Color;

/**
 *
 * @author migue
 */

public class PrinterCircleImplementation implements CircleService{

    private Color color = Color.RED;
    private Position position = new Position(0, 0);
    private int zLayer;
    private SimpleAlignment alignment = new SimpleAlignment(SimpleAlignment.HorizontalAlignment.CENTER, SimpleAlignment.VerticalAlignment.CENTER);
    private CircleBounds circleBounds = new CircleBounds(50, 50);
    private double size = 1;
    
    public PrinterCircleImplementation() {
    }

    @Override
    public void printMyself(Position globalOffset) {
        int x = position.getX();
        int y = position.getY();
        
        if (alignment.getHorizontalAlignment() == SimpleAlignment.HorizontalAlignment.CENTER) {
            x -= circleBounds.getRx()/2;
        }
        if (alignment.getHorizontalAlignment() == SimpleAlignment.HorizontalAlignment.RIGHT) {
            x -= circleBounds.getRx();
        }
        if (alignment.getVerticalAlignment()== SimpleAlignment.VerticalAlignment.CENTER) {
            y -= circleBounds.getRy()/2;
        }
        if (alignment.getVerticalAlignment() == SimpleAlignment.VerticalAlignment.BOTTOM) {
            y -= circleBounds.getRy();
        }
        
        printOval(x+globalOffset.getX(), y+globalOffset.getY(), circleBounds.getRx(), circleBounds.getRy());
    }
    
    private void printOval(int x, int y, int rx, int ry){
        CircleCanvasBounds circleCanvasBounds = new CircleCanvasBounds(x, y, zLayer, rx, ry, color);
        Pencil.print(circleCanvasBounds);
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
        if (bounds instanceof CircleBounds) {
            this.circleBounds = (CircleBounds) bounds;
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

    @Override
    public void setZLayer(int zLayer) {
        this.zLayer = zLayer;
    }

    @Override
    public int getZLayer() {
        return zLayer;
    }
    
}
