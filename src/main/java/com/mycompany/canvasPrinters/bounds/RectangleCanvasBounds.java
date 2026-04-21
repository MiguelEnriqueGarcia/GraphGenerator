/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.canvasPrinters.bounds;

import com.mycompany.canvasPrinters.CanvasBounds;
import com.mycompany.grafos.service.Colorable;
import java.awt.Color;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;

/**
 *
 * @author migue
 */

@AllArgsConstructor
@Getter
@Data
public class RectangleCanvasBounds implements CanvasBounds, Colorable{
    private int x;
    private int y;
    private int z;
    private int width;
    private int height;
    private Color color;
}
