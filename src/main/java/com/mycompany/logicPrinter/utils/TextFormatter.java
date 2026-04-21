/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.logicPrinter.utils;

import com.mycompany.canvasPrinter.bounds.TextCanvasBounds;
import com.mycompany.logicPrinter.part.bound.TextBounds;
import java.awt.FontMetrics;

/**
 *
 * @author migue
 */
public final class TextFormatter {
    private FontMetrics fm;
    private String text;
    private TextBounds textBounds;
    private final String DELIMITER = "%";
    
    private Boolean formattable = null;

    public TextFormatter(FontMetrics fm, TextCanvasBounds bounds) {
        this.fm = fm;
        this.text = bounds.getOriginalText();
        this.textBounds = bounds.getTextBounds();
    }
    
    public int getWidth(){
        return fm.stringWidth(text);
    }
    
    public int getHeight(){
        return fm.getHeight();
    }
    
    public String format() {
        
        if (!isFormattable()) {
            return "";
        }
        
        FormatWidthOutput output = formatWidth();
        
        StringBuilder textBuilder = output.textBuilder;
        int charAmountUpdated = output.charUpdated;
        
        textBuilder = formatHeight(textBuilder, charAmountUpdated);
        
        return textBuilder.toString();
    }
    
    public boolean isFormattable(){
        if (formattable != null) {
            return formattable;
        }
        
        formattable =  getWidth() != 0
                        && getHeight() != 0
                        && Math.floorDiv(textBounds.getYSize(), getHeight()) > 0;
        
        return formattable;
    }

    private FormatWidthOutput formatWidth() {
        int maxLines = Math.floorDiv(textBounds.getYSize(), getHeight());
        
        StringBuilder sb = new StringBuilder("");
        StringBuilder innerSb;
        
        int lineCounter = 0;
        int charNumber = 0;
        while(charNumber < text.length() && lineCounter < maxLines){
            innerSb = new StringBuilder();
            while(fm.stringWidth(innerSb.toString()) < textBounds.getXSize() && charNumber < text.length()){
                innerSb.append(text.charAt(charNumber));
                charNumber++;
            }
            sb.append(innerSb.toString());
            lineCounter++;
            
            sb.append(DELIMITER);
        }
        
        return new FormatWidthOutput(sb, charNumber);
    }

    private StringBuilder formatHeight(StringBuilder textBuilder, int charUpdated) {
        
        if (charUpdated < text.length()) {
            if (textBuilder.length() >= 3) {
                textBuilder
                    .deleteCharAt(textBuilder.lastIndexOf(DELIMITER))
                    .deleteCharAt(textBuilder.length()-1)
                    .deleteCharAt(textBuilder.length()-1)
                    .deleteCharAt(textBuilder.length()-1)
                    .append("...").append(DELIMITER);
            }else{
                textBuilder = new StringBuilder("...").append(DELIMITER);
            }
        }
        
        return textBuilder;
    }
    
    private class FormatWidthOutput {
        StringBuilder textBuilder;
        int charUpdated;

        public FormatWidthOutput(StringBuilder textBuilder, int charUpdated) {
            this.textBuilder = textBuilder;
            this.charUpdated = charUpdated;
        }
    }

    
}
