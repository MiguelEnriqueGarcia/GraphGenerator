/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.grafos.builder;

import com.mycompany.grafos.graphcomponents.Node;
import com.mycompany.grafos.parts.Position;
import com.mycompany.grafos.service.compoundService.NodeService;
import com.mycompany.grafos.service.compoundService.RelationService;
import java.awt.Color;
import java.util.LinkedList;
import java.util.List;

/**
 *
 * @author migue
 */
public class NodeBuilder {
    private NodeService node;
    private List<RelationService> relations;

    public NodeBuilder() {
        node = new Node();
        relations = new LinkedList<>();
    }
    
    public NodeBuilder color(Color color){
        node.setColor(color);
        
        return this;
    }
    
    public NodeBuilder position(Position position){
        node.setPosition(position);
        
        return this;
    }
    
    public NodeBuilder text(String text){
        node.setText(text);
        
        return this;
    }
    
    public NodeBuilder grade(int grade){
        node.setGrade(grade);
        
        return this;
    }
    
    public NodeBuilder radius(int radius){
        node.setRadius(radius);
        
        return this;
    }
    
    public NodeBuilder setRelations(List<RelationService> relations){
        this.relations = relations;
        
        return this;
    }
    public NodeBuilder addRelation(RelationService relation){
        this.relations.add(relation);
        
        return this;
    }
    public NodeBuilder addRelations(List<RelationService> relations){
        relations.forEach(relation -> {
            this.relations.add(relation);
        });
        
        return this;
    }
    public NodeService build(){
        node.setRelations(relations);
        
        return node;
    }
    
}
