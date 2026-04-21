/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.mycompany.canvasPrinters;

import com.mycompany.grafos.service.ZLayerable;

/**
 *
 * @author migue
 */
public interface CanvasBounds{
    public default int getZ(){
        return 0;
    }
}
