/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.canvasPrinter.bounds;

import com.mycompany.logicPrinter.model.contract.Colorable;
import java.awt.Color;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import com.mycompany.canvasPrinter.service.CanvasBoundsService;

/**
 *
 * @author migue
 */

@AllArgsConstructor
@Getter
@Data
public class LineCanvasBounds implements CanvasBoundsService, Colorable{
    private int x1;
    private int y1;
    private int x2;
    private int y2;
    private int z;
    private double stroke;
    private double size;
    private Color color;
}
