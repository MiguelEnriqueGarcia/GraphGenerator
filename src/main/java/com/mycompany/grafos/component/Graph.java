/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.grafos.component;

import com.mycompany.grafos.service.GraphCompService;
import lombok.experimental.Delegate;

/**
 *
 * @author migue
 */
public class Graph implements GraphCompService{
    @Delegate
    private GraphCompService graph;

    public Graph(GraphCompService graph) {
        this.graph = graph;
    }
}
