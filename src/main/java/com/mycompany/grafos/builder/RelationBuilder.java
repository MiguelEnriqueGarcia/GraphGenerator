/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.grafos.builder;

import com.mycompany.grafos.exception.BuildingError;
import com.mycompany.grafos.graphcomponents.Relation;
import com.mycompany.grafos.service.compoundService.NodeService;
import com.mycompany.grafos.service.compoundService.RelationService;

/**
 *
 * @author migue
 */
public class RelationBuilder {
    private RelationService relation;

    public RelationBuilder() {
        this.relation = new Relation();
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
    
    public RelationService build(){
        
        if (relation.getLastNode() == null || relation.getNextNode() == null) {
            throw new BuildingError();
        }
        
        return relation;
    }
}
