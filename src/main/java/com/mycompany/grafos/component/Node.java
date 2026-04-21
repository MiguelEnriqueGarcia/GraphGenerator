/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.grafos.component;

import com.mycompany.grafos.service.NodeService;
import lombok.experimental.Delegate;

/**
 *
 * @author migue
 */
public class Node implements NodeService{
    @Delegate
    private NodeService service;

    public Node(NodeService service) {
        this.service = service;
    }
}
