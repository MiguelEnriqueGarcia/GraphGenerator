/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.canvasPrinter;

import com.mycompany.canvasPrinter.bounds.CircleCanvasBounds;
import com.mycompany.canvasPrinter.bounds.LineCanvasBounds;
import com.mycompany.canvasPrinter.bounds.RectangleCanvasBounds;
import com.mycompany.canvasPrinter.bounds.TextCanvasBounds;
import com.mycompany.canvasPrinter.printers.CircleCanvasPrinter;
import com.mycompany.canvasPrinter.printers.LineCanvasPrinter;
import com.mycompany.canvasPrinter.printers.RectangleCanvasPrinter;
import com.mycompany.canvasPrinter.printers.TextCanvasPrinter;
import com.mycompany.logicPrinter.model.contract.Colorable;
import java.awt.Graphics2D;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import com.mycompany.canvasPrinter.service.CanvasBoundsService;
import com.mycompany.canvasPrinter.service.CanvasPrinterService;

/**
 *
 * @author migue
 */
public class Pencil {
    
    private static final Map<Class<? extends CanvasBoundsService>, ? extends CanvasPrinterService> m = new HashMap<>(){{
        put(CircleCanvasBounds.class,       new CircleCanvasPrinter());
        put(LineCanvasBounds.class,         new LineCanvasPrinter());
        put(RectangleCanvasBounds.class,    new RectangleCanvasPrinter());
        put(TextCanvasBounds.class,         new TextCanvasPrinter());
    }};
    
    private static Set<CanvasBoundsService> forms = new HashSet<>();
    
    public static void clear(){
        forms.clear();
    }
    
    public static void printAll(Graphics2D g){
        
        forms.stream()
                .sorted((o1, o2) -> o2.getZ() - o1.getZ())
                .forEachOrdered(form -> printForm(g, form));
        
    }
    
    public static void printForm(Graphics2D g, CanvasBoundsService form){
        
        if (form == null) {
            throw new RuntimeException(
                    "Se ha intentado pintar algo con unos bounds nulos en 'Pencil'"
            );
        }
        
        if (form instanceof Colorable colorable) {
            g.setColor(colorable.getColor());
        }
        CanvasPrinterService printer = m.get(form.getClass());
        
        if (printer == null) {
            throw new RuntimeException(
                    "Se ha intentado pintar algo sin un CanvasPrinter compatible en 'Pencil'"
            );
        }
        
        printer.printMyself(g, form);

    }
    
    public static void print(CanvasBoundsService form){
        
        forms.add(form);
        
    }
}
