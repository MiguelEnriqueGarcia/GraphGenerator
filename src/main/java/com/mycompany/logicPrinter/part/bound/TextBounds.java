/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.logicPrinter.part.bound;

import com.mycompany.logicPrinter.model.marker.Bounds;
import com.mycompany.logicPrinter.model.contract.Resizable;

/**
 *
 * @author migue
 */
public class TextBounds implements Bounds, Resizable{
    
    private int xSize = 10;
    private int ySize = 10;
    private double size = 1;

    public TextBounds(int xSize, int ySize) {
        this.xSize = xSize;
        this.ySize = ySize;
    }
    
    @Override
    public void resize(double factor) {
        this.size = factor;
    }

    @Override
    public double getSize() {
        return size;
    }

    public int getXSize() {
        return (int) (xSize*size);
    }

    public int getYSize() {
        return (int) (ySize*size);
    }
    
}
