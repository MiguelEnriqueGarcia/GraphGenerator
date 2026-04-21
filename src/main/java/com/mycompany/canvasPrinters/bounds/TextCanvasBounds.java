/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.canvasPrinters.bounds;

import com.mycompany.canvasPrinters.CanvasBounds;
import com.mycompany.grafos.parts.TextBounds;
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
public class TextCanvasBounds implements CanvasBounds, Colorable{
    private String originalText;
    private TextBounds textBounds;
    private int x;
    private int y;
    private int z;
    private double size = 1;
    private double fontSize = 12;
    private Color color;
}
