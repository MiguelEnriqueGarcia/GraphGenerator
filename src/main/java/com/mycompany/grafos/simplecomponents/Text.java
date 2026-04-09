/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.grafos.simplecomponents;

import com.mycompany.grafos.service.compoundService.CircleService;
import com.mycompany.grafos.service.compoundService.TextService;
import lombok.experimental.Delegate;

/**
 *
 * @author migue
 */

public class Text  implements TextService{
    
    @Delegate
    private TextService printer;

    public Text(TextService textPrinter) {
        this.printer = textPrinter;
    }
    
}
