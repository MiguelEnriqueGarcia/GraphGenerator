/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.grafos.parts;

import com.mycompany.grafos.service.Resizable;

/**
 *
 * @author migue
 */
public final class Position implements Resizable{
    private int x;
    private int y;
    private double size = 1;

    public Position(int x, int y) {
        this.x = x;
        this.y = y;
    }
    
    public Position copy(){
        return new Position(x, y);
    }
    
    public Position move(Position posAdder){
        return move(posAdder.getX(), posAdder.getY());
    }
    
    public Position move(int xAdder, int yAdder){
        return new Position(x + xAdder, y + yAdder);
    }

    public int getX() {
        return (int) (x*getSize());
    }

    public int getY() {
        return (int) (y*getSize());
    }

    @Override
    public String toString() {
        return "{ "+x+" , "+y+" }";
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
