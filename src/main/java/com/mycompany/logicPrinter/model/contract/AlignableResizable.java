/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.mycompany.logicPrinter.model.contract;

import com.mycompany.logicPrinter.model.marker.Alignment;

/**
 *
 * @author migue
 */
public interface AlignableResizable{
    public double getSize();
    public void resize(double factor, Alignment alignment);
}
