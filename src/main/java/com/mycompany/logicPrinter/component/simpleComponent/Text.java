/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.logicPrinter.component.simpleComponent;

import com.mycompany.logicPrinter.model.service.simpleService.TextService;
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
