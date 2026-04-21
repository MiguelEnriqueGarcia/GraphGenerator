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
import com.mycompany.grafos.service.Colorable;
import java.awt.Graphics2D;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 *
 * @author migue
 */
public class Pencil {
    
    private static final Map<Class<? extends CanvasBounds>, ? extends CanvasPrinter> m = new HashMap<>(){{
        put(    CircleCanvasBounds.class,       new CirclePrinter());
        put(    LineCanvasBounds.class,         new LinePrinter());
        put(    RectangleCanvasBounds.class,    new RectanglePrinter());
        put(    TextCanvasBounds.class,         new TextPrinter());
    }};
    
    private static Set<CanvasBounds> forms = new HashSet<>();
    
    public static void clear(){
        forms.clear();
    }
    
    public static void printAll(Graphics2D g){
        
        forms.stream()
                .sorted((o1, o2) -> o2.getZ() - o1.getZ())
                .forEachOrdered(form -> printForm(g, form));
        
    }
    
    public static void printForm(Graphics2D g, CanvasBounds form){
        
        if (form == null) {
            throw new RuntimeException(
                    "Se ha intentado pintar algo con unos bounds nulos en 'Pencil'"
            );
        }
        
        if (form instanceof Colorable colorable) {
            g.setColor(colorable.getColor());
        }
        CanvasPrinter printer = m.get(form.getClass());
        
        if (printer == null) {
            throw new RuntimeException(
                    "Se ha intentado pintar algo sin un CanvasPrinter compatible en 'Pencil'"
            );
        }
        
        printer.printMyself(g, form);

    }
    
    public static void print(CanvasBounds form){
        
        forms.add(form);
        
    }
}
