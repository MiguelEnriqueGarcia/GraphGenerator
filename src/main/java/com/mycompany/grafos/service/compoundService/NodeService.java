/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.mycompany.grafos.service.compoundService;

import com.mycompany.grafos.service.Centerable;
import com.mycompany.grafos.service.Colorable;
import java.util.List;

/**
 *
 * @author migue
 */
public interface NodeService 
        extends ComplexCompService,
        Centerable,
        Colorable {
    
    void setText(String text);
    void setGrade(int grade);
    void setRadius(int radius);
    void setRelations(List<RelationService> relations);
    void addRelation(RelationService relation);
    void addRelations(List<RelationService> relations);
    List<RelationService> getRelations();
}
