/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.grafos.impl;

import com.mycompany.grafos.parts.LineAlignment;
import com.mycompany.grafos.parts.LineBounds;
import com.mycompany.grafos.parts.Position;
import com.mycompany.grafos.service.Alignment;
import com.mycompany.grafos.service.Bounds;
import com.mycompany.grafos.service.compoundService.LineService;
import java.awt.Color;
import java.awt.Graphics2D;

/**
 *
 * @author migue
 */
public class PrinterLineImplementation implements LineService{

    private Color color = Color.RED;
    private Position position = new Position(0, 0);
    private Position offset = new Position(0, 0);
    private LineAlignment alignment = new LineAlignment(LineAlignment.TypeAlignment.CENTER);
    private LineBounds lineBounds = new LineBounds(new Position(0, 0), new Position(1, 1));
    private double size = 1;
    
    public PrinterLineImplementation() {
    }
    
    @Override
    public void printMyself(Graphics2D g) {
        g.setColor(color);
        
        int p1x = lineBounds.getResizedP1().getX();
        int p1y = lineBounds.getResizedP1().getY();
        int p2x = lineBounds.getResizedP2().getX();
        int p2y = lineBounds.getResizedP2().getY();
        
        
        Position centerOn = new Position(0,0);
        if (alignment.getTypeAlignment()== LineAlignment.TypeAlignment.FIRST_POSITION) {
            centerOn = lineBounds.getResizedP1();
        }else if (alignment.getTypeAlignment()== LineAlignment.TypeAlignment.SECOND_POSITION) {
            centerOn = lineBounds.getResizedP2();
        }else if (alignment.getTypeAlignment()== LineAlignment.TypeAlignment.CENTER) {
            centerOn = new Position(
                    (p1x+p2x)/2,
                    (p1y+p2y)/2
            );
        }
        
        int xAdder = position.getX() - centerOn.getX();
        int yAdder = position.getY() - centerOn.getY();
        
        p1x += xAdder + offset.getX();
        p1y += yAdder + offset.getY();
        p2x += xAdder + offset.getX();
        p2y += yAdder + offset.getY();
        
        printLine(g, p1x, p1y, p2x, p2y);
    }
    
    private void printLine(Graphics2D g, int p1x, int p1y, int p2x, int p2y){
        g.drawLine(p1x, p1y, p2x, p2y);
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
        return lineBounds;
    }

    @Override
    public void setBounds(Bounds bounds) {
        if (bounds instanceof LineBounds) {
            this.lineBounds = (LineBounds) bounds;
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
        if (alignment instanceof LineAlignment) {
            this.alignment = (LineAlignment) alignment;
        }else{
            throw new RuntimeException("Trying to apply incorrect Alignment to a Line Printer Implementation");
        }
    }

    @Override
    public void setOffset(Position offset) {
        this.offset = offset;
    }

    @Override
    public Position setOffset() {
        return offset;
    }

    @Override
    public void resize(double factor) {
        lineBounds.resize(factor, alignment);
        offset.resize(factor);
        
        this.size = factor;
    }

    @Override
    public double getSize() {
        return this.size;
    }
    
}
