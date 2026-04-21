/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.grafos.impl;

import com.mycompany.canvasPrinters.Pencil;
import com.mycompany.canvasPrinters.bounds.TextCanvasBounds;
import com.mycompany.grafos.parts.Position;
import com.mycompany.grafos.parts.SimpleAlignment;
import com.mycompany.grafos.parts.TextBounds;
import com.mycompany.grafos.service.Alignment;
import com.mycompany.grafos.service.Bounds;
import com.mycompany.grafos.service.compoundService.TextService;
import java.awt.Color;

/**
 *
 * @author migue
 */
public class PrinterTextImplementation implements TextService{
    
    private String text = "";
    
    private Color color = Color.RED;
    private Position position = new Position(0, 0);
    private int zLayer;
    private SimpleAlignment alignment = new SimpleAlignment(SimpleAlignment.HorizontalAlignment.CENTER, SimpleAlignment.VerticalAlignment.CENTER);
    private TextBounds textBounds = new TextBounds(10, 10);
    
    private double size = 1;
    private double fontSize = 12;
    
    public PrinterTextImplementation() {
    }
    
    @Override
    public void printMyself(Position globalOffset) {
        int x = position.getX();
        int y = (int) (position.getY() + 7*size*(fontSize/12));
        
        if (alignment.getHorizontalAlignment() == SimpleAlignment.HorizontalAlignment.CENTER) {
            x -= textBounds.getXSize()/2;
        }
        if (alignment.getHorizontalAlignment() == SimpleAlignment.HorizontalAlignment.RIGHT) {
            x -= textBounds.getXSize();
        }
        if (alignment.getVerticalAlignment()== SimpleAlignment.VerticalAlignment.CENTER) {
            y -= textBounds.getYSize()/2 - 4*size*(fontSize/12);
        }
        if (alignment.getVerticalAlignment() == SimpleAlignment.VerticalAlignment.UP) {
            y -= textBounds.getYSize();
        }
        
        x += globalOffset.getX();
        y += globalOffset.getY();
        
        printText(x, y);
    }
    
    private void printText(int x, int y){
        
        TextCanvasBounds textCanvasBounds = new TextCanvasBounds(text, textBounds, x, y, zLayer, size, fontSize, color);
        Pencil.print(textCanvasBounds);
        
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
    public Bounds getBounds() {
        return textBounds;
    }

    @Override
    public void setBounds(Bounds bounds) {
        if (bounds instanceof TextBounds) {
            this.textBounds = (TextBounds) bounds;
        }else{
            throw new RuntimeException("Trying to apply incorrect bounds to a Line Printer Implementation");
        }
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
    public Alignment getAlignment() {
        return alignment;
    }

    @Override
    public void setAlignment(Alignment alignment) {
        if (alignment instanceof SimpleAlignment) {
            this.alignment = (SimpleAlignment) alignment;
        }else{
            throw new RuntimeException("Trying to apply incorrect Alignment to a Line Printer Implementation");
        }
    }

    @Override
    public void resize(double factor) {
        this.size = factor;
        textBounds.resize(factor);
    }

    @Override
    public double getSize() {
        return this.size;
    }

    @Override
    public String getText() {
        return text;
    }

    @Override
    public void setText(String text) {
        this.text = text;
    }

    @Override
    public double getFontSize() {
        return fontSize;
    }

    @Override
    public void resizeFont(double fontSize) {
        this.fontSize = fontSize;
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
