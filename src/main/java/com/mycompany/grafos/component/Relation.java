/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.grafos.component;

import com.mycompany.grafos.service.RelationService;
import lombok.experimental.Delegate;

/**
 *
 * @author migue
 */
public class Relation implements RelationService{
    @Delegate
    private RelationService relation;

    public Relation(RelationService relation) {
        this.relation = relation;
    }
}
