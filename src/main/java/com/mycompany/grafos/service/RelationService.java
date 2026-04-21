/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.mycompany.grafos.service;

import com.mycompany.logicPrinter.model.service.simpleService.LineService;

/**
 *
 * @author migue
 */
public interface RelationService extends LineService {
    
    void setLastNode(NodeService node);
    void setNextNode(NodeService node);
    void setWeight(int weight);
    
    NodeService getLastNode();
    NodeService getNextNode();
    int getWeight();
    
}
