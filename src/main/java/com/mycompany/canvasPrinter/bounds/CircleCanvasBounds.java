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
public final class CircleCanvasBounds implements CanvasBoundsService, Colorable{
    private int x;
    private int y;
    private int z;
    private int width;
    private int height;
    private Color color;
}
