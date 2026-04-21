/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.grafos.parts;

import com.mycompany.grafos.service.AlignableResizable;
import com.mycompany.grafos.service.Alignment;
import com.mycompany.grafos.service.Bounds;

/**
 *
 * @author migue
 */
public class LineBounds implements Bounds, AlignableResizable{
    private Position p1;
    private Position p2;
    private double size;
    private Position p1Resized;
    private Position p2Resized;

    public LineBounds(Position p1, Position p2) {
        this.p1 = p1;
        this.p2 = p2;
        
        this.p1Resized = p1;
        this.p2Resized = p2;
    }

    public Position getResizedP1() {
        return p1Resized;
    }

    public Position getResizedP2() {
        return p2Resized;
    }

    @Override
    public void resize(double factor, Alignment alignment) {
        if (factor != 1) {
            if (alignment instanceof LineAlignment) {
                LineAlignment lineAlignment = (LineAlignment) alignment;

                resize(factor, lineAlignment.getTypeAlignment());
            }else{
                throw new RuntimeException("Trying to apply incorrect Alignment to a Line Printer Implementation");
            }
        }
    }
   
    private void resize(double factor, LineAlignment.TypeAlignment alignment) {
        generateResizedBounds(factor, alignment);
        
        this.size = factor;
    }
    
    private void generateResizedBounds(double factor, LineAlignment.TypeAlignment alignment) {
        int p1x = p1.getX();
        int p1y = p1.getY();
        int p2x = p2.getX();
        int p2y = p2.getY();
        if (alignment == LineAlignment.TypeAlignment.FIRST_POSITION) {
            
            
            p2x = (int) (factor*(p2x - p1x) + p1x);
            p2y = (int) (factor*(p2y - p1y) + p1y);
            
        }else if (alignment == LineAlignment.TypeAlignment.SECOND_POSITION) {
            
            p1x = (int) (-factor*(p2x - p1x) + p2x);
            p1y = (int) (-factor*(p2y - p1y) + p2y);
            
        }else if (alignment == LineAlignment.TypeAlignment.CENTER) {
            
            p1x = (int) (-factor*(p2x - p1x) + p2x);
            p1y = (int) (-factor*(p2y - p1y) + p2y);
            
            
        }
        
        p1Resized = new Position(p1x, p1y);
        p2Resized = new Position(p2x, p2y);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        
        sb
                .append("\n1::")
                .append(p1.getX()).append(" , ").append(p1.getY()).append("\n")
                .append("2::")
                .append(p2.getX()).append(" , ").append(p2.getY()).append("\n");
        
        return sb.toString();
    }

    @Override
    public double getSize() {
        return size;
    }

   
    
    
}
