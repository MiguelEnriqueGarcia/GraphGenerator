/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.mycompany.grafos.service;

import com.mycompany.logicPrinter.model.service.compoundService.ComplexCompService;
import com.mycompany.logicPrinter.model.contract.Centerable;
import com.mycompany.logicPrinter.model.contract.Colorable;
import java.util.List;

/**
 *
 * @author migue
 */
public interface NodeService 
        extends ComplexCompService,
        Centerable,
        Colorable {
    
    String getText();
    int getGrade();
    int getRadius();
    List<RelationService> getRelations();
    
    void setText(String text);
    void setGrade(int grade);
    void setRadius(int radius);
    void setRelations(List<RelationService> relations);
    void addRelation(RelationService relation);
    void addRelations(List<RelationService> relations);
}
