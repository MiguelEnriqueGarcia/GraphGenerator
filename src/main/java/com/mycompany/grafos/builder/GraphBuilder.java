/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.grafos.builder;

import com.mycompany.grafos.component.Graph;
import com.mycompany.grafos.impl.GraphCompImplementation;
import com.mycompany.grafos.service.NodeService;
import com.mycompany.logicPrinter.part.Position;
import java.util.LinkedList;
import java.util.List;

/**
 *
 * @author migue
 */
public class GraphBuilder {
    private List<NodeService> nodes = new LinkedList<>();
    private Position mousePosition = new Position(0, 0);

    public GraphBuilder() {
    }
    
    public GraphBuilder mousePosition(Position mousePosition){
        this.mousePosition = mousePosition;
        return this;
    }
    
    public GraphBuilder nodes(List<NodeService> nodes){
        this.nodes = nodes;
        return this;
    }
    
    public GraphBuilder node(NodeService node){
        nodes.add(node);
        return this;
    }
    
    public Graph build(){
        Graph graph = new Graph(new GraphCompImplementation(nodes));
        graph.setMousePosition(mousePosition);
        return graph;
    }
}
