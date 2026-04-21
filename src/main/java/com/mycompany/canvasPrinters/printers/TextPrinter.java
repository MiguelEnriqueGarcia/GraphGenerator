/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.canvasPrinters.printers;

import com.mycompany.canvasPrinters.CanvasPrinter;
import com.mycompany.canvasPrinters.bounds.TextCanvasBounds;
import com.mycompany.grafos.utils.TextFormatter;
import java.awt.Font;
import java.awt.Graphics2D;

/**
 *
 * @author migue
 */
public class TextPrinter implements CanvasPrinter<TextCanvasBounds> {

    private final int INTERLINE_SIZE = 15;
    
    @Override
    public void printMyself(Graphics2D g, TextCanvasBounds bounds) {
        g.setFont(new Font("Arial", Font.PLAIN, (int) (bounds.getFontSize()*bounds.getSize())));
        
        String formattedText = applyFormatToText(g, bounds);
        
        int x = bounds.getX();
        int y = bounds.getY();
        
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < formattedText.length(); i++) {
            char actualChar = formattedText.charAt(i);
            
            if (actualChar == '%') {
                drawString(g, x, y, sb.toString());
                sb = new StringBuilder();
                y += INTERLINE_SIZE * bounds.getSize() * (bounds.getFontSize()/12);
            }else{
                sb.append(actualChar);
            }
        }
    }
    
    private String applyFormatToText(Graphics2D g, TextCanvasBounds bounds) {
        TextFormatter formatter = new TextFormatter(g.getFontMetrics(), bounds);
        
        if (formatter.isFormattable()) {
            return formatter.format();
        }else{
            return "";
        }
    }
    
    private void drawString(Graphics2D g, int x, int y, String text) {
        g.drawString(text, x, y);
    }
    
}
