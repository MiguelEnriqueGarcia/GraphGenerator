/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.mycompany.logicPrinter.model.contract;

import com.mycompany.logicPrinter.part.Position;

/**
 *
 * @author migue
 */
public interface Centerable {
    public Position getCenter(Position globalOffset);
}
