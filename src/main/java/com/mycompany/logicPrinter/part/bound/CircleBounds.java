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
public class CircleBounds implements Bounds, Resizable{
    private int rx;
    private int ry;
    private double size = 1;

    public CircleBounds(int rx, int ry) {
        this.rx = rx;
        this.ry = ry;
    }

    public int getRx() {
        return (int) (rx*getSize());
    }

    public int getRy() {
        return (int) (ry*getSize());
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
