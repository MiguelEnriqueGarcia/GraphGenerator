/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.logicPrinter.component.compundComponent;

import com.mycompany.logicPrinter.model.service.compoundService.ComplexCompService;
import lombok.experimental.Delegate;

/**
 *
 * @author migue
 */
public class ComplexComp implements ComplexCompService{
    
    @Delegate
    private ComplexCompService complexComp;

    public ComplexComp(ComplexCompService complexComp) {
        this.complexComp = complexComp;
    }
}
