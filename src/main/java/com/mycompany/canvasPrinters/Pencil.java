/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.canvasPrinters;

import com.mycompany.canvasPrinters.bounds.CircleCanvasBounds;
import com.mycompany.canvasPrinters.bounds.LineCanvasBounds;
import com.mycompany.canvasPrinters.bounds.RectangleCanvasBounds;
import com.mycompany.canvasPrinters.bounds.TextCanvasBounds;
import com.mycompany.canvasPrinters.printers.CirclePrinter;
import com.mycompany.canvasPrinters.printers.LinePrinter;
import com.mycompany.canvasPrinters.printers.RectanglePrinter;
import com.mycompany.canvasPrinters.printers.TextPrinter;
import java.awt.Graphics2D;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Set;

/**
 *
 * @author migue
 */
public class Pencil {
    private static final CirclePrinter circlePrinter = new CirclePrinter();
    private static final LinePrinter linePrinter = new LinePrinter();
    private static final RectanglePrinter rectanglePrinter = new RectanglePrinter();
    private static final TextPrinter textPrinter = new TextPrinter();
    
    private static Set<CanvasBounds> forms = new HashSet<>();
    
    public static void clear(){
        forms.clear();
    }
    
    public static void printAll(Graphics2D g){
        forms.stream().sorted((Comparator<? super CanvasBounds>) new Comparator<CanvasBounds>() {
            @Override
            public int compare(CanvasBounds o1, CanvasBounds o2) {
                return o2.getZ() - o1.getZ();
            }
        }).forEachOrdered(form -> {printForm(g, form);});
        
//        for (CanvasBounds form : forms) {
//            System.out.println(form.getZ());
//            printForm(g, form);
//        }
    }
    
    public static void printForm(Graphics2D g, CanvasBounds form){
        
        switch (form) {
            case CircleCanvasBounds circleCanvasBounds -> {
                g.setColor(circleCanvasBounds.getColor());
                circlePrinter.printMyself(g, circleCanvasBounds);
            }
            case LineCanvasBounds lineCanvasBounds -> {
                g.setColor(lineCanvasBounds.getColor());
                linePrinter.printMyself(g, lineCanvasBounds);
            }
            case RectangleCanvasBounds rectangleCanvasBounds -> {
                g.setColor(rectangleCanvasBounds.getColor());
                rectanglePrinter.printMyself(g, rectangleCanvasBounds);
            }
            case TextCanvasBounds textCanvasBounds -> {
                g.setColor(textCanvasBounds.getColor());
                textPrinter.printMyself(g, textCanvasBounds);
            }
            default -> throw new RuntimeException("    Se ha intentado pintar algo sin un CanvasBounds localizado en 'Pencil'     ");
        }
    }
    
    public static void print(Graphics2D g, CanvasBounds form){
        
        forms.add(form);
        
    }
}
