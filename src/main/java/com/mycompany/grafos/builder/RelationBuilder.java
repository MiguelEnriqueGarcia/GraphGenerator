/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.grafos.builder;

import com.mycompany.grafos.component.Relation;
import com.mycompany.logicPrinter.exception.BuildingLogicPrinterError;
import com.mycompany.grafos.impl.RelationImplementation;
import com.mycompany.grafos.service.NodeService;
import com.mycompany.grafos.service.RelationService;

/**
 *
 * @author migue
 */
public class RelationBuilder {
    private RelationService relation;

    public RelationBuilder() {
        this.relation = new RelationImplementation();
    }
    
    public RelationBuilder lastNode(NodeService node){
        relation.setLastNode(node);
        
        return this;
    }
    
    public RelationBuilder nextNode(NodeService node){
        relation.setNextNode(node);
        
        return this;
    }
    
    public RelationBuilder weight(int weight){
        relation.setWeight(weight);
        
        return this;
    }
    
    public Relation build(){
        
        if (relation.getLastNode() == null || relation.getNextNode() == null) {
            throw new BuildingLogicPrinterError();
        }
        
        return new Relation(relation);
    }
}
