/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.grafos.parts;

import com.mycompany.grafos.service.Bounds;
import com.mycompany.grafos.service.Resizable;

/**
 *
 * @author migue
 */
public class RectangleBounds implements Bounds, Resizable{
    private int xSize;
    private int ySize;
    private double size = 1;

    public RectangleBounds(int xSize, int ySize) {
        this.xSize = xSize;
        this.ySize = ySize;
    }

    public int getXSize() {
        return (int) (xSize*getSize());
    }

    public int getYSize() {
        return (int) (ySize*getSize());
    }

    @Override
    public void resize(double factor) {
        this.size = factor;
    }

    @Override
    public double getSize() {
        return size;
    }
}
